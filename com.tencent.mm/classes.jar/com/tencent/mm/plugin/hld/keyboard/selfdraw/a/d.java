package com.tencent.mm.plugin.hld.keyboard.selfdraw.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/FloatDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "attr", "", "getAttr", "()[I", "floatTextPaint", "Landroid/graphics/Paint;", "mainTextPaint", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "", "setStyle", "plugin-hld_release"})
public final class d
  extends b
{
  private final Paint DBc;
  private final Paint DBd;
  private final int[] DBe;
  
  public d(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(214378);
    paramKeyboardView = new Paint();
    paramKeyboardView.setTextAlign(Paint.Align.CENTER);
    paramKeyboardView.setAntiAlias(true);
    this.DBc = paramKeyboardView;
    paramKeyboardView = new Paint();
    paramKeyboardView.setTextAlign(Paint.Align.CENTER);
    paramKeyboardView.setAntiAlias(true);
    this.DBd = paramKeyboardView;
    this.DBe = new int[] { a.b.textSize, a.b.textColor };
    AppMethodBeat.o(214378);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(214377);
    p.k(paramCanvas, "canvas");
    p.k(paramb, "button");
    b(paramCanvas, paramb);
    Paint localPaint = this.DBc;
    localPaint.setTextSize(paramb.DzE);
    localPaint.setColor(paramb.DzF);
    localPaint = this.DBd;
    localPaint.setTextSize(paramb.DzG);
    localPaint.setColor(paramb.DzH);
    float f1 = paramb.DzD.centerX();
    float f2 = paramb.DzD.centerY();
    float f3 = this.DBc.getTextSize() / 3.0F;
    paramCanvas.drawText(paramb.mainText, f1, f2 + f3, this.DBc);
    f1 = paramb.DzD.centerX();
    f2 = paramb.DzD.top;
    f3 = this.DBd.getTextSize();
    paramCanvas.drawText(paramb.floatText, f1, f2 + f3, this.DBd);
    AppMethodBeat.o(214377);
  }
  
  public final String getType()
  {
    return "floatType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.d
 * JD-Core Version:    0.7.0.1
 */