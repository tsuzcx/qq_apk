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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private DialogInterface.OnCancelListener XY;
  private d jzT;
  
  public PermissionWarningDialog()
  {
    AppMethodBeat.i(20694);
    this.XY = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(20690);
        PermissionWarningDialog.this.finish();
        AppMethodBeat.o(20690);
      }
    };
    this.jzT = null;
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20700);
  }
  
  private boolean bkS()
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
      locala.bon(((Bundle)localObject).getString("warning_title"));
      locala.boo(((Bundle)localObject).getString("warning_content"));
      locala.aoV(2131755874).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20691);
          PermissionWarningDialog.this.finish();
          AppMethodBeat.o(20691);
        }
      });
      locala.f(this.XY);
      this.jzT = locala.hbn();
      this.jzT.setCanceledOnTouchOutside(false);
      this.jzT.show();
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
        locala.aoO(2131755938);
        locala.boo(getString(2131755933));
        locala.aoV(2131755927).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20692);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(20692);
          }
        });
        locala.f(this.XY);
        this.jzT = locala.hbn();
        this.jzT.setCanceledOnTouchOutside(false);
        this.jzT.show();
      }
      else
      {
        if (3 != i) {
          break;
        }
        localObject = new f.a(this);
        ((f.a)localObject).Dq(false);
        ((f.a)localObject).bow(getString(2131755894)).boB(getString(2131755876)).boA(getString(2131755895)).c(new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
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
  
  public static void dp(Context paramContext)
  {
    AppMethodBeat.i(20701);
    Object localObject = new Intent(paramContext, PermissionWarningDialog.class);
    ((Intent)localObject).putExtra("warning_type", 3);
    ((Intent)localObject).addFlags(805306368);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20695);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (!bkS()) {
      finish();
    }
    AppMethodBeat.o(20695);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(20697);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.jzT != null)
    {
      this.jzT.dismiss();
      this.jzT = null;
    }
    if (!bkS()) {
      finish();
    }
    AppMethodBeat.o(20697);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20698);
    super.onPause();
    aa.activateBroadcast(false);
    AppMethodBeat.o(20698);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20696);
    super.onResume();
    aa.activateBroadcast(true);
    AppMethodBeat.o(20696);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog
 * JD-Core Version:    0.7.0.1
 */