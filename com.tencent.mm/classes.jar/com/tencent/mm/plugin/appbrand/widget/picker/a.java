package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.luggage.b.a.a.b;
import com.tencent.luggage.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends c
{
  private static final int ehD = a.e.app_brand_picker_panel;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137967);
    super.setId(ehD);
    setBackgroundResource(a.b.transparent);
    setOnClickListener(new a.1(this));
    AppMethodBeat.o(137967);
  }
  
  public static a es(View paramView)
  {
    AppMethodBeat.i(137966);
    paramView = (a)paramView.getRootView().findViewById(ehD);
    AppMethodBeat.o(137966);
    return paramView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(137971);
    super.hide();
    AppMethodBeat.o(137971);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137968);
    if (isShown())
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup))) {}
      for (int i = ((ViewGroup)getParent()).getMeasuredHeight(); i > 0; i = 0)
      {
        gg(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
        AppMethodBeat.o(137968);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(137968);
  }
  
  public final void setHeader(String paramString)
  {
    AppMethodBeat.i(137969);
    super.setHeader(paramString);
    AppMethodBeat.o(137969);
  }
  
  public final void setId(int paramInt) {}
  
  public final void show()
  {
    AppMethodBeat.i(137970);
    super.show();
    AppMethodBeat.o(137970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */