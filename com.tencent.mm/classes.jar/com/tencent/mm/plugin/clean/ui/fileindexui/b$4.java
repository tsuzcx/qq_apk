package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.vfs.e;

final class b$4
  implements AdapterView.OnItemClickListener
{
  b$4(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18749);
    ab.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kHM.getCount()) });
    if ((paramInt < 0) || (paramInt >= this.kHM.getCount()))
    {
      AppMethodBeat.o(18749);
      return;
    }
    paramAdapterView = this.kHM.tB(paramInt);
    paramView = new Intent();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18749);
      return;
      paramView.setAction("android.intent.action.VIEW");
      k.a(b.e(this.kHM), paramView, e.avH(paramAdapterView.filePath), "video/*");
      try
      {
        b.e(this.kHM).startActivity(Intent.createChooser(paramView, b.e(this.kHM).getString(2131304541)));
        AppMethodBeat.o(18749);
        return;
      }
      catch (Exception paramAdapterView)
      {
        AppMethodBeat.o(18749);
        return;
      }
      paramView.putExtra("key_title", b.e(this.kHM).getString(2131298380));
      paramView.putExtra("show_menu", false);
      if (e.cN(paramAdapterView.filePath)) {}
      for (paramAdapterView = paramAdapterView.filePath;; paramAdapterView = paramAdapterView.thumbPath)
      {
        paramView.putExtra("key_image_path", paramAdapterView);
        d.f(b.e(this.kHM), ".ui.tools.ShowImageUI", paramView);
        AppMethodBeat.o(18749);
        return;
      }
      paramView.putExtra("app_msg_id", paramAdapterView.cpg);
      d.f(b.e(this.kHM), ".ui.chatting.AppAttachDownloadUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.4
 * JD-Core Version:    0.7.0.1
 */