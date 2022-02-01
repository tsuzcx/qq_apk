package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "encryptMMKVStorageSecretKey", "(Ljava/lang/String;Ljava/lang/String;)V", "encryptMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptMMKVStorage;", "mAppId", "mUin", "", "noEncryptMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "clearOldSchemeData", "", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToEncryptMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends au
{
  public static final a.a qLF;
  private final String mAppId;
  private final long mUin;
  private final c qLG;
  private final l qLH;
  
  static
  {
    AppMethodBeat.i(323134);
    qLF = new a.a((byte)0);
    AppMethodBeat.o(323134);
  }
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(323122);
    this.mAppId = paramString1;
    c.a locala = c.qLN;
    this.qLG = c.a.a(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue(), paramString1, paramString2, null);
    paramString2 = l.qMo;
    this.qLH = l.a.jA(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue());
    this.mUin = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(this.mAppId)).longValue();
    AppMethodBeat.o(323122);
  }
  
  private final void chQ()
  {
    AppMethodBeat.i(323127);
    k localk = k.qMi;
    if (k.t(this.mUin, this.mAppId))
    {
      Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "[transfer] had clear old scheme data, return");
      AppMethodBeat.o(323127);
      return;
    }
    Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "[transfer] clear old scheme data");
    this.qLH.VW(this.mAppId);
    localk = k.qMi;
    k.r(this.mUin, this.mAppId);
    AppMethodBeat.o(323127);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandEncryptKVStorageTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(323157);
    if (!b.qLK.chT())
    {
      Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "[transfer] isNeedTransfer = false");
      AppMethodBeat.o(323157);
      return;
    }
    if (b.qLK.chS())
    {
      Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "rollback phases, clear [had transfer to encrypt mmkv] flag");
      localObject1 = k.qMi;
      k.q(this.mUin, this.mAppId);
      this.qLG.chU();
      AppMethodBeat.o(323157);
      return;
    }
    Object localObject1 = k.qMi;
    boolean bool = k.u(this.mUin, this.mAppId);
    if ((bool) && (b.qLK.chR()))
    {
      chQ();
      localObject1 = k.qMi;
      k.o(this.mUin, this.mAppId);
      AppMethodBeat.o(323157);
      return;
    }
    if (bool)
    {
      Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "[transfer] had transfer to encrypt mmkv, return");
      AppMethodBeat.o(323157);
      return;
    }
    Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "start transfer");
    paramInt = 0;
    com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 0L, 1L);
    long l5 = System.currentTimeMillis();
    Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "clear MMKV");
    this.qLG.chU();
    int[] arrayOfInt = this.qLH.VX(this.mAppId);
    int j = this.qLH.VT(this.mAppId);
    int k = arrayOfInt.length;
    int i = 0;
    long l3 = 0L;
    long l2 = 0L;
    Object localObject2;
    label269:
    long l1;
    long l4;
    label339:
    label362:
    long l6;
    label398:
    label432:
    long l7;
    if (i < k)
    {
      int m = arrayOfInt[i];
      localObject1 = this.qLH.aj(m, this.mAppId)[0];
      if ((localObject1 instanceof ArrayList))
      {
        localObject2 = (ArrayList)localObject1;
        if (localObject2 != null) {
          break label339;
        }
      }
      for (localObject1 = new a.b(0L, 0L, 0);; localObject1 = new a.b(0L, 0L, 0))
      {
        l1 = ((a.b)localObject1).qLI;
        l4 = ((a.b)localObject1).qLJ;
        m = ((a.b)localObject1).size;
        i += 1;
        l3 += l4;
        l2 += l1;
        paramInt += m;
        break;
        localObject2 = null;
        break label269;
        if (((ArrayList)localObject2).size() != 0) {
          break label362;
        }
      }
      Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", s.X("[transfer] key size = ", Integer.valueOf(((ArrayList)localObject2).size())));
      l4 = 0L;
      Iterator localIterator = ((Iterable)localObject2).iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
          l6 = System.currentTimeMillis();
          localObject1 = this.qLH.p(m, this.mAppId, (String)localObject3);
          ah localah = ah.aiuX;
          l7 = System.currentTimeMillis();
          localah = localObject1[1];
          Object localObject4 = localObject1[2];
          if ((s.p(localObject3, "")) || (localObject1[0] != v.a.qNg) || (!(localah instanceof String)) || (!(localObject4 instanceof String))) {
            break label1035;
          }
          long l8 = System.currentTimeMillis();
          this.qLG.d(m, this.mAppId, (String)localObject3, (String)localah, (String)localObject4);
          localObject1 = ah.aiuX;
          l1 += System.currentTimeMillis() - l8;
        }
      }
    }
    label1035:
    for (;;)
    {
      l4 = l7 - l6 + l4;
      break label398;
      localObject1 = null;
      break label432;
      localObject1 = new a.b(l4, l1, ((ArrayList)localObject2).size());
      break;
      l1 = System.currentTimeMillis() - l5;
      if (5000L < l1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 10L, 1L);
        Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "finish transfer, cost total time= " + l1 + " ms read time = " + l2 + " ms, write time = " + l3 + " ms");
        i = this.qLG.VT(this.mAppId);
        localObject1 = this.qLG;
        localObject2 = this.mAppId;
        s.u(localObject2, "appId");
        k = ((c)localObject1).qLP.Wg((String)localObject2);
        Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "newbytes =" + i + " oldbytes =" + j + "  newsize =" + k + "  oldsize =" + paramInt + ' ');
        if (i != j) {
          break label885;
        }
        i = 1;
        label804:
        if (k != paramInt) {
          break label890;
        }
        j = 1;
        label812:
        if ((i == 0) || (j == 0)) {
          break label895;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 1L, 1L);
      }
      for (;;)
      {
        if (k != paramInt)
        {
          localObject1 = new IllegalStateException("tansfer failed ");
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
          {
            AppMethodBeat.o(323157);
            throw ((Throwable)localObject1);
            com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 9L, 1L);
            break;
            label885:
            i = 0;
            break label804;
            label890:
            j = 0;
            break label812;
            label895:
            if ((i == 0) && (j == 0))
            {
              com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 4L, 1L);
              continue;
            }
            if (i == 0)
            {
              com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 3L, 1L);
              continue;
            }
            if (j != 0) {
              continue;
            }
            com.tencent.mm.plugin.report.service.h.OAn.p(1817L, 2L, 1L);
            continue;
          }
          Log.printErrStackTrace("MicroMsg.AppBrandEncryptKVStorageTransfer", (Throwable)localObject1, "transfer failed", new Object[0]);
        }
      }
      Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", "finish transfer, prev ");
      localObject1 = k.qMi;
      k.p(this.mUin, this.mAppId);
      if (b.qLK.chR())
      {
        chQ();
        localObject1 = k.qMi;
        k.o(this.mUin, this.mAppId);
      }
      AppMethodBeat.o(323157);
      return;
    }
  }
  
  public final boolean vc(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(323162);
    Object localObject = MMApplicationContext.getDefaultPreference();
    i.a locala = i.uxx;
    locala = i.uxx;
    boolean bool1 = bool2;
    if (((SharedPreferences)localObject).getBoolean(i.a.b(i.cOM(), this.mUin, this.mAppId), false))
    {
      localObject = k.qMi;
      bool1 = bool2;
      if (!k.s(this.mUin, this.mAppId)) {
        bool1 = true;
      }
    }
    Log.i("MicroMsg.AppBrandEncryptKVStorageTransfer", s.X("needTransfer ", Boolean.valueOf(bool1)));
    AppMethodBeat.o(323162);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.a
 * JD-Core Version:    0.7.0.1
 */