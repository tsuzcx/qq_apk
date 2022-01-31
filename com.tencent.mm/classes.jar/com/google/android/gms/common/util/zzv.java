package com.google.android.gms.common.util;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import java.util.Set;

public final class zzv
{
  public static String[] zza(Scope[] paramArrayOfScope)
  {
    zzac.zzb(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    int i = 0;
    while (i < paramArrayOfScope.length)
    {
      arrayOfString[i] = paramArrayOfScope[i].zzvt();
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String[] zzd(Set<Scope> paramSet)
  {
    zzac.zzb(paramSet, "scopes can't be null.");
    return zza((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.zzv
 * JD-Core Version:    0.7.0.1
 */