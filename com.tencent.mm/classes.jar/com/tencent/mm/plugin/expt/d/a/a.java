package com.tencent.mm.plugin.expt.d.a;

import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public abstract class a
  implements c
{
  private MultiProcessMMKV aal()
  {
    if (getType() == 2) {
      return b.dbB();
    }
    if (getType() == 1) {
      return b.dbA();
    }
    return null;
  }
  
  private static String awl(String paramString)
  {
    if (g.fK(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_key_data_cache_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.f.a parama)
  {
    if (parama == null) {}
    MultiProcessMMKV localMultiProcessMMKV;
    String str;
    do
    {
      do
      {
        return;
        localMultiProcessMMKV = aal();
      } while (localMultiProcessMMKV == null);
      str = awl(parama.wdY);
    } while (g.fK(str));
    Log.d("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save key : ".concat(String.valueOf(str)));
    Object localObject1 = localMultiProcessMMKV.decodeBytes(str);
    Object localObject3;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localObject3 = new ais();
    }
    for (;;)
    {
      try
      {
        ((ais)localObject3).parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.d.f.c.a((ais)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(parama);
        parama = com.tencent.mm.plugin.expt.d.f.c.dq((List)localObject3);
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
  
  public final List<com.tencent.mm.plugin.expt.d.f.a> awk(String paramString)
  {
    if (g.fK(paramString)) {}
    for (;;)
    {
      return null;
      Object localObject = aal();
      if (localObject == null) {
        continue;
      }
      String str = awl(paramString);
      if (g.fK(str)) {
        continue;
      }
      Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read key : ".concat(String.valueOf(str)));
      paramString = ((MultiProcessMMKV)localObject).decodeBytes(str);
      if ((paramString == null) || (paramString.length <= 0)) {
        continue;
      }
      localObject = new ais();
      try
      {
        ((ais)localObject).parseFrom(paramString);
        paramString = com.tencent.mm.plugin.expt.d.f.c.a((ais)localObject);
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
  
  public final long bUj()
  {
    long l1 = 0L;
    MultiProcessMMKV localMultiProcessMMKV = aal();
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
    ais localais;
    if (localObject1 != null)
    {
      l2 = l1;
      if (localObject1.length > 0) {
        localais = new ais();
      }
    }
    label231:
    for (;;)
    {
      try
      {
        localais.parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.d.f.c.a(localais);
        l2 = l1;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          l2 = l1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (com.tencent.mm.plugin.expt.d.f.a)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.expt.d.f.a)localObject3).data == null) {
              break label231;
            }
            l1 = ((com.tencent.mm.plugin.expt.d.f.a)localObject3).data.length() + l1;
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
  
  public final void clear(String paramString)
  {
    if (g.fK(paramString)) {}
    MultiProcessMMKV localMultiProcessMMKV;
    do
    {
      do
      {
        return;
        localMultiProcessMMKV = aal();
      } while (localMultiProcessMMKV == null);
      paramString = awl(paramString);
    } while (g.fK(paramString));
    Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clear key : ".concat(String.valueOf(paramString)));
    localMultiProcessMMKV.removeValueForKey(paramString);
  }
  
  public final void dp(List<String> paramList)
  {
    MultiProcessMMKV localMultiProcessMMKV = aal();
    if (localMultiProcessMMKV == null) {
      return;
    }
    Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clearInvalidCache");
    int i;
    label60:
    String str;
    if (paramList.size() > 0)
    {
      String[] arrayOfString = localMultiProcessMMKV.allKeys();
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label151;
      }
      arrayOfString = localMultiProcessMMKV.allKeys();
      int k = arrayOfString.length;
      i = 0;
      if (i >= k) {
        break label151;
      }
      str = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!g.oC(awl((String)localIterator.next()), str));
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clearInvalidCache isValid key : ".concat(String.valueOf(str)));
        localMultiProcessMMKV.removeValueForKey(str);
      }
      i += 1;
      break label60;
      localMultiProcessMMKV.clearAll();
      label151:
      if (localMultiProcessMMKV.totalSize() < 3145728L) {
        break;
      }
      localMultiProcessMMKV.trim();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a.a
 * JD-Core Version:    0.7.0.1
 */