package com.tencent.mm.plugin.lite.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.google.a.f;
import com.google.a.g;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class b
{
  public io.flutter.embedding.engine.a cGL;
  private ViewGroup ggq;
  public String jzm;
  public Context mContext;
  com.tencent.mm.plugin.lite.b sOa;
  public LuggageNativeViewJni sOb;
  public c sOc;
  public FlutterView sOd;
  public com.tencent.mm.plugin.lite.b.a sOe;
  private k.c sOf;
  public SparseArray<k.d> sOg;
  
  public b(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(146382);
    this.sOf = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(146372);
        ad.d("MicroMsg.AppLite.LiteRenderEngine", "onMethodCall", new Object[] { paramAnonymousj.method });
        Object localObject1 = paramAnonymousj.method;
        int i = -1;
        switch (((String)localObject1).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            label100:
            AppMethodBeat.o(146372);
            return;
            if (((String)localObject1).equals("startUI"))
            {
              i = 0;
              continue;
              if (((String)localObject1).equals("startUI4Result"))
              {
                i = 1;
                continue;
                if (((String)localObject1).equals("publishEvent")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        Object localObject2 = b.this;
        localObject1 = new Intent();
        if (paramAnonymousj.fTP != null)
        {
          paramAnonymousj = (HashMap)paramAnonymousj.fTP;
          String str = bt.by((String)paramAnonymousj.get("clazzName"), "");
          i = bt.a((Integer)paramAnonymousj.get("requestCode"), 0);
          if (bt.isNullOrNil(str))
          {
            ((Intent)localObject1).setClassName(((b)localObject2).mContext, str);
            ((Intent)localObject1).putExtra("data", paramAnonymousj);
            if (i == 0)
            {
              paramAnonymousj = ((b)localObject2).mContext;
              paramAnonymousd = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousj, paramAnonymousd.adn(), "com/tencent/mm/plugin/lite/flutter/LiteRenderEngine", "handleStartUIMethod", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousj.startActivity((Intent)paramAnonymousd.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousj, "com/tencent/mm/plugin/lite/flutter/LiteRenderEngine", "handleStartUIMethod", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(146372);
              return;
            }
            ((Activity)((b)localObject2).mContext).startActivityForResult((Intent)localObject1, i);
            ((b)localObject2).sOg.put(i, paramAnonymousd);
          }
        }
        AppMethodBeat.o(146372);
        return;
        paramAnonymousd = b.this;
        localObject1 = (HashMap)paramAnonymousj.fTP;
        ((Integer)((HashMap)localObject1).get("id")).intValue();
        ((Integer)((HashMap)localObject1).get("viewId")).intValue();
        paramAnonymousj = (String)((HashMap)localObject1).get("eventName");
        localObject1 = (HashMap)((HashMap)localObject1).get("detail");
        ((HashMap)localObject1).get("appId");
        ((HashMap)localObject1).get("pageName");
        localObject1 = (String)((HashMap)localObject1).get("clazzName");
        switch (paramAnonymousj.hashCode())
        {
        default: 
          label472:
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            ad.w("MicroMsg.AppLite.LiteRenderEngine", "un implement.");
            break label100;
            if (!paramAnonymousj.equals("NavigatorToNextPage")) {
              break label472;
            }
            i = 0;
            continue;
            if (!paramAnonymousj.equals("NavigatorToNativeUI")) {
              break label472;
            }
            i = 1;
          }
        }
        paramAnonymousj = new com.tencent.mm.plugin.lite.b(paramAnonymousd.mContext);
        localObject1 = new LuggageNativeViewJni();
        ((LuggageNativeViewJni)localObject1).init();
        paramAnonymousj.a((LuggageNativeViewJni)localObject1);
        localObject2 = paramAnonymousd.mContext.getResources().getDisplayMetrics();
        i = ((DisplayMetrics)localObject2).densityDpi;
        int j = ((DisplayMetrics)localObject2).widthPixels;
        int k = ((DisplayMetrics)localObject2).heightPixels;
        ad.i("MicroMsg.AppLite.LiteRenderEngine", "SetDisplayParams w=%d h=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(j) });
        ((LuggageNativeViewJni)localObject1).c(j, k, i, ((DisplayMetrics)localObject2).density);
        ((LuggageNativeViewJni)localObject1).cp("AppLiteUI hardcode");
        aq.n(new b.2(paramAnonymousd, paramAnonymousj), 200L);
        AppMethodBeat.o(146372);
        return;
        paramAnonymousj = new Intent();
        paramAnonymousj.setClassName(paramAnonymousd.mContext, (String)localObject1);
        paramAnonymousd = paramAnonymousd.mContext;
        paramAnonymousj = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousj);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousd, paramAnonymousj.adn(), "com/tencent/mm/plugin/lite/flutter/LiteRenderEngine", "handlePublicEvent", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousd.startActivity((Intent)paramAnonymousj.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousd, "com/tencent/mm/plugin/lite/flutter/LiteRenderEngine", "handlePublicEvent", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(146372);
      }
    };
    this.sOg = new SparseArray();
    this.mContext = paramContext;
    this.ggq = paramViewGroup;
    this.jzm = paramString;
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "init");
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "initJni");
    this.sOb = new LuggageNativeViewJni();
    this.sOb.init();
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "initJsEngine");
    this.sOa = new com.tencent.mm.plugin.lite.b(this.mContext);
    this.sOa.setJsExceptionHandler(new h()
    {
      public final void t(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(146374);
        ad.e("MicroMsg.J2V8_Console", "Js Exception:" + paramAnonymousString1 + "," + paramAnonymousString2);
        AppMethodBeat.o(146374);
      }
    });
    paramContext = (q)this.sOa.P(q.class);
    if (paramContext != null) {
      paramContext.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(146375);
          v localv = (v)b.this.sOa.P(v.class);
          b.this.sOb.s(localv.getIsolatePtr(), localv.LU());
          AppMethodBeat.o(146375);
        }
      });
    }
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "initRoute");
    paramContext = new HashMap();
    paramContext.put("pageName", "index.js");
    this.sOc = new c("liteapp", "app_id_empty", paramContext);
    this.sOc.rds = 2;
    paramContext = new HashMap();
    paramViewGroup = new HashMap();
    paramViewGroup.put("density", Float.valueOf(com.tencent.mm.cd.a.getDensity(aj.getContext())));
    paramViewGroup.put("widthPixels", Integer.valueOf(com.tencent.mm.cd.a.hV(aj.getContext())));
    paramViewGroup.put("heightPixels", Integer.valueOf(com.tencent.mm.cd.a.hW(aj.getContext())));
    paramViewGroup.put("densityDpi", Integer.valueOf(aj.getContext().getResources().getDisplayMetrics().densityDpi));
    paramContext.put("displayMetrics", paramViewGroup);
    paramContext = new g().xl().toJson(paramContext);
    if (this.sOc.params == null) {
      this.sOc.params = new HashMap();
    }
    this.sOc.params.put("data", paramContext);
    paramContext = UUID.randomUUID().toString();
    this.sOc.rds = 2;
    this.sOc.rdr = new HashMap();
    this.sOc.rdr.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.dT(aj.getContext())));
    this.sOc.rdr.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.hR(aj.getContext())));
    this.sOc.rdr.put("language", ac.eFu());
    this.sOc.rdr.put("sessionId", paramContext);
    this.sOc.rdr.put("renderPtr", Long.valueOf(this.sOb.ceQ));
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "initFlutterView");
    this.sOd = new FlutterView(this.mContext, FlutterView.b.IXY);
    this.sOd.setBackgroundColor(-1);
    this.ggq.addView(this.sOd, new ViewGroup.LayoutParams(-1, -1));
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "initFlutterEngine");
    FlutterMain.startInitialization(aj.getContext());
    FlutterMain.ensureInitializationComplete(aj.getContext(), null);
    this.cGL = a.fo(this.mContext);
    this.cGL.IYk.setInitialRoute(this.sOc.aOj());
    if (!this.cGL.IYe.IYQ)
    {
      System.loadLibrary("wechatlv");
      paramContext = this.cGL.IYe;
      aj.getContext().getAssets();
      paramContext.a(new DartExecutor.a(FlutterMain.findAppBundlePath(aj.getContext()), "LiteAppEntry", (byte)0));
    }
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "initChannel");
    io.flutter.b.a.registerWith(new com.tencent.mm.b(this.cGL, this.mContext));
    this.sOe = new com.tencent.mm.plugin.lite.b.a(this.cGL.IYe, "com.tencent.mm.liteapp/LiteApp");
    this.sOe.sNU = this.sOf;
    AppMethodBeat.o(146382);
  }
  
  public final void aeR(String paramString)
  {
    AppMethodBeat.i(146383);
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "invokeMethod method:%s", new Object[] { paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("viewId", Long.valueOf(this.sOb.CR()));
    this.sOe.a(paramString, localHashMap, null);
    AppMethodBeat.o(146383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.b
 * JD-Core Version:    0.7.0.1
 */