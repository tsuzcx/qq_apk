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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/NormalDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "attr", "", "getAttr", "()[I", "textPaint", "Landroid/graphics/Paint;", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "", "setStyle", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b
{
  private final int[] Jud;
  private final Paint dZu;
  
  public g(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(313085);
    paramKeyboardView = new Paint();
    paramKeyboardView.setTextAlign(Paint.Align.CENTER);
    paramKeyboardView.setAntiAlias(true);
    ah localah = ah.aiuX;
    this.dZu = paramKeyboardView;
    this.Jud = new int[] { a.b.textSize, a.b.textColor };
    AppMethodBeat.o(313085);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(313092);
    s.u(paramCanvas, "canvas");
    s.u(paramb, "button");
    b(paramCanvas, paramb);
    Paint localPaint = this.dZu;
    localPaint.setTextSize(paramb.JsH);
    localPaint.setColor(paramb.JsI);
    float f1 = paramb.JsG.centerX();
    float f2 = paramb.JsG.centerY();
    float f3 = this.dZu.getTextSize() / 3.0F;
    paramCanvas.drawText(paramb.mainText, f1, f2 + f3, this.dZu);
    AppMethodBeat.o(313092);
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