package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.vfs.e;

final class a$a$3
  implements View.OnClickListener
{
  a$a$3(a.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    paramView = (b)paramView.getTag();
    this.iSM.iSK.iSy.Ag(paramView.iSX);
    if (this.iSM.iSK.mContext.getResources().getString(b.h.launch_app).equals(this.iSM.iSG.getText().toString())) {
      com.tencent.mm.plugin.downloader.h.a.a(this.iSM.iSK.mContext, paramView.appId, null);
    }
    do
    {
      return;
      if (!this.iSM.iSK.mContext.getResources().getString(b.h.install_app).equals(this.iSM.iSG.getText().toString())) {
        break;
      }
      paramView = c.zH(paramView.appId);
    } while ((paramView == null) || (!e.bK(paramView.field_filePath)));
    com.tencent.mm.plugin.downloader.h.a.m(paramView.field_downloadId, false);
    return;
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramView.appId);
    ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).a(this.iSM.iSK.mContext, localIntent, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a.a.3
 * JD-Core Version:    0.7.0.1
 */