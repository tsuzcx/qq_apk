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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.au.j;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.music.b.i;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.protocal.protobuf.epa;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.fok;
import com.tencent.mm.protocal.protobuf.fqd;
import com.tencent.mm.protocal.protobuf.fqe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
{
  public String appId;
  public Dialog dialog;
  public String fve;
  public com.tencent.mm.plugin.appbrand.report.b olT;
  public int pEa;
  public TextView rrS;
  public boolean rtM;
  int rtO;
  public RatingBar rtQ;
  public TextView rtR;
  public LinearLayout rtS;
  public LinearLayout rtT;
  boolean rtU;
  public int scene;
  public String sessionId;
  public String userName;
  
  public e(c paramc)
  {
    AppMethodBeat.i(49886);
    this.rtM = false;
    this.rtO = 0;
    this.pEa = -1;
    this.rtU = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.R(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.olT = paramc.bOq();
    }
    AppMethodBeat.o(49886);
  }
  
  public static Dialog C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(49887);
    paramContext = new com.tencent.mm.plugin.crashfix.b.a(paramContext, au.j.AppBrandEvaluateDialogStyle);
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
      localWindow.setWindowAnimations(au.j.AppBrandEvaluateDialogAnimation);
    }
    AppMethodBeat.o(49887);
    return paramContext;
  }
  
  final void DG(int paramInt)
  {
    AppMethodBeat.i(49890);
    int i = au.i.app_brand_evaluate_star_one;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.rtR.setText(paramInt);
      AppMethodBeat.o(49890);
      return;
      paramInt = au.i.app_brand_evaluate_star_one;
      continue;
      paramInt = au.i.app_brand_evaluate_star_two;
      continue;
      paramInt = au.i.app_brand_evaluate_star_three;
      continue;
      paramInt = au.i.app_brand_evaluate_star_four;
      continue;
      paramInt = au.i.app_brand_evaluate_star_five;
    }
  }
  
  final void a(t paramt, boolean paramBoolean, dgz paramdgz, fqd paramfqd)
  {
    AppMethodBeat.i(175092);
    if (this.rtU)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.rtU = true;
    int i;
    if (paramdgz == null)
    {
      i = 0;
      paramdgz = (AudioManager)paramt.mContext.getSystemService("audio");
      if (paramdgz == null) {
        break label390;
      }
    }
    for (;;)
    {
      try
      {
        j = paramdgz.getStreamVolume(3);
        fok localfok = new fok();
        if (j != 0) {
          break label396;
        }
        bool = true;
        localfok.UMy = bool;
        paramdgz = i.fcS();
        str1 = paramt.mAppId;
        localfok.UMz = paramdgz.FNQ.contains(str1);
        localfok.UMA = (this.pEa / 1000);
        if (!paramBoolean) {
          break label402;
        }
        paramdgz = "true";
        String str3 = paramfqd.UNV;
        if (j != 0) {
          break label409;
        }
        str1 = "true";
        if (!localfok.UMz) {
          break label417;
        }
        str2 = "true";
        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { paramdgz, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localfok.UMA) });
        paramdgz = new fqe();
        paramdgz.UOa = paramBoolean;
        paramdgz.TNG = i;
        paramdgz.UNV = paramfqd.UNV;
        paramfqd = new eoz();
        paramfqd.lVG = paramt.mAppId;
        paramfqd.Ton = this.olT.qIn;
        paramfqd.Tom = this.olT.qIo;
        paramfqd.Too = localfok;
        paramfqd.Urt = paramdgz;
        paramt = new d.a();
        paramt.funcId = 2772;
        paramt.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramt.lBU = paramfqd;
        paramt.lBV = new epa();
        IPCRunCgi.a(paramt.bgN(), new e.14(this));
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception paramdgz)
      {
        Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { paramdgz.toString() });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1237L, 6L, 1L, false);
      }
      i = paramdgz.TNG;
      break;
      label390:
      int j = 0;
      continue;
      label396:
      boolean bool = false;
      continue;
      label402:
      paramdgz = "false";
      continue;
      label409:
      String str1 = "false";
      continue;
      label417:
      String str2 = "false";
    }
  }
  
  final void a(eww parameww)
  {
    AppMethodBeat.i(49888);
    d.a locala = new d.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.lBU = parameww;
    locala.lBV = new ewx();
    IPCRunCgi.a(locala.bgN(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(49869);
        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousd != null) && (d.c.b(paramAnonymousd.lBS) != null) && ((d.c.b(paramAnonymousd.lBS) instanceof ewx)))
        {
          Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
          if (e.this.rtM)
          {
            e.this.fg(3, 1);
            AppMethodBeat.o(49869);
            return;
          }
          e.this.fg(2, 1);
          AppMethodBeat.o(49869);
          return;
        }
        Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
        if (e.this.rtM)
        {
          e.this.fg(3, 2);
          AppMethodBeat.o(49869);
          return;
        }
        e.this.fg(2, 2);
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
  
  public final void fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49893);
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.rtO), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.fve });
    com.tencent.mm.plugin.report.service.h.IzE.a(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.rtO), this.sessionId, this.fve, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */