package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class wk
  extends b
{
  public a dBQ;
  public b dBR;
  
  public wk()
  {
    this((byte)0);
  }
  
  private wk(byte paramByte)
  {
    AppMethodBeat.i(125651);
    this.dBQ = new a();
    this.dBR = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(125651);
  }
  
  public static final class a
  {
    public n dBS;
  }
  
  public static final class b
  {
    public List dBT;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.wk
 * JD-Core Version:    0.7.0.1
 */