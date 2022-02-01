package com.tencent.mm.mj_template.album_template.multi_template;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.LiveData;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.album_template.multi_template.a.b.e;
import com.tencent.mm.mj_template.api.MaasAlbumMultiTemplateRequestParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/MaasAlbumMultiTemplateOverlayUIC;", "Lcom/tencent/mm/mj_template/album_template/MaasBaseUILogicUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "backFromMMEditor", "", "iVideoGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "mRequestParams", "Lcom/tencent/mm/mj_template/api/MaasAlbumMultiTemplateRequestParams;", "getMRequestParams", "()Lcom/tencent/mm/mj_template/api/MaasAlbumMultiTemplateRequestParams;", "mRequestParams$delegate", "Lkotlin/Lazy;", "showSpringOfflineStrategy", "getShowSpringOfflineStrategy", "()Z", "showSpringOfflineStrategy$delegate", "getExportTemplateIdAndMusicId", "Lkotlin/Pair;", "", "initView", "", "launchMMEditorUI", "loadNoRecommendList", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onPreDestroyed", "onResume", "onSdkError", "msg", "onWindowFocusChanged", "hasFocus", "performNext", "setListReporter", "reporter", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState$IReporter;", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.mj_template.album_template.c
{
  public static final a.a nWF;
  private CaptureDataManager.b nWG;
  private boolean nWH;
  private final kotlin.j nWI;
  private final kotlin.j nWJ;
  
  static
  {
    AppMethodBeat.i(240748);
    nWF = new a.a((byte)0);
    AppMethodBeat.o(240748);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(240725);
    this.nWI = kotlin.k.cm((kotlin.g.a.a)e.nWL);
    this.nWJ = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(240725);
  }
  
  private static final void a(a parama, com.tencent.mm.mj_template.maas.g paramg)
  {
    AppMethodBeat.i(240737);
    s.u(parama, "this$0");
    Log.i("MaasMultiTemplate.MaasAlbumMultiTemplateOverlayUIC", s.X("initView: recommend ", paramg));
    if (paramg.oaK)
    {
      paramg = com.tencent.mm.mj_template.plugin.b.ocx;
      if (com.tencent.mm.mj_template.plugin.b.byp()) {
        parama.bwT();
      }
    }
    AppMethodBeat.o(240737);
  }
  
  private final void bwT()
  {
    AppMethodBeat.i(240729);
    kotlinx.coroutines.j.a(getLifecycleScope(), null, null, (m)new c(this, null), 3);
    AppMethodBeat.o(240729);
  }
  
  private final void bwU()
  {
    AppMethodBeat.i(240731);
    Log.i("MaasMultiTemplate.MaasAlbumMultiTemplateOverlayUIC", "launchMMEditorUI");
    this.nWH = true;
    CaptureDataManager.NHH.NHG = this.nWG;
    Intent localIntent = new Intent((Context)getContext(), Class.forName("com.tencent.mm.plugin.recordvideo.activity.MMRecordUI"));
    localIntent.putExtras(getContext().getIntent());
    com.tencent.mm.hellhoundlib.a.a.a(getContext(), com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/mj_template/album_template/multi_template/MaasAlbumMultiTemplateOverlayUIC", "launchMMEditorUI", "()V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(240731);
  }
  
  public final void Hz(String paramString)
  {
    AppMethodBeat.i(240805);
    s.u(paramString, "msg");
    Log.e("MaasMultiTemplate.MaasAlbumMultiTemplateOverlayUIC", s.X("onSdkError ", paramString));
    bwU();
    getContext().finish();
    AppMethodBeat.o(240805);
  }
  
  public final r<String, String> bwN()
  {
    AppMethodBeat.i(240811);
    Object localObject = this.nWi;
    String str1;
    if ((s.p(((com.tencent.mm.mj_template.album_template.multi_template.a.d)localObject).nXv, "@@mm_edit@@")) || (s.p(((com.tencent.mm.mj_template.album_template.multi_template.a.d)localObject).nXv, "@@maas_blank@@")))
    {
      str1 = "";
      localObject = bwK();
      if (localObject != null) {
        break label79;
      }
      localObject = "";
    }
    for (;;)
    {
      localObject = new r(str1, localObject);
      AppMethodBeat.o(240811);
      return localObject;
      str1 = ((com.tencent.mm.mj_template.album_template.multi_template.a.d)localObject).nXu;
      break;
      label79:
      localObject = ((com.tencent.mm.mj_template.album_template.a.g)localObject).nYW;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = (MJMusicInfo)((bm)localObject).getValue();
        if (localObject == null)
        {
          localObject = "";
        }
        else
        {
          String str2 = ((MJMusicInfo)localObject).getMusicID();
          localObject = str2;
          if (str2 == null) {
            localObject = "";
          }
        }
      }
    }
  }
  
  public final void initView()
  {
    AppMethodBeat.i(240768);
    Object localObject1 = getContext();
    Object localObject2;
    if ((localObject1 instanceof androidx.lifecycle.q))
    {
      localObject1 = (androidx.lifecycle.q)localObject1;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.mj_template.plugin.b.ocx;
        if (!com.tencent.mm.mj_template.plugin.b.byq()) {
          break label152;
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).gO(false);
        bwT();
      }
    }
    for (;;)
    {
      localObject1 = bwI();
      ((ComposeView)localObject1).setPadding(0, bf.getStatusBarHeight(((ComposeView)localObject1).getContext()), 0, 0);
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((ComposeView)localObject1).getContext();
      s.s(localObject2, "context");
      ((ComposeView)localObject1).setContent((m)androidx.compose.runtime.c.c.a(-985531230, true, new b(this, (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)localObject2).cq(com.tencent.mm.mj_template.maas.c.a.class))));
      AppMethodBeat.o(240768);
      return;
      localObject1 = null;
      break;
      label152:
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byg().a((androidx.lifecycle.q)localObject1, new a..ExternalSyntheticLambda0(this.nWi));
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class)).byf().a((androidx.lifecycle.q)localObject1, new a..ExternalSyntheticLambda1(this));
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(240758);
    this.nWG = CaptureDataManager.NHH.NHG;
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    MaasAlbumMultiTemplateRequestParams localMaasAlbumMultiTemplateRequestParams = (MaasAlbumMultiTemplateRequestParams)this.nWJ.getValue();
    if (localMaasAlbumMultiTemplateRequestParams != null) {
      paramBundle.setMediaList(localMaasAlbumMultiTemplateRequestParams.nZr);
    }
    AppMethodBeat.o(240758);
  }
  
  public final void onPreDestroyed()
  {
    AppMethodBeat.i(240795);
    super.onPreDestroyed();
    if ((!bwL()) && (this.nWH)) {
      uG(2);
    }
    AppMethodBeat.o(240795);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(240787);
    if (this.nWH)
    {
      com.tencent.mm.mj_template.maas.b.a locala = com.tencent.mm.mj_template.maas.b.a.obp;
      com.tencent.mm.mj_template.maas.b.a.uK(2);
    }
    super.onResume();
    AppMethodBeat.o(240787);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(240779);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      bwI().setPadding(0, bf.getStatusBarHeight((Context)getContext()), 0, bf.bk((Context)getContext()));
    }
    AppMethodBeat.o(240779);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    b(a parama, com.tencent.mm.mj_template.maas.c.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    c(a parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240652);
      paramObject = (kotlin.d.d)new c(this.nWK, paramd);
      AppMethodBeat.o(240652);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240646);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240646);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.mj_template.b.b.ofM;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = paramObject.a(0, "cache_key_finder_album", (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(240646);
          return localObject2;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (List)paramObject;
        localObject1 = paramObject;
        if (paramObject == null) {
          break label381;
        }
        if (!a.a(this.nWK)) {
          break label406;
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)this.nWK.getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
        localObject3 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 2;
        localObject1 = ((com.tencent.mm.mj_template.maas.c.a)localObject1).a(paramObject, (kotlin.d.d)localObject3);
        if (localObject1 != localObject2) {
          break label403;
        }
        AppMethodBeat.o(240646);
        return localObject2;
      }
      localObject2 = (List)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      Object localObject1 = paramObject;
      paramObject = localObject2;
      localObject1 = (List)localObject1;
      for (;;)
      {
        com.tencent.mm.mj_template.album_template.multi_template.a.d locald = this.nWK.nWi;
        localObject1 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (fxr)localIterator.next();
          String str = ((fxr)localObject3).id;
          s.s(str, "it.id");
          localObject1 = ((fxr)localObject3).abVq;
          if (localObject1 == null)
          {
            localObject1 = "";
            label297:
            localObject2 = ((fxr)localObject3).abVq;
            if (localObject2 != null) {
              break label349;
            }
            localObject2 = "";
          }
          for (;;)
          {
            localCollection.add(new b.e(str, (String)localObject1, (String)localObject2));
            break;
            localObject2 = ((aex)localObject1).ZmV;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label297;
            }
            localObject1 = "";
            break label297;
            label349:
            localObject3 = ((aex)localObject2).title;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
          }
        }
        locald.bL((List)localCollection);
        localObject1 = paramObject;
        label381:
        Log.i("MaasMultiTemplate.MaasAlbumMultiTemplateOverlayUIC", s.X("loadNoRecommendList: ", localObject1));
        paramObject = ah.aiuX;
        AppMethodBeat.o(240646);
        return paramObject;
        label403:
        break;
        label406:
        localObject2 = paramObject;
        localObject1 = paramObject;
        paramObject = localObject2;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/api/MaasAlbumMultiTemplateRequestParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MaasAlbumMultiTemplateRequestParams>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final e nWL;
    
    static
    {
      AppMethodBeat.i(240645);
      nWL = new e();
      AppMethodBeat.o(240645);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.a
 * JD-Core Version:    0.7.0.1
 */