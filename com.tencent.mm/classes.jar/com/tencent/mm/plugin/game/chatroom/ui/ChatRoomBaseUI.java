package com.tencent.mm.plugin.game.chatroom.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fp;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class ChatRoomBaseUI
  extends MMActivity
{
  private long CvJ = 0L;
  private long CvK = 0L;
  private long mStartTime = 0L;
  
  public abstract long evK();
  
  public abstract long evL();
  
  public abstract long evM();
  
  public abstract long evN();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.mStartTime != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mStartTime;
      Log.i("MicroMsg.ChatRoomBaseUI", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l1 - l2), Long.valueOf(this.CvJ) });
      if (evL() != -1L)
      {
        Object localObject = d.jTj;
        l1 = evL();
        l2 = evK();
        long l3 = evM();
        long l4 = evN();
        long l5 = this.CvJ / 1000L;
        localObject = d.a.a(l1, l2, 0L, 29L, 0L, l3, l4);
        d.a locala = d.jTj;
        ((fp)localObject).uX(d.aEy());
        ((fp)localObject).glN = l5;
        ((fp)localObject).bpa();
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.CvJ += System.currentTimeMillis() - this.CvK;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.CvK = System.currentTimeMillis();
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.ChatRoomBaseUI
 * JD-Core Version:    0.7.0.1
 */