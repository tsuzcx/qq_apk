package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/platformtools/MediaExportLogic;", "", "()V", "MaxCacheSize", "", "TAG", "", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/protocal/protobuf/MediaExportInfo;", "cachePath", "getExportUUID", "md5", "readFromCache", "", "saveExportUUID", "uuid", "saveToCache", "plugin-comm_release"})
public final class v
{
  private static final String TAG = "MicroMsg.MediaExportLogic";
  private static final String cachePath;
  private static final c<String, cmy> jNx;
  public static final v jNy;
  
  static
  {
    AppMethodBeat.i(169179);
    jNy = new v();
    TAG = "MicroMsg.MediaExportLogic";
    cachePath = b.aKB() + "media_export.proto";
    jNx = new c(500);
    blJ();
    AppMethodBeat.o(169179);
  }
  
  public static String Ss(String paramString)
  {
    AppMethodBeat.i(169178);
    if (paramString == null)
    {
      AppMethodBeat.o(169178);
      return null;
    }
    Object localObject = (cmy)jNx.get(paramString);
    if (localObject != null) {}
    for (localObject = ((cmy)localObject).uuid;; localObject = null)
    {
      blK();
      Log.i(TAG, "getExportUUID " + paramString + ", " + (String)localObject);
      AppMethodBeat.o(169178);
      return localObject;
    }
  }
  
  public static void bR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169177);
    if ((paramString1 != null) && (paramString2 != null))
    {
      cmy localcmy = new cmy();
      localcmy.md5 = paramString1;
      localcmy.uuid = paramString2;
      jNx.put(paramString1, localcmy);
      blK();
    }
    Log.i(TAG, "saveExportUUID " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(169177);
  }
  
  private static void blJ()
  {
    int j = 1;
    AppMethodBeat.i(169175);
    Log.i(TAG, "readFromCache");
    Object localObject1 = s.aW(cachePath, 0, -1);
    jNx.clear();
    if (localObject1 != null)
    {
      if (localObject1.length != 0) {
        break label150;
      }
      i = 1;
      if (i != 0) {
        break label155;
      }
    }
    label150:
    label155:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        try
        {
          Object localObject2 = new cmx();
          ((cmx)localObject2).parseFrom((byte[])localObject1);
          localObject1 = ((cmx)localObject2).Msv;
          p.g(localObject1, "cache.exportInfoList");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cmy)((Iterator)localObject1).next();
            jNx.put(((cmy)localObject2).md5, localObject2);
          }
          AppMethodBeat.o(169175);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          s.deleteFile(cachePath);
        }
      }
      return;
      i = 0;
      break;
    }
    AppMethodBeat.o(169175);
  }
  
  private static void blK()
  {
    AppMethodBeat.i(169176);
    Object localObject2 = jNx.snapshot();
    Log.i(TAG, "saveToCache " + ((Map)localObject2).size());
    Object localObject1 = new cmx();
    p.g(localObject2, "snapShot");
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((cmx)localObject1).Msv.add(localEntry.getValue());
    }
    try
    {
      localObject1 = ((cmx)localObject1).toByteArray();
      s.C(cachePath, (byte[])localObject1);
      AppMethodBeat.o(169176);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(169176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.v
 * JD-Core Version:    0.7.0.1
 */