package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/platformtools/MediaExportLogic;", "", "()V", "MaxCacheSize", "", "TAG", "", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/protocal/protobuf/MediaExportInfo;", "cachePath", "getExportUUID", "md5", "readFromCache", "", "saveExportUUID", "uuid", "saveToCache", "plugin-comm_release"})
public final class v
{
  private static final String TAG = "MicroMsg.MediaExportLogic";
  private static final String cachePath;
  private static final c<String, bze> iQC;
  public static final v iQD;
  
  static
  {
    AppMethodBeat.i(169179);
    iQD = new v();
    TAG = "MicroMsg.MediaExportLogic";
    cachePath = b.asb() + "media_export.proto";
    iQC = new c(500);
    aRf();
    AppMethodBeat.o(169179);
  }
  
  public static String Ju(String paramString)
  {
    AppMethodBeat.i(169178);
    if (paramString == null)
    {
      AppMethodBeat.o(169178);
      return null;
    }
    Object localObject = (bze)iQC.get(paramString);
    if (localObject != null) {}
    for (localObject = ((bze)localObject).uuid;; localObject = null)
    {
      aRg();
      ae.i(TAG, "getExportUUID " + paramString + ", " + (String)localObject);
      AppMethodBeat.o(169178);
      return localObject;
    }
  }
  
  private static void aRf()
  {
    int j = 1;
    AppMethodBeat.i(169175);
    ae.i(TAG, "readFromCache");
    Object localObject1 = o.bb(cachePath, 0, -1);
    iQC.clear();
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
          Object localObject2 = new bzd();
          ((bzd)localObject2).parseFrom((byte[])localObject1);
          localObject1 = ((bzd)localObject2).Hmf;
          p.g(localObject1, "cache.exportInfoList");
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bze)((Iterator)localObject1).next();
            iQC.put(((bze)localObject2).md5, localObject2);
          }
          AppMethodBeat.o(169175);
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          o.deleteFile(cachePath);
        }
      }
      return;
      i = 0;
      break;
    }
    AppMethodBeat.o(169175);
  }
  
  private static void aRg()
  {
    AppMethodBeat.i(169176);
    Object localObject2 = iQC.snapshot();
    ae.i(TAG, "saveToCache " + ((Map)localObject2).size());
    Object localObject1 = new bzd();
    p.g(localObject2, "snapShot");
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((bzd)localObject1).Hmf.add(localEntry.getValue());
    }
    try
    {
      localObject1 = ((bzd)localObject1).toByteArray();
      o.C(cachePath, (byte[])localObject1);
      AppMethodBeat.o(169176);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(169176);
    }
  }
  
  public static void bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169177);
    if ((paramString1 != null) && (paramString2 != null))
    {
      bze localbze = new bze();
      localbze.md5 = paramString1;
      localbze.uuid = paramString2;
      iQC.put(paramString1, localbze);
      aRg();
    }
    ae.i(TAG, "saveExportUUID " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(169177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.v
 * JD-Core Version:    0.7.0.1
 */