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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private TextView obU;
  private ProgressBar obV;
  private View obW;
  private boolean obX;
  private String obY;
  private Animation wq;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113426);
    this.obX = false;
    this.obY = "";
    init(paramContext);
    AppMethodBeat.o(113426);
  }
  
  @TargetApi(11)
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113425);
    this.obX = false;
    this.obY = "";
    init(paramContext);
    AppMethodBeat.o(113425);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(113427);
    this.wq = AnimationUtils.loadAnimation(paramContext, 2131034284);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969995, this, true);
    this.obV = ((ProgressBar)paramContext.findViewById(2131825438));
    this.obU = ((TextView)paramContext.findViewById(2131825439));
    this.obW = paramContext.findViewById(2131825436);
    this.obU.setText("");
    this.obU.setVisibility(0);
    this.obV.setVisibility(0);
    AppMethodBeat.o(113427);
  }
  
  public String getPreText()
  {
    return this.obY;
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(113430);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(113430);
      return;
    }
    this.obY = (paramString + "\n");
    AppMethodBeat.o(113430);
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    AppMethodBeat.i(113428);
    this.obX = paramBoolean;
    this.obV.setVisibility(8);
    this.obU.setVisibility(8);
    AppMethodBeat.o(113428);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(113429);
    if ((this.obU == null) || (this.obV == null) || (this.obX))
    {
      AppMethodBeat.o(113429);
      return;
    }
    if (!bo.isNullOrNil(paramString))
    {
      this.obU.setText(String.valueOf(paramString));
      this.obV.setVisibility(8);
      this.obU.setVisibility(0);
      AppMethodBeat.o(113429);
      return;
    }
    this.obU.setText("");
    this.obU.setVisibility(0);
    this.obV.setVisibility(0);
    AppMethodBeat.o(113429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */