package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.y;

final class d$c
  extends h
{
  d$c(d paramd, i parami)
  {
    super(parami);
  }
  
  public final void enter()
  {
    super.enter();
    this.fGa.ujd.sendEmptyMessageDelayed(4, this.fGa.fzT.ZB().fPQ * 1000L);
  }
  
  public final void exit()
  {
    super.exit();
    this.fGa.ujd.removeMessages(4);
  }
  
  public final boolean g(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.g(paramMessage);
    case 4: 
      paramMessage = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(paramMessage);
      y.i(this.fGa.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", new Object[] { Integer.valueOf(paramMessage.importance) });
      if (paramMessage.importance == 100)
      {
        d.a(this.fGa, this.fGa.fFU);
        return true;
      }
      d.a(this.fGa, this.fGa.fFS);
      return true;
    case 10: 
      y.i(this.fGa.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
      d.a(this.fGa, this.fGa.fFU);
      return true;
    }
    d.a(this.fGa, this.fGa.fFQ);
    return true;
  }
  
  public final String getName()
  {
    return this.fGa.mName + "|BackgroundTemporary";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.c
 * JD-Core Version:    0.7.0.1
 */