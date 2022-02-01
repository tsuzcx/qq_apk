package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.b.b;

public final class mg
  extends b
{
  public a dAP;
  
  public mg()
  {
    this((byte)0);
  }
  
  private mg(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.dAP = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public f dAJ;
    public String dAQ;
    public boolean dAR;
    public boolean dAS = false;
    public long duration;
    public int errCode;
    public String errMsg;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mg
 * JD-Core Version:    0.7.0.1
 */