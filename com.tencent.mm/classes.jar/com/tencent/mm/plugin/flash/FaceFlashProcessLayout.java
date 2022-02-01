package com.tencent.mm.plugin.flash;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashProcessLayout
  extends RelativeLayout
{
  private static String HhK = "MicroMsg.FaceFlashManagerError";
  static String TAG = "MicroMsg.FaceFlashManager";
  TextView HhL;
  private TextView HhM;
  WeImageView HhN;
  ImageView HhO;
  Button HhP;
  private TextView HhQ;
  Animation HhR;
  Animation HhS;
  Animation HhT;
  private FaceFlashUI Hhn;
  
  public FaceFlashProcessLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceFlashProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceFlashProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(264514);
    this.Hhn = ((FaceFlashUI)getContext());
    this.HhR = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    this.HhS = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_success_scale);
    this.HhT = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    LayoutInflater.from(getContext()).inflate(a.g.face_flash_upload_layout, this, true);
    this.HhL = ((TextView)findViewById(a.e.face_flash_header_tip));
    this.HhM = ((TextView)findViewById(a.e.face_flash_header_hint));
    this.HhN = ((WeImageView)findViewById(a.e.face_flash_header_icon));
    this.HhP = ((Button)findViewById(a.e.face_flash_bottom_verify));
    this.HhQ = ((TextView)findViewById(a.e.face_flash_bottom_feedback));
    this.HhO = ((ImageView)findViewById(a.e.face_flash_header_bg));
    AppMethodBeat.o(264514);
  }
  
  public final void aDq(String paramString)
  {
    AppMethodBeat.i(264558);
    Log.i(TAG, "showFailedAnimation");
    fus();
    for (;;)
    {
      try
      {
        this.HhO.setImageResource(a.d.face_flash_fail_circle);
        this.HhO.startAnimation(this.HhR);
        this.HhN.setImageDrawable(com.tencent.mm.cd.a.m(getContext(), a.h.icons_filled_error3));
        this.HhN.startAnimation(this.HhT);
        if ((WeChatEnvironment.isCoolassistEnv()) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
          this.HhN.setOnLongClickListener(new FaceFlashProcessLayout.1(this));
        }
        final JSONObject localJSONObject = new JSONObject(paramString);
        TextView localTextView = this.HhL;
        Object localObject1 = com.tencent.mm.cd.a.bt(getContext(), a.i.face_compare_fail);
        Object localObject3 = localJSONObject.optString("err_msg", localJSONObject.optString("errormsg", (String)localObject1));
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          com.tencent.mm.plugin.flash.c.b.F("msgVerify", localObject1);
          localTextView.setText((CharSequence)localObject1);
          localTextView = this.HhM;
          localObject1 = "";
          localObject3 = localJSONObject.optString("err_tip", "");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label443;
          }
          localTextView.setText((CharSequence)localObject1);
          localObject1 = localJSONObject.optString("err_feedback", "");
          localObject3 = this.HhQ;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label450;
          }
          i = 4;
          ((TextView)localObject3).setVisibility(i);
          this.HhQ.setOnClickListener(new FaceFlashProcessLayout.2(this, localJSONObject, (String)localObject1));
          final boolean bool = localJSONObject.optBoolean("err_retry", true);
          this.HhP.setVisibility(0);
          localObject3 = this.HhP;
          if (bool)
          {
            localObject1 = com.tencent.mm.cd.a.bt(getContext(), a.i.face_try_again);
            ((Button)localObject3).setText((CharSequence)localObject1);
            this.HhP.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(264610);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (bool) {
                  FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).reset();
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(264610);
                  return;
                  FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).bg(localJSONObject);
                }
              }
            });
            AppMethodBeat.o(264558);
          }
        }
        else
        {
          com.tencent.mm.plugin.flash.c.b.F("msgVerify", localObject3);
          localObject1 = localObject3;
          continue;
        }
        localObject1 = com.tencent.mm.cd.a.bt(getContext(), a.i.face_severe_error_main_btn);
        continue;
        Object localObject2 = localObject3;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace(HhK, localJSONException, "parse face failed result error.%s", new Object[] { paramString });
        this.HhL.setText(paramString);
        this.HhQ.setVisibility(4);
        this.HhP.setVisibility(0);
        this.HhP.setText(com.tencent.mm.cd.a.bt(getContext(), a.i.face_try_again));
        this.HhP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(264613);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).reset();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(264613);
          }
        });
        AppMethodBeat.o(264558);
        return;
      }
      label443:
      continue;
      label450:
      int i = 0;
    }
  }
  
  final void fus()
  {
    AppMethodBeat.i(264566);
    findViewById(a.e.reflect_jumper_root).setPadding(0, bf.fs(getContext()), 0, 0);
    AppMethodBeat.o(264566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashProcessLayout
 * JD-Core Version:    0.7.0.1
 */