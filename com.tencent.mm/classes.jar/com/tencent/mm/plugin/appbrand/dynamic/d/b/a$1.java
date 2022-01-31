package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.dj;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a$1
  implements Runnable
{
  a$1(String paramString1, String paramString2) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(10877);
    Object localObject1 = a.azS().matcher(this.hpp);
    int j;
    String str;
    if (((Matcher)localObject1).find())
    {
      com.tencent.mm.sdk.platformtools.ab.i("DrawCanvasMgr", "invalid draw data %s", new Object[] { this.hpp });
      int k = ((Matcher)localObject1).start();
      j = ((Matcher)localObject1).end();
      if (k > 30) {
        i = k - 30;
      }
      if (j >= this.hpp.length() - 30) {
        break label213;
      }
      j += 30;
      com.tencent.mm.plugin.appbrand.dynamic.f.azz();
      localObject1 = this.hoG;
      str = this.hpp.substring(i, j);
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        break label224;
      }
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAa().Bn((String)localObject1);
      if ((localObject2 != null) && (((IPCDynamicPageView)localObject2).hrh != null))
      {
        localObject2 = (z)((IPCDynamicPageView)localObject2).hrh.qs("onWidgetDrawDataInvalid");
        if (localObject2 != null) {
          ((z)localObject2).qq(str);
        }
      }
      new dj().iN("").iO(u.qn((String)localObject1)).iP(q.encode(str)).ake();
      AppMethodBeat.o(10877);
      return;
      label213:
      j = this.hpp.length();
      break;
      label224:
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("id", (String)localObject1);
      ((Bundle)localObject2).putInt("widgetState", 2113);
      com.tencent.mm.ipcinvoker.f.a(i.azB().AY((String)localObject1), (Parcelable)localObject2, f.a.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.1
 * JD-Core Version:    0.7.0.1
 */