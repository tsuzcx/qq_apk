package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class FaceUploadVideoService
  extends Service
  implements com.tencent.mm.ah.f
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof r))
    {
      paramm = (r)paramm;
      y.i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = h.nFQ;
      if (paramInt2 != 0) {
        break label92;
      }
    }
    label92:
    for (long l = 25L;; l = 26L)
    {
      paramString.a(917L, l, 1L, false);
      g.Dk().b(1197, this);
      e.deleteFile(paramm.mFileName);
      stopSelf();
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      y.e("MicroMsg.FaceUploadVideoService", "hy: null intent called to FaceUploadVideoService! Stub");
      return super.onStartCommand(null, paramInt1, paramInt2);
    }
    String str1 = paramIntent.getStringExtra("key_video_file_name");
    long l = paramIntent.getLongExtra("k_bio_id", -1L);
    String str2 = paramIntent.getStringExtra("key_app_id");
    y.i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", new Object[] { str1 });
    if (bk.bl(str1))
    {
      y.w("MicroMsg.FaceUploadVideoService", "hy: null file name");
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!new com.tencent.mm.vfs.b(str1).exists())
    {
      y.w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if ((l == -1L) && (bk.bl(str2)))
    {
      y.w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
      e.deleteFile(str1);
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = new FaceUploadVideoService.a(this, l, str2, str1, (byte)0);
    localf.field_mediaId = o.Cq(str1);
    localf.field_fullpath = str1;
    localf.field_thumbpath = "";
    localf.field_fileType = a.MediaType_FILE;
    localf.field_talker = "";
    localf.field_priority = a.dlk;
    localf.field_needStorage = false;
    localf.field_isStreamMedia = false;
    localf.field_appType = 0;
    localf.field_bzScene = 0;
    localf.field_largesvideo = 0;
    if (!com.tencent.mm.ak.f.Nd().c(localf))
    {
      y.e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", new Object[] { localf.field_mediaId });
      e.deleteFile(str1);
      FaceDetectReporter.e(l, 1, 10086);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService
 * JD-Core Version:    0.7.0.1
 */