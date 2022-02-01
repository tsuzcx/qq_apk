package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

public final class FaceTutorial
{
  ViewPager Qd;
  q gMA;
  View jFG;
  Button rse;
  Animation rsi;
  a rtP;
  
  public FaceTutorial()
  {
    AppMethodBeat.i(104045);
    this.jFG = null;
    this.rsi = null;
    ae.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.rsi = AnimationUtils.loadAnimation(ak.getContext(), 2130771982);
    this.rsi.setDuration(500L);
    AppMethodBeat.o(104045);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104046);
    ae.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.jFG.getVisibility() == 0) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104038);
          FaceTutorial.this.rsi.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(104037);
              FaceTutorial.this.jFG.setVisibility(8);
              AppMethodBeat.o(104037);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          FaceTutorial.this.jFG.startAnimation(FaceTutorial.this.rsi);
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
    private View jFG;
    private Button rtS;
    private WeakReference<FaceTutorial> rtT;
    
    public TutorialOne(FaceTutorial paramFaceTutorial)
    {
      AppMethodBeat.i(104041);
      this.jFG = null;
      this.rtS = null;
      ae.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
      this.rtT = new WeakReference(paramFaceTutorial);
      AppMethodBeat.o(104041);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(104043);
      ae.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
      super.onCreate(paramBundle);
      AppMethodBeat.o(104043);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(104042);
      ae.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
      this.jFG = paramLayoutInflater.inflate(2131493927, paramViewGroup, false);
      this.rtS = ((Button)this.jFG.findViewById(2131299721));
      this.rtS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104040);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get() != null)
          {
            paramAnonymousView = (FaceTutorial)FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get();
            if (paramAnonymousView.rtP != null) {
              paramAnonymousView.rtP.cvp();
            }
            paramAnonymousView.dismiss();
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(104040);
            return;
            ae.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
          }
        }
      });
      paramLayoutInflater = this.jFG;
      AppMethodBeat.o(104042);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(104044);
      super.onDestroy();
      ae.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
      AppMethodBeat.o(104044);
    }
  }
  
  static abstract interface a
  {
    public abstract void cvp();
    
    public abstract void onCancel();
  }
  
  final class b
    extends j
  {
    public b(g paramg)
    {
      super();
    }
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(104039);
      switch (paramInt)
      {
      default: 
        localObject = new InvalidParameterException("hy: invalid page status");
        AppMethodBeat.o(104039);
        throw ((Throwable)localObject);
      }
      Object localObject = new FaceTutorial.TutorialOne(FaceTutorial.this);
      AppMethodBeat.o(104039);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial
 * JD-Core Version:    0.7.0.1
 */