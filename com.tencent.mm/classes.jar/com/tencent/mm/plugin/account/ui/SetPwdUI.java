package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;

public abstract class SetPwdUI
  extends MMActivity
  implements f
{
  protected ProgressDialog fMu = null;
  protected String jqT;
  protected String jqU;
  public boolean ov = true;
  
  protected ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected final void aUK()
  {
    this.jqT = aUm();
    this.jqU = aUn();
    if (bt.isNullOrNil(this.jqT)) {}
    do
    {
      return;
      if (!this.jqT.equals(this.jqU))
      {
        a(a.a.jhM);
        return;
      }
      if (this.jqT.length() > 16)
      {
        a(a.a.jhN);
        return;
      }
      if (bt.aQP(this.jqT))
      {
        h.l(this, 2131762309, 2131762346);
        return;
      }
      if (!bt.aQU(this.jqT))
      {
        if ((this.jqT.length() >= 8) && (this.jqT.length() < 16))
        {
          a(a.a.jhP);
          return;
        }
        a(a.a.jhO);
        return;
      }
      hideVKB();
      final n localn = aUl();
      com.tencent.mm.kernel.g.aiU().a(localn, 0);
      getString(2131755906);
      this.fMu = a(this, getString(2131762273), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.g.aiU().a(localn);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!aUw()) || (this.ov));
    ad.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.g.yhR.f(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected abstract n aUl();
  
  protected abstract String aUm();
  
  protected abstract String aUn();
  
  protected int aUo()
  {
    return 383;
  }
  
  protected void aUv()
  {
    aUK();
  }
  
  public boolean aUw()
  {
    return false;
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.iRH.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean o(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.ov)
    {
      if (aUw())
      {
        ad.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.g.yhR.f(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.g.aiU().a(aUo(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.aUv();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, s.b.JbS);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.aUw()) && (paramAnonymousMenuItem.ov))
        {
          ad.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.g.yhR.f(11868, new Object[] { Integer.valueOf(1) });
        }
        paramAnonymousMenuItem.hideVKB();
        paramAnonymousMenuItem.setResult(0);
        paramAnonymousMenuItem.finish();
        AppMethodBeat.o(128730);
        return true;
      }
    });
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.aiU().b(aUo(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (paramn.getType() != aUo()) {}
    label288:
    do
    {
      do
      {
        return;
        if (paramn.getType() != 383) {
          break;
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      String str;
      if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(6, null)))
      {
        ad.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(2131761625);
        paramn = (z)paramn;
        if ((paramn.rr == null) || (paramn.rr.hNL.hNQ == null)) {
          break label288;
        }
      }
      for (paramn = (dcp)paramn.rr.hNL.hNQ;; paramn = null)
      {
        if ((paramn != null) && (paramn.FyU != null))
        {
          paramn = paramn.FyU.getBuffer().toByteArray();
          SharedPreferences.Editor localEditor = aj.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.abm()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.Fnj);
          localEditor.putString("_auth_key", bt.cE(paramn));
          com.tencent.mm.kernel.g.ajA();
          localEditor.putInt("_auth_uin", com.tencent.mm.kernel.a.getUin());
          localEditor.commit();
        }
        h.a(this, str, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128731);
            SetPwdUI.this.setResult(-1);
            if (SetPwdUI.this.o(paramInt1, paramInt2, paramString))
            {
              AppMethodBeat.o(128731);
              return;
            }
            AppMethodBeat.o(128731);
          }
        });
        return;
        ad.i("MicroMsg.SetPwdUI", "has bind mobile");
        str = getString(2131756527);
        break;
      }
    } while (o(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(2131759567, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */