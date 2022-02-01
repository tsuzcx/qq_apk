package com.tencent.mm.mj_template.maas;

import com.tencent.maas.instamovie.MJAsyncTaskInfo;
import com.tencent.maas.instamovie.MJExportSettings;
import com.tencent.maas.instamovie.MJMovieOptions;
import com.tencent.maas.instamovie.MJMovieOutroInfo;
import com.tencent.maas.instamovie.MJMovieSession;
import com.tencent.maas.instamovie.MJMovieSession.OnComplete;
import com.tencent.maas.instamovie.MJMovieSession.OnProgress;
import com.tencent.maas.instamovie.MJMovieSessionState;
import com.tencent.maas.instamovie.MJRecommendOptions.Mode;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.instamovie.base.MJError.MaasEC;
import com.tencent.maas.instamovie.base.asset.MJAssetInfo;
import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.maas.b.c;
import com.tencent.mm.mj_template.maas.c.a.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.q;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/MaasMovieSessionManager;", "", "movieSession", "Lcom/tencent/maas/instamovie/MJMovieSession;", "initialPatams", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$MaasMovieSessionInitialParams;", "(Lcom/tencent/maas/instamovie/MJMovieSession;Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$MaasMovieSessionInitialParams;)V", "<set-?>", "Lcom/tencent/maas/instamovie/MJMovieOptions;", "curMovieOption", "getCurMovieOption", "()Lcom/tencent/maas/instamovie/MJMovieOptions;", "curOutroInfo", "Lcom/tencent/maas/instamovie/MJMovieOutroInfo;", "getCurOutroInfo", "()Lcom/tencent/maas/instamovie/MJMovieOutroInfo;", "curOutroInfo$delegate", "Lkotlin/Lazy;", "getInitialPatams", "()Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$MaasMovieSessionInitialParams;", "getMovieSession", "()Lcom/tencent/maas/instamovie/MJMovieSession;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "createMovieOption", "musicMuted", "", "originMuted", "export", "Lkotlinx/coroutines/flow/Flow;", "", "outPath", "", "settings", "Lcom/tencent/maas/instamovie/MJExportSettings;", "genSessionKey", "initial", "playing", "prepareRender", "", "ready", "realExport", "exportSettings", "isRetry", "recreateWithBlankTemplate", "recreateWithMusicID", "musicId", "recreateWithTemplateID", "templateId", "release", "startMovieCreation", "mediaInfo", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "needRecommend", "onRecommendReady", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;", "startMovieCreationAutoRecommendTemplate", "startMovieCreationWithBlankTemplate", "recommendTemplate", "startPlay", "startTime", "Lcom/tencent/maas/model/time/MJTime;", "(Lcom/tencent/maas/model/time/MJTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPlay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMovieOption", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a oal;
  public final MJMovieSession oam;
  final a.c oan;
  MJMovieOptions oao;
  private final j oap;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(239893);
    oal = new f.a((byte)0);
    AppMethodBeat.o(239893);
  }
  
  public f(MJMovieSession paramMJMovieSession, a.c paramc)
  {
    AppMethodBeat.i(239821);
    this.oam = paramMJMovieSession;
    this.oan = paramc;
    this.oam.setTextResolver(f..ExternalSyntheticLambda2.INSTANCE);
    this.oao = u(this.oan.obW, this.oan.obX);
    this.oap = kotlin.k.cm((kotlin.g.a.a)b.oaq);
    this.scope = ar.kBZ();
    AppMethodBeat.o(239821);
  }
  
  private static final String HG(String paramString)
  {
    AppMethodBeat.i(239856);
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(239856);
          return null;
        } while (!paramString.equals("deviceName"));
        AppMethodBeat.o(239856);
        return "";
      } while (!paramString.equals("username"));
      paramString = z.bAW();
      d.a locala = com.tencent.mm.plugin.finder.api.d.AwY;
      paramString = d.a.auT(paramString);
    } while (paramString == null);
    paramString = paramString.dUr();
    AppMethodBeat.o(239856);
    return paramString;
  }
  
  private static final void a(long paramLong, MJMovieSession.OnComplete paramOnComplete, MJError paramMJError)
  {
    AppMethodBeat.i(239864);
    s.u(paramOnComplete, "$onRecommendReady");
    com.tencent.mm.mj_template.maas.b.b localb;
    if (paramMJError != null)
    {
      Log.e("MicroMsg.MaasMovieSessionManager", paramMJError.ec + ' ' + paramMJError.message, new Object[] { new Throwable() });
      localb = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.a("203", paramMJError, System.currentTimeMillis() - paramLong);
    }
    for (;;)
    {
      paramOnComplete.onComplete(paramMJError);
      AppMethodBeat.o(239864);
      return;
      localb = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.x("203", System.currentTimeMillis() - paramLong);
    }
  }
  
  private static final void b(long paramLong, MJMovieSession.OnComplete paramOnComplete, MJError paramMJError)
  {
    AppMethodBeat.i(239870);
    s.u(paramOnComplete, "$onRecommendReady");
    com.tencent.mm.mj_template.maas.b.b localb;
    if (paramMJError != null)
    {
      Log.e("MicroMsg.MaasMovieSessionManager", paramMJError.ec + ' ' + paramMJError.message, new Object[] { new Throwable() });
      localb = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.a("203", paramMJError, System.currentTimeMillis() - paramLong);
    }
    for (;;)
    {
      paramOnComplete.onComplete(paramMJError);
      AppMethodBeat.o(239870);
      return;
      localb = com.tencent.mm.mj_template.maas.b.b.obs;
      com.tencent.mm.mj_template.maas.b.b.x("203", System.currentTimeMillis() - paramLong);
    }
  }
  
  private boolean bxB()
  {
    AppMethodBeat.i(239833);
    if (this.oam.getCurrentState() == MJMovieSessionState.Playing)
    {
      AppMethodBeat.o(239833);
      return true;
    }
    AppMethodBeat.o(239833);
    return false;
  }
  
  private static String bxC()
  {
    AppMethodBeat.i(239849);
    Object localObject = new StringBuilder("maas_");
    if (com.tencent.mm.kernel.h.baC() == null) {}
    for (int i = 0;; i = com.tencent.mm.kernel.b.getUin())
    {
      localObject = com.tencent.mm.b.p.getString(i) + '_' + System.currentTimeMillis();
      AppMethodBeat.o(239849);
      return localObject;
    }
  }
  
  private final MJMovieOptions u(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(239842);
    Object localObject1 = com.tencent.mm.mj_template.album_template.b.nWa;
    boolean bool2 = com.tencent.mm.mj_template.album_template.b.bwE();
    localObject1 = com.tencent.mm.mj_template.album_template.b.nWa;
    localObject1 = com.tencent.mm.mj_template.album_template.b.bwF();
    Object localObject2 = com.tencent.mm.mj_template.album_template.b.nWa;
    boolean bool1;
    MJMovieOptions localMJMovieOptions;
    if (!com.tencent.mm.mj_template.album_template.b.bwD())
    {
      bool1 = true;
      localObject2 = com.tencent.mm.mj_template.album_template.b.nWa;
      localMJMovieOptions = new MJMovieOptions(true, paramBoolean2, paramBoolean1, false, 0.0F, bool2, (com.tencent.maas.instamovie.mediafoundation.b)localObject1, bool1, com.tencent.mm.mj_template.album_template.b.bwG());
      if (this.oan.obY) {
        break label200;
      }
      paramBoolean1 = true;
      label83:
      localMJMovieOptions.setShouldAlwaysUseFirstBGM(paramBoolean1);
      localObject1 = Integer.valueOf(this.oan.obZ);
      if (((Number)localObject1).intValue() <= 0) {
        break label205;
      }
      label112:
      if (i == 0) {
        break label210;
      }
      label116:
      if (localObject1 != null) {
        break label216;
      }
    }
    label200:
    label205:
    label210:
    label216:
    for (localObject1 = null;; localObject1 = MJTime.fromSeconds(((Number)localObject1).intValue()))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MJTime.PositiveInfinityTime;
      }
      localMJMovieOptions.setMaxDuration((MJTime)localObject2);
      localMJMovieOptions.setShouldRetainOriginalMediaDuration(this.oan.shouldRetainOriginalMediaDuration);
      localMJMovieOptions.setRetainOriginalMediaDurationThreshold(MJTime.fromSeconds(this.oan.uxv));
      localMJMovieOptions.setDefaultTemplateIDs(this.oan.defaultTemplateIDs);
      AppMethodBeat.o(239842);
      return localMJMovieOptions;
      bool1 = false;
      break;
      paramBoolean1 = false;
      break label83;
      i = 0;
      break label112;
      localObject1 = null;
      break label116;
    }
  }
  
  public final Object C(kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(239948);
    if (this.oam.getCurrentState() == MJMovieSessionState.Initial) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.MaasMovieSessionManager", "cur state is initial, no need to stop");
      paramd = Boolean.TRUE;
      AppMethodBeat.o(239948);
      return paramd;
    }
    boolean bool = bxB();
    Log.i("MicroMsg.MaasMovieSessionManager", s.X("stopPlay, isPlaying: ", Boolean.valueOf(bool)));
    if (bool)
    {
      paramd = i.c("242", (kotlin.g.a.b)new s(this), paramd);
      AppMethodBeat.o(239948);
      return paramd;
    }
    paramd = Boolean.FALSE;
    AppMethodBeat.o(239948);
    return paramd;
  }
  
  public final Object a(final MJTime paramMJTime, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(239943);
    boolean bool2 = bxB();
    if (this.oam.getCurrentState() == MJMovieSessionState.Ready) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MaasMovieSessionManager", "startPlay, isPlaying: " + bool2 + " ready: " + bool1);
      if ((bool2) || (!bool1)) {
        break;
      }
      paramMJTime = i.c("241", (kotlin.g.a.b)new r(this, paramMJTime), paramd);
      AppMethodBeat.o(239943);
      return paramMJTime;
    }
    paramMJTime = Boolean.FALSE;
    AppMethodBeat.o(239943);
    return paramMJTime;
  }
  
  public final Object a(boolean paramBoolean1, boolean paramBoolean2, kotlin.d.d<? super Boolean> paramd)
  {
    boolean bool = true;
    AppMethodBeat.i(239940);
    Object localObject1;
    if ((paramd instanceof t))
    {
      localObject1 = (t)paramd;
      if ((((t)localObject1).label & 0x80000000) != 0) {
        ((t)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new t(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239940);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (paramBoolean1)
    {
      paramBoolean1 = true;
      if (!paramBoolean2) {
        break label214;
      }
    }
    label214:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localMJMovieOptions = u(paramBoolean1, paramBoolean2);
      localObject1 = (kotlin.g.a.b)new u(this, localMJMovieOptions);
      paramd.L$0 = this;
      paramd.Uf = localMJMovieOptions;
      paramd.label = 1;
      Object localObject2 = i.c("240", (kotlin.g.a.b)localObject1, paramd);
      localObject1 = localObject2;
      paramd = this;
      if (localObject2 != locala) {
        break label241;
      }
      AppMethodBeat.o(239940);
      return locala;
      paramBoolean1 = false;
      break;
    }
    final MJMovieOptions localMJMovieOptions = (MJMovieOptions)paramd.Uf;
    paramd = (f)paramd.L$0;
    ResultKt.throwOnFailure(localObject1);
    label241:
    paramBoolean1 = ((Boolean)localObject1).booleanValue();
    if (paramBoolean1) {
      paramd.oao = localMJMovieOptions;
    }
    if (paramBoolean1) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      AppMethodBeat.o(239940);
      return Boolean.valueOf(paramBoolean1);
    }
  }
  
  public final g<Float> a(String paramString1, final String paramString2, final List<? extends GalleryItem.MediaItem> paramList, boolean paramBoolean, final MJMovieSession.OnComplete paramOnComplete)
  {
    AppMethodBeat.i(239918);
    s.u(paramString1, "templateId");
    s.u(paramList, "mediaInfo");
    s.u(paramOnComplete, "onRecommendReady");
    Object localObject = com.tencent.mm.mj_template.maas.b.a.obp;
    com.tencent.mm.mj_template.maas.b.a.HH(bxC());
    localObject = c.obu;
    c.bN(paramList);
    paramList = (Iterable)paramList;
    localObject = (Collection)new ArrayList(kotlin.a.p.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (GalleryItem.MediaItem)localIterator.next();
      com.tencent.maas.instamovie.base.asset.a locala = com.tencent.maas.instamovie.base.asset.a.eFo;
      String str = paramList.Gcc;
      if (paramList.getType() == 1) {}
      for (paramList = com.tencent.maas.instamovie.base.asset.b.eFr;; paramList = com.tencent.maas.instamovie.base.asset.b.eFs)
      {
        ((Collection)localObject).add(new MJAssetInfo(locala, str, paramList));
        break;
      }
    }
    paramList = (List)localObject;
    paramOnComplete = new f..ExternalSyntheticLambda0(System.currentTimeMillis(), paramOnComplete);
    localObject = new ah.f();
    ((ah.f)localObject).aqH = MJRecommendOptions.Mode.Foreground;
    int i;
    if (((CharSequence)paramString1).length() > 0)
    {
      i = 1;
      if (i != 0) {
        if (!paramBoolean) {
          break label290;
        }
      }
    }
    label290:
    for (((ah.f)localObject).aqH = MJRecommendOptions.Mode.Background;; ((ah.f)localObject).aqH = MJRecommendOptions.Mode.None)
    {
      Log.i("MicroMsg.MaasMovieSessionManager", s.X("startMovieCreation: mode:", ((ah.f)localObject).aqH));
      paramString1 = i.a("200", (kotlin.g.a.m)new l(paramString1, this, paramString2, paramList, (ah.f)localObject, paramOnComplete), (kotlin.g.a.b)new m(this));
      AppMethodBeat.o(239918);
      return paramString1;
      i = 0;
      break;
    }
  }
  
  public final g<Float> a(List<? extends GalleryItem.MediaItem> paramList, final boolean paramBoolean, final MJMovieSession.OnComplete paramOnComplete)
  {
    AppMethodBeat.i(239927);
    s.u(paramList, "mediaInfo");
    s.u(paramOnComplete, "onRecommendReady");
    Object localObject = com.tencent.mm.mj_template.maas.b.a.obp;
    com.tencent.mm.mj_template.maas.b.a.HH(bxC());
    localObject = c.obu;
    c.bN(paramList);
    localObject = new f..ExternalSyntheticLambda1(System.currentTimeMillis(), paramOnComplete);
    if (paramBoolean) {}
    for (paramOnComplete = MJRecommendOptions.Mode.Background;; paramOnComplete = MJRecommendOptions.Mode.None)
    {
      paramList = i.a("202", (kotlin.g.a.m)new p(paramList, paramBoolean, paramOnComplete, this, (MJMovieSession.OnComplete)localObject), (kotlin.g.a.b)new q(this));
      AppMethodBeat.o(239927);
      return paramList;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(239951);
    Log.i("MicroMsg.MaasMovieSessionManager", "release");
    e locale = e.nZS;
    e.a(this.oam);
    AppMethodBeat.o(239951);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJMovieOutroInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MJMovieOutroInfo>
  {
    public static final b oaq;
    
    static
    {
      AppMethodBeat.i(239696);
      oaq = new b();
      AppMethodBeat.o(239696);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.b.h<? super Float>, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    public c(MJExportSettings paramMJExportSettings, f paramf, String paramString, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239718);
      paramd = new c(this.oar, this.oas, this.oat, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(239718);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(239710);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239710);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.h)this.L$0;
        localObject2 = new ah.a();
        localObject1 = new ah.c();
        localObject3 = com.tencent.mm.mj_template.album_template.d.nWs;
        if (com.tencent.mm.mj_template.album_template.d.bwP())
        {
          i = com.tencent.mm.mj_template.album_template.d.nWt.getInt("KeyMassAutoFallbackOutputSize", -1);
          if (i > 0)
          {
            Log.i("MicroMsg.MaasExportAutoFallback", s.X("auto fallback size:", Integer.valueOf(i)));
            if (com.tencent.mm.mj_template.album_template.d.nWw.containsKey(Integer.valueOf(i)))
            {
              localObject3 = (Integer)com.tencent.mm.mj_template.album_template.d.nWw.get(Integer.valueOf(i));
              if (localObject3 != null) {
                i = ((Integer)localObject3).intValue();
              }
            }
          }
        }
      case 1: 
        while (i > 0)
        {
          this.oar.setVideoDimensionLevel(com.tencent.maas.instamovie.mediafoundation.b.mM(i));
          localObject2 = f.a(this.oas, this.oat, this.oar, false);
          paramObject = (kotlinx.coroutines.b.h)new a((ah.c)localObject1, paramObject);
          localObject1 = (kotlin.d.d)this;
          this.label = 1;
          if (((g)localObject2).a(paramObject, (kotlin.d.d)localObject1) == locala)
          {
            AppMethodBeat.o(239710);
            return locala;
            i = -1;
            continue;
            i = -1;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            paramObject = ah.aiuX;
            AppMethodBeat.o(239710);
            return paramObject;
          }
        }
        localObject3 = kotlinx.coroutines.b.p.e(f.a(this.oas, this.oat, this.oar, false), (q)new kotlin.d.b.a.k((ah.a)localObject2, null)
        {
          int label;
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(239735);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(239735);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = (Throwable)this.L$0;
            localObject = com.tencent.mm.mj_template.album_template.b.nWa;
            if (!com.tencent.mm.mj_template.album_template.b.bwH())
            {
              AppMethodBeat.o(239735);
              throw paramAnonymousObject;
            }
            this.oau.aiwY = true;
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(239735);
            return paramAnonymousObject;
          }
        });
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new b((ah.c)localObject1, paramObject);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject2;
        this.VC = localObject1;
        this.label = 2;
        if (((g)localObject3).a(localh, locald) == locala)
        {
          AppMethodBeat.o(239710);
          return locala;
        }
        break;
      case 2: 
        localObject1 = (ah.c)this.VC;
        localObject2 = (ah.a)this.Uf;
        localObject3 = (kotlinx.coroutines.b.h)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject3;
      }
      while (((ah.a)localObject2).aiwY)
      {
        Log.w("MicroMsg.MaasMovieSessionManager", "retry export");
        localObject2 = f.a(this.oas, this.oat, this.oar, true);
        paramObject = (kotlinx.coroutines.b.h)new c((ah.c)localObject1, paramObject);
        localObject1 = (kotlin.d.d)this;
        this.L$0 = null;
        this.Uf = null;
        this.VC = null;
        this.label = 3;
        if (((g)localObject2).a(paramObject, (kotlin.d.d)localObject1) != locala) {
          break;
        }
        AppMethodBeat.o(239710);
        return locala;
        ResultKt.throwOnFailure(paramObject);
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Float>
    {
      public a(ah.c paramc, kotlinx.coroutines.b.h paramh) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(239703);
        Object localObject1;
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        Object localObject2;
        for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(239825);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.oax.a(null, (kotlin.d.d)this);
                AppMethodBeat.o(239825);
                return paramAnonymousObject;
              }
            })
        {
          localObject2 = paramd.result;
          localObject1 = kotlin.d.a.a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramFloat = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(239703);
            throw paramFloat;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        float f = ((Number)paramFloat).floatValue();
        if (f > this.oav.aixa)
        {
          paramFloat = paramObject;
          paramd.label = 1;
          if (paramFloat.a(Float.valueOf(f), paramd) == localObject1)
          {
            AppMethodBeat.o(239703);
            return localObject1;
            ResultKt.throwOnFailure(localObject2);
          }
        }
        paramFloat = ah.aiuX;
        AppMethodBeat.o(239703);
        return paramFloat;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.h<Float>
    {
      public b(ah.c paramc, kotlinx.coroutines.b.h paramh) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(239704);
        float f = ((Number)paramFloat).floatValue();
        this.oav.aixa = f;
        paramFloat = paramObject.a(Float.valueOf(f), paramd);
        if (paramFloat == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(239704);
          return paramFloat;
        }
        paramFloat = ah.aiuX;
        AppMethodBeat.o(239704);
        return paramFloat;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements kotlinx.coroutines.b.h<Float>
    {
      public c(ah.c paramc, kotlinx.coroutines.b.h paramh) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(239731);
        Object localObject1;
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        Object localObject2;
        for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(239797);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.oay.a(null, (kotlin.d.d)this);
                AppMethodBeat.o(239797);
                return paramAnonymousObject;
              }
            })
        {
          localObject2 = paramd.result;
          localObject1 = kotlin.d.a.a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramFloat = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(239731);
            throw paramFloat;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        float f = ((Number)paramFloat).floatValue();
        if (f > this.oav.aixa)
        {
          paramFloat = paramObject;
          paramd.label = 1;
          if (paramFloat.a(Float.valueOf(f), paramd) == localObject1)
          {
            AppMethodBeat.o(239731);
            return localObject1;
            ResultKt.throwOnFailure(localObject2);
          }
        }
        paramFloat = ah.aiuX;
        AppMethodBeat.o(239731);
        return paramFloat;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    d(String paramString1, String paramString2, MJExportSettings paramMJExportSettings, f paramf, long paramLong)
    {
      super();
    }
    
    private static final void a(MJExportSettings paramMJExportSettings, String paramString, long paramLong, MJMovieSession.OnComplete paramOnComplete, MJError paramMJError)
    {
      AppMethodBeat.i(239706);
      s.u(paramMJExportSettings, "$exportSettings");
      s.u(paramString, "$outPath");
      s.u(paramOnComplete, "$onComplete");
      if (paramMJError != null)
      {
        paramString = c.obu;
        c.a(paramMJError);
        if (paramMJError.ec == MJError.MaasEC.VideoEncodeFailed)
        {
          Log.e("MicroMsg.MaasMovieSessionManager", "export encode error, mark");
          paramString = com.tencent.mm.mj_template.album_template.d.nWs;
          paramMJExportSettings = com.tencent.maas.instamovie.mediafoundation.b.mM(paramMJExportSettings.getVideoDimensionLevel());
          s.s(paramMJExportSettings, "valueOf(exportSettings.videoDimensionLevel)");
          com.tencent.mm.mj_template.album_template.d.a(paramMJExportSettings);
        }
      }
      for (;;)
      {
        paramMJExportSettings = c.obu;
        c.iq(System.currentTimeMillis() - paramLong);
        paramOnComplete.onComplete(paramMJError);
        AppMethodBeat.o(239706);
        return;
        paramMJExportSettings = c.obu;
        c.HJ(paramString);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    public f(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    public g(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    public h(String paramString, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    public i(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    public j(String paramString, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class k
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    public k(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplate", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    l(String paramString1, f paramf, String paramString2, List<? extends MJAssetInfo> paramList, ah.f<MJRecommendOptions.Mode> paramf1, MJMovieSession.OnComplete paramOnComplete)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    m(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    public n(List<? extends GalleryItem.MediaItem> paramList, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class o
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    public o(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;", "onProgress", "Lcom/tencent/maas/instamovie/MJMovieSession$OnProgress;", "onComplete", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.m<MJMovieSession.OnProgress, MJMovieSession.OnComplete, MJAsyncTaskInfo>
  {
    p(List<? extends GalleryItem.MediaItem> paramList, boolean paramBoolean, MJRecommendOptions.Mode paramMode, f paramf, MJMovieSession.OnComplete paramOnComplete)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/maas/instamovie/MJAsyncTaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.b<MJAsyncTaskInfo, ah>
  {
    q(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/base/MJError;", "it", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<MJMovieSession.OnComplete, MJError>
  {
    r(f paramf, MJTime paramMJTime)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/base/MJError;", "it", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.b<MJMovieSession.OnComplete, MJError>
  {
    s(f paramf)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    t(f paramf, kotlin.d.d<? super t> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239859);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oas.a(false, false, (kotlin.d.d)this);
      AppMethodBeat.o(239859);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/instamovie/base/MJError;", "it", "Lcom/tencent/maas/instamovie/MJMovieSession$OnComplete;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.b<MJMovieSession.OnComplete, MJError>
  {
    u(f paramf, MJMovieOptions paramMJMovieOptions)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.f
 * JD-Core Version:    0.7.0.1
 */