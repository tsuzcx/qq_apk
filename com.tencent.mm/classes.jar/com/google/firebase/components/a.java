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
  final Set<Class<? super T>> bIo;
  final Set<f> bIp;
  final d<T> bIq;
  private final int zzad;
  
  private a(Set<Class<? super T>> paramSet, Set<f> paramSet1, int paramInt, d<T> paramd)
  {
    AppMethodBeat.i(4072);
    this.bIo = Collections.unmodifiableSet(paramSet);
    this.bIp = Collections.unmodifiableSet(paramSet1);
    this.zzad = paramInt;
    this.bIq = paramd;
    AppMethodBeat.o(4072);
  }
  
  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(4075);
    paramClass = n(paramClass).a(new j(paramT)).yt();
    AppMethodBeat.o(4075);
    return paramClass;
  }
  
  @KeepForSdk
  public static <T> a<T> n(Class<T> paramClass)
  {
    AppMethodBeat.i(4074);
    paramClass = new a(paramClass, new Class[0], (byte)0);
    AppMethodBeat.o(4074);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4073);
    String str = "Component<" + Arrays.toString(this.bIo.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.bIp.toArray()) + "}";
    AppMethodBeat.o(4073);
    return str;
  }
  
  public final boolean yr()
  {
    return this.zzad == 1;
  }
  
  public final boolean ys()
  {
    return this.zzad == 2;
  }
  
  @KeepForSdk
  public static final class a<T>
  {
    private final Set<Class<? super T>> bIo;
    private final Set<f> bIp;
    private d<T> bIq;
    public int zzad;
    
    private a(Class<T> paramClass, Class<? super T>... paramVarArgs)
    {
      AppMethodBeat.i(4068);
      this.bIo = new HashSet();
      this.bIp = new HashSet();
      this.zzad = 0;
      r.zza(paramClass, "Null interface");
      this.bIo.add(paramClass);
      int j = paramVarArgs.length;
      while (i < j)
      {
        r.zza(paramVarArgs[i], "Null interface");
        i += 1;
      }
      Collections.addAll(this.bIo, paramVarArgs);
      AppMethodBeat.o(4068);
    }
    
    @KeepForSdk
    public final a<T> a(d<T> paramd)
    {
      AppMethodBeat.i(4070);
      this.bIq = ((d)r.zza(paramd, "Null factory"));
      AppMethodBeat.o(4070);
      return this;
    }
    
    @KeepForSdk
    public final a<T> a(f paramf)
    {
      AppMethodBeat.i(4069);
      r.zza(paramf, "Null dependency");
      Class localClass = paramf.bIr;
      if (!this.bIo.contains(localClass)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramf = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        AppMethodBeat.o(4069);
        throw paramf;
      }
      this.bIp.add(paramf);
      AppMethodBeat.o(4069);
      return this;
    }
    
    @KeepForSdk
    public final a<T> yt()
    {
      AppMethodBeat.i(4071);
      if (this.bIq != null) {}
      for (boolean bool = true;; bool = false)
      {
        r.c(bool, "Missing required property: factory.");
        a locala = new a(new HashSet(this.bIo), new HashSet(this.bIp), this.zzad, this.bIq, (byte)0);
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