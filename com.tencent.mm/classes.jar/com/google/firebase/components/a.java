package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class a<T>
{
  final Set<Class<? super T>> bCx;
  final Set<f> bCy;
  final d<T> bCz;
  private final int zzad;
  
  private a(Set<Class<? super T>> paramSet, Set<f> paramSet1, int paramInt, d<T> paramd)
  {
    AppMethodBeat.i(4072);
    this.bCx = Collections.unmodifiableSet(paramSet);
    this.bCy = Collections.unmodifiableSet(paramSet1);
    this.zzad = paramInt;
    this.bCz = paramd;
    AppMethodBeat.o(4072);
  }
  
  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(4075);
    paramClass = x(paramClass).a(new j(paramT)).wH();
    AppMethodBeat.o(4075);
    return paramClass;
  }
  
  @KeepForSdk
  public static <T> a<T> x(Class<T> paramClass)
  {
    AppMethodBeat.i(4074);
    paramClass = new a(paramClass, new Class[0], (byte)0);
    AppMethodBeat.o(4074);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4073);
    String str = "Component<" + Arrays.toString(this.bCx.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.bCy.toArray()) + "}";
    AppMethodBeat.o(4073);
    return str;
  }
  
  public final boolean wF()
  {
    return this.zzad == 1;
  }
  
  public final boolean wG()
  {
    return this.zzad == 2;
  }
  
  @KeepForSdk
  public static final class a<T>
  {
    private final Set<Class<? super T>> bCx;
    private final Set<f> bCy;
    private d<T> bCz;
    public int zzad;
    
    private a(Class<T> paramClass, Class<? super T>... paramVarArgs)
    {
      AppMethodBeat.i(4068);
      this.bCx = new HashSet();
      this.bCy = new HashSet();
      this.zzad = 0;
      r.zza(paramClass, "Null interface");
      this.bCx.add(paramClass);
      int j = paramVarArgs.length;
      while (i < j)
      {
        r.zza(paramVarArgs[i], "Null interface");
        i += 1;
      }
      Collections.addAll(this.bCx, paramVarArgs);
      AppMethodBeat.o(4068);
    }
    
    @KeepForSdk
    public final a<T> a(d<T> paramd)
    {
      AppMethodBeat.i(4070);
      this.bCz = ((d)r.zza(paramd, "Null factory"));
      AppMethodBeat.o(4070);
      return this;
    }
    
    @KeepForSdk
    public final a<T> a(f paramf)
    {
      AppMethodBeat.i(4069);
      r.zza(paramf, "Null dependency");
      Class localClass = paramf.bCA;
      if (!this.bCx.contains(localClass)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramf = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        AppMethodBeat.o(4069);
        throw paramf;
      }
      this.bCy.add(paramf);
      AppMethodBeat.o(4069);
      return this;
    }
    
    @KeepForSdk
    public final a<T> wH()
    {
      AppMethodBeat.i(4071);
      if (this.bCz != null) {}
      for (boolean bool = true;; bool = false)
      {
        r.b(bool, "Missing required property: factory.");
        a locala = new a(new HashSet(this.bCx), new HashSet(this.bCy), this.zzad, this.bCz, (byte)0);
        AppMethodBeat.o(4071);
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.a
 * JD-Core Version:    0.7.0.1
 */