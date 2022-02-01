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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class FaceFlashTestAnimateUI
  extends MMActivity
{
  public static String TAG = "MicroMsg.FaceFlashTestAnimateUI";
  private TextView wHA;
  Animation wHB;
  Animation wHD;
  TextView wHw;
  WeImageView wHx;
  ImageView wHy;
  private Button wHz;
  Animation wIJ;
  
  public int getLayoutId()
  {
    return 2131494073;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186691);
    super.onCreate(paramBundle);
    this.wHw = ((TextView)findViewById(2131300342));
    this.wHx = ((WeImageView)findViewById(2131300341));
    this.wHz = ((Button)findViewById(2131300338));
    this.wHA = ((TextView)findViewById(2131300337));
    this.wHy = ((ImageView)findViewById(2131300340));
    this.wHB = AnimationUtils.loadAnimation(getContext(), 2130772041);
    this.wIJ = AnimationUtils.loadAnimation(getContext(), 2130772043);
    this.wHD = AnimationUtils.loadAnimation(getContext(), 2130772042);
    this.wHz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186689);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FaceFlashTestAnimateUI.this;
        paramAnonymousView.wHw.setText(com.tencent.mm.cb.a.aI(paramAnonymousView.getContext(), 2131759093));
        paramAnonymousView.wHy.setImageResource(2131232243);
        paramAnonymousView.wHy.startAnimation(paramAnonymousView.wHB);
        paramAnonymousView.wHx.setImageDrawable(com.tencent.mm.cb.a.l(paramAnonymousView.getContext(), 2131690539));
        paramAnonymousView.wHx.startAnimation(paramAnonymousView.wIJ);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186689);
      }
    });
    findViewById(2131300339).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186690);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FaceFlashTestAnimateUI.this;
        Log.i(FaceFlashTestAnimateUI.TAG, "showFailedAnimation");
        paramAnonymousView.wHy.setImageResource(2131232242);
        paramAnonymousView.wHy.startAnimation(paramAnonymousView.wHB);
        paramAnonymousView.wHx.setImageDrawable(com.tencent.mm.cb.a.l(paramAnonymousView.getContext(), 2131690548));
        paramAnonymousView.wHx.startAnimation(paramAnonymousView.wHD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/test/FaceFlashTestAnimateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186690);
      }
    });
    AppMethodBeat.o(186691);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.test.FaceFlashTestAnimateUI
 * JD-Core Version:    0.7.0.1
 */