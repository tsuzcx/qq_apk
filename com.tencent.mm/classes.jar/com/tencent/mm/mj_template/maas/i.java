package com.tencent.mm.mj_template.maas;

import com.tencent.maas.MJMaasCore.OnComplete;
import com.tencent.maas.instamovie.MJAsyncTaskInfo;
import com.tencent.maas.instamovie.MJMovieSession.OnComplete;
import com.tencent.maas.instamovie.MJMovieSession.OnProgress;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.l;
import kotlinx.coroutines.a.t;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"TAG", "", "asyncTaskWrapper", "Lkotlinx/coroutines/flow/Flow;", "", "funcName", "block", "Lkotlin/Function2;", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onCancel", "Lkotlin/Function1;", "", "mjFunWrapper", "", "Lcom/tencent/maas/instamovie/base/MJError;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mjFunWrapper1", "Lcom/tencent/maas/MJMaasCore$OnComplete;", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final g<Float> a(final String paramString, m<? super MJMovieSession.OnProgress, ? super MJMovieSession.OnComplete, ? extends MJAsyncTaskInfo> paramm, final kotlin.g.a.b<? super MJAsyncTaskInfo, ah> paramb)
  {
    AppMethodBeat.i(239788);
    s.u(paramString, "funcName");
    s.u(paramm, "block");
    s.u(paramb, "onCancel");
    paramString = j.z((m)new a(paramm, paramString, paramb, null));
    AppMethodBeat.o(239788);
    return paramString;
  }
  
  public static final Object c(final String paramString, kotlin.g.a.b<? super MJMovieSession.OnComplete, ? extends MJError> paramb, d<? super Boolean> paramd)
  {
    AppMethodBeat.i(239763);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    Object localObject = (d)localh;
    final long l = System.currentTimeMillis();
    paramb = (MJError)paramb.invoke(new b((d)localObject, paramString, l));
    if (paramb != null)
    {
      Log.e("MaasFuncUtils", paramString + " call error: " + paramb.ec + ' ' + paramb.message, new Object[] { new Throwable() });
      Result.Companion localCompanion = Result.Companion;
      ((d)localObject).resumeWith(Result.constructor-impl(Boolean.FALSE));
      localObject = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.a(paramString, paramb, System.currentTimeMillis() - l);
    }
    paramString = localh.kli();
    if (paramString == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(239763);
    return paramString;
  }
  
  public static final Object d(String paramString, kotlin.g.a.b<? super MJMaasCore.OnComplete, ? extends MJError> paramb, d<? super Boolean> paramd)
  {
    AppMethodBeat.i(239775);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    Object localObject = (d)localh;
    final long l = System.currentTimeMillis();
    paramb = (MJError)paramb.invoke(new c(paramString, (d)localObject, l));
    if (paramb != null)
    {
      Log.e("MaasFuncUtils", paramString + " call error: " + paramb.ec + ' ' + paramb.message, new Object[] { new Throwable() });
      Result.Companion localCompanion = Result.Companion;
      ((d)localObject).resumeWith(Result.constructor-impl(Boolean.FALSE));
      localObject = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.a(paramString, paramb, System.currentTimeMillis() - l);
    }
    paramString = localh.kli();
    if (paramString == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(239775);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<v<? super Float>, d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    a(m<? super MJMovieSession.OnProgress, ? super MJMovieSession.OnComplete, ? extends MJAsyncTaskInfo> paramm, String paramString, kotlin.g.a.b<? super MJAsyncTaskInfo, ah> paramb, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(239782);
      paramd = new a(this.VV, paramString, paramb, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(239782);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239770);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239770);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (v)this.L$0;
        Object localObject3 = this.VV;
        localObject1 = paramString;
        localObject2 = paramb;
        this.L$0 = paramObject;
        this.Uf = localObject3;
        this.VC = localObject1;
        this.VD = localObject2;
        this.label = 1;
        q localq = new q(kotlin.d.a.b.au((d)this), 1);
        localq.kBA();
        p localp = (p)localq;
        final long l = System.currentTimeMillis();
        localObject3 = (MJAsyncTaskInfo)((m)localObject3).invoke(new b(paramObject, (String)localObject1), new c(localp, (String)localObject1, l));
        if ((((MJAsyncTaskInfo)localObject3).error != null) && (localp.isActive()))
        {
          Object localObject4 = com.tencent.mm.mj_template.maas.b.b.obs;
          localObject4 = ((MJAsyncTaskInfo)localObject3).error;
          s.s(localObject4, "task.error");
          com.tencent.mm.mj_template.maas.b.b.a((String)localObject1, (MJError)localObject4, System.currentTimeMillis() - l);
          localObject4 = (d)localp;
          Throwable localThrowable = (Throwable)new h(((MJAsyncTaskInfo)localObject3).error);
          Result.Companion localCompanion = Result.Companion;
          ((d)localObject4).resumeWith(Result.constructor-impl(ResultKt.createFailure(localThrowable)));
        }
        localp.bg((kotlin.g.a.b)new a((String)localObject1, l, (kotlin.g.a.b)localObject2, (MJAsyncTaskInfo)localObject3));
        localObject1 = localq.getResult();
        if (localObject1 == kotlin.d.a.a.aiwj) {
          s.u((d)this, "frame");
        }
        if (localObject1 == locala)
        {
          AppMethodBeat.o(239770);
          return locala;
        }
      case 1: 
        localObject1 = (v)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        paramObject.kDu().k(null);
        localObject1 = (kotlin.g.a.a)new i.a.1(paramString);
        localObject2 = (d)this;
        this.L$0 = null;
        this.Uf = null;
        this.VC = null;
        this.VD = null;
        this.label = 2;
        if (t.a(paramObject, (kotlin.g.a.a)localObject1, (d)localObject2) != locala) {
          break label439;
        }
        AppMethodBeat.o(239770);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label439:
      paramObject = ah.aiuX;
      AppMethodBeat.o(239770);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Throwable, ah>
    {
      a(String paramString, long paramLong, kotlin.g.a.b<? super MJAsyncTaskInfo, ah> paramb, MJAsyncTaskInfo paramMJAsyncTaskInfo)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      implements MJMovieSession.OnProgress
    {
      b(v<? super Float> paramv, String paramString) {}
      
      public final void onProgress(float paramFloat)
      {
        AppMethodBeat.i(239778);
        if (l.isFailure-impl(this.oaL.iV(Float.valueOf(paramFloat)))) {
          Log.e("MaasFuncUtils", this.nZA + " try send error " + paramFloat);
        }
        AppMethodBeat.o(239778);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/base/MJError;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      implements MJMovieSession.OnComplete
    {
      c(p<? super ah> paramp, String paramString, long paramLong) {}
      
      public final void onComplete(MJError paramMJError)
      {
        AppMethodBeat.i(239776);
        if (!this.nZF.isActive())
        {
          Log.e("MaasFuncUtils", s.X(this.nZA, " already resumed"));
          AppMethodBeat.o(239776);
          return;
        }
        if (paramMJError != null)
        {
          Object localObject = com.tencent.mm.mj_template.maas.b.b.obs;
          com.tencent.mm.mj_template.maas.b.b.a(this.nZA, paramMJError, System.currentTimeMillis() - l);
          localObject = (d)this.nZF;
          paramMJError = (Throwable)new h(paramMJError);
          Result.Companion localCompanion = Result.Companion;
          ((d)localObject).resumeWith(Result.constructor-impl(ResultKt.createFailure(paramMJError)));
          AppMethodBeat.o(239776);
          return;
        }
        this.nZF.d(ah.aiuX, null);
        paramMJError = com.tencent.mm.mj_template.maas.b.b.obs;
        com.tencent.mm.mj_template.maas.b.b.x(this.nZA, System.currentTimeMillis() - l);
        AppMethodBeat.o(239776);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/base/MJError;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements MJMovieSession.OnComplete
  {
    b(d<? super Boolean> paramd, String paramString, long paramLong) {}
    
    public final void onComplete(MJError paramMJError)
    {
      AppMethodBeat.i(239747);
      if (paramMJError != null)
      {
        Log.e("MaasFuncUtils", paramMJError.ec + ' ' + paramMJError.message, new Object[] { new Throwable() });
        localObject = this.nZH;
        Result.Companion localCompanion = Result.Companion;
        ((d)localObject).resumeWith(Result.constructor-impl(Boolean.FALSE));
        localObject = com.tencent.mm.mj_template.maas.b.b.obs;
        com.tencent.mm.mj_template.maas.b.b.a(paramString, paramMJError, System.currentTimeMillis() - l);
        AppMethodBeat.o(239747);
        return;
      }
      paramMJError = this.nZH;
      Object localObject = Result.Companion;
      paramMJError.resumeWith(Result.constructor-impl(Boolean.TRUE));
      paramMJError = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.x(paramString, System.currentTimeMillis() - l);
      AppMethodBeat.o(239747);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/base/MJError;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    implements MJMaasCore.OnComplete
  {
    c(String paramString, d<? super Boolean> paramd, long paramLong) {}
    
    public final void onComplete(MJError paramMJError)
    {
      AppMethodBeat.i(239755);
      if (paramMJError != null)
      {
        Log.e("MaasFuncUtils", this.nZA + " call error: " + paramMJError.ec + ' ' + paramMJError.message, new Object[] { new Throwable() });
        localObject = this.nZH;
        Result.Companion localCompanion = Result.Companion;
        ((d)localObject).resumeWith(Result.constructor-impl(Boolean.FALSE));
        localObject = com.tencent.mm.mj_template.maas.b.b.obs;
        com.tencent.mm.mj_template.maas.b.b.a(this.nZA, paramMJError, System.currentTimeMillis() - l);
        AppMethodBeat.o(239755);
        return;
      }
      paramMJError = this.nZH;
      Object localObject = Result.Companion;
      paramMJError.resumeWith(Result.constructor-impl(Boolean.TRUE));
      paramMJError = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.x(this.nZA, System.currentTimeMillis() - l);
      AppMethodBeat.o(239755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.i
 * JD-Core Version:    0.7.0.1
 */