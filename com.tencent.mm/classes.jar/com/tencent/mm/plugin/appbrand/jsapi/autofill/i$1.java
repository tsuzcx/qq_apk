package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kp;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.phonenumber.i;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import kotlin.g.a.b;
import kotlin.x;

final class i$1
  extends i
{
  public final void a(final Context paramContext, final b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(46118);
    h.a(paramContext, false, paramContext.getString(2131755477), paramContext.getString(2131755478), paramContext.getString(2131755485), paramContext.getString(2131755761), new DialogInterface.OnClickListener()new i.1.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(46113);
        paramAnonymousDialogInterface = new Intent(paramContext, AppBrandRedirectUI.class);
        paramAnonymousDialogInterface.putExtra("key_from_scene", 0);
        f.aK(paramContext).a(paramAnonymousDialogInterface, new f.b()
        {
          public final void a(int paramAnonymous2Int, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(46112);
            i.1.1.this.ltB.invoke(Integer.valueOf(paramAnonymous2Int));
            AppMethodBeat.o(46112);
          }
        });
        AppMethodBeat.o(46113);
      }
    }, new i.1.2(this, paramb), 2131100566, 2131100566);
    AppMethodBeat.o(46118);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(174779);
    kp localkp = new kp();
    localkp.eWC = paramy.nAE;
    localkp.eWD = paramy.nAF;
    localkp.eWE = paramy.nAG;
    localkp.eWF = paramy.nAH;
    localkp.eWG = paramy.nAI;
    localkp.eWH = paramy.nAJ;
    localkp.eWI = paramy.nAK;
    localkp.eWJ = paramy.nAL;
    localkp.eWK = paramy.nAM;
    localkp.eWL = paramy.nAN;
    localkp.eWM = paramy.nAO;
    localkp.eWN = paramy.nAP;
    localkp.eWO = paramy.nBc;
    localkp.eWP = paramy.nAR;
    localkp.eWQ = paramy.nAS;
    localkp.eWR = paramy.nAT;
    localkp.eWS = paramy.nAU;
    localkp.eWT = paramy.nAV;
    localkp.eWU = paramy.nAW;
    localkp.eWV = paramy.nAX;
    localkp.eWW = paramy.nAY;
    localkp.eWX = paramy.nAZ;
    localkp.eWY = paramy.nBa;
    localkp.eWZ = paramy.nBb;
    localkp.eXa = paramy.nBc;
    localkp.eXb = paramy.nBd;
    localkp.bfK();
    AppMethodBeat.o(174779);
  }
  
  public final void dL(Context paramContext)
  {
    AppMethodBeat.i(46116);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).hideVKB();
    }
    AppMethodBeat.o(46116);
  }
  
  public final void dM(Context paramContext)
  {
    AppMethodBeat.i(46117);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).showVKB();
    }
    AppMethodBeat.o(46117);
  }
  
  public final SpannableString n(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(46115);
    String str = paramContext.getString(2131756132);
    paramContext = String.format(paramContext.getString(2131756133), new Object[] { str });
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramString1;
    locala.pageId = paramString2;
    locala.from = 8;
    paramString1 = new a(w.b(locala.bAv()));
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