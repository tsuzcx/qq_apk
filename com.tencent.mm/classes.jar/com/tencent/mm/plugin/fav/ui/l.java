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
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.pe.b;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.a.wj.b;
import com.tencent.mm.model.ah.a;
import com.tencent.mm.model.ah.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.an.a;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final ajn paramajn, final Runnable paramRunnable)
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
    if (paramajn == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(this.cWl, paramg, paramajn);
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
  
  public static void a(final Context paramContext, final String paramString, ajn paramajn, final Runnable paramRunnable)
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
    if (paramajn == null)
    {
      ad.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (this.rxU.dataType == 15) {
          l.a(paramContext, paramString, this.rxU);
        }
        for (;;)
        {
          aq.f(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, this.rxU);
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
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = bt.U(this.rxR.split(",")).iterator();
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
              com.tencent.mm.plugin.report.service.g.yhR.f(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
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
                com.tencent.mm.plugin.messenger.a.g.dlD().aa(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, com.tencent.mm.model.w.Ar(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.nZa.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (ajn)((Iterator)localObject1).next();
                  com.tencent.mm.plugin.messenger.a.g.dlD().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((ajn)localObject2), 0, "", "", 0L, ((ajn)localObject2).iuq);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Giu;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((aju)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((aju)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((aju)localObject1).dyB).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(bt.bI(((aju)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(bt.bI(((aju)localObject1).dDq, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                com.tencent.mm.plugin.messenger.a.g.dlD().aa(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((ajn)localObject7).GgY;
                ((WXMusicObject)localObject1).musicDataUrl = ((ajn)localObject7).Gha;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((ajn)localObject7).Ghc;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((ajn)localObject7).Ghc;
                ((WXMusicObject)localObject1).songAlbumUrl = ((ajn)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((ajn)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((ajn)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((ajn)localObject7).desc;
                localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.a((ajn)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = bt.bI(((ajn)localObject7).dnv, "");
                  localObject1 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Gjv.appId;
                localObject2 = ah.a.hFM.r((Context)localObject6, (String)localObject1);
                ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  ad.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Giw;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Gjv;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((aks)localObject7).title;
                    localObject2 = ((aks)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (bt.isNullOrNil((String)localObject2)) {
                      localObject1 = bt.bI(((ajn)localObject5).dnv, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (bt.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((ajn)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((aks)localObject7).desc;
                  }
                  if (bt.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((ajn)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Giw != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Giw.GjX;
                  }
                  if ((localObject8 != null) && (bt.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((akj)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).rsm) && (bt.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((ajn)localObject5).GgY;
                  }
                  if (!bt.isNullOrNil(((ajn)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((ajn)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).dHo = ((akj)localObject8).djX;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DSw != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.DSw;
                    localObject2 = new com.tencent.mm.ai.e();
                    ((com.tencent.mm.ai.e)localObject2).hzh = ((ajv)localObject1).hzh;
                    ((com.tencent.mm.ai.e)localObject2).hzk = ((ajv)localObject1).hzk;
                    if (bt.isNullOrNil(((k.b)localObject6).dHo)) {
                      ((k.b)localObject6).dHo = ((ajv)localObject1).doK;
                    }
                    if (((ajv)localObject1).hzh == 5)
                    {
                      ((com.tencent.mm.ai.e)localObject2).hzm = ((ajv)localObject1).hzm;
                      ((com.tencent.mm.ai.e)localObject2).hzi = ((ajv)localObject1).hzi;
                      ((com.tencent.mm.ai.e)localObject2).duration = ((ajv)localObject1).duration;
                      ((com.tencent.mm.ai.e)localObject2).videoWidth = ((ajv)localObject1).videoWidth;
                      ((com.tencent.mm.ai.e)localObject2).videoHeight = ((ajv)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.ai.f)localObject2);
                  }
                  if ((localObject7 != null) && (!bt.isNullOrNil(((aks)localObject7).Gkc)))
                  {
                    localObject1 = bw.M(((aks)localObject7).Gkc, "websearch");
                    localObject2 = new ae();
                    ((ae)localObject2).DBG = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((ae)localObject2).DBH = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((ae)localObject2).DBI = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((ae)localObject2).DBJ = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((ae)localObject2).DBK = bt.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((ae)localObject2).qeQ = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((ae)localObject2).qeR = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((ae)localObject2).uaw = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((ae)localObject2).DBL = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((ae)localObject2).DBM = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((ae)localObject2).DBN = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((ae)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((ae)localObject2).lox = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((ae)localObject2).DBO = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((ae)localObject2).DBP = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((ae)localObject2).DBQ = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((ae)localObject2).DBR = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((ae)localObject2).DBS = bt.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((ae)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((ae)localObject2).DBT = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.ai.f)localObject2);
                  }
                  ((k.b)localObject6).dHv = ((ajn)localObject5).dHv;
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.a((ajn)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label1765;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((aks)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (bt.isNullOrNil((String)localObject1)) {
                      localObject2 = bt.bI(((ajn)localObject5).dnv, "");
                    }
                    localObject1 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + u.aAm() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = y.AH((String)localObject2);
                    localObject8 = y.aBq().F((String)localObject7, true);
                    ((y.b)localObject8).k("prePublishId", localObject2);
                    ((y.b)localObject8).k("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((y.b)localObject8).k("sendAppMsgScene", Integer.valueOf(1));
                    ((y.b)localObject8).k("adExtStr", ((ajn)localObject5).dHv);
                    com.tencent.mm.plugin.messenger.a.g.dlD().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Giy;
                localObject3 = new pe();
                ((pe)localObject3).dDg.opType = 0;
                ((pe)localObject3).dDg.dDi = ((akc)localObject2).info;
                ((pe)localObject3).dDg.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((pe)localObject3).dDh.dno)
                {
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(bt.bI(((akc)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bt.readFromFile(((pe)localObject3).dDh.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.dlD().a(str, (byte[])localObject1, ((pe)localObject3).dDh.dDj, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GiA;
                localObject3 = new wj();
                ((wj)localObject3).dKH.opType = 0;
                ((wj)localObject3).dKH.dKJ = ((akm)localObject2).info;
                ((wj)localObject3).dKH.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                ad.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((wj)localObject3).dKI.dno), ((akm)localObject2).thumbUrl });
                if (((wj)localObject3).dKI.dno)
                {
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(bt.bI(((akm)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bt.readFromFile(((wj)localObject3).dKI.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.dlD().a(str, (byte[])localObject1, ((wj)localObject3).dKI.dDj, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Giy;
                localObject3 = new pe();
                ((pe)localObject3).dDg.opType = 1;
                ((pe)localObject3).dDg.dDi = ((akc)localObject2).info;
                ((pe)localObject3).dDg.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((pe)localObject3).dDh.dno)
                {
                  localObject2 = bt.readFromFile(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(bt.bI(((akc)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bt.readFromFile(((pe)localObject3).dDh.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.dlD().a(str, (byte[])localObject1, ((pe)localObject3).dDh.dDj, null);
                }
                break;
              case 20: 
                localObject1 = f.rwD;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  ad.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (c.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GiJ))
                {
                  ad.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GiJ;
                  localObject1 = ((n)com.tencent.mm.kernel.g.ab(n.class)).Nt(((ajl)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).hCn = ((ajl)localObject2).username;
                    ((k.b)localObject5).hCm = ((ajl)localObject2).dki;
                    ((k.b)localObject5).hCo = ((ajl)localObject2).appId;
                    ((k.b)localObject5).hCz = ((ajl)localObject2).dtF;
                    ((k.b)localObject5).hCA = ((ajl)localObject2).version;
                    ((k.b)localObject5).hCp = 2;
                    ((k.b)localObject5).hCw = ((ajl)localObject2).kro;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).KJ(((ajl)localObject2).appId);
                    ((k.b)localObject5).hCB = ((ajl)localObject2).iconUrl;
                    ((k.b)localObject5).dHu = ("wxapp_" + ((ajl)localObject2).appId + ((ajl)localObject2).dki);
                    ((k.b)localObject5).dHo = ((ajl)localObject2).username;
                    ((k.b)localObject5).dHp = ((String)localObject1);
                    localObject1 = new com.tencent.mm.ai.a();
                    ((com.tencent.mm.ai.a)localObject1).hyh = ((ajl)localObject2).jXI;
                    ((com.tencent.mm.ai.a)localObject1).hyj = ((ajl)localObject2).dJW;
                    ((com.tencent.mm.ai.a)localObject1).hyk = ((ajl)localObject2).subType;
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
                    w.a.azd().a((k.b)localObject5, ((ajl)localObject2).appId, "", str, "", (byte[])localObject1);
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
                localObject2 = new akd();
                try
                {
                  ad.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((akd)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((akd)localObject2).nZa;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (ajn)((Iterator)localObject5).next();
                    if ((((ajn)localObject6).GhL != null) && (((ajn)localObject6).GhL.GiJ != null) && (c.a(((ajn)localObject6).GhL.GiJ)))
                    {
                      ((ajn)localObject6).ZI(1);
                      ((ajn)localObject6).aOg(paramContext.getString(2131755833));
                      ((LinkedList)localObject3).set(i, localObject6);
                      ((akd)localObject2).bl((LinkedList)localObject3);
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
                  localObject4 = new qh();
                  ((qh)localObject4).dEN.type = 2;
                  ((qh)localObject4).dEN.toUser = str;
                  ((qh)localObject4).dEN.dEQ = ((akd)localObject2);
                  ((qh)localObject4).dEN.title = ((l.a)localObject1).title;
                  ((qh)localObject4).dEN.desc = ((l.a)localObject1).desc;
                  ((qh)localObject4).dEN.thumbPath = ((l.a)localObject1).thumbPath;
                  ((qh)localObject4).dEN.dEU = ((l.a)localObject1).rxX;
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = bu.a.aUb((String)localObject1);
                localObject4 = com.tencent.mm.plugin.messenger.a.g.dlD();
                if (am.aSQ(((bu.a)localObject2).dHm)) {}
                for (i = 66;; i = 42)
                {
                  ((com.tencent.mm.plugin.messenger.a.d)localObject4).aa(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!bt.isNullOrNil(paramString2)) {
            com.tencent.mm.plugin.messenger.a.g.dlD().aa(str, paramString2, com.tencent.mm.model.w.Ar(str));
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
  
  public static boolean j(ajn paramajn)
  {
    AppMethodBeat.i(106902);
    if ((paramajn != null) && (!bt.isNullOrNil(paramajn.Ghg)) && ((bt.lQ(paramajn.Ghg, ".htm")) || (bt.lQ(paramajn.Ghg, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(ajn paramajn)
  {
    AppMethodBeat.i(106905);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(paramajn));
    if (locale.exists()) {}
    for (paramajn = q.B(locale.fOK());; paramajn = com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(bt.bI(paramajn.dnv, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramajn;
    }
  }
  
  public static final class a
  {
    public String desc;
    public String rxX;
    public String thumbPath;
    public String title;
    
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
        localIterator = paramg.field_favProto.nZa.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (ajn)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((ajn)localObject1)))
          {
            int k = localSparseIntArray.get(((ajn)localObject1).dataType);
            localSparseIntArray.put(((ajn)localObject1).dataType, k + 1);
            switch (((ajn)localObject1).dataType)
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
                localObject1 = ((ajn)localObject1).desc;
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
                k = (int)com.tencent.mm.plugin.fav.a.b.vu(((ajn)localObject1).duration);
                localLinkedList.add(paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(k) }) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((ajn)localObject1);
                if (agL((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((ajn)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((ajn)localObject1).GhL.Giu;
                localObject2 = new StringBuilder().append(paramContext.getString(2131755806));
                if ((!bt.isNullOrNil(b((aju)localObject1))) && (!b((aju)localObject1).equals(paramContext.getString(2131760739)))) {
                  break label549;
                }
              }
              for (localObject1 = a((aju)localObject1);; localObject1 = b((aju)localObject1))
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
                localLinkedList.add(paramContext.getString(2131755773) + ((ajn)localObject1).title + "\n");
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
                localLinkedList.add(paramContext.getString(2131755279) + ((ajn)localObject1).title + "\n");
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
      Iterator localIterator = paramg.field_favProto.nZa.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (ajn)localIterator.next();
        j = localSparseIntArray.get(((ajn)localObject2).dataType);
        localSparseIntArray.put(((ajn)localObject2).dataType, j + 1);
        switch (((ajn)localObject2).dataType)
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
            localLinkedList.add(((ajn)localObject2).GhN + ":" + ((ajn)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4)
          {
            j = (int)com.tencent.mm.plugin.fav.a.b.sv(((ajn)localObject2).duration);
            localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(j) }) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755853) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((ajn)localObject2);
            if (!agL(paramg)) {
              break label2617;
            }
            locala.thumbPath = paramg;
            i = 1;
          }
          break;
        }
      }
      label2617:
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755920) + ((ajn)localObject2).title + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((ajn)localObject2);
        if (agL(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
          break;
        }
        paramg = ((ajn)localObject2).GhL.Giw;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (bt.isNullOrNil(paramg)) {
            localObject1 = bt.bI(((ajn)localObject2).dnv, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.cuM()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755920) + ((ajn)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755895) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((ajn)localObject2);
        if (agL(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755926) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((ajn)localObject2);
          if (agL(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((ajn)localObject2).GhL.Giu;
              localObject1 = new StringBuilder().append(((ajn)localObject2).GhN).append(":").append(paramContext.getString(2131755806));
              if ((!bt.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(2131760739)))) {
                break label1849;
              }
            }
            label1849:
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
              localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755820) + ((ajn)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((ajn)localObject2).dnv);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755773) + ((ajn)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755858) + ((ajn)localObject2).GhL.Giy.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((ajn)localObject2).GhL.Giy;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755278) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((ajn)localObject2).GhL.GiA;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755782) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.rxX = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqk(((ajn)localObject2).desc).dHm;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755872) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((ajn)localObject2).GhL.GiJ != null) && (((ajn)localObject2).GhL.GiJ.type == 3))
            {
              localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755833) + "\n");
              break;
            }
            localLinkedList.add(((ajn)localObject2).GhN + ":" + paramContext.getString(2131755279) + ((ajn)localObject2).title + "\n");
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
    
    private static String a(aju paramaju)
    {
      AppMethodBeat.i(106896);
      if (paramaju == null)
      {
        ad.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramaju = paramaju.label;
      AppMethodBeat.o(106896);
      return paramaju;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(bt.bI(paramString, "").getBytes());
      if (agL(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static boolean agL(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new com.tencent.mm.vfs.e(paramString).exists();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    private static String b(aju paramaju)
    {
      AppMethodBeat.i(106897);
      if (paramaju == null)
      {
        ad.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramaju = paramaju.dDq;
      AppMethodBeat.o(106897);
      return paramaju;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */