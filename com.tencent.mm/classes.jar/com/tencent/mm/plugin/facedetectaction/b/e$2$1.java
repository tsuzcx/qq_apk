package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.i.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$2$1
  implements a.b
{
  e$2$1(e.2 param2) {}
  
  public final void Ns(String paramString)
  {
    AppMethodBeat.i(702);
    ab.i("MicroMsg.FaceCheckVideoRecordMgr", "onStop filePath: %s", new Object[] { paramString });
    h.qsU.idkeyStat(917L, 46L, 1L, false);
    e locale = this.mqP.mqO;
    try
    {
      ab.i("MicroMsg.FaceCheckVideoRecordMgr", "encryptAndUploadVideoFile: %s", new Object[] { paramString });
      if ((!bo.isNullOrNil(paramString)) && (FileOp.cN(paramString)))
      {
        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { paramString, com.tencent.mm.a.g.getMD5(paramString) });
        String str = paramString + "_encrypt";
        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "encrypt video file, personId: %s", new Object[] { locale.mqA });
        e.S(locale.mqA, paramString, str);
        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { str, com.tencent.mm.a.g.getMD5(str) });
        FileOp.deleteFile(paramString);
        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "doUploadVideoFile: %s", new Object[] { str });
        paramString = locale.mqA;
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.edp = new e.b(locale, str, paramString, (byte)0);
        localg.field_mediaId = p.Nr(str);
        localg.field_fullpath = str;
        localg.field_thumbpath = "";
        localg.field_fileType = a.MediaType_FILE;
        localg.field_talker = "";
        localg.field_priority = a.ecF;
        localg.field_needStorage = false;
        localg.field_isStreamMedia = false;
        localg.field_appType = 0;
        localg.field_bzScene = 0;
        localg.field_largesvideo = 0;
        if (!f.afO().e(localg))
        {
          ab.e("MicroMsg.FaceCheckVideoRecordMgr", "hy: video task info failed. clientid:%s", new Object[] { localg.field_mediaId });
          com.tencent.mm.a.e.deleteFile(str);
          if (locale.mqL != null) {
            locale.mqL.onError();
          }
        }
      }
      AppMethodBeat.o(702);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", paramString, "encryptAndUploadVideoFile error", new Object[0]);
      if (locale.mqL != null) {
        locale.mqL.onError();
      }
      AppMethodBeat.o(702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.2.1
 * JD-Core Version:    0.7.0.1
 */