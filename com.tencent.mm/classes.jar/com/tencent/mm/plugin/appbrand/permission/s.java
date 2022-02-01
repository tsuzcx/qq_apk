package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;

public final class s
{
  private static final j<String, a.a> tEP;
  
  static
  {
    AppMethodBeat.i(140777);
    tEP = new j();
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
    paramString = tEP.ej(paramString);
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
    AppMethodBeat.i(318730);
    if ((TextUtils.isEmpty(paramString)) || (parama == null))
    {
      Log.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
      AppMethodBeat.o(318730);
      return;
    }
    tEP.v(paramString, parama);
    AppMethodBeat.o(318730);
  }
  
  public static void afs(String paramString)
  {
    AppMethodBeat.i(140775);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
      AppMethodBeat.o(140775);
      return;
    }
    tEP.ek(paramString);
    AppMethodBeat.o(140775);
  }
  
  public static void b(String paramString, a.a parama)
  {
    AppMethodBeat.i(318732);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid arguments");
      AppMethodBeat.o(318732);
      return;
    }
    tEP.O(paramString, parama);
    AppMethodBeat.o(318732);
  }
  
  @Deprecated
  public static void c(String paramString, a.a parama)
  {
    AppMethodBeat.i(318735);
    a(paramString, parama);
    AppMethodBeat.o(318735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.s
 * JD-Core Version:    0.7.0.1
 */