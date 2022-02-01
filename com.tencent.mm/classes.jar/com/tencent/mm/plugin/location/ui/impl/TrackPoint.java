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
import com.tencent.mm.sdk.platformtools.Log;

public class TrackPoint
  extends LinearLayout
{
  private Context mContext;
  public ViewManager mViewManager;
  private double mbh;
  private double mbi;
  private double mbj;
  private double mbk;
  private String username;
  private boolean visible;
  public FrameLayout yOd;
  public ImageView yOe;
  private double yOf;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56180);
    this.yOf = 0.0D;
    this.mbh = -1.0D;
    this.mbi = -1.0D;
    this.mbj = -1.0D;
    this.mbk = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    init(0);
    AppMethodBeat.o(56180);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(56181);
    this.yOf = 0.0D;
    this.mbh = -1.0D;
    this.mbi = -1.0D;
    this.mbj = -1.0D;
    this.mbk = -1.0D;
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
    this.yOf = 0.0D;
    this.mbh = -1.0D;
    this.mbi = -1.0D;
    this.mbj = -1.0D;
    this.mbk = -1.0D;
    this.visible = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(2131233559);
    AppMethodBeat.o(56182);
  }
  
  private void init(int paramInt)
  {
    AppMethodBeat.i(56183);
    this.yOd = ((FrameLayout)View.inflate(this.mContext, 2131496760, null));
    this.yOe = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.yOe.setImageResource(paramInt);
    }
    for (;;)
    {
      this.yOe.setBackgroundResource(2131233974);
      this.yOe.setFocusable(true);
      this.yOe.setFocusableInTouchMode(true);
      AppMethodBeat.o(56183);
      return;
      this.yOe.setImageResource(2131233560);
    }
  }
  
  public final void eee()
  {
    AppMethodBeat.i(56185);
    this.visible = false;
    this.yOd.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.yOd);
    }
    AppMethodBeat.o(56185);
  }
  
  public final void eef()
  {
    AppMethodBeat.i(56186);
    this.visible = true;
    this.yOd.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.yOd);
    }
    AppMethodBeat.o(56186);
  }
  
  public double getHeading()
  {
    return this.yOf;
  }
  
  public double getLatOffest()
  {
    return this.mbh - this.mbj;
  }
  
  public double getLongOffset()
  {
    return this.mbi - this.mbk;
  }
  
  public final void n(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56188);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.yOd, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocationPinLayout(this.yOe, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(56188);
  }
  
  public final void o(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56189);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.yOd, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.yOe, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(56189);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(56190);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.yOd);
      this.mViewManager.setMarker2Top(this.yOe);
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
    a.b.d((ImageView)this.yOd.findViewById(2131296756), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.yOd);
    }
    AppMethodBeat.o(56184);
  }
  
  public void setHeading(double paramDouble)
  {
    this.yOf = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void x(double paramDouble)
  {
    AppMethodBeat.i(56187);
    this.yOf = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.yOe, (float)paramDouble);
    }
    AppMethodBeat.o(56187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */