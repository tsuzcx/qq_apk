package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.f.a;

public class j
  implements h
{
  protected final AppBrandRuntime jzY;
  
  public j(AppBrandRuntime paramAppBrandRuntime)
  {
    this.jzY = paramAppBrandRuntime;
  }
  
  public void TR(String paramString)
  {
    AppMethodBeat.i(147661);
    Toast.makeText(a.jq(this.jzY.mContext), String.format("jsapi banned %s", new Object[] { paramString }), 0).show();
    AppMethodBeat.o(147661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.j
 * JD-Core Version:    0.7.0.1
 */