package com.tencent.mm.mj_template.maas.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.tencent.maas.MJMaasCore;
import com.tencent.maas.instamovie.MJExportSettings;
import com.tencent.maas.instamovie.MJMovieOptions;
import com.tencent.maas.instamovie.MJMovieSession;
import com.tencent.maas.instamovie.MJMovieSession.OnMediaTimeChange;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.model.MJChannelEventConfig;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.maas.model.MJTemplateCategory;
import com.tencent.maas.model.MJTemplateInfo;
import com.tencent.maas.model.time.MJTime;
import com.tencent.maas.model.time.MJTimeRange;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.maas.b.c;
import com.tencent.mm.mj_template.maas.e;
import com.tencent.mm.mj_template.maas.f;
import com.tencent.mm.mj_template.maas.f.c;
import com.tencent.mm.mj_template.maas.f.f;
import com.tencent.mm.mj_template.maas.f.g;
import com.tencent.mm.mj_template.maas.f.h;
import com.tencent.mm.mj_template.maas.f.i;
import com.tencent.mm.mj_template.maas.f.j;
import com.tencent.mm.mj_template.maas.f.k;
import com.tencent.mm.mj_template.maas.f.n;
import com.tencent.mm.mj_template.maas.f.o;
import com.tencent.mm.mj_template.maas.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.d<-Lkotlinx.coroutines.b.g<Ljava.lang.Float;>;>;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/MaasSdkUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "creationMusicId", "", "creationTemplateId", "curPlayTime", "Lcom/tencent/maas/model/time/MJTime;", "kotlin.jvm.PlatformType", "maasMovieSessionInitialParams", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$MaasMovieSessionInitialParams;", "mediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "movieSessionConfigProvider", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IMaasMovieSessionConfigProvider;", "movieSessionManager", "Lcom/tencent/mm/mj_template/maas/MaasMovieSessionManager;", "needRecommend", "", "onPlaybackTimeChange", "Lcom/tencent/maas/instamovie/MJMovieSession$OnMediaTimeChange;", "playingState", "Lcom/tencent/mm/mj_template/maas/uic/MaasSdkUIC$PlayingStateImpl;", "recommendCategoryListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/maas/model/MJTemplateCategory;", "recommendResult", "Lcom/tencent/mm/mj_template/maas/MaasRecommendResult;", "recommendTemplateListLiveData", "Lcom/tencent/maas/model/MJTemplateInfo;", "uiCallback", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$UICallback;", "useBlank", "export", "Lkotlinx/coroutines/flow/Flow;", "", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterLocalTemplate", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "templateList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentLyricInfo", "Lcom/tencent/maas/model/MJLyricInfo;", "getPlaybackDurationMs", "", "getPlayingState", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IPlayingState;", "getRecommendCategoryListLivedata", "Landroidx/lifecycle/LiveData;", "getRecommendResultLiveData", "getRecommendTemplateListLivedata", "getReportScene", "", "getTemplateEventInfo", "Lcom/tencent/maas/model/MJChannelEventConfig;", "initMovieSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mediaPreCheck", "onBeforeFinish", "resultIntent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRecommendResult", "manager", "error", "Lcom/tencent/mm/mj_template/maas/MaasRuntimeException;", "onResume", "performCreation", "performCreationWithBlankTemplate", "performCreationWithRecommendTemplate", "performCreationWithTemplate", "recreateWithBlankTemplate", "recreateWithMusicID", "musicId", "recreateWithTemplateID", "templateId", "registerUICallback", "callback", "setCreationTemplateIdAndMusicId", "setMaasMovieSessionConfigProvider", "provider", "setMaasMovieSessionInitialParams", "params", "setMediaList", "setNeedRecommend", "autoRecommend", "setUseBlankForRecommend", "switchMovieOption", "musicMuted", "originMuted", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unRegisterUICallback", "updateMovieOption", "Companion", "PlayingStateImpl", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
  implements a
{
  public static final b.a oca;
  private List<? extends GalleryItem.MediaItem> nZr;
  private f ocb;
  private a.c occ;
  private a.d ocd;
  private final x<com.tencent.mm.mj_template.maas.g> oce;
  private final x<List<MJTemplateInfo>> ocf;
  private final x<List<MJTemplateCategory>> ocg;
  private final b och;
  private String oci;
  private boolean ocj;
  private boolean ock;
  private String ocl;
  private a.a ocm;
  private MJTime ocn;
  private final MJMovieSession.OnMediaTimeChange oco;
  
  static
  {
    AppMethodBeat.i(240213);
    oca = new b.a((byte)0);
    AppMethodBeat.o(240213);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(239959);
    this.occ = new a.c("TemplateRecommendv2", true, false, -1, false, (List)ab.aivy, 0);
    this.oce = new x();
    this.ocf = new x((List)ab.aivy);
    this.ocg = new x((List)ab.aivy);
    this.och = new b();
    this.oci = "";
    this.ocj = true;
    this.ock = true;
    this.ocl = "";
    this.nZr = ((List)ab.aivy);
    this.ocn = MJTime.ZeroTime;
    this.oco = new b..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(239959);
  }
  
  private final Object I(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(239995);
    e locale;
    if ((paramd instanceof e))
    {
      locale = (e)paramd;
      if ((locale.label & 0x80000000) != 0) {
        locale.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      paramd = locale.result;
      locala = kotlin.d.a.a.aiwj;
      switch (locale.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239995);
        throw paramd;
        locale = new e(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    paramd = e.nZS;
    Object localObject1 = this.occ;
    locale.L$0 = this;
    locale.label = 1;
    localObject1 = paramd.a((a.c)localObject1, locale);
    Object localObject2;
    if (localObject1 == locala)
    {
      AppMethodBeat.o(239995);
      return locala;
      localObject2 = (b)locale.L$0;
      ResultKt.throwOnFailure(paramd);
      localObject1 = paramd;
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject2;; paramd = this)
    {
      localObject1 = (f)localObject1;
      if (localObject1 == null)
      {
        paramd = ((b)paramd).ocd;
        if (paramd != null) {
          paramd.Hz("create movieSessionManager error");
        }
        paramd = ah.aiuX;
        AppMethodBeat.o(239995);
        return paramd;
      }
      paramd.ocb = ((f)localObject1);
      localObject2 = e.nZS;
      locale.L$0 = paramd;
      locale.Uf = localObject1;
      locale.label = 2;
      localObject2 = ((e)localObject2).y(locale);
      Object localObject3;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(239995);
        return locala;
        localObject1 = (f)locale.Uf;
        localObject3 = (b)locale.L$0;
        ResultKt.throwOnFailure(paramd);
        localObject2 = paramd;
        paramd = (kotlin.d.d<? super ah>)localObject3;
      }
      for (;;)
      {
        localObject2 = (SurfaceView)localObject2;
        if (localObject2 == null)
        {
          paramd = ((b)paramd).ocd;
          if (paramd != null) {
            paramd.Hz("create renderSurface error");
          }
          paramd = ah.aiuX;
          AppMethodBeat.o(239995);
          return paramd;
        }
        localObject3 = paramd.ocd;
        if (localObject3 != null) {
          ((a.d)localObject3).a((SurfaceView)localObject2);
        }
        localObject2 = e.nZS;
        localObject1 = ((f)localObject1).oam;
        s.u(localObject1, "movieSession");
        if (!e.nZV) {
          Log.e("MicroMsg.MaasManager", "not initialized");
        }
        e.bxo().connectToSession((MJMovieSession)localObject1);
        locale.L$0 = paramd;
        locale.Uf = null;
        locale.label = 3;
        localObject1 = paramd;
        if (paramd.K(locale) == locala)
        {
          AppMethodBeat.o(239995);
          return locala;
          localObject1 = (b)locale.L$0;
          ResultKt.throwOnFailure(paramd);
        }
        locale.L$0 = null;
        locale.label = 4;
        if (((b)localObject1).J(locale) == locala)
        {
          AppMethodBeat.o(239995);
          return locala;
          ResultKt.throwOnFailure(paramd);
        }
        paramd = ah.aiuX;
        AppMethodBeat.o(239995);
        return paramd;
      }
    }
  }
  
  private final Object J(final kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(240027);
    j localj;
    if ((paramd instanceof j))
    {
      localj = (j)paramd;
      if ((localj.label & 0x80000000) != 0) {
        localj.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      paramd = localj.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localj.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240027);
        throw paramd;
        localj = new j(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    Log.i("MaasMultiTemplate.MaasSdkUIC", "performCreation: tmplId " + this.oci + ", musicId: " + this.ocl + ", autoRecommend: " + this.ocj);
    paramd = this.ocb;
    Object localObject1;
    label236:
    Object localObject3;
    Object localObject2;
    if (paramd != null)
    {
      int i;
      if (((CharSequence)this.oci).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label395;
        }
        if (!this.ock) {
          break label290;
        }
        localObject1 = paramd.a(this.nZr, this.ocj, new b..ExternalSyntheticLambda0(this, paramd));
        if (localObject1 != null) {
          break label428;
        }
        localObject3 = null;
        localObject2 = paramd;
        localObject1 = paramd;
        paramd = this;
      }
      for (;;)
      {
        if (localObject3 == null)
        {
          paramd = paramd.ocd;
          if (paramd != null) {
            paramd.Hz("creation error");
          }
          paramd = ah.aiuX;
          AppMethodBeat.o(240027);
          return paramd;
          i = 0;
          break;
          label290:
          if (this.ocj)
          {
            localObject1 = this.nZr;
            s.u(localObject1, "mediaInfo");
            localObject1 = o.d(i.a("201", (m)new f.n((List)localObject1, paramd), (kotlin.g.a.b)new f.o(paramd)), (q)new n(this, paramd, null));
            break label236;
          }
          Log.w("MaasMultiTemplate.MaasSdkUIC", "needRecommend is " + this.ocj + ", do not call recommend");
          localObject1 = null;
          break label236;
          label395:
          localObject1 = paramd.a(this.oci, this.ocl, this.nZr, this.ocj, new b..ExternalSyntheticLambda1(this, paramd));
          break label236;
          label428:
          localObject1 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject1, (q)new k(this, null));
          if (localObject1 == null)
          {
            localObject3 = null;
            localObject2 = paramd;
            localObject1 = paramd;
            paramd = this;
          }
          else
          {
            localObject1 = o.d((kotlinx.coroutines.b.g)localObject1, (q)new l(this, paramd, null));
            if (localObject1 == null)
            {
              localObject3 = null;
              localObject2 = paramd;
              localObject1 = paramd;
              paramd = this;
            }
            else
            {
              localObject2 = (kotlinx.coroutines.b.h)new m(this);
              localj.L$0 = this;
              localj.Uf = paramd;
              localj.VC = paramd;
              localj.label = 1;
              if (((kotlinx.coroutines.b.g)localObject1).a((kotlinx.coroutines.b.h)localObject2, localj) != locala) {
                break label735;
              }
              AppMethodBeat.o(240027);
              return locala;
              localObject2 = (f)localj.VC;
              localObject1 = (f)localj.Uf;
              localObject3 = (b)localj.L$0;
              ResultKt.throwOnFailure(paramd);
            }
          }
        }
      }
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject3;; paramd = this)
    {
      localObject3 = ah.aiuX;
      break;
      localj.L$0 = paramd;
      localj.Uf = localObject1;
      localj.VC = null;
      localj.label = 2;
      localObject2 = f.a((f)localObject2, localj);
      localObject1 = localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(240027);
        return locala;
        localObject2 = (b)localj.L$0;
        ResultKt.throwOnFailure(paramd);
        localObject1 = paramd;
        paramd = (kotlin.d.d<? super ah>)localObject2;
      }
      if (((Boolean)localObject1).booleanValue())
      {
        localObject1 = paramd.ocd;
        if (localObject1 != null) {
          ((a.d)localObject1).bwM();
        }
        paramd.byo();
      }
      for (;;)
      {
        paramd = ah.aiuX;
        AppMethodBeat.o(240027);
        return paramd;
        paramd = paramd.ocd;
        if (paramd != null) {
          paramd.Hz("start play error");
        }
      }
      label735:
      localObject2 = paramd;
      localObject1 = paramd;
    }
  }
  
  private final Object K(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(240072);
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    Object localObject7;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new f(this, paramd))
    {
      localObject7 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240072);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject7);
    Object localObject2 = (Iterable)this.nZr;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((GalleryItem.MediaItem)localObject3).getType() == 1) {}
      for (i = 1; i != 0; i = 0)
      {
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject5;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (GalleryItem.MediaItem)localObject3;
      localObject5 = ((GalleryItem.MediaItem)localObject4).mMimeType;
      s.s(localObject5, "it.mimeType");
      if (!n.i((CharSequence)localObject5, (CharSequence)"heic"))
      {
        localObject4 = ((GalleryItem.MediaItem)localObject4).mMimeType;
        s.s(localObject4, "it.mimeType");
        if (!n.i((CharSequence)localObject4, (CharSequence)"heif")) {
          break label337;
        }
      }
      label337:
      for (i = 1; i != 0; i = 0)
      {
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3 = this;
    Object localObject4 = paramd;
    paramd = (kotlin.d.d<? super ah>)localObject2;
    Object localObject6;
    if (((Iterator)localObject1).hasNext())
    {
      localObject6 = (GalleryItem.MediaItem)((Iterator)localObject1).next();
      localObject2 = com.tencent.mm.mj_template.maas.b.nZx;
      localObject2 = ((GalleryItem.MediaItem)localObject6).Gcc;
      s.s(localObject2, "item.originalPath");
      ((f)localObject4).L$0 = localObject3;
      ((f)localObject4).Uf = paramd;
      ((f)localObject4).VC = localObject1;
      ((f)localObject4).VD = localObject6;
      ((f)localObject4).Ze = paramd;
      ((f)localObject4).label = 1;
      localObject7 = com.tencent.mm.mj_template.maas.b.b((String)localObject2, (kotlin.d.d)localObject4);
      if (localObject7 != locala) {
        break label823;
      }
      AppMethodBeat.o(240072);
      return locala;
      localObject5 = (Collection)paramd.Ze;
      localObject6 = (GalleryItem.MediaItem)paramd.VD;
      localObject1 = (Iterator)paramd.VC;
      localObject2 = (Collection)paramd.Uf;
      localObject3 = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject7);
      localObject4 = paramd;
    }
    for (paramd = localObject7;; paramd = localObject7)
    {
      paramd = (String)paramd;
      if (paramd == null) {}
      for (paramd = null;; paramd = new GalleryItem.ImageMediaItem(((GalleryItem.MediaItem)localObject6).HHJ, paramd, ((GalleryItem.MediaItem)localObject6).bud(), ((GalleryItem.MediaItem)localObject6).mMimeType))
      {
        ((Collection)localObject5).add(paramd);
        paramd = (kotlin.d.d<? super ah>)localObject2;
        break;
      }
      localObject2 = kotlin.a.p.l((Iterable)paramd);
      Log.i("MaasMultiTemplate.MaasSdkUIC", s.X("transcoded size: ", Integer.valueOf(((List)localObject2).size())));
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label811;
        }
        paramd = (Iterable)((b)localObject3).nZr;
        localObject4 = (Collection)new ArrayList(kotlin.a.p.a(paramd, 10));
        localObject5 = paramd.iterator();
        label683:
        if (!((Iterator)localObject5).hasNext()) {
          break label801;
        }
        localObject1 = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        localObject6 = ((Iterable)localObject2).iterator();
        label716:
        if (!((Iterator)localObject6).hasNext()) {
          break label788;
        }
        paramd = ((Iterator)localObject6).next();
        if (((GalleryItem.ImageMediaItem)paramd).HHJ != ((GalleryItem.MediaItem)localObject1).HHJ) {
          break label783;
        }
        i = 1;
        label751:
        if (i == 0) {
          break label786;
        }
        label755:
        paramd = (GalleryItem.ImageMediaItem)paramd;
        if (paramd != null) {
          break label793;
        }
      }
      label783:
      label786:
      label788:
      label793:
      for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = (GalleryItem.MediaItem)paramd)
      {
        ((Collection)localObject4).add(paramd);
        break label683;
        i = 0;
        break;
        i = 0;
        break label751;
        break label716;
        paramd = null;
        break label755;
      }
      label801:
      ((b)localObject3).nZr = ((List)localObject4);
      label811:
      paramd = ah.aiuX;
      AppMethodBeat.o(240072);
      return paramd;
      label823:
      localObject5 = paramd;
      localObject2 = paramd;
    }
  }
  
  private static final void a(b paramb, MJTime paramMJTime, MJTimeRange paramMJTimeRange, long paramLong)
  {
    AppMethodBeat.i(240082);
    s.u(paramb, "this$0");
    paramb.ocn = paramMJTime;
    AppMethodBeat.o(240082);
  }
  
  private static final void a(b paramb, f paramf, MJError paramMJError)
  {
    AppMethodBeat.i(240095);
    s.u(paramb, "this$0");
    s.u(paramf, "$manager");
    Log.i("MaasMultiTemplate.MaasSdkUIC", "recommend with blank onComplete");
    if (paramMJError == null) {}
    for (paramMJError = null;; paramMJError = new com.tencent.mm.mj_template.maas.h(paramMJError))
    {
      paramb.a(paramf, paramMJError);
      AppMethodBeat.o(240095);
      return;
    }
  }
  
  private final void a(f paramf, com.tencent.mm.mj_template.maas.h paramh)
  {
    AppMethodBeat.i(240047);
    Object localObject2 = this.oce;
    if (paramh == null) {}
    for (Object localObject1 = null;; localObject1 = paramh.oaJ)
    {
      ((x)localObject2).t(new com.tencent.mm.mj_template.maas.g((MJError)localObject1));
      if (paramh == null) {
        break;
      }
      Log.e("MaasMultiTemplate.MaasSdkUIC", s.X("recommend error ", paramh.getMessage()));
      AppMethodBeat.o(240047);
      return;
    }
    paramh = paramf.oam.getRecommendedTemplateInfos();
    s.s(paramh, "manager.movieSession.recommendedTemplateInfos");
    localObject1 = (Iterable)paramh;
    paramh = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label163:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (((MJTemplateInfo)localObject2).getTemplateDescVersion() != 0L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label163;
        }
        paramh.add(localObject2);
        break;
      }
    }
    paramh = (List)paramh;
    paramf = paramf.oam.getRecommendedTemplateCategories();
    Log.i("MaasMultiTemplate.MaasSdkUIC", "recommendResult: template.size:" + paramh.size() + ",categories.size:" + paramf.size());
    localObject1 = ((Iterable)paramh).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MJTemplateInfo)((Iterator)localObject1).next();
      com.tencent.mm.mj_template.b.b localb = com.tencent.mm.mj_template.b.b.ofM;
      s.s(localObject2, "it");
      com.tencent.mm.mj_template.b.b.a((MJTemplateInfo)localObject2);
    }
    this.ocf.t(paramh);
    this.ocg.t(paramf);
    AppMethodBeat.o(240047);
  }
  
  private static final void b(b paramb, f paramf, MJError paramMJError)
  {
    AppMethodBeat.i(240108);
    s.u(paramb, "this$0");
    s.u(paramf, "$manager");
    if (paramMJError == null) {}
    for (paramMJError = null;; paramMJError = new com.tencent.mm.mj_template.maas.h(paramMJError))
    {
      paramb.a(paramf, paramMJError);
      AppMethodBeat.o(240108);
      return;
    }
  }
  
  private final void byo()
  {
    AppMethodBeat.i(239975);
    Object localObject = this.ocb;
    if (localObject != null)
    {
      localObject = ((f)localObject).oam;
      if (localObject != null)
      {
        this.och.ocr.t(Boolean.valueOf(((MJMovieSession)localObject).getCurrentMovieOptions().isBGMMuted()));
        this.och.ocs.t(Boolean.valueOf(((MJMovieSession)localObject).getCurrentMovieOptions().isOSTMuted()));
      }
    }
    AppMethodBeat.o(239975);
  }
  
  public final Object H(kotlin.d.d<? super kotlinx.coroutines.b.g<Float>> paramd)
  {
    AppMethodBeat.i(240418);
    Object localObject1;
    if ((paramd instanceof o))
    {
      localObject1 = (o)paramd;
      if ((((o)localObject1).label & 0x80000000) != 0) {
        ((o)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    for (paramd = (kotlin.d.d<? super kotlinx.coroutines.b.g<Float>>)localObject1;; paramd = new o(this, paramd))
    {
      localObject3 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240418);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject3);
    Object localObject2 = this.ocb;
    if (localObject2 != null)
    {
      paramd.L$0 = this;
      paramd.Uf = localObject2;
      paramd.label = 1;
      paramd = ((f)localObject2).C(paramd);
      if (paramd != localObject1) {
        break label275;
      }
      AppMethodBeat.o(240418);
      return localObject1;
      localObject1 = (f)paramd.Uf;
      localObject2 = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject3);
      paramd = (kotlin.d.d<? super kotlinx.coroutines.b.g<Float>>)localObject1;
      localObject1 = localObject2;
      localObject2 = paramd;
      paramd = localObject3;
    }
    for (;;)
    {
      if (((Boolean)paramd).booleanValue())
      {
        paramd = o.d(o.d(i.a("222", (m)new f.f((f)localObject2), (kotlin.g.a.b)new f.g((f)localObject2)), (q)new p((f)localObject2, null)), (q)new q((b)localObject1, null));
        AppMethodBeat.o(240418);
        return paramd;
      }
      AppMethodBeat.o(240418);
      return null;
      label275:
      localObject1 = this;
    }
  }
  
  public final Object a(List<? extends fxr> paramList, kotlin.d.d<? super List<? extends fxr>> paramd)
  {
    AppMethodBeat.i(240288);
    paramList = e.nZS.a(paramList, paramd);
    AppMethodBeat.o(240288);
    return paramList;
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(240280);
    s.u(parama, "provider");
    this.ocm = parama;
    AppMethodBeat.o(240280);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(240449);
    s.u(paramc, "params");
    this.occ = paramc;
    AppMethodBeat.o(240449);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(240333);
    s.u(paramd, "callback");
    this.ocd = paramd;
    AppMethodBeat.o(240333);
  }
  
  public final void aR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(240310);
    s.u(paramString1, "templateId");
    Log.i("MaasMultiTemplate.MaasSdkUIC", "set templateId: " + paramString1 + ", musicId: " + paramString2);
    this.oci = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.ocl = paramString1;
    AppMethodBeat.o(240310);
  }
  
  public final void byc()
  {
    this.ock = false;
  }
  
  public final void byd()
  {
    this.ocd = null;
  }
  
  public final a.b bye()
  {
    return (a.b)this.och;
  }
  
  public final LiveData<List<MJTemplateInfo>> byg()
  {
    return (LiveData)this.ocf;
  }
  
  public final MJChannelEventConfig byh()
  {
    AppMethodBeat.i(240362);
    Object localObject = this.ocb;
    if (localObject == null)
    {
      AppMethodBeat.o(240362);
      return null;
    }
    localObject = ((f)localObject).oam;
    if (localObject == null)
    {
      AppMethodBeat.o(240362);
      return null;
    }
    localObject = ((MJMovieSession)localObject).getCurrentTemplateInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(240362);
      return null;
    }
    localObject = ((MJTemplateInfo)localObject).getChannelEventConfig();
    AppMethodBeat.o(240362);
    return localObject;
  }
  
  public final long byi()
  {
    AppMethodBeat.i(240464);
    Object localObject = this.ocb;
    if (localObject == null)
    {
      AppMethodBeat.o(240464);
      return 0L;
    }
    localObject = ((f)localObject).oam;
    if (localObject == null)
    {
      AppMethodBeat.o(240464);
      return 0L;
    }
    localObject = ((MJMovieSession)localObject).getPlaybackDuration();
    if (localObject == null)
    {
      AppMethodBeat.o(240464);
      return 0L;
    }
    localObject = Double.valueOf(((MJTime)localObject).toMilliseconds());
    int i;
    if (!Double.isNaN(((Number)localObject).doubleValue()))
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label119;
      }
      AppMethodBeat.o(240464);
      return 0L;
      i = 0;
      break;
      label113:
      localObject = null;
    }
    label119:
    long l = kotlin.h.a.ai(((Double)localObject).doubleValue());
    AppMethodBeat.o(240464);
    return l;
  }
  
  public final List<MJLyricInfo> byj()
  {
    AppMethodBeat.i(240456);
    Object localObject = this.ocb;
    if (localObject == null)
    {
      AppMethodBeat.o(240456);
      return null;
    }
    localObject = ((f)localObject).oam;
    if (localObject == null)
    {
      AppMethodBeat.o(240456);
      return null;
    }
    localObject = ((MJMovieSession)localObject).getCurrentLyricInfos();
    AppMethodBeat.o(240456);
    return localObject;
  }
  
  public final Object c(boolean paramBoolean1, boolean paramBoolean2, kotlin.d.d<? super ah> paramd)
  {
    int i = 1;
    AppMethodBeat.i(240374);
    if ((paramd instanceof z))
    {
      localObject1 = (z)paramd;
      if ((((z)localObject1).label & 0x80000000) != 0) {
        ((z)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new z(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240374);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = this.ocb;
    Object localObject1 = this;
    if (localObject2 != null)
    {
      if (paramBoolean1)
      {
        paramBoolean1 = true;
        if (!paramBoolean2) {
          break label198;
        }
      }
      label198:
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        paramd.L$0 = this;
        paramd.label = 1;
        localObject1 = ((f)localObject2).a(paramBoolean1, paramBoolean2, paramd);
        localObject2 = localObject1;
        paramd = this;
        if (localObject1 != locala) {
          break label216;
        }
        AppMethodBeat.o(240374);
        return locala;
        paramBoolean1 = false;
        break;
      }
      paramd = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
      label216:
      localObject1 = paramd;
      if (((Boolean)localObject2).booleanValue() != true) {}
    }
    for (;;)
    {
      if (i != 0) {
        paramd.byo();
      }
      paramd = ah.aiuX;
      AppMethodBeat.o(240374);
      return paramd;
      i = 0;
      paramd = (kotlin.d.d<? super ah>)localObject1;
    }
  }
  
  public final Object d(String paramString, kotlin.d.d<? super kotlinx.coroutines.b.g<Float>> paramd)
  {
    AppMethodBeat.i(240404);
    Object localObject1;
    if ((paramd instanceof v))
    {
      localObject1 = (v)paramd;
      if ((((v)localObject1).label & 0x80000000) != 0) {
        ((v)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super kotlinx.coroutines.b.g<Float>>)localObject1;; paramd = new v(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240404);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject3 = this.ocb;
    if (localObject3 != null)
    {
      localObject1 = ((f)localObject3).oam.getCurrentTemplateInfo();
      if (localObject1 == null) {}
      for (localObject1 = null; s.p(paramString, localObject1); localObject1 = ((MJTemplateInfo)localObject1).getTemplateID())
      {
        Log.i("MaasMultiTemplate.MaasSdkUIC", s.X("no need to recreateWithTemplateID ", paramString));
        paramString = kotlinx.coroutines.b.j.y((m)new b.w(null));
        AppMethodBeat.o(240404);
        return paramString;
      }
      paramd.L$0 = this;
      paramd.Uf = paramString;
      paramd.VC = localObject3;
      paramd.label = 1;
      localObject2 = ((f)localObject3).C(paramd);
      if (localObject2 != locala) {
        break label371;
      }
      AppMethodBeat.o(240404);
      return locala;
      paramString = (f)paramd.VC;
      localObject1 = (String)paramd.Uf;
      paramd = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
      localObject3 = paramString;
    }
    for (;;)
    {
      if (((Boolean)localObject2).booleanValue())
      {
        s.u(localObject1, "templateId");
        paramString = o.d(o.d(i.a("221", (m)new f.j((String)localObject1, (f)localObject3), (kotlin.g.a.b)new f.k((f)localObject3)), (q)new x((f)localObject3, null)), (q)new y(paramd, (f)localObject3, null));
        AppMethodBeat.o(240404);
        return paramString;
      }
      AppMethodBeat.o(240404);
      return null;
      label371:
      paramd = this;
      localObject1 = paramString;
    }
  }
  
  public final Object e(String paramString, kotlin.d.d<? super kotlinx.coroutines.b.g<Float>> paramd)
  {
    AppMethodBeat.i(240391);
    Object localObject1;
    if ((paramd instanceof r))
    {
      localObject1 = (r)paramd;
      if ((((r)localObject1).label & 0x80000000) != 0) {
        ((r)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super kotlinx.coroutines.b.g<Float>>)localObject1;; paramd = new r(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240391);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject3 = this.ocb;
    if (localObject3 != null)
    {
      localObject1 = ((f)localObject3).oam.getCurrentMusicInfo();
      if (localObject1 == null) {}
      for (localObject1 = null; s.p(paramString, localObject1); localObject1 = ((MJMusicInfo)localObject1).getMusicID())
      {
        Log.i("MaasMultiTemplate.MaasSdkUIC", s.X("no need to recreateWithMusicID ", paramString));
        paramString = kotlinx.coroutines.b.j.y((m)new b.s(null));
        AppMethodBeat.o(240391);
        return paramString;
      }
      paramd.L$0 = this;
      paramd.Uf = paramString;
      paramd.VC = localObject3;
      paramd.label = 1;
      localObject2 = ((f)localObject3).C(paramd);
      if (localObject2 != locala) {
        break label371;
      }
      AppMethodBeat.o(240391);
      return locala;
      paramString = (f)paramd.VC;
      localObject1 = (String)paramd.Uf;
      paramd = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
      localObject3 = paramString;
    }
    for (;;)
    {
      if (((Boolean)localObject2).booleanValue())
      {
        s.u(localObject1, "musicId");
        paramString = o.d(o.d(i.a("220", (m)new f.h((String)localObject1, (f)localObject3), (kotlin.g.a.b)new f.i((f)localObject3)), (q)new t((f)localObject3, null)), (q)new u(paramd, (f)localObject3, null));
        AppMethodBeat.o(240391);
        return paramString;
      }
      AppMethodBeat.o(240391);
      return null;
      label371:
      paramd = this;
      localObject1 = paramString;
    }
  }
  
  public final Object f(String paramString, kotlin.d.d<? super kotlinx.coroutines.b.g<Float>> paramd)
  {
    AppMethodBeat.i(240432);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    Object localObject3;
    for (paramd = (kotlin.d.d<? super kotlinx.coroutines.b.g<Float>>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      localObject3 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240432);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = this.ocb;
    if (localObject1 != null)
    {
      paramd.L$0 = this;
      paramd.Uf = paramString;
      paramd.VC = localObject1;
      paramd.label = 1;
      localObject2 = ((f)localObject1).C(paramd);
      if (localObject2 != localObject3) {
        break label307;
      }
      AppMethodBeat.o(240432);
      return localObject3;
      localObject1 = (f)paramd.VC;
      paramString = (String)paramd.Uf;
      paramd = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    for (;;)
    {
      if (((Boolean)localObject2).booleanValue())
      {
        localObject3 = paramd.ocm;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("movieSessionConfigProvider");
          localObject2 = null;
        }
        localObject2 = ((a.a)localObject2).bwB();
        s.u(paramString, "outPath");
        s.u(localObject2, "settings");
        paramString = o.d(kotlinx.coroutines.b.j.y((m)new f.c((MJExportSettings)localObject2, (f)localObject1, paramString, null)), (q)new d(paramd, null));
        AppMethodBeat.o(240432);
        return paramString;
      }
      AppMethodBeat.o(240432);
      return null;
      label307:
      paramd = this;
    }
  }
  
  public final void gO(boolean paramBoolean)
  {
    this.ocj = paramBoolean;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(240440);
    super.onBeforeFinish(paramIntent);
    Log.i("MaasMultiTemplate.MaasSdkUIC", "release onBeforeFinish");
    paramIntent = this.ocb;
    if (paramIntent != null) {
      paramIntent.release();
    }
    this.ocb = null;
    AppMethodBeat.o(240440);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240250);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.mj_template.maas.b.a.obp;
    int i;
    switch (getIntent().getIntExtra("key_maas_entrance", 0))
    {
    default: 
      i = 200;
    }
    for (;;)
    {
      com.tencent.mm.mj_template.maas.b.a.uK(i);
      paramBundle = c.obu;
      c.uL(getIntent().getIntExtra("key_maas_entrance", 0));
      kotlinx.coroutines.j.a(getMainScope(), null, null, (m)new g(this, null), 3);
      AppMethodBeat.o(240250);
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 100;
      continue;
      i = 101;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(240275);
    super.onDestroy();
    Object localObject = this.ocb;
    if (localObject != null)
    {
      localObject = ((f)localObject).oam;
      if (localObject != null) {
        ((MJMovieSession)localObject).setOnPlaybackMediaTimeDidChange(null);
      }
    }
    localObject = this.ocb;
    if (localObject != null) {
      ((f)localObject).release();
    }
    this.ocb = null;
    localObject = com.tencent.mm.mj_template.maas.b.a.obp;
    com.tencent.mm.mj_template.maas.b.a.uK(0);
    AppMethodBeat.o(240275);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(240263);
    super.onPause();
    kotlinx.coroutines.j.a(getMainScope(), null, null, (m)new h(this, null), 3);
    AppMethodBeat.o(240263);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(240254);
    super.onResume();
    kotlinx.coroutines.j.a(getMainScope(), null, null, (m)new i(this, null), 3);
    AppMethodBeat.o(240254);
  }
  
  public final void setMediaList(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(240296);
    s.u(paramList, "mediaList");
    this.nZr = paramList;
    AppMethodBeat.o(240296);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/MaasSdkUIC$PlayingStateImpl;", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IPlayingState;", "()V", "musicInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/maas/model/MJMusicInfo;", "getMusicInfo", "()Landroidx/lifecycle/MutableLiveData;", "musicInfos", "", "getMusicInfos", "musicMuted", "", "kotlin.jvm.PlatformType", "getMusicMuted", "originMuted", "getOriginMuted", "getCurrentMusicInfo", "Landroidx/lifecycle/LiveData;", "getCurrentMusicInfoList", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements a.b
  {
    final x<List<MJMusicInfo>> ocp;
    final x<MJMusicInfo> ocq;
    final x<Boolean> ocr;
    final x<Boolean> ocs;
    
    public b()
    {
      AppMethodBeat.i(239882);
      this.ocp = new x((List)ab.aivy);
      this.ocq = new x();
      this.ocr = new x(Boolean.FALSE);
      this.ocs = new x(Boolean.FALSE);
      AppMethodBeat.o(239882);
    }
    
    public final LiveData<List<MJMusicInfo>> byk()
    {
      return (LiveData)this.ocp;
    }
    
    public final LiveData<MJMusicInfo> byl()
    {
      return (LiveData)this.ocq;
    }
    
    public final LiveData<Boolean> bym()
    {
      return (LiveData)this.ocr;
    }
    
    public final LiveData<Boolean> byn()
    {
      return (LiveData)this.ocs;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    c(b paramb, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239885);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oct.f(null, (kotlin.d.d)this);
      AppMethodBeat.o(239885);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(b paramb, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239884);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239884);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((Throwable)this.L$0 == null)
      {
        Log.i("MaasMultiTemplate.MaasSdkUIC", "release after export");
        paramObject = b.b(this.oct);
        if (paramObject != null) {
          paramObject.release();
        }
        b.e(this.oct);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239884);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    e(b paramb, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239881);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(this.oct, (kotlin.d.d)this);
      AppMethodBeat.o(239881);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int label;
    
    f(b paramb, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239880);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.c(this.oct, (kotlin.d.d)this);
      AppMethodBeat.o(239880);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(b paramb, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239913);
      paramObject = (kotlin.d.d)new g(this.oct, paramd);
      AppMethodBeat.o(239913);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239907);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239907);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.a(this.oct);
        if (paramObject != null)
        {
          locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.w(locald) == locala)
          {
            AppMethodBeat.o(239907);
            return locala;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.oct;
        locald = (kotlin.d.d)this;
        this.label = 2;
        if (b.a(paramObject, locald) != locala) {
          break label140;
        }
        AppMethodBeat.o(239907);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label140:
      paramObject = ah.aiuX;
      AppMethodBeat.o(239907);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(b paramb, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239904);
      paramObject = (kotlin.d.d)new h(this.oct, paramd);
      AppMethodBeat.o(239904);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239899);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239899);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.b(this.oct);
        if (paramObject != null)
        {
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.C(locald) == locala)
          {
            AppMethodBeat.o(239899);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239899);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(b paramb, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239903);
      paramObject = (kotlin.d.d)new i(this.oct, paramd);
      AppMethodBeat.o(239903);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239898);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239898);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.b(this.oct);
        if (paramObject != null)
        {
          MJTime localMJTime = b.c(this.oct);
          s.s(localMJTime, "curPlayTime");
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.a(localMJTime, locald) == locala)
          {
            AppMethodBeat.o(239898);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239898);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    j(b paramb, kotlin.d.d<? super j> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239894);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.b(this.oct, (kotlin.d.d)this);
      AppMethodBeat.o(239894);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    k(b paramb, kotlin.d.d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239895);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239895);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.printErrStackTrace("MaasMultiTemplate.MaasSdkUIC", (Throwable)this.L$0, "creation error", new Object[0]);
      paramObject = b.a(this.oct);
      if (paramObject != null) {
        paramObject.Hz("creation error");
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239895);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    l(b paramb, f paramf, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239914);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239914);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      x localx = b.d(this.oct).ocp;
      localObject = paramd.oam.getCurrentTemplateMusicInfos();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = (List)ab.aivy;
      }
      localx.t(paramObject);
      localx = b.d(this.oct).ocq;
      localObject = paramd.oam.getCurrentMusicInfo();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = new MJMusicInfo("", "", "", MJTime.InvalidTime, new Object[0]);
      }
      localx.t(paramObject);
      Log.i("MaasMultiTemplate.MaasSdkUIC", "startMovieCreationAutoRecommendTemplate onCompletion");
      paramd.oam.setOnPlaybackMediaTimeDidChange(b.f(this.oct));
      paramObject = ah.aiuX;
      AppMethodBeat.o(239914);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements kotlinx.coroutines.b.h<Float>
  {
    public m(b paramb) {}
    
    public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(239892);
      float f = ((Number)paramFloat).floatValue();
      paramFloat = b.a(this.oct);
      if (paramFloat == null) {}
      for (paramFloat = null; paramFloat == kotlin.d.a.a.aiwj; paramFloat = ah.aiuX)
      {
        AppMethodBeat.o(239892);
        return paramFloat;
        paramFloat.br(f);
      }
      paramFloat = ah.aiuX;
      AppMethodBeat.o(239892);
      return paramFloat;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    n(b paramb, f paramf, kotlin.d.d<? super n> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239891);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239891);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (Throwable)this.L$0;
      Log.i("MaasMultiTemplate.MaasSdkUIC", "startMovieCreation recommend onComplete");
      localObject = this.oct;
      f localf = paramd;
      if ((paramObject instanceof com.tencent.mm.mj_template.maas.h)) {}
      for (paramObject = (com.tencent.mm.mj_template.maas.h)paramObject;; paramObject = null)
      {
        b.a((b)localObject, localf, paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(239891);
        return paramObject;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    o(b paramb, kotlin.d.d<? super o> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239930);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oct.H((kotlin.d.d)this);
      AppMethodBeat.o(239930);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    p(f paramf, kotlin.d.d<? super p> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239931);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239931);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ocv;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (f.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(239931);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239931);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    q(b paramb, kotlin.d.d<? super q> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239932);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239932);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((Throwable)this.L$0 == null)
      {
        b.d(this.oct).ocp.t((List)ab.aivy);
        b.d(this.oct).ocq.t(new MJMusicInfo("", "", "", MJTime.InvalidTime, new Object[0]));
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239932);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    r(b paramb, kotlin.d.d<? super r> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239924);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oct.e(null, (kotlin.d.d)this);
      AppMethodBeat.o(239924);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    t(f paramf, kotlin.d.d<? super t> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239928);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239928);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ocv;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (f.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(239928);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239928);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    u(b paramb, f paramf, kotlin.d.d<? super u> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239929);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239929);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((Throwable)this.L$0 == null) {
        b.d(this.oct).ocq.t(this.ocv.oam.getCurrentMusicInfo());
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239929);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    v(b paramb, kotlin.d.d<? super v> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239921);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oct.d(null, (kotlin.d.d)this);
      AppMethodBeat.o(239921);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    x(f paramf, kotlin.d.d<? super x> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239954);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239954);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ocv;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (f.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(239954);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239954);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends k
    implements q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    y(b paramb, f paramf, kotlin.d.d<? super y> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239953);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239953);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((Throwable)this.L$0 == null)
      {
        b.d(this.oct).ocp.t(this.ocv.oam.getCurrentTemplateMusicInfos());
        b.d(this.oct).ocq.t(this.ocv.oam.getCurrentMusicInfo());
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239953);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    z(b paramb, kotlin.d.d<? super z> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239938);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oct.c(false, false, (kotlin.d.d)this);
      AppMethodBeat.o(239938);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.c.b
 * JD-Core Version:    0.7.0.1
 */