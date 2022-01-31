package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class b$4
  implements AdapterView.OnItemClickListener
{
  b$4(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.iCF.pl(paramInt);
    paramView = new Intent();
    switch (paramAdapterView.type)
    {
    case 2: 
    default: 
      return;
    case 3: 
      paramView.setAction("android.intent.action.VIEW");
      paramView.setDataAndType(e.aeP(paramAdapterView.filePath), "video/*");
      try
      {
        b.e(this.iCF).startActivity(Intent.createChooser(paramView, b.e(this.iCF).getString(R.l.video_title)));
        return;
      }
      catch (Exception paramAdapterView)
      {
        return;
      }
    case 1: 
      paramView.putExtra("key_title", b.e(this.iCF).getString(R.l.clean_image_detail_title));
      paramView.putExtra("show_menu", false);
      if (e.bK(paramAdapterView.filePath)) {}
      for (paramAdapterView = paramAdapterView.filePath;; paramAdapterView = paramAdapterView.thumbPath)
      {
        paramView.putExtra("key_image_path", paramAdapterView);
        d.e(b.e(this.iCF), ".ui.tools.ShowImageUI", paramView);
        return;
      }
    }
    paramView.putExtra("app_msg_id", paramAdapterView.bHR);
    d.e(b.e(this.iCF), ".ui.chatting.AppAttachDownloadUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.4
 * JD-Core Version:    0.7.0.1
 */