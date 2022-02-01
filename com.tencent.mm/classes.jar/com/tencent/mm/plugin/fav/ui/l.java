package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.om.b;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vg.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.model.ag.a;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.fav.a.an.a;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final afy paramafy, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106904);
    if (paramContext == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (paramg == null) {
      ad.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
    }
    if (paramafy == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(this.cND, paramg, paramafy);
        aq.f(paramRunnable);
        AppMethodBeat.o(106891);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(106892);
        String str = super.toString() + "|sendFavFile";
        AppMethodBeat.o(106892);
        return str;
      }
    });
    AppMethodBeat.o(106904);
  }
  
  public static void a(final Context paramContext, final String paramString, afy paramafy, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106903);
    if (paramContext == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (paramafy == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (this.qft.dataType == 15) {
          l.a(paramContext, paramString, this.qft);
        }
        for (;;)
        {
          aq.f(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, this.qft);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(106890);
        String str = super.toString() + "|sendFavVideo";
        AppMethodBeat.o(106890);
        return str;
      }
    });
    AppMethodBeat.o(106903);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.fav.a.g paramg, Runnable paramRunnable)
  {
    AppMethodBeat.i(106900);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramg);
    a(paramContext, paramString1, paramString2, localLinkedList, paramRunnable);
    AppMethodBeat.o(106900);
  }
  
  public static void a(final Context paramContext, String paramString1, final String paramString2, final List<com.tencent.mm.plugin.fav.a.g> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106901);
    if (paramContext == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
      aq.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
      aq.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (paramList.isEmpty())
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
      aq.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = bt.S(this.qfq.split(",")).iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject3 = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
            if (localObject3 == null)
            {
              ad.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[] { Integer.valueOf(paramList.size()) });
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
              Object localObject1;
              Object localObject2;
              Object localObject6;
              Object localObject7;
              Object localObject5;
              label1765:
              int i;
              label2377:
              label2762:
              Object localObject4;
              switch (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type)
              {
              case 3: 
              case 9: 
              case 12: 
              case 13: 
              default: 
                break;
              case 1: 
                j.cOB().W(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, com.tencent.mm.model.w.tq(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.mVb.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (afy)((Iterator)localObject1).next();
                  j.cOB().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((afy)localObject2), 0, "", "", 0L, ((afy)localObject2).hAt);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhC;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((agf)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((agf)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((agf)localObject1).dpd).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(bt.by(((agf)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(bt.by(((agf)localObject1).dtN, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                j.cOB().W(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((afy)localObject7).Dgg;
                ((WXMusicObject)localObject1).musicDataUrl = ((afy)localObject7).Dgi;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((afy)localObject7).Dgk;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((afy)localObject7).Dgk;
                ((WXMusicObject)localObject1).songAlbumUrl = ((afy)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((afy)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((afy)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((afy)localObject7).desc;
                localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.a((afy)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = bt.by(((afy)localObject7).deE, "");
                  localObject1 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DiD.appId;
                localObject2 = ag.a.gMU.s((Context)localObject6, (String)localObject1);
                ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  ad.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhE;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DiD;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((ahd)localObject7).title;
                    localObject2 = ((ahd)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (bt.isNullOrNil((String)localObject2)) {
                      localObject1 = bt.by(((afy)localObject5).deE, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (bt.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((afy)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((ahd)localObject7).desc;
                  }
                  if (bt.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((afy)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhE != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhE.Djf;
                  }
                  if ((localObject8 != null) && (bt.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((agu)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).pZE) && (bt.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((afy)localObject5).Dgg;
                  }
                  if (!bt.isNullOrNil(((afy)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((afy)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).dxz = ((agu)localObject8).dbj;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.AWL != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.AWL;
                    localObject2 = new com.tencent.mm.ai.e();
                    ((com.tencent.mm.ai.e)localObject2).gGx = ((agg)localObject1).gGx;
                    ((com.tencent.mm.ai.e)localObject2).gGA = ((agg)localObject1).gGA;
                    if (bt.isNullOrNil(((k.b)localObject6).dxz)) {
                      ((k.b)localObject6).dxz = ((agg)localObject1).dfT;
                    }
                    if (((agg)localObject1).gGx == 5)
                    {
                      ((com.tencent.mm.ai.e)localObject2).gGC = ((agg)localObject1).gGC;
                      ((com.tencent.mm.ai.e)localObject2).gGy = ((agg)localObject1).gGy;
                      ((com.tencent.mm.ai.e)localObject2).duration = ((agg)localObject1).duration;
                      ((com.tencent.mm.ai.e)localObject2).videoWidth = ((agg)localObject1).videoWidth;
                      ((com.tencent.mm.ai.e)localObject2).videoHeight = ((agg)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.ai.f)localObject2);
                  }
                  if ((localObject7 != null) && (!bt.isNullOrNil(((ahd)localObject7).Djk)))
                  {
                    localObject1 = bw.K(((ahd)localObject7).Djk, "websearch");
                    localObject2 = new com.tencent.mm.plugin.websearch.api.ab();
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGs = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGt = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGu = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGv = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGw = bt.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).oYa = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).oYb = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).rUO = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGx = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGy = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGz = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).kqB = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGA = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGB = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGC = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGD = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGE = bt.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ab)localObject2).AGF = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.ai.f)localObject2);
                  }
                  ((k.b)localObject6).dxG = ((afy)localObject5).dxG;
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.a((afy)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label1765;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((ahd)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (bt.isNullOrNil((String)localObject1)) {
                      localObject2 = bt.by(((afy)localObject5).deE, "");
                    }
                    localObject1 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + u.aqG() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = y.tD((String)localObject2);
                    localObject8 = y.arz().E((String)localObject7, true);
                    ((y.b)localObject8).m("prePublishId", localObject2);
                    ((y.b)localObject8).m("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((y.b)localObject8).m("sendAppMsgScene", Integer.valueOf(1));
                    ((y.b)localObject8).m("adExtStr", ((afy)localObject5).dxG);
                    j.cOB().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhG;
                localObject3 = new om();
                ((om)localObject3).dtD.opType = 0;
                ((om)localObject3).dtD.dtF = ((agn)localObject2).info;
                ((om)localObject3).dtD.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((om)localObject3).dtE.dew)
                {
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(bt.by(((agn)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bt.readFromFile(((om)localObject3).dtE.thumbPath);
                  }
                  j.cOB().a(str, (byte[])localObject1, ((om)localObject3).dtE.dtG, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhI;
                localObject3 = new vg();
                ((vg)localObject3).dAI.opType = 0;
                ((vg)localObject3).dAI.dAK = ((agx)localObject2).info;
                ((vg)localObject3).dAI.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
                ad.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((vg)localObject3).dAJ.dew), ((agx)localObject2).thumbUrl });
                if (((vg)localObject3).dAJ.dew)
                {
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(bt.by(((agx)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bt.readFromFile(((vg)localObject3).dAJ.thumbPath);
                  }
                  j.cOB().a(str, (byte[])localObject1, ((vg)localObject3).dAJ.dtG, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhG;
                localObject3 = new om();
                ((om)localObject3).dtD.opType = 1;
                ((om)localObject3).dtD.dtF = ((agn)localObject2).info;
                ((om)localObject3).dtD.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((om)localObject3).dtE.dew)
                {
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(bt.by(((agn)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bt.readFromFile(((om)localObject3).dtE.thumbPath);
                  }
                  j.cOB().a(str, (byte[])localObject1, ((om)localObject3).dtE.dtG, null);
                }
                break;
              case 20: 
                localObject1 = f.qdY;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  ad.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (c.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhR))
                {
                  ad.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DhR;
                  localObject1 = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(((afw)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).gJE = ((afw)localObject2).username;
                    ((k.b)localObject5).gJD = ((afw)localObject2).dbu;
                    ((k.b)localObject5).gJF = ((afw)localObject2).appId;
                    ((k.b)localObject5).gJQ = ((afw)localObject2).dkC;
                    ((k.b)localObject5).gJR = ((afw)localObject2).version;
                    ((k.b)localObject5).gJG = 2;
                    ((k.b)localObject5).gJN = ((afw)localObject2).jwB;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).Du(((afw)localObject2).appId);
                    ((k.b)localObject5).gJS = ((afw)localObject2).iconUrl;
                    ((k.b)localObject5).dxF = ("wxapp_" + ((afw)localObject2).appId + ((afw)localObject2).dbu);
                    ((k.b)localObject5).dxz = ((afw)localObject2).username;
                    ((k.b)localObject5).dxA = ((String)localObject1);
                    localObject1 = new com.tencent.mm.ai.a();
                    ((com.tencent.mm.ai.a)localObject1).gFy = ((afw)localObject2).cfU;
                    ((com.tencent.mm.ai.a)localObject1).gFA = ((afw)localObject2).dzY;
                    ((com.tencent.mm.ai.a)localObject1).gFB = ((afw)localObject2).subType;
                    ((k.b)localObject5).a((com.tencent.mm.ai.f)localObject1);
                    ((k.b)localObject5).type = 33;
                    localObject1 = new byte[0];
                    localObject6 = o.a(com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3), (com.tencent.mm.plugin.fav.a.g)localObject3);
                    if ((localObject6 == null) || (((Bitmap)localObject6).isRecycled())) {
                      break label2762;
                    }
                    ad.i("MicroMsg.FavAppBrandLogic", "thumb image is not null ");
                    localObject3 = Bitmap.createBitmap(((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), Bitmap.Config.ARGB_8888);
                    localObject1 = new Canvas((Bitmap)localObject3);
                    ((Canvas)localObject1).drawColor(-1);
                    ((Canvas)localObject1).drawBitmap((Bitmap)localObject6, 0.0F, 0.0F, null);
                    localObject1 = new ByteArrayOutputStream();
                    ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
                    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
                    ad.i("MicroMsg.FavAppBrandLogic", "bitmap recycle %s", new Object[] { localObject3 });
                    ((Bitmap)localObject3).recycle();
                  }
                  for (;;)
                  {
                    w.a.apB().a((k.b)localObject5, ((afw)localObject2).appId, "", str, "", (byte[])localObject1);
                    break;
                    localObject1 = aj.getContext().getString(2131755945);
                    break label2377;
                    ad.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                  }
                }
                break;
              case 14: 
              case 18: 
                ad.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
                localObject1 = l.a.a(paramContext, (com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject2 = new ago();
                try
                {
                  ad.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((ago)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((ago)localObject2).mVb;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (afy)((Iterator)localObject5).next();
                    if ((((afy)localObject6).DgT != null) && (((afy)localObject6).DgT.DhR != null) && (c.a(((afy)localObject6).DgT.DhR)))
                    {
                      ((afy)localObject6).VD(1);
                      ((afy)localObject6).aDm(paramContext.getString(2131755833));
                      ((LinkedList)localObject3).set(i, localObject6);
                      ((ago)localObject2).bd((LinkedList)localObject3);
                    }
                    i += 1;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    ad.printErrStackTrace("MicroMsg.FavSendLogic", localException, "", new Object[0]);
                    ad.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[] { localException.getMessage() });
                  }
                  localObject4 = new pn();
                  ((pn)localObject4).dvb.type = 2;
                  ((pn)localObject4).dvb.toUser = str;
                  ((pn)localObject4).dvb.dve = ((ago)localObject2);
                  ((pn)localObject4).dvb.title = ((l.a)localObject1).title;
                  ((pn)localObject4).dvb.desc = ((l.a)localObject1).desc;
                  ((pn)localObject4).dvb.thumbPath = ((l.a)localObject1).thumbPath;
                  ((pn)localObject4).dvb.dvi = ((l.a)localObject1).qfw;
                  com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject4);
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = bl.a.aIO((String)localObject1);
                localObject4 = j.cOB();
                if (af.aHH(((bl.a)localObject2).yGA)) {}
                for (i = 66;; i = 42)
                {
                  ((com.tencent.mm.plugin.messenger.a.e)localObject4).W(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!bt.isNullOrNil(paramString2)) {
            j.cOB().W(str, paramString2, com.tencent.mm.model.w.tq(str));
          }
        }
        aq.f(paramRunnable);
        AppMethodBeat.o(106886);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(106887);
        String str = super.toString() + "|sendFavMsg";
        AppMethodBeat.o(106887);
        return str;
      }
    });
    AppMethodBeat.o(106901);
  }
  
  public static boolean j(afy paramafy)
  {
    AppMethodBeat.i(106902);
    if ((paramafy != null) && (!bt.isNullOrNil(paramafy.Dgo)) && ((bt.kU(paramafy.Dgo, ".htm")) || (bt.kU(paramafy.Dgo, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(afy paramafy)
  {
    AppMethodBeat.i(106905);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(paramafy));
    if (locale.exists()) {}
    for (paramafy = q.B(locale.fhU());; paramafy = com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(bt.by(paramafy.deE, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramafy;
    }
  }
  
  public static final class a
  {
    public String desc;
    public String qfw;
    public String thumbPath;
    public String title;
    
    private static boolean YA(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new com.tencent.mm.vfs.e(paramString).exists();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    public static a a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
    {
      AppMethodBeat.i(106898);
      int j;
      Object localObject1;
      Object localObject2;
      if (paramg.field_type == 18)
      {
        locala = new a();
        localSparseIntArray = new SparseIntArray();
        if (paramg.field_type == 18) {
          locala.title = paramg.field_favProto.title;
        }
        i = 0;
        localLinkedList = new LinkedList();
        localIterator = paramg.field_favProto.mVb.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (afy)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((afy)localObject1)))
          {
            int k = localSparseIntArray.get(((afy)localObject1).dataType);
            localSparseIntArray.put(((afy)localObject1).dataType, k + 1);
            switch (((afy)localObject1).dataType)
            {
            case 5: 
            case 7: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            default: 
              break;
            case 1: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((afy)localObject1).desc;
                if (!bt.isNullOrNil((String)localObject1))
                {
                  localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                  localLinkedList.add((String)localObject1 + "\n");
                }
              }
              break;
            case 3: 
              if (localLinkedList.size() < 4)
              {
                k = (int)com.tencent.mm.plugin.fav.a.b.pI(((afy)localObject1).duration);
                localLinkedList.add(paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(k) }) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((afy)localObject1);
                if (YA((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((afy)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((afy)localObject1).DgT.DhC;
                localObject2 = new StringBuilder().append(paramContext.getString(2131755806));
                if ((!bt.isNullOrNil(b((agf)localObject1))) && (!b((agf)localObject1).equals(paramContext.getString(2131760739)))) {
                  break label549;
                }
              }
              for (localObject1 = a((agf)localObject1);; localObject1 = b((agf)localObject1))
              {
                localLinkedList.add((String)localObject1 + "\n");
                if (i != 0) {
                  break;
                }
                i = 1;
                break;
              }
            case 8: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131755773) + ((afy)localObject1).title + "\n");
              }
              if (i == 0) {
                i = 1;
              }
              break;
            case 4: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131755926) + "\n");
              }
              break;
            case 17: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131755872) + "\n");
              }
              break;
            case 19: 
              label549:
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131755279) + ((afy)localObject1).title + "\n");
              }
              break;
            }
          }
        }
        locala.desc = "";
        paramg = localLinkedList.iterator();
        for (paramContext = ""; paramg.hasNext(); paramContext = paramContext + (String)localObject1) {
          localObject1 = (String)paramg.next();
        }
        paramg = paramContext.trim();
        paramContext = paramg;
        if (localLinkedList.size() >= 4) {
          paramContext = paramg + "...";
        }
        locala.desc = paramContext;
        if (locala.title == null) {
          locala.title = "";
        }
        AppMethodBeat.o(106898);
        return locala;
      }
      a locala = new a();
      SparseIntArray localSparseIntArray = new SparseIntArray();
      if (paramg.field_type == 14) {
        locala.title = paramg.field_favProto.title;
      }
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramg.field_favProto.mVb.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (afy)localIterator.next();
        j = localSparseIntArray.get(((afy)localObject2).dataType);
        localSparseIntArray.put(((afy)localObject2).dataType, j + 1);
        switch (((afy)localObject2).dataType)
        {
        case 9: 
        case 12: 
        case 13: 
        case 18: 
        case 20: 
        case 21: 
        default: 
          break;
        case 1: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((afy)localObject2).DgV + ":" + ((afy)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4)
          {
            j = (int)com.tencent.mm.plugin.fav.a.b.mI(((afy)localObject2).duration);
            localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(j) }) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755853) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((afy)localObject2);
            if (!YA(paramg)) {
              break label2619;
            }
            locala.thumbPath = paramg;
            i = 1;
          }
          break;
        }
      }
      label1849:
      label2619:
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755920) + ((afy)localObject2).title + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((afy)localObject2);
        if (YA(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
          break;
        }
        paramg = ((afy)localObject2).DgT.DhE;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (bt.isNullOrNil(paramg)) {
            localObject1 = bt.by(((afy)localObject2).deE, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.chA()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755920) + ((afy)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755895) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((afy)localObject2);
        if (YA(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755926) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((afy)localObject2);
          if (YA(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((afy)localObject2).DgT.DhC;
              localObject1 = new StringBuilder().append(((afy)localObject2).DgV).append(":").append(paramContext.getString(2131755806));
              if ((!bt.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(2131760739)))) {
                break label1849;
              }
            }
            for (paramg = a(paramg);; paramg = b(paramg))
            {
              localLinkedList.add(paramg + "\n");
              if (i != 0) {
                break;
              }
              i = 1;
              break;
            }
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755820) + ((afy)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((afy)localObject2).deE);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755773) + ((afy)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755858) + ((afy)localObject2).DgT.DhG.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((afy)localObject2).DgT.DhG;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755278) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((afy)localObject2).DgT.DhI;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755782) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.qfw = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agC(((afy)localObject2).desc).yGA;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755872) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((afy)localObject2).DgT.DhR != null) && (((afy)localObject2).DgT.DhR.type == 3))
            {
              localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755833) + "\n");
              break;
            }
            localLinkedList.add(((afy)localObject2).DgV + ":" + paramContext.getString(2131755279) + ((afy)localObject2).title + "\n");
            break;
            locala.desc = "";
            paramg = localLinkedList.iterator();
            for (paramContext = ""; paramg.hasNext(); paramContext = paramContext + (String)localObject1) {
              localObject1 = (String)paramg.next();
            }
            paramg = paramContext.trim();
            paramContext = paramg;
            if (localLinkedList.size() >= 4) {
              paramContext = paramg + "...";
            }
            locala.desc = paramContext;
            AppMethodBeat.o(106898);
            return locala;
          }
        }
      }
    }
    
    private static String a(agf paramagf)
    {
      AppMethodBeat.i(106896);
      if (paramagf == null)
      {
        ad.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramagf = paramagf.label;
      AppMethodBeat.o(106896);
      return paramagf;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(bt.by(paramString, "").getBytes());
      if (YA(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static String b(agf paramagf)
    {
      AppMethodBeat.i(106897);
      if (paramagf == null)
      {
        ad.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramagf = paramagf.dtN;
      AppMethodBeat.o(106897);
      return paramagf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */