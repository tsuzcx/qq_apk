package com.tencent.mm.plugin.flash.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.flash.action.FaceFlashActionUI;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.e;

@com.tencent.mm.ui.base.a(3)
public class FaceFlashPermissionUI
  extends MMActivity
{
  private boolean Hjs = false;
  private boolean Hjt = false;
  private boolean Hju = false;
  private boolean Hjv = false;
  private e pjp;
  
  public static Bundle aw(Bundle paramBundle)
  {
    AppMethodBeat.i(264622);
    paramBundle.putBoolean("face_permission_check", true);
    AppMethodBeat.o(264622);
    return paramBundle;
  }
  
  public static void b(Context paramContext, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(264634);
    Intent localIntent = new Intent(paramContext, FaceFlashPermissionUI.class);
    localIntent.putExtras(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI", "jumpToActivity", "(Landroid/content/Context;Landroid/os/Bundle;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(264634);
  }
  
  private static Intent bU(int paramInt, String paramString)
  {
    AppMethodBeat.i(264612);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", 4);
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManagerPermission", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(264612);
    return localIntent;
  }
  
  private void fuL()
  {
    AppMethodBeat.i(264603);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]gotoFaceFlashUI() hasStarted:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Hjt) });
    if (this.Hjt)
    {
      AppMethodBeat.o(264603);
      return;
    }
    if (!com.tencent.mm.plugin.facedetect.model.k.as(this))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "no camera  or audio permission. check permission");
      AppMethodBeat.o(264603);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerPermission", "check permission all success");
    if (fuM())
    {
      AppMethodBeat.o(264603);
      return;
    }
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbm, false);
    boolean bool2 = getIntent().getExtras().getBoolean("face_permission_check", false);
    Log.i("MicroMsg.FaceFlashManagerPermission", "use new face action  %b openPlatformFlashPage:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool2) {
      FaceFlashUI.d(this, getIntent().getExtras());
    }
    for (;;)
    {
      this.Hjt = true;
      AppMethodBeat.o(264603);
      return;
      if (bool1)
      {
        FaceFlashActionUI.d(this, getIntent().getExtras());
      }
      else
      {
        Intent localIntent = new Intent(this, FaceActionUI.class);
        Bundle localBundle = getIntent().getExtras();
        if (localBundle != null) {
          localIntent.putExtras(localBundle);
        }
        startActivityForResult(localIntent, 1);
      }
    }
  }
  
  private boolean fuM()
  {
    AppMethodBeat.i(264645);
    boolean bool = getIntent().getBooleanExtra("face_permission_location_check", false);
    Log.i("MicroMsg.FaceFlashManagerPermission", "needCheckLocation: [%s]，hasCheckLocation：[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.Hju) });
    if ((!bool) || (this.Hju))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "do not needCheckLocation");
      AppMethodBeat.o(264645);
      return false;
    }
    bool = b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, "");
    Log.i("MicroMsg.FaceFlashManagerPermission", "locationPermission: [%s] ", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(264645);
      return true;
    }
    AppMethodBeat.o(264645);
    return false;
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
    AppMethodBeat.i(264734);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onActivityResult()", new Object[] { Integer.valueOf(hashCode()) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(264734);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264677);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onCreate()", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate(paramBundle);
    AppMethodBeat.o(264677);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264697);
    super.onDestroy();
    AppMethodBeat.o(264697);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(264724);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onRequestPermissionsResult:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt) });
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "dont have any permission");
      setResult(1, bU(90010, "fail"));
      finish();
      AppMethodBeat.o(264724);
      return;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(264724);
      return;
    case 16: 
      if (paramArrayOfInt[0] == 0)
      {
        this.Hjs = true;
        fuL();
        AppMethodBeat.o(264724);
        return;
      }
      this.Hjs = false;
      this.pjp = com.tencent.mm.ui.base.k.a(this, getString(a.i.face_permission_camera_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(264563);
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting", new Object[] { Integer.valueOf(hashCode()) });
          paramAnonymousDialogInterface.dismiss();
          b.lx(FaceFlashPermissionUI.this.getContext());
          AppMethodBeat.o(264563);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(264564);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", new Object[] { Integer.valueOf(hashCode()) });
          FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.bV(90008, "fail"));
          FaceFlashPermissionUI.this.finish();
          AppMethodBeat.o(264564);
        }
      });
      AppMethodBeat.o(264724);
      return;
    case 18: 
    case 80: 
      if (paramArrayOfInt[0] == 0)
      {
        this.Hjs = true;
        fuL();
        AppMethodBeat.o(264724);
        return;
      }
      this.Hjs = false;
      this.pjp = com.tencent.mm.ui.base.k.a(this, getString(a.i.face_permission_micro_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(264569);
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting ", new Object[] { Integer.valueOf(hashCode()) });
          paramAnonymousDialogInterface.dismiss();
          b.lx(FaceFlashPermissionUI.this.getContext());
          AppMethodBeat.o(264569);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(264577);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", new Object[] { Integer.valueOf(hashCode()) });
          FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.bV(90009, "fail"));
          FaceFlashPermissionUI.this.finish();
          AppMethodBeat.o(264577);
        }
      });
      AppMethodBeat.o(264724);
      return;
    }
    if (paramArrayOfInt[0] == 0) {
      Log.i("MicroMsg.FaceFlashManagerPermission", "get location granted");
    }
    for (;;)
    {
      this.Hju = true;
      fuL();
      break;
      Log.i("MicroMsg.FaceFlashManagerPermission", "do not get location granted");
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(264686);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onRestoreInstanceState()", new Object[] { Integer.valueOf(hashCode()) });
    this.Hjv = true;
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(264686);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(264710);
    super.onResume();
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onResume()  restore:%b checkPermissionSuccess:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Hjv), Boolean.valueOf(this.Hjs) });
    if ((this.Hjs) || (this.Hjv))
    {
      AppMethodBeat.o(264710);
      return;
    }
    if ((this.pjp == null) || (!this.pjp.isShowing()))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "onResume goFaceFlash");
      fuL();
    }
    AppMethodBeat.o(264710);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI
 * JD-Core Version:    0.7.0.1
 */