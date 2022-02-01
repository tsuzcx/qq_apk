package com.tencent.mapsdk.internal;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.lang.ref.WeakReference;

public final class mg
  extends Paint
{
  private WeakReference<TencentMapContext> a;
  
  public mg(TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(223028);
    this.a = new WeakReference(paramTencentMapContext);
    AppMethodBeat.o(223028);
  }
  
  public final Typeface setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(223036);
    if (this.a != null)
    {
      localObject = (TencentMapContext)this.a.get();
      if (localObject != null) {}
    }
    else
    {
      paramTypeface = super.setTypeface(paramTypeface);
      AppMethodBeat.o(223036);
      return paramTypeface;
    }
    Object localObject = ((TencentMapContext)localObject).getTypeface();
    if ((localObject != null) && ((Typeface.DEFAULT == paramTypeface) || (Typeface.DEFAULT_BOLD == paramTypeface)))
    {
      paramTypeface = super.setTypeface((Typeface)localObject);
      AppMethodBeat.o(223036);
      return paramTypeface;
    }
    paramTypeface = super.setTypeface(paramTypeface);
    AppMethodBeat.o(223036);
    return paramTypeface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mg
 * JD-Core Version:    0.7.0.1
 */