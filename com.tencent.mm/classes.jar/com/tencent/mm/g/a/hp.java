package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class hp
  extends b
{
  public a dll;
  public b dlm;
  
  public hp()
  {
    this((byte)0);
  }
  
  private hp(byte paramByte)
  {
    AppMethodBeat.i(89640);
    this.dll = new a();
    this.dlm = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(89640);
  }
  
  public static final class a
  {
    public int BX = 0;
    public Context context;
    public String dln;
  }
  
  public static final class b
  {
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.hp
 * JD-Core Version:    0.7.0.1
 */