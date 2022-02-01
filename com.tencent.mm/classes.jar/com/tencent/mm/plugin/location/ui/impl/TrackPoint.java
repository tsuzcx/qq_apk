package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;

public class TrackPoint
  extends LinearLayout
{
  private double jVA;
  private double jVx;
  private double jVy;
  private double jVz;
  private Context mContext;
  public ViewManager mViewManager;
  public FrameLayout sXm;
  public ImageView sXn;
  private double sXo;
  private String username;
  private boolean visible;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56180);
    this.sXo = 0.0D;
    this.jVx = -1.0D;
    this.jVy = -1.0D;
    this.jVz = -1.0D;
    this.jVA = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    init(0);
    AppMethodBeat.o(56180);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(56181);
    this.sXo = 0.0D;
    this.jVx = -1.0D;
    this.jVy = -1.0D;
    this.jVz = -1.0D;
    this.jVA = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(0);
    AppMethodBeat.o(56181);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(56182);
    this.sXo = 0.0D;
    this.jVx = -1.0D;
    this.jVy = -1.0D;
    this.jVz = -1.0D;
    this.jVA = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(2131232916);
    AppMethodBeat.o(56182);
  }
  
  private void init(int paramInt)
  {
    AppMethodBeat.i(56183);
    this.sXm = ((FrameLayout)View.inflate(this.mContext, 2131495802, null));
    this.sXn = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.sXn.setImageResource(paramInt);
    }
    for (;;)
    {
      this.sXn.setBackgroundResource(2131233299);
      this.sXn.setFocusable(true);
      this.sXn.setFocusableInTouchMode(true);
      AppMethodBeat.o(56183);
      return;
      this.sXn.setImageResource(2131232917);
    }
  }
  
  public final void cKC()
  {
    AppMethodBeat.i(56185);
    this.visible = false;
    this.sXm.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.sXm);
    }
    AppMethodBeat.o(56185);
  }
  
  public final void cKD()
  {
    AppMethodBeat.i(56186);
    this.visible = true;
    this.sXm.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.sXm);
    }
    AppMethodBeat.o(56186);
  }
  
  public double getHeading()
  {
    return this.sXo;
  }
  
  public double getLatOffest()
  {
    return this.jVx - this.jVz;
  }
  
  public double getLongOffset()
  {
    return this.jVy - this.jVA;
  }
  
  public final void n(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56188);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.sXm, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocationPinLayout(this.sXn, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(56188);
  }
  
  public final void o(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56189);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.sXm, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.sXn, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(56189);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(56190);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.sXm);
      this.mViewManager.setMarker2Top(this.sXn);
    }
    AppMethodBeat.o(56190);
  }
  
  public void setAvatar(String paramString)
  {
    AppMethodBeat.i(56184);
    if (paramString.equals(this.username))
    {
      ad.i("MicroMsg.TrackPoint", "skip this set avatar");
      AppMethodBeat.o(56184);
      return;
    }
    this.username = paramString;
    a.b.d((ImageView)this.sXm.findViewById(2131296670), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.sXm);
    }
    AppMethodBeat.o(56184);
  }
  
  public void setHeading(double paramDouble)
  {
    this.sXo = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void y(double paramDouble)
  {
    AppMethodBeat.i(56187);
    this.sXo = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.sXn, (float)paramDouble);
    }
    AppMethodBeat.o(56187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */