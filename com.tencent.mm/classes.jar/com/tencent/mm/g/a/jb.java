package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bl;

public final class jb
  extends b
{
  public a dnb;
  public b dnc;
  
  public jb()
  {
    this((byte)0);
  }
  
  private jb(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.dnb = new a();
    this.dnc = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public bl dbD;
    public ImageView dnd;
    public ImageView dne;
    public ProgressBar dnf;
    public int dng;
    public int h;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.jb
 * JD-Core Version:    0.7.0.1
 */