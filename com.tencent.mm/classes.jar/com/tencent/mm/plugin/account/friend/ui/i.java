package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.ak.i
{
  public String dSf;
  public boolean ifz = false;
  private final a khO;
  public com.tencent.mm.plugin.account.friend.a.z khP;
  private com.tencent.mm.plugin.account.friend.a.z khQ;
  public boolean khR = true;
  public b khS;
  public Context mContext;
  public com.tencent.mm.ui.base.q tipDialog = null;
  
  public i(b paramb, Context paramContext, a parama)
  {
    this.khS = paramb;
    this.mContext = paramContext;
    this.khO = parama;
  }
  
  private boolean U(int paramInt, String paramString)
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
      Toast.makeText(this.mContext, 2131755804, 0).show();
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131756598, 0).show();
      bool = true;
      continue;
      Log.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((b.khU == this.khS) || (this.khS == b.khV))
      {
        g.aAh().azQ().set(4097, "");
        paramString = (String)g.aAh().azQ().get(6, "");
        g.aAh().azQ().set(6, this.dSf);
        if (!Util.isNullOrNil(paramString))
        {
          if (g.aAh().azQ().get(ar.a.Ogq, "").equals(paramString)) {
            g.aAh().azQ().set(ar.a.Ogq, com.tencent.mm.model.z.aTY());
          }
          Iterator localIterator = ch.iFO.aWo().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(ch.iFO.getString(str, "login_user_name"))) {
              ch.iFO.l(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
      }
      h(2, new Bundle());
      Toast.makeText(this.mContext, 2131756595, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if (paramString != null) {
        paramString.a(this.mContext, null, null);
      }
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131756597, 0).show();
      bool = true;
      continue;
      h.a(this.mContext, 2131756596, 2131756650, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131756600, 0).show();
      bool = true;
      continue;
      h.a(this.mContext, 2131756599, 2131755998, null);
      bool = true;
      continue;
      bool = false;
      continue;
      h.a(this.mContext, 2131756594, 2131755998, null);
      bool = true;
    }
  }
  
  private void boL()
  {
    AppMethodBeat.i(131326);
    if ((this.khS == b.khU) || (this.khS == b.khV))
    {
      int i = 1;
      if (this.khS == b.khV) {
        i = 18;
      }
      this.khQ = new com.tencent.mm.plugin.account.friend.a.z(this.dSf, i, "", 0, "");
      g.azz().a(this.khQ, 0);
    }
    AppMethodBeat.o(131326);
  }
  
  private void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(131324);
    if ((this.khS == b.khU) || (this.khS == b.khV)) {
      g.azz().b(132, this);
    }
    if (this.khO != null) {
      this.khO.h(paramInt, paramBundle);
    }
    AppMethodBeat.o(131324);
  }
  
  public final void Tm(String paramString)
  {
    AppMethodBeat.i(131321);
    if ((this.khS == b.khU) || (this.khS == b.khV)) {
      g.azz().a(132, this);
    }
    this.dSf = paramString;
    this.ifz = false;
    boL();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = h.a(this.mContext, this.mContext.getString(2131755978), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        i.this.ifz = true;
      }
    });
    AppMethodBeat.o(131321);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(131325);
    Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramq != this.khP) && (paramq != this.khQ))
    {
      Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(131325);
      return;
    }
    if (this.ifz)
    {
      AppMethodBeat.o(131325);
      return;
    }
    if (((b.khU == this.khS) || (b.khV == this.khS)) && (paramq.getType() == 132))
    {
      switch (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj())
      {
      default: 
        AppMethodBeat.o(131325);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() == 2) || (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() == 19))
        {
          if (this.khR) {
            ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() == 2)
          {
            Log.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((com.tencent.mm.plugin.account.friend.a.z)paramq).bbG() });
            paramString.putString("setpwd_ticket", ((com.tencent.mm.plugin.account.friend.a.z)paramq).bbG());
          }
          if (((mi)((com.tencent.mm.plugin.account.friend.a.z)paramq).rr.iLL.iLR).KQt != 0) {}
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
      if (!U(paramInt2, paramString))
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.mContext, null, null);
          AppMethodBeat.o(131325);
          return;
        }
        Toast.makeText(this.mContext, this.mContext.getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    g.azz().b(132, this);
    this.mContext = null;
    this.ifz = true;
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
      khU = new b("BINDMOBILE", 0);
      khV = new b("CHANGEMOBILE", 1);
      khW = new b[] { khU, khV };
      AppMethodBeat.o(131320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */