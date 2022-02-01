package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class h
{
  private String account = "";
  private String edo;
  boolean kmX = false;
  private String knh = "";
  private a kni;
  private String username = "";
  
  public h(a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.knh = paramString2;
    this.kni = parama;
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128263);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128260);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128260);
            return;
          }
          paramAnonymousg = paramAnonymousg.aZh();
          com.tencent.mm.kernel.g.aAf();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128260);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
        this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.platformtools.t.dr(paramMMActivity);
        y.St(this.account);
        y.showAddrBookUploadConfirm(paramMMActivity, new h.3(this, paramMMActivity), false, 2);
        if (this.kmX)
        {
          paramMMActivity = MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.aps()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.CyF.a(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
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
        y.a(paramMMActivity, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128263);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.jRu.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.azz().aYS() == 5)
          {
            com.tencent.mm.ui.base.h.n(paramMMActivity, 2131763503, 2131763502);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.n(paramMMActivity, 2131758757, 2131762516);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.n(paramMMActivity, 2131762515, 2131762516);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.n(paramMMActivity, 2131764440, 2131755998);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.ui.base.h.n(paramMMActivity, 2131755300, 2131755998);
          i = 1;
          break;
        case -2023: 
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.aAf();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
          for (paramString = com.tencent.mm.cb.a.aI(paramMMActivity, 2131762849);; paramString = com.tencent.mm.kernel.a.ayX())
          {
            com.tencent.mm.ui.base.h.a(paramMMActivity, paramString, paramMMActivity.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.g.aAf();
          }
        case -140: 
          if (!Util.isNullOrNil(this.edo)) {
            y.m(paramMMActivity, paramString, this.edo);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128263);
      return;
    }
  }
  
  public final void b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(128262);
    Object localObject = this.account;
    if (Util.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new com.tencent.mm.modelsimple.t((String)localObject, this.knh, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    a locala = this.kni;
    paramMMActivity.getString(2131755998);
    locala.a(com.tencent.mm.ui.base.h.a(paramMMActivity, paramMMActivity.getString(2131762532), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128259);
        com.tencent.mm.kernel.g.azz().a(this.klI);
        AppMethodBeat.o(128259);
      }
    }));
    AppMethodBeat.o(128262);
  }
  
  public static abstract interface a
  {
    public abstract void a(ProgressDialog paramProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */