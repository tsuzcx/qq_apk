package com.tencent.mm.autogen.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hd
  extends IEvent
{
  public a hHR;
  
  public hd()
  {
    this((byte)0);
  }
  
  private hd(byte paramByte)
  {
    AppMethodBeat.i(63288);
    this.hHR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63288);
  }
  
  public static final class a
  {
    public String hHS;
    public int hHT = 0;
    public Activity hHU;
    public int mRequestCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.hd
 * JD-Core Version:    0.7.0.1
 */