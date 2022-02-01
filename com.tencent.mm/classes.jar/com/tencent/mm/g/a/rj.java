package com.tencent.mm.g.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.b.b;

public final class rj
  extends b
{
  public a dFZ;
  
  public rj()
  {
    this((byte)0);
  }
  
  private rj(byte paramByte)
  {
    AppMethodBeat.i(103547);
    this.dFZ = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(103547);
  }
  
  public static final class a
  {
    public byte[] dGa;
    public Rect dGb;
    public int dGc = 90;
    public r dGd;
    public int height = -1;
    public int width = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.rj
 * JD-Core Version:    0.7.0.1
 */