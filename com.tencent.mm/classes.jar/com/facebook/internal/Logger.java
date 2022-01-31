package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Logger
{
  public static final String LOG_TAG_BASE = "FacebookSDK.";
  private static final HashMap<String, String> stringsToReplace;
  private final LoggingBehavior behavior;
  private StringBuilder contents;
  private int priority;
  private final String tag;
  
  static
  {
    AppMethodBeat.i(72422);
    stringsToReplace = new HashMap();
    AppMethodBeat.o(72422);
  }
  
  public Logger(LoggingBehavior paramLoggingBehavior, String paramString)
  {
    AppMethodBeat.i(72412);
    this.priority = 3;
    Validate.notNullOrEmpty(paramString, "tag");
    this.behavior = paramLoggingBehavior;
    this.tag = "FacebookSDK.".concat(String.valueOf(paramString));
    this.contents = new StringBuilder();
    AppMethodBeat.o(72412);
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(72410);
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior))
    {
      String str = replaceStrings(paramString2);
      paramString2 = paramString1;
      if (!paramString1.startsWith("FacebookSDK.")) {
        paramString2 = "FacebookSDK.".concat(String.valueOf(paramString1));
      }
      Log.println(paramInt, paramString2, str);
      if (paramLoggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
        new Exception();
      }
    }
    AppMethodBeat.o(72410);
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(72409);
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
      log(paramLoggingBehavior, paramInt, paramString1, String.format(paramString2, paramVarArgs));
    }
    AppMethodBeat.o(72409);
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2)
  {
    AppMethodBeat.i(72407);
    log(paramLoggingBehavior, 3, paramString1, paramString2);
    AppMethodBeat.o(72407);
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(72408);
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
      log(paramLoggingBehavior, 3, paramString1, String.format(paramString2, paramVarArgs));
    }
    AppMethodBeat.o(72408);
  }
  
  public static void registerAccessToken(String paramString)
  {
    try
    {
      AppMethodBeat.i(72406);
      if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
        registerStringToReplace(paramString, "ACCESS_TOKEN_REMOVED");
      }
      AppMethodBeat.o(72406);
      return;
    }
    finally {}
  }
  
  public static void registerStringToReplace(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(72405);
      stringsToReplace.put(paramString1, paramString2);
      AppMethodBeat.o(72405);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private static String replaceStrings(String paramString)
  {
    try
    {
      AppMethodBeat.i(72411);
      Iterator localIterator = stringsToReplace.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramString = paramString.replace((CharSequence)localEntry.getKey(), (CharSequence)localEntry.getValue());
      }
      AppMethodBeat.o(72411);
      return paramString;
    }
    finally {}
  }
  
  private boolean shouldLog()
  {
    AppMethodBeat.i(72421);
    boolean bool = FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    AppMethodBeat.o(72421);
    return bool;
  }
  
  public void append(String paramString)
  {
    AppMethodBeat.i(72418);
    if (shouldLog()) {
      this.contents.append(paramString);
    }
    AppMethodBeat.o(72418);
  }
  
  public void append(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (shouldLog()) {
      this.contents.append(String.format(paramString, paramVarArgs));
    }
    AppMethodBeat.o(72419);
  }
  
  public void append(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(72417);
    if (shouldLog()) {
      this.contents.append(paramStringBuilder);
    }
    AppMethodBeat.o(72417);
  }
  
  public void appendKeyValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(72420);
    append("  %s:\t%s\n", new Object[] { paramString, paramObject });
    AppMethodBeat.o(72420);
  }
  
  public String getContents()
  {
    AppMethodBeat.i(72414);
    String str = replaceStrings(this.contents.toString());
    AppMethodBeat.o(72414);
    return str;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public void log()
  {
    AppMethodBeat.i(72415);
    logString(this.contents.toString());
    this.contents = new StringBuilder();
    AppMethodBeat.o(72415);
  }
  
  public void logString(String paramString)
  {
    AppMethodBeat.i(72416);
    log(this.behavior, this.priority, this.tag, paramString);
    AppMethodBeat.o(72416);
  }
  
  public void setPriority(int paramInt)
  {
    AppMethodBeat.i(72413);
    Validate.oneOf(Integer.valueOf(paramInt), "value", new Object[] { Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(5) });
    this.priority = paramInt;
    AppMethodBeat.o(72413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.internal.Logger
 * JD-Core Version:    0.7.0.1
 */