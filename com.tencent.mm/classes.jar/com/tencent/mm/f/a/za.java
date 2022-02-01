package com.tencent.mm.f.a;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class za
  extends IEvent
{
  public a fYq;
  
  public za()
  {
    this((byte)0);
  }
  
  private za(byte paramByte)
  {
    AppMethodBeat.i(262450);
    this.fYq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(262450);
  }
  
  public static final class a
  {
    public int action;
    public PhoneStateListener fYr;
    public int fYs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.za
 * JD-Core Version:    0.7.0.1
 */