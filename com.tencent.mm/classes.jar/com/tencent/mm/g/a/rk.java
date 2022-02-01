package com.tencent.mm.g.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.b.b;

public final class rk
  extends b
{
  public a dHf;
  
  public rk()
  {
    this((byte)0);
  }
  
  private rk(byte paramByte)
  {
    AppMethodBeat.i(103547);
    this.dHf = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(103547);
  }
  
  public static final class a
  {
    public byte[] dHg;
    public Rect dHh;
    public int dHi = 90;
    public r dHj;
    public int height = -1;
    public int width = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rk
 * JD-Core Version:    0.7.0.1
 */