package androidx.compose.b.a;

import androidx.compose.foundation.b.a.a;
import androidx.compose.foundation.b.a.b;
import androidx.compose.foundation.b.a.c;
import androidx.compose.foundation.b.b;
import androidx.compose.foundation.b.c;
import androidx.compose.foundation.b.g.a;
import androidx.compose.foundation.b.g.b;
import androidx.compose.foundation.b.g.c;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/Ripple;", "Landroidx/compose/foundation/Indication;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "other", "", "hashCode", "", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  implements androidx.compose.foundation.k
{
  private final boolean ajS;
  private final bm<z> ajT;
  private final float radius;
  
  private e(boolean paramBoolean, float paramFloat, bm<z> parambm)
  {
    this.ajS = paramBoolean;
    this.radius = paramFloat;
    this.ajT = parambm;
  }
  
  public abstract l a(c paramc, boolean paramBoolean, float paramFloat, bm<z> parambm, bm<f> parambm1, androidx.compose.runtime.h paramh);
  
  public final androidx.compose.foundation.l a(c paramc, androidx.compose.runtime.h paramh)
  {
    s.u(paramc, "interactionSource");
    paramh.bx(-1524341367);
    Object localObject1 = (n)paramh.a((androidx.compose.runtime.p)o.nI());
    long l = ((z)this.ajT.getValue()).value;
    Object localObject2 = z.awK;
    int i;
    if (l != z.sw())
    {
      i = 1;
      if (i == 0) {
        break label182;
      }
      paramh.bx(-1524341137);
      paramh.od();
      l = ((z)this.ajT.getValue()).value;
    }
    for (;;)
    {
      localObject2 = bj.b(z.ad(l), paramh);
      localObject1 = bj.b(((n)localObject1).i(paramh), paramh);
      localObject1 = a(paramc, this.ajS, this.radius, (bm)localObject2, (bm)localObject1, paramh);
      aa.a(localObject1, paramc, (kotlin.g.a.m)new a(paramc, (l)localObject1, null), paramh);
      paramh.od();
      return (androidx.compose.foundation.l)localObject1;
      i = 0;
      break;
      label182:
      paramh.bx(-1524341088);
      l = ((n)localObject1).h(paramh);
      paramh.od();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    if (this.ajS != ((e)paramObject).ajS) {
      return false;
    }
    if (!androidx.compose.ui.n.g.G(this.radius, ((e)paramObject).radius)) {
      return false;
    }
    return s.p(this.ajT, ((e)paramObject).ajT);
  }
  
  public int hashCode()
  {
    return (e..ExternalSyntheticBackport0.m(this.ajS) * 31 + androidx.compose.ui.n.g.ah(this.radius)) * 31 + this.ajT.hashCode();
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(c paramc, l paraml, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(201760);
      paramd = new a(this.YX, this.akh, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(201760);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201757);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201757);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject = (aq)this.L$0;
        paramObject = this.YX.mr();
        localObject = (kotlinx.coroutines.b.h)new a(this.akh, (aq)localObject);
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a((kotlinx.coroutines.b.h)localObject, locald) == locala)
        {
          AppMethodBeat.o(201757);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(201757);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<b>
    {
      public a(l paraml, aq paramaq) {}
      
      public final Object a(b paramb, d<? super ah> paramd)
      {
        AppMethodBeat.i(201813);
        paramb = (b)paramb;
        if ((paramb instanceof g.b)) {
          this.aki.a((g.b)paramb, this.akj);
        }
        Object localObject;
        label152:
        b localb;
        do
        {
          for (;;)
          {
            paramb = ah.aiuX;
            AppMethodBeat.o(201813);
            return paramb;
            if ((paramb instanceof g.c))
            {
              this.aki.a(((g.c)paramb).abH);
            }
            else
            {
              if (!(paramb instanceof g.a)) {
                break;
              }
              this.aki.a(((g.a)paramb).abH);
            }
          }
          localObject = this.aki;
          paramd = this.akj;
          s.u(paramb, "interaction");
          s.u(paramd, "scope");
          localObject = ((l)localObject).akP;
          s.u(paramb, "interaction");
          s.u(paramd, "scope");
          if (!(paramb instanceof a.b)) {
            break;
          }
          ((p)localObject).akY.add(paramb);
          localb = (b)kotlin.a.p.oN(((p)localObject).akY);
        } while (s.p(((p)localObject).akZ, localb));
        float f;
        if (localb != null) {
          if ((paramb instanceof a.b))
          {
            f = ((f)((p)localObject).ajU.getValue()).akk;
            label207:
            j.a(paramd, null, null, (kotlin.g.a.m)new p.a((p)localObject, f, m.b(localb), null), 3);
          }
        }
        for (;;)
        {
          ((p)localObject).akZ = localb;
          break;
          if ((paramb instanceof a.c))
          {
            ((p)localObject).akY.remove(((a.c)paramb).abF);
            break label152;
          }
          if (!(paramb instanceof a.a)) {
            break;
          }
          ((p)localObject).akY.remove(((a.a)paramb).abF);
          break label152;
          f = 0.0F;
          break label207;
          j.a(paramd, null, null, (kotlin.g.a.m)new p.b((p)localObject, m.c(((p)localObject).akZ), null), 3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.e
 * JD-Core Version:    0.7.0.1
 */