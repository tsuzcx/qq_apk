package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.io.ByteArrayOutputStream;

public final class a
  implements f
{
  public int rnI;
  public d rnJ;
  public c rnK;
  public boolean rnL;
  public boolean rnM;
  public long rnN;
  public int rnO;
  public n rnP;
  public n rnQ;
  public long rnR;
  public int rnS;
  public int rnT;
  public g.a rnU;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103584);
    this.rnI = -1;
    this.rnJ = null;
    this.rnK = null;
    this.rnL = false;
    this.rnM = false;
    this.rnN = 0L;
    this.rnO = 0;
    this.rnP = null;
    this.rnQ = null;
    this.rnR = -1L;
    this.rnS = -1;
    this.rnU = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103582);
        if (paramAnonymousInt == -21005)
        {
          ae.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(103582);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          ae.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousc = paramAnonymousd.field_fileId;
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("key_pic_cdn_id", paramAnonymousc);
          paramAnonymousString.putString("key_cdn_aes_key", paramAnonymousd.field_aesKey);
          paramAnonymousc = a.this;
          if (paramAnonymousc.rnJ != null) {
            paramAnonymousc.rnJ.o("ok", paramAnonymousString);
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 13L, 1L, false);
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ae.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90020, "cdn ret error");
          AppMethodBeat.o(103582);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ae.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 14L, 1L, false);
          a.this.s(3, 90021, "cdn start error");
          AppMethodBeat.o(103582);
          return 0;
        }
        ae.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null)
        {
          double d = paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength;
          ae.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(d) });
          paramAnonymousString = a.this;
          if (paramAnonymousString.rnJ != null) {
            paramAnonymousString.rnJ.t(d);
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
    this.rnI = paramInt1;
    this.rnT = paramInt2;
    AppMethodBeat.o(103584);
  }
  
  public final void cuc()
  {
    AppMethodBeat.i(103585);
    if (this.rnQ != null) {
      com.tencent.mm.kernel.g.ajj().b(this.rnQ.getType(), this);
    }
    AppMethodBeat.o(103585);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(103587);
    ae.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramn.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramn instanceof u)) || ((paramn instanceof v)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramn;
        this.rnN = paramString.cud();
        e.vB(this.rnN);
        if (paramString.cue() == null)
        {
          ae.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          s(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(103587);
          return;
        }
        paramString = paramString.cue();
        paramInt1 = paramString.length;
        if (this.rnJ == null) {
          bool = true;
        }
        ae.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        if (this.rnK != null) {
          this.rnK.e(this.rnN, paramString);
        }
        AppMethodBeat.o(103587);
        return;
      }
      if (this.rnK != null)
      {
        this.rnK.aR(paramInt1, "get face bio config failed");
        AppMethodBeat.o(103587);
      }
    }
    else if ((this.rnQ != null) && (paramn.getType() == this.rnQ.getType()))
    {
      this.rnS = ((int)(System.currentTimeMillis() - this.rnR));
      if (this.rnJ != null) {
        this.rnJ.f(paramInt1, paramInt2, paramString, paramn);
      }
    }
    AppMethodBeat.o(103587);
  }
  
  public final void s(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103586);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103583);
        if (a.this.rnJ != null) {
          a.this.rnJ.a(a.this.rnO, paramInt1, paramInt2, paramString);
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