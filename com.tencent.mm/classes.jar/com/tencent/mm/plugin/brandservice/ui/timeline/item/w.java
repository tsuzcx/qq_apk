package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;

public class w
  extends aa
{
  public LinearLayout okA;
  public LinearLayout okB;
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramb);
    AppMethodBeat.o(5999);
  }
  
  public final void bPJ()
  {
    AppMethodBeat.i(6000);
    if (this.oiV == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    this.fQl = ((ImageView)this.oiV.findViewById(2131297008));
    this.ojK = ((TextView)this.oiV.findViewById(2131302860));
    this.oln = this.oiV.findViewById(2131297371);
    this.fVV = ((TextView)this.oiV.findViewById(2131305822));
    this.olm = this.oiV.findViewById(2131297276);
    this.okA = ((LinearLayout)this.oiV.findViewById(2131297356));
    this.okB = ((LinearLayout)this.oiV.findViewById(2131297346));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.w
 * JD-Core Version:    0.7.0.1
 */