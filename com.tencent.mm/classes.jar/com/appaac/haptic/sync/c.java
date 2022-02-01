package com.appaac.haptic.sync;

import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import com.appaac.haptic.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public boolean DEBUG;
  public long csf;
  private b csg;
  private long csh;
  private long csi;
  private Handler mEventHandler;
  
  public c(Handler paramHandler, String paramString, a parama)
  {
    AppMethodBeat.i(208356);
    this.DEBUG = false;
    this.csh = -1L;
    this.csf = -1L;
    this.mEventHandler = paramHandler;
    this.csg = new b(paramString, parama);
    AppMethodBeat.o(208356);
  }
  
  private void ND()
  {
    AppMethodBeat.i(208368);
    try
    {
      this.csh = this.csg.NA();
      if (this.DEBUG) {
        new StringBuilder("scheduleTimedEvents @").append(this.csh).append(" after ").append(this.csf);
      }
      if (this.csh != -1L)
      {
        long l1 = this.csh;
        long l2 = this.csf;
        Message localMessage = this.mEventHandler.obtainMessage(100, 0, 0, Long.valueOf(this.csh));
        this.mEventHandler.sendMessageDelayed(localMessage, l1 - l2 - 20L);
        AppMethodBeat.o(208368);
        return;
      }
      if (this.DEBUG) {
        new StringBuilder("scheduleTimedEvents @ completed- tail pattern duration:").append(this.csg.NB()).append(",mLastScheduledTime:").append(this.csi);
      }
      this.mEventHandler.sendEmptyMessageDelayed(102, this.csi + this.csg.NB());
      AppMethodBeat.o(208368);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(208368);
    }
  }
  
  private void y(long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(208362);
    for (;;)
    {
      try
      {
        Object localObject = this.csg.bE(paramLong2);
        if (this.DEBUG) {
          new StringBuilder("synchronize curPos:").append(paramLong1).append(",timeUs:").append(paramLong2).append(" with ").append(localObject);
        }
        if ((localObject != null) && (!((VibrationPattern)localObject).pattern.isEmpty()))
        {
          Parcel localParcel = Parcel.obtain();
          ((VibrationPattern)localObject).writeToParcel(localParcel, 0);
          localParcel.setDataPosition(0);
          localObject = this.mEventHandler.obtainMessage(101, 0, 0, localParcel);
          if (paramLong2 <= paramLong1)
          {
            this.mEventHandler.sendMessage((Message)localObject);
            this.csi = 0L;
            AppMethodBeat.o(208362);
            return;
            this.csi = l;
            this.mEventHandler.sendMessageDelayed((Message)localObject, l);
          }
        }
        else
        {
          AppMethodBeat.o(208362);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.getMessage();
        AppMethodBeat.o(208362);
        return;
      }
      if (paramLong2 - paramLong1 > 20L) {
        l = paramLong2 - paramLong1 - 20L;
      }
    }
  }
  
  public final void NC()
  {
    AppMethodBeat.i(208381);
    if (this.DEBUG) {}
    try
    {
      y(0L, 0L);
      ND();
      AppMethodBeat.o(208381);
      return;
    }
    finally
    {
      AppMethodBeat.o(208381);
    }
  }
  
  public final void x(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(208374);
    try
    {
      y(paramLong1, paramLong2);
      ND();
      AppMethodBeat.o(208374);
      return;
    }
    finally
    {
      AppMethodBeat.o(208374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.sync.c
 * JD-Core Version:    0.7.0.1
 */