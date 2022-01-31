package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ak.b;
import com.tencent.mm.j.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$2$1
  implements a.b
{
  e$2$1(e.2 param2) {}
  
  public final void Cr(String paramString)
  {
    y.i("MicroMsg.FaceCheckVideoRecordMgr", "onStop filePath: %s", new Object[] { paramString });
    h.nFQ.a(917L, 46L, 1L, false);
    e locale = this.jWy.jWx;
    try
    {
      y.i("MicroMsg.FaceCheckVideoRecordMgr", "encryptAndUploadVideoFile: %s", new Object[] { paramString });
      if ((!bk.bl(paramString)) && (FileOp.bK(paramString)))
      {
        y.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { paramString, g.bQ(paramString) });
        String str = paramString + "_encrypt";
        y.i("MicroMsg.FaceCheckVideoRecordMgr", "encrypt video file, personId: %s", new Object[] { locale.jWi });
        e.N(locale.jWi, paramString, str);
        y.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { str, g.bQ(str) });
        FileOp.deleteFile(paramString);
        y.i("MicroMsg.FaceCheckVideoRecordMgr", "doUploadVideoFile: %s", new Object[] { str });
        paramString = locale.jWi;
        com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
        localf.dlP = new e.b(locale, str, paramString, (byte)0);
        localf.field_mediaId = o.Cq(str);
        localf.field_fullpath = str;
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
          y.e("MicroMsg.FaceCheckVideoRecordMgr", "hy: video task info failed. clientid:%s", new Object[] { localf.field_mediaId });
          com.tencent.mm.a.e.deleteFile(str);
          if (locale.jWu != null) {
            locale.jWu.onError();
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        y.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", paramString, "encryptAndUploadVideoFile error", new Object[0]);
      } while (locale.jWu == null);
      locale.jWu.onError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.2.1
 * JD-Core Version:    0.7.0.1
 */