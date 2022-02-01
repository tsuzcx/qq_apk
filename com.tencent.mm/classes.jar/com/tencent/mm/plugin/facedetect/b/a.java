package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.ByteArrayOutputStream;

public final class a
  implements com.tencent.mm.ak.g
{
  public int qvP;
  public d qvQ;
  public c qvR;
  public boolean qvS;
  public boolean qvT;
  public long qvU;
  public int qvV;
  public n qvW;
  public n qvX;
  public long qvY;
  public int qvZ;
  public int qwa;
  public g.a qwb;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.qvP = -1;
    this.qvQ = null;
    this.qvR = null;
    this.qvS = false;
    this.qvT = false;
    this.qvU = 0L;
    this.qvV = 0;
    this.qvW = null;
    this.qvX = null;
    this.qvY = -1L;
    this.qvZ = -1;
    this.qwb = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103582);
        if (paramAnonymousInt == -21005)
        {
          ac.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(103582);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          ac.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousc = paramAnonymousd.field_fileId;
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("key_pic_cdn_id", paramAnonymousc);
          paramAnonymousString.putString("key_cdn_aes_key", paramAnonymousd.field_aesKey);
          paramAnonymousc = a.this;
          if (paramAnonymousc.qvQ != null) {
            paramAnonymousc.qvQ.n("ok", paramAnonymousString);
          }
          h.wUl.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ac.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.wUl.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ac.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.wUl.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90021, "cdn start error");
          AppMethodBeat.o(103582);
          return 0;
        }
        ac.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null)
        {
          double d = paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength;
          ac.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(d) });
          paramAnonymousString = a.this;
          if (paramAnonymousString.qvQ != null) {
            paramAnonymousString.qvQ.t(d);
          }
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
    this.qvP = paramInt1;
    this.qwa = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  public final void cmW()
  {
    AppMethodBeat.i(103585);
    if (this.qvX != null) {
      com.tencent.mm.kernel.g.agi().b(this.qvX.getType(), this);
    }
    AppMethodBeat.o(103585);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(103587);
    ac.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramn.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramn instanceof u)) || ((paramn instanceof v)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramn;
        this.qvU = paramString.cmX();
        e.to(this.qvU);
        if (paramString.cmY() == null)
        {
          ac.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          s(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramString = paramString.cmY();
        paramInt1 = paramString.length;
        if (this.qvQ == null) {
          bool = true;
        }
        ac.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        if (this.qvR != null) {
          this.qvR.e(this.qvU, paramString);
        }
        AppMethodBeat.o(103587);
        return;
      }
      if (this.qvR != null)
      {
        this.qvR.aP(paramInt1, "get face bio config failed");
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.qvX != null) && (paramn.getType() == this.qvX.getType()))
    {
      this.qvZ = ((int)(System.currentTimeMillis() - this.qvY));
      if (this.qvQ != null) {
        this.qvQ.f(paramInt1, paramInt2, paramString, paramn);
      }
    }
    AppMethodBeat.o(103587);
  }
  
  public final void s(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103586);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103583);
        if (a.this.qvQ != null) {
          a.this.qvQ.a(a.this.qvV, paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(103583);
      }
    });
    AppMethodBeat.o(103586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */