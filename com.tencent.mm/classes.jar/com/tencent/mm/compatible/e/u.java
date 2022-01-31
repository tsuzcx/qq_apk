package com.tencent.mm.compatible.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class u
{
  public static boolean dyD = false;
  public String dyE = "";
  Map<String, String> dyF = null;
  private int dyG = 0;
  
  public static boolean zw()
  {
    boolean bool = false;
    if (dyD)
    {
      dyD = false;
      bool = true;
    }
    return bool;
  }
  
  public final void e(Map<String, String> paramMap)
  {
    this.dyF = paramMap;
  }
  
  public final void fb(String paramString)
  {
    this.dyE = paramString;
  }
  
  public final void gC(int paramInt)
  {
    this.dyG = paramInt;
    dyD = true;
    SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "system_config_prefs", 4).edit();
    localEditor.putInt("update_swip_back_status", paramInt);
    localEditor.commit();
    y.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", new Object[] { Integer.valueOf(this.dyG) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.u
 * JD-Core Version:    0.7.0.1
 */