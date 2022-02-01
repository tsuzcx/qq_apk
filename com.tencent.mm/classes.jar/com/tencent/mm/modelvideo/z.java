package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class z
  implements com.tencent.mm.an.h
{
  public static int a(int paramInt1, com.tencent.mm.i.d paramd, long paramLong1, w paramw, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(127032);
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramw.bqM(), paramString2, paramString1 });
      new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).bpa();
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
      Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramw.bqM(), paramString2, paramString1 });
      if (paramd != null) {
        break label853;
      }
      paramInt1 = -1;
      paramLong1 = Util.nowMilliSecond();
      i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
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
      new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).bpa();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = Util.nowMilliSecond();
        i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
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
    for (paramd = "";; paramd = paramd.iUs)
    {
      new com.tencent.mm.f.b.a.ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).bpa();
      paramd = s.bqB();
      paramString1 = paramw.getFileName();
      paramw = x.a.c.mir;
      if (!Util.isNullOrNil(paramString1))
      {
        paramString1 = paramd.XN(paramString1);
        if (paramString1 != null)
        {
          paramw = new x.a.a(paramString1.getFileName(), x.a.b.mip, paramw, paramString1.mhX, paramString1.mga);
          paramd.lAD.event(paramw);
          paramd.lAD.doNotify();
        }
      }
      AppMethodBeat.o(127032);
      return 0;
      q localq = new q(paramString1);
      new q(paramString3).aj(localq);
      Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), paramw.bqM(), paramString2, paramString1 });
      if (paramw.mhX == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.h.IzE;
        if (ab.Lj(paramw.bqM())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.h.IzE;
      if (ab.Lj(paramw.bqM())) {}
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
      paramString2 = paramd.iUs;
      break label248;
      label879:
      paramInt1 = paramd.field_retCode;
      break label392;
      label887:
      paramString1 = paramd.field_transInfo;
      break label417;
    }
  }
  
  public final h.b b(h.a arg1)
  {
    AppMethodBeat.i(127030);
    Object localObject5 = ???.jQG;
    if (localObject5 == null)
    {
      Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
    Object localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject5).RIE);
    Object localObject3 = com.tencent.mm.platformtools.z.a(((db)localObject5).RID);
    boolean bool1;
    if ((((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      Log.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe();
      if (!str1.equals(localObject3)) {
        break label374;
      }
    }
    label374:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((i)localObject6).aL((String)localObject4, ((db)localObject5).HlH);
      Log.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((db)localObject5).HlH), Long.valueOf(((et)localObject4).field_msgId), Integer.valueOf(((et)localObject4).field_flag), Long.valueOf(((et)localObject4).field_msgSeq), ??? });
      if ((((et)localObject4).field_msgId != 0L) && (((et)localObject4).field_createTime + 604800000L < bq.z((String)localObject3, ((db)localObject5).CreateTime)))
      {
        Log.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((db)localObject5).HlH), Long.valueOf(((et)localObject4).field_msgId) });
        bq.Gk(((et)localObject4).field_msgId);
        ((ca)localObject4).setMsgId(0L);
      }
      if (((et)localObject4).field_msgId == 0L) {
        break label381;
      }
      Log.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((db)localObject5).HlH) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label381:
    Object localObject6 = com.tencent.mm.platformtools.z.a(((db)localObject5).RIF);
    localObject4 = new w();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((w)localObject4).fPV = ((String)localObject3);
    ((w)localObject4).createTime = ((db)localObject5).CreateTime;
    ((w)localObject4).fNu = ((db)localObject5).HlH;
    ((w)localObject4).mhW = ((db)localObject5).RIF.Ufy;
    Log.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((db)localObject5).RII });
    Object localObject8 = XmlParser.parseXml((String)localObject6, "msg", null);
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new ca();
    ((ca)localObject3).Ip(((db)localObject5).RII);
    Object localObject7 = bq.RR(((db)localObject5).RII);
    if (localObject7 != null)
    {
      ((ca)localObject3).Jv(((bq.b)localObject7).lut);
      ((ca)localObject3).qb(((bq.b)localObject7).luu);
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
        ((w)localObject4).lAW = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((w)localObject4).lvw = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        Log.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((w)localObject4).lAW), Integer.valueOf(((w)localObject4).lvw) });
        ((w)localObject4).mhK = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((w)localObject4).bqK())) {
          ((w)localObject4).mhK = ((String)localObject1);
        }
        ((w)localObject4).fUk = ((String)((Map)localObject8).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject8).get(".msg.videomsg.$cdnthumburl");
        j = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$cdnthumblength"), 0);
        str4 = (String)((Map)localObject8).get(".msg.videomsg.$tpvideourl");
        localObject7 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumburl");
        str2 = (String)((Map)localObject8).get(".msg.videomsg.$tpauthkey");
        str3 = (String)((Map)localObject8).get(".msg.videomsg.$tpthumbaeskey");
        k = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$tpthumblength"), 0);
        int m = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(m)));
        if (m == 44)
        {
          i = 1;
          ((w)localObject4).mhU = i;
          if (62 == ((db)localObject5).COi)
          {
            ((w)localObject4).mhX = 3;
            ((w)localObject4).a(Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), ""), Util.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), ""));
            boolean bool2 = ((w)localObject4).bqK().equals((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
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
          ((w)localObject4).mhX = 2;
        } else {
          ((w)localObject4).mhX = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 216L, 1L, false);
        Log.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        Log.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(???) });
        AppMethodBeat.o(127030);
        return null;
      }
    }
    localObject8 = (String)((Map)localObject8).get(".msg.commenturl");
    Object localObject9 = XmlParser.parseXml((String)localObject6, "msgoperation", null);
    if (localObject9 != null)
    {
      ((ca)localObject3).Jw((String)((Map)localObject9).get(".msgoperation.expinfo.expidstr"));
      ((ca)localObject3).qa(Util.getInt((String)((Map)localObject9).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      Log.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((et)localObject3).ilq, Integer.valueOf(((et)localObject3).ilr) });
    }
    localObject9 = x.XS(((w)localObject4).bqK());
    ((w)localObject4).fileName = ((String)localObject9);
    ((ca)localObject3).EG(((w)localObject4).fNu);
    ((ca)localObject3).Jn(((w)localObject4).getFileName());
    ((ca)localObject3).setCreateTime(bq.z(((w)localObject4).bqM(), ((w)localObject4).createTime));
    ((ca)localObject3).Jm(((w)localObject4).bqM());
    ((ca)localObject3).setStatus(((db)localObject5).rVU);
    if (bool1)
    {
      i = 1;
      ((ca)localObject3).pJ(i);
      if (((db)localObject5).COi != 62) {
        break label1460;
      }
      ((ca)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((ca)localObject3).setContent(u.a(((w)localObject4).bqK(), 0L, false));
      ((ca)localObject3).Jo((String)localObject6);
      ((ca)localObject3).Ju((String)localObject8);
      ((ca)localObject3).Ip(((db)localObject5).RII);
      bq.a((ca)localObject3, ???);
      l1 = bq.z((ca)localObject3);
      if (l1 > 0L) {
        break label1470;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 215L, 1L, false);
      Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((w)localObject4).fNu) });
      AppMethodBeat.o(127030);
      return null;
      i = 0;
      break;
      label1460:
      ((ca)localObject3).setType(43);
    }
    label1470:
    ((w)localObject4).mhR = ((int)l1);
    ((w)localObject4).mhP = Util.nowSecond();
    ((w)localObject4).mhS = 0;
    ((w)localObject4).status = 111;
    Log.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((w)localObject4).getFileName() + "] size:" + ((w)localObject4).lAW + " svrid:" + ((w)localObject4).fNu + " timelen:" + ((w)localObject4).lvw + " user:" + ((w)localObject4).bqM() + " human:" + ((w)localObject4).bqK());
    if (!s.bqB().b((w)localObject4))
    {
      Log.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((w)localObject4).getFileName());
      AppMethodBeat.o(127030);
      return null;
    }
    s.bqB();
    localObject6 = x.XU((String)localObject9);
    ??? = com.tencent.mm.platformtools.z.a(((db)localObject5).RIH);
    Log.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(Util.getLength(???)) });
    if (com.tencent.mm.platformtools.ac.mFS)
    {
      Log.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!Util.isNullOrNil(???)) {
      x.a((String)localObject6, 0, ???);
    }
    for (;;)
    {
      if (((ca)localObject3).dlT())
      {
        com.tencent.mm.modelcontrol.d.bkm();
        if (((et)localObject3).ilr != 1) {
          break label2363;
        }
        i = 1;
        label1735:
        if (i != 0)
        {
          y.Yf(((et)localObject3).field_imgPath);
          com.tencent.mm.aq.f.bkg().lHW.add("video_" + ((et)localObject3).field_msgId);
        }
      }
      j = 1;
      if (ab.Lj(((w)localObject4).bqM()))
      {
        i = v.Pu(((w)localObject4).bqM());
        if ((ab.Rc(((w)localObject4).bqM())) || (!ab.Rb(((w)localObject4).bqM())))
        {
          j = 2;
          com.tencent.mm.plugin.report.service.h.IzE.a(14388, new Object[] { Long.valueOf(((et)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
          localObject1 = s.bqD();
        }
      }
      synchronized (((m)localObject1).mgD)
      {
        ((m)localObject1).mgD.offerFirst(localObject3);
        ((m)localObject1).startDownload();
        ??? = new h.b((ca)localObject3, true);
        AppMethodBeat.o(127030);
        return ???;
        if (!Util.isNullOrNil(str4))
        {
          l1 = ((w)localObject4).fNu;
          Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((w)localObject4).bqM(), localObject7, localObject6 });
          l2 = Util.nowMilliSecond();
          ??? = (String)localObject6 + ".tmp";
          localObject1 = new g();
          ((g)localObject1).taskName = "task_VideoMsgExtension_1";
          ((g)localObject1).field_mediaId = com.tencent.mm.aq.c.a("downvideothumb", ((w)localObject4).createTime, ((w)localObject4).bqM(), String.valueOf(l1));
          ((g)localObject1).field_fullpath = ???;
          ((g)localObject1).field_fileType = 19;
          ((g)localObject1).field_aesKey = str3;
          ((g)localObject1).field_authKey = str2;
          ((g)localObject1).iUJ = ((String)localObject7);
          ((g)localObject1).iUG = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(127028);
              paramAnonymousInt = z.a(paramAnonymousInt, paramAnonymousd, l1, this.miw, this.lOQ, k, parama, l2, this.val$startTime);
              AppMethodBeat.o(127028);
              return paramAnonymousInt;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          com.tencent.mm.aq.f.bkg().b((g)localObject1, -1);
          continue;
        }
        l1 = ((w)localObject4).fNu;
        Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((w)localObject4).bqM(), str1, localObject6 });
        final long l2 = Util.nowMilliSecond();
        ??? = (String)localObject6 + ".tmp";
        localObject5 = new g();
        ((g)localObject5).taskName = "task_VideoMsgExtension_2";
        ((g)localObject5).field_mediaId = com.tencent.mm.aq.c.a("downvideothumb", ((w)localObject4).createTime, ((w)localObject4).bqM(), String.valueOf(l1));
        ((g)localObject5).field_fullpath = ???;
        ((g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((g)localObject5).field_totalLen = j;
        ((g)localObject5).field_aesKey = ((String)localObject1);
        ((g)localObject5).field_fileId = str1;
        ((g)localObject5).field_priority = com.tencent.mm.i.a.iTV;
        if (ab.Lj(((w)localObject4).bqM())) {}
        for (i = 1;; i = 0)
        {
          ((g)localObject5).field_chattype = i;
          Log.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((g)localObject5).field_chattype), ((w)localObject4).bqM() });
          ((g)localObject5).iUG = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(127029);
              paramAnonymousInt = z.a(paramAnonymousInt, paramAnonymousd, l1, this.miw, str1, j, parama, l2, this.val$startTime);
              AppMethodBeat.o(127029);
              return paramAnonymousInt;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return null;
            }
          };
          com.tencent.mm.aq.f.bkg().b((g)localObject5, -1);
          break;
        }
        label2363:
        if (((et)localObject3).ilr == 2)
        {
          i = 0;
          break label1735;
        }
        if (!com.tencent.mm.modelcontrol.d.Z((ca)localObject3))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
          i = 0;
          break label1735;
        }
        ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("C2CSightNotAutoDownloadTimeRange");
        Log.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
        if (com.tencent.mm.modelcontrol.b.VC(???))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
          i = 0;
          break label1735;
        }
        ??? = ((et)localObject3).field_talker;
        Log.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
        i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("SIGHTSessionAutoLoadNetwork"), 1);
        if (i == 3)
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId) });
          i = 0;
          break label1735;
        }
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId), ((et)localObject3).field_imgPath });
          localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(???);
          if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).jxt > 0) && (((ab.Lj(???)) && (((ax)localObject1).hDj == 0)) || (((as)localObject1).aeg()))) {
            break label3038;
          }
          i = 1;
          break label1735;
        }
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId), ((et)localObject3).field_imgPath });
          i = 0;
          break label1735;
        }
        ??? = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(((et)localObject3).field_talker);
        if (ab.Lj(((et)localObject3).field_talker))
        {
          if (???.hDj == 0)
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId), ((et)localObject3).field_imgPath });
            i = 0;
            break label1735;
          }
          if (((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))) && (i == 1))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId), ((et)localObject3).field_imgPath });
            i = 1;
            break label1735;
          }
          Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
          i = 0;
          break label1735;
        }
        if (???.aeg())
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId), ((et)localObject3).field_imgPath });
          i = 0;
          break label1735;
        }
        if (((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))) && (i == 1))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId), ((et)localObject3).field_imgPath });
          i = 1;
          break label1735;
        }
        Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
        i = 0;
        break label1735;
        label3038:
        Log.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
        i = 0;
        break label1735;
        j = 3;
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(127031);
    paramc = paramc.fNz;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    y.Yj(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.z
 * JD-Core Version:    0.7.0.1
 */