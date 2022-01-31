package com.google.android.gms.dynamite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  implements DynamiteModule.VersionPolicy.IVersions
{
  public final int getLocalVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90449);
    int i = DynamiteModule.getLocalVersion(paramContext, paramString);
    AppMethodBeat.o(90449);
    return i;
  }
  
  public final int getRemoteVersion(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90448);
    int i = DynamiteModule.getRemoteVersion(paramContext, paramString, paramBoolean);
    AppMethodBeat.o(90448);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.dynamite.zza
 * JD-Core Version:    0.7.0.1
 */