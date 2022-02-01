package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;

public final class x
{
  public Runnable callback;
  public a dCQ;
  public b dCR;
  
  public x()
  {
    this((byte)0);
  }
  
  private x(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.dCQ = new a();
    this.dCR = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int dCS;
    public b dCT;
    public a dCU;
    public String dtX;
    public String processName;
  }
  
  public static final class b
  {
    public int count;
    public a dCU;
    public d dCV;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.x
 * JD-Core Version:    0.7.0.1
 */