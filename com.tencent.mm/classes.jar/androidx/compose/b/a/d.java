package androidx.compose.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.b.c;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.z;
import androidx.compose.ui.platform.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e
{
  private d(boolean paramBoolean, float paramFloat, bm<z> parambm)
  {
    super(paramBoolean, paramFloat, parambm, (byte)0);
  }
  
  public final l a(c paramc, boolean paramBoolean, float paramFloat, bm<z> parambm, bm<f> parambm1, h paramh)
  {
    AppMethodBeat.i(201836);
    s.u(paramc, "interactionSource");
    s.u(parambm, "color");
    s.u(parambm1, "rippleAlpha");
    paramh.bx(1643266907);
    paramh.bx(601470064);
    Object localObject2;
    for (Object localObject1 = paramh.a((p)j.yL()); !(localObject1 instanceof ViewGroup); localObject1 = localObject2)
    {
      localObject2 = ((View)localObject1).getParent();
      if (!(localObject2 instanceof View))
      {
        paramc = (Throwable)new IllegalArgumentException(("Couldn't find a valid parent for " + localObject1 + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
        AppMethodBeat.o(201836);
        throw paramc;
      }
      s.s(localObject2, "parent");
    }
    ViewGroup localViewGroup = (ViewGroup)localObject1;
    paramh.od();
    boolean bool1;
    boolean bool2;
    if (localViewGroup.isInEditMode())
    {
      paramh.bx(1643267309);
      paramh.bx(-3686552);
      bool1 = paramh.G(paramc);
      bool2 = paramh.G(this);
      localObject1 = paramh.or();
      if (!(bool2 | bool1))
      {
        paramc = h.alD;
        paramc = (c)localObject1;
        if (localObject1 != h.a.ox()) {}
      }
      else
      {
        paramc = new b(paramBoolean, paramFloat, parambm, parambm1, (byte)0);
        paramh.F(paramc);
      }
      paramh.od();
      paramc = (b)paramc;
      paramh.od();
      paramh.od();
      paramc = (l)paramc;
      AppMethodBeat.o(201836);
      return paramc;
    }
    paramh.bx(1643267473);
    paramh.od();
    int i = 0;
    int k = localViewGroup.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localObject1 = localViewGroup.getChildAt(i);
      if ((localObject1 instanceof i)) {}
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localViewGroup.getContext();
          s.s(localObject1, "view.context");
          localObject2 = new i((Context)localObject1);
          localViewGroup.addView((View)localObject2);
          localObject1 = ah.aiuX;
        }
        paramh.bx(-3686095);
        bool1 = paramh.G(paramc);
        bool2 = paramh.G(this);
        boolean bool3 = paramh.G(localObject2);
        localObject1 = paramh.or();
        if (!(bool3 | bool1 | bool2))
        {
          paramc = h.alD;
          paramc = (c)localObject1;
          if (localObject1 != h.a.ox()) {}
        }
        else
        {
          paramc = new a(paramBoolean, paramFloat, parambm, parambm1, (i)localObject2, (byte)0);
          paramh.F(paramc);
        }
        paramh.od();
        paramc = (a)paramc;
        paramh.od();
        paramc = (l)paramc;
        AppMethodBeat.o(201836);
        return paramc;
        if (j < k) {
          break;
        }
        localObject1 = null;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.d
 * JD-Core Version:    0.7.0.1
 */