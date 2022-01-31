package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import org.json.JSONObject;

public class d<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected volatile l grC;
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool;
    try
    {
      if (this.grC == null)
      {
        this.grC = new l(paramCONTEXT);
        this.grC.start();
      }
      bool = paramJSONObject.optBoolean("enable");
      if ((!bool) && (!i(paramCONTEXT)))
      {
        paramCONTEXT.C(paramInt, h("ok", null));
        return;
      }
    }
    finally {}
    this.grC.ezQ = d(paramCONTEXT, paramJSONObject);
    if (bool) {
      if (!i(paramCONTEXT)) {
        paramCONTEXT.C(paramInt, h("fail:system permission denied", null));
      }
    }
    for (;;)
    {
      paramCONTEXT.C(paramInt, h("ok", null));
      return;
      this.grC.Ff(1);
      continue;
      this.grC.Ff(2);
    }
  }
  
  protected Bundle d(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.d
 * JD-Core Version:    0.7.0.1
 */