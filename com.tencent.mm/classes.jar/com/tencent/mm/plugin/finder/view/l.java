package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.g.a.b;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "text", "", "textColor", "", "clickBgColor", "bold", "", "isTopic", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/String;IIZZLkotlin/jvm/functions/Function1;)V", "getBold", "()Z", "setBold", "(Z)V", "canClick", "getCanClick", "setCanClick", "getClickBgColor", "()I", "setClickBgColor", "(I)V", "setTopic", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "widget", "Landroid/view/View;", "setColor", "linkColor", "backgroundColor", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public final class l
  extends com.tencent.mm.pluginsdk.ui.span.p
{
  public boolean sYU;
  private int sYV;
  private boolean sYW;
  private final String text;
  private int textColor;
  private b<? super String, x> uzi;
  boolean wpF;
  
  public l(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, b<? super String, x> paramb)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(254995);
    this.text = paramString;
    this.textColor = paramInt1;
    this.sYV = paramInt2;
    this.sYW = paramBoolean1;
    this.wpF = paramBoolean2;
    this.uzi = paramb;
    this.sYU = true;
    AppMethodBeat.o(254995);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(168418);
    kotlin.g.b.p.h(paramView, "widget");
    if (this.sYU) {
      this.uzi.invoke(this.text);
    }
    AppMethodBeat.o(168418);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168419);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.sYV = paramInt2;
    AppMethodBeat.o(168419);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(254994);
    kotlin.g.b.p.h(paramTextPaint, "ds");
    super.updateDrawState(paramTextPaint);
    if (this.sYW) {
      ao.a((Paint)paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(254994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l
 * JD-Core Version:    0.7.0.1
 */