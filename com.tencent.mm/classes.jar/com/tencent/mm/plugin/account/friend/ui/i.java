package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class i
  implements f
{
  public String czF;
  public boolean eUJ = false;
  private final i.a gAr;
  public x gAs;
  private x gAt;
  public boolean gAu = true;
  public i.b gAv;
  public Context mContext;
  public com.tencent.mm.ui.base.p tipDialog = null;
  
  public i(i.b paramb, Context paramContext, i.a parama)
  {
    this.gAv = paramb;
    this.mContext = paramContext;
    this.gAr = parama;
  }
  
  private boolean F(int paramInt, String paramString)
  {
    AppMethodBeat.i(108663);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(108663);
      return bool;
      Toast.makeText(this.mContext, 2131296926, 0).show();
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131297570, 0).show();
      bool = true;
      continue;
      ab.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      if ((i.b.gAx == this.gAv) || (this.gAv == i.b.gAy))
      {
        g.RL().Ru().set(4097, "");
        paramString = (String)g.RL().Ru().get(6, "");
        g.RL().Ru().set(6, this.czF);
        if (!bo.isNullOrNil(paramString))
        {
          if (g.RL().Ru().get(ac.a.yJS, "").equals(paramString)) {
            g.RL().Ru().set(ac.a.yJS, r.Zn());
          }
          Iterator localIterator = bx.fnO.abf().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramString.equals(bx.fnO.getString(str, "login_user_name"))) {
              bx.fnO.n(str, "login_user_name", str);
            }
          }
        }
        ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
      }
      g(2, new Bundle());
      Toast.makeText(this.mContext, 2131297567, 0).show();
      bool = true;
      continue;
      paramString = com.tencent.mm.h.a.kO(paramString);
      if (paramString != null) {
        paramString.a(this.mContext, null, null);
      }
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131297569, 0).show();
      bool = true;
      continue;
      h.a(this.mContext, 2131297568, 2131297621, new i.3(this));
      bool = true;
      continue;
      Toast.makeText(this.mContext, 2131297572, 0).show();
      bool = true;
      continue;
      h.a(this.mContext, 2131297571, 2131297087, null);
      bool = true;
      continue;
      bool = false;
      continue;
      h.a(this.mContext, 2131297566, 2131297087, null);
      bool = true;
    }
  }
  
  private void aqX()
  {
    AppMethodBeat.i(108666);
    if ((this.gAv == i.b.gAx) || (this.gAv == i.b.gAy))
    {
      int i = 1;
      if (this.gAv == i.b.gAy) {
        i = 18;
      }
      this.gAt = new x(this.czF, i, "", 0, "");
      g.Rc().a(this.gAt, 0);
    }
    AppMethodBeat.o(108666);
  }
  
  private void g(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(108664);
    if ((this.gAv == i.b.gAx) || (this.gAv == i.b.gAy)) {
      g.Rc().b(132, this);
    }
    if (this.gAr != null) {
      this.gAr.g(paramInt, paramBundle);
    }
    AppMethodBeat.o(108664);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108665);
    ab.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramm != this.gAs) && (paramm != this.gAt))
    {
      ab.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      AppMethodBeat.o(108665);
      return;
    }
    if (this.eUJ)
    {
      AppMethodBeat.o(108665);
      return;
    }
    if (((i.b.gAx == this.gAv) || (i.b.gAy == this.gAv)) && (paramm.getType() == 132))
    {
      switch (((x)paramm).Ac())
      {
      default: 
        AppMethodBeat.o(108665);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((x)paramm).Ac() == 2) || (((x)paramm).Ac() == 19))
        {
          if (this.gAu) {
            ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Bundle();
          if (((x)paramm).Ac() == 2)
          {
            ab.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((x)paramm).agx() });
            paramString.putString("setpwd_ticket", ((x)paramm).agx());
          }
          if (((jt)((x)paramm).rr.fsW.fta).wwh != 0) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              paramString.putBoolean("restart_wechat", true);
            }
            g(2, paramString);
            AppMethodBeat.o(108665);
            return;
          }
        }
        g(1, new Bundle());
        AppMethodBeat.o(108665);
        return;
      }
      if (!F(paramInt2, paramString))
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.mContext, null, null);
          AppMethodBeat.o(108665);
          return;
        }
        Toast.makeText(this.mContext, this.mContext.getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(108665);
      return;
    }
    Assert.assertTrue("code path should not be here!", false);
    AppMethodBeat.o(108665);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(108662);
    g.Rc().b(132, this);
    this.mContext = null;
    this.eUJ = true;
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(108662);
  }
  
  public final void xr(String paramString)
  {
    AppMethodBeat.i(108661);
    if ((this.gAv == i.b.gAx) || (this.gAv == i.b.gAy)) {
      g.Rc().a(132, this);
    }
    this.czF = paramString;
    this.eUJ = false;
    aqX();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.tipDialog = h.b(this.mContext, this.mContext.getString(2131297069), true, new i.1(this));
    AppMethodBeat.o(108661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */