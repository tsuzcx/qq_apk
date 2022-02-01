package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;

public class TipSayingWidget
  extends LinearLayout
{
  private ImageView EnL;
  private Chronometer EnM;
  private int EnN;
  private Context context;
  private String iRj;
  private TextView jiw;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55954);
    this.EnN = 0;
    this.context = paramContext;
    paramContext = View.inflate(this.context, a.f.tips_saying, this);
    this.EnL = ((ImageView)paramContext.findViewById(a.e.saying_iv));
    this.jiw = ((TextView)paramContext.findViewById(a.e.sayint_tips));
    this.EnM = ((Chronometer)findViewById(a.e.chronometer));
    AppMethodBeat.o(55954);
  }
  
  public void setCurSaying(String paramString)
  {
    AppMethodBeat.i(55955);
    if (Util.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(55955);
      return;
    }
    setVisibility(0);
    a.b.C(this.EnL, paramString);
    if (Util.isNullOrNil(this.iRj)) {
      this.iRj = z.bcZ();
    }
    if (this.iRj.equals(paramString))
    {
      this.jiw.setText(this.context.getString(a.i.track_somebody_saying, new Object[] { paramString }));
      this.EnM.setVisibility(0);
      AppMethodBeat.o(55955);
      return;
    }
    this.jiw.setText(this.context.getString(a.i.track_somebody_saying, new Object[] { paramString }));
    this.EnM.setVisibility(8);
    AppMethodBeat.o(55955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */