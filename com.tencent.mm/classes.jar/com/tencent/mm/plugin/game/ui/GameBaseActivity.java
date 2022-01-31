package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity
  extends MMActivity
{
  private int kXn = 1;
  private long kXo = 0L;
  private long kXp = 0L;
  private long mStartTime = 0L;
  
  public boolean aZX()
  {
    return true;
  }
  
  public abstract int aZY();
  
  public abstract int aZZ();
  
  public abstract int baa();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.mStartTime != 0L)
    {
      long l = System.currentTimeMillis() - this.mStartTime;
      y.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l), Long.valueOf(this.kXo) });
      if (aZX()) {
        a.a(this.kXn, aZY(), aZZ(), baa(), "", "", l / 1000L, this.kXo / 1000L);
      }
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.kXo += System.currentTimeMillis() - this.kXp;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.kXp = System.currentTimeMillis();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBaseActivity
 * JD-Core Version:    0.7.0.1
 */