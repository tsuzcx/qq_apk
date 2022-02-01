package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.b.b;

public final class ft
  extends b
{
  public a drd;
  public b dre;
  
  public ft()
  {
    this((byte)0);
  }
  
  private ft(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.drd = new a();
    this.dre = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public String drf;
    public int flags;
    public int type;
  }
  
  public static final class b
  {
    public n drg;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ft
 * JD-Core Version:    0.7.0.1
 */