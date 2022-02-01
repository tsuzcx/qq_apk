package com.tencent.mm.compatible.deviceinfo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import java.util.Map;

public final class z
{
  public static boolean jtO = false;
  String jtP = "";
  Map<String, String> jtQ = null;
  private int jtR = 0;
  
  public static boolean avg()
  {
    boolean bool = false;
    if (jtO)
    {
      jtO = false;
      bool = true;
    }
    return bool;
  }
  
  public final void KQ(String paramString)
  {
    this.jtP = paramString;
  }
  
  public final void j(Map<String, String> paramMap)
  {
    this.jtQ = paramMap;
  }
  
  public final void qP(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.jtR = paramInt;
    jtO = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    Log.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.jtR) });
    AppMethodBeat.o(155767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z
 * JD-Core Version:    0.7.0.1
 */