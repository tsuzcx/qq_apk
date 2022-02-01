package com.tencent.mm.plugin.appbrand.utils;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;

public final class z
{
  private static final LinkedList<String> uqW;
  
  static
  {
    AppMethodBeat.i(135375);
    uqW = new LinkedList();
    AppMethodBeat.o(135375);
  }
  
  public static void a(i parami, String paramString, a parama)
  {
    AppMethodBeat.i(135372);
    a(parami, null, paramString, parama);
    AppMethodBeat.o(135372);
  }
  
  public static void a(i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, final a parama)
  {
    AppMethodBeat.i(135373);
    Log.i("MicroMsg.JsValidationInjector", "hy: injecting file %s", new Object[] { paramString1 });
    final long l = System.currentTimeMillis();
    if (Util.isNullOrNil(paramString4))
    {
      Log.e("MicroMsg.JsValidationInjector", "hy: empty script!");
      if (parama != null) {
        parama.eW("isNullOrNil script");
      }
      AppMethodBeat.o(135373);
      return;
    }
    paramString4 = paramString4 + String.format("\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    String str = paramString4 + Util.nullAsNil(paramString5);
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
      paramString5 = (v)parami.Z(v.class);
      if (paramString5 != null)
      {
        paramString5.a(paramString4, paramString2, paramString3, paramInt, str, new m.b()
        {
          public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(135367);
            z.a(z.this, parama, paramAnonymousString, l);
            if ((parama instanceof z.b)) {
              ((z.b)parama).a(paramAnonymousc);
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
      Log.e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
      parama.eW("MalformedURLException");
      AppMethodBeat.o(135373);
      return;
    }
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
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
    AppMethodBeat.i(317327);
    if (Util.isNullOrNil(paramString))
    {
      if (parama != null) {
        parama.eW("isNullOrNil script");
      }
      AppMethodBeat.o(317327);
      return;
    }
    for (;;)
    {
      synchronized (uqW)
      {
        Iterator localIterator = uqW.iterator();
        if (!localIterator.hasNext()) {
          break label164;
        }
        if (!paramString.startsWith((String)localIterator.next())) {
          continue;
        }
        i = 0;
        ??? = paramString;
        if (i != 0) {
          ??? = paramString + cNC();
        }
        paramString = new ValueCallback() {};
        if (paramURL == null)
        {
          parami.evaluateJavascript((String)???, paramString);
          AppMethodBeat.o(317327);
          return;
        }
      }
      parami.a(paramURL, (String)???, paramString);
      AppMethodBeat.o(317327);
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
      Log.e("MicroMsg.JsValidationInjector", "empty script list, abort");
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
      Log.i("MicroMsg.JsValidationInjector", " contain wxa pkg: %s, file: %s", new Object[] { str2, str1 });
    }
    label345:
    for (;;)
    {
      break;
      final long l = System.currentTimeMillis();
      if ((Util.isNullOrNil(str2)) || (Util.isNullOrNil(str1)) || (Util.isNullOrNil((String)localObject)))
      {
        Log.e("MicroMsg.JsValidationInjector", "empty wxa path or file path or key path!");
        if (parama != null) {
          parama.eW("isNullOrNil empty path");
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
        paramString1 = (v)parami.Z(v.class);
        if (paramString1 == null)
        {
          Assert.fail("Only addonV8 supports wxa script");
          AppMethodBeat.o(176788);
          return;
        }
      }
      catch (MalformedURLException parami)
      {
        Log.e("MicroMsg.JsValidationInjector", "MalformedURLException");
        parama.eW("MalformedURLException");
        AppMethodBeat.o(176788);
        return;
      }
      if (parama == null) {}
      for (parami = null;; parami = new m.b()
          {
            public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
            {
              AppMethodBeat.i(176787);
              z.a(z.this, parama, paramAnonymousString, l);
              if ((parama instanceof z.b)) {
                ((z.b)parama).a(paramAnonymousc);
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
  
  public static void agG(String paramString)
  {
    AppMethodBeat.i(135370);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(135370);
      return;
    }
    synchronized (uqW)
    {
      uqW.add(paramString);
      AppMethodBeat.o(135370);
      return;
    }
  }
  
  public static String cNC()
  {
    AppMethodBeat.i(135371);
    String str = String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    AppMethodBeat.o(135371);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void eW(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
  
  public static abstract interface b
    extends z.a
  {
    public abstract void a(m.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.z
 * JD-Core Version:    0.7.0.1
 */