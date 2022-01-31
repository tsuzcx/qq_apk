package com.tencent.mm.compatible.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;

public final class x
{
  public static boolean erd = false;
  public String ere = "";
  Map<String, String> erf = null;
  private int erg = 0;
  
  public static boolean LY()
  {
    boolean bool = false;
    if (erd)
    {
      erd = false;
      bool = true;
    }
    return bool;
  }
  
  public final void f(Map<String, String> paramMap)
  {
    this.erf = paramMap;
  }
  
  public final void iR(int paramInt)
  {
    AppMethodBeat.i(93016);
    this.erg = paramInt;
    erd = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    ab.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.erg) });
    AppMethodBeat.o(93016);
  }
  
  public final void ln(String paramString)
  {
    this.ere = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.x
 * JD-Core Version:    0.7.0.1
 */