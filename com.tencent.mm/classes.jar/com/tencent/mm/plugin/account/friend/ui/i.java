package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.ak.g
{
  public String dnz;
  public boolean gRx = false;
  private final a iNK;
  public z iNL;
  private z iNM;
  public boolean iNN = true;
  public i.b iNO;
  public Context mContext;
  public p tipDialog = null;
  
  public i(i.b paramb, Context paramContext, a parama)
  {
    this.iNO = paramb;
    this.mContext = paramContext;
    this.iNK = parama;
  }
  
  private boolean P(int paramInt, String paramString)
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
      Toast.makeText(this.mContext, 2131755733, 0).show();
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131756462, 0).show();
      bool = true;
      continue;
      ac.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((i.b.iNQ == this.iNO) || (this.iNO == i.b.iNR))
      {
        com.tencent.mm.kernel.g.agR().agA().set(4097, "");
        paramString = (String)com.tencent.mm.kernel.g.agR().agA().get(6, "");
        com.tencent.mm.kernel.g.agR().agA().set(6, this.dnz);
        if (!bs.isNullOrNil(paramString))
        {
          if (com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQW, "").equals(paramString)) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQW, u.axw());
          }
          Iterator localIterator = ca.hpQ.azx().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(ca.hpQ.getString(str, "login_user_name"))) {
              ca.hpQ.m(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
      }
      i(2, new Bundle());
      Toast.makeText(this.mContext, 2131756459, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.rM(paramString);
      if (paramString != null) {
        paramString.a(this.mContext, null, null);
      }
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131756461, 0).show();
      bool = true;
      continue;
      h.a(this.mContext, 2131756460, 2131756514, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131756464, 0).show();
      bool = true;
      continue;
      h.a(this.mContext, 2131756463, 2131755906, null);
      bool = true;
      continue;
      bool = false;
      continue;
      h.a(this.mContext, 2131756458, 2131755906, null);
      bool = true;
    }
  }
  
  private void aQo()
  {
    AppMethodBeat.i(131326);
    if ((this.iNO == i.b.iNQ) || (this.iNO == i.b.iNR))
    {
      int i = 1;
      if (this.iNO == i.b.iNR) {
        i = 18;
      }
      this.iNM = new z(this.dnz, i, "", 0, "");
      com.tencent.mm.kernel.g.agi().a(this.iNM, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.iNO == i.b.iNQ) || (this.iNO == i.b.iNR)) {
      com.tencent.mm.kernel.g.agi().b(132, this);
    }
    if (this.iNK != null) {
      this.iNK.i(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void GA(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.iNO == i.b.iNQ) || (this.iNO == i.b.iNR)) {
      com.tencent.mm.kernel.g.agi().a(132, this);
    }
    this.dnz = paramString;
    this.gRx = false;
    aQo();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = h.b(this.mContext, this.mContext.getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        i.this.gRx = true;
      }
    });
    AppMethodBeat.o(131321);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131325);
    ac.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramn != this.iNL) && (paramn != this.iNM))
    {
      ac.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.gRx)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if (((i.b.iNQ == this.iNO) || (i.b.iNR == this.iNO)) && (paramn.getType() == 132))
    {
      switch (((z)paramn).Js())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((z)paramn).Js() == 2) || (((z)paramn).Js() == 19))
        {
          if (this.iNN) {
            ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((z)paramn).Js() == 2)
          {
            ac.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((z)paramn).aEr() });
            paramString.putString("setpwd_ticket", ((z)paramn).aEr());
          }
          if (((lh)((z)paramn).rr.hvs.hvw).DYQ != 0) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              paramString.putBoolean("restart_wechat", true);
            }
            i(2, paramString);
            AppMethodBeat.o(131325);
            return;
          }
        }
        i(1, new Bundle());
        AppMethodBeat.o(131325);
        return;
      }
      if (!P(paramInt2, paramString))
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this.mContext, null, null);
          AppMethodBeat.o(131325);
          return;
        }
        Toast.makeText(this.mContext, this.mContext.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    com.tencent.mm.kernel.g.agi().b(132, this);
    this.mContext = null;
    this.gRx = true;
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(131322);
  }
  
  public static abstract interface a
  {
    public abstract void i(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */