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
  static final k<?, ?> aCE;
  final com.bumptech.glide.f.e aCA;
  private final Handler aCF;
  private final com.bumptech.glide.f.a.b aCG;
  final j aCj;
  public final h aCo;
  public final com.bumptech.glide.c.b.a.b aCp;
  final Map<Class<?>, k<?, ?>> aCu;
  public final int aCz;
  
  static
  {
    AppMethodBeat.i(76783);
    aCE = new b();
    AppMethodBeat.o(76783);
  }
  
  public e(Context paramContext, com.bumptech.glide.c.b.a.b paramb, h paramh, com.bumptech.glide.f.a.b paramb1, com.bumptech.glide.f.e parame, Map<Class<?>, k<?, ?>> paramMap, j paramj, int paramInt)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(76782);
    this.aCp = paramb;
    this.aCo = paramh;
    this.aCG = paramb1;
    this.aCA = parame;
    this.aCu = paramMap;
    this.aCj = paramj;
    this.aCz = paramInt;
    this.aCF = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(76782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.e
 * JD-Core Version:    0.7.0.1
 */