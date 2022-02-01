package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class z
  extends w
{
  public View iFF;
  public MMNeat7extView oip;
  public ImageView olf;
  public ImageView olg;
  public ImageView olh;
  public View oli;
  public View olj;
  
  public final View a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6017);
    super.b(paramContext, paramb);
    if (this.oiV != null)
    {
      paramContext = this.oiV;
      AppMethodBeat.o(6017);
      return paramContext;
    }
    this.oiV = View.inflate(paramContext, 2131493209, null);
    bPJ();
    this.olf = ((ImageView)this.oiV.findViewById(2131303257));
    this.olg = ((ImageView)this.oiV.findViewById(2131303258));
    this.olh = ((ImageView)this.oiV.findViewById(2131298824));
    this.iFF = this.oiV.findViewById(2131306012);
    this.oli = this.oiV.findViewById(2131297218);
    this.olj = this.oiV.findViewById(2131304856);
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305938));
    paramContext = this.oiV;
    AppMethodBeat.o(6017);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.z
 * JD-Core Version:    0.7.0.1
 */