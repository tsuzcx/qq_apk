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
  private double kSp;
  private double kSq;
  private double kSr;
  private double kSs;
  private Context mContext;
  public ViewManager mViewManager;
  private String username;
  public FrameLayout vij;
  public ImageView vik;
  private double vil;
  private boolean visible;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56180);
    this.vil = 0.0D;
    this.kSp = -1.0D;
    this.kSq = -1.0D;
    this.kSr = -1.0D;
    this.kSs = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    init(0);
    AppMethodBeat.o(56180);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(56181);
    this.vil = 0.0D;
    this.kSp = -1.0D;
    this.kSq = -1.0D;
    this.kSr = -1.0D;
    this.kSs = -1.0D;
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
    this.vil = 0.0D;
    this.kSp = -1.0D;
    this.kSq = -1.0D;
    this.kSr = -1.0D;
    this.kSs = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(2131232916);
    AppMethodBeat.o(56182);
  }
  
  private void init(int paramInt)
  {
    AppMethodBeat.i(56183);
    this.vij = ((FrameLayout)View.inflate(this.mContext, 2131495802, null));
    this.vik = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.vik.setImageResource(paramInt);
    }
    for (;;)
    {
      this.vik.setBackgroundResource(2131233299);
      this.vik.setFocusable(true);
      this.vik.setFocusableInTouchMode(true);
      AppMethodBeat.o(56183);
      return;
      this.vik.setImageResource(2131232917);
    }
  }
  
  public final void dht()
  {
    AppMethodBeat.i(56185);
    this.visible = false;
    this.vij.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.vij);
    }
    AppMethodBeat.o(56185);
  }
  
  public final void dhu()
  {
    AppMethodBeat.i(56186);
    this.visible = true;
    this.vij.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.vij);
    }
    AppMethodBeat.o(56186);
  }
  
  public double getHeading()
  {
    return this.vil;
  }
  
  public double getLatOffest()
  {
    return this.kSp - this.kSr;
  }
  
  public double getLongOffset()
  {
    return this.kSq - this.kSs;
  }
  
  public final void n(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56188);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.vij, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocationPinLayout(this.vik, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(56188);
  }
  
  public final void o(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56189);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.vij, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.vik, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(56189);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(56190);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.vij);
      this.mViewManager.setMarker2Top(this.vik);
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
    a.b.d((ImageView)this.vij.findViewById(2131296670), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.vij);
    }
    AppMethodBeat.o(56184);
  }
  
  public void setHeading(double paramDouble)
  {
    this.vil = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void x(double paramDouble)
  {
    AppMethodBeat.i(56187);
    this.vil = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.vik, (float)paramDouble);
    }
    AppMethodBeat.o(56187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */