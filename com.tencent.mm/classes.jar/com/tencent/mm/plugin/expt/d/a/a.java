package com.tencent.mm.plugin.expt.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.c;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.io.IOException;
import java.util.List;
import org.apache.commons.b.g;

public final class a
{
  public static ax Lv()
  {
    AppMethodBeat.i(210226);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_cache_");
    d.crP();
    localObject = ax.aQz(d.getUin());
    AppMethodBeat.o(210226);
    return localObject;
  }
  
  public static List<com.tencent.mm.plugin.expt.d.e.a> fv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210223);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(210223);
      return null;
    }
    Object localObject2 = Lv();
    if (localObject2 == null)
    {
      AppMethodBeat.o(210223);
      return null;
    }
    Object localObject1 = fx(paramInt1, paramInt2);
    if (g.ea((String)localObject1))
    {
      AppMethodBeat.o(210223);
      return null;
    }
    ad.i("EdgeComputingDataCache", "[EdgeComputingDataCache] readDataCache dataCacheKey : ".concat(String.valueOf(localObject1)));
    byte[] arrayOfByte = ((ax)localObject2).decodeBytes((String)localObject1);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localObject2 = new afr();
      try
      {
        ((afr)localObject2).parseFrom(arrayOfByte);
        localObject1 = c.a((afr)localObject2);
        if (localObject1 != null)
        {
          AppMethodBeat.o(210223);
          return localObject1;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("EdgeComputingDataCache", "[EdgeComputingDataCache] readDataCache parseFrom : " + (String)localObject1 + ", throw IOException : " + localIOException.getMessage());
        }
      }
    }
    AppMethodBeat.o(210223);
    return null;
  }
  
  public static void fw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210224);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(210224);
      return;
    }
    ax localax = Lv();
    if (localax == null)
    {
      AppMethodBeat.o(210224);
      return;
    }
    String str = fx(paramInt1, paramInt2);
    if (g.ea(str))
    {
      AppMethodBeat.o(210224);
      return;
    }
    ad.i("EdgeComputingDataCache", "[EdgeComputingDataCache] clearDataCache dataCacheKey : ".concat(String.valueOf(str)));
    localax.removeValueForKey(str);
    AppMethodBeat.o(210224);
  }
  
  public static String fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210225);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(210225);
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mmkv_key_data_cache_");
    ((StringBuilder)localObject).append(paramInt1).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(210225);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a.a
 * JD-Core Version:    0.7.0.1
 */