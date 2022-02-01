package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class g
{
  private String account = "";
  private String dAl;
  boolean isG = false;
  private String isR = "";
  private a isS;
  private String username = "";
  
  public g(a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.isR = paramString2;
    this.isS = parama;
  }
  
  public final void a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(128262);
    Object localObject = this.account;
    if (bt.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new s((String)localObject, this.isR, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    a locala = this.isS;
    paramMMActivity.getString(2131755906);
    locala.a(com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128259);
        com.tencent.mm.kernel.g.aeS().a(this.irt);
        AppMethodBeat.o(128259);
      }
    }));
    AppMethodBeat.o(128262);
  }
  
  public final void a(final MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128263);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128260);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128260);
            return;
          }
          paramAnonymouse = paramAnonymouse.avg();
          com.tencent.mm.kernel.g.afz();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128260);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramn instanceof s)) {
        this.dAl = ((s)paramn).aAJ();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        t.cN(paramMMActivity);
        y.BD(this.account);
        y.showAddrBookUploadConfirm(paramMMActivity, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128261);
            Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(paramMMActivity);
            ((Intent)localObject).addFlags(67108864);
            MMActivity localMMActivity = paramMMActivity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localMMActivity, "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramMMActivity.finish();
            AppMethodBeat.o(128261);
          }
        }, false, 2);
        if (this.isG)
        {
          paramMMActivity = aj.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.XN()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.vKh.f(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
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
        y.a(paramMMActivity, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128263);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.hYu.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.aeS().auR() == 5)
          {
            com.tencent.mm.ui.base.h.j(paramMMActivity, 2131761537, 2131761536);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.j(paramMMActivity, 2131758459, 2131760766);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.j(paramMMActivity, 2131760765, 2131760766);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.j(paramMMActivity, 2131762374, 2131755906);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.ui.base.h.j(paramMMActivity, 2131755265, 2131755906);
          i = 1;
          break;
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.afz();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
          for (paramString = com.tencent.mm.cd.a.aq(paramMMActivity, 2131761063);; paramString = com.tencent.mm.kernel.a.aeq())
          {
            com.tencent.mm.ui.base.h.a(paramMMActivity, paramString, paramMMActivity.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.g.afz();
          }
        case -140: 
          if (!bt.isNullOrNil(this.dAl)) {
            y.m(paramMMActivity, paramString, this.dAl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */