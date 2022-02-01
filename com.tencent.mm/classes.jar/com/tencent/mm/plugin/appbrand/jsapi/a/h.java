package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ef;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.phonenumber.i;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;

public final class h
{
  static boolean csX = false;
  
  public static void init()
  {
    AppMethodBeat.i(46120);
    if (csX)
    {
      AppMethodBeat.o(46120);
      return;
    }
    csX = true;
    com.tencent.mm.plugin.appbrand.phonenumber.u localu = com.tencent.mm.plugin.appbrand.phonenumber.u.lkN;
    com.tencent.mm.plugin.appbrand.phonenumber.u.a(new i()
    {
      public final void a(Context paramAnonymousContext, b<? super Integer, d.y> paramAnonymousb)
      {
        AppMethodBeat.i(46118);
        com.tencent.mm.ui.base.h.a(paramAnonymousContext, false, paramAnonymousContext.getString(2131755439), paramAnonymousContext.getString(2131755440), paramAnonymousContext.getString(2131755447), paramAnonymousContext.getString(2131755691), new h.1.1(this, paramAnonymousContext, paramAnonymousb), new h.1.2(this, paramAnonymousb), 2131100464, 2131100464);
        AppMethodBeat.o(46118);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.phonenumber.y paramAnonymousy)
      {
        AppMethodBeat.i(174779);
        ef localef = new ef();
        localef.dYt = paramAnonymousy.llq;
        localef.dYu = paramAnonymousy.llr;
        localef.dYv = paramAnonymousy.lls;
        localef.dYw = paramAnonymousy.llt;
        localef.dYx = paramAnonymousy.llu;
        localef.dYy = paramAnonymousy.llv;
        localef.dYz = paramAnonymousy.llw;
        localef.dYA = paramAnonymousy.llx;
        localef.dYB = paramAnonymousy.lly;
        localef.dYC = paramAnonymousy.llz;
        localef.dYD = paramAnonymousy.llA;
        localef.dYE = paramAnonymousy.llB;
        localef.dYF = paramAnonymousy.llO;
        localef.dYG = paramAnonymousy.llD;
        localef.dYH = paramAnonymousy.llE;
        localef.dYI = paramAnonymousy.llF;
        localef.dYJ = paramAnonymousy.llG;
        localef.dYK = paramAnonymousy.llH;
        localef.dYL = paramAnonymousy.llI;
        localef.dYM = paramAnonymousy.llJ;
        localef.dYN = paramAnonymousy.llK;
        localef.dYO = paramAnonymousy.llL;
        localef.dYP = paramAnonymousy.llM;
        localef.dYQ = paramAnonymousy.llN;
        localef.dYR = paramAnonymousy.llO;
        localef.dYS = paramAnonymousy.llP;
        localef.aBj();
        AppMethodBeat.o(174779);
      }
      
      public final void dh(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46116);
        if ((paramAnonymousContext instanceof MMActivity)) {
          ((MMActivity)paramAnonymousContext).hideVKB();
        }
        AppMethodBeat.o(46116);
      }
      
      public final void di(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46117);
        if ((paramAnonymousContext instanceof MMActivity)) {
          ((MMActivity)paramAnonymousContext).showVKB();
        }
        AppMethodBeat.o(46117);
      }
      
      public final SpannableString n(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(46115);
        String str = paramAnonymousContext.getString(2131756017);
        paramAnonymousContext = String.format(paramAnonymousContext.getString(2131756018), new Object[] { str });
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = paramAnonymousString1;
        locala.pageId = paramAnonymousString2;
        locala.from = 8;
        paramAnonymousString1 = new a(com.tencent.mm.plugin.appbrand.u.b(locala.aTV()));
        paramAnonymousString2 = new SpannableString(paramAnonymousContext);
        int i = paramAnonymousContext.indexOf(str);
        int j = paramAnonymousContext.indexOf(str);
        paramAnonymousString2.setSpan(paramAnonymousString1, i, str.length() + j, 18);
        AppMethodBeat.o(46115);
        return paramAnonymousString2;
      }
    });
    AppMethodBeat.o(46120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.h
 * JD-Core Version:    0.7.0.1
 */