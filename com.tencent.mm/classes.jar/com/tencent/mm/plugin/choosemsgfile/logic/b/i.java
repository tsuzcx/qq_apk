package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.a.b;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;

public final class i
  extends c
{
  public i(g paramg, long paramLong)
  {
    super(paramg, paramLong);
  }
  
  public final void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162331);
    super.a(paraml, paramInt, parama);
    paraml.pIJ.setTextColor(getContext().getResources().getColor(a.b.choose_msg_file_date_tv_color));
    paraml.wPX.setBackgroundColor(getContext().getResources().getColor(a.b.choose_msg_file_date_item_bg));
    AppMethodBeat.o(162331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.i
 * JD-Core Version:    0.7.0.1
 */