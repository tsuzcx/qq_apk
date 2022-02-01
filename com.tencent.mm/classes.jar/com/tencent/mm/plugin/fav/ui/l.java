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
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.f.a.qv;
import com.tencent.mm.f.a.qv.b;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.yt;
import com.tencent.mm.f.a.yt.b;
import com.tencent.mm.model.ab;
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
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ao.a;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final anm paramanm, final Runnable paramRunnable)
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
    if (paramanm == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(this.ffX, paramg, paramanm);
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
  
  public static void a(final Context paramContext, final String paramString, anm paramanm, final Runnable paramRunnable)
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
    if (paramanm == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (this.wMa.dataType == 15) {
          l.a(paramContext, paramString, this.wMa);
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, this.wMa);
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
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = Util.stringsToList(this.wLX.split(",")).iterator();
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
              com.tencent.mm.plugin.report.service.h.IzE.a(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
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
                com.tencent.mm.plugin.messenger.a.g.eRW().ai(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, ab.QZ(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.syG.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (anm)((Iterator)localObject1).next();
                  com.tencent.mm.plugin.messenger.a.g.eRW().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((anm)localObject2), 0, "", "", 0L, ((anm)localObject2).mic);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szp;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((ant)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((ant)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((ant)localObject1).fKJ).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(Util.nullAs(((ant)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(Util.nullAs(((ant)localObject1).fPN, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                com.tencent.mm.plugin.messenger.a.g.eRW().ai(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((anm)localObject7).SxU;
                ((WXMusicObject)localObject1).musicDataUrl = ((anm)localObject7).SxW;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((anm)localObject7).SxY;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((anm)localObject7).SxY;
                ((WXMusicObject)localObject1).songAlbumUrl = ((anm)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((anm)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((anm)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((anm)localObject7).desc;
                localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((anm)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = Util.nullAs(((anm)localObject7).fyu, "");
                  localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.SAB.appId;
                localObject2 = am.a.lto.t((Context)localObject6, (String)localObject1);
                ((ac)com.tencent.mm.kernel.h.ae(ac.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 21: 
                localObject7 = paramContext;
                localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((anm)localObject5).SxU;
                ((WXMusicObject)localObject1).musicDataUrl = ((anm)localObject5).SxW;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((anm)localObject5).SxY;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((anm)localObject5).SxY;
                ((WXMusicObject)localObject1).songAlbumUrl = ((anm)localObject5).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((anm)localObject5).songLyric;
                localObject6 = new WXMediaMessage();
                ((WXMediaMessage)localObject6).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject6).title = ((anm)localObject5).title;
                ((WXMediaMessage)localObject6).description = ((anm)localObject5).desc;
                localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((anm)localObject5));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = Util.nullAs(((anm)localObject5).fyu, "");
                  localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject6).thumbData = ((byte[])localObject1);
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.SAB.appId;
                localObject3 = am.a.lto.t((Context)localObject7, (String)localObject2);
                localObject1 = new k.b();
                ((k.b)localObject1).title = ((anm)localObject5).title;
                ((k.b)localObject1).description = ((anm)localObject5).desc;
                ((k.b)localObject1).url = ((anm)localObject5).SxU;
                ((k.b)localObject1).llW = ((anm)localObject5).SxY;
                ((k.b)localObject1).lms = ((anm)localObject5).SxW;
                ((k.b)localObject1).lmt = ((anm)localObject5).SxY;
                ((k.b)localObject1).appId = ((String)localObject2);
                ((k.b)localObject1).type = 76;
                ((k.b)localObject1).appName = ((String)localObject3);
                ((k.b)localObject1).lma = 3;
                if ((localObject5 != null) && (((anm)localObject5).SyG != null))
                {
                  localObject2 = ((anm)localObject5).SyG.SzR;
                  if (localObject2 != null)
                  {
                    localObject3 = new com.tencent.mm.pluginsdk.ui.tools.b();
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songAlbumUrl = ((anm)localObject5).songAlbumUrl;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songLyric = ((anm)localObject5).songLyric;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ruu = ((dbr)localObject2).Ruu;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ruv = ((dbr)localObject2).Ruv;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ruw = ((dbr)localObject2).Ruw;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Rux = ((dbr)localObject2).Rux;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ruy = ((dbr)localObject2).singerName;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).Ruz = ((dbr)localObject2).albumName;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).RuA = ((dbr)localObject2).musicGenre;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).RuB = String.valueOf(((dbr)localObject2).issueDate);
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).RuC = ((dbr)localObject2).identification;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).FSG = ((dbr)localObject2).FSG;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).RuD = ((dbr)localObject2).extraInfo;
                    ((k.b)localObject1).a((com.tencent.mm.aj.f)localObject3);
                  }
                }
                ((ac)com.tencent.mm.kernel.h.ae(ac.class)).a((k.b)localObject1, (WXMediaMessage)localObject6, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  Log.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szr;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.SAB;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((aor)localObject7).title;
                    localObject2 = ((aor)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (Util.isNullOrNil((String)localObject2)) {
                      localObject1 = Util.nullAs(((anm)localObject5).fyu, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (Util.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((anm)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((aor)localObject7).desc;
                  }
                  if (Util.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((anm)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szr != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szr.SBc;
                  }
                  if ((localObject8 != null) && (Util.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((aoi)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).wGh) && (Util.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((anm)localObject5).SxU;
                  }
                  if (!Util.isNullOrNil(((anm)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((anm)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).fUd = ((aoi)localObject8).fuO;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.PTL != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.PTL;
                    localObject2 = new e();
                    ((e)localObject2).llp = ((anu)localObject1).llp;
                    ((e)localObject2).lls = ((anu)localObject1).lls;
                    if (Util.isNullOrNil(((k.b)localObject6).fUd)) {
                      ((k.b)localObject6).fUd = ((anu)localObject1).fzT;
                    }
                    if (((anu)localObject1).llp == 5)
                    {
                      ((e)localObject2).vid = ((anu)localObject1).vid;
                      ((e)localObject2).llq = ((anu)localObject1).llq;
                      ((e)localObject2).duration = ((anu)localObject1).duration;
                      ((e)localObject2).videoWidth = ((anu)localObject1).videoWidth;
                      ((e)localObject2).videoHeight = ((anu)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.aj.f)localObject2);
                  }
                  if ((localObject7 != null) && (!Util.isNullOrNil(((aor)localObject7).SBh)))
                  {
                    localObject1 = XmlParser.parseXml(((aor)localObject7).SBh, "websearch", null);
                    localObject2 = new aj();
                    ((aj)localObject2).PyQ = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((aj)localObject2).PyR = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((aj)localObject2).PyS = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((aj)localObject2).PyT = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((aj)localObject2).PyU = Util.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((aj)localObject2).vhY = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((aj)localObject2).pqW = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((aj)localObject2).CHR = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((aj)localObject2).PyV = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((aj)localObject2).PyW = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((aj)localObject2).PyX = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((aj)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((aj)localObject2).fVx = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((aj)localObject2).PyY = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((aj)localObject2).PyZ = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((aj)localObject2).Pza = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((aj)localObject2).Pzb = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((aj)localObject2).Pzc = Util.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((aj)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((aj)localObject2).Pzd = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.aj.f)localObject2);
                  }
                  ((k.b)localObject6).fUk = ((anm)localObject5).fUk;
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((anm)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label2237;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((aor)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (Util.isNullOrNil((String)localObject1)) {
                      localObject2 = Util.nullAs(((anm)localObject5).fyu, "");
                    }
                    localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + z.bcZ() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = ad.Rp((String)localObject2);
                    localObject8 = ad.beh().I((String)localObject7, true);
                    ((ad.b)localObject8).k("prePublishId", localObject2);
                    ((ad.b)localObject8).k("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((ad.b)localObject8).k("sendAppMsgScene", Integer.valueOf(1));
                    ((ad.b)localObject8).k("adExtStr", ((anm)localObject5).fUk);
                    com.tencent.mm.plugin.messenger.a.g.eRW().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szt;
                localObject3 = new qv();
                ((qv)localObject3).fPE.opType = 0;
                ((qv)localObject3).fPE.fPG = ((aob)localObject2).fTp;
                ((qv)localObject3).fPE.context = ((Context)localObject1);
                EventCenter.instance.publish((IEvent)localObject3);
                if (((qv)localObject3).fPF.fyl)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((aob)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((qv)localObject3).fPF.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.eRW().a(str, (byte[])localObject1, ((qv)localObject3).fPF.fPH, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szv;
                localObject3 = new yt();
                ((yt)localObject3).fXU.opType = 0;
                ((yt)localObject3).fXU.fXW = ((aol)localObject2).fTp;
                ((yt)localObject3).fXU.context = ((Context)localObject1);
                EventCenter.instance.publish((IEvent)localObject3);
                Log.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((yt)localObject3).fXV.fyl), ((aol)localObject2).thumbUrl });
                if (((yt)localObject3).fXV.fyl)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((aol)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((yt)localObject3).fXV.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.eRW().a(str, (byte[])localObject1, ((yt)localObject3).fXV.fPH, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.Szt;
                localObject3 = new qv();
                ((qv)localObject3).fPE.opType = 1;
                ((qv)localObject3).fPE.fPG = ((aob)localObject2).fTp;
                ((qv)localObject3).fPE.context = ((Context)localObject1);
                EventCenter.instance.publish((IEvent)localObject3);
                if (((qv)localObject3).fPF.fyl)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((aob)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((qv)localObject3).fPF.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.eRW().a(str, (byte[])localObject1, ((qv)localObject3).fPF.fPH, null);
                }
                break;
              case 20: 
                localObject1 = f.wKG;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  Log.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (c.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.SzE))
                {
                  Log.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.SzE;
                  localObject1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(((ank)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).loA = ((ank)localObject2).username;
                    ((k.b)localObject5).loz = ((ank)localObject2).fve;
                    ((k.b)localObject5).loB = ((ank)localObject2).appId;
                    ((k.b)localObject5).loT = ((ank)localObject2).fES;
                    ((k.b)localObject5).loU = ((ank)localObject2).version;
                    ((k.b)localObject5).loC = 2;
                    ((k.b)localObject5).loJ = ((ank)localObject2).otE;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).aca(((ank)localObject2).appId);
                    ((k.b)localObject5).loV = ((ank)localObject2).iconUrl;
                    ((k.b)localObject5).fUj = ("wxapp_" + ((ank)localObject2).appId + ((ank)localObject2).fve);
                    ((k.b)localObject5).fUd = ((ank)localObject2).username;
                    ((k.b)localObject5).fUe = ((String)localObject1);
                    localObject1 = new a();
                    ((a)localObject1).lkl = ((ank)localObject2).nYp;
                    ((a)localObject1).lkn = ((ank)localObject2).fXg;
                    ((a)localObject1).lko = ((ank)localObject2).subType;
                    ((k.b)localObject5).a((com.tencent.mm.aj.f)localObject1);
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
                    w.a.bbx().a((k.b)localObject5, ((ank)localObject2).appId, "", str, "", (byte[])localObject1);
                    break;
                    localObject1 = MMApplicationContext.getContext().getString(s.i.appbrand_app_name);
                    break label2849;
                    Log.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                  }
                }
                break;
              case 14: 
              case 18: 
                Log.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
                localObject1 = l.a.a(paramContext, (com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject2 = new aoc();
                try
                {
                  Log.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((aoc)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((aoc)localObject2).syG;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (anm)((Iterator)localObject5).next();
                    if (((anm)localObject6).SyG != null)
                    {
                      if ((((anm)localObject6).SyG.SzE != null) && (c.a(((anm)localObject6).SyG.SzE)))
                      {
                        ((anm)localObject6).arq(1);
                        ((anm)localObject6).bsy(paramContext.getString(s.i.app_not_show));
                        ((LinkedList)localObject3).set(i, localObject6);
                        ((aoc)localObject2).cg((LinkedList)localObject3);
                      }
                      if ((((anm)localObject6).SyG.Szr != null) && (com.tencent.mm.plugin.fav.a.m.a(((anm)localObject6).SyG.Szr)))
                      {
                        ((anm)localObject6).arq(1);
                        ((anm)localObject6).bsy(paramContext.getString(s.i.app_not_show));
                        ((LinkedList)localObject3).set(i, localObject6);
                        ((aoc)localObject2).cg((LinkedList)localObject3);
                      }
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
                  localObject4 = new sc();
                  ((sc)localObject4).fRw.type = 2;
                  ((sc)localObject4).fRw.toUser = str;
                  ((sc)localObject4).fRw.fRz = ((aoc)localObject2);
                  ((sc)localObject4).fRw.title = ((l.a)localObject1).title;
                  ((sc)localObject4).fRw.desc = ((l.a)localObject1).desc;
                  ((sc)localObject4).fRw.thumbPath = ((l.a)localObject1).thumbPath;
                  ((sc)localObject4).fRw.fRC = ((l.a)localObject1).wMd;
                  EventCenter.instance.publish((IEvent)localObject4);
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = ca.a.bwZ((String)localObject1);
                localObject4 = com.tencent.mm.plugin.messenger.a.g.eRW();
                if (as.bvK(((ca.a)localObject2).fcC)) {}
                for (i = 66;; i = 42)
                {
                  ((d)localObject4).ai(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!Util.isNullOrNil(paramString2)) {
            com.tencent.mm.plugin.messenger.a.g.eRW().ai(str, paramString2, ab.QZ(str));
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
    AppMethodBeat.i(231318);
    WXFileObject localWXFileObject = new WXFileObject();
    localWXFileObject.setFilePath(paramString2);
    paramString2 = new WXMediaMessage();
    paramString2.mediaObject = localWXFileObject;
    paramString2.title = paramString3;
    paramString2.description = paramString4;
    paramString2.thumbData = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.LQ(paramString5));
    ((ac)com.tencent.mm.kernel.h.ae(ac.class)).a(paramString2, "", "", paramString1);
    AppMethodBeat.o(231318);
  }
  
  public static boolean j(anm paramanm)
  {
    AppMethodBeat.i(106902);
    if ((paramanm != null) && (!Util.isNullOrNil(paramanm.Syc)) && ((Util.isEqual(paramanm.Syc, ".htm")) || (Util.isEqual(paramanm.Syc, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(anm paramanm)
  {
    AppMethodBeat.i(106905);
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.fav.a.b.a(paramanm));
    if (localq.ifE()) {}
    for (paramanm = localq.bOF();; paramanm = com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(paramanm.fyu, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramanm;
    }
  }
  
  public static final class a
  {
    public String desc;
    public String thumbPath;
    public String title;
    public String wMd;
    
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
        localIterator = paramg.field_favProto.syG.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (anm)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((anm)localObject1)))
          {
            int k = localSparseIntArray.get(((anm)localObject1).dataType);
            localSparseIntArray.put(((anm)localObject1).dataType, k + 1);
            switch (((anm)localObject1).dataType)
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
                localObject1 = ((anm)localObject1).desc;
                if (!Util.isNullOrNil((String)localObject1))
                {
                  localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                  localLinkedList.add((String)localObject1 + "\n");
                }
              }
              break;
            case 3: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(s.i.app_voice) + m.N(paramContext, (int)com.tencent.mm.plugin.fav.a.b.Kc(((anm)localObject1).duration)) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((anm)localObject1);
                if (aAr((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((anm)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((anm)localObject1).SyG.Szp;
                localObject2 = new StringBuilder().append(paramContext.getString(s.i.app_location));
                if ((!Util.isNullOrNil(b((ant)localObject1))) && (!b((ant)localObject1).equals(paramContext.getString(s.i.location_sub_title_location_with_bracket)))) {
                  break label536;
                }
              }
              for (localObject1 = a((ant)localObject1);; localObject1 = b((ant)localObject1))
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
                localLinkedList.add(paramContext.getString(s.i.app_file) + ((anm)localObject1).title + "\n");
              }
              if (i == 0) {
                i = 1;
              }
              break;
            case 4: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(s.i.app_video) + "\n");
              }
              break;
            case 17: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(s.i.app_record) + "\n");
              }
              break;
            case 19: 
              label536:
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(s.i.app_app_brand) + ((anm)localObject1).title + "\n");
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
      Iterator localIterator = paramg.field_favProto.syG.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (anm)localIterator.next();
        j = localSparseIntArray.get(((anm)localObject2).dataType);
        localSparseIntArray.put(((anm)localObject2).dataType, j + 1);
        switch (((anm)localObject2).dataType)
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
            localLinkedList.add(((anm)localObject2).SyI + ":" + ((anm)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_voice) + m.N(paramContext, (int)com.tencent.mm.plugin.fav.a.b.Kc(((anm)localObject2).duration)) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_pic) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((anm)localObject2);
            if (!aAr(paramg)) {
              break label2713;
            }
            locala.thumbPath = paramg;
            i = 1;
          }
          break;
        }
      }
      label1937:
      label2713:
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4)
        {
          if ((((anm)localObject2).SyG.Szr == null) || (!com.tencent.mm.plugin.fav.a.m.a(((anm)localObject2).SyG.Szr))) {
            break label1465;
          }
          localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_not_show) + "\n");
        }
        while (i == 0)
        {
          paramg = com.tencent.mm.plugin.fav.a.b.a((anm)localObject2);
          if (!aAr(paramg)) {
            break label1522;
          }
          locala.thumbPath = paramg;
          i = 1;
          break;
          label1465:
          localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_url) + ((anm)localObject2).title + "\n");
        }
        label1522:
        paramg = ((anm)localObject2).SyG.Szr;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (Util.isNullOrNil(paramg)) {
            localObject1 = Util.nullAs(((anm)localObject2).fyu, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.djw()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_url) + ((anm)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_shortvideo) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((anm)localObject2);
        if (aAr(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_video) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((anm)localObject2);
          if (aAr(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((anm)localObject2).SyG.Szp;
              localObject1 = new StringBuilder().append(((anm)localObject2).SyI).append(":").append(paramContext.getString(s.i.app_location));
              if ((!Util.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(s.i.location_sub_title_location_with_bracket)))) {
                break label1937;
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
              localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_music) + ((anm)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((anm)localObject2).fyu);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_file) + ((anm)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_product) + ((anm)localObject2).SyG.Szt.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((anm)localObject2).SyG.Szt;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_app) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((anm)localObject2).SyG.Szv;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_friend_card) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.wMd = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOU(((anm)localObject2).desc).fcC;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_record) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((anm)localObject2).SyG.SzE != null) && (((anm)localObject2).SyG.SzE.type == 3))
            {
              localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_not_show) + "\n");
              break;
            }
            localLinkedList.add(((anm)localObject2).SyI + ":" + paramContext.getString(s.i.app_app_brand) + ((anm)localObject2).title + "\n");
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
    
    private static String a(ant paramant)
    {
      AppMethodBeat.i(106896);
      if (paramant == null)
      {
        Log.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramant = paramant.label;
      AppMethodBeat.o(106896);
      return paramant;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(paramString, "").getBytes());
      if (aAr(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static boolean aAr(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new com.tencent.mm.vfs.q(paramString).ifE();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    private static String b(ant paramant)
    {
      AppMethodBeat.i(106897);
      if (paramant == null)
      {
        Log.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramant = paramant.fPN;
      AppMethodBeat.o(106897);
      return paramant;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */