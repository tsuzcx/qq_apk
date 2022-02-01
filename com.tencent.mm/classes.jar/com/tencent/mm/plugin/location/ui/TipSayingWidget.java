package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;

public class TipSayingWidget
  extends LinearLayout
{
  private Context context;
  private String fki;
  private TextView ful;
  private ImageView sSW;
  private Chronometer sSX;
  private int sSY;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55954);
    this.sSY = 0;
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131495759, this);
    this.sSW = ((ImageView)paramContext.findViewById(2131304297));
    this.ful = ((TextView)paramContext.findViewById(2131304299));
    this.sSX = ((Chronometer)findViewById(2131298329));
    AppMethodBeat.o(55954);
  }
  
  public void setCurSaying(String paramString)
  {
    AppMethodBeat.i(55955);
    if (bt.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(55955);
      return;
    }
    setVisibility(0);
    a.b.w(this.sSW, paramString);
    if (bt.isNullOrNil(this.fki)) {
      this.fki = u.aqG();
    }
    if (this.fki.equals(paramString))
    {
      this.ful.setText(this.context.getString(2131764532, new Object[] { paramString }));
      this.sSX.setVisibility(0);
      AppMethodBeat.o(55955);
      return;
    }
    this.ful.setText(this.context.getString(2131764532, new Object[] { paramString }));
    this.sSX.setVisibility(8);
    AppMethodBeat.o(55955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */