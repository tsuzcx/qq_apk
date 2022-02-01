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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.plugin.flash.b.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONObject;

public class FaceFlashUI
  extends MMActivity
  implements View.OnClickListener
{
  private IListener ndY;
  private long startTime;
  FaceFlashPreviewLayout wHK;
  FaceFlashProcessLayout wHL;
  int wHM;
  private String wHN;
  String wHO;
  private IListener wHP;
  private WeImageView wgU;
  
  public FaceFlashUI()
  {
    AppMethodBeat.i(186484);
    this.wHM = 90004;
    this.wHN = "";
    this.wHO = "";
    this.startTime = Util.currentTicks();
    this.ndY = new IListener() {};
    this.wHP = new FaceFlashUI.3(this);
    AppMethodBeat.o(186484);
  }
  
  public static boolean a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(186485);
    Object localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186478);
        com.tencent.mm.plugin.flash.c.b.s("msgVerify", "camera or mic 正在被占用");
        com.tencent.mm.plugin.flash.c.b.MW(90033);
        this.dnO.setResult(1, FaceFlashUI.axh("finish by voip call"));
        this.dnO.finish();
        AppMethodBeat.o(186478);
      }
    };
    if ((!com.tencent.mm.q.a.b(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.c(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.a(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.e(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.d(paramActivity, (DialogInterface.OnClickListener)localObject)))
    {
      localObject = new Intent(paramActivity, FaceFlashUI.class);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      AppMethodBeat.o(186485);
      return true;
    }
    AppMethodBeat.o(186485);
    return false;
  }
  
  private void dKT()
  {
    AppMethodBeat.i(186499);
    if (!TextUtils.isEmpty(this.wHO))
    {
      axg(this.wHO);
      AppMethodBeat.o(186499);
      return;
    }
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByCancel", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = y(1, this.wHM, "cancel");
    localIntent.putExtra("scene", getIntent().getIntExtra("scene", 0));
    localIntent.putExtra("totalTime", Util.ticksToNow(this.startTime));
    try
    {
      if (!TextUtils.isEmpty(this.wHN))
      {
        JSONObject localJSONObject = new JSONObject(this.wHN);
        localIntent.putExtra("serial_id", localJSONObject.optString("serial_id"));
        aO(localJSONObject);
        AppMethodBeat.o(186499);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager", localException, "", new Object[0]);
      com.tencent.mm.plugin.flash.c.b.axn("usrCancel");
      com.tencent.mm.plugin.flash.c.b.pr(false);
      com.tencent.mm.plugin.flash.c.b.MW(90004);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(186499);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(186494);
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186482);
        Object localObject = FaceFlashUI.a(FaceFlashUI.this);
        ((FaceFlashProcessLayout)localObject).wHB.cancel();
        ((FaceFlashProcessLayout)localObject).wHC.cancel();
        ((FaceFlashProcessLayout)localObject).wHD.cancel();
        localObject = FaceFlashUI.b(FaceFlashUI.this);
        Log.i("MicroMsg.FaceFlashManager", "release");
        ((FaceFlashPreviewLayout)localObject).wGG.clearAnimation();
        ((FaceFlashPreviewLayout)localObject).wGH.clearAnimation();
        a.dKS();
        ((FaceFlashPreviewLayout)localObject).wGO.dKU();
        ((FaceFlashPreviewLayout)localObject).wGR.release();
        ((FaceFlashPreviewLayout)localObject).wHi.cancel();
        if (((FaceFlashPreviewLayout)localObject).wHc != null)
        {
          ((FaceFlashPreviewLayout)localObject).wHc.cancel(true);
          ((FaceFlashPreviewLayout)localObject).wHc = null;
        }
        FaceFlashUI.c(FaceFlashUI.this).dead();
        EventCenter.instance.removeListener(FaceFlashUI.d(FaceFlashUI.this));
        AppMethodBeat.o(186482);
      }
    });
    AppMethodBeat.o(186494);
  }
  
  private static Intent y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(186503);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManager", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(186503);
    return localIntent;
  }
  
  public final void MP(int paramInt)
  {
    AppMethodBeat.i(186495);
    this.wgU.setIconColor(paramInt);
    AppMethodBeat.o(186495);
  }
  
  public final void aN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186501);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishBySuccess", new Object[] { Integer.valueOf(hashCode()) });
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(186501);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.pr(true);
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.aP(paramJSONObject);
    paramJSONObject.putString("click_other_verify_btn", "no");
    paramJSONObject.putLong("totalTime", Util.ticksToNow(this.startTime));
    localIntent.putExtras(paramJSONObject);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(186501);
  }
  
  public final void aO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186502);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByFailed", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.pr(false);
    Intent localIntent = new Intent();
    localIntent.putExtras(com.tencent.mm.plugin.flash.d.a.aP(paramJSONObject));
    setResult(1, localIntent);
    finish();
    AppMethodBeat.o(186502);
  }
  
  public final void axf(String paramString)
  {
    AppMethodBeat.i(186496);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity showFailedLayout", new Object[] { Integer.valueOf(hashCode()) });
    this.wHM = 90006;
    this.wHN = paramString;
    MP(com.tencent.mm.cb.a.n(getContext(), 2131100044));
    this.wHK.setVisibility(8);
    this.wHL.setVisibility(0);
    this.wHL.axe(paramString);
    com.tencent.mm.plugin.flash.c.b.axl(paramString);
    AppMethodBeat.o(186496);
  }
  
  public final void axg(String paramString)
  {
    AppMethodBeat.i(186500);
    try
    {
      aN(new JSONObject(paramString));
      AppMethodBeat.o(186500);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager", paramString, "", new Object[0]);
      AppMethodBeat.o(186500);
    }
  }
  
  public final void bm(int paramInt, String paramString)
  {
    AppMethodBeat.i(186497);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finishByUnexpectedError", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.s("msgVerify", paramString);
    com.tencent.mm.plugin.flash.c.b.MW(paramInt);
    com.tencent.mm.plugin.flash.c.b.pr(false);
    setResult(1, y(4, paramInt, paramString));
    finish();
    AppMethodBeat.o(186497);
  }
  
  public void finish()
  {
    AppMethodBeat.i(186491);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity finish", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.finish();
    AppMethodBeat.o(186491);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494069;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(186492);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onBackPressed", new Object[] { Integer.valueOf(hashCode()) });
    dKT();
    AppMethodBeat.o(186492);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(186489);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131301569) {
      dKT();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(186489);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(186504);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.FaceFlashManager", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.wHK.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(186504);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186486);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onCreate", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.au(getIntent());
    com.tencent.mm.plugin.flash.c.b.axn("enter");
    com.tencent.mm.plugin.flash.c.b.dLi().erd = System.currentTimeMillis();
    getController().p(this, com.tencent.mm.cb.a.n(getContext(), 2131099844));
    this.wHK = ((FaceFlashPreviewLayout)findViewById(2131301572));
    this.wHL = ((FaceFlashProcessLayout)findViewById(2131301573));
    this.wgU = ((WeImageView)findViewById(2131301569));
    this.wgU.setOnClickListener(this);
    this.ndY.alive();
    EventCenter.instance.addListener(this.wHP);
    com.tencent.mm.plugin.flash.c.a.dLh();
    AppMethodBeat.o(186486);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186490);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.onDestroy();
    AppMethodBeat.o(186490);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(186488);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onPause", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    YtSDKKitFramework.getInstance().doPause();
    FaceFlashPreviewLayout localFaceFlashPreviewLayout = this.wHK;
    localFaceFlashPreviewLayout.wGO.stopPreview();
    localFaceFlashPreviewLayout.dKO();
    AppMethodBeat.o(186488);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186487);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onResume", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    YtSDKKitFramework.getInstance().doResume();
    FaceFlashPreviewLayout localFaceFlashPreviewLayout = this.wHK;
    if (localFaceFlashPreviewLayout.wHb == -1) {
      localFaceFlashPreviewLayout.wHb = localFaceFlashPreviewLayout.getDegree();
    }
    if ((localFaceFlashPreviewLayout.getVisibility() == 0) && (!localFaceFlashPreviewLayout.wGO.sZd) && (localFaceFlashPreviewLayout.ltm != null) && (localFaceFlashPreviewLayout.wGK.getVisibility() != 0)) {
      localFaceFlashPreviewLayout.wGO.a(localFaceFlashPreviewLayout.ltm, new FaceFlashPreviewLayout.10(localFaceFlashPreviewLayout));
    }
    AppMethodBeat.o(186487);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(186498);
    Log.i("MicroMsg.FaceFlashManager", "onSwipeBack");
    dKT();
    super.onSwipeBack();
    AppMethodBeat.o(186498);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(186493);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity reset", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.axn("reset");
    com.tencent.mm.plugin.flash.c.b.dLi().erd = System.currentTimeMillis();
    MP(com.tencent.mm.cb.a.n(getContext(), 2131100042));
    this.wHN = "";
    this.wHO = "";
    this.wHK.reset();
    this.wHK.setVisibility(0);
    this.wHL.setVisibility(8);
    long l = com.tencent.mm.plugin.flash.c.b.dLk().eqF;
    com.tencent.mm.plugin.flash.c.b.dLk().eqF = (l + 1L);
    AppMethodBeat.o(186493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashUI
 * JD-Core Version:    0.7.0.1
 */