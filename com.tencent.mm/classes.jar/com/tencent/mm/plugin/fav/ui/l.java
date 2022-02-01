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
import com.tencent.mm.ag.a;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.px.b;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.g.a.xn.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.fav.a.an.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final aml paramaml, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106904);
    if (paramContext == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
      AppMethodBeat.o(106904);
      return;
    }
    if (paramg == null) {
      Log.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
    }
    if (paramaml == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(this.dnJ, paramg, paramaml);
        MMHandlerThread.postToMainThread(paramRunnable);
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
  
  public static void a(final Context paramContext, final String paramString, aml paramaml, final Runnable paramRunnable)
  {
    AppMethodBeat.i(106903);
    if (paramContext == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
      AppMethodBeat.o(106903);
      return;
    }
    if (paramaml == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (this.tfL.dataType == 15) {
          l.a(paramContext, paramString, this.tfL);
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, this.tfL);
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
      Log.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(106901);
      return;
    }
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = Util.stringsToList(this.tfI.split(",")).iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject3 = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
            if (localObject3 == null)
            {
              Log.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[] { Integer.valueOf(paramList.size()) });
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
              Object localObject1;
              Object localObject2;
              Object localObject6;
              Object localObject7;
              Object localObject5;
              label2237:
              int i;
              label2849:
              label3234:
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
                com.tencent.mm.plugin.messenger.a.g.eir().ad(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, com.tencent.mm.model.ab.JG(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ppH.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (aml)((Iterator)localObject1).next();
                  com.tencent.mm.plugin.messenger.a.g.eir().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((aml)localObject2), 0, "", "", 0L, ((aml)localObject2).jsz);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwQ;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((ams)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((ams)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((ams)localObject1).dRt).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(Util.nullAs(((ams)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(Util.nullAs(((ams)localObject1).dWi, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                com.tencent.mm.plugin.messenger.a.g.eir().ad(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((aml)localObject7).Lvu;
                ((WXMusicObject)localObject1).musicDataUrl = ((aml)localObject7).Lvw;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((aml)localObject7).Lvy;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((aml)localObject7).Lvy;
                ((WXMusicObject)localObject1).songAlbumUrl = ((aml)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((aml)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((aml)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((aml)localObject7).desc;
                localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((aml)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = Util.nullAs(((aml)localObject7).dFN, "");
                  localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Lya.appId;
                localObject2 = am.a.iDo.r((Context)localObject6, (String)localObject1);
                ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 21: 
                localObject7 = paramContext;
                localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((aml)localObject5).Lvu;
                ((WXMusicObject)localObject1).musicDataUrl = ((aml)localObject5).Lvw;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((aml)localObject5).Lvy;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((aml)localObject5).Lvy;
                ((WXMusicObject)localObject1).songAlbumUrl = ((aml)localObject5).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((aml)localObject5).songLyric;
                localObject6 = new WXMediaMessage();
                ((WXMediaMessage)localObject6).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject6).title = ((aml)localObject5).title;
                ((WXMediaMessage)localObject6).description = ((aml)localObject5).desc;
                localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((aml)localObject5));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = Util.nullAs(((aml)localObject5).dFN, "");
                  localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject6).thumbData = ((byte[])localObject1);
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Lya.appId;
                localObject3 = am.a.iDo.r((Context)localObject7, (String)localObject2);
                localObject1 = new k.b();
                ((k.b)localObject1).title = ((aml)localObject5).title;
                ((k.b)localObject1).description = ((aml)localObject5).desc;
                ((k.b)localObject1).url = ((aml)localObject5).Lvu;
                ((k.b)localObject1).iwH = ((aml)localObject5).Lvy;
                ((k.b)localObject1).ixd = ((aml)localObject5).Lvw;
                ((k.b)localObject1).ixe = ((aml)localObject5).Lvy;
                ((k.b)localObject1).appId = ((String)localObject2);
                ((k.b)localObject1).type = 76;
                ((k.b)localObject1).appName = ((String)localObject3);
                ((k.b)localObject1).iwL = 3;
                if ((localObject5 != null) && (((aml)localObject5).Lwh != null))
                {
                  localObject2 = ((aml)localObject5).Lwh.Lxs;
                  if (localObject2 != null)
                  {
                    localObject3 = new com.tencent.mm.pluginsdk.ui.tools.b();
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songAlbumUrl = ((aml)localObject5).songAlbumUrl;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songLyric = ((aml)localObject5).songLyric;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktn = ((css)localObject2).Ktn;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Kto = ((css)localObject2).Kto;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktp = ((css)localObject2).Ktp;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktq = ((css)localObject2).Ktq;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktr = ((css)localObject2).singerName;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Kts = ((css)localObject2).albumName;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktt = ((css)localObject2).musicGenre;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktu = String.valueOf(((css)localObject2).issueDate);
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktv = ((css)localObject2).identification;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Alz = ((css)localObject2).Alz;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ktw = ((css)localObject2).extraInfo;
                    ((k.b)localObject1).a((com.tencent.mm.ag.f)localObject3);
                  }
                }
                ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a((k.b)localObject1, (WXMediaMessage)localObject6, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  Log.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwS;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Lya;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((anq)localObject7).title;
                    localObject2 = ((anq)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (Util.isNullOrNil((String)localObject2)) {
                      localObject1 = Util.nullAs(((aml)localObject5).dFN, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (Util.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((aml)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((anq)localObject7).desc;
                  }
                  if (Util.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((aml)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwS != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwS.LyC;
                  }
                  if ((localObject8 != null) && (Util.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((anh)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).tad) && (Util.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((aml)localObject5).Lvu;
                  }
                  if (!Util.isNullOrNil(((aml)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((aml)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).eag = ((anh)localObject8).dCl;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.IXu != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.IXu;
                    localObject2 = new e();
                    ((e)localObject2).iwc = ((amt)localObject1).iwc;
                    ((e)localObject2).iwf = ((amt)localObject1).iwf;
                    if (Util.isNullOrNil(((k.b)localObject6).eag)) {
                      ((k.b)localObject6).eag = ((amt)localObject1).dHc;
                    }
                    if (((amt)localObject1).iwc == 5)
                    {
                      ((e)localObject2).vid = ((amt)localObject1).vid;
                      ((e)localObject2).iwd = ((amt)localObject1).iwd;
                      ((e)localObject2).duration = ((amt)localObject1).duration;
                      ((e)localObject2).videoWidth = ((amt)localObject1).videoWidth;
                      ((e)localObject2).videoHeight = ((amt)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.ag.f)localObject2);
                  }
                  if ((localObject7 != null) && (!Util.isNullOrNil(((anq)localObject7).LyH)))
                  {
                    localObject1 = XmlParser.parseXml(((anq)localObject7).LyH, "websearch", null);
                    localObject2 = new aj();
                    ((aj)localObject2).IEy = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((aj)localObject2).IEz = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((aj)localObject2).IEA = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((aj)localObject2).IEB = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((aj)localObject2).IEC = Util.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((aj)localObject2).rCq = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((aj)localObject2).msN = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((aj)localObject2).xDQ = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((aj)localObject2).IED = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((aj)localObject2).IEE = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((aj)localObject2).IEF = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((aj)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((aj)localObject2).eby = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((aj)localObject2).IEG = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((aj)localObject2).IEH = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((aj)localObject2).IEI = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((aj)localObject2).IEJ = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((aj)localObject2).IEK = Util.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((aj)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((aj)localObject2).IEL = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.ag.f)localObject2);
                  }
                  ((k.b)localObject6).ean = ((aml)localObject5).ean;
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((aml)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label2237;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((anq)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (Util.isNullOrNil((String)localObject1)) {
                      localObject2 = Util.nullAs(((aml)localObject5).dFN, "");
                    }
                    localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + z.aTY() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = ad.JX((String)localObject2);
                    localObject8 = ad.aVe().G((String)localObject7, true);
                    ((ad.b)localObject8).l("prePublishId", localObject2);
                    ((ad.b)localObject8).l("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((ad.b)localObject8).l("sendAppMsgScene", Integer.valueOf(1));
                    ((ad.b)localObject8).l("adExtStr", ((aml)localObject5).ean);
                    com.tencent.mm.plugin.messenger.a.g.eir().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwU;
                localObject3 = new px();
                ((px)localObject3).dVZ.opType = 0;
                ((px)localObject3).dVZ.dWb = ((ana)localObject2).info;
                ((px)localObject3).dVZ.context = ((Context)localObject1);
                EventCenter.instance.publish((IEvent)localObject3);
                if (((px)localObject3).dWa.dFE)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((ana)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((px)localObject3).dWa.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.eir().a(str, (byte[])localObject1, ((px)localObject3).dWa.dWc, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwW;
                localObject3 = new xn();
                ((xn)localObject3).edL.opType = 0;
                ((xn)localObject3).edL.edN = ((ank)localObject2).info;
                ((xn)localObject3).edL.context = ((Context)localObject1);
                EventCenter.instance.publish((IEvent)localObject3);
                Log.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((xn)localObject3).edM.dFE), ((ank)localObject2).thumbUrl });
                if (((xn)localObject3).edM.dFE)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((ank)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((xn)localObject3).edM.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.eir().a(str, (byte[])localObject1, ((xn)localObject3).edM.dWc, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.LwU;
                localObject3 = new px();
                ((px)localObject3).dVZ.opType = 1;
                ((px)localObject3).dVZ.dWb = ((ana)localObject2).info;
                ((px)localObject3).dVZ.context = ((Context)localObject1);
                EventCenter.instance.publish((IEvent)localObject3);
                if (((px)localObject3).dWa.dFE)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((ana)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((px)localObject3).dWa.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.eir().a(str, (byte[])localObject1, ((px)localObject3).dWa.dWc, null);
                }
                break;
              case 20: 
                localObject1 = f.teu;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  Log.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (c.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Lxf))
                {
                  Log.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Lxf;
                  localObject1 = ((q)com.tencent.mm.kernel.g.af(q.class)).Xk(((amj)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).izi = ((amj)localObject2).username;
                    ((k.b)localObject5).izh = ((amj)localObject2).dCx;
                    ((k.b)localObject5).izj = ((amj)localObject2).appId;
                    ((k.b)localObject5).izz = ((amj)localObject2).dMe;
                    ((k.b)localObject5).izA = ((amj)localObject2).version;
                    ((k.b)localObject5).izk = 2;
                    ((k.b)localObject5).izr = ((amj)localObject2).lyE;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).Ur(((amj)localObject2).appId);
                    ((k.b)localObject5).izB = ((amj)localObject2).iconUrl;
                    ((k.b)localObject5).eam = ("wxapp_" + ((amj)localObject2).appId + ((amj)localObject2).dCx);
                    ((k.b)localObject5).eag = ((amj)localObject2).username;
                    ((k.b)localObject5).eah = ((String)localObject1);
                    localObject1 = new a();
                    ((a)localObject1).ivc = ((amj)localObject2).leb;
                    ((a)localObject1).ive = ((amj)localObject2).eda;
                    ((a)localObject1).ivf = ((amj)localObject2).subType;
                    ((k.b)localObject5).a((com.tencent.mm.ag.f)localObject1);
                    ((k.b)localObject5).type = 33;
                    localObject1 = new byte[0];
                    localObject6 = o.a(com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3), (com.tencent.mm.plugin.fav.a.g)localObject3);
                    if ((localObject6 == null) || (((Bitmap)localObject6).isRecycled())) {
                      break label3234;
                    }
                    Log.i("MicroMsg.FavAppBrandLogic", "thumb image is not null ");
                    localObject3 = Bitmap.createBitmap(((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), Bitmap.Config.ARGB_8888);
                    localObject1 = new Canvas((Bitmap)localObject3);
                    ((Canvas)localObject1).drawColor(-1);
                    ((Canvas)localObject1).drawBitmap((Bitmap)localObject6, 0.0F, 0.0F, null);
                    localObject1 = new ByteArrayOutputStream();
                    ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
                    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
                    Log.i("MicroMsg.FavAppBrandLogic", "bitmap recycle %s", new Object[] { localObject3 });
                    ((Bitmap)localObject3).recycle();
                  }
                  for (;;)
                  {
                    w.a.aSz().a((k.b)localObject5, ((amj)localObject2).appId, "", str, "", (byte[])localObject1);
                    break;
                    localObject1 = MMApplicationContext.getContext().getString(2131756040);
                    break label2849;
                    Log.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                  }
                }
                break;
              case 14: 
              case 18: 
                Log.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
                localObject1 = l.a.a(paramContext, (com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject2 = new anb();
                try
                {
                  Log.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((anb)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((anb)localObject2).ppH;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (aml)((Iterator)localObject5).next();
                    if ((((aml)localObject6).Lwh != null) && (((aml)localObject6).Lwh.Lxf != null) && (c.a(((aml)localObject6).Lwh.Lxf)))
                    {
                      ((aml)localObject6).ajd(1);
                      ((aml)localObject6).bgg(paramContext.getString(2131755919));
                      ((LinkedList)localObject3).set(i, localObject6);
                      ((anb)localObject2).bH((LinkedList)localObject3);
                    }
                    i += 1;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.FavSendLogic", localException, "", new Object[0]);
                    Log.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[] { localException.getMessage() });
                  }
                  localObject4 = new rc();
                  ((rc)localObject4).dXF.type = 2;
                  ((rc)localObject4).dXF.toUser = str;
                  ((rc)localObject4).dXF.dXI = ((anb)localObject2);
                  ((rc)localObject4).dXF.title = ((l.a)localObject1).title;
                  ((rc)localObject4).dXF.desc = ((l.a)localObject1).desc;
                  ((rc)localObject4).dXF.thumbPath = ((l.a)localObject1).thumbPath;
                  ((rc)localObject4).dXF.dXL = ((l.a)localObject1).tfO;
                  EventCenter.instance.publish((IEvent)localObject4);
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = ca.a.bkA((String)localObject1);
                localObject4 = com.tencent.mm.plugin.messenger.a.g.eir();
                if (as.bjp(((ca.a)localObject2).dkU)) {}
                for (i = 66;; i = 42)
                {
                  ((com.tencent.mm.plugin.messenger.a.d)localObject4).ad(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!Util.isNullOrNil(paramString2)) {
            com.tencent.mm.plugin.messenger.a.g.eir().ad(str, paramString2, com.tencent.mm.model.ab.JG(str));
          }
        }
        MMHandlerThread.postToMainThread(paramRunnable);
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
  
  public static void g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(235320);
    WXFileObject localWXFileObject = new WXFileObject();
    localWXFileObject.setFilePath(paramString2);
    paramString2 = new WXMediaMessage();
    paramString2.mediaObject = localWXFileObject;
    paramString2.title = paramString3;
    paramString2.description = paramString4;
    paramString2.thumbData = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.EX(paramString5));
    ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(paramString2, "", "", paramString1);
    AppMethodBeat.o(235320);
  }
  
  public static boolean j(aml paramaml)
  {
    AppMethodBeat.i(106902);
    if ((paramaml != null) && (!Util.isNullOrNil(paramaml.LvC)) && ((Util.isEqual(paramaml.LvC, ".htm")) || (Util.isEqual(paramaml.LvC, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(aml paramaml)
  {
    AppMethodBeat.i(106905);
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.a(paramaml));
    if (localo.exists()) {}
    for (paramaml = aa.z(localo.her());; paramaml = com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(paramaml.dFN, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramaml;
    }
  }
  
  public static final class a
  {
    public String desc;
    public String tfO;
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
        localIterator = paramg.field_favProto.ppH.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (aml)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((aml)localObject1)))
          {
            int k = localSparseIntArray.get(((aml)localObject1).dataType);
            localSparseIntArray.put(((aml)localObject1).dataType, k + 1);
            switch (((aml)localObject1).dataType)
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
                localObject1 = ((aml)localObject1).desc;
                if (!Util.isNullOrNil((String)localObject1))
                {
                  localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                  localLinkedList.add((String)localObject1 + "\n");
                }
              }
              break;
            case 3: 
              if (localLinkedList.size() < 4)
              {
                k = (int)com.tencent.mm.plugin.fav.a.b.DO(((aml)localObject1).duration);
                localLinkedList.add(paramContext.getString(2131756022) + paramContext.getString(2131759158, new Object[] { Integer.valueOf(k) }) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((aml)localObject1);
                if (asq((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((aml)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((aml)localObject1).Lwh.LwQ;
                localObject2 = new StringBuilder().append(paramContext.getString(2131755888));
                if ((!Util.isNullOrNil(b((ams)localObject1))) && (!b((ams)localObject1).equals(paramContext.getString(2131762480)))) {
                  break label549;
                }
              }
              for (localObject1 = a((ams)localObject1);; localObject1 = b((ams)localObject1))
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
                localLinkedList.add(paramContext.getString(2131755851) + ((aml)localObject1).title + "\n");
              }
              if (i == 0) {
                i = 1;
              }
              break;
            case 4: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131756018) + "\n");
              }
              break;
            case 17: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131755961) + "\n");
              }
              break;
            case 19: 
              label549:
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(2131755314) + ((aml)localObject1).title + "\n");
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
      Iterator localIterator = paramg.field_favProto.ppH.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (aml)localIterator.next();
        j = localSparseIntArray.get(((aml)localObject2).dataType);
        localSparseIntArray.put(((aml)localObject2).dataType, j + 1);
        switch (((aml)localObject2).dataType)
        {
        case 9: 
        case 12: 
        case 13: 
        case 18: 
        case 20: 
        case 21: 
        case 23: 
        case 24: 
        case 25: 
        default: 
          break;
        case 1: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aml)localObject2).Lwj + ":" + ((aml)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4)
          {
            j = (int)com.tencent.mm.plugin.fav.a.b.AO(((aml)localObject2).duration);
            localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131756022) + paramContext.getString(2131759158, new Object[] { Integer.valueOf(j) }) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755939) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((aml)localObject2);
            if (!asq(paramg)) {
              break label2645;
            }
            locala.thumbPath = paramg;
            i = 1;
          }
          break;
        }
      }
      label2645:
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131756012) + ((aml)localObject2).title + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((aml)localObject2);
        if (asq(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
          break;
        }
        paramg = ((aml)localObject2).Lwh.LwS;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (Util.isNullOrNil(paramg)) {
            localObject1 = Util.nullAs(((aml)localObject2).dFN, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.cUq()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131756012) + ((aml)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755987) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((aml)localObject2);
        if (asq(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131756018) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((aml)localObject2);
          if (asq(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((aml)localObject2).Lwh.LwQ;
              localObject1 = new StringBuilder().append(((aml)localObject2).Lwj).append(":").append(paramContext.getString(2131755888));
              if ((!Util.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(2131762480)))) {
                break label1877;
              }
            }
            label1877:
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
              localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755905) + ((aml)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((aml)localObject2).dFN);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755851) + ((aml)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755947) + ((aml)localObject2).Lwh.LwU.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((aml)localObject2).Lwh.LwU;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755313) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((aml)localObject2).Lwh.LwW;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755862) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.tfO = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(((aml)localObject2).desc).dkU;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755961) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((aml)localObject2).Lwh.Lxf != null) && (((aml)localObject2).Lwh.Lxf.type == 3))
            {
              localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755919) + "\n");
              break;
            }
            localLinkedList.add(((aml)localObject2).Lwj + ":" + paramContext.getString(2131755314) + ((aml)localObject2).title + "\n");
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
    
    private static String a(ams paramams)
    {
      AppMethodBeat.i(106896);
      if (paramams == null)
      {
        Log.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramams = paramams.label;
      AppMethodBeat.o(106896);
      return paramams;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(paramString, "").getBytes());
      if (asq(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static boolean asq(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new com.tencent.mm.vfs.o(paramString).exists();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    private static String b(ams paramams)
    {
      AppMethodBeat.i(106897);
      if (paramams == null)
      {
        Log.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramams = paramams.dWi;
      AppMethodBeat.o(106897);
      return paramams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */