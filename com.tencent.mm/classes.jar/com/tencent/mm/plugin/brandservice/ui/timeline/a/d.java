package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class d
  extends a
{
  public MMNeat7extView jXI;
  public ImageView jXP;
  public ImageView jXQ;
  public ImageView jXR;
  public View jXS;
  public View jXT;
  public View jXs;
  
  public final View a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14247);
    super.b(paramContext, parama);
    if (this.jXr != null)
    {
      paramContext = this.jXr;
      AppMethodBeat.o(14247);
      return paramContext;
    }
    this.jXr = View.inflate(paramContext, 2130968873, null);
    aWX();
    this.jXP = ((ImageView)this.jXr.findViewById(2131821875));
    this.jXQ = ((ImageView)this.jXr.findViewById(2131821876));
    this.jXR = ((ImageView)this.jXr.findViewById(2131821891));
    this.jXs = this.jXr.findViewById(2131821887);
    this.jXS = this.jXr.findViewById(2131821874);
    this.jXT = this.jXr.findViewById(2131821873);
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821889));
    paramContext = this.jXr;
    AppMethodBeat.o(14247);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */