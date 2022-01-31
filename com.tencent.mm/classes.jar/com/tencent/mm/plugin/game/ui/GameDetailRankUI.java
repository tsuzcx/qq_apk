package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class GameDetailRankUI
  extends MMActivity
{
  public static String EXTRA_SESSION_ID = "extra_session_id";
  public static String kZp = "gameDetailRankDataKey";
  private String appId;
  private ListView kZm;
  private GameRankHeadView kZn;
  private i kZo;
  
  protected final int getLayoutId()
  {
    return g.f.game_detail2_rank;
  }
  
  protected final void initView()
  {
    setMMTitle(com.tencent.mm.pluginsdk.model.app.g.n(this.mController.uMN, this.appId));
    setBackBtn(new GameDetailRankUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra(EXTRA_SESSION_ID);
    paramBundle = u.Hc().ii(paramBundle);
    if (paramBundle == null)
    {
      finish();
      return;
    }
    paramBundle = (GameDetailRankUI.a)paramBundle.get(kZp);
    this.kZm = ((ListView)findViewById(g.e.game_detail_rank_list));
    if ((!bk.bl(paramBundle.kZr)) && (!bk.bl(paramBundle.kZs)))
    {
      View localView = ((LayoutInflater)this.mController.uMN.getSystemService("layout_inflater")).inflate(g.f.game_detail_rank_head, this.kZm, false);
      this.kZn = ((GameRankHeadView)localView.findViewById(g.e.game_rank_head));
      this.kZm.addHeaderView(localView);
      this.kZn.setData(paramBundle);
    }
    this.kZo = new i(this);
    this.kZo.Ls = g.f.game_detail2_rank_item_big;
    this.kZm.setAdapter(this.kZo);
    this.appId = paramBundle.kZt.field_appId;
    if (bk.bl(this.appId))
    {
      finish();
      return;
    }
    initView();
    com.tencent.mm.kernel.g.DS().O(new GameDetailRankUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    k.b(this.kZn.kZy);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankUI
 * JD-Core Version:    0.7.0.1
 */