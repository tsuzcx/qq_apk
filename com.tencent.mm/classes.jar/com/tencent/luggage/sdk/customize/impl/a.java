package com.tencent.luggage.sdk.customize.impl;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/customize/impl/AndroidNBLEScanStatsService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/IAppScanStats;", "()V", "EXCESSIVE_SCANNING_PERIOD_MS", "", "NUM_SCAN_DURATIONS_KEPT", "", "idGenerator", "lastScans", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/sdk/customize/impl/AndroidNBLEScanStatsService$LastScan;", "Lkotlin/collections/ArrayList;", "ongoingScans", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isScanningTooFrequently", "", "recordScanStart", "recordScanStop", "", "id", "LastScan", "luggage-wechat-full-sdk_release"})
final class a
  implements f
{
  private static final ArrayList<a> cxX;
  private static final HashMap<Integer, a> cxY;
  public static final a cxZ;
  private static int idGenerator;
  
  static
  {
    AppMethodBeat.i(250220);
    cxZ = new a();
    cxX = new ArrayList(5);
    cxY = new HashMap();
    AppMethodBeat.o(250220);
  }
  
  public final int QI()
  {
    try
    {
      AppMethodBeat.i(250213);
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStart");
      int i = idGenerator;
      idGenerator = i + 1;
      ((Map)cxY).put(Integer.valueOf(i), new a(i, SystemClock.elapsedRealtime()));
      AppMethodBeat.o(250213);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean QJ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(250217);
        if (cxX.size() < 5)
        {
          AppMethodBeat.o(250217);
          bool = false;
          return bool;
        }
        if (SystemClock.elapsedRealtime() - ((a)cxX.get(0)).timeStamp < 30000L)
        {
          bool = true;
          AppMethodBeat.o(250217);
          continue;
        }
        AppMethodBeat.o(250217);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public final void iQ(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 124
    //   4: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 77
    //   9: ldc 126
    //   11: iload_1
    //   12: invokestatic 131	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   15: invokevirtual 135	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 67	com/tencent/luggage/sdk/customize/impl/a:cxY	Ljava/util/HashMap;
    //   24: iload_1
    //   25: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 139	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 8	com/tencent/luggage/sdk/customize/impl/a$a
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +18 -> 54
    //   39: ldc 77
    //   41: ldc 141
    //   43: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc 124
    //   48: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: getstatic 62	com/tencent/luggage/sdk/customize/impl/a:cxX	Ljava/util/ArrayList;
    //   57: invokevirtual 112	java/util/ArrayList:size	()I
    //   60: iconst_5
    //   61: if_icmplt +11 -> 72
    //   64: getstatic 62	com/tencent/luggage/sdk/customize/impl/a:cxX	Ljava/util/ArrayList;
    //   67: iconst_0
    //   68: invokevirtual 146	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   71: pop
    //   72: getstatic 62	com/tencent/luggage/sdk/customize/impl/a:cxX	Ljava/util/ArrayList;
    //   75: aload_2
    //   76: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   79: pop
    //   80: ldc 124
    //   82: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/customize/impl/AndroidNBLEScanStatsService$LastScan;", "", "id", "", "timeStamp", "", "(IJ)V", "getId", "()I", "getTimeStamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wechat-full-sdk_release"})
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
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.id != paramObject.id) || (this.timeStamp != paramObject.timeStamp)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.id;
      long l = this.timeStamp;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(241043);
      String str = "LastScan(id=" + this.id + ", timeStamp=" + this.timeStamp + ")";
      AppMethodBeat.o(241043);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a
 * JD-Core Version:    0.7.0.1
 */