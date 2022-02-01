package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity
  extends MMActivity
{
  private int INi = 1;
  private long ImA = 0L;
  private long Imz = 0L;
  private long mStartTime = 0L;
  
  protected boolean fHl()
  {
    return true;
  }
  
  public abstract int fHm();
  
  public abstract int fHn();
  
  public abstract String fHo();
  
  public abstract String fHp();
  
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
      Log.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l), Long.valueOf(this.Imz) });
      if (fHl()) {
        a.a(this.INi, getScene(), fHm(), fHn(), "", fHo(), "", l / 1000L, this.Imz / 1000L, fHp());
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.Imz += System.currentTimeMillis() - this.ImA;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.ImA = System.currentTimeMillis();
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