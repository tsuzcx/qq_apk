package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class ci
  extends cc
{
  static final String f = "name";
  static final String g = "host";
  static final String h = "host_test";
  static final String i = "https";
  static final String j = "status";
  
  private void b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222698);
    paramJSONObject = (ck)JsonUtils.parseToModel(paramJSONObject, ck.class, new Object[0]);
    cm localcm = this.b;
    localcm.a = paramJSONObject.a;
    localcm.b = paramJSONObject.b;
    AppMethodBeat.o(222698);
  }
  
  final void a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    AppMethodBeat.i(222709);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(222709);
      return;
    }
    Object localObject = paramJSONObject.optString("name", null);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = (df)b((String)localObject);
      if (localObject != null)
      {
        int k = paramJSONObject.optInt("status", 1);
        String str1 = paramJSONObject.optString("host", null);
        String str2 = paramJSONObject.optString("host_test", null);
        boolean bool3 = paramJSONObject.optBoolean("https", true);
        if (k == 0) {
          break label155;
        }
        bool1 = true;
        ((dd)localObject).c = bool1;
        ((dd)localObject).b = bool3;
        if (!TextUtils.isEmpty(str1)) {
          ((df)localObject).d = str1;
        }
        if (!TextUtils.isEmpty(str2)) {
          ((df)localObject).e = str2;
        }
        if (k != 2) {
          break label160;
        }
      }
    }
    label155:
    label160:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((dd)localObject).a = bool1;
      AppMethodBeat.o(222709);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ci
 * JD-Core Version:    0.7.0.1
 */