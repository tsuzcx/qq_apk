package com.tencent.mm.compatible.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class h$1
  implements h.a
{
  public final boolean aQf()
  {
    return false;
  }
  
  public final boolean aQg()
  {
    return false;
  }
  
  public final boolean aQh()
  {
    return true;
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(240828);
    AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
    AppMethodBeat.o(240828);
    return localAssetManager;
  }
  
  public final boolean tryLoadLibrary(String paramString)
  {
    AppMethodBeat.i(240833);
    Log.i("MicroMsg.exp.ExpansionsProxy", " System.loadLibrary(), name = ".concat(String.valueOf(paramString)));
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/tencent/mm/compatible/util/ExpansionsProxy$1", "tryLoadLibrary", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/compatible/util/ExpansionsProxy$1", "tryLoadLibrary", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(240833);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.h.1
 * JD-Core Version:    0.7.0.1
 */