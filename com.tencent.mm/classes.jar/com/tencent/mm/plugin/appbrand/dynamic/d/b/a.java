package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.uy;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static Map<String, Map<Integer, e>> rmf;
  private static final Pattern rmg;
  
  static
  {
    AppMethodBeat.i(121361);
    rmg = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");
    AppMethodBeat.o(121361);
  }
  
  public static void Zj(String paramString)
  {
    AppMethodBeat.i(121359);
    if (rmf == null)
    {
      AppMethodBeat.o(121359);
      return;
    }
    paramString = (Map)rmf.get(paramString);
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
  
  public static e cz(String paramString, int paramInt)
  {
    AppMethodBeat.i(121358);
    if (rmf == null)
    {
      localObject = new HashMap();
      rmf = (Map)localObject;
      ((Map)localObject).put(paramString, new HashMap());
    }
    Object localObject = (Map)rmf.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      rmf.put(paramString, localObject);
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
  
  public static void dE(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(121360);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(121360);
      return;
    }
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(121357);
        Object localObject1 = a.cnN().matcher(a.this);
        int j;
        String str;
        if (((Matcher)localObject1).find())
        {
          Log.i("DrawCanvasMgr", "invalid draw data %s", new Object[] { a.this });
          int k = ((Matcher)localObject1).start();
          j = ((Matcher)localObject1).end();
          if (k > 30) {
            i = k - 30;
          }
          if (j >= a.this.length() - 30) {
            break label245;
          }
          j += 30;
          f.cnu();
          localObject1 = paramString1;
          str = a.this.substring(i, j);
          if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
            break label256;
          }
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.a.cnV().Zm((String)localObject1);
          if ((localObject2 != null) && (((IPCDynamicPageView)localObject2).roa != null))
          {
            localObject2 = (y)((IPCDynamicPageView)localObject2).roa.KV("onWidgetDrawDataInvalid");
            if (localObject2 != null) {
              ((y)localObject2).KT(str);
            }
          }
          localObject2 = new uy();
          ((uy)localObject2).jIi = ((uy)localObject2).F("WidgetAppid", "", true);
          ((uy)localObject2).jIj = ((uy)localObject2).F("SrcAppid", u.KQ((String)localObject1), true);
          ((uy)localObject2).jIk = ((uy)localObject2).F("DrawData", r.cg(str), true);
          ((uy)localObject2).bMH();
          AppMethodBeat.o(121357);
          return;
          label245:
          j = a.this.length();
          break;
          label256:
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("id", (String)localObject1);
          ((Bundle)localObject2).putInt("widgetState", 2113);
          j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX((String)localObject1), (Parcelable)localObject2, f.a.class, null);
        }
      }
    }, "onDrawFrame");
    AppMethodBeat.o(121360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a
 * JD-Core Version:    0.7.0.1
 */