package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;

public class TrackPointAnimAvatar
  extends RelativeLayout
{
  private ImageView ikp;
  private Context mContext;
  private LinearLayout sXp;
  private Animation sXq;
  private Animation sXr;
  private String username;
  
  public TrackPointAnimAvatar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(56195);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(56195);
  }
  
  public TrackPointAnimAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56194);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(56194);
  }
  
  private void cKE()
  {
    AppMethodBeat.i(56198);
    this.sXq = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F);
    this.sXq.setDuration(500L);
    this.sXq.setFillAfter(true);
    this.sXr = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
    this.sXr.setDuration(500L);
    this.sXr.setFillAfter(true);
    this.sXq.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(56192);
        TrackPointAnimAvatar.this.bringToFront();
        TrackPointAnimAvatar.b(TrackPointAnimAvatar.this).startAnimation(TrackPointAnimAvatar.a(TrackPointAnimAvatar.this));
        AppMethodBeat.o(56192);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.sXr.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(56193);
        TrackPointAnimAvatar.this.bringToFront();
        TrackPointAnimAvatar.b(TrackPointAnimAvatar.this).startAnimation(TrackPointAnimAvatar.c(TrackPointAnimAvatar.this));
        AppMethodBeat.o(56193);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(56198);
  }
  
  private void init()
  {
    AppMethodBeat.i(56196);
    View localView = View.inflate(this.mContext, 2131495802, this);
    this.sXp = ((LinearLayout)localView.findViewById(2131296671));
    this.ikp = ((ImageView)localView.findViewById(2131296670));
    cKE();
    AppMethodBeat.o(56196);
  }
  
  public void setUser(String paramString)
  {
    AppMethodBeat.i(56197);
    if (!bt.isNullOrNil(paramString))
    {
      this.username = paramString;
      if (this.ikp != null) {
        a.b.d(this.ikp, this.username);
      }
    }
    AppMethodBeat.o(56197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar
 * JD-Core Version:    0.7.0.1
 */