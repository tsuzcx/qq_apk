package com.tencent.mm.plugin.lite.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class q
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(271599);
    Log.d("LiteAppJsApiWriteCommData", "Invoke writeCommData");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271599);
      return;
    }
    paramString = paramJSONObject.optString("packageName");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("LiteAppJsApiWriteCommData", "writeCommData fail, packageName is null");
      this.JZj.aJV("fail: packageName is null");
      AppMethodBeat.o(271599);
      return;
    }
    String str = paramJSONObject.optString("data");
    paramBoolean = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0).edit().putString(paramString, str).commit();
    if (paramJSONObject == null) {}
    for (;;)
    {
      Log.i("LiteAppJsApiWriteCommData", "writeCommData, ret = %b, packageName = %s, data length = %d", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(i) });
      if (!paramBoolean) {
        break;
      }
      this.JZj.fTW();
      AppMethodBeat.o(271599);
      return;
      i = paramJSONObject.length();
    }
    this.JZj.aJV("fail");
    AppMethodBeat.o(271599);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.q
 * JD-Core Version:    0.7.0.1
 */