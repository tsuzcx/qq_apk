package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class PoiHeaderView
  extends RelativeLayout
{
  private Context context;
  public TextView ehx;
  public String ocG;
  public String ocH;
  public SimpleImageView ocI;
  
  public PoiHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113469);
    this.ocG = "";
    this.ocH = "";
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2130970425, this);
    this.ehx = ((TextView)paramContext.findViewById(2131826751));
    this.ocI = ((SimpleImageView)paramContext.findViewById(2131826752));
    this.ehx.setVisibility(8);
    this.ocI.setVisibility(8);
    setVisibility(8);
    setOnClickListener(new PoiHeaderView.1(this));
    AppMethodBeat.o(113469);
  }
  
  public void setViewUrl(String paramString)
  {
    AppMethodBeat.i(113470);
    ab.d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(paramString)));
    this.ocH = paramString;
    AppMethodBeat.o(113470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView
 * JD-Core Version:    0.7.0.1
 */