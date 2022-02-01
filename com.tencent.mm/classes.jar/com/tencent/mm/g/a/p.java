package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class p
  extends IEvent
{
  public a dCt;
  
  public p()
  {
    this((byte)0);
  }
  
  private p(byte paramByte)
  {
    AppMethodBeat.i(121048);
    this.dCt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121048);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int appVersion;
    public int cyo;
    public int dCA;
    public int dCB;
    public String dCC;
    public String dCu;
    public int dCv;
    public String dCw;
    public String dCx;
    public String dCy;
    public long dCz;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.p
 * JD-Core Version:    0.7.0.1
 */