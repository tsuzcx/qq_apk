package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i
  extends h
{
  public i(b paramb)
  {
    super(paramb);
  }
  
  public final long a(e parame)
  {
    if (bk.bl(parame.fDR)) {
      return -1L;
    }
    parame = new Intent("android.intent.action.VIEW", Uri.parse(parame.fDR));
    parame.addFlags(268435456);
    try
    {
      ae.getContext().startActivity(parame);
      return 0L;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + parame.toString());
    }
    return -1L;
  }
  
  public final int dc(long paramLong)
  {
    return 1;
  }
  
  public final FileDownloadTaskInfo dd(long paramLong)
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    localFileDownloadTaskInfo.status = -1;
    return localFileDownloadTaskInfo;
  }
  
  public final boolean de(long paramLong)
  {
    return false;
  }
  
  public final boolean df(long paramLong)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i
 * JD-Core Version:    0.7.0.1
 */