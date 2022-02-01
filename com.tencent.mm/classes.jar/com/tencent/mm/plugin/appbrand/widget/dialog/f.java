package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.czs;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class f
{
  public boolean KCV;
  int KCW;
  public TextView KCX;
  public RatingBar KCY;
  public TextView KCZ;
  public LinearLayout KDa;
  public LinearLayout KDb;
  boolean KDc;
  public String appId;
  public String dbu;
  public Dialog dialog;
  public com.tencent.mm.plugin.appbrand.report.b jpK;
  public int kve;
  public int scene;
  public String sessionId;
  public String userName;
  
  public f(c paramc)
  {
    AppMethodBeat.i(49886);
    this.KCV = false;
    this.KCW = 0;
    this.kve = -1;
    this.KDc = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.Q(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.jpK = paramc.aWx();
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
  
  final void a(o paramo, boolean paramBoolean, bxd parambxd, dwv paramdwv)
  {
    AppMethodBeat.i(175092);
    if (this.KDc)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.KDc = true;
    int i;
    if (parambxd == null)
    {
      i = 0;
      parambxd = (AudioManager)paramo.mContext.getSystemService("audio");
      if (parambxd == null) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        j = parambxd.getStreamVolume(3);
        dvf localdvf = new dvf();
        if (j != 0) {
          break label393;
        }
        bool = true;
        localdvf.EJl = bool;
        parambxd = com.tencent.mm.plugin.music.b.f.cTC();
        str1 = paramo.mAppId;
        localdvf.EJm = parambxd.tTP.contains(str1);
        localdvf.EJn = (this.kve / 1000);
        if (!paramBoolean) {
          break label399;
        }
        parambxd = "true";
        String str3 = paramdwv.EKK;
        if (j != 0) {
          break label406;
        }
        str1 = "true";
        if (!localdvf.EJm) {
          break label414;
        }
        str2 = "true";
        ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { parambxd, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localdvf.EJn) });
        parambxd = new dww();
        parambxd.EKP = paramBoolean;
        parambxd.DTx = i;
        parambxd.EKK = paramdwv.EKK;
        paramdwv = new czr();
        paramdwv.hnC = paramo.mAppId;
        paramdwv.DBq = this.jpK.loz;
        paramdwv.DBp = this.jpK.loA;
        paramdwv.DBr = localdvf;
        paramdwv.Ers = parambxd;
        paramo = new b.a();
        paramo.funcId = 2772;
        paramo.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramo.gUU = paramdwv;
        paramo.gUV = new czs();
        IPCRunCgi.a(paramo.atI(), new f.14(this));
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception parambxd)
      {
        ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { parambxd.toString() });
        h.vKh.idkeyStat(1237L, 6L, 1L, false);
      }
      i = parambxd.DTx;
      break;
      label387:
      int j = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      parambxd = "false";
      continue;
      label406:
      String str1 = "false";
      continue;
      label414:
      String str2 = "false";
    }
  }
  
  final void a(dgn paramdgn)
  {
    AppMethodBeat.i(49888);
    b.a locala = new b.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.gUU = paramdgn;
    locala.gUV = new dgo();
    IPCRunCgi.a(locala.atI(), new f.5(this));
    AppMethodBeat.o(49888);
  }
  
  final void agN(int paramInt)
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
      this.KCZ.setText(i);
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
    if (bt.isNullOrNil(this.appId))
    {
      ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.KCW), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.dbu });
    h.vKh.f(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(bt.aGK()), Integer.valueOf(this.KCW), this.sessionId, this.dbu, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f
 * JD-Core Version:    0.7.0.1
 */