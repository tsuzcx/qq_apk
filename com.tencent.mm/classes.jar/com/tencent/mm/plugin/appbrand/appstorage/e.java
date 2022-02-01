package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class e
  extends ao
{
  private static final String jPu = "hadTransferToMMKV";
  private static final String jPv = "keyHadCleanOldScheme";
  private static final String jPw = "keyHadFinishTransfer";
  public static final a kRd;
  private final h jPn;
  private final String mAppId;
  private final long mUin;
  
  static
  {
    AppMethodBeat.i(50217);
    kRd = new a((byte)0);
    jPu = "hadTransferToMMKV";
    jPv = "keyHadCleanOldScheme";
    jPw = "keyHadFinishTransfer";
    AppMethodBeat.o(50217);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(50216);
    this.mAppId = paramString;
    this.jPn = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dl(this.mAppId);
    this.mUin = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ng(this.mAppId)).longValue();
    AppMethodBeat.o(50216);
  }
  
  private final void a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(50214);
    if (paramSharedPreferences.getBoolean(a.e(jPv, this.mUin, this.mAppId), false))
    {
      ae.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(50214);
      return;
    }
    ae.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    com.tencent.mm.plugin.appbrand.app.j.El().MA(this.mAppId);
    paramSharedPreferences.edit().putBoolean(a.e(jPv, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(50214);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final boolean os(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(50215);
    if (!ak.fox().getBoolean(a.e(jPw, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    ae.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(bool)));
    AppMethodBeat.o(50215);
    return bool;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(50213);
    if (!f.jPr.bbV())
    {
      ae.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(50213);
      return;
    }
    SharedPreferences localSharedPreferences = ak.fox();
    if (f.jPr.bbT())
    {
      ae.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(a.e(jPu, this.mUin, this.mAppId), false).apply();
      this.jPn.MA(this.mAppId);
      AppMethodBeat.o(50213);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(a.e(jPu, this.mUin, this.mAppId), false);
    if ((bool) && (f.jPr.bbS()))
    {
      d.g.b.p.g(localSharedPreferences, "sharedPreferences");
      a(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(a.e(jPw, this.mUin, this.mAppId), true).apply();
      AppMethodBeat.o(50213);
      return;
    }
    if (bool)
    {
      ae.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
      AppMethodBeat.o(50213);
      return;
    }
    ae.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
    com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 0L);
    long l5 = System.currentTimeMillis();
    ae.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.jPn.MA(this.mAppId);
    int[] arrayOfInt = com.tencent.mm.plugin.appbrand.app.j.El().MB(this.mAppId);
    d.g.b.p.g(arrayOfInt, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
    int j = com.tencent.mm.plugin.appbrand.app.j.El().MC(this.mAppId);
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
      localObject2 = com.tencent.mm.plugin.appbrand.app.j.El().V(m, this.mAppId)[0];
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localArrayList = (ArrayList)localObject1;
      if (localArrayList == null) {}
      for (localObject1 = new b(0L, 0L, 0);; localObject1 = new b(0L, 0L, 0))
      {
        l1 = ((b)localObject1).kRe;
        l4 = ((b)localObject1).kRg;
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
      ae.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + localArrayList.size());
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
      localObject2 = com.tencent.mm.plugin.appbrand.app.j.El().k(m, this.mAppId, (String)localObject1);
      d.g.b.p.g(localObject2, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
      long l7 = System.currentTimeMillis();
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (((d.g.b.p.i(localObject1, "") ^ true)) && (localObject2[0] == p.a.jQg) && ((localObject3 instanceof String)) && ((localObject4 instanceof String)))
      {
        long l8 = System.currentTimeMillis();
        this.jPn.c(m, this.mAppId, (String)localObject1, (String)localObject3, (String)localObject4);
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
          com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 12L);
          ae.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
          k = this.jPn.MC(this.mAppId);
          m = this.jPn.ML(this.mAppId);
          ae.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
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
          com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 1L);
        }
        for (;;)
        {
          if (m != paramInt)
          {
            localObject1 = new IllegalStateException("tansfer failed ");
            if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG))
            {
              localObject1 = (Throwable)localObject1;
              AppMethodBeat.o(50213);
              throw ((Throwable)localObject1);
              com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 11L);
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
                com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 4L);
                continue;
              }
              if (i == 0)
              {
                com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 3L);
                continue;
              }
              if (j != 0) {
                continue;
              }
              com.tencent.mm.plugin.report.service.g.yxI.A(1016L, 2L);
              continue;
            }
            ae.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
          }
        }
        ae.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
        com.tencent.mm.plugin.report.service.g.yxI.f(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.jPn.ML(this.mAppId)) });
        d.g.b.p.g(localSharedPreferences, "sharedPreferences");
        localSharedPreferences.edit().putBoolean(a.e(jPu, this.mUin, this.mAppId), true).apply();
        if (f.jPr.bbS())
        {
          a(localSharedPreferences);
          localSharedPreferences.edit().putBoolean(a.e(jPw, this.mUin, this.mAppId), true).apply();
        }
        AppMethodBeat.o(50213);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static int ME(String paramString)
    {
      AppMethodBeat.i(50211);
      d.g.b.p.h(paramString, "appId");
      SharedPreferences localSharedPreferences = ak.fox();
      long l = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ng(paramString)).longValue();
      int i;
      if (localSharedPreferences.getBoolean(e(e.bbQ(), l, paramString), false)) {
        i = 2;
      }
      for (;;)
      {
        ae.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
        AppMethodBeat.o(50211);
        return i;
        if ((localSharedPreferences.getBoolean(e(e.bbR(), l, paramString), false)) && (!f.jPr.bbT())) {
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  static final class b
  {
    long kRe;
    long kRg;
    final int size;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.kRe = paramLong1;
      this.kRg = paramLong2;
      this.size = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.kRe != paramObject.kRe) || (this.kRg != paramObject.kRg) || (this.size != paramObject.size)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.kRe;
      int i = (int)(l ^ l >>> 32);
      l = this.kRg;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.size;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50212);
      String str = "Result(readTime=" + this.kRe + ", writeTime=" + this.kRg + ", size=" + this.size + ")";
      AppMethodBeat.o(50212);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e
 * JD-Core Version:    0.7.0.1
 */