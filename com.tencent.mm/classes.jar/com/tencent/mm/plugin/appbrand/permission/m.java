package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class m
  implements k
{
  protected final AppBrandRuntime qwG;
  
  public m(AppBrandRuntime paramAppBrandRuntime)
  {
    this.qwG = paramAppBrandRuntime;
  }
  
  public void afr(String paramString)
  {
    AppMethodBeat.i(147661);
    Toast.makeText(AndroidContextUtil.castActivityOrNull(this.qwG.mContext), String.format("jsapi banned %s", new Object[] { paramString }), 0).show();
    AppMethodBeat.o(147661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.m
 * JD-Core Version:    0.7.0.1
 */