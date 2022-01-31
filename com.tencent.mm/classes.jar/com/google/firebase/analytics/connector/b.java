package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements a
{
  private static volatile a bep;
  private final AppMeasurement beo;
  @VisibleForTesting
  final Map<String, Object> beq;
  
  private b(AppMeasurement paramAppMeasurement)
  {
    AppMethodBeat.i(67871);
    Preconditions.checkNotNull(paramAppMeasurement);
    this.beo = paramAppMeasurement;
    this.beq = new ConcurrentHashMap();
    AppMethodBeat.o(67871);
  }
  
  @KeepForSdk
  public static a af(Context paramContext)
  {
    AppMethodBeat.i(67872);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (bep == null) {}
    try
    {
      if (bep == null) {
        bep = new b(AppMeasurement.getInstance(paramContext));
      }
      paramContext = bep;
      AppMethodBeat.o(67872);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(67872);
    }
  }
  
  @KeepForSdk
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(67873);
    if (!com.google.firebase.analytics.connector.internal.b.aV(paramString1))
    {
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0)
      {
        "Origin not allowed : ".concat(paramString1);
        AppMethodBeat.o(67873);
        return;
      }
      new String("Origin not allowed : ");
      AppMethodBeat.o(67873);
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.b.e(paramString2, paramBundle))
    {
      AppMethodBeat.o(67873);
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.b.a(paramString1, paramString2, paramBundle))
    {
      AppMethodBeat.o(67873);
      return;
    }
    this.beo.logEventInternal(paramString1, paramString2, paramBundle);
    AppMethodBeat.o(67873);
  }
  
  @KeepForSdk
  public final void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(67874);
    if (!com.google.firebase.analytics.connector.internal.b.aV(paramString1))
    {
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0)
      {
        "Origin not allowed : ".concat(paramString1);
        AppMethodBeat.o(67874);
        return;
      }
      new String("Origin not allowed : ");
      AppMethodBeat.o(67874);
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.b.aW(paramString2))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0)
      {
        "User Property not allowed : ".concat(paramString1);
        AppMethodBeat.o(67874);
        return;
      }
      new String("User Property not allowed : ");
      AppMethodBeat.o(67874);
      return;
    }
    if (((paramString2.equals("_ce1")) || (paramString2.equals("_ce2"))) && (!paramString1.equals("fcm")) && (!paramString1.equals("frc")))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0)
      {
        "User Property not allowed for this origin: ".concat(paramString1);
        AppMethodBeat.o(67874);
        return;
      }
      new String("User Property not allowed for this origin: ");
      AppMethodBeat.o(67874);
      return;
    }
    this.beo.setUserPropertyInternal(paramString1, paramString2, paramObject);
    AppMethodBeat.o(67874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.analytics.connector.b
 * JD-Core Version:    0.7.0.1
 */