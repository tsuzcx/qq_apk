package com.tencent.mm.plugin.expansions;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.toolkit.frontia.a.c.a;
import java.io.File;

final class Delivery$1
  implements c.a
{
  Delivery$1(Context paramContext) {}
  
  public final File dHs()
  {
    AppMethodBeat.i(273636);
    File localFile = new File(this.val$context.getApplicationInfo().nativeLibraryDir);
    AppMethodBeat.o(273636);
    return localFile;
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(273641);
    AssetManager localAssetManager = ApplicationGlobal.context().getAssets();
    AppMethodBeat.o(273641);
    return localAssetManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.Delivery.1
 * JD-Core Version:    0.7.0.1
 */