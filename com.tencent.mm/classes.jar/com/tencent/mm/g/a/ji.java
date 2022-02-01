package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bo;

public final class ji
  extends b
{
  public a dkJ;
  public b dkK;
  
  public ji()
  {
    this((byte)0);
  }
  
  private ji(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.dkJ = new a();
    this.dkK = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public bo cZc;
    public ImageView dkL;
    public ImageView dkM;
    public ProgressBar dkN;
    public int dkO;
    public int h;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ji
 * JD-Core Version:    0.7.0.1
 */