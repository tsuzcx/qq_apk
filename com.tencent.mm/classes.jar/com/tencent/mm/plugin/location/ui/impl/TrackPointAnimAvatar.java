package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;

public class TrackPointAnimAvatar
  extends RelativeLayout
{
  private ImageView ffK;
  private LinearLayout lKv;
  private Animation lKw;
  private Animation lKx;
  private Context mContext;
  private String username;
  
  public TrackPointAnimAvatar(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TrackPointAnimAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = View.inflate(this.mContext, a.f.track_point_avatar, this);
    this.lKv = ((LinearLayout)localView.findViewById(a.e.anim_avatar_layout));
    this.ffK = ((ImageView)localView.findViewById(a.e.anim_avatar));
    this.lKw = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F);
    this.lKw.setDuration(500L);
    this.lKw.setFillAfter(true);
    this.lKx = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
    this.lKx.setDuration(500L);
    this.lKx.setFillAfter(true);
    this.lKw.setAnimationListener(new TrackPointAnimAvatar.1(this));
    this.lKx.setAnimationListener(new TrackPointAnimAvatar.2(this));
  }
  
  public void setUser(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.username = paramString;
      if (this.ffK != null) {
        a.b.n(this.ffK, this.username);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar
 * JD-Core Version:    0.7.0.1
 */