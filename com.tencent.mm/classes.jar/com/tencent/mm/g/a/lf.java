package com.tencent.mm.g.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.b.b;

public final class lf
  extends b
{
  public a dyv;
  public b dyw;
  
  public lf()
  {
    this((byte)0);
  }
  
  private lf(byte paramByte)
  {
    AppMethodBeat.i(127406);
    this.dyv = new a();
    this.dyw = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(127406);
  }
  
  public static final class a
  {
    public n dor;
    public float dyA = 0.0F;
    public int dyB = 0;
    public int dyx = 0;
    public String dyy;
    public float dyz = 0.0F;
    public String filename;
    public int height = 0;
    public View view;
    public int width = 0;
  }
  
  public static final class b
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.lf
 * JD-Core Version:    0.7.0.1
 */