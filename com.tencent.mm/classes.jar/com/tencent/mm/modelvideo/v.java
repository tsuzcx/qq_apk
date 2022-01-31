package com.tencent.mm.modelvideo;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.ah.e
{
  public static int a(int paramInt1, com.tencent.mm.j.d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    if (paramInt1 != 0)
    {
      y.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.SA(), paramString2, paramString1 });
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).QX();
      return paramInt1;
    }
    if (paramd == null) {
      return 0;
    }
    label200:
    int i;
    int j;
    if (paramd.field_retCode != 0)
    {
      y.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), params.SA(), paramString2, paramString1 });
      if (paramd != null) {
        break label833;
      }
      paramInt1 = -1;
      paramLong1 = bk.UY();
      i = com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext());
      j = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label841;
      }
      paramString1 = "";
      label225:
      if (paramd != null) {
        break label850;
      }
      paramString2 = "";
      label233:
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).QX();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label859;
        }
        paramInt1 = -1;
        label377:
        paramLong1 = bk.UY();
        i = com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext());
        j = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label867;
        }
        paramString1 = "";
        label402:
        if (paramd != null) {
          break label876;
        }
      }
    }
    label833:
    label841:
    label850:
    label859:
    label867:
    label876:
    for (paramd = "";; paramd = paramd.dlG)
    {
      new com.tencent.mm.h.b.a.d(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).QX();
      paramd = o.Sr();
      paramString1 = params.getFileName();
      params = t.a.c.eId;
      if (!bk.bl(paramString1))
      {
        paramString1 = paramd.nQ(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.eIb, params, paramString1.eHO, paramString1.eFV);
          paramd.ebu.bV(params);
          paramd.ebu.doNotify();
        }
      }
      return 0;
      File localFile = new File(paramString1);
      new File(paramString3).renameTo(localFile);
      y.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.SA(), paramString2, paramString1 });
      if (params.eHO == 3)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (com.tencent.mm.model.s.fn(params.SA())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.a(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.nFQ.a(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.h.nFQ;
      if (com.tencent.mm.model.s.fn(params.SA())) {}
      for (paramLong1 = 14L;; paramLong1 = 13L)
      {
        paramString1.a(198L, paramLong1, 1L, false);
        break;
      }
      paramInt1 = paramd.field_retCode;
      break label200;
      paramString1 = paramd.field_transInfo;
      break label225;
      paramString2 = paramd.dlG;
      break label233;
      paramInt1 = paramd.field_retCode;
      break label377;
      paramString1 = paramd.field_transInfo;
      break label402;
    }
  }
  
  public final void a(e.c paramc)
  {
    int i = 1;
    paramc = paramc.bWO;
    if (paramc == null) {}
    for (;;)
    {
      return;
      paramc = paramc.field_imgPath;
      if (!bk.bl(paramc))
      {
        t localt = o.Sr();
        if (localt.dXo.delete("videoinfo2", "filename= ?", new String[] { paramc }) > 0)
        {
          t.a.a locala = new t.a.a(paramc, t.a.b.eIa, t.a.c.eId, 1, -1L);
          localt.ebu.bV(locala);
          localt.ebu.doNotify();
        }
        while (i != 0)
        {
          try
          {
            o.Sr();
            new com.tencent.mm.vfs.b(t.nT(paramc)).delete();
            o.Sr();
            new com.tencent.mm.vfs.b(t.nS(paramc)).delete();
            return;
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.zI() + " file:" + paramc + " msg:" + localException.getMessage());
            return;
          }
          i = 0;
        }
      }
    }
  }
  
  public final e.b b(e.a arg1)
  {
    Object localObject5 = ???.dBs;
    if (localObject5 == null)
    {
      y.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      return null;
    }
    String str1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
    Object localObject1 = aa.a(((cd)localObject5).svG);
    Object localObject3 = aa.a(((cd)localObject5).svF);
    boolean bool;
    Object localObject6;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool = true;
      y.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO();
      if (!str1.equals(localObject3)) {
        break label360;
      }
    }
    label360:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject6).O((String)localObject4, ((cd)localObject5).ndp);
      y.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((cd)localObject5).ndp), Long.valueOf(((cs)localObject4).field_msgId), Integer.valueOf(((cs)localObject4).field_flag), Long.valueOf(((cs)localObject4).field_msgSeq), ??? });
      if ((((cs)localObject4).field_msgId != 0L) && (((cs)localObject4).field_createTime + 604800000L < com.tencent.mm.model.bd.o((String)localObject3, ((cd)localObject5).mPL)))
      {
        y.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((cd)localObject5).ndp), Long.valueOf(((cs)localObject4).field_msgId) });
        com.tencent.mm.model.bd.bC(((cs)localObject4).field_msgId);
        ((bi)localObject4).setMsgId(0L);
      }
      if (((cs)localObject4).field_msgId == 0L) {
        break label367;
      }
      y.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((cd)localObject5).ndp) });
      return null;
      bool = false;
      break;
    }
    label367:
    Object localObject7 = aa.a(((cd)localObject5).svH);
    localObject4 = new s();
    if (bool) {
      localObject3 = localObject1;
    }
    ((s)localObject4).bVI = ((String)localObject3);
    ((s)localObject4).createTime = ((cd)localObject5).mPL;
    ((s)localObject4).bXr = ((cd)localObject5).ndp;
    ((s)localObject4).eHN = ((cd)localObject5).svH.tFO;
    y.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject7, ((cd)localObject5).svK });
    Object localObject8 = bn.s((String)localObject7, "msg");
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 216L, 1L, false);
      return null;
    }
    localObject3 = new bi();
    ((bi)localObject3).cY(((cd)localObject5).svK);
    ((bi)localObject3).ei(com.tencent.mm.model.bd.iN(((cd)localObject5).svK));
    for (;;)
    {
      int j;
      String str4;
      String str2;
      String str3;
      int k;
      try
      {
        ((s)localObject4).ebK = bk.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).eHH = bk.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        y.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).ebK), Integer.valueOf(((s)localObject4).eHH) });
        ((s)localObject4).eHA = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).SB())) {
          ((s)localObject4).eHA = ((String)localObject1);
        }
        ((s)localObject4).bYN = ((String)((Map)localObject8).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumburl");
        j = bk.getInt((String)((Map)localObject8).get(".msg.videomsg.$cdnthumblength"), 0);
        str4 = (String)((Map)localObject8).get(".msg.videomsg.$tpvideourl");
        localObject6 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumburl");
        str2 = (String)((Map)localObject8).get(".msg.videomsg.$tpauthkey");
        str3 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumbaeskey");
        k = bk.getInt((String)((Map)localObject8).get(".msg.videomsg.$tpthumblength"), 0);
        int m = bk.getInt((String)((Map)localObject8).get(".msg.videomsg.$type"), 0);
        y.d("MicroMsg.VideoMsgExtension", "video msg exportType :" + m);
        if (m != 44) {
          break label3082;
        }
        i = 1;
        ((s)localObject4).eHL = i;
        if (62 == ((cd)localObject5).kSW)
        {
          ((s)localObject4).eHO = 3;
          String str5 = bk.aM((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), "");
          i = bk.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0);
          String str6 = bk.aM((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), "");
          String str7 = bk.aM((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), "");
          String str8 = bk.aM((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), "");
          String str9 = bk.aM((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), "");
          String str10 = bk.aM((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), "");
          if (((s)localObject4).eHQ == null) {
            ((s)localObject4).eHQ = new bwa();
          }
          ((s)localObject4).eHQ.dSR = str6;
          ((s)localObject4).eHQ.sWK = i;
          ((s)localObject4).eHQ.dSP = str5;
          ((s)localObject4).eHQ.dSS = str7;
          ((s)localObject4).eHQ.dST = str8;
          ((s)localObject4).eHQ.dSV = str9;
          ((s)localObject4).eHQ.dSW = str10;
          if (!((s)localObject4).SB().equals((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""))) {
            break label1180;
          }
          return null;
        }
        if (m > 0)
        {
          ((s)localObject4).eHO = 2;
          continue;
        }
        ((s)localObject4).eHO = 1;
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 216L, 1L, false);
        y.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        y.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bk.j(???) });
        return null;
      }
      continue;
      label1180:
      localObject8 = (String)((Map)localObject8).get(".msg.commenturl");
      localObject7 = bn.s((String)localObject7, "msgoperation");
      if (localObject7 != null)
      {
        ((bi)localObject3).ej((String)((Map)localObject7).get(".msgoperation.expinfo.expidstr"));
        ((bi)localObject3).fN(bk.getInt((String)((Map)localObject7).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
        y.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((cs)localObject3).cQO, Integer.valueOf(((cs)localObject3).cQP) });
      }
      localObject7 = t.nR(((s)localObject4).SB());
      ((s)localObject4).fileName = ((String)localObject7);
      ((bi)localObject3).bf(((s)localObject4).bXr);
      ((bi)localObject3).ed(((s)localObject4).getFileName());
      ((bi)localObject3).bg(com.tencent.mm.model.bd.o(((s)localObject4).SA(), ((s)localObject4).createTime));
      ((bi)localObject3).ec(((s)localObject4).SA());
      ((bi)localObject3).setStatus(((cd)localObject5).hQq);
      if (bool)
      {
        i = 1;
        ((bi)localObject3).fA(i);
        if (((cd)localObject5).kSW != 62) {
          break label1490;
        }
        ((bi)localObject3).setType(62);
      }
      long l1;
      for (;;)
      {
        ((bi)localObject3).setContent(q.d(((s)localObject4).SB(), 0L, false));
        ((bi)localObject3).eh((String)localObject8);
        ((bi)localObject3).cY(((cd)localObject5).svK);
        com.tencent.mm.model.bd.a((bi)localObject3, ???);
        l1 = com.tencent.mm.model.bd.h((bi)localObject3);
        if (l1 > 0L) {
          break label1500;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 215L, 1L, false);
        y.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).bXr) });
        return null;
        i = 0;
        break;
        label1490:
        ((bi)localObject3).setType(43);
      }
      label1500:
      ((s)localObject4).eHI = ((int)l1);
      ((s)localObject4).eHF = bk.UX();
      ((s)localObject4).eHJ = 0;
      ((s)localObject4).status = 111;
      y.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).ebK + " svrid:" + ((s)localObject4).bXr + " timelen:" + ((s)localObject4).eHH + " user:" + ((s)localObject4).SA() + " human:" + ((s)localObject4).SB());
      if (!o.Sr().b((s)localObject4))
      {
        y.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
        return null;
      }
      o.Sr();
      localObject7 = t.nT((String)localObject7);
      ??? = aa.a(((cd)localObject5).svJ);
      y.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bk.bF(???)) });
      if (com.tencent.mm.platformtools.ae.eSV)
      {
        y.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
        ??? = null;
      }
      if (!bk.bE(???)) {
        t.a((String)localObject7, 0, ???);
      }
      for (;;)
      {
        if (((bi)localObject3).aRR())
        {
          com.tencent.mm.modelcontrol.c.Ni();
          if (((cs)localObject3).cQP != 1) {
            break label2367;
          }
          i = 1;
          label1760:
          if (i != 0)
          {
            u.oa(((cs)localObject3).field_imgPath);
            com.tencent.mm.ak.f.Nd().eiM.add("video_" + ((cs)localObject3).field_msgId);
          }
        }
        i = 1;
        j = 0;
        if (com.tencent.mm.model.s.fn(((s)localObject4).SA()))
        {
          j = m.gM(((s)localObject4).SA());
          if ((com.tencent.mm.model.s.hZ(((s)localObject4).SA())) || (!com.tencent.mm.model.s.hY(((s)localObject4).SA()))) {
            i = 2;
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14388, new Object[] { Long.valueOf(((cs)localObject3).field_msgSvrId), Integer.valueOf(i), "", Integer.valueOf(j) });
          localObject1 = o.St();
        }
        synchronized (((i)localObject1).eGw)
        {
          ((i)localObject1).eGw.offerFirst(localObject3);
          ((i)localObject1).Sk();
          return new e.b((bi)localObject3, true);
          long l2;
          if (!bk.bl(str4))
          {
            l1 = ((s)localObject4).bXr;
            y.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).SA(), localObject6, localObject7 });
            l2 = bk.UY();
            ??? = (String)localObject7 + ".tmp";
            localObject1 = new com.tencent.mm.j.f();
            ((com.tencent.mm.j.f)localObject1).field_mediaId = com.tencent.mm.ak.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).SA(), String.valueOf(l1));
            ((com.tencent.mm.j.f)localObject1).field_fullpath = ???;
            ((com.tencent.mm.j.f)localObject1).field_fileType = 19;
            ((com.tencent.mm.j.f)localObject1).field_aesKey = str3;
            ((com.tencent.mm.j.f)localObject1).field_authKey = str2;
            ((com.tencent.mm.j.f)localObject1).dlQ = ((String)localObject6);
            ((com.tencent.mm.j.f)localObject1).dlP = new v.1(this, l1, (s)localObject4, (String)localObject7, (String)localObject6, k, ???, l2);
            com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject1, -1);
          }
          else
          {
            l1 = ((s)localObject4).bXr;
            y.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).SA(), str1, localObject7 });
            l2 = bk.UY();
            ??? = (String)localObject7 + ".tmp";
            localObject5 = new com.tencent.mm.j.f();
            ((com.tencent.mm.j.f)localObject5).field_mediaId = com.tencent.mm.ak.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).SA(), String.valueOf(l1));
            ((com.tencent.mm.j.f)localObject5).field_fullpath = ???;
            ((com.tencent.mm.j.f)localObject5).field_fileType = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
            ((com.tencent.mm.j.f)localObject5).field_totalLen = j;
            ((com.tencent.mm.j.f)localObject5).field_aesKey = ((String)localObject1);
            ((com.tencent.mm.j.f)localObject5).field_fileId = str1;
            ((com.tencent.mm.j.f)localObject5).field_priority = com.tencent.mm.j.a.dll;
            if (com.tencent.mm.model.s.fn(((s)localObject4).SA())) {}
            for (i = 1;; i = 0)
            {
              ((com.tencent.mm.j.f)localObject5).field_chattype = i;
              y.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.j.f)localObject5).field_chattype), ((s)localObject4).SA() });
              ((com.tencent.mm.j.f)localObject5).dlP = new v.2(this, l1, (s)localObject4, (String)localObject7, str1, j, ???, l2);
              com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject5, -1);
              break;
            }
            label2367:
            if (((cs)localObject3).cQP == 2)
            {
              i = 0;
              break label1760;
            }
            if (!com.tencent.mm.modelcontrol.c.p((bi)localObject3))
            {
              y.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
              i = 0;
              break label1760;
            }
            ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("C2CSightNotAutoDownloadTimeRange");
            y.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: " + ???);
            if (com.tencent.mm.modelcontrol.b.lO(???))
            {
              y.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
              i = 0;
              break label1760;
            }
            ??? = ((cs)localObject3).field_talker;
            y.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: " + ???);
            i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("SIGHTSessionAutoLoadNetwork"), 1);
            if (i == 3)
            {
              y.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId) });
              i = 0;
              break label1760;
            }
            if (aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext()))
            {
              y.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId), ((cs)localObject3).field_imgPath });
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(???);
              if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).dBe > 0) && (((com.tencent.mm.model.s.fn(???)) && (((ao)localObject1).cCy == 0)) || (((ad)localObject1).Bj()))) {
                break label3056;
              }
              i = 1;
              break label1760;
            }
            if (aq.is2G(com.tencent.mm.sdk.platformtools.ae.getContext()))
            {
              y.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId), ((cs)localObject3).field_imgPath });
              i = 0;
              break label1760;
            }
            ??? = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((cs)localObject3).field_talker);
            if (com.tencent.mm.model.s.fn(((cs)localObject3).field_talker))
            {
              if (???.cCy == 0)
              {
                y.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId), ((cs)localObject3).field_imgPath });
                i = 0;
                break label1760;
              }
              if (((aq.is3G(com.tencent.mm.sdk.platformtools.ae.getContext())) || (aq.is4G(com.tencent.mm.sdk.platformtools.ae.getContext()))) && (i == 1))
              {
                y.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId), ((cs)localObject3).field_imgPath });
                i = 1;
                break label1760;
              }
              y.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
              i = 0;
              break label1760;
            }
            if (???.Bj())
            {
              y.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId), ((cs)localObject3).field_imgPath });
              i = 0;
              break label1760;
            }
            if (((aq.is3G(com.tencent.mm.sdk.platformtools.ae.getContext())) || (aq.is4G(com.tencent.mm.sdk.platformtools.ae.getContext()))) && (i == 1))
            {
              y.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((cs)localObject3).field_msgId), Long.valueOf(((cs)localObject3).field_msgSvrId), ((cs)localObject3).field_imgPath });
              i = 1;
              break label1760;
            }
            y.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
            i = 0;
            break label1760;
            label3056:
            y.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
            i = 0;
            break label1760;
            i = 3;
          }
        }
      }
      label3082:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */