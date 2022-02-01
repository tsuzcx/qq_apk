package com.tencent.matrix.openglleak;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.openglleak.a.d;
import com.tencent.matrix.openglleak.detector.OpenglIndexDetectorService;
import com.tencent.matrix.openglleak.hook.OpenGLHook;
import java.util.Map;

public final class a
  extends com.tencent.matrix.d.b
{
  public static b eWN;
  Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final String getTag()
  {
    return "OpenglLeak";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.d.c paramc)
  {
    super.init(paramApplication, paramc);
    paramc = com.tencent.matrix.openglleak.a.a.ayS();
    Activity localActivity = com.tencent.matrix.openglleak.a.a.getActivity();
    if (localActivity != null) {
      paramc.eXY = new com.tencent.matrix.openglleak.a.a.a(localActivity.hashCode(), localActivity.getLocalClassName());
    }
    paramApplication.registerActivityLifecycleCallbacks(paramc);
    d.ayV().start();
  }
  
  public final void start()
  {
    super.start();
    new Thread(new Runnable()
    {
      public final void run()
      {
        a locala = a.this;
        Intent localIntent = new Intent(locala.context, OpenglIndexDetectorService.class);
        boolean bool = locala.context.bindService(localIntent, new a.2(locala), 1);
        com.tencent.matrix.e.c.d("matrix.OpenglLeakPlugin", "bindService result = ".concat(String.valueOf(bool)), new Object[0]);
        if (bool) {
          if (a.eWN != null) {
            a.eWN.awh();
          }
        }
        while (a.eWN == null) {
          return;
        }
        a.eWN.awi();
      }
    }).start();
  }
  
  public final void stop()
  {
    super.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.a
 * JD-Core Version:    0.7.0.1
 */