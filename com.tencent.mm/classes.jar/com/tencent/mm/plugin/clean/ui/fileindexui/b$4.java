package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

final class b$4
  implements AdapterView.OnItemClickListener
{
  b$4(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22859);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    Log.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qqp.getCount()) });
    if ((paramInt < 0) || (paramInt >= this.qqp.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(22859);
      return;
    }
    paramAdapterView = this.qqp.EP(paramInt);
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
      FileProviderHelper.setIntentDataAndType(b.e(this.qqp), paramView, new o(paramAdapterView.filePath), "video/*", false);
      try
      {
        paramAdapterView = b.e(this.qqp);
        paramView = Intent.createChooser(paramView, b.e(this.qqp).getString(2131767114));
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.axQ(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      catch (Exception paramAdapterView) {}
      continue;
      paramView.putExtra("key_title", b.e(this.qqp).getString(2131757607));
      paramView.putExtra("show_menu", false);
      if (s.YS(paramAdapterView.filePath)) {}
      for (paramAdapterView = paramAdapterView.filePath;; paramAdapterView = paramAdapterView.thumbPath)
      {
        paramView.putExtra("key_image_path", paramAdapterView);
        com.tencent.mm.br.c.f(b.e(this.qqp), ".ui.tools.ShowImageUI", paramView);
        break;
      }
      paramView.putExtra("app_msg_id", paramAdapterView.dFm);
      com.tencent.mm.br.c.f(b.e(this.qqp), ".ui.chatting.AppAttachDownloadUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.4
 * JD-Core Version:    0.7.0.1
 */