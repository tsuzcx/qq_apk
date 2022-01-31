package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.launching.ActivityStarterIpcDelegate;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
  extends com.tencent.mm.plugin.appbrand.menu.a.a
{
  public a()
  {
    super(o.gPu.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, com.tencent.mm.ui.base.l paraml, String paramString)
  {
    paramString = paramq.getRuntime().ZB();
    int k = o.gPu.ordinal();
    String str = paramString.bJw;
    int i = paramString.aej();
    boolean bool = paramq.gTO;
    paramq = paramContext.getString(y.j.app_brand_about_app_formatter, new Object[] { str });
    str = com.tencent.mm.plugin.appbrand.appcache.a.kp(i);
    if (bk.bl(str))
    {
      paramContext = paramq;
      paraml.e(k, paramContext);
      return;
    }
    int j = Color.parseColor("#42000000");
    i = com.tencent.mm.cb.a.i(paramContext, y.d.bottom_sheet_text_color);
    if (bool)
    {
      j = Color.parseColor("#80FFFFFF");
      i = com.tencent.mm.cb.a.i(paramContext, y.d.white_text_color);
    }
    for (;;)
    {
      paramString = new com.tencent.mm.plugin.appbrand.widget.g.c(str, com.tencent.mm.cb.a.fromDPToPix(paramContext, 11), com.tencent.mm.cb.a.fromDPToPix(paramContext, 11), com.tencent.mm.cb.a.fromDPToPix(paramContext, 9), j, com.tencent.mm.cb.a.fromDPToPix(paramContext, 2));
      j = paramString.b(null);
      int[] arrayOfInt = com.tencent.mm.plugin.appbrand.ui.l.api();
      int m = com.tencent.mm.cb.a.aa(paramContext, y.e.bottomsheet_list_text_size);
      TextPaint localTextPaint = new TextPaint(new Paint(i));
      localTextPaint.setTextSize(m);
      paramq = TextUtils.ellipsize(paramq, localTextPaint, arrayOfInt[0] - com.tencent.mm.cb.a.aa(paramContext, y.e.bottomsheet_list_icon_padding) - j, TextUtils.TruncateAt.END);
      paramContext = new SpannableStringBuilder(paramq + str);
      paramContext.setSpan(new AbsoluteSizeSpan(m, false), 0, paramq.length(), 18);
      paramContext.setSpan(new ForegroundColorSpan(i), 0, paramq.length(), 18);
      paramContext.setSpan(paramString, paramq.length(), paramContext.length(), 18);
      break;
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramq.getRuntime().ZB();
    if (localAppBrandSysConfigWC == null) {
      return;
    }
    paramn = "";
    if (com.tencent.mm.plugin.appbrand.a.qp(paramString) != null) {
      paramn = ((com.tencent.mm.plugin.appbrand.n)paramq.getRuntime()).aac().fJO;
    }
    AppBrandOpReportLogic.a.n(paramq);
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = localAppBrandSysConfigWC.appId;
    locala.from = 3;
    if (paramq.gTF == null) {}
    for (String str = "";; str = paramq.getURL())
    {
      locala.bUo = str;
      locala.fEM = localAppBrandSysConfigWC.fPS.fEM;
      locala.fEN = localAppBrandSysConfigWC.fPS.fEN;
      AppBrandProfileUI.a(paramContext, localAppBrandSysConfigWC.bFn, 3, paramn, locala.aes(), null, ActivityStarterIpcDelegate.cq(paramContext));
      com.tencent.mm.plugin.appbrand.report.c.a(paramString, paramq.getURL(), 6, "", bk.UX(), 1, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a
 * JD-Core Version:    0.7.0.1
 */