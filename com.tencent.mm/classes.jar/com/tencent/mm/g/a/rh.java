package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rh
  extends b
{
  public a dGV;
  
  public rh()
  {
    this((byte)0);
  }
  
  private rh(byte paramByte)
  {
    AppMethodBeat.i(91217);
    this.dGV = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(91217);
  }
  
  public static final class a
  {
    public Context context;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rh
 * JD-Core Version:    0.7.0.1
 */