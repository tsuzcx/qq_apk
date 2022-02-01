package com.tencent.mm.plugin.expt.edge.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.b;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.c.i;

public final class a
  implements c
{
  private int type;
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  private static MultiProcessMMKV Lu(int paramInt)
  {
    AppMethodBeat.i(299679);
    MultiProcessMMKV localMultiProcessMMKV;
    if (paramInt == 2)
    {
      localMultiProcessMMKV = b.dHY();
      AppMethodBeat.o(299679);
      return localMultiProcessMMKV;
    }
    if (paramInt == 1)
    {
      localMultiProcessMMKV = b.dHX();
      AppMethodBeat.o(299679);
      return localMultiProcessMMKV;
    }
    AppMethodBeat.o(299679);
    return null;
  }
  
  private static String aqk(String paramString)
  {
    AppMethodBeat.i(299674);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299674);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_key_data_cache_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(299674);
    return paramString;
  }
  
  public final List<com.tencent.mm.plugin.expt.edge.e.a> SV(String paramString)
  {
    AppMethodBeat.i(299725);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299725);
      return null;
    }
    Object localObject = Lu(this.type);
    if (localObject == null)
    {
      AppMethodBeat.o(299725);
      return null;
    }
    String str = aqk(paramString);
    if (i.hm(str))
    {
      AppMethodBeat.o(299725);
      return null;
    }
    paramString = ((MultiProcessMMKV)localObject).decodeBytes(str);
    if ((paramString != null) && (paramString.length > 0))
    {
      localObject = new alx();
      try
      {
        ((alx)localObject).parseFrom(paramString);
        paramString = com.tencent.mm.plugin.expt.edge.e.c.a((alx)localObject);
        if (paramString != null)
        {
          AppMethodBeat.o(299725);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("EdgeComputingCacheStrategyMMKV", "[EdgeComputingCacheStrategyMMKV] query parseFrom : " + str + ", throw Exception : " + paramString.getMessage());
          paramString = null;
        }
      }
    }
    AppMethodBeat.o(299725);
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.expt.edge.e.a parama)
  {
    AppMethodBeat.i(299700);
    if (parama == null)
    {
      AppMethodBeat.o(299700);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = Lu(this.type);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299700);
      return;
    }
    String str = aqk(parama.zzS);
    if (i.hm(str))
    {
      AppMethodBeat.o(299700);
      return;
    }
    b.hf("EdgeComputingCacheStrategyMMKV", "[EdgeComputingCacheStrategyMMKV] save key : ".concat(String.valueOf(str)));
    Object localObject1 = localMultiProcessMMKV.decodeBytes(str);
    Object localObject3;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localObject3 = new alx();
    }
    for (;;)
    {
      try
      {
        ((alx)localObject3).parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.plugin.expt.edge.e.c.a((alx)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(parama);
        parama = com.tencent.mm.plugin.expt.edge.e.c.fm((List)localObject3);
        if (parama == null) {
          break label261;
        }
        boolean bool;
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        try
        {
          bool = localMultiProcessMMKV.encode(str, parama.toByteArray());
          b.hf("EdgeComputingCacheStrategyMMKV", "[EdgeComputingCacheStrategyMMKV] save encode : " + str + ", mmkvEncode : " + bool);
          AppMethodBeat.o(299700);
          return;
        }
        catch (Exception parama)
        {
          Log.e("EdgeComputingCacheStrategyMMKV", "[EdgeComputingCacheStrategyMMKV] save encode throw Exception : " + parama.getMessage());
        }
        localException = localException;
        Log.e("EdgeComputingCacheStrategyMMKV", "[EdgeComputingCacheStrategyMMKV] save parseFrom : " + str + ", throw Exception : " + localException.getMessage());
      }
    }
    label261:
    AppMethodBeat.o(299700);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(299714);
    MultiProcessMMKV localMultiProcessMMKV = Lu(this.type);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299714);
      return;
    }
    localMultiProcessMMKV.clearAll();
    if (localMultiProcessMMKV.totalSize() >= 3145728L) {
      localMultiProcessMMKV.trim();
    }
    AppMethodBeat.o(299714);
  }
  
  public final void close() {}
  
  public final long count()
  {
    long l1 = 0L;
    AppMethodBeat.i(299733);
    MultiProcessMMKV localMultiProcessMMKV = Lu(this.type);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299733);
      return 0L;
    }
    String[] arrayOfString = localMultiProcessMMKV.allKeys();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      AppMethodBeat.o(299733);
      return 0L;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        Object localObject1 = localMultiProcessMMKV.decodeBytes(str);
        long l2 = l1;
        alx localalx;
        if (localObject1 != null)
        {
          l2 = l1;
          if (localObject1.length > 0) {
            localalx = new alx();
          }
        }
        try
        {
          localalx.parseFrom((byte[])localObject1);
          localObject1 = com.tencent.mm.plugin.expt.edge.e.c.a(localalx);
          l2 = l1;
          if (localObject1 != null) {
            l2 = l1 + ((List)localObject1).size();
          }
          i += 1;
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("EdgeComputingCacheStrategyMMKV", "[EdgeComputingCacheStrategyMMKV] size parseFrom : " + str + ", throw Exception : " + localException.getMessage());
            Object localObject2 = null;
          }
        }
      }
    }
    AppMethodBeat.o(299733);
    return l1;
  }
  
  public final void dId() {}
  
  public final void lS(long paramLong) {}
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(299706);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299706);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = Lu(this.type);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299706);
      return;
    }
    paramString = aqk(paramString);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299706);
      return;
    }
    localMultiProcessMMKV.removeValueForKey(paramString);
    if (localMultiProcessMMKV.totalSize() >= 3145728L) {
      localMultiProcessMMKV.trim();
    }
    AppMethodBeat.o(299706);
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.a.b.a
 * JD-Core Version:    0.7.0.1
 */