package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  protected int nok = 0;
  protected boolean nwa = false;
  protected n nwb;
  protected n nwc;
  protected n nwd;
  protected boolean nwe = false;
  private boolean nwf = true;
  
  public final int bHg()
  {
    return 1000;
  }
  
  public final int bHh()
  {
    return this.nok;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.RG())
    {
      ab.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.nok = getIntent().getIntExtra("game_report_from_scene", 0);
    this.nwa = getIntent().getBooleanExtra("from_find_more_friend", false);
    com.tencent.mm.plugin.game.f.c.aNS().ac(new GameCenterBaseUI.1(this));
    com.tencent.mm.game.report.c.a(this, 10, 1000, 0, 1, 0, null, this.nok, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.RG())
    {
      ab.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.nwf) && (a.a.bHB().nDX))
    {
      a.a.bHB().nDX = false;
      ab.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
      Intent localIntent = new Intent();
      localIntent.putExtra("game_report_from_scene", 901);
      localIntent.putExtra("switch_country_no_anim", true);
      d.b(this, "game", ".ui.GameCenterUI", localIntent);
    }
    this.nwf = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */