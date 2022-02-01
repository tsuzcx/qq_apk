package com.tencent.mm.plugin.expt.d.a;

import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public abstract class a
  implements c
{
  private MultiProcessMMKV VQ()
  {
    if (getType() == 2) {
      return b.cMO();
    }
    if (getType() == 1) {
      return b.cMN();
    }
    return null;
  }
  
  private static String aom(String paramString)
  {
    if (g.eP(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_key_data_cache_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a parama)
  {
    if (parama == null) {}
    MultiProcessMMKV localMultiProcessMMKV;
    String str;
    do
    {
      do
      {
        return;
        localMultiProcessMMKV = VQ();
      } while (localMultiProcessMMKV == null);
      str = aom(parama.syg);
    } while (g.eP(str));
    Log.d("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save key : ".concat(String.valueOf(str)));
    Object localObject1 = localMultiProcessMMKV.decodeBytes(str);
    Object localObject3;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localObject3 = new aih();
    }
    for (;;)
    {
      try
      {
        ((aih)localObject3).parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.d.e.c.a((aih)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(parama);
        parama = com.tencent.mm.plugin.expt.d.e.c.jdMethod_do((List)localObject3);
        if (parama == null) {
          break;
        }
        try
        {
          boolean bool = localMultiProcessMMKV.encode(str, parama.toByteArray());
          Log.d("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save encode : " + str + ", mmkvEncode : " + bool);
          return;
        }
        catch (Exception parama)
        {
          Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save encode throw Exception : " + parama.getMessage());
          return;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save parseFrom : " + str + ", throw Exception : " + localException.getMessage());
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.expt.d.e.a> aol(String paramString)
  {
    if (g.eP(paramString)) {}
    for (;;)
    {
      return null;
      Object localObject = VQ();
      if (localObject == null) {
        continue;
      }
      String str = aom(paramString);
      if (g.eP(str)) {
        continue;
      }
      Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read key : ".concat(String.valueOf(str)));
      paramString = ((MultiProcessMMKV)localObject).decodeBytes(str);
      if ((paramString == null) || (paramString.length <= 0)) {
        continue;
      }
      localObject = new aih();
      try
      {
        ((aih)localObject).parseFrom(paramString);
        paramString = com.tencent.mm.plugin.expt.d.e.c.a((aih)localObject);
        if (paramString == null) {
          continue;
        }
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read parseFrom : " + str + ", throw Exception : " + paramString.getMessage());
          paramString = null;
        }
      }
    }
  }
  
  public final void clear(String paramString)
  {
    if (g.eP(paramString)) {}
    MultiProcessMMKV localMultiProcessMMKV;
    do
    {
      do
      {
        return;
        localMultiProcessMMKV = VQ();
      } while (localMultiProcessMMKV == null);
      paramString = aom(paramString);
    } while (g.eP(paramString));
    Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clear key : ".concat(String.valueOf(paramString)));
    localMultiProcessMMKV.removeValueForKey(paramString);
  }
  
  public final void clearAll()
  {
    MultiProcessMMKV localMultiProcessMMKV = VQ();
    if (localMultiProcessMMKV == null) {}
    do
    {
      return;
      Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clearAll");
      localMultiProcessMMKV.clearAll();
    } while (localMultiProcessMMKV.totalSize() < 3145728L);
    localMultiProcessMMKV.trim();
  }
  
  public final long size()
  {
    long l1 = 0L;
    MultiProcessMMKV localMultiProcessMMKV = VQ();
    if (localMultiProcessMMKV == null) {
      l2 = l1;
    }
    String[] arrayOfString;
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          return l2;
          arrayOfString = localMultiProcessMMKV.allKeys();
          l2 = l1;
        } while (arrayOfString == null);
        l2 = l1;
      } while (arrayOfString.length <= 0);
      j = arrayOfString.length;
      i = 0;
      l2 = l1;
    } while (i >= j);
    Object localObject3 = arrayOfString[i];
    Object localObject1 = localMultiProcessMMKV.decodeBytes((String)localObject3);
    long l2 = l1;
    aih localaih;
    if (localObject1 != null)
    {
      l2 = l1;
      if (localObject1.length > 0) {
        localaih = new aih();
      }
    }
    label231:
    for (;;)
    {
      try
      {
        localaih.parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.d.e.c.a(localaih);
        l2 = l1;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          l2 = l1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (com.tencent.mm.plugin.expt.d.e.a)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.expt.d.e.a)localObject3).data == null) {
              break label231;
            }
            l1 = ((com.tencent.mm.plugin.expt.d.e.a)localObject3).data.length() + l1;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read parseFrom : " + (String)localObject3 + ", throw Exception : " + localException.getMessage());
        Object localObject2 = null;
        continue;
      }
      i += 1;
      l1 = l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a.a
 * JD-Core Version:    0.7.0.1
 */