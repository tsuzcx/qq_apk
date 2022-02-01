package com.tencent.matrix.openglleak.detector;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.Map;

public class OpenglIndexDetectorService
  extends Service
{
  private final a.a eWS = new a.a()
  {
    public final Map<String, Integer> ayJ()
    {
      return OpenglIndexDetectorService.ayL();
    }
    
    public final void destory()
    {
      OpenglIndexDetectorService.this.stopSelf();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/openglleak/detector/OpenglIndexDetectorService$1", "destory", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/openglleak/detector/OpenglIndexDetectorService$1", "destory", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/openglleak/detector/OpenglIndexDetectorService$1", "destory", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/openglleak/detector/OpenglIndexDetectorService$1", "destory", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
  };
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.eWS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.detector.OpenglIndexDetectorService
 * JD-Core Version:    0.7.0.1
 */