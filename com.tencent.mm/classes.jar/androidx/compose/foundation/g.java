package androidx.compose.foundation;

import androidx.compose.foundation.a.l;
import androidx.compose.foundation.a.v;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"PressedInteractionSourceDisposableEffect", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pressedInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "gestureModifiers", "genericClickableWithoutGesture-W9VDXb4", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "Landroidx/compose/ui/geometry/Offset;", "handlePressInteraction-YqVAtuI", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final f a(f paramf, final androidx.compose.foundation.b.e parame, final k paramk, final boolean paramBoolean, final String paramString, final androidx.compose.ui.k.g paramg, final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(203615);
    s.u(paramf, "$this$clickable");
    s.u(parame, "interactionSource");
    s.u(parama, "onClick");
    if (ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new e(paramBoolean, paramString, paramg, parama, paramk, parame);; localb = ab.zh())
    {
      paramf = androidx.compose.ui.e.a(paramf, localb, (q)new d(parama, paramBoolean, parame, paramk, paramString, paramg));
      AppMethodBeat.o(203615);
      return paramf;
    }
  }
  
  public static final void a(final androidx.compose.foundation.b.e parame, final an<androidx.compose.foundation.b.g.b> paraman, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(203633);
    s.u(parame, "interactionSource");
    s.u(paraman, "pressedInteraction");
    androidx.compose.runtime.h localh = paramh.by(1115973350);
    if ((paramInt & 0xE) == 0) {
      if (localh.G(parame)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (localh.G(paraman))
        {
          j = 32;
          label76:
          i = j | i;
        }
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!localh.nZ()))
        {
          localh.bx(-3686552);
          boolean bool1 = localh.G(paraman);
          boolean bool2 = localh.G(parame);
          paramh = localh.or();
          if (!(bool2 | bool1))
          {
            h.a locala = androidx.compose.runtime.h.alD;
            if (paramh != h.a.ox()) {}
          }
          else
          {
            paramh = (kotlin.g.a.b)new a(paraman, parame);
            localh.F(paramh);
            label182:
            localh.od();
            aa.a(parame, (kotlin.g.a.b)paramh, localh);
          }
        }
        for (;;)
        {
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((m)new b(parame, paraman, paramInt));
          }
          AppMethodBeat.o(203633);
          return;
          i = 2;
          break;
          j = 16;
          break label76;
          break label182;
          localh.oi();
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y, x>
  {
    a(an<androidx.compose.foundation.b.g.b> paraman, androidx.compose.foundation.b.e parame)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(an paraman, androidx.compose.foundation.b.e parame) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203644);
        Object localObject = (androidx.compose.foundation.b.g.b)this.Yq.getValue();
        if (localObject != null)
        {
          localObject = new androidx.compose.foundation.b.g.a((androidx.compose.foundation.b.g.b)localObject);
          this.Yr.a((androidx.compose.foundation.b.b)localObject);
          this.Yq.setValue(null);
        }
        AppMethodBeat.o(203644);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    b(androidx.compose.foundation.b.e parame, an<androidx.compose.foundation.b.g.b> paraman, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements q<f, androidx.compose.runtime.h, Integer, f>
  {
    c(boolean paramBoolean, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements q<f, androidx.compose.runtime.h, Integer, f>
  {
    d(kotlin.g.a.a<ah> parama, boolean paramBoolean, androidx.compose.foundation.b.e parame, k paramk, String paramString, androidx.compose.ui.k.g paramg)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<androidx.compose.ui.g.c.u, d<? super ah>, Object>
    {
      int label;
      
      a(boolean paramBoolean, androidx.compose.foundation.b.e parame, an<androidx.compose.foundation.b.g.b> paraman, bm<? extends kotlin.g.a.a<ah>> parambm, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(203518);
        paramd = new a(this.eD, this.Yp, this.Yo, this.Yw, paramd);
        paramd.L$0 = paramObject;
        paramObject = (d)paramd;
        AppMethodBeat.o(203518);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(203515);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(203515);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (androidx.compose.ui.g.c.u)this.L$0;
          q localq = (q)new kotlin.d.b.a.k(this.eD, this.Yp)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(203533);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(203533);
                throw paramAnonymousObject;
              case 0: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = (l)this.L$0;
                long l = this.Yx;
                if (this.eD)
                {
                  Object localObject = this.Yp;
                  an localan = this.Yo;
                  d locald = (d)this;
                  this.label = 1;
                  localObject = ar.c((m)new g.h(paramAnonymousObject, l, (androidx.compose.foundation.b.e)localObject, localan, null), locald);
                  paramAnonymousObject = localObject;
                  if (localObject != kotlin.d.a.a.aiwj) {
                    paramAnonymousObject = ah.aiuX;
                  }
                  if (paramAnonymousObject == locala)
                  {
                    AppMethodBeat.o(203533);
                    return locala;
                  }
                }
                break;
              case 1: 
                ResultKt.throwOnFailure(paramAnonymousObject);
              }
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(203533);
              return paramAnonymousObject;
            }
          };
          kotlin.g.a.b localb = (kotlin.g.a.b)new kotlin.g.b.u(this.eD) {};
          d locald = (d)this;
          this.label = 1;
          if (v.a(paramObject, localq, localb, locald) == locala)
          {
            AppMethodBeat.o(203515);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(203515);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public e(boolean paramBoolean, String paramString, androidx.compose.ui.k.g paramg, kotlin.g.a.a parama, k paramk, androidx.compose.foundation.b.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public f(boolean paramBoolean, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    boolean YF;
    int label;
    
    h(l paraml, long paramLong, androidx.compose.foundation.b.e parame, an<androidx.compose.foundation.b.g.b> paraman, d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(203659);
      paramd = new h(this.YG, this.YH, this.Yp, this.Yo, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(203659);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203657);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      boolean bool;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203657);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = j.a((aq)this.L$0, null, null, (m)new a(this.YH, this.Yp, this.Yo, null), 3);
        localObject1 = this.YG;
        localObject2 = (d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = ((l)localObject1).a((d)localObject2);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(203657);
          return locala;
        }
      case 1: 
        localObject2 = (cb)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        bool = ((Boolean)localObject1).booleanValue();
        if (paramObject.isActive())
        {
          localObject1 = (d)this;
          this.L$0 = null;
          this.YF = bool;
          this.label = 2;
          if (cg.b(paramObject, (d)localObject1) != locala) {
            break label506;
          }
          AppMethodBeat.o(203657);
          return locala;
        }
        break;
      case 2: 
        bool = this.YF;
        ResultKt.throwOnFailure(paramObject);
      }
      label503:
      label506:
      for (;;)
      {
        if (bool)
        {
          localObject2 = new androidx.compose.foundation.b.g.b(this.YH, (byte)0);
          paramObject = new androidx.compose.foundation.b.g.c((androidx.compose.foundation.b.g.b)localObject2);
          localObject1 = this.Yp;
          localObject2 = (androidx.compose.foundation.b.b)localObject2;
          d locald = (d)this;
          this.L$0 = paramObject;
          this.label = 3;
          if (((androidx.compose.foundation.b.e)localObject1).a((androidx.compose.foundation.b.b)localObject2, locald) != locala) {
            break label503;
          }
          AppMethodBeat.o(203657);
          return locala;
          localObject1 = (androidx.compose.foundation.b.g.c)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        for (;;)
        {
          localObject1 = this.Yp;
          paramObject = (androidx.compose.foundation.b.b)paramObject;
          localObject2 = (d)this;
          this.L$0 = null;
          this.label = 4;
          if (((androidx.compose.foundation.b.e)localObject1).a(paramObject, (d)localObject2) == locala)
          {
            AppMethodBeat.o(203657);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
          for (;;)
          {
            this.Yo.setValue(null);
            paramObject = ah.aiuX;
            AppMethodBeat.o(203657);
            return paramObject;
            paramObject = (androidx.compose.foundation.b.g.b)this.Yo.getValue();
            if (paramObject != null)
            {
              localObject1 = this.Yp;
              if (bool) {}
              for (paramObject = (androidx.compose.foundation.b.g)new androidx.compose.foundation.b.g.c(paramObject);; paramObject = (androidx.compose.foundation.b.g)new androidx.compose.foundation.b.g.a(paramObject))
              {
                paramObject = (androidx.compose.foundation.b.b)paramObject;
                this.L$0 = null;
                this.label = 5;
                if (((androidx.compose.foundation.b.e)localObject1).a(paramObject, this) != locala) {
                  break;
                }
                AppMethodBeat.o(203657);
                return locala;
              }
              ResultKt.throwOnFailure(paramObject);
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, d<? super ah>, Object>
    {
      Object L$0;
      int label;
      
      a(long paramLong, androidx.compose.foundation.b.e parame, an<androidx.compose.foundation.b.g.b> paraman, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(203491);
        paramObject = (d)new a(this.YH, this.Yp, this.Yo, paramd);
        AppMethodBeat.o(203491);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(203485);
        Object localObject = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(203485);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          long l = h.mi();
          paramObject = (d)this;
          this.label = 1;
          if (bb.e(l, paramObject) == localObject)
          {
            AppMethodBeat.o(203485);
            return localObject;
          }
        case 1: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = new androidx.compose.foundation.b.g.b(this.YH, (byte)0);
          androidx.compose.foundation.b.e locale = this.Yp;
          androidx.compose.foundation.b.b localb = (androidx.compose.foundation.b.b)paramObject;
          d locald = (d)this;
          this.L$0 = paramObject;
          this.label = 2;
          if (locale.a(localb, locald) != localObject) {
            break label178;
          }
          AppMethodBeat.o(203485);
          return localObject;
        }
        localObject = (androidx.compose.foundation.b.g.b)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
        label178:
        this.Yo.setValue(paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(203485);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.g
 * JD-Core Version:    0.7.0.1
 */