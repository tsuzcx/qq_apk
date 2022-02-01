package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.nl;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.phonenumber.i;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import kotlin.g.a.b;
import kotlin.x;

final class j$1
  extends i
{
  public final void a(Context paramContext, b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(46118);
    String str1 = paramContext.getString(au.i.app_brand_get_phone_number_no_bind_phone_msg);
    String str2 = paramContext.getString(au.i.app_brand_get_phone_number_no_bind_phone_title);
    String str3 = paramContext.getString(au.i.app_brand_get_phone_number_to_bind_phone);
    String str4 = paramContext.getString(au.i.app_cancel);
    j.1.1 local1 = new j.1.1(this, paramContext, paramb);
    paramb = new j.1.2(this, paramb);
    int i = au.c.green_text_color;
    h.a(paramContext, false, str1, str2, str3, str4, local1, paramb, i, i);
    AppMethodBeat.o(46118);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(174779);
    nl localnl = new nl();
    localnl.gZi = paramy.qCP;
    localnl.gZj = paramy.qCQ;
    localnl.gZk = paramy.qCR;
    localnl.gZl = paramy.qCS;
    localnl.gZm = paramy.qCT;
    localnl.gZn = paramy.qCU;
    localnl.gZo = paramy.qCV;
    localnl.gZp = paramy.qCW;
    localnl.gZq = paramy.qCX;
    localnl.gZr = paramy.qCY;
    localnl.gZs = paramy.qCZ;
    localnl.gZt = paramy.qDa;
    localnl.gZu = paramy.qDn;
    localnl.gZv = paramy.qDc;
    localnl.gZw = paramy.qDd;
    localnl.gZx = paramy.qDe;
    localnl.gZy = paramy.qDf;
    localnl.gZz = paramy.qDg;
    localnl.gZA = paramy.qDh;
    localnl.gZB = paramy.qDi;
    localnl.gZC = paramy.qDj;
    localnl.gZD = paramy.qDk;
    localnl.gZE = paramy.qDl;
    localnl.gZF = paramy.qDm;
    localnl.gZG = paramy.qDn;
    localnl.gZH = paramy.qDo;
    localnl.bpa();
    AppMethodBeat.o(174779);
  }
  
  public final void dK(Context paramContext)
  {
    AppMethodBeat.i(46116);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).hideVKB();
    }
    AppMethodBeat.o(46116);
  }
  
  public final void dL(Context paramContext)
  {
    AppMethodBeat.i(46117);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).showVKB();
    }
    AppMethodBeat.o(46117);
  }
  
  public final SpannableString q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(46115);
    String str = paramContext.getString(au.i.appbrand_phone_number_expose_slogan_end);
    paramContext = String.format(paramContext.getString(au.i.appbrand_phone_number_expose_slogan_start), new Object[] { str });
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramString1;
    locala.pageId = paramString2;
    locala.from = 8;
    paramString1 = new a(z.b(locala.bLN()));
    paramString2 = new SpannableString(paramContext);
    int i = paramContext.indexOf(str);
    int j = paramContext.indexOf(str);
    paramString2.setSpan(paramString1, i, str.length() + j, 18);
    AppMethodBeat.o(46115);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.j.1
 * JD-Core Version:    0.7.0.1
 */