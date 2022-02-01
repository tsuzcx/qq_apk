package com.tencent.mm.plugin.hld.model.a;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.crash.a.b;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/recovery/ImeDictRecovery;", "Lcom/tencent/mm/crash/WeChatNativeCrash$INativeCrashCallback;", "()V", "TAG", "", "engineCrashNum", "", "Ljava/lang/Integer;", "monitoring", "", "getMonitoring", "()Z", "setMonitoring", "(Z)V", "endMonitor", "", "initRecovery", "onNativeCrash", "reset", "startMonitor", "plugin-hld_release"})
public final class a
  implements a.b
{
  public static Integer DEU;
  private static boolean DEW;
  public static final a DEX;
  
  static
  {
    AppMethodBeat.i(209620);
    DEX = new a();
    AppMethodBeat.o(209620);
  }
  
  public static boolean eFt()
  {
    return DEW;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(209617);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putInt("ime_engine_init_native_crash_num", 0);
    }
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null)
    {
      ((MultiProcessMMKV)localObject).putBoolean("ime_engine_init_recovery_first_level", true);
      AppMethodBeat.o(209617);
      return;
    }
    AppMethodBeat.o(209617);
  }
  
  public final void ayz()
  {
    AppMethodBeat.i(209615);
    Log.e("WxIme.ImeDictRecovery", "onNativeCrash ori:" + DEU);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null)
    {
      Integer localInteger = DEU;
      if (localInteger != null) {}
      for (int i = localInteger.intValue() + 1;; i = 1)
      {
        ((MultiProcessMMKV)localObject).putInt("ime_engine_init_native_crash_num", i);
        AppMethodBeat.o(209615);
        return;
      }
    }
    AppMethodBeat.o(209615);
  }
  
  public final void eFu()
  {
    AppMethodBeat.i(209614);
    com.tencent.mm.crash.a.b((a.b)this);
    DEW = false;
    reset();
    h.ZvG.d((Runnable)a.DEY, "WxIme.ImeDictRecovery");
    AppMethodBeat.o(209614);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(209613);
    com.tencent.mm.crash.a.a((a.b)this);
    DEW = true;
    AppMethodBeat.o(209613);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a DEY;
    
    static
    {
      AppMethodBeat.i(209478);
      DEY = new a();
      AppMethodBeat.o(209478);
    }
    
    public final void run()
    {
      AppMethodBeat.i(209475);
      Object localObject1 = n.DEn;
      localObject1 = n.eEU();
      Object localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject2 = com.tencent.mm.plugin.hld.f.l.getKV();
      clm localclm;
      Object localObject3;
      if (localObject2 != null)
      {
        localclm = new clm();
        localclm.version = ((String)localObject1);
        localclm.Tta = new cli();
        localObject3 = new cli();
        Object localObject4 = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject4 = com.tencent.mm.plugin.hld.f.l.getKV();
        if (localObject4 != null)
        {
          localObject4 = ((MultiProcessMMKV)localObject4).decodeBytes("key_current_cloud_dicts");
          if (localObject4 != null) {
            ((cli)localObject3).parseFrom((byte[])localObject4);
          }
        }
        localObject3 = ((cli)localObject3).TsR;
        p.j(localObject3, "localCloudDicts.cloudDicts");
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (clh)((Iterator)localObject3).next();
          if (((clh)localObject4).TsM == com.tencent.mm.plugin.hld.model.l.DDO.value) {
            localclm.Tta.TsR.add(localObject4);
          }
        }
        ((MultiProcessMMKV)localObject2).encode("ime_engine_init_recovery_data", localclm.toByteArray());
      }
      localObject2 = com.tencent.mm.plugin.hld.f.i.DHq;
      if (!com.tencent.mm.plugin.hld.f.i.eGC())
      {
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.biq())
        {
          localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject2 = com.tencent.mm.plugin.hld.f.l.eHB();
          if (localObject2 != null)
          {
            localclm = new clm();
            localclm.version = ((String)localObject1);
            localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
            localObject3 = com.tencent.mm.plugin.hld.f.l.eHB();
            if (localObject3 != null)
            {
              localObject1 = new clo();
              localObject3 = ((MultiProcessMMKV)localObject3).decodeBytes("key_current_cloud_dicts");
              if (localObject3 != null) {
                ((clo)localObject1).parseFrom((byte[])localObject3);
              }
              localclm.Ttb = ((clo)localObject1).Ttb;
              localclm.Ttc = ((clo)localObject1).Ttc;
            }
            ((MultiProcessMMKV)localObject2).encode("ime_engine_init_recovery_data", localclm.toByteArray());
            AppMethodBeat.o(209475);
            return;
          }
        }
      }
      AppMethodBeat.o(209475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.a.a
 * JD-Core Version:    0.7.0.1
 */