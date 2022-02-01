package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abb
  extends IEvent
{
  public a gaf;
  
  public abb()
  {
    this((byte)0);
  }
  
  private abb(byte paramByte)
  {
    AppMethodBeat.i(91224);
    this.gaf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91224);
  }
  
  public static final class a
  {
    public String appId;
    public String fJB;
    public String fwv;
    public int gag;
    public String nonceStr;
    public String packageExt;
    public String signType;
    public String timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.abb
 * JD-Core Version:    0.7.0.1
 */