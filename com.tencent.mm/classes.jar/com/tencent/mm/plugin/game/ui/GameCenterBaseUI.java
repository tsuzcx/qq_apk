package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  private boolean isFirst = true;
  protected int udq = 0;
  protected boolean ulU = false;
  protected o ulV;
  protected o ulW;
  protected o ulX;
  protected boolean ulY = false;
  
  public final int cZQ()
  {
    return 1000;
  }
  
  public final int cZR()
  {
    return this.udq;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.udq = getIntent().getIntExtra("game_report_from_scene", 0);
    this.ulU = getIntent().getBooleanExtra("from_find_more_friend", false);
    c.bZb().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41926);
        GameCenterBaseUI.a(GameCenterBaseUI.this);
        if (GameCenterBaseUI.this.ulU)
        {
          GameCenterBaseUI.b(GameCenterBaseUI.this);
          ((e)g.ab(e.class)).cWG();
          r.cZa();
        }
        AppMethodBeat.o(41926);
      }
    });
    f.a(this, 10, 1000, 0, 1, 0, null, this.udq, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.isFirst) && (a.a.das().uvm))
    {
      a.a.das().uvm = false;
      ad.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
      Intent localIntent = new Intent();
      localIntent.putExtra("game_report_from_scene", 901);
      localIntent.putExtra("switch_country_no_anim", true);
      d.b(this, "game", ".ui.GameCenterUI", localIntent);
    }
    this.isFirst = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */