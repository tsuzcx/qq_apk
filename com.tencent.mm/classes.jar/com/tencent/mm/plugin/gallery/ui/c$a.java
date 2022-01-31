package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;

final class c$a
  implements View.OnClickListener
{
  private String filePath;
  
  public c$a(c paramc, String paramString)
  {
    this.filePath = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21458);
    paramView = new Intent();
    paramView.setAction("android.intent.action.VIEW");
    File localFile = new File(this.filePath);
    k.a(this.nfB.mContext, paramView, localFile, "video/*");
    try
    {
      this.nfB.mContext.startActivity(paramView);
      AppMethodBeat.o(21458);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(21458);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c.a
 * JD-Core Version:    0.7.0.1
 */