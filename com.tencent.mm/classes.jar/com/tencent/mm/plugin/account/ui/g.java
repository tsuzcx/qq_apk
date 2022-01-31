package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class g
{
  private String account = "";
  private String cJr;
  boolean gFc = false;
  private String gFn = "";
  private g.a gFo;
  private String username = "";
  
  public g(g.a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.gFn = paramString2;
    this.gFo = parama;
  }
  
  public final void a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(125084);
    Object localObject = this.account;
    if (bo.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new s((String)localObject, this.gFn, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    g.a locala = this.gFo;
    paramMMActivity.getString(2131297087);
    locala.a(com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(2131301149), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(125081);
        com.tencent.mm.kernel.g.Rc().a(this.gDI);
        AppMethodBeat.o(125081);
      }
    }));
    AppMethodBeat.o(125084);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125085);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.Rc().a(new bk(new bk.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(125082);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(125082);
            return;
          }
          paramAnonymouse = paramAnonymouse.adI();
          com.tencent.mm.kernel.g.RJ();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(125082);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramm instanceof s)) {
        this.cJr = ((s)paramm).ajF();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        w.cs(paramMMActivity);
        z.wz(this.account);
        z.showAddrBookUploadConfirm(paramMMActivity, new g.3(this, paramMMActivity), false, 2);
        if (this.gFc)
        {
          paramMMActivity = ah.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.h.Mp()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.qsU.e(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
        }
        AppMethodBeat.o(125085);
        return;
      }
      if (paramInt2 == -106)
      {
        z.f(paramMMActivity, paramString, 0);
        AppMethodBeat.o(125085);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(paramMMActivity, com.tencent.mm.platformtools.e.a((s)paramm), paramInt2);
        AppMethodBeat.o(125085);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.gmP.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(125085);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (com.tencent.mm.kernel.g.Rc().adt() == 5)
          {
            com.tencent.mm.ui.base.h.h(paramMMActivity, 2131301790, 2131301789);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.h(paramMMActivity, 2131299331, 2131301135);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.h(paramMMActivity, 2131301134, 2131301135);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.h(paramMMActivity, 2131302471, 2131297087);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.ui.base.h.h(paramMMActivity, 2131296531, 2131297087);
          i = 1;
          break;
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.RJ();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
          for (paramString = com.tencent.mm.cb.a.aq(paramMMActivity, 2131301416);; paramString = com.tencent.mm.kernel.a.QD())
          {
            com.tencent.mm.ui.base.h.a(paramMMActivity, paramString, paramMMActivity.getString(2131297087), new g.4(this), new g.5(this));
            i = 1;
            break;
            com.tencent.mm.kernel.g.RJ();
          }
        case -140: 
          if (!bo.isNullOrNil(this.cJr)) {
            z.o(paramMMActivity, paramString, this.cJr);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(125085);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */