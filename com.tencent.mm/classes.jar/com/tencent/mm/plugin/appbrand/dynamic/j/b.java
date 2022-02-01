package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  static g a(ContentValues paramContentValues)
  {
    AppMethodBeat.i(121477);
    if (paramContentValues != null)
    {
      g localg = new g();
      localg.field_id = paramContentValues.getAsString("id");
      localg.field_appId = paramContentValues.getAsString("appId");
      localg.field_cacheKey = paramContentValues.getAsString("cacheKey");
      localg.field_updateTime = Util.nullAsNil(paramContentValues.getAsLong("updateTime"));
      localg.field_interval = Util.nullAsNil(paramContentValues.getAsInteger("interval"));
      localg.systemRowid = Util.nullAsNil(paramContentValues.getAsLong("rowid"));
      AppMethodBeat.o(121477);
      return localg;
    }
    AppMethodBeat.o(121477);
    return null;
  }
  
  public static g ags(String paramString)
  {
    AppMethodBeat.i(121476);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    paramString = a((ContentValues)j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class));
    AppMethodBeat.o(121476);
    return paramString;
  }
  
  static class a
    implements m<Bundle, ContentValues>
  {}
  
  public static class b
    implements m<ContentValues, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */