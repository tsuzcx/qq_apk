package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.jy;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static Map<String, Map<Integer, e>> kgT;
  private static final Pattern kgU;
  
  static
  {
    AppMethodBeat.i(121361);
    kgU = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");
    AppMethodBeat.o(121361);
  }
  
  public static void OG(String paramString)
  {
    AppMethodBeat.i(121359);
    if (kgT == null)
    {
      AppMethodBeat.o(121359);
      return;
    }
    paramString = (Map)kgT.get(paramString);
    if (paramString != null)
    {
      Iterator localIterator = paramString.values().iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).reset();
      }
      paramString.clear();
    }
    AppMethodBeat.o(121359);
  }
  
  public static e bz(String paramString, int paramInt)
  {
    AppMethodBeat.i(121358);
    if (kgT == null)
    {
      localObject = new HashMap();
      kgT = (Map)localObject;
      ((Map)localObject).put(paramString, new HashMap());
    }
    Object localObject = (Map)kgT.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      kgT.put(paramString, localObject);
    }
    for (;;)
    {
      e locale = (e)((Map)localObject).get(Integer.valueOf(paramInt));
      paramString = locale;
      if (locale == null) {
        switch (paramInt)
        {
        default: 
          paramString = new c();
        }
      }
      for (;;)
      {
        ((Map)localObject).put(Integer.valueOf(paramInt), paramString);
        AppMethodBeat.o(121358);
        return paramString;
        paramString = new b();
        continue;
        paramString = new c();
        continue;
        paramString = new d();
      }
    }
  }
  
  public static void cL(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(121360);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(121360);
      return;
    }
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(121357);
        Object localObject1 = a.bgb().matcher(this.kgV);
        int j;
        String str;
        if (((Matcher)localObject1).find())
        {
          ad.i("DrawCanvasMgr", "invalid draw data %s", new Object[] { this.kgV });
          int k = ((Matcher)localObject1).start();
          j = ((Matcher)localObject1).end();
          if (k > 30) {
            i = k - 30;
          }
          if (j >= this.kgV.length() - 30) {
            break label245;
          }
          j += 30;
          f.bfI();
          localObject1 = paramString1;
          str = this.kgV.substring(i, j);
          if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
            break label256;
          }
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.a.bgj().OJ((String)localObject1);
          if ((localObject2 != null) && (((IPCDynamicPageView)localObject2).kiN != null))
          {
            localObject2 = (z)((IPCDynamicPageView)localObject2).kiN.Cn("onWidgetDrawDataInvalid");
            if (localObject2 != null) {
              ((z)localObject2).Cl(str);
            }
          }
          localObject2 = new jy();
          ((jy)localObject2).eCE = ((jy)localObject2).t("WidgetAppid", "", true);
          ((jy)localObject2).eCF = ((jy)localObject2).t("SrcAppid", u.Ci((String)localObject1), true);
          ((jy)localObject2).eCG = ((jy)localObject2).t("DrawData", q.encode(str), true);
          ((jy)localObject2).aLk();
          AppMethodBeat.o(121357);
          return;
          label245:
          j = this.kgV.length();
          break;
          label256:
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("id", (String)localObject1);
          ((Bundle)localObject2).putInt("widgetState", 2113);
          com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.plugin.appbrand.dynamic.i.bfK().Ou((String)localObject1), (Parcelable)localObject2, f.a.class, null);
        }
      }
    }, "onDrawFrame");
    AppMethodBeat.o(121360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a
 * JD-Core Version:    0.7.0.1
 */