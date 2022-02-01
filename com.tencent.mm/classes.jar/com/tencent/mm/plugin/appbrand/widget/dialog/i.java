package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.fjy;
import com.tencent.mm.protocal.protobuf.fjz;
import com.tencent.mm.protocal.protobuf.fsp;
import com.tencent.mm.protocal.protobuf.fsq;
import com.tencent.mm.protocal.protobuf.glj;
import com.tencent.mm.protocal.protobuf.gnm;
import com.tencent.mm.protocal.protobuf.gnn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
{
  public String appId;
  public String hzy;
  public com.tencent.mm.plugin.appbrand.report.b rpC;
  public int sJm;
  public int scene;
  public String sessionId;
  public boolean uCN;
  int uCR;
  public RatingBar uCS;
  public Dialog uCz;
  public TextView uDc;
  public LinearLayout uDd;
  public LinearLayout uDk;
  boolean uDl;
  public TextView uck;
  public String userName;
  
  public i(c paramc)
  {
    AppMethodBeat.i(49886);
    this.uCN = false;
    this.uCR = 0;
    this.sJm = -1;
    this.uDl = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.aa(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.rpC = paramc.coF();
    }
    AppMethodBeat.o(49886);
  }
  
  public static Dialog E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(49887);
    paramContext = new a(paramContext, ba.j.AppBrandEvaluateDialogStyle);
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
      localWindow.setWindowAnimations(ba.j.AppBrandEvaluateDialogAnimation);
    }
    AppMethodBeat.o(49887);
    return paramContext;
  }
  
  final void a(w paramw, boolean paramBoolean, dzg paramdzg, gnm paramgnm)
  {
    AppMethodBeat.i(175092);
    if (this.uDl)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.uDl = true;
    int i;
    if (paramdzg == null)
    {
      i = 0;
      paramdzg = (AudioManager)paramw.mContext.getSystemService("audio");
      if (paramdzg == null) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        j = paramdzg.getStreamVolume(3);
        glj localglj = new glj();
        if (j != 0) {
          break label393;
        }
        bool = true;
        localglj.acgS = bool;
        paramdzg = com.tencent.mm.plugin.music.b.i.glV();
        str1 = paramw.mAppId;
        localglj.acgT = paramdzg.LIM.contains(str1);
        localglj.acgU = (this.sJm / 1000);
        if (!paramBoolean) {
          break label399;
        }
        paramdzg = "true";
        String str3 = paramgnm.acix;
        if (j != 0) {
          break label406;
        }
        str1 = "true";
        if (!localglj.acgT) {
          break label414;
        }
        str2 = "true";
        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { paramdzg, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localglj.acgU) });
        paramdzg = new gnn();
        paramdzg.aciC = paramBoolean;
        paramdzg.abdZ = i;
        paramdzg.acix = paramgnm.acix;
        paramgnm = new fjy();
        paramgnm.oOI = paramw.mAppId;
        paramgnm.aaCu = this.rpC.tMT;
        paramgnm.aaCt = this.rpC.tMU;
        paramgnm.aaCv = localglj;
        paramgnm.abKt = paramdzg;
        paramw = new c.a();
        paramw.funcId = 2772;
        paramw.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramw.otE = paramgnm;
        paramw.otF = new fjz();
        IPCRunCgi.a(paramw.bEF(), new i.14(this));
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception paramdzg)
      {
        Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { paramdzg.toString() });
        h.OAn.idkeyStat(1237L, 6L, 1L, false);
      }
      i = paramdzg.abdZ;
      break;
      label387:
      int j = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      paramdzg = "false";
      continue;
      label406:
      String str1 = "false";
      continue;
      label414:
      String str2 = "false";
    }
  }
  
  final void a(fsp paramfsp)
  {
    AppMethodBeat.i(49888);
    c.a locala = new c.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.otE = paramfsp;
    locala.otF = new fsq();
    IPCRunCgi.a(locala.bEF(), new i.5(this));
    AppMethodBeat.o(49888);
  }
  
  final void aqi(int paramInt)
  {
    AppMethodBeat.i(49890);
    int i = ba.i.app_brand_evaluate_star_one;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.uDc.setText(paramInt);
      AppMethodBeat.o(49890);
      return;
      paramInt = ba.i.app_brand_evaluate_star_one;
      continue;
      paramInt = ba.i.app_brand_evaluate_star_two;
      continue;
      paramInt = ba.i.app_brand_evaluate_star_three;
      continue;
      paramInt = ba.i.app_brand_evaluate_star_four;
      continue;
      paramInt = ba.i.app_brand_evaluate_star_five;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49892);
    if (this.uCz != null)
    {
      this.uCz.dismiss();
      this.uCz = null;
    }
    AppMethodBeat.o(49892);
  }
  
  public final void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49893);
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.uCR), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.hzy });
    h.OAn.b(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.uCR), this.sessionId, this.hzy, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(49893);
  }
  
  public final void show()
  {
    AppMethodBeat.i(49891);
    if (this.uCz != null) {
      this.uCz.show();
    }
    AppMethodBeat.o(49891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i
 * JD-Core Version:    0.7.0.1
 */