package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;

public final class k
{
  private static final android.support.v4.e.a<AppBrandRuntime, Bitmap> nUe;
  
  static
  {
    AppMethodBeat.i(48662);
    nUe = new android.support.v4.e.a();
    AppMethodBeat.o(48662);
  }
  
  public static aa a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(227610);
    if (paramAppBrandInitConfigWC.ldN)
    {
      if (!TextUtils.isEmpty(l.dM(paramAppBrandInitConfigWC.kHw)))
      {
        AppMethodBeat.o(227610);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.c.a.b.bZg())
      {
        Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(227610);
        return null;
      }
      String str = paramAppBrandInitConfigWC.lea;
      if (s.YS(str))
      {
        Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = BitmapUtil.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new aa(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(227610);
          return paramContext;
        }
      }
      AppMethodBeat.o(227610);
      return null;
    }
    AppMethodBeat.o(227610);
    return null;
  }
  
  public static ab a(Context paramContext, q paramq)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)nUe.remove(paramq);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new o(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramq.bsC());
    if (localObject != null)
    {
      ((aa)localObject).setRuntime(paramq);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (com.tencent.mm.plugin.appbrand.af.g.an(paramq))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.af.b(en(paramContext), paramq);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((r.am(paramq)) || (bb.r(paramq)) || (paramq.bsN()))
    {
      if (paramq.NA()) {}
      for (paramContext = new g(en(paramContext), paramq, paramq.bsC().cyv);; paramContext = new m(en(paramContext), paramq, paramq.bsC().cyv))
      {
        if (paramq.bsN()) {
          paramContext.CF(true);
        }
        AppMethodBeat.o(48659);
        return paramContext;
      }
    }
    if (paramq.NA())
    {
      localObject = new h(en(paramContext), paramq);
      if (paramq.brL())
      {
        paramContext = new c(en(paramContext), paramq, (ab)localObject, paramq.kDu);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      AppMethodBeat.o(48659);
      return localObject;
    }
    AppBrandUILoadingSplash localAppBrandUILoadingSplash = (AppBrandUILoadingSplash)paramq.bsn().a(AppBrandUILoadingSplash.class, paramContext);
    boolean bool;
    if (localAppBrandUILoadingSplash != null)
    {
      Log.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramq.OU().brandName });
      localAppBrandUILoadingSplash.kEc = paramq;
      Activity localActivity = AndroidContextUtil.castActivityOrNull(paramq.mContext);
      localObject = localAppBrandUILoadingSplash;
      if ((localAppBrandUILoadingSplash.getContext() instanceof MutableContextWrapper))
      {
        ((MutableContextWrapper)localAppBrandUILoadingSplash.getContext()).setBaseContext(localActivity);
        int i = localAppBrandUILoadingSplash.getResources().getColor(2131099650);
        if (localAppBrandUILoadingSplash.isDarkMode()) {
          break label418;
        }
        bool = true;
        localAppBrandUILoadingSplash.S(i, bool);
      }
    }
    for (localObject = localAppBrandUILoadingSplash;; localObject = new AppBrandUILoadingSplash(en(paramContext), paramq))
    {
      ((AppBrandUILoadingSplash)localObject).setLabelInjector(new AppBrandUILoadingSplash.a()
      {
        public final void a(ViewStub paramAnonymousViewStub)
        {
          AppMethodBeat.i(227608);
          if ((com.tencent.luggage.sdk.config.e.hO(this.kzl.bsC().lec)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smL, 0) == 1))
          {
            paramAnonymousViewStub.setLayoutResource(2131493102);
            paramAnonymousViewStub.inflate();
          }
          AppMethodBeat.o(227608);
        }
        
        @SuppressLint({"ResourceType"})
        public final void b(ViewStub paramAnonymousViewStub)
        {
          AppMethodBeat.i(227609);
          if ((com.tencent.luggage.sdk.config.e.hP(this.kzl.bsC().leb)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skg, 0) == 1))
          {
            paramAnonymousViewStub.setLayoutResource(2131493105);
            paramAnonymousViewStub = (ImageView)paramAnonymousViewStub.inflate().findViewById(2131302468);
            if (!ao.isDarkMode()) {
              break label81;
            }
          }
          label81:
          for (int i = 2131689707;; i = 2131689706)
          {
            paramAnonymousViewStub.setImageResource(i);
            AppMethodBeat.o(227609);
            return;
          }
        }
      });
      if (!paramq.brL()) {
        break label440;
      }
      paramContext = new c(en(paramContext), paramq, (ab)localObject, paramq.kDu);
      AppMethodBeat.o(48659);
      return paramContext;
      label418:
      bool = false;
      break;
    }
    label440:
    AppMethodBeat.o(48659);
    return localObject;
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, Bitmap paramBitmap)
  {
    AppMethodBeat.i(48661);
    if ((paramAppBrandRuntime == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(48661);
      return;
    }
    nUe.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean bXf()
  {
    AppMethodBeat.i(161867);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    if ((!com.tencent.mm.cc.a.gvt()) && (com.tencent.mm.cc.a.gvm())) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.cc.a.gvs()); i = 0)
    {
      AppMethodBeat.o(161867);
      return true;
    }
    AppMethodBeat.o(161867);
    return false;
  }
  
  private static Context en(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = localContext;
    if (bXf()) {
      paramContext = new w(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */