package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.bk;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private TextView lEG;
  private ProgressBar lEH;
  private View lEI;
  private boolean lEJ = false;
  private String lEK = "";
  private Animation wb;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.wb = AnimationUtils.loadAnimation(paramContext, a.a.translate_map);
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.location_view, this, true);
    this.lEH = ((ProgressBar)paramContext.findViewById(a.e.location_load_progress));
    this.lEG = ((TextView)paramContext.findViewById(a.e.location_tips));
    this.lEI = paramContext.findViewById(a.e.location_here);
    this.lEG.setText("");
    this.lEG.setVisibility(0);
    this.lEH.setVisibility(0);
  }
  
  public String getPreText()
  {
    return this.lEK;
  }
  
  public void setPreText(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.lEK = (paramString + "\n");
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    this.lEJ = paramBoolean;
    this.lEH.setVisibility(8);
    this.lEG.setVisibility(8);
  }
  
  public void setText(String paramString)
  {
    if ((this.lEG == null) || (this.lEH == null) || (this.lEJ)) {
      return;
    }
    if (!bk.bl(paramString))
    {
      this.lEG.setText(paramString);
      this.lEH.setVisibility(8);
      this.lEG.setVisibility(0);
      return;
    }
    this.lEG.setText("");
    this.lEG.setVisibility(0);
    this.lEH.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */