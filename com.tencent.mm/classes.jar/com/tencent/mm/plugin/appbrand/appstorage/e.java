package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class e
  extends al
{
  private static final String jse = "hadTransferToMMKV";
  private static final String jsf = "keyHadCleanOldScheme";
  private static final String jsg = "keyHadFinishTransfer";
  public static final a jsh;
  private final h jsd;
  private final String mAppId;
  private final long mUin;
  
  static
  {
    AppMethodBeat.i(50217);
    jsh = new a((byte)0);
    jse = "hadTransferToMMKV";
    jsf = "keyHadCleanOldScheme";
    jsg = "keyHadFinishTransfer";
    AppMethodBeat.o(50217);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(50216);
    this.mAppId = paramString;
    this.jsd = ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).ch(this.mAppId);
    this.mUin = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ji(this.mAppId)).longValue();
    AppMethodBeat.o(50216);
  }
  
  private final void a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(50214);
    if (paramSharedPreferences.getBoolean(a.e(jsf, this.mUin, this.mAppId), false))
    {
      ac.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(50214);
      return;
    }
    ac.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    j.CJ().IF(this.mAppId);
    paramSharedPreferences.edit().putBoolean(a.e(jsf, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(50214);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final boolean nP(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(50215);
    if (!ai.eUY().getBoolean(a.e(jsg, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    ac.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(bool)));
    AppMethodBeat.o(50215);
    return bool;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(50213);
    if (!f.jsl.aXV())
    {
      ac.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(50213);
      return;
    }
    SharedPreferences localSharedPreferences = ai.eUY();
    if (f.jsl.aXT())
    {
      ac.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(a.e(jse, this.mUin, this.mAppId), false).apply();
      this.jsd.IF(this.mAppId);
      AppMethodBeat.o(50213);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(a.e(jse, this.mUin, this.mAppId), false);
    if ((bool) && (f.jsl.aXS()))
    {
      k.g(localSharedPreferences, "sharedPreferences");
      a(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(a.e(jsg, this.mUin, this.mAppId), true).apply();
      AppMethodBeat.o(50213);
      return;
    }
    if (bool)
    {
      ac.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
      AppMethodBeat.o(50213);
      return;
    }
    ac.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
    com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 0L);
    long l5 = System.currentTimeMillis();
    ac.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.jsd.IF(this.mAppId);
    int[] arrayOfInt = j.CJ().IG(this.mAppId);
    k.g(arrayOfInt, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
    int j = j.CJ().IH(this.mAppId);
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
      localObject2 = j.CJ().T(m, this.mAppId)[0];
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localArrayList = (ArrayList)localObject1;
      if (localArrayList == null) {}
      for (localObject1 = new b(0L, 0L, 0);; localObject1 = new b(0L, 0L, 0))
      {
        l1 = ((b)localObject1).jso;
        l4 = ((b)localObject1).jsp;
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
      ac.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + localArrayList.size());
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
      localObject2 = j.CJ().k(m, this.mAppId, (String)localObject1);
      k.g(localObject2, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
      long l7 = System.currentTimeMillis();
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (((k.g(localObject1, "") ^ true)) && (localObject2[0] == o.a.jsZ) && ((localObject3 instanceof String)) && ((localObject4 instanceof String)))
      {
        long l8 = System.currentTimeMillis();
        this.jsd.c(m, this.mAppId, (String)localObject1, (String)localObject3, (String)localObject4);
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
          com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 12L);
          ac.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
          k = this.jsd.IH(this.mAppId);
          m = this.jsd.IQ(this.mAppId);
          ac.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
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
          com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 1L);
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
              com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 11L);
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
                com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 4L);
                continue;
              }
              if (i == 0)
              {
                com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 3L);
                continue;
              }
              if (j != 0) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.wUl.A(1016L, 2L);
              continue;
            }
            ac.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
          }
        }
        ac.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
        com.tencent.mm.plugin.report.service.h.wUl.f(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.jsd.IQ(this.mAppId)) });
        k.g(localSharedPreferences, "sharedPreferences");
        localSharedPreferences.edit().putBoolean(a.e(jse, this.mUin, this.mAppId), true).apply();
        if (f.jsl.aXS())
        {
          a(localSharedPreferences);
          localSharedPreferences.edit().putBoolean(a.e(jsg, this.mUin, this.mAppId), true).apply();
        }
        AppMethodBeat.o(50213);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static int IO(String paramString)
    {
      AppMethodBeat.i(50211);
      k.h(paramString, "appId");
      SharedPreferences localSharedPreferences = ai.eUY();
      long l = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ji(paramString)).longValue();
      int i;
      if (localSharedPreferences.getBoolean(e(e.aRE(), l, paramString), false)) {
        i = 2;
      }
      for (;;)
      {
        ac.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
        AppMethodBeat.o(50211);
        return i;
        if ((localSharedPreferences.getBoolean(e(e.aXQ(), l, paramString), false)) && (!f.jsl.aXT())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
    
    public static String e(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(50210);
      k.h(paramString1, "key");
      k.h(paramString2, "appId");
      paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
      AppMethodBeat.o(50210);
      return paramString1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  static final class b
  {
    long jso;
    long jsp;
    final int size;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.jso = paramLong1;
      this.jsp = paramLong2;
      this.size = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.jso != paramObject.jso) || (this.jsp != paramObject.jsp) || (this.size != paramObject.size)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.jso;
      int i = (int)(l ^ l >>> 32);
      l = this.jsp;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.size;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50212);
      String str = "Result(readTime=" + this.jso + ", writeTime=" + this.jsp + ", size=" + this.size + ")";
      AppMethodBeat.o(50212);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e
 * JD-Core Version:    0.7.0.1
 */