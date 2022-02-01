package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public abstract class GameCenterBaseUI
  extends GameCenterActivity
{
  private boolean isFirst = true;
  protected int tfA = 0;
  protected boolean tnA = false;
  protected boolean tnw = false;
  protected o tnx;
  protected o tny;
  protected o tnz;
  
  public final int cRk()
  {
    return 1000;
  }
  
  public final int cRl()
  {
    return this.tfA;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.agM())
    {
      ac.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.tfA = getIntent().getIntExtra("game_report_from_scene", 0);
    this.tnw = getIntent().getBooleanExtra("from_find_more_friend", false);
    c.bUw().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41926);
        GameCenterBaseUI.a(GameCenterBaseUI.this);
        if (GameCenterBaseUI.this.tnw)
        {
          GameCenterBaseUI.b(GameCenterBaseUI.this);
          ((com.tencent.mm.plugin.game.api.d)g.ab(com.tencent.mm.plugin.game.api.d.class)).cOl();
          r.cQv();
        }
        AppMethodBeat.o(41926);
      }
    });
    e.a(this, 10, 1000, 0, 1, 0, null, this.tfA, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!g.agM())
    {
      ac.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.isFirst) && (a.a.cRI().twa))
    {
      a.a.cRI().twa = false;
      ac.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
      Intent localIntent = new Intent();
      localIntent.putExtra("game_report_from_scene", 901);
      localIntent.putExtra("switch_country_no_anim", true);
      com.tencent.mm.br.d.b(this, "game", ".ui.GameCenterUI", localIntent);
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