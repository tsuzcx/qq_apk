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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;

public abstract class SetPwdUI
  extends MMActivity
  implements f
{
  protected ProgressDialog fOC = null;
  protected String jtM;
  protected String jtN;
  public boolean ov = true;
  
  protected ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected abstract n aUK();
  
  protected abstract String aUL();
  
  protected abstract String aUM();
  
  protected int aUN()
  {
    return 383;
  }
  
  protected void aUU()
  {
    aVj();
  }
  
  public boolean aUV()
  {
    return false;
  }
  
  protected final void aVj()
  {
    this.jtM = aUL();
    this.jtN = aUM();
    if (bu.isNullOrNil(this.jtM)) {}
    do
    {
      return;
      if (!this.jtM.equals(this.jtN))
      {
        a(a.a.jkF);
        return;
      }
      if (this.jtM.length() > 16)
      {
        a(a.a.jkG);
        return;
      }
      if (bu.aSm(this.jtM))
      {
        h.l(this, 2131762309, 2131762346);
        return;
      }
      if (!bu.aSr(this.jtM))
      {
        if ((this.jtM.length() >= 8) && (this.jtM.length() < 16))
        {
          a(a.a.jkI);
          return;
        }
        a(a.a.jkH);
        return;
      }
      hideVKB();
      final n localn = aUK();
      com.tencent.mm.kernel.g.ajj().a(localn, 0);
      getString(2131755906);
      this.fOC = a(this, getString(2131762273), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.g.ajj().a(localn);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!aUV()) || (this.ov));
    ae.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.g.yxI.f(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.iUA.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean o(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.ov)
    {
      if (aUV())
      {
        ae.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.g.yxI.f(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.g.ajj().a(aUN(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.aUU();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, s.b.JwA);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.aUV()) && (paramAnonymousMenuItem.ov))
        {
          ae.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.g.yxI.f(11868, new Object[] { Integer.valueOf(1) });
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
    com.tencent.mm.kernel.g.ajj().b(aUN(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (paramn.getType() != aUN()) {}
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
      if (bu.isNullOrNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(6, null)))
      {
        ae.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(2131761625);
        paramn = (aa)paramn;
        if ((paramn.rr == null) || (paramn.rr.hQE.hQJ == null)) {
          break label288;
        }
      }
      for (paramn = (ddj)paramn.rr.hQE.hQJ;; paramn = null)
      {
        if ((paramn != null) && (paramn.FRs != null))
        {
          paramn = paramn.FRs.getBuffer().toByteArray();
          SharedPreferences.Editor localEditor = ak.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.abv()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", d.FFH);
          localEditor.putString("_auth_key", bu.cH(paramn));
          com.tencent.mm.kernel.g.ajP();
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
        ae.i("MicroMsg.SetPwdUI", "has bind mobile");
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