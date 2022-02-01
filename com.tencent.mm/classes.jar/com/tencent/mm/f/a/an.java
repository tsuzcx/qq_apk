package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class an
  extends IEvent
{
  public a fvU;
  public b fvV;
  
  public an()
  {
    this((byte)0);
  }
  
  private an(byte paramByte)
  {
    AppMethodBeat.i(42651);
    this.fvU = new a();
    this.fvV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42651);
  }
  
  public static final class a
  {
    public int fvW = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.an
 * JD-Core Version:    0.7.0.1
 */