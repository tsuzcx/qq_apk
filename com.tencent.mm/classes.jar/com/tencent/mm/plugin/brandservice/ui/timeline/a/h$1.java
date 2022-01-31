package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class h$1
  implements View.OnClickListener
{
  public h$1(h paramh, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14266);
    if (!this.jMz.field_isExpand)
    {
      this.jYw.jXI.setMaxLines(2147483647);
      this.jMz.field_isExpand = true;
      this.jYw.jYv.setText(2131297703);
      AppMethodBeat.o(14266);
      return;
    }
    this.jYw.jXI.setMaxLines(4);
    this.jMz.field_isExpand = false;
    this.jYw.jYv.setText(2131297704);
    AppMethodBeat.o(14266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.h.1
 * JD-Core Version:    0.7.0.1
 */