package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q
  extends j
{
  public View naN;
  public TextView naO;
  public MMNeat7extView naa;
  
  public final View a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(6042);
    super.b(paramContext, paramc);
    if (this.mYI != null)
    {
      paramContext = this.mYI;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.mYI = View.inflate(paramContext, 2131493218, null);
    bDa();
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131297361));
    this.naO = ((TextView)this.mYI.findViewById(2131297362));
    this.naa.setOnTouchListener(new g(this.naa, new n(this.naa.getContext())));
    this.naN = this.mYI.findViewById(2131297342);
    paramContext = this.mYI;
    AppMethodBeat.o(6042);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.q
 * JD-Core Version:    0.7.0.1
 */