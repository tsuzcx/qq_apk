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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class g
{
  private String account = "";
  private String dLz;
  boolean joN = false;
  private String joY = "";
  private a joZ;
  private String username = "";
  
  public g(a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.joY = paramString2;
    this.joZ = parama;
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128263);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128260);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128260);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFs();
          com.tencent.mm.kernel.g.ajP();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128260);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramn instanceof com.tencent.mm.modelsimple.t)) {
        this.dLz = ((com.tencent.mm.modelsimple.t)paramn).aLh();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.platformtools.t.cW(paramMMActivity);
        y.Jv(this.account);
        y.showAddrBookUploadConfirm(paramMMActivity, new g.3(this, paramMMActivity), false, 2);
        if (this.joN)
        {
          paramMMActivity = ak.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.abv()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.g.yxI.f(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
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
        y.a(paramMMActivity, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
        AppMethodBeat.o(128263);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iUA.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
          {
            h.l(paramMMActivity, 2131761537, 2131761536);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          h.l(paramMMActivity, 2131758459, 2131760766);
          i = 1;
          break;
        case -9: 
          h.l(paramMMActivity, 2131760765, 2131760766);
          i = 1;
          break;
        case -72: 
          h.l(paramMMActivity, 2131762374, 2131755906);
          i = 1;
          break;
        case -75: 
          h.l(paramMMActivity, 2131755265, 2131755906);
          i = 1;
          break;
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajP();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
          for (paramString = com.tencent.mm.cb.a.az(paramMMActivity, 2131761063);; paramString = com.tencent.mm.kernel.a.aiH())
          {
            h.a(paramMMActivity, paramString, paramMMActivity.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.g.ajP();
          }
        case -140: 
          if (!bu.isNullOrNil(this.dLz)) {
            y.n(paramMMActivity, paramString, this.dLz);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128263);
      return;
    }
  }
  
  public final void b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(128262);
    Object localObject = this.account;
    if (bu.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new com.tencent.mm.modelsimple.t((String)localObject, this.joY, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    a locala = this.joZ;
    paramMMActivity.getString(2131755906);
    locala.a(h.b(paramMMActivity, paramMMActivity.getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128259);
        com.tencent.mm.kernel.g.ajj().a(this.jnA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */