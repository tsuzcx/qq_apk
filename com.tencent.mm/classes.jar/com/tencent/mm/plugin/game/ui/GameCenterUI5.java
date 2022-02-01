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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements com.tencent.mm.ak.g
{
  private boolean fPJ = true;
  private Dialog pzQ;
  private GameNewTopBannerView tnL;
  private GameIndexSearchView tnM;
  private GameIndexWxagView tnN;
  private GameMessageBubbleView tnO;
  private GameBlockView tnP;
  private GameRecomBlockView tnQ;
  private GameNewClassifyView tnR;
  private GameIndexListView tnS;
  
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
    this.tnS = ((GameIndexListView)findViewById(2131300442));
    this.tnS.setVisibility(8);
    View localView = getLayoutInflater().inflate(2131494322, this.tnS, false);
    this.tnS.addHeaderView(localView);
    this.tnL = ((GameNewTopBannerView)localView.findViewById(2131300556));
    this.tnM = ((GameIndexSearchView)localView.findViewById(2131300467));
    this.tnN = ((GameIndexWxagView)localView.findViewById(2131300468));
    this.tnO = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.tnP = ((GameBlockView)localView.findViewById(2131300353));
    this.tnQ = ((GameRecomBlockView)localView.findViewById(2131300542));
    this.tnR = ((GameNewClassifyView)localView.findViewById(2131300525));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.tfA);
    com.tencent.mm.kernel.g.agi().a(2994, this);
    initView();
    c.bUw().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().agO("pb_index_4");
        if (localObject == null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41958);
              if (GameCenterUI5.this.isFinishing())
              {
                AppMethodBeat.o(41958);
                return;
              }
              GameCenterUI5.a(GameCenterUI5.this, c.fv(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().init(GameCenterUI5.this);
          c.aA(com.tencent.mm.plugin.game.model.e.cPV());
          localObject = new an(ab.eUO(), com.tencent.mm.plugin.game.model.e.cPV(), GameCenterUI5.this.tnx, GameCenterUI5.this.tny, GameCenterUI5.this.tnz, GameCenterUI5.this.tnw);
          com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.fk(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.cQa();
          a.a.cRI().cRG();
          AppMethodBeat.o(41960);
          return;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.tnV, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.tfA) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.cRI().clearCache();
    com.tencent.mm.kernel.g.agi().b(2994, this);
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().clearCache();
    aw.cRa();
    aw.cRc();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.fPJ)
    {
      ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().init(this);
      Object localObject = this.tnO;
      ((GameMessageBubbleView)localObject).ttb.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.tnw) {
        this.tnO.cRA();
      }
      localObject = this.tnP;
      if (((GameBlockView)localObject).tnc != null) {
        ((GameBlockView)localObject).tnc.tnh.refresh();
      }
      localObject = this.tnS;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.jW();
      int j = localLinearLayoutManager.jY();
      ((GameIndexListView)localObject).tre.ao(i, j - i + 1);
    }
    this.fPJ = false;
    AppMethodBeat.o(41962);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41965);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
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
        paramString = ((an)paramn).fYA.hvs.hvw;
        c.bUw().postToWorker(new Runnable()
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
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(41956);
                  try
                  {
                    GameCenterUI5.a(GameCenterUI5.this, this.tnV, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.cev) });
                    AppMethodBeat.o(41956);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[] { localException.getMessage() });
                      GameCenterUI5.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(41957);
              return;
              localbe = (be)paramString;
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().b("pb_index_4", localbe);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.iyy.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.pzQ != null) {
      this.pzQ.cancel();
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