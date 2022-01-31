package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class GameCenterActivity
  extends GameBaseActivity
{
  protected int nvX = 0;
  protected String nvY = null;
  private dd nvZ;
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.nvZ = a.bFc();
    if (this.nvZ != null)
    {
      this.nvX = c.parseColor(this.nvZ.color);
      this.nvY = this.nvZ.noW;
    }
    ab.i("MicroMsg.GameCenterActivity", "setInitialStatusBarStyle");
    if ((d.fv(21)) && (this.nvX != 0)) {
      setActionbarColor(this.nvX);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */