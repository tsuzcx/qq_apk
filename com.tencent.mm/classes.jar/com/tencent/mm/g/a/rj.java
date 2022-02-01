package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rj
  extends b
{
  public a dHc;
  public b dHd;
  
  public rj()
  {
    this((byte)0);
  }
  
  private rj(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.dHc = new a();
    this.dHd = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149884);
  }
  
  public static final class a
  {
    public Context context;
    public int dHe;
    public Bundle extras;
  }
  
  public static final class b
  {
    public boolean dHb;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rj
 * JD-Core Version:    0.7.0.1
 */