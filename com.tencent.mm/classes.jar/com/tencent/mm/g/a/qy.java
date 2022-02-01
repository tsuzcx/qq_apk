package com.tencent.mm.g.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.b.b;

public final class qy
  extends b
{
  public a dtZ;
  
  public qy()
  {
    this((byte)0);
  }
  
  private qy(byte paramByte)
  {
    AppMethodBeat.i(103547);
    this.dtZ = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(103547);
  }
  
  public static final class a
  {
    public byte[] dua;
    public Rect dub;
    public int duc = 90;
    public r dud;
    public int height = -1;
    public int width = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.qy
 * JD-Core Version:    0.7.0.1
 */