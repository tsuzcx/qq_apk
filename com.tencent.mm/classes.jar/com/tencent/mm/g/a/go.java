package com.tencent.mm.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.b.b;

public final class go
  extends b
{
  public a dhc;
  public b dhd;
  
  public go()
  {
    this((byte)0);
  }
  
  private go(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.dhc = new a();
    this.dhd = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public long dcg;
    public agx dhe;
    public ImageView dhf;
    public int dhg;
    public boolean dhh = false;
    public boolean dhi = false;
    public boolean dhj = true;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap dhk;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.go
 * JD-Core Version:    0.7.0.1
 */