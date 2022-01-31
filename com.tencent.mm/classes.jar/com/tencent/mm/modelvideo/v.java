package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.ai.e
{
  public static int a(int paramInt1, com.tencent.mm.i.d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(50863);
    if (paramInt1 != 0)
    {
      ab.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).ake();
      AppMethodBeat.o(50863);
      return paramInt1;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(50863);
      return 0;
    }
    label215:
    int i;
    int j;
    if (paramd.field_retCode != 0)
    {
      ab.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (paramd != null) {
        break label853;
      }
      paramInt1 = -1;
      paramLong1 = bo.aoy();
      i = com.tencent.mm.al.c.cb(ah.getContext());
      j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label861;
      }
      paramString1 = "";
      label240:
      if (paramd != null) {
        break label870;
      }
      paramString2 = "";
      label248:
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).ake();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = bo.aoy();
        i = com.tencent.mm.al.c.cb(ah.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label887;
        }
        paramString1 = "";
        label417:
        if (paramd != null) {
          break label896;
        }
      }
    }
    label896:
    for (paramd = "";; paramd = paramd.edb)
    {
      new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).ake();
      paramd = o.alE();
      paramString1 = params.getFileName();
      params = t.a.c.fXT;
      if (!bo.isNullOrNil(paramString1))
      {
        paramString1 = paramd.vd(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.fXR, params, paramString1.fXE, paramString1.fVM);
          paramd.frK.cy(params);
          paramd.frK.doNotify();
        }
      }
      AppMethodBeat.o(50863);
      return 0;
      File localFile = new File(paramString1);
      new File(paramString3).renameTo(localFile);
      ab.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (params.fXE == 3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.h.qsU;
        if (com.tencent.mm.model.t.lA(params.getUser())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.h.qsU;
      if (com.tencent.mm.model.t.lA(params.getUser())) {}
      for (paramLong1 = 14L;; paramLong1 = 13L)
      {
        paramString1.idkeyStat(198L, paramLong1, 1L, false);
        break;
      }
      label853:
      paramInt1 = paramd.field_retCode;
      break label215;
      label861:
      paramString1 = paramd.field_transInfo;
      break label240;
      label870:
      paramString2 = paramd.edb;
      break label248;
      label879:
      paramInt1 = paramd.field_retCode;
      break label392;
      label887:
      paramString1 = paramd.field_transInfo;
      break label417;
    }
  }
  
  public final void a(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(50862);
    paramc = paramc.cEE;
    if (paramc == null)
    {
      AppMethodBeat.o(50862);
      return;
    }
    paramc = paramc.field_imgPath;
    if (!bo.isNullOrNil(paramc))
    {
      t localt = o.alE();
      if (localt.fnw.delete("videoinfo2", "filename= ?", new String[] { String.valueOf(paramc) }) > 0)
      {
        t.a.a locala = new t.a.a(paramc, t.a.b.fXQ, t.a.c.fXT, 1, -1L);
        localt.frK.cy(locala);
        localt.frK.doNotify();
      }
      for (;;)
      {
        if (i == 0) {
          break label202;
        }
        try
        {
          o.alE();
          new com.tencent.mm.vfs.b(t.vg(paramc)).delete();
          o.alE();
          new com.tencent.mm.vfs.b(t.vf(paramc)).delete();
          AppMethodBeat.o(50862);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.Ml() + " file:" + paramc + " msg:" + localException.getMessage());
        }
        i = 0;
      }
    }
    label202:
    AppMethodBeat.o(50862);
  }
  
  public final e.b b(e.a arg1)
  {
    AppMethodBeat.i(50861);
    Object localObject5 = ???.eyJ;
    if (localObject5 == null)
    {
      ab.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(50861);
      return null;
    }
    String str1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, "");
    Object localObject1 = aa.a(((cm)localObject5).woQ);
    Object localObject3 = aa.a(((cm)localObject5).woP);
    boolean bool1;
    Object localObject6;
    if ((((j)com.tencent.mm.kernel.g.E(j.class)).YI().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      ab.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ();
      if (!str1.equals(localObject3)) {
        break label378;
      }
    }
    label378:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject6).ag((String)localObject4, ((cm)localObject5).pIG);
      ab.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((cm)localObject5).pIG), Long.valueOf(((dd)localObject4).field_msgId), Integer.valueOf(((dd)localObject4).field_flag), Long.valueOf(((dd)localObject4).field_msgSeq), ??? });
      if ((((dd)localObject4).field_msgId != 0L) && (((dd)localObject4).field_createTime + 604800000L < bf.x((String)localObject3, ((cm)localObject5).CreateTime)))
      {
        ab.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((cm)localObject5).pIG), Long.valueOf(((dd)localObject4).field_msgId) });
        bf.gw(((dd)localObject4).field_msgId);
        ((bi)localObject4).setMsgId(0L);
      }
      if (((dd)localObject4).field_msgId == 0L) {
        break label385;
      }
      ab.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((cm)localObject5).pIG) });
      AppMethodBeat.o(50861);
      return null;
      bool1 = false;
      break;
    }
    label385:
    String str4 = aa.a(((cm)localObject5).woR);
    localObject4 = new s();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((s)localObject4).cDt = ((String)localObject3);
    ((s)localObject4).createTime = ((cm)localObject5).CreateTime;
    ((s)localObject4).cFn = ((cm)localObject5).pIG;
    ((s)localObject4).fXD = ((cm)localObject5).woR.xJE;
    ab.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { str4, ((cm)localObject5).woU });
    Object localObject7 = br.F(str4, "msg");
    if (localObject7 == null)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(50861);
      return null;
    }
    localObject3 = new bi();
    ((bi)localObject3).jl(((cm)localObject5).woU);
    ((bi)localObject3).kp(bf.pB(((cm)localObject5).woU));
    int j;
    String str5;
    String str2;
    String str3;
    int k;
    int i;
    for (;;)
    {
      try
      {
        ((s)localObject4).fsd = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).fXx = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
        ab.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).fsd), Integer.valueOf(((s)localObject4).fXx) });
        ((s)localObject4).fXq = ((String)((Map)localObject7).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).alM())) {
          ((s)localObject4).fXq = ((String)localObject1);
        }
        ((s)localObject4).cGU = ((String)((Map)localObject7).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnthumburl");
        j = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
        str5 = (String)((Map)localObject7).get(".msg.videomsg.$tpvideourl");
        localObject6 = (String)((Map)localObject7).get(".msg.videomsg.$tpthumburl");
        str2 = (String)((Map)localObject7).get(".msg.videomsg.$tpauthkey");
        str3 = (String)((Map)localObject7).get(".msg.videomsg.$tpthumbaeskey");
        k = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$tpthumblength"), 0);
        int m = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$type"), 0);
        ab.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(m)));
        if (m == 44)
        {
          i = 1;
          ((s)localObject4).fXB = i;
          if (62 == ((cm)localObject5).nqW)
          {
            ((s)localObject4).fXE = 3;
            localObject8 = bo.bf((String)((Map)localObject7).get(".msg.streamvideo.streamvideourl"), "");
            i = bo.getInt((String)((Map)localObject7).get(".msg.streamvideo.streamvideototaltime"), 0);
            String str6 = bo.bf((String)((Map)localObject7).get(".msg.streamvideo.streamvideotitle"), "");
            String str7 = bo.bf((String)((Map)localObject7).get(".msg.streamvideo.streamvideowording"), "");
            String str8 = bo.bf((String)((Map)localObject7).get(".msg.streamvideo.streamvideoweburl"), "");
            String str9 = bo.bf((String)((Map)localObject7).get(".msg.streamvideo.streamvideoaduxinfo"), "");
            String str10 = bo.bf((String)((Map)localObject7).get(".msg.streamvideo.streamvideopublishid"), "");
            if (((s)localObject4).fXG == null) {
              ((s)localObject4).fXG = new cii();
            }
            ((s)localObject4).fXG.fiQ = str6;
            ((s)localObject4).fXG.wUJ = i;
            ((s)localObject4).fXG.fiO = ((String)localObject8);
            ((s)localObject4).fXG.fiR = str7;
            ((s)localObject4).fXG.fiS = str8;
            ((s)localObject4).fXG.fiU = str9;
            ((s)localObject4).fXG.fiV = str10;
            boolean bool2 = ((s)localObject4).alM().equals((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
            if (!bool2) {
              break;
            }
            AppMethodBeat.o(50861);
            return null;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if (m > 0) {
          ((s)localObject4).fXE = 2;
        } else {
          ((s)localObject4).fXE = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 216L, 1L, false);
        ab.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        ab.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bo.l(???) });
        AppMethodBeat.o(50861);
        return null;
      }
    }
    localObject7 = (String)((Map)localObject7).get(".msg.commenturl");
    Object localObject8 = br.F(str4, "msgoperation");
    if (localObject8 != null)
    {
      ((bi)localObject3).kq((String)((Map)localObject8).get(".msgoperation.expinfo.expidstr"));
      ((bi)localObject3).ib(bo.getInt((String)((Map)localObject8).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      ab.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((dd)localObject3).dHa, Integer.valueOf(((dd)localObject3).dHb) });
    }
    localObject8 = t.ve(((s)localObject4).alM());
    ((s)localObject4).fileName = ((String)localObject8);
    ((bi)localObject3).fP(((s)localObject4).cFn);
    ((bi)localObject3).kk(((s)localObject4).getFileName());
    ((bi)localObject3).fQ(bf.x(((s)localObject4).getUser(), ((s)localObject4).createTime));
    ((bi)localObject3).kj(((s)localObject4).getUser());
    ((bi)localObject3).setStatus(((cm)localObject5).jJS);
    if (bool1)
    {
      i = 1;
      ((bi)localObject3).hL(i);
      if (((cm)localObject5).nqW != 62) {
        break label1541;
      }
      ((bi)localObject3).setType(62);
    }
    long l1;
    for (;;)
    {
      ((bi)localObject3).setContent(q.d(((s)localObject4).alM(), 0L, false));
      ((bi)localObject3).kl(str4);
      ((bi)localObject3).ko((String)localObject7);
      ((bi)localObject3).jl(((cm)localObject5).woU);
      bf.a((bi)localObject3, ???);
      l1 = bf.l((bi)localObject3);
      if (l1 > 0L) {
        break label1551;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 215L, 1L, false);
      ab.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).cFn) });
      AppMethodBeat.o(50861);
      return null;
      i = 0;
      break;
      label1541:
      ((bi)localObject3).setType(43);
    }
    label1551:
    ((s)localObject4).fXy = ((int)l1);
    ((s)localObject4).fXv = bo.aox();
    ((s)localObject4).fXz = 0;
    ((s)localObject4).status = 111;
    ab.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).fsd + " svrid:" + ((s)localObject4).cFn + " timelen:" + ((s)localObject4).fXx + " user:" + ((s)localObject4).getUser() + " human:" + ((s)localObject4).alM());
    if (!o.alE().b((s)localObject4))
    {
      ab.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
      AppMethodBeat.o(50861);
      return null;
    }
    o.alE();
    str4 = t.vg((String)localObject8);
    ??? = aa.a(((cm)localObject5).woT);
    ab.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bo.cf(???)) });
    if (ae.gkQ)
    {
      ab.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!bo.ce(???)) {
      t.a(str4, 0, ???);
    }
    for (;;)
    {
      if (((bi)localObject3).byk())
      {
        com.tencent.mm.modelcontrol.c.afT();
        if (((dd)localObject3).dHb != 1) {
          break label2432;
        }
        i = 1;
        label1817:
        if (i != 0)
        {
          u.vn(((dd)localObject3).field_imgPath);
          com.tencent.mm.al.f.afO().fyQ.add("video_" + ((dd)localObject3).field_msgId);
        }
      }
      i = 1;
      j = 0;
      if (com.tencent.mm.model.t.lA(((s)localObject4).getUser()))
      {
        j = n.nv(((s)localObject4).getUser());
        if ((com.tencent.mm.model.t.oI(((s)localObject4).getUser())) || (!com.tencent.mm.model.t.oH(((s)localObject4).getUser()))) {
          i = 2;
        }
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14388, new Object[] { Long.valueOf(((dd)localObject3).field_msgSvrId), Integer.valueOf(i), "", Integer.valueOf(j) });
        localObject1 = o.alG();
      }
      synchronized (((i)localObject1).fWm)
      {
        ((i)localObject1).fWm.offerFirst(localObject3);
        ((i)localObject1).alw();
        ??? = new e.b((bi)localObject3, true);
        AppMethodBeat.o(50861);
        return ???;
        if (!bo.isNullOrNil(str5))
        {
          l1 = ((s)localObject4).cFn;
          ab.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), localObject6, str4 });
          l2 = bo.aoy();
          ??? = str4 + ".tmp";
          localObject1 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject1).field_mediaId = com.tencent.mm.al.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject1).field_fullpath = ???;
          ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject1).field_aesKey = str3;
          ((com.tencent.mm.i.g)localObject1).field_authKey = str2;
          ((com.tencent.mm.i.g)localObject1).eds = ((String)localObject6);
          ((com.tencent.mm.i.g)localObject1).edp = new v.1(this, l1, (s)localObject4, str4, (String)localObject6, k, ???, l2);
          com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject1, -1);
          continue;
        }
        l1 = ((s)localObject4).cFn;
        ab.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), str1, str4 });
        long l2 = bo.aoy();
        ??? = str4 + ".tmp";
        localObject5 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject5).field_mediaId = com.tencent.mm.al.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject5).field_fullpath = ???;
        ((com.tencent.mm.i.g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject5).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject5).field_aesKey = ((String)localObject1);
        ((com.tencent.mm.i.g)localObject5).field_fileId = str1;
        ((com.tencent.mm.i.g)localObject5).field_priority = com.tencent.mm.i.a.ecG;
        if (com.tencent.mm.model.t.lA(((s)localObject4).getUser())) {}
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.i.g)localObject5).field_chattype = i;
          ab.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject5).field_chattype), ((s)localObject4).getUser() });
          ((com.tencent.mm.i.g)localObject5).edp = new v.2(this, l1, (s)localObject4, str4, str1, j, ???, l2);
          com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject5, -1);
          break;
        }
        label2432:
        if (((dd)localObject3).dHb == 2)
        {
          i = 0;
          break label1817;
        }
        if (!com.tencent.mm.modelcontrol.c.v((bi)localObject3))
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
          i = 0;
          break label1817;
        }
        ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("C2CSightNotAutoDownloadTimeRange");
        ab.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
        if (com.tencent.mm.modelcontrol.b.sM(???))
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
          i = 0;
          break label1817;
        }
        ??? = ((dd)localObject3).field_talker;
        ab.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
        i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("SIGHTSessionAutoLoadNetwork"), 1);
        if (i == 3)
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId) });
          i = 0;
          break label1817;
        }
        if (at.isWifi(ah.getContext()))
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId), ((dd)localObject3).field_imgPath });
          localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(???);
          if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).euF > 0) && (((com.tencent.mm.model.t.lA(???)) && (((aq)localObject1).dqK == 0)) || (((ad)localObject1).DP()))) {
            break label3107;
          }
          i = 1;
          break label1817;
        }
        if (at.is2G(ah.getContext()))
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId), ((dd)localObject3).field_imgPath });
          i = 0;
          break label1817;
        }
        ??? = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(((dd)localObject3).field_talker);
        if (com.tencent.mm.model.t.lA(((dd)localObject3).field_talker))
        {
          if (???.dqK == 0)
          {
            ab.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId), ((dd)localObject3).field_imgPath });
            i = 0;
            break label1817;
          }
          if (((at.is3G(ah.getContext())) || (at.is4G(ah.getContext()))) && (i == 1))
          {
            ab.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId), ((dd)localObject3).field_imgPath });
            i = 1;
            break label1817;
          }
          ab.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
          i = 0;
          break label1817;
        }
        if (???.DP())
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId), ((dd)localObject3).field_imgPath });
          i = 0;
          break label1817;
        }
        if (((at.is3G(ah.getContext())) || (at.is4G(ah.getContext()))) && (i == 1))
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dd)localObject3).field_msgId), Long.valueOf(((dd)localObject3).field_msgSvrId), ((dd)localObject3).field_imgPath });
          i = 1;
          break label1817;
        }
        ab.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
        i = 0;
        break label1817;
        label3107:
        ab.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
        i = 0;
        break label1817;
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */