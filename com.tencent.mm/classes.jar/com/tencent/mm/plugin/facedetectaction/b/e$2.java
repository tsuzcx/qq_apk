package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

final class e$2
  implements Runnable
{
  e$2(e parame, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(104225);
    try
    {
      com.tencent.mm.plugin.facedetect.e.a.cTF().aai();
      byte[][] arrayOfByte = this.sXR;
      int j = arrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte1 = arrayOfByte[i];
        com.tencent.mm.plugin.facedetect.e.a.cTF().bD(arrayOfByte1);
        i += 1;
      }
      com.tencent.mm.plugin.facedetect.e.a.cTF().a(new a.b()
      {
        public final void arD(String paramAnonymousString)
        {
          AppMethodBeat.i(104224);
          Log.i("MicroMsg.FaceCheckVideoRecordMgr", "onStop filePath: %s", new Object[] { paramAnonymousString });
          Object localObject1 = com.tencent.mm.plugin.sight.base.e.aNx(paramAnonymousString);
          if (localObject1 != null)
          {
            int i = SightVideoJNI.getMp4RotateVFS(paramAnonymousString);
            Log.i("MicroMsg.FaceCheckVideoRecordMgr", "face record video size:%sx%s rotate:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject1).height), Integer.valueOf(i) });
          }
          h.CyF.idkeyStat(917L, 46L, 1L, false);
          localObject1 = e.2.this.sXS;
          try
          {
            Log.i("MicroMsg.FaceCheckVideoRecordMgr", "encryptAndUploadVideoFile: %s", new Object[] { paramAnonymousString });
            Object localObject2;
            Object localObject3;
            if ((!Util.isNullOrNil(paramAnonymousString)) && (s.YS(paramAnonymousString)))
            {
              Log.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { paramAnonymousString, s.bhK(paramAnonymousString) });
              localObject2 = s.bhK(paramAnonymousString);
              Log.i("MicroMsg.FaceCheckVideoRecordMgr", "MD5ForSignatureString：%s", new Object[] { localObject2 });
              localObject2 = ((String)localObject2).getBytes();
              localObject3 = new PByteArray();
              if (!d.AEF.a(1, (byte[])localObject2, 0, localObject2.length, (PByteArray)localObject3)) {
                break label502;
              }
            }
            for (((e)localObject1).sXN = ((PByteArray)localObject3).value;; ((e)localObject1).sXN = ((byte[])localObject2))
            {
              localObject2 = paramAnonymousString + "_encrypt";
              Log.i("MicroMsg.FaceCheckVideoRecordMgr", "encrypt video file, personId: %s", new Object[] { ((e)localObject1).personId });
              e.ae(((e)localObject1).personId, paramAnonymousString, (String)localObject2);
              Log.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", new Object[] { localObject2, s.bhK((String)localObject2) });
              s.deleteFile(paramAnonymousString);
              Log.i("MicroMsg.FaceCheckVideoRecordMgr", "doUploadVideoFile: %s", new Object[] { localObject2 });
              ((e)localObject1).sXP = System.currentTimeMillis();
              paramAnonymousString = ((e)localObject1).personId;
              localObject3 = new g();
              ((g)localObject3).taskName = "task_FaceCheckVideoRecordMgr";
              ((g)localObject3).gqy = new e.b((e)localObject1, (String)localObject2, paramAnonymousString, (byte)0);
              ((g)localObject3).field_mediaId = p.arC((String)localObject2);
              ((g)localObject3).field_fullpath = ((String)localObject2);
              ((g)localObject3).field_thumbpath = "";
              ((g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
              ((g)localObject3).field_talker = "";
              ((g)localObject3).field_priority = com.tencent.mm.i.a.gpM;
              ((g)localObject3).field_needStorage = false;
              ((g)localObject3).field_isStreamMedia = false;
              ((g)localObject3).field_appType = 1;
              ((g)localObject3).field_bzScene = 0;
              ((g)localObject3).field_largesvideo = 0;
              ((g)localObject3).fuQ = 5;
              com.tencent.mm.plugin.flash.c.b.axn("reqCdn");
              if (!f.baQ().f((g)localObject3))
              {
                Log.e("MicroMsg.FaceCheckVideoRecordMgr", "hy: video task info failed. clientid:%s", new Object[] { ((g)localObject3).field_mediaId });
                s.deleteFile((String)localObject2);
                com.tencent.mm.plugin.flash.c.b.axn("cdnFailTask");
                if (((e)localObject1).sXM != null) {
                  ((e)localObject1).sXM.onError();
                }
              }
              AppMethodBeat.o(104224);
              return;
              label502:
              Log.i("MicroMsg.FaceCheckVideoRecordMgr", "digitalSignature failed");
            }
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", paramAnonymousString, "encryptAndUploadVideoFile error", new Object[0]);
            if (((e)localObject1).sXM != null) {
              ((e)localObject1).sXM.onError();
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
      Log.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", localException, "recordFrameImpl error", new Object[0]);
      if (this.sXS.sXM != null) {
        this.sXS.sXM.onError();
      }
      AppMethodBeat.o(104225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.2
 * JD-Core Version:    0.7.0.1
 */