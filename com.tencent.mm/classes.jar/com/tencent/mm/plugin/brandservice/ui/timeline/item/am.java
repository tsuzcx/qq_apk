package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class am
  extends w
{
  public View iFF;
  public MMNeat7extView oip;
  public ImageView okW;
  public View olI;
  public View oli;
  public View olj;
  public TextView omf;
  public ImageView omh;
  public ImageView omi;
  public MMNeat7extView omj;
  
  public final View a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(6071);
    super.b(paramContext, paramb);
    if (this.oiV != null)
    {
      paramContext = this.oiV;
      AppMethodBeat.o(6071);
      return paramContext;
    }
    this.oiV = View.inflate(paramContext, 2131493231, null);
    bPJ();
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305948));
    this.omf = ((TextView)this.oiV.findViewById(2131303288));
    this.okW = ((ImageView)this.oiV.findViewById(2131297219));
    this.olI = this.oiV.findViewById(2131298114);
    this.iFF = this.oiV.findViewById(2131306012);
    this.omj = ((MMNeat7extView)this.oiV.findViewById(2131305938));
    this.oli = this.oiV.findViewById(2131297350);
    this.olj = this.oiV.findViewById(2131304857);
    this.omh = ((ImageView)this.oiV.findViewById(2131303284));
    this.omi = ((ImageView)this.oiV.findViewById(2131298824));
    paramContext = this.oiV;
    AppMethodBeat.o(6071);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.am
 * JD-Core Version:    0.7.0.1
 */