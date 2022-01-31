package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.y;

public class TrackPoint
  extends LinearLayout
{
  private boolean aoL = true;
  private double guN = -1.0D;
  private double guO = -1.0D;
  private double guP = -1.0D;
  private double guQ = -1.0D;
  public FrameLayout lKs;
  public ImageView lKt;
  private double lKu = 0.0D;
  private Context mContext;
  public ViewManager mViewManager;
  private String username;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init(0);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(0);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager, int paramInt)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(paramInt);
  }
  
  private void init(int paramInt)
  {
    this.lKs = ((FrameLayout)View.inflate(this.mContext, a.f.track_point_avatar, null));
    this.lKt = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.lKt.setImageResource(paramInt);
    }
    for (;;)
    {
      this.lKt.setBackgroundResource(a.d.mm_trans);
      this.lKt.setFocusable(true);
      this.lKt.setFocusableInTouchMode(true);
      return;
      this.lKt.setImageResource(a.d.location_track_point_icon_navigate);
    }
  }
  
  public final void bfa()
  {
    this.aoL = false;
    this.lKs.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.lKs);
    }
  }
  
  public final void bfb()
  {
    this.aoL = true;
    this.lKs.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.lKs);
    }
  }
  
  public double getHeading()
  {
    return this.lKu;
  }
  
  public double getLatOffest()
  {
    return this.guN - this.guP;
  }
  
  public double getLongOffset()
  {
    return this.guO - this.guQ;
  }
  
  public final void k(double paramDouble1, double paramDouble2)
  {
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.lKs, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocaitonPinLayout(this.lKt, paramDouble1, paramDouble2, false);
    }
  }
  
  public final void l(double paramDouble1, double paramDouble2)
  {
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.lKs, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.lKt, paramDouble1, paramDouble2);
    }
  }
  
  public final void set2Top()
  {
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.lKs);
      this.mViewManager.setMarker2Top(this.lKt);
    }
  }
  
  public void setAvatar(String paramString)
  {
    if (paramString.equals(this.username)) {
      y.i("MicroMsg.TrackPoint", "skip this set avatar");
    }
    do
    {
      return;
      this.username = paramString;
      a.b.n((ImageView)this.lKs.findViewById(a.e.anim_avatar), paramString);
    } while (this.mViewManager == null);
    this.mViewManager.updateMarkerView(this.lKs);
  }
  
  public void setHeading(double paramDouble)
  {
    this.lKu = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void v(double paramDouble)
  {
    this.lKu = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.lKt, (float)paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */