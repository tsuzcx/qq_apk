package com.tencent.mm.accessibility.core.area;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.uitl.IdUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/area/ViewTouchAreaExpander;", "", "()V", "TAG", "", "expand", "", "view", "Landroid/view/View;", "eLeft", "", "eTop", "eRight", "eBottom", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ViewTouchAreaExpander
{
  public static final ViewTouchAreaExpander INSTANCE;
  public static final String TAG = "MicroMsg.Acc.ViewTouchAreaExpander";
  
  static
  {
    AppMethodBeat.i(234325);
    INSTANCE = new ViewTouchAreaExpander();
    AppMethodBeat.o(234325);
  }
  
  public final void expand(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234334);
    s.u(paramView, "view");
    long l = System.nanoTime();
    ExpandTouchDelegate.Companion.expand(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.Acc.ViewTouchAreaExpander", "expand: view(" + IdUtil.INSTANCE.getName(paramView.getId()) + ") cost " + (System.nanoTime() - l));
    AppMethodBeat.o(234334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.area.ViewTouchAreaExpander
 * JD-Core Version:    0.7.0.1
 */