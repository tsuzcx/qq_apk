package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity
  extends MMActivity
{
  private long mStartTime = 0L;
  private int xOI = 1;
  private long xOJ = 0L;
  private long xyY = 0L;
  
  protected boolean dWh()
  {
    return true;
  }
  
  public abstract int dWi();
  
  public abstract int dWj();
  
  public abstract int getScene();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.mStartTime != 0L)
    {
      long l = System.currentTimeMillis() - this.mStartTime;
      Log.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l), Long.valueOf(this.xyY) });
      if (dWh()) {
        a.a(this.xOI, getScene(), dWi(), dWj(), "", "", l / 1000L, this.xyY / 1000L);
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.xyY += System.currentTimeMillis() - this.xOJ;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.xOJ = System.currentTimeMillis();
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBaseActivity
 * JD-Core Version:    0.7.0.1
 */