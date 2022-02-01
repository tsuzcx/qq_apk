package com.tencent.mm.mj_template.album_template;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.ComposeView;
import com.tencent.maas.model.MJChannelEventConfig;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.maas.c.a.a;
import com.tencent.mm.mj_template.maas.c.a.b;
import com.tencent.mm.mj_template.maas.c.a.d;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.o;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/MaasBaseUILogicUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$UICallback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityFetchJob", "Lkotlinx/coroutines/Job;", "composeRootView", "Landroidx/compose/ui/platform/ComposeView;", "kotlin.jvm.PlatformType", "getComposeRootView", "()Landroidx/compose/ui/platform/ComposeView;", "composeRootView$delegate", "Lkotlin/Lazy;", "loadingDialog", "Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "loadingDialog$delegate", "musicState", "Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "getMusicState$plugin_mj_template_release", "()Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "setMusicState$plugin_mj_template_release", "(Lcom/tencent/mm/mj_template/album_template/widget/MusicState;)V", "previewContainer", "Landroid/widget/FrameLayout;", "getPreviewContainer", "()Landroid/widget/FrameLayout;", "previewContainer$delegate", "previewView", "Landroid/view/SurfaceView;", "reported", "", "getReported", "()Z", "setReported", "(Z)V", "templateListState", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;", "getTemplateListState$plugin_mj_template_release", "()Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;", "beforeInitMovieSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkDir", "path", "", "fetchEventInfo", "eventName", "finderNickName", "getExportTemplateIdAndMusicId", "Lkotlin/Pair;", "getMusicState", "iMaasSdkUIC", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC;", "(Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC;Landroidx/compose/runtime/Composer;I)Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "initView", "onBeforeFinish", "resultIntent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onPreview", "onPreviewProgress", "progress", "", "onPreviewViewCreated", "performExport", "performPost", "performSwitchMusic", "musicId", "report24946", "creationResult", "", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends UIComponent
  implements a.d
{
  public static final int Ue = 8;
  public static final c.a nWb = new c.a((byte)0);
  private final kotlin.j nWc = kotlin.k.cm((kotlin.g.a.a)new b(this));
  private final kotlin.j nWd = kotlin.k.cm((kotlin.g.a.a)new j(this));
  private final kotlin.j nWe = kotlin.k.cm((kotlin.g.a.a)new g(this));
  private com.tencent.mm.mj_template.album_template.a.g nWf;
  private cb nWg;
  private boolean nWh;
  public final com.tencent.mm.mj_template.album_template.multi_template.a.d nWi;
  private SurfaceView nkf;
  
  public c(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    paramAppCompatActivity = new com.tencent.mm.mj_template.album_template.multi_template.a.d(getMainScope());
    Object localObject = (kotlin.g.a.q)new k(this, paramAppCompatActivity, null);
    s.u(localObject, "<set-?>");
    paramAppCompatActivity.nXw = ((kotlin.g.a.q)localObject);
    localObject = ah.aiuX;
    this.nWi = paramAppCompatActivity;
  }
  
  protected final void Hv(final String paramString)
  {
    s.u(paramString, "musicId");
    Object localObject = this.nWf;
    if (localObject == null) {
      localObject = "";
    }
    while (s.p(paramString, localObject))
    {
      Log.i("MaasBaseUILogicUIC", "same music, no need to switch");
      return;
      localObject = ((com.tencent.mm.mj_template.album_template.a.g)localObject).nYW;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = (MJMusicInfo)((androidx.compose.runtime.bm)localObject).getValue();
        if (localObject == null)
        {
          localObject = "";
        }
        else
        {
          String str = ((MJMusicInfo)localObject).getMusicID();
          localObject = str;
          if (str == null) {
            localObject = "";
          }
        }
      }
    }
    localObject = bwJ();
    ((f)localObject).Hy(getString(com.tencent.mm.mj_template.plugin.c.g.odr));
    ((f)localObject).show();
    kotlinx.coroutines.j.a(getMainScope(), null, null, (m)new i(this, paramString, null), 3);
  }
  
  protected final void Hw(String paramString)
  {
    int i = 1;
    s.u(paramString, "path");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    localObject1 = (Context)getContext();
    Intent localIntent = new Intent();
    Object localObject2 = MultiMediaVideoChecker.ObB.aTG(paramString);
    long l;
    boolean bool;
    if (localObject2 == null)
    {
      l = 0L;
      if (l <= 60000L) {
        break label366;
      }
      bool = true;
      label59:
      localIntent.putExtras(getIntent());
      if (!localIntent.hasExtra("post_id"))
      {
        localObject2 = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localIntent.putExtra("post_id", com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
      }
      localIntent.putExtra("postType", 4);
      localIntent.putExtra("postMediaList", (Serializable)kotlin.a.p.al(new String[] { paramString }));
      localIntent.putExtra("postTypeList", (Serializable)kotlin.a.p.al(new Integer[] { Integer.valueOf(4) }));
      paramString = new byy();
      localObject2 = bwN();
      paramString.id = ((String)((r)localObject2).bsC);
      paramString.type = 1;
      paramString.aahW = 1001000;
      paramString.aahX = getIntent().getIntExtra("key_maas_entrance", 0);
      Object localObject3 = this.nWf;
      if (localObject3 == null) {
        break label372;
      }
      localObject3 = ((com.tencent.mm.mj_template.album_template.a.g)localObject3).nYY;
      if ((localObject3 == null) || (((Boolean)((androidx.compose.runtime.bm)localObject3).getValue()).booleanValue())) {
        break label372;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MaasBaseUILogicUIC", "performPost has music id");
        paramString.aahZ = ((String)((r)localObject2).bsD);
      }
      localObject2 = ah.aiuX;
      localIntent.putExtra("KEY_POST_VIDEO_TEMPLATE", paramString.toByteArray());
      localIntent.putExtra("isLongVideoPost", bool);
      paramString = com.tencent.mm.mj_template.maas.b.a.obp;
      localIntent.putExtra("edit_id", com.tencent.mm.mj_template.maas.b.a.bxG());
      paramString = ah.aiuX;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)localObject1, localIntent);
      return;
      l = ((MultiMediaVideoChecker.a)localObject2).duration;
      break;
      label366:
      bool = false;
      break label59;
      label372:
      i = 0;
    }
  }
  
  public final com.tencent.mm.mj_template.album_template.a.g a(final com.tencent.mm.mj_template.maas.c.a parama, androidx.compose.runtime.h paramh)
  {
    s.u(parama, "iMaasSdkUIC");
    paramh.bx(215960282);
    Object localObject = this.nWf;
    if (localObject == null)
    {
      paramh.bx(215960369);
      localObject = parama.bye();
      parama = new com.tencent.mm.mj_template.album_template.a.g(androidx.compose.runtime.d.a.a(((a.b)localObject).byk(), (List)ab.aivy, paramh), androidx.compose.runtime.d.a.a(((a.b)localObject).byl(), new MJMusicInfo("", "", "", MJTime.InvalidTime, new Object[0]), paramh), (kotlin.g.a.b)new d(), androidx.compose.runtime.d.a.a(((a.b)localObject).bym(), Boolean.FALSE, paramh), androidx.compose.runtime.d.a.a(((a.b)localObject).byn(), Boolean.FALSE, paramh), (kotlin.g.a.a)new e(parama), (m)new f(this, parama));
      this.nWf = parama;
      paramh.od();
    }
    for (;;)
    {
      paramh.od();
      return parama;
      paramh.bx(215960355);
      paramh.od();
      parama = (com.tencent.mm.mj_template.maas.c.a)localObject;
    }
  }
  
  public final void a(SurfaceView paramSurfaceView)
  {
    s.u(paramSurfaceView, "previewView");
    paramSurfaceView.setVisibility(4);
    this.nkf = paramSurfaceView;
    ((FrameLayout)this.nWd.getValue()).addView((View)paramSurfaceView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
  }
  
  public final void br(float paramFloat)
  {
    f localf = bwJ();
    String str = getResources().getString(com.tencent.mm.mj_template.plugin.c.g.odp, new Object[] { Integer.valueOf(kotlin.h.a.eH(100.0F * paramFloat)) });
    s.s(str, "resources.getString(\n   …oundToInt()\n            )");
    localf.Hy(str);
  }
  
  protected final ComposeView bwI()
  {
    return (ComposeView)this.nWc.getValue();
  }
  
  protected final f bwJ()
  {
    return (f)this.nWe.getValue();
  }
  
  public final com.tencent.mm.mj_template.album_template.a.g bwK()
  {
    return this.nWf;
  }
  
  protected final boolean bwL()
  {
    return this.nWh;
  }
  
  public final void bwM()
  {
    bwI().setVisibility(0);
    SurfaceView localSurfaceView = this.nkf;
    if (localSurfaceView != null) {
      localSurfaceView.setVisibility(0);
    }
    bwJ().dismiss();
  }
  
  protected abstract r<String, String> bwN();
  
  public final void bwO()
  {
    kotlinx.coroutines.j.a(getMainScope(), null, null, (m)new h(this, null), 3);
  }
  
  protected abstract void initView();
  
  public void onBeforeFinish(Intent paramIntent)
  {
    super.onBeforeFinish(paramIntent);
    uG(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    bwJ().show();
  }
  
  public void onCreateBefore(Bundle paramBundle)
  {
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    paramBundle.a((a.a)a.nVZ);
    paramBundle.a((a.d)this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.nkf = null;
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byd();
    uG(5);
  }
  
  protected final void uG(int paramInt)
  {
    if (!this.nWh)
    {
      com.tencent.mm.mj_template.maas.b.c localc = com.tencent.mm.mj_template.maas.b.c.obu;
      com.tencent.mm.mj_template.maas.b.c.rG(paramInt);
      this.nWh = true;
    }
  }
  
  public Object w(kotlin.d.d<? super ah> paramd)
  {
    return ah.aiuX;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/ComposeView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ComposeView>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<Boolean, Boolean, ah>
  {
    f(c paramc, com.tencent.mm.mj_template.maas.c.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<f>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    int label;
    
    h(c paramc, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240489);
      paramd = new h(this.nWj, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(240489);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240483);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240483);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject1 = this.nWj.bwJ();
        ((f)localObject1).Hy(this.nWj.getString(com.tencent.mm.mj_template.plugin.c.g.odm));
        ((f)localObject1).show();
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.nWj.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byh();
        if ((localObject3 != null) && (!this.nWj.getIntent().hasExtra("key_topic_id")))
        {
          localObject1 = this.nWj;
          localObject2 = ((MJChannelEventConfig)localObject3).getEventName();
          s.s(localObject2, "eventInfo.eventName");
          localObject3 = ((MJChannelEventConfig)localObject3).getFinderNickName();
          s.s(localObject3, "eventInfo.finderNickName");
          c.a((c)localObject1, (String)localObject2, (String)localObject3);
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.bm.GlZ;
        c.Hx(com.tencent.mm.plugin.finder.utils.bm.fik());
        localObject1 = new StringBuilder();
        localObject2 = com.tencent.mm.plugin.finder.utils.bm.GlZ;
        localObject2 = com.tencent.mm.plugin.finder.utils.bm.fik() + (String)this.nWj.bwN().bsC + '_' + System.currentTimeMillis() + ".mp4";
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.nWj.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
        localObject3 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject2;
        this.label = 1;
        localObject1 = ((com.tencent.mm.mj_template.maas.c.a)localObject1).f((String)localObject2, (kotlin.d.d)localObject3);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(240483);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (String)this.Uf;
        localObject3 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject3;
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
            paramObject = this.nWj;
            Log.e("MaasBaseUILogicUIC", "unexpected export null");
            paramObject.bwJ().dismiss();
            aa.dc((Context)paramObject.getContext(), paramObject.getString(com.tencent.mm.mj_template.plugin.c.g.odl));
            paramObject.uG(4);
            paramObject.getContext().setResult(0);
            paramObject.getContext().finish();
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(240483);
          return paramObject;
          localObject1 = o.d((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.nWj, (String)localObject2)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(240517);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              Throwable localThrowable;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(240517);
                throw paramAnonymousObject;
              case 0: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                localThrowable = (Throwable)this.L$0;
                cb localcb = c.a(this.nWj);
                paramAnonymousObject = localThrowable;
                if (localcb != null)
                {
                  kotlin.d.d locald = (kotlin.d.d)this;
                  this.L$0 = localThrowable;
                  this.label = 1;
                  paramAnonymousObject = localThrowable;
                  if (localcb.ay(locald) == locala)
                  {
                    AppMethodBeat.o(240517);
                    return locala;
                  }
                }
                break;
              case 1: 
                localThrowable = (Throwable)this.L$0;
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = localThrowable;
              }
              this.nWj.bwJ().dismiss();
              if (paramAnonymousObject == null)
              {
                this.nWj.uG(3);
                this.nWj.Hw(this.eWL);
                this.nWj.getContext().setResult(-1);
                this.nWj.getContext().finish();
                Log.i("MaasBaseUILogicUIC", "export successful");
              }
              for (;;)
              {
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(240517);
                return paramAnonymousObject;
                Log.printErrStackTrace("MaasBaseUILogicUIC", paramAnonymousObject, "maas error", new Object[0]);
                this.nWj.uG(4);
              }
            }
          });
          if (localObject1 == null)
          {
            paramObject = null;
          }
          else
          {
            localObject1 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.nWj, null)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(240629);
                kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(240629);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                Log.printErrStackTrace("MaasBaseUILogicUIC", (Throwable)this.L$0, "maas error", new Object[0]);
                this.nWj.bwJ().dismiss();
                aa.dc((Context)this.nWj.getContext(), this.nWj.getString(com.tencent.mm.mj_template.plugin.c.g.odl));
                this.nWj.uG(4);
                this.nWj.getContext().setResult(0);
                this.nWj.getContext().finish();
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(240629);
                return paramAnonymousObject;
              }
            });
            if (localObject1 == null)
            {
              paramObject = null;
            }
            else
            {
              localObject2 = (kotlinx.coroutines.b.h)new a(this.nWj);
              localObject3 = (kotlin.d.d)this;
              this.L$0 = paramObject;
              this.Uf = null;
              this.label = 2;
              if (((kotlinx.coroutines.b.g)localObject1).a((kotlinx.coroutines.b.h)localObject2, (kotlin.d.d)localObject3) == locala)
              {
                AppMethodBeat.o(240483);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = ah.aiuX;
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Float>
    {
      public a(c paramc) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(240477);
        float f = ((Number)paramFloat).floatValue();
        paramFloat = this.nWj.bwJ();
        paramd = this.nWj.getResources().getString(com.tencent.mm.mj_template.plugin.c.g.odn, new Object[] { Integer.valueOf(kotlin.h.a.eH(f * 100.0F)) });
        s.s(paramd, "resources.getString(\n   …t()\n                    )");
        paramFloat.Hy(paramd);
        paramFloat = ah.aiuX;
        AppMethodBeat.o(240477);
        return paramFloat;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(c paramc, String paramString, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240478);
      paramd = new i(this.nWj, paramString, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(240478);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240475);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240475);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.nWj.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
        localObject2 = paramString;
        locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = ((com.tencent.mm.mj_template.maas.c.a)localObject1).e((String)localObject2, locald);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(240475);
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
            paramObject = this.nWj;
            Log.e("MaasBaseUILogicUIC", "recreateWithMusicID return null");
            paramObject.bwJ().dismiss();
            aa.dc((Context)paramObject.getContext(), paramObject.getString(com.tencent.mm.mj_template.plugin.c.g.ocZ));
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(240475);
          return paramObject;
          localObject1 = o.d((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.nWj, null)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(240460);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(240460);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (Throwable)this.L$0;
              this.nWj.bwJ().dismiss();
              if (paramAnonymousObject != null) {
                aa.dc((Context)this.nWj.getContext(), this.nWj.getString(com.tencent.mm.mj_template.plugin.c.g.ocZ));
              }
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(240460);
              return paramAnonymousObject;
            }
          });
          if (localObject1 == null)
          {
            paramObject = null;
          }
          else
          {
            localObject1 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.nWj, null)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(240447);
                kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(240447);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                Log.printErrStackTrace("MaasBaseUILogicUIC", (Throwable)this.L$0, "maas error", new Object[0]);
                this.nWj.bwJ().dismiss();
                aa.dc((Context)this.nWj.getContext(), this.nWj.getString(com.tencent.mm.mj_template.plugin.c.g.odl));
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(240447);
                return paramAnonymousObject;
              }
            });
            if (localObject1 == null)
            {
              paramObject = null;
            }
            else
            {
              localObject2 = (kotlinx.coroutines.b.h)new a(this.nWj);
              locald = (kotlin.d.d)this;
              this.L$0 = paramObject;
              this.label = 2;
              if (((kotlinx.coroutines.b.g)localObject1).a((kotlinx.coroutines.b.h)localObject2, locald) == locala)
              {
                AppMethodBeat.o(240475);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = ah.aiuX;
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Float>
    {
      public a(c paramc) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(240433);
        float f = ((Number)paramFloat).floatValue();
        paramFloat = this.nWj.bwJ();
        paramd = this.nWj.getResources().getString(com.tencent.mm.mj_template.plugin.c.g.ods, new Object[] { Integer.valueOf(kotlin.h.a.eH(f * 100.0F)) });
        s.s(paramd, "resources.getString(\n   …                        )");
        paramFloat.Hy(paramd);
        paramFloat = ah.aiuX;
        AppMethodBeat.o(240433);
        return paramFloat;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "templateId", "", "isBlank"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.d.b.a.k
    implements kotlin.g.a.q<String, Boolean, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    
    k(c paramc, com.tencent.mm.mj_template.album_template.multi_template.a.d paramd, kotlin.d.d<? super k> paramd1)
    {
      super(paramd1);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240491);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      boolean bool;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240491);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (String)this.L$0;
        bool = this.YF;
        paramObject = this.nWj.bwJ();
        paramObject.Hy(this.nWj.getString(com.tencent.mm.mj_template.plugin.c.g.odt));
        paramObject.show();
        paramObject = new ah.a();
        if (bool)
        {
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          localObject1 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.nWj.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
          localObject2 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          localObject1 = ((com.tencent.mm.mj_template.maas.c.a)localObject1).H((kotlin.d.d)localObject2);
          if (localObject1 != locala) {
            break label503;
          }
          AppMethodBeat.o(240491);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (ah.a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      label424:
      label503:
      for (;;)
      {
        localObject1 = (kotlinx.coroutines.b.g)localObject1;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            localObject1 = this.nWj;
            Log.e("MaasBaseUILogicUIC", "unexpected null");
            ((c)localObject1).bwJ().dismiss();
            aa.dc((Context)((c)localObject1).getContext(), ((c)localObject1).getString(com.tencent.mm.mj_template.plugin.c.g.oda));
          }
          bool = paramObject.aiwY;
          AppMethodBeat.o(240491);
          return Boolean.valueOf(bool);
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.nWj.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
          locald = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 2;
          localObject2 = ((com.tencent.mm.mj_template.maas.c.a)localObject2).d((String)localObject1, locald);
          localObject1 = localObject2;
          if (localObject2 == locala)
          {
            AppMethodBeat.o(240491);
            return locala;
            localObject2 = (ah.a)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          localObject1 = (kotlinx.coroutines.b.g)localObject1;
          break;
          localObject1 = kotlinx.coroutines.b.p.e((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(this.nWj, null)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(240452);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(240452);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              Log.printErrStackTrace("MaasBaseUILogicUIC", (Throwable)this.L$0, "maas error", new Object[0]);
              this.nWj.bwJ().dismiss();
              aa.dc((Context)this.nWj.getContext(), this.nWj.getString(com.tencent.mm.mj_template.plugin.c.g.oda));
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(240452);
              return paramAnonymousObject;
            }
          });
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = o.d((kotlinx.coroutines.b.g)localObject1, (kotlin.g.a.q)new kotlin.d.b.a.k(paramObject, this.nWj)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(240453);
                Object localObject = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(240453);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = (Throwable)this.L$0;
                Log.i("MaasBaseUILogicUIC", "change on completion");
                localObject = this.nWr;
                if (paramAnonymousObject == null) {}
                for (boolean bool = true;; bool = false)
                {
                  ((ah.a)localObject).aiwY = bool;
                  this.nWj.bwJ().dismiss();
                  paramAnonymousObject = ah.aiuX;
                  AppMethodBeat.o(240453);
                  return paramAnonymousObject;
                }
              }
            });
            if (localObject1 != null) {
              break label424;
            }
            localObject1 = null;
          }
        }
        localObject2 = (kotlinx.coroutines.b.h)new a(this.nWj);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 3;
        if (((kotlinx.coroutines.b.g)localObject1).a((kotlinx.coroutines.b.h)localObject2, locald) == locala)
        {
          AppMethodBeat.o(240491);
          return locala;
          localObject1 = (ah.a)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        for (;;)
        {
          localObject1 = ah.aiuX;
          break;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Float>
    {
      public a(c paramc) {}
      
      public final Object a(Float paramFloat, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(240444);
        float f = ((Number)paramFloat).floatValue();
        paramFloat = this.nWj.bwJ();
        paramd = this.nWj.getResources().getString(com.tencent.mm.mj_template.plugin.c.g.odu, new Object[] { Integer.valueOf(kotlin.h.a.eH(f * 100.0F)) });
        s.s(paramd, "resources.getString(\n   …t()\n                    )");
        paramFloat.Hy(paramd);
        paramFloat = ah.aiuX;
        AppMethodBeat.o(240444);
        return paramFloat;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.c
 * JD-Core Version:    0.7.0.1
 */