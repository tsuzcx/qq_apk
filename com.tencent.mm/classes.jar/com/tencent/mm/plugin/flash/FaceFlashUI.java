package com.tencent.mm.plugin.flash;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.ha;
import com.tencent.mm.f.b.a.bg;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.flash.b.d;
import com.tencent.mm.plugin.flash.b.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONObject;

public class FaceFlashUI
  extends MMActivity
  implements View.OnClickListener
{
  private WeImageView AQI;
  FaceFlashPreviewLayout BAK;
  FaceFlashProcessLayout BAL;
  private int BAM;
  private String BAN;
  String BAO;
  private IListener BAP;
  private IListener qep;
  private long startTime;
  
  public FaceFlashUI()
  {
    AppMethodBeat.i(190596);
    this.BAM = 90004;
    this.BAN = "";
    this.BAO = "";
    this.startTime = Util.currentTicks();
    this.qep = new IListener() {};
    this.BAP = new IListener() {};
    AppMethodBeat.o(190596);
  }
  
  private static Intent A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(190683);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManager", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(190683);
    return localIntent;
  }
  
  public static boolean d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(190605);
    Object localObject = new FaceFlashUI.1(paramActivity);
    if ((!com.tencent.mm.q.a.b(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.c(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.a(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.e(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.d(paramActivity, (DialogInterface.OnClickListener)localObject)))
    {
      localObject = new Intent(paramActivity, FaceFlashUI.class);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      paramActivity.startActivityForResult((Intent)localObject, 1);
      AppMethodBeat.o(190605);
      return true;
    }
    AppMethodBeat.o(190605);
    return false;
  }
  
  private void epu()
  {
    AppMethodBeat.i(190665);
    if (!TextUtils.isEmpty(this.BAO))
    {
      aHa(this.BAO);
      AppMethodBeat.o(190665);
      return;
    }
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByCancel", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = A(1, this.BAM, "cancel");
    localIntent.putExtra("scene", getIntent().getIntExtra("scene", 0));
    localIntent.putExtra("totalTime", Util.ticksToNow(this.startTime));
    try
    {
      if (!TextUtils.isEmpty(this.BAN))
      {
        JSONObject localJSONObject = new JSONObject(this.BAN);
        localIntent.putExtra("serial_id", localJSONObject.optString("serial_id"));
        aT(localJSONObject);
        AppMethodBeat.o(190665);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager", localException, "", new Object[0]);
      com.tencent.mm.plugin.flash.c.b.aHi("usrCancel");
      com.tencent.mm.plugin.flash.c.b.rL(false);
      com.tencent.mm.plugin.flash.c.b.epM().gmH = 6;
      com.tencent.mm.plugin.flash.c.b.Ss(90004);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(190665);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(190639);
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197115);
        Object localObject = FaceFlashUI.a(FaceFlashUI.this);
        ((FaceFlashProcessLayout)localObject).BAt.cancel();
        ((FaceFlashProcessLayout)localObject).BAu.cancel();
        ((FaceFlashProcessLayout)localObject).BAv.cancel();
        localObject = FaceFlashUI.b(FaceFlashUI.this);
        Log.i("MicroMsg.FaceFlashManager", "release");
        ((FaceFlashPreviewLayout)localObject).BzC.clearAnimation();
        ((FaceFlashPreviewLayout)localObject).BzD.clearAnimation();
        ((FaceFlashPreviewLayout)localObject).BzN.release();
        ((FaceFlashPreviewLayout)localObject).BAd.cancel();
        FaceFlashUI.c(FaceFlashUI.this).dead();
        EventCenter.instance.removeListener(FaceFlashUI.d(FaceFlashUI.this));
        AppMethodBeat.o(197115);
      }
    });
    AppMethodBeat.o(190639);
  }
  
  public final void Sm(int paramInt)
  {
    AppMethodBeat.i(190641);
    this.AQI.setIconColor(paramInt);
    AppMethodBeat.o(190641);
  }
  
  public final void aGZ(String paramString)
  {
    AppMethodBeat.i(190649);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity showFailedLayout", new Object[] { Integer.valueOf(hashCode()) });
    this.BAK.epj();
    this.BAN = paramString;
    Sm(com.tencent.mm.ci.a.w(getContext(), a.b.black_color));
    ept();
    this.BAL.aGY(paramString);
    com.tencent.mm.plugin.flash.c.b.aHh(paramString);
    AppMethodBeat.o(190649);
  }
  
  public final void aHa(String paramString)
  {
    AppMethodBeat.i(190670);
    try
    {
      aS(new JSONObject(paramString));
      AppMethodBeat.o(190670);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager", paramString, "", new Object[0]);
      AppMethodBeat.o(190670);
    }
  }
  
  public final void aS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190676);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishBySuccess", new Object[] { Integer.valueOf(hashCode()) });
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(190676);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.rL(true);
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.aU(paramJSONObject);
    paramJSONObject.putString("click_other_verify_btn", "no");
    paramJSONObject.putLong("totalTime", Util.ticksToNow(this.startTime));
    localIntent.putExtras(paramJSONObject);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(190676);
  }
  
  public final void aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190679);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByFailed", new Object[] { Integer.valueOf(hashCode()) });
    this.BAK.BzO.epI();
    com.tencent.mm.plugin.flash.c.b.rL(false);
    Intent localIntent = new Intent();
    localIntent.putExtras(com.tencent.mm.plugin.flash.d.a.aU(paramJSONObject));
    setResult(1, localIntent);
    finish();
    AppMethodBeat.o(190679);
  }
  
  public final void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(190654);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByUnexpectedError", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.s("msgVerify", paramString);
    com.tencent.mm.plugin.flash.c.b.Ss(paramInt);
    com.tencent.mm.plugin.flash.c.b.rL(false);
    setResult(1, A(4, paramInt, paramString));
    finish();
    AppMethodBeat.o(190654);
  }
  
  final void ept()
  {
    AppMethodBeat.i(190652);
    this.BAK.setVisibility(8);
    this.BAK.onPause();
    this.BAL.setVisibility(0);
    AppMethodBeat.o(190652);
  }
  
  public void finish()
  {
    AppMethodBeat.i(190629);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finish", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.finish();
    AppMethodBeat.o(190629);
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
    AppMethodBeat.i(190632);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onBackPressed", new Object[] { Integer.valueOf(hashCode()) });
    epu();
    AppMethodBeat.o(190632);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(190621);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == a.e.flash_cancel) {
      epu();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190621);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(190687);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.FaceFlashManager", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.BAK.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(190687);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190609);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onCreate", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.az(getIntent());
    com.tencent.mm.plugin.flash.c.b.aHi("enter");
    com.tencent.mm.plugin.flash.c.b.epM().gmw = System.currentTimeMillis();
    getController().q(this, com.tencent.mm.ci.a.w(getContext(), a.b.White));
    this.BAK = ((FaceFlashPreviewLayout)findViewById(a.e.flash_preview_layout));
    this.BAL = ((FaceFlashProcessLayout)findViewById(a.e.flash_process_layout));
    this.AQI = ((WeImageView)findViewById(a.e.flash_cancel));
    this.AQI.setOnClickListener(this);
    this.qep.alive();
    EventCenter.instance.addListener(this.BAP);
    com.tencent.mm.plugin.flash.c.a.epL();
    AppMethodBeat.o(190609);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190625);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.onDestroy();
    AppMethodBeat.o(190625);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190616);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onPause", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    YtSDKKitFramework.getInstance().doPause();
    this.BAK.onPause();
    AppMethodBeat.o(190616);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190615);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onResume", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    YtSDKKitFramework.getInstance().doResume();
    this.BAK.onResume();
    AppMethodBeat.o(190615);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(190656);
    Log.i("MicroMsg.FaceFlashManager", "onSwipeBack");
    epu();
    super.onSwipeBack();
    AppMethodBeat.o(190656);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(190637);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity reset", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.aHi("reset");
    com.tencent.mm.plugin.flash.c.b.epM().gmw = System.currentTimeMillis();
    Sm(com.tencent.mm.ci.a.w(getContext(), a.b.black));
    this.BAN = "";
    this.BAO = "";
    this.BAK.reset();
    this.BAK.setVisibility(0);
    this.BAK.onResume();
    this.BAL.setVisibility(8);
    long l = com.tencent.mm.plugin.flash.c.b.epO().glZ;
    com.tencent.mm.plugin.flash.c.b.epO().glZ = (l + 1L);
    AppMethodBeat.o(190637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashUI
 * JD-Core Version:    0.7.0.1
 */