package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Delivery$e
{
  static List<File> b(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(273657);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)ShareReflectUtil.findField(paramClassLoader, "libPath").get(paramClassLoader);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(":");
      Log.i("MicroMsg.exp.Delivery", "dumpV4: libPath");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new File(localObject[i]));
        i += 1;
      }
    }
    paramClassLoader = (List)ShareReflectUtil.findField(paramClassLoader, "libraryPathElements").get(paramClassLoader);
    Log.i("MicroMsg.exp.Delivery", "dumpV4: libraryPathElements");
    if (paramClassLoader != null)
    {
      paramClassLoader = paramClassLoader.iterator();
      while (paramClassLoader.hasNext()) {
        localArrayList.add(new File((String)paramClassLoader.next()));
      }
    }
    AppMethodBeat.o(273657);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.Delivery.e
 * JD-Core Version:    0.7.0.1
 */