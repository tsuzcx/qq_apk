package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.vfs.e;

final class b$3
  implements AdapterView.OnItemClickListener
{
  b$3(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18849);
    ab.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.kJe.tF(paramInt);
    paramView = new Intent();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18849);
      return;
      paramView.setAction("android.intent.action.VIEW");
      k.a(b.a(this.kJe), paramView, e.avH(paramAdapterView.filePath), "video/*");
      try
      {
        b.a(this.kJe).startActivity(Intent.createChooser(paramView, b.a(this.kJe).getString(2131304541)));
        AppMethodBeat.o(18849);
        return;
      }
      catch (Exception paramAdapterView)
      {
        AppMethodBeat.o(18849);
        return;
      }
      paramView.putExtra("key_title", b.a(this.kJe).getString(2131298380));
      paramView.putExtra("show_menu", false);
      paramView.putExtra("key_image_path", paramAdapterView.filePath);
      d.f(b.a(this.kJe), ".ui.tools.ShowImageUI", paramView);
      AppMethodBeat.o(18849);
      return;
      paramView.putExtra("app_msg_id", paramAdapterView.cpg);
      d.f(b.a(this.kJe), ".ui.chatting.AppAttachDownloadUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.3
 * JD-Core Version:    0.7.0.1
 */