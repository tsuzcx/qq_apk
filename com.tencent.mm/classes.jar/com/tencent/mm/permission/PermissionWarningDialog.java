package com.tencent.mm.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private DialogInterface.OnCancelListener fs;
  private d mpz;
  
  public PermissionWarningDialog()
  {
    AppMethodBeat.i(20694);
    this.fs = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(20690);
        PermissionWarningDialog.this.finish();
        AppMethodBeat.o(20690);
      }
    };
    this.mpz = null;
    AppMethodBeat.o(20694);
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(20700);
    Object localObject = new Intent(paramContext, PermissionWarningDialog.class);
    ((Intent)localObject).putExtra("warning_type", 2);
    ((Intent)localObject).putExtra("warning_filter", paramBoolean1);
    ((Intent)localObject).putExtra("warning_due2Exception", paramBoolean2);
    ((Intent)localObject).addFlags(805306368);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20700);
  }
  
  private boolean buF()
  {
    AppMethodBeat.i(20699);
    if (getIntent() == null)
    {
      Log.e("MicroMsg.PermissionWarningDialog", "Intent is null");
      AppMethodBeat.o(20699);
      return false;
    }
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      Log.e("MicroMsg.PermissionWarningDialog", "invalid params");
      AppMethodBeat.o(20699);
      return false;
    }
    int i = ((Bundle)localObject).getInt("warning_type", 0);
    d.a locala;
    if (1 == i)
    {
      locala = new d.a(this);
      locala.bBc(((Bundle)localObject).getString("warning_title"));
      locala.bBd(((Bundle)localObject).getString("warning_content"));
      locala.ayj(R.l.app_i_known).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20691);
          PermissionWarningDialog.this.finish();
          AppMethodBeat.o(20691);
        }
      });
      locala.f(this.fs);
      this.mpz = locala.icu();
      this.mpz.setCanceledOnTouchOutside(false);
      this.mpz.show();
    }
    for (;;)
    {
      AppMethodBeat.o(20699);
      return true;
      if (2 == i)
      {
        locala = new d.a(this);
        ((Bundle)localObject).getBoolean("warning_filter", false);
        ((Bundle)localObject).getBoolean("warning_due2Exception", false);
        locala.ayc(R.l.eoP);
        locala.bBd(getString(R.l.eoN));
        locala.ayj(R.l.eoL).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20692);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(20692);
          }
        });
        locala.f(this.fs);
        this.mpz = locala.icu();
        this.mpz.setCanceledOnTouchOutside(false);
        this.mpz.show();
      }
      else
      {
        if (3 != i) {
          break;
        }
        localObject = new f.a(this);
        ((f.a)localObject).HL(false);
        ((f.a)localObject).bBl(getString(R.l.eoE)).bBq(getString(R.l.app_ignore)).bBp(getString(R.l.eoF)).c(new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(20693);
            if (paramAnonymousBoolean)
            {
              Log.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
              ((AudioManager)MMApplicationContext.getContext().getSystemService("audio")).setMicrophoneMute(false);
            }
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(20693);
          }
        }).show();
      }
    }
    AppMethodBeat.o(20699);
    return false;
  }
  
  public static void dm(Context paramContext)
  {
    AppMethodBeat.i(20701);
    Object localObject = new Intent(paramContext, PermissionWarningDialog.class);
    ((Intent)localObject).putExtra("warning_type", 3);
    ((Intent)localObject).addFlags(805306368);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20695);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (!buF()) {
      finish();
    }
    AppMethodBeat.o(20695);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(20697);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.mpz != null)
    {
      this.mpz.dismiss();
      this.mpz = null;
    }
    if (!buF()) {
      finish();
    }
    AppMethodBeat.o(20697);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20698);
    super.onPause();
    ac.activateBroadcast(false);
    AppMethodBeat.o(20698);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20696);
    super.onResume();
    ac.activateBroadcast(true);
    AppMethodBeat.o(20696);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog
 * JD-Core Version:    0.7.0.1
 */