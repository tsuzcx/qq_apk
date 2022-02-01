package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class pq
  extends b
{
  public a dDT;
  public b dDU;
  
  public pq()
  {
    this((byte)0);
  }
  
  private pq(byte paramByte)
  {
    AppMethodBeat.i(91211);
    this.dDT = new a();
    this.dDU = new b();
    this.IbR = false;
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
    public boolean dDV = false;
    public String dDW;
    public String dDX;
    public String dDY;
    public String dDZ;
    public String dEa;
    public String dEb;
    public String dEc;
    public int errCode = 0;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.pq
 * JD-Core Version:    0.7.0.1
 */