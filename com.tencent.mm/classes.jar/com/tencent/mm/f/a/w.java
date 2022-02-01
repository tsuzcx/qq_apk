package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class w
  extends IEvent
{
  public a fvs;
  
  public w()
  {
    this((byte)0);
  }
  
  private w(byte paramByte)
  {
    AppMethodBeat.i(19787);
    this.fvs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19787);
  }
  
  public static final class a
  {
    public ca fvt;
    public k.b fvu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.w
 * JD-Core Version:    0.7.0.1
 */