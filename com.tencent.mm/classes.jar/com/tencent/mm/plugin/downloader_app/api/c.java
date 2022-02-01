package com.tencent.mm.plugin.downloader_app.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.LinkedList;

public abstract interface c
  extends com.tencent.mm.kernel.c.a
{
  public abstract long a(com.tencent.mm.plugin.downloader_app.a.a parama, a.b paramb);
  
  public abstract void a(Context paramContext, Intent paramIntent, a.c paramc);
  
  public abstract void a(e parame);
  
  public abstract boolean a(long paramLong, boolean paramBoolean, a.b paramb);
  
  public abstract void ak(Context paramContext, String paramString);
  
  public abstract void b(e parame);
  
  public abstract boolean cdT();
  
  public abstract void cdU();
  
  public abstract LinkedList<DownloadWidgetTaskInfo> cdV();
  
  public abstract void cdW();
  
  public abstract boolean cdX();
  
  public abstract void e(Context paramContext, Bundle paramBundle);
  
  public abstract void wy(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.api.c
 * JD-Core Version:    0.7.0.1
 */