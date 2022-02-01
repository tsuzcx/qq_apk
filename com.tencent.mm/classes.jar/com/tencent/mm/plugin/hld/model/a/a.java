package com.tencent.mm.plugin.hld.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.crash.b;
import com.tencent.mm.crash.b.b;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/recovery/ImeDictRecovery;", "Lcom/tencent/mm/crash/WeChatNativeCrash$INativeCrashCallback;", "()V", "TAG", "", "engineCrashNum", "", "Ljava/lang/Integer;", "monitoring", "", "getMonitoring", "()Z", "setMonitoring", "(Z)V", "endMonitor", "", "initRecovery", "onNativeCrash", "reset", "startMonitor", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b.b
{
  public static final a JwD;
  public static Integer JwE;
  private static boolean JwF;
  
  static
  {
    AppMethodBeat.i(312079);
    JwD = new a();
    AppMethodBeat.o(312079);
  }
  
  public static boolean fNk()
  {
    return JwF;
  }
  
  private static final void fNm()
  {
    AppMethodBeat.i(312065);
    Object localObject1 = n.JvW;
    localObject1 = n.fMX();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject2 = com.tencent.mm.plugin.hld.f.l.getKV();
    dbu localdbu;
    Object localObject3;
    if (localObject2 != null)
    {
      localdbu = new dbu();
      localdbu.version = ((String)localObject1);
      localdbu.aaHl = new dbq();
      localObject3 = new dbq();
      Object localObject4 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject4 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject4 != null)
      {
        localObject4 = ((MultiProcessMMKV)localObject4).decodeBytes("key_current_cloud_dicts");
        if (localObject4 != null) {
          ((dbq)localObject3).parseFrom((byte[])localObject4);
        }
      }
      localObject3 = ((dbq)localObject3).aaHc;
      s.s(localObject3, "localCloudDicts.cloudDicts");
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (dbp)((Iterator)localObject3).next();
        if (((dbp)localObject4).aaGX == com.tencent.mm.plugin.hld.model.l.JvM.value) {
          localdbu.aaHl.aaHc.add(localObject4);
        }
      }
      localObject3 = ah.aiuX;
      ((MultiProcessMMKV)localObject2).encode("ime_engine_init_recovery_data", localdbu.toByteArray());
    }
    localObject2 = com.tencent.mm.plugin.hld.f.i.JyA;
    if (!com.tencent.mm.plugin.hld.f.i.fOo())
    {
      localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
      if (com.tencent.mm.plugin.hld.f.l.bGa())
      {
        localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
        localObject2 = com.tencent.mm.plugin.hld.f.l.fPk();
        if (localObject2 != null)
        {
          localdbu = new dbu();
          localdbu.version = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
          localObject3 = com.tencent.mm.plugin.hld.f.l.fPk();
          if (localObject3 != null)
          {
            localObject1 = new dbw();
            localObject3 = ((MultiProcessMMKV)localObject3).decodeBytes("key_current_cloud_dicts");
            if (localObject3 != null) {
              ((dbw)localObject1).parseFrom((byte[])localObject3);
            }
            localdbu.aaHm = ((dbw)localObject1).aaHm;
            localdbu.aaHn = ((dbw)localObject1).aaHn;
          }
          localObject1 = ah.aiuX;
          ((MultiProcessMMKV)localObject2).encode("ime_engine_init_recovery_data", localdbu.toByteArray());
        }
      }
    }
    AppMethodBeat.o(312065);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(312045);
    Object localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putInt("ime_engine_init_native_crash_num", 0);
    }
    localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_engine_init_recovery_first_level", true);
    }
    AppMethodBeat.o(312045);
  }
  
  public final void aTc()
  {
    AppMethodBeat.i(312125);
    Log.e("WxIme.ImeDictRecovery", s.X("onNativeCrash ori:", JwE));
    Object localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    Integer localInteger;
    if (localObject != null)
    {
      localInteger = JwE;
      if (localInteger != null) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = localInteger.intValue() + 1)
    {
      ((MultiProcessMMKV)localObject).putInt("ime_engine_init_native_crash_num", i);
      AppMethodBeat.o(312125);
      return;
    }
  }
  
  public final void fNl()
  {
    AppMethodBeat.i(312115);
    b.b((b.b)this);
    JwF = false;
    reset();
    h.ahAA.g(a..ExternalSyntheticLambda0.INSTANCE, "WxIme.ImeDictRecovery");
    AppMethodBeat.o(312115);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(312104);
    b.a((b.b)this);
    JwF = true;
    AppMethodBeat.o(312104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.a.a
 * JD-Core Version:    0.7.0.1
 */