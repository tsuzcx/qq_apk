package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
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
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class v
  implements com.tencent.mm.ak.h
{
  public static int a(int paramInt1, com.tencent.mm.i.d paramd, long paramLong1, s params, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(127032);
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" })).bfK();
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
      Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (paramd != null) {
        break label853;
      }
      paramInt1 = -1;
      paramLong1 = Util.nowMilliSecond();
      i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
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
      new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramString2 })).bfK();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label879;
        }
        paramInt1 = -1;
        label392:
        paramLong1 = Util.nowMilliSecond();
        i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
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
    for (paramd = "";; paramd = paramd.gqk)
    {
      new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString1, "", "", "", "", "", "", "", paramd })).bfK();
      paramd = o.bhj();
      paramString1 = params.getFileName();
      params = t.a.c.jsN;
      if (!Util.isNullOrNil(paramString1))
      {
        paramString1 = paramd.Qq(paramString1);
        if (paramString1 != null)
        {
          params = new t.a.a(paramString1.getFileName(), t.a.b.jsL, params, paramString1.jsu, paramString1.jqz);
          paramd.iKx.event(params);
          paramd.iKx.doNotify();
        }
      }
      AppMethodBeat.o(127032);
      return 0;
      com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(paramString1);
      new com.tencent.mm.vfs.o(paramString3).am(localo);
      Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong1), params.getUser(), paramString2, paramString1 });
      if (params.jsu == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 6L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 7L, 1L, false);
        paramString1 = com.tencent.mm.plugin.report.service.h.CyF;
        if (ab.Eq(params.getUser())) {}
        for (paramLong1 = 9L;; paramLong1 = 8L)
        {
          paramString1.idkeyStat(198L, paramLong1, 1L, false);
          break;
        }
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 11L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 12L, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.service.h.CyF;
      if (ab.Eq(params.getUser())) {}
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
      paramString2 = paramd.gqk;
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
    Object localObject5 = ???.heO;
    if (localObject5 == null)
    {
      Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
    Object localObject1 = z.a(((de)localObject5).KHm);
    Object localObject3 = z.a(((de)localObject5).KHl);
    boolean bool1;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      Log.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy();
      if (!str1.equals(localObject3)) {
        break label374;
      }
    }
    label374:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject6).aJ((String)localObject4, ((de)localObject5).Brn);
      Log.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((de)localObject5).Brn), Long.valueOf(((eo)localObject4).field_msgId), Integer.valueOf(((eo)localObject4).field_flag), Long.valueOf(((eo)localObject4).field_msgSeq), ??? });
      if ((((eo)localObject4).field_msgId != 0L) && (((eo)localObject4).field_createTime + 604800000L < bp.C((String)localObject3, ((de)localObject5).CreateTime)))
      {
        Log.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((de)localObject5).Brn), Long.valueOf(((eo)localObject4).field_msgId) });
        bp.Ad(((eo)localObject4).field_msgId);
        ((ca)localObject4).setMsgId(0L);
      }
      if (((eo)localObject4).field_msgId == 0L) {
        break label381;
      }
      Log.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((de)localObject5).Brn) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label381:
    Object localObject6 = z.a(((de)localObject5).KHn);
    localObject4 = new s();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((s)localObject4).dWq = ((String)localObject3);
    ((s)localObject4).createTime = ((de)localObject5).CreateTime;
    ((s)localObject4).dTS = ((de)localObject5).Brn;
    ((s)localObject4).jst = ((de)localObject5).KHn.MTo;
    Log.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((de)localObject5).KHq });
    Object localObject8 = XmlParser.parseXml((String)localObject6, "msg", null);
    if (localObject8 == null)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new ca();
    ((ca)localObject3).BB(((de)localObject5).KHq);
    Object localObject7 = bp.Ky(((de)localObject5).KHq);
    if (localObject7 != null)
    {
      ((ca)localObject3).CH(((bp.b)localObject7).iEs);
      ((ca)localObject3).nM(((bp.b)localObject7).iEt);
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
        ((s)localObject4).iKP = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$length"), 0);
        ((s)localObject4).iFw = Util.getInt((String)((Map)localObject8).get(".msg.videomsg.$playlength"), 0);
        Log.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((s)localObject4).iKP), Integer.valueOf(((s)localObject4).iFw) });
        ((s)localObject4).jsh = ((String)((Map)localObject8).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((s)localObject4).bhs())) {
          ((s)localObject4).jsh = ((String)localObject1);
        }
        ((s)localObject4).ean = ((String)((Map)localObject8).get(".msg.statextstr"));
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
          ((s)localObject4).jsr = i;
          if (62 == ((de)localObject5).xKb)
          {
            ((s)localObject4).jsu = 3;
            ((s)localObject4).a(Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideourl"), ""), Util.getInt((String)((Map)localObject8).get(".msg.streamvideo.streamvideototaltime"), 0), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideotitle"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideowording"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideoweburl"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideoaduxinfo"), ""), Util.nullAs((String)((Map)localObject8).get(".msg.streamvideo.streamvideopublishid"), ""));
            boolean bool2 = ((s)localObject4).bhs().equals((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, ""));
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
          ((s)localObject4).jsu = 2;
        } else {
          ((s)localObject4).jsu = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 216L, 1L, false);
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
      ((ca)localObject3).CI((String)((Map)localObject9).get(".msgoperation.expinfo.expidstr"));
      ((ca)localObject3).nL(Util.getInt((String)((Map)localObject9).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      Log.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((eo)localObject3).fRa, Integer.valueOf(((eo)localObject3).fRb) });
    }
    localObject9 = t.Qv(((s)localObject4).bhs());
    ((s)localObject4).fileName = ((String)localObject9);
    ((ca)localObject3).yF(((s)localObject4).dTS);
    ((ca)localObject3).Cz(((s)localObject4).getFileName());
    ((ca)localObject3).setCreateTime(bp.C(((s)localObject4).getUser(), ((s)localObject4).createTime));
    ((ca)localObject3).Cy(((s)localObject4).getUser());
    ((ca)localObject3).setStatus(((de)localObject5).oTW);
    if (bool1)
    {
      i = 1;
      ((ca)localObject3).nv(i);
      if (((de)localObject5).xKb != 62) {
        break label1460;
      }
      ((ca)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((ca)localObject3).setContent(q.b(((s)localObject4).bhs(), 0L, false));
      ((ca)localObject3).CA((String)localObject6);
      ((ca)localObject3).CG((String)localObject8);
      ((ca)localObject3).BB(((de)localObject5).KHq);
      bp.a((ca)localObject3, ???);
      l1 = bp.x((ca)localObject3);
      if (l1 > 0L) {
        break label1470;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 215L, 1L, false);
      Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((s)localObject4).dTS) });
      AppMethodBeat.o(127030);
      return null;
      i = 0;
      break;
      label1460:
      ((ca)localObject3).setType(43);
    }
    label1470:
    ((s)localObject4).jso = ((int)l1);
    ((s)localObject4).jsm = Util.nowSecond();
    ((s)localObject4).jsp = 0;
    ((s)localObject4).status = 111;
    Log.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((s)localObject4).getFileName() + "] size:" + ((s)localObject4).iKP + " svrid:" + ((s)localObject4).dTS + " timelen:" + ((s)localObject4).iFw + " user:" + ((s)localObject4).getUser() + " human:" + ((s)localObject4).bhs());
    if (!o.bhj().b((s)localObject4))
    {
      Log.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((s)localObject4).getFileName());
      AppMethodBeat.o(127030);
      return null;
    }
    o.bhj();
    localObject6 = t.Qx((String)localObject9);
    ??? = z.a(((de)localObject5).KHp);
    Log.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(Util.getLength(???)) });
    if (ac.jOI)
    {
      Log.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!Util.isNullOrNil(???))
    {
      t.a((String)localObject6, 0, ???);
      if (((ca)localObject3).cWL())
      {
        com.tencent.mm.modelcontrol.d.baW();
        if (((eo)localObject3).fRb != 1) {
          break label2363;
        }
        i = 1;
        label1735:
        if (i != 0)
        {
          u.QI(((eo)localObject3).field_imgPath);
          com.tencent.mm.an.f.baQ().iRE.add("video_" + ((eo)localObject3).field_msgId);
        }
      }
      j = 1;
      if (!ab.Eq(((s)localObject4).getUser())) {
        break label3069;
      }
      i = com.tencent.mm.model.v.Ie(((s)localObject4).getUser());
      if ((!ab.JJ(((s)localObject4).getUser())) && (ab.JI(((s)localObject4).getUser()))) {
        break label3052;
      }
      j = 2;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14388, new Object[] { Long.valueOf(((eo)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
        localObject1 = o.bhl();
        synchronized (((i)localObject1).jra)
        {
          ((i)localObject1).jra.offerFirst(localObject3);
          ((i)localObject1).startDownload();
          ??? = new h.b((ca)localObject3, true);
          AppMethodBeat.o(127030);
          return ???;
          if (!Util.isNullOrNil(str4))
          {
            l1 = ((s)localObject4).dTS;
            Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), localObject7, localObject6 });
            l2 = Util.nowMilliSecond();
            ??? = (String)localObject6 + ".tmp";
            localObject1 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject1).taskName = "task_VideoMsgExtension_1";
            ((com.tencent.mm.i.g)localObject1).field_mediaId = com.tencent.mm.an.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
            ((com.tencent.mm.i.g)localObject1).field_fullpath = ???;
            ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
            ((com.tencent.mm.i.g)localObject1).field_aesKey = str3;
            ((com.tencent.mm.i.g)localObject1).field_authKey = str2;
            ((com.tencent.mm.i.g)localObject1).gqB = ((String)localObject7);
            ((com.tencent.mm.i.g)localObject1).gqy = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127028);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.jsS, this.iYw, k, parama, l2, this.val$startTime);
                AppMethodBeat.o(127028);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            com.tencent.mm.an.f.baQ().b((com.tencent.mm.i.g)localObject1, -1);
            break;
          }
          l1 = ((s)localObject4).dTS;
          Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((s)localObject4).getUser(), str1, localObject6 });
          final long l2 = Util.nowMilliSecond();
          ??? = (String)localObject6 + ".tmp";
          localObject5 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject5).taskName = "task_VideoMsgExtension_2";
          ((com.tencent.mm.i.g)localObject5).field_mediaId = com.tencent.mm.an.c.a("downvideothumb", ((s)localObject4).createTime, ((s)localObject4).getUser(), String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject5).field_fullpath = ???;
          ((com.tencent.mm.i.g)localObject5).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
          ((com.tencent.mm.i.g)localObject5).field_totalLen = j;
          ((com.tencent.mm.i.g)localObject5).field_aesKey = ((String)localObject1);
          ((com.tencent.mm.i.g)localObject5).field_fileId = str1;
          ((com.tencent.mm.i.g)localObject5).field_priority = com.tencent.mm.i.a.gpN;
          if (ab.Eq(((s)localObject4).getUser())) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject5).field_chattype = i;
            Log.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject5).field_chattype), ((s)localObject4).getUser() });
            ((com.tencent.mm.i.g)localObject5).gqy = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(127029);
                paramAnonymousInt = v.a(paramAnonymousInt, paramAnonymousd, l1, this.jsS, str1, j, parama, l2, this.val$startTime);
                AppMethodBeat.o(127029);
                return paramAnonymousInt;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return null;
              }
            };
            com.tencent.mm.an.f.baQ().b((com.tencent.mm.i.g)localObject5, -1);
            break;
          }
          label2363:
          if (((eo)localObject3).fRb == 2)
          {
            i = 0;
            break label1735;
          }
          if (!com.tencent.mm.modelcontrol.d.T((ca)localObject3))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
            i = 0;
            break label1735;
          }
          ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("C2CSightNotAutoDownloadTimeRange");
          Log.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(???)));
          if (com.tencent.mm.modelcontrol.b.Of(???))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
            i = 0;
            break label1735;
          }
          ??? = ((eo)localObject3).field_talker;
          Log.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(???)));
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SIGHTSessionAutoLoadNetwork"), 1);
          if (i == 3)
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId) });
            i = 0;
            break label1735;
          }
          if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId), ((eo)localObject3).field_imgPath });
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(???);
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).gMZ > 0) && (((ab.Eq(???)) && (((ax)localObject1).fuH == 0)) || (((as)localObject1).Zx()))) {
              break label3038;
            }
            i = 1;
            break label1735;
          }
          if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId), ((eo)localObject3).field_imgPath });
            i = 0;
            break label1735;
          }
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((eo)localObject3).field_talker);
          if (ab.Eq(((eo)localObject3).field_talker))
          {
            if (???.fuH == 0)
            {
              Log.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId), ((eo)localObject3).field_imgPath });
              i = 0;
              break label1735;
            }
            if (((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))) && (i == 1))
            {
              Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId), ((eo)localObject3).field_imgPath });
              i = 1;
              break label1735;
            }
            Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
            i = 0;
            break label1735;
          }
          if (???.Zx())
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId), ((eo)localObject3).field_imgPath });
            i = 0;
            break label1735;
          }
          if (((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))) && (i == 1))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId), ((eo)localObject3).field_imgPath });
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
          label3052:
          j = 3;
        }
      }
      label3069:
      i = 0;
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(127031);
    paramc = paramc.dTX;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    u.QM(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */