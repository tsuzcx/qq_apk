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
import com.tencent.mm.sdk.platformtools.bs;

public class TipSayingWidget
  extends LinearLayout
{
  private Context context;
  private String fnC;
  private TextView fxS;
  private ImageView ubi;
  private Chronometer ubj;
  private int ubk;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55954);
    this.ubk = 0;
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131495759, this);
    this.ubi = ((ImageView)paramContext.findViewById(2131304297));
    this.fxS = ((TextView)paramContext.findViewById(2131304299));
    this.ubj = ((Chronometer)findViewById(2131298329));
    AppMethodBeat.o(55954);
  }
  
  public void setCurSaying(String paramString)
  {
    AppMethodBeat.i(55955);
    if (bs.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(55955);
      return;
    }
    setVisibility(0);
    a.b.w(this.ubi, paramString);
    if (bs.isNullOrNil(this.fnC)) {
      this.fnC = u.axw();
    }
    if (this.fnC.equals(paramString))
    {
      this.fxS.setText(this.context.getString(2131764532, new Object[] { paramString }));
      this.ubj.setVisibility(0);
      AppMethodBeat.o(55955);
      return;
    }
    this.fxS.setText(this.context.getString(2131764532, new Object[] { paramString }));
    this.ubj.setVisibility(8);
    AppMethodBeat.o(55955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */