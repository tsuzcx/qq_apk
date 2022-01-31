package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final List<String> bes;
  private static final List<String> bet;
  private static final List<String> beu;
  private static final List<String> bev;
  private static final List<String> bew;
  
  static
  {
    AppMethodBeat.i(67882);
    bes = Arrays.asList(new String[] { "_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open" });
    bet = Arrays.asList(new String[] { "auto", "app", "am" });
    beu = Arrays.asList(new String[] { "_r", "_dbg" });
    bev = Arrays.asList((String[])ArrayUtils.concat(new String[][] { AppMeasurement.UserProperty.zzadb, AppMeasurement.UserProperty.zzadc }));
    bew = Arrays.asList(new String[] { "^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$" });
    AppMethodBeat.o(67882);
  }
  
  public static boolean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(67881);
    if (!"_cmp".equals(paramString2))
    {
      AppMethodBeat.o(67881);
      return true;
    }
    if (!aV(paramString1))
    {
      AppMethodBeat.o(67881);
      return false;
    }
    if (paramBundle == null)
    {
      AppMethodBeat.o(67881);
      return false;
    }
    paramString2 = beu.iterator();
    while (paramString2.hasNext()) {
      if (paramBundle.containsKey((String)paramString2.next()))
      {
        AppMethodBeat.o(67881);
        return false;
      }
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(67881);
        return false;
        if (paramString1.equals("fcm"))
        {
          i = 0;
          continue;
          if (paramString1.equals("fdl")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramBundle.putString("_cis", "fcm_integration");
    AppMethodBeat.o(67881);
    return true;
    paramBundle.putString("_cis", "fdl_integration");
    AppMethodBeat.o(67881);
    return true;
  }
  
  public static boolean aV(String paramString)
  {
    AppMethodBeat.i(67878);
    if (!bet.contains(paramString))
    {
      AppMethodBeat.o(67878);
      return true;
    }
    AppMethodBeat.o(67878);
    return false;
  }
  
  public static boolean aW(String paramString)
  {
    AppMethodBeat.i(67880);
    if (bev.contains(paramString))
    {
      AppMethodBeat.o(67880);
      return false;
    }
    Iterator localIterator = bew.iterator();
    while (localIterator.hasNext()) {
      if (paramString.matches((String)localIterator.next()))
      {
        AppMethodBeat.o(67880);
        return false;
      }
    }
    AppMethodBeat.o(67880);
    return true;
  }
  
  public static boolean e(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(67879);
    if (bes.contains(paramString))
    {
      AppMethodBeat.o(67879);
      return false;
    }
    if (paramBundle != null)
    {
      paramString = beu.iterator();
      while (paramString.hasNext()) {
        if (paramBundle.containsKey((String)paramString.next()))
        {
          AppMethodBeat.o(67879);
          return false;
        }
      }
    }
    AppMethodBeat.o(67879);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.analytics.connector.internal.b
 * JD-Core Version:    0.7.0.1
 */