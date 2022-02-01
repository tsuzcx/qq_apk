package com.tencent.mm.mj_template.album_template.single_template;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.ui.platform.ComposeView;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.album_template.a.g;
import com.tencent.mm.mj_template.api.MJTemplateSession;
import com.tencent.mm.mj_template.api.MaasAlbumTemplateRequestParams;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/single_template/MaasAlbumTemplateOverlayUIC;", "Lcom/tencent/mm/mj_template/album_template/MaasBaseUILogicUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mRequestParams", "Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;", "getMRequestParams", "()Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;", "mRequestParams$delegate", "Lkotlin/Lazy;", "beforeInitMovieSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExportTemplateIdAndMusicId", "Lkotlin/Pair;", "", "initView", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onSdkError", "msg", "onWindowFocusChanged", "hasFocus", "", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.mj_template.album_template.c
{
  public static final int Ue;
  public static final b.a nXH;
  private final j nWJ;
  
  static
  {
    AppMethodBeat.i(240528);
    nXH = new b.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(240528);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(240511);
    this.nWJ = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(240511);
  }
  
  private final MaasAlbumTemplateRequestParams bxa()
  {
    AppMethodBeat.i(240516);
    MaasAlbumTemplateRequestParams localMaasAlbumTemplateRequestParams = (MaasAlbumTemplateRequestParams)this.nWJ.getValue();
    AppMethodBeat.o(240516);
    return localMaasAlbumTemplateRequestParams;
  }
  
  public final void Hz(String paramString)
  {
    AppMethodBeat.i(240563);
    s.u(paramString, "msg");
    aa.makeText((Context)getContext(), (CharSequence)getContext().getString(c.g.ocX), 0).show();
    Log.e("MaasAlbumTemplateOverlayUIC", paramString);
    getContext().finish();
    AppMethodBeat.o(240563);
  }
  
  public final r<String, String> bwN()
  {
    AppMethodBeat.i(240556);
    String str2 = bxa().nZs.bxj().id;
    Object localObject = bwK();
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localObject = new r(str2, localObject);
      AppMethodBeat.o(240556);
      return localObject;
      localObject = ((g)localObject).nYW;
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
          String str1 = ((MJMusicInfo)localObject).getMusicID();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
        }
      }
    }
  }
  
  public final void initView()
  {
    AppMethodBeat.i(240548);
    ComposeView localComposeView = bwI();
    localComposeView.setPadding(0, bf.getStatusBarHeight(localComposeView.getContext()), 0, 0);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = localComposeView.getContext();
    s.s(localObject, "context");
    localComposeView.setContent((m)androidx.compose.runtime.c.c.a(-985532356, true, new c(this, (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)localObject).cq(com.tencent.mm.mj_template.maas.c.a.class))));
    AppMethodBeat.o(240548);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(240542);
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (com.tencent.mm.mj_template.maas.c.a)com.tencent.mm.ui.component.k.nq((Context)getContext()).cq(com.tencent.mm.mj_template.maas.c.a.class);
    paramBundle.setMediaList(bxa().nZr);
    String str = bxa().nZs.bxj().id;
    s.s(str, "mRequestParams.mjTemplateSession.templateInfo.id");
    paramBundle.aR(str, bxa().nZs.musicId);
    AppMethodBeat.o(240542);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(240553);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      bwI().setPadding(0, bf.getStatusBarHeight((Context)getContext()), 0, bf.bk((Context)getContext()));
    }
    AppMethodBeat.o(240553);
  }
  
  public final Object w(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(240534);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240534);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (super.w(paramd) == locala)
    {
      AppMethodBeat.o(240534);
      return locala;
      localObject2 = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject1 = localObject2;
    }
    Object localObject2 = com.tencent.mm.mj_template.b.b.ofM;
    localObject1 = ((b)localObject1).bxa().nZs.bxj().id;
    s.s(localObject1, "mRequestParams.mjTemplateSession.templateInfo.id");
    paramd.L$0 = null;
    paramd.label = 2;
    localObject1 = ((com.tencent.mm.mj_template.b.b)localObject2).b((String)localObject1, 2, paramd);
    paramd = (kotlin.d.d<? super ah>)localObject1;
    if (localObject1 == locala)
    {
      AppMethodBeat.o(240534);
      return locala;
      ResultKt.throwOnFailure(localObject1);
      paramd = (kotlin.d.d<? super ah>)localObject1;
    }
    if ((fxr)paramd != null) {
      Log.e("MaasAlbumTemplateOverlayUIC", "get template info error, can not start creation");
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(240534);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240501);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nXI.w((kotlin.d.d)this);
      AppMethodBeat.o(240501);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<h, Integer, ah>
  {
    c(b paramb, com.tencent.mm.mj_template.maas.c.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MaasAlbumTemplateRequestParams>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.single_template.b
 * JD-Core Version:    0.7.0.1
 */