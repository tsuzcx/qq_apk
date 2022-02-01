package com.tencent.live2.b;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static boolean a = false;
  
  public static void a()
  {
    AppMethodBeat.i(214044);
    if (!a)
    {
      AppMethodBeat.o(214044);
      return;
    }
    TXCLog.i("V2-MonitorHelper", "unInitMonitorLog");
    Monitor.a();
    a = false;
    AppMethodBeat.o(214044);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(214043);
    if (a)
    {
      AppMethodBeat.o(214043);
      return;
    }
    TXCLog.i("V2-MonitorHelper", "initMonitorLog [userId:" + paramString1 + "][sdkAppId:" + paramInt + "][roomId:" + paramString2 + "]");
    Monitor.a(paramString1, paramInt, paramString2);
    a = true;
    AppMethodBeat.o(214043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.b.c
 * JD-Core Version:    0.7.0.1
 */