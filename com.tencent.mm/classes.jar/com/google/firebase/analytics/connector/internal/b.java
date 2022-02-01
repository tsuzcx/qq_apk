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
  private static final List<String> bIj;
  private static final List<String> bIk;
  private static final List<String> bIl;
  private static final List<String> bIm;
  private static final List<String> bIn;
  
  static
  {
    AppMethodBeat.i(116777);
    bIj = Arrays.asList(new String[] { "_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open" });
    bIk = Arrays.asList(new String[] { "auto", "app", "am" });
    bIl = Arrays.asList(new String[] { "_r", "_dbg" });
    bIm = Arrays.asList((String[])ArrayUtils.concat(new String[][] { AppMeasurement.UserProperty.zzadb, AppMeasurement.UserProperty.zzadc }));
    bIn = Arrays.asList(new String[] { "^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$" });
    AppMethodBeat.o(116777);
  }
  
  public static boolean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(116776);
    if (!"_cmp".equals(paramString2))
    {
      AppMethodBeat.o(116776);
      return true;
    }
    if (!bY(paramString1))
    {
      AppMethodBeat.o(116776);
      return false;
    }
    if (paramBundle == null)
    {
      AppMethodBeat.o(116776);
      return false;
    }
    paramString2 = bIl.iterator();
    while (paramString2.hasNext()) {
      if (paramBundle.containsKey((String)paramString2.next()))
      {
        AppMethodBeat.o(116776);
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
        AppMethodBeat.o(116776);
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
    AppMethodBeat.o(116776);
    return true;
    paramBundle.putString("_cis", "fdl_integration");
    AppMethodBeat.o(116776);
    return true;
  }
  
  public static boolean bY(String paramString)
  {
    AppMethodBeat.i(116773);
    if (!bIk.contains(paramString))
    {
      AppMethodBeat.o(116773);
      return true;
    }
    AppMethodBeat.o(116773);
    return false;
  }
  
  public static boolean bZ(String paramString)
  {
    AppMethodBeat.i(116775);
    if (bIm.contains(paramString))
    {
      AppMethodBeat.o(116775);
      return false;
    }
    Iterator localIterator = bIn.iterator();
    while (localIterator.hasNext()) {
      if (paramString.matches((String)localIterator.next()))
      {
        AppMethodBeat.o(116775);
        return false;
      }
    }
    AppMethodBeat.o(116775);
    return true;
  }
  
  public static boolean j(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(116774);
    if (bIj.contains(paramString))
    {
      AppMethodBeat.o(116774);
      return false;
    }
    if (paramBundle != null)
    {
      paramString = bIl.iterator();
      while (paramString.hasNext()) {
        if (paramBundle.containsKey((String)paramString.next()))
        {
          AppMethodBeat.o(116774);
          return false;
        }
      }
    }
    AppMethodBeat.o(116774);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.firebase.analytics.connector.internal.b
 * JD-Core Version:    0.7.0.1
 */