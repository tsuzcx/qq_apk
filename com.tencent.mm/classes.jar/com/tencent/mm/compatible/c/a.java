package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static boolean a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(92902);
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      AppMethodBeat.o(92902);
      return false;
    }
    if (ax.Ep())
    {
      AppMethodBeat.o(92902);
      return false;
    }
    ab.i("MicroMsg.BluetoothUtil", "start SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s ", new Object[] { Integer.valueOf(ac.erF.eoL) });
    if (((ac.erF.eoL == 1) || (ac.erF.eoL == -1)) && (!paramAudioManager.isBluetoothScoOn()))
    {
      ab.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bo.dtY() });
      paramAudioManager.startBluetoothSco();
    }
    AppMethodBeat.o(92902);
    return true;
  }
  
  public static boolean b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(92903);
    if (ax.Ep())
    {
      AppMethodBeat.o(92903);
      return false;
    }
    ab.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(ac.erF.eoL), Integer.valueOf(ac.erF.eoK) });
    if (((ac.erF.eoK == 1) || (ac.erF.eoL == -1)) && (paramAudioManager.isBluetoothScoOn()))
    {
      ab.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bo.dtY() });
      paramAudioManager.stopBluetoothSco();
    }
    AppMethodBeat.o(92903);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */