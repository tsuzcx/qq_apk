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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements f
{
  public String dAs;
  public boolean hmD = false;
  private final a jjM;
  public z jjN;
  private z jjO;
  public boolean jjP = true;
  public i.b jjQ;
  public Context mContext;
  public p tipDialog = null;
  
  public i(i.b paramb, Context paramContext, a parama)
  {
    this.jjQ = paramb;
    this.mContext = paramContext;
    this.jjM = parama;
  }
  
  private boolean R(int paramInt, String paramString)
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
      ae.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((i.b.jjS == this.jjQ) || (this.jjQ == i.b.jjT))
      {
        g.ajR().ajA().set(4097, "");
        paramString = (String)g.ajR().ajA().get(6, "");
        g.ajR().ajA().set(6, this.dAs);
        if (!bu.isNullOrNil(paramString))
        {
          if (g.ajR().ajA().get(am.a.IXT, "").equals(paramString)) {
            g.ajR().ajA().set(am.a.IXT, v.aAC());
          }
          Iterator localIterator = cd.hLa.aCQ().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(cd.hLa.getString(str, "login_user_name"))) {
              cd.hLa.l(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
      }
      i(2, new Bundle());
      Toast.makeText(this.mContext, 2131756459, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.uU(paramString);
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
  
  private void aTZ()
  {
    AppMethodBeat.i(131326);
    if ((this.jjQ == i.b.jjS) || (this.jjQ == i.b.jjT))
    {
      int i = 1;
      if (this.jjQ == i.b.jjT) {
        i = 18;
      }
      this.jjO = new z(this.dAs, i, "", 0, "");
      g.ajj().a(this.jjO, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.jjQ == i.b.jjS) || (this.jjQ == i.b.jjT)) {
      g.ajj().b(132, this);
    }
    if (this.jjM != null) {
      this.jjM.i(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void Ko(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.jjQ == i.b.jjS) || (this.jjQ == i.b.jjT)) {
      g.ajj().a(132, this);
    }
    this.dAs = paramString;
    this.hmD = false;
    aTZ();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = h.b(this.mContext, this.mContext.getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        i.this.hmD = true;
      }
    });
    AppMethodBeat.o(131321);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131325);
    ae.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramn != this.jjN) && (paramn != this.jjO))
    {
      ae.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.hmD)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if (((i.b.jjS == this.jjQ) || (i.b.jjT == this.jjQ)) && (paramn.getType() == 132))
    {
      switch (((z)paramn).KZ())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((z)paramn).KZ() == 2) || (((z)paramn).KZ() == 19))
        {
          if (this.jjP) {
            ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((z)paramn).KZ() == 2)
          {
            ae.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((z)paramn).aHN() });
            paramString.putString("setpwd_ticket", ((z)paramn).aHN());
          }
          if (((lr)((z)paramn).rr.hQE.hQJ).FWH != 0) {}
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
      if (!R(paramInt2, paramString))
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
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
    g.ajj().b(132, this);
    this.mContext = null;
    this.hmD = true;
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