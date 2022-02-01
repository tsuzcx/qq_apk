package com.tencent.mm.plugin.bizui.a;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/bizui/util/BizViewUtils$roundCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ui-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  extends ViewOutlineProvider
{
  a$c(boolean paramBoolean1, boolean paramBoolean2, float paramFloat) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(260857);
    s.u(paramView, "view");
    s.u(paramOutline, "outline");
    if ((this.vtH) && (this.vtI))
    {
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.vtJ);
      AppMethodBeat.o(260857);
      return;
    }
    if (this.vtH)
    {
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), (int)(paramView.getHeight() + this.vtJ), this.vtJ);
      AppMethodBeat.o(260857);
      return;
    }
    if (this.vtI) {
      paramOutline.setRoundRect(0, (int)(0.0F - this.vtJ), paramView.getWidth(), paramView.getHeight(), this.vtJ);
    }
    AppMethodBeat.o(260857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a.c
 * JD-Core Version:    0.7.0.1
 */