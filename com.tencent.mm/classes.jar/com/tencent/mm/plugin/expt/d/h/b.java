package com.tencent.mm.plugin.expt.d.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.b.g;

public final class b
{
  public static boolean J(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(256889);
    if ((g.fK(paramString1)) || (paramInt <= 0) || (g.fK(paramString2)))
    {
      AppMethodBeat.o(256889);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.d.b.dbF();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(256889);
      return false;
    }
    String str = String.valueOf(paramInt);
    if ((g.fK(paramString1)) || (g.fK(str))) {}
    for (str = null; g.fK(str); str = ((StringBuilder)localObject).toString())
    {
      AppMethodBeat.o(256889);
      return false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mmkv_key_realtime_report_cache_");
      ((StringBuilder)localObject).append(paramString1).append("_");
      ((StringBuilder)localObject).append(str);
    }
    Object localObject = new aiv();
    byte[] arrayOfByte = localMultiProcessMMKV.decodeBytes(str);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        ((aiv)localObject).parseFrom(arrayOfByte);
        ((aiv)localObject).EyF.add(paramString2);
        ((aiv)localObject).wdY = paramString1;
      }
      catch (Exception paramString1)
      {
        try
        {
          Log.i("EdgeComputingRtReportCache", "[EdgeComputingConfigService] rtReportItem encode mmkvEncode : ".concat(String.valueOf(localMultiProcessMMKV.encode(str, ((aiv)localObject).toByteArray()))));
          AppMethodBeat.o(256889);
          return true;
        }
        catch (IOException paramString1)
        {
          Log.e("EdgeComputingRtReportCache", "[EdgeComputingRtReportCache] rtReportItem encode throw IOException : " + paramString1.getMessage());
          AppMethodBeat.o(256889);
        }
        paramString1 = paramString1;
        Log.e("EdgeComputingRtReportCache", "[EdgeComputingRtReportCache] save parse rtReportItem throw Exception : " + paramString1.getMessage());
        AppMethodBeat.o(256889);
        return false;
      }
      ((aiv)localObject).Stn = paramInt;
    }
    return false;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(256891);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.d.b.dbF();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(256891);
      return;
    }
    localMultiProcessMMKV.clearAll();
    if (localMultiProcessMMKV.totalSize() >= 3145728L) {
      localMultiProcessMMKV.trim();
    }
    AppMethodBeat.o(256891);
  }
  
  public static List<aiv> dbR()
  {
    AppMethodBeat.i(256890);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.d.b.dbF();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(256890);
      return null;
    }
    String[] arrayOfString = localMultiProcessMMKV.allKeys();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      AppMethodBeat.o(256890);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        byte[] arrayOfByte = localMultiProcessMMKV.decodeBytes(arrayOfString[i]);
        aiv localaiv;
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          localaiv = new aiv();
        }
        try
        {
          localaiv.parseFrom(arrayOfByte);
          localArrayList.add(localaiv);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("EdgeComputingRtReportCache", "[EdgeComputingRtReportCache] read parse realtimeReportItem throw Exception : " + localException.getMessage());
          }
        }
      }
    }
    AppMethodBeat.o(256890);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.b
 * JD-Core Version:    0.7.0.1
 */