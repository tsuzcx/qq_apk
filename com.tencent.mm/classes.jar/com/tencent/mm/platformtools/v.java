package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/platformtools/MediaExportLogic;", "", "()V", "MaxCacheSize", "", "TAG", "", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/protocal/protobuf/MediaExportInfo;", "cachePath", "getExportUUID", "md5", "readFromCache", "", "saveExportUUID", "uuid", "saveToCache", "plugin-comm_release"})
public final class v
{
  private static final String TAG = "MicroMsg.MediaExportLogic";
  private static final String cachePath;
  private static final c<String, cvq> mEF;
  public static final v mEG;
  
  static
  {
    AppMethodBeat.i(169179);
    mEG = new v();
    TAG = "MicroMsg.MediaExportLogic";
    cachePath = b.aSD() + "media_export.proto";
    mEF = new c(500);
    bvz();
    AppMethodBeat.o(169179);
  }
  
  public static String ZU(String paramString)
  {
    AppMethodBeat.i(169178);
    if (paramString == null)
    {
      AppMethodBeat.o(169178);
      return null;
    }
    Object localObject = (cvq)mEF.get(paramString);
    if (localObject != null) {}
    for (localObject = ((cvq)localObject).uuid;; localObject = null)
    {
      bvA();
      Log.i(TAG, "getExportUUID " + paramString + ", " + (String)localObject);
      AppMethodBeat.o(169178);
      return localObject;
    }
  }
  
  public static void bV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169177);
    if ((paramString1 != null) && (paramString2 != null))
    {
      cvq localcvq = new cvq();
      localcvq.md5 = paramString1;
      localcvq.uuid = paramString2;
      mEF.put(paramString1, localcvq);
      bvA();
    }
    Log.i(TAG, "saveExportUUID " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(169177);
  }
  
  private static void bvA()
  {
    AppMethodBeat.i(169176);
    Object localObject2 = mEF.snapshot();
    Log.i(TAG, "saveToCache " + ((Map)localObject2).size());
    Object localObject1 = new cvp();
    p.j(localObject2, "snapShot");
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((cvp)localObject1).TDB.add(localEntry.getValue());
    }
    try
    {
      localObject1 = ((cvp)localObject1).toByteArray();
      u.H(cachePath, (byte[])localObject1);
      AppMethodBeat.o(169176);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(169176);
    }
  }
  
  private static void bvz()
  {
    int j = 1;
    AppMethodBeat.i(169175);
    Log.i(TAG, "readFromCache");
    Object localObject1 = u.aY(cachePath, 0, -1);
    mEF.clear();
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
          Object localObject2 = new cvp();
          ((cvp)localObject2).parseFrom((byte[])localObject1);
          localObject1 = ((cvp)localObject2).TDB;
          p.j(localObject1, "cache.exportInfoList");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cvq)((Iterator)localObject1).next();
            mEF.put(((cvq)localObject2).md5, localObject2);
          }
          AppMethodBeat.o(169175);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          u.deleteFile(cachePath);
        }
      }
      return;
      i = 0;
      break;
    }
    AppMethodBeat.o(169175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.v
 * JD-Core Version:    0.7.0.1
 */