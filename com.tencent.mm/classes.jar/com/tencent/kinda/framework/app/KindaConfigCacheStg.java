package com.tencent.kinda.framework.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.nio.charset.Charset;

public class KindaConfigCacheStg
  extends MAutoStorage<KindaConfigCacheItem>
{
  public static final String SAVE_CHARSET = "ISO-8859-1";
  public static final String[] SQL_CREATE;
  public static final String TABLE_NAME = "KindaConfigCache";
  public static final String TAG = "MicroMsg.KindaConfigCacheStg";
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(18410);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(KindaConfigCacheItem.info, "KindaConfigCache") };
    AppMethodBeat.o(18410);
  }
  
  public KindaConfigCacheStg(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, KindaConfigCacheItem.info, "KindaConfigCache", null);
    this.db = paramISQLiteDatabase;
  }
  
  private KindaConfigCacheItem getImpl(String paramString)
  {
    AppMethodBeat.i(18395);
    paramString = this.db.rawQuery("select * from KindaConfigCache where key=?", new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(18395);
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(18395);
      return null;
    }
    paramString.moveToFirst();
    KindaConfigCacheItem localKindaConfigCacheItem = new KindaConfigCacheItem();
    localKindaConfigCacheItem.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(18395);
    return localKindaConfigCacheItem;
  }
  
  public static Object resolveObj(int paramInt, String paramString)
  {
    AppMethodBeat.i(18394);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18394);
      return null;
      try
      {
        paramInt = Util.getInt(paramString, 0);
        AppMethodBeat.o(18394);
        return Integer.valueOf(paramInt);
      }
      catch (Exception paramString)
      {
        long l;
        float f;
        double d;
        Log.e("MicroMsg.KindaConfigCacheStg", "exception:%s", new Object[] { "" });
      }
      l = Util.getLong(paramString, 0L);
      AppMethodBeat.o(18394);
      return Long.valueOf(l);
      AppMethodBeat.o(18394);
      return paramString;
      paramString = Boolean.valueOf(paramString);
      AppMethodBeat.o(18394);
      return paramString;
      f = Util.getFloat(paramString, 0.0F);
      AppMethodBeat.o(18394);
      return Float.valueOf(f);
      d = Util.getDouble(paramString, 0.0D);
      AppMethodBeat.o(18394);
      return Double.valueOf(d);
      paramString = paramString.getBytes();
      AppMethodBeat.o(18394);
      return paramString;
    }
  }
  
  public Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(18393);
    paramString = getImpl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(18393);
      return paramObject;
    }
    paramString = resolveObj(paramString.field_type, paramString.field_value);
    if (paramString != null)
    {
      AppMethodBeat.o(18393);
      return paramString;
    }
    AppMethodBeat.o(18393);
    return paramObject;
  }
  
  public byte[] getBinary(String paramString)
  {
    AppMethodBeat.i(18399);
    paramString = (byte[])get(paramString, new byte[0]);
    AppMethodBeat.o(18399);
    return paramString;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(18396);
    int i = ((Integer)get(paramString, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(18396);
    return i;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(18397);
    long l = ((Long)get(paramString, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(18397);
    return l;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(18398);
    paramString = (String)get(paramString, "");
    AppMethodBeat.o(18398);
    return paramString;
  }
  
  public void put(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(18408);
    put(paramString, paramObject, paramInt, 0L);
    AppMethodBeat.o(18408);
  }
  
  public void put(String paramString, Object paramObject, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18409);
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
      AppMethodBeat.o(18409);
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
    AppMethodBeat.o(18409);
  }
  
  public void putBinary(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18403);
    put(paramString, paramArrayOfByte, 7);
    AppMethodBeat.o(18403);
  }
  
  public void putBinary(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(18407);
    put(paramString, paramArrayOfByte, 7, paramLong);
    AppMethodBeat.o(18407);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(18400);
    put(paramString, Integer.valueOf(paramInt), 1);
    AppMethodBeat.o(18400);
  }
  
  public void putInt(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18404);
    put(paramString, Integer.valueOf(paramInt), 1, paramLong);
    AppMethodBeat.o(18404);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(18401);
    put(paramString, Long.valueOf(paramLong), 2);
    AppMethodBeat.o(18401);
  }
  
  public void putLong(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18405);
    put(paramString, Long.valueOf(paramLong1), 2, paramLong2);
    AppMethodBeat.o(18405);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18402);
    put(paramString1, paramString2, 3);
    AppMethodBeat.o(18402);
  }
  
  public void putString(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(18406);
    put(paramString1, paramString2, 3, paramLong);
    AppMethodBeat.o(18406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaConfigCacheStg
 * JD-Core Version:    0.7.0.1
 */