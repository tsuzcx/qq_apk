package com.tencent.mm.as;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class k$2
  implements f.a
{
  k$2(k paramk) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if (paramInt == -21006)
    {
      y.i(this.epe.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.epe.eoQ });
      return 0;
    }
    long l1;
    long l2;
    int i;
    int j;
    int k;
    if (paramInt != 0)
    {
      i.iL((int)this.epe.eoN);
      i.iK((int)this.epe.eoN);
      l1 = this.epe.startTime;
      l2 = bk.UY();
      i = com.tencent.mm.ak.c.bx(ae.getContext());
      j = this.epe.eoR;
      k = this.epe.ebK;
      if (paramd == null)
      {
        paramString = "";
        if (paramd != null) {
          break label289;
        }
      }
      label289:
      for (paramc = "";; paramc = paramd.dlG)
      {
        paramString = a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc });
        new com.tencent.mm.h.b.a.f(paramString).QX();
        new com.tencent.mm.h.b.a.d(paramString).QX();
        this.epe.dmL.onSceneEnd(3, paramInt, "", this.epe);
        return 0;
        paramString = paramd.field_transInfo;
        break;
      }
    }
    e locale = o.OJ().b(Long.valueOf(this.epe.dFT));
    if (paramc != null)
    {
      if (paramc.field_finishedLength == this.epe.ebK)
      {
        y.d(this.epe.TAG, "cdntra ignore progress 100%");
        return 0;
      }
      this.epe.eoZ = true;
      if (!this.epe.eoV) {
        this.epe.eoV = paramc.field_mtlnotify;
      }
      y.i(this.epe.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { this.epe.eoQ, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength), Boolean.valueOf(this.epe.eoV) });
      k.a(this.epe, locale, this.epe.ebK, locale.offset, paramc.field_finishedLength - locale.offset);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label932;
      }
      i.iK((int)this.epe.eoN);
      y.e(this.epe.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramd.field_retCode) });
      this.epe.dmL.onSceneEnd(3, paramd.field_retCode, "", this.epe);
      paramInt = paramd.field_retCode;
      l1 = this.epe.startTime;
      l2 = bk.UY();
      i = com.tencent.mm.ak.c.bx(ae.getContext());
      j = this.epe.eoR;
      k = this.epe.ebK;
      if (paramd != null) {
        break label1305;
      }
      paramString = "";
      label600:
      if (paramd != null) {
        break label1314;
      }
      paramc = "";
      label608:
      new com.tencent.mm.h.b.a.f(a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc })).QX();
      if (paramd.field_retCode != 0)
      {
        paramInt = paramd.field_retCode;
        l1 = this.epe.startTime;
        l2 = bk.UY();
        i = com.tencent.mm.ak.c.bx(ae.getContext());
        j = this.epe.eoR;
        k = this.epe.ebK;
        if (paramd != null) {
          break label1323;
        }
        paramString = "";
        label796:
        if (paramd != null) {
          break label1332;
        }
      }
    }
    label932:
    label1323:
    label1332:
    for (paramc = "";; paramc = paramd.dlG)
    {
      new com.tencent.mm.h.b.a.d(a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc })).QX();
      return 0;
      y.i(this.epe.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramd.field_convert2baseline) });
      if (locale.ent == 1)
      {
        h.nFQ.a(198L, 26L, locale.ebK, false);
        h.nFQ.a(198L, 27L, 1L, false);
        paramc = h.nFQ;
        if (this.epe.bFH != null)
        {
          paramString = this.epe.bFH.field_talker;
          if (!s.fn(paramString)) {
            break label1161;
          }
        }
        for (l1 = 29L;; l1 = 28L)
        {
          paramc.a(198L, l1, 1L, false);
          if (paramd.field_convert2baseline)
          {
            y.i(this.epe.TAG, "cdntra need convert2baseline. file:%s", new Object[] { this.epe.eoT });
            paramBoolean = MMNativeJpeg.Convert2Baseline(this.epe.eoT, 60);
            y.i(this.epe.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          }
          if (!this.epe.eoZ) {
            break label1267;
          }
          k.a(this.epe, locale, locale.offset, locale.offset, 0);
          break;
          paramString = "";
          break label1026;
        }
      }
      h.nFQ.a(198L, 21L, locale.ebK, false);
      h.nFQ.a(198L, 22L, 1L, false);
      paramc = h.nFQ;
      if (this.epe.bFH != null)
      {
        paramString = this.epe.bFH.field_talker;
        label1227:
        if (!s.fn(paramString)) {
          break label1259;
        }
      }
      label1259:
      for (l1 = 24L;; l1 = 23L)
      {
        paramc.a(198L, l1, 1L, false);
        break;
        paramString = "";
        break label1227;
      }
      label1267:
      k.a(this.epe, locale, this.epe.ebK, locale.offset, this.epe.ebK - locale.offset);
      break;
      paramString = paramd.field_transInfo;
      break label600;
      paramc = paramd.dlG;
      break label608;
      paramString = paramd.field_transInfo;
      break label796;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.as.k.2
 * JD-Core Version:    0.7.0.1
 */