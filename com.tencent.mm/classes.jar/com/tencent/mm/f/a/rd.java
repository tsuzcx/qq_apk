package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rd
  extends IEvent
{
  public a fQd;
  
  public rd()
  {
    this((byte)0);
  }
  
  private rd(byte paramByte)
  {
    AppMethodBeat.i(89649);
    this.fQd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89649);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public String content;
    public boolean fQe;
    public boolean fQf;
    public int fwp = 0;
    public String fwt;
    public String icon;
    public int iconHeight;
    public int iconWidth;
    public long msgId;
    public int msgType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.rd
 * JD-Core Version:    0.7.0.1
 */