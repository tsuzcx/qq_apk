package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONObject;

public class FaceFlashActionUI
  extends MMActivity
  implements View.OnClickListener
{
  private IListener ndY;
  private long startTime;
  int wHM;
  private String wHN;
  String wHO;
  private IListener wHP;
  FaceFlashActionPreviewLayout wIg;
  FaceFlashActionProcessLayout wIh;
  private WeImageView wgU;
  
  public FaceFlashActionUI()
  {
    AppMethodBeat.i(186585);
    this.wHM = 90004;
    this.wHN = "";
    this.wHO = "";
    this.startTime = Util.currentTicks();
    this.ndY = new IListener() {};
    this.wHP = new FaceFlashActionUI.3(this);
    AppMethodBeat.o(186585);
  }
  
  public static boolean d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(186586);
    Object localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186580);
        com.tencent.mm.plugin.flash.c.b.MX(90033);
        this.dnO.setResult(1, FaceFlashActionUI.axh("finish by voip call"));
        this.dnO.finish();
        AppMethodBeat.o(186580);
      }
    };
    if ((!com.tencent.mm.q.a.b(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.c(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.a(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.e(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.d(paramActivity, (DialogInterface.OnClickListener)localObject)))
    {
      localObject = new Intent(paramActivity, FaceFlashActionUI.class);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      paramActivity.startActivityForResult((Intent)localObject, 1);
      AppMethodBeat.o(186586);
      return true;
    }
    AppMethodBeat.o(186586);
    return false;
  }
  
  private void dKT()
  {
    AppMethodBeat.i(186600);
    if (!TextUtils.isEmpty(this.wHO))
    {
      axg(this.wHO);
      AppMethodBeat.o(186600);
      return;
    }
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishByCancel", new Object[] { Integer.valueOf(hashCode()) });
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
        AppMethodBeat.o(186600);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager.FaceFlashActionUI", localException, "", new Object[0]);
      com.tencent.mm.plugin.flash.c.b.axn("usrCancel");
      com.tencent.mm.plugin.flash.c.b.MX(90004);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(186600);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(186595);
    this.wIh.release();
    this.wIg.release();
    this.ndY.dead();
    EventCenter.instance.removeListener(this.wHP);
    AppMethodBeat.o(186595);
  }
  
  private static Intent y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(186604);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(186604);
    return localIntent;
  }
  
  public final void MP(int paramInt)
  {
    AppMethodBeat.i(186596);
    this.wgU.setIconColor(paramInt);
    AppMethodBeat.o(186596);
  }
  
  public final void MQ(int paramInt)
  {
    AppMethodBeat.i(186598);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishByUnexpectedError", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.MX(paramInt);
    setResult(1, y(4, paramInt, "fail"));
    finish();
    AppMethodBeat.o(186598);
  }
  
  public final void aN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186602);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishBySuccess", new Object[] { Integer.valueOf(hashCode()) });
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(186602);
      return;
    }
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.aP(paramJSONObject);
    paramJSONObject.putString("err_msg", "ok");
    paramJSONObject.putString("click_other_verify_btn", "no");
    paramJSONObject.putLong("totalTime", Util.ticksToNow(this.startTime));
    localIntent.putExtras(paramJSONObject);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(186602);
  }
  
  public final void aO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186603);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finishByFailed", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.aP(paramJSONObject);
    paramJSONObject.putString("err_msg", "fail");
    localIntent.putExtras(paramJSONObject);
    setResult(1, localIntent);
    finish();
    AppMethodBeat.o(186603);
  }
  
  public final void axf(String paramString)
  {
    AppMethodBeat.i(186597);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity showFailedLayout", new Object[] { Integer.valueOf(hashCode()) });
    this.wHM = 90006;
    this.wHN = paramString;
    com.tencent.mm.plugin.flash.c.b.axm(paramString);
    MP(com.tencent.mm.cb.a.n(getContext(), 2131100044));
    this.wIg.setVisibility(8);
    this.wIh.setVisibility(0);
    this.wIh.axe(paramString);
    AppMethodBeat.o(186597);
  }
  
  public final void axg(String paramString)
  {
    AppMethodBeat.i(186601);
    try
    {
      aN(new JSONObject(paramString));
      AppMethodBeat.o(186601);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManager.FaceFlashActionUI", paramString, "", new Object[0]);
      AppMethodBeat.o(186601);
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(186592);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity finish", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.finish();
    AppMethodBeat.o(186592);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494067;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(186593);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onBackPressed", new Object[] { Integer.valueOf(hashCode()) });
    dKT();
    AppMethodBeat.o(186593);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(186590);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131301569) {
      dKT();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(186590);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186587);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onCreate", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.axn("enter");
    super.onCreate(paramBundle);
    getController().p(this, com.tencent.mm.cb.a.n(getContext(), 2131099844));
    this.wIg = ((FaceFlashActionPreviewLayout)findViewById(2131301572));
    this.wIh = ((FaceFlashActionProcessLayout)findViewById(2131301573));
    this.wgU = ((WeImageView)findViewById(2131301569));
    this.wgU.setOnClickListener(this);
    this.ndY.alive();
    EventCenter.instance.addListener(this.wHP);
    com.tencent.mm.plugin.flash.c.a.dLh();
    AppMethodBeat.o(186587);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186591);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.onDestroy();
    AppMethodBeat.o(186591);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(186589);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onPause", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    YtSDKKitFramework.getInstance().doPause();
    FaceFlashActionPreviewLayout localFaceFlashActionPreviewLayout = this.wIg;
    localFaceFlashActionPreviewLayout.wGO.stopPreview();
    localFaceFlashActionPreviewLayout.dKO();
    AppMethodBeat.o(186589);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186588);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity onResume", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    YtSDKKitFramework.getInstance().doResume();
    FaceFlashActionPreviewLayout localFaceFlashActionPreviewLayout = this.wIg;
    if ((localFaceFlashActionPreviewLayout.getVisibility() == 0) && (!localFaceFlashActionPreviewLayout.wGO.sZd) && (localFaceFlashActionPreviewLayout.ltm != null) && (localFaceFlashActionPreviewLayout.wGK.getVisibility() != 0)) {
      localFaceFlashActionPreviewLayout.wGO.a(localFaceFlashActionPreviewLayout.ltm, new FaceFlashActionPreviewLayout.7(localFaceFlashActionPreviewLayout));
    }
    AppMethodBeat.o(186588);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(186599);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "onSwipeBack");
    dKT();
    super.onSwipeBack();
    AppMethodBeat.o(186599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(186594);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity reset", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.axn("reset");
    MP(com.tencent.mm.cb.a.n(getContext(), 2131100042));
    this.wHN = "";
    this.wHO = "";
    this.wIg.reset();
    this.wIg.setVisibility(0);
    this.wIh.setVisibility(8);
    AppMethodBeat.o(186594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionUI
 * JD-Core Version:    0.7.0.1
 */