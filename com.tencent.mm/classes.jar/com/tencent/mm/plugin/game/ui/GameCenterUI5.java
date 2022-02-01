package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.a.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements i
{
  private boolean gWt = true;
  private Dialog rAV;
  private GameNewTopBannerView xPG;
  private GameIndexSearchView xPH;
  private GameIndexWxagView xPI;
  private GameMessageBubbleView xPJ;
  private GameBlockView xPK;
  private GameRecomBlockView xPL;
  private GameNewClassifyView xPM;
  private GameIndexListView xPN;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494816;
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
    setMMTitle(2131761376);
    this.xPN = ((GameIndexListView)findViewById(2131301965));
    this.xPN.setVisibility(8);
    View localView = getLayoutInflater().inflate(2131494886, this.xPN, false);
    this.xPN.addHeaderView(localView);
    this.xPG = ((GameNewTopBannerView)localView.findViewById(2131302088));
    this.xPH = ((GameIndexSearchView)localView.findViewById(2131301990));
    this.xPI = ((GameIndexWxagView)localView.findViewById(2131301991));
    this.xPJ = ((GameMessageBubbleView)localView.findViewById(2131302044));
    this.xPK = ((GameBlockView)localView.findViewById(2131301875));
    this.xPL = ((GameRecomBlockView)localView.findViewById(2131302074));
    this.xPM = ((GameNewClassifyView)localView.findViewById(2131302057));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.xGR);
    g.azz().a(2994, this);
    initView();
    c.cyh().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((f)g.af(f.class)).dSL().azn("pb_index_4");
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
              GameCenterUI5.a(GameCenterUI5.this, c.gl(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().init(GameCenterUI5.this);
          c.aX(com.tencent.mm.plugin.game.model.e.dUR());
          localObject = new an(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.dUR(), GameCenterUI5.this.xPs, GameCenterUI5.this.xPt, GameCenterUI5.this.xPu, GameCenterUI5.this.xPr);
          g.azz().a((q)localObject, 0);
          com.tencent.mm.plugin.game.model.e.fY(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.dUW();
          a.a.dWO().dWM();
          AppMethodBeat.o(41960);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.xPQ, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    Log.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.xGR) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    Log.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.dWO().clearCache();
    g.azz().b(2994, this);
    ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().clearCache();
    aw.dVY();
    aw.dWa();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.gWt)
    {
      ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().init(this);
      Object localObject = this.xPJ;
      ((GameMessageBubbleView)localObject).xUR.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.xPr) {
        this.xPJ.dWx();
      }
      localObject = this.xPK;
      if (((GameBlockView)localObject).xOX != null) {
        ((GameBlockView)localObject).xOX.xPc.refresh();
      }
      localObject = this.xPN;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.ks();
      int j = localLinearLayoutManager.ku();
      ((GameIndexListView)localObject).xSV.aq(i, j - i + 1);
    }
    this.gWt = false;
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
        paramString = ((an)paramq).hhm.iLL.iLR;
        c.cyh().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41957);
            bo localbo;
            if (paramString == null) {
              localbo = new bo();
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
                    GameCenterUI5.a(GameCenterUI5.this, this.xPQ, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    Log.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.cBb) });
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
              localbo = (bo)paramString;
              ((f)g.af(f.class)).dSL().b("pb_index_4", localbo);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131761264, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.rAV != null) {
      this.rAV.cancel();
    }
    AppMethodBeat.o(41965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */