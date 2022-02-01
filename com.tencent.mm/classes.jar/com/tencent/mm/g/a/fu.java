package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.b.b;

public final class fu
  extends b
{
  public a dsi;
  public b dsj;
  
  public fu()
  {
    this((byte)0);
  }
  
  private fu(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.dsi = new a();
    this.dsj = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public String dsk;
    public int flags;
    public int type;
  }
  
  public static final class b
  {
    public n dsl;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fu
 * JD-Core Version:    0.7.0.1
 */