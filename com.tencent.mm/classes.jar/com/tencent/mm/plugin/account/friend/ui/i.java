package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.lu;
import com.tencent.mm.autogen.a.lu.b;
import com.tencent.mm.autogen.a.lv;
import com.tencent.mm.autogen.a.lv.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.am.h
{
  private String hRk;
  private boolean nzW;
  public String pPg;
  private MMActivity pVV;
  private final a pVW;
  private com.tencent.mm.plugin.account.friend.model.w pVX;
  private com.tencent.mm.plugin.account.friend.model.w pVY;
  public boolean pVZ;
  private i.b pWa;
  private com.tencent.mm.ui.base.w tipDialog;
  
  public i(i.b paramb, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(304844);
    this.nzW = false;
    this.tipDialog = null;
    this.pVZ = true;
    this.pPg = "";
    this.pWa = paramb;
    this.pVV = paramMMActivity;
    this.pVW = parama;
    ((com.tencent.mm.plugin.account.sdk.b.a)MvvmEventCenter.getEvent(com.tencent.mm.plugin.account.sdk.b.a.class)).observe(this.pVV, new i.1(this));
    AppMethodBeat.o(304844);
  }
  
  private boolean ae(int paramInt, String paramString)
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
      Toast.makeText(this.pVV, a.g.app_err_system_busy_tip, 0).show();
      bool = true;
      continue;
      Toast.makeText(this.pVV, a.g.bind_mcontact_err_freq_limit, 0).show();
      bool = true;
      continue;
      Log.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((i.b.pWc == this.pWa) || (this.pWa == i.b.pWd))
      {
        com.tencent.mm.kernel.h.baE().ban().B(4097, "");
        paramString = (String)com.tencent.mm.kernel.h.baE().ban().d(6, "");
        com.tencent.mm.kernel.h.baE().ban().B(6, this.hRk);
        if (!Util.isNullOrNil(paramString))
        {
          if (com.tencent.mm.kernel.h.baE().ban().get(at.a.acWp, "").equals(paramString)) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWp, z.bAM());
          }
          Iterator localIterator = cj.ono.bDj().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(cj.ono.getString(str, "login_user_name"))) {
              cj.ono.s(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
      }
      k(2, new Bundle());
      Toast.makeText(this.pVV, a.g.bind_mcontact_err_binded, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramString != null)
      {
        if (paramString.hAN != 8) {
          break label423;
        }
        com.tencent.mm.plugin.account.sdk.c.a.b(this.pVV, paramString.url, 100, true);
      }
      for (;;)
      {
        bool = true;
        break;
        label423:
        paramString.a(this.pVV, null, null);
      }
      Toast.makeText(this.pVV, a.g.bind_mcontact_err_format, 0).show();
      bool = true;
      continue;
      k.a(this.pVV, a.g.bind_mcontact_err_binded_by_other, a.g.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = true;
      continue;
      Toast.makeText(this.pVV, a.g.bind_mcontact_err_unbinded_notbinded, 0).show();
      bool = true;
      continue;
      k.a(this.pVV, a.g.bind_mcontact_err_not_suport_country, a.g.app_tip, null);
      bool = true;
      continue;
      bool = false;
      continue;
      k.a(this.pVV, a.g.bind_mcontact_err_BindPhone_NeedAdjust, a.g.app_tip, null);
      bool = true;
    }
  }
  
  private void bXI()
  {
    int i = 1;
    AppMethodBeat.i(131326);
    Log.i("MicroMsg.SmsBindMobileObserver", "sendGetVerifyReq %s policyTicket:%s", new Object[] { this.pWa, this.pPg });
    if ((this.pWa == i.b.pWc) || (this.pWa == i.b.pWd))
    {
      if (this.pWa == i.b.pWd) {
        i = 18;
      }
      this.pVY = new com.tencent.mm.plugin.account.friend.model.w(this.hRk, i, "", 0, "");
      this.pVY.bXg().YOt = this.pPg;
      com.tencent.mm.kernel.h.aZW().a(this.pVY, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void k(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.pWa == i.b.pWc) || (this.pWa == i.b.pWd)) {
      com.tencent.mm.kernel.h.aZW().b(132, this);
    }
    if (!Util.isNullOrNil(this.pPg)) {
      paramBundle.putString("policyTicket", this.pPg);
    }
    if (this.pVW != null) {
      this.pVW.k(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void Tl(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.pWa == i.b.pWc) || (this.pWa == i.b.pWd)) {
      com.tencent.mm.kernel.h.aZW().a(132, this);
    }
    this.hRk = paramString;
    this.nzW = false;
    bXI();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = k.a(this.pVV, this.pVV.getString(a.g.app_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(304842);
        i.b(i.this);
        AppMethodBeat.o(304842);
      }
    });
    AppMethodBeat.o(131321);
  }
  
  public final void o(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(304847);
    if (this.tipDialog != null) {
      this.tipDialog.setCancelable(true);
    }
    Object localObject1;
    Object localObject2;
    if ((this.pWa == i.b.pWc) || (this.pWa == i.b.pWd))
    {
      com.tencent.mm.kernel.h.aZW().a(132, this);
      localObject1 = new lu();
      ((lu)localObject1).hNG.context = this.pVV;
      ((lu)localObject1).publish();
      localObject1 = ((lu)localObject1).hNH.hNI;
      localObject2 = new lv();
      ((lv)localObject2).publish();
      localObject2 = ((lv)localObject2).hNJ.hNK;
      if ((this.pWa != i.b.pWd) || (paramInt == 25)) {
        break label238;
      }
      paramInt = 19;
    }
    label238:
    for (;;)
    {
      this.nzW = false;
      this.pVX = new com.tencent.mm.plugin.account.friend.model.w(this.hRk, paramInt, paramString1, "", paramString2, (String)localObject1, (String)localObject2);
      this.pVX.bXg().YOt = this.pPg;
      com.tencent.mm.kernel.h.aZW().a(this.pVX, 0);
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = k.a(this.pVV, this.pVV.getString(a.g.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(304840);
          i.b(i.this);
          AppMethodBeat.o(304840);
        }
      });
      AppMethodBeat.o(304847);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(131325);
    Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramp != this.pVX) && (paramp != this.pVY))
    {
      Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.nzW)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -445) && (!Util.isNullOrNil(paramString)))
    {
      com.tencent.mm.broadcast.a locala = com.tencent.mm.broadcast.a.CH(paramString);
      if ((locala != null) && (locala.hAN == 9))
      {
        com.tencent.mm.plugin.account.sdk.c.a.b(this.pVV, locala.url, 0, true);
        AppMethodBeat.o(131325);
        return;
      }
    }
    if (((i.b.pWc == this.pWa) || (i.b.pWd == this.pWa)) && (paramp.getType() == 132))
    {
      switch (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 2) || (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 25) || (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 19))
        {
          if (this.pVZ) {
            ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 2)
          {
            Log.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((com.tencent.mm.plugin.account.friend.model.w)paramp).bIQ() });
            paramString.putString("setpwd_ticket", ((com.tencent.mm.plugin.account.friend.model.w)paramp).bIQ());
          }
          if (((mz)c.c.b(((com.tencent.mm.plugin.account.friend.model.w)paramp).rr.otC)).YOJ != 0) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              paramString.putBoolean("restart_wechat", true);
            }
            k(2, paramString);
            AppMethodBeat.o(131325);
            return;
          }
        }
        k(1, new Bundle());
        AppMethodBeat.o(131325);
        return;
      }
      if (ae(paramInt2, paramString))
      {
        if (paramInt2 == -445)
        {
          paramString = new Bundle();
          paramString.putString("setpwd_ticket", ((mz)c.c.b(((com.tencent.mm.plugin.account.friend.model.w)paramp).rr.otC)).YOu);
          k(3, paramString);
        }
        AppMethodBeat.o(131325);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramString != null)
      {
        paramString.a(this.pVV, null, null);
        AppMethodBeat.o(131325);
        return;
      }
      Toast.makeText(this.pVV, this.pVV.getString(a.g.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(131325);
      return;
    }
    Assert.assertTrue("code path should not be here!", false);
    AppMethodBeat.o(131325);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(131322);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    this.pVV = null;
    this.nzW = true;
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(131322);
  }
  
  public static abstract interface a
  {
    public abstract void k(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */