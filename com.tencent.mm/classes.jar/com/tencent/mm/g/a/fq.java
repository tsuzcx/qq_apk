package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.b.b;

public final class fq
  extends b
{
  public a dfH;
  public b dfI;
  
  public fq()
  {
    this((byte)0);
  }
  
  private fq(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.dfH = new a();
    this.dfI = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public String dfJ;
    public int flags;
    public int type;
  }
  
  public static final class b
  {
    public n dfK;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fq
 * JD-Core Version:    0.7.0.1
 */