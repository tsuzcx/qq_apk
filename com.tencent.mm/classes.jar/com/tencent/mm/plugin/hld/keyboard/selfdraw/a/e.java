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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/ImageDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "rectTemp", "Landroid/graphics/Rect;", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "drawDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "iconRect", "getType", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
{
  private final Rect Jue;
  
  public e(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(313077);
    this.Jue = new Rect();
    AppMethodBeat.o(313077);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(313093);
    s.u(paramCanvas, "canvas");
    s.u(paramb, "button");
    b(paramCanvas, paramb);
    if ((paramb.JsL != 0) && (paramb.iconWidth != 0) && (paramb.iconHeight != 0))
    {
      Object localObject2 = fLU().getContext().getResources().getDrawable(paramb.JsL);
      float f1 = ((Drawable)localObject2).getMinimumWidth() / ((Drawable)localObject2).getMinimumHeight();
      Object localObject1;
      float f2;
      if (f1 > 1.0F)
      {
        localObject1 = new Rect();
        ((Rect)localObject1).left = (paramb.JsG.centerX() - paramb.iconWidth / 2);
        ((Rect)localObject1).right = (paramb.JsG.centerX() + paramb.iconWidth / 2);
        ((Rect)localObject1).top = ((int)(paramb.JsG.centerY() - paramb.iconHeight / 2.0F / f1));
        f2 = paramb.JsG.centerY();
        ((Rect)localObject1).bottom = ((int)(paramb.iconHeight / 2.0F / f1 + f2));
      }
      for (paramb = (com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1;; paramb = (com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1)
      {
        localObject1 = ((Drawable)localObject2).mutate();
        ((Drawable)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(fLU().getResources().getColor(a.c.FG_0), PorterDuff.Mode.SRC_ATOP));
        ((Drawable)localObject1).setAlpha(255);
        localObject2 = ah.aiuX;
        s.s(localObject1, "drawable.mutate().also {…255\n                    }");
        if (!(localObject1 instanceof c)) {
          break;
        }
        localObject2 = Bitmap.createBitmap(paramb.width(), paramb.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject2);
        Picture localPicture = ((c)localObject1).jeq();
        Rect localRect = this.Jue;
        localRect.set(paramb);
        localRect.offsetTo(0, 0);
        ah localah = ah.aiuX;
        localCanvas.drawPicture(localPicture, localRect);
        ((c)localObject1).bb((Bitmap)localObject2);
        ((c)localObject1).setBounds(paramb);
        ((Drawable)localObject1).draw(paramCanvas);
        AppMethodBeat.o(313093);
        return;
        localObject1 = new Rect();
        ((Rect)localObject1).left = ((int)(paramb.JsG.centerX() - paramb.iconWidth / 2.0F * f1));
        f2 = paramb.JsG.centerX();
        ((Rect)localObject1).right = ((int)(f1 * (paramb.iconWidth / 2.0F) + f2));
        ((Rect)localObject1).top = (paramb.JsG.centerY() - paramb.iconHeight / 2);
        ((Rect)localObject1).bottom = (paramb.JsG.centerY() + paramb.iconHeight / 2);
      }
      ((Drawable)localObject1).setBounds(paramb);
      ((Drawable)localObject1).draw(paramCanvas);
    }
    AppMethodBeat.o(313093);
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