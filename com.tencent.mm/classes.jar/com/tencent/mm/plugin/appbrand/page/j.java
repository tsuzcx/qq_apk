package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.c;
import java.util.Objects;

public final class j
  extends ao
{
  public j(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(219357);
    ((ViewGroup)Objects.requireNonNull(b(0, false, false))).addView(paramc, -1, -2);
    d(new ao.b(paramc, 1, 0, 1000, true, false, false));
    AppMethodBeat.o(219357);
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(219354);
    paramBoolean = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean);
    AppMethodBeat.o(219354);
    return paramBoolean;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219355);
    paramBoolean1 = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(219355);
    return paramBoolean1;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(219356);
    paramBoolean1 = super.a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(219356);
    return paramBoolean1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */