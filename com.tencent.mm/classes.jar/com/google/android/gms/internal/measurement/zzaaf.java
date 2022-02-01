package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaaf
  implements zzaak
{
  private zzaak[] zzbtf;
  
  zzaaf(zzaak... paramVarArgs)
  {
    this.zzbtf = paramVarArgs;
  }
  
  public final boolean zzd(Class<?> paramClass)
  {
    AppMethodBeat.i(40126);
    zzaak[] arrayOfzzaak = this.zzbtf;
    int j = arrayOfzzaak.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfzzaak[i].zzd(paramClass))
      {
        AppMethodBeat.o(40126);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(40126);
    return false;
  }
  
  public final zzaaj zze(Class<?> paramClass)
  {
    AppMethodBeat.i(40127);
    zzaak[] arrayOfzzaak = this.zzbtf;
    int j = arrayOfzzaak.length;
    int i = 0;
    while (i < j)
    {
      zzaak localzzaak = arrayOfzzaak[i];
      if (localzzaak.zzd(paramClass))
      {
        paramClass = localzzaak.zze(paramClass);
        AppMethodBeat.o(40127);
        return paramClass;
      }
      i += 1;
    }
    paramClass = String.valueOf(paramClass.getName());
    if (paramClass.length() != 0) {}
    for (paramClass = "No factory is available for message type: ".concat(paramClass);; paramClass = new String("No factory is available for message type: "))
    {
      paramClass = new UnsupportedOperationException(paramClass);
      AppMethodBeat.o(40127);
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaaf
 * JD-Core Version:    0.7.0.1
 */