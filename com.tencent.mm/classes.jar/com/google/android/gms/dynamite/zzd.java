package com.google.android.gms.dynamite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions)
  {
    AppMethodBeat.i(5473);
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    localSelectionResult.localVersion = paramIVersions.getLocalVersion(paramContext, paramString);
    localSelectionResult.remoteVersion = paramIVersions.getRemoteVersion(paramContext, paramString, true);
    if ((localSelectionResult.localVersion == 0) && (localSelectionResult.remoteVersion == 0)) {
      localSelectionResult.selection = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(5473);
      return localSelectionResult;
      if (localSelectionResult.localVersion >= localSelectionResult.remoteVersion) {
        localSelectionResult.selection = -1;
      } else {
        localSelectionResult.selection = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzd
 * JD-Core Version:    0.7.0.1
 */