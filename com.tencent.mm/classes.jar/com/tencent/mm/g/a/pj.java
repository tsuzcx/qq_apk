package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pj
  extends IEvent
{
  public a dVs;
  
  public pj()
  {
    this((byte)0);
  }
  
  private pj(byte paramByte)
  {
    AppMethodBeat.i(117550);
    this.dVs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117550);
  }
  
  public static final class a
  {
    public String appId;
    public String dVt;
    public String dVu;
    public int dVv;
    public int dVw;
    public String nonceStr;
    public String packageExt;
    public String partnerId;
    public int payChannel;
    public String signType;
    public String timeStamp;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.pj
 * JD-Core Version:    0.7.0.1
 */