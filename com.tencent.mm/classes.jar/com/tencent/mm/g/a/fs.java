package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.sdk.b.b;

public final class fs
  extends b
{
  public a dfN;
  public b dfO;
  
  public fs()
  {
    this((byte)0);
  }
  
  private fs(byte paramByte)
  {
    AppMethodBeat.i(116019);
    this.dfN = new a();
    this.dfO = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(116019);
  }
  
  public static final class a
  {
    public boolean cQv;
    public boolean dfP = false;
    public i.a dfQ;
    public i.b dfR;
    public String fileName;
    public int op;
  }
  
  public static final class b
  {
    public boolean dbS = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fs
 * JD-Core Version:    0.7.0.1
 */