package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends e
{
  public LinearLayout jXp;
  public LinearLayout jXq;
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14235);
    super.a(paramView, parama);
    AppMethodBeat.o(14235);
  }
  
  public final void aWX()
  {
    AppMethodBeat.i(14236);
    if (this.jXr == null)
    {
      AppMethodBeat.o(14236);
      return;
    }
    this.egq = ((ImageView)this.jXr.findViewById(2131821210));
    this.jXY = ((TextView)this.jXr.findViewById(2131821854));
    this.ekh = ((TextView)this.jXr.findViewById(2131821004));
    this.jXX = this.jXr.findViewById(2131821853);
    this.jXp = ((LinearLayout)this.jXr.findViewById(2131821897));
    this.jXq = ((LinearLayout)this.jXr.findViewById(2131821896));
    AppMethodBeat.o(14236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */