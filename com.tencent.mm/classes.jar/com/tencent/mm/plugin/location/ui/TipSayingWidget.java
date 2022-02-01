package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bu;

public class TipSayingWidget
  extends LinearLayout
{
  private Context context;
  private String fHO;
  private TextView fTl;
  private ImageView vqc;
  private Chronometer vqd;
  private int vqe;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55954);
    this.vqe = 0;
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131495759, this);
    this.vqc = ((ImageView)paramContext.findViewById(2131304297));
    this.fTl = ((TextView)paramContext.findViewById(2131304299));
    this.vqd = ((Chronometer)findViewById(2131298329));
    AppMethodBeat.o(55954);
  }
  
  public void setCurSaying(String paramString)
  {
    AppMethodBeat.i(55955);
    if (bu.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(55955);
      return;
    }
    setVisibility(0);
    a.b.w(this.vqc, paramString);
    if (bu.isNullOrNil(this.fHO)) {
      this.fHO = v.aAC();
    }
    if (this.fHO.equals(paramString))
    {
      this.fTl.setText(this.context.getString(2131764532, new Object[] { paramString }));
      this.vqd.setVisibility(0);
      AppMethodBeat.o(55955);
      return;
    }
    this.fTl.setText(this.context.getString(2131764532, new Object[] { paramString }));
    this.vqd.setVisibility(8);
    AppMethodBeat.o(55955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */