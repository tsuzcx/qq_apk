package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
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
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(244328);
    ((ViewGroup)Objects.requireNonNull(b(0, false, false))).addView(paramc, -1, -2);
    d(new ap.b(paramc, 1, 0, 1000, true, false, false));
    AppMethodBeat.o(244328);
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(244323);
    paramBoolean = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean);
    AppMethodBeat.o(244323);
    return paramBoolean;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(244326);
    paramBoolean1 = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(244326);
    return paramBoolean1;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(244327);
    paramBoolean1 = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(244327);
    return paramBoolean1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */