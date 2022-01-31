package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class a$a<T>
{
  private final Set<Class<? super T>> bex;
  private final Set<f> bey;
  private d<T> bez;
  public int zzad;
  
  private a$a(Class<T> paramClass, Class<? super T>... paramVarArgs)
  {
    AppMethodBeat.i(10601);
    this.bex = new HashSet();
    this.bey = new HashSet();
    this.zzad = 0;
    r.zza(paramClass, "Null interface");
    this.bex.add(paramClass);
    int j = paramVarArgs.length;
    while (i < j)
    {
      r.zza(paramVarArgs[i], "Null interface");
      i += 1;
    }
    Collections.addAll(this.bex, paramVarArgs);
    AppMethodBeat.o(10601);
  }
  
  @KeepForSdk
  public final a<T> a(d<T> paramd)
  {
    AppMethodBeat.i(10603);
    this.bez = ((d)r.zza(paramd, "Null factory"));
    AppMethodBeat.o(10603);
    return this;
  }
  
  @KeepForSdk
  public final a<T> a(f paramf)
  {
    AppMethodBeat.i(10602);
    r.zza(paramf, "Null dependency");
    Class localClass = paramf.beA;
    if (!this.bex.contains(localClass)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
      AppMethodBeat.o(10602);
      throw paramf;
    }
    this.bey.add(paramf);
    AppMethodBeat.o(10602);
    return this;
  }
  
  @KeepForSdk
  public final a<T> rI()
  {
    AppMethodBeat.i(10604);
    if (this.bez != null) {}
    for (boolean bool = true;; bool = false)
    {
      r.b(bool, "Missing required property: factory.");
      a locala = new a(new HashSet(this.bex), new HashSet(this.bey), this.zzad, this.bez, (byte)0);
      AppMethodBeat.o(10604);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.firebase.components.a.a
 * JD-Core Version:    0.7.0.1
 */