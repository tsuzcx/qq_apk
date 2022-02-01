package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.ov.b;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
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
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final agx paramagx, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106904);
    if (paramContext == null)
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (paramg == null) {
      ac.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
    }
    if (paramagx == null)
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(this.cKY, paramg, paramagx);
        ap.f(paramRunnable);
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
  
  public static void a(final Context paramContext, final String paramString, agx paramagx, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106903);
    if (paramContext == null)
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (paramagx == null)
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (this.qNV.dataType == 15) {
          l.a(paramContext, paramString, this.qNV);
        }
        for (;;)
        {
          ap.f(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, this.qNV);
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
      ac.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
      ap.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
      ap.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (paramList.isEmpty())
    {
      ac.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
      ap.f(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = bs.S(this.qNS.split(",")).iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject3 = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
            if (localObject3 == null)
            {
              ac.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[] { Integer.valueOf(paramList.size()) });
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
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
                j.dck().X(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, com.tencent.mm.model.w.xt(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.nxC.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (agx)((Iterator)localObject1).next();
                  j.dck().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((agx)localObject2), 0, "", "", 0L, ((agx)localObject2).iaU);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAI;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((ahe)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((ahe)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((ahe)localObject1).dmN).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(bs.bG(((ahe)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(bs.bG(((ahe)localObject1).dry, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                j.dck().X(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((agx)localObject7).Ezm;
                ((WXMusicObject)localObject1).musicDataUrl = ((agx)localObject7).Ezo;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((agx)localObject7).Ezq;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((agx)localObject7).Ezq;
                ((WXMusicObject)localObject1).songAlbumUrl = ((agx)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((agx)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((agx)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((agx)localObject7).desc;
                localObject2 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.a((agx)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = bs.bG(((agx)localObject7).dbZ, "");
                  localObject1 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EBJ.appId;
                localObject2 = ag.a.hnu.s((Context)localObject6, (String)localObject1);
                ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  ac.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAK;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EBJ;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((aic)localObject7).title;
                    localObject2 = ((aic)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (bs.isNullOrNil((String)localObject2)) {
                      localObject1 = bs.bG(((agx)localObject5).dbZ, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (bs.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((agx)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((aic)localObject7).desc;
                  }
                  if (bs.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((agx)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAK != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAK.ECl;
                  }
                  if ((localObject8 != null) && (bs.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((aht)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).qIl) && (bs.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((agx)localObject5).Ezm;
                  }
                  if (!bs.isNullOrNil(((agx)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((agx)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).dvl = ((aht)localObject8).cYF;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.CoY != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.CoY;
                    localObject2 = new com.tencent.mm.ah.e();
                    ((com.tencent.mm.ah.e)localObject2).hgY = ((ahf)localObject1).hgY;
                    ((com.tencent.mm.ah.e)localObject2).hhb = ((ahf)localObject1).hhb;
                    if (bs.isNullOrNil(((k.b)localObject6).dvl)) {
                      ((k.b)localObject6).dvl = ((ahf)localObject1).ddo;
                    }
                    if (((ahf)localObject1).hgY == 5)
                    {
                      ((com.tencent.mm.ah.e)localObject2).hhd = ((ahf)localObject1).hhd;
                      ((com.tencent.mm.ah.e)localObject2).hgZ = ((ahf)localObject1).hgZ;
                      ((com.tencent.mm.ah.e)localObject2).duration = ((ahf)localObject1).duration;
                      ((com.tencent.mm.ah.e)localObject2).videoWidth = ((ahf)localObject1).videoWidth;
                      ((com.tencent.mm.ah.e)localObject2).videoHeight = ((ahf)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.ah.f)localObject2);
                  }
                  if ((localObject7 != null) && (!bs.isNullOrNil(((aic)localObject7).ECq)))
                  {
                    localObject1 = bv.L(((aic)localObject7).ECq, "websearch");
                    localObject2 = new aa();
                    ((aa)localObject2).BYK = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((aa)localObject2).BYL = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((aa)localObject2).BYM = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((aa)localObject2).BYN = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((aa)localObject2).BYO = bs.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((aa)localObject2).pBl = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((aa)localObject2).pBm = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((aa)localObject2).tcG = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((aa)localObject2).BYP = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((aa)localObject2).BYQ = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((aa)localObject2).BYR = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((aa)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((aa)localObject2).kRU = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((aa)localObject2).BYS = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((aa)localObject2).BYT = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((aa)localObject2).BYU = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((aa)localObject2).BYV = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((aa)localObject2).BYW = bs.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((aa)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((aa)localObject2).BYX = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.ah.f)localObject2);
                  }
                  ((k.b)localObject6).dvs = ((agx)localObject5).dvs;
                  localObject2 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.a((agx)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label1765;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((aic)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (bs.isNullOrNil((String)localObject1)) {
                      localObject2 = bs.bG(((agx)localObject5).dbZ, "");
                    }
                    localObject1 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + u.axw() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = y.xJ((String)localObject2);
                    localObject8 = y.ayq().F((String)localObject7, true);
                    ((y.b)localObject8).l("prePublishId", localObject2);
                    ((y.b)localObject8).l("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((y.b)localObject8).l("sendAppMsgScene", Integer.valueOf(1));
                    ((y.b)localObject8).l("adExtStr", ((agx)localObject5).dvs);
                    j.dck().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAM;
                localObject3 = new ov();
                ((ov)localObject3).dro.opType = 0;
                ((ov)localObject3).dro.drq = ((ahm)localObject2).info;
                ((ov)localObject3).dro.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((ov)localObject3).drp.dbS)
                {
                  localObject2 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(bs.bG(((ahm)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bs.readFromFile(((ov)localObject3).drp.thumbPath);
                  }
                  j.dck().a(str, (byte[])localObject1, ((ov)localObject3).drp.drr, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAO;
                localObject3 = new vq();
                ((vq)localObject3).dyu.opType = 0;
                ((vq)localObject3).dyu.dyw = ((ahw)localObject2).info;
                ((vq)localObject3).dyu.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                ac.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((vq)localObject3).dyv.dbS), ((ahw)localObject2).thumbUrl });
                if (((vq)localObject3).dyv.dbS)
                {
                  localObject2 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(bs.bG(((ahw)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bs.readFromFile(((vq)localObject3).dyv.thumbPath);
                  }
                  j.dck().a(str, (byte[])localObject1, ((vq)localObject3).dyv.drr, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAM;
                localObject3 = new ov();
                ((ov)localObject3).dro.opType = 1;
                ((ov)localObject3).dro.drq = ((ahm)localObject2).info;
                ((ov)localObject3).dro.context = ((Context)localObject1);
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                if (((ov)localObject3).drp.dbS)
                {
                  localObject2 = bs.readFromFile(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(bs.bG(((ahm)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = bs.readFromFile(((ov)localObject3).drp.thumbPath);
                  }
                  j.dck().a(str, (byte[])localObject1, ((ov)localObject3).drp.drr, null);
                }
                break;
              case 20: 
                localObject1 = f.qMB;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  ac.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (c.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAX))
                {
                  ac.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.EAX;
                  localObject1 = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(((agv)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).hke = ((agv)localObject2).username;
                    ((k.b)localObject5).hkd = ((agv)localObject2).cYQ;
                    ((k.b)localObject5).hkf = ((agv)localObject2).appId;
                    ((k.b)localObject5).hkq = ((agv)localObject2).dib;
                    ((k.b)localObject5).hkr = ((agv)localObject2).version;
                    ((k.b)localObject5).hkg = 2;
                    ((k.b)localObject5).hkn = ((agv)localObject2).jWX;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).Hx(((agv)localObject2).appId);
                    ((k.b)localObject5).hks = ((agv)localObject2).iconUrl;
                    ((k.b)localObject5).dvr = ("wxapp_" + ((agv)localObject2).appId + ((agv)localObject2).cYQ);
                    ((k.b)localObject5).dvl = ((agv)localObject2).username;
                    ((k.b)localObject5).dvm = ((String)localObject1);
                    localObject1 = new com.tencent.mm.ah.a();
                    ((com.tencent.mm.ah.a)localObject1).hfZ = ((agv)localObject2).ccR;
                    ((com.tencent.mm.ah.a)localObject1).hgb = ((agv)localObject2).dxK;
                    ((com.tencent.mm.ah.a)localObject1).hgc = ((agv)localObject2).subType;
                    ((k.b)localObject5).a((com.tencent.mm.ah.f)localObject1);
                    ((k.b)localObject5).type = 33;
                    localObject1 = new byte[0];
                    localObject6 = o.a(com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3), (com.tencent.mm.plugin.fav.a.g)localObject3);
                    if ((localObject6 == null) || (((Bitmap)localObject6).isRecycled())) {
                      break label2762;
                    }
                    ac.i("MicroMsg.FavAppBrandLogic", "thumb image is not null ");
                    localObject3 = Bitmap.createBitmap(((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), Bitmap.Config.ARGB_8888);
                    localObject1 = new Canvas((Bitmap)localObject3);
                    ((Canvas)localObject1).drawColor(-1);
                    ((Canvas)localObject1).drawBitmap((Bitmap)localObject6, 0.0F, 0.0F, null);
                    localObject1 = new ByteArrayOutputStream();
                    ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
                    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
                    ac.i("MicroMsg.FavAppBrandLogic", "bitmap recycle %s", new Object[] { localObject3 });
                    ((Bitmap)localObject3).recycle();
                  }
                  for (;;)
                  {
                    w.a.awq().a((k.b)localObject5, ((agv)localObject2).appId, "", str, "", (byte[])localObject1);
                    break;
                    localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131755945);
                    break label2377;
                    ac.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                  }
                }
                break;
              case 14: 
              case 18: 
                ac.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
                localObject1 = l.a.a(paramContext, (com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject2 = new ahn();
                try
                {
                  ac.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((ahn)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((ahn)localObject2).nxC;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (agx)((Iterator)localObject5).next();
                    if ((((agx)localObject6).EzZ != null) && (((agx)localObject6).EzZ.EAX != null) && (c.a(((agx)localObject6).EzZ.EAX)))
                    {
                      ((agx)localObject6).XM(1);
                      ((agx)localObject6).aID(paramContext.getString(2131755833));
                      ((LinkedList)localObject3).set(i, localObject6);
                      ((ahn)localObject2).bk((LinkedList)localObject3);
                    }
                    i += 1;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    ac.printErrStackTrace("MicroMsg.FavSendLogic", localException, "", new Object[0]);
                    ac.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[] { localException.getMessage() });
                  }
                  localObject4 = new pw();
                  ((pw)localObject4).dsN.type = 2;
                  ((pw)localObject4).dsN.toUser = str;
                  ((pw)localObject4).dsN.dsQ = ((ahn)localObject2);
                  ((pw)localObject4).dsN.title = ((l.a)localObject1).title;
                  ((pw)localObject4).dsN.desc = ((l.a)localObject1).desc;
                  ((pw)localObject4).dsN.thumbPath = ((l.a)localObject1).thumbPath;
                  ((pw)localObject4).dsN.dsU = ((l.a)localObject1).qNY;
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject4);
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = bo.a.aOk((String)localObject1);
                localObject4 = j.dck();
                if (com.tencent.mm.storage.ai.aNc(((bo.a)localObject2).zTO)) {}
                for (i = 66;; i = 42)
                {
                  ((com.tencent.mm.plugin.messenger.a.e)localObject4).X(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!bs.isNullOrNil(paramString2)) {
            j.dck().X(str, paramString2, com.tencent.mm.model.w.xt(str));
          }
        }
        ap.f(paramRunnable);
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
  
  public static boolean j(agx paramagx)
  {
    AppMethodBeat.i(106902);
    if ((paramagx != null) && (!bs.isNullOrNil(paramagx.Ezu)) && ((bs.lr(paramagx.Ezu, ".htm")) || (bs.lr(paramagx.Ezu, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(agx paramagx)
  {
    AppMethodBeat.i(106905);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(paramagx));
    if (locale.exists()) {}
    for (paramagx = q.B(locale.fxV());; paramagx = com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(bs.bG(paramagx.dbZ, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramagx;
    }
  }
  
  public static final class a
  {
    public String desc;
    public String qNY;
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
        localIterator = paramg.field_favProto.nxC.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (agx)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((agx)localObject1)))
          {
            int k = localSparseIntArray.get(((agx)localObject1).dataType);
            localSparseIntArray.put(((agx)localObject1).dataType, k + 1);
            switch (((agx)localObject1).dataType)
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
                localObject1 = ((agx)localObject1).desc;
                if (!bs.isNullOrNil((String)localObject1))
                {
                  localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                  localLinkedList.add((String)localObject1 + "\n");
                }
              }
              break;
            case 3: 
              if (localLinkedList.size() < 4)
              {
                k = (int)com.tencent.mm.plugin.fav.a.b.tx(((agx)localObject1).duration);
                localLinkedList.add(paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(k) }) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((agx)localObject1);
                if (acW((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((agx)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((agx)localObject1).EzZ.EAI;
                localObject2 = new StringBuilder().append(paramContext.getString(2131755806));
                if ((!bs.isNullOrNil(b((ahe)localObject1))) && (!b((ahe)localObject1).equals(paramContext.getString(2131760739)))) {
                  break label549;
                }
              }
              for (localObject1 = a((ahe)localObject1);; localObject1 = b((ahe)localObject1))
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
                localLinkedList.add(paramContext.getString(2131755773) + ((agx)localObject1).title + "\n");
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
                localLinkedList.add(paramContext.getString(2131755279) + ((agx)localObject1).title + "\n");
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
      Iterator localIterator = paramg.field_favProto.nxC.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (agx)localIterator.next();
        j = localSparseIntArray.get(((agx)localObject2).dataType);
        localSparseIntArray.put(((agx)localObject2).dataType, j + 1);
        switch (((agx)localObject2).dataType)
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
            localLinkedList.add(((agx)localObject2).EAb + ":" + ((agx)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4)
          {
            j = (int)com.tencent.mm.plugin.fav.a.b.qw(((agx)localObject2).duration);
            localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755929) + paramContext.getString(2131758835, new Object[] { Integer.valueOf(j) }) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755853) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((agx)localObject2);
            if (!acW(paramg)) {
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
          localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755920) + ((agx)localObject2).title + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((agx)localObject2);
        if (acW(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
          break;
        }
        paramg = ((agx)localObject2).EzZ.EAK;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (bs.isNullOrNil(paramg)) {
            localObject1 = bs.bG(((agx)localObject2).dbZ, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.cph()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755920) + ((agx)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755895) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((agx)localObject2);
        if (acW(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755926) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((agx)localObject2);
          if (acW(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((agx)localObject2).EzZ.EAI;
              localObject1 = new StringBuilder().append(((agx)localObject2).EAb).append(":").append(paramContext.getString(2131755806));
              if ((!bs.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(2131760739)))) {
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
              localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755820) + ((agx)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((agx)localObject2).dbZ);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755773) + ((agx)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755858) + ((agx)localObject2).EzZ.EAM.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((agx)localObject2).EzZ.EAM;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755278) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((agx)localObject2).EzZ.EAO;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755782) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.qNY = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alw(((agx)localObject2).desc).zTO;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755872) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((agx)localObject2).EzZ.EAX != null) && (((agx)localObject2).EzZ.EAX.type == 3))
            {
              localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755833) + "\n");
              break;
            }
            localLinkedList.add(((agx)localObject2).EAb + ":" + paramContext.getString(2131755279) + ((agx)localObject2).title + "\n");
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
    
    private static String a(ahe paramahe)
    {
      AppMethodBeat.i(106896);
      if (paramahe == null)
      {
        ac.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramahe = paramahe.label;
      AppMethodBeat.o(106896);
      return paramahe;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(bs.bG(paramString, "").getBytes());
      if (acW(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static boolean acW(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new com.tencent.mm.vfs.e(paramString).exists();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    private static String b(ahe paramahe)
    {
      AppMethodBeat.i(106897);
      if (paramahe == null)
      {
        ac.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramahe = paramahe.dry;
      AppMethodBeat.o(106897);
      return paramahe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */