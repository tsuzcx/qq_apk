package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends FileObserver
{
  private String piQ;
  
  public a(String paramString)
  {
    super(paramString, 618);
    this.piQ = paramString;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(88814);
    if (paramString == null)
    {
      ad.e("DownloadsObserver", "path should be null");
      AppMethodBeat.o(88814);
      return;
    }
    paramString = this.piQ + paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88814);
      return;
      ad.i("DownloadsObserver", "close write file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      ad.i("DownloadsObserver", "open file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      ad.i("DownloadsObserver", "delete file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      ad.i("DownloadsObserver", "move from file: %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a
 * JD-Core Version:    0.7.0.1
 */