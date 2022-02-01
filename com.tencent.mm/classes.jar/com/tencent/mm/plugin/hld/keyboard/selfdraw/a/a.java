package com.tencent.mm.plugin.hld.keyboard.selfdraw.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/ChineseSwitchDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "yinPaint", "Landroid/graphics/Paint;", "yinPercentX", "", "yinPercentY", "yinText", "", "yinTextSize", "", "zhongPaint", "zhongPercentX", "zhongPercentY", "zhongText", "zhongTextSize", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private final int JtI;
  private final int JtJ;
  private final double JtK;
  private final double JtL;
  private final double JtM;
  private final double JtN;
  private final String JtO;
  private final String JtP;
  private final Paint JtQ;
  private final Paint JtR;
  
  public a(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(313106);
    this.JtI = 16;
    this.JtJ = 10;
    this.JtK = 0.3289D;
    this.JtL = 0.6033D;
    this.JtM = 0.6828D;
    this.JtN = 0.7257D;
    this.JtO = "中";
    this.JtP = "/英";
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    localPaint.setColor(paramKeyboardView.getContext().getResources().getColor(a.c.black_text_color));
    localPaint.setTextSize(this.JtI * paramKeyboardView.getContext().getResources().getDisplayMetrics().scaledDensity);
    ah localah = ah.aiuX;
    this.JtQ = localPaint;
    localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    localPaint.setColor(paramKeyboardView.getContext().getResources().getColor(a.c.grey_text_color));
    localPaint.setTextSize(this.JtJ * paramKeyboardView.getContext().getResources().getDisplayMetrics().scaledDensity);
    paramKeyboardView = ah.aiuX;
    this.JtR = localPaint;
    AppMethodBeat.o(313106);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(313118);
    s.u(paramCanvas, "canvas");
    s.u(paramb, "button");
    b(paramCanvas, paramb);
    double d1 = paramb.JsG.left;
    double d2 = paramb.JsG.width();
    double d3 = this.JtK;
    double d4 = paramb.JsG.top;
    double d5 = paramb.JsG.height();
    double d6 = this.JtL;
    paramCanvas.drawText(this.JtO, (float)(d1 + d2 * d3), (float)(d4 + d5 * d6), this.JtQ);
    int i = paramb.JsG.left;
    int j = (int)(paramb.JsG.width() * this.JtM);
    int k = paramb.JsG.top;
    int m = (int)(paramb.JsG.height() * this.JtN);
    paramCanvas.drawText(this.JtP, i + j, k + m, this.JtR);
    AppMethodBeat.o(313118);
  }
  
  public final String getType()
  {
    return "chSwitchType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.a
 * JD-Core Version:    0.7.0.1
 */