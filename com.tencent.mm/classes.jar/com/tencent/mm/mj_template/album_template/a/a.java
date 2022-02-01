package com.tencent.mm.mj_template.album_template.a;

import android.graphics.Bitmap;
import androidx.compose.runtime.an;
import androidx.compose.runtime.az;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/widget/ImageLoaderPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "url", "", "(Ljava/lang/String;)V", "_dataReady", "Landroidx/compose/runtime/MutableState;", "", "<set-?>", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "dataReady", "getDataReady", "()Z", "dataReady$delegate", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "loadJob", "Lkotlinx/coroutines/Job;", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "applyAlpha", "applyColorFilter", "onAbandoned", "", "onForgotten", "onRemembered", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
  implements az
{
  public static final int Ue;
  public static final a.a nXN;
  private final an cmn;
  private final an cmt;
  private final an cmu;
  private final an<Boolean> nXO;
  private final an nXP;
  private cb nXQ;
  private final aq scope;
  private final String url;
  
  static
  {
    AppMethodBeat.i(240609);
    nXN = new a.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(240609);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(240586);
    this.url = paramString;
    this.cmu = bj.T(null);
    this.nXO = bj.T(Boolean.FALSE);
    this.nXP = this.nXO;
    this.cmt = bj.T(Float.valueOf(1.0F));
    this.cmn = bj.T(null);
    this.scope = ar.d(bg.kCi().plus((kotlin.d.f)cx.g(null)));
    AppMethodBeat.o(240586);
  }
  
  private final c MN()
  {
    AppMethodBeat.i(240589);
    c localc = (c)((bm)this.cmu).getValue();
    AppMethodBeat.o(240589);
    return localc;
  }
  
  private final void b(c paramc)
  {
    AppMethodBeat.i(240594);
    this.cmu.setValue(paramc);
    AppMethodBeat.o(240594);
  }
  
  public final boolean S(float paramFloat)
  {
    AppMethodBeat.i(240639);
    this.cmt.setValue(Float.valueOf(paramFloat));
    AppMethodBeat.o(240639);
    return true;
  }
  
  public final void b(androidx.compose.ui.e.b.e parame)
  {
    AppMethodBeat.i(240631);
    s.u(parame, "<this>");
    c localc = MN();
    if (localc != null) {
      localc.a(parame, parame.sf(), ((Number)((bm)this.cmt).getValue()).floatValue(), (aa)((bm)this.cmn).getValue());
    }
    AppMethodBeat.o(240631);
  }
  
  public final boolean bxc()
  {
    AppMethodBeat.i(240617);
    boolean bool = ((Boolean)((bm)this.nXP).getValue()).booleanValue();
    AppMethodBeat.o(240617);
    return bool;
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(240643);
    this.cmn.setValue(paramaa);
    AppMethodBeat.o(240643);
    return true;
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(240657);
    Log.i("MicroMsg.ImageLoaderPainter", s.X("onRemembered: ", this.url));
    Object localObject = this.nXQ;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    localObject = com.tencent.mm.mj_template.album_template.e.nWz;
    com.tencent.mm.loader.a.b localb = com.tencent.mm.mj_template.album_template.e.bwR().GC(this.url);
    localObject = (Bitmap)localb.bll();
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null) {
        this.nXQ = j.a(this.scope, null, null, (m)new b(localb, this, null), 3);
      }
      AppMethodBeat.o(240657);
      return;
      int i;
      if (!((Bitmap)localObject).isRecycled())
      {
        i = 1;
        label110:
        if (i == 0) {
          break label128;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          break label133;
        }
        localObject = null;
        break;
        i = 0;
        break label110;
        label128:
        localObject = null;
      }
      label133:
      b((c)new androidx.compose.ui.e.c.a(androidx.compose.ui.e.f.h((Bitmap)localObject)));
      this.nXO.setValue(Boolean.TRUE);
      Log.i("MicroMsg.ImageLoaderPainter", s.X("get img from cache ", this.url));
      localObject = ah.aiuX;
    }
  }
  
  public final void mK()
  {
    AppMethodBeat.i(240647);
    Log.i("MicroMsg.ImageLoaderPainter", s.X("onForgotten: ", this.url));
    cb localcb = this.nXQ;
    if (localcb != null) {
      localcb.a(null);
    }
    this.nXQ = null;
    ar.a(this.scope, null);
    AppMethodBeat.o(240647);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(240662);
    mK();
    AppMethodBeat.o(240662);
  }
  
  public final long uM()
  {
    AppMethodBeat.i(240623);
    Object localObject = MN();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = androidx.compose.ui.d.k.U(((c)localObject).uM()))
    {
      localObject = androidx.compose.ui.d.k.avA;
      l = androidx.compose.ui.d.k.sw();
      AppMethodBeat.o(240623);
      return l;
    }
    long l = ((androidx.compose.ui.d.k)localObject).avp;
    AppMethodBeat.o(240623);
    return l;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(com.tencent.mm.loader.a.b<String, Bitmap> paramb, a parama, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(240574);
      paramObject = (d)new b(this.nXR, jdField_this, paramd);
      AppMethodBeat.o(240574);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240571);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240571);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nXR;
        this.L$0 = paramObject;
        this.label = 1;
        h localh = new h(kotlin.d.a.b.au((d)this));
        paramObject.a((com.tencent.mm.loader.e.e)new a((d)localh));
        paramObject.blg();
        paramObject = localh.kli();
        if (paramObject == kotlin.d.a.a.aiwj) {
          s.u((d)this, "frame");
        }
        if (paramObject == localObject)
        {
          AppMethodBeat.o(240571);
          return localObject;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        paramObject = (Bitmap)paramObject;
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = ah.aiuX)
        {
          if (paramObject == null) {
            Log.w("MicroMsg.ImageLoaderPainter", "get from network error");
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(240571);
          return paramObject;
          localObject = jdField_this;
          a.a((a)localObject, (c)new androidx.compose.ui.e.c.a(androidx.compose.ui.e.f.h(paramObject)));
          a.a((a)localObject).setValue(Boolean.TRUE);
          Log.i("MicroMsg.ImageLoaderPainter", s.X("get img from network ", a.b((a)localObject)));
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a<T, R>
      implements com.tencent.mm.loader.e.e
    {
      a(d<? super Bitmap> paramd) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.a
 * JD-Core Version:    0.7.0.1
 */