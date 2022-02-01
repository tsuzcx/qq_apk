package com.tencent.mm.mj_template.maas;

import com.tencent.maas.camerafun.MJAuditCaptureSettings;
import com.tencent.maas.camerafun.MJCamFunSession;
import com.tencent.maas.camerafun.MJCamFunSession.b;
import com.tencent.maas.camerafun.MJCamFunSession.c;
import com.tencent.maas.camerafun.MJCamFunSession.d;
import com.tencent.maas.camerafun.MJCaptureOptions;
import com.tencent.maas.camerafun.MJRecordingFinishInfo;
import com.tencent.maas.instamovie.MJAsyncTaskInfo;
import com.tencent.maas.instamovie.MJRecordingSettings;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/MaasCamFunSessionManager;", "", "camFunSession", "Lcom/tencent/maas/camerafun/MJCamFunSession;", "(Lcom/tencent/maas/camerafun/MJCamFunSession;)V", "firstFrameJob", "Lkotlinx/coroutines/Job;", "firstFrameScope", "Lkotlinx/coroutines/CoroutineScope;", "awaitFirstFrame", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genSessionKey", "", "installFirstFrameCallback", "prepareRender", "release", "sendAudioFrame", "audioFrame", "Lcom/tencent/maas/camerafun/MJAudioFrame;", "sendVideoFrame", "videoFrame", "Lcom/tencent/maas/camerafun/MJVideoFrame;", "start", "Lcom/tencent/maas/camerafun/MJCaptureOptions;", "startRecording", "", "outputFilePath", "exportSettings", "Lcom/tencent/maas/instamovie/MJRecordingSettings;", "auditCaptureSettings", "Lcom/tencent/maas/camerafun/MJAuditCaptureSettings;", "(Ljava/lang/String;Lcom/tencent/maas/instamovie/MJRecordingSettings;Lcom/tencent/maas/camerafun/MJAuditCaptureSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWithTemplate", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/mj_template/maas/MJCamFunAsyncTaskResult;", "templateID", "stopRecording", "Lcom/tencent/maas/camerafun/MJRecordingFinishInfo;", "switchToEmptyTemplate", "switchToTemplate", "switchToTemplateWithResult", "onProgress", "Lcom/tencent/maas/camerafun/MJCamFunSession$OnProgress;", "(Ljava/lang/String;Lcom/tencent/maas/camerafun/MJCamFunSession$OnProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final int Ue;
  public static final d.a nZI;
  public final MJCamFunSession nZJ;
  public cb nZK;
  private aq nZL;
  
  static
  {
    AppMethodBeat.i(239827);
    nZI = new d.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(239827);
  }
  
  public d(MJCamFunSession paramMJCamFunSession)
  {
    AppMethodBeat.i(239802);
    this.nZJ = paramMJCamFunSession;
    this.nZL = ar.b(ar.kBZ(), (f)cx.g(null));
    AppMethodBeat.o(239802);
  }
  
  public final Object x(kotlin.d.d<? super MJCaptureOptions> paramd)
  {
    AppMethodBeat.i(239832);
    paramd = c.b("1005", (kotlin.g.a.b)new g(this), paramd);
    AppMethodBeat.o(239832);
    return paramd;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(d paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239673);
      paramObject = (kotlin.d.d)new b(this.nZM, paramd);
      AppMethodBeat.o(239673);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239668);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239668);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nZM;
        this.L$0 = paramObject;
        this.label = 1;
        h localh = new h(kotlin.d.a.b.au((kotlin.d.d)this));
        kotlin.d.d locald = (kotlin.d.d)localh;
        long l = Util.currentTicks();
        d.b(paramObject).setFirstFrameDidPresentFunc((MJCamFunSession.b)new a(l, locald));
        paramObject = localh.kli();
        if (paramObject == kotlin.d.a.a.aiwj) {
          s.u((kotlin.d.d)this, "frame");
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(239668);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239668);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/base/MJError;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements MJCamFunSession.b
    {
      a(long paramLong, kotlin.d.d<? super ah> paramd) {}
      
      public final void onComplete(MJError paramMJError)
      {
        Object localObject2 = null;
        AppMethodBeat.i(239946);
        StringBuilder localStringBuilder = new StringBuilder("first frame present, error:");
        Object localObject1;
        if (paramMJError == null)
        {
          localObject1 = null;
          localStringBuilder = localStringBuilder.append(localObject1).append(',');
          if (paramMJError != null) {
            break label112;
          }
          localObject1 = localObject2;
          label43:
          Log.i("MicroMsg.CamFunSessionManager", localObject1);
          if (paramMJError != null) {
            break label120;
          }
          paramMJError = com.tencent.mm.mj_template.maas.b.b.obs;
          com.tencent.mm.mj_template.maas.b.b.x("1008", Util.ticksToNow(this.nvq));
        }
        for (;;)
        {
          paramMJError = this.msc;
          localObject1 = Result.Companion;
          paramMJError.resumeWith(Result.constructor-impl(ah.aiuX));
          AppMethodBeat.o(239946);
          return;
          localObject1 = paramMJError.ec;
          break;
          label112:
          localObject1 = paramMJError.message;
          break label43;
          label120:
          localObject1 = com.tencent.mm.mj_template.maas.b.b.obs;
          com.tencent.mm.mj_template.maas.b.b.a("1008", paramMJError, Util.ticksToNow(this.nvq));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/base/MJError;", "oncomplete", "Lkotlin/Function1;", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.b<kotlin.g.a.b<? super MJError, ? extends ah>, MJError>
  {
    public c(d paramd)
    {
      super();
    }
    
    private static final void a(d paramd, kotlin.g.a.b paramb, MJError paramMJError)
    {
      AppMethodBeat.i(239665);
      s.u(paramd, "this$0");
      s.u(paramb, "$oncomplete");
      Log.i("MicroMsg.CamFunSessionManager", "teardown finish");
      d.b(paramd).release();
      cb localcb = d.c(paramd);
      if (localcb != null) {
        localcb.a(null);
      }
      d.d(paramd);
      paramd = com.tencent.mm.mj_template.maas.b.a.obp;
      com.tencent.mm.mj_template.maas.b.a.HH("");
      paramb.invoke(paramMJError);
      AppMethodBeat.o(239665);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Function2;", "Lcom/tencent/maas/camerafun/MJCaptureOptions;", "Lcom/tencent/maas/instamovie/base/MJError;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.b<m<? super MJCaptureOptions, ? super MJError, ? extends ah>, ah>
  {
    public d(d paramd)
    {
      super();
    }
    
    private static final void a(m paramm, MJCaptureOptions paramMJCaptureOptions, MJError paramMJError)
    {
      AppMethodBeat.i(239679);
      s.u(paramm, "$tmp0");
      paramm.invoke(paramMJCaptureOptions, paramMJError);
      AppMethodBeat.o(239679);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/base/MJError;", "it", "Lkotlin/Function1;", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.b<kotlin.g.a.b<? super MJError, ? extends ah>, MJError>
  {
    public e(d paramd, String paramString, MJRecordingSettings paramMJRecordingSettings, MJAuditCaptureSettings paramMJAuditCaptureSettings)
    {
      super();
    }
    
    private static final void a(kotlin.g.a.b paramb, MJError paramMJError)
    {
      AppMethodBeat.i(239719);
      s.u(paramb, "$tmp0");
      paramb.invoke(paramMJError);
      AppMethodBeat.o(239719);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Function2;", "Lcom/tencent/maas/camerafun/MJRecordingFinishInfo;", "Lcom/tencent/maas/instamovie/base/MJError;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements kotlin.g.a.b<m<? super MJRecordingFinishInfo, ? super MJError, ? extends ah>, ah>
  {
    public f(d paramd)
    {
      super();
    }
    
    private static final void a(m paramm, MJRecordingFinishInfo paramMJRecordingFinishInfo, MJError paramMJError)
    {
      AppMethodBeat.i(239714);
      s.u(paramm, "$it");
      if (paramMJError != null)
      {
        com.tencent.mm.mj_template.maas.b.c localc = com.tencent.mm.mj_template.maas.b.c.obu;
        com.tencent.mm.mj_template.maas.b.c.a(paramMJError);
        localc = com.tencent.mm.mj_template.maas.b.c.obu;
        com.tencent.mm.mj_template.maas.b.c.rG(4);
      }
      paramm.invoke(paramMJRecordingFinishInfo, paramMJError);
      AppMethodBeat.o(239714);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Function2;", "Lcom/tencent/maas/camerafun/MJCaptureOptions;", "Lcom/tencent/maas/instamovie/base/MJError;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<m<? super MJCaptureOptions, ? super MJError, ? extends ah>, ah>
  {
    g(d paramd)
    {
      super();
    }
    
    private static final void a(m paramm, MJCaptureOptions paramMJCaptureOptions, MJError paramMJError)
    {
      AppMethodBeat.i(239720);
      s.u(paramm, "$tmp0");
      paramm.invoke(paramMJCaptureOptions, paramMJError);
      AppMethodBeat.o(239720);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "originOnProgress", "Lcom/tencent/maas/camerafun/MJCamFunSession$OnProgress;", "onOptionsComplete", "Lcom/tencent/maas/camerafun/MJCamFunSession$OnOptionsComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements m<MJCamFunSession.d, MJCamFunSession.c, MJAsyncTaskInfo>
  {
    public h(d paramd, String paramString, MJCamFunSession.d paramd1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.d
 * JD-Core Version:    0.7.0.1
 */