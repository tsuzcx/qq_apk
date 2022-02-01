package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ad
  extends w
{
  public MMNeat7extView oip;
  public View olI;
  public TextView olJ;
  
  public final View a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6042);
    super.b(paramContext, paramb);
    if (this.oiV != null)
    {
      paramContext = this.oiV;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.oiV = View.inflate(paramContext, 2131493218, null);
    bPJ();
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131297361));
    this.olJ = ((TextView)this.oiV.findViewById(2131297362));
    this.oip.setOnTouchListener(new g(this.oip, new n(this.oip.getContext())));
    this.olI = this.oiV.findViewById(2131297342);
    paramContext = this.oiV;
    AppMethodBeat.o(6042);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
 * JD-Core Version:    0.7.0.1
 */