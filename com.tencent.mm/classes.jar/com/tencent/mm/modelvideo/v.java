package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.ak.f
{
  public static int a(int paramInt1, d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(127032);
    if (paramInt1 != 0)
    {
      ac.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).aHZ();
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
      ac.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (paramd != null) {
        break label853;
      }
      paramInt1 = -1;
      paramLong1 = bs.eWj();
      i = com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext());
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
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).aHZ();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = bs.eWj();
        i = com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext());
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
    for (paramd = "";; paramd = paramd.fqM)
    {
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).aHZ();
      paramd = o.aJy();
      paramString1 = params.getFileName();
      params = t.a.c.ibi;
      if (!bs.isNullOrNil(paramString1))
      {
        paramString1 = paramd.DT(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.ibg, params, paramString1.iaP, paramString1.hYX);
          paramd.huf.dS(params);
          paramd.huf.doNotify();
        }
      }
      AppMethodBeat.o(127032);
      return 0;
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString1);
      new com.tencent.mm.vfs.e(paramString3).ae(locale);
      ac.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (params.iaP == 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.h.wUl;
        if (w.sQ(params.getUser())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.h.wUl;
      if (w.sQ(params.getUser())) {}
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
      paramString2 = paramd.fqM;
      break label248;
      label879:
      paramInt1 = paramd.field_retCode;
      break label392;
      label887:
      paramString1 = paramd.field_transInfo;
      break label417;
    }
  }
  
  public final f.b b(f.a arg1)
  {
    AppMethodBeat.i(127030);
    Object localObject5 = ???.fXi;
    if (localObject5 == null)
    {
      ac.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.g.agR().agA().get(2, "");
    Object localObject1 = z.a(((cu)localObject5).DPU);
    Object localObject3 = z.a(((cu)localObject5).DPT);
    boolean bool1;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      ac.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr();
      if (!str1.equals(localObject3)) {
        break label374;
      }
    }
    label374:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject6).aF((String)localObject4, ((cu)localObject5).vTQ);
      ac.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((cu)localObject5).vTQ), Long.valueOf(((dy)localObject4).field_msgId), Integer.valueOf(((dy)localObject4).field_flag), Long.valueOf(((dy)localObject4).field_msgSeq), ??? });
      if ((((dy)localObject4).field_msgId != 0L) && (((dy)localObject4).field_createTime + 604800000L < bi.z((String)localObject3, ((cu)localObject5).CreateTime)))
      {
        ac.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((cu)localObject5).vTQ), Long.valueOf(((dy)localObject4).field_msgId) });
        bi.pK(((dy)localObject4).field_msgId);
        ((bo)localObject4).setMsgId(0L);
      }
      if (((dy)localObject4).field_msgId == 0L) {
        break label381;
      }
      ac.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((cu)localObject5).vTQ) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label381:
    Object localObject6 = z.a(((cu)localObject5).DPV);
    localObject4 = new s();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((s)localObject4).drG = ((String)localObject3);
    ((s)localObject4).createTime = ((cu)localObject5).CreateTime;
    ((s)localObject4).dpl = ((cu)localObject5).vTQ;
    ((s)localObject4).iaO = ((cu)localObject5).DPV.FEm;
    ac.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((cu)localObject5).DPY });
    Object localObject8 = bv.L((String)localObject6, "msg");
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new bo();
    ((bo)localObject3).qf(((cu)localObject5).DPY);
    Object localObject7 = bi.yr(((cu)localObject5).DPY);
    if (localObject7 != null)
    {
      ((bo)localObject3).rk(((bi.b)localObject7).hoy);
      ((bo)localObject3).kk(((bi.b)localObject7).hoz);
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
        ((s)localObject4).hux = bs.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).hpy = bs.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        ac.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).hux), Integer.valueOf(((s)localObject4).hpy) });
        ((s)localObject4).iaC = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).aJH())) {
          ((s)localObject4).iaC = ((String)localObject1);
        }
        ((s)localObject4).dvs = ((String)((Map)localObject8).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumburl");
        j = bs.getInt((String)((Map)localObject8).get(".msg.videomsg.$cdnthumblength"), 0);
        str4 = (String)((Map)localObject8).get(".msg.videomsg.$tpvideourl");
        localObject7 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumburl");
        str2 = (String)((Map)localObject8).get(".msg.videomsg.$tpauthkey");
        str3 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumbaeskey");
        k = bs.getInt((String)((Map)localObject8).get(".msg.videomsg.$tpthumblength"), 0);
        int m = bs.getInt((String)((Map)localObject8).get(".msg.videomsg.$type"), 0);
        ac.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(m)));
        if (m == 44)
        {
          i = 1;
          ((s)localObject4).iaM = i;
          if (62 == ((cu)localObject5).tit)
          {
            ((s)localObject4).iaP = 3;
            ((s)localObject4).a(bs.bG((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), ""), bs.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0), bs.bG((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), ""), bs.bG((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), ""), bs.bG((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), ""), bs.bG((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), ""), bs.bG((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), ""));
            boolean bool2 = ((s)localObject4).aJH().equals((String)com.tencent.mm.kernel.g.agR().agA().get(2, ""));
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
          ((s)localObject4).iaP = 2;
        } else {
          ((s)localObject4).iaP = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 216L, 1L, false);
        ac.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        ac.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bs.m(???) });
        AppMethodBeat.o(127030);
        return null;
      }
    }
    localObject8 = (String)((Map)localObject8).get(".msg.commenturl");
    Object localObject9 = bv.L((String)localObject6, "msgoperation");
    if (localObject9 != null)
    {
      ((bo)localObject3).rl((String)((Map)localObject9).get(".msgoperation.expinfo.expidstr"));
      ((bo)localObject3).kj(bs.getInt((String)((Map)localObject9).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      ac.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((dy)localObject3).eSk, Integer.valueOf(((dy)localObject3).eSl) });
    }
    localObject9 = t.DU(((s)localObject4).aJH());
    ((s)localObject4).fileName = ((String)localObject9);
    ((bo)localObject3).oz(((s)localObject4).dpl);
    ((bo)localObject3).rf(((s)localObject4).getFileName());
    ((bo)localObject3).oA(bi.z(((s)localObject4).getUser(), ((s)localObject4).createTime));
    ((bo)localObject3).re(((s)localObject4).getUser());
    ((bo)localObject3).setStatus(((cu)localObject5).ndj);
    if (bool1)
    {
      i = 1;
      ((bo)localObject3).jT(i);
      if (((cu)localObject5).tit != 62) {
        break label1458;
      }
      ((bo)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((bo)localObject3).setContent(q.b(((s)localObject4).aJH(), 0L, false));
      ((bo)localObject3).rg((String)localObject6);
      ((bo)localObject3).rj((String)localObject8);
      ((bo)localObject3).qf(((cu)localObject5).DPY);
      bi.a((bo)localObject3, ???);
      l1 = bi.u((bo)localObject3);
      if (l1 > 0L) {
        break label1468;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 215L, 1L, false);
      ac.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).dpl) });
      AppMethodBeat.o(127030);
      return null;
      i = 0;
      break;
      label1458:
      ((bo)localObject3).setType(43);
    }
    label1468:
    ((s)localObject4).iaJ = ((int)l1);
    ((s)localObject4).iaH = bs.aNx();
    ((s)localObject4).iaK = 0;
    ((s)localObject4).status = 111;
    ac.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).hux + " svrid:" + ((s)localObject4).dpl + " timelen:" + ((s)localObject4).hpy + " user:" + ((s)localObject4).getUser() + " human:" + ((s)localObject4).aJH());
    if (!o.aJy().b((s)localObject4))
    {
      ac.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
      AppMethodBeat.o(127030);
      return null;
    }
    o.aJy();
    localObject6 = t.DW((String)localObject9);
    ??? = z.a(((cu)localObject5).DPX);
    ac.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bs.cw(???)) });
    if (ab.ivM)
    {
      ac.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!bs.cv(???))
    {
      t.a((String)localObject6, 0, ???);
      if (((bo)localObject3).crv())
      {
        com.tencent.mm.modelcontrol.c.aDI();
        if (((dy)localObject3).eSl != 1) {
          break label2345;
        }
        i = 1;
        label1733:
        if (i != 0)
        {
          u.Ee(((dy)localObject3).field_imgPath);
          com.tencent.mm.an.f.aDD().hBp.add("video_" + ((dy)localObject3).field_msgId);
        }
      }
      j = 1;
      if (!w.sQ(((s)localObject4).getUser())) {
        break label3051;
      }
      i = com.tencent.mm.model.q.wb(((s)localObject4).getUser());
      if ((!w.xw(((s)localObject4).getUser())) && (w.xv(((s)localObject4).getUser()))) {
        break label3034;
      }
      j = 2;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14388, new Object[] { Long.valueOf(((dy)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
        localObject1 = o.aJA();
        synchronized (((i)localObject1).hZz)
        {
          ((i)localObject1).hZz.offerFirst(localObject3);
          ((i)localObject1).startDownload();
          ??? = new f.b((bo)localObject3, true);
          AppMethodBeat.o(127030);
          return ???;
          if (!bs.isNullOrNil(str4))
          {
            l1 = ((s)localObject4).dpl;
            ac.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), localObject7, localObject6 });
            l2 = bs.eWj();
            ??? = (String)localObject6 + ".tmp";
            localObject1 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject1).field_mediaId = com.tencent.mm.an.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
            ((com.tencent.mm.i.g)localObject1).field_fullpath = ???;
            ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
            ((com.tencent.mm.i.g)localObject1).field_aesKey = str3;
            ((com.tencent.mm.i.g)localObject1).field_authKey = str2;
            ((com.tencent.mm.i.g)localObject1).fre = ((String)localObject7);
            ((com.tencent.mm.i.g)localObject1).frb = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127028);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.ibn, this.hHS, k, parama, l2, this.hHV);
                AppMethodBeat.o(127028);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject1, -1);
            break;
          }
          l1 = ((s)localObject4).dpl;
          ac.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), str1, localObject6 });
          final long l2 = bs.eWj();
          ??? = (String)localObject6 + ".tmp";
          localObject5 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject5).field_mediaId = com.tencent.mm.an.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject5).field_fullpath = ???;
          ((com.tencent.mm.i.g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
          ((com.tencent.mm.i.g)localObject5).field_totalLen = j;
          ((com.tencent.mm.i.g)localObject5).field_aesKey = ((String)localObject1);
          ((com.tencent.mm.i.g)localObject5).field_fileId = str1;
          ((com.tencent.mm.i.g)localObject5).field_priority = com.tencent.mm.i.a.fqq;
          if (w.sQ(((s)localObject4).getUser())) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject5).field_chattype = i;
            ac.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject5).field_chattype), ((s)localObject4).getUser() });
            ((com.tencent.mm.i.g)localObject5).frb = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127029);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.ibn, str1, j, parama, l2, this.hHV);
                AppMethodBeat.o(127029);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return null;
              }
            };
            com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject5, -1);
            break;
          }
          label2345:
          if (((dy)localObject3).eSl == 2)
          {
            i = 0;
            break label1733;
          }
          if (!com.tencent.mm.modelcontrol.c.H((bo)localObject3))
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("C2CSightNotAutoDownloadTimeRange");
          ac.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
          if (com.tencent.mm.modelcontrol.b.BU(???))
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((dy)localObject3).field_talker;
          ac.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
          i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("SIGHTSessionAutoLoadNetwork"), 1);
          if (i == 3)
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId) });
            i = 0;
            break label1733;
          }
          if (ax.isWifi(com.tencent.mm.sdk.platformtools.ai.getContext()))
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId), ((dy)localObject3).field_imgPath });
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(???);
            if ((localObject1 != null) && ((int)((com.tencent.mm.n.b)localObject1).fLJ > 0) && (((w.sQ(???)) && (((av)localObject1).exT == 0)) || (((com.tencent.mm.storage.ai)localObject1).Nw()))) {
              break label3020;
            }
            i = 1;
            break label1733;
          }
          if (ax.is2G(com.tencent.mm.sdk.platformtools.ai.getContext()))
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId), ((dy)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((dy)localObject3).field_talker);
          if (w.sQ(((dy)localObject3).field_talker))
          {
            if (???.exT == 0)
            {
              ac.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId), ((dy)localObject3).field_imgPath });
              i = 0;
              break label1733;
            }
            if (((ax.is3G(com.tencent.mm.sdk.platformtools.ai.getContext())) || (ax.is4G(com.tencent.mm.sdk.platformtools.ai.getContext()))) && (i == 1))
            {
              ac.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId), ((dy)localObject3).field_imgPath });
              i = 1;
              break label1733;
            }
            ac.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
            i = 0;
            break label1733;
          }
          if (???.Nw())
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId), ((dy)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          if (((ax.is3G(com.tencent.mm.sdk.platformtools.ai.getContext())) || (ax.is4G(com.tencent.mm.sdk.platformtools.ai.getContext()))) && (i == 1))
          {
            ac.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId), ((dy)localObject3).field_imgPath });
            i = 1;
            break label1733;
          }
          ac.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
          i = 0;
          break label1733;
          label3020:
          ac.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
          i = 0;
          break label1733;
          label3034:
          j = 3;
        }
      }
      label3051:
      i = 0;
    }
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(127031);
    paramc = paramc.dpq;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    u.Ei(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */