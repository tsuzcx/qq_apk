package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private int lMS;
  private ExdeviceLikeView.a lMT;
  private int lMU;
  private TextView lMV;
  private ImageView lMW;
  private ProgressBar lMX;
  private Context mContext;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(19977);
    this.lMU = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2130969457, this, true);
    this.lMV = ((TextView)paramContext.findViewById(2131823779));
    this.lMW = ((ImageView)paramContext.findViewById(2131823780));
    this.lMX = ((ProgressBar)paramContext.findViewById(2131823781));
    setOnClickListener(new ExdeviceLikeView.1(this));
    AppMethodBeat.o(19977);
  }
  
  public void setLikeNum(int paramInt)
  {
    AppMethodBeat.i(19978);
    this.lMS = paramInt;
    String str = this.lMS;
    if (this.lMS < 0)
    {
      ab.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.lMS > 0) {
        break label97;
      }
      this.lMV.setVisibility(8);
    }
    for (;;)
    {
      this.lMV.setText(str);
      AppMethodBeat.o(19978);
      return;
      if (paramInt <= 999) {
        break;
      }
      ab.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.lMV.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(ExdeviceLikeView.a parama)
  {
    this.lMT = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(19979);
    this.lMU = paramInt;
    if (this.lMU == 1)
    {
      this.lMX.setVisibility(8);
      this.lMV.setVisibility(0);
      this.lMW.setVisibility(0);
      this.lMW.setImageResource(2131231247);
      AppMethodBeat.o(19979);
      return;
    }
    if (this.lMU == 0)
    {
      this.lMX.setVisibility(8);
      this.lMV.setVisibility(0);
      this.lMW.setVisibility(0);
      this.lMW.setImageResource(2131231248);
      AppMethodBeat.o(19979);
      return;
    }
    if (this.lMU == 2)
    {
      this.lMV.setVisibility(8);
      this.lMX.setVisibility(0);
      this.lMW.setVisibility(8);
      AppMethodBeat.o(19979);
      return;
    }
    ab.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(19979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */