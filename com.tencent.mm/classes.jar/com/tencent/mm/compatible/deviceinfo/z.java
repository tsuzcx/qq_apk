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
  public static boolean lXf = false;
  String lXg = "";
  Map<String, String> lXh = null;
  private int lXi = 0;
  
  public static boolean aPB()
  {
    boolean bool = false;
    if (lXf)
    {
      lXf = false;
      bool = true;
    }
    return bool;
  }
  
  public final void Dv(String paramString)
  {
    this.lXg = paramString;
  }
  
  public final void q(Map<String, String> paramMap)
  {
    this.lXh = paramMap;
  }
  
  public final void qW(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.lXi = paramInt;
    lXf = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    Log.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.lXi) });
    AppMethodBeat.o(155767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z
 * JD-Core Version:    0.7.0.1
 */