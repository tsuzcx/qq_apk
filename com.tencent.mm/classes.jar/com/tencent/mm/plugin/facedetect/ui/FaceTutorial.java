package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;

public final class FaceTutorial
{
  View qAv;
  Animation zWo;
  
  public FaceTutorial()
  {
    AppMethodBeat.i(104045);
    this.qAv = null;
    this.zWo = null;
    Log.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.zWo = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.alpha_out);
    this.zWo.setDuration(500L);
    AppMethodBeat.o(104045);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104046);
    Log.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.qAv.getVisibility() == 0) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271905);
          FaceTutorial.this.zWo.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(271912);
              FaceTutorial.this.qAv.setVisibility(8);
              AppMethodBeat.o(271912);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          FaceTutorial.this.qAv.startAnimation(FaceTutorial.this.zWo);
          AppMethodBeat.o(271905);
        }
      });
    }
    AppMethodBeat.o(104046);
  }
  
  public static class TutorialOne
    extends Fragment
  {
    private View qAv;
    private Button zWr;
    private WeakReference<FaceTutorial> zWs;
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(104043);
      Log.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
      super.onCreate(paramBundle);
      AppMethodBeat.o(104043);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(104042);
      Log.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
      this.qAv = paramLayoutInflater.inflate(a.g.face_tutorial_fragment_2, paramViewGroup, false);
      this.zWr = ((Button)this.qAv.findViewById(a.e.face_tt_confirm_btn));
      this.zWr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104040);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get() != null) {
            ((FaceTutorial)FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get()).dismiss();
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(104040);
            return;
            Log.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
          }
        }
      });
      paramLayoutInflater = this.qAv;
      AppMethodBeat.o(104042);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(104044);
      super.onDestroy();
      Log.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
      AppMethodBeat.o(104044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial
 * JD-Core Version:    0.7.0.1
 */