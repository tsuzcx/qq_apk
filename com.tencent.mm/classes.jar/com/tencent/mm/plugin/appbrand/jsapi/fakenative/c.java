package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 592;
  public static final String NAME = "openBusinessView";
  private p efs;
  boolean hLw = false;
  private com.tencent.mm.sdk.b.c<kl> hLx;
  
  private void a(com.tencent.mm.plugin.appbrand.d paramd, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(131036);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt2));
    paramd.h(paramInt1, j(paramString, localHashMap));
    AppMethodBeat.o(131036);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c aCU()
  {
    return e.hLL;
  }
  
  final void aCV()
  {
    AppMethodBeat.i(131037);
    if (this.efs != null)
    {
      this.efs.dismiss();
      this.efs = null;
    }
    AppMethodBeat.o(131037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.c
 * JD-Core Version:    0.7.0.1
 */