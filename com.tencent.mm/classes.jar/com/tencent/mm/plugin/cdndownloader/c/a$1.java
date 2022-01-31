package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Queue;

final class a$1
  implements Runnable
{
  a$1(a parama, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(874);
    if (this.fyS != -1) {
      a.a(this.kDz).put(this.fyT.field_mediaId, Integer.valueOf(this.fyS));
    }
    a.b(this.kDz).add(this.fyT.field_mediaId);
    a.c(this.kDz).put(this.fyT.field_mediaId, this.fyT);
    a locala = this.kDz;
    ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.fyK.size()) });
    Object localObject;
    g localg;
    int i;
    label249:
    int j;
    for (;;)
    {
      if (!locala.fyK.isEmpty())
      {
        localObject = (String)locala.fyK.poll();
        localg = (g)locala.fyL.remove(localObject);
        if (localg == null)
        {
          ab.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
          AppMethodBeat.o(874);
          return;
        }
        ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
        localg.field_startTime = bo.aoy();
        if (localg.cMU)
        {
          if (localg.field_fullpath == null)
          {
            i = -1;
            if (localg.field_thumbpath != null) {
              break label456;
            }
          }
          label456:
          for (j = -1;; j = localg.field_thumbpath.length())
          {
            ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bo.aqg(localg.field_svr_signature), bo.aqg(localg.field_aesKey), Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
            if (localg.field_fullpath == null) {
              localg.field_fullpath = "";
            }
            if (localg.field_thumbpath == null) {
              localg.field_thumbpath = "";
            }
            i = locala.afP().b(localg);
            if (i == 0) {
              break label468;
            }
            ab.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
            if (localg.edp == null) {
              break;
            }
            localg.edp.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
            break;
            i = localg.field_fullpath.length();
            break label249;
          }
          label468:
          ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
          locala.fyM.put(localg.field_mediaId, localg);
        }
        else
        {
          i = -1;
          if ((localg.field_fileType == com.tencent.mm.i.a.ecS) || (localg.field_fileType == com.tencent.mm.i.a.ecU) || (localg.field_fileType == com.tencent.mm.i.a.ecV) || (localg.field_fileType == com.tencent.mm.i.a.ecW) || (localg.field_fileType == com.tencent.mm.i.a.ecX) || (localg.field_fileType == com.tencent.mm.i.a.ecY))
          {
            j = i;
            if (localg.field_fullpath != null)
            {
              j = i;
              if (!localg.field_fullpath.isEmpty()) {
                j = locala.afP().a(localg.field_mediaId, localg.eds, localg.field_fullpath, localg.field_fileType, localg.edt, localg.edu, localg.edv, localg.edw);
              }
            }
            if (localg.field_fullpath == null)
            {
              i = -1;
              label658:
              ab.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(i), localg.field_mediaId, localg.eds, Integer.valueOf(localg.field_fileType), Integer.valueOf(j) });
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ab.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
        if (localg.edp == null) {
          break;
        }
        localg.edp.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
        break;
        i = localg.field_fullpath.length();
        break label658;
        if (localg.edy)
        {
          j = i;
          if (localg.field_fullpath != null)
          {
            j = i;
            if (!localg.field_fullpath.isEmpty()) {
              j = locala.afP().a(localg.field_mediaId, localg.field_fullpath, localg.eds, localg.edz, localg.edA, localg.allow_mobile_net_download, localg.edt, localg.edu, localg.is_resume_task, localg.edx, localg.edv);
            }
          }
          if (localg.field_fullpath == null) {}
          for (localObject = "";; localObject = localg.field_fullpath)
          {
            ab.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.eds, localg.edz });
            i = j;
            break;
          }
        }
        if (localg.field_fullpath == null)
        {
          j = -1;
          label962:
          if (localg.field_thumbpath != null) {
            break label1105;
          }
        }
        label1105:
        for (int k = -1;; k = localg.field_thumbpath.length())
        {
          ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), localg.field_svr_signature, localg.field_aesKey, Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
          if (localg.edD != 2) {
            break label1194;
          }
          if (!(localg instanceof h)) {
            break label1256;
          }
          localObject = (h)localg;
          if (!((h)localObject).Jr()) {
            break label1117;
          }
          i = locala.afP().a(localg, 2);
          break;
          j = localg.field_fullpath.length();
          break label962;
        }
        label1117:
        if (((h)localObject).Jp()) {
          i = locala.afP().a(((h)localObject).field_mediaId, ((h)localObject).url, ((h)localObject).referer, ((h)localObject).field_fullpath, ((h)localObject).edJ, ((h)localObject).edh, ((h)localObject).isColdSnsData, ((h)localObject).signalQuality, ((h)localObject).snsScene, ((h)localObject).field_preloadRatio, ((h)localObject).field_requestVideoFormat, 1, 1);
        }
        continue;
        label1194:
        i = locala.afP().c(localg);
        continue;
      }
      ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
      locala.fyM.put(localg.field_mediaId, localg);
      break;
      AppMethodBeat.o(874);
      return;
      label1256:
      i = -1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(875);
    String str = super.toString() + "|addRecvTask";
    AppMethodBeat.o(875);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a.1
 * JD-Core Version:    0.7.0.1
 */