package com.google.firebase.iid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class q
{
  private static final long bDH;
  final String bDI;
  private final String bDJ;
  private final long timestamp;
  
  static
  {
    AppMethodBeat.i(4200);
    bDH = TimeUnit.DAYS.toMillis(7L);
    AppMethodBeat.o(4200);
  }
  
  private q(String paramString1, String paramString2, long paramLong)
  {
    this.bDI = paramString1;
    this.bDJ = paramString2;
    this.timestamp = paramLong;
  }
  
  static String b(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(4198);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("token", paramString1);
      localJSONObject.put("appVersion", paramString2);
      localJSONObject.put("timestamp", paramLong);
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(4198);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = String.valueOf(paramString1);
      new StringBuilder(String.valueOf(paramString1).length() + 24).append("Failed to encode token: ").append(paramString1);
      AppMethodBeat.o(4198);
    }
    return null;
  }
  
  static q bh(String paramString)
  {
    AppMethodBeat.i(4197);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(4197);
      return null;
    }
    if (paramString.startsWith("{")) {
      try
      {
        paramString = new JSONObject(paramString);
        paramString = new q(paramString.getString("token"), paramString.getString("appVersion"), paramString.getLong("timestamp"));
        AppMethodBeat.o(4197);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString = String.valueOf(paramString);
        new StringBuilder(String.valueOf(paramString).length() + 23).append("Failed to parse token: ").append(paramString);
        AppMethodBeat.o(4197);
        return null;
      }
    }
    paramString = new q(paramString, null, 0L);
    AppMethodBeat.o(4197);
    return paramString;
  }
  
  final boolean bi(String paramString)
  {
    AppMethodBeat.i(4199);
    if ((System.currentTimeMillis() > this.timestamp + bDH) || (!paramString.equals(this.bDJ)))
    {
      AppMethodBeat.o(4199);
      return true;
    }
    AppMethodBeat.o(4199);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.firebase.iid.q
 * JD-Core Version:    0.7.0.1
 */