package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fy
  extends b
{
  public a dgj;
  public b dgk;
  
  public fy()
  {
    this((byte)0);
  }
  
  private fy(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.dgj = new a();
    this.dgk = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String dgl;
    public int dgm = 0;
    public Runnable dgn;
    public String fileName;
    public int from = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean bhH;
    public String content;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fy
 * JD-Core Version:    0.7.0.1
 */