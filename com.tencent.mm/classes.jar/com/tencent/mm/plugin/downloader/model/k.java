package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

final class k
  extends j
{
  public k(c paramc)
  {
    super(paramc);
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    return 0L;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(89031);
    if (bs.isNullOrNil(paramg.job))
    {
      AppMethodBeat.o(89031);
      return -1L;
    }
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramg.job));
    ((Intent)localObject).addFlags(268435456);
    try
    {
      paramg = ai.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramg, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/downloader/model/FileDownloaderImplNormal", "addDownloadTask", "(Lcom/tencent/mm/plugin/downloader/model/FileDownloadRequest;)J", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramg.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/plugin/downloader/model/FileDownloaderImplNormal", "addDownloadTask", "(Lcom/tencent/mm/plugin/downloader/model/FileDownloadRequest;)J", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(89031);
      return 0L;
    }
    catch (Exception paramg)
    {
      ac.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + paramg.toString());
      AppMethodBeat.o(89031);
    }
    return -1L;
  }
  
  public final int rS(long paramLong)
  {
    return 1;
  }
  
  public final FileDownloadTaskInfo rT(long paramLong)
  {
    AppMethodBeat.i(89032);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    localFileDownloadTaskInfo.status = -1;
    AppMethodBeat.o(89032);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean rU(long paramLong)
  {
    return false;
  }
  
  public final boolean rV(long paramLong)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.k
 * JD-Core Version:    0.7.0.1
 */