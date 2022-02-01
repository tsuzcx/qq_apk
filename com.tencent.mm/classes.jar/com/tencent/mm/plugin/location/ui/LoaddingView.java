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
import com.tencent.mm.sdk.platformtools.bs;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private Animation DM;
  private TextView tYH;
  private ProgressBar tYI;
  private View tYJ;
  private boolean tYK;
  private String tYL;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55802);
    this.tYK = false;
    this.tYL = "";
    init(paramContext);
    AppMethodBeat.o(55802);
  }
  
  @TargetApi(11)
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55801);
    this.tYK = false;
    this.tYL = "";
    init(paramContext);
    AppMethodBeat.o(55801);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55803);
    this.DM = AnimationUtils.loadAnimation(paramContext, 2130772163);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494600, this, true);
    this.tYI = ((ProgressBar)paramContext.findViewById(2131301532));
    this.tYH = ((TextView)paramContext.findViewById(2131301545));
    this.tYJ = paramContext.findViewById(2131301523);
    this.tYH.setText("");
    this.tYH.setVisibility(0);
    this.tYI.setVisibility(0);
    AppMethodBeat.o(55803);
  }
  
  public String getPreText()
  {
    return this.tYL;
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(55806);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(55806);
      return;
    }
    this.tYL = (paramString + "\n");
    AppMethodBeat.o(55806);
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    AppMethodBeat.i(55804);
    this.tYK = paramBoolean;
    this.tYI.setVisibility(8);
    this.tYH.setVisibility(8);
    AppMethodBeat.o(55804);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(55805);
    if ((this.tYH == null) || (this.tYI == null) || (this.tYK))
    {
      AppMethodBeat.o(55805);
      return;
    }
    if (!bs.isNullOrNil(paramString))
    {
      this.tYH.setText(String.valueOf(paramString));
      this.tYI.setVisibility(8);
      this.tYH.setVisibility(0);
      AppMethodBeat.o(55805);
      return;
    }
    this.tYH.setText("");
    this.tYH.setVisibility(0);
    this.tYI.setVisibility(0);
    AppMethodBeat.o(55805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */