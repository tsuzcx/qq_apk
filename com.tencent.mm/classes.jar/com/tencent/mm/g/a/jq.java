package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bu;

public final class jq
  extends b
{
  public a dww;
  public b dwx;
  
  public jq()
  {
    this((byte)0);
  }
  
  private jq(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.dww = new a();
    this.dwx = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public bu dku;
    public ProgressBar dwA;
    public int dwB;
    public ImageView dwy;
    public ImageView dwz;
    public int h;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.jq
 * JD-Core Version:    0.7.0.1
 */