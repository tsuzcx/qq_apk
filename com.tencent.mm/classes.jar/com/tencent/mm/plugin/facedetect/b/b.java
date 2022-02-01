package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.g.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.ByteArrayOutputStream;

public final class b
  implements com.tencent.mm.am.h
{
  private boolean isLogin;
  private int zRn;
  private e zRo;
  private d zRp;
  private boolean zRq;
  private long zRr;
  private int zRs;
  private p zRt;
  private p zRu;
  private long zRv;
  private int zRw;
  private int zRx;
  private g.a zRy;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.zRn = -1;
    this.zRo = null;
    this.zRp = null;
    this.isLogin = false;
    this.zRq = false;
    this.zRr = 0L;
    this.zRs = 0;
    this.zRt = null;
    this.zRu = null;
    this.zRv = -1L;
    this.zRw = -1;
    this.zRy = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
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
          b.dOx();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 14L, 1L, false);
          b.a(b.this, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 14L, 1L, false);
          b.a(b.this, 90021, "cdn start error");
          AppMethodBeat.o(103582);
          return 0;
        }
        Log.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null)
        {
          Log.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
          b.dOy();
        }
        AppMethodBeat.o(103582);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.zRn = paramInt1;
    this.zRx = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  private void w(final int paramInt1, final int paramInt2, final String paramString)
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = false;
    AppMethodBeat.i(103587);
    Log.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramp.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramp instanceof v)) || ((paramp instanceof w)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (c)paramp;
        this.zRr = paramString.dOz();
        com.tencent.mm.plugin.facedetect.model.e.mr(this.zRr);
        if (paramString.dOA() == null)
        {
          Log.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          w(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramInt1 = paramString.dOA().length;
        if (this.zRo == null) {
          bool = true;
        }
        Log.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        AppMethodBeat.o(103587);
        return;
      }
      if (this.zRp != null) {
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.zRu != null) && (paramp.getType() == this.zRu.getType()))
    {
      this.zRw = ((int)(System.currentTimeMillis() - this.zRv));
    }
    AppMethodBeat.o(103587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.b
 * JD-Core Version:    0.7.0.1
 */