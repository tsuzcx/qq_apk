package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.event.IEvent;

public final class mx
  extends IEvent
{
  public a dSE;
  
  public mx()
  {
    this((byte)0);
  }
  
  private mx(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.dSE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String dSF;
    public boolean dSG;
    public boolean dSH = false;
    public f dSy;
    public long duration;
    public int errCode;
    public String errMsg;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mx
 * JD-Core Version:    0.7.0.1
 */