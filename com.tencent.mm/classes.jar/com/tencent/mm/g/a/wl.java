package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class wl
  extends b
{
  public a dBU;
  public b dBV;
  
  public wl()
  {
    this((byte)0);
  }
  
  private wl(byte paramByte)
  {
    AppMethodBeat.i(116056);
    this.dBU = new a();
    this.dBV = new b();
    this.ESR = false;
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
    public boolean dBW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.wl
 * JD-Core Version:    0.7.0.1
 */