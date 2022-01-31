package com.tencent.mm.plugin.downloader_app.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.sdk.platformtools.bo;

final class BottomEntranceView$2
  implements View.OnClickListener
{
  BottomEntranceView$2(BottomEntranceView paramBottomEntranceView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136210);
    if ((BottomEntranceView.b(this.lbR) != null) && (!bo.isNullOrNil(BottomEntranceView.b(this.lbR).knV)))
    {
      paramView = new Bundle();
      paramView.putString("rawUrl", BottomEntranceView.b(this.lbR).knV);
      ((d)g.E(d.class)).g(this.lbR.getContext(), paramView);
      a.a(10, 1005, 1, 40, "", "", "");
    }
    AppMethodBeat.o(136210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView.2
 * JD-Core Version:    0.7.0.1
 */