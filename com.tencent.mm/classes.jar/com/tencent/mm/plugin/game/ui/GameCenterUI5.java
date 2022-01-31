package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class GameCenterUI5
  extends GameCenterBaseUI
  implements com.tencent.mm.ah.f
{
  private Dialog jwv;
  private GameIndexListView kYA;
  private boolean kYB = true;
  private GameNewTopBannerView kYt;
  private GameIndexSearchView kYu;
  private GameIndexWxagView kYv;
  private GameMessageBubbleView kYw;
  private GameBlockView kYx;
  private GameRecomBlockView kYy;
  private GameNewClassifyView kYz;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_center_4_index;
  }
  
  protected final void initView()
  {
    setBackBtn(new GameCenterUI5.1(this));
    setMMTitle(g.i.game_wechat_game);
    this.kYA = ((GameIndexListView)findViewById(g.e.game_fees_list));
    this.kYA.setVisibility(8);
    View localView = getLayoutInflater().inflate(g.f.game_index_header_view, this.kYA, false);
    this.kYA.addHeaderView(localView);
    this.kYt = ((GameNewTopBannerView)localView.findViewById(g.e.game_top_banner_view));
    this.kYu = ((GameIndexSearchView)localView.findViewById(g.e.game_index_search));
    this.kYv = ((GameIndexWxagView)localView.findViewById(g.e.game_index_wxag));
    this.kYw = ((GameMessageBubbleView)localView.findViewById(g.e.game_msg_bubble_view));
    this.kYx = ((GameBlockView)localView.findViewById(g.e.game_block_view));
    this.kYy = ((GameRecomBlockView)localView.findViewById(g.e.game_recom_block_view));
    this.kYz = ((GameNewClassifyView)localView.findViewById(g.e.game_new_classify_view));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.DK())
    {
      y.e("MicroMsg.GameCenterUI5", "account not ready");
      finish();
      return;
    }
    GameIndexListView.setSourceScene(this.kQh);
    g.Dk().a(2994, this);
    initView();
    com.tencent.mm.plugin.game.f.c.DS().O(new Runnable()
    {
      public final void run()
      {
        Object localObject = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().Ey("pb_index_4");
        if (localObject == null) {
          ai.d(new GameCenterUI5.3.1(this));
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYc().init(GameCenterUI5.this);
          com.tencent.mm.plugin.game.f.c.X(com.tencent.mm.plugin.game.model.f.aYT());
          localObject = new ao(com.tencent.mm.sdk.platformtools.x.cqJ(), com.tencent.mm.plugin.game.model.f.aYT(), GameCenterUI5.this.kYd, GameCenterUI5.this.kYe, GameCenterUI5.this.kYf, GameCenterUI5.this.kYc);
          g.Dk().a((m)localObject, 0);
          com.tencent.mm.plugin.game.model.f.dp(GameCenterUI5.this.mController.uMN);
          com.tencent.mm.plugin.game.model.f.aYY();
          a.a.bau().bas();
          return;
          ai.d(new GameCenterUI5.3.2(this, new ad((byte[])localObject)));
        }
      }
    });
    y.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[] { Integer.valueOf(this.kQh) });
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.GameCenterUI5", "onDestroy");
    super.onDestroy();
    if (!g.DK())
    {
      y.e("MicroMsg.GameCenterUI5", "account not ready");
      return;
    }
    a.a.bau().clearCache();
    g.Dk().b(2994, this);
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYc().clearCache();
    ay.aZP();
    ay.aZR();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.DK())
    {
      y.e("MicroMsg.GameCenterUI5", "account not ready");
      return;
    }
    if (!this.kYB)
    {
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYc().init(this);
      Object localObject = this.kYw;
      ((GameMessageBubbleView)localObject).ldO.setOnClickListener(null);
      ((GameMessageBubbleView)localObject).setVisibility(8);
      if (this.kYc) {
        this.kYw.bao();
      }
      localObject = this.kYx;
      if (((GameBlockView)localObject).kXD != null) {
        ((GameBlockView)localObject).kXD.kXI.refresh();
      }
      localObject = this.kYA;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((GameIndexListView)localObject).getLayoutManager();
      int i = localLinearLayoutManager.gY();
      int j = localLinearLayoutManager.ha();
      ((GameIndexListView)localObject).lbQ.ah(i, j - i + 1);
    }
    this.kYB = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    do
    {
      return;
      long l = System.currentTimeMillis();
      paramString = ((ao)paramm).jvQ.ecF.ecN;
      com.tencent.mm.plugin.game.f.c.DS().O(new GameCenterUI5.2(this, paramString, l));
      return;
      if (!com.tencent.mm.plugin.game.b.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(g.i.game_list_get_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
    } while (this.jwv == null);
    this.jwv.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5
 * JD-Core Version:    0.7.0.1
 */