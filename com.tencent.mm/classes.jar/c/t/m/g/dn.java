package c.t.m.g;

import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

final class dn
  extends PhoneStateListener
{
  volatile boolean a;
  final dg b;
  byte[] c = new byte[0];
  CellLocation d = null;
  SignalStrength e = null;
  ServiceState f = null;
  long g;
  HandlerThread h;
  dn.a i;
  
  public dn(dg paramdg)
  {
    this.b = paramdg;
  }
  
  private void a()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (this.d != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.g > 2000L) {}
        for (int j = 1; j != 0; j = 0)
        {
          this.g = l;
          ea localea = ea.a(this.b, this.d, this.e);
          synchronized (this.c)
          {
            if ((this.i != null) && (localea != null))
            {
              dn.b localb = new dn.b(this.b);
              localb.a = localea;
              this.i.post(localb);
            }
            return;
          }
        }
      }
    }
  }
  
  final void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.e;
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException)
    {
      j.a("TxCellProvider", "listenCellState: failed! flags=" + paramInt, localException);
    }
  }
  
  final boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    try
    {
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (localGsmCellLocation.getCid() == 0)
      {
        int j = localGsmCellLocation.getLac();
        if (j == 0) {
          return false;
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      if (en.a(paramCellLocation) < 0) {
        return false;
      }
      if (en.a(this.d, paramCellLocation)) {
        return false;
      }
      paramCellLocation = ea.a(this.b, paramCellLocation, null);
      if (paramCellLocation == null) {}
      for (boolean bool = true; bool; bool = en.a(paramCellLocation)) {
        return true;
      }
    }
    return false;
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    if (a(paramCellLocation))
    {
      this.d = paramCellLocation;
      a();
      return;
    }
    j.a("TxCellProvider", 6, "onCellLocationChanged: illegal cell or same cell " + paramCellLocation);
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int k = 1;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    do
    {
      ServiceState localServiceState;
      do
      {
        return;
        localServiceState = this.f;
      } while ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState()));
      this.f = paramServiceState;
    } while (!this.a);
    int j;
    boolean bool;
    if (this.f != null) {
      if (this.f.getState() == 0)
      {
        j = 1;
        paramServiceState = this.b.e;
        bool = en.a(this.b.a);
        if (paramServiceState == null) {
          break label171;
        }
        if (paramServiceState.getSimState() != 5) {
          break label166;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (k == 0)) {
        j = 0;
      }
      paramServiceState = new Message();
      paramServiceState.what = 12999;
      paramServiceState.arg1 = 12003;
      paramServiceState.arg2 = j;
      this.b.b(paramServiceState);
      return;
      if (this.f.getState() == 1)
      {
        j = 0;
        break;
      }
      j = -1;
      break;
      label166:
      k = 0;
      continue;
      label171:
      k = 0;
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    for (;;)
    {
      return;
      try
      {
        SignalStrength localSignalStrength = this.e;
        int j = this.b.b.a;
        if ((localSignalStrength == null) || (en.a(j, localSignalStrength, paramSignalStrength)))
        {
          this.e = paramSignalStrength;
          a();
          return;
        }
      }
      catch (Exception paramSignalStrength)
      {
        j.a("TxCellProvider", 6, paramSignalStrength.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.dn
 * JD-Core Version:    0.7.0.1
 */