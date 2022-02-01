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
  final Set<Class<? super T>> bKt;
  final Set<f> bKu;
  final d<T> bKv;
  private final int zzad;
  
  private a(Set<Class<? super T>> paramSet, Set<f> paramSet1, int paramInt, d<T> paramd)
  {
    AppMethodBeat.i(4072);
    this.bKt = Collections.unmodifiableSet(paramSet);
    this.bKu = Collections.unmodifiableSet(paramSet1);
    this.zzad = paramInt;
    this.bKv = paramd;
    AppMethodBeat.o(4072);
  }
  
  @KeepForSdk
  public static <T> a<T> a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(4075);
    paramClass = x(paramClass).a(new j(paramT)).xR();
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
    String str = "Component<" + Arrays.toString(this.bKt.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.bKu.toArray()) + "}";
    AppMethodBeat.o(4073);
    return str;
  }
  
  public final boolean xP()
  {
    return this.zzad == 1;
  }
  
  public final boolean xQ()
  {
    return this.zzad == 2;
  }
  
  @KeepForSdk
  public static final class a<T>
  {
    private final Set<Class<? super T>> bKt;
    private final Set<f> bKu;
    private d<T> bKv;
    public int zzad;
    
    private a(Class<T> paramClass, Class<? super T>... paramVarArgs)
    {
      AppMethodBeat.i(4068);
      this.bKt = new HashSet();
      this.bKu = new HashSet();
      this.zzad = 0;
      r.zza(paramClass, "Null interface");
      this.bKt.add(paramClass);
      int j = paramVarArgs.length;
      while (i < j)
      {
        r.zza(paramVarArgs[i], "Null interface");
        i += 1;
      }
      Collections.addAll(this.bKt, paramVarArgs);
      AppMethodBeat.o(4068);
    }
    
    @KeepForSdk
    public final a<T> a(d<T> paramd)
    {
      AppMethodBeat.i(4070);
      this.bKv = ((d)r.zza(paramd, "Null factory"));
      AppMethodBeat.o(4070);
      return this;
    }
    
    @KeepForSdk
    public final a<T> a(f paramf)
    {
      AppMethodBeat.i(4069);
      r.zza(paramf, "Null dependency");
      Class localClass = paramf.bKw;
      if (!this.bKt.contains(localClass)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramf = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        AppMethodBeat.o(4069);
        throw paramf;
      }
      this.bKu.add(paramf);
      AppMethodBeat.o(4069);
      return this;
    }
    
    @KeepForSdk
    public final a<T> xR()
    {
      AppMethodBeat.i(4071);
      if (this.bKv != null) {}
      for (boolean bool = true;; bool = false)
      {
        r.b(bool, "Missing required property: factory.");
        a locala = new a(new HashSet(this.bKt), new HashSet(this.bKu), this.zzad, this.bKv, (byte)0);
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