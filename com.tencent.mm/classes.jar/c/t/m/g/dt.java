package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class dt
{
  volatile boolean a;
  byte[] b = new byte[0];
  final dg c;
  ea d = null;
  ServiceState e = null;
  HandlerThread f;
  dt.a g;
  b h;
  Handler i;
  List<String> j;
  
  public dt(dg paramdg)
  {
    this.c = paramdg;
  }
  
  final class b
    extends PhoneStateListener
  {
    public b()
    {
      a(1025);
      dt.this.a = true;
    }
    
    final void a(int paramInt)
    {
      try
      {
        dt.this.c.e.listen(this, paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        j.a("TxNewCellProvider", 6, "listenCellState: failed! flags=" + paramInt + localThrowable.toString());
      }
    }
    
    @SuppressLint({"NewApi"})
    public final void onCellInfoChanged(List<CellInfo> paramList)
    {
      if ((dt.this.d != null) && (dt.this.d.a(100L))) {
        return;
      }
      if (paramList != null) {}
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int i;
        try
        {
          if (paramList.size() <= 0) {
            break label387;
          }
          localObject1 = new ArrayList();
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break label369;
          }
          localObject2 = (CellInfo)paramList.next();
          if (!((CellInfo)localObject2).isRegistered()) {
            continue;
          }
          localObject2 = ea.a(dt.this.c, (CellInfo)localObject2);
          if (localObject2 == null) {
            continue;
          }
          if (((ea)localObject2).a == ea.a.c) {
            break label292;
          }
          if ((((ea)localObject2).b < 0) || (((ea)localObject2).c < 0) || (((ea)localObject2).b == 535) || (((ea)localObject2).c == 535) || (((ea)localObject2).d < 0) || (((ea)localObject2).d == 65535) || (((ea)localObject2).d == 25840) || (((ea)localObject2).e == 65535) || (((ea)localObject2).e == 268435455) || (((ea)localObject2).e == 2147483647) || (((ea)localObject2).e == 50594049) || (((ea)localObject2).e == 8) || (((ea)localObject2).e == 10) || (((ea)localObject2).e == 33)) {
            break label503;
          }
          if (((ea)localObject2).e > 0) {
            break label287;
          }
        }
        catch (Throwable paramList)
        {
          j.a("TxNewCellProvider", "onCellInfoChanged Error.", paramList);
          return;
        }
        if (i != 0)
        {
          ((List)localObject1).add(localObject2);
          continue;
          label287:
          i = 1;
          continue;
          label292:
          if ((((ea)localObject2).b >= 0) && (((ea)localObject2).c >= 0) && (((ea)localObject2).b != 535) && (((ea)localObject2).c != 535) && (((ea)localObject2).d >= 0) && (((ea)localObject2).d != 65535) && (((ea)localObject2).e != 65535))
          {
            if (((ea)localObject2).e > 0) {
              break label513;
            }
            break label508;
            label369:
            if (((List)localObject1).size() > 0)
            {
              dt.a(dt.this, (List)localObject1);
              return;
              j.a("TxNewCellProvider", 6, "cellInfos list is null");
            }
            localObject1 = en.a(dt.this.c);
            if (localObject1 != null)
            {
              paramList = new ArrayList();
              localObject1 = ea.a(dt.this.c, (CellLocation)localObject1, null);
              if (localObject1 != null) {
                paramList.add(localObject1);
              }
              dt.a(dt.this, paramList);
              return;
            }
            j.a("TxNewCellProvider", 6, "cellLocation is still null,so we use the last CellInfo,this happen when restart requestLocationUpdate");
            if (dt.this.d == null) {
              break;
            }
            paramList = new ArrayList();
            paramList.add(dt.this.d);
            dt.a(dt.this, paramList);
            return;
            label503:
            i = 0;
            continue;
          }
          label387:
          label508:
          i = 0;
          continue;
          label513:
          i = 1;
        }
      }
    }
    
    public final void onServiceStateChanged(ServiceState paramServiceState)
    {
      int j = 1;
      int m = 0;
      super.onServiceStateChanged(paramServiceState);
      if (paramServiceState == null) {}
      for (;;)
      {
        return;
        try
        {
          Object localObject = dt.this.e;
          if ((localObject != null) && (((ServiceState)localObject).getState() == paramServiceState.getState())) {
            continue;
          }
          dt.this.e = paramServiceState;
          paramServiceState = dt.this;
          if (!paramServiceState.a) {
            continue;
          }
          int i;
          boolean bool;
          if (paramServiceState.e != null) {
            if (paramServiceState.e.getState() == 0)
            {
              i = 1;
              localObject = paramServiceState.c.e;
              bool = en.a(paramServiceState.c.a);
              if (localObject == null) {
                break label194;
              }
              if (((TelephonyManager)localObject).getSimState() != 5) {
                break label183;
              }
              break label196;
            }
          }
          for (;;)
          {
            localObject = new Message();
            ((Message)localObject).what = 12999;
            ((Message)localObject).arg1 = 12003;
            ((Message)localObject).arg2 = k;
            paramServiceState.c.b(localObject);
            return;
            i = paramServiceState.e.getState();
            if (i == 1)
            {
              i = 0;
              break;
            }
            i = -1;
            break;
            label183:
            j = 0;
            label194:
            label196:
            do
            {
              k = i;
              break;
              j = 0;
              k = m;
              if (bool) {
                break;
              }
            } while (j != 0);
            int k = m;
          }
          return;
        }
        catch (Throwable paramServiceState) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.dt
 * JD-Core Version:    0.7.0.1
 */