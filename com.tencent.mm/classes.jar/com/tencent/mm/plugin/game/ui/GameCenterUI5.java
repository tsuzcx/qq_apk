package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements f
{
  private boolean evP = true;
  private Dialog lFU;
  private GameNewTopBannerView nwr;
  private GameIndexSearchView nws;
  private GameIndexWxagView nwt;
  private GameMessageBubbleView nwu;
  private GameBlockView nwv;
  private GameRecomBlockView nww;
  private GameNewClassifyView nwx;
  private GameIndexListView nwy;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969703;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111796);
    setBackBtn(new GameCenterUI5.1(this));
    setMMTitle(2131300478);
    this.nwy = ((GameIndexListView)findViewById(2131824457));
    this.nwy.setVisibility(8);
    View localView = getLayoutInflater().inflate(2130969765, this.nwy, false);
    this.nwy.addHeaderView(localView);
    this.nwr = ((GameNewTopBannerView)localView.findViewById(2131824662));
    this.nws = ((GameIndexSearchView)localView.findViewById(2131824664));
    this.nwt = ((GameIndexWxagView)localView.findViewById(2131824665));
    this.nwu = ((GameMessageBubbleView)localView.findViewById(2131824462));
    this.nwv = ((GameBlockView)localView.findViewById(2131824666));
    this.nww = ((GameRecomBlockView)localView.findViewById(2131824667));
    this.nwx = ((GameNewClassifyView)localView.findViewById(2131824668));
    AppMethodBeat.o(111796);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111793);
    super.onCreate(paramBundle);
    if (!g.RG())
    {
      ab.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      AppMethodBeat.o(111793);
      return;
    }
    GameIndexListView.setSourceScene(this.nok);
    g.Rc().a(2994, this);
    initView();
    c.aNS().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111792);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bET().PN("pb_index_4");
        if (localObject == null) {
          al.d(new GameCenterUI5.3.1(this));
        }
        for (;;)
        {
          ((d)g.E(d.class)).bEP().init(GameCenterUI5.this);
          c.ae(com.tencent.mm.plugin.game.model.e.bFS());
          localObject = new an(aa.dsG(), com.tencent.mm.plugin.game.model.e.bFS(), GameCenterUI5.this.nwb, GameCenterUI5.this.nwc, GameCenterUI5.this.nwd, GameCenterUI5.this.nwa);
          g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
          com.tencent.mm.plugin.game.model.e.ec(GameCenterUI5.this.getContext());
          com.tencent.mm.plugin.game.model.e.bFX();
          a.a.bHB().bHz();
          AppMethodBeat.o(111792);
          return;
          al.d(new GameCenterUI5.3.2(this, new ac((byte[])localObject)));
        }
      }
    });
    ab.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.nok) });
    AppMethodBeat.o(111793);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111795);
    ab.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!g.RG())
    {
      ab.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(111795);
      return;
    }
    a.a.bHB().clearCache();
    g.Rc().b(2994, this);
    ((d)g.E(d.class)).bEP().clearCache();
    ax.bGV();
    ax.bGX();
    AppMethodBeat.o(111795);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111794);
    super.onResume();
    if (!g.RG())
    {
      ab.e("MicroMsg.GameCenterUI5", "account not ready");
      AppMethodBeat.o(111794);
      return;
    }
    if (!this.evP)
    {
      ((d)g.E(d.class)).bEP().init(this);
      Object localObject = this.nwu;
      ((GameMessageBubbleView)localObject).nBJ.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.nwa) {
        this.nwu.bHu();
      }
      localObject = this.nwv;
      if (((GameBlockView)localObject).nvF != null) {
        ((GameBlockView)localObject).nvF.nvK.refresh();
      }
      localObject = this.nwy;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.it();
      int j = localLinearLayoutManager.iv();
      ((GameIndexListView)localObject).nzL.an(i, j - i + 1);
    }
    this.evP = false;
    AppMethodBeat.o(111794);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(111797);
    ab.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(111797);
        return;
        long l = System.currentTimeMillis();
        paramString = ((an)paramm).lFp.fsW.fta;
        c.aNS().ac(new GameCenterUI5.2(this, paramString, l));
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131300407, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.lFU != null) {
      this.lFU.cancel();
    }
    AppMethodBeat.o(111797);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */