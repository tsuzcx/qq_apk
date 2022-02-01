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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/NormalDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "attr", "", "getAttr", "()[I", "textPaint", "Landroid/graphics/Paint;", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "", "setStyle", "plugin-hld_release"})
public final class g
  extends b
{
  private final int[] DBe;
  private final Paint ciV;
  
  public g(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(210883);
    paramKeyboardView = new Paint();
    paramKeyboardView.setTextAlign(Paint.Align.CENTER);
    paramKeyboardView.setAntiAlias(true);
    this.ciV = paramKeyboardView;
    this.DBe = new int[] { a.b.textSize, a.b.textColor };
    AppMethodBeat.o(210883);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(210879);
    p.k(paramCanvas, "canvas");
    p.k(paramb, "button");
    b(paramCanvas, paramb);
    Paint localPaint = this.ciV;
    localPaint.setTextSize(paramb.DzE);
    localPaint.setColor(paramb.DzF);
    float f1 = paramb.DzD.centerX();
    float f2 = paramb.DzD.centerY();
    float f3 = this.ciV.getTextSize() / 3.0F;
    paramCanvas.drawText(paramb.mainText, f1, f2 + f3, this.ciV);
    AppMethodBeat.o(210879);
  }
  
  public final String getType()
  {
    return "normalType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.g
 * JD-Core Version:    0.7.0.1
 */