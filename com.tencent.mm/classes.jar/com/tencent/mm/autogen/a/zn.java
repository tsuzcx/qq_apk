package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zn
  extends IEvent
{
  public a icF;
  public b icG;
  
  public zn()
  {
    this((byte)0);
  }
  
  private zn(byte paramByte)
  {
    AppMethodBeat.i(127410);
    this.icF = new a();
    this.icG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127410);
  }
  
  public static final class a
  {
    public boolean icH;
    public String icI;
    public dn icJ;
    public String url;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zn
 * JD-Core Version:    0.7.0.1
 */