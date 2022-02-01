package com.tencent.mm.plugin.game.ui;

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
  protected int IFc = 0;
  protected boolean INQ = false;
  protected o INR;
  protected o INS;
  protected o INU;
  protected boolean INV = false;
  private boolean isFirst = true;
  
  public final int fHm()
  {
    return 1000;
  }
  
  public final int fHn()
  {
    return this.IFc;
  }
  
  public final String fHo()
  {
    return null;
  }
  
  public final String fHp()
  {
    return null;
  }
  
  public final int getScene()
  {
    return 10;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!h.baz())
    {
      Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
      finish();
      return;
    }
    this.IFc = getIntent().getIntExtra("game_report_from_scene", 0);
    this.INQ = getIntent().getBooleanExtra("from_find_more_friend", false);
    com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41926);
        GameCenterBaseUI.a(GameCenterBaseUI.this);
        if (GameCenterBaseUI.this.INQ)
        {
          GameCenterBaseUI.b(GameCenterBaseUI.this);
          ((e)h.ax(e.class)).fCg().fGv();
        }
        AppMethodBeat.o(41926);
      }
    });
    g.a(this, 10, 1000, 0, 1, 0, null, this.IFc, 0, null, null, null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!h.baz())
    {
      Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
      return;
    }
    if ((!this.isFirst) && (a.a.fHX().IXT))
    {
      a.a.fHX().IXT = false;
      Log.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
      if (!isFinishing()) {
        finish();
      }
      sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.HRS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI
 * JD-Core Version:    0.7.0.1
 */