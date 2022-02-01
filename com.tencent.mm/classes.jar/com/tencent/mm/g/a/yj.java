package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yj
  extends b
{
  public a dNJ;
  public b dNK;
  
  public yj()
  {
    this((byte)0);
  }
  
  private yj(byte paramByte)
  {
    AppMethodBeat.i(130930);
    this.dNJ = new a();
    this.dNK = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(130930);
  }
  
  public static final class a
  {
    public String action;
    public String appId;
    public String buffer;
    public String cVJ;
    public String dNL;
    public String dNM;
    public int dNN;
    public String nonceStr;
    public String signType;
    public String url;
  }
  
  public static final class b
  {
    public String buffer;
    public Runnable dNO;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.yj
 * JD-Core Version:    0.7.0.1
 */