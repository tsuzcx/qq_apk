package com.google.android.gms.dynamite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions)
  {
    AppMethodBeat.i(5476);
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    localSelectionResult.localVersion = paramIVersions.getLocalVersion(paramContext, paramString);
    if (localSelectionResult.localVersion != 0)
    {
      localSelectionResult.remoteVersion = paramIVersions.getRemoteVersion(paramContext, paramString, false);
      if ((localSelectionResult.localVersion != 0) || (localSelectionResult.remoteVersion != 0)) {
        break label98;
      }
      localSelectionResult.selection = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(5476);
      return localSelectionResult;
      localSelectionResult.remoteVersion = paramIVersions.getRemoteVersion(paramContext, paramString, true);
      break;
      label98:
      if (localSelectionResult.remoteVersion >= localSelectionResult.localVersion) {
        localSelectionResult.selection = 1;
      } else {
        localSelectionResult.selection = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzg
 * JD-Core Version:    0.7.0.1
 */