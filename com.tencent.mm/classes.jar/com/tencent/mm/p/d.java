package com.tencent.mm.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  implements b
{
  public static a mbj = null;
  public c mbk = null;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(120679);
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("WXFileDownloaderBridge", bool);
      mbj = parama;
      AppMethodBeat.o(120679);
      return;
    }
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(120680);
    Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.mbk.f(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(120680);
  }
  
  public final void i(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120681);
    Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.mbk.onTaskFail(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(120681);
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120682);
    Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    AppMethodBeat.o(120682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.p.d
 * JD-Core Version:    0.7.0.1
 */