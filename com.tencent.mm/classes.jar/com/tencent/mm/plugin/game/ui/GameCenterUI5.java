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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements com.tencent.mm.al.f
{
  private boolean gjj = true;
  private Dialog qdv;
  private GameNewTopBannerView umj;
  private GameIndexSearchView umk;
  private GameIndexWxagView uml;
  private GameMessageBubbleView umm;
  private GameBlockView umn;
  private GameRecomBlockView umo;
  private GameNewClassifyView ump;
  private GameIndexListView umq;
  
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
    this.umq = ((GameIndexListView)findViewById(2131300442));
    this.umq.setVisibility(8);
    View localView = getLayoutInflater().inflate(2131494322, this.umq, false);
    this.umq.addHeaderView(localView);
    this.umj = ((GameNewTopBannerView)localView.findViewById(2131300556));
    this.umk = ((GameIndexSearchView)localView.findViewById(2131300467));
    this.uml = ((GameIndexWxagView)localView.findViewById(2131300468));
    this.umm = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.umn = ((GameBlockView)localView.findViewById(2131300353));
    this.umo = ((GameRecomBlockView)localView.findViewById(2131300542));
    this.ump = ((GameNewClassifyView)localView.findViewById(2131300525));
    AppMethodBeat.o(41964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41961);
    super.onCreate(paramBundle);
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(41961);
      return;
    }
    GameIndexListView.setSourceScene(this.udq);
    g.aiU().a(2994, this);
    initView();
    c.bZb().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41960);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().all("pb_index_4");
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
              GameCenterUI5.a(GameCenterUI5.this, c.fA(GameCenterUI5.this));
              GameCenterUI5.a(GameCenterUI5.this).show();
              AppMethodBeat.o(41958);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cWF().init(GameCenterUI5.this);
          c.aC(com.tencent.mm.plugin.game.model.e.cYA());
          localObject = new an(com.tencent.mm.sdk.platformtools.ac.fks(), com.tencent.mm.plugin.game.model.e.cYA(), GameCenterUI5.this.ulV, GameCenterUI5.this.ulW, GameCenterUI5.this.ulX, GameCenterUI5.this.ulU);
          g.aiU().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.fo(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.cYF();
          a.a.das().daq();
          AppMethodBeat.o(41960);
          return;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41959);
              GameCenterUI5.a(GameCenterUI5.this, this.umt, 1);
              AppMethodBeat.o(41959);
            }
          });
        }
      }
    });
    ad.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.udq) });
    AppMethodBeat.o(41961);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41963);
    ad.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41963);
      return;
    }
    a.a.das().clearCache();
    g.aiU().b(2994, this);
    ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cWF().clearCache();
    aw.cZG();
    aw.cZI();
    AppMethodBeat.o(41963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41962);
    super.onResume();
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(41962);
      return;
    }
    if (!this.gjj)
    {
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cWF().init(this);
      Object localObject = this.umm;
      ((GameMessageBubbleView)localObject).urA.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.ulU) {
        this.umm.daf();
      }
      localObject = this.umn;
      if (((GameBlockView)localObject).ulA != null) {
        ((GameBlockView)localObject).ulA.ulF.refresh();
      }
      localObject = this.umq;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.km();
      int j = localLinearLayoutManager.ko();
      ((GameIndexListView)localObject).upB.ap(i, j - i + 1);
    }
    this.gjj = false;
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
        paramString = ((an)paramn).grW.hNL.hNQ;
        c.bZb().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41957);
            bh localbh;
            if (paramString == null) {
              localbh = new bh();
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
                    GameCenterUI5.a(GameCenterUI5.this, this.umt, 2);
                    if (GameCenterUI5.a(GameCenterUI5.this) != null) {
                      GameCenterUI5.a(GameCenterUI5.this).dismiss();
                    }
                    ad.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameCenterUI5.2.this.coM) });
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
              localbh = (bh)paramString;
              ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().b("pb_index_4", localbh);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.iRH.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.qdv != null) {
      this.qdv.cancel();
    }
    AppMethodBeat.o(41965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */