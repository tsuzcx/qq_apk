package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adt
  extends IEvent
{
  public a iie;
  
  public adt()
  {
    this((byte)0);
  }
  
  private adt(byte paramByte)
  {
    AppMethodBeat.i(19849);
    this.iie = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19849);
  }
  
  public static final class a
  {
    public byte[] data;
    public int hAf;
    public String hEl;
    public String hEr;
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adt
 * JD-Core Version:    0.7.0.1
 */