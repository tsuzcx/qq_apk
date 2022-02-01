package com.tencent.mm.plugin.flash.action;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetectaction.ui.a.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashActionProcessLayout
  extends RelativeLayout
{
  static String TAG = "MicroMsg.FaceFlashManager.FaceFlashActionProcessLayout";
  private static String wHv = "MicroMsg.FaceFlashManagerError";
  TextView wHA;
  Animation wHB;
  Animation wHC;
  private Animation wHD;
  private FaceFlashActionUI wHY;
  TextView wHw;
  WeImageView wHx;
  ImageView wHy;
  Button wHz;
  private Button wIe;
  
  public FaceFlashActionProcessLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceFlashActionProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceFlashActionProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(186577);
    this.wHY = ((FaceFlashActionUI)getContext());
    this.wHB = AnimationUtils.loadAnimation(getContext(), 2130772041);
    this.wHC = AnimationUtils.loadAnimation(getContext(), 2130772043);
    this.wHD = AnimationUtils.loadAnimation(getContext(), 2130772042);
    LayoutInflater.from(getContext()).inflate(2131494068, this, true);
    this.wHw = ((TextView)findViewById(2131300342));
    this.wHx = ((WeImageView)findViewById(2131300341));
    this.wHz = ((Button)findViewById(2131300338));
    this.wHA = ((TextView)findViewById(2131300337));
    this.wHy = ((ImageView)findViewById(2131300340));
    this.wIe = ((Button)findViewById(2131300336));
    AppMethodBeat.o(186577);
  }
  
  public final void axe(String paramString)
  {
    AppMethodBeat.i(186578);
    Log.i(TAG, "showFailedAnimation");
    for (;;)
    {
      try
      {
        this.wHy.setImageResource(2131232242);
        this.wHy.startAnimation(this.wHB);
        this.wHx.setImageDrawable(com.tencent.mm.cb.a.l(getContext(), 2131690548));
        this.wHx.startAnimation(this.wHD);
        final JSONObject localJSONObject = new JSONObject(paramString);
        this.wHw.setText(com.tencent.mm.plugin.flash.d.a.k(localJSONObject, com.tencent.mm.cb.a.aI(getContext(), 2131759001)));
        Object localObject1 = localJSONObject.optString("otherVerifyTitle");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.wIe.setVisibility(4);
          localObject1 = localJSONObject.optString("err_feedback", "");
          Object localObject2 = this.wHA;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = 4;
            ((TextView)localObject2).setVisibility(i);
            ao.a(this.wHA.getPaint(), 0.8F);
            localObject2 = getContext().getResources().getString(2131759032);
            SpannableString localSpannableString = new SpannableString((CharSequence)localObject2);
            localSpannableString.setSpan(new com.tencent.mm.plugin.facedetectaction.ui.a((String)localObject2, getContext().getResources().getColor(2131100685), getContext().getResources().getColor(2131099660), new a.a()
            {
              public final void arG(String paramAnonymousString)
              {
                AppMethodBeat.i(186574);
                Log.i(FaceFlashActionProcessLayout.TAG, "click feedback url ");
                try
                {
                  paramAnonymousString = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localJSONObject.optString("key_app_id", ""), Integer.valueOf(localJSONObject.optInt("err_code", 0)), localJSONObject.optString("verify_result", "") }), "UTF-8");
                  paramAnonymousString = this.wHF + "?customInfo=" + paramAnonymousString;
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  c.b(FaceFlashActionProcessLayout.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(186574);
                  return;
                }
                catch (Exception paramAnonymousString)
                {
                  Log.printErrStackTrace(FaceFlashActionProcessLayout.wHv, paramAnonymousString, "face start feedback webview exception", new Object[0]);
                  AppMethodBeat.o(186574);
                }
              }
            }), 0, localSpannableString.length(), 17);
            this.wHA.setClickable(true);
            this.wHA.setOnTouchListener(new o(getContext()));
            this.wHA.setText(localSpannableString);
            final boolean bool = localJSONObject.optBoolean("err_retry", true);
            this.wHz.setVisibility(0);
            localObject2 = this.wHz;
            if (!bool) {
              break label821;
            }
            localObject1 = com.tencent.mm.cb.a.aI(getContext(), 2131759083);
            ((Button)localObject2).setText((CharSequence)localObject1);
            this.wHz.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(186575);
                b localb = new b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                Log.i(FaceFlashActionProcessLayout.TAG, "click retry btn, canRetry：%s", new Object[] { Boolean.valueOf(bool) });
                if (bool) {
                  FaceFlashActionProcessLayout.a(FaceFlashActionProcessLayout.this).reset();
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(186575);
                  return;
                  FaceFlashActionProcessLayout.a(FaceFlashActionProcessLayout.this).aO(localJSONObject);
                }
              }
            });
            if ((this.wIe.getVisibility() == 0) && (this.wHA.getVisibility() == 0))
            {
              localObject1 = (RelativeLayout.LayoutParams)this.wIe.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 108);
              this.wIe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              localObject1 = (RelativeLayout.LayoutParams)this.wHz.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
              ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131300336);
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
              this.wHz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            if ((this.wIe.getVisibility() != 0) && (this.wHA.getVisibility() != 0))
            {
              localObject1 = (RelativeLayout.LayoutParams)this.wHz.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).addRule(12);
              ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 96);
              this.wHz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            if ((this.wIe.getVisibility() == 0) && (this.wHA.getVisibility() != 0))
            {
              localObject1 = (RelativeLayout.LayoutParams)this.wIe.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 96);
              this.wIe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              localObject1 = (RelativeLayout.LayoutParams)this.wHz.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
              ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131300336);
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
              this.wHz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            if ((this.wIe.getVisibility() != 0) && (this.wHA.getVisibility() == 0))
            {
              localObject1 = (RelativeLayout.LayoutParams)this.wHz.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).addRule(12);
              ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 108);
              this.wHz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            AppMethodBeat.o(186578);
          }
        }
        else
        {
          this.wIe.setVisibility(0);
          this.wIe.setText((CharSequence)localObject1);
          this.wIe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(186573);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i(FaceFlashActionProcessLayout.TAG, "click customBtn");
              try
              {
                localJSONObject.put("click_other_verify_btn", "yes");
                FaceFlashActionProcessLayout.a(FaceFlashActionProcessLayout.this).aO(localJSONObject);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186573);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  Log.printErrStackTrace(FaceFlashActionProcessLayout.wHv, paramAnonymousView, "face start feedback webview exception", new Object[0]);
                }
              }
            }
          });
          continue;
        }
        int i = 0;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace(wHv, localJSONException, "parse face failed result error.%s", new Object[] { paramString });
        this.wHw.setText(paramString);
        this.wHA.setVisibility(4);
        this.wHz.setVisibility(0);
        this.wHz.setText(com.tencent.mm.cb.a.aI(getContext(), 2131759083));
        this.wHz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186576);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            FaceFlashActionProcessLayout.a(FaceFlashActionProcessLayout.this).reset();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186576);
          }
        });
        AppMethodBeat.o(186578);
        return;
      }
      continue;
      label821:
      String str = com.tencent.mm.cb.a.aI(getContext(), 2131759081);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(186579);
    this.wHB.cancel();
    this.wHC.cancel();
    this.wHD.cancel();
    AppMethodBeat.o(186579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout
 * JD-Core Version:    0.7.0.1
 */