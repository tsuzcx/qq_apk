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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.protocal.protobuf.dmc;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class f
{
  public String appId;
  public String cYQ;
  public Dialog dialog;
  public com.tencent.mm.plugin.appbrand.report.b jPZ;
  public int kWs;
  public boolean mAR;
  int mAS;
  public TextView mAT;
  public RatingBar mAU;
  public TextView mAV;
  public LinearLayout mAW;
  public LinearLayout mAY;
  boolean mBd;
  public int scene;
  public String sessionId;
  public String userName;
  
  public f(c paramc)
  {
    AppMethodBeat.i(49886);
    this.mAR = false;
    this.mAS = 0;
    this.kWs = -1;
    this.mBd = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.Q(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.jPZ = paramc.bdv();
    }
    AppMethodBeat.o(49886);
  }
  
  public static Dialog u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(49887);
    paramContext = new a(paramContext, 2131820558);
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
  
  final void a(o paramo, boolean paramBoolean, cbx paramcbx, ecm paramecm)
  {
    AppMethodBeat.i(175092);
    if (this.mBd)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.mBd = true;
    int i;
    if (paramcbx == null)
    {
      i = 0;
      paramcbx = (AudioManager)paramo.mContext.getSystemService("audio");
      if (paramcbx == null) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        j = paramcbx.getStreamVolume(3);
        eaw localeaw = new eaw();
        if (j != 0) {
          break label393;
        }
        bool = true;
        localeaw.Ggx = bool;
        paramcbx = com.tencent.mm.plugin.music.b.f.dhm();
        str1 = paramo.mAppId;
        localeaw.Ggy = paramcbx.vcx.contains(str1);
        localeaw.Ggz = (this.kWs / 1000);
        if (!paramBoolean) {
          break label399;
        }
        paramcbx = "true";
        String str3 = paramecm.GhW;
        if (j != 0) {
          break label406;
        }
        str1 = "true";
        if (!localeaw.Ggy) {
          break label414;
        }
        str2 = "true";
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { paramcbx, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localeaw.Ggz) });
        paramcbx = new ecn();
        paramcbx.Gib = paramBoolean;
        paramcbx.FpT = i;
        paramcbx.GhW = paramecm.GhW;
        paramecm = new dfd();
        paramecm.hOf = paramo.mAppId;
        paramecm.EWM = this.jPZ.lQz;
        paramecm.EWL = this.jPZ.lQA;
        paramecm.EWN = localeaw;
        paramecm.FOu = paramcbx;
        paramo = new b.a();
        paramo.funcId = 2772;
        paramo.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramo.hvt = paramecm;
        paramo.hvu = new dfe();
        IPCRunCgi.a(paramo.aAz(), new IPCRunCgi.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
          {
            AppMethodBeat.i(49878);
            ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof dfe)))
            {
              ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request success");
              AppMethodBeat.o(49878);
              return;
            }
            h.wUl.idkeyStat(1237L, 5L, 1L, false);
            ac.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request fail");
            AppMethodBeat.o(49878);
          }
        });
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception paramcbx)
      {
        ac.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { paramcbx.toString() });
        h.wUl.idkeyStat(1237L, 6L, 1L, false);
      }
      i = paramcbx.FpT;
      break;
      label387:
      int j = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      paramcbx = "false";
      continue;
      label406:
      String str1 = "false";
      continue;
      label414:
      String str2 = "false";
    }
  }
  
  final void a(dmc paramdmc)
  {
    AppMethodBeat.i(49888);
    b.a locala = new b.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.hvt = paramdmc;
    locala.hvu = new dmd();
    IPCRunCgi.a(locala.aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(49869);
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof dmd)))
        {
          ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
          if (f.this.mAR)
          {
            f.this.es(3, 1);
            AppMethodBeat.o(49869);
            return;
          }
          f.this.es(2, 1);
          AppMethodBeat.o(49869);
          return;
        }
        ac.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
        if (f.this.mAR)
        {
          f.this.es(3, 2);
          AppMethodBeat.o(49869);
          return;
        }
        f.this.es(2, 2);
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
  
  public final void es(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49893);
    if (bs.isNullOrNil(this.appId))
    {
      ac.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.mAS), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.cYQ });
    h.wUl.f(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(bs.aNx()), Integer.valueOf(this.mAS), this.sessionId, this.cYQ, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
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
  
  final void vG(int paramInt)
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
      this.mAV.setText(i);
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