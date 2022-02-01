package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class wy
  extends b
{
  public a dCu;
  public b dCv;
  
  public wy()
  {
    this((byte)0);
  }
  
  private wy(byte paramByte)
  {
    AppMethodBeat.i(130930);
    this.dCu = new a();
    this.dCv = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(130930);
  }
  
  public static final class a
  {
    public String action;
    public String appId;
    public String buffer;
    public String cMo;
    public String dCw;
    public String dCx;
    public int dCy;
    public String nonceStr;
    public String signType;
    public String url;
  }
  
  public static final class b
  {
    public String buffer;
    public Runnable dCz;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.wy
 * JD-Core Version:    0.7.0.1
 */