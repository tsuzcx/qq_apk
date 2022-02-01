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
  public static boolean fEM = false;
  public String fEN = "";
  Map<String, String> fEO = null;
  private int fEP = 0;
  
  public static boolean Xp()
  {
    boolean bool = false;
    if (fEM)
    {
      fEM = false;
      bool = true;
    }
    return bool;
  }
  
  public final void j(Map<String, String> paramMap)
  {
    this.fEO = paramMap;
  }
  
  public final void la(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.fEP = paramInt;
    fEM = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    ad.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.fEP) });
    AppMethodBeat.o(155767);
  }
  
  public final void pk(String paramString)
  {
    this.fEN = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.y
 * JD-Core Version:    0.7.0.1
 */