package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements com.tencent.mm.am.h
{
  private GameNewTopBannerView IOg;
  private GameIndexSearchView IOh;
  private GameIndexWxagView IOi;
  private GameMessageBubbleView IOj;
  private GameBlockView IOk;
  private GameRecomBlockView IOl;
  private GameNewClassifyView IOm;
  private GameIndexListView IOn;
  private boolean mgS = true;
  private Dialog ysC;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.HYH;
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
    setMMTitle(h.i.Icp);
    this.IOn = ((GameIndexListView)findViewById(h.e.HVq));
    this.IOn.setVisibility(8);
    View localView = getLayoutInflater().inflate(h.f.HZE, this.IOn, false);
    this.IOn.ev(localView);
    this.IOg = ((GameNewTopBannerView)localView.findViewById(h.e.HWF));
    this.IOh = ((GameIndexSearchView)localView.findViewById(h.e.HVC));
    this.IOi = ((GameIndexWxagView)localView.findViewById(h.e.HVD));
    this.IOj = ((GameMessageBubbleView)localView.findViewById(h.e.HWg));
    this.IOk = ((GameBlockView)localView.findViewById(h.e.HUb));
    this.IOl = ((GameRecomBlockView)localView.findViewById(h.e.HWr));
    this.IOm = ((GameNewClassifyView)localView.findViewById(h.e.HWn));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.IFc);
    com.tencent.mm.kernel.h.aZW().a(2994, this);
    initView();
    com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().aFI("pb_index_4");
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
              GameCenterUI5.a(GameCenterUI5.this, com.tencent.mm.plugin.game.d.c.hY(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCf().init(GameCenterUI5.this);
          com.tencent.mm.plugin.game.d.c.bx(com.tencent.mm.plugin.game.model.e.fFU());
          localObject = new an(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.fFU(), GameCenterUI5.this.INR, GameCenterUI5.this.INS, GameCenterUI5.this.INU, GameCenterUI5.this.INQ);
          com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
          com.tencent.mm.plugin.game.model.e.hL(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.fFZ();
          a.a.fHX().fHV();
          AppMethodBeat.o(41960);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.IOq, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    Log.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.IFc) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    Log.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.fHX().clearCache();
    com.tencent.mm.kernel.h.aZW().b(2994, this);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCf().clearCache();
    aw.fHc();
    aw.fHe();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.mgS)
    {
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCf().init(this);
      Object localObject = this.IOj;
      ((GameMessageBubbleView)localObject).ITs.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.INQ) {
        this.IOj.fHB();
      }
      localObject = this.IOk;
      if (((GameBlockView)localObject).INw != null) {
        ((GameBlockView)localObject).INw.INB.bDL();
      }
      localObject = this.IOn;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.Ju();
      int j = localLinearLayoutManager.Jw();
      ((GameIndexListView)localObject).IRx.by(i, j - i + 1);
    }
    this.mgS = false;
    AppMethodBeat.o(41962);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(41965);
    Log.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(41965);
        return;
        final long l = System.currentTimeMillis();
        paramString = c.c.b(((an)paramp).mtC.otC);
        com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41957);
            bq localbq;
            if (paramString == null) {
              localbq = new bq();
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
                    GameCenterUI5.a(GameCenterUI5.this, this.IOq, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    Log.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.esF) });
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
              localbq = (bq)paramString;
              ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().b("pb_index_4", localbq);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(h.i.Ibn, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.ysC != null) {
      this.ysC.cancel();
    }
    AppMethodBeat.o(41965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */