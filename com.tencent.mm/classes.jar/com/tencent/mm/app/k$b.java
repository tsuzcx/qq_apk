package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class k$b
  implements Runnable
{
  private k$b(k paramk) {}
  
  private static ActivityManager.ProcessErrorStateInfo sY()
  {
    Object localObject = ((ActivityManager)ae.getContext().getSystemService("activity")).getProcessesInErrorState();
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
    y.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
    ??? = null;
    for (;;)
    {
      if (this.bwR.bwJ.block(10000L)) {
        this.bwR.bwJ.close();
      }
      try
      {
        Thread.sleep(500L);
        label46:
        Object localObject2 = sY();
        ??? = localObject2;
        if (localObject2 == null) {
          continue;
        }
        ??? = localObject2;
        localObject2 = ???;
        if (??? == null)
        {
          ??? = sY();
          localObject2 = ???;
          if (??? == null)
          {
            y.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
            this.bwR.bwP = null;
            return;
          }
        }
        y.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
        for (;;)
        {
          Object localObject4;
          synchronized (this.bwR.bwG)
          {
            localObject4 = new ArrayList(this.bwR.bwG.size());
            int i = this.bwR.bwI.lastIndexOf('.');
            String str;
            if (i != -1)
            {
              str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
              str = this.bwR.bwI.substring(0, i) + '_' + str + this.bwR.bwI.substring(i);
              if (this.bwR.bwG.remove(str)) {
                ((ArrayList)localObject4).add(str);
              }
            }
            if (this.bwR.bwG.remove(this.bwR.bwI)) {
              ((ArrayList)localObject4).add(this.bwR.bwI);
            }
            ((ArrayList)localObject4).addAll(this.bwR.bwG);
            ??? = ((ArrayList)localObject4).iterator();
            if (((Iterator)???).hasNext())
            {
              localObject4 = (String)((Iterator)???).next();
              localObject4 = this.bwR.bwH + '/' + (String)localObject4;
              str = k.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
              if (str != null)
              {
                y.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                this.bwR.p(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
              }
            }
            else
            {
              y.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
              this.bwR.bwP = null;
              return;
            }
          }
          y.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[] { localObject4 });
        }
      }
      catch (Exception localException)
      {
        break label46;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.k.b
 * JD-Core Version:    0.7.0.1
 */