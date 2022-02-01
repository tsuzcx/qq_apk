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
import com.tencent.mm.sdk.platformtools.ae;

public class TrackPoint
  extends LinearLayout
{
  private double kVY;
  private double kVZ;
  private double kWa;
  private double kWb;
  private Context mContext;
  public ViewManager mViewManager;
  private String username;
  private boolean visible;
  public FrameLayout vuo;
  public ImageView vup;
  private double vuq;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56180);
    this.vuq = 0.0D;
    this.kVY = -1.0D;
    this.kVZ = -1.0D;
    this.kWa = -1.0D;
    this.kWb = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    init(0);
    AppMethodBeat.o(56180);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(56181);
    this.vuq = 0.0D;
    this.kVY = -1.0D;
    this.kVZ = -1.0D;
    this.kWa = -1.0D;
    this.kWb = -1.0D;
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
    this.vuq = 0.0D;
    this.kVY = -1.0D;
    this.kVZ = -1.0D;
    this.kWa = -1.0D;
    this.kWb = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(2131232916);
    AppMethodBeat.o(56182);
  }
  
  private void init(int paramInt)
  {
    AppMethodBeat.i(56183);
    this.vuo = ((FrameLayout)View.inflate(this.mContext, 2131495802, null));
    this.vup = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.vup.setImageResource(paramInt);
    }
    for (;;)
    {
      this.vup.setBackgroundResource(2131233299);
      this.vup.setFocusable(true);
      this.vup.setFocusableInTouchMode(true);
      AppMethodBeat.o(56183);
      return;
      this.vup.setImageResource(2131232917);
    }
  }
  
  public final void dks()
  {
    AppMethodBeat.i(56185);
    this.visible = false;
    this.vuo.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.vuo);
    }
    AppMethodBeat.o(56185);
  }
  
  public final void dkt()
  {
    AppMethodBeat.i(56186);
    this.visible = true;
    this.vuo.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.vuo);
    }
    AppMethodBeat.o(56186);
  }
  
  public double getHeading()
  {
    return this.vuq;
  }
  
  public double getLatOffest()
  {
    return this.kVY - this.kWa;
  }
  
  public double getLongOffset()
  {
    return this.kVZ - this.kWb;
  }
  
  public final void n(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56188);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.vuo, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocationPinLayout(this.vup, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(56188);
  }
  
  public final void o(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56189);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.vuo, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.vup, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(56189);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(56190);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.vuo);
      this.mViewManager.setMarker2Top(this.vup);
    }
    AppMethodBeat.o(56190);
  }
  
  public void setAvatar(String paramString)
  {
    AppMethodBeat.i(56184);
    if (paramString.equals(this.username))
    {
      ae.i("MicroMsg.TrackPoint", "skip this set avatar");
      AppMethodBeat.o(56184);
      return;
    }
    this.username = paramString;
    a.b.d((ImageView)this.vuo.findViewById(2131296670), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.vuo);
    }
    AppMethodBeat.o(56184);
  }
  
  public void setHeading(double paramDouble)
  {
    this.vuq = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void x(double paramDouble)
  {
    AppMethodBeat.i(56187);
    this.vuq = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.vup, (float)paramDouble);
    }
    AppMethodBeat.o(56187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */