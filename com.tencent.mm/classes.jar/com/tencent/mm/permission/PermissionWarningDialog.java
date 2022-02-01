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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private DialogInterface.OnCancelListener XL;
  private d iNf;
  
  public PermissionWarningDialog()
  {
    AppMethodBeat.i(20694);
    this.XL = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(20690);
        PermissionWarningDialog.this.finish();
        AppMethodBeat.o(20690);
      }
    };
    this.iNf = null;
    AppMethodBeat.o(20694);
  }
  
  private boolean aQn()
  {
    AppMethodBeat.i(20699);
    if (getIntent() == null)
    {
      ae.e("MicroMsg.PermissionWarningDialog", "Intent is null");
      AppMethodBeat.o(20699);
      return false;
    }
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      ae.e("MicroMsg.PermissionWarningDialog", "invalid params");
      AppMethodBeat.o(20699);
      return false;
    }
    int i = ((Bundle)localObject).getInt("warning_type", 0);
    d.a locala;
    if (1 == i)
    {
      locala = new d.a(this);
      locala.aZh(((Bundle)localObject).getString("warning_title"));
      locala.aZi(((Bundle)localObject).getString("warning_content"));
      locala.afU(2131755793).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20691);
          PermissionWarningDialog.this.finish();
          AppMethodBeat.o(20691);
        }
      });
      locala.e(this.XL);
      this.iNf = locala.fQv();
      this.iNf.setCanceledOnTouchOutside(false);
      this.iNf.show();
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
        locala.afN(2131755852);
        locala.aZi(getString(2131755847));
        locala.afU(2131755841).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20692);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(20692);
          }
        });
        locala.e(this.XL);
        this.iNf = locala.fQv();
        this.iNf.setCanceledOnTouchOutside(false);
        this.iNf.show();
      }
      else
      {
        if (3 != i) {
          break;
        }
        localObject = new f.a(this);
        ((f.a)localObject).zi(false);
        ((f.a)localObject).aZq(getString(2131755812)).aZv(getString(2131755795)).aZu(getString(2131755813)).c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(20693);
            if (paramAnonymousBoolean)
            {
              ae.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
              ((AudioManager)ak.getContext().getSystemService("audio")).setMicrophoneMute(false);
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
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(20700);
    Object localObject = new Intent(paramContext, PermissionWarningDialog.class);
    ((Intent)localObject).putExtra("warning_type", 2);
    ((Intent)localObject).putExtra("warning_filter", paramBoolean1);
    ((Intent)localObject).putExtra("warning_due2Exception", paramBoolean2);
    ((Intent)localObject).addFlags(805306368);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20700);
  }
  
  public static void cU(Context paramContext)
  {
    AppMethodBeat.i(20701);
    Object localObject = new Intent(paramContext, PermissionWarningDialog.class);
    ((Intent)localObject).putExtra("warning_type", 3);
    ((Intent)localObject).addFlags(805306368);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20695);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (!aQn()) {
      finish();
    }
    AppMethodBeat.o(20695);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(20697);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.iNf != null)
    {
      this.iNf.dismiss();
      this.iNf = null;
    }
    if (!aQn()) {
      finish();
    }
    AppMethodBeat.o(20697);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20698);
    super.onPause();
    y.activateBroadcast(false);
    AppMethodBeat.o(20698);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20696);
    super.onResume();
    y.activateBroadcast(true);
    AppMethodBeat.o(20696);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog
 * JD-Core Version:    0.7.0.1
 */