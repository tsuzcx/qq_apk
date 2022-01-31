package com.tencent.mm.modelvideo;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class m$a
  implements com.tencent.mm.ah.f, f.a
{
  List<s> dYN;
  long eFV;
  s eFW;
  String eGP;
  long startTime;
  
  private m$a(m paramm) {}
  
  public final int a(String arg1, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.eGP, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      y.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.eGP });
      return 0;
    }
    if (paramInt != 0)
    {
      m.aa(this.dYN);
      y.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.eFV), Integer.valueOf(paramInt) });
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).QX();
      this.eGO.d(this.eFV, 3, paramInt);
      return 0;
    }
    if (paramc != null)
    {
      y.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Integer.valueOf(paramc.field_finishedLength) });
      ??? = this.dYN.iterator();
      while (???.hasNext())
      {
        paramd = (s)???.next();
        paramd.eHF = bk.UX();
        paramd.eGk = paramc.field_finishedLength;
        paramd.bcw = 1032;
        u.f(paramd);
      }
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        y.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.eFV) });
        m.aa(this.dYN);
        ??? = com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_TinyVideo), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG });
        new com.tencent.mm.h.b.a.f(???).QX();
        new com.tencent.mm.h.b.a.d(???).QX();
        this.eGO.d(this.eFV, 3, paramd.field_retCode);
      }
    }
    else {
      return 0;
    }
    y.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.eFV) });
    ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
    ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
    ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
    ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
    y.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
    paramc = this.dYN.iterator();
    while (paramc.hasNext())
    {
      s locals = (s)paramc.next();
      if (bk.bl(locals.SD()))
      {
        locals.eHN = ???;
        locals.bcw = 2097152;
        paramBoolean = u.f(locals);
        y.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.eFV), locals.getFileName(), Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      synchronized (m.a(this.eGO))
      {
        paramc = (String)m.b(this.eGO).get(Long.valueOf(this.eFV));
        if (bk.bl(paramc)) {
          y.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.eFV), paramc, this.eGP });
        }
      }
      y.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.eFV), paramc, this.eGP });
      m.b(this.eGO).put(Long.valueOf(this.eFV), "done_upload_cdn_client_id");
      com.tencent.mm.kernel.g.Dk().a(245, this);
      paramc = new e(this.eFV, this.eFW, paramd, this.eGP);
      if (!com.tencent.mm.kernel.g.Dk().a(paramc, 0))
      {
        y.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
        com.tencent.mm.kernel.g.Dk().b(245, this);
        this.eGO.d(this.eFV, 3, 0);
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.kernel.g.Dk().b(245, this);
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      y.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.eFV);
      m.ab(this.dYN);
      this.eGO.d(this.eFV, paramInt1, paramInt2);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      y.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.eFV);
      m.aa(this.dYN);
      this.eGO.d(this.eFV, paramInt1, paramInt2);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.eFV);
      m.aa(this.dYN);
      this.eGO.d(this.eFV, paramInt1, paramInt2);
      return;
    }
    paramString = this.dYN.iterator();
    if (paramString.hasNext())
    {
      paramm = (s)paramString.next();
      paramm.eHF = bk.UX();
      paramm.status = 199;
      paramm.bcw = 1280;
      if (u.f(paramm))
      {
        if (paramm != null) {
          break label354;
        }
        y.e("MicroMsg.VideoLogic", "video info is null");
      }
      for (;;)
      {
        y.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.eFV), paramm.getFileName(), Integer.valueOf(199) });
        break;
        label354:
        bi localbi;
        if (paramm.eHI > 0)
        {
          localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramm.eHI);
          paramInt1 = localbi.getType();
          y.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((43 == paramInt1) || (62 == paramInt1))
          {
            localbi.fA(1);
            localbi.ec(paramm.SA());
            localbi.bf(paramm.bXr);
            localbi.setStatus(2);
            localbi.setContent(q.d(paramm.SB(), paramm.eHH, false));
            ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramm.eHI, localbi);
            y.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
          }
        }
        else
        {
          localbi = new bi();
          localbi.ec(paramm.SA());
          localbi.setType(62);
          localbi.fA(1);
          localbi.ed(paramm.getFileName());
          localbi.setStatus(2);
          localbi.bg(bd.iK(paramm.SA()));
          paramm.eHI = ((int)bd.h(localbi));
          paramm.bcw = 8192;
          u.f(paramm);
          y.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
        }
      }
    }
    paramString = this.eGO;
    long l = this.eFV;
    com.tencent.mm.kernel.g.DS().O(new m.1(paramString, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.a
 * JD-Core Version:    0.7.0.1
 */