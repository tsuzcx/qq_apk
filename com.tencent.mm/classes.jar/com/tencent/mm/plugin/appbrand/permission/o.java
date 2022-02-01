package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.app.a.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.Iterator;

public final class o
{
  private static final h<String, a.a> lji;
  
  static
  {
    AppMethodBeat.i(140777);
    lji = new h();
    AppMethodBeat.o(140777);
  }
  
  public static void Mi(String paramString)
  {
    AppMethodBeat.i(140775);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
      AppMethodBeat.o(140775);
      return;
    }
    lji.cE(paramString);
    AppMethodBeat.o(140775);
  }
  
  public static void a(String paramString, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(140776);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
      AppMethodBeat.o(140776);
      return;
    }
    paramString = lji.cD(paramString);
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
    AppMethodBeat.i(140773);
    if ((TextUtils.isEmpty(paramString)) || (parama == null))
    {
      ad.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
      AppMethodBeat.o(140773);
      return;
    }
    lji.h(paramString, parama);
    AppMethodBeat.o(140773);
  }
  
  @Deprecated
  public static void b(String paramString, a.a parama)
  {
    AppMethodBeat.i(140774);
    a(paramString, parama);
    AppMethodBeat.o(140774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.o
 * JD-Core Version:    0.7.0.1
 */