package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/platformtools/MediaExportLogic;", "", "()V", "MaxCacheSize", "", "TAG", "", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/protocal/protobuf/MediaExportInfo;", "cachePath", "getExportUUID", "md5", "readFromCache", "", "saveExportUUID", "uuid", "saveToCache", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  private static final String TAG;
  private static final String cachePath;
  public static final s pBi;
  private static final c<String, dmw> pBj;
  
  static
  {
    int j = 1;
    AppMethodBeat.i(169179);
    pBi = new s();
    TAG = "MicroMsg.MediaExportLogic";
    cachePath = kotlin.g.b.s.X(b.bmr(), "media_export.proto");
    pBj = new c(500);
    Log.i(TAG, "readFromCache");
    Object localObject1 = y.bi(cachePath, 0, -1);
    pBj.clear();
    if (localObject1 != null)
    {
      if (localObject1.length != 0) {
        break label189;
      }
      i = 1;
      if (i != 0) {
        break label194;
      }
    }
    label189:
    label194:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        try
        {
          Object localObject2 = new dmv();
          ((dmv)localObject2).parseFrom((byte[])localObject1);
          localObject1 = ((dmv)localObject2).aaTh;
          kotlin.g.b.s.s(localObject1, "cache.exportInfoList");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (dmw)((Iterator)localObject1).next();
            pBj.put(((dmw)localObject2).md5, localObject2);
          }
          AppMethodBeat.o(169179);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          y.deleteFile(cachePath);
        }
      }
      return;
      i = 0;
      break;
    }
    AppMethodBeat.o(169179);
  }
  
  public static String Si(String paramString)
  {
    AppMethodBeat.i(169178);
    if (paramString == null)
    {
      AppMethodBeat.o(169178);
      return null;
    }
    Object localObject = (dmw)pBj.get(paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((dmw)localObject).uuid)
    {
      bTM();
      Log.i(TAG, "getExportUUID " + paramString + ", " + localObject);
      AppMethodBeat.o(169178);
      return localObject;
    }
  }
  
  private static void bTM()
  {
    AppMethodBeat.i(169176);
    Object localObject2 = pBj.snapshot();
    Log.i(TAG, kotlin.g.b.s.X("saveToCache ", Integer.valueOf(((Map)localObject2).size())));
    Object localObject1 = new dmv();
    kotlin.g.b.s.s(localObject2, "snapShot");
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((dmv)localObject1).aaTh.add(localEntry.getValue());
    }
    try
    {
      localObject1 = ((dmv)localObject1).toByteArray();
      y.f(cachePath, (byte[])localObject1, localObject1.length);
      AppMethodBeat.o(169176);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(169176);
    }
  }
  
  public static void ci(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169177);
    if ((paramString1 != null) && (paramString2 != null))
    {
      dmw localdmw = new dmw();
      localdmw.md5 = paramString1;
      localdmw.uuid = paramString2;
      pBj.put(paramString1, localdmw);
      bTM();
    }
    Log.i(TAG, "saveExportUUID " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(169177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.s
 * JD-Core Version:    0.7.0.1
 */