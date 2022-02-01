package com.bumptech.glide.load.b.d;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private final e aCj;
  private final h aCk;
  private final b aJD;
  private final Handler handler;
  
  public a(h paramh, e parame, b paramb)
  {
    AppMethodBeat.i(77198);
    this.handler = new Handler(Looper.getMainLooper());
    this.aCk = paramh;
    this.aCj = parame;
    this.aJD = paramb;
    AppMethodBeat.o(77198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.d.a
 * JD-Core Version:    0.7.0.1
 */