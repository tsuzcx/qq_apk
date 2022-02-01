package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.lq.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 592;
  public static final String NAME = "openBusinessView";
  p fqw;
  boolean jPM = false;
  private com.tencent.mm.sdk.b.c<lq> jPN;
  
  private void a(com.tencent.mm.plugin.appbrand.d paramd, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(46291);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt2));
    paramd.h(paramInt1, k(paramString, localHashMap));
    AppMethodBeat.o(46291);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c aZJ()
  {
    return h.jQg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.d
 * JD-Core Version:    0.7.0.1
 */