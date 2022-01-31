package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
public final class a<T>
{
  final Set<Class<? super T>> bex;
  final Set<f> bey;
  final d<T> bez;
  private final int zzad;
  
  private a(Set<Class<? super T>> paramSet, Set<f> paramSet1, int paramInt, d<T> paramd)
  {
    AppMethodBeat.i(10605);
    this.bex = Collections.unmodifiableSet(paramSet);
    this.bey = Collections.unmodifiableSet(paramSet1);
    this.zzad = paramInt;
    this.bez = paramd;
    AppMethodBeat.o(10605);
  }
  
  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(10608);
    paramClass = n(paramClass).a(new j(paramT)).rI();
    AppMethodBeat.o(10608);
    return paramClass;
  }
  
  @KeepForSdk
  public static <T> a.a<T> n(Class<T> paramClass)
  {
    AppMethodBeat.i(10607);
    paramClass = new a.a(paramClass, new Class[0], (byte)0);
    AppMethodBeat.o(10607);
    return paramClass;
  }
  
  public final boolean rG()
  {
    return this.zzad == 1;
  }
  
  public final boolean rH()
  {
    return this.zzad == 2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(10606);
    String str = "Component<" + Arrays.toString(this.bex.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.bey.toArray()) + "}";
    AppMethodBeat.o(10606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.a
 * JD-Core Version:    0.7.0.1
 */