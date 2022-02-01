package com.tencent.mm.plugin.appbrand.appstorage.b;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandScopedStorageTransfer;", "", "()V", "appBrandTargetFolder", "", "appId", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "rootPath", "tasks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "Lkotlin/collections/ArrayList;", "uin", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "commit", "", "getKey", "into", "path", "isTransferred", "", "taskPaths", "nonFlattenedFSPath", "nonFlattenedOpenFSPath", "nonFlattenedClientFSPath", "tryTransfer", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "task", "hasLocalRecord", "hasSyncRecord", "fakeNative", "with", "Companion", "plugin-appbrand-integration_release"})
public final class b
{
  public static final a kTO;
  public String appId;
  public final MultiProcessMMKV cQe;
  public final String jpM;
  public String kTM;
  public final ArrayList<c> kTN;
  public String uin;
  
  static
  {
    AppMethodBeat.i(175119);
    kTO = new a((byte)0);
    AppMethodBeat.o(175119);
  }
  
  public b()
  {
    AppMethodBeat.i(175118);
    this.cQe = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.AppBrandScopedStorageTransfer");
    this.kTN = new ArrayList();
    String str = new File(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").getAbsolutePath();
    p.g(str, "java.io.File(Environment…t/MicroMsg\").absolutePath");
    this.jpM = a.Wr(str);
    AppMethodBeat.o(175118);
  }
  
  private static e a(c paramc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(228119);
    try
    {
      paramc = paramc.d(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(228119);
      return paramc;
    }
    catch (Exception paramc)
    {
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
      {
        paramc = (Throwable)paramc;
        AppMethodBeat.o(228119);
        throw paramc;
      }
      Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", (Throwable)paramc, "tryTransfer", new Object[0]);
      paramc = new e(false, true, String.valueOf(paramc.getMessage()));
      AppMethodBeat.o(228119);
    }
    return paramc;
  }
  
  public final b Wq(String paramString)
  {
    AppMethodBeat.i(175117);
    p.h(paramString, "appId");
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
      p.btv("appId");
    }
    Log.i("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", (String)localObject2);
    long l1 = System.currentTimeMillis();
    h.CyF.dN(1323, 3);
    localObject1 = this.appId;
    if (localObject1 == null) {
      p.btv("appId");
    }
    localObject1 = y.Xy((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", "commit: appId -> username failed");
      AppMethodBeat.o(175116);
      return;
    }
    localObject2 = ((k)n.W(k.class)).Ws((String)localObject1);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.appbrand.appusage.b)localObject2).field_updateTime != 0L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool4 = ((x)n.W(x.class)).bm((String)localObject1, 0);
      localObject1 = n.buC().d((String)localObject1, new String[0]);
      if (localObject1 != null)
      {
        localObject1 = ((WxaAttributes)localObject1).bAn();
        if (localObject1 == null) {}
      }
      boolean bool3;
      for (boolean bool2 = ((WxaAttributes.a)localObject1).bAt();; bool2 = false)
      {
        localObject1 = ((Iterable)this.kTN).iterator();
        for (bool3 = true; ((Iterator)localObject1).hasNext(); bool3 = a((c)((Iterator)localObject1).next(), bool1, bool4, bool2).kTW & bool3) {}
      }
      localObject1 = this.cQe;
      localObject2 = new StringBuilder();
      String str = this.appId;
      if (str == null) {
        p.btv("appId");
      }
      localObject2 = ((StringBuilder)localObject2).append(str);
      str = this.uin;
      if (str == null) {
        p.btv("uin");
      }
      ((MultiProcessMMKV)localObject1).putBoolean(str, bool3);
      long l2 = System.currentTimeMillis();
      localObject1 = new StringBuilder("commit() done with appId:");
      localObject2 = this.appId;
      if (localObject2 == null) {
        p.btv("appId");
      }
      Log.i("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", (String)localObject2 + " cost:" + (l2 - l1) + "ms, res = [%b]", new Object[] { Boolean.valueOf(bool3) });
      if (bool3)
      {
        h.CyF.dN(1323, 0);
        AppMethodBeat.o(175116);
        return;
      }
      h.CyF.dN(1323, 1);
      AppMethodBeat.o(175116);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandScopedStorageTransfer$Companion;", "", "()V", "ID_KEY", "", "ID_KEY_DISAPPROVED", "ID_KEY_DISAPPROVED_NEED_TRANSFER", "ID_KEY_DISAPPROVED_NO_NEED_TRANSFER", "ID_KEY_FAIL", "ID_KEY_NO_NEED", "ID_KEY_START", "ID_KEY_SUCCESS", "TAG", "", "tryHardToGetCanonicalPath", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String Wr(String paramString)
    {
      AppMethodBeat.i(175114);
      p.h(paramString, "path");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.b
 * JD-Core Version:    0.7.0.1
 */