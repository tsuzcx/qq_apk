package androidx.compose.foundation.a;

import androidx.compose.foundation.b.a.a;
import androidx.compose.foundation.b.a.b;
import androidx.compose.foundation.b.a.c;
import androidx.compose.foundation.b.b;
import androidx.compose.runtime.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.g.a.q;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DragLogic;", "", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "dragStartInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getDragStartInteraction", "()Landroidx/compose/runtime/MutableState;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDragStarted", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getOnDragStopped", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
{
  private final q<aq, androidx.compose.ui.d.e, kotlin.d.d<? super ah>, Object> aao;
  private final q<aq, Float, kotlin.d.d<? super ah>, Object> aap;
  private final an<a.b> aaq;
  private final androidx.compose.foundation.b.e aar;
  
  public e(q<? super aq, ? super androidx.compose.ui.d.e, ? super kotlin.d.d<? super ah>, ? extends Object> paramq, q<? super aq, ? super Float, ? super kotlin.d.d<? super ah>, ? extends Object> paramq1, an<a.b> paraman, androidx.compose.foundation.b.e parame)
  {
    AppMethodBeat.i(204132);
    this.aao = paramq;
    this.aap = paramq1;
    this.aaq = paraman;
    this.aar = parame;
    AppMethodBeat.o(204132);
  }
  
  public final Object a(aq paramaq, c.c paramc, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204141);
    b localb;
    if ((paramd instanceof b))
    {
      localb = (b)paramd;
      if ((localb.label & 0x80000000) != 0) {
        localb.label += -2147483648;
      }
    }
    Object localObject1;
    a locala;
    for (;;)
    {
      localObject1 = localb.result;
      locala = a.aiwj;
      switch (localb.label)
      {
      default: 
        paramaq = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204141);
        throw paramaq;
        localb = new b(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject2 = (a.b)this.aaq.getValue();
    e locale = this;
    aq localaq = paramaq;
    paramd = paramc;
    if (localObject2 != null)
    {
      localObject1 = this.aar;
      locale = this;
      localaq = paramaq;
      paramd = paramc;
      if (localObject1 != null)
      {
        localObject2 = (b)new a.a((a.b)localObject2);
        localb.L$0 = this;
        localb.Uf = paramaq;
        localb.VC = paramc;
        localb.label = 1;
        locale = this;
        localaq = paramaq;
        paramd = paramc;
        if (((androidx.compose.foundation.b.e)localObject1).a((b)localObject2, localb) == locala)
        {
          AppMethodBeat.o(204141);
          return locala;
          paramd = (c.c)localb.VC;
          localaq = (aq)localb.Uf;
          locale = (e)localb.L$0;
          ResultKt.throwOnFailure(localObject1);
        }
      }
    }
    paramaq = new a.b();
    paramc = locale.aar;
    if (paramc != null)
    {
      localObject1 = (b)paramaq;
      localb.L$0 = locale;
      localb.Uf = localaq;
      localb.VC = paramd;
      localb.VD = paramaq;
      localb.label = 2;
      if (paramc.a((b)localObject1, localb) == locala)
      {
        AppMethodBeat.o(204141);
        return locala;
        paramaq = (a.b)localb.VD;
        paramd = (c.c)localb.VC;
        localaq = (aq)localb.Uf;
        locale = (e)localb.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
    }
    for (;;)
    {
      locale.aaq.setValue(paramaq);
      paramaq = locale.aao;
      paramc = androidx.compose.ui.d.e.N(paramd.aab);
      localb.L$0 = null;
      localb.Uf = null;
      localb.VC = null;
      localb.VD = null;
      localb.label = 3;
      if (paramaq.invoke(localaq, paramc, localb) == locala)
      {
        AppMethodBeat.o(204141);
        return locala;
        ResultKt.throwOnFailure(localObject1);
      }
      paramaq = ah.aiuX;
      AppMethodBeat.o(204141);
      return paramaq;
    }
  }
  
  public final Object a(aq paramaq, c.d paramd, kotlin.d.d<? super ah> paramd1)
  {
    AppMethodBeat.i(204150);
    c localc;
    if ((paramd1 instanceof c))
    {
      localc = (c)paramd1;
      if ((localc.label & 0x80000000) != 0) {
        localc.label += -2147483648;
      }
    }
    a locala;
    for (;;)
    {
      localObject = localc.result;
      locala = a.aiwj;
      switch (localc.label)
      {
      default: 
        paramaq = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204150);
        throw paramaq;
        localc = new c(this, paramd1);
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = (a.b)this.aaq.getValue();
    paramd1 = this;
    aq localaq = paramaq;
    c.d locald = paramd;
    if (localObject != null)
    {
      androidx.compose.foundation.b.e locale = this.aar;
      paramd1 = this;
      localaq = paramaq;
      locald = paramd;
      if (locale != null)
      {
        localObject = (b)new a.c((a.b)localObject);
        localc.L$0 = this;
        localc.Uf = paramaq;
        localc.VC = paramd;
        localc.label = 1;
        paramd1 = this;
        localaq = paramaq;
        locald = paramd;
        if (locale.a((b)localObject, localc) == locala)
        {
          AppMethodBeat.o(204150);
          return locala;
          locald = (c.d)localc.VC;
          localaq = (aq)localc.Uf;
          paramd1 = (e)localc.L$0;
          ResultKt.throwOnFailure(localObject);
        }
      }
      paramd1.aaq.setValue(null);
    }
    paramaq = paramd1.aap;
    float f = locald.aac;
    localc.L$0 = null;
    localc.Uf = null;
    localc.VC = null;
    localc.label = 2;
    if (paramaq.invoke(localaq, Float.valueOf(f), localc) == locala)
    {
      AppMethodBeat.o(204150);
      return locala;
      ResultKt.throwOnFailure(localObject);
    }
    paramaq = ah.aiuX;
    AppMethodBeat.o(204150);
    return paramaq;
  }
  
  public final Object a(aq paramaq, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204159);
    a locala;
    if ((paramd instanceof a))
    {
      locala = (a)paramd;
      if ((locala.label & 0x80000000) != 0) {
        locala.label += -2147483648;
      }
    }
    a locala1;
    for (;;)
    {
      localObject = locala.result;
      locala1 = a.aiwj;
      switch (locala.label)
      {
      default: 
        paramaq = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204159);
        throw paramaq;
        locala = new a(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = (a.b)this.aaq.getValue();
    paramd = this;
    aq localaq = paramaq;
    if (localObject != null)
    {
      androidx.compose.foundation.b.e locale = this.aar;
      paramd = this;
      localaq = paramaq;
      if (locale != null)
      {
        localObject = (b)new a.a((a.b)localObject);
        locala.L$0 = this;
        locala.Uf = paramaq;
        locala.label = 1;
        paramd = this;
        localaq = paramaq;
        if (locale.a((b)localObject, locala) == locala1)
        {
          AppMethodBeat.o(204159);
          return locala1;
          localaq = (aq)locala.Uf;
          paramd = (e)locala.L$0;
          ResultKt.throwOnFailure(localObject);
        }
      }
      paramd.aaq.setValue(null);
    }
    paramaq = paramd.aap;
    locala.L$0 = null;
    locala.Uf = null;
    locala.label = 2;
    if (paramaq.invoke(localaq, Float.valueOf(0.0F), locala) == locala1)
    {
      AppMethodBeat.o(204159);
      return locala1;
      ResultKt.throwOnFailure(localObject);
    }
    paramaq = ah.aiuX;
    AppMethodBeat.o(204159);
    return paramaq;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(e parame, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204162);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aas.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(204162);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    b(e parame, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204165);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aas.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(204165);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    c(e parame, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204170);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aas.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(204170);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.e
 * JD-Core Version:    0.7.0.1
 */