package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bqv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;

public abstract class SetPwdUI
  extends MMActivity
  implements f
{
  protected ProgressDialog dnm = null;
  public boolean fsA = true;
  protected String fsy;
  protected String fsz;
  
  protected abstract m XZ();
  
  protected abstract String Ya();
  
  protected abstract String Yb();
  
  protected int Yc()
  {
    return 383;
  }
  
  protected void Yg()
  {
    Yu();
  }
  
  public boolean Yh()
  {
    return false;
  }
  
  protected final void Yu()
  {
    this.fsy = Ya();
    this.fsz = Yb();
    if (bk.bl(this.fsy)) {}
    do
    {
      return;
      if (!this.fsy.equals(this.fsz))
      {
        a(a.a.fjM);
        return;
      }
      if (this.fsy.length() > 16)
      {
        a(a.a.fjN);
        return;
      }
      if (bk.Zz(this.fsy))
      {
        com.tencent.mm.ui.base.h.h(this, q.j.regbyfacebook_reg_setpwd_alert_using_chinese, q.j.regbymobile_reg_setpwd_alert_title);
        return;
      }
      if (!bk.ZE(this.fsy))
      {
        if ((this.fsy.length() >= 8) && (this.fsy.length() < 16))
        {
          a(a.a.fjP);
          return;
        }
        a(a.a.fjO);
        return;
      }
      XM();
      m localm = XZ();
      g.Dk().a(localm, 0);
      getString(q.j.app_tip);
      this.dnm = a(this, getString(q.j.reg_processing), new SetPwdUI.1(this, localm));
    } while ((!Yh()) || (this.fsA));
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.nFQ.f(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected final boolean h(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean i(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.fsA)
    {
      if (Yh())
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.nFQ.f(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    g.Dk().a(Yc(), this);
    super.onCreate(paramBundle);
    a(0, getString(q.j.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SetPwdUI.this.Yg();
        return true;
      }
    }, s.b.uNx);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.Yh()) && (paramAnonymousMenuItem.fsA))
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.h.nFQ.f(11868, new Object[] { Integer.valueOf(1) });
        }
        paramAnonymousMenuItem.XM();
        paramAnonymousMenuItem.setResult(0);
        paramAnonymousMenuItem.finish();
        return true;
      }
    });
  }
  
  public void onDestroy()
  {
    g.Dk().b(Yc(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, m paramm)
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (paramm.getType() != Yc()) {}
    label288:
    do
    {
      do
      {
        return;
        if (paramm.getType() != 383) {
          break;
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      String str;
      if (bk.bl((String)g.DP().Dz().get(6, null)))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(q.j.no_mobile_setpwd_success_tip);
        paramm = (com.tencent.mm.modelsimple.y)paramm;
        if ((paramm.dmK == null) || (paramm.dmK.ecF.ecN == null)) {
          break label288;
        }
      }
      for (paramm = (bqv)paramm.dmK.ecF.ecN;; paramm = null)
      {
        if ((paramm != null) && (paramm.syi != null))
        {
          paramm = paramm.syi.tFM.toByteArray();
          SharedPreferences.Editor localEditor = ae.getContext().getSharedPreferences("auth_info_key_prefs", 4).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.spa);
          localEditor.putString("_auth_key", bk.bG(paramm));
          g.DN();
          localEditor.putInt("_auth_uin", com.tencent.mm.kernel.a.CK());
          localEditor.commit();
        }
        com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            SetPwdUI.this.setResult(-1);
            if (SetPwdUI.this.i(paramInt1, paramInt2, paramString)) {}
          }
        });
        return;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SetPwdUI", "has bind mobile");
        str = getString(q.j.bind_mobile_setpwd_success_tip);
        break;
      }
    } while (i(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(q.j.fmt_set_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */