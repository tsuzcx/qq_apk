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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;

public abstract class SetPwdUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  protected ProgressDialog fpP = null;
  protected String ixH;
  protected String ixI;
  public boolean lA = true;
  
  protected ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected final void aKH()
  {
    this.ixH = aKj();
    this.ixI = aKk();
    if (bt.isNullOrNil(this.ixH)) {}
    do
    {
      return;
      if (!this.ixH.equals(this.ixI))
      {
        a(a.a.iox);
        return;
      }
      if (this.ixH.length() > 16)
      {
        a(a.a.ioy);
        return;
      }
      if (bt.aFS(this.ixH))
      {
        com.tencent.mm.ui.base.h.j(this, 2131762309, 2131762346);
        return;
      }
      if (!bt.aFX(this.ixH))
      {
        if ((this.ixH.length() >= 8) && (this.ixH.length() < 16))
        {
          a(a.a.ioA);
          return;
        }
        a(a.a.ioz);
        return;
      }
      hideVKB();
      final n localn = aKi();
      com.tencent.mm.kernel.g.aeS().a(localn, 0);
      getString(2131755906);
      this.fpP = a(this, getString(2131762273), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.g.aeS().a(localn);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!aKt()) || (this.lA));
    ad.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.vKh.f(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected abstract n aKi();
  
  protected abstract String aKj();
  
  protected abstract String aKk();
  
  protected int aKl()
  {
    return 383;
  }
  
  protected void aKs()
  {
    aKH();
  }
  
  public boolean aKt()
  {
    return false;
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.hYu.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean o(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.lA)
    {
      if (aKt())
      {
        ad.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.vKh.f(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.g.aeS().a(aKl(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.aKs();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, r.b.FOB);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.aKt()) && (paramAnonymousMenuItem.lA))
        {
          ad.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.h.vKh.f(11868, new Object[] { Integer.valueOf(1) });
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
    com.tencent.mm.kernel.g.aeS().b(aKl(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (paramn.getType() != aKl()) {}
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
      if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.afB().afk().get(6, null)))
      {
        ad.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(2131761625);
        paramn = (z)paramn;
        if ((paramn.rr == null) || (paramn.rr.gUT.gUX == null)) {
          break label288;
        }
      }
      for (paramn = (crt)paramn.rr.gUT.gUX;; paramn = null)
      {
        if ((paramn != null) && (paramn.CBc != null))
        {
          paramn = paramn.CBc.getBuffer().toByteArray();
          SharedPreferences.Editor localEditor = aj.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.XN()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.CpK);
          localEditor.putString("_auth_key", bt.cy(paramn));
          com.tencent.mm.kernel.g.afz();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */