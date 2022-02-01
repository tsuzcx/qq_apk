package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aad
  extends IEvent
{
  public a fZt;
  public b fZu;
  
  public aad()
  {
    this((byte)0);
  }
  
  private aad(byte paramByte)
  {
    AppMethodBeat.i(121052);
    this.fZt = new a();
    this.fZu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121052);
  }
  
  public static final class a
  {
    public int action;
    public String fuO;
    public int option;
  }
  
  public static final class b
  {
    public boolean fZv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.aad
 * JD-Core Version:    0.7.0.1
 */