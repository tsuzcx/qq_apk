package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ar
  extends IEvent
{
  public a dDD;
  public b dDE;
  
  public ar()
  {
    this((byte)0);
  }
  
  private ar(byte paramByte)
  {
    AppMethodBeat.i(155543);
    this.dDD = new a();
    this.dDE = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155543);
  }
  
  public static final class a
  {
    public String event;
    public int position = 0;
    public int type;
  }
  
  public static final class b
  {
    public String Title;
    public int dDF = 0;
    public int dDG = 0;
    public int dDH = 0;
    public int dDI = 0;
    public String dDJ;
    public String desc;
    public int position = 0;
    public String url;
    public boolean visible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ar
 * JD-Core Version:    0.7.0.1
 */