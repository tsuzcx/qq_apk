package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends au
{
  private static final String uxA;
  private static final String uxB;
  public static final i.a uxx;
  private static final String uxz;
  private final String mAppId;
  private final long mUin;
  private final l uxy;
  
  static
  {
    AppMethodBeat.i(50217);
    uxx = new i.a((byte)0);
    uxz = "hadTransferToMMKV";
    uxA = "keyHadCleanOldScheme";
    uxB = "keyHadFinishTransfer";
    AppMethodBeat.o(50217);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(50216);
    this.mAppId = paramString;
    l.a locala = l.qMo;
    this.uxy = l.a.jA(new p(((a)com.tencent.mm.kernel.h.ax(a.class)).WE(paramString)).longValue());
    this.mUin = new p(((a)com.tencent.mm.kernel.h.ax(a.class)).WE(this.mAppId)).longValue();
    AppMethodBeat.o(50216);
  }
  
  private final void b(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(50214);
    if (paramSharedPreferences.getBoolean(i.a.b(uxA, this.mUin, this.mAppId), false))
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(50214);
      return;
    }
    Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
    n.aqR().VW(this.mAppId);
    paramSharedPreferences.edit().putBoolean(i.a.b(uxA, this.mUin, this.mAppId), true).apply();
    AppMethodBeat.o(50214);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandKVStorageTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(50213);
    if (!j.qMg.chT())
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(50213);
      return;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (j.qMg.chS())
    {
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
      localSharedPreferences.edit().putBoolean(i.a.b(uxz, this.mUin, this.mAppId), false).apply();
      this.uxy.VW(this.mAppId);
      AppMethodBeat.o(50213);
      return;
    }
    boolean bool = localSharedPreferences.getBoolean(i.a.b(uxz, this.mUin, this.mAppId), false);
    if ((bool) && (j.qMg.chR()))
    {
      s.s(localSharedPreferences, "sharedPreferences");
      b(localSharedPreferences);
      localSharedPreferences.edit().putBoolean(i.a.b(uxB, this.mUin, this.mAppId), true).apply();
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
    paramInt = 0;
    com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 0L, 1L);
    long l5 = System.currentTimeMillis();
    Log.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
    this.uxy.VW(this.mAppId);
    int[] arrayOfInt = n.aqR().VX(this.mAppId);
    s.s(arrayOfInt, "getAppKVStorage().getAllStorageId(mAppId)");
    int j = n.aqR().VT(this.mAppId);
    int k = arrayOfInt.length;
    int i = 0;
    long l3 = 0L;
    long l2 = 0L;
    int m;
    Object localObject1;
    ArrayList localArrayList;
    label333:
    long l1;
    long l4;
    label403:
    label426:
    label463:
    label497:
    long l6;
    long l7;
    if (i < k)
    {
      m = arrayOfInt[i];
      localObject1 = n.aqR().aj(m, this.mAppId)[0];
      if ((localObject1 instanceof ArrayList))
      {
        localArrayList = (ArrayList)localObject1;
        if (localArrayList != null) {
          break label403;
        }
      }
      for (localObject1 = new i.b(0L, 0L, 0);; localObject1 = new i.b(0L, 0L, 0))
      {
        l1 = ((i.b)localObject1).qLI;
        l4 = ((i.b)localObject1).qLJ;
        m = ((i.b)localObject1).size;
        i += 1;
        l3 += l4;
        l2 += l1;
        paramInt += m;
        break;
        localArrayList = null;
        break label333;
        if (localArrayList.size() != 0) {
          break label426;
        }
      }
      Log.i("MicroMsg.AppBrandKVStorageTransfer", s.X("[transfer] key size = ", Integer.valueOf(localArrayList.size())));
      l4 = 0L;
      Iterator localIterator = ((Iterable)localArrayList).iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          l6 = System.currentTimeMillis();
          localObject1 = n.aqR().p(m, this.mAppId, (String)localObject2);
          s.s(localObject1, "getAppKVStorage().get(storageId, mAppId, key)");
          ah localah = ah.aiuX;
          l7 = System.currentTimeMillis();
          localah = localObject1[1];
          Object localObject3 = localObject1[2];
          if ((s.p(localObject2, "")) || (localObject1[0] != v.a.qNg) || (!(localah instanceof String)) || (!(localObject3 instanceof String))) {
            break label1193;
          }
          long l8 = System.currentTimeMillis();
          this.uxy.d(m, this.mAppId, (String)localObject2, (String)localah, (String)localObject3);
          localObject1 = ah.aiuX;
          l1 += System.currentTimeMillis() - l8;
        }
      }
    }
    label1193:
    for (;;)
    {
      l4 = l7 - l6 + l4;
      break label463;
      localObject1 = null;
      break label497;
      localObject1 = new i.b(l4, l1, localArrayList.size());
      break;
      l1 = System.currentTimeMillis() - l5;
      if (5000L < l1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 12L, 1L);
        Log.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
        k = this.uxy.VT(this.mAppId);
        m = this.uxy.Wg(this.mAppId);
        Log.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + k + " oldbytes =" + j + "  newsize =" + m + "  oldsize =" + paramInt + ' ');
        if (k != j) {
          break label941;
        }
        i = 1;
        label860:
        if (m != paramInt) {
          break label946;
        }
        j = 1;
        label868:
        if ((i == 0) || (j == 0)) {
          break label951;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 1L, 1L);
      }
      for (;;)
      {
        if (m != paramInt)
        {
          localObject1 = new IllegalStateException("tansfer failed ");
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
          {
            AppMethodBeat.o(50213);
            throw ((Throwable)localObject1);
            com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 11L, 1L);
            break;
            label941:
            i = 0;
            break label860;
            label946:
            j = 0;
            break label868;
            label951:
            if ((i == 0) && (j == 0))
            {
              com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 4L, 1L);
              continue;
            }
            if (i == 0)
            {
              com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 3L, 1L);
              continue;
            }
            if (j != 0) {
              continue;
            }
            com.tencent.mm.plugin.report.service.h.OAn.p(1016L, 2L, 1L);
            continue;
          }
          Log.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
        }
      }
      Log.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
      com.tencent.mm.plugin.report.service.h.OAn.b(16335, new Object[] { this.mAppId, Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(this.uxy.Wg(this.mAppId)) });
      s.s(localSharedPreferences, "sharedPreferences");
      localSharedPreferences.edit().putBoolean(i.a.b(uxz, this.mUin, this.mAppId), true).apply();
      if (j.qMg.chR())
      {
        b(localSharedPreferences);
        localSharedPreferences.edit().putBoolean(i.a.b(uxB, this.mUin, this.mAppId), true).apply();
      }
      AppMethodBeat.o(50213);
      return;
    }
  }
  
  public final boolean vc(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(50215);
    if (!MMApplicationContext.getDefaultPreference().getBoolean(i.a.b(uxB, this.mUin, this.mAppId), false)) {
      bool = true;
    }
    Log.i("MicroMsg.AppBrandKVStorageTransfer", s.X("needTransfer ", Boolean.valueOf(bool)));
    AppMethodBeat.o(50215);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */