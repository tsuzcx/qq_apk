package com.tencent.mm.plugin.expt.d.a;

import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public abstract class a
  implements c
{
  private ay LD()
  {
    if (getType() == 2) {
      return b.coC();
    }
    if (getType() == 1) {
      return b.coB();
    }
    return null;
  }
  
  private static String aec(String paramString)
  {
    if (g.ef(paramString)) {
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
    ay localay;
    String str;
    do
    {
      do
      {
        return;
        localay = LD();
      } while (localay == null);
      str = aec(parama.qXW);
    } while (g.ef(str));
    ae.d("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save key : ".concat(String.valueOf(str)));
    Object localObject1 = localay.decodeBytes(str);
    Object localObject3;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localObject3 = new aga();
    }
    for (;;)
    {
      try
      {
        ((aga)localObject3).parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.d.e.c.a((aga)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(parama);
        parama = com.tencent.mm.plugin.expt.d.e.c.da((List)localObject3);
        if (parama == null) {
          break;
        }
        try
        {
          boolean bool = localay.encode(str, parama.toByteArray());
          ae.d("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save encode : " + str + ", mmkvEncode : " + bool);
          return;
        }
        catch (Exception parama)
        {
          ae.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save encode throw Exception : " + parama.getMessage());
          return;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        ae.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] save parseFrom : " + str + ", throw Exception : " + localException.getMessage());
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.expt.d.e.a> aeb(String paramString)
  {
    if (g.ef(paramString)) {}
    for (;;)
    {
      return null;
      Object localObject = LD();
      if (localObject == null) {
        continue;
      }
      String str = aec(paramString);
      if (g.ef(str)) {
        continue;
      }
      ae.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read key : ".concat(String.valueOf(str)));
      paramString = ((ay)localObject).decodeBytes(str);
      if ((paramString == null) || (paramString.length <= 0)) {
        continue;
      }
      localObject = new aga();
      try
      {
        ((aga)localObject).parseFrom(paramString);
        paramString = com.tencent.mm.plugin.expt.d.e.c.a((aga)localObject);
        if (paramString == null) {
          continue;
        }
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read parseFrom : " + str + ", throw Exception : " + paramString.getMessage());
          paramString = null;
        }
      }
    }
  }
  
  public final void clear(String paramString)
  {
    if (g.ef(paramString)) {}
    ay localay;
    do
    {
      do
      {
        return;
        localay = LD();
      } while (localay == null);
      paramString = aec(paramString);
    } while (g.ef(paramString));
    ae.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clear key : ".concat(String.valueOf(paramString)));
    localay.removeValueForKey(paramString);
  }
  
  public final void clearAll()
  {
    ay localay = LD();
    if (localay == null) {}
    do
    {
      return;
      ae.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clearAll");
      localay.clearAll();
    } while (localay.IyS.totalSize() < 3145728L);
    localay.IyS.trim();
  }
  
  public final long size()
  {
    long l1 = 0L;
    ay localay = LD();
    if (localay == null) {
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
          arrayOfString = localay.allKeys();
          l2 = l1;
        } while (arrayOfString == null);
        l2 = l1;
      } while (arrayOfString.length <= 0);
      j = arrayOfString.length;
      i = 0;
      l2 = l1;
    } while (i >= j);
    Object localObject3 = arrayOfString[i];
    Object localObject1 = localay.decodeBytes((String)localObject3);
    long l2 = l1;
    aga localaga;
    if (localObject1 != null)
    {
      l2 = l1;
      if (localObject1.length > 0) {
        localaga = new aga();
      }
    }
    label231:
    for (;;)
    {
      try
      {
        localaga.parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.d.e.c.a(localaga);
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
        ae.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read parseFrom : " + (String)localObject3 + ", throw Exception : " + localException.getMessage());
        Object localObject2 = null;
        continue;
      }
      i += 1;
      l1 = l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a.a
 * JD-Core Version:    0.7.0.1
 */