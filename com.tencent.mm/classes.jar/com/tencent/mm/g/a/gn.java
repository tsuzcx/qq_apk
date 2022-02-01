package com.tencent.mm.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.b.b;

public final class gn
  extends b
{
  public a djH;
  public b djI;
  
  public gn()
  {
    this((byte)0);
  }
  
  private gn(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.djH = new a();
    this.djI = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public long deL;
    public afy djJ;
    public ImageView djK;
    public int djL;
    public boolean djM = false;
    public boolean djN = false;
    public boolean djO = true;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap djP;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gn
 * JD-Core Version:    0.7.0.1
 */