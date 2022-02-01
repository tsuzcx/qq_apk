package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public static e YE(String paramString)
  {
    AppMethodBeat.i(121476);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    paramString = a((ContentValues)h.a(MainProcessIPCService.dkO, localBundle, a.class));
    AppMethodBeat.o(121476);
    return paramString;
  }
  
  static e a(ContentValues paramContentValues)
  {
    AppMethodBeat.i(121477);
    if (paramContentValues != null)
    {
      e locale = new e();
      locale.field_id = paramContentValues.getAsString("id");
      locale.field_appId = paramContentValues.getAsString("appId");
      locale.field_cacheKey = paramContentValues.getAsString("cacheKey");
      locale.field_updateTime = Util.nullAsNil(paramContentValues.getAsLong("updateTime"));
      locale.field_interval = Util.nullAsNil(paramContentValues.getAsInteger("interval"));
      locale.systemRowid = Util.nullAsNil(paramContentValues.getAsLong("rowid"));
      AppMethodBeat.o(121477);
      return locale;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */