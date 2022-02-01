package com.tencent.matrix.a;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.a;
import com.tencent.matrix.a.a.a.j;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.a.d.2;
import com.tencent.matrix.a.a.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
  extends com.tencent.matrix.d.b
{
  private static String cQP = null;
  private static String sPackageName = null;
  public final d cSM;
  
  public c(com.tencent.matrix.a.a.c paramc)
  {
    this.cSM = new d(paramc);
    com.tencent.matrix.e.c.i("Matrix.battery.BatteryMonitorPlugin", "setUp battery monitor plugin with configs: ".concat(String.valueOf(paramc)), new Object[0]);
  }
  
  public final d VL()
  {
    return this.cSM;
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
        if (!com.tencent.matrix.b.Vt()) {
          throw new IllegalStateException(getTag() + " is not yet init!");
        }
      }
      finally {}
      Application localApplication2 = com.tencent.matrix.b.Vu().application;
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
    if (!this.cSM.cUb.cTM) {
      paramc = a.cQs;
    }
    synchronized (paramc.listeners)
    {
      paramc.listeners.remove(this);
      return;
    }
  }
  
  public boolean isForeground()
  {
    return this.cSM.cUh;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    Object localObject1 = this.cSM;
    if (!com.tencent.matrix.b.Vt())
    {
      com.tencent.matrix.e.c.e("Matrix.battery.BatteryMonitorCore", "Matrix was not installed yet, just ignore the event", new Object[0]);
      return;
    }
    ((d)localObject1).cUh = paramBoolean;
    Object localObject3;
    label66:
    Object localObject2;
    if (b.isInit())
    {
      localObject3 = b.VJ();
      ((b)localObject3).cSH = paramBoolean;
      if (paramBoolean)
      {
        b.cSE = 0L;
        ((b)localObject3).mUiHandler.removeCallbacks(((b)localObject3).cSG);
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
      ((d)localObject1).mHandler.sendMessageDelayed((Message)localObject2, ((d)localObject1).cUk);
      if (((d)localObject1).cUj)
      {
        if (((d)localObject1).cUd != null)
        {
          ((d)localObject1).mHandler.removeCallbacks(((d)localObject1).cUd);
          ((d)localObject1).cUd = null;
        }
        ((d)localObject1).cUd = new d.a((d)localObject1, (byte)0);
        ((d)localObject1).mHandler.postDelayed(((d)localObject1).cUd, ((d)localObject1).cUm);
      }
    }
    for (;;)
    {
      localObject1 = ((d)localObject1).cUb.cTY.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((j)((Iterator)localObject1).next()).onForeground(paramBoolean);
      }
      break;
      b.cSE = SystemClock.uptimeMillis();
      localObject2 = ((b)localObject3).mUiHandler;
      b.a locala = ((b)localObject3).cSG;
      localObject3 = ((b)localObject3).cSG;
      ((b.a)localObject3).cSL = 0L;
      ((b.a)localObject3).bk(300000L);
      ((Handler)localObject2).postDelayed(locala, ((b.a)localObject3).cSL);
      break label66;
      label259:
      if (!((d)localObject1).mHandler.hasMessages(1))
      {
        if (((d)localObject1).cUd != null)
        {
          ((d)localObject1).mHandler.removeCallbacks(((d)localObject1).cUd);
          ((d)localObject1).cUd = null;
        }
        localObject2 = Message.obtain(((d)localObject1).mHandler);
        ((Message)localObject2).what = 2;
        ((d)localObject1).mHandler.sendMessageAtFrontOfQueue((Message)localObject2);
        if ((((d)localObject1).cUi) && (((d)localObject1).cUc != null))
        {
          ((d)localObject1).mHandler.removeCallbacks(((d)localObject1).cUc);
          ((d)localObject1).cUc.cUq = 1;
          ((d)localObject1).mHandler.post(((d)localObject1).cUc);
        }
      }
    }
  }
  
  public void start()
  {
    super.start();
    d locald1 = this.cSM;
    Object localObject;
    try
    {
      if (!locald1.cUg)
      {
        localObject = locald1.cUb.cTY.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).VZ();
        }
        locald2.cUg = true;
      }
    }
    finally {}
    locald2.mHandler.post(new d.2(locald2));
    if (b.isInit())
    {
      localObject = b.VJ();
      ((b)localObject).cSI = locald2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((b)localObject).mContext.registerReceiver(new b.1((b)localObject), localIntentFilter);
    }
  }
  
  public void stop()
  {
    super.stop();
    d locald = this.cSM;
    try
    {
      if (locald.cUg)
      {
        locald.mHandler.removeCallbacksAndMessages(null);
        Iterator localIterator = locald.cUb.cTY.iterator();
        while (localIterator.hasNext()) {
          ((j)localIterator.next()).Wa();
        }
        localObject.cUg = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c
 * JD-Core Version:    0.7.0.1
 */