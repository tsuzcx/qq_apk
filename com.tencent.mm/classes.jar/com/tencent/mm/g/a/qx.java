package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qx
  extends b
{
  public a dtW;
  public b dtX;
  
  public qx()
  {
    this((byte)0);
  }
  
  private qx(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.dtW = new a();
    this.dtX = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(149884);
  }
  
  public static final class a
  {
    public Context context;
    public int dtY;
    public Bundle extras;
  }
  
  public static final class b
  {
    public boolean dtV;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qx
 * JD-Core Version:    0.7.0.1
 */