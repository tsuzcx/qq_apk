package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.app.a.a;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.i;
import java.util.Collection;
import java.util.Iterator;

public final class n
{
  private static final i<String, a.a> iCj;
  
  static
  {
    AppMethodBeat.i(91127);
    iCj = new i();
    AppMethodBeat.o(91127);
  }
  
  public static void EA(String paramString)
  {
    AppMethodBeat.i(91125);
    if (TextUtils.isEmpty(paramString))
    {
      d.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
      AppMethodBeat.o(91125);
      return;
    }
    iCj.bs(paramString);
    AppMethodBeat.o(91125);
  }
  
  public static void a(String paramString, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91126);
    if ((paramString == null) || (paramString.length() == 0))
    {
      d.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
      AppMethodBeat.o(91126);
      return;
    }
    paramString = iCj.br(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a.a)paramString.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(91126);
  }
  
  public static void a(String paramString, a.a parama)
  {
    AppMethodBeat.i(91123);
    if ((TextUtils.isEmpty(paramString)) || (parama == null))
    {
      d.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
      AppMethodBeat.o(91123);
      return;
    }
    iCj.s(paramString, parama);
    AppMethodBeat.o(91123);
  }
  
  @Deprecated
  public static void b(String paramString, a.a parama)
  {
    AppMethodBeat.i(91124);
    a(paramString, parama);
    AppMethodBeat.o(91124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.n
 * JD-Core Version:    0.7.0.1
 */