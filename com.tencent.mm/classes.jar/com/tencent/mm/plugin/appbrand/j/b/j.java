package com.tencent.mm.plugin.appbrand.j.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.b.h;

public final class j
  implements a
{
  public final void a(h paramh)
  {
    if ((paramh instanceof b)) {
      ((b)paramh).dismiss();
    }
  }
  
  public final h ac(Context paramContext)
  {
    paramContext = new d(paramContext);
    paramContext.setCancelable(false);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.j
 * JD-Core Version:    0.7.0.1
 */