package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.f.a;

public class l
  implements j
{
  protected final AppBrandRuntime jDb;
  
  public l(AppBrandRuntime paramAppBrandRuntime)
  {
    this.jDb = paramAppBrandRuntime;
  }
  
  public void UB(String paramString)
  {
    AppMethodBeat.i(147661);
    Toast.makeText(a.jw(this.jDb.mContext), String.format("jsapi banned %s", new Object[] { paramString }), 0).show();
    AppMethodBeat.o(147661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.l
 * JD-Core Version:    0.7.0.1
 */