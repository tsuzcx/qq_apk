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
  private static volatile a bKB;
  private final AppMeasurement bKA;
  @VisibleForTesting
  final Map<String, Object> bKC;
  
  private b(AppMeasurement paramAppMeasurement)
  {
    AppMethodBeat.i(116766);
    Preconditions.checkNotNull(paramAppMeasurement);
    this.bKA = paramAppMeasurement;
    this.bKC = new ConcurrentHashMap();
    AppMethodBeat.o(116766);
  }
  
  @KeepForSdk
  public static a ao(Context paramContext)
  {
    AppMethodBeat.i(116767);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (bKB == null) {}
    try
    {
      if (bKB == null) {
        bKB = new b(AppMeasurement.getInstance(paramContext));
      }
      paramContext = bKB;
      AppMethodBeat.o(116767);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(116767);
    }
  }
  
  @KeepForSdk
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(116768);
    if (!com.google.firebase.analytics.connector.internal.b.bM(paramString1))
    {
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0)
      {
        "Origin not allowed : ".concat(paramString1);
        AppMethodBeat.o(116768);
        return;
      }
      new String("Origin not allowed : ");
      AppMethodBeat.o(116768);
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.b.e(paramString2, paramBundle))
    {
      AppMethodBeat.o(116768);
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.b.a(paramString1, paramString2, paramBundle))
    {
      AppMethodBeat.o(116768);
      return;
    }
    this.bKA.logEventInternal(paramString1, paramString2, paramBundle);
    AppMethodBeat.o(116768);
  }
  
  @KeepForSdk
  public final void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(116769);
    if (!com.google.firebase.analytics.connector.internal.b.bM(paramString1))
    {
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0)
      {
        "Origin not allowed : ".concat(paramString1);
        AppMethodBeat.o(116769);
        return;
      }
      new String("Origin not allowed : ");
      AppMethodBeat.o(116769);
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.b.bN(paramString2))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0)
      {
        "User Property not allowed : ".concat(paramString1);
        AppMethodBeat.o(116769);
        return;
      }
      new String("User Property not allowed : ");
      AppMethodBeat.o(116769);
      return;
    }
    if (((paramString2.equals("_ce1")) || (paramString2.equals("_ce2"))) && (!paramString1.equals("fcm")) && (!paramString1.equals("frc")))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0)
      {
        "User Property not allowed for this origin: ".concat(paramString1);
        AppMethodBeat.o(116769);
        return;
      }
      new String("User Property not allowed for this origin: ");
      AppMethodBeat.o(116769);
      return;
    }
    this.bKA.setUserPropertyInternal(paramString1, paramString2, paramObject);
    AppMethodBeat.o(116769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.analytics.connector.b
 * JD-Core Version:    0.7.0.1
 */