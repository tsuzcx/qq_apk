package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.af;

public class CollectRadioBtnView
  extends LinearLayout
{
  private TextView sUt;
  private ImageView xey;
  
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
    paramContext = af.mU(paramContext).inflate(a.g.collect_bill_radio_btn, this);
    this.xey = ((ImageView)paramContext.findViewById(a.f.radio_iv));
    this.sUt = ((TextView)paramContext.findViewById(a.f.title_tv));
    AppMethodBeat.o(64194);
  }
  
  public void setRadioSrc(int paramInt)
  {
    AppMethodBeat.i(64196);
    this.xey.setImageResource(paramInt);
    AppMethodBeat.o(64196);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(64195);
    this.sUt.setText(paramString);
    AppMethodBeat.o(64195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectRadioBtnView
 * JD-Core Version:    0.7.0.1
 */