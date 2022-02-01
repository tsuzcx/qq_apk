package com.google.android.gms.dynamite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions)
  {
    AppMethodBeat.i(5471);
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    localSelectionResult.remoteVersion = paramIVersions.getRemoteVersion(paramContext, paramString, true);
    if (localSelectionResult.remoteVersion != 0) {
      localSelectionResult.selection = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(5471);
      return localSelectionResult;
      localSelectionResult.localVersion = paramIVersions.getLocalVersion(paramContext, paramString);
      if (localSelectionResult.localVersion != 0) {
        localSelectionResult.selection = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzb
 * JD-Core Version:    0.7.0.1
 */