package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.al.f
{
  public static int a(int paramInt1, d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(127032);
    if (paramInt1 != 0)
    {
      ad.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).aBj();
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
      paramLong1 = bt.eGO();
      i = com.tencent.mm.ao.c.cu(aj.getContext());
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
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).aBj();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = bt.eGO();
        i = com.tencent.mm.ao.c.cu(aj.getContext());
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
    for (paramd = "";; paramd = paramd.fns)
    {
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).aBj();
      paramd = o.aCI();
      paramString1 = params.getFileName();
      params = t.a.c.hAH;
      if (!bt.isNullOrNil(paramString1))
      {
        paramString1 = paramd.zO(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.hAF, params, paramString1.hAo, paramString1.hyw);
          paramd.gTG.dR(params);
          paramd.gTG.doNotify();
        }
      }
      AppMethodBeat.o(127032);
      return 0;
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString1);
      new com.tencent.mm.vfs.e(paramString3).af(locale);
      ad.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (params.hAo == 3)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.h.vKh;
        if (w.pF(params.getUser())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.h.vKh;
      if (w.pF(params.getUser())) {}
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
      paramString2 = paramd.fns;
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
    Object localObject5 = ???.fTo;
    if (localObject5 == null)
    {
      ad.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(2, "");
    Object localObject1 = z.a(((cs)localObject5).Cxy);
    Object localObject3 = z.a(((cs)localObject5).Cxx);
    boolean bool1;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      ad.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI();
      if (!str1.equals(localObject3)) {
        break label374;
      }
    }
    label374:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject6).aD((String)localObject4, ((cs)localObject5).uKZ);
      ad.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((cs)localObject5).uKZ), Long.valueOf(((du)localObject4).field_msgId), Integer.valueOf(((du)localObject4).field_flag), Long.valueOf(((du)localObject4).field_msgSeq), ??? });
      if ((((du)localObject4).field_msgId != 0L) && (((du)localObject4).field_createTime + 604800000L < bi.y((String)localObject3, ((cs)localObject5).CreateTime)))
      {
        ad.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((cs)localObject5).uKZ), Long.valueOf(((du)localObject4).field_msgId) });
        bi.lW(((du)localObject4).field_msgId);
        ((bl)localObject4).setMsgId(0L);
      }
      if (((du)localObject4).field_msgId == 0L) {
        break label381;
      }
      ad.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((cs)localObject5).uKZ) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label381:
    Object localObject6 = z.a(((cs)localObject5).Cxz);
    localObject4 = new s();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((s)localObject4).dtV = ((String)localObject3);
    ((s)localObject4).createTime = ((cs)localObject5).CreateTime;
    ((s)localObject4).drA = ((cs)localObject5).uKZ;
    ((s)localObject4).hAn = ((cs)localObject5).Cxz.Ehn;
    ad.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((cs)localObject5).CxC });
    Object localObject8 = bw.K((String)localObject6, "msg");
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new bl();
    ((bl)localObject3).mZ(((cs)localObject5).CxC);
    Object localObject7 = bi.ul(((cs)localObject5).CxC);
    if (localObject7 != null)
    {
      ((bl)localObject3).oe(((bi.b)localObject7).gNY);
      ((bl)localObject3).kn(((bi.b)localObject7).gNZ);
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
        ((s)localObject4).gTY = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).gOY = bt.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        ad.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).gTY), Integer.valueOf(((s)localObject4).gOY) });
        ((s)localObject4).hAb = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).aCQ())) {
          ((s)localObject4).hAb = ((String)localObject1);
        }
        ((s)localObject4).dxG = ((String)((Map)localObject8).get(".msg.statextstr"));
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
          ((s)localObject4).hAl = i;
          if (62 == ((cs)localObject5).saz)
          {
            ((s)localObject4).hAo = 3;
            ((s)localObject4).a(bt.by((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), ""), bt.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0), bt.by((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), ""), bt.by((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), ""), bt.by((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), ""), bt.by((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), ""), bt.by((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), ""));
            boolean bool2 = ((s)localObject4).aCQ().equals((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
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
          ((s)localObject4).hAo = 2;
        } else {
          ((s)localObject4).hAo = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 216L, 1L, false);
        ad.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        ad.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bt.m(???) });
        AppMethodBeat.o(127030);
        return null;
      }
    }
    localObject8 = (String)((Map)localObject8).get(".msg.commenturl");
    Object localObject9 = bw.K((String)localObject6, "msgoperation");
    if (localObject9 != null)
    {
      ((bl)localObject3).of((String)((Map)localObject9).get(".msgoperation.expinfo.expidstr"));
      ((bl)localObject3).km(bt.getInt((String)((Map)localObject9).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      ad.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((du)localObject3).ePc, Integer.valueOf(((du)localObject3).ePd) });
    }
    localObject9 = t.zP(((s)localObject4).aCQ());
    ((s)localObject4).fileName = ((String)localObject9);
    ((bl)localObject3).kX(((s)localObject4).drA);
    ((bl)localObject3).nZ(((s)localObject4).getFileName());
    ((bl)localObject3).kY(bi.y(((s)localObject4).getUser(), ((s)localObject4).createTime));
    ((bl)localObject3).nY(((s)localObject4).getUser());
    ((bl)localObject3).setStatus(((cs)localObject5).mBi);
    if (bool1)
    {
      i = 1;
      ((bl)localObject3).jV(i);
      if (((cs)localObject5).saz != 62) {
        break label1458;
      }
      ((bl)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((bl)localObject3).setContent(q.b(((s)localObject4).aCQ(), 0L, false));
      ((bl)localObject3).oa((String)localObject6);
      ((bl)localObject3).od((String)localObject8);
      ((bl)localObject3).mZ(((cs)localObject5).CxC);
      bi.a((bl)localObject3, ???);
      l1 = bi.u((bl)localObject3);
      if (l1 > 0L) {
        break label1468;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 215L, 1L, false);
      ad.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).drA) });
      AppMethodBeat.o(127030);
      return null;
      i = 0;
      break;
      label1458:
      ((bl)localObject3).setType(43);
    }
    label1468:
    ((s)localObject4).hAi = ((int)l1);
    ((s)localObject4).hAg = bt.aGK();
    ((s)localObject4).hAj = 0;
    ((s)localObject4).status = 111;
    ad.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).gTY + " svrid:" + ((s)localObject4).drA + " timelen:" + ((s)localObject4).gOY + " user:" + ((s)localObject4).getUser() + " human:" + ((s)localObject4).aCQ());
    if (!o.aCI().b((s)localObject4))
    {
      ad.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
      AppMethodBeat.o(127030);
      return null;
    }
    o.aCI();
    localObject6 = t.zR((String)localObject9);
    ??? = z.a(((cs)localObject5).CxB);
    ad.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bt.cx(???)) });
    if (com.tencent.mm.platformtools.ab.hVI)
    {
      ad.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!bt.cw(???))
    {
      t.a((String)localObject6, 0, ???);
      if (((bl)localObject3).cjO())
      {
        com.tencent.mm.modelcontrol.c.awQ();
        if (((du)localObject3).ePd != 1) {
          break label2345;
        }
        i = 1;
        label1733:
        if (i != 0)
        {
          u.zZ(((du)localObject3).field_imgPath);
          com.tencent.mm.ao.f.awL().haO.add("video_" + ((du)localObject3).field_msgId);
        }
      }
      j = 1;
      if (!w.pF(((s)localObject4).getUser())) {
        break label3051;
      }
      i = com.tencent.mm.model.q.rY(((s)localObject4).getUser());
      if ((!w.tt(((s)localObject4).getUser())) && (w.ts(((s)localObject4).getUser()))) {
        break label3034;
      }
      j = 2;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(14388, new Object[] { Long.valueOf(((du)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
        localObject1 = o.aCK();
        synchronized (((i)localObject1).hyY)
        {
          ((i)localObject1).hyY.offerFirst(localObject3);
          ((i)localObject1).aCA();
          ??? = new f.b((bl)localObject3, true);
          AppMethodBeat.o(127030);
          return ???;
          if (!bt.isNullOrNil(str4))
          {
            l1 = ((s)localObject4).drA;
            ad.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), localObject7, localObject6 });
            l2 = bt.eGO();
            ??? = (String)localObject6 + ".tmp";
            localObject1 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject1).field_mediaId = com.tencent.mm.ao.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
            ((com.tencent.mm.i.g)localObject1).field_fullpath = ???;
            ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
            ((com.tencent.mm.i.g)localObject1).field_aesKey = str3;
            ((com.tencent.mm.i.g)localObject1).field_authKey = str2;
            ((com.tencent.mm.i.g)localObject1).fnK = ((String)localObject7);
            ((com.tencent.mm.i.g)localObject1).fnH = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127028);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.hAM, this.hhp, k, parama, l2, this.hhs);
                AppMethodBeat.o(127028);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject1, -1);
            break;
          }
          l1 = ((s)localObject4).drA;
          ad.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), str1, localObject6 });
          final long l2 = bt.eGO();
          ??? = (String)localObject6 + ".tmp";
          localObject5 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject5).field_mediaId = com.tencent.mm.ao.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject5).field_fullpath = ???;
          ((com.tencent.mm.i.g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
          ((com.tencent.mm.i.g)localObject5).field_totalLen = j;
          ((com.tencent.mm.i.g)localObject5).field_aesKey = ((String)localObject1);
          ((com.tencent.mm.i.g)localObject5).field_fileId = str1;
          ((com.tencent.mm.i.g)localObject5).field_priority = com.tencent.mm.i.a.fmW;
          if (w.pF(((s)localObject4).getUser())) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject5).field_chattype = i;
            ad.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject5).field_chattype), ((s)localObject4).getUser() });
            ((com.tencent.mm.i.g)localObject5).fnH = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127029);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.hAM, str1, j, parama, l2, this.hhs);
                AppMethodBeat.o(127029);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return null;
              }
            };
            com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject5, -1);
            break;
          }
          label2345:
          if (((du)localObject3).ePd == 2)
          {
            i = 0;
            break label1733;
          }
          if (!com.tencent.mm.modelcontrol.c.H((bl)localObject3))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("C2CSightNotAutoDownloadTimeRange");
          ad.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
          if (com.tencent.mm.modelcontrol.b.xO(???))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((du)localObject3).field_talker;
          ad.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("SIGHTSessionAutoLoadNetwork"), 1);
          if (i == 3)
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId) });
            i = 0;
            break label1733;
          }
          if (ay.isWifi(aj.getContext()))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId), ((du)localObject3).field_imgPath });
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(???);
            if ((localObject1 != null) && ((int)((com.tencent.mm.n.b)localObject1).fId > 0) && (((w.pF(???)) && (((au)localObject1).evx == 0)) || (((af)localObject1).Ny()))) {
              break label3020;
            }
            i = 1;
            break label1733;
          }
          if (ay.is2G(aj.getContext()))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId), ((du)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((du)localObject3).field_talker);
          if (w.pF(((du)localObject3).field_talker))
          {
            if (???.evx == 0)
            {
              ad.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId), ((du)localObject3).field_imgPath });
              i = 0;
              break label1733;
            }
            if (((ay.is3G(aj.getContext())) || (ay.is4G(aj.getContext()))) && (i == 1))
            {
              ad.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId), ((du)localObject3).field_imgPath });
              i = 1;
              break label1733;
            }
            ad.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
            i = 0;
            break label1733;
          }
          if (???.Ny())
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId), ((du)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          if (((ay.is3G(aj.getContext())) || (ay.is4G(aj.getContext()))) && (i == 1))
          {
            ad.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId), ((du)localObject3).field_imgPath });
            i = 1;
            break label1733;
          }
          ad.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
          i = 0;
          break label1733;
          label3020:
          ad.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
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
    paramc = paramc.drF;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    u.Ad(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */