package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.media.AudioManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class f
{
  public String appId;
  public Dialog dialog;
  public String dlk;
  public com.tencent.mm.plugin.appbrand.report.b knB;
  public int lxQ;
  public boolean ngM;
  int ngN;
  public TextView ngP;
  public RatingBar ngU;
  public TextView ngV;
  public LinearLayout ngW;
  public LinearLayout ngX;
  boolean nhc;
  public int scene;
  public String sessionId;
  public String userName;
  
  public f(c paramc)
  {
    AppMethodBeat.i(49886);
    this.ngM = false;
    this.ngN = 0;
    this.lxQ = -1;
    this.nhc = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.Q(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.knB = paramc.bhH();
    }
    AppMethodBeat.o(49886);
  }
  
  public static Dialog w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(49887);
    paramContext = new com.tencent.mm.plugin.crashfix.b.a(paramContext, 2131820558);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(paramBoolean);
    Window localWindow = paramContext.getWindow();
    if (localWindow != null)
    {
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.gravity = 81;
      localLayoutParams.height = -2;
      localLayoutParams.width = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setWindowAnimations(2131820557);
    }
    AppMethodBeat.o(49887);
    return paramContext;
  }
  
  final void a(com.tencent.mm.plugin.appbrand.p paramp, boolean paramBoolean, chi paramchi, ekj paramekj)
  {
    AppMethodBeat.i(175092);
    if (this.nhc)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.nhc = true;
    int i;
    if (paramchi == null)
    {
      i = 0;
      paramchi = (AudioManager)paramp.mContext.getSystemService("audio");
      if (paramchi == null) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        j = paramchi.getStreamVolume(3);
        eir localeir = new eir();
        if (j != 0) {
          break label393;
        }
        bool = true;
        localeir.IlR = bool;
        paramchi = com.tencent.mm.plugin.music.b.f.duL();
        str1 = paramp.mAppId;
        localeir.IlS = paramchi.wxx.contains(str1);
        localeir.IlT = (this.lxQ / 1000);
        if (!paramBoolean) {
          break label399;
        }
        paramchi = "true";
        String str3 = paramekj.Inr;
        if (j != 0) {
          break label406;
        }
        str1 = "true";
        if (!localeir.IlS) {
          break label414;
        }
        str2 = "true";
        ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { paramchi, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localeir.IlT) });
        paramchi = new ekk();
        paramchi.Inw = paramBoolean;
        paramchi.Hte = i;
        paramchi.Inr = paramekj.Inr;
        paramekj = new dll();
        paramekj.ikm = paramp.mAppId;
        paramekj.GZL = this.knB.mvn;
        paramekj.GZK = this.knB.mvo;
        paramekj.GZM = localeir;
        paramekj.HSQ = paramchi;
        paramp = new b.a();
        paramp.funcId = 2772;
        paramp.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramp.hQF = paramekj;
        paramp.hQG = new dlm();
        IPCRunCgi.a(paramp.aDS(), new IPCRunCgi.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
          {
            AppMethodBeat.i(49878);
            ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hQE.hQJ != null) && ((paramAnonymousb.hQE.hQJ instanceof dlm)))
            {
              ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request success");
              AppMethodBeat.o(49878);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1237L, 5L, 1L, false);
            ae.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request fail");
            AppMethodBeat.o(49878);
          }
        });
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception paramchi)
      {
        ae.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { paramchi.toString() });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1237L, 6L, 1L, false);
      }
      i = paramchi.Hte;
      break;
      label387:
      int j = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      paramchi = "false";
      continue;
      label406:
      String str1 = "false";
      continue;
      label414:
      String str2 = "false";
    }
  }
  
  final void a(dsq paramdsq)
  {
    AppMethodBeat.i(49888);
    b.a locala = new b.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.hQF = paramdsq;
    locala.hQG = new dsr();
    IPCRunCgi.a(locala.aDS(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(49869);
        ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hQE.hQJ != null) && ((paramAnonymousb.hQE.hQJ instanceof dsr)))
        {
          ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
          if (f.this.ngM)
          {
            f.this.eu(3, 1);
            AppMethodBeat.o(49869);
            return;
          }
          f.this.eu(2, 1);
          AppMethodBeat.o(49869);
          return;
        }
        ae.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
        if (f.this.ngM)
        {
          f.this.eu(3, 2);
          AppMethodBeat.o(49869);
          return;
        }
        f.this.eu(2, 2);
        AppMethodBeat.o(49869);
      }
    });
    AppMethodBeat.o(49888);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49892);
    if (this.dialog != null)
    {
      this.dialog.dismiss();
      this.dialog = null;
    }
    AppMethodBeat.o(49892);
  }
  
  public final void eu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49893);
    if (bu.isNullOrNil(this.appId))
    {
      ae.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.ngN), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.dlk });
    com.tencent.mm.plugin.report.service.g.yxI.f(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(bu.aRi()), Integer.valueOf(this.ngN), this.sessionId, this.dlk, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(49893);
  }
  
  public final void show()
  {
    AppMethodBeat.i(49891);
    if (this.dialog != null) {
      this.dialog.show();
    }
    AppMethodBeat.o(49891);
  }
  
  final void wq(int paramInt)
  {
    int j = 2131755412;
    AppMethodBeat.i(49890);
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      this.ngV.setText(i);
      AppMethodBeat.o(49890);
      return;
      i = 2131755414;
      continue;
      i = 2131755413;
      continue;
      i = 2131755411;
      continue;
      i = 2131755410;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f
 * JD-Core Version:    0.7.0.1
 */