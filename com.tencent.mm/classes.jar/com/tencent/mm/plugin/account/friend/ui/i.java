package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.an.i
{
  public String fLC;
  public boolean kUn = false;
  public Context mContext;
  private final a mZn;
  public com.tencent.mm.plugin.account.friend.a.z mZo;
  private com.tencent.mm.plugin.account.friend.a.z mZp;
  public boolean mZq = true;
  public i.b mZr;
  public s tipDialog = null;
  
  public i(i.b paramb, Context paramContext, a parama)
  {
    this.mZr = paramb;
    this.mContext = paramContext;
    this.mZn = parama;
  }
  
  private boolean W(int paramInt, String paramString)
  {
    AppMethodBeat.i(131323);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(131323);
      return bool;
      Toast.makeText(this.mContext, a.g.app_err_system_busy_tip, 0).show();
      bool = true;
      continue;
      Toast.makeText(this.mContext, a.g.bind_mcontact_err_freq_limit, 0).show();
      bool = true;
      continue;
      Log.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((i.b.mZt == this.mZr) || (this.mZr == i.b.mZu))
      {
        com.tencent.mm.kernel.h.aHG().aHp().i(4097, "");
        paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, "");
        com.tencent.mm.kernel.h.aHG().aHp().i(6, this.fLC);
        if (!Util.isNullOrNil(paramString))
        {
          if (com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuG, "").equals(paramString)) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuG, com.tencent.mm.model.z.bcZ());
          }
          Iterator localIterator = ci.lvQ.bfs().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(ci.lvQ.getString(str, "login_user_name"))) {
              ci.lvQ.o(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
      }
      j(2, new Bundle());
      Toast.makeText(this.mContext, a.g.bind_mcontact_err_binded, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if (paramString != null) {
        paramString.a(this.mContext, null, null);
      }
      bool = true;
      continue;
      Toast.makeText(this.mContext, a.g.bind_mcontact_err_format, 0).show();
      bool = true;
      continue;
      com.tencent.mm.ui.base.h.a(this.mContext, a.g.bind_mcontact_err_binded_by_other, a.g.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = true;
      continue;
      Toast.makeText(this.mContext, a.g.bind_mcontact_err_unbinded_notbinded, 0).show();
      bool = true;
      continue;
      com.tencent.mm.ui.base.h.a(this.mContext, a.g.bind_mcontact_err_not_suport_country, a.g.app_tip, null);
      bool = true;
      continue;
      bool = false;
      continue;
      com.tencent.mm.ui.base.h.a(this.mContext, a.g.bind_mcontact_err_BindPhone_NeedAdjust, a.g.app_tip, null);
      bool = true;
    }
  }
  
  private void byU()
  {
    AppMethodBeat.i(131326);
    if ((this.mZr == i.b.mZt) || (this.mZr == i.b.mZu))
    {
      int i = 1;
      if (this.mZr == i.b.mZu) {
        i = 18;
      }
      this.mZp = new com.tencent.mm.plugin.account.friend.a.z(this.fLC, i, "", 0, "");
      com.tencent.mm.kernel.h.aGY().a(this.mZp, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void j(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.mZr == i.b.mZt) || (this.mZr == i.b.mZu)) {
      com.tencent.mm.kernel.h.aGY().b(132, this);
    }
    if (this.mZn != null) {
      this.mZn.j(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void aaS(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.mZr == i.b.mZt) || (this.mZr == i.b.mZu)) {
      com.tencent.mm.kernel.h.aGY().a(132, this);
    }
    this.fLC = paramString;
    this.kUn = false;
    byU();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(a.g.app_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(194123);
        i.a(i.this);
        AppMethodBeat.o(194123);
      }
    });
    AppMethodBeat.o(131321);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(131325);
    Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramq != this.mZo) && (paramq != this.mZp))
    {
      Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.kUn)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if (((i.b.mZt == this.mZr) || (i.b.mZu == this.mZr)) && (paramq.getType() == 132))
    {
      switch (((com.tencent.mm.plugin.account.friend.a.z)paramq).ZB())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((com.tencent.mm.plugin.account.friend.a.z)paramq).ZB() == 2) || (((com.tencent.mm.plugin.account.friend.a.z)paramq).ZB() == 19))
        {
          if (this.mZq) {
            ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((com.tencent.mm.plugin.account.friend.a.z)paramq).ZB() == 2)
          {
            Log.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((com.tencent.mm.plugin.account.friend.a.z)paramq).bkW() });
            paramString.putString("setpwd_ticket", ((com.tencent.mm.plugin.account.friend.a.z)paramq).bkW());
          }
          if (((ly)d.c.b(((com.tencent.mm.plugin.account.friend.a.z)paramq).rr.lBS)).RRr != 0) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              paramString.putBoolean("restart_wechat", true);
            }
            j(2, paramString);
            AppMethodBeat.o(131325);
            return;
          }
        }
        j(1, new Bundle());
        AppMethodBeat.o(131325);
        return;
      }
      if (!W(paramInt2, paramString))
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.mContext, null, null);
          AppMethodBeat.o(131325);
          return;
        }
        Toast.makeText(this.mContext, this.mContext.getString(a.g.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(131325);
      return;
    }
    Assert.assertTrue("code path should not be here!", false);
    AppMethodBeat.o(131325);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(131322);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    this.mContext = null;
    this.kUn = true;
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(131322);
  }
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */