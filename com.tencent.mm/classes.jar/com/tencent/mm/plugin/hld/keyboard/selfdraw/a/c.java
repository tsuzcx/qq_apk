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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/EnglishSwitchDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "mainPaint", "Landroid/graphics/Paint;", "mainPercentX", "", "mainPercentY", "mainText", "", "mainTextSize", "", "smallPaint", "smallPercentX", "smallPercentY", "smallText", "smallTextSize", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  private final int JsH;
  private final int JtT;
  private final double JtU;
  private final double JtV;
  private final double JtW;
  private final double JtX;
  private final String JtY;
  private final Paint JtZ;
  private final Paint Jua;
  private final String mainText;
  
  public c(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(313051);
    this.JsH = 16;
    this.JtT = 10;
    this.JtU = 0.3289D;
    this.JtV = 0.6033D;
    this.JtW = 0.6828D;
    this.JtX = 0.7257D;
    this.mainText = "英";
    this.JtY = "/中";
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    localPaint.setColor(paramKeyboardView.getContext().getResources().getColor(a.c.black_text_color));
    localPaint.setTextSize(this.JsH * paramKeyboardView.getContext().getResources().getDisplayMetrics().scaledDensity);
    ah localah = ah.aiuX;
    this.JtZ = localPaint;
    localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    localPaint.setColor(paramKeyboardView.getContext().getResources().getColor(a.c.grey_text_color));
    localPaint.setTextSize(this.JtT * paramKeyboardView.getContext().getResources().getDisplayMetrics().scaledDensity);
    paramKeyboardView = ah.aiuX;
    this.Jua = localPaint;
    AppMethodBeat.o(313051);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(313064);
    s.u(paramCanvas, "canvas");
    s.u(paramb, "button");
    b(paramCanvas, paramb);
    double d1 = paramb.JsG.left;
    double d2 = paramb.JsG.width();
    double d3 = this.JtU;
    double d4 = paramb.JsG.top;
    double d5 = paramb.JsG.height();
    double d6 = this.JtV;
    paramCanvas.drawText(this.mainText, (float)(d1 + d2 * d3), (float)(d4 + d5 * d6), this.JtZ);
    int i = paramb.JsG.left;
    int j = (int)(paramb.JsG.width() * this.JtW);
    int k = paramb.JsG.top;
    int m = (int)(paramb.JsG.height() * this.JtX);
    paramCanvas.drawText(this.JtY, i + j, k + m, this.Jua);
    AppMethodBeat.o(313064);
  }
  
  public final String getType()
  {
    return "enSwitchType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.c
 * JD-Core Version:    0.7.0.1
 */