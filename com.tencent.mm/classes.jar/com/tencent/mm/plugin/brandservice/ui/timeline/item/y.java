package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class y
  extends v
{
  public View iCM;
  public MMNeat7extView ocA;
  public ImageView ofg;
  public ImageView ofh;
  public ImageView ofi;
  public View ofj;
  public View ofk;
  
  public final View a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(6017);
    super.b(paramContext, paramb);
    if (this.odh != null)
    {
      paramContext = this.odh;
      AppMethodBeat.o(6017);
      return paramContext;
    }
    this.odh = View.inflate(paramContext, 2131493209, null);
    bOL();
    this.ofg = ((ImageView)this.odh.findViewById(2131303257));
    this.ofh = ((ImageView)this.odh.findViewById(2131303258));
    this.ofi = ((ImageView)this.odh.findViewById(2131298824));
    this.iCM = this.odh.findViewById(2131306012);
    this.ofj = this.odh.findViewById(2131297218);
    this.ofk = this.odh.findViewById(2131304856);
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305938));
    paramContext = this.odh;
    AppMethodBeat.o(6017);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.y
 * JD-Core Version:    0.7.0.1
 */