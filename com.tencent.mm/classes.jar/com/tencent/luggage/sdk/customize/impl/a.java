package com.tencent.luggage.sdk.customize.impl;

import android.os.SystemClock;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/customize/impl/AndroidNBLEScanStatsService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/IAppScanStats;", "()V", "EXCESSIVE_SCANNING_PERIOD_MS", "", "NUM_SCAN_DURATIONS_KEPT", "", "idGenerator", "lastScans", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/sdk/customize/impl/AndroidNBLEScanStatsService$LastScan;", "Lkotlin/collections/ArrayList;", "ongoingScans", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isScanningTooFrequently", "", "recordScanStart", "recordScanStop", "", "id", "LastScan", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  implements f
{
  public static final a eqt;
  private static final ArrayList<a> equ;
  private static final HashMap<Integer, a> eqv;
  private static int idGenerator;
  
  static
  {
    AppMethodBeat.i(220358);
    eqt = new a();
    equ = new ArrayList(5);
    eqv = new HashMap();
    AppMethodBeat.o(220358);
  }
  
  public final int aqV()
  {
    try
    {
      AppMethodBeat.i(220363);
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStart");
      int i = idGenerator;
      idGenerator = i + 1;
      ((Map)eqv).put(Integer.valueOf(i), new a(i, SystemClock.elapsedRealtime()));
      AppMethodBeat.o(220363);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean aqW()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(220373);
        if (equ.size() < 5)
        {
          AppMethodBeat.o(220373);
          bool = false;
          return bool;
        }
        if (SystemClock.elapsedRealtime() - ((a)equ.get(0)).timeStamp < 30000L)
        {
          bool = true;
          AppMethodBeat.o(220373);
          continue;
        }
        AppMethodBeat.o(220373);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public final void mr(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 80
    //   9: ldc 129
    //   11: iload_1
    //   12: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: invokestatic 135	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 70	com/tencent/luggage/sdk/customize/impl/a:eqv	Ljava/util/HashMap;
    //   24: iload_1
    //   25: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 139	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 8	com/tencent/luggage/sdk/customize/impl/a$a
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +18 -> 54
    //   39: ldc 80
    //   41: ldc 141
    //   43: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc 127
    //   48: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: getstatic 65	com/tencent/luggage/sdk/customize/impl/a:equ	Ljava/util/ArrayList;
    //   57: invokevirtual 115	java/util/ArrayList:size	()I
    //   60: iconst_5
    //   61: if_icmplt +11 -> 72
    //   64: getstatic 65	com/tencent/luggage/sdk/customize/impl/a:equ	Ljava/util/ArrayList;
    //   67: iconst_0
    //   68: invokevirtual 146	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   71: pop
    //   72: getstatic 65	com/tencent/luggage/sdk/customize/impl/a:equ	Ljava/util/ArrayList;
    //   75: aload_2
    //   76: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   79: pop
    //   80: ldc 127
    //   82: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -34 -> 51
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   0	93	1	paramInt	int
    //   34	42	2	locala	a
    //   88	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	88	finally
    //   39	51	88	finally
    //   54	72	88	finally
    //   72	85	88	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/customize/impl/AndroidNBLEScanStatsService$LastScan;", "", "id", "", "timeStamp", "", "(IJ)V", "getId", "()I", "getTimeStamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    private final int id;
    final long timeStamp;
    
    public a(int paramInt, long paramLong)
    {
      this.id = paramInt;
      this.timeStamp = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.id != paramObject.id) {
          return false;
        }
      } while (this.timeStamp == paramObject.timeStamp);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(220377);
      int i = this.id;
      int j = q.a..ExternalSyntheticBackport0.m(this.timeStamp);
      AppMethodBeat.o(220377);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(220372);
      String str = "LastScan(id=" + this.id + ", timeStamp=" + this.timeStamp + ')';
      AppMethodBeat.o(220372);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a
 * JD-Core Version:    0.7.0.1
 */