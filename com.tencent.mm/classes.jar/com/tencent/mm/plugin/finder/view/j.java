package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.al;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "text", "", "textColor", "", "clickBgColor", "bold", "", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/String;IIZLkotlin/jvm/functions/Function1;)V", "getBold", "()Z", "setBold", "(Z)V", "canClick", "getCanClick", "setCanClick", "getClickBgColor", "()I", "setClickBgColor", "(I)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "widget", "Landroid/view/View;", "setColor", "linkColor", "backgroundColor", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public final class j
  extends o
{
  public boolean ryP;
  private int ryQ;
  private boolean ryR;
  private b<? super String, z> sKw;
  private final String text;
  private int textColor;
  
  public j(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, b<? super String, z> paramb)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(205855);
    this.text = paramString;
    this.textColor = paramInt1;
    this.ryQ = paramInt2;
    this.ryR = paramBoolean;
    this.sKw = paramb;
    this.ryP = true;
    AppMethodBeat.o(205855);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(168418);
    p.h(paramView, "widget");
    if (this.ryP) {
      this.sKw.invoke(this.text);
    }
    AppMethodBeat.o(168418);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168419);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.ryQ = paramInt2;
    AppMethodBeat.o(168419);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205854);
    p.h(paramTextPaint, "ds");
    super.updateDrawState(paramTextPaint);
    if (this.ryR) {
      al.a((Paint)paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(205854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.j
 * JD-Core Version:    0.7.0.1
 */