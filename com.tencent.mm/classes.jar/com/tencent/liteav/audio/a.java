package com.tencent.liteav.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private final SharedPreferences a;
  
  private a()
  {
    AppMethodBeat.i(221863);
    this.a = TXCCommonUtil.getAppContext().getSharedPreferences("txc_audio_settings", 0);
    AppMethodBeat.o(221863);
  }
  
  public static a a()
  {
    AppMethodBeat.i(221862);
    a locala = a.a();
    AppMethodBeat.o(221862);
    return locala;
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void a(String paramString, Object paramObject)
  {
    AppMethodBeat.i(221866);
    SharedPreferences.Editor localEditor = this.a.edit();
    if ((paramObject instanceof Integer)) {
      localEditor.putInt(paramString, ((Integer)paramObject).intValue());
    }
    for (;;)
    {
      localEditor.commit();
      AppMethodBeat.o(221866);
      return;
      if ((paramObject instanceof String)) {
        localEditor.putString(paramString, paramObject.toString());
      } else if ((paramObject instanceof Boolean)) {
        localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject instanceof Long)) {
        localEditor.putLong(paramString, ((Long)paramObject).longValue());
      } else if ((paramObject instanceof Float)) {
        localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Double)) {
        localEditor.putLong(paramString, Double.doubleToRawLongBits(((Double)paramObject).doubleValue()));
      }
    }
  }
  
  private Object b(String paramString, Object paramObject)
  {
    AppMethodBeat.i(221867);
    try
    {
      if ((paramObject instanceof String))
      {
        String str = this.a.getString(paramString, paramObject.toString());
        AppMethodBeat.o(221867);
        return str;
      }
      if ((paramObject instanceof Integer))
      {
        int i = this.a.getInt(paramString, ((Integer)paramObject).intValue());
        AppMethodBeat.o(221867);
        return Integer.valueOf(i);
      }
      if ((paramObject instanceof Boolean))
      {
        boolean bool = this.a.getBoolean(paramString, ((Boolean)paramObject).booleanValue());
        AppMethodBeat.o(221867);
        return Boolean.valueOf(bool);
      }
      if ((paramObject instanceof Long))
      {
        long l = this.a.getLong(paramString, ((Long)paramObject).longValue());
        AppMethodBeat.o(221867);
        return Long.valueOf(l);
      }
      if ((paramObject instanceof Float))
      {
        float f = this.a.getFloat(paramString, ((Float)paramObject).floatValue());
        AppMethodBeat.o(221867);
        return Float.valueOf(f);
      }
      if ((paramObject instanceof Double))
      {
        double d = Double.longBitsToDouble(this.a.getLong(paramString, Double.doubleToLongBits(((Double)paramObject).doubleValue())));
        AppMethodBeat.o(221867);
        return Double.valueOf(d);
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCAudioSettings", "get value from sharedpreference failed for key: %s", new Object[] { paramString, localException });
      AppMethodBeat.o(221867);
      return paramObject;
    }
    AppMethodBeat.o(221867);
    return paramObject;
  }
  
  public void a(String paramString, long paramLong)
  {
    AppMethodBeat.i(221864);
    a(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(221864);
  }
  
  public long b(String paramString, long paramLong)
  {
    AppMethodBeat.i(221865);
    paramLong = ((Long)b(paramString, Long.valueOf(paramLong))).longValue();
    AppMethodBeat.o(221865);
    return paramLong;
  }
  
  static class a
  {
    private static final a a;
    
    static
    {
      AppMethodBeat.i(221787);
      a = new a(null);
      AppMethodBeat.o(221787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.a
 * JD-Core Version:    0.7.0.1
 */