package com.tencent.mm.plugin.flash.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.flash.action.FaceFlashActionUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

@com.tencent.mm.ui.base.a(3)
public class FaceFlashPermissionUI
  extends MMActivity
{
  private d jzT;
  private boolean wIB = false;
  
  private static Intent bo(int paramInt, String paramString)
  {
    AppMethodBeat.i(186663);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", 4);
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManagerPermission", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(186663);
    return localIntent;
  }
  
  private void dLg()
  {
    AppMethodBeat.i(186661);
    if (!p.ai(this))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "no camera  or audio permission. check permission");
      AppMethodBeat.o(186661);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerPermission", "check permission all success");
    boolean bool = ((b)g.af(b.class)).a(b.a.scy, false);
    Log.i("MicroMsg.FaceFlashManagerPermission", "use new face action  %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      FaceFlashActionUI.d(this, getIntent().getExtras());
      AppMethodBeat.o(186661);
      return;
    }
    Intent localIntent = new Intent(this, FaceActionUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(186661);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(186664);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(186664);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186659);
    super.onCreate(paramBundle);
    AppMethodBeat.o(186659);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186662);
    Log.i("MicroMsg.FaceFlashManagerPermission", "onRequestPermissionsResult:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "dont have any permission");
      setResult(1, bo(90010, "fail"));
      finish();
      AppMethodBeat.o(186662);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(186662);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.wIB = true;
        dLg();
        AppMethodBeat.o(186662);
        return;
      }
      this.wIB = false;
      this.jzT = h.a(this, getString(2131759068), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186655);
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting", new Object[] { Integer.valueOf(hashCode()) });
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceFlashPermissionUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(186655);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186656);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", new Object[] { Integer.valueOf(hashCode()) });
          FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.bp(90008, "fail"));
          FaceFlashPermissionUI.this.finish();
          AppMethodBeat.o(186656);
        }
      });
      AppMethodBeat.o(186662);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.wIB = true;
        dLg();
        AppMethodBeat.o(186662);
        return;
      }
      this.wIB = false;
      this.jzT = h.a(this, getString(2131759069), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186657);
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting ", new Object[] { Integer.valueOf(hashCode()) });
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceFlashPermissionUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(186657);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186658);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", new Object[] { Integer.valueOf(hashCode()) });
          FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.bp(90009, "fail"));
          FaceFlashPermissionUI.this.finish();
          AppMethodBeat.o(186658);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186660);
    super.onResume();
    if (this.wIB)
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "has check permission success");
      AppMethodBeat.o(186660);
      return;
    }
    if ((this.jzT == null) || (!this.jzT.isShowing()))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "onResume goFaceFlash");
      dLg();
    }
    AppMethodBeat.o(186660);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI
 * JD-Core Version:    0.7.0.1
 */