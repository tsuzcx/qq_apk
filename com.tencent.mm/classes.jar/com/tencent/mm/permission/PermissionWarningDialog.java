package com.tencent.mm.permission;

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
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private DialogInterface.OnCancelListener mOnCancelListener;
  private e pjp;
  
  public PermissionWarningDialog()
  {
    AppMethodBeat.i(20694);
    this.mOnCancelListener = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(20690);
        PermissionWarningDialog.this.finish();
        AppMethodBeat.o(20690);
      }
    };
    this.pjp = null;
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20700);
  }
  
  private boolean bSO()
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
    e.a locala;
    if (1 == i)
    {
      locala = new e.a(this);
      locala.bDv(((Bundle)localObject).getString("warning_title"));
      locala.bDw(((Bundle)localObject).getString("warning_content"));
      locala.aER(R.l.app_i_known).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20691);
          PermissionWarningDialog.this.finish();
          AppMethodBeat.o(20691);
        }
      });
      locala.e(this.mOnCancelListener);
      this.pjp = locala.jHH();
      this.pjp.setCanceledOnTouchOutside(false);
      this.pjp.show();
    }
    for (;;)
    {
      AppMethodBeat.o(20699);
      return true;
      if (2 == i)
      {
        locala = new e.a(this);
        ((Bundle)localObject).getBoolean("warning_filter", false);
        ((Bundle)localObject).getBoolean("warning_due2Exception", false);
        locala.aEK(R.l.grQ);
        locala.bDw(getString(R.l.grO));
        locala.aER(R.l.grM).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20692);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(20692);
          }
        });
        locala.e(this.mOnCancelListener);
        this.pjp = locala.jHH();
        this.pjp.setCanceledOnTouchOutside(false);
        this.pjp.show();
      }
      else
      {
        if (3 != i) {
          break;
        }
        localObject = new g.a(this);
        ((g.a)localObject).NF(false);
        ((g.a)localObject).bDE(getString(R.l.grD)).bDJ(getString(R.l.app_ignore)).bDI(getString(R.l.grE)).c(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
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
  
  public static void ee(Context paramContext)
  {
    AppMethodBeat.i(20701);
    Object localObject = new Intent(paramContext, PermissionWarningDialog.class);
    ((Intent)localObject).putExtra("warning_type", 3);
    ((Intent)localObject).addFlags(805306368);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20695);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (!bSO()) {
      finish();
    }
    AppMethodBeat.o(20695);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(20697);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.pjp != null)
    {
      this.pjp.dismiss();
      this.pjp = null;
    }
    if (!bSO()) {
      finish();
    }
    AppMethodBeat.o(20697);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20698);
    super.onPause();
    ag.activateBroadcast(false);
    AppMethodBeat.o(20698);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20696);
    super.onResume();
    ag.activateBroadcast(true);
    AppMethodBeat.o(20696);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog
 * JD-Core Version:    0.7.0.1
 */