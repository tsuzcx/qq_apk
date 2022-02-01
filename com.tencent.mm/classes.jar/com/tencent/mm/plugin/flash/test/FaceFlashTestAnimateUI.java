package com.tencent.mm.plugin.flash.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class FaceFlashTestAnimateUI
  extends MMActivity
{
  public static String TAG = "MicroMsg.FaceFlashTestAnimateUI";
  TextView BAn;
  WeImageView BAp;
  ImageView BAq;
  private Button BAr;
  private TextView BAs;
  Animation BAt;
  Animation BAv;
  Animation BBX;
  
  public int getLayoutId()
  {
    return a.g.face_flash_upload_layout_test;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192001);
    super.onCreate(paramBundle);
    this.BAn = ((TextView)findViewById(a.e.face_flash_header_tip));
    this.BAp = ((WeImageView)findViewById(a.e.face_flash_header_icon));
    this.BAr = ((Button)findViewById(a.e.face_flash_bottom_verify));
    this.BAs = ((TextView)findViewById(a.e.face_flash_bottom_feedback));
    this.BAq = ((ImageView)findViewById(a.e.face_flash_header_bg));
    this.BAt = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    this.BBX = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_success_scale);
    this.BAv = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    this.BAr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190082);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FaceFlashTestAnimateUI.this;
        paramAnonymousView.BAn.setText(com.tencent.mm.ci.a.ba(paramAnonymousView.getContext(), a.i.face_upload_sucess_tips));
        paramAnonymousView.BAq.setImageResource(a.d.face_flash_success_circle);
        paramAnonymousView.BAq.startAnimation(paramAnonymousView.BAt);
        paramAnonymousView.BAp.setImageDrawable(com.tencent.mm.ci.a.m(paramAnonymousView.getContext(), a.h.icons_filled_done3));
        paramAnonymousView.BAp.startAnimation(paramAnonymousView.BBX);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190082);
      }
    });
    findViewById(a.e.face_flash_bottom_verify_fail).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193344);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FaceFlashTestAnimateUI.this;
        Log.i(FaceFlashTestAnimateUI.TAG, "showFailedAnimation");
        paramAnonymousView.BAq.setImageResource(a.d.face_flash_fail_circle);
        paramAnonymousView.BAq.startAnimation(paramAnonymousView.BAt);
        paramAnonymousView.BAp.setImageDrawable(com.tencent.mm.ci.a.m(paramAnonymousView.getContext(), a.h.icons_filled_error3));
        paramAnonymousView.BAp.startAnimation(paramAnonymousView.BAv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193344);
      }
    });
    AppMethodBeat.o(192001);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.test.FaceFlashTestAnimateUI
 * JD-Core Version:    0.7.0.1
 */