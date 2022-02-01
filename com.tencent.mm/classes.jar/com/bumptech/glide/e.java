package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import com.bumptech.glide.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class e
  extends ContextWrapper
{
  static final k<?, ?> aCF;
  final List<com.bumptech.glide.e.e<Object>> aCD;
  public final boolean aCE;
  private final com.bumptech.glide.e.a.b aCG;
  final com.bumptech.glide.load.b.k aCi;
  public final h aCn;
  public final com.bumptech.glide.load.b.a.b aCo;
  final Map<Class<?>, k<?, ?>> aCt;
  public final int aCy;
  final f aCz;
  
  static
  {
    AppMethodBeat.i(76783);
    aCF = new b();
    AppMethodBeat.o(76783);
  }
  
  public e(Context paramContext, com.bumptech.glide.load.b.a.b paramb, h paramh, com.bumptech.glide.e.a.b paramb1, f paramf, Map<Class<?>, k<?, ?>> paramMap, List<com.bumptech.glide.e.e<Object>> paramList, com.bumptech.glide.load.b.k paramk, boolean paramBoolean, int paramInt)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(204441);
    this.aCo = paramb;
    this.aCn = paramh;
    this.aCG = paramb1;
    this.aCz = paramf;
    this.aCD = paramList;
    this.aCt = paramMap;
    this.aCi = paramk;
    this.aCE = paramBoolean;
    this.aCy = paramInt;
    AppMethodBeat.o(204441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e
 * JD-Core Version:    0.7.0.1
 */