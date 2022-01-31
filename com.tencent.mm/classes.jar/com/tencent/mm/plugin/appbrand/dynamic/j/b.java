package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public static com.tencent.mm.plugin.appbrand.widget.f Bp(String paramString)
  {
    AppMethodBeat.i(10995);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    paramString = a((ContentValues)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", localBundle, a.class));
    AppMethodBeat.o(10995);
    return paramString;
  }
  
  static com.tencent.mm.plugin.appbrand.widget.f a(ContentValues paramContentValues)
  {
    AppMethodBeat.i(10996);
    if (paramContentValues != null)
    {
      com.tencent.mm.plugin.appbrand.widget.f localf = new com.tencent.mm.plugin.appbrand.widget.f();
      localf.field_id = paramContentValues.getAsString("id");
      localf.field_appId = paramContentValues.getAsString("appId");
      localf.field_cacheKey = paramContentValues.getAsString("cacheKey");
      localf.field_updateTime = bo.c(paramContentValues.getAsLong("updateTime"));
      localf.field_interval = bo.g(paramContentValues.getAsInteger("interval"));
      localf.systemRowid = bo.c(paramContentValues.getAsLong("rowid"));
      AppMethodBeat.o(10996);
      return localf;
    }
    AppMethodBeat.o(10996);
    return null;
  }
  
  static class a
    implements i<Bundle, ContentValues>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */