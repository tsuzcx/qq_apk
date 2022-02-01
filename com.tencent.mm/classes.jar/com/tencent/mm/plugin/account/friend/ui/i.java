package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.al.g
{
  public String dpO;
  public boolean gqP = false;
  private final a inE;
  public z inF;
  private z inG;
  public boolean inH = true;
  public b inI;
  public Context mContext;
  public p tipDialog = null;
  
  public i(b paramb, Context paramContext, a parama)
  {
    this.inI = paramb;
    this.mContext = paramContext;
    this.inE = parama;
  }
  
  private boolean O(int paramInt, String paramString)
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
      ad.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((b.inK == this.inI) || (this.inI == b.inL))
      {
        com.tencent.mm.kernel.g.afB().afk().set(4097, "");
        paramString = (String)com.tencent.mm.kernel.g.afB().afk().get(6, "");
        com.tencent.mm.kernel.g.afB().afk().set(6, this.dpO);
        if (!bt.isNullOrNil(paramString))
        {
          if (com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftd, "").equals(paramString)) {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftd, u.aqG());
          }
          Iterator localIterator = ca.gPq.asG().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(ca.gPq.getString(str, "login_user_name"))) {
              ca.gPq.m(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
      }
      h(2, new Bundle());
      Toast.makeText(this.mContext, 2131756459, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.oG(paramString);
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
  
  private void aJx()
  {
    AppMethodBeat.i(131326);
    if ((this.inI == b.inK) || (this.inI == b.inL))
    {
      int i = 1;
      if (this.inI == b.inL) {
        i = 18;
      }
      this.inG = new z(this.dpO, i, "", 0, "");
      com.tencent.mm.kernel.g.aeS().a(this.inG, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.inI == b.inK) || (this.inI == b.inL)) {
      com.tencent.mm.kernel.g.aeS().b(132, this);
    }
    if (this.inE != null) {
      this.inE.h(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void Cx(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.inI == b.inK) || (this.inI == b.inL)) {
      com.tencent.mm.kernel.g.aeS().a(132, this);
    }
    this.dpO = paramString;
    this.gqP = false;
    aJx();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = h.b(this.mContext, this.mContext.getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        i.this.gqP = true;
      }
    });
    AppMethodBeat.o(131321);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131325);
    ad.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramn != this.inF) && (paramn != this.inG))
    {
      ad.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.gqP)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if (((b.inK == this.inI) || (b.inL == this.inI)) && (paramn.getType() == 132))
    {
      switch (((z)paramn).JJ())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((z)paramn).JJ() == 2) || (((z)paramn).JJ() == 19))
        {
          if (this.inH) {
            ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((z)paramn).JJ() == 2)
          {
            ad.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((z)paramn).axz() });
            paramString.putString("setpwd_ticket", ((z)paramn).axz());
          }
          if (((lb)((z)paramn).rr.gUT.gUX).CGq != 0) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              paramString.putBoolean("restart_wechat", true);
            }
            h(2, paramString);
            AppMethodBeat.o(131325);
            return;
          }
        }
        h(1, new Bundle());
        AppMethodBeat.o(131325);
        return;
      }
      if (!O(paramInt2, paramString))
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
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
    com.tencent.mm.kernel.g.aeS().b(132, this);
    this.mContext = null;
    this.gqP = true;
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(131322);
  }
  
  public static abstract interface a
  {
    public abstract void h(int paramInt, Bundle paramBundle);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(131320);
      inK = new b("BINDMOBILE", 0);
      inL = new b("CHANGEMOBILE", 1);
      inM = new b[] { inK, inL };
      AppMethodBeat.o(131320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */