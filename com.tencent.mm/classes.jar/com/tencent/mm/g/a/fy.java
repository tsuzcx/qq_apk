package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fy
  extends b
{
  public a drq;
  public b drr;
  
  public fy()
  {
    this((byte)0);
  }
  
  private fy(byte paramByte)
  {
    AppMethodBeat.i(116021);
    this.drq = new a();
    this.drr = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116021);
  }
  
  public static final class a
  {
    public Runnable cXl;
    public int duration;
    public String filePath;
    public int op;
  }
  
  public static final class b
  {
    public boolean dno = false;
    public int drs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fy
 * JD-Core Version:    0.7.0.1
 */