package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.a.a;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar
  implements e
{
  @SuppressLint({"MissingPermission"})
  @Keep
  @KeepForSdk
  public List<com.google.firebase.components.a<?>> getComponents()
  {
    AppMethodBeat.i(116770);
    List localList = Collections.singletonList(com.google.firebase.components.a.x(com.google.firebase.analytics.connector.a.class).a(f.z(com.google.firebase.a.class)).a(f.z(Context.class)).a(a.bKn).xR());
    AppMethodBeat.o(116770);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar
 * JD-Core Version:    0.7.0.1
 */