package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qh
  extends IEvent
{
  public a fOV;
  
  public qh()
  {
    this((byte)0);
  }
  
  private qh(byte paramByte)
  {
    AppMethodBeat.i(117550);
    this.fOV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117550);
  }
  
  public static final class a
  {
    public String appId;
    public String fOW;
    public String fOX;
    public int fOY;
    public int fOZ;
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
 * Qualified Name:     com.tencent.mm.f.a.qh
 * JD-Core Version:    0.7.0.1
 */