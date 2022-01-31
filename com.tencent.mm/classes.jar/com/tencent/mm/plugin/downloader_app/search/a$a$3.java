package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.e;

final class a$a$3
  implements View.OnClickListener
{
  a$a$3(a.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136165);
    paramView = (b)paramView.getTag();
    this.lbw.lbu.lbi.Kd(paramView.lbI);
    if (this.lbw.lbu.mContext.getResources().getString(2131301053).equals(this.lbw.lbq.getText().toString()))
    {
      com.tencent.mm.plugin.downloader.i.a.a(this.lbw.lbu.mContext, paramView.appId, null);
      com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, paramView.position, 22, paramView.appId, "", "");
      AppMethodBeat.o(136165);
      return;
    }
    if (this.lbw.lbu.mContext.getResources().getString(2131300740).equals(this.lbw.lbq.getText().toString()))
    {
      localObject = com.tencent.mm.plugin.downloader.model.d.JD(paramView.appId);
      if (localObject == null)
      {
        AppMethodBeat.o(136165);
        return;
      }
      if (e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath))
      {
        com.tencent.mm.plugin.downloader.i.a.a(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId, false, null);
        com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, paramView.position, 44, paramView.appId, "", "");
      }
      AppMethodBeat.o(136165);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("appId", paramView.appId);
    ((Intent)localObject).addFlags(67108864);
    ((com.tencent.mm.plugin.downloader_app.a.d)g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).a(this.lbw.lbu.mContext, (Intent)localObject, null);
    com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, paramView.position, 23, paramView.appId, "", "");
    AppMethodBeat.o(136165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a.a.3
 * JD-Core Version:    0.7.0.1
 */