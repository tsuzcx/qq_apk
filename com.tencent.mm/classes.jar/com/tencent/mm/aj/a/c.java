package com.tencent.mm.aj.a;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "MAIN_HANDLER$delegate", "Lkotlin/Lazy;", "toAnimationPainter", "Lcom/tencent/mm/mm_compose/painter/AnimationPainter;", "Landroid/graphics/drawable/AnimationDrawable;", "toPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroid/graphics/drawable/Drawable;", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final j cEX;
  
  static
  {
    AppMethodBeat.i(238737);
    cEX = k.a(o.aiuH, (kotlin.g.a.a)c.a.ogq);
    AppMethodBeat.o(238737);
  }
  
  public static final androidx.compose.ui.e.c.c C(Drawable paramDrawable)
  {
    AppMethodBeat.i(238724);
    s.u(paramDrawable, "<this>");
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      s.s(paramDrawable, "bitmap");
      paramDrawable = (androidx.compose.ui.e.c.c)new androidx.compose.ui.e.c.a(f.h(paramDrawable));
      AppMethodBeat.o(238724);
      return paramDrawable;
    }
    if ((paramDrawable instanceof ColorDrawable))
    {
      paramDrawable = (androidx.compose.ui.e.c.c)new androidx.compose.ui.e.c.b(ab.cH(((ColorDrawable)paramDrawable).getColor()), (byte)0);
      AppMethodBeat.o(238724);
      return paramDrawable;
    }
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramDrawable = paramDrawable.mutate();
      s.s(paramDrawable, "mutate()");
      paramDrawable = (androidx.compose.ui.e.c.c)new a(paramDrawable);
      AppMethodBeat.o(238724);
      return paramDrawable;
    }
    paramDrawable = paramDrawable.mutate();
    s.s(paramDrawable, "mutate()");
    paramDrawable = (androidx.compose.ui.e.c.c)new b(paramDrawable);
    AppMethodBeat.o(238724);
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.c
 * JD-Core Version:    0.7.0.1
 */