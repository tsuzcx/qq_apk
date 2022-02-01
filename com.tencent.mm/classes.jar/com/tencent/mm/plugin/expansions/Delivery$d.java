package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

final class Delivery$d
{
  static List<File> b(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(273651);
    ArrayList localArrayList = new ArrayList();
    paramClassLoader = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
    if (paramClassLoader != null)
    {
      paramClassLoader = (List)ShareReflectUtil.findField(paramClassLoader, "nativeLibraryDirectories").get(paramClassLoader);
      Log.i("MicroMsg.exp.Delivery", "dumpV23: nativeLibraryDirectories");
      if (paramClassLoader != null) {
        localArrayList.addAll(paramClassLoader);
      }
    }
    AppMethodBeat.o(273651);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.Delivery.d
 * JD-Core Version:    0.7.0.1
 */