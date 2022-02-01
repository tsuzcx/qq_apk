package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lc
  extends IEvent
{
  public a dQg;
  public b dQh;
  
  public lc()
  {
    this((byte)0);
  }
  
  private lc(byte paramByte)
  {
    AppMethodBeat.i(200179);
    this.dQg = new a();
    this.dQh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(200179);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public Runnable callback;
    public String dQi;
    public String dQj;
    public String dQk;
    public String dQl;
    public String dQm;
    public String dQn;
    public String nonceStr;
    public String signType;
    public String timeStamp;
  }
  
  public static final class b
  {
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.lc
 * JD-Core Version:    0.7.0.1
 */