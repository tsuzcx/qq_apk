package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.b.a.ha;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a$1
  implements Runnable
{
  a$1(String paramString1, String paramString2) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(121357);
    Object localObject1 = a.aVz().matcher(this.jmx);
    int j;
    String str;
    if (((Matcher)localObject1).find())
    {
      ad.i("DrawCanvasMgr", "invalid draw data %s", new Object[] { this.jmx });
      int k = ((Matcher)localObject1).start();
      j = ((Matcher)localObject1).end();
      if (k > 30) {
        i = k - 30;
      }
      if (j >= this.jmx.length() - 30) {
        break label245;
      }
      j += 30;
      f.aVg();
      localObject1 = this.jlO;
      str = this.jmx.substring(i, j);
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        break label256;
      }
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.a.aVH().Hl((String)localObject1);
      if ((localObject2 != null) && (((IPCDynamicPageView)localObject2).joq != null))
      {
        localObject2 = (z)((IPCDynamicPageView)localObject2).joq.vi("onWidgetDrawDataInvalid");
        if (localObject2 != null) {
          ((z)localObject2).vg(str);
        }
      }
      localObject2 = new ha();
      ((ha)localObject2).ejt = ((ha)localObject2).t("WidgetAppid", "", true);
      ((ha)localObject2).eju = ((ha)localObject2).t("SrcAppid", u.vd((String)localObject1), true);
      ((ha)localObject2).ejv = ((ha)localObject2).t("DrawData", p.encode(str), true);
      ((ha)localObject2).aBj();
      AppMethodBeat.o(121357);
      return;
      label245:
      j = this.jmx.length();
      break;
      label256:
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("id", (String)localObject1);
      ((Bundle)localObject2).putInt("widgetState", 2113);
      h.a(i.aVi().GW((String)localObject1), (Parcelable)localObject2, f.a.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.1
 * JD-Core Version:    0.7.0.1
 */