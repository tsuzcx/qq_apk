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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/LargeChineseSwitchDrawer;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "yinPaint", "Landroid/graphics/Paint;", "yinPercentX", "", "yinPercentY", "yinText", "", "yinTextSize", "", "zhongPaint", "zhongPercentX", "zhongPercentY", "zhongText", "zhongTextSize", "drawButton", "", "canvas", "Landroid/graphics/Canvas;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "getType", "plugin-hld_release"})
public final class f
  extends b
{
  private final int DAI;
  private final int DAJ;
  private final double DAK;
  private final double DAL;
  private final double DAM;
  private final double DAN;
  private final String DAO;
  private final String DAP;
  private final Paint DAQ;
  private final Paint DAR;
  
  public f(KeyboardView paramKeyboardView)
  {
    super(paramKeyboardView);
    AppMethodBeat.i(210277);
    this.DAI = 18;
    this.DAJ = 14;
    this.DAK = 0.3289D;
    this.DAL = 0.6033D;
    this.DAM = 0.6828D;
    this.DAN = 0.7257D;
    this.DAO = "中";
    this.DAP = "/英";
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    Object localObject = paramKeyboardView.getContext();
    p.j(localObject, "keyboard.context");
    localPaint.setColor(((Context)localObject).getResources().getColor(a.c.black_text_color));
    float f = this.DAI;
    localObject = paramKeyboardView.getContext();
    p.j(localObject, "keyboard.context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "keyboard.context.resources");
    localPaint.setTextSize(f * ((Resources)localObject).getDisplayMetrics().scaledDensity);
    this.DAQ = localPaint;
    localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextAlign(Paint.Align.CENTER);
    localObject = paramKeyboardView.getContext();
    p.j(localObject, "keyboard.context");
    localPaint.setColor(((Context)localObject).getResources().getColor(a.c.grey_text_color));
    f = this.DAJ;
    paramKeyboardView = paramKeyboardView.getContext();
    p.j(paramKeyboardView, "keyboard.context");
    paramKeyboardView = paramKeyboardView.getResources();
    p.j(paramKeyboardView, "keyboard.context.resources");
    localPaint.setTextSize(f * paramKeyboardView.getDisplayMetrics().scaledDensity);
    this.DAR = localPaint;
    AppMethodBeat.o(210277);
  }
  
  public final void a(Canvas paramCanvas, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(210273);
    p.k(paramCanvas, "canvas");
    p.k(paramb, "button");
    b(paramCanvas, paramb);
    double d1 = paramb.DzD.left;
    double d2 = paramb.DzD.width();
    double d3 = this.DAK;
    double d4 = paramb.DzD.top;
    double d5 = paramb.DzD.height();
    double d6 = this.DAL;
    paramCanvas.drawText(this.DAO, (float)(d1 + d2 * d3), (float)(d4 + d5 * d6), this.DAQ);
    int i = paramb.DzD.left;
    int j = (int)(paramb.DzD.width() * this.DAM);
    int k = paramb.DzD.top;
    int m = (int)(paramb.DzD.height() * this.DAN);
    paramCanvas.drawText(this.DAP, i + j, k + m, this.DAR);
    AppMethodBeat.o(210273);
  }
  
  public final String getType()
  {
    return "chSwitchType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a.f
 * JD-Core Version:    0.7.0.1
 */