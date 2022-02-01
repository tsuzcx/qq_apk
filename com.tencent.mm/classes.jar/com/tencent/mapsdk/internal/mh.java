package com.tencent.mapsdk.internal;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

public final class mh
  extends TextView
{
  private boolean a;
  
  public mh(Context paramContext, TencentMapContext paramTencentMapContext)
  {
    super(paramContext);
    AppMethodBeat.i(223016);
    if ((!this.a) && (paramTencentMapContext != null))
    {
      this.a = true;
      paramContext = paramTencentMapContext.getTypeface();
      if (paramContext != null) {
        setTypeface(paramContext);
      }
    }
    AppMethodBeat.o(223016);
  }
  
  private void a(TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(223023);
    if ((!this.a) && (paramTencentMapContext != null))
    {
      this.a = true;
      paramTencentMapContext = paramTencentMapContext.getTypeface();
      if (paramTencentMapContext != null) {
        setTypeface(paramTencentMapContext);
      }
    }
    AppMethodBeat.o(223023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mh
 * JD-Core Version:    0.7.0.1
 */