package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.c;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;

public final class ac
  implements com.tencent.mm.am.g
{
  public static int a(int paramInt1, com.tencent.mm.g.d paramd, long paramLong, z paramz, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(241200);
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramz.bOs(), paramString2, paramString1 });
      AppMethodBeat.o(241200);
      return paramInt1;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(241200);
      return 0;
    }
    if (paramd.field_retCode != 0)
    {
      Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong), paramz.bOs(), paramString2, paramString1 });
      paramd = v.bOh();
      paramString1 = paramz.getFileName();
      paramz = aa.a.c.pbG;
      if (!Util.isNullOrNil(paramString1))
      {
        paramString1 = paramd.PR(paramString1);
        if (paramString1 != null)
        {
          paramz = new aa.a.a(paramString1.getFileName(), aa.a.b.pbE, paramz, paramString1.pbi, paramString1.oYW);
          paramd.ose.event(paramz);
          paramd.ose.doNotify();
        }
      }
      AppMethodBeat.o(241200);
      return 0;
    }
    paramd = new u(paramString1);
    new u(paramString3).am(paramd);
    Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(paramLong), paramz.bOs(), paramString2, paramString1 });
    if (paramz.pbi == 3)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 6L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 7L, 1L, false);
      paramd = com.tencent.mm.plugin.report.service.h.OAn;
      if (au.bwE(paramz.bOs())) {}
      for (paramLong = 9L;; paramLong = 8L)
      {
        paramd.idkeyStat(198L, paramLong, 1L, false);
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 11L, paramInt2, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 12L, 1L, false);
    paramd = com.tencent.mm.plugin.report.service.h.OAn;
    if (au.bwE(paramz.bOs())) {}
    for (paramLong = 14L;; paramLong = 13L)
    {
      paramd.idkeyStat(198L, paramLong, 1L, false);
      break;
    }
  }
  
  public final g.b b(final com.tencent.mm.am.g.a parama)
  {
    AppMethodBeat.i(127030);
    dl localdl = parama.mpN;
    if (localdl == null)
    {
      Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(127030);
      return null;
    }
    String str1 = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
    Object localObject1 = w.a(localdl.YFF);
    Object localObject2 = w.a(localdl.YFE);
    boolean bool1;
    if ((((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().has((String)localObject2)) || (str1.equals(localObject2)))
    {
      bool1 = true;
      Log.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject2, localObject1, str1, Boolean.valueOf(bool1) });
      localObject4 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ();
      if (!str1.equals(localObject2)) {
        break label381;
      }
    }
    label381:
    for (Object localObject3 = localObject1;; localObject3 = localObject2)
    {
      localObject3 = ((i)localObject4).aU((String)localObject3, localdl.Njv);
      Log.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(((fi)localObject3).field_msgId), Integer.valueOf(((fi)localObject3).field_flag), Long.valueOf(((fi)localObject3).field_msgSeq), parama });
      if ((localObject3 != null) && (((fi)localObject3).field_msgId != 0L) && (((cc)localObject3).getCreateTime() + 604800000L < br.D((String)localObject2, localdl.CreateTime)))
      {
        Log.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(((fi)localObject3).field_msgId) });
        br.iu(((fi)localObject3).field_msgId);
        ((cc)localObject3).setMsgId(0L);
      }
      if ((localObject3 == null) || (((fi)localObject3).field_msgId == 0L)) {
        break label388;
      }
      Log.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(localdl.Njv) });
      AppMethodBeat.o(127030);
      return null;
      bool1 = false;
      break;
    }
    label388:
    String str2 = w.a(localdl.YFG);
    Object localObject4 = new z();
    if (bool1) {}
    Object localObject6;
    for (localObject3 = localObject1;; localObject3 = localObject2)
    {
      ((z)localObject4).hVQ = ((String)localObject3);
      ((z)localObject4).createTime = localdl.CreateTime;
      ((z)localObject4).hTh = localdl.Njv;
      ((z)localObject4).pbh = localdl.YFG.abwM;
      Log.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { str2, localdl.YFJ });
      localObject6 = XmlParser.parseXml(str2, "msg", null);
      if (localObject6 != null) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 216L, 1L, false);
      AppMethodBeat.o(127030);
      return null;
    }
    localObject3 = new cc();
    ((cc)localObject3).AU(localdl.YFJ);
    Object localObject5 = br.JP(localdl.YFJ);
    if (localObject5 != null)
    {
      ((cc)localObject3).Cb(((br.b)localObject5).olS);
      ((cc)localObject3).qb(((br.b)localObject5).olT);
    }
    localObject5 = ae.pbN;
    localObject5 = ae.a.Qv(str2);
    if (localObject5 != null) {}
    for (final long l1 = ((ae)localObject5).nVD;; l1 = 0L)
    {
      final String str3;
      final int j;
      String str7;
      final String str4;
      String str5;
      String str6;
      final int k;
      int i;
      for (;;)
      {
        try
        {
          ((z)localObject4).osy = Util.getInt((String)((Map)localObject6).get(".msg.videomsg.$length"), 0);
          ((z)localObject4).omT = Util.getInt((String)((Map)localObject6).get(".msg.videomsg.$playlength"), 0);
          Log.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((z)localObject4).osy), Integer.valueOf(((z)localObject4).omT) });
          ((z)localObject4).paV = ((String)((Map)localObject6).get(".msg.videomsg.$fromusername"));
          if (str1.equals(((z)localObject4).bOq())) {
            ((z)localObject4).paV = ((String)localObject1);
          }
          ((z)localObject4).iah = ((String)((Map)localObject6).get(".msg.statextstr"));
          localObject5 = (String)((Map)localObject6).get(".msg.videomsg.$cdnthumbaeskey");
          str3 = (String)((Map)localObject6).get(".msg.videomsg.$cdnthumburl");
          j = Util.getInt((String)((Map)localObject6).get(".msg.videomsg.$cdnthumblength"), 0);
          str7 = (String)((Map)localObject6).get(".msg.videomsg.$tpvideourl");
          str4 = (String)((Map)localObject6).get(".msg.videomsg.$tpthumburl");
          str5 = (String)((Map)localObject6).get(".msg.videomsg.$tpauthkey");
          str6 = (String)((Map)localObject6).get(".msg.videomsg.$tpthumbaeskey");
          k = Util.getInt((String)((Map)localObject6).get(".msg.videomsg.$tpthumblength"), 0);
          int m = Util.getInt((String)((Map)localObject6).get(".msg.videomsg.$type"), 0);
          Log.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(m)));
          if (m == 44)
          {
            i = 1;
            ((z)localObject4).pbf = i;
            if (62 == localdl.IIs)
            {
              ((z)localObject4).pbi = 3;
              ((z)localObject4).a(Util.nullAs((String)((Map)localObject6).get(".msg.streamvideo.streamvideourl"), ""), Util.getInt((String)((Map)localObject6).get(".msg.streamvideo.streamvideototaltime"), 0), Util.nullAs((String)((Map)localObject6).get(".msg.streamvideo.streamvideotitle"), ""), Util.nullAs((String)((Map)localObject6).get(".msg.streamvideo.streamvideowording"), ""), Util.nullAs((String)((Map)localObject6).get(".msg.streamvideo.streamvideoweburl"), ""), Util.nullAs((String)((Map)localObject6).get(".msg.streamvideo.streamvideoaduxinfo"), ""), Util.nullAs((String)((Map)localObject6).get(".msg.streamvideo.streamvideopublishid"), ""));
              boolean bool2 = ((z)localObject4).bOq().equals((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
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
            ((z)localObject4).pbi = 2;
          } else {
            ((z)localObject4).pbi = 1;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 216L, 1L, false);
          Log.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
          Log.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
          AppMethodBeat.o(127030);
          return null;
        }
      }
      localObject6 = (String)((Map)localObject6).get(".msg.commenturl");
      Object localObject7 = XmlParser.parseXml(str2, "msgoperation", null);
      if (localObject7 != null)
      {
        ((cc)localObject3).Cc((String)((Map)localObject7).get(".msgoperation.expinfo.expidstr"));
        ((cc)localObject3).qa(Util.getInt((String)((Map)localObject7).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
        Log.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((fi)localObject3).kLp, Integer.valueOf(((fi)localObject3).kLq) });
      }
      localObject7 = aa.PW(((z)localObject4).bOq());
      ((z)localObject4).fileName = ((String)localObject7);
      ((cc)localObject3).gX(((z)localObject4).hTh);
      ((cc)localObject3).BT(((z)localObject4).getFileName());
      ((cc)localObject3).setCreateTime(br.D(((z)localObject4).bOs(), ((z)localObject4).createTime));
      ((cc)localObject3).BS(((z)localObject4).bOs());
      ((cc)localObject3).setStatus(localdl.vhk);
      if (bool1)
      {
        i = 1;
        ((cc)localObject3).pI(i);
        if (localdl.IIs != 62) {
          break label1548;
        }
        ((cc)localObject3).setType(62);
        label1382:
        ((cc)localObject3).setContent(x.a(((z)localObject4).bOq(), 0L, false));
        ((cc)localObject3).BU(str2);
        ((cc)localObject3).Ca((String)localObject6);
        ((cc)localObject3).AU(localdl.YFJ);
        br.a((cc)localObject3, parama);
        if (l1 == 0L) {
          break label1565;
        }
        parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ();
        if (!str1.equals(localObject2)) {
          break label1558;
        }
      }
      for (;;)
      {
        parama = parama.aU((String)localObject1, l1);
        if (parama != null)
        {
          parama.BU(str2);
          parama.gX(((z)localObject4).hTh);
          localObject1 = ab.Qo(parama.field_imgPath);
          if (localObject1 != null)
          {
            ((z)localObject1).pbh = str2;
            ((z)localObject1).hTh = ((z)localObject4).hTh;
            ab.f((z)localObject1);
            br.C(parama);
            v.bOj().au(parama);
          }
        }
        AppMethodBeat.o(127030);
        return null;
        i = 0;
        break;
        label1548:
        ((cc)localObject3).setType(43);
        break label1382;
        label1558:
        localObject1 = localObject2;
      }
      label1565:
      l1 = br.B((cc)localObject3);
      if (l1 <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 215L, 1L, false);
        Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((z)localObject4).hTh) });
        AppMethodBeat.o(127030);
        return null;
      }
      ((z)localObject4).pbc = ((int)l1);
      ((z)localObject4).pba = Util.nowSecond();
      ((z)localObject4).pbd = 0;
      ((z)localObject4).status = 111;
      Log.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((z)localObject4).getFileName() + "] size:" + ((z)localObject4).osy + " svrid:" + ((z)localObject4).hTh + " timelen:" + ((z)localObject4).omT + " user:" + ((z)localObject4).bOs() + " human:" + ((z)localObject4).bOq());
      if (!v.bOh().b((z)localObject4))
      {
        Log.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((z)localObject4).getFileName());
        AppMethodBeat.o(127030);
        return null;
      }
      v.bOh();
      localObject1 = aa.PY((String)localObject7);
      parama = w.a(localdl.YFI);
      Log.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(Util.getLength(parama)) });
      if (com.tencent.mm.platformtools.z.pCs)
      {
        Log.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
        parama = null;
      }
      if (!Util.isNullOrNil(parama))
      {
        aa.a((String)localObject1, 0, parama);
        if (((cc)localObject3).dSJ())
        {
          com.tencent.mm.modelcontrol.d.bId();
          if (((fi)localObject3).kLq != 1) {
            break label2501;
          }
          i = 1;
          label1896:
          if (i != 0)
          {
            ab.Qj(((fi)localObject3).field_imgPath);
            k.bHW().oAv.add("video_" + ((fi)localObject3).field_msgId);
          }
        }
        j = 1;
        if (!au.bwE(((z)localObject4).bOs())) {
          break label3193;
        }
        i = com.tencent.mm.model.v.getMembersCountByChatRoomName(((z)localObject4).bOs());
        if ((!com.tencent.mm.model.ab.Ja(((z)localObject4).bOs())) && (com.tencent.mm.model.ab.IZ(((z)localObject4).bOs()))) {
          break label3188;
        }
        j = 2;
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(14388, new Object[] { Long.valueOf(((fi)localObject3).field_msgSvrId), Integer.valueOf(j), "", Integer.valueOf(i) });
        v.bOj().au((cc)localObject3);
        parama = new g.b((cc)localObject3, true);
        AppMethodBeat.o(127030);
        return parama;
        if (!Util.isNullOrNil(str7))
        {
          l1 = ((z)localObject4).hTh;
          Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((z)localObject4).bOs(), str4, localObject1 });
          l2 = Util.nowMilliSecond();
          parama = (String)localObject1 + ".tmp";
          localObject2 = new com.tencent.mm.g.g();
          ((com.tencent.mm.g.g)localObject2).taskName = "task_VideoMsgExtension_1";
          ((com.tencent.mm.g.g)localObject2).field_mediaId = com.tencent.mm.modelcdntran.h.a("downvideothumb", ((z)localObject4).createTime, ((z)localObject4).bOs(), String.valueOf(l1));
          ((com.tencent.mm.g.g)localObject2).field_fullpath = parama;
          ((com.tencent.mm.g.g)localObject2).field_fileType = 19;
          ((com.tencent.mm.g.g)localObject2).field_aesKey = str6;
          ((com.tencent.mm.g.g)localObject2).field_authKey = str5;
          ((com.tencent.mm.g.g)localObject2).lwO = str4;
          ((com.tencent.mm.g.g)localObject2).lwL = new com.tencent.mm.g.g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(127028);
              paramAnonymousInt = ac.a(paramAnonymousInt, paramAnonymousd, l1, this.pbL, str4, k, parama, l2);
              AppMethodBeat.o(127028);
              return paramAnonymousInt;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          k.bHW().b((com.tencent.mm.g.g)localObject2, -1);
          break;
        }
        l1 = ((z)localObject4).hTh;
        Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((z)localObject4).bOs(), str3, localObject1 });
        final long l2 = Util.nowMilliSecond();
        parama = (String)localObject1 + ".tmp";
        localObject2 = new com.tencent.mm.g.g();
        ((com.tencent.mm.g.g)localObject2).taskName = "task_VideoMsgExtension_2";
        ((com.tencent.mm.g.g)localObject2).field_mediaId = com.tencent.mm.modelcdntran.h.a("downvideothumb", ((z)localObject4).createTime, ((z)localObject4).bOs(), String.valueOf(l1));
        ((com.tencent.mm.g.g)localObject2).field_fullpath = parama;
        ((com.tencent.mm.g.g)localObject2).field_fileType = com.tencent.mm.g.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.g.g)localObject2).field_totalLen = j;
        ((com.tencent.mm.g.g)localObject2).field_aesKey = ((String)localObject5);
        ((com.tencent.mm.g.g)localObject2).field_fileId = str3;
        ((com.tencent.mm.g.g)localObject2).field_priority = com.tencent.mm.g.a.lwa;
        if (au.bwE(((z)localObject4).bOs())) {}
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.g.g)localObject2).field_chattype = i;
          Log.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.g.g)localObject2).field_chattype), ((z)localObject4).bOs() });
          ((com.tencent.mm.g.g)localObject2).lwL = new com.tencent.mm.g.g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(127029);
              paramAnonymousInt = ac.a(paramAnonymousInt, paramAnonymousd, l1, this.pbL, str3, j, parama, l2);
              AppMethodBeat.o(127029);
              return paramAnonymousInt;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return null;
            }
          };
          k.bHW().b((com.tencent.mm.g.g)localObject2, -1);
          break;
        }
        label2501:
        if (((fi)localObject3).kLq == 2)
        {
          i = 0;
          break label1896;
        }
        if (!com.tencent.mm.modelcontrol.d.ae((cc)localObject3))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
          i = 0;
          break label1896;
        }
        parama = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("C2CSightNotAutoDownloadTimeRange");
        Log.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(parama)));
        if (b.NB(parama))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
          i = 0;
          break label1896;
        }
        parama = ((fi)localObject3).field_talker;
        Log.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(parama)));
        i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("SIGHTSessionAutoLoadNetwork"), 1);
        if (i == 3)
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId) });
          i = 0;
          break label1896;
        }
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId), ((fi)localObject3).field_imgPath });
          localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(parama);
          if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).maN > 0) && (((au.bwE(parama)) && (((az)localObject1).kaf == 0)) || (((au)localObject1).aGe()))) {
            break label3174;
          }
          i = 1;
          break label1896;
        }
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId), ((fi)localObject3).field_imgPath });
          i = 0;
          break label1896;
        }
        parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(((fi)localObject3).field_talker);
        if (au.bwE(((fi)localObject3).field_talker))
        {
          if (parama.kaf == 0)
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId), ((fi)localObject3).field_imgPath });
            i = 0;
            break label1896;
          }
          if (((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))) && (i == 1))
          {
            Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId), ((fi)localObject3).field_imgPath });
            i = 1;
            break label1896;
          }
          Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
          i = 0;
          break label1896;
        }
        if (parama.aGe())
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId), ((fi)localObject3).field_imgPath });
          i = 0;
          break label1896;
        }
        if (((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))) && (i == 1))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId), ((fi)localObject3).field_imgPath });
          i = 1;
          break label1896;
        }
        Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
        i = 0;
        break label1896;
        label3174:
        Log.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
        i = 0;
        break label1896;
        label3188:
        j = 3;
        continue;
        label3193:
        i = 0;
      }
    }
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(127031);
    paramc = paramc.hTm;
    if (paramc == null)
    {
      AppMethodBeat.o(127031);
      return;
    }
    ab.Qn(paramc.field_imgPath);
    AppMethodBeat.o(127031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.ac
 * JD-Core Version:    0.7.0.1
 */