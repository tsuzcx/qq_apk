package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class ListenerHolder$ListenerKey<L>
{
  private final L zzli;
  private final String zzll;
  
  @KeepForSdk
  ListenerHolder$ListenerKey(L paramL, String paramString)
  {
    this.zzli = paramL;
    this.zzll = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(11131);
    if (this == paramObject)
    {
      AppMethodBeat.o(11131);
      return true;
    }
    if (!(paramObject instanceof ListenerKey))
    {
      AppMethodBeat.o(11131);
      return false;
    }
    paramObject = (ListenerKey)paramObject;
    if ((this.zzli == paramObject.zzli) && (this.zzll.equals(paramObject.zzll)))
    {
      AppMethodBeat.o(11131);
      return true;
    }
    AppMethodBeat.o(11131);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(11132);
    int i = System.identityHashCode(this.zzli);
    int j = this.zzll.hashCode();
    AppMethodBeat.o(11132);
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey
 * JD-Core Version:    0.7.0.1
 */