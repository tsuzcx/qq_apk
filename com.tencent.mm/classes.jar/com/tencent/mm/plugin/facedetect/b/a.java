package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.ByteArrayOutputStream;

public final class a
  implements f
{
  public int rfF;
  public d rfG;
  public c rfH;
  public boolean rfI;
  public boolean rfJ;
  public long rfK;
  public int rfL;
  public n rfM;
  public n rfN;
  public long rfO;
  public int rfP;
  public int rfQ;
  public g.a rfR;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.rfF = -1;
    this.rfG = null;
    this.rfH = null;
    this.rfI = false;
    this.rfJ = false;
    this.rfK = 0L;
    this.rfL = 0;
    this.rfM = null;
    this.rfN = null;
    this.rfO = -1L;
    this.rfP = -1;
    this.rfR = new g.a()
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
          if (paramAnonymousc.rfG != null) {
            paramAnonymousc.rfG.o("ok", paramAnonymousString);
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 14L, 1L, false);
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
          if (paramAnonymousString.rfG != null) {
            paramAnonymousString.rfG.t(d);
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
    this.rfF = paramInt1;
    this.rfQ = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  public final void csB()
  {
    AppMethodBeat.i(103585);
    if (this.rfN != null) {
      com.tencent.mm.kernel.g.aiU().b(this.rfN.getType(), this);
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
        this.rfK = paramString.csC();
        e.vl(this.rfK);
        if (paramString.csD() == null)
        {
          ad.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          s(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramString = paramString.csD();
        paramInt1 = paramString.length;
        if (this.rfG == null) {
          bool = true;
        }
        ad.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        if (this.rfH != null) {
          this.rfH.e(this.rfK, paramString);
        }
        AppMethodBeat.o(103587);
        return;
      }
      if (this.rfH != null)
      {
        this.rfH.aS(paramInt1, "get face bio config failed");
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.rfN != null) && (paramn.getType() == this.rfN.getType()))
    {
      this.rfP = ((int)(System.currentTimeMillis() - this.rfO));
      if (this.rfG != null) {
        this.rfG.f(paramInt1, paramInt2, paramString, paramn);
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
        if (a.this.rfG != null) {
          a.this.rfG.a(a.this.rfL, paramInt1, paramInt2, paramString);
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