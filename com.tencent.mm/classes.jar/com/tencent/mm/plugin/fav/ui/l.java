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
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.a.pf.b;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.a.wn.b;
import com.tencent.mm.model.ai.a;
import com.tencent.mm.model.ai.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.an.a;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.vfs.k;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final ajx paramajx, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106904);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (paramg == null) {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
    }
    if (paramajx == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(this.cXi, paramg, paramajx);
        ar.f(paramRunnable);
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
  
  public static void a(final Context paramContext, final String paramString, ajx paramajx, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106903);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (paramajx == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (this.rGf.dataType == 15) {
          l.a(paramContext, paramString, this.rGf);
        }
        for (;;)
        {
          ar.f(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, this.rGf);
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
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
      ar.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (bu.isNullOrNil(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
      ar.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (paramList.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
      ar.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = bu.U(this.rGc.split(",")).iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject3 = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
            if (localObject3 == null)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[] { Integer.valueOf(paramList.size()) });
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
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
                com.tencent.mm.plugin.messenger.a.g.doC().aa(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, x.Bb(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.oeJ.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (ajx)((Iterator)localObject1).next();
                  com.tencent.mm.plugin.messenger.a.g.doC().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((ajx)localObject2), 0, "", "", 0L, ((ajx)localObject2).ixk);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBd;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((ake)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((ake)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((ake)localObject1).dzG).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(bu.bI(((ake)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(bu.bI(((ake)localObject1).dEv, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                com.tencent.mm.plugin.messenger.a.g.doC().aa(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((ajx)localObject7).GzH;
                ((WXMusicObject)localObject1).musicDataUrl = ((ajx)localObject7).GzJ;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((ajx)localObject7).GzL;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((ajx)localObject7).GzL;
                ((WXMusicObject)localObject1).songAlbumUrl = ((ajx)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((ajx)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((ajx)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((ajx)localObject7).desc;
                localObject2 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.a((ajx)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = bu.bI(((ajx)localObject7).dox, "");
                  localObject1 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GCe.appId;
                localObject2 = ai.a.hIE.r((Context)localObject6, (String)localObject1);
                ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBf;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GCe;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((alc)localObject7).title;
                    localObject2 = ((alc)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (bu.isNullOrNil((String)localObject2)) {
                      localObject1 = bu.bI(((ajx)localObject5).dox, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (bu.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((ajx)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((alc)localObject7).desc;
                  }
                  if (bu.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((ajx)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBf != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBf.GCG;
                  }
                  if ((localObject8 != null) && (bu.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((akt)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).rAz) && (bu.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((ajx)localObject5).GzH;
                  }
                  if (!bu.isNullOrNil(((ajx)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((ajx)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).dIt = ((akt)localObject8).dkZ;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Ekw != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Ekw;
                    localObject2 = new e();
                    ((e)localObject2).hBV = ((akf)localObject1).hBV;
                    ((e)localObject2).hBY = ((akf)localObject1).hBY;
                    if (bu.isNullOrNil(((k.b)localObject6).dIt)) {
                      ((k.b)localObject6).dIt = ((akf)localObject1).dpP;
                    }
                    if (((akf)localObject1).hBV == 5)
                    {
                      ((e)localObject2).hCa = ((akf)localObject1).hCa;
                      ((e)localObject2).hBW = ((akf)localObject1).hBW;
                      ((e)localObject2).duration = ((akf)localObject1).duration;
                      ((e)localObject2).videoWidth = ((akf)localObject1).videoWidth;
                      ((e)localObject2).videoHeight = ((akf)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.ah.f)localObject2);
                  }
                  if ((localObject7 != null) && (!bu.isNullOrNil(((alc)localObject7).GCL)))
                  {
                    localObject1 = bx.M(((alc)localObject7).GCL, "websearch");
                    localObject2 = new com.tencent.mm.plugin.websearch.api.ae();
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTD = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTE = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTF = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTG = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTH = bu.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).qlv = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).qlw = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).uly = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTI = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTJ = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTK = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).dJL = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTL = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTM = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTN = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTO = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTP = bu.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((com.tencent.mm.plugin.websearch.api.ae)localObject2).DTQ = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.ah.f)localObject2);
                  }
                  ((k.b)localObject6).dIA = ((ajx)localObject5).dIA;
                  localObject2 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.a((ajx)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label1765;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((alc)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (bu.isNullOrNil((String)localObject1)) {
                      localObject2 = bu.bI(((ajx)localObject5).dox, "");
                    }
                    localObject1 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + v.aAC() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = z.Br((String)localObject2);
                    localObject8 = z.aBG().F((String)localObject7, true);
                    ((z.b)localObject8).k("prePublishId", localObject2);
                    ((z.b)localObject8).k("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((z.b)localObject8).k("sendAppMsgScene", Integer.valueOf(1));
                    ((z.b)localObject8).k("adExtStr", ((ajx)localObject5).dIA);
                    com.tencent.mm.plugin.messenger.a.g.doC().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBh;
                localObject3 = new pf();
                ((pf)localObject3).dEl.opType = 0;
                ((pf)localObject3).dEl.dEn = ((akm)localObject2).info;
                ((pf)localObject3).dEl.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((pf)localObject3).dEm.doq)
                {
                  localObject2 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(bu.bI(((akm)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bu.readFromFile(((pf)localObject3).dEm.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.doC().a(str, (byte[])localObject1, ((pf)localObject3).dEm.dEo, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBj;
                localObject3 = new wn();
                ((wn)localObject3).dLW.opType = 0;
                ((wn)localObject3).dLW.dLY = ((akw)localObject2).info;
                ((wn)localObject3).dLW.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((wn)localObject3).dLX.doq), ((akw)localObject2).thumbUrl });
                if (((wn)localObject3).dLX.doq)
                {
                  localObject2 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(bu.bI(((akw)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bu.readFromFile(((wn)localObject3).dLX.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.doC().a(str, (byte[])localObject1, ((wn)localObject3).dLX.dEo, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBh;
                localObject3 = new pf();
                ((pf)localObject3).dEl.opType = 1;
                ((pf)localObject3).dEl.dEn = ((akm)localObject2).info;
                ((pf)localObject3).dEl.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((pf)localObject3).dEm.doq)
                {
                  localObject2 = bu.readFromFile(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(bu.bI(((akm)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bu.readFromFile(((pf)localObject3).dEm.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.doC().a(str, (byte[])localObject1, ((pf)localObject3).dEm.dEo, null);
                }
                break;
              case 20: 
                localObject1 = f.rEP;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (c.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBs))
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.GBs;
                  localObject1 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(((ajv)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).hFc = ((ajv)localObject2).username;
                    ((k.b)localObject5).hFb = ((ajv)localObject2).dlk;
                    ((k.b)localObject5).hFd = ((ajv)localObject2).appId;
                    ((k.b)localObject5).hFr = ((ajv)localObject2).duK;
                    ((k.b)localObject5).hFs = ((ajv)localObject2).version;
                    ((k.b)localObject5).hFe = 2;
                    ((k.b)localObject5).hFl = ((ajv)localObject2).kuE;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).Lj(((ajv)localObject2).appId);
                    ((k.b)localObject5).hFt = ((ajv)localObject2).iconUrl;
                    ((k.b)localObject5).dIz = ("wxapp_" + ((ajv)localObject2).appId + ((ajv)localObject2).dlk);
                    ((k.b)localObject5).dIt = ((ajv)localObject2).username;
                    ((k.b)localObject5).dIu = ((String)localObject1);
                    localObject1 = new com.tencent.mm.ah.a();
                    ((com.tencent.mm.ah.a)localObject1).hAV = ((ajv)localObject2).kaX;
                    ((com.tencent.mm.ah.a)localObject1).hAX = ((ajv)localObject2).dLl;
                    ((com.tencent.mm.ah.a)localObject1).hAY = ((ajv)localObject2).subType;
                    ((k.b)localObject5).a((com.tencent.mm.ah.f)localObject1);
                    ((k.b)localObject5).type = 33;
                    localObject1 = new byte[0];
                    localObject6 = o.a(com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3), (com.tencent.mm.plugin.fav.a.g)localObject3);
                    if ((localObject6 == null) || (((Bitmap)localObject6).isRecycled())) {
                      break label2762;
                    }
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FavAppBrandLogic", "thumb image is not null ");
                    localObject3 = Bitmap.createBitmap(((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), Bitmap.Config.ARGB_8888);
                    localObject1 = new Canvas((Bitmap)localObject3);
                    ((Canvas)localObject1).drawColor(-1);
                    ((Canvas)localObject1).drawBitmap((Bitmap)localObject6, 0.0F, 0.0F, null);
                    localObject1 = new ByteArrayOutputStream();
                    ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
                    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FavAppBrandLogic", "bitmap recycle %s", new Object[] { localObject3 });
                    ((Bitmap)localObject3).recycle();
                  }
                  for (;;)
                  {
                    w.a.azs().a((k.b)localObject5, ((ajv)localObject2).appId, "", str, "", (byte[])localObject1);
                    break;
                    localObject1 = ak.getContext().getString(2131755945);
                    break label2377;
                    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                  }
                }
                break;
              case 14: 
              case 18: 
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
                localObject1 = l.a.a(paramContext, (com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject2 = new akn();
                try
                {
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((akn)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((akn)localObject2).oeJ;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (ajx)((Iterator)localObject5).next();
                    if ((((ajx)localObject6).GAu != null) && (((ajx)localObject6).GAu.GBs != null) && (c.a(((ajx)localObject6).GAu.GBs)))
                    {
                      ((ajx)localObject6).aao(1);
                      ((ajx)localObject6).aPD(paramContext.getString(2131755833));
                      ((LinkedList)localObject3).set(i, localObject6);
                      ((akn)localObject2).bm((LinkedList)localObject3);
                    }
                    i += 1;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.FavSendLogic", localException, "", new Object[0]);
                    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[] { localException.getMessage() });
                  }
                  localObject4 = new qi();
                  ((qi)localObject4).dFS.type = 2;
                  ((qi)localObject4).dFS.toUser = str;
                  ((qi)localObject4).dFS.dFV = ((akn)localObject2);
                  ((qi)localObject4).dFS.title = ((l.a)localObject1).title;
                  ((qi)localObject4).dFS.desc = ((l.a)localObject1).desc;
                  ((qi)localObject4).dFS.thumbPath = ((l.a)localObject1).thumbPath;
                  ((qi)localObject4).dFS.dFZ = ((l.a)localObject1).rGi;
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = bv.a.aVC((String)localObject1);
                localObject4 = com.tencent.mm.plugin.messenger.a.g.doC();
                if (an.aUq(((bv.a)localObject2).cUA)) {}
                for (i = 66;; i = 42)
                {
                  ((com.tencent.mm.plugin.messenger.a.d)localObject4).aa(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!bu.isNullOrNil(paramString2)) {
            com.tencent.mm.plugin.messenger.a.g.doC().aa(str, paramString2, x.Bb(str));
          }
        }
        ar.f(paramRunnable);
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
  
  public static boolean j(ajx paramajx)
  {
    AppMethodBeat.i(106902);
    if ((paramajx != null) && (!bu.isNullOrNil(paramajx.GzP)) && ((bu.lX(paramajx.GzP, ".htm")) || (bu.lX(paramajx.GzP, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(ajx paramajx)
  {
    AppMethodBeat.i(106905);
    k localk = new k(com.tencent.mm.plugin.fav.a.b.a(paramajx));
    if (localk.exists()) {}
    for (paramajx = com.tencent.mm.vfs.w.B(localk.fTh());; paramajx = com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(bu.bI(paramajx.dox, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramajx;
    }
  }
  
  public static final class a
  {
    public String desc;
    public String rGi;
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
        localIterator = paramg.field_favProto.oeJ.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (ajx)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((ajx)localObject1)))
          {
            int k = localSparseIntArray.get(((ajx)localObject1).dataType);
            localSparseIntArray.put(((ajx)localObject1).dataType, k + 1);
            switch (((ajx)localObject1).dataType)
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
                localObject1 = ((ajx)localObject1).desc;
                if (!bu.isNullOrNil((String)localObject1))
                {
                  localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                  localLinkedList.add((String)localObject1 + "\n");
                }
              }
              break;
            case 3: 
              if (localLinkedList.size() < 4)
              {
                k = (int)com.tencent.mm.plugin.fav.a.b.vK(((ajx)localObject1).duration);
                localLinkedList.add(paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(k) }) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((ajx)localObject1);
                if (ahI((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((ajx)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((ajx)localObject1).GAu.GBd;
                localObject2 = new StringBuilder().append(paramContext.getString(2131755806));
                if ((!bu.isNullOrNil(b((ake)localObject1))) && (!b((ake)localObject1).equals(paramContext.getString(2131760739)))) {
                  break label549;
                }
              }
              for (localObject1 = a((ake)localObject1);; localObject1 = b((ake)localObject1))
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
                localLinkedList.add(paramContext.getString(2131755773) + ((ajx)localObject1).title + "\n");
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
                localLinkedList.add(paramContext.getString(2131755279) + ((ajx)localObject1).title + "\n");
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
      Iterator localIterator = paramg.field_favProto.oeJ.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (ajx)localIterator.next();
        j = localSparseIntArray.get(((ajx)localObject2).dataType);
        localSparseIntArray.put(((ajx)localObject2).dataType, j + 1);
        switch (((ajx)localObject2).dataType)
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
            localLinkedList.add(((ajx)localObject2).GAw + ":" + ((ajx)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4)
          {
            j = (int)com.tencent.mm.plugin.fav.a.b.sI(((ajx)localObject2).duration);
            localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(j) }) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755853) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((ajx)localObject2);
            if (!ahI(paramg)) {
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
          localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755920) + ((ajx)localObject2).title + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((ajx)localObject2);
        if (ahI(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
          break;
        }
        paramg = ((ajx)localObject2).GAu.GBf;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (bu.isNullOrNil(paramg)) {
            localObject1 = bu.bI(((ajx)localObject2).dox, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.cwn()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755920) + ((ajx)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755895) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((ajx)localObject2);
        if (ahI(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755926) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((ajx)localObject2);
          if (ahI(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((ajx)localObject2).GAu.GBd;
              localObject1 = new StringBuilder().append(((ajx)localObject2).GAw).append(":").append(paramContext.getString(2131755806));
              if ((!bu.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(2131760739)))) {
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
              localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755820) + ((ajx)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((ajx)localObject2).dox);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755773) + ((ajx)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755858) + ((ajx)localObject2).GAu.GBh.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((ajx)localObject2).GAu.GBh;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755278) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((ajx)localObject2).GAu.GBj;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755782) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.rGi = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arp(((ajx)localObject2).desc).cUA;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755872) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((ajx)localObject2).GAu.GBs != null) && (((ajx)localObject2).GAu.GBs.type == 3))
            {
              localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755833) + "\n");
              break;
            }
            localLinkedList.add(((ajx)localObject2).GAw + ":" + paramContext.getString(2131755279) + ((ajx)localObject2).title + "\n");
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
    
    private static String a(ake paramake)
    {
      AppMethodBeat.i(106896);
      if (paramake == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramake = paramake.label;
      AppMethodBeat.o(106896);
      return paramake;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(bu.bI(paramString, "").getBytes());
      if (ahI(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static boolean ahI(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new k(paramString).exists();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    private static String b(ake paramake)
    {
      AppMethodBeat.i(106897);
      if (paramake == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramake = paramake.dEv;
      AppMethodBeat.o(106897);
      return paramake;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */