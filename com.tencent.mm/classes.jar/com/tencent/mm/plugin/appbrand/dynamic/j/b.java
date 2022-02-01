package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static f OL(String paramString)
  {
    AppMethodBeat.i(121476);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    paramString = a((ContentValues)h.a("com.tencent.mm", localBundle, a.class));
    AppMethodBeat.o(121476);
    return paramString;
  }
  
  static f a(ContentValues paramContentValues)
  {
    AppMethodBeat.i(121477);
    if (paramContentValues != null)
    {
      f localf = new f();
      localf.field_id = paramContentValues.getAsString("id");
      localf.field_appId = paramContentValues.getAsString("appId");
      localf.field_cacheKey = paramContentValues.getAsString("cacheKey");
      localf.field_updateTime = bt.g(paramContentValues.getAsLong("updateTime"));
      localf.field_interval = bt.n(paramContentValues.getAsInteger("interval"));
      localf.systemRowid = bt.g(paramContentValues.getAsLong("rowid"));
      AppMethodBeat.o(121477);
      return localf;
    }
    AppMethodBeat.o(121477);
    return null;
  }
  
  static class a
    implements k<Bundle, ContentValues>
  {}
  
  public static class b
    implements k<ContentValues, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */