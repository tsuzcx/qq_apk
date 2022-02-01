package com.tencent.mm.plugin.hld.keyboard.selfdraw.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "bgPaint", "Landroid/graphics/Paint;", "bgRect", "Landroid/graphics/RectF;", "getKeyboard", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "drawBackground", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "drawButton", "getType", "", "plugin-hld_release"})
public abstract class b
{
  private final RectF DAS;
  private final KeyboardView DzB;
  private final Paint opo;
  
  public b(KeyboardView paramKeyboardView)
  {
    this.DzB = paramKeyboardView;
    this.opo = new Paint();
    this.DAS = new RectF();
  }
  
  public abstract void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb);
  
  public final void b(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    p.k(paramCanvas, "canvas");
    p.k(paramb, "button");
    int i;
    RectF localRectF;
    if (paramb.shadowColor != 0)
    {
      i = paramb.shadowColor;
      this.opo.setColor(i);
      paramCanvas.save();
      localRectF = this.DAS;
      localRectF.set(paramb.DzD);
      localRectF.offset(0.0F, paramb.DzK / 2.0F);
      paramCanvas.clipRect(localRectF);
      localRectF = this.DAS;
      localRectF.set(paramb.DzD);
      localRectF.offset(0.0F, paramb.DzK / 2.0F);
      localRectF.top = (localRectF.bottom - paramb.DzJ * 2);
      paramCanvas.drawRoundRect(localRectF, paramb.DzJ, paramb.DzJ, this.opo);
      paramCanvas.restore();
    }
    if (paramb.bgColor != 0)
    {
      i = paramb.bgColor;
      this.opo.setColor(i);
      localRectF = this.DAS;
      localRectF.set(paramb.DzD);
      localRectF.offset(0.0F, -paramb.DzK / 2.0F);
      paramCanvas.drawRoundRect(localRectF, paramb.DzJ, paramb.DzJ, this.opo);
    }
    if ((paramb.DzM != 0) && (p.h(paramb.sSq, "press")))
    {
      i = paramb.DzM;
      this.opo.setColor(i);
      localRectF = this.DAS;
      localRectF.set(paramb.DzD);
      localRectF.offset(0.0F, -paramb.DzK / 2.0F);
      paramCanvas.drawRoundRect(localRectF, paramb.DzJ, paramb.DzJ, this.opo);
    }
  }
  
  public final KeyboardView eDR()
  {
    return this.DzB;
  }
  
  public abstract String getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b
 * JD-Core Version:    0.7.0.1
 */