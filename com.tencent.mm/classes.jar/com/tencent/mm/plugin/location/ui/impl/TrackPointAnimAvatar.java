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
import com.tencent.mm.sdk.platformtools.bu;

public class TrackPointAnimAvatar
  extends RelativeLayout
{
  private ImageView jgy;
  private Context mContext;
  private String username;
  private LinearLayout vur;
  private Animation vus;
  private Animation vut;
  
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
  
  private void dku()
  {
    AppMethodBeat.i(56198);
    this.vus = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F);
    this.vus.setDuration(500L);
    this.vus.setFillAfter(true);
    this.vut = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
    this.vut.setDuration(500L);
    this.vut.setFillAfter(true);
    this.vus.setAnimationListener(new Animation.AnimationListener()
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
    this.vut.setAnimationListener(new Animation.AnimationListener()
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
    this.vur = ((LinearLayout)localView.findViewById(2131296671));
    this.jgy = ((ImageView)localView.findViewById(2131296670));
    dku();
    AppMethodBeat.o(56196);
  }
  
  public void setUser(String paramString)
  {
    AppMethodBeat.i(56197);
    if (!bu.isNullOrNil(paramString))
    {
      this.username = paramString;
      if (this.jgy != null) {
        a.b.d(this.jgy, this.username);
      }
    }
    AppMethodBeat.o(56197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar
 * JD-Core Version:    0.7.0.1
 */