package com.tencent.matrix.traffic;

import com.tencent.matrix.d.b;
import com.tencent.matrix.e.c;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficPlugin
  extends b
{
  private static final ConcurrentHashMap<String, String> fiH = new ConcurrentHashMap();
  private final a fiG;
  
  static
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-traffic");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/traffic/TrafficPlugin", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/traffic/TrafficPlugin", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  public TrafficPlugin(a parama)
  {
    this.fiG = parama;
  }
  
  public static ConcurrentHashMap<String, String> aAh()
  {
    return fiH;
  }
  
  public static void aAi()
  {
    fiH.clear();
    nativeClearTrafficInfo();
  }
  
  private static native void nativeClearTrafficInfo();
  
  private static native String nativeGetAllStackTraceTrafficInfo();
  
  private static native String nativeGetTrafficInfo();
  
  private static native HashMap<String, String> nativeGetTrafficInfoMap(int paramInt);
  
  private static native void nativeInitMatrixTraffic(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String[] paramArrayOfString);
  
  private static native void nativeReleaseMatrixTraffic();
  
  public static HashMap<String, String> nz(int paramInt)
  {
    return nativeGetTrafficInfoMap(paramInt);
  }
  
  private static void setStackTrace(String paramString1, String paramString2)
  {
    c.i("TrafficPlugin", "setStackTrace, threadName = ".concat(String.valueOf(paramString1)), new Object[] { "nativeBackTrace = ".concat(String.valueOf(paramString2)) });
    paramString2 = new StringBuilder(paramString2);
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 3;
    while (i < arrayOfStackTraceElement.length)
    {
      paramString2.append(arrayOfStackTraceElement[i]).append("\n");
      i += 1;
    }
    fiH.put(paramString1, paramString2.toString());
  }
  
  public void start()
  {
    if (isPluginStarted()) {
      return;
    }
    super.start();
    c.i("TrafficPlugin", "start", new Object[0]);
    Object localObject = this.fiG;
    localObject = (String[])((a)localObject).fiF.toArray(new String[((a)localObject).fiF.size()]);
    nativeInitMatrixTraffic(this.fiG.fiA, this.fiG.fiB, this.fiG.fiC, this.fiG.fiD, this.fiG.fiE, (String[])localObject);
  }
  
  public void stop()
  {
    if (isPluginStopped()) {
      return;
    }
    super.stop();
    nativeReleaseMatrixTraffic();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.traffic.TrafficPlugin
 * JD-Core Version:    0.7.0.1
 */