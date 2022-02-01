package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;

public final class q
{
  private static final LinkedList<String> mOR;
  
  static
  {
    AppMethodBeat.i(135375);
    mOR = new LinkedList();
    AppMethodBeat.o(135375);
  }
  
  public static void Vd(String paramString)
  {
    AppMethodBeat.i(135370);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(135370);
      return;
    }
    synchronized (mOR)
    {
      mOR.add(paramString);
      AppMethodBeat.o(135370);
      return;
    }
  }
  
  public static void a(i parami, String paramString, a parama)
  {
    AppMethodBeat.i(135372);
    a(parami, null, paramString, parama);
    AppMethodBeat.o(135372);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, final a parama)
  {
    AppMethodBeat.i(135373);
    ad.i("MicroMsg.JsValidationInjector", "hy: injecting file %s", new Object[] { paramString1 });
    final long l = System.currentTimeMillis();
    if (bt.isNullOrNil(paramString4))
    {
      ad.e("MicroMsg.JsValidationInjector", "hy: empty script!");
      if (parama != null) {
        parama.cT("isNullOrNil script");
      }
      AppMethodBeat.o(135373);
      return;
    }
    paramString4 = paramString4 + String.format("\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    String str = paramString4 + bt.nullAsNil(paramString5);
    paramString5 = null;
    paramString4 = paramString5;
    if (paramString1 != null) {
      paramString4 = paramString5;
    }
    try
    {
      if (paramString1.length() > 0) {
        paramString4 = new URL(paramString1);
      }
      paramString5 = (v)parami.P(v.class);
      if (paramString5 != null)
      {
        paramString5.a(paramString4, paramString2, paramString3, paramInt, str, new m.b()
        {
          public final void a(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(135367);
            q.a(this.val$filePath, parama, paramAnonymousString, l);
            if ((parama instanceof q.b)) {
              ((q.b)parama).a(paramAnonymousc);
            }
            AppMethodBeat.o(135367);
          }
        });
        AppMethodBeat.o(135373);
        return;
      }
    }
    catch (MalformedURLException parami)
    {
      ad.e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
      parama.cT("MalformedURLException");
      AppMethodBeat.o(135373);
      return;
    }
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      parami.a(paramString4, str, new ValueCallback() {});
      AppMethodBeat.o(135373);
      return;
    }
    parami.a(paramString4, paramString2, paramString3, paramInt, str, new ValueCallback() {});
    AppMethodBeat.o(135373);
  }
  
  public static void a(i parami, URL paramURL, String paramString, a parama)
  {
    AppMethodBeat.i(197447);
    if (bt.isNullOrNil(paramString))
    {
      if (parama != null) {
        parama.cT("isNullOrNil script");
      }
      AppMethodBeat.o(197447);
      return;
    }
    for (;;)
    {
      synchronized (mOR)
      {
        Iterator localIterator = mOR.iterator();
        if (!localIterator.hasNext()) {
          break label164;
        }
        if (!paramString.startsWith((String)localIterator.next())) {
          continue;
        }
        i = 0;
        ??? = paramString;
        if (i != 0) {
          ??? = paramString + bBu();
        }
        paramString = new ValueCallback() {};
        if (paramURL == null)
        {
          parami.evaluateJavascript((String)???, paramString);
          AppMethodBeat.o(197447);
          return;
        }
      }
      parami.a(paramURL, (String)???, paramString);
      AppMethodBeat.o(197447);
      return;
      label164:
      int i = 1;
    }
  }
  
  public static void a(i parami, ArrayList<ScriptPartObject> paramArrayList, String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(176788);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ad.e("MicroMsg.JsValidationInjector", "empty script list, abort");
      AppMethodBeat.o(176788);
      return;
    }
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      ScriptPartObject localScriptPartObject = (ScriptPartObject)localIterator.next();
      if (localScriptPartObject.type != 2) {
        break label345;
      }
      str2 = localScriptPartObject.wxaPkgPath;
      str1 = localScriptPartObject.wxaFileName;
      localObject = localScriptPartObject.wxaPkgKeyFilePath;
      ad.i("MicroMsg.JsValidationInjector", " contain wxa pkg: %s, file: %s", new Object[] { str2, str1 });
    }
    label345:
    for (;;)
    {
      break;
      final long l = System.currentTimeMillis();
      if ((bt.isNullOrNil(str2)) || (bt.isNullOrNil(str1)) || (bt.isNullOrNil((String)localObject)))
      {
        ad.e("MicroMsg.JsValidationInjector", "empty wxa path or file path or key path!");
        if (parama != null) {
          parama.cT("isNullOrNil empty path");
        }
        AppMethodBeat.o(176788);
        return;
      }
      str2 = null;
      localObject = str2;
      if (paramString1 != null) {
        localObject = str2;
      }
      try
      {
        if (paramString1.length() > 0) {
          localObject = new URL(paramString1);
        }
        paramString1 = new ScriptPartObject();
        paramString1.type = 1;
        paramString1.content = String.format(Locale.US, "\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
        paramArrayList.add(paramString1);
        paramString1 = (v)parami.P(v.class);
        if (paramString1 == null)
        {
          Assert.fail("Only addonV8 supports wxa script");
          AppMethodBeat.o(176788);
          return;
        }
      }
      catch (MalformedURLException parami)
      {
        ad.e("MicroMsg.JsValidationInjector", "MalformedURLException");
        parama.cT("MalformedURLException");
        AppMethodBeat.o(176788);
        return;
      }
      if (parama == null) {}
      for (parami = null;; parami = new m.b()
          {
            public final void a(String paramAnonymousString, m.c paramAnonymousc)
            {
              AppMethodBeat.i(176787);
              q.a(this.mOU, parama, paramAnonymousString, l);
              if ((parama instanceof q.b)) {
                ((q.b)parama).a(paramAnonymousc);
              }
              AppMethodBeat.o(176787);
            }
          })
      {
        paramString1.a(paramArrayList, (URL)localObject, paramString2, paramString3, parami);
        AppMethodBeat.o(176788);
        return;
      }
    }
  }
  
  public static String bBu()
  {
    AppMethodBeat.i(135371);
    String str = String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    AppMethodBeat.o(135371);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void cT(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
  
  public static abstract interface b
    extends q.a
  {
    public abstract void a(m.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.q
 * JD-Core Version:    0.7.0.1
 */