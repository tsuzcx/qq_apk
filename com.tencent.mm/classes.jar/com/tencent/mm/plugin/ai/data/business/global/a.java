package com.tencent.mm.plugin.ai.data.business.global;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static boolean a(PFloat paramPFloat)
  {
    AppMethodBeat.i(267521);
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = MMApplicationContext.getContext().registerReceiver(null, (IntentFilter)localObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AiDeviceData", "get battery charge intent is null");
      AppMethodBeat.o(267521);
      return false;
    }
    int i = ((Intent)localObject).getIntExtra("status", -1);
    if ((i == 2) || (i == 5)) {}
    for (boolean bool = true;; bool = false)
    {
      i = ((Intent)localObject).getIntExtra("level", -1);
      int j = ((Intent)localObject).getIntExtra("scale", -1);
      if ((i >= 0) && (j > 0)) {
        paramPFloat.value = (i * 1.0F / (j * 1.0F));
      }
      Log.i("MicroMsg.AiDeviceData", "get battery charge and level charging[%b] level[%f]", new Object[] { Boolean.valueOf(bool), Float.valueOf(paramPFloat.value) });
      AppMethodBeat.o(267521);
      return bool;
    }
  }
  
  public static int bZV()
  {
    AppMethodBeat.i(267513);
    AudioManager localAudioManager = com.tencent.mm.plugin.audio.c.a.cTW().audioManager;
    int i;
    if (localAudioManager != null) {
      if (localAudioManager.isWiredHeadsetOn()) {
        i = 3;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AiDeviceData", "get current audio mode [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(267513);
      return 0;
      if ((localAudioManager.isBluetoothA2dpOn()) || (localAudioManager.isBluetoothScoOn()))
      {
        i = 4;
      }
      else if (localAudioManager.isSpeakerphoneOn())
      {
        i = 1;
      }
      else
      {
        i = 2;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.a
 * JD-Core Version:    0.7.0.1
 */