package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends f
{
  public a()
  {
    super(null);
  }
  
  public a(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramHandler, paramInt1, paramInt2, paramInt3);
  }
  
  protected final int q(Uri paramUri)
  {
    AppMethodBeat.i(234963);
    i locali = i.mCD;
    int i = i.r(paramUri);
    AppMethodBeat.o(234963);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a
 * JD-Core Version:    0.7.0.1
 */