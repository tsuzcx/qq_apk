package com.tencent.mm.mj_template.maas;

import com.tencent.maas.camerafun.MJCamFunSession.c;
import com.tencent.maas.camerafun.MJCaptureOptions;
import com.tencent.maas.instamovie.MJAsyncTaskInfo;
import com.tencent.maas.instamovie.MJMovieSession.OnComplete;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"TAG", "", "mjCamFunAsyncTaskWrapperWithCaptureOption", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/mj_template/maas/MJCamFunAsyncTaskResult;", "funcName", "block", "Lkotlin/Function2;", "Lcom/tencent/maas/camerafun/MJCamFunSession$OnProgress;", "Lcom/tencent/maas/camerafun/MJCamFunSession$OnOptionsComplete;", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onCancel", "Lkotlin/Function1;", "", "mjCamFunAsyncTaskWrapperWithCaptureOptionBlockWithoutProgress", "Lcom/tencent/maas/camerafun/MJCaptureOptions;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mjCamFunWrapper", "", "Lcom/tencent/maas/instamovie/base/MJError;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mjCamFunWrapperWithResult", "T", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final Object a(String paramString, kotlin.g.a.b<? super kotlin.g.a.b<? super MJError, ah>, ? extends MJError> paramb, d<? super Boolean> paramd)
  {
    AppMethodBeat.i(239803);
    paramString = i.c(paramString, (kotlin.g.a.b)new d(paramb), paramd);
    AppMethodBeat.o(239803);
    return paramString;
  }
  
  public static final <T> Object b(final String paramString, kotlin.g.a.b<? super m<? super T, ? super MJError, ah>, ah> paramb, d<? super T> paramd)
  {
    AppMethodBeat.i(239808);
    h localh = new h(kotlin.d.a.b.au(paramd));
    paramb.invoke(new e((d)localh, paramString, System.currentTimeMillis()));
    paramString = localh.kli();
    if (paramString == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(239808);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    public a(String paramString, long paramLong, MJAsyncTaskInfo paramMJAsyncTaskInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "option", "Lcom/tencent/maas/camerafun/MJCaptureOptions;", "kotlin.jvm.PlatformType", "error", "Lcom/tencent/maas/instamovie/base/MJError;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MJCamFunSession.c
  {
    public c(p<? super MJCaptureOptions> paramp, String paramString, long paramLong) {}
    
    public final void onComplete(MJCaptureOptions paramMJCaptureOptions, MJError paramMJError)
    {
      AppMethodBeat.i(239784);
      if (!this.nZF.isActive())
      {
        Log.e("MicroMsg.MaasFuncUtils", s.X(this.nZA, " already resumed"));
        AppMethodBeat.o(239784);
        return;
      }
      if (paramMJError != null)
      {
        paramMJCaptureOptions = com.tencent.mm.mj_template.maas.b.b.obs;
        com.tencent.mm.mj_template.maas.b.b.a(this.nZA, paramMJError, System.currentTimeMillis() - this.nZB);
        paramMJCaptureOptions = (d)this.nZF;
        paramMJError = Result.Companion;
        paramMJCaptureOptions.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(239784);
        return;
      }
      paramMJError = this.nZF;
      Result.Companion localCompanion = Result.Companion;
      paramMJError.resumeWith(Result.constructor-impl(paramMJCaptureOptions));
      paramMJCaptureOptions = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.x(this.nZA, System.currentTimeMillis() - this.nZB);
      AppMethodBeat.o(239784);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/base/MJError;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<MJMovieSession.OnComplete, MJError>
  {
    d(kotlin.g.a.b<? super kotlin.g.a.b<? super MJError, ah>, ? extends MJError> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "option", "error", "Lcom/tencent/maas/instamovie/base/MJError;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<T, MJError, ah>
  {
    e(d<? super T> paramd, String paramString, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.c
 * JD-Core Version:    0.7.0.1
 */