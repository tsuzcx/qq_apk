package com.tencent.mm.g.a;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xt
  extends IEvent
{
  public a eeb;
  
  public xt()
  {
    this((byte)0);
  }
  
  private xt(byte paramByte)
  {
    AppMethodBeat.i(194255);
    this.eeb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194255);
  }
  
  public static final class a
  {
    public int action;
    public PhoneStateListener eec;
    public int eed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xt
 * JD-Core Version:    0.7.0.1
 */