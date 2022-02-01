package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;

public final class r
{
  private static final h<String, a.a> qzQ;
  
  static
  {
    AppMethodBeat.i(140777);
    qzQ = new h();
    AppMethodBeat.o(140777);
  }
  
  public static void a(String paramString, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(140776);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
      AppMethodBeat.o(140776);
      return;
    }
    paramString = qzQ.cN(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a.a)paramString.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(140776);
  }
  
  public static void a(String paramString, a.a parama)
  {
    AppMethodBeat.i(209418);
    if ((TextUtils.isEmpty(paramString)) || (parama == null))
    {
      Log.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
      AppMethodBeat.o(209418);
      return;
    }
    qzQ.k(paramString, parama);
    AppMethodBeat.o(209418);
  }
  
  public static void amk(String paramString)
  {
    AppMethodBeat.i(140775);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
      AppMethodBeat.o(140775);
      return;
    }
    qzQ.cO(paramString);
    AppMethodBeat.o(140775);
  }
  
  @Deprecated
  public static void b(String paramString, a.a parama)
  {
    AppMethodBeat.i(209420);
    a(paramString, parama);
    AppMethodBeat.o(209420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.r
 * JD-Core Version:    0.7.0.1
 */