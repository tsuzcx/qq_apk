package com.tencent.luggage.sdk.e;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "Landroid/view/View$OnLayoutChangeListener;", "()V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a$a
  implements View.OnLayoutChangeListener
{
  private int evg;
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(220218);
    this.evg += 1;
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, this.evg);
    AppMethodBeat.o(220218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a.a
 * JD-Core Version:    0.7.0.1
 */