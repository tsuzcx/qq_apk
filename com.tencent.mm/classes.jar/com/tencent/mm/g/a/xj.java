package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xj
  extends b
{
  public a dAg;
  public b dAh;
  
  public xj()
  {
    this((byte)0);
  }
  
  private xj(byte paramByte)
  {
    AppMethodBeat.i(130930);
    this.dAg = new a();
    this.dAh = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(130930);
  }
  
  public static final class a
  {
    public String action;
    public String appId;
    public String buffer;
    public String cJz;
    public String dAi;
    public String dAj;
    public int dAk;
    public String nonceStr;
    public String signType;
    public String url;
  }
  
  public static final class b
  {
    public String buffer;
    public Runnable dAl;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.xj
 * JD-Core Version:    0.7.0.1
 */