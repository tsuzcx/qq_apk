package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.ByteArrayOutputStream;

public final class b
  implements i
{
  private boolean isLogin;
  private int wvi;
  private e wvj;
  private d wvk;
  private boolean wvl;
  private long wvm;
  private int wvn;
  private q wvo;
  private q wvp;
  private long wvq;
  private int wvr;
  private int wvs;
  private g.a wvt;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.wvi = -1;
    this.wvj = null;
    this.wvk = null;
    this.isLogin = false;
    this.wvl = false;
    this.wvm = 0L;
    this.wvn = 0;
    this.wvo = null;
    this.wvp = null;
    this.wvq = -1L;
    this.wvr = -1;
    this.wvt = new g.a()
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
          b.dhM();
          h.IzE.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.IzE.idkeyStat(917L, 14L, 1L, false);
          b.a(b.this, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.IzE.idkeyStat(917L, 14L, 1L, false);
          b.a(b.this, 90021, "cdn start error");
          AppMethodBeat.o(103582);
          return 0;
        }
        Log.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null)
        {
          Log.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
          b.dhN();
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
    this.wvi = paramInt1;
    this.wvs = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  private void t(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103586);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103583);
        if (b.a(b.this) != null)
        {
          b.a(b.this);
          b.b(b.this);
        }
        AppMethodBeat.o(103583);
      }
    });
    AppMethodBeat.o(103586);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(103587);
    Log.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramq.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramq instanceof v)) || ((paramq instanceof w)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (c)paramq;
        this.wvm = paramString.dhO();
        com.tencent.mm.plugin.facedetect.model.e.JT(this.wvm);
        if (paramString.dhP() == null)
        {
          Log.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          t(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramInt1 = paramString.dhP().length;
        if (this.wvj == null) {
          bool = true;
        }
        Log.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        AppMethodBeat.o(103587);
        return;
      }
      if (this.wvk != null) {
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.wvp != null) && (paramq.getType() == this.wvp.getType()))
    {
      this.wvr = ((int)(System.currentTimeMillis() - this.wvq));
    }
    AppMethodBeat.o(103587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.b
 * JD-Core Version:    0.7.0.1
 */