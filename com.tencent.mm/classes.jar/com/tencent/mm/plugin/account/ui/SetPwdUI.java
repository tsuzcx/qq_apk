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
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public abstract class SetPwdUI
  extends MMActivity
  implements f
{
  protected ProgressDialog eeN = null;
  protected String gKa;
  protected String gKb;
  public boolean gKc = true;
  
  protected ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected abstract com.tencent.mm.ai.m arI();
  
  protected abstract String arJ();
  
  protected abstract String arK();
  
  protected int arL()
  {
    return 383;
  }
  
  protected void arP()
  {
    ase();
  }
  
  public boolean arQ()
  {
    return false;
  }
  
  protected final void ase()
  {
    this.gKa = arJ();
    this.gKb = arK();
    if (bo.isNullOrNil(this.gKa)) {}
    do
    {
      return;
      if (!this.gKa.equals(this.gKb))
      {
        a(a.a.gBd);
        return;
      }
      if (this.gKa.length() > 16)
      {
        a(a.a.gBe);
        return;
      }
      if (bo.apE(this.gKa))
      {
        com.tencent.mm.ui.base.h.h(this, 2131302412, 2131302443);
        return;
      }
      if (!bo.apJ(this.gKa))
      {
        if ((this.gKa.length() >= 8) && (this.gKa.length() < 16))
        {
          a(a.a.gBg);
          return;
        }
        a(a.a.gBf);
        return;
      }
      hideVKB();
      com.tencent.mm.ai.m localm = arI();
      g.Rc().a(localm, 0);
      getString(2131297087);
      this.eeN = a(this, getString(2131302376), new SetPwdUI.1(this, localm));
    } while ((!arQ()) || (this.gKc));
    ab.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.qsU.e(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected final boolean l(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean m(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.gKc)
    {
      if (arQ())
      {
        ab.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.qsU.e(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    g.Rc().a(arL(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(2131296964), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125567);
        SetPwdUI.this.arP();
        AppMethodBeat.o(125567);
        return true;
      }
    }, null, q.b.zby);
    setBackBtn(new SetPwdUI.3(this));
  }
  
  public void onDestroy()
  {
    g.Rc().b(arL(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (paramm.getType() != arL()) {}
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
      if (bo.isNullOrNil((String)g.RL().Ru().get(6, null)))
      {
        ab.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(2131301865);
        paramm = (com.tencent.mm.modelsimple.z)paramm;
        if ((paramm.rr == null) || (paramm.rr.fsW.fta == null)) {
          break label288;
        }
      }
      for (paramm = (cbd)paramm.rr.fsW.fta;; paramm = null)
      {
        if ((paramm != null) && (paramm.wrL != null))
        {
          paramm = paramm.wrL.getBuffer().toByteArray();
          SharedPreferences.Editor localEditor = ah.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.h.Mp()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.whH);
          localEditor.putString("_auth_key", bo.cg(paramm));
          g.RJ();
          localEditor.putInt("_auth_uin", com.tencent.mm.kernel.a.getUin());
          localEditor.commit();
        }
        com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125569);
            SetPwdUI.this.setResult(-1);
            if (SetPwdUI.this.m(paramInt1, paramInt2, paramString))
            {
              AppMethodBeat.o(125569);
              return;
            }
            AppMethodBeat.o(125569);
          }
        });
        return;
        ab.i("MicroMsg.SetPwdUI", "has bind mobile");
        str = getString(2131297634);
        break;
      }
    } while (m(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(2131300100, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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