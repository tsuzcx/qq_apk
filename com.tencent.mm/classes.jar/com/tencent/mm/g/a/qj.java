package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qj
  extends IEvent
{
  public a dWK;
  public b dWL;
  
  public qj()
  {
    this((byte)0);
  }
  
  private qj(byte paramByte)
  {
    AppMethodBeat.i(91211);
    this.dWK = new a();
    this.dWL = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91211);
  }
  
  public static final class a
  {
    public String appId;
    public String url;
  }
  
  public static final class b
  {
    public boolean dWM = false;
    public String dWN;
    public String dWO;
    public String dWP;
    public String dWQ;
    public String dWR;
    public String dWS;
    public String dWT;
    public int errCode = 0;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qj
 * JD-Core Version:    0.7.0.1
 */