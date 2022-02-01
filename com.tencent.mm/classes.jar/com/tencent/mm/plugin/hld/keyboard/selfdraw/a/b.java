package com.tencent.mm.plugin.hld.keyboard.selfdraw.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "bgPaint", "Landroid/graphics/Paint;", "bgRect", "Landroid/graphics/RectF;", "getKeyboard", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "drawBackground", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "drawButton", "getType", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  private final KeyboardView JsC;
  private final RectF JtS;
  private final Paint rsW;
  
  public b(KeyboardView paramKeyboardView)
  {
    this.JsC = paramKeyboardView;
    paramKeyboardView = new Paint();
    ah localah = ah.aiuX;
    this.rsW = paramKeyboardView;
    this.JtS = new RectF();
  }
  
  public abstract void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb);
  
  public final void b(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    s.u(paramCanvas, "canvas");
    s.u(paramb, "button");
    int i;
    RectF localRectF;
    ah localah;
    if (paramb.shadowColor != 0)
    {
      i = paramb.shadowColor;
      this.rsW.setColor(i);
      paramCanvas.save();
      localRectF = this.JtS;
      localRectF.set(paramb.JsG);
      localRectF.offset(0.0F, paramb.JsN / 2.0F);
      localah = ah.aiuX;
      paramCanvas.clipRect(localRectF);
      localRectF = this.JtS;
      localRectF.set(paramb.JsG);
      localRectF.offset(0.0F, paramb.JsN / 2.0F);
      localRectF.top = (localRectF.bottom - paramb.JsM * 2);
      localah = ah.aiuX;
      paramCanvas.drawRoundRect(localRectF, paramb.JsM, paramb.JsM, this.rsW);
      paramCanvas.restore();
    }
    if (paramb.bgColor != 0)
    {
      i = paramb.bgColor;
      this.rsW.setColor(i);
      localRectF = this.JtS;
      localRectF.set(paramb.JsG);
      localRectF.offset(0.0F, -paramb.JsN / 2.0F);
      localah = ah.aiuX;
      paramCanvas.drawRoundRect(localRectF, paramb.JsM, paramb.JsM, this.rsW);
    }
    if ((paramb.JsP != 0) && (s.p(paramb.vXL, "press")))
    {
      i = paramb.JsP;
      this.rsW.setColor(i);
      localRectF = this.JtS;
      localRectF.set(paramb.JsG);
      localRectF.offset(0.0F, -paramb.JsN / 2.0F);
      localah = ah.aiuX;
      paramCanvas.drawRoundRect(localRectF, paramb.JsM, paramb.JsM, this.rsW);
    }
  }
  
  public final KeyboardView fLU()
  {
    return this.JsC;
  }
  
  public abstract String getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b
 * JD-Core Version:    0.7.0.1
 */