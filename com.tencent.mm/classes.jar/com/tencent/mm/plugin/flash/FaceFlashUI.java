package com.tencent.mm.plugin.flash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.mmdata.rpt.cc;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.flash.b.d;
import com.tencent.mm.plugin.flash.b.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONObject;

public class FaceFlashUI
  extends MMActivity
  implements View.OnClickListener
{
  private WeImageView GsS;
  FaceFlashPreviewLayout Hii;
  FaceFlashProcessLayout Hij;
  private int Hik;
  private String Hil;
  String Him;
  private IListener Hin;
  private long startTime;
  private IListener tje;
  
  public FaceFlashUI()
  {
    AppMethodBeat.i(264608);
    this.Hik = 90004;
    this.Hil = "";
    this.Him = "";
    this.startTime = Util.currentTicks();
    this.tje = new IListener(f.hfK) {};
    this.Hin = new FaceFlashUI.3(this, f.hfK);
    AppMethodBeat.o(264608);
  }
  
  private static Intent E(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(264638);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManager", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(264638);
    return localIntent;
  }
  
  public static boolean d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(264618);
    Object localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(264523);
        com.tencent.mm.plugin.flash.c.b.F("msgVerify", "camera or mic 正在被占用");
        com.tencent.mm.plugin.flash.c.b.fuO().ivK = 1;
        com.tencent.mm.plugin.flash.c.b.VL(90033);
        FaceFlashUI.this.setResult(1, FaceFlashUI.aDt("finish by voip call"));
        FaceFlashUI.this.finish();
        AppMethodBeat.o(264523);
      }
    };
    if ((!com.tencent.mm.n.a.b(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.d(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.a(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.f(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.e(paramActivity, (DialogInterface.OnClickListener)localObject)))
    {
      localObject = new Intent(paramActivity, FaceFlashUI.class);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/flash/FaceFlashUI", "jumpToFaceFlashUI", "(Landroid/app/Activity;Landroid/os/Bundle;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(264618);
      return true;
    }
    AppMethodBeat.o(264618);
    return false;
  }
  
  private void fuw()
  {
    AppMethodBeat.i(264633);
    if (!TextUtils.isEmpty(this.Him))
    {
      aDs(this.Him);
      AppMethodBeat.o(264633);
      return;
    }
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByCancel", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = E(1, this.Hik, "cancel");
    localIntent.putExtra("scene", getIntent().getIntExtra("scene", 0));
    localIntent.putExtra("totalTime", Util.ticksToNow(this.startTime));
    try
    {
      if (!TextUtils.isEmpty(this.Hil))
      {
        JSONObject localJSONObject = new JSONObject(this.Hil);
        localIntent.putExtra("serial_id", localJSONObject.optString("serial_id"));
        bg(localJSONObject);
        AppMethodBeat.o(264633);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager", localException, "", new Object[0]);
      com.tencent.mm.plugin.flash.c.b.aDA("usrCancel");
      com.tencent.mm.plugin.flash.c.b.vC(false);
      com.tencent.mm.plugin.flash.c.b.fuO().ivK = 6;
      com.tencent.mm.plugin.flash.c.b.VL(90004);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(264633);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(264623);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264554);
        Object localObject = FaceFlashUI.a(FaceFlashUI.this);
        ((FaceFlashProcessLayout)localObject).HhR.cancel();
        ((FaceFlashProcessLayout)localObject).HhS.cancel();
        ((FaceFlashProcessLayout)localObject).HhT.cancel();
        localObject = FaceFlashUI.b(FaceFlashUI.this);
        Log.i("MicroMsg.FaceFlashManager", "release");
        ((FaceFlashPreviewLayout)localObject).Hhp.release();
        ((FaceFlashPreviewLayout)localObject).HhC.cancel();
        FaceFlashUI.c(FaceFlashUI.this).dead();
        FaceFlashUI.d(FaceFlashUI.this).dead();
        AppMethodBeat.o(264554);
      }
    });
    AppMethodBeat.o(264623);
  }
  
  public final void VF(int paramInt)
  {
    AppMethodBeat.i(264727);
    this.GsS.setIconColor(paramInt);
    AppMethodBeat.o(264727);
  }
  
  public final void aDr(String paramString)
  {
    AppMethodBeat.i(264733);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity showFailedLayout", new Object[] { Integer.valueOf(hashCode()) });
    this.Hii.ful();
    this.Hil = paramString;
    VF(com.tencent.mm.cd.a.w(getContext(), a.b.black_color));
    fuv();
    this.Hij.aDq(paramString);
    com.tencent.mm.plugin.flash.c.b.aDz(paramString);
    AppMethodBeat.o(264733);
  }
  
  public final void aDs(String paramString)
  {
    AppMethodBeat.i(264751);
    try
    {
      bf(new JSONObject(paramString));
      AppMethodBeat.o(264751);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager", paramString, "", new Object[0]);
      AppMethodBeat.o(264751);
    }
  }
  
  public final void bR(int paramInt, String paramString)
  {
    AppMethodBeat.i(264743);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByUnexpectedError", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.F("msgVerify", paramString);
    com.tencent.mm.plugin.flash.c.b.VL(paramInt);
    com.tencent.mm.plugin.flash.c.b.vC(false);
    setResult(1, E(4, paramInt, paramString));
    finish();
    AppMethodBeat.o(264743);
  }
  
  public final void bf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(264754);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishBySuccess", new Object[] { Integer.valueOf(hashCode()) });
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(264754);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.vC(true);
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.bh(paramJSONObject);
    paramJSONObject.putString("click_other_verify_btn", "no");
    paramJSONObject.putLong("totalTime", Util.ticksToNow(this.startTime));
    localIntent.putExtras(paramJSONObject);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(264754);
  }
  
  public final void bg(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(264761);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByFailed", new Object[] { Integer.valueOf(hashCode()) });
    this.Hii.Hhq.fuK();
    com.tencent.mm.plugin.flash.c.b.vC(false);
    Intent localIntent = new Intent();
    localIntent.putExtras(com.tencent.mm.plugin.flash.d.a.bh(paramJSONObject));
    setResult(1, localIntent);
    finish();
    AppMethodBeat.o(264761);
  }
  
  public void finish()
  {
    AppMethodBeat.i(264712);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finish", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.finish();
    AppMethodBeat.o(264712);
  }
  
  final void fuv()
  {
    AppMethodBeat.i(264736);
    this.Hii.setVisibility(8);
    this.Hii.onPause();
    this.Hij.setVisibility(0);
    AppMethodBeat.o(264736);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.face_flash_layout;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(264715);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onBackPressed", new Object[] { Integer.valueOf(hashCode()) });
    fuw();
    AppMethodBeat.o(264715);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(264699);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == a.e.flash_cancel) {
      fuw();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(264699);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(264768);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.FaceFlashManager", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.Hii.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(264768);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264681);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onCreate", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.aS(getIntent());
    com.tencent.mm.plugin.flash.c.b.aDA("enter");
    com.tencent.mm.plugin.flash.c.b.fuO().ivA = System.currentTimeMillis();
    getController().s(this, com.tencent.mm.cd.a.w(getContext(), a.b.White));
    this.Hii = ((FaceFlashPreviewLayout)findViewById(a.e.flash_preview_layout));
    this.Hij = ((FaceFlashProcessLayout)findViewById(a.e.flash_process_layout));
    this.GsS = ((WeImageView)findViewById(a.e.flash_cancel));
    this.GsS.setOnClickListener(this);
    this.tje.alive();
    this.Hin.alive();
    com.tencent.mm.plugin.flash.c.a.fuN();
    AppMethodBeat.o(264681);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264705);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.onDestroy();
    AppMethodBeat.o(264705);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(264692);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onPause", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    YtSDKKitFramework.getInstance().doPause();
    this.Hii.onPause();
    AppMethodBeat.o(264692);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(264687);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onResume", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    YtSDKKitFramework.getInstance().doResume();
    this.Hii.onResume();
    AppMethodBeat.o(264687);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(264746);
    Log.i("MicroMsg.FaceFlashManager", "onSwipeBack");
    fuw();
    super.onSwipeBack();
    AppMethodBeat.o(264746);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(264721);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity reset", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.aDA("reset");
    com.tencent.mm.plugin.flash.c.b.fuO().ivA = System.currentTimeMillis();
    VF(com.tencent.mm.cd.a.w(getContext(), a.b.black));
    this.Hil = "";
    this.Him = "";
    this.Hii.reset();
    this.Hii.setVisibility(0);
    this.Hii.onResume();
    this.Hij.setVisibility(8);
    long l = com.tencent.mm.plugin.flash.c.b.fuQ().ivd;
    com.tencent.mm.plugin.flash.c.b.fuQ().ivd = (l + 1L);
    AppMethodBeat.o(264721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashUI
 * JD-Core Version:    0.7.0.1
 */