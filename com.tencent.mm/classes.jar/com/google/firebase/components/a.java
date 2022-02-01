package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a<T>
{
  final Set<Class<? super T>> dBW;
  final Set<f> dBX;
  final d<T> dBY;
  private final int zzad;
  
  private a(Set<Class<? super T>> paramSet, Set<f> paramSet1, int paramInt, d<T> paramd)
  {
    AppMethodBeat.i(4072);
    this.dBW = Collections.unmodifiableSet(paramSet);
    this.dBX = Collections.unmodifiableSet(paramSet1);
    this.zzad = paramInt;
    this.dBY = paramd;
    AppMethodBeat.o(4072);
  }
  
  public static <T> a<T> a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(4075);
    paramClass = w(paramClass).a(new j(paramT)).Ye();
    AppMethodBeat.o(4075);
    return paramClass;
  }
  
  public static <T> a<T> w(Class<T> paramClass)
  {
    AppMethodBeat.i(4074);
    paramClass = new a(paramClass, new Class[0], (byte)0);
    AppMethodBeat.o(4074);
    return paramClass;
  }
  
  public final boolean Yc()
  {
    return this.zzad == 1;
  }
  
  public final boolean Yd()
  {
    return this.zzad == 2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4073);
    String str = "Component<" + Arrays.toString(this.dBW.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.dBX.toArray()) + "}";
    AppMethodBeat.o(4073);
    return str;
  }
  
  public static final class a<T>
  {
    private final Set<Class<? super T>> dBW;
    private final Set<f> dBX;
    private d<T> dBY;
    public int zzad;
    
    private a(Class<T> paramClass, Class<? super T>... paramVarArgs)
    {
      AppMethodBeat.i(4068);
      this.dBW = new HashSet();
      this.dBX = new HashSet();
      this.zzad = 0;
      r.zza(paramClass, "Null interface");
      this.dBW.add(paramClass);
      int j = paramVarArgs.length;
      while (i < j)
      {
        r.zza(paramVarArgs[i], "Null interface");
        i += 1;
      }
      Collections.addAll(this.dBW, paramVarArgs);
      AppMethodBeat.o(4068);
    }
    
    public final a<T> Ye()
    {
      AppMethodBeat.i(4071);
      if (this.dBY != null) {}
      for (boolean bool = true;; bool = false)
      {
        r.b(bool, "Missing required property: factory.");
        a locala = new a(new HashSet(this.dBW), new HashSet(this.dBX), this.zzad, this.dBY, (byte)0);
        AppMethodBeat.o(4071);
        return locala;
      }
    }
    
    public final a<T> a(d<T> paramd)
    {
      AppMethodBeat.i(4070);
      this.dBY = ((d)r.zza(paramd, "Null factory"));
      AppMethodBeat.o(4070);
      return this;
    }
    
    public final a<T> a(f paramf)
    {
      AppMethodBeat.i(4069);
      r.zza(paramf, "Null dependency");
      Class localClass = paramf.dBZ;
      if (!this.dBW.contains(localClass)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramf = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        AppMethodBeat.o(4069);
        throw paramf;
      }
      this.dBX.add(paramf);
      AppMethodBeat.o(4069);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.a
 * JD-Core Version:    0.7.0.1
 */