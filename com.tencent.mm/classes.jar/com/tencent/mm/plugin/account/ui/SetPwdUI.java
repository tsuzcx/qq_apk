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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;

public abstract class SetPwdUI
  extends MMActivity
  implements i
{
  protected ProgressDialog gtM = null;
  protected String ksb;
  protected String ksc;
  public boolean ox = true;
  
  protected ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return com.tencent.mm.ui.base.h.a(paramContext, paramString2, true, paramOnCancelListener);
  }
  
  protected abstract void a(a.a parama);
  
  protected int bpA()
  {
    return 383;
  }
  
  protected void bpG()
  {
    bpV();
  }
  
  public boolean bpH()
  {
    return false;
  }
  
  protected final void bpV()
  {
    this.ksb = bpy();
    this.ksc = bpz();
    if (Util.isNullOrNil(this.ksb)) {}
    do
    {
      return;
      if (!this.ksb.equals(this.ksc))
      {
        a(a.a.kiI);
        return;
      }
      if (this.ksb.length() > 16)
      {
        a(a.a.kiJ);
        return;
      }
      if (Util.isChinese(this.ksb))
      {
        com.tencent.mm.ui.base.h.n(this, 2131764375, 2131764412);
        return;
      }
      if (!Util.isValidPassword(this.ksb))
      {
        if ((this.ksb.length() >= 8) && (this.ksb.length() < 16))
        {
          a(a.a.kiL);
          return;
        }
        a(a.a.kiK);
        return;
      }
      hideVKB();
      final q localq = bpx();
      com.tencent.mm.kernel.g.azz().a(localq, 0);
      this.gtM = a(this, getString(2131755998), getString(2131764339), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128728);
          com.tencent.mm.kernel.g.azz().a(localq);
          AppMethodBeat.o(128728);
        }
      });
    } while ((!bpH()) || (this.ox));
    Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
    com.tencent.mm.plugin.report.service.h.CyF.a(11868, new Object[] { Integer.valueOf(0) });
  }
  
  protected abstract q bpx();
  
  protected abstract String bpy();
  
  protected abstract String bpz();
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    return com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString);
  }
  
  protected abstract boolean o(int paramInt1, int paramInt2, String paramString);
  
  public void onBackPressed()
  {
    if (this.ox)
    {
      if (bpH())
      {
        Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.h.CyF.a(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.kernel.g.azz().a(bpA(), this);
    super.onCreate(paramBundle);
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128729);
        SetPwdUI.this.bpG();
        AppMethodBeat.o(128729);
        return true;
      }
    }, null, t.b.OGU);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128730);
        paramAnonymousMenuItem = SetPwdUI.this;
        if ((paramAnonymousMenuItem.bpH()) && (paramAnonymousMenuItem.ox))
        {
          Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
          com.tencent.mm.plugin.report.service.h.CyF.a(11868, new Object[] { Integer.valueOf(1) });
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
    com.tencent.mm.kernel.g.azz().b(bpA(), this);
    super.onDestroy();
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, q paramq)
  {
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (paramq.getType() != bpA()) {}
    label288:
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
      if (Util.isNullOrNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(6, null)))
      {
        Log.i("MicroMsg.SetPwdUI", "has not bind mobile");
        str = getString(2131763593);
        paramq = (aa)paramq;
        if ((paramq.rr == null) || (paramq.rr.iLL.iLR == null)) {
          break label288;
        }
      }
      for (paramq = (dwn)paramq.rr.iLL.iLR;; paramq = null)
      {
        if ((paramq != null) && (paramq.KKZ != null))
        {
          paramq = paramq.KKZ.getBuffer().toByteArray();
          SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aps()).edit();
          localEditor.putBoolean("key_auth_info_prefs_created", true);
          localEditor.putInt("key_auth_update_version", com.tencent.mm.protocal.d.KyO);
          localEditor.putString("_auth_key", Util.encodeHexString(paramq));
          com.tencent.mm.kernel.g.aAf();
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
        Log.i("MicroMsg.SetPwdUI", "has bind mobile");
        str = getString(2131756663);
        break;
      }
    } while (o(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(2131760884, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI
 * JD-Core Version:    0.7.0.1
 */