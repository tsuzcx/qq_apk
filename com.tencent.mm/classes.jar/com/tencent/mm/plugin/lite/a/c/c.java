package com.tencent.mm.plugin.lite.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.util.Base64;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271615);
    Log.d("LiteAppJsApiCalRqt", "Invoke calRqt");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("fail: data is null");
      AppMethodBeat.o(271615);
      return;
    }
    paramString = paramJSONObject.optString("rqt");
    if (Util.isNullOrNil(paramString))
    {
      this.JZj.aJV("fail: dataIn is null");
      AppMethodBeat.o(271615);
      return;
    }
    Object localObject = paramString.getBytes(Charset.forName("UTF-8"));
    paramString = new PInt();
    paramJSONObject = new PInt();
    PByteArray localPByteArray = new PByteArray();
    if (d.MtP.a(1, (byte[])localObject, 0, localObject.length, paramString, paramJSONObject, localPByteArray))
    {
      localObject = new HashMap(5);
      ((Map)localObject).put("k1", Integer.valueOf(paramString.value));
      ((Map)localObject).put("k2", Integer.valueOf(paramJSONObject.value));
      ((Map)localObject).put("data", Base64.encodeToString(localPByteArray.value, 2));
      this.JZj.az((Map)localObject);
      AppMethodBeat.o(271615);
      return;
    }
    Log.e("LiteAppJsApiCalRqt", "calrqt, connot calculate hash of rqt data.");
    this.JZj.aJV("fail");
    AppMethodBeat.o(271615);
  }
  
  public final int fEx()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.c
 * JD-Core Version:    0.7.0.1
 */