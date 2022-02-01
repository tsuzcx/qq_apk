package com.tencent.mm.compatible.deviceinfo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Map;

public final class y
{
  public static boolean gbT = false;
  public String gbU = "";
  Map<String, String> gbV = null;
  private int gbW = 0;
  
  public static boolean aaO()
  {
    boolean bool = false;
    if (gbT)
    {
      gbT = false;
      bool = true;
    }
    return bool;
  }
  
  public final void i(Map<String, String> paramMap)
  {
    this.gbV = paramMap;
  }
  
  public final void lt(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.gbW = paramInt;
    gbT = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    ad.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.gbW) });
    AppMethodBeat.o(155767);
  }
  
  public final void vl(String paramString)
  {
    this.gbU = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.y
 * JD-Core Version:    0.7.0.1
 */