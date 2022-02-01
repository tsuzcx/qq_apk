package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lt
  extends IEvent
{
  public a fJx;
  public b fJy;
  
  public lt()
  {
    this((byte)0);
  }
  
  private lt(byte paramByte)
  {
    AppMethodBeat.i(254941);
    this.fJx = new a();
    this.fJy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(254941);
  }
  
  public static final class a
  {
    public String appId;
    public String appName;
    public Runnable callback;
    public String fJA;
    public String fJB;
    public String fJC;
    public String fJD;
    public String fJE;
    public String fJz;
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
 * Qualified Name:     com.tencent.mm.f.a.lt
 * JD-Core Version:    0.7.0.1
 */