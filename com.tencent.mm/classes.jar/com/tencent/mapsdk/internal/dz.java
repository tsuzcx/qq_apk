package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonParser.Deserializer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dz
  implements JsonParser.Deserializer<ec.a.a.a>
{
  private static ec.a.a.a a(Object paramObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(222896);
    if (paramObject == null)
    {
      AppMethodBeat.o(222896);
      return null;
    }
    Object localObject1 = localObject2;
    String str;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      str = paramObject.getString("type");
      if (TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(222896);
        return null;
      }
      if (!"Point".equalsIgnoreCase(str)) {
        break label83;
      }
      localObject1 = (ec.a.a.a)JsonUtils.parseToModel(paramObject, ec.a.a.c.class, new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(222896);
      return localObject1;
      label83:
      if ("Points".equalsIgnoreCase(str))
      {
        localObject1 = (ec.a.a.a)JsonUtils.parseToModel(paramObject, ec.a.a.d.class, new Object[0]);
      }
      else
      {
        localObject1 = localObject2;
        if ("Line".equalsIgnoreCase(str)) {
          localObject1 = (ec.a.a.a)JsonUtils.parseToModel(paramObject, ec.a.a.b.class, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dz
 * JD-Core Version:    0.7.0.1
 */