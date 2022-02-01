package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zw
  extends IEvent
{
  public a idt;
  
  public zw()
  {
    this((byte)0);
  }
  
  private zw(byte paramByte)
  {
    AppMethodBeat.i(19838);
    this.idt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19838);
  }
  
  public static final class a
  {
    public Context context;
    public String idu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zw
 * JD-Core Version:    0.7.0.1
 */