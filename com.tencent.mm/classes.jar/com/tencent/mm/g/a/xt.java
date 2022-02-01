package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xt
  extends b
{
  public a dNj;
  public b dNk;
  
  public xt()
  {
    this((byte)0);
  }
  
  private xt(byte paramByte)
  {
    AppMethodBeat.i(116056);
    this.dNj = new a();
    this.dNk = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116056);
  }
  
  public static final class a
  {
    public Context context;
    public int type;
  }
  
  public static final class b
  {
    public boolean dNl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.xt
 * JD-Core Version:    0.7.0.1
 */