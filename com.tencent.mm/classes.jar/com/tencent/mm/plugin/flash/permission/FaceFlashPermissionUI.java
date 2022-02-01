package com.tencent.mm.plugin.flash.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.flash.action.FaceFlashActionUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;

@com.tencent.mm.ui.base.a(3)
public class FaceFlashPermissionUI
  extends MMActivity
{
  private boolean BBL = false;
  private boolean BBM = false;
  private boolean BBN = false;
  private boolean BBO = false;
  private d mpz;
  
  public static Bundle ae(Bundle paramBundle)
  {
    AppMethodBeat.i(195876);
    paramBundle.putBoolean("face_permission_check", true);
    AppMethodBeat.o(195876);
    return paramBundle;
  }
  
  public static void b(Context paramContext, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(195877);
    Intent localIntent = new Intent(paramContext, FaceFlashPermissionUI.class);
    localIntent.putExtras(paramBundle);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(195877);
  }
  
  private static Intent bq(int paramInt, String paramString)
  {
    AppMethodBeat.i(195874);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", 4);
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManagerPermission", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(195874);
    return localIntent;
  }
  
  private void epJ()
  {
    AppMethodBeat.i(195872);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]gotoFaceFlashUI() hasStarted:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.BBM) });
    if (this.BBM)
    {
      AppMethodBeat.o(195872);
      return;
    }
    if (!p.aj(this))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "no camera  or audio permission. check permission");
      AppMethodBeat.o(195872);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerPermission", "check permission all success");
    if (epK())
    {
      AppMethodBeat.o(195872);
      return;
    }
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKM, false);
    boolean bool2 = getIntent().getExtras().getBoolean("face_permission_check", false);
    Log.i("MicroMsg.FaceFlashManagerPermission", "use new face action  %b openPlatformFlashPage:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool2) {
      FaceFlashUI.d(this, getIntent().getExtras());
    }
    for (;;)
    {
      this.BBM = true;
      AppMethodBeat.o(195872);
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
  
  private boolean epK()
  {
    AppMethodBeat.i(195878);
    boolean bool = getIntent().getBooleanExtra("face_permission_location_check", false);
    Log.i("MicroMsg.FaceFlashManagerPermission", "needCheckLocation: [%s]，hasCheckLocation：[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.BBN) });
    if ((!bool) || (this.BBN))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "do not needCheckLocation");
      AppMethodBeat.o(195878);
      return false;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
    Log.i("MicroMsg.FaceFlashManagerPermission", "locationPermission: [%s] ", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(195878);
      return true;
    }
    AppMethodBeat.o(195878);
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
    AppMethodBeat.i(195875);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onActivityResult()", new Object[] { Integer.valueOf(hashCode()) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(195875);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195865);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onCreate()", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate(paramBundle);
    AppMethodBeat.o(195865);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(195867);
    super.onDestroy();
    AppMethodBeat.o(195867);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195873);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onRequestPermissionsResult:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt) });
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "dont have any permission");
      setResult(1, bq(90010, "fail"));
      finish();
      AppMethodBeat.o(195873);
      return;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(195873);
      return;
    case 16: 
      if (paramArrayOfInt[0] == 0)
      {
        this.BBL = true;
        epJ();
        AppMethodBeat.o(195873);
        return;
      }
      this.BBL = false;
      this.mpz = com.tencent.mm.ui.base.h.a(this, getString(a.i.face_permission_camera_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(192388);
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting", new Object[] { Integer.valueOf(hashCode()) });
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceFlashPermissionUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(192388);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(192887);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", new Object[] { Integer.valueOf(hashCode()) });
          FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.br(90008, "fail"));
          FaceFlashPermissionUI.this.finish();
          AppMethodBeat.o(192887);
        }
      });
      AppMethodBeat.o(195873);
      return;
    case 18: 
    case 80: 
      if (paramArrayOfInt[0] == 0)
      {
        this.BBL = true;
        epJ();
        AppMethodBeat.o(195873);
        return;
      }
      this.BBL = false;
      this.mpz = com.tencent.mm.ui.base.h.a(this, getString(a.i.face_permission_micro_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194802);
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click setting ", new Object[] { Integer.valueOf(hashCode()) });
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceFlashPermissionUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/flash/permission/FaceFlashPermissionUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(194802);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(189835);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FaceFlashManagerPermission", "[%s]Dialog audio click cancel", new Object[] { Integer.valueOf(hashCode()) });
          FaceFlashPermissionUI.this.setResult(1, FaceFlashPermissionUI.br(90009, "fail"));
          FaceFlashPermissionUI.this.finish();
          AppMethodBeat.o(189835);
        }
      });
      AppMethodBeat.o(195873);
      return;
    }
    if (paramArrayOfInt[0] == 0) {
      Log.i("MicroMsg.FaceFlashManagerPermission", "get location granted");
    }
    for (;;)
    {
      this.BBN = true;
      epJ();
      break;
      Log.i("MicroMsg.FaceFlashManagerPermission", "do not get location granted");
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(195866);
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onRestoreInstanceState()", new Object[] { Integer.valueOf(hashCode()) });
    this.BBO = true;
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(195866);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(195870);
    super.onResume();
    Log.i("MicroMsg.FaceFlashManagerPermission", "[%d]onResume()  restore:%b checkPermissionSuccess:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.BBO), Boolean.valueOf(this.BBL) });
    if ((this.BBL) || (this.BBO))
    {
      AppMethodBeat.o(195870);
      return;
    }
    if ((this.mpz == null) || (!this.mpz.isShowing()))
    {
      Log.i("MicroMsg.FaceFlashManagerPermission", "onResume goFaceFlash");
      epJ();
    }
    AppMethodBeat.o(195870);
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