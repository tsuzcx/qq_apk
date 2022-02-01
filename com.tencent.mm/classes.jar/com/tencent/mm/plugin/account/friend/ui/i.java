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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements f
{
  public String dzn;
  public boolean hjP = false;
  private final a jgT;
  public z jgU;
  private z jgV;
  public boolean jgW = true;
  public i.b jgX;
  public Context mContext;
  public p tipDialog = null;
  
  public i(i.b paramb, Context paramContext, a parama)
  {
    this.jgX = paramb;
    this.mContext = paramContext;
    this.jgT = parama;
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
      ad.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((i.b.jgZ == this.jgX) || (this.jgX == i.b.jha))
      {
        g.ajC().ajl().set(4097, "");
        paramString = (String)g.ajC().ajl().get(6, "");
        g.ajC().ajl().set(6, this.dzn);
        if (!bt.isNullOrNil(paramString))
        {
          if (g.ajC().ajl().get(al.a.IDt, "").equals(paramString)) {
            g.ajC().ajl().set(al.a.IDt, u.aAm());
          }
          Iterator localIterator = cb.hIi.aCA().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(cb.hIi.getString(str, "login_user_name"))) {
              cb.hIi.l(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
      }
      i(2, new Bundle());
      Toast.makeText(this.mContext, 2131756459, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.uz(paramString);
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
  
  private void aTA()
  {
    AppMethodBeat.i(131326);
    if ((this.jgX == i.b.jgZ) || (this.jgX == i.b.jha))
    {
      int i = 1;
      if (this.jgX == i.b.jha) {
        i = 18;
      }
      this.jgV = new z(this.dzn, i, "", 0, "");
      g.aiU().a(this.jgV, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.jgX == i.b.jgZ) || (this.jgX == i.b.jha)) {
      g.aiU().b(132, this);
    }
    if (this.jgT != null) {
      this.jgT.i(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.jgX == i.b.jgZ) || (this.jgX == i.b.jha)) {
      g.aiU().a(132, this);
    }
    this.dzn = paramString;
    this.hjP = false;
    aTA();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = h.b(this.mContext, this.mContext.getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        i.this.hjP = true;
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
    if ((paramn != this.jgU) && (paramn != this.jgV))
    {
      ad.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.hjP)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if (((i.b.jgZ == this.jgX) || (i.b.jha == this.jgX)) && (paramn.getType() == 132))
    {
      switch (((z)paramn).KR())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((z)paramn).KR() == 2) || (((z)paramn).KR() == 19))
        {
          if (this.jgW) {
            ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((z)paramn).KR() == 2)
          {
            ad.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((z)paramn).aHw() });
            paramString.putString("setpwd_ticket", ((z)paramn).aHw());
          }
          if (((lr)((z)paramn).rr.hNL.hNQ).FEm != 0) {}
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
        paramString = com.tencent.mm.h.a.uz(paramString);
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
    g.aiU().b(132, this);
    this.mContext = null;
    this.hjP = true;
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