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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/EnglishSwitchDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "mainPaint", "Landroid/graphics/Paint;", "mainPercentX", "", "mainPercentY", "mainText", "", "mainTextSize", "", "smallPaint", "smallPercentX", "smallPercentY", "smallText", "smallTextSize", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "plugin-hld_release"})
public final class c
  extends b
{
  private final int DAT;
  private final double DAU;
  private final double DAV;
  private final double DAW;
  private final double DAX;
  private final String DAZ;
  private final Paint DBa;
  private final Paint DBb;
  private final int DzE;
  private final String mainText;
  
  public c(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(209044);
    this.DzE = 16;
    this.DAT = 10;
    this.DAU = 0.3289D;
    this.DAV = 0.6033D;
    this.DAW = 0.6828D;
    this.DAX = 0.7257D;
    this.mainText = "英";
    this.DAZ = "/中";
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    Object localObject = paramKeyboardView.getContext();
    p.j(localObject, "keyboard.context");
    localPaint.setColor(((Context)localObject).getResources().getColor(a.c.black_text_color));
    float f = this.DzE;
    localObject = paramKeyboardView.getContext();
    p.j(localObject, "keyboard.context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "keyboard.context.resources");
    localPaint.setTextSize(f * ((Resources)localObject).getDisplayMetrics().scaledDensity);
    this.DBa = localPaint;
    localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    localObject = paramKeyboardView.getContext();
    p.j(localObject, "keyboard.context");
    localPaint.setColor(((Context)localObject).getResources().getColor(a.c.grey_text_color));
    f = this.DAT;
    paramKeyboardView = paramKeyboardView.getContext();
    p.j(paramKeyboardView, "keyboard.context");
    paramKeyboardView = paramKeyboardView.getResources();
    p.j(paramKeyboardView, "keyboard.context.resources");
    localPaint.setTextSize(f * paramKeyboardView.getDisplayMetrics().scaledDensity);
    this.DBb = localPaint;
    AppMethodBeat.o(209044);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(209041);
    p.k(paramCanvas, "canvas");
    p.k(paramb, "button");
    b(paramCanvas, paramb);
    double d1 = paramb.DzD.left;
    double d2 = paramb.DzD.width();
    double d3 = this.DAU;
    double d4 = paramb.DzD.top;
    double d5 = paramb.DzD.height();
    double d6 = this.DAV;
    paramCanvas.drawText(this.mainText, (float)(d1 + d2 * d3), (float)(d4 + d5 * d6), this.DBa);
    int i = paramb.DzD.left;
    int j = (int)(paramb.DzD.width() * this.DAW);
    int k = paramb.DzD.top;
    int m = (int)(paramb.DzD.height() * this.DAX);
    paramCanvas.drawText(this.DAZ, i + j, k + m, this.DBb);
    AppMethodBeat.o(209041);
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