package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.ha;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.flash.b.g;
import com.tencent.mm.plugin.flash.c;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashActionUI
  extends MMActivity
  implements View.OnClickListener
{
  private WeImageView AQI;
  int BAM;
  private String BAN;
  String BAO;
  private IListener BAP;
  FaceFlashActionPreviewLayout BBo;
  FaceFlashActionProcessLayout BBp;
  private IListener qep;
  private long startTime;
  
  public FaceFlashActionUI()
  {
    AppMethodBeat.i(197269);
    this.BAM = 90004;
    this.BAN = "";
    this.BAO = "";
    this.startTime = Util.currentTicks();
    this.qep = new IListener() {};
    this.BAP = new IListener() {};
    AppMethodBeat.o(197269);
  }
  
  private static Intent A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(197369);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashActionUI", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(197369);
    return localIntent;
  }
  
  public static boolean d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(197274);
    Object localObject = new FaceFlashActionUI.1(paramActivity);
    if ((!com.tencent.mm.q.a.b(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.c(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.a(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.e(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.q.a.d(paramActivity, (DialogInterface.OnClickListener)localObject)))
    {
      localObject = new Intent(paramActivity, FaceFlashActionUI.class);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      paramActivity.startActivityForResult((Intent)localObject, 1);
      AppMethodBeat.o(197274);
      return true;
    }
    AppMethodBeat.o(197274);
    return false;
  }
  
  private void epu()
  {
    AppMethodBeat.i(197357);
    if (!TextUtils.isEmpty(this.BAO))
    {
      aHa(this.BAO);
      AppMethodBeat.o(197357);
      return;
    }
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishByCancel", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = A(1, this.BAM, "cancel");
    localIntent.putExtra("scene", getIntent().getIntExtra("scene", 0));
    localIntent.putExtra("totalTime", Util.ticksToNow(this.startTime));
    try
    {
      if (!TextUtils.isEmpty(this.BAN))
      {
        JSONObject localJSONObject = new JSONObject(this.BAN);
        localIntent.putExtra("serial_id", localJSONObject.optString("serial_id"));
        if (com.tencent.mm.plugin.flash.d.a.aV(localJSONObject))
        {
          if (!this.BBo.epx()) {
            break label189;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
        }
        for (;;)
        {
          aT(localJSONObject);
          AppMethodBeat.o(197357);
          return;
          label189:
          com.tencent.mm.plugin.report.service.h.IzE.a(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0) });
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashActionUI", localException, "", new Object[0]);
      com.tencent.mm.plugin.flash.c.b.aHi("usrCancel");
      com.tencent.mm.plugin.flash.c.b.epN().gmH = 6;
      com.tencent.mm.plugin.flash.c.b.St(90004);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(197357);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(197316);
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197096);
        Object localObject = FaceFlashActionUI.a(FaceFlashActionUI.this);
        ((FaceFlashActionProcessLayout)localObject).BAt.cancel();
        ((FaceFlashActionProcessLayout)localObject).BAu.cancel();
        ((FaceFlashActionProcessLayout)localObject).BAv.cancel();
        localObject = FaceFlashActionUI.b(FaceFlashActionUI.this);
        Log.i("MicroMsg.FaceFlashActionPreviewLayout", "release");
        ((FaceFlashActionPreviewLayout)localObject).BzC.clearAnimation();
        ((FaceFlashActionPreviewLayout)localObject).BzD.clearAnimation();
        com.tencent.mm.plugin.flash.b.eps();
        ((FaceFlashActionPreviewLayout)localObject).BAB.release();
        if (((FaceFlashActionPreviewLayout)localObject).BzN != null) {
          ((FaceFlashActionPreviewLayout)localObject).BzN.release();
        }
        ((FaceFlashActionPreviewLayout)localObject).BAd.cancel();
        if (((FaceFlashActionPreviewLayout)localObject).BBa != null)
        {
          ((FaceFlashActionPreviewLayout)localObject).BBa.cancel(true);
          ((FaceFlashActionPreviewLayout)localObject).BBa = null;
        }
        com.tencent.mm.kernel.h.aGY().b(5965, (com.tencent.mm.an.i)localObject);
        AppMethodBeat.o(197096);
      }
    });
    this.qep.dead();
    EventCenter.instance.removeListener(this.BAP);
    AppMethodBeat.o(197316);
  }
  
  public final void Sm(int paramInt)
  {
    AppMethodBeat.i(197319);
    this.AQI.setIconColor(paramInt);
    AppMethodBeat.o(197319);
  }
  
  public final void aGZ(String paramString)
  {
    AppMethodBeat.i(197342);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity showFailedLayout", new Object[] { Integer.valueOf(hashCode()) });
    this.BAM = 90006;
    this.BAN = paramString;
    Sm(com.tencent.mm.ci.a.w(getContext(), a.b.BW_0));
    this.BBo.setVisibility(8);
    this.BBp.setVisibility(0);
    this.BBp.setCircleY(this.BBo.getCircleY());
    this.BBp.BBl = this.BBo.epw();
    localFaceFlashActionProcessLayout = this.BBp;
    i = getContentView().getHeight();
    Log.i(FaceFlashActionProcessLayout.TAG, "showFailedAnimation");
    for (;;)
    {
      try
      {
        if (!localFaceFlashActionProcessLayout.BBl) {
          continue;
        }
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BBj.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        i -= ar.getStatusBarHeight(localFaceFlashActionProcessLayout.getContext());
        if ((int)localFaceFlashActionProcessLayout.BBk <= i * 0.5D) {
          continue;
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(i * 0.5D) - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 100));
        localFaceFlashActionProcessLayout.BBj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        JSONObject localJSONObject;
        Object localObject3;
        String str;
        SpannableString localSpannableString;
        Log.printErrStackTrace(FaceFlashActionProcessLayout.BAm, localJSONException, "parse face failed result error.%s", new Object[] { paramString });
        localFaceFlashActionProcessLayout.BAn.setText(paramString);
        localFaceFlashActionProcessLayout.BAs.setVisibility(4);
        localFaceFlashActionProcessLayout.BAr.setVisibility(0);
        localFaceFlashActionProcessLayout.BAr.setText(com.tencent.mm.ci.a.ba(localFaceFlashActionProcessLayout.getContext(), a.i.face_try_again));
        localFaceFlashActionProcessLayout.BAr.setOnClickListener(new FaceFlashActionProcessLayout.4(localFaceFlashActionProcessLayout));
        continue;
        Object localObject2 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BBj.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.e.face_flash_header_tip);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 48);
        localFaceFlashActionProcessLayout.BBj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        continue;
        com.tencent.mm.plugin.flash.c.b.s("msgVerify", str);
        localObject2 = str;
        continue;
        localFaceFlashActionProcessLayout.BAr.setBackgroundResource(a.d.face_green_btn_bg);
        localFaceFlashActionProcessLayout.BAr.setTextColor(localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.face_green_btn_selector));
        localFaceFlashActionProcessLayout.BBi.setVisibility(0);
        localFaceFlashActionProcessLayout.BBi.setText(str);
        localFaceFlashActionProcessLayout.BBi.setOnClickListener(new FaceFlashActionProcessLayout.1(localFaceFlashActionProcessLayout, localJSONObject));
        continue;
        localObject2 = com.tencent.mm.ci.a.ba(localFaceFlashActionProcessLayout.getContext(), a.i.face_result_confirm_btn);
        continue;
        i = 0;
        continue;
        boolean bool = false;
        continue;
      }
      localFaceFlashActionProcessLayout.BAq.setImageResource(a.d.face_flash_fail_circle);
      localFaceFlashActionProcessLayout.BAq.startAnimation(localFaceFlashActionProcessLayout.BAt);
      localFaceFlashActionProcessLayout.BAp.setImageDrawable(com.tencent.mm.ci.a.m(localFaceFlashActionProcessLayout.getContext(), a.h.icons_filled_error3));
      localFaceFlashActionProcessLayout.BAp.startAnimation(localFaceFlashActionProcessLayout.BAv);
      localJSONObject = new JSONObject(paramString);
      localObject3 = localFaceFlashActionProcessLayout.BAn;
      localObject1 = com.tencent.mm.ci.a.ba(localFaceFlashActionProcessLayout.getContext(), a.i.face_compare_fail);
      str = localJSONObject.optString("err_tip", localJSONObject.optString("message", localJSONObject.optString("errormsg", localJSONObject.optString("err_msg", (String)localObject1))));
      if (!TextUtils.isEmpty(str)) {
        continue;
      }
      com.tencent.mm.plugin.flash.c.b.s("msgVerify", localObject1);
      ((TextView)localObject3).setText((CharSequence)localObject1);
      str = localJSONObject.optString("otherVerifyTitle");
      Log.i(FaceFlashActionProcessLayout.TAG, "otherVerifyTitle is :%s", new Object[] { str });
      if (!TextUtils.isEmpty(str)) {
        continue;
      }
      localFaceFlashActionProcessLayout.BBi.setVisibility(4);
      localFaceFlashActionProcessLayout.BAr.setBackgroundResource(a.d.face_white_btn_bg);
      localFaceFlashActionProcessLayout.BAr.setTextColor(localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.face_white_btn_selector));
      localObject1 = localJSONObject.optString("err_feedback", "");
      localObject3 = localFaceFlashActionProcessLayout.BAs;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        continue;
      }
      i = 4;
      ((TextView)localObject3).setVisibility(i);
      ar.a(localFaceFlashActionProcessLayout.BAs.getPaint(), 0.8F);
      localObject3 = localFaceFlashActionProcessLayout.getContext().getResources().getString(a.i.face_detect_feedback);
      localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(new com.tencent.mm.plugin.facedetectaction.ui.a((String)localObject3, localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.link_color), localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.UN_BW_0_Alpha_0_2), new FaceFlashActionProcessLayout.2(localFaceFlashActionProcessLayout, localJSONObject, (String)localObject1)), 0, localSpannableString.length(), 17);
      localFaceFlashActionProcessLayout.BAs.setClickable(true);
      localFaceFlashActionProcessLayout.BAs.setOnTouchListener(new o(localFaceFlashActionProcessLayout.getContext()));
      localFaceFlashActionProcessLayout.BAs.setText(localSpannableString);
      if (localJSONObject.optInt("err_retry", 1) != 1) {
        continue;
      }
      bool = true;
      localFaceFlashActionProcessLayout.BAr.setVisibility(0);
      localObject3 = localFaceFlashActionProcessLayout.BAr;
      if (!bool) {
        continue;
      }
      localObject1 = com.tencent.mm.ci.a.ba(localFaceFlashActionProcessLayout.getContext(), a.i.face_try_again);
      ((Button)localObject3).setText((CharSequence)localObject1);
      localFaceFlashActionProcessLayout.BAr.setOnClickListener(new FaceFlashActionProcessLayout.3(localFaceFlashActionProcessLayout, bool, localJSONObject, str));
      if ((localFaceFlashActionProcessLayout.BBi.getVisibility() == 0) && (localFaceFlashActionProcessLayout.BAs.getVisibility() == 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BBi.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 108);
        localFaceFlashActionProcessLayout.BBi.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BAr.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, a.e.face_flash_bottom_custom);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 16);
        localFaceFlashActionProcessLayout.BAr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if ((localFaceFlashActionProcessLayout.BBi.getVisibility() != 0) && (localFaceFlashActionProcessLayout.BAs.getVisibility() != 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BAr.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 96);
        localFaceFlashActionProcessLayout.BAr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if ((localFaceFlashActionProcessLayout.BBi.getVisibility() == 0) && (localFaceFlashActionProcessLayout.BAs.getVisibility() != 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BBi.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 96);
        localFaceFlashActionProcessLayout.BBi.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BAr.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, a.e.face_flash_bottom_custom);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 16);
        localFaceFlashActionProcessLayout.BAr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if ((localFaceFlashActionProcessLayout.BBi.getVisibility() != 0) && (localFaceFlashActionProcessLayout.BAs.getVisibility() == 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.BAr.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 108);
        localFaceFlashActionProcessLayout.BAr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      com.tencent.mm.plugin.flash.c.b.es(paramString, 1);
      AppMethodBeat.o(197342);
      return;
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)localFaceFlashActionProcessLayout.BBk - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 100));
    }
  }
  
  final void aHa(String paramString)
  {
    AppMethodBeat.i(197358);
    try
    {
      aS(new JSONObject(paramString));
      AppMethodBeat.o(197358);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashActionUI", paramString, "", new Object[0]);
      AppMethodBeat.o(197358);
    }
  }
  
  public final void aS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(197360);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishBySuccess", new Object[] { Integer.valueOf(hashCode()) });
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(197360);
      return;
    }
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.aU(paramJSONObject);
    paramJSONObject.putString("err_msg", "ok");
    paramJSONObject.putString("click_other_verify_btn", "no");
    paramJSONObject.putLong("totalTime", Util.ticksToNow(this.startTime));
    localIntent.putExtras(paramJSONObject);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(197360);
  }
  
  public final void aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(197363);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishByFailed", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.aU(paramJSONObject);
    paramJSONObject.putString("err_msg", "fail");
    localIntent.putExtras(paramJSONObject);
    setResult(1, localIntent);
    finish();
    AppMethodBeat.o(197363);
  }
  
  public final void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(197345);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishByUnexpectedError", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.s("msgVerify", paramString);
    com.tencent.mm.plugin.flash.c.b.St(paramInt);
    setResult(1, A(4, paramInt, "fail"));
    finish();
    AppMethodBeat.o(197345);
  }
  
  public void finish()
  {
    AppMethodBeat.i(197306);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finish", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.finish();
    AppMethodBeat.o(197306);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.face_flash_action_layout;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(197310);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onBackPressed", new Object[] { Integer.valueOf(hashCode()) });
    epu();
    AppMethodBeat.o(197310);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(197298);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == a.e.flash_cancel) {
      epu();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(197298);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197285);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onCreate", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.aHi("enter");
    super.onCreate(paramBundle);
    getController().q(this, com.tencent.mm.ci.a.w(getContext(), a.b.White));
    this.BBo = ((FaceFlashActionPreviewLayout)findViewById(a.e.flash_preview_layout));
    this.BBp = ((FaceFlashActionProcessLayout)findViewById(a.e.flash_process_layout));
    this.AQI = ((WeImageView)findViewById(a.e.flash_cancel));
    this.AQI.setOnClickListener(this);
    this.qep.alive();
    EventCenter.instance.addListener(this.BAP);
    com.tencent.mm.plugin.flash.c.a.epL();
    AppMethodBeat.o(197285);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(197304);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.onDestroy();
    AppMethodBeat.o(197304);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(197294);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onPause", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    YtSDKKitFramework.getInstance().doPause();
    FaceFlashActionPreviewLayout localFaceFlashActionPreviewLayout = this.BBo;
    localFaceFlashActionPreviewLayout.BAB.TL();
    localFaceFlashActionPreviewLayout.epo();
    AppMethodBeat.o(197294);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(197292);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onResume", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    YtSDKKitFramework.getInstance().doResume();
    FaceFlashActionPreviewLayout localFaceFlashActionPreviewLayout = this.BBo;
    if ((localFaceFlashActionPreviewLayout.getVisibility() == 0) && (!localFaceFlashActionPreviewLayout.BAB.wFf) && (localFaceFlashActionPreviewLayout.ool != null) && (localFaceFlashActionPreviewLayout.BzG.getVisibility() != 0)) {
      localFaceFlashActionPreviewLayout.BAB.a(localFaceFlashActionPreviewLayout.ool, new FaceFlashActionPreviewLayout.13(localFaceFlashActionPreviewLayout));
    }
    AppMethodBeat.o(197292);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(197346);
    Log.i("MicroMsg.FaceFlashActionUI", "onSwipeBack");
    epu();
    super.onSwipeBack();
    AppMethodBeat.o(197346);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(197315);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity reset", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.aHi("reset");
    Sm(com.tencent.mm.ci.a.w(getContext(), a.b.BW_0));
    this.BAN = "";
    this.BAO = "";
    this.BBo.reset();
    this.BBo.setVisibility(0);
    this.BBp.setVisibility(8);
    AppMethodBeat.o(197315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionUI
 * JD-Core Version:    0.7.0.1
 */