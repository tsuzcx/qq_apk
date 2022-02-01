package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "text", "", "textColor", "", "clickBgColor", "bold", "", "isTopic", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/String;IIZZLkotlin/jvm/functions/Function1;)V", "getBold", "()Z", "setBold", "(Z)V", "canClick", "getCanClick", "setCanClick", "getClickBgColor", "()I", "setClickBgColor", "(I)V", "setTopic", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "widget", "Landroid/view/View;", "setColor", "linkColor", "backgroundColor", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public class o
  extends com.tencent.mm.pluginsdk.ui.span.p
{
  boolean BaS;
  private final String text;
  private int textColor;
  public boolean wEW;
  private int wEX;
  private boolean wEY;
  private b<? super String, x> yUf;
  
  public o(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, b<? super String, x> paramb)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(239085);
    this.text = paramString;
    this.textColor = paramInt1;
    this.wEX = paramInt2;
    this.wEY = paramBoolean1;
    this.BaS = paramBoolean2;
    this.yUf = paramb;
    this.wEW = true;
    AppMethodBeat.o(239085);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(168418);
    kotlin.g.b.p.k(paramView, "widget");
    if (this.wEW) {
      this.yUf.invoke(this.text);
    }
    AppMethodBeat.o(168418);
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168419);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.wEX = paramInt2;
    AppMethodBeat.o(168419);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(239082);
    kotlin.g.b.p.k(paramTextPaint, "ds");
    super.updateDrawState(paramTextPaint);
    if (this.wEY) {
      ar.a((Paint)paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(239082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.o
 * JD-Core Version:    0.7.0.1
 */