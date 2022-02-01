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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;

public class TipSayingWidget
  extends LinearLayout
{
  private Context context;
  private String gna;
  private TextView gyt;
  private ImageView yJS;
  private Chronometer yJT;
  private int yJU;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55954);
    this.yJU = 0;
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131496717, this);
    this.yJS = ((ImageView)paramContext.findViewById(2131307225));
    this.gyt = ((TextView)paramContext.findViewById(2131307227));
    this.yJT = ((Chronometer)findViewById(2131298721));
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
    a.b.A(this.yJS, paramString);
    if (Util.isNullOrNil(this.gna)) {
      this.gna = z.aTY();
    }
    if (this.gna.equals(paramString))
    {
      this.gyt.setText(this.context.getString(2131766876, new Object[] { paramString }));
      this.yJT.setVisibility(0);
      AppMethodBeat.o(55955);
      return;
    }
    this.gyt.setText(this.context.getString(2131766876, new Object[] { paramString }));
    this.yJT.setVisibility(8);
    AppMethodBeat.o(55955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */