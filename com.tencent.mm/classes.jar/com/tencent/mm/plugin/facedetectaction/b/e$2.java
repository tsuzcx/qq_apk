package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

final class e$2
  implements Runnable
{
  e$2(e parame, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(104225);
    try
    {
      com.tencent.mm.plugin.facedetect.e.a.ctV().PP();
      byte[][] arrayOfByte = this.rpP;
      int j = arrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte1 = arrayOfByte[i];
        com.tencent.mm.plugin.facedetect.e.a.ctV().bn(arrayOfByte1);
        i += 1;
      }
      com.tencent.mm.plugin.facedetect.e.a.ctV().a(new a.b()
      {
        public final void afY(String paramAnonymousString)
        {
          AppMethodBeat.i(104224);
          ad.i("MicroMsg.FaceCheckVideoRecordMgr", "onStop filePath: %s", new Object[] { paramAnonymousString });
          Object localObject1 = com.tencent.mm.plugin.sight.base.e.axx(paramAnonymousString);
          if (localObject1 != null)
          {
            int i = SightVideoJNI.getMp4RotateVFS(paramAnonymousString);
            ad.i("MicroMsg.FaceCheckVideoRecordMgr", "face record video size:%sx%s rotate:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject1).height), Integer.valueOf(i) });
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 46L, 1L, false);
          localObject1 = e.2.this.rpQ;
          try
          {
            ad.i("MicroMsg.FaceCheckVideoRecordMgr", "encryptAndUploadVideoFile: %s", new Object[] { paramAnonymousString });
            Object localObject2;
            Object localObject3;
            if ((!bt.isNullOrNil(paramAnonymousString)) && (i.fv(paramAnonymousString)))
            {
              ad.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { paramAnonymousString, i.aPK(paramAnonymousString) });
              localObject2 = i.aPK(paramAnonymousString);
              ad.i("MicroMsg.FaceCheckVideoRecordMgr", "MD5ForSignatureString：%s", new Object[] { localObject2 });
              localObject2 = ((String)localObject2).getBytes();
              localObject3 = new PByteArray();
              if (!com.tencent.mm.plugin.normsg.a.b.wtJ.a(1, (byte[])localObject2, 0, localObject2.length, (PByteArray)localObject3)) {
                break label483;
              }
            }
            for (((e)localObject1).rpN = ((PByteArray)localObject3).value;; ((e)localObject1).rpN = ((byte[])localObject2))
            {
              localObject2 = paramAnonymousString + "_encrypt";
              ad.i("MicroMsg.FaceCheckVideoRecordMgr", "encrypt video file, personId: %s", new Object[] { ((e)localObject1).rpB });
              e.Y(((e)localObject1).rpB, paramAnonymousString, (String)localObject2);
              ad.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { localObject2, i.aPK((String)localObject2) });
              i.deleteFile(paramAnonymousString);
              ad.i("MicroMsg.FaceCheckVideoRecordMgr", "doUploadVideoFile: %s", new Object[] { localObject2 });
              paramAnonymousString = ((e)localObject1).rpB;
              localObject3 = new com.tencent.mm.i.g();
              ((com.tencent.mm.i.g)localObject3).fJi = "task_FaceCheckVideoRecordMgr";
              ((com.tencent.mm.i.g)localObject3).fJj = new e.b((e)localObject1, (String)localObject2, paramAnonymousString, (byte)0);
              ((com.tencent.mm.i.g)localObject3).field_mediaId = p.afX((String)localObject2);
              ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
              ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
              ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
              ((com.tencent.mm.i.g)localObject3).field_talker = "";
              ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fIw;
              ((com.tencent.mm.i.g)localObject3).field_needStorage = false;
              ((com.tencent.mm.i.g)localObject3).field_isStreamMedia = false;
              ((com.tencent.mm.i.g)localObject3).field_appType = 1;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 0;
              ((com.tencent.mm.i.g)localObject3).field_largesvideo = 0;
              ((com.tencent.mm.i.g)localObject3).ePC = 5;
              if (!f.aGI().f((com.tencent.mm.i.g)localObject3))
              {
                ad.e("MicroMsg.FaceCheckVideoRecordMgr", "hy: video task info failed. clientid:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId });
                i.deleteFile((String)localObject2);
                if (((e)localObject1).rpM != null) {
                  ((e)localObject1).rpM.onError();
                }
              }
              AppMethodBeat.o(104224);
              return;
              label483:
              ad.i("MicroMsg.FaceCheckVideoRecordMgr", "digitalSignature failed");
            }
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", paramAnonymousString, "encryptAndUploadVideoFile error", new Object[0]);
            if (((e)localObject1).rpM != null) {
              ((e)localObject1).rpM.onError();
            }
            AppMethodBeat.o(104224);
          }
        }
      });
      AppMethodBeat.o(104225);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", localException, "recordFrameImpl error", new Object[0]);
      if (this.rpQ.rpM != null) {
        this.rpQ.rpM.onError();
      }
      AppMethodBeat.o(104225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.2
 * JD-Core Version:    0.7.0.1
 */