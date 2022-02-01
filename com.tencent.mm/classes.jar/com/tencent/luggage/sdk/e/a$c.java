package com.tencent.luggage.sdk.e;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$onConfigurationChanged$1", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  extends a.a
{
  a$c(View paramView, a<C> parama) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    AppMethodBeat.i(220213);
    if (paramInt9 == 10)
    {
      this.evk.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(220213);
      return;
    }
    if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
    for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
    {
      Log.i("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
      AppMethodBeat.o(220213);
      return;
    }
    if (this.evl.euQ != null) {
      a.a(this.evl, "onConfigurationChanged");
    }
    this.evk.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
    AppMethodBeat.o(220213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a.c
 * JD-Core Version:    0.7.0.1
 */