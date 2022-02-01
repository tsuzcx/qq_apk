package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity
  extends MMActivity
{
  private long mStartTime = 0L;
  private int ulk = 1;
  private long ull = 0L;
  private long ulm = 0L;
  
  protected boolean cZP()
  {
    return true;
  }
  
  public abstract int cZQ();
  
  public abstract int cZR();
  
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
      ad.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l), Long.valueOf(this.ull) });
      if (cZP()) {
        a.a(this.ulk, getScene(), cZQ(), cZR(), "", "", l / 1000L, this.ull / 1000L);
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.ull += System.currentTimeMillis() - this.ulm;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.ulm = System.currentTimeMillis();
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