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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements com.tencent.mm.al.g
{
  private boolean fLX = true;
  private Dialog oWF;
  private GameNewTopBannerView sfS;
  private GameIndexSearchView sfT;
  private GameIndexWxagView sfU;
  private GameMessageBubbleView sfV;
  private GameBlockView sfW;
  private GameRecomBlockView sfX;
  private GameNewClassifyView sfY;
  private GameIndexListView sfZ;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494255;
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
    setMMTitle(2131760012);
    this.sfZ = ((GameIndexListView)findViewById(2131300442));
    this.sfZ.setVisibility(8);
    View localView = getLayoutInflater().inflate(2131494322, this.sfZ, false);
    this.sfZ.addHeaderView(localView);
    this.sfS = ((GameNewTopBannerView)localView.findViewById(2131300556));
    this.sfT = ((GameIndexSearchView)localView.findViewById(2131300467));
    this.sfU = ((GameIndexWxagView)localView.findViewById(2131300468));
    this.sfV = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.sfW = ((GameBlockView)localView.findViewById(2131300353));
    this.sfX = ((GameRecomBlockView)localView.findViewById(2131300542));
    this.sfY = ((GameNewClassifyView)localView.findViewById(2131300525));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.rXI);
    com.tencent.mm.kernel.g.aeS().a(2994, this);
    initView();
    c.bNl().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().abW("pb_index_4");
        if (localObject == null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41958);
              if (GameCenterUI5.this.isFinishing())
              {
                AppMethodBeat.o(41958);
                return;
              }
              GameCenterUI5.a(GameCenterUI5.this, c.fi(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().init(GameCenterUI5.this);
          c.at(com.tencent.mm.plugin.game.model.e.cCL());
          localObject = new an(com.tencent.mm.sdk.platformtools.ac.eFu(), com.tencent.mm.plugin.game.model.e.cCL(), GameCenterUI5.this.sfE, GameCenterUI5.this.sfF, GameCenterUI5.this.sfG, GameCenterUI5.this.sfD);
          com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.eX(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.cCQ();
          a.a.cEy().cEw();
          AppMethodBeat.o(41960);
          return;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.sgc, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    ad.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.rXI) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    ad.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.cEy().clearCache();
    com.tencent.mm.kernel.g.aeS().b(2994, this);
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().clearCache();
    aw.cDQ();
    aw.cDS();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.fLX)
    {
      ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().init(this);
      Object localObject = this.sfV;
      ((GameMessageBubbleView)localObject).sli.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.sfD) {
        this.sfV.cEq();
      }
      localObject = this.sfW;
      if (((GameBlockView)localObject).sfj != null) {
        ((GameBlockView)localObject).sfj.sfo.refresh();
      }
      localObject = this.sfZ;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.jO();
      int j = localLinearLayoutManager.jQ();
      ((GameIndexListView)localObject).sjl.ao(i, j - i + 1);
    }
    this.fLX = false;
    AppMethodBeat.o(41962);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41965);
    ad.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(41965);
        return;
        final long l = System.currentTimeMillis();
        paramString = ((an)paramn).fUF.gUT.gUX;
        c.bNl().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41957);
            be localbe;
            if (paramString == null) {
              localbe = new be();
            }
            for (;;)
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(41956);
                  try
                  {
                    GameCenterUI5.a(GameCenterUI5.this, this.sgc, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    ad.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.chA) });
                    AppMethodBeat.o(41956);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[] { localException.getMessage() });
                      GameCenterUI5.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(41957);
              return;
              localbe = (be)paramString;
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().b("pb_index_4", localbe);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.oWF != null) {
      this.oWF.cancel();
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