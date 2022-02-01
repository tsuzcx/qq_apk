package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.b.b;

public final class lw
  extends b
{
  public a dnW;
  
  public lw()
  {
    this((byte)0);
  }
  
  private lw(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.dnW = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public f dnQ;
    public String dnX;
    public boolean dnY;
    public boolean dnZ = false;
    public long duration;
    public int errCode;
    public String errMsg;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.lw
 * JD-Core Version:    0.7.0.1
 */