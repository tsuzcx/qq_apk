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
    AppMethodBeat.i(18626);
    paramString = SubCoreKinda.getCore().getCacheStg().get(paramString);
    if (paramString != null)
    {
      if (paramString.field_expire_at < System.currentTimeMillis() / 1000L)
      {
        AppMethodBeat.o(18626);
        return null;
      }
      paramString = paramString.field_value;
      AppMethodBeat.o(18626);
      return paramString;
    }
    AppMethodBeat.o(18626);
    return null;
  }
  
  public boolean getBool(String paramString)
  {
    AppMethodBeat.i(18629);
    paramString = get(paramString);
    if ((paramString != null) && (paramString.length > 0) && (paramString[0] == 1))
    {
      AppMethodBeat.o(18629);
      return true;
    }
    AppMethodBeat.o(18629);
    return false;
  }
  
  public boolean remove(String paramString)
  {
    AppMethodBeat.i(18627);
    paramString = SubCoreKinda.getCore().getCacheStg().get(paramString);
    if (paramString != null)
    {
      boolean bool = SubCoreKinda.getCore().getCacheStg().delete(paramString, new String[0]);
      AppMethodBeat.o(18627);
      return bool;
    }
    AppMethodBeat.o(18627);
    return true;
  }
  
  public void set(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(18625);
    KindaCacheItem localKindaCacheItem = new KindaCacheItem();
    localKindaCacheItem.field_key = paramString;
    localKindaCacheItem.field_value = paramArrayOfByte;
    if (paramLong == 0L) {}
    for (localKindaCacheItem.field_expire_at = (System.currentTimeMillis() / 1000L + 315360000L);; localKindaCacheItem.field_expire_at = (System.currentTimeMillis() / 1000L + paramLong))
    {
      SubCoreKinda.getCore().getCacheStg().save(localKindaCacheItem);
      AppMethodBeat.o(18625);
      return;
    }
  }
  
  public void setBool(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(18628);
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {
      arrayOfByte[0] = 1;
    }
    set(paramString, arrayOfByte, paramLong);
    AppMethodBeat.o(18628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl
 * JD-Core Version:    0.7.0.1
 */