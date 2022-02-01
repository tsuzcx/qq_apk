package com.tencent.mm.ac;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/kt/AndroidPairKTX;", "", "()V", "component1", "K", "V", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "libktcomm_release"})
public final class a
{
  public static final a glZ;
  
  static
  {
    AppMethodBeat.i(153442);
    glZ = new a();
    AppMethodBeat.o(153442);
  }
  
  public static <K, V> K a(Pair<K, V> paramPair)
  {
    AppMethodBeat.i(153440);
    k.h(paramPair, "$this$component1");
    paramPair = paramPair.first;
    AppMethodBeat.o(153440);
    return paramPair;
  }
  
  public static <K, V> V b(Pair<K, V> paramPair)
  {
    AppMethodBeat.i(153441);
    k.h(paramPair, "$this$component2");
    paramPair = paramPair.second;
    AppMethodBeat.o(153441);
    return paramPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.a
 * JD-Core Version:    0.7.0.1
 */