package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoIPReportAgent;", "", "()V", "MODE_VIDEO", "", "MODE_VOICE", "ROLE_CALLEE", "ROLE_CALLER", "TAG", "", "VOICE_SWITCH_AT_CONNECTED", "VOICE_SWITCH_AT_INVITING", "VOICE_SWITCH_AT_RESPONSE", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pssCollectorJob", "Lkotlinx/coroutines/Job;", "reportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FlutterVoIPP2PStruct;", "states", "Lcom/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoIPReportAgent$States;", "getPss", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBooted", "", "onCompleted", "onConnected", "onLaunch", "onMinimized", "onRendered", "onRestoreFromPIP", "onSwitchToVoice", "reportFps", "slowFrameRate", "", "startPssCollector", "stopPssCollector", "States", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b HmV;
  static hf HmW;
  private static cb HmX;
  public static a HmY;
  static aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(263567);
    HmV = new b();
    HmW = new hf();
    coroutineScope = ar.d((f)bg.kCi());
    HmY = new a((byte)0);
    AppMethodBeat.o(263567);
  }
  
  public static void N(double paramDouble)
  {
    AppMethodBeat.i(263532);
    Log.i("MicroMsg.FlutterVoIPReportAgent", s.X("reportFps: slowFrameRate=", Double.valueOf(paramDouble)));
    HmW.iNA = kotlin.h.a.ai(100.0D * paramDouble);
    AppMethodBeat.o(263532);
  }
  
  public static void fvo()
  {
    AppMethodBeat.i(263476);
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onBooted");
    if (HmW.iNz == 0L) {
      HmW.iNz = (System.currentTimeMillis() - HmY.teM);
    }
    AppMethodBeat.o(263476);
  }
  
  public static void fvp()
  {
    AppMethodBeat.i(263488);
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onRendered");
    if (HmY.HmZ)
    {
      a locala = HmY;
      locala.Hnc += System.currentTimeMillis() - HmY.teM;
      locala = HmY;
      locala.Hnd += 1;
      AppMethodBeat.o(263488);
      return;
    }
    HmW.iNu = (System.currentTimeMillis() - HmY.teM);
    AppMethodBeat.o(263488);
  }
  
  public static void fvq()
  {
    AppMethodBeat.i(263501);
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onCompleted");
    fvt();
    Object localObject;
    if (HmY.teM > 0L)
    {
      localObject = HmY;
      ((a)localObject).duration += System.currentTimeMillis() - HmY.teM;
    }
    HmW.iCW = HmY.duration;
    if (HmY.Hnb > 0) {}
    for (HmW.iNx = (HmY.Hna / HmY.Hnb);; ((hf)localObject).iNx = ((hf)localObject).iNw)
    {
      if (HmY.Hnd > 0) {
        HmW.iNv = (HmY.Hnc / HmY.Hnd);
      }
      j.a(coroutineScope, null, null, (m)new c(null), 3);
      AppMethodBeat.o(263501);
      return;
      localObject = HmW;
    }
  }
  
  public static void fvr()
  {
    int i = 1;
    AppMethodBeat.i(263514);
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onSwitchToVoice");
    hf localhf = HmW;
    if (HmY.uYV) {}
    for (;;)
    {
      localhf.iNt = i;
      AppMethodBeat.o(263514);
      return;
      if (HmW.iNs == 1) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  static void fvs()
  {
    AppMethodBeat.i(263536);
    HmX = j.a(coroutineScope, null, null, (m)new e(null), 3);
    AppMethodBeat.o(263536);
  }
  
  public static void fvt()
  {
    AppMethodBeat.i(263540);
    cb localcb = HmX;
    if (localcb != null) {
      localcb.a(null);
    }
    HmX = null;
    AppMethodBeat.o(263540);
  }
  
  public static void onConnected()
  {
    AppMethodBeat.i(263522);
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onConnected");
    HmY.uYV = true;
    AppMethodBeat.o(263522);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoIPReportAgent$States;", "", "lastStartTime", "", "duration", "fromPip", "", "pssCollectSum", "pssCollectCount", "", "pipDurationSum", "pipDurationCount", "isConnected", "(JJZJIJIZ)V", "getDuration", "()J", "setDuration", "(J)V", "getFromPip", "()Z", "setFromPip", "(Z)V", "setConnected", "getLastStartTime", "setLastStartTime", "getPipDurationCount", "()I", "setPipDurationCount", "(I)V", "getPipDurationSum", "setPipDurationSum", "getPssCollectCount", "setPssCollectCount", "getPssCollectSum", "setPssCollectSum", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean HmZ = false;
    long Hna = 0L;
    int Hnb = 0;
    long Hnc = 0L;
    int Hnd = 0;
    public long duration = 0L;
    public long teM = -1L;
    boolean uYV = true;
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.teM != paramObject.teM) {
          return false;
        }
        if (this.duration != paramObject.duration) {
          return false;
        }
        if (this.HmZ != paramObject.HmZ) {
          return false;
        }
        if (this.Hna != paramObject.Hna) {
          return false;
        }
        if (this.Hnb != paramObject.Hnb) {
          return false;
        }
        if (this.Hnc != paramObject.Hnc) {
          return false;
        }
        if (this.Hnd != paramObject.Hnd) {
          return false;
        }
      } while (this.uYV == paramObject.uYV);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(263484);
      String str = "States(lastStartTime=" + this.teM + ", duration=" + this.duration + ", fromPip=" + this.HmZ + ", pssCollectSum=" + this.Hna + ", pssCollectCount=" + this.Hnb + ", pipDurationSum=" + this.Hnc + ", pipDurationCount=" + this.Hnd + ", isConnected=" + this.uYV + ')';
      AppMethodBeat.o(263484);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super Long>, Object>
  {
    int label;
    
    b(d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(263479);
      paramObject = (d)new b(paramd);
      AppMethodBeat.o(263479);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263473);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263473);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new Debug.MemoryInfo();
      Debug.getMemoryInfo(paramObject);
      paramObject = kotlin.d.b.a.b.BF(paramObject.getTotalPss());
      AppMethodBeat.o(263473);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    c(d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(263475);
      paramObject = (d)new c(paramd);
      AppMethodBeat.o(263475);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263466);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      hf localhf;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263466);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localhf = b.fvu();
        paramObject = b.HmV;
        paramObject = (d)this;
        this.L$0 = localhf;
        this.label = 1;
        Object localObject = b.ak(paramObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(263466);
          return locala;
        }
        break;
      case 1: 
        localhf = (hf)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      localhf.iNy = ((Number)paramObject).longValue();
      b.fvu().bMH();
      Log.i("MicroMsg.FlutterVoIPReportAgent", "report: " + b.fvv() + "\n\n " + b.fvu().aIF());
      paramObject = ah.aiuX;
      AppMethodBeat.o(263466);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    d(d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(263472);
      paramObject = (d)new d(paramd);
      AppMethodBeat.o(263472);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263464);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      hf localhf;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263464);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localhf = b.fvu();
        paramObject = b.HmV;
        paramObject = (d)this;
        this.L$0 = localhf;
        this.label = 1;
        Object localObject = b.ak(paramObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(263464);
          return locala;
        }
        break;
      case 1: 
        localhf = (hf)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      localhf.iNw = ((Number)paramObject).longValue();
      paramObject = ah.aiuX;
      AppMethodBeat.o(263464);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    Object Uf;
    long Yx;
    int label;
    
    e(d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(263470);
      paramd = new e(paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(263470);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263463);
      kotlin.d.a.a locala1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263463);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
      }
      while (ar.a(paramObject))
      {
        Object localObject1 = (d)this;
        this.L$0 = paramObject;
        this.Uf = null;
        this.label = 1;
        if (bb.e(10000L, (d)localObject1) == locala1)
        {
          AppMethodBeat.o(263463);
          return locala1;
          localObject1 = (aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        b.a locala = b.fvv();
        long l = locala.Hna;
        localObject1 = b.HmV;
        localObject1 = (d)this;
        this.L$0 = paramObject;
        this.Uf = locala;
        this.Yx = l;
        this.label = 2;
        Object localObject2 = b.ak((d)localObject1);
        localObject1 = localObject2;
        if (localObject2 == locala1)
        {
          AppMethodBeat.o(263463);
          return locala1;
          l = this.Yx;
          locala = (b.a)this.Uf;
          localObject2 = (aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject2;
        }
        locala.Hna = (l + ((Number)localObject1).longValue());
        localObject1 = b.fvv();
        ((b.a)localObject1).Hnb += 1;
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(263463);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.b
 * JD-Core Version:    0.7.0.1
 */