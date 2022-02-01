package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ri
  extends b
{
  public a dFW;
  public b dFX;
  
  public ri()
  {
    this((byte)0);
  }
  
  private ri(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.dFW = new a();
    this.dFX = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149884);
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
 * Qualified Name:     com.tencent.mm.g.a.ri
 * JD-Core Version:    0.7.0.1
 */