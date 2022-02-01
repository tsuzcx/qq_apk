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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements com.tencent.mm.ak.f
{
  private boolean glB = true;
  private Dialog qka;
  private GameNewTopBannerView uxG;
  private GameIndexSearchView uxH;
  private GameIndexWxagView uxI;
  private GameMessageBubbleView uxJ;
  private GameBlockView uxK;
  private GameRecomBlockView uxL;
  private GameNewClassifyView uxM;
  private GameIndexListView uxN;
  
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
    this.uxN = ((GameIndexListView)findViewById(2131300442));
    this.uxN.setVisibility(8);
    View localView = getLayoutInflater().inflate(2131494322, this.uxN, false);
    this.uxN.addHeaderView(localView);
    this.uxG = ((GameNewTopBannerView)localView.findViewById(2131300556));
    this.uxH = ((GameIndexSearchView)localView.findViewById(2131300467));
    this.uxI = ((GameIndexWxagView)localView.findViewById(2131300468));
    this.uxJ = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.uxK = ((GameBlockView)localView.findViewById(2131300353));
    this.uxL = ((GameRecomBlockView)localView.findViewById(2131300542));
    this.uxM = ((GameNewClassifyView)localView.findViewById(2131300525));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.uoy);
    g.ajj().a(2994, this);
    initView();
    c.caq().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().amj("pb_index_4");
        if (localObject == null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41958);
              if (GameCenterUI5.this.isFinishing())
              {
                AppMethodBeat.o(41958);
                return;
              }
              GameCenterUI5.a(GameCenterUI5.this, c.fF(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().init(GameCenterUI5.this);
          c.aC(com.tencent.mm.plugin.game.model.e.dbk());
          localObject = new an(ad.fom(), com.tencent.mm.plugin.game.model.e.dbk(), GameCenterUI5.this.uxs, GameCenterUI5.this.uxt, GameCenterUI5.this.uxu, GameCenterUI5.this.uxr);
          g.ajj().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.fs(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.dbp();
          a.a.dde().ddc();
          AppMethodBeat.o(41960);
          return;
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.uxQ, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    ae.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.uoy) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    ae.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.dde().clearCache();
    g.ajj().b(2994, this);
    ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().clearCache();
    aw.dcr();
    aw.dct();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.glB)
    {
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().init(this);
      Object localObject = this.uxJ;
      ((GameMessageBubbleView)localObject).uCT.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.uxr) {
        this.uxJ.dcQ();
      }
      localObject = this.uxK;
      if (((GameBlockView)localObject).uwX != null) {
        ((GameBlockView)localObject).uwX.uxc.refresh();
      }
      localObject = this.uxN;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.km();
      int j = localLinearLayoutManager.ko();
      ((GameIndexListView)localObject).uAX.ap(i, j - i + 1);
    }
    this.glB = false;
    AppMethodBeat.o(41962);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41965);
    ae.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
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
        paramString = ((an)paramn).gux.hQE.hQJ;
        c.caq().postToWorker(new Runnable()
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
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(41956);
                  try
                  {
                    GameCenterUI5.a(GameCenterUI5.this, this.uxQ, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    ae.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.coO) });
                    AppMethodBeat.o(41956);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ae.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[] { localException.getMessage() });
                      GameCenterUI5.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(41957);
              return;
              localbo = (bo)paramString;
              ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().b("pb_index_4", localbo);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.iUA.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.qka != null) {
      this.qka.cancel();
    }
    AppMethodBeat.o(41965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */