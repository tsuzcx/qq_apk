package com.tencent.mm.autogen.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.cc;

public final class ma
  extends IEvent
{
  public a hNT;
  public b hNU;
  
  public ma()
  {
    this((byte)0);
  }
  
  private ma(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.hNT = new a();
    this.hNU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public int h;
    public ImageView hNV;
    public ImageView hNW;
    public ProgressBar hNX;
    public int hNY;
    public cc hzO;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ma
 * JD-Core Version:    0.7.0.1
 */