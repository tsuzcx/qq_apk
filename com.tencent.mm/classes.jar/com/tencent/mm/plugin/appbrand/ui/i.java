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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.al;

public final class i
{
  private static final android.support.v4.e.a<AppBrandRuntime, Bitmap> mHg;
  
  static
  {
    AppMethodBeat.i(48662);
    mHg = new android.support.v4.e.a();
    AppMethodBeat.o(48662);
  }
  
  public static v a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(223095);
    if (paramAppBrandInitConfigWC.kaJ)
    {
      if (!TextUtils.isEmpty(com.tencent.luggage.h.k.dt(paramAppBrandInitConfigWC.jFL)))
      {
        AppMethodBeat.o(223095);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.c.a.b.bCd())
      {
        ae.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(223095);
        return null;
      }
      String str = paramAppBrandInitConfigWC.kaW;
      if (com.tencent.mm.vfs.o.fB(str))
      {
        ae.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = h.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new v(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(223095);
          return paramContext;
        }
      }
      AppMethodBeat.o(223095);
      return null;
    }
    AppMethodBeat.o(223095);
    return null;
  }
  
  public static w a(Context paramContext, p paramp)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)mHg.remove(paramp);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new m(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramp.aXx());
    if (localObject != null)
    {
      ((v)localObject).setRuntime(paramp);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (com.tencent.mm.plugin.appbrand.aa.g.am(paramp))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.aa.b(dQ(paramContext), paramp);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((o.al(paramp)) || (aq.o(paramp)))
    {
      if (paramp.Ee())
      {
        paramContext = new e(dQ(paramContext), paramp, paramp.aXx().cmA);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      paramContext = new k(dQ(paramContext), paramp, paramp.aXx().cmA);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if (paramp.Ee())
    {
      localObject = new f(dQ(paramContext), paramp);
      if (paramp.aWO())
      {
        paramContext = new c(dQ(paramContext), paramp, (w)localObject, paramp.jCw);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      AppMethodBeat.o(48659);
      return localObject;
    }
    AppBrandUILoadingSplash localAppBrandUILoadingSplash = (AppBrandUILoadingSplash)paramp.jCy.aC(AppBrandUILoadingSplash.class);
    boolean bool;
    if (localAppBrandUILoadingSplash != null)
    {
      ae.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramp.Fn().dpI });
      localAppBrandUILoadingSplash.jDb = paramp;
      Activity localActivity = com.tencent.mm.sdk.f.a.jw(paramp.mContext);
      localObject = localAppBrandUILoadingSplash;
      if ((localAppBrandUILoadingSplash.getContext() instanceof MutableContextWrapper))
      {
        ((MutableContextWrapper)localAppBrandUILoadingSplash.getContext()).setBaseContext(localActivity);
        int i = localAppBrandUILoadingSplash.getResources().getColor(2131099650);
        if (localAppBrandUILoadingSplash.isDarkMode()) {
          break label402;
        }
        bool = true;
        localAppBrandUILoadingSplash.M(i, bool);
      }
    }
    for (localObject = localAppBrandUILoadingSplash;; localObject = new AppBrandUILoadingSplash(dQ(paramContext), paramp))
    {
      ((AppBrandUILoadingSplash)localObject).setLabelInjector(new AppBrandUILoadingSplash.a()
      {
        public final void a(ViewStub paramAnonymousViewStub)
        {
          AppMethodBeat.i(223093);
          if ((com.tencent.luggage.sdk.config.c.gz(this.jyD.aXx().kaY)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPC, 0) == 1))
          {
            paramAnonymousViewStub.setLayoutResource(2131496380);
            paramAnonymousViewStub.inflate();
          }
          AppMethodBeat.o(223093);
        }
        
        @SuppressLint({"ResourceType"})
        public final void b(ViewStub paramAnonymousViewStub)
        {
          AppMethodBeat.i(223094);
          if ((com.tencent.luggage.sdk.config.c.gA(this.jyD.aXx().kaX)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNl, 0) == 1))
          {
            paramAnonymousViewStub.setLayoutResource(2131496381);
            paramAnonymousViewStub = (ImageView)paramAnonymousViewStub.inflate().findViewById(2131300874);
            if (!al.isDarkMode()) {
              break label81;
            }
          }
          label81:
          for (int i = 2131691563;; i = 2131691562)
          {
            paramAnonymousViewStub.setImageResource(i);
            AppMethodBeat.o(223094);
            return;
          }
        }
      });
      if (!paramp.aWO()) {
        break label424;
      }
      paramContext = new c(dQ(paramContext), paramp, (w)localObject, paramp.jCw);
      AppMethodBeat.o(48659);
      return paramContext;
      label402:
      bool = false;
      break;
    }
    label424:
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
    mHg.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean bAh()
  {
    AppMethodBeat.i(161867);
    if (ak.coh())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    if ((!com.tencent.mm.cc.a.flH()) && (com.tencent.mm.cc.a.flA())) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.cc.a.flG()); i = 0)
    {
      AppMethodBeat.o(161867);
      return true;
    }
    AppMethodBeat.o(161867);
    return false;
  }
  
  private static Context dQ(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ak.getContext();
    }
    paramContext = localContext;
    if (bAh()) {
      paramContext = new r(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */