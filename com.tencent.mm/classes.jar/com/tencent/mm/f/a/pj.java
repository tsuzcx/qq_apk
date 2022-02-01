package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pj
  extends IEvent
{
  public a fOb;
  
  public pj()
  {
    this((byte)0);
  }
  
  private pj(byte paramByte)
  {
    AppMethodBeat.i(117613);
    this.fOb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117613);
  }
  
  public static final class a
  {
    public String appId;
    public String fOc;
    public String fOd;
    public int scene;
    public int type;
    public String url;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.pj
 * JD-Core Version:    0.7.0.1
 */