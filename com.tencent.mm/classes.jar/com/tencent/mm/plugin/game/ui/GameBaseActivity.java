package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity
  extends MMActivity
{
  private long mStartTime = 0L;
  private int tmM = 1;
  private long tmN = 0L;
  private long tmO = 0L;
  
  protected boolean cRj()
  {
    return true;
  }
  
  public abstract int cRk();
  
  public abstract int cRl();
  
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
      ac.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l), Long.valueOf(this.tmN) });
      if (cRj()) {
        a.a(this.tmM, getScene(), cRk(), cRl(), "", "", l / 1000L, this.tmN / 1000L);
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.tmN += System.currentTimeMillis() - this.tmO;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.tmO = System.currentTimeMillis();
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