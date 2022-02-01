package com.tencent.mm.plugin.flash;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashProcessLayout
  extends RelativeLayout
{
  private static String BAm = "MicroMsg.FaceFlashManagerError";
  static String TAG = "MicroMsg.FaceFlashManager";
  TextView BAn;
  private TextView BAo;
  WeImageView BAp;
  ImageView BAq;
  Button BAr;
  private TextView BAs;
  Animation BAt;
  Animation BAu;
  Animation BAv;
  private FaceFlashUI BzL;
  
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
    AppMethodBeat.i(198222);
    this.BzL = ((FaceFlashUI)getContext());
    this.BAt = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    this.BAu = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_success_scale);
    this.BAv = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    LayoutInflater.from(getContext()).inflate(a.g.face_flash_upload_layout, this, true);
    this.BAn = ((TextView)findViewById(a.e.face_flash_header_tip));
    this.BAo = ((TextView)findViewById(a.e.face_flash_header_hint));
    this.BAp = ((WeImageView)findViewById(a.e.face_flash_header_icon));
    this.BAr = ((Button)findViewById(a.e.face_flash_bottom_verify));
    this.BAs = ((TextView)findViewById(a.e.face_flash_bottom_feedback));
    this.BAq = ((ImageView)findViewById(a.e.face_flash_header_bg));
    AppMethodBeat.o(198222);
  }
  
  public final void aGY(String paramString)
  {
    AppMethodBeat.i(198226);
    Log.i(TAG, "showFailedAnimation");
    epq();
    for (;;)
    {
      try
      {
        this.BAq.setImageResource(a.d.face_flash_fail_circle);
        this.BAq.startAnimation(this.BAt);
        this.BAp.setImageDrawable(com.tencent.mm.ci.a.m(getContext(), a.h.icons_filled_error3));
        this.BAp.startAnimation(this.BAv);
        if ((WeChatEnvironment.isCoolassistEnv()) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
          this.BAp.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(193747);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
              MultiProcessMMKV.getMMKV("face-flash").encode("show-dialog", 0L);
              w.makeText(FaceFlashProcessLayout.this.getContext(), "ok", 1).show();
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(193747);
              return true;
            }
          });
        }
        final JSONObject localJSONObject = new JSONObject(paramString);
        TextView localTextView = this.BAn;
        Object localObject1 = com.tencent.mm.ci.a.ba(getContext(), a.i.face_compare_fail);
        Object localObject3 = localJSONObject.optString("err_msg", localJSONObject.optString("errormsg", (String)localObject1));
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          com.tencent.mm.plugin.flash.c.b.s("msgVerify", localObject1);
          localTextView.setText((CharSequence)localObject1);
          localTextView = this.BAo;
          localObject1 = "";
          localObject3 = localJSONObject.optString("err_tip", "");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label443;
          }
          localTextView.setText((CharSequence)localObject1);
          localObject1 = localJSONObject.optString("err_feedback", "");
          localObject3 = this.BAs;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label450;
          }
          i = 4;
          ((TextView)localObject3).setVisibility(i);
          this.BAs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(192947);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              try
              {
                paramAnonymousView = q.an(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localJSONObject.optString("key_app_id", ""), Integer.valueOf(localJSONObject.optInt("err_code", 0)), localJSONObject.optString("verify_result", "") }), "UTF-8");
                paramAnonymousView = this.BAy + "?customInfo=" + paramAnonymousView;
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                c.b(FaceFlashProcessLayout.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(192947);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  Log.printErrStackTrace(FaceFlashProcessLayout.BAm, paramAnonymousView, "face start feedback webview exception", new Object[0]);
                }
              }
            }
          });
          final boolean bool = localJSONObject.optBoolean("err_retry", true);
          this.BAr.setVisibility(0);
          localObject3 = this.BAr;
          if (bool)
          {
            localObject1 = com.tencent.mm.ci.a.ba(getContext(), a.i.face_try_again);
            ((Button)localObject3).setText((CharSequence)localObject1);
            this.BAr.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(192644);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (bool) {
                  FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).reset();
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(192644);
                  return;
                  FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).aT(localJSONObject);
                }
              }
            });
            AppMethodBeat.o(198226);
          }
        }
        else
        {
          com.tencent.mm.plugin.flash.c.b.s("msgVerify", localObject3);
          localObject1 = localObject3;
          continue;
        }
        localObject1 = com.tencent.mm.ci.a.ba(getContext(), a.i.face_severe_error_main_btn);
        continue;
        Object localObject2 = localObject3;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace(BAm, localJSONException, "parse face failed result error.%s", new Object[] { paramString });
        this.BAn.setText(paramString);
        this.BAs.setVisibility(4);
        this.BAr.setVisibility(0);
        this.BAr.setText(com.tencent.mm.ci.a.ba(getContext(), a.i.face_try_again));
        this.BAr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(195687);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).reset();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195687);
          }
        });
        AppMethodBeat.o(198226);
        return;
      }
      label443:
      continue;
      label450:
      int i = 0;
    }
  }
  
  final void epq()
  {
    AppMethodBeat.i(198228);
    findViewById(a.e.reflect_jumper_root).setPadding(0, ax.ew(getContext()), 0, 0);
    AppMethodBeat.o(198228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashProcessLayout
 * JD-Core Version:    0.7.0.1
 */