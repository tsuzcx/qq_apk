package com.tencent.matrix.a;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.a;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.c.a;
import com.tencent.matrix.g.d;
import java.util.Iterator;
import java.util.List;

public class b
  extends com.tencent.matrix.e.b
{
  private static String cQi = null;
  private static String sPackageName = null;
  public final com.tencent.matrix.a.b.c cQh;
  
  public b(com.tencent.matrix.a.b.b paramb)
  {
    this.cQh = new com.tencent.matrix.a.b.c(paramb);
    com.tencent.matrix.g.c.i("Matrix.battery.BatteryMonitorPlugin", "setUp battery monitor plugin with configs: ".concat(String.valueOf(paramb)), new Object[0]);
  }
  
  public final String getPackageName()
  {
    if (sPackageName == null)
    {
      try
      {
        if (sPackageName != null) {
          break label66;
        }
        if (getApplication() == null) {
          throw new IllegalStateException(getTag() + " is not yet init!");
        }
      }
      finally {}
      sPackageName = getApplication().getPackageName();
    }
    label66:
    return sPackageName;
  }
  
  public final String getProcessName()
  {
    if (cQi == null)
    {
      try
      {
        if (cQi != null) {
          break label65;
        }
        Application localApplication = getApplication();
        if (localApplication == null) {
          throw new IllegalStateException(getTag() + " is not yet init!");
        }
      }
      finally {}
      cQi = d.getProcessName(localContext);
    }
    label65:
    return cQi;
  }
  
  public String getTag()
  {
    return "BatteryMonitorPlugin";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    if (!this.cQh.cSe.cRU) {
      a.cPA.b(this);
    }
  }
  
  public boolean isForeground()
  {
    return this.cQh.cSh;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    Object localObject = this.cQh;
    if (!com.tencent.matrix.b.isInstalled())
    {
      com.tencent.matrix.g.c.e("Matrix.battery.BatteryMonitorCore", "Matrix was not installed yet, just ignore the event", new Object[0]);
      return;
    }
    ((com.tencent.matrix.a.b.c)localObject).cSh = paramBoolean;
    Message localMessage;
    if (!paramBoolean)
    {
      ((com.tencent.matrix.a.b.c)localObject).mHandler.removeCallbacksAndMessages(null);
      localMessage = Message.obtain(((com.tencent.matrix.a.b.c)localObject).mHandler);
      localMessage.what = 1;
      ((com.tencent.matrix.a.b.c)localObject).mHandler.sendMessageDelayed(localMessage, com.tencent.matrix.a.b.c.cSk);
      if (((com.tencent.matrix.a.b.c)localObject).cSj)
      {
        if (((com.tencent.matrix.a.b.c)localObject).cSd != null)
        {
          ((com.tencent.matrix.a.b.c)localObject).mHandler.removeCallbacks(((com.tencent.matrix.a.b.c)localObject).cSd);
          ((com.tencent.matrix.a.b.c)localObject).cSd = null;
        }
        ((com.tencent.matrix.a.b.c)localObject).cSd = new c.a((com.tencent.matrix.a.b.c)localObject, (byte)0);
        ((com.tencent.matrix.a.b.c)localObject).mHandler.postDelayed(((com.tencent.matrix.a.b.c)localObject).cSd, com.tencent.matrix.a.b.c.cSm);
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.matrix.a.b.c)localObject).cSe.cRZ.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((g)((Iterator)localObject).next()).onForeground(paramBoolean);
      }
      break;
      if (!((com.tencent.matrix.a.b.c)localObject).mHandler.hasMessages(1))
      {
        if (((com.tencent.matrix.a.b.c)localObject).cSd != null)
        {
          ((com.tencent.matrix.a.b.c)localObject).mHandler.removeCallbacks(((com.tencent.matrix.a.b.c)localObject).cSd);
          ((com.tencent.matrix.a.b.c)localObject).cSd = null;
        }
        localMessage = Message.obtain(((com.tencent.matrix.a.b.c)localObject).mHandler);
        localMessage.what = 2;
        ((com.tencent.matrix.a.b.c)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
        if ((((com.tencent.matrix.a.b.c)localObject).cSi) && (((com.tencent.matrix.a.b.c)localObject).cSc != null))
        {
          ((com.tencent.matrix.a.b.c)localObject).mHandler.removeCallbacks(((com.tencent.matrix.a.b.c)localObject).cSc);
          ((com.tencent.matrix.a.b.c)localObject).cSc.cSp = 1;
          ((com.tencent.matrix.a.b.c)localObject).mHandler.post(((com.tencent.matrix.a.b.c)localObject).cSc);
        }
      }
    }
  }
  
  public void start()
  {
    super.start();
    com.tencent.matrix.a.b.c localc = this.cQh;
    try
    {
      if (!localc.cSg)
      {
        Iterator localIterator = localc.cSe.cRZ.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).Se();
        }
        localObject.cSg = true;
      }
    }
    finally {}
  }
  
  public void stop()
  {
    super.stop();
    com.tencent.matrix.a.b.c localc = this.cQh;
    try
    {
      if (localc.cSg)
      {
        localc.mHandler.removeCallbacksAndMessages(null);
        Iterator localIterator = localc.cSe.cRZ.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).Sf();
        }
        localObject.cSg = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b
 * JD-Core Version:    0.7.0.1
 */