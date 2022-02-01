package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends FileObserver
{
  private String oFm;
  
  public a(String paramString)
  {
    super(paramString, 618);
    this.oFm = paramString;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(88814);
    if (paramString == null)
    {
      ac.e("DownloadsObserver", "path should be null");
      AppMethodBeat.o(88814);
      return;
    }
    paramString = this.oFm + paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88814);
      return;
      ac.i("DownloadsObserver", "close write file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      ac.i("DownloadsObserver", "open file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      ac.i("DownloadsObserver", "delete file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      ac.i("DownloadsObserver", "move from file: %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a
 * JD-Core Version:    0.7.0.1
 */