package com.tencent.mm.compatible.deviceinfo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Map;

public final class y
{
  public static boolean geb = false;
  public String gec = "";
  Map<String, String> ged = null;
  private int gee = 0;
  
  public static boolean aaX()
  {
    boolean bool = false;
    if (geb)
    {
      geb = false;
      bool = true;
    }
    return bool;
  }
  
  public final void lv(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.gee = paramInt;
    geb = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    ae.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.gee) });
    AppMethodBeat.o(155767);
  }
  
  public final void p(Map<String, String> paramMap)
  {
    this.ged = paramMap;
  }
  
  public final void vH(String paramString)
  {
    this.gec = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.y
 * JD-Core Version:    0.7.0.1
 */