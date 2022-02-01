package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  final Class<?> dBZ;
  final int dCa;
  private final int dCb;
  
  private f(Class<?> paramClass)
  {
    AppMethodBeat.i(4077);
    this.dBZ = ((Class)r.zza(paramClass, "Null dependency interface."));
    this.dCa = 1;
    this.dCb = 0;
    AppMethodBeat.o(4077);
  }
  
  public static f y(Class<?> paramClass)
  {
    AppMethodBeat.i(4078);
    paramClass = new f(paramClass);
    AppMethodBeat.o(4078);
    return paramClass;
  }
  
  public final boolean Yf()
  {
    return this.dCb == 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      bool1 = bool2;
      if (this.dBZ == paramObject.dBZ)
      {
        bool1 = bool2;
        if (this.dCa == paramObject.dCa)
        {
          bool1 = bool2;
          if (this.dCb == paramObject.dCb) {
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
    int i = this.dBZ.hashCode();
    int j = this.dCa;
    int k = this.dCb;
    AppMethodBeat.o(4079);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final String toString()
  {
    boolean bool2 = true;
    AppMethodBeat.i(4080);
    Object localObject = new StringBuilder("Dependency{interface=").append(this.dBZ).append(", required=");
    if (this.dCa == 1)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", direct=");
      if (this.dCb != 0) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.f
 * JD-Core Version:    0.7.0.1
 */