package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandOpReportLogic
{
  public static final class AppBrandOnOpReportStartEvent
    implements Parcelable
  {
    public static final Parcelable.Creator<AppBrandOnOpReportStartEvent> CREATOR;
    String appId;
    
    static
    {
      AppMethodBeat.i(147202);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(147202);
    }
    
    AppBrandOnOpReportStartEvent() {}
    
    AppBrandOnOpReportStartEvent(Parcel paramParcel)
    {
      AppMethodBeat.i(147201);
      this.appId = paramParcel.readString();
      AppMethodBeat.o(147201);
    }
    
    public static void air(String paramString)
    {
      AppMethodBeat.i(147199);
      AppBrandOnOpReportStartEvent localAppBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
      localAppBrandOnOpReportStartEvent.appId = paramString;
      e.b(paramString, localAppBrandOnOpReportStartEvent);
      AppMethodBeat.o(147199);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(147200);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(147200);
    }
  }
  
  public static final class a
  {
    private static boolean phH = false;
    
    /* Error */
    public static void d(j paramj)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 19
      //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 15	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a:phH	Z
      //   11: ifeq +12 -> 23
      //   14: ldc 19
      //   16: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: aload_0
      //   24: invokeinterface 34 1 0
      //   29: new 9	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a$1
      //   32: dup
      //   33: aload_0
      //   34: invokespecial 37	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/j;)V
      //   37: invokestatic 42	com/tencent/mm/plugin/appbrand/ipc/MMToClientEvent:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/ipc/MMToClientEvent$c;)V
      //   40: iconst_1
      //   41: putstatic 15	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a:phH	Z
      //   44: ldc 19
      //   46: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   49: goto -30 -> 19
      //   52: astore_0
      //   53: ldc 2
      //   55: monitorexit
      //   56: aload_0
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	paramj	j
      // Exception table:
      //   from	to	target	type
      //   3	19	52	finally
      //   23	49	52	finally
    }
  }
  
  public static final class b
  {
    private static final SparseIntArray phI;
    
    static
    {
      AppMethodBeat.i(147206);
      phI = new SparseIntArray();
      AppMethodBeat.o(147206);
    }
    
    static void cj(String paramString, int paramInt)
    {
      AppMethodBeat.i(147205);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(147205);
        return;
      }
      synchronized (phI)
      {
        phI.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(147205);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic
 * JD-Core Version:    0.7.0.1
 */