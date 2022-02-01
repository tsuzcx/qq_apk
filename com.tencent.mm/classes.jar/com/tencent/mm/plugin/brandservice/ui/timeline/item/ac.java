package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ac
  extends v
{
  public MMNeat7extView ocA;
  public View ofK;
  public TextView ofL;
  
  public final View a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6042);
    super.b(paramContext, paramb);
    if (this.odh != null)
    {
      paramContext = this.odh;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.odh = View.inflate(paramContext, 2131493218, null);
    bOL();
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131297361));
    this.ofL = ((TextView)this.odh.findViewById(2131297362));
    this.ocA.setOnTouchListener(new g(this.ocA, new n(this.ocA.getContext())));
    this.ofK = this.odh.findViewById(2131297342);
    paramContext = this.odh;
    AppMethodBeat.o(6042);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ac
 * JD-Core Version:    0.7.0.1
 */