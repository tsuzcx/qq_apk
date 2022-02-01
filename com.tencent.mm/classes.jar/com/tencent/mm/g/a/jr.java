package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bv;

public final class jr
  extends b
{
  public a dxB;
  public b dxC;
  
  public jr()
  {
    this((byte)0);
  }
  
  private jr(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.dxB = new a();
    this.dxC = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public bv dlw;
    public ImageView dxD;
    public ImageView dxE;
    public ProgressBar dxF;
    public int dxG;
    public int h;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.jr
 * JD-Core Version:    0.7.0.1
 */