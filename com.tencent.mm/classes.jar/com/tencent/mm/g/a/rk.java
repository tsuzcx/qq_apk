package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rk
  extends b
{
  public a dGe;
  public b dGf;
  
  public rk()
  {
    this((byte)0);
  }
  
  private rk(byte paramByte)
  {
    AppMethodBeat.i(149885);
    this.dGe = new a();
    this.dGf = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149885);
  }
  
  public static final class a
  {
    public Context context;
    public int dFY;
    public Bundle extras;
  }
  
  public static final class b
  {
    public boolean dFV;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rk
 * JD-Core Version:    0.7.0.1
 */