package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static boolean a(AudioManager paramAudioManager)
  {
    if (at.uc()) {
      return false;
    }
    y.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(q.dyn.dwN), Integer.valueOf(q.dyn.dwM) });
    if (((q.dyn.dwM == 1) || (q.dyn.dwN == -1)) && (paramAudioManager.isBluetoothScoOn()))
    {
      y.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bk.csb() });
      paramAudioManager.stopBluetoothSco();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */