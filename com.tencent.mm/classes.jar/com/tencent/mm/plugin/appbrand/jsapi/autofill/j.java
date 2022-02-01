package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rd;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.phonenumber.i;
import com.tencent.mm.plugin.appbrand.phonenumber.u;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import kotlin.ah;
import kotlin.g.a.b;

public final class j
{
  static boolean isInit = false;
  
  public static void init()
  {
    AppMethodBeat.i(46120);
    if (isInit)
    {
      AppMethodBeat.o(46120);
      return;
    }
    isInit = true;
    u localu = u.tHm;
    u.a(new i()
    {
      public final void a(final Context paramAnonymousContext, final b<? super Integer, ah> paramAnonymousb)
      {
        AppMethodBeat.i(46118);
        String str1 = paramAnonymousContext.getString(ba.i.app_brand_get_phone_number_no_bind_phone_msg);
        String str2 = paramAnonymousContext.getString(ba.i.app_brand_get_phone_number_no_bind_phone_title);
        String str3 = paramAnonymousContext.getString(ba.i.app_brand_get_phone_number_to_bind_phone);
        String str4 = paramAnonymousContext.getString(ba.i.app_cancel);
        DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(46113);
            paramAnonymous2DialogInterface = new Intent(paramAnonymousContext, AppBrandRedirectUI.class);
            paramAnonymous2DialogInterface.putExtra("key_from_scene", 0);
            e.bt(paramAnonymousContext).a(paramAnonymous2DialogInterface, new e.b()
            {
              public final void onResult(int paramAnonymous3Int, Intent paramAnonymous3Intent)
              {
                AppMethodBeat.i(46112);
                j.1.1.this.rsk.invoke(Integer.valueOf(paramAnonymous3Int));
                AppMethodBeat.o(46112);
              }
            });
            AppMethodBeat.o(46113);
          }
        };
        paramAnonymousb = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(46114);
            paramAnonymous2DialogInterface.dismiss();
            paramAnonymousb.invoke(Integer.valueOf(0));
            AppMethodBeat.o(46114);
          }
        };
        int i = ba.c.green_text_color;
        k.a(paramAnonymousContext, false, str1, str2, str3, str4, local1, paramAnonymousb, i, i);
        AppMethodBeat.o(46118);
      }
      
      public final void a(y paramAnonymousy)
      {
        AppMethodBeat.i(174779);
        rd localrd = new rd();
        localrd.juT = paramAnonymousy.tHM;
        localrd.juU = paramAnonymousy.tHN;
        localrd.juV = paramAnonymousy.tHO;
        localrd.juW = paramAnonymousy.tHP;
        localrd.juX = paramAnonymousy.tHQ;
        localrd.juY = paramAnonymousy.tHR;
        localrd.juZ = paramAnonymousy.tHS;
        localrd.jva = paramAnonymousy.tHT;
        localrd.jvb = paramAnonymousy.tHU;
        localrd.jvc = paramAnonymousy.tHV;
        localrd.jvd = paramAnonymousy.tHW;
        localrd.jve = paramAnonymousy.tHX;
        localrd.jvf = paramAnonymousy.tIk;
        localrd.jvg = paramAnonymousy.tHZ;
        localrd.jvh = paramAnonymousy.tIa;
        localrd.jvi = paramAnonymousy.tIb;
        localrd.jvj = paramAnonymousy.tIc;
        localrd.jvk = paramAnonymousy.tId;
        localrd.jvl = paramAnonymousy.tIe;
        localrd.jvm = paramAnonymousy.tIf;
        localrd.jvn = paramAnonymousy.tIg;
        localrd.jvo = paramAnonymousy.tIh;
        localrd.jvp = paramAnonymousy.tIi;
        localrd.jvq = paramAnonymousy.tIj;
        localrd.jvr = paramAnonymousy.tIk;
        localrd.jvs = paramAnonymousy.tIl;
        localrd.ipx = localrd.F("appid", paramAnonymousy.appId, true);
        localrd.jvt = localrd.F("phoneNumber", paramAnonymousy.iaX, true);
        localrd.bMH();
        AppMethodBeat.o(174779);
      }
      
      public final void eE(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46116);
        if ((paramAnonymousContext instanceof MMActivity)) {
          ((MMActivity)paramAnonymousContext).hideVKB();
        }
        AppMethodBeat.o(46116);
      }
      
      public final void eF(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46117);
        if ((paramAnonymousContext instanceof MMActivity)) {
          ((MMActivity)paramAnonymousContext).showVKB();
        }
        AppMethodBeat.o(46117);
      }
      
      public final SpannableString s(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(46115);
        String str = paramAnonymousContext.getString(ba.i.appbrand_phone_number_expose_slogan_end);
        paramAnonymousContext = String.format(paramAnonymousContext.getString(ba.i.appbrand_phone_number_expose_slogan_start), new Object[] { str });
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = paramAnonymousString1;
        locala.hUf = paramAnonymousString2;
        locala.from = 8;
        paramAnonymousString1 = new a(ac.b(locala.cll()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.j
 * JD-Core Version:    0.7.0.1
 */