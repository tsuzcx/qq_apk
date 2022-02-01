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
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;

public class TrackPointAnimAvatar
  extends RelativeLayout
{
  private LinearLayout Ese;
  private Animation Esf;
  private Animation Esg;
  private Context mContext;
  private ImageView mWb;
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
  
  private void eNB()
  {
    AppMethodBeat.i(56198);
    this.Esf = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F);
    this.Esf.setDuration(500L);
    this.Esf.setFillAfter(true);
    this.Esg = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
    this.Esg.setDuration(500L);
    this.Esg.setFillAfter(true);
    this.Esf.setAnimationListener(new Animation.AnimationListener()
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
    this.Esg.setAnimationListener(new Animation.AnimationListener()
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
    View localView = View.inflate(this.mContext, a.f.track_point_avatar, this);
    this.Ese = ((LinearLayout)localView.findViewById(a.e.anim_avatar_layout));
    this.mWb = ((ImageView)localView.findViewById(a.e.anim_avatar));
    eNB();
    AppMethodBeat.o(56196);
  }
  
  public void setUser(String paramString)
  {
    AppMethodBeat.i(56197);
    if (!Util.isNullOrNil(paramString))
    {
      this.username = paramString;
      if (this.mWb != null) {
        a.b.d(this.mWb, this.username);
      }
    }
    AppMethodBeat.o(56197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar
 * JD-Core Version:    0.7.0.1
 */