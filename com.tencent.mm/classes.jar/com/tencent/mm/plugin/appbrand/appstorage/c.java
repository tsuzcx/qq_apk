package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.b.j;
import a.l;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class c
  extends ai
{
  private static final String gZc = "hadTransferToMMKV";
  private static final String gZd = "keyHadCleanOldScheme";
  private static final String gZe = "keyHadFinishTransfer";
  public static final a gZf;
  private final f gZb;
  private final String mAppId;
  private final long mUin;
  
  static
  {
    AppMethodBeat.i(134486);
    gZf = new a((byte)0);
    gZc = "hadTransferToMMKV";
    gZd = "keyHadCleanOldScheme";
    gZe = "keyHadFinishTransfer";
    AppMethodBeat.o(134486);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(134485);
    this.mAppId = paramString;
    this.gZb = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).cc(this.mAppId);
    this.mUin = new p(((a)com.tencent.mm.kernel.g.E(a.class)).zt(this.mAppId)).longValue();
    AppMethodBeat.o(134485);
  }
  
  private final void a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(134483);
    if (paramSharedPreferences.getBoolean(a.b(gZd, this.mUin, this.mAppId), false))
    {
      ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(134483);
      return;
    }
    ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    com.tencent.mm.plugin.appbrand.app.g.wf().yR(this.mAppId);
    paramSharedPreferences.edit().putBoolean(a.b(gZd, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(134483);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(134484);
    if (!ah.dsQ().getBoolean(a.b(gZe, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    ab.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(bool)));
    AppMethodBeat.o(134484);
    return bool;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(134481);
    if (!d.gZl.awD())
    {
      ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(134481);
      return;
    }
    SharedPreferences localSharedPreferences = ah.dsQ();
    if (d.gZl.awB())
    {
      ab.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(a.b(gZc, this.mUin, this.mAppId), false).apply();
      this.gZb.yR(this.mAppId);
      AppMethodBeat.o(134481);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(a.b(gZc, this.mUin, this.mAppId), false);
    if ((bool) && (d.gZl.awA()))
    {
      j.p(localSharedPreferences, "sharedPreferences");
      a(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(a.b(gZe, this.mUin, this.mAppId), true).apply();
      AppMethodBeat.o(134481);
      return;
    }
    if (bool)
    {
      ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
      AppMethodBeat.o(134481);
      return;
    }
    ab.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
    h.qsU.B(1016L, 0L);
    long l5 = System.currentTimeMillis();
    ab.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.gZb.yR(this.mAppId);
    int[] arrayOfInt = com.tencent.mm.plugin.appbrand.app.g.wf().yS(this.mAppId);
    j.p(arrayOfInt, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
    int j = com.tencent.mm.plugin.appbrand.app.g.wf().yT(this.mAppId);
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
      localObject2 = com.tencent.mm.plugin.appbrand.app.g.wf().J(m, this.mAppId)[0];
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localArrayList = (ArrayList)localObject1;
      if (localArrayList == null) {}
      for (localObject1 = new c.b(0L, 0L, 0);; localObject1 = new c.b(0L, 0L, 0))
      {
        l1 = ((c.b)localObject1).gZg;
        l4 = ((c.b)localObject1).gZh;
        m = ((c.b)localObject1).size;
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
      ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + localArrayList.size());
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
      localObject2 = com.tencent.mm.plugin.appbrand.app.g.wf().k(m, this.mAppId, (String)localObject1);
      j.p(localObject2, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
      long l7 = System.currentTimeMillis();
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (((j.e(localObject1, "") ^ true)) && (localObject2[0] == m.a.gZV) && ((localObject3 instanceof String)) && ((localObject4 instanceof String)))
      {
        long l8 = System.currentTimeMillis();
        this.gZb.b(m, this.mAppId, (String)localObject1, (String)localObject3, (String)localObject4);
        l1 += System.currentTimeMillis() - l8;
      }
      for (;;)
      {
        l4 = l7 - l6 + l4;
        break label471;
        localObject1 = new c.b(l4, l1, localArrayList.size());
        break;
        l1 = System.currentTimeMillis() - l5;
        if (5000L < l1)
        {
          h.qsU.B(1016L, 12L);
          ab.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
          k = this.gZb.yT(this.mAppId);
          m = this.gZb.zc(this.mAppId);
          ab.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
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
          h.qsU.B(1016L, 1L);
        }
        for (;;)
        {
          if (m != paramInt)
          {
            localObject1 = new IllegalStateException("tansfer failed ");
            if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.DEBUG))
            {
              localObject1 = (Throwable)localObject1;
              AppMethodBeat.o(134481);
              throw ((Throwable)localObject1);
              h.qsU.B(1016L, 11L);
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
                h.qsU.B(1016L, 4L);
                continue;
              }
              if (i == 0)
              {
                h.qsU.B(1016L, 3L);
                continue;
              }
              if (j != 0) {
                continue;
              }
              h.qsU.B(1016L, 2L);
              continue;
            }
            ab.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
          }
        }
        ab.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
        h.qsU.e(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.gZb.zc(this.mAppId)) });
        j.p(localSharedPreferences, "sharedPreferences");
        localSharedPreferences.edit().putBoolean(a.b(gZc, this.mUin, this.mAppId), true).apply();
        if (d.gZl.awA())
        {
          a(localSharedPreferences);
          localSharedPreferences.edit().putBoolean(a.b(gZe, this.mUin, this.mAppId), true).apply();
        }
        AppMethodBeat.o(134481);
        return;
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String b(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(143733);
      j.q(paramString1, "key");
      j.q(paramString2, "appId");
      paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
      AppMethodBeat.o(143733);
      return paramString1;
    }
    
    public static int yV(String paramString)
    {
      AppMethodBeat.i(134479);
      j.q(paramString, "appId");
      SharedPreferences localSharedPreferences = ah.dsQ();
      long l = new p(((a)com.tencent.mm.kernel.g.E(a.class)).zt(paramString)).longValue();
      int i;
      if (localSharedPreferences.getBoolean(b(c.awF(), l, paramString), false)) {
        i = 2;
      }
      for (;;)
      {
        ab.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
        AppMethodBeat.o(134479);
        return i;
        if ((localSharedPreferences.getBoolean(b(c.aOC(), l, paramString), false)) && (!d.gZl.awB())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c
 * JD-Core Version:    0.7.0.1
 */