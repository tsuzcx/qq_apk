package com.tencent.mm.plugin.flash.test;

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
  TextView HhL;
  WeImageView HhN;
  ImageView HhO;
  private Button HhP;
  private TextView HhQ;
  Animation HhR;
  Animation HhT;
  Animation HjE;
  
  public int getLayoutId()
  {
    return a.g.face_flash_upload_layout_test;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264575);
    super.onCreate(paramBundle);
    this.HhL = ((TextView)findViewById(a.e.face_flash_header_tip));
    this.HhN = ((WeImageView)findViewById(a.e.face_flash_header_icon));
    this.HhP = ((Button)findViewById(a.e.face_flash_bottom_verify));
    this.HhQ = ((TextView)findViewById(a.e.face_flash_bottom_feedback));
    this.HhO = ((ImageView)findViewById(a.e.face_flash_header_bg));
    this.HhR = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    this.HjE = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_success_scale);
    this.HhT = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    this.HhP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264559);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = FaceFlashTestAnimateUI.this;
        paramAnonymousView.HhL.setText(com.tencent.mm.cd.a.bt(paramAnonymousView.getContext(), a.i.face_upload_sucess_tips));
        paramAnonymousView.HhO.setImageResource(a.d.face_flash_success_circle);
        paramAnonymousView.HhO.startAnimation(paramAnonymousView.HhR);
        paramAnonymousView.HhN.setImageDrawable(com.tencent.mm.cd.a.m(paramAnonymousView.getContext(), a.h.icons_filled_done3));
        paramAnonymousView.HhN.startAnimation(paramAnonymousView.HjE);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264559);
      }
    });
    findViewById(a.e.face_flash_bottom_verify_fail).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264568);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = FaceFlashTestAnimateUI.this;
        Log.i(FaceFlashTestAnimateUI.TAG, "showFailedAnimation");
        paramAnonymousView.HhO.setImageResource(a.d.face_flash_fail_circle);
        paramAnonymousView.HhO.startAnimation(paramAnonymousView.HhR);
        paramAnonymousView.HhN.setImageDrawable(com.tencent.mm.cd.a.m(paramAnonymousView.getContext(), a.h.icons_filled_error3));
        paramAnonymousView.HhN.startAnimation(paramAnonymousView.HhT);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264568);
      }
    });
    AppMethodBeat.o(264575);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.test.FaceFlashTestAnimateUI
 * JD-Core Version:    0.7.0.1
 */