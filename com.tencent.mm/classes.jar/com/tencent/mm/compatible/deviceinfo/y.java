package com.tencent.mm.compatible.deviceinfo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import java.util.Map;

public final class y
{
  public static boolean gJA = false;
  public String gJB = "";
  Map<String, String> gJC = null;
  private int gJD = 0;
  
  public static boolean aoW()
  {
    boolean bool = false;
    if (gJA)
    {
      gJA = false;
      bool = true;
    }
    return bool;
  }
  
  public final void DY(String paramString)
  {
    this.gJB = paramString;
  }
  
  public final void oy(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.gJD = paramInt;
    gJA = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    Log.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.gJD) });
    AppMethodBeat.o(155767);
  }
  
  public final void r(Map<String, String> paramMap)
  {
    this.gJC = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.y
 * JD-Core Version:    0.7.0.1
 */