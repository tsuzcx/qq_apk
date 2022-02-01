package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ru
  extends IEvent
{
  public a hUO;
  
  public ru()
  {
    this((byte)0);
  }
  
  private ru(byte paramByte)
  {
    AppMethodBeat.i(117550);
    this.hUO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117550);
  }
  
  public static final class a
  {
    public String appId;
    public String hUP;
    public String hUQ;
    public int hUR;
    public int hUS;
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
 * Qualified Name:     com.tencent.mm.autogen.a.ru
 * JD-Core Version:    0.7.0.1
 */