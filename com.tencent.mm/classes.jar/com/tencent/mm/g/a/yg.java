package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yg
  extends IEvent
{
  public a eeB;
  
  public yg()
  {
    this((byte)0);
  }
  
  private yg(byte paramByte)
  {
    AppMethodBeat.i(140991);
    this.eeB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140991);
  }
  
  public static final class a
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
 * Qualified Name:     com.tencent.mm.g.a.yg
 * JD-Core Version:    0.7.0.1
 */