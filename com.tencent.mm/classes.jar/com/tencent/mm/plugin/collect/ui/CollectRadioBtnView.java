package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.z;

public class CollectRadioBtnView
  extends LinearLayout
{
  private TextView lHk;
  private ImageView pmO;
  
  public CollectRadioBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64192);
    init(paramContext);
    AppMethodBeat.o(64192);
  }
  
  public CollectRadioBtnView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64193);
    init(paramContext);
    AppMethodBeat.o(64193);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64194);
    paramContext = z.jV(paramContext).inflate(2131493558, this);
    this.pmO = ((ImageView)paramContext.findViewById(2131303708));
    this.lHk = ((TextView)paramContext.findViewById(2131305948));
    AppMethodBeat.o(64194);
  }
  
  public void setRadioSrc(int paramInt)
  {
    AppMethodBeat.i(64196);
    this.pmO.setImageResource(paramInt);
    AppMethodBeat.o(64196);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(64195);
    this.lHk.setText(paramString);
    AppMethodBeat.o(64195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectRadioBtnView
 * JD-Core Version:    0.7.0.1
 */