package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.a.b;

public final class i
{
  static boolean cqf = false;
  
  public static void init()
  {
    AppMethodBeat.i(46120);
    if (cqf)
    {
      AppMethodBeat.o(46120);
      return;
    }
    cqf = true;
    com.tencent.mm.plugin.appbrand.phonenumber.u localu = com.tencent.mm.plugin.appbrand.phonenumber.u.lKF;
    com.tencent.mm.plugin.appbrand.phonenumber.u.a(new com.tencent.mm.plugin.appbrand.phonenumber.i()
    {
      public final void a(final Context paramAnonymousContext, final b<? super Integer, d.y> paramAnonymousb)
      {
        AppMethodBeat.i(46118);
        h.a(paramAnonymousContext, false, paramAnonymousContext.getString(2131755439), paramAnonymousContext.getString(2131755440), paramAnonymousContext.getString(2131755447), paramAnonymousContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(46113);
            paramAnonymous2DialogInterface = new Intent(paramAnonymousContext, AppBrandRedirectUI.class);
            paramAnonymous2DialogInterface.putExtra("key_from_scene", 0);
            e.aA(paramAnonymousContext).a(paramAnonymous2DialogInterface, new e.a()
            {
              public final void a(int paramAnonymous3Int, Intent paramAnonymous3Intent)
              {
                AppMethodBeat.i(46112);
                i.1.1.this.jSp.ay(Integer.valueOf(paramAnonymous3Int));
                AppMethodBeat.o(46112);
              }
            });
            AppMethodBeat.o(46113);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(46114);
            paramAnonymous2DialogInterface.dismiss();
            paramAnonymousb.ay(Integer.valueOf(0));
            AppMethodBeat.o(46114);
          }
        }, 2131100464, 2131100464);
        AppMethodBeat.o(46118);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.phonenumber.y paramAnonymousy)
      {
        AppMethodBeat.i(174779);
        fv localfv = new fv();
        localfv.eam = paramAnonymousy.lLh;
        localfv.ean = paramAnonymousy.lLi;
        localfv.eao = paramAnonymousy.lLj;
        localfv.eap = paramAnonymousy.lLk;
        localfv.eaq = paramAnonymousy.lLl;
        localfv.ear = paramAnonymousy.lLm;
        localfv.eas = paramAnonymousy.lLn;
        localfv.eat = paramAnonymousy.lLo;
        localfv.eau = paramAnonymousy.lLp;
        localfv.eav = paramAnonymousy.lLq;
        localfv.eaw = paramAnonymousy.lLr;
        localfv.eax = paramAnonymousy.lLs;
        localfv.eay = paramAnonymousy.lLF;
        localfv.eaz = paramAnonymousy.lLu;
        localfv.eaA = paramAnonymousy.lLv;
        localfv.eaB = paramAnonymousy.lLw;
        localfv.eaC = paramAnonymousy.lLx;
        localfv.eaD = paramAnonymousy.lLy;
        localfv.eaE = paramAnonymousy.lLz;
        localfv.eaF = paramAnonymousy.lLA;
        localfv.eaG = paramAnonymousy.lLB;
        localfv.eaH = paramAnonymousy.lLC;
        localfv.eaI = paramAnonymousy.lLD;
        localfv.eaJ = paramAnonymousy.lLE;
        localfv.eaK = paramAnonymousy.lLF;
        localfv.eaL = paramAnonymousy.lLG;
        localfv.aHZ();
        AppMethodBeat.o(174779);
      }
      
      public final void dq(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46116);
        if ((paramAnonymousContext instanceof MMActivity)) {
          ((MMActivity)paramAnonymousContext).hideVKB();
        }
        AppMethodBeat.o(46116);
      }
      
      public final void dr(Context paramAnonymousContext)
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
        paramAnonymousString1 = new a(com.tencent.mm.plugin.appbrand.u.b(locala.baT()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.i
 * JD-Core Version:    0.7.0.1
 */