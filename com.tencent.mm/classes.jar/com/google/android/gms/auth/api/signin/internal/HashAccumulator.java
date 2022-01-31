package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HashAccumulator
{
  @VisibleForTesting
  private static int zzad = 31;
  private int zzae = 1;
  
  public HashAccumulator addBoolean(boolean paramBoolean)
  {
    int j = zzad;
    int k = this.zzae;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.zzae = (i + k * j);
      return this;
    }
  }
  
  public HashAccumulator addObject(Object paramObject)
  {
    AppMethodBeat.i(60389);
    int j = zzad;
    int k = this.zzae;
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode())
    {
      this.zzae = (i + k * j);
      AppMethodBeat.o(60389);
      return this;
    }
  }
  
  public int hash()
  {
    return this.zzae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.HashAccumulator
 * JD-Core Version:    0.7.0.1
 */