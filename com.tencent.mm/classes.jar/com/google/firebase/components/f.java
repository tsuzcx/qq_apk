package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class f
{
  final Class<?> bKM;
  final int bKN;
  private final int bKO;
  
  private f(Class<?> paramClass)
  {
    AppMethodBeat.i(4077);
    this.bKM = ((Class)r.zza(paramClass, "Null dependency interface."));
    this.bKN = 1;
    this.bKO = 0;
    AppMethodBeat.o(4077);
  }
  
  @KeepForSdk
  public static f B(Class<?> paramClass)
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
      if (this.bKM == paramObject.bKM)
      {
        bool1 = bool2;
        if (this.bKN == paramObject.bKN)
        {
          bool1 = bool2;
          if (this.bKO == paramObject.bKO) {
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
    int i = this.bKM.hashCode();
    int j = this.bKN;
    int k = this.bKO;
    AppMethodBeat.o(4079);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final String toString()
  {
    boolean bool2 = true;
    AppMethodBeat.i(4080);
    Object localObject = new StringBuilder("Dependency{interface=").append(this.bKM).append(", required=");
    if (this.bKN == 1)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", direct=");
      if (this.bKO != 0) {
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
  
  public final boolean ya()
  {
    return this.bKO == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.components.f
 * JD-Core Version:    0.7.0.1
 */