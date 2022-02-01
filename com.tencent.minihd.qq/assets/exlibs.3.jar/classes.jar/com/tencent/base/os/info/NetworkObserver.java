package com.tencent.base.os.info;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.base.Global;

abstract class NetworkObserver
  extends BroadcastReceiver
{
  private volatile int cellLevel = -1;
  private final boolean cellListenEnabled;
  private PhoneStateListener signalListener;
  
  NetworkObserver()
  {
    if (Build.VERSION.SDK_INT >= 7) {}
    for (boolean bool = true;; bool = false)
    {
      this.cellListenEnabled = bool;
      return;
    }
  }
  
  private int getCdmaLevel(SignalStrength paramSignalStrength)
  {
    int i = paramSignalStrength.getCdmaDbm();
    int j = paramSignalStrength.getCdmaEcio();
    if (i >= -75)
    {
      i = 4;
      if (j < -90) {
        break label71;
      }
      j = 4;
    }
    for (;;)
    {
      if (i >= j) {
        return j;
      }
      return i;
      if (i >= -85)
      {
        i = 3;
        break;
      }
      if (i >= -95)
      {
        i = 2;
        break;
      }
      if (i >= -100)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label71:
      if (j >= -110) {
        j = 3;
      } else if (j >= -130) {
        j = 2;
      } else if (j >= -150) {
        j = 1;
      } else {
        j = 0;
      }
    }
    return j;
  }
  
  private int getCellLevel(SignalStrength paramSignalStrength)
  {
    if (paramSignalStrength == null) {
      return -1;
    }
    int i;
    if (paramSignalStrength.isGsm()) {
      i = getGsmLevel(paramSignalStrength);
    }
    int j;
    do
    {
      for (;;)
      {
        return i;
        i = getCdmaLevel(paramSignalStrength);
        j = getEvdoLevel(paramSignalStrength);
        if (j != 0)
        {
          if (i != 0) {
            break;
          }
          i = j;
        }
      }
    } while (j > i);
    for (;;)
    {
      i = j;
    }
  }
  
  private int getEvdoLevel(SignalStrength paramSignalStrength)
  {
    int i = paramSignalStrength.getEvdoDbm();
    int j = paramSignalStrength.getEvdoSnr();
    if (i >= -65)
    {
      i = 4;
      if (j < 7) {
        break label71;
      }
      j = 4;
    }
    for (;;)
    {
      if (i >= j) {
        return j;
      }
      return i;
      if (i >= -75)
      {
        i = 3;
        break;
      }
      if (i >= -90)
      {
        i = 2;
        break;
      }
      if (i >= -105)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label71:
      if (j >= 5) {
        j = 3;
      } else if (j >= 3) {
        j = 2;
      } else if (j >= 1) {
        j = 1;
      } else {
        j = 0;
      }
    }
    return j;
  }
  
  private int getGsmLevel(SignalStrength paramSignalStrength)
  {
    int i = 2;
    int j = paramSignalStrength.getGsmSignalStrength();
    if ((j <= 2) || (j == 99)) {
      i = 0;
    }
    do
    {
      return i;
      if (j >= 12) {
        return 4;
      }
      if (j >= 8) {
        return 3;
      }
    } while (j >= 5);
    return 1;
  }
  
  @SuppressLint({"InlinedApi"})
  private void initSignalListen()
  {
    if (!this.cellListenEnabled) {
      return;
    }
    this.signalListener = new PhoneStateListener()
    {
      public void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        NetworkObserver.this.cellLevel = NetworkObserver.this.getCellLevel(paramAnonymousSignalStrength);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
      }
    };
    TelephonyManager localTelephonyManager = (TelephonyManager)Global.getSystemService("phone");
    if (localTelephonyManager != null)
    {
      localTelephonyManager.listen(this.signalListener, 256);
      return;
    }
    this.signalListener = null;
  }
  
  public int getCellLevel()
  {
    return this.cellLevel;
  }
  
  public abstract void onNetworkChanged();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.cellListenEnabled) && (this.signalListener == null)) {}
    try
    {
      if (this.signalListener == null) {
        initSignalListen();
      }
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
        onNetworkChanged();
      }
      return;
    }
    finally {}
  }
  
  public void startListen()
  {
    Global.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public void stopListen()
  {
    Global.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.info.NetworkObserver
 * JD-Core Version:    0.7.0.1
 */