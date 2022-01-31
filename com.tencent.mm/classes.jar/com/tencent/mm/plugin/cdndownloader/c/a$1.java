package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.j.f;
import com.tencent.mm.j.f.a;
import com.tencent.mm.j.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.Queue;

final class a$1
  implements Runnable
{
  a$1(a parama, f paramf) {}
  
  public final void run()
  {
    if (this.eiO != -1) {
      a.a(this.iAt).put(this.eiP.field_mediaId, Integer.valueOf(this.eiO));
    }
    a.b(this.iAt).add(this.eiP.field_mediaId);
    a.c(this.iAt).put(this.eiP.field_mediaId, this.eiP);
    a locala = this.iAt;
    y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.eiG.size()) });
    Object localObject;
    f localf;
    label237:
    int j;
    for (;;)
    {
      if (!locala.eiG.isEmpty())
      {
        localObject = (String)locala.eiG.poll();
        localf = (f)locala.eiH.remove(localObject);
        if (localf == null) {
          y.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
        }
      }
      else
      {
        return;
      }
      y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localf.field_mediaId, Boolean.valueOf(localf.field_autostart), Integer.valueOf(localf.field_chattype) });
      localf.field_startTime = bk.UY();
      if (!localf.ceg) {
        break;
      }
      if (localf.field_fullpath == null)
      {
        i = -1;
        if (localf.field_thumbpath != null) {
          break label445;
        }
      }
      label445:
      for (j = -1;; j = localf.field_thumbpath.length())
      {
        y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bk.aac(localf.field_svr_signature), bk.aac(localf.field_aesKey), Integer.valueOf(localf.field_fileType), localf.field_mediaId, Boolean.valueOf(localf.field_onlycheckexist) });
        if (localf.field_fullpath == null) {
          localf.field_fullpath = "";
        }
        if (localf.field_thumbpath == null) {
          localf.field_thumbpath = "";
        }
        locala.Ne();
        i = com.tencent.mm.ak.a.b(localf);
        if (i == 0) {
          break label457;
        }
        y.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localf.field_mediaId });
        if (localf.dlP == null) {
          break;
        }
        localf.dlP.a(localf.field_mediaId, i, null, null, localf.field_onlycheckexist);
        break;
        i = localf.field_fullpath.length();
        break label237;
      }
      label457:
      y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localf.field_mediaId });
      locala.eiI.put(localf.field_mediaId, localf);
    }
    int i = -1;
    if ((localf.field_fileType == com.tencent.mm.j.a.dlx) || (localf.field_fileType == com.tencent.mm.j.a.dlz) || (localf.field_fileType == com.tencent.mm.j.a.dlA) || (localf.field_fileType == com.tencent.mm.j.a.dlB) || (localf.field_fileType == com.tencent.mm.j.a.dlC) || (localf.field_fileType == com.tencent.mm.j.a.dlD))
    {
      j = i;
      if (localf.field_fullpath != null)
      {
        j = i;
        if (!localf.field_fullpath.isEmpty())
        {
          locala.Ne();
          j = com.tencent.mm.ak.a.a(localf.field_mediaId, localf.dlQ, localf.field_fullpath, localf.field_fileType, localf.dlR, localf.dlS, localf.dlT, localf.dlU);
        }
      }
      if (localf.field_fullpath == null)
      {
        i = -1;
        label648:
        y.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(i), localf.field_mediaId, localf.dlQ, Integer.valueOf(localf.field_fileType), Integer.valueOf(j) });
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        y.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localf.field_mediaId });
        if (localf.dlP == null) {
          break;
        }
        localf.dlP.a(localf.field_mediaId, i, null, null, localf.field_onlycheckexist);
        break;
        i = localf.field_fullpath.length();
        break label648;
        if (localf.dlW)
        {
          j = i;
          if (localf.field_fullpath != null)
          {
            j = i;
            if (!localf.field_fullpath.isEmpty())
            {
              locala.Ne();
              j = com.tencent.mm.ak.a.a(localf.field_mediaId, localf.field_fullpath, localf.dlQ, localf.dlX, localf.dlY, localf.allow_mobile_net_download, localf.dlR, localf.dlS, localf.is_resume_task, localf.dlV, localf.dlT);
            }
          }
          if (localf.field_fullpath == null) {}
          for (localObject = "";; localObject = localf.field_fullpath)
          {
            y.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localf.field_mediaId, localf.dlQ, localf.dlX });
            i = j;
            break;
          }
        }
        if (localf.field_fullpath == null)
        {
          j = -1;
          label952:
          if (localf.field_thumbpath != null) {
            break label1096;
          }
        }
        label1096:
        for (int k = -1;; k = localf.field_thumbpath.length())
        {
          y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), localf.field_svr_signature, localf.field_aesKey, Integer.valueOf(localf.field_fileType), localf.field_mediaId, Boolean.valueOf(localf.field_onlycheckexist) });
          if (localf.dma != 2) {
            break label1194;
          }
          if (!(localf instanceof g)) {
            break label1253;
          }
          localObject = (g)localf;
          if (!((g)localObject).wZ()) {
            break label1108;
          }
          locala.Ne();
          i = com.tencent.mm.ak.a.a(localf, 2);
          break;
          j = localf.field_fullpath.length();
          break label952;
        }
        label1108:
        if (((g)localObject).wX())
        {
          locala.Ne();
          i = com.tencent.mm.ak.a.a(((g)localObject).field_mediaId, ((g)localObject).url, ((g)localObject).referer, ((g)localObject).field_fullpath, ((g)localObject).dmg, ((g)localObject).dlK, ((g)localObject).initialDownloadOffset, ((g)localObject).initialDownloadLength, ((g)localObject).isColdSnsData, ((g)localObject).signalQuality, ((g)localObject).snsScene, ((g)localObject).field_preloadRatio, ((g)localObject).field_requestVideoFormat);
        }
        continue;
        label1194:
        locala.Ne();
        i = CdnLogic.startC2CDownload(com.tencent.mm.ak.a.a(localf));
        continue;
      }
      y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localf.field_mediaId });
      locala.eiI.put(localf.field_mediaId, localf);
      break;
      label1253:
      i = -1;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|addRecvTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a.1
 * JD-Core Version:    0.7.0.1
 */