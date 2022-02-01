package com.tencent.mm.ae;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kt/AndroidPairKTX;", "", "()V", "component1", "K", "V", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a mHs;
  
  static
  {
    AppMethodBeat.i(153442);
    mHs = new a();
    AppMethodBeat.o(153442);
  }
  
  public static <K, V> K a(Pair<K, V> paramPair)
  {
    AppMethodBeat.i(153440);
    s.u(paramPair, "<this>");
    paramPair = paramPair.first;
    AppMethodBeat.o(153440);
    return paramPair;
  }
  
  public static <K, V> V b(Pair<K, V> paramPair)
  {
    AppMethodBeat.i(153441);
    s.u(paramPair, "<this>");
    paramPair = paramPair.second;
    AppMethodBeat.o(153441);
    return paramPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ae.a
 * JD-Core Version:    0.7.0.1
 */