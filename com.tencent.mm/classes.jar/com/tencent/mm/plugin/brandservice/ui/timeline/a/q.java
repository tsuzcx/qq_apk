package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q
  extends j
{
  public MMNeat7extView nCy;
  public View nDl;
  public TextView nDm;
  
  public final View a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(6042);
    super.b(paramContext, paramc);
    if (this.nBh != null)
    {
      paramContext = this.nBh;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.nBh = View.inflate(paramContext, 2131493218, null);
    bKj();
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131297361));
    this.nDm = ((TextView)this.nBh.findViewById(2131297362));
    this.nCy.setOnTouchListener(new g(this.nCy, new n(this.nCy.getContext())));
    this.nDl = this.nBh.findViewById(2131297342);
    paramContext = this.nBh;
    AppMethodBeat.o(6042);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.q
 * JD-Core Version:    0.7.0.1
 */