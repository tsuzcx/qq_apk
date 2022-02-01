package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class g
{
  private String account = "";
  private String dxX;
  boolean iSL = false;
  private String iSW = "";
  private a iSX;
  private String username = "";
  
  public g(a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.iSW = paramString2;
    this.iSX = parama;
  }
  
  public final void a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(128262);
    Object localObject = this.account;
    if (bs.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new s((String)localObject, this.iSW, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    a locala = this.iSX;
    paramMMActivity.getString(2131755906);
    locala.a(com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128259);
        com.tencent.mm.kernel.g.agi().a(this.iRy);
        AppMethodBeat.o(128259);
      }
    }));
    AppMethodBeat.o(128262);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128263);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.agi().a(new bn(new g.2(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramn instanceof s)) {
        this.dxX = ((s)paramn).aHz();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        t.cW(paramMMActivity);
        y.FH(this.account);
        y.showAddrBookUploadConfirm(paramMMActivity, new g.3(this, paramMMActivity), false, 2);
        if (this.iSL)
        {
          paramMMActivity = ai.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.YK()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.wUl.f(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
        }
        AppMethodBeat.o(128263);
        return;
      }
      if (paramInt2 == -106)
      {
        y.g(paramMMActivity, paramString, 0);
        AppMethodBeat.o(128263);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(paramMMActivity, e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128263);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iyy.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128263);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (com.tencent.mm.kernel.g.agi().aBK() == 5)
          {
            com.tencent.mm.ui.base.h.l(paramMMActivity, 2131761537, 2131761536);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.l(paramMMActivity, 2131758459, 2131760766);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.l(paramMMActivity, 2131760765, 2131760766);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.l(paramMMActivity, 2131762374, 2131755906);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.ui.base.h.l(paramMMActivity, 2131755265, 2131755906);
          i = 1;
          break;
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.agP();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
          for (paramString = com.tencent.mm.cc.a.aw(paramMMActivity, 2131761063);; paramString = com.tencent.mm.kernel.a.afG())
          {
            com.tencent.mm.ui.base.h.a(paramMMActivity, paramString, paramMMActivity.getString(2131755906), new g.4(this), new g.5(this));
            i = 1;
            break;
            com.tencent.mm.kernel.g.agP();
          }
        case -140: 
          if (!bs.isNullOrNil(this.dxX)) {
            y.m(paramMMActivity, paramString, this.dxX);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128263);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ProgressDialog paramProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */