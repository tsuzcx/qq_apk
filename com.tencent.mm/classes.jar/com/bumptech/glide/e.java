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
  static final k<?, ?> azT;
  public final h azD;
  public final com.bumptech.glide.c.b.a.b azE;
  final Map<Class<?>, k<?, ?>> azJ;
  public final int azO;
  final com.bumptech.glide.f.e azP;
  private final Handler azU;
  private final com.bumptech.glide.f.a.b azV;
  final j azy;
  
  static
  {
    AppMethodBeat.i(76783);
    azT = new b();
    AppMethodBeat.o(76783);
  }
  
  public e(Context paramContext, com.bumptech.glide.c.b.a.b paramb, h paramh, com.bumptech.glide.f.a.b paramb1, com.bumptech.glide.f.e parame, Map<Class<?>, k<?, ?>> paramMap, j paramj, int paramInt)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(76782);
    this.azE = paramb;
    this.azD = paramh;
    this.azV = paramb1;
    this.azP = parame;
    this.azJ = paramMap;
    this.azy = paramj;
    this.azO = paramInt;
    this.azU = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(76782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e
 * JD-Core Version:    0.7.0.1
 */