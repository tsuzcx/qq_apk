package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fv
  extends b
{
  public a dfU;
  public b dfV;
  
  public fv()
  {
    this((byte)0);
  }
  
  private fv(byte paramByte)
  {
    AppMethodBeat.i(116021);
    this.dfU = new a();
    this.dfV = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(116021);
  }
  
  public static final class a
  {
    public Runnable cLX;
    public int duration;
    public String filePath;
    public int op;
  }
  
  public static final class b
  {
    public boolean dbS = false;
    public int dfW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fv
 * JD-Core Version:    0.7.0.1
 */