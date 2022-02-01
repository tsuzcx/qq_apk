package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.sdk.b.b;

public final class fw
  extends b
{
  public a dso;
  public b dsp;
  
  public fw()
  {
    this((byte)0);
  }
  
  private fw(byte paramByte)
  {
    AppMethodBeat.i(116019);
    this.dso = new a();
    this.dsp = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116019);
  }
  
  public static final class a
  {
    public boolean dcN;
    public boolean dsq = false;
    public h.a dsr;
    public h.b dss;
    public String fileName;
    public int op;
  }
  
  public static final class b
  {
    public boolean doq = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fw
 * JD-Core Version:    0.7.0.1
 */