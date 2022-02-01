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
  public FrameLayout Esb;
  public ImageView Esc;
  private double Esd;
  private Context mContext;
  public ViewManager mViewManager;
  private double oYY;
  private double oYZ;
  private double oZa;
  private double oZb;
  private String username;
  private boolean visible;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56180);
    this.Esd = 0.0D;
    this.oYY = -1.0D;
    this.oYZ = -1.0D;
    this.oZa = -1.0D;
    this.oZb = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    init(0);
    AppMethodBeat.o(56180);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(56181);
    this.Esd = 0.0D;
    this.oYY = -1.0D;
    this.oYZ = -1.0D;
    this.oZa = -1.0D;
    this.oZb = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(0);
    AppMethodBeat.o(56181);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(244691);
    this.Esd = 0.0D;
    this.oYY = -1.0D;
    this.oYZ = -1.0D;
    this.oZa = -1.0D;
    this.oZb = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(paramInt);
    AppMethodBeat.o(244691);
  }
  
  private void init(int paramInt)
  {
    AppMethodBeat.i(56183);
    this.Esb = ((FrameLayout)View.inflate(this.mContext, a.f.track_point_avatar, null));
    this.Esc = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.Esc.setImageResource(paramInt);
    }
    for (;;)
    {
      this.Esc.setBackgroundResource(a.d.mm_trans);
      this.Esc.setFocusable(true);
      this.Esc.setFocusableInTouchMode(true);
      AppMethodBeat.o(56183);
      return;
      this.Esc.setImageResource(a.d.location_track_point_icon_navigate);
    }
  }
  
  public final void eNA()
  {
    AppMethodBeat.i(56186);
    this.visible = true;
    this.Esb.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.Esb);
    }
    AppMethodBeat.o(56186);
  }
  
  public final void eNz()
  {
    AppMethodBeat.i(56185);
    this.visible = false;
    this.Esb.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.Esb);
    }
    AppMethodBeat.o(56185);
  }
  
  public double getHeading()
  {
    return this.Esd;
  }
  
  public double getLatOffest()
  {
    return this.oYY - this.oZa;
  }
  
  public double getLongOffset()
  {
    return this.oYZ - this.oZb;
  }
  
  public final void l(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56188);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.Esb, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocationPinLayout(this.Esc, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(56188);
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56189);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.Esb, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.Esc, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(56189);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(56190);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.Esb);
      this.mViewManager.setMarker2Top(this.Esc);
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
    a.b.d((ImageView)this.Esb.findViewById(a.e.anim_avatar), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.Esb);
    }
    AppMethodBeat.o(56184);
  }
  
  public void setHeading(double paramDouble)
  {
    this.Esd = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void y(double paramDouble)
  {
    AppMethodBeat.i(56187);
    this.Esd = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.Esc, (float)paramDouble);
    }
    AppMethodBeat.o(56187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */