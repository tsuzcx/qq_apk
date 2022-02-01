package androidx.compose.foundation.lazy;

import androidx.compose.a.a.ar;
import androidx.compose.a.a.h;
import androidx.compose.a.a.i;
import androidx.compose.a.a.j;
import androidx.compose.a.a.l;
import androidx.compose.foundation.a.p;
import androidx.compose.foundation.a.s;
import androidx.compose.foundation.a.s.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "doSmoothScrollToItem", "Landroidx/compose/foundation/lazy/LazyListState;", "index", "", "scrollOffset", "(Landroidx/compose/foundation/lazy/LazyListState;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class z
{
  private static final float afH;
  private static final float afI;
  
  static
  {
    AppMethodBeat.i(204305);
    afH = androidx.compose.ui.n.g.ai(2500.0F);
    afI = androidx.compose.ui.n.g.ai(1500.0F);
    AppMethodBeat.o(204305);
  }
  
  public static final Object a(aa paramaa, final int paramInt1, final int paramInt2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204293);
    final androidx.compose.a.a.g localg = (androidx.compose.a.a.g)h.a(0.0F, 0.0F, null, 7);
    paramaa = s.a.a((s)paramaa, (kotlin.g.a.m)new a(paramaa, paramInt1, localg, paramInt2, null), paramd);
    if (paramaa == a.aiwj)
    {
      AppMethodBeat.o(204293);
      return paramaa;
    }
    paramaa = ah.aiuX;
    AppMethodBeat.o(204293);
    return paramaa;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements kotlin.g.a.m<p, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    float aad;
    float aae;
    int aai;
    int label;
    
    a(aa paramaa, int paramInt1, androidx.compose.a.a.g<Float> paramg, int paramInt2, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204269);
      paramd = new a(this.afJ, paramInt1, localg, paramInt2, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204269);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(204267);
      a locala = a.aiwj;
      float f1;
      final float f2;
      Object localObject1;
      Object localObject5;
      Object localObject3;
      int i;
      label220:
      boolean bool1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204267);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (p)this.L$0;
        f1 = this.afJ.TD.w(z.mO());
        f2 = this.afJ.TD.w(z.mP());
        Object localObject2 = new ah.a();
        ((ah.a)localObject2).aiwY = true;
        localObject1 = new ah.c();
        try
        {
          localObject5 = z.a(this.afJ, paramInt1);
          if (localObject5 == null) {
            break label308;
          }
          localObject2 = new f((m)localObject5);
          AppMethodBeat.o(204267);
          throw ((Throwable)localObject2);
        }
        catch (f localf1) {}
        localObject1 = j.s(0.0F, ((ah.c)localObject1).aixa);
        f1 = localf1.aet.getOffset() + paramInt2;
        localObject3 = new ah.c();
        if (((Number)((i)localObject1).lH()).floatValue() == 0.0F)
        {
          i = 1;
          if (i != 0) {
            break label678;
          }
          bool1 = true;
          label228:
          paramObject = (b)new u(f1) {};
          localObject3 = (kotlin.d.d)this;
          this.L$0 = null;
          this.Uf = null;
          this.VC = null;
          this.VD = null;
          this.Ze = null;
          this.label = 2;
          if (ar.a((i)localObject1, Float.valueOf(f1), null, bool1, paramObject, (kotlin.d.d)localObject3, 2) != locala) {
            break label688;
          }
          AppMethodBeat.o(204267);
          return locala;
          label308:
          if (paramInt1 > this.afJ.afS.mM())
          {
            i = 1;
            break label739;
            label331:
            localObject5 = new ah.d();
            ((ah.d)localObject5).aixb = 1;
          }
        }
        break;
      }
      for (;;)
      {
        Object localObject6;
        Object localObject7;
        int j;
        label678:
        try
        {
          if (((ah.a)localObject3).aiwY)
          {
            localObject6 = j.s(0.0F, ((ah.c)localObject1).aixa);
            Object localObject8 = new ah.c();
            localObject7 = localg;
            if (((Number)((i)localObject6).lH()).floatValue() == 0.0F)
            {
              j = 1;
              break label747;
              if (i == 0) {
                continue;
              }
              bool2 = true;
              localObject8 = (b)new u(f1) {};
              kotlin.d.d locald = (kotlin.d.d)this;
              this.L$0 = paramObject;
              this.Uf = localObject3;
              this.VC = localObject1;
              this.VD = localObject5;
              this.Ze = localObject6;
              this.aad = f2;
              this.aai = i;
              this.aae = f1;
              this.label = 1;
              localObject7 = ar.a((i)localObject6, Float.valueOf(f1), (androidx.compose.a.a.g)localObject7, bool1, (b)localObject8, locald);
              if (localObject7 != locala) {
                break label736;
              }
              AppMethodBeat.o(204267);
              return locala;
              i = 0;
              break label739;
              f1 = -f1;
              break label331;
            }
            j = 0;
            break label747;
            bool1 = false;
            continue;
            final boolean bool2 = false;
            continue;
            f1 = this.aae;
            i = this.aai;
            f2 = this.aad;
            localObject7 = (i)this.Ze;
            localObject5 = (ah.d)this.VD;
            localObject1 = (ah.c)this.VC;
            localObject6 = (ah.a)this.Uf;
            localObject3 = (p)this.L$0;
          }
        }
        catch (f localf2) {}
        try
        {
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject3;
          localObject3 = localObject6;
          localObject6 = localObject7;
        }
        catch (f localf4)
        {
          paramObject = localf2;
          Object localObject4 = localf4;
        }
        try
        {
          ((ah.c)localObject1).aixa = ((Number)((i)localObject6).lH()).floatValue();
          ((ah.d)localObject5).aixb += 1;
        }
        catch (f localf3) {}
        i = 0;
        break label220;
        bool1 = false;
        break label228;
        ResultKt.throwOnFailure(paramObject);
        label688:
        this.afJ.F(paramInt1, paramInt2);
        paramObject = ah.aiuX;
        AppMethodBeat.o(204267);
        return paramObject;
        break;
        break;
        break;
        label736:
        continue;
        label739:
        if (i != 0)
        {
          break label331;
          label747:
          if (j == 0) {
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.z
 * JD-Core Version:    0.7.0.1
 */