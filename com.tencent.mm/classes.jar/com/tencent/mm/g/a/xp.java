package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xp
  extends b
{
  public a dLU;
  public b dLV;
  
  public xp()
  {
    this((byte)0);
  }
  
  private xp(byte paramByte)
  {
    AppMethodBeat.i(116056);
    this.dLU = new a();
    this.dLV = new b();
    this.IbR = false;
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
    public boolean dLW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.xp
 * JD-Core Version:    0.7.0.1
 */