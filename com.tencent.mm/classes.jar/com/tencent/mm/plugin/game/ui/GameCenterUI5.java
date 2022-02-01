package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.bp;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements i
{
  private GameNewTopBannerView CTP;
  private GameIndexSearchView CTQ;
  private GameIndexWxagView CTR;
  private GameMessageBubbleView CTS;
  private GameBlockView CTT;
  private GameRecomBlockView CTU;
  private GameNewClassifyView CTV;
  private GameIndexListView CTW;
  private boolean jHo = true;
  private Dialog vgC;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return g.f.Cmz;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41964);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(41955);
        GameCenterUI5.this.finish();
        AppMethodBeat.o(41955);
        return true;
      }
    });
    setMMTitle(g.i.Cqg);
    this.CTW = ((GameIndexListView)findViewById(g.e.Cji));
    this.CTW.setVisibility(8);
    View localView = getLayoutInflater().inflate(g.f.Cnw, this.CTW, false);
    this.CTW.dI(localView);
    this.CTP = ((GameNewTopBannerView)localView.findViewById(g.e.Ckx));
    this.CTQ = ((GameIndexSearchView)localView.findViewById(g.e.Cju));
    this.CTR = ((GameIndexWxagView)localView.findViewById(g.e.Cjv));
    this.CTS = ((GameMessageBubbleView)localView.findViewById(g.e.CjY));
    this.CTT = ((GameBlockView)localView.findViewById(g.e.ChT));
    this.CTU = ((GameRecomBlockView)localView.findViewById(g.e.Ckj));
    this.CTV = ((GameNewClassifyView)localView.findViewById(g.e.Ckf));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!h.aHB())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.CKU);
    h.aGY().a(2994, this);
    initView();
    c.cMC().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((f)h.ae(f.class)).evp().aIX("pb_index_4");
        if (localObject == null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41958);
              if (GameCenterUI5.this.isFinishing())
              {
                AppMethodBeat.o(41958);
                return;
              }
              GameCenterUI5.a(GameCenterUI5.this, c.gF(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)h.ae(com.tencent.mm.plugin.game.api.e.class)).evm().init(GameCenterUI5.this);
          c.bq(com.tencent.mm.plugin.game.model.e.exY());
          localObject = new an(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.exY(), GameCenterUI5.this.CTB, GameCenterUI5.this.CTC, GameCenterUI5.this.CTD, GameCenterUI5.this.CTA);
          h.aGY().a((q)localObject, 0);
          com.tencent.mm.plugin.game.model.e.gs(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.eyd();
          a.a.ezW().ezU();
          AppMethodBeat.o(41960);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.CTZ, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    Log.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.CKU) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    Log.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!h.aHB())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.ezW().clearCache();
    h.aGY().b(2994, this);
    ((com.tencent.mm.plugin.game.api.e)h.ae(com.tencent.mm.plugin.game.api.e.class)).evm().clearCache();
    ax.ezg();
    ax.ezi();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!h.aHB())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.jHo)
    {
      ((com.tencent.mm.plugin.game.api.e)h.ae(com.tencent.mm.plugin.game.api.e.class)).evm().init(this);
      Object localObject = this.CTS;
      ((GameMessageBubbleView)localObject).CZc.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.CTA) {
        this.CTS.ezD();
      }
      localObject = this.CTT;
      if (((GameBlockView)localObject).CTg != null) {
        ((GameBlockView)localObject).CTg.CTl.bfU();
      }
      localObject = this.CTW;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.kJ();
      int j = localLinearLayoutManager.kL();
      ((GameIndexListView)localObject).CXg.aE(i, j - i + 1);
    }
    this.jHo = false;
    AppMethodBeat.o(41962);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(41965);
    Log.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramq.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(41965);
        return;
        final long l = System.currentTimeMillis();
        paramString = d.c.b(((an)paramq).jTk.lBS);
        c.cMC().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41957);
            bp localbp;
            if (paramString == null) {
              localbp = new bp();
            }
            for (;;)
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(41956);
                  try
                  {
                    GameCenterUI5.a(GameCenterUI5.this, this.CTZ, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    Log.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.cAj) });
                    AppMethodBeat.o(41956);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[] { localException.getMessage() });
                      GameCenterUI5.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(41957);
              return;
              localbp = (bp)paramString;
              ((f)h.ae(f.class)).evp().b("pb_index_4", localbp);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.mIH.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(g.i.Cpf, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.vgC != null) {
      this.vgC.cancel();
    }
    AppMethodBeat.o(41965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */