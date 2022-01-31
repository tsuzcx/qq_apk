package com.tencent.mm.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.e.a;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private DialogInterface.OnCancelListener NW;
  private c giQ;
  
  public PermissionWarningDialog()
  {
    AppMethodBeat.i(16650);
    this.NW = new PermissionWarningDialog.1(this);
    this.giQ = null;
    AppMethodBeat.o(16650);
  }
  
  private boolean aoe()
  {
    AppMethodBeat.i(16655);
    if (getIntent() == null)
    {
      ab.e("MicroMsg.PermissionWarningDialog", "Intent is null");
      AppMethodBeat.o(16655);
      return false;
    }
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      ab.e("MicroMsg.PermissionWarningDialog", "invalid params");
      AppMethodBeat.o(16655);
      return false;
    }
    int i = ((Bundle)localObject).getInt("warning_type", 0);
    c.a locala;
    if (1 == i)
    {
      locala = new c.a(this);
      locala.avm(((Bundle)localObject).getString("warning_title"));
      locala.avn(((Bundle)localObject).getString("warning_content"));
      locala.Ri(2131296977).a(new PermissionWarningDialog.2(this));
      locala.e(this.NW);
      this.giQ = locala.aLZ();
      this.giQ.setCanceledOnTouchOutside(false);
      this.giQ.show();
    }
    for (;;)
    {
      AppMethodBeat.o(16655);
      return true;
      if (2 == i)
      {
        locala = new c.a(this);
        ((Bundle)localObject).getBoolean("warning_filter", false);
        ((Bundle)localObject).getBoolean("warning_due2Exception", false);
        locala.Rb(2131297035);
        locala.avn(getString(2131297030));
        locala.Ri(2131297024).a(new PermissionWarningDialog.3(this));
        locala.e(this.NW);
        this.giQ = locala.aLZ();
        this.giQ.setCanceledOnTouchOutside(false);
        this.giQ.show();
      }
      else
      {
        if (3 != i) {
          break;
        }
        localObject = new e.a(this);
        ((e.a)localObject).rI(false);
        localObject = ((e.a)localObject).avu(getString(2131296995));
        ((e.a)localObject).AHt = getString(2131296979);
        ((e.a)localObject).AHs = getString(2131296996);
        ((e.a)localObject).c(new PermissionWarningDialog.4(this)).show();
      }
    }
    AppMethodBeat.o(16655);
    return false;
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(16656);
    Intent localIntent = new Intent(paramContext, PermissionWarningDialog.class);
    localIntent.putExtra("warning_type", 2);
    localIntent.putExtra("warning_filter", paramBoolean1);
    localIntent.putExtra("warning_due2Exception", paramBoolean2);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(16656);
  }
  
  public static void co(Context paramContext)
  {
    AppMethodBeat.i(16657);
    Intent localIntent = new Intent(paramContext, PermissionWarningDialog.class);
    localIntent.putExtra("warning_type", 3);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(16657);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16651);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (!aoe()) {
      finish();
    }
    AppMethodBeat.o(16651);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(16653);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.giQ != null)
    {
      this.giQ.dismiss();
      this.giQ = null;
    }
    if (!aoe()) {
      finish();
    }
    AppMethodBeat.o(16653);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(16654);
    super.onPause();
    y.activateBroadcast(false);
    AppMethodBeat.o(16654);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(16652);
    super.onResume();
    y.activateBroadcast(true);
    AppMethodBeat.o(16652);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog
 * JD-Core Version:    0.7.0.1
 */