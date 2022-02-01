package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.ByteArrayOutputStream;

public final class a
  implements com.tencent.mm.al.g
{
  public int pNh;
  public d pNi;
  public c pNj;
  public boolean pNk;
  public boolean pNl;
  public long pNm;
  public int pNn;
  public n pNo;
  public n pNp;
  public long pNq;
  public int pNr;
  public int pNs;
  public g.a pNt;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.pNh = -1;
    this.pNi = null;
    this.pNj = null;
    this.pNk = false;
    this.pNl = false;
    this.pNm = 0L;
    this.pNn = 0;
    this.pNo = null;
    this.pNp = null;
    this.pNq = -1L;
    this.pNr = -1;
    this.pNt = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103582);
        if (paramAnonymousInt == -21005)
        {
          ad.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(103582);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          ad.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousc = paramAnonymousd.field_fileId;
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("key_pic_cdn_id", paramAnonymousc);
          paramAnonymousString.putString("key_cdn_aes_key", paramAnonymousd.field_aesKey);
          paramAnonymousc = a.this;
          if (paramAnonymousc.pNi != null) {
            paramAnonymousc.pNi.n("ok", paramAnonymousString);
          }
          h.vKh.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.vKh.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          h.vKh.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90021, "cdn start error");
          AppMethodBeat.o(103582);
          return 0;
        }
        ad.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null)
        {
          double d = paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength;
          ad.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(d) });
          paramAnonymousString = a.this;
          if (paramAnonymousString.pNi != null) {
            paramAnonymousString.pNi.u(d);
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
    this.pNh = paramInt1;
    this.pNs = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  public final void cfp()
  {
    AppMethodBeat.i(103585);
    if (this.pNp != null) {
      com.tencent.mm.kernel.g.aeS().b(this.pNp.getType(), this);
    }
    AppMethodBeat.o(103585);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(103587);
    ad.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramn.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramn instanceof u)) || ((paramn instanceof v)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramn;
        this.pNm = paramString.cfq();
        e.pz(this.pNm);
        if (paramString.cfr() == null)
        {
          ad.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          s(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramString = paramString.cfr();
        paramInt1 = paramString.length;
        if (this.pNi == null) {
          bool = true;
        }
        ad.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        if (this.pNj != null) {
          this.pNj.e(this.pNm, paramString);
        }
        AppMethodBeat.o(103587);
        return;
      }
      if (this.pNj != null)
      {
        this.pNj.aM(paramInt1, "get face bio config failed");
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.pNp != null) && (paramn.getType() == this.pNp.getType()))
    {
      this.pNr = ((int)(System.currentTimeMillis() - this.pNq));
      if (this.pNi != null) {
        this.pNi.f(paramInt1, paramInt2, paramString, paramn);
      }
    }
    AppMethodBeat.o(103587);
  }
  
  public final void s(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103586);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103583);
        if (a.this.pNi != null) {
          a.this.pNi.a(a.this.pNn, paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(103583);
      }
    });
    AppMethodBeat.o(103586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */