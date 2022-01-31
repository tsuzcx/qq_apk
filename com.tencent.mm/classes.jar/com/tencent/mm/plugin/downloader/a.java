package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends FileObserver
{
  private String kVf;
  
  public a(String paramString)
  {
    super(paramString, 618);
    this.kVf = paramString;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(2270);
    if (paramString == null)
    {
      ab.e("DownloadsObserver", "path should be null");
      AppMethodBeat.o(2270);
      return;
    }
    paramString = this.kVf + paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2270);
      return;
      ab.i("DownloadsObserver", "close write file: %s", new Object[] { paramString });
      AppMethodBeat.o(2270);
      return;
      ab.i("DownloadsObserver", "open file: %s", new Object[] { paramString });
      AppMethodBeat.o(2270);
      return;
      ab.i("DownloadsObserver", "delete file: %s", new Object[] { paramString });
      AppMethodBeat.o(2270);
      return;
      ab.i("DownloadsObserver", "move from file: %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a
 * JD-Core Version:    0.7.0.1
 */