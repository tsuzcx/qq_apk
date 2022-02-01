package com.tencent.live2.b;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static boolean a = false;
  
  public static void a()
  {
    AppMethodBeat.i(211364);
    if (!a)
    {
      AppMethodBeat.o(211364);
      return;
    }
    TXCLog.i("V2-MonitorHelper", "unInitMonitorLog");
    Monitor.a();
    a = false;
    AppMethodBeat.o(211364);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(211358);
    if (a)
    {
      AppMethodBeat.o(211358);
      return;
    }
    TXCLog.i("V2-MonitorHelper", "initMonitorLog [userId:" + paramString1 + "][sdkAppId:" + paramInt + "][roomId:" + paramString2 + "]");
    Monitor.a(paramString1, paramInt, paramString2);
    a = true;
    AppMethodBeat.o(211358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.b.c
 * JD-Core Version:    0.7.0.1
 */