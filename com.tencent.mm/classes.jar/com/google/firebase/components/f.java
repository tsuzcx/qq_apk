package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class f
{
  final Class<?> bAi;
  final int bAj;
  private final int bAk;
  
  private f(Class<?> paramClass)
  {
    AppMethodBeat.i(4077);
    this.bAi = ((Class)r.zza(paramClass, "Null dependency interface."));
    this.bAj = 1;
    this.bAk = 0;
    AppMethodBeat.o(4077);
  }
  
  @KeepForSdk
  public static f z(Class<?> paramClass)
  {
    AppMethodBeat.i(4078);
    paramClass = new f(paramClass);
    AppMethodBeat.o(4078);
    return paramClass;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      bool1 = bool2;
      if (this.bAi == paramObject.bAi)
      {
        bool1 = bool2;
        if (this.bAj == paramObject.bAj)
        {
          bool1 = bool2;
          if (this.bAk == paramObject.bAk) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4079);
    int i = this.bAi.hashCode();
    int j = this.bAj;
    int k = this.bAk;
    AppMethodBeat.o(4079);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final String toString()
  {
    boolean bool2 = true;
    AppMethodBeat.i(4080);
    Object localObject = new StringBuilder("Dependency{interface=").append(this.bAi).append(", required=");
    if (this.bAj == 1)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", direct=");
      if (this.bAk != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = bool1 + "}";
      AppMethodBeat.o(4080);
      return localObject;
      bool1 = false;
      break;
    }
  }
  
  public final boolean wv()
  {
    return this.bAk == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.f
 * JD-Core Version:    0.7.0.1
 */