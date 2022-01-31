package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class h
  extends a
{
  public MMNeat7extView jXI;
  public View jYu;
  public TextView jYv;
  
  public final View a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14267);
    super.b(paramContext, parama);
    if (this.jXr != null)
    {
      paramContext = this.jXr;
      AppMethodBeat.o(14267);
      return paramContext;
    }
    this.jXr = View.inflate(paramContext, 2130968880, null);
    aWX();
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821903));
    this.jYv = ((TextView)this.jXr.findViewById(2131821904));
    this.jXI.setOnTouchListener(new f(this.jXI, new m(this.jXI.getContext())));
    this.jYu = this.jXr.findViewById(2131821902);
    paramContext = this.jXr;
    AppMethodBeat.o(14267);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.h
 * JD-Core Version:    0.7.0.1
 */