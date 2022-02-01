package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.ak.e
{
  public static int a(int paramInt1, d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(127032);
    if (paramInt1 != 0)
    {
      ae.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).aLH();
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
      ae.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (paramd != null) {
        break label853;
      }
      paramInt1 = -1;
      paramLong1 = bu.fpO();
      i = com.tencent.mm.an.c.cC(ak.getContext());
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
      new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).aLH();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = bu.fpO();
        i = com.tencent.mm.an.c.cC(ak.getContext());
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
    for (paramd = "";; paramd = paramd.fKX)
    {
      new h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).aLH();
      paramd = o.aNh();
      paramString1 = params.getFileName();
      params = t.a.c.ixy;
      if (!bu.isNullOrNil(paramString1))
      {
        paramString1 = paramd.HD(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.ixw, params, paramString1.ixf, paramString1.ivn);
          paramd.hPq.dW(params);
          paramd.hPq.doNotify();
        }
      }
      AppMethodBeat.o(127032);
      return 0;
      k localk = new k(paramString1);
      new k(paramString3).ag(localk);
      ae.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (params.ixf == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.g.yxI;
        if (x.wb(params.getUser())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.g.yxI;
      if (x.wb(params.getUser())) {}
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
      paramString2 = paramd.fKX;
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
    Object localObject5 = ???.gte;
    if (localObject5 == null)
    {
      ae.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, "");
    Object localObject1 = z.a(((cv)localObject5).FNH);
    Object localObject3 = z.a(((cv)localObject5).FNG);
    boolean bool1;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      ae.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ();
      if (!str1.equals(localObject3)) {
        break label374;
      }
    }
    label374:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject6).aJ((String)localObject4, ((cv)localObject5).xrk);
      ae.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((cv)localObject5).xrk), Long.valueOf(((ei)localObject4).field_msgId), Integer.valueOf(((ei)localObject4).field_flag), Long.valueOf(((ei)localObject4).field_msgSeq), ??? });
      if ((((ei)localObject4).field_msgId != 0L) && (((ei)localObject4).field_createTime + 604800000L < bl.B((String)localObject3, ((cv)localObject5).CreateTime)))
      {
        ae.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((cv)localObject5).xrk), Long.valueOf(((ei)localObject4).field_msgId) });
        bl.rW(((ei)localObject4).field_msgId);
        ((bv)localObject4).setMsgId(0L);
      }
      if (((ei)localObject4).field_msgId == 0L) {
        break label381;
      }
      ae.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((cv)localObject5).xrk) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label381:
    Object localObject6 = z.a(((cv)localObject5).FNI);
    localObject4 = new s();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((s)localObject4).dED = ((String)localObject3);
    ((s)localObject4).createTime = ((cv)localObject5).CreateTime;
    ((s)localObject4).dCd = ((cv)localObject5).xrk;
    ((s)localObject4).ixe = ((cv)localObject5).FNI.HId;
    ae.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((cv)localObject5).FNL });
    Object localObject8 = bx.M((String)localObject6, "msg");
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new bv();
    ((bv)localObject3).tk(((cv)localObject5).FNL);
    Object localObject7 = bl.BS(((cv)localObject5).FNL);
    if (localObject7 != null)
    {
      ((bv)localObject3).ur(((bl.b)localObject7).hJI);
      ((bv)localObject3).kJ(((bl.b)localObject7).hJJ);
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
        ((s)localObject4).hPI = bu.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).hKI = bu.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        ae.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).hPI), Integer.valueOf(((s)localObject4).hKI) });
        ((s)localObject4).iwS = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).aNq())) {
          ((s)localObject4).iwS = ((String)localObject1);
        }
        ((s)localObject4).dIA = ((String)((Map)localObject8).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumburl");
        j = bu.getInt((String)((Map)localObject8).get(".msg.videomsg.$cdnthumblength"), 0);
        str4 = (String)((Map)localObject8).get(".msg.videomsg.$tpvideourl");
        localObject7 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumburl");
        str2 = (String)((Map)localObject8).get(".msg.videomsg.$tpauthkey");
        str3 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumbaeskey");
        k = bu.getInt((String)((Map)localObject8).get(".msg.videomsg.$tpthumblength"), 0);
        int m = bu.getInt((String)((Map)localObject8).get(".msg.videomsg.$type"), 0);
        ae.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(m)));
        if (m == 44)
        {
          i = 1;
          ((s)localObject4).ixc = i;
          if (62 == ((cv)localObject5).urJ)
          {
            ((s)localObject4).ixf = 3;
            ((s)localObject4).a(bu.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), ""), bu.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0), bu.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), ""), bu.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), ""), bu.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), ""), bu.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), ""), bu.bI((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), ""));
            boolean bool2 = ((s)localObject4).aNq().equals((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
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
          ((s)localObject4).ixf = 2;
        } else {
          ((s)localObject4).ixf = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 216L, 1L, false);
        ae.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        ae.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bu.o(???) });
        AppMethodBeat.o(127030);
        return null;
      }
    }
    localObject8 = (String)((Map)localObject8).get(".msg.commenturl");
    Object localObject9 = bx.M((String)localObject6, "msgoperation");
    if (localObject9 != null)
    {
      ((bv)localObject3).us((String)((Map)localObject9).get(".msgoperation.expinfo.expidstr"));
      ((bv)localObject3).kI(bu.getInt((String)((Map)localObject9).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      ae.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((ei)localObject3).fmw, Integer.valueOf(((ei)localObject3).fmx) });
    }
    localObject9 = t.HI(((s)localObject4).aNq());
    ((s)localObject4).fileName = ((String)localObject9);
    ((bv)localObject3).qM(((s)localObject4).dCd);
    ((bv)localObject3).uj(((s)localObject4).getFileName());
    ((bv)localObject3).qN(bl.B(((s)localObject4).getUser(), ((s)localObject4).createTime));
    ((bv)localObject3).ui(((s)localObject4).getUser());
    ((bv)localObject3).setStatus(((cv)localObject5).nJb);
    if (bool1)
    {
      i = 1;
      ((bv)localObject3).kt(i);
      if (((cv)localObject5).urJ != 62) {
        break label1458;
      }
      ((bv)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((bv)localObject3).setContent(q.b(((s)localObject4).aNq(), 0L, false));
      ((bv)localObject3).uk((String)localObject6);
      ((bv)localObject3).uq((String)localObject8);
      ((bv)localObject3).tk(((cv)localObject5).FNL);
      bl.a((bv)localObject3, ???);
      l1 = bl.v((bv)localObject3);
      if (l1 > 0L) {
        break label1468;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 215L, 1L, false);
      ae.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).dCd) });
      AppMethodBeat.o(127030);
      return null;
      i = 0;
      break;
      label1458:
      ((bv)localObject3).setType(43);
    }
    label1468:
    ((s)localObject4).iwZ = ((int)l1);
    ((s)localObject4).iwX = bu.aRi();
    ((s)localObject4).ixa = 0;
    ((s)localObject4).status = 111;
    ae.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).hPI + " svrid:" + ((s)localObject4).dCd + " timelen:" + ((s)localObject4).hKI + " user:" + ((s)localObject4).getUser() + " human:" + ((s)localObject4).aNq());
    if (!o.aNh().b((s)localObject4))
    {
      ae.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
      AppMethodBeat.o(127030);
      return null;
    }
    o.aNh();
    localObject6 = t.HK((String)localObject9);
    ??? = z.a(((cv)localObject5).FNK);
    ae.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bu.cG(???)) });
    if (ac.iRN)
    {
      ae.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!bu.cF(???))
    {
      t.a((String)localObject6, 0, ???);
      if (((bv)localObject3).cyI())
      {
        com.tencent.mm.modelcontrol.c.aHe();
        if (((ei)localObject3).fmx != 1) {
          break label2361;
        }
        i = 1;
        label1733:
        if (i != 0)
        {
          u.HV(((ei)localObject3).field_imgPath);
          f.aGZ().hWG.add("video_" + ((ei)localObject3).field_msgId);
        }
      }
      j = 1;
      if (!x.wb(((s)localObject4).getUser())) {
        break label3067;
      }
      i = r.zC(((s)localObject4).getUser());
      if ((!x.Be(((s)localObject4).getUser())) && (x.Bd(((s)localObject4).getUser()))) {
        break label3050;
      }
      j = 2;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14388, new Object[] { Long.valueOf(((ei)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
        localObject1 = o.aNj();
        synchronized (((i)localObject1).ivO)
        {
          ((i)localObject1).ivO.offerFirst(localObject3);
          ((i)localObject1).startDownload();
          ??? = new e.b((bv)localObject3, true);
          AppMethodBeat.o(127030);
          return ???;
          if (!bu.isNullOrNil(str4))
          {
            l1 = ((s)localObject4).dCd;
            ae.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), localObject7, localObject6 });
            l2 = bu.fpO();
            ??? = (String)localObject6 + ".tmp";
            localObject1 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject1).fLl = "task_VideoMsgExtension_1";
            ((com.tencent.mm.i.g)localObject1).field_mediaId = com.tencent.mm.an.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
            ((com.tencent.mm.i.g)localObject1).field_fullpath = ???;
            ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
            ((com.tencent.mm.i.g)localObject1).field_aesKey = str3;
            ((com.tencent.mm.i.g)localObject1).field_authKey = str2;
            ((com.tencent.mm.i.g)localObject1).fLp = ((String)localObject7);
            ((com.tencent.mm.i.g)localObject1).fLm = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127028);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.ixD, this.idz, k, parama, l2, this.idC);
                AppMethodBeat.o(127028);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            f.aGZ().b((com.tencent.mm.i.g)localObject1, -1);
            break;
          }
          l1 = ((s)localObject4).dCd;
          ae.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), str1, localObject6 });
          final long l2 = bu.fpO();
          ??? = (String)localObject6 + ".tmp";
          localObject5 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject5).fLl = "task_VideoMsgExtension_2";
          ((com.tencent.mm.i.g)localObject5).field_mediaId = com.tencent.mm.an.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject5).field_fullpath = ???;
          ((com.tencent.mm.i.g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
          ((com.tencent.mm.i.g)localObject5).field_totalLen = j;
          ((com.tencent.mm.i.g)localObject5).field_aesKey = ((String)localObject1);
          ((com.tencent.mm.i.g)localObject5).field_fileId = str1;
          ((com.tencent.mm.i.g)localObject5).field_priority = com.tencent.mm.i.a.fKB;
          if (x.wb(((s)localObject4).getUser())) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject5).field_chattype = i;
            ae.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject5).field_chattype), ((s)localObject4).getUser() });
            ((com.tencent.mm.i.g)localObject5).fLm = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127029);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.ixD, str1, j, parama, l2, this.idC);
                AppMethodBeat.o(127029);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return null;
              }
            };
            f.aGZ().b((com.tencent.mm.i.g)localObject5, -1);
            break;
          }
          label2361:
          if (((ei)localObject3).fmx == 2)
          {
            i = 0;
            break label1733;
          }
          if (!com.tencent.mm.modelcontrol.c.K((bv)localObject3))
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("C2CSightNotAutoDownloadTimeRange");
          ae.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
          if (com.tencent.mm.modelcontrol.b.Fv(???))
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
            i = 0;
            break label1733;
          }
          ??? = ((ei)localObject3).field_talker;
          ae.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
          i = bu.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("SIGHTSessionAutoLoadNetwork"), 1);
          if (i == 3)
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId) });
            i = 0;
            break label1733;
          }
          if (az.isWifi(ak.getContext()))
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(???);
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).ght > 0) && (((x.wb(???)) && (((aw)localObject1).eRd == 0)) || (((an)localObject1).Pd()))) {
              break label3036;
            }
            i = 1;
            break label1733;
          }
          if (az.is2G(ak.getContext()))
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(((ei)localObject3).field_talker);
          if (x.wb(((ei)localObject3).field_talker))
          {
            if (???.eRd == 0)
            {
              ae.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
              i = 0;
              break label1733;
            }
            if (((az.is3G(ak.getContext())) || (az.is4G(ak.getContext()))) && (i == 1))
            {
              ae.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
              i = 1;
              break label1733;
            }
            ae.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
            i = 0;
            break label1733;
          }
          if (???.Pd())
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            i = 0;
            break label1733;
          }
          if (((az.is3G(ak.getContext())) || (az.is4G(ak.getContext()))) && (i == 1))
          {
            ae.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId), ((ei)localObject3).field_imgPath });
            i = 1;
            break label1733;
          }
          ae.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
          i = 0;
          break label1733;
          label3036:
          ae.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
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
    paramc = paramc.dCi;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    u.HZ(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */