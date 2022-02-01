package com.google.firebase.iid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class q
{
  private static final long bBp;
  final String bBq;
  private final String bBr;
  private final long timestamp;
  
  static
  {
    AppMethodBeat.i(4200);
    bBp = TimeUnit.DAYS.toMillis(7L);
    AppMethodBeat.o(4200);
  }
  
  private q(String paramString1, String paramString2, long paramLong)
  {
    this.bBq = paramString1;
    this.bBr = paramString2;
    this.timestamp = paramLong;
  }
  
  static q aY(String paramString)
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
  
  final boolean aZ(String paramString)
  {
    AppMethodBeat.i(4199);
    if ((System.currentTimeMillis() > this.timestamp + bBp) || (!paramString.equals(this.bBr)))
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