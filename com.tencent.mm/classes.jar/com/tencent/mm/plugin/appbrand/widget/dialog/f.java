package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class f
{
  public String appId;
  public Dialog dialog;
  public String dki;
  public com.tencent.mm.plugin.appbrand.report.b kkl;
  public int ltr;
  int ndA;
  public TextView ndB;
  public RatingBar ndC;
  public TextView ndD;
  public LinearLayout ndE;
  public LinearLayout ndF;
  boolean ndG;
  public boolean ndz;
  public int scene;
  public String sessionId;
  public String userName;
  
  public f(c paramc)
  {
    AppMethodBeat.i(49886);
    this.ndz = false;
    this.ndA = 0;
    this.ltr = -1;
    this.ndG = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.Q(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.kkl = paramc.bgZ();
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
  
  final void a(com.tencent.mm.plugin.appbrand.o paramo, boolean paramBoolean, cgo paramcgo, eis parameis)
  {
    AppMethodBeat.i(175092);
    if (this.ndG)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.ndG = true;
    int i;
    if (paramcgo == null)
    {
      i = 0;
      paramcgo = (AudioManager)paramo.mContext.getSystemService("audio");
      if (paramcgo == null) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        j = paramcgo.getStreamVolume(3);
        eha localeha = new eha();
        if (j != 0) {
          break label393;
        }
        bool = true;
        localeha.HRK = bool;
        paramcgo = com.tencent.mm.plugin.music.b.f.drz();
        str1 = paramo.mAppId;
        localeha.HRL = paramcgo.whT.contains(str1);
        localeha.HRM = (this.ltr / 1000);
        if (!paramBoolean) {
          break label399;
        }
        paramcgo = "true";
        String str3 = parameis.HTk;
        if (j != 0) {
          break label406;
        }
        str1 = "true";
        if (!localeha.HRL) {
          break label414;
        }
        str2 = "true";
        ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { paramcgo, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localeha.HRM) });
        paramcgo = new eit();
        paramcgo.HTp = paramBoolean;
        paramcgo.GZD = i;
        paramcgo.HTk = parameis.HTk;
        parameis = new dkq();
        parameis.iht = paramo.mAppId;
        parameis.GGj = this.kkl.mqp;
        parameis.GGi = this.kkl.mqq;
        parameis.GGk = localeha;
        parameis.Hzf = paramcgo;
        paramo = new b.a();
        paramo.funcId = 2772;
        paramo.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramo.hNM = parameis;
        paramo.hNN = new dkr();
        IPCRunCgi.a(paramo.aDC(), new IPCRunCgi.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
          {
            AppMethodBeat.i(49878);
            ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof dkr)))
            {
              ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request success");
              AppMethodBeat.o(49878);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1237L, 5L, 1L, false);
            ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request fail");
            AppMethodBeat.o(49878);
          }
        });
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception paramcgo)
      {
        ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { paramcgo.toString() });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1237L, 6L, 1L, false);
      }
      i = paramcgo.GZD;
      break;
      label387:
      int j = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      paramcgo = "false";
      continue;
      label406:
      String str1 = "false";
      continue;
      label414:
      String str2 = "false";
    }
  }
  
  final void a(drt paramdrt)
  {
    AppMethodBeat.i(49888);
    b.a locala = new b.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.hNM = paramdrt;
    locala.hNN = new dru();
    IPCRunCgi.a(locala.aDC(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(49869);
        ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof dru)))
        {
          ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
          if (f.this.ndz)
          {
            f.this.cf(3, 1);
            AppMethodBeat.o(49869);
            return;
          }
          f.this.cf(2, 1);
          AppMethodBeat.o(49869);
          return;
        }
        ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
        if (f.this.ndz)
        {
          f.this.cf(3, 2);
          AppMethodBeat.o(49869);
          return;
        }
        f.this.cf(2, 2);
        AppMethodBeat.o(49869);
      }
    });
    AppMethodBeat.o(49888);
  }
  
  public final void cf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49893);
    if (bt.isNullOrNil(this.appId))
    {
      ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.ndA), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.dki });
    com.tencent.mm.plugin.report.service.g.yhR.f(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(bt.aQJ()), Integer.valueOf(this.ndA), this.sessionId, this.dki, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(49893);
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
  
  public final void show()
  {
    AppMethodBeat.i(49891);
    if (this.dialog != null) {
      this.dialog.show();
    }
    AppMethodBeat.o(49891);
  }
  
  final void xw(int paramInt)
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
      this.ndD.setText(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f
 * JD-Core Version:    0.7.0.1
 */