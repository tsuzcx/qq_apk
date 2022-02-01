package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.na.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 592;
  public static final String NAME = "openBusinessView";
  q gut;
  boolean lUi = false;
  private IListener<na> lUj;
  
  private void a(com.tencent.mm.plugin.appbrand.d paramd, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(46291);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt2));
    paramd.i(paramInt1, n(paramString, localHashMap));
    AppMethodBeat.o(46291);
  }
  
  public final c bGm()
  {
    return g.lUC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.d
 * JD-Core Version:    0.7.0.1
 */