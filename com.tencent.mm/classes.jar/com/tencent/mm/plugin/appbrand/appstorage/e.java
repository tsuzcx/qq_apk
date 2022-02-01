package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class e
  extends at
{
  private static final String rru = "hadTransferToMMKV";
  private static final String rrv = "keyHadCleanOldScheme";
  private static final String rrw = "keyHadFinishTransfer";
  public static final a rrx;
  private final String mAppId;
  private final long mUin;
  private final g rrt;
  
  static
  {
    AppMethodBeat.i(50217);
    rrx = new a((byte)0);
    rru = "hadTransferToMMKV";
    rrv = "keyHadCleanOldScheme";
    rrw = "keyHadFinishTransfer";
    AppMethodBeat.o(50217);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(50216);
    this.mAppId = paramString;
    this.rrt = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dX(this.mAppId);
    this.mUin = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).aee(this.mAppId)).longValue();
    AppMethodBeat.o(50216);
  }
  
  private final void a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(50214);
    if (paramSharedPreferences.getBoolean(a.c(rrv, this.mUin, this.mAppId), false))
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(50214);
      return;
    }
    Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    m.QF().adu(this.mAppId);
    paramSharedPreferences.edit().putBoolean(a.c(rrv, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(50214);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(50213);
    if (!f.nMh.bIv())
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(50213);
      return;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (f.nMh.bIt())
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(a.c(rru, this.mUin, this.mAppId), false).apply();
      this.rrt.adu(this.mAppId);
      AppMethodBeat.o(50213);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(a.c(rru, this.mUin, this.mAppId), false);
    if ((bool) && (f.nMh.bIs()))
    {
      kotlin.g.b.p.j(localSharedPreferences, "sharedPreferences");
      a(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(a.c(rrw, this.mUin, this.mAppId), true).apply();
      AppMethodBeat.o(50213);
      return;
    }
    if (bool)
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
      AppMethodBeat.o(50213);
      return;
    }
    Log.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
    com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 0L);
    long l5 = System.currentTimeMillis();
    Log.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.rrt.adu(this.mAppId);
    int[] arrayOfInt = m.QF().adv(this.mAppId);
    kotlin.g.b.p.j(arrayOfInt, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
    int j = m.QF().adw(this.mAppId);
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
      localObject2 = m.QF().ab(m, this.mAppId)[0];
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localArrayList = (ArrayList)localObject1;
      if (localArrayList == null) {}
      for (localObject1 = new e.b(0L, 0L, 0);; localObject1 = new e.b(0L, 0L, 0))
      {
        l1 = ((e.b)localObject1).rry;
        l4 = ((e.b)localObject1).rrz;
        m = ((e.b)localObject1).size;
        i += 1;
        l3 += l4;
        l2 += l1;
        paramInt += m;
        break;
        if (localArrayList.size() != 0) {
          break label426;
        }
      }
      label426:
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + localArrayList.size());
      l4 = 0L;
      Iterator localIterator = ((Iterable)localArrayList).iterator();
      l1 = 0L;
      label470:
      if (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        if (localObject1 != null) {
          break label1193;
        }
        localObject1 = "";
      }
    }
    label1193:
    for (;;)
    {
      long l6 = System.currentTimeMillis();
      localObject2 = m.QF().l(m, this.mAppId, (String)localObject1);
      kotlin.g.b.p.j(localObject2, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
      long l7 = System.currentTimeMillis();
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (((kotlin.g.b.p.h(localObject1, "") ^ true)) && (localObject2[0] == q.a.nNn) && ((localObject3 instanceof String)) && ((localObject4 instanceof String)))
      {
        long l8 = System.currentTimeMillis();
        this.rrt.d(m, this.mAppId, (String)localObject1, (String)localObject3, (String)localObject4);
        l1 += System.currentTimeMillis() - l8;
      }
      for (;;)
      {
        l4 = l7 - l6 + l4;
        break label470;
        localObject1 = new e.b(l4, l1, localArrayList.size());
        break;
        l1 = System.currentTimeMillis() - l5;
        if (5000L < l1)
        {
          com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 12L);
          Log.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
          k = this.rrt.adw(this.mAppId);
          m = this.rrt.adF(this.mAppId);
          Log.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
          if (k != j) {
            break label941;
          }
          i = 1;
          label855:
          if (m != paramInt) {
            break label946;
          }
          j = 1;
          label863:
          if ((i == 0) || (j == 0)) {
            break label951;
          }
          com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 1L);
        }
        for (;;)
        {
          if (m != paramInt)
          {
            localObject1 = new IllegalStateException("tansfer failed ");
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
            {
              localObject1 = (Throwable)localObject1;
              AppMethodBeat.o(50213);
              throw ((Throwable)localObject1);
              com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 11L);
              break;
              label941:
              i = 0;
              break label855;
              label946:
              j = 0;
              break label863;
              label951:
              if ((i == 0) && (j == 0))
              {
                com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 4L);
                continue;
              }
              if (i == 0)
              {
                com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 3L);
                continue;
              }
              if (j != 0) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.IzE.F(1016L, 2L);
              continue;
            }
            Log.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
          }
        }
        Log.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
        com.tencent.mm.plugin.report.service.h.IzE.a(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.rrt.adF(this.mAppId)) });
        kotlin.g.b.p.j(localSharedPreferences, "sharedPreferences");
        localSharedPreferences.edit().putBoolean(a.c(rru, this.mUin, this.mAppId), true).apply();
        if (f.nMh.bIs())
        {
          a(localSharedPreferences);
          localSharedPreferences.edit().putBoolean(a.c(rrw, this.mUin, this.mAppId), true).apply();
        }
        AppMethodBeat.o(50213);
        return;
      }
    }
  }
  
  public final boolean uQ(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(50215);
    if (!MMApplicationContext.getDefaultPreference().getBoolean(a.c(rrw, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    Log.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(bool)));
    AppMethodBeat.o(50215);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static int bkF(String paramString)
    {
      AppMethodBeat.i(50211);
      kotlin.g.b.p.k(paramString, "appId");
      SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
      long l = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).aee(paramString)).longValue();
      int i;
      if (localSharedPreferences.getBoolean(c(e.bAO(), l, paramString), false)) {
        i = 2;
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
        AppMethodBeat.o(50211);
        return i;
        if ((localSharedPreferences.getBoolean(c(e.bIq(), l, paramString), false)) && (!f.nMh.bIt())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
    
    public static String c(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(50210);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "appId");
      paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
      AppMethodBeat.o(50210);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e
 * JD-Core Version:    0.7.0.1
 */