package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class k
  extends j
{
  public k(c paramc)
  {
    super(paramc);
  }
  
  public final long a(a parama)
  {
    return 0L;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(2463);
    if (bo.isNullOrNil(paramg.gWh))
    {
      AppMethodBeat.o(2463);
      return -1L;
    }
    paramg = new Intent("android.intent.action.VIEW", Uri.parse(paramg.gWh));
    paramg.addFlags(268435456);
    try
    {
      ah.getContext().startActivity(paramg);
      AppMethodBeat.o(2463);
      return 0L;
    }
    catch (Exception paramg)
    {
      ab.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + paramg.toString());
      AppMethodBeat.o(2463);
    }
    return -1L;
  }
  
  public final FileDownloadTaskInfo iA(long paramLong)
  {
    AppMethodBeat.i(2464);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    localFileDownloadTaskInfo.status = -1;
    AppMethodBeat.o(2464);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean iB(long paramLong)
  {
    return false;
  }
  
  public final boolean iC(long paramLong)
  {
    return false;
  }
  
  public final int iz(long paramLong)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.k
 * JD-Core Version:    0.7.0.1
 */