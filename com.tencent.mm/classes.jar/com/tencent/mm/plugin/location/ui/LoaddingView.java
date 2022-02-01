package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.Util;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private TextView KdU;
  private ProgressBar KdV;
  private ImageView KdW;
  private boolean KdX;
  private String KdY;
  private Animation bCz;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55802);
    this.KdX = false;
    this.KdY = "";
    init(paramContext);
    AppMethodBeat.o(55802);
  }
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55801);
    this.KdX = false;
    this.KdY = "";
    init(paramContext);
    AppMethodBeat.o(55801);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55803);
    this.bCz = AnimationUtils.loadAnimation(paramContext, a.a.translate_map);
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.location_view, this, true);
    this.KdV = ((ProgressBar)paramContext.findViewById(a.e.location_load_progress));
    this.KdU = ((TextView)paramContext.findViewById(a.e.location_tips));
    this.KdW = ((ImageView)paramContext.findViewById(a.e.location_here));
    if (b.iRp()) {
      this.KdW.setImageResource(a.d.location_current_marker_easy_mode);
    }
    this.KdU.setText("");
    this.KdU.setVisibility(0);
    this.KdV.setVisibility(0);
    AppMethodBeat.o(55803);
  }
  
  public String getPreText()
  {
    return this.KdY;
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(55806);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(55806);
      return;
    }
    this.KdY = (paramString + "\n");
    AppMethodBeat.o(55806);
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    AppMethodBeat.i(55804);
    this.KdX = paramBoolean;
    this.KdV.setVisibility(8);
    this.KdU.setVisibility(8);
    AppMethodBeat.o(55804);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(55805);
    if ((this.KdU == null) || (this.KdV == null) || (this.KdX))
    {
      AppMethodBeat.o(55805);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.KdU.setText(String.valueOf(paramString));
      this.KdV.setVisibility(8);
      this.KdU.setVisibility(0);
      AppMethodBeat.o(55805);
      return;
    }
    this.KdU.setText("");
    this.KdU.setVisibility(0);
    this.KdV.setVisibility(0);
    AppMethodBeat.o(55805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */