package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  static g a(ContentValues paramContentValues)
  {
    if (paramContentValues != null)
    {
      g localg = new g();
      localg.field_id = paramContentValues.getAsString("id");
      localg.field_appId = paramContentValues.getAsString("appId");
      localg.field_cacheKey = paramContentValues.getAsString("cacheKey");
      localg.field_updateTime = bk.c(paramContentValues.getAsLong("updateTime"));
      localg.field_interval = bk.g(paramContentValues.getAsInteger("interval"));
      localg.ujK = bk.c(paramContentValues.getAsLong("rowid"));
      return localg;
    }
    return null;
  }
  
  public static g tl(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    return a((ContentValues)f.a("com.tencent.mm", localBundle, a.class));
  }
  
  private static class a
    implements i<Bundle, ContentValues>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */