package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.b;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.MMService;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public class FaceUploadVideoService
  extends MMService
  implements com.tencent.mm.al.f
{
  public final IBinder WQ()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.FaceUploadVideoService";
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(103874);
    if ((paramn instanceof r))
    {
      paramn = (r)paramn;
      ad.i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = com.tencent.mm.plugin.report.service.g.yhR;
      if (paramInt2 != 0) {
        break label102;
      }
    }
    label102:
    for (long l = 25L;; l = 26L)
    {
      paramString.idkeyStat(917L, l, 1L, false);
      com.tencent.mm.kernel.g.aiU().b(1197, this);
      i.deleteFile(paramn.mFileName);
      stopSelf();
      AppMethodBeat.o(103874);
      return;
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103873);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.FaceUploadVideoService", "hy: null intent called to FaceUploadVideoService! Stub");
      paramInt1 = super.onStartCommand(null, paramInt1, paramInt2);
      AppMethodBeat.o(103873);
      return paramInt1;
    }
    String str1 = paramIntent.getStringExtra("key_video_file_name");
    long l = paramIntent.getLongExtra("k_bio_id", -1L);
    String str2 = paramIntent.getStringExtra("key_app_id");
    ad.i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", new Object[] { str1 });
    if (bt.isNullOrNil(str1))
    {
      ad.w("MicroMsg.FaceUploadVideoService", "hy: null file name");
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(103873);
      return paramInt1;
    }
    if (!new e(str1).exists())
    {
      ad.w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(103873);
      return paramInt1;
    }
    if ((l == -1L) && (bt.isNullOrNil(str2)))
    {
      ad.w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
      i.deleteFile(str1);
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(103873);
      return paramInt1;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_FaceUploadVideoService";
    localg.fJj = new a(l, str2, str1, (byte)0);
    localg.field_mediaId = p.afX(str1);
    localg.field_fullpath = str1;
    localg.field_thumbpath = "";
    localg.field_fileType = a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = a.fIw;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 0;
    localg.field_bzScene = 0;
    localg.field_largesvideo = 0;
    if (!com.tencent.mm.ao.f.aGI().f(localg))
    {
      ad.e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", new Object[] { localg.field_mediaId });
      i.deleteFile(str1);
      FaceDetectReporter.h(l, 1, 10086);
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(103873);
    return paramInt1;
  }
  
  final class a
    implements g.a
  {
    private String mAppId = null;
    private String mFileName = null;
    private long rhg = -1L;
    
    private a(long paramLong, String paramString1, String paramString2)
    {
      this.rhg = paramLong;
      this.mAppId = paramString1;
      this.mFileName = paramString2;
    }
    
    public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(103872);
      ad.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ad.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 23L, 1L, false);
        FaceDetectReporter.h(this.rhg, 0, 0);
        com.tencent.mm.kernel.g.aiU().a(1197, FaceUploadVideoService.this);
        com.tencent.mm.kernel.g.aiU().a(new r(this.mFileName, this.rhg, this.mAppId, paramd.field_fileId, paramd.field_aesKey), 0);
      }
      do
      {
        AppMethodBeat.o(103872);
        return 0;
        if (paramd != null)
        {
          ad.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          i.deleteFile(this.mFileName);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 24L, 1L, false);
          FaceDetectReporter.h(this.rhg, 1, paramd.field_retCode);
          AppMethodBeat.o(103872);
          return 0;
        }
      } while (paramInt == 0);
      ad.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      i.deleteFile(this.mFileName);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 24L, 1L, false);
      FaceDetectReporter.h(this.rhg, 1, paramInt);
      AppMethodBeat.o(103872);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService
 * JD-Core Version:    0.7.0.1
 */