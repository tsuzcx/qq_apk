package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/platformtools/MediaExportLogic;", "", "()V", "MaxCacheSize", "", "TAG", "", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/protocal/protobuf/MediaExportInfo;", "cachePath", "getExportUUID", "md5", "readFromCache", "", "saveExportUUID", "uuid", "saveToCache", "plugin-comm_release"})
public final class v
{
  private static final String TAG = "MicroMsg.MediaExportLogic";
  private static final String cachePath;
  private static final c<String, byk> iNI;
  public static final v iNJ;
  
  static
  {
    AppMethodBeat.i(169179);
    iNJ = new v();
    TAG = "MicroMsg.MediaExportLogic";
    cachePath = b.arM() + "media_export.proto";
    iNI = new c(500);
    aQG();
    AppMethodBeat.o(169179);
  }
  
  public static String IV(String paramString)
  {
    AppMethodBeat.i(169178);
    if (paramString == null)
    {
      AppMethodBeat.o(169178);
      return null;
    }
    Object localObject = (byk)iNI.get(paramString);
    if (localObject != null) {}
    for (localObject = ((byk)localObject).uuid;; localObject = null)
    {
      aQH();
      ad.i(TAG, "getExportUUID " + paramString + ", " + (String)localObject);
      AppMethodBeat.o(169178);
      return localObject;
    }
  }
  
  private static void aQG()
  {
    int j = 1;
    AppMethodBeat.i(169175);
    ad.i(TAG, "readFromCache");
    Object localObject1 = i.aY(cachePath, 0, -1);
    iNI.clear();
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
          Object localObject2 = new byj();
          ((byj)localObject2).parseFrom((byte[])localObject1);
          localObject1 = ((byj)localObject2).GSE;
          p.g(localObject1, "cache.exportInfoList");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (byk)((Iterator)localObject1).next();
            iNI.put(((byk)localObject2).md5, localObject2);
          }
          AppMethodBeat.o(169175);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          i.deleteFile(cachePath);
        }
      }
      return;
      i = 0;
      break;
    }
    AppMethodBeat.o(169175);
  }
  
  private static void aQH()
  {
    AppMethodBeat.i(169176);
    Object localObject2 = iNI.snapshot();
    ad.i(TAG, "saveToCache " + ((Map)localObject2).size());
    Object localObject1 = new byj();
    p.g(localObject2, "snapShot");
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((byj)localObject1).GSE.add(localEntry.getValue());
    }
    try
    {
      localObject1 = ((byj)localObject1).toByteArray();
      i.C(cachePath, (byte[])localObject1);
      AppMethodBeat.o(169176);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(169176);
    }
  }
  
  public static void bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169177);
    if ((paramString1 != null) && (paramString2 != null))
    {
      byk localbyk = new byk();
      localbyk.md5 = paramString1;
      localbyk.uuid = paramString2;
      iNI.put(paramString1, localbyk);
      aQH();
    }
    ad.i(TAG, "saveExportUUID " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(169177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.v
 * JD-Core Version:    0.7.0.1
 */