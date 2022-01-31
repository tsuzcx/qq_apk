package com.google.firebase.iid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class q
{
  private static final long bfI;
  final String bfJ;
  private final String bfK;
  private final long timestamp;
  
  static
  {
    AppMethodBeat.i(108764);
    bfI = TimeUnit.DAYS.toMillis(7L);
    AppMethodBeat.o(108764);
  }
  
  private q(String paramString1, String paramString2, long paramLong)
  {
    this.bfJ = paramString1;
    this.bfK = paramString2;
    this.timestamp = paramLong;
  }
  
  static String b(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(108762);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("token", paramString1);
      localJSONObject.put("appVersion", paramString2);
      localJSONObject.put("timestamp", paramLong);
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(108762);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = String.valueOf(paramString1);
      new StringBuilder(String.valueOf(paramString1).length() + 24).append("Failed to encode token: ").append(paramString1);
      AppMethodBeat.o(108762);
    }
    return null;
  }
  
  static q ba(String paramString)
  {
    AppMethodBeat.i(108761);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(108761);
      return null;
    }
    if (paramString.startsWith("{")) {
      try
      {
        paramString = new JSONObject(paramString);
        paramString = new q(paramString.getString("token"), paramString.getString("appVersion"), paramString.getLong("timestamp"));
        AppMethodBeat.o(108761);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString = String.valueOf(paramString);
        new StringBuilder(String.valueOf(paramString).length() + 23).append("Failed to parse token: ").append(paramString);
        AppMethodBeat.o(108761);
        return null;
      }
    }
    paramString = new q(paramString, null, 0L);
    AppMethodBeat.o(108761);
    return paramString;
  }
  
  final boolean bb(String paramString)
  {
    AppMethodBeat.i(108763);
    if ((System.currentTimeMillis() > this.timestamp + bfI) || (!paramString.equals(this.bfK)))
    {
      AppMethodBeat.o(108763);
      return true;
    }
    AppMethodBeat.o(108763);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.iid.q
 * JD-Core Version:    0.7.0.1
 */