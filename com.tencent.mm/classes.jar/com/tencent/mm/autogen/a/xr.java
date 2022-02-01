package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xr
  extends IEvent
{
  public a iba;
  public b ibb;
  
  public xr()
  {
    this((byte)0);
  }
  
  private xr(byte paramByte)
  {
    AppMethodBeat.i(125631);
    this.iba = new a();
    this.ibb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125631);
  }
  
  public static final class a
  {
    public boolean ibc;
    public String ibd;
    public boolean ibe = false;
    public int type;
    public String videoPath;
  }
  
  public static final class b
  {
    public String ibd;
    public String ibf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xr
 * JD-Core Version:    0.7.0.1
 */