package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.b.b;

public final class qb
  extends b
{
  public a dEw;
  public b dEx;
  
  public qb()
  {
    this((byte)0);
  }
  
  private qb(byte paramByte)
  {
    AppMethodBeat.i(125624);
    this.dEw = new a();
    this.dEx = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(125624);
  }
  
  public static final class a
  {
    public String username;
  }
  
  public static final class b
  {
    public byn dEA;
    public byn dEB;
    public byn dEy;
    public byn dEz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qb
 * JD-Core Version:    0.7.0.1
 */