package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/CenterScrollFrameLayout;", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMDialog;", "getDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMDialog;", "setDialog", "(Lcom/tencent/mm/ui/widget/dialog/MMDialog;)V", "dismiss", "", "scroll", "distance", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CenterScrollFrameLayout
  extends ScrollFrameLayout
{
  public static final CenterScrollFrameLayout.a GYC;
  private i GYB;
  
  static
  {
    AppMethodBeat.i(334593);
    GYC = new CenterScrollFrameLayout.a((byte)0);
    AppMethodBeat.o(334593);
  }
  
  public CenterScrollFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(334573);
    AppMethodBeat.o(334573);
  }
  
  public CenterScrollFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(334583);
    setScrollDownLimit(paramContext.getResources().getDimension(e.c.Edge_10A));
    AppMethodBeat.o(334583);
  }
  
  public final void ct(float paramFloat)
  {
    AppMethodBeat.i(334620);
    if (getMPointerTranslateY() + paramFloat > getScrollDownLimit())
    {
      i locali = this.GYB;
      if (locali != null) {
        locali.dismiss();
      }
    }
    for (;;)
    {
      setTranslationY(getMPointerTranslateY());
      Log.i("Finder.CenterScrollFrameLayout", "translationY :" + getTranslationY() + " offsetY:" + paramFloat);
      AppMethodBeat.o(334620);
      return;
      if (getMPointerTranslateY() + paramFloat < 0.0F) {
        setMPointerTranslateY(0.0F);
      } else {
        setMPointerTranslateY(getMPointerTranslateY() + paramFloat);
      }
    }
  }
  
  public final i getDialog()
  {
    return this.GYB;
  }
  
  public final void setDialog(i parami)
  {
    this.GYB = parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.CenterScrollFrameLayout
 * JD-Core Version:    0.7.0.1
 */