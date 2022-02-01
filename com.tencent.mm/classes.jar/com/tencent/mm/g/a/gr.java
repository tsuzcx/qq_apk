package com.tencent.mm.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.b.b;

public final class gr
  extends b
{
  public a dsA;
  public b dsB;
  
  public gr()
  {
    this((byte)0);
  }
  
  private gr(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.dsA = new a();
    this.dsB = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public long dnC;
    public ajn dsC;
    public ImageView dsD;
    public int dsE;
    public boolean dsF = false;
    public boolean dsG = false;
    public boolean dsH = true;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap dsI;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gr
 * JD-Core Version:    0.7.0.1
 */