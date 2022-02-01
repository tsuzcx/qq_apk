package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends FileObserver
{
  private String ueb;
  
  public a(String paramString)
  {
    super(q.n(paramString, false), 618);
    AppMethodBeat.i(218892);
    this.ueb = paramString;
    AppMethodBeat.o(218892);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(88814);
    if (paramString == null)
    {
      Log.e("DownloadsObserver", "path should be null");
      AppMethodBeat.o(88814);
      return;
    }
    paramString = this.ueb + paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88814);
      return;
      Log.i("DownloadsObserver", "close write file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      Log.i("DownloadsObserver", "open file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      Log.i("DownloadsObserver", "delete file: %s", new Object[] { paramString });
      AppMethodBeat.o(88814);
      return;
      Log.i("DownloadsObserver", "move from file: %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a
 * JD-Core Version:    0.7.0.1
 */