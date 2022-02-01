package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMScrollView
  extends ScrollView
  implements View.OnFocusChangeListener
{
  private a kuA;
  
  public MMScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  final void a(ViewGroup paramViewGroup, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(20953);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof AddrEditView)) {
        localView.setOnFocusChangeListener(paramOnFocusChangeListener);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a((ViewGroup)localView, paramOnFocusChangeListener);
        }
      }
    }
    AppMethodBeat.o(20953);
  }
  
  public void onFocusChange(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20954);
    Log.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      AppMethodBeat.o(20954);
      return;
    }
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20952);
        MMScrollView.this.scrollTo(0, paramView.getTop() - a.fromDPToPix(MMScrollView.this.getContext(), 10));
        AppMethodBeat.o(20952);
      }
    }, 200L);
    AppMethodBeat.o(20954);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(20955);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(20955);
  }
  
  public void setOnSizeChangeListener(a parama)
  {
    if (parama != null) {
      this.kuA = parama;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.MMScrollView
 * JD-Core Version:    0.7.0.1
 */