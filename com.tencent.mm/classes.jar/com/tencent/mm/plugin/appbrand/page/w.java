package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.h;
import com.tencent.mm.plugin.appbrand.menu.h.a;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.menu.s;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.menu.y;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.List;
import java.util.Locale;

public final class w
  extends v
{
  public w(ah paramah, List<com.tencent.mm.plugin.appbrand.menu.w> paramList)
  {
    super(paramah, paramList);
  }
  
  protected final void a(f paramf)
  {
    AppMethodBeat.i(47798);
    super.a(paramf);
    Object localObject = (ah)getPageView();
    boolean bool;
    label74:
    label80:
    int n;
    label135:
    int j;
    label150:
    int i;
    label194:
    int k;
    label216:
    int i1;
    label226:
    int i2;
    label241:
    int m;
    if (((ah)localObject).getRuntime().aqJ()) {
      if ((((ah)localObject).isFullScreen()) || (((ah)localObject).cdZ()))
      {
        bool = true;
        paramf.sRy = bool;
        if ((!((ah)localObject).isFullScreen()) && (!((ah)localObject).cdZ())) {
          break label378;
        }
        bool = true;
        paramf.sRz = bool;
        paramf.aeLi = new f.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            j.a(this.tvk.getAppId(), this.tvk.cgR(), 38, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        paramf.ages = new f.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            j.a(this.tvk.getAppId(), this.tvk.cgR(), 37, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        paramf = (ah)getPageView();
        localObject = a.a.av(paramf.getRuntime());
        if (!q.g(paramf)) {
          break label405;
        }
        n = 1;
        if (!paramf.getRuntime().getInitConfig().aqJ()) {
          break label411;
        }
        j = 2;
        switch (3.tjE[com.tencent.mm.plugin.appbrand.menu.e.a(paramf, paramf.getContext()).ordinal()])
        {
        default: 
          i = 1;
          k = 0;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject).cGf() == a.b.tBK.ordinal())
          {
            k = 1;
            if (!r.g(paramf)) {
              break label465;
            }
            i1 = 1;
            localObject = h.tjI;
            if (!h.a.g(paramf)) {
              break label471;
            }
            i2 = 1;
            if (s.eY(paramf.getContext())) {
              break label477;
            }
            m = 1;
            label254:
            if (y.tkS != u.i(paramf)) {
              break label510;
            }
          }
          break;
        }
      }
    }
    label378:
    label510:
    for (int i3 = 1;; i3 = 0)
    {
      localObject = String.format(Locale.US, "%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3) });
      j.a(paramf.getAppId(), paramf.cgR(), 28, (String)localObject, Util.nowSecond(), 1, 0);
      AppMethodBeat.o(47798);
      return;
      bool = false;
      break;
      bool = false;
      break label74;
      paramf.sRy = ((ah)localObject).isFullScreen();
      paramf.sRz = ((ah)localObject).isFullScreen();
      break label80;
      n = 0;
      break label135;
      if (b.g(paramf))
      {
        j = 1;
        break label150;
      }
      j = 0;
      break label150;
      i = 1;
      break label194;
      i = 2;
      break label194;
      i = 0;
      break label194;
      if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject).cGf() != a.b.tBL.ordinal()) {
        break label216;
      }
      k = 2;
      break label216;
      i1 = 0;
      break label226;
      i2 = 2;
      break label241;
      localObject = paramf.getRuntime().ccM();
      if (localObject == null)
      {
        m = 1;
        break label254;
      }
      m = com.tencent.mm.plugin.appbrand.config.a.qVt.a((AppBrandSysConfigWC)localObject);
      break label254;
    }
  }
  
  protected final void b(f paramf)
  {
    AppMethodBeat.i(324918);
    super.b(paramf);
    Object localObject = getPageView();
    Context localContext = ((ad)localObject).getContext();
    if ((localObject instanceof ah)) {}
    for (localObject = (ah)localObject;; localObject = null)
    {
      if ((localContext == null) || (localObject == null))
      {
        Log.w("MicroMsg.AppBrandPageActionSheetWC", "trySupportRecentForward, context or pageViewWC is null");
        AppMethodBeat.o(324918);
        return;
      }
      new cj(localContext, (ah)localObject, paramf, this);
      AppMethodBeat.o(324918);
      return;
    }
  }
  
  public final void cEl()
  {
    AppMethodBeat.i(324915);
    Object localObject = cEk();
    if (!(localObject instanceof AppBrandMenuHeader))
    {
      AppMethodBeat.o(324915);
      return;
    }
    localObject = (AppBrandMenuHeader)localObject;
    ((AppBrandMenuHeader)localObject).qAv.findViewById(ba.f.menu_header).setPadding(((AppBrandMenuHeader)localObject).qAv.getPaddingLeft(), ((AppBrandMenuHeader)localObject).qAv.getPaddingTop(), ((AppBrandMenuHeader)localObject).qAv.getPaddingRight(), 0);
    AppMethodBeat.o(324915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */