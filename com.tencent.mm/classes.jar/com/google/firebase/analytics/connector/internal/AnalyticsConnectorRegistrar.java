package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.components.a.a;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public class AnalyticsConnectorRegistrar
  implements e
{
  public List<com.google.firebase.components.a<?>> getComponents()
  {
    AppMethodBeat.i(116770);
    List localList = Collections.singletonList(com.google.firebase.components.a.w(com.google.firebase.analytics.connector.a.class).a(f.y(com.google.firebase.a.class)).a(f.y(Context.class)).a(a.dBQ).Ye());
    AppMethodBeat.o(116770);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar
 * JD-Core Version:    0.7.0.1
 */