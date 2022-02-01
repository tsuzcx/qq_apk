package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.flash.b.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashActionUI
  extends MMActivity
  implements View.OnClickListener
{
  private WeImageView GsS;
  FaceFlashActionPreviewLayout HiR;
  FaceFlashActionProcessLayout HiS;
  int Hik;
  private String Hil;
  String Him;
  private IListener Hin;
  private long startTime;
  private IListener tje;
  
  public FaceFlashActionUI()
  {
    AppMethodBeat.i(264759);
    this.Hik = 90004;
    this.Hil = "";
    this.Him = "";
    this.startTime = Util.currentTicks();
    this.tje = new IListener(f.hfK) {};
    this.Hin = new FaceFlashActionUI.3(this, f.hfK);
    AppMethodBeat.o(264759);
  }
  
  private static Intent E(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(264795);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    Log.i("MicroMsg.FaceFlashActionUI", "face result errorType:%s errorCode:%s errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(264795);
    return localIntent;
  }
  
  public static boolean d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(264770);
    Object localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(264745);
        com.tencent.mm.plugin.flash.c.b.F("msgVerify", "camera or mic 正在被占用");
        com.tencent.mm.plugin.flash.c.b.fuP().ivK = 1;
        com.tencent.mm.plugin.flash.c.b.VM(90033);
        FaceFlashActionUI.this.setResult(1, FaceFlashActionUI.aDt("finish by voip call"));
        FaceFlashActionUI.this.finish();
        AppMethodBeat.o(264745);
      }
    };
    if ((!com.tencent.mm.n.a.b(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.d(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.a(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.f(paramActivity, (DialogInterface.OnClickListener)localObject)) && (!com.tencent.mm.n.a.e(paramActivity, (DialogInterface.OnClickListener)localObject)))
    {
      localObject = new Intent(paramActivity, FaceFlashActionUI.class);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "jumpToFaceFlashUI", "(Landroid/app/Activity;Landroid/os/Bundle;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(264770);
      return true;
    }
    AppMethodBeat.o(264770);
    return false;
  }
  
  private void fuw()
  {
    AppMethodBeat.i(264784);
    if (!TextUtils.isEmpty(this.Him))
    {
      aDs(this.Him);
      AppMethodBeat.o(264784);
      return;
    }
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishByCancel", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = E(1, this.Hik, "cancel");
    localIntent.putExtra("scene", getIntent().getIntExtra("scene", 0));
    localIntent.putExtra("totalTime", Util.ticksToNow(this.startTime));
    try
    {
      if (!TextUtils.isEmpty(this.Hil))
      {
        JSONObject localJSONObject = new JSONObject(this.Hil);
        localIntent.putExtra("serial_id", localJSONObject.optString("serial_id"));
        if (com.tencent.mm.plugin.flash.d.a.bi(localJSONObject))
        {
          if (!this.HiR.fuz()) {
            break label189;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
        }
        for (;;)
        {
          bg(localJSONObject);
          AppMethodBeat.o(264784);
          return;
          label189:
          com.tencent.mm.plugin.report.service.h.OAn.b(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0) });
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashActionUI", localException, "", new Object[0]);
      com.tencent.mm.plugin.flash.c.b.aDA("usrCancel");
      com.tencent.mm.plugin.flash.c.b.fuP().ivK = 6;
      com.tencent.mm.plugin.flash.c.b.VM(90004);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(264784);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(264776);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264748);
        Object localObject = FaceFlashActionUI.a(FaceFlashActionUI.this);
        ((FaceFlashActionProcessLayout)localObject).HhR.cancel();
        ((FaceFlashActionProcessLayout)localObject).HhS.cancel();
        ((FaceFlashActionProcessLayout)localObject).HhT.cancel();
        localObject = FaceFlashActionUI.b(FaceFlashActionUI.this);
        Log.i("MicroMsg.FaceFlashActionPreviewLayout", "release");
        ((FaceFlashActionPreviewLayout)localObject).Hiw.clearAnimation();
        ((FaceFlashActionPreviewLayout)localObject).Hix.clearAnimation();
        com.tencent.mm.plugin.flash.b.fuu();
        ((FaceFlashActionPreviewLayout)localObject).HhZ.release();
        if (((FaceFlashActionPreviewLayout)localObject).Hhp != null) {
          ((FaceFlashActionPreviewLayout)localObject).Hhp.release();
        }
        ((FaceFlashActionPreviewLayout)localObject).HhC.cancel();
        if (((FaceFlashActionPreviewLayout)localObject).HiC != null)
        {
          ((FaceFlashActionPreviewLayout)localObject).HiC.cancel(true);
          ((FaceFlashActionPreviewLayout)localObject).HiC = null;
        }
        com.tencent.mm.kernel.h.aZW().b(5965, (com.tencent.mm.am.h)localObject);
        AppMethodBeat.o(264748);
      }
    });
    this.tje.dead();
    this.Hin.dead();
    AppMethodBeat.o(264776);
  }
  
  public final void VF(int paramInt)
  {
    AppMethodBeat.i(264898);
    this.GsS.setIconColor(paramInt);
    AppMethodBeat.o(264898);
  }
  
  public final void aDr(String paramString)
  {
    AppMethodBeat.i(264901);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity showFailedLayout", new Object[] { Integer.valueOf(hashCode()) });
    this.Hik = 90006;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str1 = paramString;
      if (this.HiR.fuz())
      {
        str1 = paramString;
        if (Util.isNullOrNil(localJSONObject.optString("otherVerifyTitle")))
        {
          localJSONObject.put("otherVerifyTitle", this.HiR.getFaceOtherVerifyTitle());
          str1 = localJSONObject.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str1;
        String str2 = paramString;
      }
    }
    this.Hil = str1;
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264771);
        FaceFlashActionUI.this.VF(com.tencent.mm.cd.a.w(FaceFlashActionUI.this.getContext(), a.b.BW_0));
        FaceFlashActionUI.b(FaceFlashActionUI.this).setVisibility(8);
        FaceFlashActionUI.a(FaceFlashActionUI.this).setVisibility(0);
        FaceFlashActionUI.a(FaceFlashActionUI.this).setCircleY(FaceFlashActionUI.b(FaceFlashActionUI.this).getCircleY());
        FaceFlashActionUI.a(FaceFlashActionUI.this).HiN = FaceFlashActionUI.b(FaceFlashActionUI.this).fuy();
        localFaceFlashActionProcessLayout = FaceFlashActionUI.a(FaceFlashActionUI.this);
        str2 = FaceFlashActionUI.c(FaceFlashActionUI.this);
        i = FaceFlashActionUI.d(FaceFlashActionUI.this).getHeight();
        Log.i(FaceFlashActionProcessLayout.TAG, "showFailedAnimation");
        for (;;)
        {
          try
          {
            if (!localFaceFlashActionProcessLayout.HiN) {
              continue;
            }
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HiL.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
            i -= aw.getStatusBarHeight(localFaceFlashActionProcessLayout.getContext());
            if ((int)localFaceFlashActionProcessLayout.HiM <= i * 0.5D) {
              continue;
            }
            ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(i * 0.5D) - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 100));
            localFaceFlashActionProcessLayout.HiL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          catch (JSONException localJSONException)
          {
            Object localObject1;
            JSONObject localJSONObject;
            Object localObject3;
            String str1;
            SpannableString localSpannableString;
            Log.printErrStackTrace(FaceFlashActionProcessLayout.HhK, localJSONException, "parse face failed result error.%s", new Object[] { str2 });
            localFaceFlashActionProcessLayout.HhL.setText(str2);
            localFaceFlashActionProcessLayout.HhQ.setVisibility(4);
            localFaceFlashActionProcessLayout.HhP.setVisibility(0);
            localFaceFlashActionProcessLayout.HhP.setText(com.tencent.mm.cd.a.bt(localFaceFlashActionProcessLayout.getContext(), a.i.face_try_again));
            localFaceFlashActionProcessLayout.HhP.setOnClickListener(new FaceFlashActionProcessLayout.4(localFaceFlashActionProcessLayout));
            continue;
            Object localObject2 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HiL.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.e.face_flash_header_tip);
            ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 48);
            localFaceFlashActionProcessLayout.HiL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            continue;
            com.tencent.mm.plugin.flash.c.b.F("msgVerify", str1);
            localObject2 = str1;
            continue;
            localFaceFlashActionProcessLayout.HhP.setBackgroundResource(a.d.face_green_btn_bg);
            localFaceFlashActionProcessLayout.HhP.setTextColor(localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.face_green_btn_selector));
            localFaceFlashActionProcessLayout.HiK.setVisibility(0);
            localFaceFlashActionProcessLayout.HiK.setText(str1);
            localFaceFlashActionProcessLayout.HiK.setOnClickListener(new FaceFlashActionProcessLayout.1(localFaceFlashActionProcessLayout, localJSONObject));
            continue;
            localObject2 = com.tencent.mm.cd.a.bt(localFaceFlashActionProcessLayout.getContext(), a.i.face_result_confirm_btn);
            continue;
            i = 0;
            continue;
            boolean bool = false;
            continue;
          }
          localFaceFlashActionProcessLayout.HhO.setImageResource(a.d.face_flash_fail_circle);
          localFaceFlashActionProcessLayout.HhO.startAnimation(localFaceFlashActionProcessLayout.HhR);
          localFaceFlashActionProcessLayout.HhN.setImageDrawable(com.tencent.mm.cd.a.m(localFaceFlashActionProcessLayout.getContext(), a.h.icons_filled_error3));
          localFaceFlashActionProcessLayout.HhN.startAnimation(localFaceFlashActionProcessLayout.HhT);
          localJSONObject = new JSONObject(str2);
          localObject3 = localFaceFlashActionProcessLayout.HhL;
          localObject1 = com.tencent.mm.cd.a.bt(localFaceFlashActionProcessLayout.getContext(), a.i.face_compare_fail);
          str1 = localJSONObject.optString("err_tip", localJSONObject.optString("message", localJSONObject.optString("errormsg", localJSONObject.optString("err_msg", (String)localObject1))));
          if (!TextUtils.isEmpty(str1)) {
            continue;
          }
          com.tencent.mm.plugin.flash.c.b.F("msgVerify", localObject1);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          str1 = localJSONObject.optString("otherVerifyTitle");
          Log.i(FaceFlashActionProcessLayout.TAG, "otherVerifyTitle is :%s", new Object[] { str1 });
          if (!TextUtils.isEmpty(str1)) {
            continue;
          }
          localFaceFlashActionProcessLayout.HiK.setVisibility(4);
          localFaceFlashActionProcessLayout.HhP.setBackgroundResource(a.d.face_white_btn_bg);
          localFaceFlashActionProcessLayout.HhP.setTextColor(localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.face_white_btn_selector));
          localObject1 = localJSONObject.optString("err_feedback", "");
          localObject3 = localFaceFlashActionProcessLayout.HhQ;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          i = 4;
          ((TextView)localObject3).setVisibility(i);
          aw.a(localFaceFlashActionProcessLayout.HhQ.getPaint(), 0.8F);
          localObject3 = localFaceFlashActionProcessLayout.getContext().getResources().getString(a.i.face_detect_feedback);
          localSpannableString = new SpannableString((CharSequence)localObject3);
          localSpannableString.setSpan(new com.tencent.mm.plugin.facedetectaction.ui.a((String)localObject3, localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.link_color), localFaceFlashActionProcessLayout.getContext().getResources().getColor(a.b.UN_BW_0_Alpha_0_2), new FaceFlashActionProcessLayout.2(localFaceFlashActionProcessLayout, localJSONObject, (String)localObject1)), 0, localSpannableString.length(), 17);
          localFaceFlashActionProcessLayout.HhQ.setClickable(true);
          localFaceFlashActionProcessLayout.HhQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(localFaceFlashActionProcessLayout.getContext()));
          localFaceFlashActionProcessLayout.HhQ.setText(localSpannableString);
          if (localJSONObject.optInt("err_retry", 1) != 1) {
            continue;
          }
          bool = true;
          localFaceFlashActionProcessLayout.HhP.setVisibility(0);
          localObject3 = localFaceFlashActionProcessLayout.HhP;
          if (!bool) {
            continue;
          }
          localObject1 = com.tencent.mm.cd.a.bt(localFaceFlashActionProcessLayout.getContext(), a.i.face_try_again);
          ((Button)localObject3).setText((CharSequence)localObject1);
          localFaceFlashActionProcessLayout.HhP.setOnClickListener(new FaceFlashActionProcessLayout.3(localFaceFlashActionProcessLayout, bool, localJSONObject, str1));
          if ((localFaceFlashActionProcessLayout.HiK.getVisibility() == 0) && (localFaceFlashActionProcessLayout.HhQ.getVisibility() == 0))
          {
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HiK.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 108);
            localFaceFlashActionProcessLayout.HiK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HhP.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
            ((RelativeLayout.LayoutParams)localObject1).addRule(2, a.e.face_flash_bottom_custom);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 16);
            localFaceFlashActionProcessLayout.HhP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if ((localFaceFlashActionProcessLayout.HiK.getVisibility() != 0) && (localFaceFlashActionProcessLayout.HhQ.getVisibility() != 0))
          {
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HhP.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).addRule(12);
            ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 96);
            localFaceFlashActionProcessLayout.HhP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if ((localFaceFlashActionProcessLayout.HiK.getVisibility() == 0) && (localFaceFlashActionProcessLayout.HhQ.getVisibility() != 0))
          {
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HiK.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 96);
            localFaceFlashActionProcessLayout.HiK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HhP.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
            ((RelativeLayout.LayoutParams)localObject1).addRule(2, a.e.face_flash_bottom_custom);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 16);
            localFaceFlashActionProcessLayout.HhP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if ((localFaceFlashActionProcessLayout.HiK.getVisibility() != 0) && (localFaceFlashActionProcessLayout.HhQ.getVisibility() == 0))
          {
            localObject1 = (RelativeLayout.LayoutParams)localFaceFlashActionProcessLayout.HhP.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).addRule(12);
            ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(localFaceFlashActionProcessLayout.getContext(), 108);
            localFaceFlashActionProcessLayout.HhP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          com.tencent.mm.plugin.flash.c.b.fh(FaceFlashActionUI.c(FaceFlashActionUI.this), 1);
          AppMethodBeat.o(264771);
          return;
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)localFaceFlashActionProcessLayout.HiM - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 100));
        }
      }
    });
    AppMethodBeat.o(264901);
  }
  
  final void aDs(String paramString)
  {
    AppMethodBeat.i(264907);
    try
    {
      bf(new JSONObject(paramString));
      AppMethodBeat.o(264907);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashActionUI", paramString, "", new Object[0]);
      AppMethodBeat.o(264907);
    }
  }
  
  public final void bR(int paramInt, String paramString)
  {
    AppMethodBeat.i(264902);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishByUnexpectedError", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.F("msgVerify", paramString);
    com.tencent.mm.plugin.flash.c.b.VM(paramInt);
    setResult(1, E(4, paramInt, "fail"));
    finish();
    AppMethodBeat.o(264902);
  }
  
  public final void bf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(264909);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishBySuccess", new Object[] { Integer.valueOf(hashCode()) });
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(264909);
      return;
    }
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.bh(paramJSONObject);
    paramJSONObject.putString("err_msg", "ok");
    paramJSONObject.putString("click_other_verify_btn", "no");
    paramJSONObject.putLong("totalTime", Util.ticksToNow(this.startTime));
    localIntent.putExtras(paramJSONObject);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(264909);
  }
  
  public final void bg(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(264911);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finishByFailed", new Object[] { Integer.valueOf(hashCode()) });
    Intent localIntent = new Intent();
    paramJSONObject = com.tencent.mm.plugin.flash.d.a.bh(paramJSONObject);
    paramJSONObject.putString("err_msg", "fail");
    localIntent.putExtras(paramJSONObject);
    setResult(1, localIntent);
    finish();
    AppMethodBeat.o(264911);
  }
  
  public void finish()
  {
    AppMethodBeat.i(264888);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity finish", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.finish();
    AppMethodBeat.o(264888);
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
    AppMethodBeat.i(264893);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onBackPressed", new Object[] { Integer.valueOf(hashCode()) });
    fuw();
    AppMethodBeat.o(264893);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(264880);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == a.e.flash_cancel) {
      fuw();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(264880);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264863);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onCreate", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.aDA("enter");
    super.onCreate(paramBundle);
    getController().s(this, com.tencent.mm.cd.a.w(getContext(), a.b.White));
    this.HiR = ((FaceFlashActionPreviewLayout)findViewById(a.e.flash_preview_layout));
    this.HiS = ((FaceFlashActionProcessLayout)findViewById(a.e.flash_process_layout));
    this.GsS = ((WeImageView)findViewById(a.e.flash_cancel));
    this.GsS.setOnClickListener(this);
    this.tje.alive();
    this.Hin.alive();
    com.tencent.mm.plugin.flash.c.a.fuN();
    AppMethodBeat.o(264863);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264884);
    Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity onDestroy", new Object[] { Integer.valueOf(hashCode()) });
    release();
    super.onDestroy();
    AppMethodBeat.o(264884);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(264875);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onPause", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    YtSDKKitFramework.getInstance().doPause();
    FaceFlashActionPreviewLayout localFaceFlashActionPreviewLayout = this.HiR;
    localFaceFlashActionPreviewLayout.HhZ.auq();
    localFaceFlashActionPreviewLayout.fuq();
    AppMethodBeat.o(264875);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(264870);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity onResume", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    YtSDKKitFramework.getInstance().doResume();
    FaceFlashActionPreviewLayout localFaceFlashActionPreviewLayout = this.HiR;
    if ((localFaceFlashActionPreviewLayout.getVisibility() == 0) && (!localFaceFlashActionPreviewLayout.HhZ.nvB) && (localFaceFlashActionPreviewLayout.rrU != null) && (localFaceFlashActionPreviewLayout.Hhj.getVisibility() != 0)) {
      localFaceFlashActionPreviewLayout.HhZ.a(localFaceFlashActionPreviewLayout.rrU, new FaceFlashActionPreviewLayout.13(localFaceFlashActionPreviewLayout));
    }
    AppMethodBeat.o(264870);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(264905);
    Log.i("MicroMsg.FaceFlashActionUI", "onSwipeBack");
    fuw();
    super.onSwipeBack();
    AppMethodBeat.o(264905);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(264895);
    Log.i("MicroMsg.FaceFlashActionUI", "[%s]FaceFlashActivity reset", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flash.c.b.aDA("reset");
    VF(com.tencent.mm.cd.a.w(getContext(), a.b.BW_0));
    this.Hil = "";
    this.Him = "";
    this.HiR.reset();
    this.HiR.setVisibility(0);
    this.HiS.setVisibility(8);
    AppMethodBeat.o(264895);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(264850);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.flash.a.b.class);
    AppMethodBeat.o(264850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionUI
 * JD-Core Version:    0.7.0.1
 */