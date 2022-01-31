package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.weishi.b;
import com.tencent.mm.plugin.appbrand.weishi.g;
import com.tencent.mm.sdk.platformtools.ah;

public final class e
{
  private static final a<i, Bitmap> iMW;
  
  static
  {
    AppMethodBeat.i(132991);
    iMW = new a();
    AppMethodBeat.o(132991);
  }
  
  public static r a(Context paramContext, o paramo)
  {
    AppMethodBeat.i(132989);
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = ah.getContext();
    }
    paramContext = new m((Context)localObject);
    localObject = (Bitmap)iMW.remove(paramo);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new h(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(132989);
      return paramContext;
    }
    if (g.J(paramo))
    {
      paramContext = new b(paramContext, paramo);
      AppMethodBeat.o(132989);
      return paramContext;
    }
    if (j.I(paramo))
    {
      paramContext = new f(paramContext, paramo);
      AppMethodBeat.o(132989);
      return paramContext;
    }
    if (paramo.vY())
    {
      paramContext = new c(paramContext, paramo);
      AppMethodBeat.o(132989);
      return paramContext;
    }
    paramContext = new k(paramContext, paramo);
    AppMethodBeat.o(132989);
    return paramContext;
  }
  
  public static void a(i parami, Bitmap paramBitmap)
  {
    AppMethodBeat.i(132990);
    if ((parami == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(132990);
      return;
    }
    iMW.put(parami, paramBitmap);
    AppMethodBeat.o(132990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */