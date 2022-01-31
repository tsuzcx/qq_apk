package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
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
    paramView = new Intent();
    paramView.setAction("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.fromFile(new File(this.filePath)), "video/*");
    try
    {
      this.kJe.mContext.startActivity(paramView);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c.a
 * JD-Core Version:    0.7.0.1
 */