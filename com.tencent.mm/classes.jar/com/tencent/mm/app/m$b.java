package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class m$b
  implements Runnable
{
  private m$b(m paramm) {}
  
  private static ActivityManager.ProcessErrorStateInfo Bu()
  {
    Object localObject = ((ActivityManager)ah.getContext().getSystemService("activity")).getProcessesInErrorState();
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
      if ((localProcessErrorStateInfo.uid == Process.myUid()) && (localProcessErrorStateInfo.condition == 2)) {
        return localProcessErrorStateInfo;
      }
    }
    return null;
  }
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
    ??? = null;
    for (;;)
    {
      if (this.bYB.bYt.block(10000L)) {
        this.bYB.bYt.close();
      }
      try
      {
        Thread.sleep(500L);
        label46:
        Object localObject2 = Bu();
        ??? = localObject2;
        if (localObject2 == null) {
          continue;
        }
        ??? = localObject2;
        localObject2 = ???;
        if (??? == null)
        {
          ??? = Bu();
          localObject2 = ???;
          if (??? == null)
          {
            ab.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
            this.bYB.bYz = null;
            return;
          }
        }
        ab.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
        for (;;)
        {
          Object localObject4;
          synchronized (this.bYB.bYq)
          {
            localObject4 = new ArrayList(this.bYB.bYq.size());
            int i = this.bYB.bYs.lastIndexOf('.');
            String str;
            if (i != -1)
            {
              str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
              str = this.bYB.bYs.substring(0, i) + '_' + str + this.bYB.bYs.substring(i);
              if (this.bYB.bYq.remove(str)) {
                ((ArrayList)localObject4).add(str);
              }
            }
            if (this.bYB.bYq.remove(this.bYB.bYs)) {
              ((ArrayList)localObject4).add(this.bYB.bYs);
            }
            ((ArrayList)localObject4).addAll(this.bYB.bYq);
            ??? = ((ArrayList)localObject4).iterator();
            if (((Iterator)???).hasNext())
            {
              localObject4 = (String)((Iterator)???).next();
              localObject4 = this.bYB.bYr + '/' + (String)localObject4;
              str = m.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
              if (str != null)
              {
                ab.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                this.bYB.s(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
              }
            }
            else
            {
              ab.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
              this.bYB.bYz = null;
              return;
            }
          }
          ab.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[] { localObject4 });
        }
      }
      catch (Exception localException)
      {
        break label46;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.m.b
 * JD-Core Version:    0.7.0.1
 */