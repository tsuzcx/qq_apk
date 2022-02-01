package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rx
  extends IEvent
{
  public a dYt;
  
  public rx()
  {
    this((byte)0);
  }
  
  private rx(byte paramByte)
  {
    AppMethodBeat.i(89650);
    this.dYt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89650);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String dDJ;
    public int dYu;
    public String dYv;
    public String msgId;
    public int msgType;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.rx
 * JD-Core Version:    0.7.0.1
 */