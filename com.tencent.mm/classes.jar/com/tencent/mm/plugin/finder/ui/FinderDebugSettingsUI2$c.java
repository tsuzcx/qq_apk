package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.t;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ClickItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getValue", "setValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-finder_release"})
public final class FinderDebugSettingsUI2$c
  implements FinderDebugSettingsUI2.e
{
  private final View.OnClickListener rHf;
  private String title;
  private String value;
  
  public FinderDebugSettingsUI2$c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(203115);
    this.title = paramString1;
    this.value = paramString2;
    this.rHf = paramOnClickListener;
    AppMethodBeat.o(203115);
  }
  
  public final String abN()
  {
    return this.title;
  }
  
  public final void cx(View paramView)
  {
    AppMethodBeat.i(203113);
    k.h(paramView, "view");
    this.rHf.onClick(paramView);
    t.makeText(ai.getContext(), (CharSequence)"ClickItem Done", 1).show();
    AppMethodBeat.o(203113);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(203114);
    k.h(paramString, "<set-?>");
    this.value = paramString;
    AppMethodBeat.o(203114);
  }
  
  public final String value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.c
 * JD-Core Version:    0.7.0.1
 */