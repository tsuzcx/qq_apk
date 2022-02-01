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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

public final class FaceTutorial
{
  ViewPager Om;
  q gqh;
  View jja;
  Button qAl;
  Animation qAp;
  a qBU;
  
  public FaceTutorial()
  {
    AppMethodBeat.i(104045);
    this.jja = null;
    this.qAp = null;
    ac.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.qAp = AnimationUtils.loadAnimation(ai.getContext(), 2130771982);
    this.qAp.setDuration(500L);
    AppMethodBeat.o(104045);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104046);
    ac.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.jja.getVisibility() == 0) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104038);
          FaceTutorial.this.qAp.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(104037);
              FaceTutorial.this.jja.setVisibility(8);
              AppMethodBeat.o(104037);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          FaceTutorial.this.jja.startAnimation(FaceTutorial.this.qAp);
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
    private View jja;
    private Button qBX;
    private WeakReference<FaceTutorial> qBY;
    
    public TutorialOne(FaceTutorial paramFaceTutorial)
    {
      AppMethodBeat.i(104041);
      this.jja = null;
      this.qBX = null;
      ac.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
      this.qBY = new WeakReference(paramFaceTutorial);
      AppMethodBeat.o(104041);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(104043);
      ac.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
      super.onCreate(paramBundle);
      AppMethodBeat.o(104043);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(104042);
      ac.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
      this.jja = paramLayoutInflater.inflate(2131493927, paramViewGroup, false);
      this.qBX = ((Button)this.jja.findViewById(2131299721));
      this.qBX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104040);
          if (FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get() != null)
          {
            paramAnonymousView = (FaceTutorial)FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get();
            if (paramAnonymousView.qBU != null) {
              paramAnonymousView.qBU.coj();
            }
            paramAnonymousView.dismiss();
            AppMethodBeat.o(104040);
            return;
          }
          ac.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
          AppMethodBeat.o(104040);
        }
      });
      paramLayoutInflater = this.jja;
      AppMethodBeat.o(104042);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(104044);
      super.onDestroy();
      ac.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
      AppMethodBeat.o(104044);
    }
  }
  
  static abstract interface a
  {
    public abstract void coj();
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial
 * JD-Core Version:    0.7.0.1
 */