package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.c;
import java.util.Objects;

public final class k
  extends ap
{
  public k(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(324912);
    ViewGroup localViewGroup = (ViewGroup)Objects.requireNonNull(c(0, false, false));
    View localView = localViewGroup.findViewById(a.d.app_brand_external_cover_widget_container);
    Object localObject = localView;
    if (!(localView instanceof RelativeLayout))
    {
      localObject = new RelativeLayout(paramView.getContext());
      ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setId(a.d.app_brand_external_cover_widget_container);
      localViewGroup.addView((View)localObject);
      d(new ap.b((View)localObject, 2, 0, 999, true, false, false));
    }
    localView = ((View)localObject).findViewById(paramInt);
    if (localView != null) {
      ((RelativeLayout)localObject).removeView(localView);
    }
    ((RelativeLayout)localObject).addView(paramView);
    AppMethodBeat.o(324912);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(324907);
    ((ViewGroup)Objects.requireNonNull(c(0, false, false))).addView(paramc, -1, -2);
    d(new ap.b(paramc, 1, 0, 1000, true, false, false));
    AppMethodBeat.o(324907);
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(324898);
    paramBoolean = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean);
    AppMethodBeat.o(324898);
    return paramBoolean;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(324902);
    paramBoolean1 = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(324902);
    return paramBoolean1;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(324904);
    paramBoolean1 = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(324904);
    return paramBoolean1;
  }
  
  public final void cDQ()
  {
    AppMethodBeat.i(324917);
    ViewGroup localViewGroup = (ViewGroup)Objects.requireNonNull(c(0, false, false));
    View localView = localViewGroup.findViewById(a.d.app_brand_external_cover_widget_container);
    if (localView != null)
    {
      Am(2);
      localViewGroup.removeView(localView);
    }
    AppMethodBeat.o(324917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */