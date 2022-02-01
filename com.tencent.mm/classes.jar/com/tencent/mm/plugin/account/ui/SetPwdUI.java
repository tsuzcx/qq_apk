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
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.account.sdk.b.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;

public abstract class SetPwdUI
  extends MMActivity
  implements i
{
  public boolean bxO = true;
  protected ProgressDialog iXX = null;
  protected String njK;
  protected String njL;
  
  protected ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return com.tencent.mm.ui.base.h.a(paramContext, paramString2, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected final void bAh()
  {
    this.njK = bzK();
    this.njL = bzL();
    if (Util.isNullOrNil(this.njK)) {}
    do
    {
      return;
      if (!this.njK.equals(this.njL))
      {
        a(a.a.nay);
        return;
      }
      if (this.njK.length() > 16)
      {
        a(a.a.naz);
        return;
      }
      if (Util.isChinese(this.njK))
      {
        com.tencent.mm.ui.base.h.p(this, r.j.regbyfacebook_reg_setpwd_alert_using_chinese, r.j.regbymobile_reg_setpwd_alert_title);
        return;
      }
      if (!Util.isValidPassword(this.njK))
      {
        if ((this.njK.length() >= 8) && (this.njK.length() < 16))
        {
          a(a.a.naB);
          return;
        }
        a(a.a.naA);
        return;
      }
      hideVKB();
      final q localq = bzJ();
      com.tencent.mm.kernel.h.aGY().a(localq, 0);
      this.iXX = a(this, getString(r.j.app_tip), getString(r.j.reg_processing), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.h.aGY().a(localq);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!bzT()) || (this.bxO));
    Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.IzE.a(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected abstract q bzJ();
  
  protected abstract String bzK();
  
  protected abstract String bzL();
  
  protected int bzM()
  {
    return 383;
  }
  
  protected void bzS()
  {
    bAh();
  }
  
  public boolean bzT()
  {
    return false;
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    return a.mIH.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean o(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.bxO)
    {
      if (bzT())
      {
        Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.IzE.a(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.h.aGY().a(bzM(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(r.j.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.bzS();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, w.b.Wao);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.bzT()) && (paramAnonymousMenuItem.bxO))
        {
          Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.h.IzE.a(11868, new Object[] { Integer.valueOf(1) });
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
    com.tencent.mm.kernel.h.aGY().b(bzM(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, q paramq)
  {
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (paramq.getType() != bzM()) {}
    label290:
    do
    {
      do
      {
        return;
        if (paramq.getType() != 383) {
          break;
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      String str;
      if (Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null)))
      {
        Log.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(r.j.no_mobile_setpwd_success_tip);
        paramq = (aa)paramq;
        if ((paramq.rr == null) || (d.c.b(paramq.rr.lBS) == null)) {
          break label290;
        }
      }
      for (paramq = (egn)d.c.b(paramq.rr.lBS);; paramq = null)
      {
        if ((paramq != null) && (paramq.RLV != null))
        {
          paramq = paramq.RLV.Tkb.toByteArray();
          SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.avK()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", com.tencent.mm.protocal.d.RAD);
          localEditor.putString("_auth_key", Util.encodeHexString(paramq));
          com.tencent.mm.kernel.h.aHE();
          localEditor.putInt("_auth_uin", com.tencent.mm.kernel.b.getUin());
          localEditor.commit();
        }
        com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener()
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
        Log.i("MicroMsg.SetPwdUI", "has bind mobile");
        str = getString(r.j.bind_mobile_setpwd_success_tip);
        break;
      }
    } while (o(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(r.j.fmt_set_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */