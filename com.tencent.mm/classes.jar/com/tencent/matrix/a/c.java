package com.tencent.matrix.a;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.a;
import com.tencent.matrix.a.a.a.m;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.a.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
  extends com.tencent.matrix.d.b
{
  private static String eMg = null;
  private static String sPackageName = null;
  public final d eOc;
  
  public c(com.tencent.matrix.a.a.c paramc)
  {
    this.eOc = new d(paramc);
    com.tencent.matrix.e.c.i("Matrix.battery.BatteryMonitorPlugin", "setUp battery monitor plugin with configs: ".concat(String.valueOf(paramc)), new Object[0]);
  }
  
  public final String getPackageName()
  {
    if (sPackageName == null)
    {
      try
      {
        if (sPackageName != null) {
          break label80;
        }
        Application localApplication3 = getApplication();
        Application localApplication1 = localApplication3;
        if (localApplication3 != null) {
          break label73;
        }
        if (!com.tencent.matrix.c.isInstalled()) {
          throw new IllegalStateException(getTag() + " is not yet init!");
        }
      }
      finally {}
      Application localApplication2 = com.tencent.matrix.c.avW().application;
      label73:
      sPackageName = localApplication2.getPackageName();
    }
    label80:
    return sPackageName;
  }
  
  public String getTag()
  {
    return "BatteryMonitorPlugin";
  }
  
  public void init(Application arg1, com.tencent.matrix.d.c paramc)
  {
    super.init(???, paramc);
    if (!this.eOc.ePD.ePo) {
      paramc = a.eLw;
    }
    synchronized (paramc.listeners)
    {
      paramc.listeners.remove(this);
      return;
    }
  }
  
  public boolean isForeground()
  {
    return this.eOc.ePI;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    Object localObject1 = this.eOc;
    if (!com.tencent.matrix.c.isInstalled())
    {
      com.tencent.matrix.e.c.e("Matrix.battery.BatteryMonitorCore", "Matrix was not installed yet, just ignore the event", new Object[0]);
      return;
    }
    ((d)localObject1).ePI = paramBoolean;
    Object localObject3;
    label66:
    Object localObject2;
    if (b.isInit())
    {
      localObject3 = b.awt();
      ((b)localObject3).eNX = paramBoolean;
      if (paramBoolean)
      {
        b.eNU = 0L;
        ((b)localObject3).mUiHandler.removeCallbacks(((b)localObject3).eNW);
      }
    }
    else
    {
      if (paramBoolean) {
        break label259;
      }
      ((d)localObject1).mHandler.removeCallbacksAndMessages(null);
      localObject2 = Message.obtain(((d)localObject1).mHandler);
      ((Message)localObject2).what = 1;
      ((d)localObject1).mHandler.sendMessageDelayed((Message)localObject2, ((d)localObject1).ePL);
      if (((d)localObject1).ePK)
      {
        if (((d)localObject1).ePF != null)
        {
          ((d)localObject1).mHandler.removeCallbacks(((d)localObject1).ePF);
          ((d)localObject1).ePF = null;
        }
        ((d)localObject1).ePF = new d.a((d)localObject1, (byte)0);
        ((d)localObject1).mHandler.postDelayed(((d)localObject1).ePF, ((d)localObject1).ePN);
      }
    }
    for (;;)
    {
      localObject1 = ((d)localObject1).ePD.ePA.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((m)((Iterator)localObject1).next()).onForeground(paramBoolean);
      }
      break;
      b.eNU = SystemClock.uptimeMillis();
      localObject2 = ((b)localObject3).mUiHandler;
      b.a locala = ((b)localObject3).eNW;
      localObject3 = ((b)localObject3).eNW;
      ((b.a)localObject3).eOb = 0L;
      ((b.a)localObject3).dC(300000L);
      ((Handler)localObject2).postDelayed(locala, ((b.a)localObject3).eOb);
      break label66;
      label259:
      if (!((d)localObject1).mHandler.hasMessages(1))
      {
        if (((d)localObject1).ePF != null)
        {
          ((d)localObject1).mHandler.removeCallbacks(((d)localObject1).ePF);
          ((d)localObject1).ePF = null;
        }
        localObject2 = Message.obtain(((d)localObject1).mHandler);
        ((Message)localObject2).what = 2;
        ((d)localObject1).mHandler.sendMessageAtFrontOfQueue((Message)localObject2);
        if ((((d)localObject1).ePJ) && (((d)localObject1).ePE != null))
        {
          ((d)localObject1).mHandler.removeCallbacks(((d)localObject1).ePE);
          ((d)localObject1).ePE.ePQ = 1;
          ((d)localObject1).mHandler.post(((d)localObject1).ePE);
        }
      }
    }
  }
  
  public void start()
  {
    super.start();
    d locald = this.eOc;
    Object localObject2;
    try
    {
      if (!locald.ePH)
      {
        localObject2 = locald.ePD.ePA.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((m)((Iterator)localObject2).next()).awI();
        }
        localObject1.ePH = true;
      }
    }
    finally {}
    if (b.isInit())
    {
      localObject2 = b.awt();
      ((b)localObject2).eNY = localObject1;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((b)localObject2).mContext.registerReceiver(new b.1((b)localObject2), localIntentFilter);
    }
  }
  
  public void stop()
  {
    super.stop();
    d locald = this.eOc;
    try
    {
      if (locald.ePH)
      {
        locald.mHandler.removeCallbacksAndMessages(null);
        Iterator localIterator = locald.ePD.ePA.iterator();
        while (localIterator.hasNext()) {
          ((m)localIterator.next()).awJ();
        }
        localObject.ePH = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.c
 * JD-Core Version:    0.7.0.1
 */