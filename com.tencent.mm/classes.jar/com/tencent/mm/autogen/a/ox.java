package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.event.IEvent;

public final class ox
  extends IEvent
{
  public a hRN;
  
  public ox()
  {
    this((byte)0);
  }
  
  private ox(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.hRN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public long duration;
    public int errCode;
    public String errMsg;
    public f hRG;
    public boolean hRO;
    public boolean hRP = false;
    public String musicId;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ox
 * JD-Core Version:    0.7.0.1
 */