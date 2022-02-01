package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kj
  extends IEvent
{
  public a fHP;
  public b fHQ;
  
  public kj()
  {
    this((byte)0);
  }
  
  private kj(byte paramByte)
  {
    AppMethodBeat.i(130778);
    this.fHP = new a();
    this.fHQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130778);
  }
  
  public static final class a
  {
    public int fHR = -1;
  }
  
  public static final class b
  {
    public int fHS = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.kj
 * JD-Core Version:    0.7.0.1
 */