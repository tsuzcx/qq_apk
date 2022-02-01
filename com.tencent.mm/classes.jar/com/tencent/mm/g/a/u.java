package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;

public final class u
{
  public Runnable callback;
  public a dbH;
  public b dbI;
  
  public u()
  {
    this((byte)0);
  }
  
  private u(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.dbH = new a();
    this.dbI = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String cTr;
    public int dbJ;
    public b dbK;
    public a dbL;
    public String processName;
  }
  
  public static final class b
  {
    public int count;
    public d dbM;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.u
 * JD-Core Version:    0.7.0.1
 */