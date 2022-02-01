package com.tencent.mm.live.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/view/FluentSwitchRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notifyVisibilityFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visibility", "", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onWindowVisibilityChanged", "removeNotifyVisibilityFunction", "setNotifyVisibilityFunction", "function", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RelativeLayout
{
  public b<? super Integer, ah> mWO;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(247556);
    AppMethodBeat.o(247556);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected final void onWindowVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(247581);
    super.onWindowVisibilityChanged(paramInt);
    b localb = this.mWO;
    if (localb != null) {
      localb.invoke(Integer.valueOf(paramInt));
    }
    Log.i("FluentSwitchRelativeLayout", "onWindowVisibilityChanged visibility: " + paramInt + " function: " + this.mWO);
    AppMethodBeat.o(247581);
  }
  
  public final void setNotifyVisibilityFunction(b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(247572);
    s.u(paramb, "function");
    this.mWO = paramb;
    AppMethodBeat.o(247572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.view.a
 * JD-Core Version:    0.7.0.1
 */