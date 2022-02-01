package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zj
  extends IEvent
{
  public a fYK;
  public b fYL;
  
  public zj()
  {
    this((byte)0);
  }
  
  private zj(byte paramByte)
  {
    AppMethodBeat.i(116054);
    this.fYK = new a();
    this.fYL = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116054);
  }
  
  public static final class a
  {
    public String id;
  }
  
  public static final class b
  {
    public boolean fYM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zj
 * JD-Core Version:    0.7.0.1
 */