package androidx.compose.ui.c;

import androidx.compose.ui.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"invalidFocusDirection", "", "noActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "bottomRight", "findBestCandidate", "Landroidx/compose/ui/node/ModifiedFocusNode;", "", "focusRect", "findBestCandidate-4WY_MpI", "(Ljava/util/List;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/node/ModifiedFocusNode;", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch-Mxy_nc0", "(Landroidx/compose/ui/node/ModifiedFocusNode;I)Landroidx/compose/ui/node/ModifiedFocusNode;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final long a(int paramInt, g paramg1, g paramg2)
  {
    AppMethodBeat.i(204430);
    long l1 = Math.abs(b(paramg2, paramInt, paramg1));
    long l2 = Math.abs(c(paramg2, paramInt, paramg1));
    AppMethodBeat.o(204430);
    return l1 * (13L * l1) + l2 * l2;
  }
  
  private static final g a(g paramg)
  {
    AppMethodBeat.i(204403);
    paramg = new g(paramg.left, paramg.top, paramg.left, paramg.top);
    AppMethodBeat.o(204403);
    return paramg;
  }
  
  public static final androidx.compose.ui.i.o a(androidx.compose.ui.i.o paramo, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(204379);
    s.u(paramo, "$this$twoDimensionalFocusSearch");
    Object localObject2 = paramo.yf();
    switch (a.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    default: 
      paramo = new kotlin.p();
      AppMethodBeat.o(204379);
      throw paramo;
    case 1: 
      AppMethodBeat.o(204379);
      return paramo;
    case 2: 
      AppMethodBeat.o(204379);
      return null;
    case 3: 
      localObject2 = paramo.yg();
      if (localObject2 == null)
      {
        paramo = (Throwable)new IllegalStateException("ActiveParent must have a focusedChild".toString());
        AppMethodBeat.o(204379);
        throw paramo;
      }
      if (((androidx.compose.ui.i.o)localObject2).yf() == l.avf)
      {
        localObject2 = a((androidx.compose.ui.i.o)localObject2, paramInt);
        if (localObject2 != null)
        {
          AppMethodBeat.o(204379);
          return localObject2;
        }
      }
      localObject2 = n.c(paramo);
      if (localObject2 == null) {}
      while (localObject1 == null)
      {
        paramo = (Throwable)new IllegalStateException("ActiveParent must have a focusedChild".toString());
        AppMethodBeat.o(204379);
        throw paramo;
        localObject1 = ((androidx.compose.ui.i.o)localObject2).yh();
      }
      paramo = a(paramo.yi(), (g)localObject1, paramInt);
      AppMethodBeat.o(204379);
      return paramo;
    }
    localObject1 = paramo.yi();
    if (((List)localObject1).size() <= 1)
    {
      paramo = (androidx.compose.ui.i.o)kotlin.a.p.oL((List)localObject1);
      AppMethodBeat.o(204379);
      return paramo;
    }
    localObject2 = a.auH;
    if (a.C(paramInt, a.sk())) {}
    for (boolean bool = true; bool; bool = a.C(paramInt, a.sm()))
    {
      paramo = a(paramo.yh());
      paramo = a((List)localObject1, paramo, paramInt);
      AppMethodBeat.o(204379);
      return paramo;
      localObject2 = a.auH;
    }
    localObject2 = a.auH;
    if (a.C(paramInt, a.sj())) {}
    for (bool = true;; bool = a.C(paramInt, a.sl()))
    {
      if (!bool) {
        break label360;
      }
      paramo = b(paramo.yh());
      break;
      localObject2 = a.auH;
    }
    label360:
    paramo = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204379);
    throw paramo;
  }
  
  private static final androidx.compose.ui.i.o a(List<androidx.compose.ui.i.o> paramList, g paramg, int paramInt)
  {
    AppMethodBeat.i(204389);
    Object localObject1 = a.auH;
    int i;
    Object localObject2;
    label57:
    int j;
    g localg;
    if (a.C(paramInt, a.sj()))
    {
      localObject1 = paramg.y(paramg.getWidth() + 1.0F, 0.0F);
      i = 0;
      int k = paramList.size() - 1;
      if (k < 0) {
        break label314;
      }
      localObject2 = localObject1;
      localObject1 = null;
      j = i + 1;
      androidx.compose.ui.i.o localo = (androidx.compose.ui.i.o)paramList.get(i);
      localg = localo.yh();
      if (!a(localg, paramInt, paramg)) {
        break label300;
      }
      if (a(localObject2, paramInt, paramg)) {
        break label248;
      }
      i = 1;
      label103:
      if (i == 0) {
        break label305;
      }
      localObject2 = localg;
      localObject1 = localo;
      label115:
      if (j <= k) {
        break label308;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(204389);
      return localObject1;
      localObject1 = a.auH;
      if (a.C(paramInt, a.sk()))
      {
        localObject1 = paramg.y(-(paramg.getWidth() + 1.0F), 0.0F);
        break;
      }
      localObject1 = a.auH;
      if (a.C(paramInt, a.sl()))
      {
        localObject1 = paramg.y(0.0F, paramg.getHeight() + 1.0F);
        break;
      }
      localObject1 = a.auH;
      if (a.C(paramInt, a.sm()))
      {
        localObject1 = paramg.y(0.0F, -(paramg.getHeight() + 1.0F));
        break;
      }
      paramList = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
      AppMethodBeat.o(204389);
      throw paramList;
      label248:
      if (a(paramg, localg, localObject2, paramInt))
      {
        i = 1;
        break label103;
      }
      if ((!a(paramg, localObject2, localg, paramInt)) && (a(paramInt, paramg, localg) < a(paramInt, paramg, localObject2)))
      {
        i = 1;
        break label103;
      }
      label300:
      i = 0;
      break label103;
      label305:
      break label115;
      label308:
      i = j;
      break label57;
      label314:
      localObject1 = null;
    }
  }
  
  private static final boolean a(g paramg1, int paramInt, g paramg2)
  {
    AppMethodBeat.i(204414);
    a.a locala = a.auH;
    if (a.C(paramInt, a.sj()))
    {
      if (((paramg2.right > paramg1.right) || (paramg2.left >= paramg1.right)) && (paramg2.left > paramg1.left))
      {
        AppMethodBeat.o(204414);
        return true;
      }
      AppMethodBeat.o(204414);
      return false;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sk()))
    {
      if (((paramg2.left < paramg1.left) || (paramg2.right <= paramg1.left)) && (paramg2.right < paramg1.right))
      {
        AppMethodBeat.o(204414);
        return true;
      }
      AppMethodBeat.o(204414);
      return false;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sl()))
    {
      if (((paramg2.bottom > paramg1.bottom) || (paramg2.top >= paramg1.bottom)) && (paramg2.top > paramg1.top))
      {
        AppMethodBeat.o(204414);
        return true;
      }
      AppMethodBeat.o(204414);
      return false;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sm()))
    {
      if (((paramg2.top < paramg1.top) || (paramg2.bottom <= paramg1.top)) && (paramg2.bottom < paramg1.bottom))
      {
        AppMethodBeat.o(204414);
        return true;
      }
      AppMethodBeat.o(204414);
      return false;
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204414);
    throw paramg1;
  }
  
  private static final boolean a(g paramg1, g paramg2, g paramg3, int paramInt)
  {
    AppMethodBeat.i(204396);
    if ((d(paramg3, paramInt, paramg1)) || (!d(paramg2, paramInt, paramg1)))
    {
      AppMethodBeat.o(204396);
      return false;
    }
    if (!e(paramg3, paramInt, paramg1))
    {
      AppMethodBeat.o(204396);
      return true;
    }
    a.a locala = a.auH;
    if (!a.C(paramInt, a.sj()))
    {
      locala = a.auH;
      if (!a.C(paramInt, a.sk())) {}
    }
    else
    {
      AppMethodBeat.o(204396);
      return true;
    }
    if (f(paramg2, paramInt, paramg1) < g(paramg3, paramInt, paramg1))
    {
      AppMethodBeat.o(204396);
      return true;
    }
    AppMethodBeat.o(204396);
    return false;
  }
  
  private static final float b(g paramg1, int paramInt, g paramg2)
  {
    AppMethodBeat.i(204420);
    a.a locala = a.auH;
    float f;
    if (a.C(paramInt, a.sj())) {
      f = paramg2.left - paramg1.right;
    }
    for (;;)
    {
      f = Math.max(0.0F, f);
      AppMethodBeat.o(204420);
      return f;
      locala = a.auH;
      if (a.C(paramInt, a.sk()))
      {
        f = paramg1.left - paramg2.right;
      }
      else
      {
        locala = a.auH;
        if (a.C(paramInt, a.sl()))
        {
          f = paramg2.top - paramg1.bottom;
        }
        else
        {
          locala = a.auH;
          if (!a.C(paramInt, a.sm())) {
            break;
          }
          f = paramg1.top - paramg2.bottom;
        }
      }
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204420);
    throw paramg1;
  }
  
  private static final g b(g paramg)
  {
    AppMethodBeat.i(204408);
    paramg = new g(paramg.right, paramg.bottom, paramg.right, paramg.bottom);
    AppMethodBeat.o(204408);
    return paramg;
  }
  
  private static final float c(g paramg1, int paramInt, g paramg2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(204427);
    a.a locala = a.auH;
    if (a.C(paramInt, a.sj())) {}
    float f1;
    float f2;
    float f3;
    float f4;
    for (boolean bool1 = true; bool1; bool1 = a.C(paramInt, a.sk()))
    {
      f1 = paramg2.top;
      f2 = paramg2.getHeight() / 2.0F;
      f3 = paramg1.top;
      f4 = paramg1.getHeight() / 2.0F;
      AppMethodBeat.o(204427);
      return f1 + f2 - (f3 + f4);
      locala = a.auH;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sl())) {}
    for (bool1 = bool2; bool1; bool1 = a.C(paramInt, a.sm()))
    {
      f1 = paramg2.left;
      f2 = paramg2.getWidth() / 2.0F;
      f3 = paramg1.left;
      f4 = paramg1.getWidth() / 2.0F;
      AppMethodBeat.o(204427);
      return f1 + f2 - (f3 + f4);
      locala = a.auH;
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204427);
    throw paramg1;
  }
  
  private static final boolean d(g paramg1, int paramInt, g paramg2)
  {
    AppMethodBeat.i(204435);
    a.a locala = a.auH;
    boolean bool;
    if (a.C(paramInt, a.sj())) {
      bool = true;
    }
    while (bool) {
      if ((paramg1.bottom > paramg2.top) && (paramg1.top < paramg2.bottom))
      {
        AppMethodBeat.o(204435);
        return true;
        locala = a.auH;
        bool = a.C(paramInt, a.sk());
      }
      else
      {
        AppMethodBeat.o(204435);
        return false;
      }
    }
    locala = a.auH;
    if (a.C(paramInt, a.sl())) {
      bool = true;
    }
    while (bool) {
      if ((paramg1.right > paramg2.left) && (paramg1.left < paramg2.right))
      {
        AppMethodBeat.o(204435);
        return true;
        locala = a.auH;
        bool = a.C(paramInt, a.sm());
      }
      else
      {
        AppMethodBeat.o(204435);
        return false;
      }
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204435);
    throw paramg1;
  }
  
  private static final boolean e(g paramg1, int paramInt, g paramg2)
  {
    AppMethodBeat.i(204436);
    a.a locala = a.auH;
    if (a.C(paramInt, a.sj()))
    {
      if (paramg2.left >= paramg1.right)
      {
        AppMethodBeat.o(204436);
        return true;
      }
      AppMethodBeat.o(204436);
      return false;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sk()))
    {
      if (paramg2.right <= paramg1.left)
      {
        AppMethodBeat.o(204436);
        return true;
      }
      AppMethodBeat.o(204436);
      return false;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sl()))
    {
      if (paramg2.top >= paramg1.bottom)
      {
        AppMethodBeat.o(204436);
        return true;
      }
      AppMethodBeat.o(204436);
      return false;
    }
    locala = a.auH;
    if (a.C(paramInt, a.sm()))
    {
      if (paramg2.bottom <= paramg1.top)
      {
        AppMethodBeat.o(204436);
        return true;
      }
      AppMethodBeat.o(204436);
      return false;
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204436);
    throw paramg1;
  }
  
  private static final float f(g paramg1, int paramInt, g paramg2)
  {
    AppMethodBeat.i(204438);
    a.a locala = a.auH;
    float f;
    if (a.C(paramInt, a.sj())) {
      f = paramg2.left - paramg1.right;
    }
    for (;;)
    {
      f = Math.max(0.0F, f);
      AppMethodBeat.o(204438);
      return f;
      locala = a.auH;
      if (a.C(paramInt, a.sk()))
      {
        f = paramg1.left - paramg2.right;
      }
      else
      {
        locala = a.auH;
        if (a.C(paramInt, a.sl()))
        {
          f = paramg2.top - paramg1.bottom;
        }
        else
        {
          locala = a.auH;
          if (!a.C(paramInt, a.sm())) {
            break;
          }
          f = paramg1.top - paramg2.bottom;
        }
      }
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204438);
    throw paramg1;
  }
  
  private static final float g(g paramg1, int paramInt, g paramg2)
  {
    AppMethodBeat.i(204441);
    a.a locala = a.auH;
    float f;
    if (a.C(paramInt, a.sj())) {
      f = paramg2.left - paramg1.left;
    }
    for (;;)
    {
      f = Math.max(1.0F, f);
      AppMethodBeat.o(204441);
      return f;
      locala = a.auH;
      if (a.C(paramInt, a.sk()))
      {
        f = paramg1.right - paramg2.right;
      }
      else
      {
        locala = a.auH;
        if (a.C(paramInt, a.sl()))
        {
          f = paramg2.top - paramg1.top;
        }
        else
        {
          locala = a.auH;
          if (!a.C(paramInt, a.sm())) {
            break;
          }
          f = paramg1.bottom - paramg2.bottom;
        }
      }
    }
    paramg1 = (Throwable)new IllegalStateException("This function should only be used for 2-D focus search".toString());
    AppMethodBeat.o(204441);
    throw paramg1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.o
 * JD-Core Version:    0.7.0.1
 */