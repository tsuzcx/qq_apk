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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public abstract class SetPwdUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  protected ProgressDialog fts = null;
  protected String iXK;
  protected String iXL;
  public boolean mz = true;
  
  protected ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected abstract n aQZ();
  
  protected abstract String aRa();
  
  protected abstract String aRb();
  
  protected int aRc()
  {
    return 383;
  }
  
  protected void aRj()
  {
    aRy();
  }
  
  public boolean aRk()
  {
    return false;
  }
  
  protected final void aRy()
  {
    this.iXK = aRa();
    this.iXL = aRb();
    if (bs.isNullOrNil(this.iXK)) {}
    do
    {
      return;
      if (!this.iXK.equals(this.iXL))
      {
        a(a.a.iOD);
        return;
      }
      if (this.iXK.length() > 16)
      {
        a(a.a.iOE);
        return;
      }
      if (bs.aLj(this.iXK))
      {
        com.tencent.mm.ui.base.h.l(this, 2131762309, 2131762346);
        return;
      }
      if (!bs.aLo(this.iXK))
      {
        if ((this.iXK.length() >= 8) && (this.iXK.length() < 16))
        {
          a(a.a.iOG);
          return;
        }
        a(a.a.iOF);
        return;
      }
      hideVKB();
      final n localn = aQZ();
      com.tencent.mm.kernel.g.agi().a(localn, 0);
      getString(2131755906);
      this.fts = a(this, getString(2131762273), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.g.agi().a(localn);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!aRk()) || (this.mz));
    ac.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.wUl.f(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean o(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.mz)
    {
      if (aRk())
      {
        ac.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.wUl.f(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.g.agi().a(aRc(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.aRj();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, s.b.Hom);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.aRk()) && (paramAnonymousMenuItem.mz))
        {
          ac.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.h.wUl.f(11868, new Object[] { Integer.valueOf(1) });
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
    com.tencent.mm.kernel.g.agi().b(aRc(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (paramn.getType() != aRc()) {}
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
      if (bs.isNullOrNil((String)com.tencent.mm.kernel.g.agR().agA().get(6, null)))
      {
        ac.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(2131761625);
        paramn = (z)paramn;
        if ((paramn.rr == null) || (paramn.rr.hvs.hvw == null)) {
          break label288;
        }
      }
      for (paramn = (cxc)paramn.rr.hvs.hvw;; paramn = null)
      {
        if ((paramn != null) && (paramn.DTA != null))
        {
          paramn = paramn.DTA.getBuffer().toByteArray();
          SharedPreferences.Editor localEditor = ai.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.YK()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.DIc);
          localEditor.putString("_auth_key", bs.cx(paramn));
          com.tencent.mm.kernel.g.agP();
          localEditor.putInt("_auth_uin", com.tencent.mm.kernel.a.getUin());
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
        ac.i("MicroMsg.SetPwdUI", "has bind mobile");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */