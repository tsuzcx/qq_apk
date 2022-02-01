package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.luggage.l.k;
import com.tencent.luggage.wxa.c.a.b;
import com.tencent.luggage.wxa.c.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends c<y>
{
  private static final int CTRL_INDEX = 107;
  private static final String NAME = "showActionSheet";
  public static a sqL;
  
  public static abstract interface a
  {
    public abstract void AV(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.b
 * JD-Core Version:    0.7.0.1
 */