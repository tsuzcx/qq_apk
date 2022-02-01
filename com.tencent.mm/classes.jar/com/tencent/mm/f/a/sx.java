package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sx
  extends IEvent
{
  public a fSk;
  
  public sx()
  {
    this((byte)0);
  }
  
  private sx(byte paramByte)
  {
    AppMethodBeat.i(89650);
    this.fSk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89650);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int fSl;
    public String fSm;
    public String fwt;
    public String msgId;
    public int msgType;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.sx
 * JD-Core Version:    0.7.0.1
 */