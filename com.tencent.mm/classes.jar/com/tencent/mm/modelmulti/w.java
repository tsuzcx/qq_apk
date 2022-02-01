package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aad;
import com.tencent.mm.autogen.a.ba;
import com.tencent.mm.autogen.a.jo;
import com.tencent.mm.autogen.a.ri;
import com.tencent.mm.autogen.a.zd;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.fkw;
import com.tencent.mm.protocal.protobuf.fla;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mmkv.MMKV;
import com.tencent.threadpool.i;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelmulti/SyncServiceHandler;", "", "finishCmdCallback", "Lcom/tencent/mm/modelmulti/IOnFinishCmdCallback2;", "(Lcom/tencent/mm/modelmulti/IOnFinishCmdCallback2;)V", "continueSyncDataIdList", "Ljava/util/LinkedList;", "", "getFinishCmdCallback", "()Lcom/tencent/mm/modelmulti/IOnFinishCmdCallback2;", "processorMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/modelmulti/ISyncProcessor;", "Lkotlin/collections/HashMap;", "syncKv", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType", "getSyncKv", "()Lcom/tencent/mmkv/MMKV;", "syncKv$delegate", "Lkotlin/Lazy;", "syncLock", "continueSync", "", "syncData", "Lcom/tencent/mm/protocal/protobuf/SyncServiceData;", "continueSyncScene", "Lcom/tencent/mm/modelmulti/ContinueSyncScene;", "doProcessCmd", "processor", "finishCmd", "idKeyReportSyncMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/NewSyncResponse;", "mergeSyncBuf", "shouldMergeKeyBuf", "", "proc", "reflectScreenOn", "saveDiffTime", "clientTime", "", "serverTime", "Companion", "ProcessSyncData", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w.a oNV;
  private final Object hri;
  final d oNW;
  private final LinkedList<String> oNX;
  private final HashMap<Integer, e> oNY;
  private final j oNZ;
  
  static
  {
    AppMethodBeat.i(243161);
    oNV = new w.a((byte)0);
    AppMethodBeat.o(243161);
  }
  
  public w(d paramd)
  {
    AppMethodBeat.i(243124);
    this.oNW = paramd;
    this.oNX = new LinkedList();
    this.oNY = new HashMap();
    this.hri = new Object();
    this.oNZ = k.cm((a)c.oOb);
    AppMethodBeat.o(243124);
  }
  
  private static void Z(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(243131);
    long l = paramLong1 - paramLong2;
    Log.i("MicroMsg.SyncServiceHandler", "client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l), Long.valueOf(l / 1000L) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acRu, Long.valueOf(l));
    cn.iw(paramLong2);
    AppMethodBeat.o(243131);
  }
  
  public static void a(fla paramfla)
  {
    AppMethodBeat.i(243148);
    s.u(paramfla, "syncData");
    duk localduk = paramfla.abLA;
    if (localduk != null)
    {
      com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(localduk.YYp));
      if ((localduk.YYp & paramfla.selector) == 0) {
        break label219;
      }
    }
    label219:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        new c().fW(new f(paramfla));
      }
      if ((i == 0) && ((localduk.YYp & 0x100) != 0))
      {
        paramfla = new zd();
        paramfla.icq.sourceType = 3;
        paramfla.publish();
      }
      if ((i == 0) && ((localduk.YYp & 0x200000) != 0)) {
        new ri().publish();
      }
      if ((i == 0) && ((localduk.YYp & 0x80) != 0)) {
        new aad().publish();
      }
      if ((i == 0) && ((localduk.YYp & 0x1000000) != 0)) {
        new jo().publish();
      }
      if ((i == 0) && ((localduk.YYp & 0x20) != 0)) {
        new ba().publish();
      }
      AppMethodBeat.o(243148);
      return;
    }
  }
  
  private static void a(boolean paramBoolean, duk paramduk, Object paramObject)
  {
    AppMethodBeat.i(243137);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(8195, "");
    if (localObject == null)
    {
      paramduk = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(243137);
      throw paramduk;
    }
    byte[] arrayOfByte2 = Util.decodeHexString(Util.nullAsNil((String)localObject));
    byte[] arrayOfByte1 = com.tencent.mm.platformtools.w.a(paramduk.ZdD);
    Log.i("MicroMsg.SyncServiceHandler", "mergeSyncBuf processResp %s synckey req:%s  shouldMerge:%s", new Object[] { paramObject, ad.de(arrayOfByte2), Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.SyncServiceHandler", "mergeSyncBuf processResp %s synckey resp:%s", new Object[] { paramObject, ad.de(arrayOfByte1) });
    if (paramduk.ZdD != null)
    {
      localObject = paramduk.ZdD;
      if (localObject == null)
      {
        i = 0;
        if (i <= 0) {
          break label337;
        }
        if (paramBoolean)
        {
          localObject = ad.o(arrayOfByte2, arrayOfByte1);
          Log.i("MicroMsg.SyncServiceHandler", "processResp %s synckey merge:%s", new Object[] { paramObject, ad.de((byte[])localObject) });
          if (localObject != null) {
            if (localObject.length != 0) {
              break label309;
            }
          }
        }
      }
      label309:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject = arrayOfByte1;
        }
        paramduk.ZdD = com.tencent.mm.platformtools.w.aN((byte[])localObject);
        if (Arrays.equals(arrayOfByte2, com.tencent.mm.platformtools.w.a(paramduk.ZdD))) {
          break label314;
        }
        com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(com.tencent.mm.platformtools.w.a(paramduk.ZdD)));
        MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", g.aQe()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(com.tencent.mm.platformtools.w.a(paramduk.ZdD))).commit();
        AppMethodBeat.o(243137);
        return;
        i = ((gol)localObject).abwJ;
        break;
      }
      label314:
      Log.i("MicroMsg.SyncServiceHandler", "processResp %s  Sync Key Not change, not save", new Object[] { paramObject });
      AppMethodBeat.o(243137);
      return;
    }
    label337:
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 47L, 1L, false);
    AppMethodBeat.o(243137);
  }
  
  private static void b(duk paramduk)
  {
    AppMethodBeat.i(243141);
    s.u(paramduk, "resp");
    paramduk = paramduk.ZdG;
    int i;
    if (paramduk == null) {
      i = 0;
    }
    for (;;)
    {
      paramduk = com.tencent.mm.plugin.report.f.a(i, new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) });
      if (paramduk != null) {
        break;
      }
      paramduk = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(243141);
      throw paramduk;
      paramduk = paramduk.vgO;
      if (paramduk == null) {
        i = 0;
      } else {
        i = paramduk.size();
      }
    }
    int j = Util.nullAsNil(Integer.valueOf(((Integer)paramduk).intValue()));
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, j, 1L, false);
    if (!bKS())
    {
      paramduk = com.tencent.mm.plugin.report.f.Ozc;
      if (i > 0) {}
      for (l = 221L;; l = 218L)
      {
        paramduk.idkeyStat(99L, l, 1L, false);
        AppMethodBeat.o(243141);
        return;
      }
    }
    if (!CrashReportFactory.foreground)
    {
      paramduk = com.tencent.mm.plugin.report.f.Ozc;
      if (i > 0) {}
      for (l = 220L;; l = 217L)
      {
        paramduk.idkeyStat(99L, l, 1L, false);
        AppMethodBeat.o(243141);
        return;
      }
    }
    paramduk = com.tencent.mm.plugin.report.f.Ozc;
    if (i > 0) {}
    for (long l = 219L;; l = 216L)
    {
      paramduk.idkeyStat(99L, l, 1L, false);
      AppMethodBeat.o(243141);
      return;
    }
  }
  
  private static boolean bKS()
  {
    AppMethodBeat.i(243145);
    Object localObject3;
    try
    {
      Object localObject1 = PowerManager.class.getMethod("isScreenOn", new Class[0]);
      localObject3 = MMApplicationContext.getContext().getSystemService("power");
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        AppMethodBeat.o(243145);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 45L, 1L, false);
      Log.e("MicroMsg.SyncServiceHandler", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, Util.stackTraceToString((Throwable)localException) });
      AppMethodBeat.o(243145);
      return true;
    }
    Object localObject2 = localException.invoke((PowerManager)localObject3, new Object[0]);
    if (localObject2 == null)
    {
      localObject2 = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(243145);
      throw ((Throwable)localObject2);
    }
    boolean bool = ((Boolean)localObject2).booleanValue();
    AppMethodBeat.o(243145);
    return bool;
  }
  
  private final MMKV bLd()
  {
    AppMethodBeat.i(243126);
    MMKV localMMKV = (MMKV)this.oNZ.getValue();
    AppMethodBeat.o(243126);
    return localMMKV;
  }
  
  private final void c(fla paramfla, b paramb)
  {
    AppMethodBeat.i(243129);
    synchronized (this.oNX)
    {
      LinkedList localLinkedList2 = this.oNX;
      String str2 = paramfla.hIQ;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      if (!localLinkedList2.contains(str1))
      {
        localLinkedList2 = this.oNX;
        str2 = paramfla.hIQ;
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localLinkedList2.add(str1);
        this.oNW.a(paramfla, paramb);
        if (this.oNX.size() > 5) {
          Log.i("MicroMsg.SyncServiceHandler", s.X("remove first dataId ", (String)this.oNX.removeFirst()));
        }
        paramfla = ah.aiuX;
        AppMethodBeat.o(243129);
        return;
      }
      Log.i("MicroMsg.SyncServiceHandler", s.X("already sync dataId ", paramfla.hIQ));
    }
  }
  
  public final void b(fla paramfla, e parame)
  {
    AppMethodBeat.i(243174);
    s.u(paramfla, "syncData");
    s.u(parame, "processor");
    long l3 = cn.bDw();
    paramfla.hIQ = (parame.hashCode() + '_' + l3);
    paramfla.abLB = parame.hashCode();
    if (paramfla.dataType == 1) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 100L, 1L, false);
    }
    while ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.b.aZG()) || (com.tencent.mm.kernel.h.baE() == null) || (com.tencent.mm.kernel.h.baE().ban() == null))
    {
      Log.e("MicroMsg.SyncServiceHandler", "Error CmdProcHandler " + parame + " accHasReady:" + com.tencent.mm.kernel.h.baz() + " hold:" + com.tencent.mm.kernel.b.aZG() + " accstg:" + com.tencent.mm.kernel.h.baE());
      this.oNW.a(paramfla, parame);
      this.oNW.a(paramfla, b.oLq);
      AppMethodBeat.o(243174);
      return;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 101L, 1L, false);
    }
    duk localduk = paramfla.abLA;
    if (localduk == null)
    {
      Log.e("MicroMsg.SyncServiceHandler", "Error SyncResponse " + parame + " accHasReady:" + com.tencent.mm.kernel.h.baz() + " hold:" + com.tencent.mm.kernel.b.aZG() + " accstg:" + com.tencent.mm.kernel.h.baE());
      this.oNW.a(paramfla, parame);
      this.oNW.a(paramfla, b.oLr);
      AppMethodBeat.o(243174);
      return;
    }
    b(localduk);
    long l2 = localduk.abaw;
    long l1 = l2;
    if (String.valueOf(l2).length() == 10) {
      l1 = l2 * 1000L;
    }
    Z(System.currentTimeMillis(), l1);
    com.tencent.mm.kernel.h.baC().ec(localduk.vhk, localduk.abav);
    com.tencent.mm.kernel.b.sx(localduk.vhk);
    Object localObject1 = localduk.ZdG;
    if (localObject1 != null)
    {
      localObject1 = ((adx)localObject1).vgO;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty() != true)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.SyncServiceHandler", s.X("Empty CmdList ", paramfla.toJSON()));
      a(paramfla.oNH, localduk, parame);
      this.oNW.a(paramfla, parame);
      this.oNW.a(paramfla, b.oLs);
      AppMethodBeat.o(243174);
      return;
    }
    for (;;)
    {
      boolean bool1;
      synchronized (this.hri)
      {
        ((Map)this.oNY).put(Integer.valueOf(paramfla.abLB), parame);
        Object localObject2 = bLd().decodeBytes("process_data_list");
        if (localObject2 == null)
        {
          localObject1 = null;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new fkw();
          }
          if (((fkw)localObject2).abLy.size() >= 5)
          {
            i = 0;
            bool1 = false;
            bool2 = false;
            if (paramfla.dataType != 1) {
              break label869;
            }
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 102L, 1L, false);
            parame = ah.aiuX;
            Log.i("MicroMsg.SyncServiceHandler", "doProcessCmd: saveResult:" + bool1 + " returnResult:" + bool2 + " costTime:" + (cn.bDu() - l3) + " queueSize:" + i + " netSceneMap:" + this.oNY.size() + " syncData:" + paramfla.toJSON());
            com.tencent.threadpool.h.ahAA.g((Runnable)new b(), "SyncProcessorThreadTag");
            if (bool2) {
              c(paramfla, b.oLt);
            }
            AppMethodBeat.o(243174);
          }
        }
        else
        {
          localObject1 = new fkw();
          try
          {
            ((fkw)localObject1).parseFrom((byte[])localObject2);
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.SyncServiceHandler", (Throwable)localException2, "parse data queue", new Object[0]);
            continue;
          }
        }
      }
      localException2.abLy.add(paramfla);
      i = localException2.abLy.size();
      try
      {
        bool1 = bLd().encode("process_data_list", localException2.toByteArray());
        if (!bool1) {
          break label886;
        }
        a(paramfla.oNH, localduk, parame);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SyncServiceHandler", (Throwable)localException1, "save data queue", new Object[0]);
          bool1 = false;
        }
      }
      label869:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 103L, 1L, false);
      continue;
      label886:
      boolean bool2 = true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelmulti/SyncServiceHandler$ProcessSyncData;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/modelmulti/SyncServiceHandler;)V", "run", "", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements Runnable
  {
    public b()
    {
      AppMethodBeat.i(243094);
      AppMethodBeat.o(243094);
    }
    
    public final void run()
    {
      AppMethodBeat.i(243102);
      if ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.b.aZG()) || (com.tencent.mm.kernel.h.baE() == null) || (com.tencent.mm.kernel.h.baE().ban() == null))
      {
        Log.e("MicroMsg.SyncServiceHandler", "processResp accready:%s hold:%s accstg:%s ", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.baz()), Boolean.valueOf(com.tencent.mm.kernel.b.aZG()), com.tencent.mm.kernel.h.baE() });
        AppMethodBeat.o(243102);
        return;
      }
      boolean bool = WXHardCoderJNI.hcReceiveMsgEnable;
      int j = WXHardCoderJNI.hcReceiveMsgDelay;
      int k = WXHardCoderJNI.hcReceiveMsgCPU;
      int m = WXHardCoderJNI.hcReceiveMsgIO;
      int i;
      long l1;
      Object localObject1;
      if (WXHardCoderJNI.hcReceiveMsgThr)
      {
        i = com.tencent.mm.kernel.h.baH().getProcessTid();
        k = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncServiceHandler");
        l1 = cn.bDw();
        localObject5 = w.a(this.oOa);
        localObject1 = this.oOa;
      }
      label285:
      Object localObject3;
      for (;;)
      {
        try
        {
          byte[] arrayOfByte = w.b((w)localObject1).decodeBytes("process_data_list");
          if (arrayOfByte == null)
          {
            localObject1 = null;
            if (localObject1 != null) {
              break label285;
            }
            localObject1 = null;
            if (localObject1 != null) {
              break label319;
            }
            localObject5 = null;
            Log.i("MicroMsg.SyncServiceHandler", s.X("ProcessSyncData syncData:", localObject5));
            if (localObject1 != null) {
              break label329;
            }
            localObject1 = null;
            if (localObject1 == null) {
              Log.i("MicroMsg.SyncServiceHandler", "no sync data process");
            }
            AppMethodBeat.o(243102);
            return;
            i = 0;
            break;
          }
          localObject1 = new fkw();
          try
          {
            ((fkw)localObject1).parseFrom(arrayOfByte);
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.SyncServiceHandler", (Throwable)localException3, "process parse data queue 1", new Object[0]);
            continue;
          }
          localObject3 = localObject2.abLy;
        }
        finally
        {
          AppMethodBeat.o(243102);
        }
        if (localObject3 == null)
        {
          localObject3 = null;
        }
        else
        {
          localObject3 = (fla)p.oL((List)localObject3);
          continue;
          label319:
          localObject5 = ((fla)localObject3).toJSON();
        }
      }
      label329:
      w localw = this.oOa;
      Object localObject5 = new c();
      ((c)localObject5).fT(new f((fla)localObject3));
      long l2 = Util.nowMilliSecond();
      Object localObject8 = ((fla)localObject3).abLA;
      if (localObject8 == null) {
        i = 0;
      }
      for (;;)
      {
        localObject8 = ((fla)localObject3).abLA;
        if (localObject8 == null) {
          break;
        }
        localObject8 = ((duk)localObject8).ZdG;
        if (localObject8 == null) {
          break;
        }
        localObject8 = ((adx)localObject8).vgO;
        if (localObject8 == null) {
          break;
        }
        localObject8 = ((Iterable)localObject8).iterator();
        j = 0;
        while (((Iterator)localObject8).hasNext())
        {
          ??? = ((Iterator)localObject8).next();
          if (j < 0) {
            p.kkW();
          }
          ??? = (adw)???;
          new f((fla)localObject3);
          if (!((c)localObject5).a((adw)???, false)) {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 46L, 1L, false);
          }
          long l3 = Util.milliSecondsToNow(l2);
          Log.i("MicroMsg.SyncServiceHandler", "processResp Single Cmd NetSync[%s] time:%s size:%s index:%s", new Object[] { Integer.valueOf(((fla)localObject3).abLB), Long.valueOf(l3), Integer.valueOf(i), Integer.valueOf(j) });
          j += 1;
        }
        localObject8 = ((duk)localObject8).ZdG;
        if (localObject8 == null)
        {
          i = 0;
        }
        else
        {
          localObject8 = ((adx)localObject8).vgO;
          if (localObject8 == null) {
            i = 0;
          } else {
            i = ((LinkedList)localObject8).size();
          }
        }
      }
      ((c)localObject5).fU(new f((fla)localObject3));
      for (;;)
      {
        synchronized (w.a(localw))
        {
          localObject5 = w.b(localw).decodeBytes("process_data_list");
          if (localObject5 == null)
          {
            localObject8 = null;
            break label1080;
            bool = s.p(localObject5, ((fla)localObject3).hIQ);
            if (!bool) {}
          }
          try
          {
            localObject10 = w.b(localw);
            if (localObject8 != null) {
              break label995;
            }
            localObject5 = null;
            label676:
            bool = ((MMKV)localObject10).encode("process_data_list", (byte[])localObject5);
          }
          catch (Exception localException2)
          {
            Object localObject10;
            Object localObject6;
            Log.printErrStackTrace("MicroMsg.SyncServiceHandler", (Throwable)localException2, "process save data queue", new Object[0]);
            bool = false;
            continue;
            localObject7 = ((fkw)localObject8).abLy;
            if (localObject7 != null) {
              break label1048;
            }
            localObject7 = null;
            continue;
            i = ((LinkedList)localObject7).size();
            localObject7 = Integer.valueOf(i);
            continue;
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 105L, 1L, false);
            continue;
          }
          localObject10 = new StringBuilder("process save data queue saveResult:").append(bool).append(" QueueSize: ");
          if (localObject8 != null) {
            break label1030;
          }
          localObject5 = null;
          Log.i("MicroMsg.SyncServiceHandler", localObject5);
          localObject5 = (e)w.c(localw).remove(Integer.valueOf(((fla)localObject3).abLB));
          w.a((fla)localObject3);
          if (((fla)localObject3).dataType != 1) {
            break label1063;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 104L, 1L, false);
          localw.oNW.a((fla)localObject3, (e)localObject5);
          i = WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, k);
          com.tencent.threadpool.h.ahAA.g((Runnable)new b(localw), "SyncProcessorThreadTag");
          w.a(localw, (fla)localObject3, b.oLu);
          Log.i("MicroMsg.SyncServiceHandler", "sync data process finish costTime:" + (cn.bDw() - l1) + " startPerformance:" + k + " stopPerformance:" + i);
          localObject3 = ah.aiuX;
          break;
          localObject8 = new fkw();
          try
          {
            ((fkw)localObject8).parseFrom((byte[])localObject5);
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.SyncServiceHandler", (Throwable)localException1, "process parse data queue 2", new Object[0]);
          }
        }
        label951:
        localObject6 = ((fkw)localObject8).abLy;
        if (localObject6 == null) {
          localObject6 = null;
        }
        for (localObject6 = (fla)p.oG((List)localObject6); localObject7 != null; localObject7 = null)
        {
          localObject6 = ((fla)localObject6).hIQ;
          break;
          label995:
          localObject6 = ((fkw)localObject8).toByteArray();
          break label676;
          label1030:
          label1048:
          label1063:
          label1080:
          if (localObject8 != null) {
            break label951;
          }
        }
        Object localObject7 = null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<MMKV>
  {
    public static final c oOb;
    
    static
    {
      AppMethodBeat.i(243097);
      oOb = new c();
      AppMethodBeat.o(243097);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.w
 * JD-Core Version:    0.7.0.1
 */