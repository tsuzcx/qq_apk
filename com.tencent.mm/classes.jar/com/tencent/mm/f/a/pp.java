package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pp
  extends IEvent
{
  public a fOl;
  public b fOm;
  
  public pp()
  {
    this((byte)0);
  }
  
  private pp(byte paramByte)
  {
    AppMethodBeat.i(116039);
    this.fOl = new a();
    this.fOm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116039);
  }
  
  public static final class a
  {
    public int fOn;
    public int fOo;
    public String fyu;
    public String pageId;
    public int source;
  }
  
  public static final class b
  {
    public String xml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.pp
 * JD-Core Version:    0.7.0.1
 */