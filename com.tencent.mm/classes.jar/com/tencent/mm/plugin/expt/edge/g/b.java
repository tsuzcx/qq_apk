package com.tencent.mm.plugin.expt.edge.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.c.i;

public final class b
{
  public static boolean L(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(299638);
    if ((i.hm(paramString1)) || (paramInt <= 0) || (i.hm(paramString2)))
    {
      AppMethodBeat.o(299638);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.edge.b.dIc();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299638);
      return false;
    }
    String str = String.valueOf(paramInt);
    if ((i.hm(paramString1)) || (i.hm(str))) {}
    for (str = null; i.hm(str); str = ((StringBuilder)localObject).toString())
    {
      AppMethodBeat.o(299638);
      return false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mmkv_key_realtime_report_cache_");
      ((StringBuilder)localObject).append(paramString1).append("_");
      ((StringBuilder)localObject).append(str);
    }
    Object localObject = new ama();
    byte[] arrayOfByte = localMultiProcessMMKV.decodeBytes(str);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        ((ama)localObject).parseFrom(arrayOfByte);
        ((ama)localObject).Krs.add(paramString2);
        ((ama)localObject).zzS = paramString1;
      }
      catch (Exception paramString1)
      {
        try
        {
          Log.i("EdgeComputingRtReportCache", "[EdgeComputingConfigService] rtReportItem encode mmkvEncode : ".concat(String.valueOf(localMultiProcessMMKV.encode(str, ((ama)localObject).toByteArray()))));
          AppMethodBeat.o(299638);
          return true;
        }
        catch (IOException paramString1)
        {
          Log.e("EdgeComputingRtReportCache", "[EdgeComputingRtReportCache] rtReportItem encode throw IOException : " + paramString1.getMessage());
          AppMethodBeat.o(299638);
        }
        paramString1 = paramString1;
        Log.e("EdgeComputingRtReportCache", "[EdgeComputingRtReportCache] save parse rtReportItem throw Exception : " + paramString1.getMessage());
        AppMethodBeat.o(299638);
        return false;
      }
      ((ama)localObject).ZsX = paramInt;
    }
    return false;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(299655);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.edge.b.dIc();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299655);
      return;
    }
    localMultiProcessMMKV.clearAll();
    if (localMultiProcessMMKV.totalSize() >= 3145728L) {
      localMultiProcessMMKV.trim();
    }
    AppMethodBeat.o(299655);
  }
  
  public static List<ama> dIv()
  {
    AppMethodBeat.i(299648);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.edge.b.dIc();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299648);
      return null;
    }
    String[] arrayOfString = localMultiProcessMMKV.allKeys();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      AppMethodBeat.o(299648);
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
        ama localama;
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          localama = new ama();
        }
        try
        {
          localama.parseFrom(arrayOfByte);
          localArrayList.add(localama);
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
    AppMethodBeat.o(299648);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.g.b
 * JD-Core Version:    0.7.0.1
 */