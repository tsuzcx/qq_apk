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
import com.tencent.mm.sdk.platformtools.Util;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private Animation FN;
  private TextView yHs;
  private ProgressBar yHt;
  private View yHu;
  private boolean yHv;
  private String yHw;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55802);
    this.yHv = false;
    this.yHw = "";
    init(paramContext);
    AppMethodBeat.o(55802);
  }
  
  @TargetApi(11)
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55801);
    this.yHv = false;
    this.yHw = "";
    init(paramContext);
    AppMethodBeat.o(55801);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55803);
    this.FN = AnimationUtils.loadAnimation(paramContext, 2130772192);
    paramContext = LayoutInflater.from(paramContext).inflate(2131495311, this, true);
    this.yHt = ((ProgressBar)paramContext.findViewById(2131303738));
    this.yHs = ((TextView)paramContext.findViewById(2131303755));
    this.yHu = paramContext.findViewById(2131303729);
    this.yHs.setText("");
    this.yHs.setVisibility(0);
    this.yHt.setVisibility(0);
    AppMethodBeat.o(55803);
  }
  
  public String getPreText()
  {
    return this.yHw;
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(55806);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(55806);
      return;
    }
    this.yHw = (paramString + "\n");
    AppMethodBeat.o(55806);
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    AppMethodBeat.i(55804);
    this.yHv = paramBoolean;
    this.yHt.setVisibility(8);
    this.yHs.setVisibility(8);
    AppMethodBeat.o(55804);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(55805);
    if ((this.yHs == null) || (this.yHt == null) || (this.yHv))
    {
      AppMethodBeat.o(55805);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.yHs.setText(String.valueOf(paramString));
      this.yHt.setVisibility(8);
      this.yHs.setVisibility(0);
      AppMethodBeat.o(55805);
      return;
    }
    this.yHs.setText("");
    this.yHs.setVisibility(0);
    this.yHt.setVisibility(0);
    AppMethodBeat.o(55805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */