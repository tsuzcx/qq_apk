package com.tencent.mm.plugin.appbrand.widget.b;

import android.app.Dialog;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  public String appId;
  public String cmG;
  public String cpW;
  public Dialog dialog;
  public LinearLayout jjA;
  public boolean jju = false;
  int jjv = 0;
  public TextView jjw;
  public RatingBar jjx;
  public TextView jjy;
  public FrameLayout jjz;
  public int scene;
  public String userName;
  
  final void a(cnl paramcnl)
  {
    AppMethodBeat.i(134265);
    b.a locala = new b.a();
    locala.funcId = 2521;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
    locala.fsX = paramcnl;
    locala.fsY = new cnm();
    b.a(locala.ado(), new f.11(this));
    AppMethodBeat.o(134265);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(134267);
    if (this.dialog != null)
    {
      this.dialog.dismiss();
      this.dialog = null;
    }
    AppMethodBeat.o(134267);
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134268);
    if (bo.isNullOrNil(this.appId))
    {
      ab.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, no app id");
      AppMethodBeat.o(134268);
      return;
    }
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", new Object[] { this.appId, Integer.valueOf(paramInt1), this.cpW, Integer.valueOf(this.jjv), Integer.valueOf(this.scene), Integer.valueOf(paramInt2), this.cmG });
    h.qsU.e(16176, new Object[] { this.appId, Integer.valueOf(paramInt1), Long.valueOf(bo.aox()), Integer.valueOf(this.jjv), this.cpW, this.cmG, Integer.valueOf(this.scene), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(134268);
  }
  
  final void qn(int paramInt)
  {
    int j = 2131296640;
    AppMethodBeat.i(134266);
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      this.jjy.setText(i);
      AppMethodBeat.o(134266);
      return;
      i = 2131296642;
      continue;
      i = 2131296641;
      continue;
      i = 2131296639;
      continue;
      i = 2131296638;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f
 * JD-Core Version:    0.7.0.1
 */