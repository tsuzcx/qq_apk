package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class am
  extends af
{
  public View clickArea;
  public MMNeat7extView vIW;
  public TextView vNg;
  
  public final View b(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6042);
    super.a(paramContext, paramb);
    if (this.vJU != null)
    {
      paramContext = this.vJU;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.vJU = View.inflate(paramContext, d.f.biz_time_line_text_item, null);
    ddU();
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(d.e.biz_time_line_text));
    this.vNg = ((TextView)this.vJU.findViewById(d.e.biz_time_line_text_expand));
    this.vIW.setOnTouchListener(new l(this.vIW, new s(this.vIW.getContext())));
    this.clickArea = this.vJU.findViewById(d.e.biz_time_line_item_click_area);
    paramContext = this.vJU;
    AppMethodBeat.o(6042);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.am
 * JD-Core Version:    0.7.0.1
 */