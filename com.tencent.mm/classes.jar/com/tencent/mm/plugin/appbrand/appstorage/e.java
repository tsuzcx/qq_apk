package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class e
  extends am
{
  private static final String jMb = "hadTransferToMMKV";
  private static final String jMi = "keyHadCleanOldScheme";
  private static final String jMj = "keyHadFinishTransfer";
  public static final a jMk;
  private final h jMa;
  private final String mAppId;
  private final long mUin;
  
  static
  {
    AppMethodBeat.i(50217);
    jMk = new a((byte)0);
    jMb = "hadTransferToMMKV";
    jMi = "keyHadCleanOldScheme";
    jMj = "keyHadFinishTransfer";
    AppMethodBeat.o(50217);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(50216);
    this.mAppId = paramString;
    this.jMa = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dg(this.mAppId);
    this.mUin = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Mz(this.mAppId)).longValue();
    AppMethodBeat.o(50216);
  }
  
  private final void a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(50214);
    if (paramSharedPreferences.getBoolean(a.e(jMi, this.mUin, this.mAppId), false))
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(50214);
      return;
    }
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    j.Ei().LW(this.mAppId);
    paramSharedPreferences.edit().putBoolean(a.e(jMi, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(50214);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final boolean op(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(50215);
    if (!aj.fkD().getBoolean(a.e(jMj, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(bool)));
    AppMethodBeat.o(50215);
    return bool;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(50213);
    if (!f.jMf.bbt())
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(50213);
      return;
    }
    SharedPreferences localSharedPreferences = aj.fkD();
    if (f.jMf.bbr())
    {
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(a.e(jMb, this.mUin, this.mAppId), false).apply();
      this.jMa.LW(this.mAppId);
      AppMethodBeat.o(50213);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(a.e(jMb, this.mUin, this.mAppId), false);
    if ((bool) && (f.jMf.bbq()))
    {
      d.g.b.p.g(localSharedPreferences, "sharedPreferences");
      a(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(a.e(jMj, this.mUin, this.mAppId), true).apply();
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
    com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 0L);
    long l5 = System.currentTimeMillis();
    ad.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.jMa.LW(this.mAppId);
    int[] arrayOfInt = j.Ei().LX(this.mAppId);
    d.g.b.p.g(arrayOfInt, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
    int j = j.Ei().LY(this.mAppId);
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
      localObject2 = j.Ei().V(m, this.mAppId)[0];
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localArrayList = (ArrayList)localObject1;
      if (localArrayList == null) {}
      for (localObject1 = new b(0L, 0L, 0);; localObject1 = new b(0L, 0L, 0))
      {
        l1 = ((b)localObject1).kLD;
        l4 = ((b)localObject1).kLE;
        m = ((b)localObject1).size;
        i += 1;
        l3 += l4;
        l2 += l1;
        paramInt += m;
        break;
        if (localArrayList.size() != 0) {
          break label428;
        }
      }
      label428:
      ad.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + localArrayList.size());
      l4 = 0L;
      Iterator localIterator = ((Iterable)localArrayList).iterator();
      l1 = 0L;
      label472:
      if (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        if (localObject1 != null) {
          break label1195;
        }
        localObject1 = "";
      }
    }
    label1195:
    for (;;)
    {
      long l6 = System.currentTimeMillis();
      localObject2 = j.Ei().k(m, this.mAppId, (String)localObject1);
      d.g.b.p.g(localObject2, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
      long l7 = System.currentTimeMillis();
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (((d.g.b.p.i(localObject1, "") ^ true)) && (localObject2[0] == o.a.jMT) && ((localObject3 instanceof String)) && ((localObject4 instanceof String)))
      {
        long l8 = System.currentTimeMillis();
        this.jMa.c(m, this.mAppId, (String)localObject1, (String)localObject3, (String)localObject4);
        l1 += System.currentTimeMillis() - l8;
      }
      for (;;)
      {
        l4 = l7 - l6 + l4;
        break label472;
        localObject1 = new b(l4, l1, localArrayList.size());
        break;
        l1 = System.currentTimeMillis() - l5;
        if (5000L < l1)
        {
          com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 12L);
          ad.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
          k = this.jMa.LY(this.mAppId);
          m = this.jMa.Mh(this.mAppId);
          ad.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
          if (k != j) {
            break label943;
          }
          i = 1;
          label857:
          if (m != paramInt) {
            break label948;
          }
          j = 1;
          label865:
          if ((i == 0) || (j == 0)) {
            break label953;
          }
          com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 1L);
        }
        for (;;)
        {
          if (m != paramInt)
          {
            localObject1 = new IllegalStateException("tansfer failed ");
            if ((i.IS_FLAVOR_RED) || (i.DEBUG))
            {
              localObject1 = (Throwable)localObject1;
              AppMethodBeat.o(50213);
              throw ((Throwable)localObject1);
              com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 11L);
              break;
              label943:
              i = 0;
              break label857;
              label948:
              j = 0;
              break label865;
              label953:
              if ((i == 0) && (j == 0))
              {
                com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 4L);
                continue;
              }
              if (i == 0)
              {
                com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 3L);
                continue;
              }
              if (j != 0) {
                continue;
              }
              com.tencent.mm.plugin.report.service.g.yhR.A(1016L, 2L);
              continue;
            }
            ad.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
          }
        }
        ad.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
        com.tencent.mm.plugin.report.service.g.yhR.f(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.jMa.Mh(this.mAppId)) });
        d.g.b.p.g(localSharedPreferences, "sharedPreferences");
        localSharedPreferences.edit().putBoolean(a.e(jMb, this.mUin, this.mAppId), true).apply();
        if (f.jMf.bbq())
        {
          a(localSharedPreferences);
          localSharedPreferences.edit().putBoolean(a.e(jMj, this.mUin, this.mAppId), true).apply();
        }
        AppMethodBeat.o(50213);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static int Mb(String paramString)
    {
      AppMethodBeat.i(50211);
      d.g.b.p.h(paramString, "appId");
      SharedPreferences localSharedPreferences = aj.fkD();
      long l = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Mz(paramString)).longValue();
      int i;
      if (localSharedPreferences.getBoolean(e(e.Mr(), l, paramString), false)) {
        i = 2;
      }
      for (;;)
      {
        ad.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
        AppMethodBeat.o(50211);
        return i;
        if ((localSharedPreferences.getBoolean(e(e.Ms(), l, paramString), false)) && (!f.jMf.bbr())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
    
    public static String e(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(50210);
      d.g.b.p.h(paramString1, "key");
      d.g.b.p.h(paramString2, "appId");
      paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
      AppMethodBeat.o(50210);
      return paramString1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  static final class b
  {
    long kLD;
    long kLE;
    final int size;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.kLD = paramLong1;
      this.kLE = paramLong2;
      this.size = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.kLD != paramObject.kLD) || (this.kLE != paramObject.kLE) || (this.size != paramObject.size)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.kLD;
      int i = (int)(l ^ l >>> 32);
      l = this.kLE;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.size;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50212);
      String str = "Result(readTime=" + this.kLD + ", writeTime=" + this.kLE + ", size=" + this.size + ")";
      AppMethodBeat.o(50212);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e
 * JD-Core Version:    0.7.0.1
 */