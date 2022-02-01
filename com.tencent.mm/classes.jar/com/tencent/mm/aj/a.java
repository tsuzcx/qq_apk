package com.tencent.mm.aj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.z;
import androidx.compose.ui.platform.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"A", "Landroidx/compose/ui/unit/Dp;", "", "getA$annotations", "(D)V", "getA", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "color", "Landroidx/compose/ui/graphics/Color;", "getColor$annotations", "getColor", "(ILandroidx/compose/runtime/Composer;I)J", "dimen", "getDimen$annotations", "getDimen", "drawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDrawable", "(ILandroidx/compose/runtime/Composer;I)Landroid/graphics/drawable/Drawable;", "drawablePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "getDrawablePainter", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "imageVector", "getImageVector", "pxToDp", "getPxToDp$annotations", "getPxToDp", "(ILandroidx/compose/runtime/Composer;I)F", "str", "", "getStr$annotations", "getStr", "(I)Ljava/lang/String;", "toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "getToAndroidRect$annotations", "(Landroidx/compose/ui/geometry/Rect;)V", "getToAndroidRect", "(Landroidx/compose/ui/geometry/Rect;)Landroid/graphics/Rect;", "toPx", "getToPx-0680j_4$annotations", "getToPx-0680j_4", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "getToSp$annotations", "getToSp", "(FLandroidx/compose/runtime/Composer;I)J", "colorResource", "id", "context", "Landroid/content/Context;", "(ILandroid/content/Context;)J", "colorDrawablePainter", "colorDrawablePainter-RPmYEkk", "(IJLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroid/content/Context;)F", "string", "formatArgs", "", "", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final androidx.compose.ui.e.c.c a(int paramInt, long paramLong, h paramh)
  {
    AppMethodBeat.i(238747);
    paramh.bx(-61520699);
    Context localContext = (Context)paramh.a((p)j.yJ());
    Object localObject = z.ad(paramLong);
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(Integer.valueOf(paramInt));
    boolean bool2 = paramh.G(localObject);
    localObject = paramh.or();
    if (!(bool2 | bool1))
    {
      h.a locala = h.alD;
      if (localObject != h.a.ox()) {}
    }
    else
    {
      localObject = bb.m(localContext, paramInt, ab.ai(paramLong));
      s.s(localObject, "getColorDrawable(\n      … color.toArgb()\n        )");
      localObject = com.tencent.mm.aj.a.c.C((Drawable)localObject);
      paramh.F(localObject);
    }
    for (;;)
    {
      paramh.od();
      localObject = (androidx.compose.ui.e.c.c)localObject;
      paramh.od();
      AppMethodBeat.o(238747);
      return localObject;
    }
  }
  
  public static final androidx.compose.ui.e.c.c a(int paramInt, h paramh)
  {
    AppMethodBeat.i(238739);
    paramh.bx(1945913784);
    Resources localResources = ((Context)paramh.a((p)j.yJ())).getResources();
    paramh.bx(-3686930);
    boolean bool = paramh.G(Integer.valueOf(paramInt));
    Object localObject2 = paramh.or();
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = localResources.getDrawable(paramInt);
      s.s(localObject1, "resource.getDrawable(this)");
      localObject1 = com.tencent.mm.aj.a.c.C((Drawable)localObject1);
      paramh.F(localObject1);
    }
    paramh.od();
    Object localObject1 = (androidx.compose.ui.e.c.c)localObject1;
    paramh.od();
    AppMethodBeat.o(238739);
    return localObject1;
  }
  
  public static final long b(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(238722);
    s.u(paramContext, "context");
    long l = c(paramInt, paramContext);
    AppMethodBeat.o(238722);
    return l;
  }
  
  public static final long c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(238754);
    s.u(paramContext, "context");
    if (Build.VERSION.SDK_INT >= 23)
    {
      l = ab.cH(paramContext.getResources().getColor(paramInt, paramContext.getTheme()));
      AppMethodBeat.o(238754);
      return l;
    }
    long l = ab.cH(paramContext.getResources().getColor(paramInt));
    AppMethodBeat.o(238754);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a
 * JD-Core Version:    0.7.0.1
 */