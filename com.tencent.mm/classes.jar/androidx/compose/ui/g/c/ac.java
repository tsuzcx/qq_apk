package androidx.compose.ui.g.c;

import androidx.compose.runtime.h;
import androidx.compose.ui.e;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"DownChangeConsumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "EmptyPointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "PointerInputModifierNoParamError", "", "pointerInput", "Landroidx/compose/ui/Modifier;", "key1", "", "key2", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ac
{
  private static final b aMd;
  private static final i aMe;
  
  static
  {
    AppMethodBeat.i(205784);
    aMd = new b(true, 1);
    aMe = new i((List)kotlin.a.ab.aivy);
    AppMethodBeat.o(205784);
  }
  
  public static final f a(f paramf, Object paramObject1, final Object paramObject2, final m<? super u, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(205771);
    s.u(paramf, "<this>");
    s.u(paramm, "block");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new b(paramObject1, paramObject2, paramm);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = e.a(paramf, localb, (q)new e(paramObject1, paramObject2, paramm));
      AppMethodBeat.o(205771);
      return paramf;
    }
  }
  
  public static final f a(f paramf, Object paramObject, final m<? super u, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(205765);
    s.u(paramf, "<this>");
    s.u(paramm, "block");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new a(paramObject, paramm);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = e.a(paramf, localb, (q)new d(paramObject, paramm));
      AppMethodBeat.o(205765);
      return paramf;
    }
  }
  
  public static final f a(f paramf, Object[] paramArrayOfObject, final m<? super u, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(205775);
    s.u(paramf, "<this>");
    s.u(paramArrayOfObject, "keys");
    s.u(paramm, "block");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new c(paramArrayOfObject, paramm);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = e.a(paramf, localb, (q)new f(paramArrayOfObject, paramm));
      AppMethodBeat.o(205775);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public a(Object paramObject, m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public b(Object paramObject1, Object paramObject2, m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public c(Object[] paramArrayOfObject, m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements q<f, h, Integer, f>
  {
    d(Object paramObject, m<? super u, ? super d<? super ah>, ? extends Object> paramm)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(m<? super u, ? super d<? super ah>, ? extends Object> paramm, ab paramab, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(205791);
        paramObject = (d)new a(this.VV, this.aMk, paramd);
        AppMethodBeat.o(205791);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(205785);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(205785);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.VV;
          ab localab = this.aMk;
          this.label = 1;
          if (paramObject.invoke(localab, this) == locala)
          {
            AppMethodBeat.o(205785);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(205785);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements q<f, h, Integer, f>
  {
    e(Object paramObject1, Object paramObject2, m<? super u, ? super d<? super ah>, ? extends Object> paramm)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(m<? super u, ? super d<? super ah>, ? extends Object> paramm, ab paramab, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(205776);
        paramObject = (d)new a(this.VV, this.aMk, paramd);
        AppMethodBeat.o(205776);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(205773);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(205773);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.VV;
          ab localab = this.aMk;
          this.label = 1;
          if (paramObject.invoke(localab, this) == locala)
          {
            AppMethodBeat.o(205773);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(205773);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements q<f, h, Integer, f>
  {
    f(Object[] paramArrayOfObject, m<? super u, ? super d<? super ah>, ? extends Object> paramm)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(m<? super u, ? super d<? super ah>, ? extends Object> paramm, ab paramab, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(205801);
        paramObject = (d)new a(this.VV, this.aMk, paramd);
        AppMethodBeat.o(205801);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(205795);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(205795);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.VV;
          ab localab = this.aMk;
          this.label = 1;
          if (paramObject.invoke(localab, this) == locala)
          {
            AppMethodBeat.o(205795);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(205795);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.ac
 * JD-Core Version:    0.7.0.1
 */