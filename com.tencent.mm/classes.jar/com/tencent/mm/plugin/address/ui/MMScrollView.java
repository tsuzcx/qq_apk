package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class MMScrollView
  extends ScrollView
  implements View.OnFocusChangeListener
{
  private a jaj;
  
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
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20954);
    ac.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      AppMethodBeat.o(20954);
      return;
    }
    postDelayed(new MMScrollView.1(this, paramView), 200L);
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
      this.jaj = parama;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.MMScrollView
 * JD-Core Version:    0.7.0.1
 */