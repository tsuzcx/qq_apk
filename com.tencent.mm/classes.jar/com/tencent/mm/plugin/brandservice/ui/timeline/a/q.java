package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q
  extends a
{
  public MMNeat7extView jXI;
  public View jXS;
  public View jXT;
  public View jXs;
  public ImageView jXy;
  public TextView jYR;
  public ImageView jYT;
  public ImageView jYU;
  public MMNeat7extView jYV;
  public View jYu;
  
  public final View a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14279);
    super.b(paramContext, parama);
    if (this.jXr != null)
    {
      paramContext = this.jXr;
      AppMethodBeat.o(14279);
      return paramContext;
    }
    this.jXr = View.inflate(paramContext, 2130968893, null);
    aWX();
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821212));
    this.jYR = ((TextView)this.jXr.findViewById(2131821940));
    this.jXy = ((ImageView)this.jXr.findViewById(2131821944));
    this.jYu = this.jXr.findViewById(2131821943);
    this.jXs = this.jXr.findViewById(2131821887);
    this.jYV = ((MMNeat7extView)this.jXr.findViewById(2131821889));
    this.jXS = this.jXr.findViewById(2131821942);
    this.jXT = this.jXr.findViewById(2131821946);
    this.jYT = ((ImageView)this.jXr.findViewById(2131821895));
    this.jYU = ((ImageView)this.jXr.findViewById(2131821891));
    paramContext = this.jXr;
    AppMethodBeat.o(14279);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.q
 * JD-Core Version:    0.7.0.1
 */