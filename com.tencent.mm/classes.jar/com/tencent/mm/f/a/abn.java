package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abn
  extends IEvent
{
  public a gbr;
  public b gbs;
  
  public abn()
  {
    this((byte)0);
  }
  
  private abn(byte paramByte)
  {
    AppMethodBeat.i(116059);
    this.gbr = new a();
    this.gbs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116059);
  }
  
  public static final class a
  {
    public String fJG;
  }
  
  public static final class b
  {
    public boolean gbt;
    public boolean gbu;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.abn
 * JD-Core Version:    0.7.0.1
 */