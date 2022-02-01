package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ha;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.phonenumber.i;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.a.b;
import d.z;

final class i$1
  extends i
{
  public final void a(final Context paramContext, final b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(46118);
    h.a(paramContext, false, paramContext.getString(2131755439), paramContext.getString(2131755440), paramContext.getString(2131755447), paramContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(46113);
        paramAnonymousDialogInterface = new Intent(paramContext, AppBrandRedirectUI.class);
        paramAnonymousDialogInterface.putExtra("key_from_scene", 0);
        e.aB(paramContext).a(paramAnonymousDialogInterface, new e.b()
        {
          public final void a(int paramAnonymous2Int, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(46112);
            i.1.1.this.kpT.invoke(Integer.valueOf(paramAnonymous2Int));
            AppMethodBeat.o(46112);
          }
        });
        AppMethodBeat.o(46113);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(46114);
        paramAnonymousDialogInterface.dismiss();
        paramb.invoke(Integer.valueOf(0));
        AppMethodBeat.o(46114);
      }
    }, 2131100464, 2131100464);
    AppMethodBeat.o(46118);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(174779);
    ha localha = new ha();
    localha.esB = paramy.mpS;
    localha.esC = paramy.mpT;
    localha.esD = paramy.mpU;
    localha.esE = paramy.mpV;
    localha.esF = paramy.mpW;
    localha.esG = paramy.mpX;
    localha.esH = paramy.mpY;
    localha.esI = paramy.mpZ;
    localha.esJ = paramy.mqa;
    localha.esK = paramy.mqb;
    localha.esL = paramy.mqc;
    localha.esM = paramy.mqd;
    localha.esN = paramy.mqq;
    localha.esO = paramy.mqf;
    localha.esP = paramy.mqg;
    localha.esQ = paramy.mqh;
    localha.esR = paramy.mqi;
    localha.esS = paramy.mqj;
    localha.esT = paramy.mqk;
    localha.esU = paramy.mql;
    localha.esV = paramy.mqm;
    localha.esW = paramy.mqn;
    localha.esX = paramy.mqo;
    localha.esY = paramy.mqp;
    localha.esZ = paramy.mqq;
    localha.eta = paramy.mqr;
    localha.aLH();
    AppMethodBeat.o(174779);
  }
  
  public final void dq(Context paramContext)
  {
    AppMethodBeat.i(46116);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).hideVKB();
    }
    AppMethodBeat.o(46116);
  }
  
  public final void dr(Context paramContext)
  {
    AppMethodBeat.i(46117);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).showVKB();
    }
    AppMethodBeat.o(46117);
  }
  
  public final SpannableString o(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(46115);
    String str = paramContext.getString(2131756017);
    paramContext = String.format(paramContext.getString(2131756018), new Object[] { str });
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramString1;
    locala.pageId = paramString2;
    locala.from = 8;
    paramString1 = new a(v.b(locala.bfb()));
    paramString2 = new SpannableString(paramContext);
    int i = paramContext.indexOf(str);
    int j = paramContext.indexOf(str);
    paramString2.setSpan(paramString1, i, str.length() + j, 18);
    AppMethodBeat.o(46115);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.i.1
 * JD-Core Version:    0.7.0.1
 */