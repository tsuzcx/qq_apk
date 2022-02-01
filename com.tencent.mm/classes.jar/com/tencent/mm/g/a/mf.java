package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.b.b;

public final class mf
  extends b
{
  public a dzK;
  
  public mf()
  {
    this((byte)0);
  }
  
  private mf(byte paramByte)
  {
    AppMethodBeat.i(136976);
    this.dzK = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(136976);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public long duration;
    public f dzE;
    public String dzL;
    public boolean dzM;
    public boolean dzN = false;
    public int errCode;
    public String errMsg;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mf
 * JD-Core Version:    0.7.0.1
 */