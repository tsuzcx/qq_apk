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
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public class TrackPoint
  extends LinearLayout
{
  public FrameLayout KkH;
  public ImageView KkI;
  private double KkJ;
  private Context mContext;
  public ViewManager mViewManager;
  private double seA;
  private double seB;
  private double seC;
  private double seD;
  private String username;
  private boolean visible;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56180);
    this.KkJ = 0.0D;
    this.seA = -1.0D;
    this.seB = -1.0D;
    this.seC = -1.0D;
    this.seD = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    sE(0);
    AppMethodBeat.o(56180);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(56181);
    this.KkJ = 0.0D;
    this.seA = -1.0D;
    this.seB = -1.0D;
    this.seC = -1.0D;
    this.seD = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    sE(0);
    AppMethodBeat.o(56181);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(264986);
    this.KkJ = 0.0D;
    this.seA = -1.0D;
    this.seB = -1.0D;
    this.seC = -1.0D;
    this.seD = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    sE(paramInt);
    AppMethodBeat.o(264986);
  }
  
  private void sE(int paramInt)
  {
    AppMethodBeat.i(56183);
    this.KkH = ((FrameLayout)View.inflate(this.mContext, a.f.track_point_avatar, null));
    this.KkI = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.KkI.setImageResource(paramInt);
    }
    for (;;)
    {
      this.KkI.setBackgroundResource(a.d.mm_trans);
      this.KkI.setFocusable(true);
      this.KkI.setFocusableInTouchMode(true);
      AppMethodBeat.o(56183);
      return;
      this.KkI.setImageResource(a.d.location_track_point_icon_navigate);
    }
  }
  
  public final void R(double paramDouble)
  {
    AppMethodBeat.i(56187);
    this.KkJ = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.KkI, (float)paramDouble);
    }
    AppMethodBeat.o(56187);
  }
  
  public final void fVS()
  {
    AppMethodBeat.i(56185);
    this.visible = false;
    this.KkH.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.KkH);
    }
    AppMethodBeat.o(56185);
  }
  
  public final void fVT()
  {
    AppMethodBeat.i(56186);
    this.visible = true;
    this.KkH.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.KkH);
    }
    AppMethodBeat.o(56186);
  }
  
  public double getHeading()
  {
    return this.KkJ;
  }
  
  public double getLatOffest()
  {
    return this.seA - this.seC;
  }
  
  public double getLongOffset()
  {
    return this.seB - this.seD;
  }
  
  public final void p(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56188);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.KkH, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocationPinLayout(this.KkI, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(56188);
  }
  
  public final void q(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56189);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.KkH, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.KkI, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(56189);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(56190);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.KkH);
      this.mViewManager.setMarker2Top(this.KkI);
    }
    AppMethodBeat.o(56190);
  }
  
  public void setAvatar(String paramString)
  {
    AppMethodBeat.i(56184);
    if (paramString.equals(this.username))
    {
      Log.i("MicroMsg.TrackPoint", "skip this set avatar");
      AppMethodBeat.o(56184);
      return;
    }
    this.username = paramString;
    a.b.h((ImageView)this.KkH.findViewById(a.e.anim_avatar), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.KkH);
    }
    AppMethodBeat.o(56184);
  }
  
  public void setHeading(double paramDouble)
  {
    this.KkJ = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */