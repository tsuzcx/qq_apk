package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class di
  extends IEvent
{
  public a hDl;
  public b hDm;
  
  public di()
  {
    this((byte)0);
  }
  
  private di(byte paramByte)
  {
    AppMethodBeat.i(127401);
    this.hDl = new a();
    this.hDm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127401);
  }
  
  public static final class a
  {
    public long hDn = 0L;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.di
 * JD-Core Version:    0.7.0.1
 */