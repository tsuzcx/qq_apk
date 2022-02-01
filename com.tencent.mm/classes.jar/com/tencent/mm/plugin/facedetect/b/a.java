package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.ByteArrayOutputStream;

public final class a
  implements i
{
  private int sPn;
  private d sPo;
  private c sPp;
  private boolean sPq;
  private boolean sPr;
  private long sPs;
  private int sPt;
  private q sPu;
  private q sPv;
  private long sPw;
  private int sPx;
  private int sPy;
  private g.a sPz;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.sPn = -1;
    this.sPo = null;
    this.sPp = null;
    this.sPq = false;
    this.sPr = false;
    this.sPs = 0L;
    this.sPt = 0;
    this.sPu = null;
    this.sPv = null;
    this.sPw = -1L;
    this.sPx = -1;
    this.sPz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103582);
        if (paramAnonymousInt == -21005)
        {
          Log.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(103582);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          Log.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousString = paramAnonymousd.field_fileId;
          paramAnonymousc = new Bundle();
          paramAnonymousc.putString("key_pic_cdn_id", paramAnonymousString);
          paramAnonymousc.putString("key_cdn_aes_key", paramAnonymousd.field_aesKey);
          h.CyF.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.CyF.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.CyF.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90021, "cdn start error");
          AppMethodBeat.o(103582);
          return 0;
        }
        Log.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
        }
        AppMethodBeat.o(103582);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.sPn = paramInt1;
    this.sPy = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(103587);
    Log.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramq.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramq instanceof u)) || ((paramq instanceof v)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramq;
        this.sPs = paramString.cSK();
        e.DF(this.sPs);
        if (paramString.cSL() == null)
        {
          Log.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          s(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramInt1 = paramString.cSL().length;
        if (this.sPo == null) {
          bool = true;
        }
        Log.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        AppMethodBeat.o(103587);
        return;
      }
      if (this.sPp != null) {
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.sPv != null) && (paramq.getType() == this.sPv.getType()))
    {
      this.sPx = ((int)(System.currentTimeMillis() - this.sPw));
    }
    AppMethodBeat.o(103587);
  }
  
  final void s(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103586);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103583);
        AppMethodBeat.o(103583);
      }
    });
    AppMethodBeat.o(103586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */