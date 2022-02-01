package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.aj;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "text", "", "textColor", "", "clickBgColor", "bold", "", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/String;IIZLkotlin/jvm/functions/Function1;)V", "getBold", "()Z", "setBold", "(Z)V", "canClick", "getCanClick", "setCanClick", "getClickBgColor", "()I", "setClickBgColor", "(I)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "widget", "Landroid/view/View;", "setColor", "linkColor", "backgroundColor", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public final class g
  extends o
{
  public boolean rZg;
  private int rZh;
  private boolean rZi;
  private b<? super String, y> rZj;
  private final String text;
  private int textColor;
  
  public g(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, b<? super String, y> paramb)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(204233);
    this.text = paramString;
    this.textColor = paramInt1;
    this.rZh = paramInt2;
    this.rZi = paramBoolean;
    this.rZj = paramb;
    this.rZg = true;
    AppMethodBeat.o(204233);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(168418);
    k.h(paramView, "widget");
    if (this.rZg) {
      this.rZj.ay(this.text);
    }
    AppMethodBeat.o(168418);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168419);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.rZh = paramInt2;
    AppMethodBeat.o(168419);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(204232);
    k.h(paramTextPaint, "ds");
    super.updateDrawState(paramTextPaint);
    if (this.rZi) {
      aj.a((Paint)paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(204232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.g
 * JD-Core Version:    0.7.0.1
 */