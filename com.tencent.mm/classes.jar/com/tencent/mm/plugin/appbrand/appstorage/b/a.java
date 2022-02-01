package com.tencent.mm.plugin.appbrand.appstorage.b;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandScopedStorageTransfer;", "", "()V", "appBrandTargetFolder", "", "appId", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "rootPath", "tasks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "Lkotlin/collections/ArrayList;", "commit", "", "into", "path", "isTransferred", "", "taskPaths", "nonFlattenedFSPath", "nonFlattenedOpenFSPath", "nonFlattenedClientFSPath", "tryTransfer", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "task", "with", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a iTH;
  public String appId;
  public final ax ctt;
  public final String hxI;
  public String iTF;
  public final ArrayList<b> iTG;
  
  static
  {
    AppMethodBeat.i(175119);
    iTH = new a((byte)0);
    AppMethodBeat.o(175119);
  }
  
  public a()
  {
    AppMethodBeat.i(175118);
    this.ctt = ax.aFC("MicroMsg.AppBrand.AppBrandCompatibilityTransfer");
    this.iTG = new ArrayList();
    String str = new File(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").getAbsolutePath();
    k.g(str, "java.io.File(Environment…t/MicroMsg\").absolutePath");
    this.hxI = a.Fh(str);
    AppMethodBeat.o(175118);
  }
  
  private static e a(b paramb)
  {
    AppMethodBeat.i(175115);
    for (;;)
    {
      com.tencent.mm.vfs.e locale1;
      try
      {
        locale1 = new com.tencent.mm.vfs.e(paramb.iTI);
        com.tencent.mm.vfs.e locale2 = new com.tencent.mm.vfs.e(paramb.iTJ);
        if (c.x(locale1))
        {
          ad.d("MicroMsg.AppBrand.AppBrandTransferTask", paramb.iTI + " legacy file not exist, no need to transfer");
          paramb = new e(false);
          AppMethodBeat.o(175115);
          return paramb;
        }
        if ((c.x(locale2)) && (!locale2.mkdir()))
        {
          ad.d("MicroMsg.AppBrand.AppBrandTransferTask", "mkdir in " + paramb.iTJ + " fail, abort this task");
          paramb = new e(false, true, "mkdir fail");
          continue;
        }
        if (!i.lE(paramb.iTI, paramb.iTJ)) {
          break label239;
        }
      }
      catch (Exception paramb)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.AppBrandCompatibilityTransfer", (Throwable)paramb, "tryTransfer", new Object[0]);
        paramb = new e(false, true, String.valueOf(paramb.getMessage()));
        AppMethodBeat.o(175115);
        return paramb;
      }
      ad.d("MicroMsg.AppBrand.AppBrandTransferTask", locale1 + " -> " + paramb.iTJ + " successful");
      paramb = new e(true);
      continue;
      label239:
      ad.d("MicroMsg.AppBrand.AppBrandTransferTask", locale1 + " -> " + paramb.iTJ + " fail");
      paramb = new e(false, true, "move fail");
    }
  }
  
  public final a Fg(String paramString)
  {
    AppMethodBeat.i(175117);
    k.h(paramString, "appId");
    this.appId = paramString;
    AppMethodBeat.o(175117);
    return this;
  }
  
  public final void commit()
  {
    AppMethodBeat.i(175116);
    Object localObject1 = new StringBuilder("commit() with appId:");
    Object localObject2 = this.appId;
    if (localObject2 == null) {
      k.aPZ("appId");
    }
    ad.i("MicroMsg.AppBrand.AppBrandCompatibilityTransfer", (String)localObject2);
    long l1 = System.currentTimeMillis();
    h.vKh.dB(1323, 3);
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)this.iTG).iterator();
    boolean bool2;
    for (boolean bool1 = true; ((Iterator)localObject2).hasNext(); bool1 = bool2 & bool1)
    {
      e locale = a((b)((Iterator)localObject2).next());
      bool2 = locale.iTQ;
      ((ArrayList)localObject1).add(locale.errorMsg);
    }
    localObject1 = this.ctt;
    localObject2 = this.appId;
    if (localObject2 == null) {
      k.aPZ("appId");
    }
    ((ax)localObject1).putBoolean((String)localObject2, bool1);
    if (bool1)
    {
      localObject1 = ((Iterable)this.iTG).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        try
        {
          new com.tencent.mm.vfs.e(((b)localObject2).iTI, ".appBrandTransfer.semaphore").createNewFile();
        }
        catch (Exception localException)
        {
          ad.i("MicroMsg.AppBrand.AppBrandCompatibilityTransfer", "try to create semaphore file for [%s] fail, [%s]", new Object[] { ((b)localObject2).iTI, String.valueOf(localException.getMessage()) });
        }
      }
    }
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder("commit() done with appId:");
    localObject2 = this.appId;
    if (localObject2 == null) {
      k.aPZ("appId");
    }
    ad.i("MicroMsg.AppBrand.AppBrandCompatibilityTransfer", (String)localObject2 + " cost:" + (l2 - l1) + "ms");
    if (bool1)
    {
      h.vKh.dB(1323, 0);
      AppMethodBeat.o(175116);
      return;
    }
    h.vKh.dB(1323, 1);
    AppMethodBeat.o(175116);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandScopedStorageTransfer$Companion;", "", "()V", "ID_KEY", "", "ID_KEY_FAIL", "ID_KEY_NO_NEED", "ID_KEY_START", "ID_KEY_SUCCESS", "TAG", "", "tryHardToGetCanonicalPath", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String Fh(String paramString)
    {
      AppMethodBeat.i(175114);
      k.h(paramString, "path");
      File localFile = new File(paramString);
      try
      {
        paramString = localFile.getCanonicalPath();
        AppMethodBeat.o(175114);
        return paramString;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString = localFile.getAbsolutePath();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.a
 * JD-Core Version:    0.7.0.1
 */