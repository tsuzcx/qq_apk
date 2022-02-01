package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.f.a;

public class i
  implements g
{
  protected final AppBrandRuntime iGV;
  
  public i(AppBrandRuntime paramAppBrandRuntime)
  {
    this.iGV = paramAppBrandRuntime;
  }
  
  public void Mh(String paramString)
  {
    AppMethodBeat.i(147661);
    Toast.makeText(a.iV(this.iGV.mContext), String.format("jsapi banned %s", new Object[] { paramString }), 0).show();
    AppMethodBeat.o(147661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.i
 * JD-Core Version:    0.7.0.1
 */