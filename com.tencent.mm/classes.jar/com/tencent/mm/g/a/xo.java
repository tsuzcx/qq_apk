package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class xo
  extends b
{
  public a dLQ;
  public b dLR;
  
  public xo()
  {
    this((byte)0);
  }
  
  private xo(byte paramByte)
  {
    AppMethodBeat.i(125651);
    this.dLQ = new a();
    this.dLR = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(125651);
  }
  
  public static final class a
  {
    public n dLS;
  }
  
  public static final class b
  {
    public List dLT;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.xo
 * JD-Core Version:    0.7.0.1
 */