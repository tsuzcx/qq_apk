package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

final class b$4
  implements AdapterView.OnItemClickListener
{
  b$4(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22859);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    Log.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tOX.getCount()) });
    if ((paramInt < 0) || (paramInt >= this.tOX.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(22859);
      return;
    }
    paramAdapterView = this.tOX.Iw(paramInt);
    paramView = new Intent();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(22859);
      return;
      paramView.setAction("android.intent.action.VIEW");
      FileProviderHelper.setIntentDataAndType(b.e(this.tOX), paramView, new q(paramAdapterView.filePath), "video/*", false);
      try
      {
        paramAdapterView = b.e(this.tOX);
        paramView = Intent.createChooser(paramView, b.e(this.tOX).getString(R.l.video_title));
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, paramView.aFh(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      catch (Exception paramAdapterView) {}
      continue;
      paramView.putExtra("key_title", b.e(this.tOX).getString(R.l.exA));
      paramView.putExtra("show_menu", false);
      if (u.agG(paramAdapterView.filePath)) {}
      for (paramAdapterView = paramAdapterView.filePath;; paramAdapterView = paramAdapterView.thumbPath)
      {
        paramView.putExtra("key_image_path", paramAdapterView);
        com.tencent.mm.by.c.f(b.e(this.tOX), ".ui.tools.ShowImageUI", paramView);
        break;
      }
      paramView.putExtra("app_msg_id", paramAdapterView.fxU);
      com.tencent.mm.by.c.f(b.e(this.tOX), ".ui.chatting.AppAttachDownloadUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.4
 * JD-Core Version:    0.7.0.1
 */