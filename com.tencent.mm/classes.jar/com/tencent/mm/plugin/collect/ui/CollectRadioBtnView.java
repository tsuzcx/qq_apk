package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

public class CollectRadioBtnView
  extends LinearLayout
{
  private TextView iJG;
  private ImageView kSQ;
  
  public CollectRadioBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41329);
    init(paramContext);
    AppMethodBeat.o(41329);
  }
  
  public CollectRadioBtnView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41330);
    init(paramContext);
    AppMethodBeat.o(41330);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(41331);
    paramContext = w.hM(paramContext).inflate(2130969176, this);
    this.kSQ = ((ImageView)paramContext.findViewById(2131822908));
    this.iJG = ((TextView)paramContext.findViewById(2131821212));
    AppMethodBeat.o(41331);
  }
  
  public void setRadioSrc(int paramInt)
  {
    AppMethodBeat.i(41333);
    this.kSQ.setImageResource(paramInt);
    AppMethodBeat.o(41333);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(41332);
    this.iJG.setText(paramString);
    AppMethodBeat.o(41332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectRadioBtnView
 * JD-Core Version:    0.7.0.1
 */