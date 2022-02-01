package com.tencent.mm.plugin.downloader_app.api;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void a(Context paramContext, b.a parama1, b.a parama2);
  
  public abstract void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void a(Context paramContext, String paramString, b.a parama1, b.a parama2, b.a parama3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.api.b
 * JD-Core Version:    0.7.0.1
 */