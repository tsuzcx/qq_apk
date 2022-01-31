package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends d
{
  private static final int VIEW_ID = 2131820571;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126685);
    super.setId(VIEW_ID);
    setBackgroundResource(2131690159);
    setOnClickListener(new a.1(this));
    AppMethodBeat.o(126685);
  }
  
  public static a cY(View paramView)
  {
    AppMethodBeat.i(126684);
    paramView = (a)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(126684);
    return paramView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126688);
    super.hide();
    AppMethodBeat.o(126688);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126686);
    if (isShown())
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup))) {}
      for (int i = ((ViewGroup)getParent()).getMeasuredHeight(); i > 0; i = 0)
      {
        dz(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
        AppMethodBeat.o(126686);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(126686);
  }
  
  public final void setId(int paramInt) {}
  
  public final void show()
  {
    AppMethodBeat.i(126687);
    super.show();
    AppMethodBeat.o(126687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */