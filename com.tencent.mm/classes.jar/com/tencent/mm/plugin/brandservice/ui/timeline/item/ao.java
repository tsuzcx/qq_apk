package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.ui.tools.p;

public final class ao
  extends a
{
  public ProgressBar progressBar;
  public View sEi;
  public LinearLayout sHE;
  public LinearLayout sHF;
  public TextView sHG;
  public TextView sHH;
  public LinearLayout sHI;
  public TextView sHJ;
  
  public final View cR(Context paramContext)
  {
    AppMethodBeat.i(258478);
    if (this.sEi != null)
    {
      paramContext = this.sEi;
      AppMethodBeat.o(258478);
      return paramContext;
    }
    this.sEi = View.inflate(paramContext, d.f.stQ, null);
    this.sHE = ((LinearLayout)this.sEi.findViewById(d.e.sqq));
    this.sHF = ((LinearLayout)this.sEi.findViewById(d.e.sri));
    this.sHG = ((TextView)this.sEi.findViewById(d.e.srj));
    this.sHI = ((LinearLayout)this.sEi.findViewById(d.e.srb));
    this.sHJ = ((TextView)this.sEi.findViewById(d.e.srd));
    this.progressBar = ((ProgressBar)this.sEi.findViewById(d.e.srg));
    this.sHH = ((TextView)this.sEi.findViewById(d.e.srh));
    paramContext = d.sTw;
    d.l(this.sHG);
    p.E(this.sHF, 0.5F);
    p.E(this.sHE, 0.5F);
    paramContext = this.sEi;
    AppMethodBeat.o(258478);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ao
 * JD-Core Version:    0.7.0.1
 */