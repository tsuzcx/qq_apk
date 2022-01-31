package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class GameDetailRankLikedUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg" + GameDetailRankLikedUI.class.getSimpleName();
  private Dialog hhG;
  private ListView kZh;
  private GameDetailRankLikedUI.a kZi;
  
  protected final int getLayoutId()
  {
    return g.f.game_detail2_rank_liked;
  }
  
  protected final void initView()
  {
    setMMTitle(g.i.game_detail_rank_liked);
    setBackBtn(new GameDetailRankLikedUI.1(this));
    this.kZh = ((ListView)findViewById(g.e.game_detail_rank_liked_list));
    this.kZi = new GameDetailRankLikedUI.a(this);
    this.kZh.setAdapter(this.kZi);
    this.hhG = c.dA(this.mController.uMN);
    this.hhG.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("extra_appdi");
    if (bk.bl(paramBundle))
    {
      finish();
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bo();
    ((b.a)localObject).ecI = new bp();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getuplist";
    ((b.a)localObject).ecG = 1331;
    localObject = ((b.a)localObject).Kt();
    ((bo)((b)localObject).ecE.ecN).kRX = paramBundle;
    w.a((b)localObject, new GameDetailRankLikedUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI
 * JD-Core Version:    0.7.0.1
 */