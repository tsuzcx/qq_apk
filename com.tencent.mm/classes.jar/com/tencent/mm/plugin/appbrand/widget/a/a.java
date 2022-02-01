package com.tencent.mm.plugin.appbrand.widget.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"LUGGAGE_WIDGET_ACCESSIBILITY_DEBUG", "", "TAG", "", "delegateAccessibility4Debug", "", "Landroid/view/View;", "Landroid/view/ViewGroup;", "doAccessibilityFocus", "luggage-commons-widget_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void dQ(View paramView)
  {
    AppMethodBeat.i(323972);
    s.u(paramView, "<this>");
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    if ((paramView instanceof ViewGroup)) {
      ((ViewGroup)paramView).setDescendantFocusability(131072);
    }
    Log.i("MicroMsg.AppBrand.AccessibilityExt", s.X("doAccessibilityFocus, focused: ", Boolean.valueOf(paramView.requestFocus())));
    AppMethodBeat.o(323972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.a.a
 * JD-Core Version:    0.7.0.1
 */