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
  final Set<Class<? super T>> bKJ;
  final Set<f> bKK;
  final d<T> bKL;
  private final int zzad;
  
  private a(Set<Class<? super T>> paramSet, Set<f> paramSet1, int paramInt, d<T> paramd)
  {
    AppMethodBeat.i(4072);
    this.bKJ = Collections.unmodifiableSet(paramSet);
    this.bKK = Collections.unmodifiableSet(paramSet1);
    this.zzad = paramInt;
    this.bKL = paramd;
    AppMethodBeat.o(4072);
  }
  
  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(4075);
    paramClass = z(paramClass).a(new j(paramT)).xZ();
    AppMethodBeat.o(4075);
    return paramClass;
  }
  
  @KeepForSdk
  public static <T> a<T> z(Class<T> paramClass)
  {
    AppMethodBeat.i(4074);
    paramClass = new a(paramClass, new Class[0], (byte)0);
    AppMethodBeat.o(4074);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4073);
    String str = "Component<" + Arrays.toString(this.bKJ.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.bKK.toArray()) + "}";
    AppMethodBeat.o(4073);
    return str;
  }
  
  public final boolean xX()
  {
    return this.zzad == 1;
  }
  
  public final boolean xY()
  {
    return this.zzad == 2;
  }
  
  @KeepForSdk
  public static final class a<T>
  {
    private final Set<Class<? super T>> bKJ;
    private final Set<f> bKK;
    private d<T> bKL;
    public int zzad;
    
    private a(Class<T> paramClass, Class<? super T>... paramVarArgs)
    {
      AppMethodBeat.i(4068);
      this.bKJ = new HashSet();
      this.bKK = new HashSet();
      this.zzad = 0;
      r.zza(paramClass, "Null interface");
      this.bKJ.add(paramClass);
      int j = paramVarArgs.length;
      while (i < j)
      {
        r.zza(paramVarArgs[i], "Null interface");
        i += 1;
      }
      Collections.addAll(this.bKJ, paramVarArgs);
      AppMethodBeat.o(4068);
    }
    
    @KeepForSdk
    public final a<T> a(d<T> paramd)
    {
      AppMethodBeat.i(4070);
      this.bKL = ((d)r.zza(paramd, "Null factory"));
      AppMethodBeat.o(4070);
      return this;
    }
    
    @KeepForSdk
    public final a<T> a(f paramf)
    {
      AppMethodBeat.i(4069);
      r.zza(paramf, "Null dependency");
      Class localClass = paramf.bKM;
      if (!this.bKJ.contains(localClass)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramf = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        AppMethodBeat.o(4069);
        throw paramf;
      }
      this.bKK.add(paramf);
      AppMethodBeat.o(4069);
      return this;
    }
    
    @KeepForSdk
    public final a<T> xZ()
    {
      AppMethodBeat.i(4071);
      if (this.bKL != null) {}
      for (boolean bool = true;; bool = false)
      {
        r.b(bool, "Missing required property: factory.");
        a locala = new a(new HashSet(this.bKJ), new HashSet(this.bKK), this.zzad, this.bKL, (byte)0);
        AppMethodBeat.o(4071);
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.components.a
 * JD-Core Version:    0.7.0.1
 */