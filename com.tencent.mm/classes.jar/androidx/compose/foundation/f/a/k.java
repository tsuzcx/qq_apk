package androidx.compose.foundation.f.a;

import androidx.compose.ui.d.e;
import androidx.compose.ui.g.c.i;
import androidx.compose.ui.g.c.y;
import androidx.compose.ui.g.c.y.a;
import androidx.compose.ui.platform.av;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Landroidx.compose.ui.g.c.i;>;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"ClicksSlop", "", "awaitMouseEventDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "finalPass", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionDetector", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  static final Object b(androidx.compose.ui.g.c.a parama, boolean paramBoolean, kotlin.d.d<? super i> paramd)
  {
    AppMethodBeat.i(203758);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super i>)localObject1;; paramd = new a(paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203758);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (paramBoolean) {}
    for (Object localObject1 = androidx.compose.ui.g.c.k.aLk;; localObject1 = androidx.compose.ui.g.c.k.aLj)
    {
      paramd.L$0 = parama;
      paramd.YF = paramBoolean;
      paramd.label = 1;
      localObject2 = parama.a((androidx.compose.ui.g.c.k)localObject1, paramd);
      localObject1 = localObject2;
      if (localObject2 != locala) {
        break;
      }
      AppMethodBeat.o(203758);
      return locala;
    }
    paramBoolean = paramd.YF;
    parama = (androidx.compose.ui.g.c.a)paramd.L$0;
    ResultKt.throwOnFailure(localObject1);
    localObject1 = (i)localObject1;
    Object localObject2 = ((i)localObject1).alK;
    int i = 0;
    int k = ((List)localObject2).size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      androidx.compose.ui.g.c.m localm = (androidx.compose.ui.g.c.m)((List)localObject2).get(i);
      i = localm.type;
      y.a locala1 = y.aLM;
      if ((y.C(i, y.wt())) && (androidx.compose.ui.g.c.j.a(localm)))
      {
        i = 1;
        if (i != 0) {
          break label302;
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label312;
        }
        AppMethodBeat.o(203758);
        return localObject1;
        i = 0;
        break;
        label302:
        if (j <= k) {
          break label314;
        }
      }
      label312:
      break;
      label314:
      i = j;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203732);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = k.b(null, false, (kotlin.d.d)this);
      AppMethodBeat.o(203732);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<androidx.compose.ui.g.c.u, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public b(boolean paramBoolean, b paramb, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(203738);
      paramd = new b(this.ahY, this.ahZ, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(203738);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203730);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203730);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (androidx.compose.ui.g.c.u)this.L$0;
        kotlin.g.a.m localm = (kotlin.g.a.m)new kotlin.d.b.a.j(this.ahY)
        {
          Object Uf;
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(203748);
            paramAnonymousd = new 1(this.ahY, this.ahZ, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            paramAnonymousObject = (kotlin.d.d)paramAnonymousd;
            AppMethodBeat.o(203748);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(203746);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            Object localObject5;
            Object localObject4;
            Object localObject3;
            int i;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(203746);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              localObject1 = (androidx.compose.ui.g.c.a)this.L$0;
              paramAnonymousObject = new a(((androidx.compose.ui.g.c.a)localObject1).getViewConfiguration());
              boolean bool = this.ahY;
              localObject2 = (kotlin.d.d)this;
              this.L$0 = localObject1;
              this.Uf = paramAnonymousObject;
              this.label = 1;
              localObject5 = k.b((androidx.compose.ui.g.c.a)localObject1, bool, (kotlin.d.d)localObject2);
              localObject4 = localObject5;
              localObject3 = paramAnonymousObject;
              localObject2 = localObject1;
              if (localObject5 == locala)
              {
                AppMethodBeat.o(203746);
                return locala;
              }
            case 1: 
              localObject3 = (a)this.Uf;
              localObject2 = (androidx.compose.ui.g.c.a)this.L$0;
              ResultKt.throwOnFailure(paramAnonymousObject);
              localObject4 = paramAnonymousObject;
              paramAnonymousObject = (i)localObject4;
              s.u(paramAnonymousObject, "event");
              localObject1 = ((a)localObject3).ahG;
              localObject4 = (androidx.compose.ui.g.c.m)paramAnonymousObject.alK.get(0);
              if (localObject1 != null)
              {
                s.u(localObject1, "prevClick");
                s.u(localObject4, "newClick");
                if (((androidx.compose.ui.g.c.m)localObject4).aLm - ((androidx.compose.ui.g.c.m)localObject1).aLm < ((a)localObject3).ahE.yR())
                {
                  i = 1;
                  if (i == 0) {
                    break label488;
                  }
                  s.u(localObject1, "prevClick");
                  s.u(localObject4, "newClick");
                  if (e.M(e.f(((androidx.compose.ui.g.c.m)localObject4).position, ((androidx.compose.ui.g.c.m)localObject1).position)) >= 100.0D) {
                    break label483;
                  }
                  i = 1;
                  if (i == 0) {
                    break label488;
                  }
                  ((a)localObject3).ahF += 1;
                  ((a)localObject3).ahG = ((androidx.compose.ui.g.c.m)localObject4);
                  localObject5 = (androidx.compose.ui.g.c.m)paramAnonymousObject.alK.get(0);
                  s.u(paramAnonymousObject, "<this>");
                  switch (((a)localObject3).ahF)
                  {
                  default: 
                    localObject4 = f.ahM;
                  }
                }
              }
            case 2: 
              for (;;)
              {
                label257:
                label301:
                label317:
                paramAnonymousObject = localObject3;
                localObject1 = localObject2;
                if (!this.ahZ.a(((androidx.compose.ui.g.c.m)localObject5).position, (f)localObject4)) {
                  break;
                }
                androidx.compose.ui.g.c.j.i((androidx.compose.ui.g.c.m)localObject5);
                long l = ((androidx.compose.ui.g.c.m)localObject5).id;
                paramAnonymousObject = (kotlin.g.a.b)new kotlin.g.b.u(this.ahZ) {};
                localObject1 = (kotlin.d.d)this;
                this.L$0 = localObject2;
                this.Uf = localObject3;
                this.label = 3;
                if (androidx.compose.foundation.a.d.a((androidx.compose.ui.g.c.a)localObject2, l, paramAnonymousObject, (kotlin.d.d)localObject1) != locala) {
                  break label579;
                }
                AppMethodBeat.o(203746);
                return locala;
                i = 0;
                break label257;
                label483:
                i = 0;
                break label301;
                label488:
                ((a)localObject3).ahF = 1;
                break label317;
                localObject2 = (a)this.Uf;
                localObject1 = (androidx.compose.ui.g.c.a)this.L$0;
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = localObject2;
                break;
                localObject4 = f.ahJ;
                continue;
                localObject4 = f.ahL;
              }
            }
            Object localObject1 = (a)this.Uf;
            Object localObject2 = (androidx.compose.ui.g.c.a)this.L$0;
            ResultKt.throwOnFailure(paramAnonymousObject);
            for (paramAnonymousObject = localObject2;; paramAnonymousObject = localObject2)
            {
              localObject2 = paramAnonymousObject;
              paramAnonymousObject = localObject1;
              localObject1 = localObject2;
              break;
              label579:
              localObject1 = localObject3;
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localm, locald) == locala)
        {
          AppMethodBeat.o(203730);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(203730);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.a.k
 * JD-Core Version:    0.7.0.1
 */