package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderGradientBlurEffectProducer;", "Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends e
{
  public static final l.a Exv;
  
  static
  {
    AppMethodBeat.i(331741);
    Exv = new l.a((byte)0);
    AppMethodBeat.o(331741);
  }
  
  public final com.tencent.mm.loader.g.e<Bitmap> a(final g<?> paramg, final f<?, Bitmap> paramf, com.tencent.mm.loader.g.b.a parama)
  {
    AppMethodBeat.i(331748);
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parama, "input");
    parama = super.a(paramg, paramf, parama);
    paramf = (Bitmap)parama.value;
    if ((paramf == null) || (paramf.getWidth() <= 0) || (paramf.getHeight() <= 0))
    {
      AppMethodBeat.o(331748);
      return parama;
    }
    parama = new ah.f();
    kotlinx.coroutines.k.x((m)new b(parama, paramf, paramg, null));
    paramg = new com.tencent.mm.loader.g.e(parama.aqH);
    AppMethodBeat.o(331748);
    return paramg;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(ah.f<Bitmap> paramf, Bitmap paramBitmap, g<?> paramg, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(331786);
      paramd = new b(this.Exw, paramf, paramg, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(331786);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(331780);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(331780);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject1 = kotlinx.coroutines.a.k.a(0, null, 7);
        Object localObject3 = new com.tencent.mm.videocomposition.effect.b();
        Bitmap localBitmap = paramf;
        g localg = paramg;
        s.s(localBitmap, "originBitmap");
        ((com.tencent.mm.videocomposition.effect.b)localObject3).setInputBitmap(localBitmap);
        if (localg.width <= 0) {}
        for (int i = localBitmap.getWidth();; i = localg.width)
        {
          ((com.tencent.mm.videocomposition.effect.b)localObject3).pl(i, kotlin.h.a.eH(i * 1.0F * localBitmap.getHeight() / localBitmap.getWidth()));
          ((com.tencent.mm.videocomposition.effect.d)localObject3).agEA = ((kotlin.g.a.b)new a((com.tencent.mm.videocomposition.effect.b)localObject3));
          ((com.tencent.mm.videocomposition.effect.d)localObject3).GpO.jQk();
          ((com.tencent.mm.videocomposition.effect.b)localObject3).aX((kotlin.g.a.b)new l.b.1(paramObject, (h)localObject1, paramf));
          paramObject = this.Exw;
          localObject3 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          localObject1 = ((h)localObject1).aA((kotlin.d.d)localObject3);
          if (localObject1 != localObject2) {
            break;
          }
          AppMethodBeat.o(331780);
          return localObject2;
        }
      }
      localObject2 = (ah.f)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      Object localObject1 = paramObject;
      paramObject = localObject2;
      for (;;)
      {
        paramObject.aqH = localObject1;
        paramObject = ah.aiuX;
        AppMethodBeat.o(331780);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Long, ah>
    {
      a(com.tencent.mm.videocomposition.effect.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.l
 * JD-Core Version:    0.7.0.1
 */