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
import com.tencent.mm.sdk.platformtools.ab;

public class TrackPoint
  extends LinearLayout
{
  private boolean arf;
  private double hPI;
  private double hPJ;
  private double hPK;
  private double hPL;
  private Context mContext;
  public ViewManager mViewManager;
  public FrameLayout ohK;
  public ImageView ohL;
  private double ohM;
  private String username;
  
  public TrackPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113720);
    this.ohM = 0.0D;
    this.hPI = -1.0D;
    this.hPJ = -1.0D;
    this.hPK = -1.0D;
    this.hPL = -1.0D;
    this.arf = true;
    this.mContext = paramContext;
    init(0);
    AppMethodBeat.o(113720);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager)
  {
    super(paramContext);
    AppMethodBeat.i(113721);
    this.ohM = 0.0D;
    this.hPI = -1.0D;
    this.hPJ = -1.0D;
    this.hPK = -1.0D;
    this.hPL = -1.0D;
    this.arf = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(0);
    AppMethodBeat.o(113721);
  }
  
  public TrackPoint(Context paramContext, ViewManager paramViewManager, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(113722);
    this.ohM = 0.0D;
    this.hPI = -1.0D;
    this.hPJ = -1.0D;
    this.hPK = -1.0D;
    this.hPL = -1.0D;
    this.arf = true;
    this.mContext = paramContext;
    this.mViewManager = paramViewManager;
    init(2130839318);
    AppMethodBeat.o(113722);
  }
  
  private void init(int paramInt)
  {
    AppMethodBeat.i(113723);
    this.ohK = ((FrameLayout)View.inflate(this.mContext, 2130971037, null));
    this.ohL = new ImageView(this.mContext);
    if (paramInt > 0) {
      this.ohL.setImageResource(paramInt);
    }
    for (;;)
    {
      this.ohL.setBackgroundResource(2130839676);
      this.ohL.setFocusable(true);
      this.ohL.setFocusableInTouchMode(true);
      AppMethodBeat.o(113723);
      return;
      this.ohL.setImageResource(2130839319);
    }
  }
  
  public final void bMw()
  {
    AppMethodBeat.i(113725);
    this.arf = false;
    this.ohK.setVisibility(4);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.ohK);
    }
    AppMethodBeat.o(113725);
  }
  
  public final void bMx()
  {
    AppMethodBeat.i(113726);
    this.arf = true;
    this.ohK.setVisibility(0);
    if (this.mViewManager != null) {
      this.mViewManager.toggleViewVisible(this.ohK);
    }
    AppMethodBeat.o(113726);
  }
  
  public double getHeading()
  {
    return this.ohM;
  }
  
  public double getLatOffest()
  {
    return this.hPI - this.hPK;
  }
  
  public double getLongOffset()
  {
    return this.hPJ - this.hPL;
  }
  
  public final void n(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113728);
    if (this.mViewManager != null)
    {
      this.mViewManager.updateViewLayout(this.ohK, paramDouble1, paramDouble2, false);
      this.mViewManager.updateLocaitonPinLayout(this.ohL, paramDouble1, paramDouble2, false);
    }
    AppMethodBeat.o(113728);
  }
  
  public final void o(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113729);
    if (this.mViewManager != null)
    {
      this.mViewManager.addView(this.ohK, paramDouble1, paramDouble2);
      this.mViewManager.addView(this.ohL, paramDouble1, paramDouble2);
    }
    AppMethodBeat.o(113729);
  }
  
  public final void set2Top()
  {
    AppMethodBeat.i(113730);
    if (this.mViewManager != null)
    {
      this.mViewManager.setMarker2Top(this.ohK);
      this.mViewManager.setMarker2Top(this.ohL);
    }
    AppMethodBeat.o(113730);
  }
  
  public void setAvatar(String paramString)
  {
    AppMethodBeat.i(113724);
    if (paramString.equals(this.username))
    {
      ab.i("MicroMsg.TrackPoint", "skip this set avatar");
      AppMethodBeat.o(113724);
      return;
    }
    this.username = paramString;
    a.b.s((ImageView)this.ohK.findViewById(2131828627), paramString);
    if (this.mViewManager != null) {
      this.mViewManager.updateMarkerView(this.ohK);
    }
    AppMethodBeat.o(113724);
  }
  
  public void setHeading(double paramDouble)
  {
    this.ohM = paramDouble;
  }
  
  public void setOnAvatarOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnLocationOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void y(double paramDouble)
  {
    AppMethodBeat.i(113727);
    this.ohM = paramDouble;
    if (this.mViewManager != null) {
      this.mViewManager.updateRotation(this.ohL, (float)paramDouble);
    }
    AppMethodBeat.o(113727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.TrackPoint
 * JD-Core Version:    0.7.0.1
 */