package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;

public enum x
{
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    return c.getMMString(paramInt, paramVarArgs);
  }
  
  public static void lO(int paramInt)
  {
    uV(ae.getResources().getString(paramInt));
  }
  
  public static void uV(String paramString)
  {
    ai.d(new x.1(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x
 * JD-Core Version:    0.7.0.1
 */