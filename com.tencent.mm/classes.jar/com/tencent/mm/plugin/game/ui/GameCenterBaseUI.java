package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  protected int kQh = 0;
  protected boolean kYc = false;
  protected o kYd;
  protected o kYe;
  protected o kYf;
  protected boolean kYg = false;
  private boolean kYh = true;
  
  public final int aZY()
  {
    return 10;
  }
  
  public final int aZZ()
  {
    return 1000;
  }
  
  public final int baa()
  {
    return this.kQh;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.DK())
    {
      y.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.kQh = getIntent().getIntExtra("game_report_from_scene", 0);
    this.kYc = getIntent().getBooleanExtra("from_find_more_friend", false);
    c.DS().O(new GameCenterBaseUI.1(this));
    b.a(this, 10, 1000, 0, 1, 0, null, this.kQh, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.DK())
    {
      y.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.kYh) && (a.a.bau().lgc))
    {
      a.a.bau().lgc = false;
      y.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
      Intent localIntent = new Intent();
      localIntent.putExtra("game_report_from_scene", 901);
      localIntent.putExtra("switch_country_no_anim", true);
      d.b(this, "game", ".ui.GameCenterUI", localIntent);
    }
    this.kYh = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */