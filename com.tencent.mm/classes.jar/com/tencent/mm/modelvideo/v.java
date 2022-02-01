package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.al.e
{
  public static int a(int paramInt1, d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(127032);
    if (paramInt1 != 0)
    {
      ad.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).aLk();
      AppMethodBeat.o(127032);
      return paramInt1;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(127032);
      return 0;
    }
    label215:
    int i;
    int j;
    if (paramd.field_retCode != 0)
    {
      ad.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (paramd != null) {
        break label853;
      }
      paramInt1 = -1;
      paramLong1 = bt.flT();
      i = com.tencent.mm.ao.c.cA(aj.getContext());
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
      new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).aLk();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = bt.flT();
        i = com.tencent.mm.ao.c.cA(aj.getContext());
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
    for (paramd = "";; paramd = paramd.fIT)
    {
      new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).aLk();
      paramd = o.aMJ();
      paramString1 = params.getFileName();
      params = t.a.c.iuE;
      if (!bt.isNullOrNil(paramString1))
      {
        paramString1 = paramd.Hb(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.iuC, params, paramString1.iul, paramString1.ist);
          paramd.hMx.dV(params);
          paramd.hMx.doNotify();
        }
      }
      AppMethodBeat.o(127032);
      return 0;
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString1);
      new com.tencent.mm.vfs.e(paramString3).ag(locale);
      ad.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (params.iul == 3)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.g.yhR;
        if (w.vF(params.getUser())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.g.yhR;
      if (w.vF(params.getUser())) {}
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
      paramString2 = paramd.fIT;
      break label248;
      label879:
      paramInt1 = paramd.field_retCode;
      break label392;
      label887:
      paramString1 = paramd.field_transInfo;
      break label417;
    }
  }
  
  public final e.b b(e.a arg1)
  {
    AppMethodBeat.i(127030);
    Object localObject5 = ???.gqE;
    if (localObject5 == null)
    {
      ad.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, "");
    Object localObject1 = z.a(((cv)localObject5).Fvj);
    Object localObject3 = z.a(((cv)localObject5).Fvi);
    boolean bool1;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      ad.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK();
      if (!str1.equals(localObject3)) {
        break label374;
      }
    }
    label374:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject6).aI((String)localObject4, ((cv)localObject5).xbt);
      ad.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((cv)localObject5).xbt), Long.valueOf(((ei)localObject4).field_msgId), Integer.valueOf(((ei)localObject4).field_flag), Long.valueOf(((ei)localObject4).field_msgSeq), ??? });
      if ((((ei)localObject4).field_msgId != 0L) && (((ei)localObject4).field_createTime + 604800000L < bj.B((String)localObject3, ((cv)localObject5).CreateTime)))
      {
        ad.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((cv)localObject5).xbt), Long.valueOf(((ei)localObject4).field_msgId) });
        bj.rJ(((ei)localObject4).field_msgId);
        ((bu)localObject4).setMsgId(0L);
      }
      if (((ei)localObject4).field_msgId == 0L) {
        break label381;
      }
      ad.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((cv)localObject5).xbt) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label381:
    Object localObject6 = z.a(((cv)localObject5).Fvk);
    localObject4 = new s();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((s)localObject4).dDy = ((String)localObject3);
    ((s)localObject4).createTime = ((cv)localObject5).CreateTime;
    ((s)localObject4).dAY = ((cv)localObject5).xbt;
    ((s)localObject4).iuk = ((cv)localObject5).Fvk.HoB;
    ad.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((cv)localObject5).Fvn });
    Object localObject8 = bw.M((String)localObject6, "msg");
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new bu();
    ((bu)localObject3).sP(((cv)localObject5).Fvn);
    Object localObject7 = bj.Bq(((cv)localObject5).Fvn);
    if (localObject7 != null)
    {
      ((bu)localObject3).tW(((bj.b)localObject7).hGQ);
      ((bu)localObject3).kH(((bj.b)localObject7).hGR);
    }
    final int j;
    String str4;
    String str2;
    String str3;
    final int k;
    int i;
    for (;;)
    {
      try
      {
        ((s)localObject4).hMP = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).hHQ = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        ad.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).hMP), Integer.valueOf(((s)localObject4).hHQ) });
        ((s)localObject4).itY = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).aMS())) {
          ((s)localObject4).itY = ((String)localObject1);
        }
        ((s)localObject4).dHv = ((String)((Map)localObject8).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumburl");
        j = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$cdnthumblength"), 0);
        str4 = (String)((Map)localObject8).get(".msg.videomsg.$tpvideourl");
        localObject7 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumburl");
        str2 = (String)((Map)localObject8).get(".msg.videomsg.$tpauthkey");
        str3 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumbaeskey");
        k = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$tpthumblength"), 0);
        int m = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$type"), 0);
        ad.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(m)));
        if (m == 44)
        {
          i = 1;
          ((s)localObject4).iui = i;
          if (62 == ((cv)localObject5).ugm)
          {
            ((s)localObject4).iul = 3;
            ((s)localObject4).a(bt.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), ""), bt.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0), bt.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), ""), bt.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), ""), bt.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), ""), bt.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), ""), bt.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), ""));
            boolean bool2 = ((s)localObject4).aMS().equals((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
            if (!bool2) {
              break;
            }
            AppMethodBeat.o(127030);
            return null;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if (m > 0) {
          ((s)localObject4).iul = 2;
        } else {
          ((s)localObject4).iul = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 216L, 1L, false);
        ad.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        ad.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bt.n(???) });
        AppMethodBeat.o(127030);
        return null;
      }
    }
    localObject8 = (String)((Map)localObject8).get(".msg.commenturl");
    Object localObject9 = bw.M((String)localObject6, "msgoperation");
    if (localObject9 != null)
    {
      ((bu)localObject3).tX((String)((Map)localObject9).get(".msgoperation.expinfo.expidstr"));
      ((bu)localObject3).kG(bt.getInt((String)((Map)localObject9).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      ad.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((ei)localObject3).fkz, Integer.valueOf(((ei)localObject3).fkA) });
    }
    localObject9 = t.Hg(((s)localObject4).aMS());
    ((s)localObject4).fileName = ((String)localObject9);
    ((bu)localObject3).qz(((s)localObject4).dAY);
    ((bu)localObject3).tO(((s)localObject4).getFileName());
    ((bu)localObject3).qA(bj.B(((s)localObject4).getUser(), ((s)localObject4).createTime));
    ((bu)localObject3).tN(((s)localObject4).getUser());
    ((bu)localObject3).setStatus(((cv)localObject5).nDG);
    if (bool1)
    {
      i = 1;
      ((bu)localObject3).kr(i);
      if (((cv)localObject5).ugm != 62) {
        break label1458;
      }
      ((bu)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((bu)localObject3).setContent(q.b(((s)localObject4).aMS(), 0L, false));
      ((bu)localObject3).tP((String)localObject6);
      ((bu)localObject3).tV((String)localObject8);
      ((bu)localObject3).sP(((cv)localObject5).Fvn);
      bj.a((bu)localObject3, ???);
      l1 = bj.v((bu)localObject3);
      if (l1 > 0L) {
        break label1468;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 215L, 1L, false);
      ad.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).dAY) });
      AppMethodBeat.o(127030);
      return null;
      i = 0;
      break;
      label1458:
      ((bu)localObject3).setType(43);
    }
    label1468:
    ((s)localObject4).iuf = ((int)l1);
    ((s)localObject4).iud = bt.aQJ();
    ((s)localObject4).iug = 0;
    ((s)localObject4).status = 111;
    ad.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).hMP + " svrid:" + ((s)localObject4).dAY + " timelen:" + ((s)localObject4).hHQ + " user:" + ((s)localObject4).getUser() + " human:" + ((s)localObject4).aMS());
    if (!o.aMJ().b((s)localObject4))
    {
      ad.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
      AppMethodBeat.o(127030);
      return null;
    }
    o.aMJ();
    localObject6 = t.Hi((String)localObject9);
    ??? = z.a(((cv)localObject5).Fvm);
    ad.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bt.cD(???)) });
    if (ac.iOT)
    {
      ad.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!bt.cC(???))
    {
      t.a((String)localObject6, 0, ???);
      if (((bu)localObject3).cxh())
      {
        com.tencent.mm.modelcontrol.c.aGN();
        if (((ei)localObject3).fkA != 1) {
          break label2361;
        }
        i = 1;
        label1733:
        if (i != 0)
        {
          u.Ht(((ei)localObject3).field_imgPath);
          f.aGI().hTO.add("video_" + ((ei)localObject3).field_msgId);
        }
      }
      j = 1;
      if (!w.vF(((s)localObject4).getUser())) {
        break label3067;
      }
      i = com.tencent.mm.model.q.yS(((s)localObject4).getUser());
      if ((!w.Au(((s)localObject4).getUser())) && (w.At(((s)localObject4).getUser()))) {
        break label3050;
      }
      j = 2;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(14388, new Object[] { Long.valueOf(((ei)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
        localObject1 = o.aML();
        synchronized (((i)localObject1).isU)
        {
          ((i)localObject1).isU.offerFirst(localObject3);
          ((i)localObject1).startDownload();
          ??? = new e.b((bu)localObject3, true);
          AppMethodBeat.o(127030);
          return ???;
          if (!bt.isNullOrNil(str4))
          {
            l1 = ((s)localObject4).dAY;
            ad.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), localObject7, localObject6 });
            l2 = bt.flT();
            ??? = (String)localObject6 + ".tmp";
            localObject1 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject1).fJi = "task_VideoMsgExtension_1";
            ((com.tencent.mm.i.g)localObject1).field_mediaId = com.tencent.mm.ao.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
            ((com.tencent.mm.i.g)localObject1).field_fullpath = ???;
            ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
            ((com.tencent.mm.i.g)localObject1).field_aesKey = str3;
            ((com.tencent.mm.i.g)localObject1).field_authKey = str2;
            ((com.tencent.mm.i.g)localObject1).fJm = ((String)localObject7);
            ((com.tencent.mm.i.g)localObject1).fJj = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127028);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.iuJ, this.iaG, k, parama, l2, this.iaJ);
                AppMethodBeat.o(127028);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            f.aGI().b((com.tencent.mm.i.g)localObject1, -1);
            break;
          }
          l1 = ((s)localObject4).dAY;
          ad.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), str1, localObject6 });
          final long l2 = bt.flT();
          ??? = (String)localObject6 + ".tmp";
          localObject5 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject5).fJi = "task_VideoMsgExtension_2";
          ((com.tencent.mm.i.g)localObject5).field_mediaId = com.tencent.mm.ao.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject5).field_fullpath = ???;
          ((com.tencent.mm.i.g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
          ((com.tencent.mm.i.g)localObject5).field_totalLen = j;
          ((com.tencent.mm.i.g)localObject5).field_aesKey = ((String)localObject1);
          ((com.tencent.mm.i.g)localObject5).field_fileId = str1;
          ((com.tencent.mm.i.g)localObject5).field_priority = com.tencent.mm.i.a.fIx;
          if (w.vF(((s)localObject4).getUser())) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject5).field_chattype = i;
            ad.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject5).field_chattype), ((s)localObject4).getUser() });
            ((com.tencent.mm.i.g)localObject5).fJj = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127029);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.iuJ, str1, j, parama, l2, this.iaJ);
                AppMethodBeat.o(127029);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return null;
              }
            };
            f.aGI().b((com.tencent.mm.i.g)localObject5, -1);
            break;
          }
          label2361:
          if (((ei)localObject3).fkA == 2)
          {
            i = 0;
            break label1733;
          }
          if (!com.tencent.mm.modelcontrol.c.K((bu)localObject3))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("C2CSightNotAutoDownloadTimeRange");
          ad.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
          if (com.tencent.mm.modelcontrol.b.ET(???))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((ei)localObject3).field_talker;
          ad.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("SIGHTSessionAutoLoadNetwork"), 1);
          if (i == 3)
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId) });
            i = 0;
            break label1733;
          }
          if (ay.isWifi(aj.getContext()))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(???);
            if ((localObject1 != null) && ((int)((com.tencent.mm.o.b)localObject1).gfj > 0) && (((w.vF(???)) && (((aw)localObject1).ePs == 0)) || (((am)localObject1).Pf()))) {
              break label3036;
            }
            i = 1;
            break label1733;
          }
          if (ay.is2G(aj.getContext()))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(((ei)localObject3).field_talker);
          if (w.vF(((ei)localObject3).field_talker))
          {
            if (???.ePs == 0)
            {
              ad.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
              i = 0;
              break label1733;
            }
            if (((ay.is3G(aj.getContext())) || (ay.is4G(aj.getContext()))) && (i == 1))
            {
              ad.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
              i = 1;
              break label1733;
            }
            ad.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
            i = 0;
            break label1733;
          }
          if (???.Pf())
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          if (((ay.is3G(aj.getContext())) || (ay.is4G(aj.getContext()))) && (i == 1))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            i = 1;
            break label1733;
          }
          ad.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
          i = 0;
          break label1733;
          label3036:
          ad.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
          i = 0;
          break label1733;
          label3050:
          j = 3;
        }
      }
      label3067:
      i = 0;
    }
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(127031);
    paramc = paramc.dBd;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    u.Hx(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */