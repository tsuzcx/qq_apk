package com.facebook.appevents;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

class AppEvent
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final HashSet<String> validatedIdentifiers;
  private final String checksum;
  private final boolean isImplicit;
  private final JSONObject jsonObject;
  private final String name;
  
  static
  {
    AppMethodBeat.i(71876);
    validatedIdentifiers = new HashSet();
    AppMethodBeat.o(71876);
  }
  
  public AppEvent(String paramString1, String paramString2, Double paramDouble, Bundle paramBundle, boolean paramBoolean, UUID paramUUID)
  {
    AppMethodBeat.i(71867);
    this.jsonObject = getJSONObjectForAppEvent(paramString1, paramString2, paramDouble, paramBundle, paramBoolean, paramUUID);
    this.isImplicit = paramBoolean;
    this.name = paramString2;
    this.checksum = calculateChecksum();
    AppMethodBeat.o(71867);
  }
  
  private AppEvent(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(71868);
    this.jsonObject = new JSONObject(paramString1);
    this.isImplicit = paramBoolean;
    this.name = this.jsonObject.optString("_eventName");
    this.checksum = paramString2;
    AppMethodBeat.o(71868);
  }
  
  private String calculateChecksum()
  {
    AppMethodBeat.i(71874);
    if (Build.VERSION.SDK_INT > 19)
    {
      localObject1 = md5Checksum(this.jsonObject.toString());
      AppMethodBeat.o(71874);
      return localObject1;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = this.jsonObject.keys();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(((Iterator)localObject1).next());
    }
    Collections.sort((List)localObject2);
    localObject1 = new StringBuilder();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(str).append(" = ").append(this.jsonObject.optString(str)).append('\n');
    }
    localObject1 = md5Checksum(((StringBuilder)localObject1).toString());
    AppMethodBeat.o(71874);
    return localObject1;
  }
  
  private static JSONObject getJSONObjectForAppEvent(String paramString1, String paramString2, Double paramDouble, Bundle paramBundle, boolean paramBoolean, UUID paramUUID)
  {
    AppMethodBeat.i(71871);
    validateIdentifier(paramString2);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_eventName", paramString2);
    localJSONObject.put("_eventName_md5", md5Checksum(paramString2));
    localJSONObject.put("_logTime", System.currentTimeMillis() / 1000L);
    localJSONObject.put("_ui", paramString1);
    if (paramUUID != null) {
      localJSONObject.put("_session_id", paramUUID);
    }
    if (paramDouble != null) {
      localJSONObject.put("_valueToSum", paramDouble.doubleValue());
    }
    if (paramBoolean) {
      localJSONObject.put("_implicitlyLogged", "1");
    }
    if (paramBundle != null)
    {
      paramString1 = paramBundle.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        validateIdentifier(paramString2);
        paramDouble = paramBundle.get(paramString2);
        if ((!(paramDouble instanceof String)) && (!(paramDouble instanceof Number)))
        {
          paramString1 = new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] { paramDouble, paramString2 }));
          AppMethodBeat.o(71871);
          throw paramString1;
        }
        localJSONObject.put(paramString2, paramDouble.toString());
      }
    }
    if (!paramBoolean) {
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", new Object[] { localJSONObject.toString() });
    }
    AppMethodBeat.o(71871);
    return localJSONObject;
  }
  
  private static String md5Checksum(String paramString)
  {
    AppMethodBeat.i(71875);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      paramString = paramString.getBytes("UTF-8");
      localMessageDigest.update(paramString, 0, paramString.length);
      paramString = AppEventUtility.bytesToHex(localMessageDigest.digest());
      AppMethodBeat.o(71875);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Utility.logd("Failed to generate checksum: ", paramString);
      AppMethodBeat.o(71875);
      return "0";
    }
    catch (UnsupportedEncodingException paramString)
    {
      Utility.logd("Failed to generate checksum: ", paramString);
      AppMethodBeat.o(71875);
    }
    return "1";
  }
  
  private static void validateIdentifier(String paramString)
  {
    AppMethodBeat.i(71870);
    if ((paramString == null) || (paramString.length() == 0) || (paramString.length() > 40))
    {
      ??? = paramString;
      if (paramString == null) {
        ??? = "<None Provided>";
      }
      paramString = new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] { ???, Integer.valueOf(40) }));
      AppMethodBeat.o(71870);
      throw paramString;
    }
    synchronized (validatedIdentifiers)
    {
      boolean bool = validatedIdentifiers.contains(paramString);
      if (bool) {
        break label182;
      }
      if (!paramString.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
        break label152;
      }
    }
    synchronized (validatedIdentifiers)
    {
      validatedIdentifiers.add(paramString);
      AppMethodBeat.o(71870);
      return;
      paramString = finally;
      AppMethodBeat.o(71870);
      throw paramString;
    }
    label152:
    paramString = new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] { paramString }));
    AppMethodBeat.o(71870);
    throw paramString;
    label182:
    AppMethodBeat.o(71870);
  }
  
  private Object writeReplace()
  {
    AppMethodBeat.i(71872);
    AppEvent.SerializationProxyV2 localSerializationProxyV2 = new AppEvent.SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum, null);
    AppMethodBeat.o(71872);
    return localSerializationProxyV2;
  }
  
  public boolean getIsImplicit()
  {
    return this.isImplicit;
  }
  
  public JSONObject getJSONObject()
  {
    return this.jsonObject;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isChecksumValid()
  {
    AppMethodBeat.i(71869);
    if (this.checksum == null)
    {
      AppMethodBeat.o(71869);
      return true;
    }
    boolean bool = calculateChecksum().equals(this.checksum);
    AppMethodBeat.o(71869);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(71873);
    String str = String.format("\"%s\", implicit: %b, json: %s", new Object[] { this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString() });
    AppMethodBeat.o(71873);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.AppEvent
 * JD-Core Version:    0.7.0.1
 */