package com.tencent.mm.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.b.b;

public final class gs
  extends b
{
  public a dtG;
  public b dtH;
  
  public gs()
  {
    this((byte)0);
  }
  
  private gs(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.dtG = new a();
    this.dtH = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public long doH;
    public ajx dtI;
    public ImageView dtJ;
    public int dtK;
    public boolean dtL = false;
    public boolean dtM = false;
    public boolean dtN = true;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap dtO;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gs
 * JD-Core Version:    0.7.0.1
 */