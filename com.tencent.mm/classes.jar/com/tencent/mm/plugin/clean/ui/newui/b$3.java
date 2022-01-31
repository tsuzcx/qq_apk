package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class b$3
  implements AdapterView.OnItemClickListener
{
  b$3(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.iDX.pp(paramInt);
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
        b.a(this.iDX).startActivity(Intent.createChooser(paramView, b.a(this.iDX).getString(R.l.video_title)));
        return;
      }
      catch (Exception paramAdapterView)
      {
        return;
      }
    case 1: 
      paramView.putExtra("key_title", b.a(this.iDX).getString(R.l.clean_image_detail_title));
      paramView.putExtra("show_menu", false);
      paramView.putExtra("key_image_path", paramAdapterView.filePath);
      d.e(b.a(this.iDX), ".ui.tools.ShowImageUI", paramView);
      return;
    }
    paramView.putExtra("app_msg_id", paramAdapterView.bHR);
    d.e(b.a(this.iDX), ".ui.chatting.AppAttachDownloadUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.3
 * JD-Core Version:    0.7.0.1
 */