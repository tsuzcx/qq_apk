package com.tencent.mm.plugin.hld.keyboard.selfdraw.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/FloatDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "attr", "", "getAttr", "()[I", "floatTextPaint", "Landroid/graphics/Paint;", "mainTextPaint", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "", "setStyle", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  private final Paint Jub;
  private final Paint Juc;
  private final int[] Jud;
  
  public d(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(313052);
    paramKeyboardView = new Paint();
    paramKeyboardView.setTextAlign(Paint.Align.CENTER);
    paramKeyboardView.setAntiAlias(true);
    ah localah = ah.aiuX;
    this.Jub = paramKeyboardView;
    paramKeyboardView = new Paint();
    paramKeyboardView.setTextAlign(Paint.Align.CENTER);
    paramKeyboardView.setAntiAlias(true);
    localah = ah.aiuX;
    this.Juc = paramKeyboardView;
    this.Jud = new int[] { a.b.textSize, a.b.textColor };
    AppMethodBeat.o(313052);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(313066);
    s.u(paramCanvas, "canvas");
    s.u(paramb, "button");
    b(paramCanvas, paramb);
    Paint localPaint = this.Jub;
    localPaint.setTextSize(paramb.JsH);
    localPaint.setColor(paramb.JsI);
    localPaint = this.Juc;
    localPaint.setTextSize(paramb.JsJ);
    localPaint.setColor(paramb.JsK);
    float f1 = paramb.JsG.centerX();
    float f2 = paramb.JsG.centerY();
    float f3 = this.Jub.getTextSize() / 3.0F;
    paramCanvas.drawText(paramb.mainText, f1, f2 + f3, this.Jub);
    f1 = paramb.JsG.centerX();
    f2 = paramb.JsG.top;
    f3 = this.Juc.getTextSize();
    paramCanvas.drawText(paramb.floatText, f1, f2 + f3, this.Juc);
    AppMethodBeat.o(313066);
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