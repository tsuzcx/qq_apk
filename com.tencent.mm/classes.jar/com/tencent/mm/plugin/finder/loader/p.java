package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.h;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderGradientBlurEffectProducer;", "Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"})
public final class p
  extends i
{
  public static final a ztD;
  
  static
  {
    AppMethodBeat.i(221621);
    ztD = new a((byte)0);
    AppMethodBeat.o(221621);
  }
  
  public final e<Bitmap> a(final com.tencent.mm.loader.e.b.g<?> paramg, f<?, Bitmap> paramf, final com.tencent.mm.loader.h.b.a parama)
  {
    AppMethodBeat.i(221619);
    kotlin.g.b.p.k(paramg, "targetView");
    kotlin.g.b.p.k(paramf, "reaper");
    kotlin.g.b.p.k(parama, "input");
    parama = super.a(paramg, paramf, parama);
    paramf = (Bitmap)parama.getValue();
    if ((paramf == null) || (paramf.getWidth() <= 0) || (paramf.getHeight() <= 0))
    {
      AppMethodBeat.o(221619);
      return parama;
    }
    parama = new aa.f();
    parama.aaBC = null;
    h.k((m)new b(paramf, paramg, parama, null));
    paramg = new e((Bitmap)parama.aaBC);
    AppMethodBeat.o(221619);
    return paramg;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderGradientBlurEffectProducer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    
    b(Bitmap paramBitmap, com.tencent.mm.loader.e.b.g paramg, aa.f paramf, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(267559);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new b(this.ztE, paramg, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(267559);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(267560);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(267560);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(267557);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(267557);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        final kotlinx.coroutines.a.g localg = kotlinx.coroutines.a.i.aFQ(0);
        localObject = new com.tencent.mm.videocomposition.effect.b();
        ((com.tencent.mm.videocomposition.effect.b)localObject).setInputBitmap(this.ztE);
        if (paramg.getViewWidth() <= 0) {}
        for (int i = this.ztE.getWidth();; i = paramg.getViewWidth())
        {
          ((com.tencent.mm.videocomposition.effect.b)localObject).no(i, kotlin.h.a.dm(i * 1.0F * this.ztE.getHeight() / this.ztE.getWidth()));
          ((com.tencent.mm.videocomposition.effect.d)localObject).YIS = ((kotlin.g.a.b)new a((com.tencent.mm.videocomposition.effect.b)localObject));
          ((com.tencent.mm.videocomposition.effect.d)localObject).ANo.ikd();
          ((com.tencent.mm.videocomposition.effect.b)localObject).ag((kotlin.g.a.b)new q(paramObject) {});
          localObject = parama;
          this.L$0 = paramObject;
          this.oDA = localg;
          this.pGq = localObject;
          this.label = 1;
          paramObject = localg.q(this);
          if (paramObject != locala) {
            break;
          }
          AppMethodBeat.o(267557);
          return locala;
        }
      }
      Object localObject = (aa.f)this.pGq;
      ResultKt.throwOnFailure(paramObject);
      for (;;)
      {
        ((aa.f)localObject).aaBC = ((Bitmap)paramObject);
        paramObject = x.aazN;
        AppMethodBeat.o(267557);
        return paramObject;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<Long, x>
    {
      a(com.tencent.mm.videocomposition.effect.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.p
 * JD-Core Version:    0.7.0.1
 */