package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.a.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.m.e;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.b;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class NotifyReceiver$NotifyService
  extends Service
{
  Boolean dhT = null;
  private com.tencent.mm.kernel.api.g dhU;
  
  private void e(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      y.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
      return;
    }
    if (!com.tencent.mm.kernel.g.DQ().dKP.dLj)
    {
      y.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", new Object[] { Integer.valueOf(0) });
      if (this.dhU != null) {
        com.tencent.mm.kernel.g.DQ().b(this.dhU);
      }
      this.dhU = new NotifyReceiver.NotifyService.1(this, System.currentTimeMillis(), paramIntent);
      com.tencent.mm.kernel.g.DQ().a(this.dhU);
      f.nEG.a(99L, 213L, 1L, false);
    }
    for (int i = -1;; i = 0)
    {
      if (i < 0)
      {
        y.e("MicroMsg.NotifyReceiver", "summerboot status %s", new Object[] { Integer.valueOf(-1) });
        return;
      }
      f(paramIntent);
      return;
    }
  }
  
  public static void eo(String paramString)
  {
    synchronized ()
    {
      if (NotifyReceiver.wa() == null) {
        NotifyReceiver.a(new WakerLock(ae.getContext(), "MicroMsg.NotifyReceiver"));
      }
      NotifyReceiver.wa().lock(5000L, paramString);
      return;
    }
  }
  
  private void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("notify_option_type", 0);
    if (i == 0)
    {
      y.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
      return;
    }
    if ((!com.tencent.mm.kernel.g.DK()) || (com.tencent.mm.kernel.a.CW()))
    {
      y.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.DK()), Boolean.valueOf(com.tencent.mm.kernel.a.CW()), Integer.valueOf(i) });
      return;
    }
    if (com.tencent.mm.kernel.g.Dk().edx == null)
    {
      y.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.Dk().bM(true);
    }
    if (this.dhT == null) {
      if (!com.tencent.mm.sdk.a.b.cqk()) {
        break label202;
      }
    }
    boolean bool;
    Object localObject;
    label202:
    int j;
    label377:
    byte[] arrayOfByte;
    long l;
    label814:
    label831:
    label972:
    label977:
    label994:
    label1903:
    for (;;)
    {
      bool = false;
      for (localObject = this;; localObject = this)
      {
        ((NotifyService)localObject).dhT = Boolean.valueOf(bool);
        y.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", new Object[] { this.dhT, Integer.valueOf(i) });
        switch (i)
        {
        default: 
          y.e("MicroMsg.NotifyReceiver", "invald opCode:" + i);
          return;
          j = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("AndroidOldNotifyReceiver"), 0);
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DN();
          if (j <= com.tencent.mm.a.h.aT(com.tencent.mm.kernel.a.CK(), 100)) {
            break label1903;
          }
          bool = true;
        }
      }
      if (this.dhT.booleanValue()) {
        t(ae.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
      }
      paramIntent = ae.getContext();
      y.i("MicroMsg.NotifyReceiver", "dealWithLooper");
      if ((!com.tencent.mm.kernel.g.DK()) || (com.tencent.mm.kernel.a.CW()))
      {
        y.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.g.DK() + " isHold:" + com.tencent.mm.kernel.a.CW());
        return;
      }
      if (!com.tencent.mm.kernel.g.Dk().foreground) {
        if ((paramIntent == null) || (aq.isWap(paramIntent))) {
          break label377;
        }
      }
      for (i = 1; i == 0; i = 0)
      {
        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().iT(2);
        return;
      }
      com.tencent.mm.kernel.g.Dk().a(new i(), 0);
      return;
      if (this.dhT.booleanValue())
      {
        t(ae.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
        j = paramIntent.getIntExtra("notify_respType", 0);
        localObject = paramIntent.getByteArrayExtra("notify_respBuf");
        arrayOfByte = paramIntent.getByteArrayExtra("notify_skey");
        l = paramIntent.getLongExtra("notfiy_recv_time", -1L);
        if (localObject == null) {}
        for (i = -1;; i = localObject.length)
        {
          y.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), bk.aac(bk.bG(arrayOfByte)) });
          switch (j)
          {
          default: 
            ((PluginZero)com.tencent.mm.kernel.g.t(PluginZero.class)).rSf.a(this, j, (byte[])localObject, arrayOfByte, l);
            return;
          }
        }
        if (bk.bE(arrayOfByte))
        {
          y.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + arrayOfByte);
          return;
        }
        if ((bk.bE((byte[])localObject)) || (localObject.length <= 8))
        {
          y.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
          return;
        }
        i = n.q((byte[])localObject, 0);
        j = n.q((byte[])localObject, 4);
        if (j != localObject.length - 8)
        {
          y.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + localObject.length);
          return;
        }
        paramIntent = new byte[j];
        System.arraycopy(localObject, 8, paramIntent, 0, j);
        y.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localObject.length), Long.valueOf(l) });
        try
        {
          NotifyReceiver.wc().lock();
          k.a(i, paramIntent, arrayOfByte, l);
          NotifyReceiver.wd().add(Long.valueOf(l));
          u(ae.getContext(), "NotifyReceiver.NotifyData");
          try
          {
            NotifyReceiver.wc().unlock();
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
          try
          {
            NotifyReceiver.wc().unlock();
            throw paramIntent;
            if (localObject == null)
            {
              i = 7;
              if (localObject != null) {
                break label972;
              }
              j = 2;
              if (localObject != null) {
                break label977;
              }
            }
            for (int k = -1;; k = localObject.length)
            {
              for (;;)
              {
                y.d("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                try
                {
                  NotifyReceiver.wc().lock();
                  i = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().a(i, j, "");
                  if (i > 0)
                  {
                    y.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[] { Integer.valueOf(i) });
                    NotifyReceiver.wd().add(Long.valueOf(i));
                    u(ae.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                  }
                  try
                  {
                    NotifyReceiver.wc().unlock();
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    return;
                  }
                  i = n.q((byte[])localObject, 0);
                  break;
                }
                finally {}
              }
              j = 1;
              break label831;
            }
            try
            {
              NotifyReceiver.wc().unlock();
              throw paramIntent;
              paramIntent = new StringBuilder("oreh on newsynccheck2 notify, notify=");
              if (localObject != null) {
                bool = true;
              }
              for (;;)
              {
                y.d("MicroMsg.NotifyReceiver", bool);
                paramIntent = new w.b();
                try
                {
                  paramIntent.A((byte[])localObject);
                  NotifyReceiver.wc().lock();
                  i = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().a(paramIntent.sqp, 1, paramIntent.cpg());
                  if (i > 0)
                  {
                    y.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[] { Integer.valueOf(i) });
                    NotifyReceiver.wd().add(Long.valueOf(i));
                    u(ae.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                  }
                  try
                  {
                    NotifyReceiver.wc().unlock();
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    return;
                  }
                  bool = false;
                }
                catch (Exception paramIntent)
                {
                  paramIntent = paramIntent;
                  y.printErrStackTrace("MicroMsg.NotifyReceiver", paramIntent, "", new Object[0]);
                  try
                  {
                    NotifyReceiver.wc().unlock();
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    return;
                  }
                }
                finally {}
              }
              try
              {
                NotifyReceiver.wc().unlock();
                throw paramIntent;
                com.tencent.mm.kernel.g.Dk().a(new i(), 0);
                return;
                y.d("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                i = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().a(7L, 13, "");
                try
                {
                  NotifyReceiver.wc().lock();
                  if (i > 0)
                  {
                    y.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[] { Integer.valueOf(i) });
                    NotifyReceiver.wd().add(Long.valueOf(i));
                    u(ae.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY");
                  }
                  try
                  {
                    NotifyReceiver.wc().unlock();
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    return;
                  }
                  try
                  {
                    NotifyReceiver.wc().unlock();
                    throw paramIntent;
                    j = paramIntent.getIntExtra("notify_respType", 0);
                    localObject = paramIntent.getByteArrayExtra("notify_respBuf");
                    arrayOfByte = paramIntent.getByteArrayExtra("notify_skey");
                    l = paramIntent.getLongExtra("notfiy_recv_time", -1L);
                    if (localObject == null) {}
                    for (i = -1;; i = localObject.length)
                    {
                      y.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), bk.aac(bk.bG(arrayOfByte)) });
                      switch (j)
                      {
                      default: 
                        ((PluginZero)com.tencent.mm.kernel.g.t(PluginZero.class)).rSf.a(this, j, (byte[])localObject, arrayOfByte, l);
                        return;
                      }
                    }
                    if (bk.bE(arrayOfByte))
                    {
                      y.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + arrayOfByte);
                      return;
                    }
                    if ((bk.bE((byte[])localObject)) || (localObject.length <= 8))
                    {
                      y.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                      return;
                    }
                    i = n.q((byte[])localObject, 0);
                    j = n.q((byte[])localObject, 4);
                    if (j != localObject.length - 8)
                    {
                      y.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + localObject.length);
                      return;
                    }
                    paramIntent = new byte[j];
                    System.arraycopy(localObject, 8, paramIntent, 0, j);
                    y.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localObject.length), Long.valueOf(l) });
                    k.a(i, paramIntent, arrayOfByte, l);
                    return;
                    if (localObject == null)
                    {
                      i = 7;
                      if (localObject != null) {
                        break label1744;
                      }
                      j = 2;
                      if (localObject != null) {
                        break label1749;
                      }
                    }
                    for (k = -1;; k = localObject.length)
                    {
                      y.i("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().a(i, j, "");
                      return;
                      i = n.q((byte[])localObject, 0);
                      break;
                      j = 1;
                      break label1667;
                    }
                    y.i("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                    ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().a(7L, 13, "");
                    return;
                    paramIntent = new StringBuilder("oreh on newsynccheck2 notify, notify=");
                    if (localObject != null) {}
                    for (bool = true;; bool = false)
                    {
                      y.i("MicroMsg.NotifyReceiver", bool);
                      paramIntent = new w.b();
                      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().a(paramIntent.sqp, 1, paramIntent.cpg());
                      return;
                    }
                    com.tencent.mm.kernel.g.Dk().a(new i(), 0);
                    return;
                  }
                  catch (Exception localException1)
                  {
                    break label1302;
                  }
                }
                finally {}
              }
              catch (Exception localException2)
              {
                break label1176;
              }
            }
            catch (Exception localException3)
            {
              break label994;
            }
          }
          catch (Exception localException4)
          {
            break label814;
          }
        }
        finally {}
      }
    }
  }
  
  private static void t(Context paramContext, String paramString)
  {
    synchronized ()
    {
      if (NotifyReceiver.wa() == null) {
        NotifyReceiver.a(new WakerLock(paramContext, "MicroMsg.NotifyReceiver"));
      }
      NotifyReceiver.wa().lock(14000L, paramString);
      return;
    }
  }
  
  private static void u(Context paramContext, String paramString)
  {
    synchronized ()
    {
      if (NotifyReceiver.wb() == null) {
        NotifyReceiver.b(new WakerLock(paramContext, "MicroMsg.NotifyReceiver"));
      }
      NotifyReceiver.wb().lock(60000L, paramString);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.h.zK()))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        break label76;
      }
      startForeground(-1212, new Notification());
    }
    for (;;)
    {
      long l = ae.cqS().getLong("mm_stop_service_time", 86400000L);
      new ah().postDelayed(new NotifyReceiver.NotifyService.2(this), l);
      return;
      label76:
      if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false))
      {
        startForeground(-1212, new Notification());
        startService(new Intent(this, NotifyReceiver.NotifyService.InnerService.class));
        y.i("MicroMsg.NotifyReceiver", "set service for mm.");
      }
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    e(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + paramInt1 + "startId :" + paramInt2 + " intent " + paramIntent);
    e(paramIntent);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyService
 * JD-Core Version:    0.7.0.1
 */