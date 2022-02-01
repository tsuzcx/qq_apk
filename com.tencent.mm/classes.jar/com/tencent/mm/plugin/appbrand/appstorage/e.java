package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class e
  extends al
{
  private static final String KCf = "hadTransferToMMKV";
  private static final String KCg = "keyHadCleanOldScheme";
  private static final String KCh = "keyHadFinishTransfer";
  public static final a KCi;
  private final h KCe;
  private final String mAppId;
  private final long mUin;
  
  static
  {
    AppMethodBeat.i(50217);
    KCi = new a((byte)0);
    KCf = "hadTransferToMMKV";
    KCg = "keyHadCleanOldScheme";
    KCh = "keyHadFinishTransfer";
    AppMethodBeat.o(50217);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(50216);
    this.mAppId = paramString;
    this.KCe = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).cs(this.mAppId);
    this.mUin = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ff(this.mAppId)).longValue();
    AppMethodBeat.o(50216);
  }
  
  private final void a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(50214);
    if (paramSharedPreferences.getBoolean(a.i(KCg, this.mUin, this.mAppId), false))
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(50214);
      return;
    }
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    j.Dg().EC(this.mAppId);
    paramSharedPreferences.edit().putBoolean(a.i(KCg, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(50214);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final boolean nb(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(50215);
    if (!aj.eFE().getBoolean(a.i(KCh, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(bool)));
    AppMethodBeat.o(50215);
    return bool;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(50213);
    if (!f.iSa.aRa())
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(50213);
      return;
    }
    SharedPreferences localSharedPreferences = aj.eFE();
    if (f.iSa.aQY())
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(a.i(KCf, this.mUin, this.mAppId), false).apply();
      this.KCe.EC(this.mAppId);
      AppMethodBeat.o(50213);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(a.i(KCf, this.mUin, this.mAppId), false);
    if ((bool) && (f.iSa.aQX()))
    {
      k.g(localSharedPreferences, "sharedPreferences");
      a(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(a.i(KCh, this.mUin, this.mAppId), true).apply();
      AppMethodBeat.o(50213);
      return;
    }
    if (bool)
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
      AppMethodBeat.o(50213);
      return;
    }
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
    com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 0L);
    long l5 = System.currentTimeMillis();
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.KCe.EC(this.mAppId);
    int[] arrayOfInt = j.Dg().ED(this.mAppId);
    k.g(arrayOfInt, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
    int j = j.Dg().EE(this.mAppId);
    int k = arrayOfInt.length;
    int i = 0;
    long l3 = 0L;
    long l2 = 0L;
    paramInt = 0;
    int m;
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    long l1;
    long l4;
    if (i < k)
    {
      m = arrayOfInt[i];
      localObject2 = j.Dg().S(m, this.mAppId)[0];
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localArrayList = (ArrayList)localObject1;
      if (localArrayList == null) {}
      for (localObject1 = new e.b(0L, 0L, 0);; localObject1 = new e.b(0L, 0L, 0))
      {
        l1 = ((e.b)localObject1).KCj;
        l4 = ((e.b)localObject1).KCk;
        m = ((e.b)localObject1).size;
        i += 1;
        l3 += l4;
        l2 += l1;
        paramInt += m;
        break;
        if (localArrayList.size() != 0) {
          break label427;
        }
      }
      label427:
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + localArrayList.size());
      l4 = 0L;
      Iterator localIterator = ((Iterable)localArrayList).iterator();
      l1 = 0L;
      label471:
      if (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        if (localObject1 != null) {
          break label1194;
        }
        localObject1 = "";
      }
    }
    label1194:
    for (;;)
    {
      long l6 = System.currentTimeMillis();
      localObject2 = j.Dg().l(m, this.mAppId, (String)localObject1);
      k.g(localObject2, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
      long l7 = System.currentTimeMillis();
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (((k.g(localObject1, "") ^ true)) && (localObject2[0] == o.a.iSO) && ((localObject3 instanceof String)) && ((localObject4 instanceof String)))
      {
        long l8 = System.currentTimeMillis();
        this.KCe.c(m, this.mAppId, (String)localObject1, (String)localObject3, (String)localObject4);
        l1 += System.currentTimeMillis() - l8;
      }
      for (;;)
      {
        l4 = l7 - l6 + l4;
        break label471;
        localObject1 = new e.b(l4, l1, localArrayList.size());
        break;
        l1 = System.currentTimeMillis() - l5;
        if (5000L < l1)
        {
          com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 12L);
          ad.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
          k = this.KCe.EE(this.mAppId);
          m = this.KCe.EN(this.mAppId);
          ad.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
          if (k != j) {
            break label942;
          }
          i = 1;
          label856:
          if (m != paramInt) {
            break label947;
          }
          j = 1;
          label864:
          if ((i == 0) || (j == 0)) {
            break label952;
          }
          com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 1L);
        }
        for (;;)
        {
          if (m != paramInt)
          {
            localObject1 = new IllegalStateException("tansfer failed ");
            if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
            {
              localObject1 = (Throwable)localObject1;
              AppMethodBeat.o(50213);
              throw ((Throwable)localObject1);
              com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 11L);
              break;
              label942:
              i = 0;
              break label856;
              label947:
              j = 0;
              break label864;
              label952:
              if ((i == 0) && (j == 0))
              {
                com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 4L);
                continue;
              }
              if (i == 0)
              {
                com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 3L);
                continue;
              }
              if (j != 0) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.vKh.D(1016L, 2L);
              continue;
            }
            ad.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
          }
        }
        ad.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
        com.tencent.mm.plugin.report.service.h.vKh.f(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.KCe.EN(this.mAppId)) });
        k.g(localSharedPreferences, "sharedPreferences");
        localSharedPreferences.edit().putBoolean(a.i(KCf, this.mUin, this.mAppId), true).apply();
        if (f.iSa.aQX())
        {
          a(localSharedPreferences);
          localSharedPreferences.edit().putBoolean(a.i(KCh, this.mUin, this.mAppId), true).apply();
        }
        AppMethodBeat.o(50213);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static int aUA(String paramString)
    {
      AppMethodBeat.i(50211);
      k.h(paramString, "appId");
      SharedPreferences localSharedPreferences = aj.eFE();
      long l = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ff(paramString)).longValue();
      int i;
      if (localSharedPreferences.getBoolean(i(e.fQS(), l, paramString), false)) {
        i = 2;
      }
      for (;;)
      {
        ad.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
        AppMethodBeat.o(50211);
        return i;
        if ((localSharedPreferences.getBoolean(i(e.fQT(), l, paramString), false)) && (!f.iSa.aQY())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
    
    public static String i(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(50210);
      k.h(paramString1, "key");
      k.h(paramString2, "appId");
      paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
      AppMethodBeat.o(50210);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e
 * JD-Core Version:    0.7.0.1
 */