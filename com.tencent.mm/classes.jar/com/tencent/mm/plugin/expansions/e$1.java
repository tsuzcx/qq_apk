package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.toolkit.frontia.a.c.a;
import java.io.File;

final class e$1
  implements c.a
{
  public final File dHs()
  {
    AppMethodBeat.i(273666);
    File localFile = new File(MMApplicationContext.getContext().getApplicationInfo().nativeLibraryDir);
    AppMethodBeat.o(273666);
    return localFile;
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(273669);
    AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
    AppMethodBeat.o(273669);
    return localAssetManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.e.1
 * JD-Core Version:    0.7.0.1
 */