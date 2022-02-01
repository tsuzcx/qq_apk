package androidx.compose.foundation.a;

import androidx.compose.ui.d.e;
import androidx.compose.ui.g.c.a.a;
import androidx.compose.ui.g.c.i;
import androidx.compose.ui.g.c.l;
import androidx.compose.ui.platform.av;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Landroidx.compose.ui.g.c.m;>;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.g.a.b<-Landroidx.compose.ui.g.c.m;Lkotlin.ah;>;
import kotlin.g.b.ah.e;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.da;
import kotlinx.coroutines.dc;

@Metadata(d1={""}, d2={"awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "", "overSlop", "", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "initialDown", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "getDragDirectionValue", "Landroidx/compose/ui/geometry/Offset;", "awaitTouchSlopOrCancellation-TUCjRT4", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionFromChange", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final Object a(androidx.compose.ui.g.c.a parama, long paramLong, kotlin.d.d<? super androidx.compose.ui.g.c.m> paramd)
  {
    AppMethodBeat.i(204156);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject1;; paramd = new a(paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204156);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if (a(parama.wk(), paramLong))
    {
      AppMethodBeat.o(204156);
      return null;
    }
    Object localObject2 = new ah.e();
    ((ah.e)localObject2).aixc = paramLong;
    Object localObject1 = parama;
    parama = (androidx.compose.ui.g.c.a)localObject2;
    paramd.L$0 = localObject1;
    paramd.Uf = parama;
    paramd.label = 1;
    localObject2 = a.a.d((androidx.compose.ui.g.c.a)localObject1, paramd);
    label220:
    Object localObject4;
    Object localObject3;
    int i;
    int k;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204156);
      return locala;
      parama = (ah.e)paramd.Uf;
      localObject1 = (androidx.compose.ui.g.c.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
      localObject4 = (i)localObject2;
      localObject3 = ((i)localObject4).alK;
      i = 0;
      k = ((List)localObject3).size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject2 = ((List)localObject3).get(i);
      if (l.e(((androidx.compose.ui.g.c.m)localObject2).id, parama.aixc))
      {
        label288:
        s.checkNotNull(localObject2);
        localObject3 = (androidx.compose.ui.g.c.m)localObject2;
        if (!androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject3)) {
          break label427;
        }
        localObject4 = ((i)localObject4).alK;
        i = 0;
        k = ((List)localObject4).size() - 1;
        if (k < 0) {
          break label409;
        }
      }
      for (;;)
      {
        j = i + 1;
        localObject2 = ((List)localObject4).get(i);
        if (((androidx.compose.ui.g.c.m)localObject2).aLn)
        {
          label362:
          localObject2 = (androidx.compose.ui.g.c.m)localObject2;
          if (localObject2 != null) {
            break label415;
          }
        }
        label409:
        label415:
        label427:
        label471:
        for (;;)
        {
          if (!androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject3)) {
            break label473;
          }
          AppMethodBeat.o(204156);
          return null;
          if (j <= k) {
            break label491;
          }
          localObject2 = null;
          break label288;
          if (j <= k) {
            break label484;
          }
          localObject2 = null;
          break label362;
          parama.aixc = ((androidx.compose.ui.g.c.m)localObject2).id;
          break;
          s.u(localObject3, "<this>");
          paramLong = androidx.compose.ui.g.c.j.a((androidx.compose.ui.g.c.m)localObject3, true);
          localObject2 = e.avo;
          if (!e.e(paramLong, e.su())) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label471;
            }
            break;
          }
        }
        label473:
        AppMethodBeat.o(204156);
        return localObject3;
        break label220;
        label484:
        i = j;
      }
      label491:
      i = j;
    }
  }
  
  public static final Object a(androidx.compose.ui.g.c.a parama, long paramLong, kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah> paramb, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(204147);
    if ((paramd instanceof g))
    {
      localObject1 = (g)paramd;
      if ((((g)localObject1).label & 0x80000000) != 0) {
        ((g)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new g(paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204147);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = paramb;
    paramb = parama;
    for (;;)
    {
      paramd.L$0 = paramb;
      paramd.Uf = localObject1;
      paramd.label = 1;
      Object localObject3 = a(paramb, paramLong, paramd);
      localObject2 = localObject3;
      parama = (androidx.compose.ui.g.c.a)localObject1;
      if (localObject3 == locala)
      {
        AppMethodBeat.o(204147);
        return locala;
        parama = (kotlin.g.a.b)paramd.Uf;
        paramb = (androidx.compose.ui.g.c.a)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      localObject1 = (androidx.compose.ui.g.c.m)localObject2;
      if (localObject1 == null)
      {
        parama = Boolean.FALSE;
        AppMethodBeat.o(204147);
        return parama;
      }
      if (androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject1))
      {
        parama = Boolean.TRUE;
        AppMethodBeat.o(204147);
        return parama;
      }
      parama.invoke(localObject1);
      paramLong = ((androidx.compose.ui.g.c.m)localObject1).id;
      localObject1 = parama;
    }
  }
  
  public static final Object a(androidx.compose.ui.g.c.a parama, long paramLong, kotlin.g.a.m<? super androidx.compose.ui.g.c.m, ? super Float, ah> paramm, kotlin.d.d<? super androidx.compose.ui.g.c.m> paramd)
  {
    AppMethodBeat.i(204164);
    if ((paramd instanceof e))
    {
      localObject1 = (e)paramd;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject1;; paramd = new e(paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204164);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (a(parama.wk(), paramLong))
    {
      AppMethodBeat.o(204164);
      return null;
    }
    float f1 = parama.getViewConfiguration().yS();
    Object localObject2 = new ah.e();
    ((ah.e)localObject2).aixc = paramLong;
    float f2 = 0.0F;
    Object localObject1 = parama;
    parama = (androidx.compose.ui.g.c.a)localObject2;
    paramd.L$0 = localObject1;
    paramd.Uf = paramm;
    paramd.VC = parama;
    paramd.VD = null;
    paramd.aad = f1;
    paramd.aae = f2;
    paramd.label = 1;
    localObject2 = a.a.d((androidx.compose.ui.g.c.a)localObject1, paramd);
    Object localObject3;
    label312:
    List localList;
    int i;
    int k;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204164);
      return locala;
      f2 = paramd.aae;
      f1 = paramd.aad;
      parama = (ah.e)paramd.VC;
      paramm = (kotlin.g.a.m)paramd.Uf;
      localObject3 = (androidx.compose.ui.g.c.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = (i)localObject2;
      localList = ((i)localObject3).alK;
      i = 0;
      k = localList.size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject2 = localList.get(i);
      if (l.e(((androidx.compose.ui.g.c.m)localObject2).id, parama.aixc)) {}
      for (;;)
      {
        s.checkNotNull(localObject2);
        localObject2 = (androidx.compose.ui.g.c.m)localObject2;
        if (!androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2)) {
          break;
        }
        AppMethodBeat.o(204164);
        return null;
        if (j <= k) {
          break label782;
        }
        localObject2 = null;
      }
      if (androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject2))
      {
        localObject3 = ((i)localObject3).alK;
        i = 0;
        k = ((List)localObject3).size() - 1;
        if (k < 0) {}
      }
      for (;;)
      {
        j = i + 1;
        localObject2 = ((List)localObject3).get(i);
        if (((androidx.compose.ui.g.c.m)localObject2).aLn) {}
        for (;;)
        {
          localObject2 = (androidx.compose.ui.g.c.m)localObject2;
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(204164);
          return null;
          if (j <= k) {
            break label775;
          }
          localObject2 = null;
        }
        parama.aixc = ((androidx.compose.ui.g.c.m)localObject2).id;
        break;
        paramLong = ((androidx.compose.ui.g.c.m)localObject2).position;
        long l = ((androidx.compose.ui.g.c.m)localObject2).aLp;
        f2 += e.G(paramLong) - e.G(l);
        if (Math.abs(f2) < f1)
        {
          localObject3 = androidx.compose.ui.g.c.k.aLk;
          paramd.L$0 = localObject1;
          paramd.Uf = paramm;
          paramd.VC = parama;
          paramd.VD = localObject2;
          paramd.aad = f1;
          paramd.aae = f2;
          paramd.label = 2;
          if (((androidx.compose.ui.g.c.a)localObject1).a((androidx.compose.ui.g.c.k)localObject3, paramd) != locala) {
            break label769;
          }
          AppMethodBeat.o(204164);
          return locala;
          f2 = paramd.aae;
          f1 = paramd.aad;
          localObject2 = (androidx.compose.ui.g.c.m)paramd.VD;
          parama = (ah.e)paramd.VC;
          paramm = (kotlin.g.a.m)paramd.Uf;
          localObject3 = (androidx.compose.ui.g.c.a)paramd.L$0;
          ResultKt.throwOnFailure(localObject1);
          localObject1 = localObject3;
        }
        label769:
        for (;;)
        {
          if (androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2))
          {
            AppMethodBeat.o(204164);
            return null;
            paramm.invoke(localObject2, Float.valueOf(f2 - Math.signum(f2) * f1));
            if (androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2))
            {
              AppMethodBeat.o(204164);
              return localObject2;
            }
            f2 = 0.0F;
            break;
          }
          break;
        }
        break label312;
        label775:
        i = j;
      }
      label782:
      i = j;
    }
  }
  
  static final Object a(androidx.compose.ui.g.c.u paramu, androidx.compose.ui.g.c.m paramm, kotlin.d.d<? super androidx.compose.ui.g.c.m> paramd)
  {
    AppMethodBeat.i(204194);
    if ((paramd instanceof c))
    {
      localObject = (c)paramd;
      if ((((c)localObject).label & 0x80000000) != 0) {
        ((c)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject;; paramd = new c(paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramu = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204194);
        throw paramu;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = new ah.f();
    final ah.f localf = new ah.f();
    localf.aqH = paramm;
    long l = paramu.getViewConfiguration().yQ();
    for (;;)
    {
      try
      {
        paramu = (kotlin.g.a.m)new d(paramu, localf, (ah.f)localObject, null);
        paramd.L$0 = paramm;
        paramd.Uf = localObject;
        paramd.label = 1;
        paramu = dc.a(l, paramu, paramd);
        if (paramu == locala)
        {
          AppMethodBeat.o(204194);
          return locala;
          paramu = (ah.f)paramd.Uf;
          paramm = (androidx.compose.ui.g.c.m)paramd.L$0;
        }
        paramd = (androidx.compose.ui.g.c.m)paramd.aqH;
      }
      catch (da paramu)
      {
        try
        {
          ResultKt.throwOnFailure(localObject);
          paramm = null;
          AppMethodBeat.o(204194);
          return paramm;
        }
        catch (da paramd)
        {
          for (;;)
          {
            paramd = paramu;
            paramu = paramm;
          }
        }
        paramu = paramu;
        paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject;
        paramu = paramm;
      }
      paramm = paramd;
      if (paramd == null) {
        paramm = paramu;
      }
    }
  }
  
  static final boolean a(i parami, long paramLong)
  {
    AppMethodBeat.i(204202);
    List localList = parami.alK;
    int k = localList.size() - 1;
    if (k >= 0) {}
    int j;
    label101:
    label106:
    label114:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      parami = localList.get(i);
      if (l.e(((androidx.compose.ui.g.c.m)parami).id, paramLong))
      {
        parami = (androidx.compose.ui.g.c.m)parami;
        if ((parami == null) || (parami.aLn != true)) {
          break label101;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label106;
        }
        AppMethodBeat.o(204202);
        return true;
        if (j <= k) {
          break label114;
        }
        parami = null;
        break;
      }
      AppMethodBeat.o(204202);
      return false;
    }
  }
  
  public static final Object b(androidx.compose.ui.g.c.a parama, long paramLong, kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah> paramb, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(204167);
    i locali;
    if ((paramd instanceof i))
    {
      locali = (i)paramd;
      if ((locali.label & 0x80000000) != 0) {
        locali.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = locali.result;
      locala = kotlin.d.a.a.aiwj;
      switch (locali.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204167);
        throw parama;
        locali = new i(paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (a(parama.wk(), paramLong))
    {
      parama = Boolean.FALSE;
      AppMethodBeat.o(204167);
      return parama;
    }
    Object localObject1 = new ah.e();
    ((ah.e)localObject1).aixc = paramLong;
    paramd = paramb;
    paramb = parama;
    parama = (androidx.compose.ui.g.c.a)localObject1;
    locali.L$0 = paramb;
    locali.Uf = paramd;
    locali.VC = parama;
    locali.label = 1;
    localObject1 = a.a.d(paramb, locali);
    label251:
    Object localObject3;
    Object localObject2;
    int i;
    int k;
    if (localObject1 == locala)
    {
      AppMethodBeat.o(204167);
      return locala;
      paramd = (ah.e)locali.VC;
      paramb = (kotlin.g.a.b)locali.Uf;
      parama = (androidx.compose.ui.g.c.a)locali.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject3 = (i)localObject1;
      localObject2 = ((i)localObject3).alK;
      i = 0;
      k = ((List)localObject2).size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject1 = ((List)localObject2).get(i);
      if (l.e(((androidx.compose.ui.g.c.m)localObject1).id, paramd.aixc))
      {
        label320:
        s.checkNotNull(localObject1);
        localObject2 = (androidx.compose.ui.g.c.m)localObject1;
        if (!androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject2)) {
          break label477;
        }
        localObject3 = ((i)localObject3).alK;
        i = 0;
        k = ((List)localObject3).size() - 1;
        if (k < 0) {
          break label446;
        }
      }
      for (;;)
      {
        j = i + 1;
        localObject1 = ((List)localObject3).get(i);
        if (((androidx.compose.ui.g.c.m)localObject1).aLn)
        {
          label394:
          localObject1 = (androidx.compose.ui.g.c.m)localObject1;
          if (localObject1 != null) {
            break label452;
          }
        }
        label527:
        label531:
        for (;;)
        {
          if (!androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2)) {
            break label533;
          }
          parama = Boolean.FALSE;
          AppMethodBeat.o(204167);
          return parama;
          if (j <= k) {
            break label593;
          }
          localObject1 = null;
          break label320;
          if (j <= k) {
            break label586;
          }
          label446:
          localObject1 = null;
          break label394;
          label452:
          paramd.aixc = ((androidx.compose.ui.g.c.m)localObject1).id;
          localObject1 = parama;
          parama = paramd;
          paramd = paramb;
          paramb = (kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah>)localObject1;
          break;
          label477:
          if (e.G(androidx.compose.ui.g.c.j.f((androidx.compose.ui.g.c.m)localObject2)) == 0.0F)
          {
            i = 1;
            label493:
            if (i != 0) {
              break label527;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label531;
            }
            localObject1 = parama;
            parama = paramd;
            paramd = paramb;
            paramb = (kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah>)localObject1;
            break;
            i = 0;
            break label493;
          }
        }
        label533:
        if (androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject2))
        {
          parama = Boolean.TRUE;
          AppMethodBeat.o(204167);
          return parama;
        }
        paramb.invoke(localObject2);
        paramLong = ((androidx.compose.ui.g.c.m)localObject2).id;
        break;
        localObject2 = paramb;
        paramb = paramd;
        paramd = parama;
        parama = (androidx.compose.ui.g.c.a)localObject2;
        break label251;
        label586:
        i = j;
      }
      label593:
      i = j;
    }
  }
  
  public static final Object b(androidx.compose.ui.g.c.a parama, long paramLong, kotlin.g.a.m<? super androidx.compose.ui.g.c.m, ? super Float, ah> paramm, kotlin.d.d<? super androidx.compose.ui.g.c.m> paramd)
  {
    AppMethodBeat.i(204173);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject1;; paramd = new b(paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204173);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (a(parama.wk(), paramLong))
    {
      AppMethodBeat.o(204173);
      return null;
    }
    float f1 = parama.getViewConfiguration().yS();
    Object localObject2 = new ah.e();
    ((ah.e)localObject2).aixc = paramLong;
    float f2 = 0.0F;
    Object localObject1 = parama;
    parama = (androidx.compose.ui.g.c.a)localObject2;
    paramd.L$0 = localObject1;
    paramd.Uf = paramm;
    paramd.VC = parama;
    paramd.VD = null;
    paramd.aad = f1;
    paramd.aae = f2;
    paramd.label = 1;
    localObject2 = a.a.d((androidx.compose.ui.g.c.a)localObject1, paramd);
    Object localObject3;
    label312:
    List localList;
    int i;
    int k;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204173);
      return locala;
      f2 = paramd.aae;
      f1 = paramd.aad;
      parama = (ah.e)paramd.VC;
      paramm = (kotlin.g.a.m)paramd.Uf;
      localObject3 = (androidx.compose.ui.g.c.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = (i)localObject2;
      localList = ((i)localObject3).alK;
      i = 0;
      k = localList.size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject2 = localList.get(i);
      if (l.e(((androidx.compose.ui.g.c.m)localObject2).id, parama.aixc)) {}
      for (;;)
      {
        s.checkNotNull(localObject2);
        localObject2 = (androidx.compose.ui.g.c.m)localObject2;
        if (!androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2)) {
          break;
        }
        AppMethodBeat.o(204173);
        return null;
        if (j <= k) {
          break label782;
        }
        localObject2 = null;
      }
      if (androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject2))
      {
        localObject3 = ((i)localObject3).alK;
        i = 0;
        k = ((List)localObject3).size() - 1;
        if (k < 0) {}
      }
      for (;;)
      {
        j = i + 1;
        localObject2 = ((List)localObject3).get(i);
        if (((androidx.compose.ui.g.c.m)localObject2).aLn) {}
        for (;;)
        {
          localObject2 = (androidx.compose.ui.g.c.m)localObject2;
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(204173);
          return null;
          if (j <= k) {
            break label775;
          }
          localObject2 = null;
        }
        parama.aixc = ((androidx.compose.ui.g.c.m)localObject2).id;
        break;
        paramLong = ((androidx.compose.ui.g.c.m)localObject2).position;
        long l = ((androidx.compose.ui.g.c.m)localObject2).aLp;
        f2 += e.F(paramLong) - e.F(l);
        if (Math.abs(f2) < f1)
        {
          localObject3 = androidx.compose.ui.g.c.k.aLk;
          paramd.L$0 = localObject1;
          paramd.Uf = paramm;
          paramd.VC = parama;
          paramd.VD = localObject2;
          paramd.aad = f1;
          paramd.aae = f2;
          paramd.label = 2;
          if (((androidx.compose.ui.g.c.a)localObject1).a((androidx.compose.ui.g.c.k)localObject3, paramd) != locala) {
            break label769;
          }
          AppMethodBeat.o(204173);
          return locala;
          f2 = paramd.aae;
          f1 = paramd.aad;
          localObject2 = (androidx.compose.ui.g.c.m)paramd.VD;
          parama = (ah.e)paramd.VC;
          paramm = (kotlin.g.a.m)paramd.Uf;
          localObject3 = (androidx.compose.ui.g.c.a)paramd.L$0;
          ResultKt.throwOnFailure(localObject1);
          localObject1 = localObject3;
        }
        label769:
        for (;;)
        {
          if (androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2))
          {
            AppMethodBeat.o(204173);
            return null;
            paramm.invoke(localObject2, Float.valueOf(f2 - Math.signum(f2) * f1));
            if (androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2))
            {
              AppMethodBeat.o(204173);
              return localObject2;
            }
            f2 = 0.0F;
            break;
          }
          break;
        }
        break label312;
        label775:
        i = j;
      }
      label782:
      i = j;
    }
  }
  
  public static final Object c(androidx.compose.ui.g.c.a parama, long paramLong, kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah> paramb, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(204182);
    h localh;
    if ((paramd instanceof h))
    {
      localh = (h)paramd;
      if ((localh.label & 0x80000000) != 0) {
        localh.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = localh.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localh.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204182);
        throw parama;
        localh = new h(paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (a(parama.wk(), paramLong))
    {
      parama = Boolean.FALSE;
      AppMethodBeat.o(204182);
      return parama;
    }
    Object localObject1 = new ah.e();
    ((ah.e)localObject1).aixc = paramLong;
    paramd = paramb;
    paramb = parama;
    parama = (androidx.compose.ui.g.c.a)localObject1;
    localh.L$0 = paramb;
    localh.Uf = paramd;
    localh.VC = parama;
    localh.label = 1;
    localObject1 = a.a.d(paramb, localh);
    label251:
    Object localObject3;
    Object localObject2;
    int i;
    int k;
    if (localObject1 == locala)
    {
      AppMethodBeat.o(204182);
      return locala;
      paramd = (ah.e)localh.VC;
      paramb = (kotlin.g.a.b)localh.Uf;
      parama = (androidx.compose.ui.g.c.a)localh.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject3 = (i)localObject1;
      localObject2 = ((i)localObject3).alK;
      i = 0;
      k = ((List)localObject2).size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject1 = ((List)localObject2).get(i);
      if (l.e(((androidx.compose.ui.g.c.m)localObject1).id, paramd.aixc))
      {
        label320:
        s.checkNotNull(localObject1);
        localObject2 = (androidx.compose.ui.g.c.m)localObject1;
        if (!androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject2)) {
          break label477;
        }
        localObject3 = ((i)localObject3).alK;
        i = 0;
        k = ((List)localObject3).size() - 1;
        if (k < 0) {
          break label446;
        }
      }
      for (;;)
      {
        j = i + 1;
        localObject1 = ((List)localObject3).get(i);
        if (((androidx.compose.ui.g.c.m)localObject1).aLn)
        {
          label394:
          localObject1 = (androidx.compose.ui.g.c.m)localObject1;
          if (localObject1 != null) {
            break label452;
          }
        }
        label527:
        label531:
        for (;;)
        {
          if (!androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)localObject2)) {
            break label533;
          }
          parama = Boolean.FALSE;
          AppMethodBeat.o(204182);
          return parama;
          if (j <= k) {
            break label593;
          }
          localObject1 = null;
          break label320;
          if (j <= k) {
            break label586;
          }
          label446:
          localObject1 = null;
          break label394;
          label452:
          paramd.aixc = ((androidx.compose.ui.g.c.m)localObject1).id;
          localObject1 = parama;
          parama = paramd;
          paramd = paramb;
          paramb = (kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah>)localObject1;
          break;
          label477:
          if (e.F(androidx.compose.ui.g.c.j.f((androidx.compose.ui.g.c.m)localObject2)) == 0.0F)
          {
            i = 1;
            label493:
            if (i != 0) {
              break label527;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label531;
            }
            localObject1 = parama;
            parama = paramd;
            paramd = paramb;
            paramb = (kotlin.g.a.b<? super androidx.compose.ui.g.c.m, ah>)localObject1;
            break;
            i = 0;
            break label493;
          }
        }
        label533:
        if (androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)localObject2))
        {
          parama = Boolean.TRUE;
          AppMethodBeat.o(204182);
          return parama;
        }
        paramb.invoke(localObject2);
        paramLong = ((androidx.compose.ui.g.c.m)localObject2).id;
        break;
        localObject2 = paramb;
        paramb = paramd;
        paramd = parama;
        parama = (androidx.compose.ui.g.c.a)localObject2;
        break label251;
        label586:
        i = j;
      }
      label593:
      i = j;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204049);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, 0L, (kotlin.d.d)this);
      AppMethodBeat.o(204049);
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
    float aad;
    float aae;
    int label;
    
    b(kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204068);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.b(null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(204068);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    c(kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204070);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(204070);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(androidx.compose.ui.g.c.u paramu, ah.f<androidx.compose.ui.g.c.m> paramf1, ah.f<androidx.compose.ui.g.c.m> paramf2, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204069);
      paramObject = (kotlin.d.d)new d(this.aaf, localf, this.aah, paramd);
      AppMethodBeat.o(204069);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204066);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204066);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.aaf;
        kotlin.g.a.m localm = (kotlin.g.a.m)new kotlin.d.b.a.j(localf)
        {
          Object Uf;
          int aai;
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(204034);
            paramAnonymousd = new 1(this.aag, this.aah, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            paramAnonymousObject = (kotlin.d.d)paramAnonymousd;
            AppMethodBeat.o(204034);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(204031);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            int i;
            Object localObject1;
            Object localObject2;
            int j;
            int m;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(204031);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (androidx.compose.ui.g.c.a)this.L$0;
              i = 0;
              if (i == 0)
              {
                localObject1 = androidx.compose.ui.g.c.k.aLj;
                localObject2 = (kotlin.d.d)this;
                this.L$0 = paramAnonymousObject;
                this.Uf = null;
                this.aai = i;
                this.label = 1;
                localObject2 = paramAnonymousObject.a((androidx.compose.ui.g.c.k)localObject1, (kotlin.d.d)localObject2);
                localObject1 = localObject2;
                if (localObject2 == locala)
                {
                  AppMethodBeat.o(204031);
                  return locala;
                }
              }
              break;
            case 1: 
              i = this.aai;
              localObject2 = (androidx.compose.ui.g.c.a)this.L$0;
              ResultKt.throwOnFailure(paramAnonymousObject);
              localObject1 = paramAnonymousObject;
              paramAnonymousObject = localObject2;
              localObject2 = (i)localObject1;
              localObject1 = ((i)localObject2).alK;
              j = 0;
              m = ((List)localObject1).size() - 1;
              if (m < 0) {}
              break;
            }
            for (;;)
            {
              int k = j + 1;
              if (!androidx.compose.ui.g.c.j.d((androidx.compose.ui.g.c.m)((List)localObject1).get(j)))
              {
                j = 0;
                label217:
                if (j != 0) {
                  i = 1;
                }
                localObject1 = ((i)localObject2).alK;
                j = 0;
                m = ((List)localObject1).size() - 1;
                if (m < 0) {
                  break label388;
                }
              }
              for (;;)
              {
                k = j + 1;
                Object localObject3 = (androidx.compose.ui.g.c.m)((List)localObject1).get(j);
                if ((((androidx.compose.ui.g.c.m)localObject3).aLr.aKT) || (androidx.compose.ui.g.c.j.a((androidx.compose.ui.g.c.m)localObject3, paramAnonymousObject.wj())))
                {
                  j = 1;
                  label293:
                  if (j == 0) {
                    break label381;
                  }
                  j = 1;
                  label299:
                  if (j == 0) {
                    break label756;
                  }
                  i = 1;
                }
                label388:
                label478:
                label611:
                label617:
                label747:
                label756:
                for (;;)
                {
                  localObject1 = androidx.compose.ui.g.c.k.aLk;
                  localObject3 = (kotlin.d.d)this;
                  this.L$0 = paramAnonymousObject;
                  this.Uf = localObject2;
                  this.aai = i;
                  this.label = 2;
                  localObject1 = paramAnonymousObject.a((androidx.compose.ui.g.c.k)localObject1, (kotlin.d.d)localObject3);
                  if (localObject1 == locala)
                  {
                    AppMethodBeat.o(204031);
                    return locala;
                    if (k <= m) {
                      break label765;
                    }
                    j = 1;
                    break label217;
                    j = 0;
                    break label293;
                    label381:
                    if (k <= m) {
                      break label759;
                    }
                    j = 0;
                    break label299;
                    i = this.aai;
                    localObject2 = (i)this.Uf;
                    localObject3 = (androidx.compose.ui.g.c.a)this.L$0;
                    ResultKt.throwOnFailure(paramAnonymousObject);
                    localObject1 = paramAnonymousObject;
                    paramAnonymousObject = localObject3;
                  }
                  for (;;)
                  {
                    localObject1 = ((i)localObject1).alK;
                    j = 0;
                    m = ((List)localObject1).size() - 1;
                    if (m >= 0) {}
                    for (;;)
                    {
                      k = j + 1;
                      ah.f localf;
                      if (androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)((List)localObject1).get(j)))
                      {
                        j = 1;
                        if (j != 0) {
                          i = 1;
                        }
                        if (d.a((i)localObject2, ((androidx.compose.ui.g.c.m)this.aag.aqH).id)) {
                          break label617;
                        }
                        localObject3 = this.aah;
                        localObject2 = ((i)localObject2).alK;
                        localf = this.aag;
                        j = 0;
                        m = ((List)localObject2).size() - 1;
                        if (m < 0) {
                          break label611;
                        }
                      }
                      for (;;)
                      {
                        k = j + 1;
                        localObject1 = ((List)localObject2).get(j);
                        if (l.e(((androidx.compose.ui.g.c.m)localObject1).id, ((androidx.compose.ui.g.c.m)localf.aqH).id)) {}
                        for (;;)
                        {
                          ((ah.f)localObject3).aqH = localObject1;
                          break;
                          if (k <= m) {
                            break label747;
                          }
                          j = 0;
                          break label478;
                          if (k <= m) {
                            break label741;
                          }
                          localObject1 = null;
                        }
                        localObject2 = ((i)localObject2).alK;
                        j = 0;
                        m = ((List)localObject2).size() - 1;
                        if (m >= 0) {}
                        for (;;)
                        {
                          k = j + 1;
                          localObject1 = ((List)localObject2).get(j);
                          if (((androidx.compose.ui.g.c.m)localObject1).aLn) {}
                          for (;;)
                          {
                            localObject1 = (androidx.compose.ui.g.c.m)localObject1;
                            if (localObject1 == null) {
                              break label719;
                            }
                            this.aag.aqH = localObject1;
                            this.aah.aqH = this.aag.aqH;
                            break;
                            if (k <= m) {
                              break label735;
                            }
                            localObject1 = null;
                          }
                          i = 1;
                          break;
                          paramAnonymousObject = ah.aiuX;
                          AppMethodBeat.o(204031);
                          return paramAnonymousObject;
                          j = k;
                        }
                        j = k;
                      }
                      j = k;
                    }
                  }
                }
                label719:
                label735:
                label741:
                label759:
                j = k;
              }
              label765:
              j = k;
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localm, locald) == locala)
        {
          AppMethodBeat.o(204066);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(204066);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    float aad;
    float aae;
    int label;
    
    e(kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204071);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(204071);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<androidx.compose.ui.g.c.u, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public f(kotlin.g.a.b<? super e, ah> paramb, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, kotlin.g.a.m<? super androidx.compose.ui.g.c.m, ? super e, ah> paramm, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204084);
      paramd = new f(this.aaj, this.aak, this.aal, this.aam, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204084);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204078);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204078);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (androidx.compose.ui.g.c.u)this.L$0;
        localObject1 = (kotlin.g.a.m)new a(null);
        localObject2 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = paramObject.a((kotlin.g.a.m)localObject1, (kotlin.d.d)localObject2);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(204078);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (androidx.compose.ui.g.c.u)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject1 = (androidx.compose.ui.g.c.m)localObject1;
        try
        {
          localObject2 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 2;
          localObject1 = d.a(paramObject, (androidx.compose.ui.g.c.m)localObject1, (kotlin.d.d)localObject2);
          if (localObject1 != locala) {
            break label318;
          }
          AppMethodBeat.o(204078);
          return locala;
        }
        catch (CancellationException paramObject)
        {
          this.aak.invoke();
          AppMethodBeat.o(204078);
          throw paramObject;
        }
        localObject2 = (androidx.compose.ui.g.c.u)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        label318:
        for (;;)
        {
          localObject1 = (androidx.compose.ui.g.c.m)localObject1;
          if (localObject1 != null)
          {
            this.aaj.invoke(e.N(((androidx.compose.ui.g.c.m)localObject1).position));
            localObject1 = (kotlin.g.a.m)new kotlin.d.b.a.j((androidx.compose.ui.g.c.m)localObject1)
            {
              int label;
              
              public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
              {
                AppMethodBeat.i(204043);
                paramAnonymousd = new 1(this.aan, this.aal, this.aak, this.aam, paramAnonymousd);
                paramAnonymousd.L$0 = paramAnonymousObject;
                paramAnonymousObject = (kotlin.d.d)paramAnonymousd;
                AppMethodBeat.o(204043);
                return paramAnonymousObject;
              }
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(204038);
                kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                Object localObject;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(204038);
                  throw paramAnonymousObject;
                case 0: 
                  ResultKt.throwOnFailure(paramAnonymousObject);
                  localObject = (androidx.compose.ui.g.c.a)this.L$0;
                  long l = this.aan.id;
                  paramAnonymousObject = (kotlin.g.a.b)new kotlin.g.b.u(this.aam) {};
                  kotlin.d.d locald = (kotlin.d.d)this;
                  this.L$0 = localObject;
                  this.label = 1;
                  paramAnonymousObject = d.a((androidx.compose.ui.g.c.a)localObject, l, paramAnonymousObject, locald);
                  if (paramAnonymousObject == locala)
                  {
                    AppMethodBeat.o(204038);
                    return locala;
                  }
                  break;
                case 1: 
                  localObject = (androidx.compose.ui.g.c.a)this.L$0;
                  ResultKt.throwOnFailure(paramAnonymousObject);
                }
                for (;;)
                {
                  int i;
                  int k;
                  if (((Boolean)paramAnonymousObject).booleanValue())
                  {
                    paramAnonymousObject = ((androidx.compose.ui.g.c.a)localObject).wk().alK;
                    i = 0;
                    k = paramAnonymousObject.size() - 1;
                    if (k < 0) {}
                  }
                  for (;;)
                  {
                    int j = i + 1;
                    localObject = (androidx.compose.ui.g.c.m)paramAnonymousObject.get(i);
                    if (androidx.compose.ui.g.c.j.c((androidx.compose.ui.g.c.m)localObject)) {
                      androidx.compose.ui.g.c.j.i((androidx.compose.ui.g.c.m)localObject);
                    }
                    if (j > k)
                    {
                      this.aal.invoke();
                      for (;;)
                      {
                        paramAnonymousObject = ah.aiuX;
                        AppMethodBeat.o(204038);
                        return paramAnonymousObject;
                        this.aak.invoke();
                      }
                    }
                    i = j;
                  }
                }
              }
            };
            localObject2 = (kotlin.d.d)this;
            this.L$0 = null;
            this.label = 3;
            paramObject = paramObject.a((kotlin.g.a.m)localObject1, (kotlin.d.d)localObject2);
            if (paramObject == locala)
            {
              AppMethodBeat.o(204078);
              return locala;
              ResultKt.throwOnFailure(paramObject);
            }
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(204078);
          return paramObject;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<androidx.compose.ui.g.c.a, kotlin.d.d<? super androidx.compose.ui.g.c.m>, Object>
    {
      int label;
      
      a(kotlin.d.d<? super a> paramd)
      {
        super();
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(203989);
        paramd = new a(paramd);
        paramd.L$0 = paramObject;
        paramObject = (kotlin.d.d)paramd;
        AppMethodBeat.o(203989);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(203978);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(203978);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (androidx.compose.ui.g.c.a)this.L$0;
          Object localObject = (kotlin.d.d)this;
          this.label = 1;
          localObject = v.a(paramObject, false, (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(203978);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(203978);
        return paramObject;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    g(kotlin.d.d<? super g> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204060);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(204060);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    h(kotlin.d.d<? super h> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204067);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.c(null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(204067);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    i(kotlin.d.d<? super i> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204061);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.b(null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(204061);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.d
 * JD-Core Version:    0.7.0.1
 */