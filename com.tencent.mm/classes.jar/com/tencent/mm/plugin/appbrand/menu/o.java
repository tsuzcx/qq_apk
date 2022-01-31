package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.k.g;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.base.l;
import java.util.Locale;

final class o
  extends a
{
  o()
  {
    super(r.iqV.ordinal());
    AppMethodBeat.i(132248);
    AppMethodBeat.o(132248);
  }
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(132249);
    if (bp.dud()) {
      paraml.e(this.irp, paramContext.getString(2131296862));
    }
    AppMethodBeat.o(132249);
  }
  
  @SuppressLint({"DefaultLocale", "RtlHardcoded"})
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(132250);
    com.tencent.mm.plugin.appbrand.config.h localh = paramv.getRuntime().wY();
    paramq = new StringBuilder("!PKG_INFO!\n");
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.avI();
    paramq.append("\n[lib.src    ] ");
    if (localWxaPkgWrappingInfo.gXh) {
      if (an.avM())
      {
        paramString = "local(force)";
        paramq.append(paramString);
        label62:
        paramq.append("\n[lib.ver_cli] ").append(localWxaPkgWrappingInfo.gXf);
        paramq.append("\n[lib.ver_sdk] ").append(WxaCommLibRuntimeReader.avH().avd());
        if (localWxaPkgWrappingInfo.gXe != 0)
        {
          StringBuilder localStringBuilder = paramq.append("  ");
          if (localWxaPkgWrappingInfo.gXe != 0) {
            break label523;
          }
          paramString = "";
          label125:
          localStringBuilder.append(paramString);
        }
        paramString = localh.hiX;
        paramq.append('\n');
        paramq.append("\n[app.version] ").append(paramString.gXf);
        if (localh.hiX.gXe != 0) {
          paramq.append("  ").append(bo.nU(paramString.gXg));
        }
        if (bo.es(paramString.gXi)) {
          break label535;
        }
      }
    }
    label523:
    label535:
    for (boolean bool = true;; bool = false)
    {
      paramq.append("\n[app.module ] ").append(String.valueOf(bool));
      if (bool)
      {
        paramString = ((g)paramv.getRuntime().gPM).DK(paramv.hzM);
        paramq.append(String.format(Locale.US, "  (%s)", new Object[] { paramString.name }));
        if (paramString.cnm) {
          paramq.append(" (independent)");
        }
      }
      if (!p.c(paramv)) {
        paramq.append("\n[app.page.url] ").append(paramv.hzM);
      }
      paramq.append('\n');
      paramq.append("\n[js_runtime] ").append(com.tencent.mm.plugin.appbrand.report.c.h(paramv.ws().aAO()));
      if (!p.c(paramv)) {
        paramq.append("\n[webview] ").append(j.aLa());
      }
      paramString = s.irl;
      s.a(paramq, paramv.ws());
      paramq.append('\n');
      paramq.append("\n[isolate_context] ").append(((com.tencent.mm.plugin.appbrand.service.c)paramv.ws()).bEO.uQ());
      paramv = new TextView(paramContext);
      paramv.setText(paramq);
      paramv.setGravity(19);
      paramv.setTextSize(1, 10.0F);
      paramv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramv.setTextColor(-16777216);
      paramv.setTypeface(Typeface.MONOSPACE);
      int i = paramContext.getResources().getDimensionPixelSize(2131427772);
      paramv.setPadding(i, i, i, i);
      paramv.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramv, null).setCanceledOnTouchOutside(false);
      AppMethodBeat.o(132250);
      return;
      paramString = "local";
      break;
      paramq.append("network");
      break label62;
      paramString = bo.nU(localWxaPkgWrappingInfo.gXg);
      break label125;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o
 * JD-Core Version:    0.7.0.1
 */