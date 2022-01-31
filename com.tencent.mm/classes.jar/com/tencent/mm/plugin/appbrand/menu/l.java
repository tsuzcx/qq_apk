package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.Locale;

final class l
  extends a
{
  l()
  {
    super(o.gPn.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, com.tencent.mm.ui.base.l paraml, String paramString)
  {
    if (bl.csf()) {
      paraml.e(this.gPE, paramContext.getString(y.j.app_brand_show_debug_info));
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    com.tencent.mm.plugin.appbrand.config.i locali = paramq.getRuntime().ZB();
    paramn = new StringBuilder("!PKG_INFO!\n");
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.abQ();
    paramn.append("\n[lib.src] ");
    if (localWxaPkgWrappingInfo.fEP) {
      if (ah.abV())
      {
        paramString = "local(force)";
        paramn.append(paramString);
        label57:
        paramn.append("\n[lib.ver] ").append(localWxaPkgWrappingInfo.fEN);
        if (localWxaPkgWrappingInfo.fEM != 0)
        {
          StringBuilder localStringBuilder = paramn.append("  ");
          if (localWxaPkgWrappingInfo.fEM != 0) {
            break label401;
          }
          paramString = "";
          label101:
          localStringBuilder.append(paramString);
        }
        paramString = locali.fPS;
        paramn.append('\n');
        paramn.append("\n[app.version] ").append(paramString.fEN);
        if (locali.aej() != 0) {
          paramn.append("  ").append(bk.hs(paramString.fEO));
        }
        if (bk.dk(paramString.fEQ)) {
          break label413;
        }
      }
    }
    label401:
    label413:
    for (boolean bool = true;; bool = false)
    {
      paramn.append("\n[app.module ] ").append(String.valueOf(bool));
      if (bool)
      {
        paramString = ((f)paramq.getRuntime().fyz).vm(paramq.getURL());
        paramn.append(String.format(Locale.US, "  (%s)", new Object[] { paramString.name }));
        if (paramString.bGd) {
          paramn.append(" (independent)");
        }
      }
      paramn.append('\n');
      paramn.append("\n[isolate_context] ").append(((p)paramq.Zy()).aaC());
      paramq = new TextView(paramContext);
      paramq.setText(paramn);
      paramq.setGravity(19);
      paramq.setTextSize(1, 10.0F);
      paramq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramq.setTextColor(-16777216);
      paramq.setTypeface(Typeface.MONOSPACE);
      int i = paramContext.getResources().getDimensionPixelSize(y.e.LargePadding);
      paramq.setPadding(i, i, i, i);
      paramq.setMovementMethod(ScrollingMovementMethod.getInstance());
      h.a(paramContext, null, paramq, null).setCanceledOnTouchOutside(false);
      return;
      paramString = "local";
      break;
      paramn.append("cgi");
      break label57;
      paramString = bk.hs(localWxaPkgWrappingInfo.fEO);
      break label101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.l
 * JD-Core Version:    0.7.0.1
 */