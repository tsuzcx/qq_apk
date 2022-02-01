package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mz
  extends b
{
  public a dAU;
  
  public mz()
  {
    this((byte)0);
  }
  
  private mz(byte paramByte)
  {
    AppMethodBeat.i(89647);
    this.dAU = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(89647);
  }
  
  public static final class a
  {
    public Context context;
    public String group;
    public Intent intent;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mz
 * JD-Core Version:    0.7.0.1
 */