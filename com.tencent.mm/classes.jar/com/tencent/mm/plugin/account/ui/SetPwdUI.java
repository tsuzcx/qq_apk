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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.account.sdk.c.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.fai;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;

public abstract class SetPwdUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public boolean dqR = true;
  protected ProgressDialog lzP = null;
  protected String qgY;
  protected String qgZ;
  
  protected ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return k.a(paramContext, paramString2, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected abstract String bYA();
  
  protected int bYB()
  {
    return 383;
  }
  
  protected void bYK()
  {
    bYZ();
  }
  
  public boolean bYL()
  {
    return false;
  }
  
  protected final void bYZ()
  {
    this.qgY = bYz();
    this.qgZ = bYA();
    if (Util.isNullOrNil(this.qgY)) {}
    do
    {
      return;
      if (!this.qgY.equals(this.qgZ))
      {
        a(a.a.pXG);
        return;
      }
      if (this.qgY.length() > 16)
      {
        a(a.a.pXH);
        return;
      }
      if (Util.isChinese(this.qgY))
      {
        k.s(this, r.j.regbyfacebook_reg_setpwd_alert_using_chinese, r.j.regbymobile_reg_setpwd_alert_title);
        return;
      }
      if (!Util.isValidPassword(this.qgY))
      {
        if ((this.qgY.length() >= 8) && (this.qgY.length() < 16))
        {
          a(a.a.pXJ);
          return;
        }
        a(a.a.pXI);
        return;
      }
      hideVKB();
      final p localp = bYy();
      com.tencent.mm.kernel.h.aZW().a(localp, 0);
      this.lzP = a(this, getString(r.j.app_tip), getString(r.j.reg_processing), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.h.aZW().a(localp);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!bYL()) || (this.dqR));
    Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.OAn.b(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected abstract p bYy();
  
  protected abstract String bYz();
  
  public void onBackPressed()
  {
    if (this.dqR)
    {
      if (bYL())
      {
        Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.OAn.b(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.h.aZW().a(bYB(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(r.j.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.bYK();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, y.b.adEJ);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.bYL()) && (paramAnonymousMenuItem.dqR))
        {
          Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.h.OAn.b(11868, new Object[] { Integer.valueOf(1) });
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
    com.tencent.mm.kernel.h.aZW().b(bYB(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, p paramp)
  {
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (paramp.getType() != bYB()) {}
    label289:
    do
    {
      do
      {
        return;
        if (paramp.getType() != 383) {
          break;
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      String str;
      if (Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().d(6, null)))
      {
        Log.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(r.j.no_mobile_setpwd_success_tip);
        paramp = (ab)paramp;
        if ((paramp.rr == null) || (c.c.b(paramp.rr.otC) == null)) {
          break label289;
        }
      }
      for (paramp = (fai)c.c.b(paramp.rr.otC);; paramp = null)
      {
        if ((paramp != null) && (paramp.YJj != null))
        {
          paramp = paramp.YJj.aaxD.toByteArray();
          SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aQe()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.Yxh);
          localEditor.putString("_auth_key", Util.encodeHexString(paramp));
          com.tencent.mm.kernel.h.baC();
          localEditor.putInt("_auth_uin", com.tencent.mm.kernel.b.getUin());
          localEditor.commit();
        }
        k.a(this, str, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128731);
            SetPwdUI.this.setResult(-1);
            if (SetPwdUI.this.q(paramInt1, paramInt2, paramString))
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
    } while (q(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(r.j.fmt_set_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final boolean p(int paramInt1, int paramInt2, String paramString)
  {
    return a.pFo.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean q(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */