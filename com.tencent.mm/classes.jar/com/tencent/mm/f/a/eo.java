package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eo
  extends IEvent
{
  public a fAt;
  public b fAu;
  
  public eo()
  {
    this((byte)0);
  }
  
  private eo(byte paramByte)
  {
    AppMethodBeat.i(115991);
    this.fAt = new a();
    this.fAu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115991);
  }
  
  public static final class a
  {
    public boolean fAs = false;
    public String fAv;
  }
  
  public static final class b
  {
    public boolean fAw = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.eo
 * JD-Core Version:    0.7.0.1
 */