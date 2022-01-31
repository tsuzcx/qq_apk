package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e.a;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private c eQV = null;
  
  private void UF()
  {
    if (getIntent() == null) {
      y.e("MicroMsg.PermissionWarningDialog", "Intent is null");
    }
    int i;
    do
    {
      return;
      localObject = getIntent().getExtras();
      if (localObject == null)
      {
        y.e("MicroMsg.PermissionWarningDialog", "invalid params");
        return;
      }
      i = ((Bundle)localObject).getInt("warning_type", 0);
      c.a locala;
      if (1 == i)
      {
        locala = new c.a(this);
        locala.aez(((Bundle)localObject).getString("warning_title"));
        locala.aeA(((Bundle)localObject).getString("warning_content"));
        locala.Is(R.l.app_i_known).a(new PermissionWarningDialog.1(this));
        this.eQV = locala.aoP();
        this.eQV.setCanceledOnTouchOutside(false);
        this.eQV.show();
        return;
      }
      if (2 == i)
      {
        locala = new c.a(this);
        ((Bundle)localObject).getBoolean("warning_filter", false);
        ((Bundle)localObject).getBoolean("warning_due2Exception", false);
        locala.Ip(R.l.app_permission_tips_upload_title);
        locala.aeA(getString(R.l.app_permission_tips_policy_tips));
        locala.Is(R.l.app_permission_tips_confirm).a(new PermissionWarningDialog.2(this));
        this.eQV = locala.aoP();
        this.eQV.setCanceledOnTouchOutside(false);
        this.eQV.show();
        return;
      }
    } while (3 != i);
    Object localObject = new e.a(this).aeG(getString(R.l.app_microphone_mute_dlg_message));
    ((e.a)localObject).wnw = getString(R.l.app_ignore);
    ((e.a)localObject).wnv = getString(R.l.app_microphone_mute_dlg_ok);
    ((e.a)localObject).c(new PermissionWarningDialog.3(this)).show();
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, PermissionWarningDialog.class);
    localIntent.putExtra("warning_type", 2);
    localIntent.putExtra("warning_filter", paramBoolean1);
    localIntent.putExtra("warning_due2Exception", paramBoolean2);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
  }
  
  public static void bH(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, PermissionWarningDialog.class);
    localIntent.putExtra("warning_type", 3);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    UF();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.eQV != null)
    {
      this.eQV.dismiss();
      this.eQV = null;
    }
    UF();
  }
  
  protected void onPause()
  {
    super.onPause();
    x.b(false, null);
  }
  
  protected void onResume()
  {
    super.onResume();
    x.b(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog
 * JD-Core Version:    0.7.0.1
 */