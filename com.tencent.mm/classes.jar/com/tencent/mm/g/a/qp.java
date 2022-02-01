package com.tencent.mm.g.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.b.b;

public final class qp
  extends b
{
  public a dwm;
  
  public qp()
  {
    this((byte)0);
  }
  
  private qp(byte paramByte)
  {
    AppMethodBeat.i(103547);
    this.dwm = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(103547);
  }
  
  public static final class a
  {
    public byte[] dwn;
    public Rect dwo;
    public int dwp = 90;
    public r dwq;
    public int height = -1;
    public int width = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.qp
 * JD-Core Version:    0.7.0.1
 */