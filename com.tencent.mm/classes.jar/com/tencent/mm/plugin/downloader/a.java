package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends FileObserver
{
  private String iOa;
  
  public a(String paramString)
  {
    super(paramString, 618);
    this.iOa = paramString;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      y.e("DownloadsObserver", "path should be null");
      return;
    }
    paramString = this.iOa + paramString;
    switch (paramInt)
    {
    default: 
      return;
    case 8: 
      y.i("DownloadsObserver", "close write file: %s", new Object[] { paramString });
      return;
    case 32: 
      y.i("DownloadsObserver", "open file: %s", new Object[] { paramString });
      return;
    case 512: 
      y.i("DownloadsObserver", "delete file: %s", new Object[] { paramString });
      return;
    }
    y.i("DownloadsObserver", "move from file: %s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a
 * JD-Core Version:    0.7.0.1
 */