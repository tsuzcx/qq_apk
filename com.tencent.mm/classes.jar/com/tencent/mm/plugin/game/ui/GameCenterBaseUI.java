package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  private boolean isFirst = true;
  protected int uoy = 0;
  protected boolean uxr = false;
  protected o uxs;
  protected o uxt;
  protected o uxu;
  protected boolean uxv = false;
  
  public final int dcB()
  {
    return 1000;
  }
  
  public final int dcC()
  {
    return this.uoy;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.uoy = getIntent().getIntExtra("game_report_from_scene", 0);
    this.uxr = getIntent().getBooleanExtra("from_find_more_friend", false);
    c.caq().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41926);
        GameCenterBaseUI.a(GameCenterBaseUI.this);
        if (GameCenterBaseUI.this.uxr)
        {
          GameCenterBaseUI.b(GameCenterBaseUI.this);
          ((e)g.ab(e.class)).cZk();
          r.dbK();
        }
        AppMethodBeat.o(41926);
      }
    });
    f.a(this, 10, 1000, 0, 1, 0, null, this.uoy, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.isFirst) && (a.a.dde().uGL))
    {
      a.a.dde().uGL = false;
      ae.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */