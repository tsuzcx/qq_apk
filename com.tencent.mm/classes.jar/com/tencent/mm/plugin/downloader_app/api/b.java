package com.tencent.mm.plugin.downloader_app.api;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void a(Context paramContext, a parama1, a parama2);
  
  public abstract void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void a(Context paramContext, String paramString, a parama1, a parama2, a parama3);
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.api.b
 * JD-Core Version:    0.7.0.1
 */