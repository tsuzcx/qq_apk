package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.event.IEvent;

public final class ei
  extends IEvent
{
  public a hEe;
  public b hEf;
  
  public ei()
  {
    this((byte)0);
  }
  
  private ei(byte paramByte)
  {
    AppMethodBeat.i(115975);
    this.hEe = new a();
    this.hEf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115975);
  }
  
  public static final class a
  {
    public String hEg;
    public int hEh = 0;
    public p hEi;
    public int opType = 0;
  }
  
  public static final class b
  {
    public p hEi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ei
 * JD-Core Version:    0.7.0.1
 */