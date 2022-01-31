package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.framework.app.KindaCacheItem;
import com.tencent.kinda.framework.app.KindaCacheStg;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.kinda.gen.KCacheService;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaCacheServiceImpl
  implements KCacheService
{
  public byte[] get(String paramString)
  {
    AppMethodBeat.i(144512);
    paramString = SubCoreKinda.getCore().getCacheStg().get(paramString);
    if (paramString != null)
    {
      if (paramString.field_expire_at < System.currentTimeMillis() / 1000L)
      {
        AppMethodBeat.o(144512);
        return null;
      }
      paramString = paramString.field_value;
      AppMethodBeat.o(144512);
      return paramString;
    }
    AppMethodBeat.o(144512);
    return null;
  }
  
  public boolean getBool(String paramString)
  {
    AppMethodBeat.i(144515);
    paramString = get(paramString);
    if ((paramString != null) && (paramString.length > 0) && (paramString[0] == 1))
    {
      AppMethodBeat.o(144515);
      return true;
    }
    AppMethodBeat.o(144515);
    return false;
  }
  
  public boolean remove(String paramString)
  {
    AppMethodBeat.i(144513);
    paramString = SubCoreKinda.getCore().getCacheStg().get(paramString);
    if (paramString != null)
    {
      boolean bool = SubCoreKinda.getCore().getCacheStg().delete(paramString, new String[0]);
      AppMethodBeat.o(144513);
      return bool;
    }
    AppMethodBeat.o(144513);
    return true;
  }
  
  public void set(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(144511);
    KindaCacheItem localKindaCacheItem = new KindaCacheItem();
    localKindaCacheItem.field_key = paramString;
    localKindaCacheItem.field_value = paramArrayOfByte;
    if (paramLong == 0L) {}
    for (localKindaCacheItem.field_expire_at = (System.currentTimeMillis() / 1000L + 315360000L);; localKindaCacheItem.field_expire_at = (System.currentTimeMillis() / 1000L + paramLong))
    {
      SubCoreKinda.getCore().getCacheStg().save(localKindaCacheItem);
      AppMethodBeat.o(144511);
      return;
    }
  }
  
  public void setBool(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(144514);
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {
      arrayOfByte[0] = 1;
    }
    set(paramString, arrayOfByte, paramLong);
    AppMethodBeat.o(144514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl
 * JD-Core Version:    0.7.0.1
 */