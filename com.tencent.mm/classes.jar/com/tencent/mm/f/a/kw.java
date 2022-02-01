package com.tencent.mm.f.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class kw
  extends IEvent
{
  public a fIt;
  public b fIu;
  
  public kw()
  {
    this((byte)0);
  }
  
  private kw(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.fIt = new a();
    this.fIu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public ImageView fIv;
    public ImageView fIw;
    public ProgressBar fIx;
    public int fIy;
    public ca fvt;
    public int h;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.kw
 * JD-Core Version:    0.7.0.1
 */