package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vv
  extends IEvent
{
  public a fUR;
  public b fUS;
  
  public vv()
  {
    this((byte)0);
  }
  
  private vv(byte paramByte)
  {
    AppMethodBeat.i(153185);
    this.fUR = new a();
    this.fUS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153185);
  }
  
  public static final class a
  {
    public boolean fUT;
  }
  
  public static final class b
  {
    public boolean fUU;
    public boolean fUV;
    public boolean fUW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.vv
 * JD-Core Version:    0.7.0.1
 */