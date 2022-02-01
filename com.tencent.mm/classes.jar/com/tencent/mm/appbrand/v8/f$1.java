package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.ILoadLibraryDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class f$1
  implements ILoadLibraryDelegate
{
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(143996);
    try
    {
      Util.nowMilliSecond();
      f.access$000();
      h.class.getClassLoader();
      j.KW("mmskia");
      h.class.getClassLoader();
      j.KW("canvas");
      h.class.getClassLoader();
      j.KW("skia-canvas");
      h.class.getClassLoader();
      j.KW("skia-canvas-log-bridge");
      Log.i("MicroMsg.JSRuntimeCreator", "load so done");
      AppMethodBeat.o(143996);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        Log.printErrStackTrace("MicroMsg.JSRuntimeCreator", paramString, "", new Object[0]);
      } while ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED));
      AppMethodBeat.o(143996);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.f.1
 * JD-Core Version:    0.7.0.1
 */