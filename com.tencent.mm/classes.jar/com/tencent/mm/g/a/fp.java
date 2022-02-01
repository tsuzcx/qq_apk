package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.b.b;

public final class fp
  extends b
{
  public a dim;
  public b din;
  
  public fp()
  {
    this((byte)0);
  }
  
  private fp(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.dim = new a();
    this.din = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public String dio;
    public int flags;
    public int type;
  }
  
  public static final class b
  {
    public n dip;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.fp
 * JD-Core Version:    0.7.0.1
 */