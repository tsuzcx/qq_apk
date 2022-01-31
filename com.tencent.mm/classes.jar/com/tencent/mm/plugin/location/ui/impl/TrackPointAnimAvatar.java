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
import com.tencent.mm.sdk.platformtools.bo;

public class TrackPointAnimAvatar
  extends RelativeLayout
{
  private ImageView gxs;
  private Context mContext;
  private LinearLayout ohN;
  private Animation ohO;
  private Animation ohP;
  private String username;
  
  public TrackPointAnimAvatar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113734);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(113734);
  }
  
  public TrackPointAnimAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113733);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(113733);
  }
  
  private void bMy()
  {
    AppMethodBeat.i(113737);
    this.ohO = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F);
    this.ohO.setDuration(500L);
    this.ohO.setFillAfter(true);
    this.ohP = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
    this.ohP.setDuration(500L);
    this.ohP.setFillAfter(true);
    this.ohO.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(113731);
        TrackPointAnimAvatar.this.bringToFront();
        TrackPointAnimAvatar.b(TrackPointAnimAvatar.this).startAnimation(TrackPointAnimAvatar.a(TrackPointAnimAvatar.this));
        AppMethodBeat.o(113731);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.ohP.setAnimationListener(new TrackPointAnimAvatar.2(this));
    AppMethodBeat.o(113737);
  }
  
  private void init()
  {
    AppMethodBeat.i(113735);
    View localView = View.inflate(this.mContext, 2130971037, this);
    this.ohN = ((LinearLayout)localView.findViewById(2131828626));
    this.gxs = ((ImageView)localView.findViewById(2131828627));
    bMy();
    AppMethodBeat.o(113735);
  }
  
  public void setUser(String paramString)
  {
    AppMethodBeat.i(113736);
    if (!bo.isNullOrNil(paramString))
    {
      this.username = paramString;
      if (this.gxs != null) {
        a.b.s(this.gxs, this.username);
      }
    }
    AppMethodBeat.o(113736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar
 * JD-Core Version:    0.7.0.1
 */