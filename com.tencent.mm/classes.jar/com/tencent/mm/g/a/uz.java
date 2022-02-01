package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class uz
  extends b
{
  public a dxT;
  public b dxU;
  
  public uz()
  {
    this((byte)0);
  }
  
  private uz(byte paramByte)
  {
    AppMethodBeat.i(153018);
    this.dxT = new a();
    this.dxU = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(153018);
  }
  
  public static final class a
  {
    public Activity dgE;
    public Intent dxV;
    public int requestCode;
  }
  
  public static final class b
  {
    public boolean deB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.uz
 * JD-Core Version:    0.7.0.1
 */