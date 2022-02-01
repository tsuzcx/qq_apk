package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class my
  extends IEvent
{
  public a hPa;
  public b hPb;
  
  public my()
  {
    this((byte)0);
  }
  
  private my(byte paramByte)
  {
    AppMethodBeat.i(369353);
    this.hPa = new a();
    this.hPb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369353);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public Runnable callback;
    public String hPc;
    public String hPd;
    public String hPe;
    public String hPf;
    public String hPg;
    public String hPh;
    public String nonceStr;
    public String signType;
    public String timeStamp;
  }
  
  public static final class b
  {
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.my
 * JD-Core Version:    0.7.0.1
 */