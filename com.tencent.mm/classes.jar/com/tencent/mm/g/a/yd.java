package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yd
  extends b
{
  public a dMt;
  public b dMu;
  
  public yd()
  {
    this((byte)0);
  }
  
  private yd(byte paramByte)
  {
    AppMethodBeat.i(130930);
    this.dMt = new a();
    this.dMu = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(130930);
  }
  
  public static final class a
  {
    public String action;
    public String appId;
    public String buffer;
    public String cUM;
    public String dMv;
    public String dMw;
    public int dMx;
    public String nonceStr;
    public String signType;
    public String url;
  }
  
  public static final class b
  {
    public String buffer;
    public Runnable dMy;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.yd
 * JD-Core Version:    0.7.0.1
 */