package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class f
{
  final Class<?> beA;
  final int beB;
  private final int beC;
  
  private f(Class<?> paramClass)
  {
    AppMethodBeat.i(10610);
    this.beA = ((Class)r.zza(paramClass, "Null dependency interface."));
    this.beB = 1;
    this.beC = 0;
    AppMethodBeat.o(10610);
  }
  
  @KeepForSdk
  public static f p(Class<?> paramClass)
  {
    AppMethodBeat.i(10611);
    paramClass = new f(paramClass);
    AppMethodBeat.o(10611);
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
      if (this.beA == paramObject.beA)
      {
        bool1 = bool2;
        if (this.beB == paramObject.beB)
        {
          bool1 = bool2;
          if (this.beC == paramObject.beC) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(10612);
    int i = this.beA.hashCode();
    int j = this.beB;
    int k = this.beC;
    AppMethodBeat.o(10612);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final boolean rJ()
  {
    return this.beC == 0;
  }
  
  public final String toString()
  {
    boolean bool2 = true;
    AppMethodBeat.i(10613);
    Object localObject = new StringBuilder("Dependency{interface=").append(this.beA).append(", required=");
    if (this.beB == 1)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", direct=");
      if (this.beC != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = bool1 + "}";
      AppMethodBeat.o(10613);
      return localObject;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.components.f
 * JD-Core Version:    0.7.0.1
 */