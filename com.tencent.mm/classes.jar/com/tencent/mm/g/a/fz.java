package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fz
  extends b
{
  public a dsw;
  public b dsx;
  
  public fz()
  {
    this((byte)0);
  }
  
  private fz(byte paramByte)
  {
    AppMethodBeat.i(116021);
    this.dsw = new a();
    this.dsx = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116021);
  }
  
  public static final class a
  {
    public Runnable cYi;
    public int duration;
    public String filePath;
    public int op;
  }
  
  public static final class b
  {
    public boolean doq = false;
    public int dsy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fz
 * JD-Core Version:    0.7.0.1
 */