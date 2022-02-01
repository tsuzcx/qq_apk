package com.tencent.mm.plugin.finder.record.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseScopePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.b;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/FinderEffectRenderPlugin;", "Lcom/tencent/mm/media/camera/render/BaseCustomRenderCallback;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;)V", "enableEffect", "", "isFirstFrame", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "setPluginLayout", "previewRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/CameraKitXEffectRender;", "getPreviewRenderer", "()Lcom/tencent/mm/plugin/recordvideo/render/CameraKitXEffectRender;", "previewRenderer$delegate", "Lkotlin/Lazy;", "glCreate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glRelease", "glRender", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "(Lcom/tencent/mm/media/globject/GLTextureObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnableEffect", "enable", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.media.camera.f.a
  implements v
{
  public static final a.a FiC;
  private final j FiD;
  private boolean eYU;
  private BaseScopePluginLayout oaR;
  public volatile boolean yoh;
  
  static
  {
    AppMethodBeat.i(337109);
    FiC = new a.a((byte)0);
    AppMethodBeat.o(337109);
  }
  
  public a(BaseScopePluginLayout paramBaseScopePluginLayout)
  {
    super((byte)0);
    AppMethodBeat.i(337074);
    this.oaR = paramBaseScopePluginLayout;
    this.FiD = kotlin.k.cm((kotlin.g.a.a)f.FiF);
    this.yoh = true;
    this.eYU = true;
    AppMethodBeat.o(337074);
  }
  
  private static final void a(a parama, XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(337095);
    s.u(parama, "this$0");
    s.u(paramXEffectConfig, "$it");
    parama.eLk().a(paramXEffectConfig);
    AppMethodBeat.o(337095);
  }
  
  private static final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(337090);
    s.u(parama, "this$0");
    parama = parama.eLk().muW;
    if (parama != null)
    {
      parama.Jm(paramBoolean);
      com.tencent.mm.plugin.xlabeffect.k.a(parama, paramBoolean);
      parama.Jl(paramBoolean);
      parama.Jn(paramBoolean);
    }
    AppMethodBeat.o(337090);
  }
  
  private final com.tencent.mm.plugin.recordvideo.e.a eLk()
  {
    AppMethodBeat.i(337083);
    com.tencent.mm.plugin.recordvideo.e.a locala = (com.tencent.mm.plugin.recordvideo.e.a)this.FiD.getValue();
    AppMethodBeat.o(337083);
    return locala;
  }
  
  public final Object a(com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    AppMethodBeat.i(337146);
    e locale;
    if ((paramd1 instanceof e))
    {
      locale = (e)paramd1;
      if ((locale.label & 0x80000000) != 0) {
        locale.label += -2147483648;
      }
    }
    Object localObject;
    kotlin.d.a.a locala1;
    for (;;)
    {
      localObject = locale.result;
      locala1 = kotlin.d.a.a.aiwj;
      switch (locale.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337146);
        throw paramd;
        locale = new e(this, paramd1);
      }
    }
    ResultKt.throwOnFailure(localObject);
    locale.L$0 = this;
    locale.Uf = paramd;
    locale.label = 1;
    a locala = this;
    paramd1 = paramd;
    if (super.a(paramd, locale) == locala1)
    {
      AppMethodBeat.o(337146);
      return locala1;
      paramd1 = (com.tencent.mm.media.g.d)locale.Uf;
      locala = (a)locale.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    if (!locala.yoh)
    {
      AppMethodBeat.o(337146);
      return paramd1;
    }
    if (locala.eYU)
    {
      locala.eYU = false;
      AppMethodBeat.o(337146);
      return paramd1;
    }
    paramd = locala.eLk();
    s.u(paramd1, "texture");
    paramd.NQW = paramd1;
    paramd.el(paramd1.width, paramd1.height);
    paramd.ek(paramd1.width, paramd1.height);
    locala.eLk().bgE();
    paramd = locala.eLk().bgF();
    if (paramd == null)
    {
      AppMethodBeat.o(337146);
      return paramd1;
    }
    AppMethodBeat.o(337146);
    return paramd;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(337166);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(337166);
  }
  
  public final boolean b(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(337159);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(337159);
      return false;
      if (paramBundle == null) {}
      for (boolean bool = false;; bool = paramBundle.getBoolean("PARAM_BEAUTIFY_ENABLE"))
      {
        com.tencent.mm.media.camera.f.a.a((com.tencent.mm.media.camera.f.a)this, new a..ExternalSyntheticLambda1(this, bool));
        break;
      }
      if (paramBundle != null)
      {
        paramc = (XEffectConfig)paramBundle.getParcelable("PARAM_BEAUTIFY_CONFIG");
        if (paramc != null) {
          com.tencent.mm.media.camera.f.a.a((com.tencent.mm.media.camera.f.a)this, new a..ExternalSyntheticLambda0(this, paramc));
        }
      }
    }
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(337191);
    s.u(this, "this");
    AppMethodBeat.o(337191);
  }
  
  public final String name()
  {
    AppMethodBeat.i(337176);
    String str = v.a.b(this);
    AppMethodBeat.o(337176);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337184);
    s.u(this, "this");
    AppMethodBeat.o(337184);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(337200);
    s.u(this, "this");
    AppMethodBeat.o(337200);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(337209);
    s.u(this, "this");
    AppMethodBeat.o(337209);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337219);
    s.u(this, "this");
    AppMethodBeat.o(337219);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(337227);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(337227);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337237);
    s.u(this, "this");
    AppMethodBeat.o(337237);
  }
  
  public final Object p(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(337134);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337134);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (super.p(paramd) == locala)
    {
      AppMethodBeat.o(337134);
      return locala;
      localObject1 = (a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    Log.i("MicroMsg.FinderEffectRenderPlugin", "glCreate");
    long l = System.currentTimeMillis();
    ((a)localObject1).eLk().gp(false);
    Log.i("MicroMsg.FinderEffectRenderPlugin", s.X("glCreate cost:", b.BF(System.currentTimeMillis() - l)));
    paramd = ah.aiuX;
    AppMethodBeat.o(337134);
    return paramd;
  }
  
  public final Object q(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(337150);
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337150);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (super.q(paramd) == locala)
    {
      AppMethodBeat.o(337150);
      return locala;
      localObject1 = (a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    Log.i("MicroMsg.FinderEffectRenderPlugin", "glRelease");
    ((a)localObject1).eLk().release(true);
    paramd = ah.aiuX;
    AppMethodBeat.o(337150);
    return paramd;
  }
  
  public final void release()
  {
    AppMethodBeat.i(337244);
    s.u(this, "this");
    AppMethodBeat.o(337244);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(337254);
    s.u(this, "this");
    AppMethodBeat.o(337254);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(337263);
    s.u(this, "this");
    AppMethodBeat.o(337263);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(a parama, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336974);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.FiE.p((kotlin.d.d)this);
      AppMethodBeat.o(336974);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(a parama, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336969);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.FiE.q((kotlin.d.d)this);
      AppMethodBeat.o(336969);
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
    
    e(a parama, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336971);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.FiE.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(336971);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/render/CameraKitXEffectRender;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.recordvideo.e.a>
  {
    public static final f FiF;
    
    static
    {
      AppMethodBeat.i(336968);
      FiF = new f();
      AppMethodBeat.o(336968);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.a
 * JD-Core Version:    0.7.0.1
 */