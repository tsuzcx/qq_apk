package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public static h Zo(String paramString)
  {
    AppMethodBeat.i(121476);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    paramString = a((ContentValues)j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class));
    AppMethodBeat.o(121476);
    return paramString;
  }
  
  static h a(ContentValues paramContentValues)
  {
    AppMethodBeat.i(121477);
    if (paramContentValues != null)
    {
      h localh = new h();
      localh.field_id = paramContentValues.getAsString("id");
      localh.field_appId = paramContentValues.getAsString("appId");
      localh.field_cacheKey = paramContentValues.getAsString("cacheKey");
      localh.field_updateTime = Util.nullAsNil(paramContentValues.getAsLong("updateTime"));
      localh.field_interval = Util.nullAsNil(paramContentValues.getAsInteger("interval"));
      localh.systemRowid = Util.nullAsNil(paramContentValues.getAsLong("rowid"));
      AppMethodBeat.o(121477);
      return localh;
    }
    AppMethodBeat.o(121477);
    return null;
  }
  
  static class a
    implements m<Bundle, ContentValues>
  {}
  
  public static class b
    implements m<ContentValues, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */