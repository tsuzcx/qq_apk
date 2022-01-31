package com.tencent.mm.modelvideo;

import com.tencent.mm.ak.b;
import com.tencent.mm.h.b.a.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.b;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class f
{
  long bIt;
  public String bJQ;
  private String bUi;
  private f.b dmc = new f.2(this);
  String dme;
  private com.tencent.mm.j.g eFN;
  boolean eFY = false;
  String eFZ;
  private long eGa;
  long eGb;
  long eGc;
  int eGd;
  private String eGe;
  public f.a eGf;
  private com.tencent.mm.j.f.a epa = new f.1(this);
  
  public f(long paramLong)
  {
    this.bIt = paramLong;
    this.eFY = true;
  }
  
  public f(com.tencent.mm.j.g paramg, String paramString)
  {
    this.eFN = paramg;
    this.bJQ = paramString;
    this.eFY = false;
  }
  
  static int e(String paramString, int paramInt, boolean paramBoolean)
  {
    s locals = u.oe(paramString);
    if (locals != null)
    {
      int i = locals.bRT;
      if (paramBoolean)
      {
        locals.bRT = paramInt;
        y.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(locals.bRT), Boolean.valueOf(paramBoolean) });
        locals.eHF = bk.UX();
        locals.bcw = 1025;
        u.f(locals);
        if (!paramBoolean) {
          break label121;
        }
        paramInt -= i;
      }
      label121:
      for (;;)
      {
        if (paramInt >= 0) {
          return paramInt;
        }
        return 0;
        locals.bRT = (i + paramInt);
        break;
      }
    }
    return paramInt;
    return paramInt;
  }
  
  public final int a(f.a parama)
  {
    this.eGf = parama;
    Object localObject;
    int i;
    label180:
    String str1;
    int j;
    for (;;)
    {
      try
      {
        y.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.bIt) });
        if (!this.eFY) {
          break label640;
        }
        parama = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.bIt);
        localObject = bd.iM(parama.czr);
        if ((localObject == null) || (((bd.b)localObject).dWM <= 0))
        {
          y.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
          parama = null;
          if (parama != null)
          {
            if (!com.tencent.mm.model.s.fn(parama.dmh)) {
              break label976;
            }
            i = 2;
            this.eGd = i;
            h.nFQ.a(354L, 140L, 1L, false);
            if (this.eGd == 1) {
              h.nFQ.a(354L, 121L, 1L, false);
            }
          }
          else
          {
            if (this.eFN != null) {
              break label957;
            }
            this.eFN = parama;
            if (parama != null) {
              break;
            }
            y.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
            i = 0;
            break label960;
          }
        }
        else
        {
          str1 = parama.field_imgPath;
          s locals = u.oe(str1);
          if (locals == null)
          {
            parama = null;
            continue;
          }
          parama = bn.s(locals.SD(), "msg");
          if (parama == null)
          {
            y.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
            parama = null;
            continue;
          }
          String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
          if (bk.bl(str2))
          {
            y.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
            parama = null;
            continue;
          }
          j = Integer.valueOf((String)parama.get(".msg.videomsg.$length")).intValue();
          String str3 = (String)parama.get(".msg.videomsg.$md5");
          String str4 = (String)parama.get(".msg.videomsg.$newmd5");
          String str5 = (String)parama.get(".msg.videomsg.$aeskey");
          String str6 = (String)parama.get(".msg.videomsg.$fileparam");
          String str7 = com.tencent.mm.ak.c.a("downvideo", locals.createTime, locals.SA(), locals.getFileName());
          if (bk.bl(str7))
          {
            y.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
            parama = null;
            continue;
          }
          o.Sr();
          String str8 = t.nS(str1);
          parama = new com.tencent.mm.j.g();
          parama.filename = str1;
          parama.dme = str3;
          parama.dmf = j;
          parama.dmg = 2;
          parama.bRO = locals.SB();
          parama.dmh = locals.SA();
          if (!com.tencent.mm.model.s.fn(locals.SA())) {
            break label966;
          }
          i = m.gM(locals.SA());
          label497:
          parama.bRQ = i;
          parama.field_mediaId = str7;
          parama.field_fullpath = str8;
          parama.field_fileType = com.tencent.mm.j.a.MediaType_VIDEO;
          parama.field_totalLen = j;
          parama.field_aesKey = str5;
          parama.field_fileId = str2;
          parama.field_priority = com.tencent.mm.j.a.dlk;
          parama.field_wxmsgparam = str6;
          if (!com.tencent.mm.model.s.fn(locals.SA())) {
            break label971;
          }
          i = 1;
          label564:
          parama.field_chattype = i;
          parama.field_autostart = false;
          parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, locals);
          parama.field_preloadRatio = ((bd.b)localObject).dWM;
          parama.bvB = str4;
          continue;
        }
        h.nFQ.a(354L, 122L, 1L, false);
        continue;
        this.eGf = null;
      }
      catch (Exception parama)
      {
        y.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
      }
      label633:
      return -1;
      label640:
      this.eGd = 3;
      parama = this.eFN;
      h.nFQ.a(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utw, Integer.valueOf(-1))).intValue() == 2) {
      y.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        y.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label960;
        if (parama.xa()) {
          break label981;
        }
        localObject = parama.dme;
        i = parama.dmf;
        str1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD().dx((String)localObject, i);
        j = i - (int)com.tencent.mm.vfs.e.aeQ(str1);
        if ((bk.bl(str1)) || (j < 0) || (j > 16)) {
          break label981;
        }
        y.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        com.tencent.mm.vfs.e.r(str1, parama.field_fullpath);
        f(parama.filename, i, (String)localObject);
        i = 1;
      }
      else
      {
        parama.dmc = this.dmc;
        parama.dlP = this.epa;
        parama.dma = 2;
        this.dme = parama.dme;
        this.bUi = parama.field_mediaId;
        this.eFZ = parama.filename;
        this.eGa = bk.UX();
        this.eGe = parama.bvB;
        y.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
        com.tencent.mm.ak.f.Nd().b(parama, -1);
        i = 1;
        break label960;
        label957:
        break label180;
      }
      label960:
      if (i == 0) {
        break label633;
      }
      return 0;
      label966:
      i = 0;
      break label497;
      label971:
      i = 0;
      break label564;
      label976:
      i = 1;
      break;
      label981:
      i = 0;
    }
  }
  
  final void f(String paramString1, int paramInt, String paramString2)
  {
    y.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.oe(paramString1) != null)
    {
      u.W(paramString1, paramInt);
      if (!bk.bl(paramString2))
      {
        o.Sr();
        paramString1 = t.nS(paramString1);
        if ((!bk.bl(paramString2)) && (paramInt > 0) && (!bk.bl(paramString1)) && (com.tencent.mm.vfs.e.bK(paramString1))) {
          break label119;
        }
        y.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString2, paramString1 });
      }
    }
    return;
    label119:
    ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD().A(paramString2, paramInt, paramString1);
  }
  
  public final String getTips()
  {
    if (this.eFY) {
      return this.bIt;
    }
    return this.bJQ;
  }
  
  final void nG(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.eGa).append(",");
    localStringBuffer.append(this.eGb).append(",");
    localStringBuffer.append(this.eGc).append(",");
    localStringBuffer.append(this.eGe).append(",");
    localStringBuffer.append(this.eGd).append(",");
    try
    {
      long l = this.eGc / 1024L / (this.eGb - this.eGa);
      i = (int)l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    localStringBuffer.append(i).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramString).append(",");
    localStringBuffer.append(this.eFN.bRO).append(",");
    localStringBuffer.append(this.eFN.dmh).append(",");
    localStringBuffer.append(this.eFN.bRQ).append(",");
    localStringBuffer.append(this.eFN.field_fileId).append(",");
    localStringBuffer.append(this.eFN.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.PU(this.eFN.bRV));
    paramString = localStringBuffer.toString();
    y.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new p(paramString).QX();
  }
  
  public final void stop()
  {
    y.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.bUi });
    if (!bk.bl(this.bUi))
    {
      com.tencent.mm.j.d locald = new com.tencent.mm.j.d();
      b localb = com.tencent.mm.ak.f.Nd();
      String str = this.bUi;
      int i = 0;
      com.tencent.mm.j.f localf = (com.tencent.mm.j.f)localb.eiI.remove(str);
      if (localf != null)
      {
        com.tencent.mm.ak.f.Ne();
        i = com.tencent.mm.ak.a.b(str, locald);
        h.nFQ.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.ak.c.ejc), Integer.valueOf(localf.field_fileType), Long.valueOf(bk.UY() - localf.field_startTime) });
      }
      localb.eiH.remove(str);
      localb.eiJ.remove(str);
      y.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localf, Integer.valueOf(i) });
      this.eGb = bk.UX();
      this.eGc = e(this.eFZ, locald.field_recvedBytes, false);
      nG(locald.wW());
    }
    this.eGf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f
 * JD-Core Version:    0.7.0.1
 */