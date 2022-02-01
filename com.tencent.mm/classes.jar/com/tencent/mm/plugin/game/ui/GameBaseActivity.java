package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity
  extends MMActivity
{
  private long mStartTime = 0L;
  private int uwH = 1;
  private long uwI = 0L;
  private long uwJ = 0L;
  
  protected boolean dcA()
  {
    return true;
  }
  
  public abstract int dcB();
  
  public abstract int dcC();
  
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
      ae.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l), Long.valueOf(this.uwI) });
      if (dcA()) {
        a.a(this.uwH, getScene(), dcB(), dcC(), "", "", l / 1000L, this.uwI / 1000L);
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.uwI += System.currentTimeMillis() - this.uwJ;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.uwJ = System.currentTimeMillis();
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