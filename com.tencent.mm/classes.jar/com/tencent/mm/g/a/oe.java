package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class oe
  extends b
{
  public a dDb;
  public b dDc;
  
  public oe()
  {
    this((byte)0);
  }
  
  private oe(byte paramByte)
  {
    AppMethodBeat.i(140935);
    this.dDb = new a();
    this.dDc = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(140935);
  }
  
  public static final class a
  {
    public int dDd = 0;
    public int dDe = 0;
    public Runnable dDf;
    public String dwj;
  }
  
  public static final class b
  {
    public String dDg;
    public int dDh = 0;
    public int dwi = 0;
    public String dwk;
    public String dwl;
    public int errCode = -1;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.oe
 * JD-Core Version:    0.7.0.1
 */