package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class m
  extends IEvent
{
  public a fuM;
  public b fuN;
  
  public m()
  {
    this((byte)0);
  }
  
  private m(byte paramByte)
  {
    AppMethodBeat.i(121047);
    this.fuM = new a();
    this.fuN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121047);
  }
  
  public static final class a
  {
    public String fuO;
  }
  
  public static final class b
  {
    public int fuP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.m
 * JD-Core Version:    0.7.0.1
 */