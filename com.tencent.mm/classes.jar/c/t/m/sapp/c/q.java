package c.t.m.sapp.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class q
{
  public static volatile SharedPreferences a;
  public static Context b;
  
  public static SharedPreferences a()
  {
    try
    {
      AppMethodBeat.i(186138);
      if (a == null) {
        a = b.getSharedPreferences("TLocationSDK", 0);
      }
      SharedPreferences localSharedPreferences = a;
      AppMethodBeat.o(186138);
      return localSharedPreferences;
    }
    finally {}
  }
  
  public static SharedPreferences a(String paramString)
  {
    AppMethodBeat.i(186150);
    if ("TLocationSDK".equals(paramString))
    {
      paramString = a();
      AppMethodBeat.o(186150);
      return paramString;
    }
    String str = b.getPackageName();
    int i = 0;
    if ("com.tencent.mobileqq".equals(str)) {
      i = 4;
    }
    paramString = b.getSharedPreferences(paramString, i);
    AppMethodBeat.o(186150);
    return paramString;
  }
  
  public static Object a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    AppMethodBeat.i(186162);
    if ((paramObject instanceof String))
    {
      paramSharedPreferences = paramSharedPreferences.getString(paramString, (String)paramObject);
      AppMethodBeat.o(186162);
      return paramSharedPreferences;
    }
    if ((paramObject instanceof Integer))
    {
      int i = paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(186162);
      return Integer.valueOf(i);
    }
    if ((paramObject instanceof Boolean))
    {
      boolean bool = paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(186162);
      return Boolean.valueOf(bool);
    }
    if ((paramObject instanceof Float))
    {
      float f = paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue());
      AppMethodBeat.o(186162);
      return Float.valueOf(f);
    }
    if ((paramObject instanceof Long))
    {
      long l = paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(186162);
      return Long.valueOf(l);
    }
    AppMethodBeat.o(186162);
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(186157);
    paramString1 = a(a(paramString1), paramString2, paramObject);
    AppMethodBeat.o(186157);
    return paramString1;
  }
  
  public static void b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    AppMethodBeat.i(186156);
    paramSharedPreferences = paramSharedPreferences.edit();
    if ((paramObject instanceof String)) {
      paramSharedPreferences.putString(paramString, (String)paramObject);
    }
    while (Build.VERSION.SDK_INT >= 9)
    {
      paramSharedPreferences.apply();
      AppMethodBeat.o(186156);
      return;
      if ((paramObject instanceof Integer)) {
        paramSharedPreferences.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Boolean)) {
        paramSharedPreferences.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject instanceof Float)) {
        paramSharedPreferences.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Long)) {
        paramSharedPreferences.putLong(paramString, ((Long)paramObject).longValue());
      } else {
        paramSharedPreferences.putString(paramString, paramObject.toString());
      }
    }
    paramSharedPreferences.commit();
    AppMethodBeat.o(186156);
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(186153);
    b(a(paramString1), paramString2, paramObject);
    AppMethodBeat.o(186153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     c.t.m.sapp.c.q
 * JD-Core Version:    0.7.0.1
 */