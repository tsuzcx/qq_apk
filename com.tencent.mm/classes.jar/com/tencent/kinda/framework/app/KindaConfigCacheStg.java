package com.tencent.kinda.framework.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.charset.Charset;

public class KindaConfigCacheStg
  extends j<KindaConfigCacheItem>
{
  public static final String SAVE_CHARSET = "ISO-8859-1";
  public static final String[] SQL_CREATE;
  public static final String TABLE_NAME = "KindaConfigCache";
  public static final String TAG = "MicroMsg.KindaConfigCacheStg";
  private e db;
  
  static
  {
    AppMethodBeat.i(144338);
    SQL_CREATE = new String[] { j.getCreateSQLs(KindaConfigCacheItem.info, "KindaConfigCache") };
    AppMethodBeat.o(144338);
  }
  
  public KindaConfigCacheStg(e parame)
  {
    super(parame, KindaConfigCacheItem.info, "KindaConfigCache", null);
    this.db = parame;
  }
  
  private KindaConfigCacheItem getImpl(String paramString)
  {
    AppMethodBeat.i(144323);
    paramString = this.db.rawQuery("select * from KindaConfigCache where key=?", new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(144323);
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(144323);
      return null;
    }
    paramString.moveToFirst();
    KindaConfigCacheItem localKindaConfigCacheItem = new KindaConfigCacheItem();
    localKindaConfigCacheItem.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(144323);
    return localKindaConfigCacheItem;
  }
  
  public static Object resolveObj(int paramInt, String paramString)
  {
    AppMethodBeat.i(144322);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(144322);
      return null;
      try
      {
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(144322);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.KindaConfigCacheStg", "exception:%s", new Object[] { "" });
      }
      paramString = Long.valueOf(paramString);
      AppMethodBeat.o(144322);
      return paramString;
      AppMethodBeat.o(144322);
      return paramString;
      paramString = Boolean.valueOf(paramString);
      AppMethodBeat.o(144322);
      return paramString;
      paramString = Float.valueOf(paramString);
      AppMethodBeat.o(144322);
      return paramString;
      paramString = Double.valueOf(paramString);
      AppMethodBeat.o(144322);
      return paramString;
      paramString = paramString.getBytes();
      AppMethodBeat.o(144322);
      return paramString;
    }
  }
  
  public Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(144321);
    paramString = getImpl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(144321);
      return paramObject;
    }
    paramString = resolveObj(paramString.field_type, paramString.field_value);
    if (paramString != null)
    {
      AppMethodBeat.o(144321);
      return paramString;
    }
    AppMethodBeat.o(144321);
    return paramObject;
  }
  
  public byte[] getBinary(String paramString)
  {
    AppMethodBeat.i(144327);
    paramString = (byte[])get(paramString, new byte[0]);
    AppMethodBeat.o(144327);
    return paramString;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(144324);
    int i = ((Integer)get(paramString, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(144324);
    return i;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(144325);
    long l = ((Long)get(paramString, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(144325);
    return l;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(144326);
    paramString = (String)get(paramString, "");
    AppMethodBeat.o(144326);
    return paramString;
  }
  
  public void put(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(144336);
    put(paramString, paramObject, paramInt, 0L);
    AppMethodBeat.o(144336);
  }
  
  public void put(String paramString, Object paramObject, int paramInt, long paramLong)
  {
    AppMethodBeat.i(144337);
    KindaConfigCacheItem localKindaConfigCacheItem = new KindaConfigCacheItem();
    localKindaConfigCacheItem.field_type = paramInt;
    localKindaConfigCacheItem.field_key = paramString;
    localKindaConfigCacheItem.field_expire_at = paramLong;
    if ((paramInt == 1) && ((paramObject instanceof Integer))) {
      localKindaConfigCacheItem.field_value = paramObject.toString();
    }
    for (;;)
    {
      replace(localKindaConfigCacheItem);
      AppMethodBeat.o(144337);
      return;
      if ((paramInt == 4) && ((paramObject instanceof Integer)))
      {
        localKindaConfigCacheItem.field_value = paramObject.toString();
      }
      else if ((paramInt == 6) && ((paramObject instanceof Double)))
      {
        localKindaConfigCacheItem.field_value = paramObject.toString();
      }
      else if ((paramInt == 5) && ((paramObject instanceof Float)))
      {
        localKindaConfigCacheItem.field_value = paramObject.toString();
      }
      else if ((paramInt == 2) && ((paramObject instanceof Long)))
      {
        localKindaConfigCacheItem.field_value = paramObject.toString();
      }
      else if ((paramInt == 3) && ((paramObject instanceof String)))
      {
        localKindaConfigCacheItem.field_value = paramObject.toString();
      }
      else
      {
        if ((paramInt != 7) || (!(paramObject instanceof byte[]))) {
          break;
        }
        localKindaConfigCacheItem.field_value = new String((byte[])paramObject, Charset.forName("ISO-8859-1"));
      }
    }
    AppMethodBeat.o(144337);
  }
  
  public void putBinary(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144331);
    put(paramString, paramArrayOfByte, 7);
    AppMethodBeat.o(144331);
  }
  
  public void putBinary(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(144335);
    put(paramString, paramArrayOfByte, 7, paramLong);
    AppMethodBeat.o(144335);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(144328);
    put(paramString, Integer.valueOf(paramInt), 1);
    AppMethodBeat.o(144328);
  }
  
  public void putInt(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(144332);
    put(paramString, Integer.valueOf(paramInt), 1, paramLong);
    AppMethodBeat.o(144332);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(144329);
    put(paramString, Long.valueOf(paramLong), 2);
    AppMethodBeat.o(144329);
  }
  
  public void putLong(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144333);
    put(paramString, Long.valueOf(paramLong1), 2, paramLong2);
    AppMethodBeat.o(144333);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144330);
    put(paramString1, paramString2, 3);
    AppMethodBeat.o(144330);
  }
  
  public void putString(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(144334);
    put(paramString1, paramString2, 3, paramLong);
    AppMethodBeat.o(144334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaConfigCacheStg
 * JD-Core Version:    0.7.0.1
 */