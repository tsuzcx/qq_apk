package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acy
  extends IEvent
{
  public a igo;
  
  public acy()
  {
    this((byte)0);
  }
  
  private acy(byte paramByte)
  {
    AppMethodBeat.i(91224);
    this.igo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91224);
  }
  
  public static final class a
  {
    public String appId;
    public String hAT;
    public String hPe;
    public int igp;
    public String nonceStr;
    public String packageExt;
    public String signType;
    public String timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acy
 * JD-Core Version:    0.7.0.1
 */