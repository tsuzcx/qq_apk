package com.tencent.mm.mj_template.sns.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.LiveData;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.mj_template.sns.a.a.e.e;
import com.tencent.mm.mj_template.sns.a.a.e.e.a;
import com.tencent.mm.mj_template.sns.a.a.g.b;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.o;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/uic/SnsTemplateControlUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$UICallback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "composeRoot", "Landroidx/compose/ui/platform/ComposeView;", "kotlin.jvm.PlatformType", "getComposeRoot", "()Landroidx/compose/ui/platform/ComposeView;", "composeRoot$delegate", "Lkotlin/Lazy;", "curMediaDetailTd", "", "cutSameTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;", "getCutSameTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;", "cutSameTemplateInfo$delegate", "defaultTemplateList", "", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "exportPath", "", "lastSwitchTime", "", "loadingDialog", "Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "loadingDialog$delegate", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "moreTemplatePanelState", "Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;", "getMoreTemplatePanelState", "()Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;", "moreTemplatePanelState$delegate", "musicState", "Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "getMusicState$plugin_mj_template_release", "()Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "setMusicState$plugin_mj_template_release", "(Lcom/tencent/mm/mj_template/album_template/widget/MusicState;)V", "<set-?>", "navigationBarHeight", "getNavigationBarHeight", "()I", "setNavigationBarHeight", "(I)V", "navigationBarHeight$delegate", "Landroidx/compose/runtime/MutableState;", "Landroid/view/SurfaceView;", "previewView", "getPreviewView", "()Landroid/view/SurfaceView;", "setPreviewView", "(Landroid/view/SurfaceView;)V", "previewView$delegate", "reported24946", "", "showSpringOfflineStrategy", "showSpringStrategy", "templateListState", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;", "getTemplateListState", "()Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;", "templateListState$delegate", "viewVisible", "getViewVisible", "()Z", "setViewVisible", "(Z)V", "viewVisible$delegate", "awaitSpringTemplateList", "", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beforeInitMovieSession", "", "checkDir", "path", "getMusicState", "iMaasSdkUIC", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC;", "(Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC;Landroidx/compose/runtime/Composer;I)Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "initComposeView", "loadIntent", "onBeforeFinish", "resultIntent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onPause", "onPreview", "onPreviewProgress", "progress", "", "onPreviewViewCreated", "onResume", "onSdkError", "msg", "onTemplateChange", "templateId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onWindowFocusChanged", "hasFocus", "performExport", "performPost", "performSwitchMusic", "musicId", "report24946", "creationResult", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements com.tencent.mm.mj_template.maas.c.a.d
{
  public static final a.a oft;
  private final kotlin.j nWe;
  private com.tencent.mm.mj_template.album_template.a.g nWf;
  private final an ofA;
  private String ofB;
  private boolean ofC;
  private int ofD;
  private final kotlin.j ofE;
  private final kotlin.j ofF;
  private final an ofG;
  private long ofH;
  private final List<fxr> ofd;
  private final ArrayList<GalleryItem.MediaItem> ofu;
  private final kotlin.j ofv;
  private final kotlin.j ofw;
  private final boolean ofx;
  private final boolean ofy;
  private final an ofz;
  
  static
  {
    AppMethodBeat.i(240530);
    oft = new a.a((byte)0);
    AppMethodBeat.o(240530);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(240277);
    this.ofu = new ArrayList();
    this.ofv = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.ofd = ((List)new ArrayList());
    this.ofw = kotlin.k.cm((kotlin.g.a.a)new f(this));
    paramAppCompatActivity = com.tencent.mm.mj_template.plugin.d.odz;
    if (!com.tencent.mm.mj_template.plugin.d.a(b.a.agsn, "SnsVideoTemplateMiaojianRecommendEnabled", true)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ofx = bool;
      paramAppCompatActivity = com.tencent.mm.mj_template.plugin.d.odz;
      this.ofy = com.tencent.mm.mj_template.plugin.d.a(b.a.agso, "SnsVideoTemplateCdnDownloadDisabled", false);
      this.ofz = bj.T(null);
      this.ofA = bj.T(Boolean.FALSE);
      this.ofB = s.X(com.tencent.mm.vfs.ah.v(af.eC("SnsTemplateExport", false).jKT()), "/");
      this.nWe = kotlin.k.cm((kotlin.g.a.a)new k(this));
      this.ofE = kotlin.k.cm((kotlin.g.a.a)new u(this));
      this.ofF = kotlin.k.cm((kotlin.g.a.a)new l(this));
      this.ofG = bj.T(Integer.valueOf(0));
      AppMethodBeat.o(240277);
      return;
    }
  }
  
  private final Object M(kotlin.d.d<? super List<e.e>> paramd)
  {
    AppMethodBeat.i(240316);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject2 = ((b)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((b)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240316);
        throw paramd;
        localObject1 = new b(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject2);
    paramd = com.tencent.mm.mj_template.b.b.ofM;
    ((b)localObject1).L$0 = this;
    ((b)localObject1).label = 1;
    Object localObject3 = paramd.a(3, "cache_key_sns", (kotlin.d.d)localObject1);
    Object localObject2 = localObject3;
    paramd = this;
    if (localObject3 == locala)
    {
      AppMethodBeat.o(240316);
      return locala;
      paramd = (a)((b)localObject1).L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    localObject3 = (List)localObject2;
    if (localObject3 == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = (List)localObject2)
    {
      paramd.byG().bL((List)ab.aivy);
      Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "get template list info error");
      AppMethodBeat.o(240316);
      return null;
      localObject2 = (kotlin.d.f)bg.kCh();
      localObject3 = (m)new c(paramd, (List)localObject3, null);
      ((b)localObject1).L$0 = paramd;
      ((b)localObject1).label = 2;
      localObject1 = l.a((kotlin.d.f)localObject2, (m)localObject3, (kotlin.d.d)localObject1);
      localObject2 = localObject1;
      if (localObject1 == locala)
      {
        AppMethodBeat.o(240316);
        return locala;
        paramd = (a)((b)localObject1).L$0;
        ResultKt.throwOnFailure(localObject2);
      }
    }
    AppMethodBeat.o(240316);
    return localObject1;
  }
  
  private final void b(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(240293);
    this.ofz.setValue(paramSurfaceView);
    AppMethodBeat.o(240293);
  }
  
  private final SurfaceView byF()
  {
    AppMethodBeat.i(240282);
    SurfaceView localSurfaceView = (SurfaceView)((bm)this.ofz).getValue();
    AppMethodBeat.o(240282);
    return localSurfaceView;
  }
  
  private final com.tencent.mm.mj_template.sns.a.a.g byG()
  {
    AppMethodBeat.i(240298);
    com.tencent.mm.mj_template.sns.a.a.g localg = (com.tencent.mm.mj_template.sns.a.a.g)this.ofE.getValue();
    AppMethodBeat.o(240298);
    return localg;
  }
  
  private final Object g(final String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(240332);
    Object localObject1;
    if ((paramd instanceof p))
    {
      localObject1 = (p)paramd;
      if ((((p)localObject1).label & 0x80000000) != 0) {
        ((p)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject2 = ((p)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((p)localObject1).label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240332);
        throw paramString;
        localObject1 = new p(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject2);
    paramd = bwJ();
    paramd.Hy(getString(c.g.odt));
    paramd.show();
    paramd = new ah.a();
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject2 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    ((p)localObject1).L$0 = this;
    ((p)localObject1).Uf = paramd;
    ((p)localObject1).label = 1;
    localObject2 = ((com.tencent.mm.mj_template.maas.c.a)localObject2).d(paramString, (kotlin.d.d)localObject1);
    if (localObject2 == locala)
    {
      AppMethodBeat.o(240332);
      return locala;
      paramd = (ah.a)((p)localObject1).Uf;
      paramString = (a)((p)localObject1).L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    for (;;)
    {
      localObject2 = (kotlinx.coroutines.b.g)localObject2;
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "unexpected null");
          paramString.bwJ().dismiss();
          aa.dc((Context)paramString.getContext(), paramString.getString(c.g.oda));
        }
        boolean bool = paramd.aiwY;
        AppMethodBeat.o(240332);
        return Boolean.valueOf(bool);
        localObject2 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject2, (kotlin.g.a.q)new q(paramString, null));
        if (localObject2 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = o.d((kotlinx.coroutines.b.g)localObject2, (kotlin.g.a.q)new r(paramd, paramString, null));
          if (localObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new o(paramString);
            ((p)localObject1).L$0 = paramString;
            ((p)localObject1).Uf = paramd;
            ((p)localObject1).label = 2;
            if (((kotlinx.coroutines.b.g)localObject2).a(localh, (kotlin.d.d)localObject1) == locala)
            {
              AppMethodBeat.o(240332);
              return locala;
              paramd = (ah.a)((p)localObject1).Uf;
              paramString = (a)((p)localObject1).L$0;
              ResultKt.throwOnFailure(localObject2);
            }
            localObject1 = kotlin.ah.aiuX;
          }
        }
      }
      paramString = this;
    }
  }
  
  private final void uG(int paramInt)
  {
    AppMethodBeat.i(240346);
    if (!this.ofC)
    {
      com.tencent.mm.mj_template.maas.b.c localc = com.tencent.mm.mj_template.maas.b.c.obu;
      com.tencent.mm.mj_template.maas.b.c.rG(paramInt);
      this.ofC = true;
    }
    AppMethodBeat.o(240346);
  }
  
  public final void Hz(String paramString)
  {
    AppMethodBeat.i(240600);
    s.u(paramString, "msg");
    Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", s.X("onSdkError:", paramString));
    bwJ().dismiss();
    aa.dc((Context)getContext(), getContext().getString(c.g.ocX));
    getContext().finish();
    AppMethodBeat.o(240600);
  }
  
  public final void a(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(240591);
    s.u(paramSurfaceView, "previewView");
    b(paramSurfaceView);
    paramSurfaceView.setVisibility(4);
    AppMethodBeat.o(240591);
  }
  
  public final void br(float paramFloat)
  {
    AppMethodBeat.i(240561);
    com.tencent.mm.mj_template.album_template.f localf = bwJ();
    String str = getResources().getString(c.g.odp, new Object[] { Integer.valueOf(kotlin.h.a.eH(100.0F * paramFloat)) });
    s.s(str, "resources.getString(\n   …oundToInt()\n            )");
    localf.Hy(str);
    AppMethodBeat.o(240561);
  }
  
  protected final com.tencent.mm.mj_template.album_template.f bwJ()
  {
    AppMethodBeat.i(240537);
    com.tencent.mm.mj_template.album_template.f localf = (com.tencent.mm.mj_template.album_template.f)this.nWe.getValue();
    AppMethodBeat.o(240537);
    return localf;
  }
  
  public final void bwM()
  {
    AppMethodBeat.i(240552);
    Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "onPreview");
    bwJ().dismiss();
    Object localObject1 = byF();
    if (localObject1 != null) {
      ((SurfaceView)localObject1).setVisibility(0);
    }
    this.ofA.setValue(Boolean.TRUE);
    Object localObject2 = byG().byD();
    localObject1 = com.tencent.mm.plugin.comm.b.e.xfd;
    e.a.a("SnsTemplate", "egdetail", "egids", localObject2, com.tencent.mm.plugin.comm.b.c.xeT, ";");
    com.tencent.mm.plugin.comm.b.e.xfd.a("SnsTemplate", "egpreviewcnt", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
    localObject1 = com.tencent.mm.plugin.comm.b.e.xfd;
    e.a.a("SnsTemplate", "editdetail", "td", Integer.valueOf(this.ofD), null, true, "egtd", 16);
    localObject1 = com.tencent.mm.plugin.comm.b.e.xfd;
    e.a.a("SnsTemplate", "editdetail", "egid", localObject2, null, false, null, 112);
    Iterator localIterator = ((Iterable)byG().byC()).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (s.p(((com.tencent.mm.mj_template.sns.a.a.e)localObject1).hIQ, localObject2))
      {
        localObject1 = (com.tencent.mm.mj_template.sns.a.a.e)localObject1;
        if (localObject1 != null) {
          break label337;
        }
        localObject1 = null;
        label212:
        localObject2 = com.tencent.mm.plugin.comm.b.e.xfd;
        if (localObject1 != null) {
          break label357;
        }
      }
    }
    label337:
    label357:
    for (int i = 0;; i = ((Integer)localObject1).intValue())
    {
      e.a.a("SnsTemplate", "editdetail", "eglocation", Integer.valueOf(i), null, false, null, 112);
      localObject1 = com.tencent.mm.plugin.comm.b.e.xfd;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      e.a.a("SnsTemplate", "editdetail", "vediotime", Long.valueOf(((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byi()), null, false, null, 112);
      localObject1 = com.tencent.mm.plugin.comm.b.e.xfd;
      localObject2 = com.tencent.mm.mj_template.maas.b.a.obp;
      ((e.a)localObject1).f("SnsPublishProcess", "Maaskey", com.tencent.mm.mj_template.maas.b.a.bxG());
      this.ofH = System.currentTimeMillis();
      AppMethodBeat.o(240552);
      return;
      localObject1 = null;
      break;
      localObject1 = Integer.valueOf(byG().byC().indexOf(localObject1));
      break label212;
    }
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(240651);
    super.onBeforeFinish(paramIntent);
    uG(1);
    AppMethodBeat.o(240651);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(240630);
    super.onCreate(paramBundle);
    bwJ().show();
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    ((ComposeView)this.ofv.getValue()).setContent((m)androidx.compose.runtime.c.c.a(-985549217, true, new j(this, paramBundle)));
    if (this.ofx)
    {
      paramBundle = com.tencent.mm.mj_template.b.b.ofM;
      com.tencent.mm.mj_template.b.b.O(3, "cache_key_sns");
    }
    com.tencent.mm.plugin.comm.b.e.xfd.f("SnsTemplate", "moreAction", Integer.valueOf(2));
    AppMethodBeat.o(240630);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(240619);
    Object localObject1 = getIntent().getParcelableArrayListExtra("Template_Media_List");
    if (localObject1 != null)
    {
      Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", s.X("media size :", Integer.valueOf(((ArrayList)localObject1).size())));
      localObject2 = (Iterable)localObject1;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = (GalleryItem.MediaItem)localObject3;
        Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "index:" + i + " path:" + ((GalleryItem.MediaItem)localObject3).Gcc);
        i += 1;
      }
      this.ofu.addAll((Collection)localObject1);
    }
    Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", s.X("showSpringStrategy:", Boolean.valueOf(this.ofx)));
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    Object localObject2 = com.tencent.mm.plugin.comm.b.e.xfd;
    this.ofD = e.a.a("SnsTemplate", "mediadetail", "data", "", null, true, null, 80);
    kotlinx.coroutines.j.a(getLifecycleScope(), null, null, (m)new m(this, null), 3);
    ((com.tencent.mm.mj_template.maas.c.a)localObject1).setMediaList((List)this.ofu);
    ((com.tencent.mm.mj_template.maas.c.a)localObject1).byc();
    ((com.tencent.mm.mj_template.maas.c.a)localObject1).a((com.tencent.mm.mj_template.maas.c.a.a)com.tencent.mm.mj_template.sns.a.odN);
    ((com.tencent.mm.mj_template.maas.c.a)localObject1).a((com.tencent.mm.mj_template.maas.c.a.d)this);
    localObject2 = com.tencent.mm.mj_template.sns.a.odN;
    int i = com.tencent.mm.mj_template.sns.a.byw();
    localObject2 = com.tencent.mm.mj_template.plugin.d.odz;
    localObject2 = com.tencent.mm.mj_template.plugin.d.bZd();
    Object localObject3 = com.tencent.mm.mj_template.sns.a.odN;
    ((com.tencent.mm.mj_template.maas.c.a)localObject1).a(new com.tencent.mm.mj_template.maas.c.a.c("MomentsTemplateRecommendv2", false, true, i, true, (List)localObject2, com.tencent.mm.mj_template.sns.a.byw()));
    if (this.ofx)
    {
      Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "set homepage template from wechat backend");
      paramBundle.gO(false);
      kotlinx.coroutines.j.a(getMainScope(), null, null, (m)new n(this, null), 3);
      AppMethodBeat.o(240619);
      return;
    }
    Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "set homepage template from maas");
    paramBundle.gO(true);
    paramBundle = getContext();
    if ((paramBundle instanceof androidx.lifecycle.q)) {}
    for (paramBundle = (androidx.lifecycle.q)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null)
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byg().a(paramBundle, new a..ExternalSyntheticLambda0(byG()));
      }
      AppMethodBeat.o(240619);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(240674);
    super.onDestroy();
    b(null);
    Object localObject = e.e.oeR;
    e.e.byB().clear();
    uG(5);
    e.a locala = com.tencent.mm.plugin.comm.b.e.xfd;
    localObject = getActivity();
    if ((localObject instanceof MMActivity))
    {
      localObject = (MMActivity)localObject;
      if (localObject != null) {
        break label88;
      }
    }
    label88:
    for (long l = 0L;; l = ((MMActivity)localObject).getActivityBrowseTimeMs())
    {
      locala.a("SnsPublishProcess", "egEditTime", Long.valueOf(l), com.tencent.mm.plugin.comm.b.c.xeT);
      AppMethodBeat.o(240674);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(240667);
    super.onPause();
    e.a locala = com.tencent.mm.plugin.comm.b.e.xfd;
    e.a.a("SnsTemplate", "editdetail", "egpreviewtime", Long.valueOf(System.currentTimeMillis() - this.ofH), com.tencent.mm.plugin.comm.b.c.xeT, false, null, 96);
    AppMethodBeat.o(240667);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(240661);
    super.onResume();
    this.ofH = System.currentTimeMillis();
    AppMethodBeat.o(240661);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(240642);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      int i = bf.bk((Context)getActivity());
      this.ofG.setValue(Integer.valueOf(i));
    }
    AppMethodBeat.o(240642);
  }
  
  public final Object w(kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(240584);
    d locald;
    if ((paramd instanceof d))
    {
      locald = (d)paramd;
      if ((locald.label & 0x80000000) != 0) {
        locald.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      paramd = locald.result;
      locala = kotlin.d.a.a.aiwj;
      switch (locald.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240584);
        throw paramd;
        locald = new d(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    paramd = com.tencent.mm.ui.component.k.aeZF;
    Object localObject3 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    Object localObject4 = new ah.f();
    Object localObject5 = (ffv)this.ofw.getValue();
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    paramd = this;
    if (localObject5 != null)
    {
      Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "cut same mode " + ((ffv)localObject5).nSg + ' ' + ((ffv)localObject5).musicId);
      paramd = com.tencent.mm.mj_template.b.b.ofM;
      localObject1 = ((ffv)localObject5).nSg;
      s.s(localObject1, "it.templateId");
      locald.L$0 = this;
      locald.Uf = localObject3;
      locald.VC = localObject4;
      locald.VD = localObject5;
      locald.label = 1;
      paramd = paramd.b((String)localObject1, 4, locald);
      if (paramd != locala) {
        break label1286;
      }
      AppMethodBeat.o(240584);
      return locala;
      localObject4 = (ffv)locald.VD;
      localObject3 = (ah.f)locald.VC;
      localObject2 = (com.tencent.mm.mj_template.maas.c.a)locald.Uf;
      localObject1 = (a)locald.L$0;
      ResultKt.throwOnFailure(paramd);
    }
    for (;;)
    {
      paramd = (fxr)paramd;
      if (paramd == null) {}
      for (paramd = null;; paramd = kotlin.ah.aiuX)
      {
        if (paramd == null)
        {
          Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "get template info error");
          aa.dc((Context)((a)localObject1).getContext(), ((a)localObject1).getString(c.g.ocY));
          ((a)localObject1).getContext().finish();
        }
        paramd = ((ffv)localObject4).nSg;
        s.s(paramd, "it.templateId");
        ((com.tencent.mm.mj_template.maas.c.a)localObject2).aR(paramd, ((ffv)localObject4).musicId);
        localObject4 = localObject2;
        paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "main entry mode");
        localObject3 = com.tencent.mm.mj_template.plugin.d.odz;
        locald.L$0 = paramd;
        locald.Uf = localObject1;
        locald.VC = localObject2;
        locald.VD = null;
        locald.label = 2;
        localObject3 = ((com.tencent.mm.mj_template.plugin.d)localObject3).L(locald);
        if (localObject3 != locala) {
          break;
        }
        AppMethodBeat.o(240584);
        return locala;
        ((ah.f)localObject3).aqH = paramd;
      }
      localObject1 = (ah.f)locald.VC;
      localObject4 = (com.tencent.mm.mj_template.maas.c.a)locald.Uf;
      localObject3 = (a)locald.L$0;
      ResultKt.throwOnFailure(paramd);
      localObject2 = paramd;
      paramd = (kotlin.d.d<? super kotlin.ah>)localObject3;
      localObject3 = localObject2;
      localObject2 = localObject4;
      for (;;)
      {
        localObject3 = (List)localObject3;
        if (paramd.ofy)
        {
          locald.L$0 = paramd;
          locald.Uf = localObject1;
          locald.VC = localObject3;
          locald.label = 3;
          localObject4 = ((com.tencent.mm.mj_template.maas.c.a)localObject2).a((List)localObject3, locald);
          if (localObject4 != locala) {
            break label1265;
          }
          AppMethodBeat.o(240584);
          return locala;
          localObject2 = (List)locald.VC;
          localObject1 = (ah.f)locald.Uf;
          localObject4 = (a)locald.L$0;
          ResultKt.throwOnFailure(paramd);
          localObject3 = paramd;
          paramd = (kotlin.d.d<? super kotlin.ah>)localObject4;
        }
        for (;;)
        {
          localObject3 = (List)localObject3;
          Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "default list filter before: " + ((List)localObject2).size() + " after: " + ((List)localObject3).size());
          paramd.ofd.addAll((Collection)localObject3);
          for (;;)
          {
            localObject3 = ((Iterable)paramd.ofd).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (fxr)((Iterator)localObject3).next();
              localObject5 = com.tencent.mm.mj_template.b.b.ofM;
              com.tencent.mm.mj_template.b.b.b((fxr)localObject4);
            }
            paramd.ofd.addAll((Collection)localObject3);
            localObject2 = localObject3;
          }
          localObject3 = (fxr)((ah.f)localObject1).aqH;
          if (localObject3 != null) {
            paramd.ofd.add(localObject3);
          }
          if (paramd.ofd.isEmpty())
          {
            if (paramd.ofy)
            {
              locald.L$0 = paramd;
              locald.Uf = localObject1;
              locald.VC = null;
              locald.label = 4;
              localObject3 = paramd.M(locald);
              localObject2 = localObject3;
              if (localObject3 == locala)
              {
                AppMethodBeat.o(240584);
                return locala;
                localObject1 = (ah.f)locald.Uf;
                localObject3 = (a)locald.L$0;
                ResultKt.throwOnFailure(paramd);
                localObject2 = paramd;
                paramd = (kotlin.d.d<? super kotlin.ah>)localObject3;
              }
              localObject2 = (List)localObject2;
              if (localObject2 == null) {
                localObject2 = null;
              }
              for (;;)
              {
                localObject3 = paramd;
                if (localObject2 != null) {
                  break;
                }
                Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "no res to creation");
                paramd.bwJ().dismiss();
                aa.dc((Context)paramd.getContext(), paramd.getString(c.g.ocY));
                paramd.getContext().finish();
                paramd = kotlin.ah.aiuX;
                AppMethodBeat.o(240584);
                return paramd;
                localObject2 = (e.e)kotlin.a.p.oL((List)localObject2);
                if (localObject2 == null)
                {
                  localObject2 = null;
                }
                else
                {
                  Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", s.X("start creation preview with ", ((com.tencent.mm.mj_template.sns.a.a.e)localObject2).hIQ));
                  localObject3 = com.tencent.mm.ui.component.k.aeZF;
                  ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)paramd.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).aR(((com.tencent.mm.mj_template.sns.a.a.e)localObject2).hIQ, "");
                  localObject2 = kotlin.ah.aiuX;
                }
              }
            }
            Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "defaultTemplateList is empty");
            localObject3 = paramd;
            paramd = ((a)localObject3).byG();
            paramd.byE();
            if (((ah.f)localObject1).aqH == null) {
              break label1233;
            }
            localObject1 = (fxr)((ah.f)localObject1).aqH;
            if (localObject1 != null)
            {
              localObject1 = ((fxr)localObject1).id;
              if (localObject1 != null) {
                paramd.HP((String)localObject1);
              }
            }
          }
          for (;;)
          {
            paramd = kotlin.ah.aiuX;
            AppMethodBeat.o(240584);
            return paramd;
            if (((ah.f)localObject1).aqH == null)
            {
              Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "start form main entry");
              localObject3 = com.tencent.mm.ui.component.k.aeZF;
              localObject3 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)paramd.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
              localObject2 = ((fxr)((List)localObject2).get(0)).id;
              s.s(localObject2, "defaultList[0].id");
              ((com.tencent.mm.mj_template.maas.c.a)localObject3).aR((String)localObject2, "");
              localObject3 = paramd;
              break;
            }
            Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "start form cut same");
            localObject3 = paramd;
            break;
            label1233:
            localObject1 = (fxr)kotlin.a.p.oL(paramd.ofd);
            if (localObject1 != null)
            {
              localObject1 = ((fxr)localObject1).id;
              if (localObject1 != null) {
                paramd.HP((String)localObject1);
              }
            }
          }
          label1265:
          localObject2 = localObject3;
          localObject3 = localObject4;
        }
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
      label1286:
      localObject1 = localObject5;
      localObject2 = localObject4;
      localObject5 = localObject3;
      localObject4 = localObject1;
      localObject3 = localObject2;
      localObject2 = localObject5;
      localObject1 = this;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(a parama, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240191);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = a.a(this.ofI, (kotlin.d.d)this);
      AppMethodBeat.o(240191);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super List<? extends e.e>>, Object>
  {
    int label;
    
    c(a parama, List<? extends fxr> paramList, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240230);
      paramObject = (kotlin.d.d)new c(this.ofI, this.asm, paramd);
      AppMethodBeat.o(240230);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240218);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240218);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "show wecaht backend list");
        if (!a.i(this.ofI)) {
          break label259;
        }
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.ofI.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
        localObject1 = this.asm;
        localObject3 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = paramObject.a((List)localObject1, (kotlin.d.d)localObject3);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(240218);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (List)paramObject;
      Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "template list filter before: " + this.asm.size() + " after: " + paramObject.size());
      for (;;)
      {
        localObject1 = (Iterable)paramObject;
        paramObject = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (fxr)((Iterator)localObject1).next();
          localObject3 = e.e.oeR;
          paramObject.add(e.e.a.a((fxr)localObject2));
        }
        label259:
        paramObject = this.asm;
      }
      paramObject = (List)paramObject;
      a.e(this.ofI).bL(paramObject);
      AppMethodBeat.o(240218);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    d(a parama, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240188);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofI.w((kotlin.d.d)this);
      AppMethodBeat.o(240188);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/ComposeView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ComposeView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ffv>
  {
    f(a parama)
    {
      super();
    }
    
    private ffv byH()
    {
      AppMethodBeat.i(240197);
      byte[] arrayOfByte = this.ofI.getIntent().getByteArrayExtra("key_video_template_info");
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(240197);
        return null;
      }
      ffv localffv = new ffv();
      com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)localffv;
      try
      {
        locala.parseFrom(arrayOfByte);
        AppMethodBeat.o(240197);
        return localffv;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements m<Boolean, Boolean, kotlin.ah>
  {
    i(a parama, com.tencent.mm.mj_template.maas.c.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, kotlin.ah>
  {
    j(a parama, com.tencent.mm.mj_template.maas.c.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.mj_template.album_template.f>
  {
    k(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.mj_template.sns.a.a.b>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    m(a parama, kotlin.d.d<? super m> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240228);
      paramObject = (kotlin.d.d)new m(this.ofI, paramd);
      AppMethodBeat.o(240228);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240219);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240219);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new JSONArray();
      localObject1 = ((Iterable)a.h(this.ofI)).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (GalleryItem.MediaItem)((Iterator)localObject1).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("md5", com.tencent.mm.b.g.getMD5(((GalleryItem.MediaItem)localObject2).Gcc));
        localJSONObject.put("source", 2);
        if ((localObject2 instanceof GalleryItem.VideoMediaItem)) {}
        for (int i = ((GalleryItem.VideoMediaItem)localObject2).oTN;; i = 0)
        {
          localJSONObject.put("dur", i);
          localObject2 = kotlin.ah.aiuX;
          paramObject.put(localJSONObject);
          break;
        }
      }
      paramObject = paramObject.toString();
      s.s(paramObject, "JSONArray().also { array…             }.toString()");
      localObject1 = com.tencent.mm.plugin.comm.b.e.xfd;
      e.a.a("SnsTemplate", "mediadetail", "data", paramObject, null, false, null, 80);
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(240219);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    n(a parama, kotlin.d.d<? super n> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240217);
      paramObject = (kotlin.d.d)new n(this.ofI, paramd);
      AppMethodBeat.o(240217);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240212);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240212);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ofI;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (a.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(240212);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(240212);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements kotlinx.coroutines.b.h<Float>
  {
    public o(a parama) {}
    
    public final Object a(Float paramFloat, kotlin.d.d<? super kotlin.ah> paramd)
    {
      AppMethodBeat.i(240162);
      float f = ((Number)paramFloat).floatValue();
      paramFloat = this.ofI.bwJ();
      paramd = this.ofI.getResources().getString(c.g.odu, new Object[] { Integer.valueOf(kotlin.h.a.eH(f * 100.0F)) });
      s.s(paramd, "resources.getString(\n   …t()\n                    )");
      paramFloat.Hy(paramd);
      paramFloat = kotlin.ah.aiuX;
      AppMethodBeat.o(240162);
      return paramFloat;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    p(a parama, kotlin.d.d<? super p> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240156);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = a.a(this.ofI, null, (kotlin.d.d)this);
      AppMethodBeat.o(240156);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.d.b.a.k
    implements kotlin.g.a.q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    q(a parama, kotlin.d.d<? super q> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240166);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240166);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.printErrStackTrace("MicroMsg.SnsTemplate.TemplateControlUIC", (Throwable)this.L$0, "maas error", new Object[0]);
      this.ofI.bwJ().dismiss();
      aa.dc((Context)this.ofI.getContext(), this.ofI.getString(c.g.oda));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(240166);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.d.b.a.k
    implements kotlin.g.a.q<kotlinx.coroutines.b.h<? super Float>, Throwable, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    r(ah.a parama, a parama1, kotlin.d.d<? super r> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240184);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240184);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (Throwable)this.L$0;
      Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "change on completion");
      localObject = this.nWr;
      if (paramObject == null) {}
      for (boolean bool = true;; bool = false)
      {
        ((ah.a)localObject).aiwY = bool;
        paramString.bwJ().dismiss();
        a.a(paramString, System.currentTimeMillis());
        paramObject = com.tencent.mm.plugin.comm.b.e.xfd;
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        e.a.a("SnsTemplate", "editdetail", "vediotime", kotlin.d.b.a.b.BF(((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)paramString.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byi()), null, false, null, 112);
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(240184);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    s(a parama, kotlin.d.d<? super s> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240200);
      paramd = new s(this.ofI, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(240200);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240193);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240193);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (aq)this.L$0;
        paramObject = this.ofI.bwJ();
        paramObject.Hy(this.ofI.getString(c.g.odm));
        paramObject.show();
        a.HQ(a.g(this.ofI));
        localObject2 = a.g(this.ofI) + System.currentTimeMillis() + ".mp4";
        Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", s.X("performExport path:", localObject2));
        paramObject = (kotlin.g.a.a)new b(this.ofI);
        localObject3 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.ofI.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
        localObject4 = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.Uf = localObject2;
        this.VC = paramObject;
        this.label = 1;
        localObject3 = ((com.tencent.mm.mj_template.maas.c.a)localObject3).f((String)localObject2, (kotlin.d.d)localObject4);
        if (localObject3 == locala)
        {
          AppMethodBeat.o(240193);
          return locala;
        }
        break;
      case 1: 
        localObject3 = (kotlin.g.a.a)this.VC;
        localObject2 = (String)this.Uf;
        localObject4 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
      for (;;)
      {
        localObject3 = (kotlinx.coroutines.b.g)localObject3;
        if (localObject3 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "unexpected export null");
            paramObject.invoke();
          }
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(240193);
          return paramObject;
          localObject2 = o.d((kotlinx.coroutines.b.g)localObject3, (kotlin.g.a.q)new kotlin.d.b.a.k(this.ofI, (String)localObject2)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(240223);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(240223);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (Throwable)this.L$0;
              this.ofI.bwJ().dismiss();
              if (paramAnonymousObject == null)
              {
                com.tencent.mm.plugin.comm.b.e.xfd.f("SnsTemplate", "egendcnt", Integer.valueOf(1));
                a.a(this.ofI, 3);
                a.a(this.ofI, this.eWL);
                this.ofI.getContext().setResult(-1);
                this.ofI.getContext().finish();
                Log.i("MicroMsg.SnsTemplate.TemplateControlUIC", "export successful");
              }
              for (;;)
              {
                paramAnonymousObject = kotlin.ah.aiuX;
                AppMethodBeat.o(240223);
                return paramAnonymousObject;
                a.a(this.ofI, 4);
                Log.printErrStackTrace("MicroMsg.SnsTemplate.TemplateControlUIC", paramAnonymousObject, "maas error", new Object[0]);
              }
            }
          });
          if (localObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject2 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject2, (kotlin.g.a.q)new a.s.2(paramObject, null));
            if (localObject2 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject3 = (kotlinx.coroutines.b.h)new a(this.ofI);
              localObject4 = (kotlin.d.d)this;
              this.L$0 = localObject1;
              this.Uf = paramObject;
              this.VC = null;
              this.label = 2;
              if (((kotlinx.coroutines.b.g)localObject2).a((kotlinx.coroutines.b.h)localObject3, (kotlin.d.d)localObject4) == locala)
              {
                AppMethodBeat.o(240193);
                return locala;
                localObject1 = (kotlin.g.a.a)this.Uf;
                ResultKt.throwOnFailure(paramObject);
                paramObject = localObject1;
              }
              localObject1 = kotlin.ah.aiuX;
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Float>
    {
      public a(a parama) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(240215);
        float f = ((Number)paramFloat).floatValue();
        paramFloat = this.ofI.bwJ();
        paramd = this.ofI.getResources().getString(c.g.odn, new Object[] { Integer.valueOf(kotlin.h.a.eH(f * 100.0F)) });
        s.s(paramd, "resources.getString(\n   …t()\n                    )");
        paramFloat.Hy(paramd);
        paramFloat = kotlin.ah.aiuX;
        AppMethodBeat.o(240215);
        return paramFloat;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    t(a parama, String paramString, kotlin.d.d<? super t> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240183);
      paramd = new t(this.ofI, this.nWp, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(240183);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240179);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240179);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.ofI.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
        localObject2 = this.nWp;
        locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = ((com.tencent.mm.mj_template.maas.c.a)localObject1).e((String)localObject2, locald);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(240179);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject1 = (kotlinx.coroutines.b.g)localObject1;
        if (localObject1 == null) {
          paramObject = null;
        }
        for (;;)
        {
          if (paramObject == null)
          {
            paramObject = this.ofI;
            Log.e("MicroMsg.SnsTemplate.TemplateControlUIC", "recreateWithMusicID return null");
            paramObject.bwJ().dismiss();
            aa.dc((Context)paramObject.getContext(), paramObject.getString(c.g.ocZ));
          }
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(240179);
          return paramObject;
          localObject1 = o.d((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.ofI, null)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(240161);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(240161);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (Throwable)this.L$0;
              this.ofI.bwJ().dismiss();
              if (paramAnonymousObject != null) {
                aa.dc((Context)this.ofI.getContext(), this.ofI.getString(c.g.ocZ));
              }
              for (;;)
              {
                paramAnonymousObject = kotlin.ah.aiuX;
                AppMethodBeat.o(240161);
                return paramAnonymousObject;
                com.tencent.mm.plugin.comm.b.e.xfd.a("SnsTemplate", "musiccnt", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
                paramAnonymousObject = com.tencent.mm.plugin.comm.b.e.xfd;
                e.a.a("SnsTemplate", "editdetail", "musiccnt", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT, false, null, 96);
              }
            }
          });
          if (localObject1 == null)
          {
            paramObject = null;
          }
          else
          {
            localObject1 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.ofI, null)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(240163);
                kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(240163);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                Log.printErrStackTrace("MicroMsg.SnsTemplate.TemplateControlUIC", (Throwable)this.L$0, "maas error", new Object[0]);
                this.ofI.bwJ().dismiss();
                aa.dc((Context)this.ofI.getContext(), this.ofI.getString(c.g.ocZ));
                paramAnonymousObject = kotlin.ah.aiuX;
                AppMethodBeat.o(240163);
                return paramAnonymousObject;
              }
            });
            if (localObject1 == null)
            {
              paramObject = null;
            }
            else
            {
              localObject2 = (kotlinx.coroutines.b.h)new a(this.ofI);
              locald = (kotlin.d.d)this;
              this.L$0 = paramObject;
              this.label = 2;
              if (((kotlinx.coroutines.b.g)localObject1).a((kotlinx.coroutines.b.h)localObject2, locald) == locala)
              {
                AppMethodBeat.o(240179);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = kotlin.ah.aiuX;
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Float>
    {
      public a(a parama) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(240147);
        float f = ((Number)paramFloat).floatValue();
        paramFloat = this.ofI.bwJ();
        paramd = this.ofI.getResources().getString(c.g.ods, new Object[] { Integer.valueOf(kotlin.h.a.eH(f * 100.0F)) });
        s.s(paramd, "resources.getString(\n   …                        )");
        paramFloat.Hy(paramd);
        paramFloat = kotlin.ah.aiuX;
        AppMethodBeat.o(240147);
        return paramFloat;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.mj_template.sns.a.a.g>
  {
    u(a parama)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/mj_template/sns/uic/SnsTemplateControlUIC$templateListState$2$1$2", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState$IReporter;", "onTemplateExposed", "", "templateId", "", "onTemplateSelected", "templatePos", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements g.b
    {
      b(a parama) {}
      
      public final void HB(String paramString)
      {
        AppMethodBeat.i(240195);
        s.u(paramString, "templateId");
        com.tencent.mm.plugin.comm.b.e.xfd.a("SnsTemplate", "egviewcnt", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
        AppMethodBeat.o(240195);
      }
      
      public final void aI(String paramString, int paramInt)
      {
        AppMethodBeat.i(240189);
        s.u(paramString, "templateId");
        e.a locala = com.tencent.mm.plugin.comm.b.e.xfd;
        e.a.a("SnsTemplate", "egdetail", "egids", paramString, com.tencent.mm.plugin.comm.b.c.xeT, "#");
        com.tencent.mm.plugin.comm.b.e.xfd.a("SnsTemplate", "egpreviewcnt", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
        locala = com.tencent.mm.plugin.comm.b.e.xfd;
        e.a.a("SnsTemplate", "editdetail", "egpreviewtime", Long.valueOf(System.currentTimeMillis() - a.k(this.ofI)), com.tencent.mm.plugin.comm.b.c.xeT, false, null, 96);
        locala = com.tencent.mm.plugin.comm.b.e.xfd;
        e.a.a("SnsTemplate", "editdetail", "td", Integer.valueOf(a.l(this.ofI)), null, true, "egtd", 16);
        locala = com.tencent.mm.plugin.comm.b.e.xfd;
        e.a.a("SnsTemplate", "editdetail", "egid", paramString, null, false, null, 112);
        paramString = com.tencent.mm.plugin.comm.b.e.xfd;
        e.a.a("SnsTemplate", "editdetail", "eglocation", Integer.valueOf(paramInt), null, false, null, 112);
        AppMethodBeat.o(240189);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.b.a
 * JD-Core Version:    0.7.0.1
 */