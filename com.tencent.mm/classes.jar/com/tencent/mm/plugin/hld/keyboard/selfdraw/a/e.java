package com.tencent.mm.plugin.hld.keyboard.selfdraw.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Picture;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.svg.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/ImageDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "rectTemp", "Landroid/graphics/Rect;", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "drawDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "iconRect", "getType", "", "plugin-hld_release"})
public final class e
  extends b
{
  private final Rect DBf;
  
  public e(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(210686);
    this.DBf = new Rect();
    AppMethodBeat.o(210686);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(210684);
    p.k(paramCanvas, "canvas");
    p.k(paramb, "button");
    b(paramCanvas, paramb);
    if ((paramb.DzI != 0) && (paramb.iconWidth != 0) && (paramb.iconHeight != 0))
    {
      Object localObject1 = eDR().getContext();
      p.j(localObject1, "keyboard.context");
      Object localObject2 = ((Context)localObject1).getResources().getDrawable(paramb.DzI);
      p.j(localObject2, "drawable");
      float f1 = ((Drawable)localObject2).getMinimumWidth() / ((Drawable)localObject2).getMinimumHeight();
      float f2;
      if (f1 > 1.0F)
      {
        localObject1 = new Rect();
        ((Rect)localObject1).left = (paramb.DzD.centerX() - paramb.iconWidth / 2);
        ((Rect)localObject1).right = (paramb.DzD.centerX() + paramb.iconWidth / 2);
        ((Rect)localObject1).top = ((int)(paramb.DzD.centerY() - paramb.iconHeight / 2.0F / f1));
        f2 = paramb.DzD.centerY();
        ((Rect)localObject1).bottom = ((int)(paramb.iconHeight / 2.0F / f1 + f2));
      }
      for (paramb = (com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1;; paramb = (com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1)
      {
        localObject1 = ((Drawable)localObject2).mutate();
        int i = eDR().getResources().getColor(a.c.FG_0);
        p.j(localObject1, "it");
        ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        ((Drawable)localObject1).setAlpha(255);
        p.j(localObject1, "drawable.mutate().also {…255\n                    }");
        if (!(localObject1 instanceof c)) {
          break;
        }
        localObject2 = Bitmap.createBitmap(paramb.width(), paramb.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject2);
        Picture localPicture = ((c)localObject1).hCk();
        Rect localRect = this.DBf;
        localRect.set(paramb);
        localRect.offsetTo(0, 0);
        localCanvas.drawPicture(localPicture, localRect);
        ((c)localObject1).aI((Bitmap)localObject2);
        ((c)localObject1).setBounds(paramb);
        ((Drawable)localObject1).draw(paramCanvas);
        AppMethodBeat.o(210684);
        return;
        localObject1 = new Rect();
        ((Rect)localObject1).left = ((int)(paramb.DzD.centerX() - paramb.iconWidth / 2.0F * f1));
        f2 = paramb.DzD.centerX();
        ((Rect)localObject1).right = ((int)(f1 * (paramb.iconWidth / 2.0F) + f2));
        ((Rect)localObject1).top = (paramb.DzD.centerY() - paramb.iconHeight / 2);
        ((Rect)localObject1).bottom = (paramb.DzD.centerY() + paramb.iconHeight / 2);
      }
      ((Drawable)localObject1).setBounds(paramb);
      ((Drawable)localObject1).draw(paramCanvas);
    }
    AppMethodBeat.o(210684);
  }
  
  public final String getType()
  {
    return "imageType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.e
 * JD-Core Version:    0.7.0.1
 */