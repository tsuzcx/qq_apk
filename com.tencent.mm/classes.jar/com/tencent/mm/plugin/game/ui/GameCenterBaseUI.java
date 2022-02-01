package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.a.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  private boolean isFirst = true;
  protected int xGR = 0;
  protected boolean xPr = false;
  protected o xPs;
  protected o xPt;
  protected o xPu;
  protected boolean xPv = false;
  
  public final int dWi()
  {
    return 1000;
  }
  
  public final int dWj()
  {
    return this.xGR;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
    this.xPr = getIntent().getBooleanExtra("from_find_more_friend", false);
    com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41926);
        GameCenterBaseUI.a(GameCenterBaseUI.this);
        if (GameCenterBaseUI.this.xPr)
        {
          GameCenterBaseUI.b(GameCenterBaseUI.this);
          ((e)g.af(e.class)).dSJ();
          r.dVr();
        }
        AppMethodBeat.o(41926);
      }
    });
    f.a(this, 10, 1000, 0, 1, 0, null, this.xGR, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.isFirst) && (a.a.dWO().xYX))
    {
      a.a.dWO().xYX = false;
      Log.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.xtn);
      Intent localIntent = new Intent();
      localIntent.putExtra("game_report_from_scene", 901);
      localIntent.putExtra("switch_country_no_anim", true);
      com.tencent.mm.br.c.b(this, "game", ".ui.GameCenterUI", localIntent);
    }
    this.isFirst = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */