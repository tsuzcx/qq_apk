package com.tencent.mm.autogen.a;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aau
  extends IEvent
{
  public a ier;
  
  public aau()
  {
    this((byte)0);
  }
  
  private aau(byte paramByte)
  {
    AppMethodBeat.i(369318);
    this.ier = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369318);
  }
  
  public static final class a
  {
    public int action;
    public PhoneStateListener ies;
    public int iet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aau
 * JD-Core Version:    0.7.0.1
 */