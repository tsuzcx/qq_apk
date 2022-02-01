package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;

public final class FaceTutorial
{
  View kHq;
  Animation sTt;
  
  public FaceTutorial()
  {
    AppMethodBeat.i(104045);
    this.kHq = null;
    this.sTt = null;
    Log.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.sTt = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130771982);
    this.sTt.setDuration(500L);
    AppMethodBeat.o(104045);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104046);
    Log.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.kHq.getVisibility() == 0) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104038);
          FaceTutorial.this.sTt.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(104037);
              FaceTutorial.this.kHq.setVisibility(8);
              AppMethodBeat.o(104037);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          FaceTutorial.this.kHq.startAnimation(FaceTutorial.this.sTt);
          AppMethodBeat.o(104038);
        }
      });
    }
    AppMethodBeat.o(104046);
  }
  
  @SuppressLint({"ValidFragment"})
  public static class TutorialOne
    extends Fragment
  {
    private View kHq;
    private Button sUj;
    private WeakReference<FaceTutorial> sUk;
    
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
      this.kHq = paramLayoutInflater.inflate(2131494095, paramViewGroup, false);
      this.sUj = ((Button)this.kHq.findViewById(2131300387));
      this.sUj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104040);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      paramLayoutInflater = this.kHq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial
 * JD-Core Version:    0.7.0.1
 */