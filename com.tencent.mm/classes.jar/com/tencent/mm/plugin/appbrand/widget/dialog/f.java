package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.media.AudioManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.eey;
import com.tencent.mm.protocal.protobuf.eez;
import com.tencent.mm.protocal.protobuf.emo;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.fdj;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.protocal.protobuf.ffd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class f
{
  public boolean GfH;
  int GhC;
  public RatingBar HZZ;
  public TextView Iaa;
  public LinearLayout Iab;
  public LinearLayout Iac;
  boolean Iad;
  public String appId;
  public String dCx;
  public Dialog dialog;
  public com.tencent.mm.plugin.appbrand.report.b lrj;
  public int mEO;
  public TextView oqv;
  public int scene;
  public String sessionId;
  public String userName;
  
  public f(c paramc)
  {
    AppMethodBeat.i(49886);
    this.GfH = false;
    this.GhC = 0;
    this.mEO = -1;
    this.Iad = false;
    paramc = (com.tencent.mm.plugin.appbrand.game.b)paramc.S(com.tencent.mm.plugin.appbrand.game.b.class);
    if (paramc != null) {
      this.lrj = paramc.bCV();
    }
    AppMethodBeat.o(49886);
  }
  
  public static Dialog z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(49887);
    paramContext = new com.tencent.mm.plugin.crashfix.b.a(paramContext, 2131820559);
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
      localWindow.setWindowAnimations(2131820558);
    }
    AppMethodBeat.o(49887);
    return paramContext;
  }
  
  final void a(q paramq, boolean paramBoolean, cxp paramcxp, ffc paramffc)
  {
    AppMethodBeat.i(175092);
    if (this.Iad)
    {
      AppMethodBeat.o(175092);
      return;
    }
    this.Iad = true;
    int i;
    if (paramcxp == null)
    {
      i = 0;
      paramcxp = (AudioManager)paramq.mContext.getSystemService("audio");
      if (paramcxp == null) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        j = paramcxp.getStreamVolume(3);
        fdj localfdj = new fdj();
        if (j != 0) {
          break label393;
        }
        bool = true;
        localfdj.NyU = bool;
        paramcxp = com.tencent.mm.plugin.music.b.h.esI();
        str1 = paramq.mAppId;
        localfdj.NyV = paramcxp.AgW.contains(str1);
        localfdj.NyW = (this.mEO / 1000);
        if (!paramBoolean) {
          break label399;
        }
        paramcxp = "true";
        String str3 = paramffc.NAt;
        if (j != 0) {
          break label406;
        }
        str1 = "true";
        if (!localfdj.NyV) {
          break label414;
        }
        str2 = "true";
        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "submitGameEvaluateResult reject[%s] questionId[%s] optionId[%d] isMute[%s] isPlayMusic[%s] playSeconds[%d]", new Object[] { paramcxp, str3, Integer.valueOf(i), str1, str2, Integer.valueOf(localfdj.NyW) });
        paramcxp = new ffd();
        paramcxp.NAy = paramBoolean;
        paramcxp.MCa = i;
        paramcxp.NAt = paramffc.NAt;
        paramffc = new eey();
        paramffc.jfi = paramq.mAppId;
        paramffc.MeL = this.lrj.nGb;
        paramffc.MeK = this.lrj.nGc;
        paramffc.MeM = localfdj;
        paramffc.NeT = paramcxp;
        paramq = new d.a();
        paramq.funcId = 2772;
        paramq.uri = "/cgi-bin/mmgame-bin/submitoriginalreview";
        paramq.iLN = paramffc;
        paramq.iLO = new eez();
        IPCRunCgi.a(paramq.aXF(), new f.14(this));
        AppMethodBeat.o(175092);
        return;
      }
      catch (Exception paramcxp)
      {
        Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "currentVolume get error: %s", new Object[] { paramcxp.toString() });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1237L, 6L, 1L, false);
      }
      i = paramcxp.MCa;
      break;
      label387:
      int j = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      paramcxp = "false";
      continue;
      label406:
      String str1 = "false";
      continue;
      label414:
      String str2 = "false";
    }
  }
  
  final void a(emo paramemo)
  {
    AppMethodBeat.i(49888);
    d.a locala = new d.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.iLN = paramemo;
    locala.iLO = new emp();
    IPCRunCgi.a(locala.aXF(), new f.5(this));
    AppMethodBeat.o(49888);
  }
  
  final void akp(int paramInt)
  {
    int j = 2131755451;
    AppMethodBeat.i(49890);
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      this.Iaa.setText(i);
      AppMethodBeat.o(49890);
      return;
      i = 2131755453;
      continue;
      i = 2131755452;
      continue;
      i = 2131755450;
      continue;
      i = 2131755449;
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
  
  public final void eI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49893);
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(49893);
      return;
    }
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.sessionId, Integer.valueOf(this.GhC), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.dCx });
    com.tencent.mm.plugin.report.service.h.CyF.a(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.GhC), this.sessionId, this.dCx, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
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