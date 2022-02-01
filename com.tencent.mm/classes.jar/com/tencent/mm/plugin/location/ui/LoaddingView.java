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
import com.tencent.mm.sdk.platformtools.bt;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private Animation FD;
  private TextView vbq;
  private ProgressBar vbr;
  private View vbs;
  private boolean vbt;
  private String vbu;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55802);
    this.vbt = false;
    this.vbu = "";
    init(paramContext);
    AppMethodBeat.o(55802);
  }
  
  @TargetApi(11)
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55801);
    this.vbt = false;
    this.vbu = "";
    init(paramContext);
    AppMethodBeat.o(55801);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55803);
    this.FD = AnimationUtils.loadAnimation(paramContext, 2130772163);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494600, this, true);
    this.vbr = ((ProgressBar)paramContext.findViewById(2131301532));
    this.vbq = ((TextView)paramContext.findViewById(2131301545));
    this.vbs = paramContext.findViewById(2131301523);
    this.vbq.setText("");
    this.vbq.setVisibility(0);
    this.vbr.setVisibility(0);
    AppMethodBeat.o(55803);
  }
  
  public String getPreText()
  {
    return this.vbu;
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(55806);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(55806);
      return;
    }
    this.vbu = (paramString + "\n");
    AppMethodBeat.o(55806);
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    AppMethodBeat.i(55804);
    this.vbt = paramBoolean;
    this.vbr.setVisibility(8);
    this.vbq.setVisibility(8);
    AppMethodBeat.o(55804);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(55805);
    if ((this.vbq == null) || (this.vbr == null) || (this.vbt))
    {
      AppMethodBeat.o(55805);
      return;
    }
    if (!bt.isNullOrNil(paramString))
    {
      this.vbq.setText(String.valueOf(paramString));
      this.vbr.setVisibility(8);
      this.vbq.setVisibility(0);
      AppMethodBeat.o(55805);
      return;
    }
    this.vbq.setText("");
    this.vbq.setVisibility(0);
    this.vbr.setVisibility(0);
    AppMethodBeat.o(55805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */