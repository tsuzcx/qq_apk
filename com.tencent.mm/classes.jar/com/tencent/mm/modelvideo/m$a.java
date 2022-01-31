package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class m$a
  implements com.tencent.mm.ai.f, g.a
{
  long fVM;
  s fVN;
  String fWF;
  List<s> foQ;
  long startTime;
  
  private m$a(m paramm) {}
  
  public final int a(String arg1, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(50742);
    ab.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.fWF, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      ab.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.fWF });
      AppMethodBeat.o(50742);
      return 0;
    }
    if (paramInt != 0)
    {
      m.ah(this.foQ);
      ab.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.fVM), Integer.valueOf(paramInt) });
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).ake();
      this.fWE.d(this.fVM, 3, paramInt);
      AppMethodBeat.o(50742);
      return 0;
    }
    if (paramc != null)
    {
      ab.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Integer.valueOf(paramc.field_finishedLength) });
      ??? = this.foQ.iterator();
      while (???.hasNext())
      {
        paramd = (s)???.next();
        paramd.fXv = bo.aox();
        paramd.fWa = paramc.field_finishedLength;
        paramd.bsY = 1032;
        u.f(paramd);
      }
      AppMethodBeat.o(50742);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        ab.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.fVM) });
        m.ah(this.foQ);
        ??? = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
        new com.tencent.mm.g.b.a.f(???).ake();
        new com.tencent.mm.g.b.a.d(???).ake();
        this.fWE.d(this.fVM, 3, paramd.field_retCode);
      }
    }
    else
    {
      AppMethodBeat.o(50742);
      return 0;
    }
    ab.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.fVM) });
    ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
    ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
    ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
    ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
    ab.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
    paramc = this.foQ.iterator();
    while (paramc.hasNext())
    {
      s locals = (s)paramc.next();
      if (bo.isNullOrNil(locals.alP()))
      {
        locals.fXD = ???;
        locals.bsY = 2097152;
        paramBoolean = u.f(locals);
        ab.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.fVM), locals.getFileName(), Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      synchronized (m.a(this.fWE))
      {
        paramc = (String)m.b(this.fWE).get(Long.valueOf(this.fVM));
        if (bo.isNullOrNil(paramc)) {
          ab.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.fVM), paramc, this.fWF });
        }
      }
      ab.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.fVM), paramc, this.fWF });
      m.b(this.fWE).put(Long.valueOf(this.fVM), "done_upload_cdn_client_id");
      g.Rc().a(245, this);
      paramc = new e(this.fVM, this.fVN, paramd, this.fWF);
      if (!g.Rc().a(paramc, 0))
      {
        ab.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
        g.Rc().b(245, this);
        this.fWE.d(this.fVM, 3, 0);
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(50743);
    g.Rc().b(245, this);
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      ab.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.fVM);
      m.ai(this.foQ);
      this.fWE.d(this.fVM, paramInt1, paramInt2);
      AppMethodBeat.o(50743);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      ab.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.fVM);
      m.ah(this.foQ);
      this.fWE.d(this.fVM, paramInt1, paramInt2);
      AppMethodBeat.o(50743);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.fVM);
      m.ah(this.foQ);
      this.fWE.d(this.fVM, paramInt1, paramInt2);
      AppMethodBeat.o(50743);
      return;
    }
    paramString = this.foQ.iterator();
    if (paramString.hasNext())
    {
      paramm = (s)paramString.next();
      paramm.fXv = bo.aox();
      paramm.status = 199;
      paramm.bsY = 1280;
      if (u.f(paramm))
      {
        if (paramm != null) {
          break label378;
        }
        ab.e("MicroMsg.VideoLogic", "video info is null");
      }
      for (;;)
      {
        ab.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.fVM), paramm.getFileName(), Integer.valueOf(199) });
        break;
        label378:
        bi localbi;
        if (paramm.fXy > 0)
        {
          localbi = ((j)g.E(j.class)).bPQ().kB(paramm.fXy);
          paramInt1 = localbi.getType();
          ab.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((43 == paramInt1) || (62 == paramInt1))
          {
            localbi.hL(1);
            localbi.kj(paramm.getUser());
            localbi.fP(paramm.cFn);
            localbi.setStatus(2);
            localbi.setContent(q.d(paramm.alM(), paramm.fXx, false));
            ((j)g.E(j.class)).bPQ().a(paramm.fXy, localbi);
            ab.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
          }
        }
        else
        {
          localbi = new bi();
          localbi.kj(paramm.getUser());
          localbi.setType(62);
          localbi.hL(1);
          localbi.kk(paramm.getFileName());
          localbi.setStatus(2);
          localbi.fQ(bf.py(paramm.getUser()));
          paramm.fXy = ((int)bf.l(localbi));
          paramm.bsY = 8192;
          u.f(paramm);
          ab.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
        }
      }
    }
    paramString = this.fWE;
    long l = this.fVM;
    g.RO().ac(new m.1(paramString, l));
    AppMethodBeat.o(50743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.a
 * JD-Core Version:    0.7.0.1
 */