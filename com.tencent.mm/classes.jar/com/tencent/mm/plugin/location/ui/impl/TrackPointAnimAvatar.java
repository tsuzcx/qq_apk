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
  private LinearLayout KkK;
  private Animation KkL;
  private Animation KkM;
  private ImageView avatar;
  private Context mContext;
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
  
  private void fVU()
  {
    AppMethodBeat.i(56198);
    this.KkL = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F);
    this.KkL.setDuration(500L);
    this.KkL.setFillAfter(true);
    this.KkM = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
    this.KkM.setDuration(500L);
    this.KkM.setFillAfter(true);
    this.KkL.setAnimationListener(new Animation.AnimationListener()
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
    this.KkM.setAnimationListener(new Animation.AnimationListener()
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
    this.KkK = ((LinearLayout)localView.findViewById(a.e.anim_avatar_layout));
    this.avatar = ((ImageView)localView.findViewById(a.e.anim_avatar));
    fVU();
    AppMethodBeat.o(56196);
  }
  
  public void setUser(String paramString)
  {
    AppMethodBeat.i(56197);
    if (!Util.isNullOrNil(paramString))
    {
      this.username = paramString;
      if (this.avatar != null) {
        a.b.h(this.avatar, this.username);
      }
    }
    AppMethodBeat.o(56197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar
 * JD-Core Version:    0.7.0.1
 */