package com.tencent.liteav.audio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private final SharedPreferences a;
  
  private b()
  {
    AppMethodBeat.i(230390);
    this.a = TXCCommonUtil.getAppContext().getSharedPreferences("txc_audio_settings", 0);
    AppMethodBeat.o(230390);
  }
  
  public static b a()
  {
    AppMethodBeat.i(230384);
    b localb = a.a();
    AppMethodBeat.o(230384);
    return localb;
  }
  
  private void a(String paramString, Object paramObject)
  {
    AppMethodBeat.i(230394);
    SharedPreferences.Editor localEditor = this.a.edit();
    if ((paramObject instanceof Integer)) {
      localEditor.putInt(paramString, ((Integer)paramObject).intValue());
    }
    for (;;)
    {
      localEditor.commit();
      AppMethodBeat.o(230394);
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
    AppMethodBeat.i(230400);
    try
    {
      if ((paramObject instanceof String))
      {
        String str = this.a.getString(paramString, paramObject.toString());
        AppMethodBeat.o(230400);
        return str;
      }
      if ((paramObject instanceof Integer))
      {
        int i = this.a.getInt(paramString, ((Integer)paramObject).intValue());
        AppMethodBeat.o(230400);
        return Integer.valueOf(i);
      }
      if ((paramObject instanceof Boolean))
      {
        boolean bool = this.a.getBoolean(paramString, ((Boolean)paramObject).booleanValue());
        AppMethodBeat.o(230400);
        return Boolean.valueOf(bool);
      }
      if ((paramObject instanceof Long))
      {
        long l = this.a.getLong(paramString, ((Long)paramObject).longValue());
        AppMethodBeat.o(230400);
        return Long.valueOf(l);
      }
      if ((paramObject instanceof Float))
      {
        float f = this.a.getFloat(paramString, ((Float)paramObject).floatValue());
        AppMethodBeat.o(230400);
        return Float.valueOf(f);
      }
      if ((paramObject instanceof Double))
      {
        double d = Double.longBitsToDouble(this.a.getLong(paramString, Double.doubleToLongBits(((Double)paramObject).doubleValue())));
        AppMethodBeat.o(230400);
        return Double.valueOf(d);
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCAudioSettings", "get value from sharedpreference failed for key: %s", new Object[] { paramString, localException });
      AppMethodBeat.o(230400);
      return paramObject;
    }
    AppMethodBeat.o(230400);
    return paramObject;
  }
  
  public void a(String paramString, long paramLong)
  {
    AppMethodBeat.i(230409);
    a(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(230409);
  }
  
  public long b(String paramString, long paramLong)
  {
    AppMethodBeat.i(230418);
    paramLong = ((Long)b(paramString, Long.valueOf(paramLong))).longValue();
    AppMethodBeat.o(230418);
    return paramLong;
  }
  
  static class a
  {
    private static final b a;
    
    static
    {
      AppMethodBeat.i(230372);
      a = new b(null);
      AppMethodBeat.o(230372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.b
 * JD-Core Version:    0.7.0.1
 */