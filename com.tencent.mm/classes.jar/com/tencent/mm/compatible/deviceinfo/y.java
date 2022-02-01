package com.tencent.mm.compatible.deviceinfo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Map;

public final class y
{
  public static boolean fIt = false;
  public String fIu = "";
  Map<String, String> fIv = null;
  private int fIw = 0;
  
  public static boolean Ym()
  {
    boolean bool = false;
    if (fIt)
    {
      fIt = false;
      bool = true;
    }
    return bool;
  }
  
  public final void i(Map<String, String> paramMap)
  {
    this.fIv = paramMap;
  }
  
  public final void kU(int paramInt)
  {
    AppMethodBeat.i(155767);
    this.fIw = paramInt;
    fIt = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    ac.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.fIw) });
    AppMethodBeat.o(155767);
  }
  
  public final void sw(String paramString)
  {
    this.fIu = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.y
 * JD-Core Version:    0.7.0.1
 */