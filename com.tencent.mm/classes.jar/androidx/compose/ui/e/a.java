package androidx.compose.ui.e;

import android.graphics.BlendMode;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final PorterDuff.Mode cx(int paramInt)
  {
    AppMethodBeat.i(205995);
    Object localObject = p.avT;
    if (p.C(paramInt, p.sR()))
    {
      localObject = PorterDuff.Mode.CLEAR;
      AppMethodBeat.o(205995);
      return localObject;
    }
    localObject = p.avT;
    if (p.C(paramInt, p.sS()))
    {
      localObject = PorterDuff.Mode.SRC;
      AppMethodBeat.o(205995);
      return localObject;
    }
    localObject = p.avT;
    if (p.C(paramInt, p.sT()))
    {
      localObject = PorterDuff.Mode.DST;
      AppMethodBeat.o(205995);
      return localObject;
    }
    localObject = p.avT;
    if (!p.C(paramInt, p.sU()))
    {
      localObject = p.avT;
      if (p.C(paramInt, p.sV()))
      {
        localObject = PorterDuff.Mode.DST_OVER;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sW()))
      {
        localObject = PorterDuff.Mode.SRC_IN;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sX()))
      {
        localObject = PorterDuff.Mode.DST_IN;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sY()))
      {
        localObject = PorterDuff.Mode.SRC_OUT;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sZ()))
      {
        localObject = PorterDuff.Mode.DST_OUT;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.ta()))
      {
        localObject = PorterDuff.Mode.SRC_ATOP;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tb()))
      {
        localObject = PorterDuff.Mode.DST_ATOP;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tc()))
      {
        localObject = PorterDuff.Mode.XOR;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.td()))
      {
        localObject = PorterDuff.Mode.ADD;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tf()))
      {
        localObject = PorterDuff.Mode.SCREEN;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tg()))
      {
        localObject = PorterDuff.Mode.OVERLAY;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.th()))
      {
        localObject = PorterDuff.Mode.DARKEN;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.ti()))
      {
        localObject = PorterDuff.Mode.LIGHTEN;
        AppMethodBeat.o(205995);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.te()))
      {
        localObject = PorterDuff.Mode.MULTIPLY;
        AppMethodBeat.o(205995);
        return localObject;
      }
    }
    localObject = PorterDuff.Mode.SRC_OVER;
    AppMethodBeat.o(205995);
    return localObject;
  }
  
  public static final BlendMode cy(int paramInt)
  {
    AppMethodBeat.i(206003);
    Object localObject = p.avT;
    if (p.C(paramInt, p.sR()))
    {
      localObject = BlendMode.CLEAR;
      AppMethodBeat.o(206003);
      return localObject;
    }
    localObject = p.avT;
    if (p.C(paramInt, p.sS()))
    {
      localObject = BlendMode.SRC;
      AppMethodBeat.o(206003);
      return localObject;
    }
    localObject = p.avT;
    if (p.C(paramInt, p.sT()))
    {
      localObject = BlendMode.DST;
      AppMethodBeat.o(206003);
      return localObject;
    }
    localObject = p.avT;
    if (!p.C(paramInt, p.sU()))
    {
      localObject = p.avT;
      if (p.C(paramInt, p.sV()))
      {
        localObject = BlendMode.DST_OVER;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sW()))
      {
        localObject = BlendMode.SRC_IN;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sX()))
      {
        localObject = BlendMode.DST_IN;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sY()))
      {
        localObject = BlendMode.SRC_OUT;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.sZ()))
      {
        localObject = BlendMode.DST_OUT;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.ta()))
      {
        localObject = BlendMode.SRC_ATOP;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tb()))
      {
        localObject = BlendMode.DST_ATOP;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tc()))
      {
        localObject = BlendMode.XOR;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.td()))
      {
        localObject = BlendMode.PLUS;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.te()))
      {
        localObject = BlendMode.MODULATE;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tf()))
      {
        localObject = BlendMode.SCREEN;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tg()))
      {
        localObject = BlendMode.OVERLAY;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.th()))
      {
        localObject = BlendMode.DARKEN;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.ti()))
      {
        localObject = BlendMode.LIGHTEN;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tj()))
      {
        localObject = BlendMode.COLOR_DODGE;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tk()))
      {
        localObject = BlendMode.COLOR_BURN;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tl()))
      {
        localObject = BlendMode.HARD_LIGHT;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tm()))
      {
        localObject = BlendMode.SOFT_LIGHT;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tn()))
      {
        localObject = BlendMode.DIFFERENCE;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.to()))
      {
        localObject = BlendMode.EXCLUSION;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tp()))
      {
        localObject = BlendMode.MULTIPLY;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tq()))
      {
        localObject = BlendMode.HUE;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tr()))
      {
        localObject = BlendMode.SATURATION;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.ts()))
      {
        localObject = BlendMode.COLOR;
        AppMethodBeat.o(206003);
        return localObject;
      }
      localObject = p.avT;
      if (p.C(paramInt, p.tt()))
      {
        localObject = BlendMode.LUMINOSITY;
        AppMethodBeat.o(206003);
        return localObject;
      }
    }
    localObject = BlendMode.SRC_OVER;
    AppMethodBeat.o(206003);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.e.a
 * JD-Core Version:    0.7.0.1
 */