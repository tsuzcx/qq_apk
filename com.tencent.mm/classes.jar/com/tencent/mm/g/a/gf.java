package com.tencent.mm.g.a;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.b.b;

public final class gf
  extends b
{
  public a cuJ;
  public gf.b cuK;
  
  public gf()
  {
    this((byte)0);
  }
  
  private gf(byte paramByte)
  {
    AppMethodBeat.i(51336);
    this.cuJ = new a();
    this.cuK = new gf.b();
    this.ymq = false;
    this.callback = null;
    AppMethodBeat.o(51336);
  }
  
  public static final class a
  {
    public Context context;
    public long cpM;
    public aca cuL;
    public ImageView cuM;
    public int cuN;
    public boolean cuO = false;
    public boolean cuP = false;
    public boolean cuQ = true;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.gf
 * JD-Core Version:    0.7.0.1
 */