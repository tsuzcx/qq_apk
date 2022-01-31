package com.tencent.mm.compatible.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
{
  public static c.a KA()
  {
    AppMethodBeat.i(92833);
    Object localObject = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    if (ac.erv.emL == 1) {}
    for (boolean bool = false;; bool = true)
    {
      if (!((SharedPreferences)localObject).contains("settings_voicerecorder_mode")) {
        ((SharedPreferences)localObject).edit().putBoolean("settings_voicerecorder_mode", bool).commit();
      }
      ab.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", new Object[] { Integer.valueOf(ac.erv.emL), Boolean.valueOf(bool), Boolean.valueOf(((SharedPreferences)localObject).getBoolean("settings_voicerecorder_mode", bool)) });
      if (!((SharedPreferences)localObject).getBoolean("settings_voicerecorder_mode", bool)) {
        break;
      }
      localObject = c.a.elO;
      AppMethodBeat.o(92833);
      return localObject;
    }
    localObject = c.a.elP;
    AppMethodBeat.o(92833);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.b.c
 * JD-Core Version:    0.7.0.1
 */