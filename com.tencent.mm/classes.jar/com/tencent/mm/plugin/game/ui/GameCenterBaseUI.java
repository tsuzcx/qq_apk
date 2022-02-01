package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  protected int CKU = 0;
  protected boolean CTA = false;
  protected o CTB;
  protected o CTC;
  protected o CTD;
  protected boolean CTE = false;
  private boolean isFirst = true;
  
  public final int ezq()
  {
    return 1000;
  }
  
  public final int ezr()
  {
    return this.CKU;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!h.aHB())
    {
      Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.CKU = getIntent().getIntExtra("game_report_from_scene", 0);
    this.CTA = getIntent().getBooleanExtra("from_find_more_friend", false);
    com.tencent.mm.plugin.game.d.c.cMC().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41926);
        GameCenterBaseUI.a(GameCenterBaseUI.this);
        if (GameCenterBaseUI.this.CTA)
        {
          GameCenterBaseUI.b(GameCenterBaseUI.this);
          ((e)h.ae(e.class)).evn().eyz();
        }
        AppMethodBeat.o(41926);
      }
    });
    g.a(this, 10, 1000, 0, 1, 0, null, this.CKU, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!h.aHB())
    {
      Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.isFirst) && (a.a.ezW().DdC))
    {
      a.a.ezW().DdC = false;
      Log.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.CfL);
      Intent localIntent = new Intent();
      localIntent.putExtra("game_report_from_scene", 901);
      localIntent.putExtra("switch_country_no_anim", true);
      com.tencent.mm.by.c.b(this, "game", ".ui.GameCenterUI", localIntent);
    }
    this.isFirst = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */