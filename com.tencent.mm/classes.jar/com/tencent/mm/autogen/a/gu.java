package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gu
  extends IEvent
{
  public a hHl;
  public b hHm;
  
  public gu()
  {
    this((byte)0);
  }
  
  private gu(byte paramByte)
  {
    AppMethodBeat.i(116021);
    this.hHl = new a();
    this.hHm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116021);
  }
  
  public static final class a
  {
    public int duration;
    public String filePath;
    public Runnable hly;
    public int op;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
    public int hHn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gu
 * JD-Core Version:    0.7.0.1
 */