package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class um
  extends IEvent
{
  public a hYh;
  
  public um()
  {
    this((byte)0);
  }
  
  private um(byte paramByte)
  {
    AppMethodBeat.i(89650);
    this.hYh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89650);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String hAR;
    public int hYi;
    public String hYj;
    public String msgId;
    public int msgType;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.um
 * JD-Core Version:    0.7.0.1
 */