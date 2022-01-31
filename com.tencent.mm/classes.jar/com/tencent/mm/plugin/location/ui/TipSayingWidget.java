package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;

public class TipSayingWidget
  extends LinearLayout
{
  private Context context;
  private String dZZ;
  private TextView ehx;
  private ImageView oej;
  private Chronometer oek;
  private int oel;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113552);
    this.oel = 0;
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2130970997, this);
    this.oej = ((ImageView)paramContext.findViewById(2131828497));
    this.ehx = ((TextView)paramContext.findViewById(2131828498));
    this.oek = ((Chronometer)findViewById(2131826636));
    AppMethodBeat.o(113552);
  }
  
  public void setCurSaying(String paramString)
  {
    AppMethodBeat.i(113553);
    if (bo.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(113553);
      return;
    }
    setVisibility(0);
    a.b.u(this.oej, paramString);
    if (bo.isNullOrNil(this.dZZ)) {
      this.dZZ = r.Zn();
    }
    if (this.dZZ.equals(paramString))
    {
      this.ehx.setText(this.context.getString(2131304390, new Object[] { paramString }));
      this.oek.setVisibility(0);
      AppMethodBeat.o(113553);
      return;
    }
    this.ehx.setText(this.context.getString(2131304390, new Object[] { paramString }));
    this.oek.setVisibility(8);
    AppMethodBeat.o(113553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */