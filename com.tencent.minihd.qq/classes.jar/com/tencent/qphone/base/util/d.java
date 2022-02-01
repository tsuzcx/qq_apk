package com.tencent.qphone.base.util;

import LBS.Cell;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;

final class d
  extends PhoneStateListener
{
  private short a = 0;
  
  public void onCellLocationChanged(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((paramCellLocation instanceof GsmCellLocation))
        {
          c.a(new ArrayList());
          localCell = new Cell();
          localCell.iLac = ((GsmCellLocation)paramCellLocation).getLac();
          localCell.iCellId = ((GsmCellLocation)paramCellLocation).getCid();
          str = c.a().getNetworkOperator();
          if (str != null)
          {
            int i = str.length();
            if (i < 5) {}
          }
        }
      }
      catch (Exception localException)
      {
        Cell localCell;
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("LocationUtil", 2, "onCellLocationChanged exception:" + localException.getMessage());
        continue;
      }
      try
      {
        localCell.shMcc = Short.valueOf(str.substring(0, 3)).shortValue();
        localCell.shMnc = Short.valueOf(str.substring(3, 5)).shortValue();
        localCell.shRssi = this.a;
        if ((localCell.iLac != -1) && (localCell.iCellId != -1)) {
          c.b().add(0, localCell);
        }
        super.onCellLocationChanged(paramCellLocation);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    if (paramSignalStrength.isGsm()) {
      if (paramSignalStrength.getGsmSignalStrength() != 99) {
        this.a = ((short)(paramSignalStrength.getGsmSignalStrength() * 2 - 113));
      }
    }
    for (;;)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      return;
      this.a = ((short)paramSignalStrength.getGsmSignalStrength());
      continue;
      this.a = ((short)paramSignalStrength.getCdmaDbm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.d
 * JD-Core Version:    0.7.0.1
 */