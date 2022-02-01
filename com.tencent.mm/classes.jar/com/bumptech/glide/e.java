package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.c.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e
  extends ContextWrapper
{
  static final k<?, ?> aAN;
  final Map<Class<?>, k<?, ?>> aAD;
  public final int aAI;
  final com.bumptech.glide.f.e aAJ;
  private final Handler aAO;
  private final com.bumptech.glide.f.a.b aAP;
  final j aAs;
  public final h aAx;
  public final com.bumptech.glide.c.b.a.b aAy;
  
  static
  {
    AppMethodBeat.i(76783);
    aAN = new b();
    AppMethodBeat.o(76783);
  }
  
  public e(Context paramContext, com.bumptech.glide.c.b.a.b paramb, h paramh, com.bumptech.glide.f.a.b paramb1, com.bumptech.glide.f.e parame, Map<Class<?>, k<?, ?>> paramMap, j paramj, int paramInt)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(76782);
    this.aAy = paramb;
    this.aAx = paramh;
    this.aAP = paramb1;
    this.aAJ = parame;
    this.aAD = paramMap;
    this.aAs = paramj;
    this.aAI = paramInt;
    this.aAO = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(76782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.e
 * JD-Core Version:    0.7.0.1
 */