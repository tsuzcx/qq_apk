package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class xs
  extends b
{
  public a dNf;
  public b dNg;
  
  public xs()
  {
    this((byte)0);
  }
  
  private xs(byte paramByte)
  {
    AppMethodBeat.i(125651);
    this.dNf = new a();
    this.dNg = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(125651);
  }
  
  public static final class a
  {
    public n dNh;
  }
  
  public static final class b
  {
    public List dNi;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.xs
 * JD-Core Version:    0.7.0.1
 */