package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public class AppEventsLoggerUtility
{
  private static final Map<AppEventsLoggerUtility.GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING;
  
  static
  {
    AppMethodBeat.i(17606);
    API_ACTIVITY_TYPE_TO_STRING = new AppEventsLoggerUtility.1();
    AppMethodBeat.o(17606);
  }
  
  public static JSONObject getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType paramGraphAPIActivityType, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(17605);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(paramGraphAPIActivityType));
    paramGraphAPIActivityType = AppEventsLogger.getUserID();
    if (paramGraphAPIActivityType != null) {
      localJSONObject.put("app_user_id", paramGraphAPIActivityType);
    }
    paramGraphAPIActivityType = AppEventsLogger.getUserData();
    if (paramGraphAPIActivityType != null) {
      localJSONObject.put("ud", paramGraphAPIActivityType);
    }
    Utility.setAppEventAttributionParameters(localJSONObject, paramAttributionIdentifiers, paramString, paramBoolean);
    try
    {
      Utility.setAppEventExtendedDeviceInfoParameters(localJSONObject, paramContext);
      localJSONObject.put("application_package_name", paramContext.getPackageName());
      AppMethodBeat.o(17605);
      return localJSONObject;
    }
    catch (Exception paramGraphAPIActivityType)
    {
      for (;;)
      {
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", new Object[] { paramGraphAPIActivityType.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.appevents.internal.AppEventsLoggerUtility
 * JD-Core Version:    0.7.0.1
 */