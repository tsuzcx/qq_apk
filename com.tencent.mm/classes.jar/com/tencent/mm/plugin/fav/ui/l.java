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
import com.tencent.mm.autogen.a.aam;
import com.tencent.mm.autogen.a.aam.b;
import com.tencent.mm.autogen.a.sk;
import com.tencent.mm.autogen.a.sk.b;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.message.a;
import com.tencent.mm.message.e;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.fav.a.ap.a;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static void a(Context paramContext, String paramString, final com.tencent.mm.plugin.fav.a.g paramg, final arf paramarf, final Runnable paramRunnable)
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
    if (paramarf == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(106904);
      return;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106891);
        l.a(l.this, paramg, paramarf);
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
  
  public static void a(final Context paramContext, final String paramString, arf paramarf, final Runnable paramRunnable)
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
    if (paramarf == null)
    {
      Log.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(106903);
      return;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106889);
        if (l.this.dataType == 15) {
          l.a(paramContext, paramString, l.this);
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(paramRunnable);
          AppMethodBeat.o(106889);
          return;
          l.b(paramContext, paramString, l.this);
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
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106886);
        Iterator localIterator1 = Util.stringsToList(l.this.split(",")).iterator();
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
              com.tencent.mm.plugin.report.service.h.OAn.b(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
              Object localObject1;
              Object localObject2;
              Object localObject6;
              Object localObject7;
              Object localObject5;
              label2255:
              int i;
              label2858:
              label3243:
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
                com.tencent.mm.plugin.messenger.a.g.gaI().ap(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, ab.IX(str));
                break;
              case 2: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.vEn.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (arf)((Iterator)localObject1).next();
                  com.tencent.mm.plugin.messenger.a.g.gaI().a(paramContext, str, com.tencent.mm.plugin.fav.a.b.d((arf)localObject2), 0, "", "", 0L, ((arf)localObject2).pbn);
                }
              case 16: 
                l.a(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 4: 
                l.b(paramContext, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 6: 
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAh;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("<msg>");
                ((StringBuilder)localObject2).append("<location ");
                ((StringBuilder)localObject2).append("x=\"").append(((arm)localObject1).lat).append("\" ");
                ((StringBuilder)localObject2).append("y=\"").append(((arm)localObject1).lng).append("\" ");
                ((StringBuilder)localObject2).append("scale=\"").append(((arm)localObject1).hQp).append("\" ");
                ((StringBuilder)localObject2).append("label=\"").append(Util.nullAs(((arm)localObject1).label, "")).append("\" ");
                ((StringBuilder)localObject2).append("maptype=\"0\" ");
                ((StringBuilder)localObject2).append("poiname=\"").append(Util.nullAs(((arm)localObject1).hVI, "")).append("\" ");
                ((StringBuilder)localObject2).append("/>");
                ((StringBuilder)localObject2).append("</msg>");
                com.tencent.mm.plugin.messenger.a.g.gaI().ap(str, ((StringBuilder)localObject2).toString(), 48);
                break;
              case 8: 
                l.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
                break;
              case 7: 
                localObject6 = paramContext;
                localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((arf)localObject7).ZyM;
                ((WXMusicObject)localObject1).musicDataUrl = ((arf)localObject7).ZyO;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((arf)localObject7).ZyQ;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((arf)localObject7).ZyQ;
                ((WXMusicObject)localObject1).songAlbumUrl = ((arf)localObject7).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((arf)localObject7).songLyric;
                localObject5 = new WXMediaMessage();
                ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject5).title = ((arf)localObject7).title;
                ((WXMediaMessage)localObject5).description = ((arf)localObject7).desc;
                localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((arf)localObject7));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = Util.nullAs(((arf)localObject7).hDd, "");
                  localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
                localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZBt.appId;
                localObject2 = am.a.okN.x((Context)localObject6, (String)localObject1);
                ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fav.a.ad.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
                break;
              case 21: 
                localObject7 = paramContext;
                localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject1 = new WXMusicObject();
                ((WXMusicObject)localObject1).musicUrl = ((arf)localObject5).ZyM;
                ((WXMusicObject)localObject1).musicDataUrl = ((arf)localObject5).ZyO;
                ((WXMusicObject)localObject1).musicLowBandUrl = ((arf)localObject5).ZyQ;
                ((WXMusicObject)localObject1).musicLowBandDataUrl = ((arf)localObject5).ZyQ;
                ((WXMusicObject)localObject1).songAlbumUrl = ((arf)localObject5).songAlbumUrl;
                ((WXMusicObject)localObject1).songLyric = ((arf)localObject5).songLyric;
                localObject6 = new WXMediaMessage();
                ((WXMediaMessage)localObject6).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                ((WXMediaMessage)localObject6).title = ((arf)localObject5).title;
                ((WXMediaMessage)localObject6).description = ((arf)localObject5).desc;
                localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((arf)localObject5));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = Util.nullAs(((arf)localObject5).hDd, "");
                  localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes()));
                }
                ((WXMediaMessage)localObject6).thumbData = ((byte[])localObject1);
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZBt.appId;
                localObject3 = am.a.okN.x((Context)localObject7, (String)localObject2);
                localObject1 = new k.b();
                ((k.b)localObject1).title = ((arf)localObject5).title;
                ((k.b)localObject1).description = ((arf)localObject5).desc;
                ((k.b)localObject1).url = ((arf)localObject5).ZyM;
                ((k.b)localObject1).nRc = ((arf)localObject5).ZyQ;
                ((k.b)localObject1).nRx = ((arf)localObject5).ZyO;
                ((k.b)localObject1).nRy = ((arf)localObject5).ZyQ;
                ((k.b)localObject1).appId = ((String)localObject2);
                ((k.b)localObject1).type = 76;
                ((k.b)localObject1).appName = ((String)localObject3);
                ((k.b)localObject1).nRg = 3;
                if ((localObject5 != null) && (((arf)localObject5).Zzy != null))
                {
                  localObject2 = ((arf)localObject5).Zzy.ZAJ;
                  if (localObject2 != null)
                  {
                    localObject3 = new com.tencent.mm.pluginsdk.ui.tools.b();
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songAlbumUrl = ((arf)localObject5).songAlbumUrl;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songLyric = ((arf)localObject5).songLyric;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqN = ((dtj)localObject2).YqN;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqO = ((dtj)localObject2).YqO;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqP = ((dtj)localObject2).YqP;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqQ = ((dtj)localObject2).YqQ;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqR = ((dtj)localObject2).singerName;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqS = ((dtj)localObject2).albumName;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqT = ((dtj)localObject2).musicGenre;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqU = String.valueOf(((dtj)localObject2).issueDate);
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqV = ((dtj)localObject2).identification;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).LNC = ((dtj)localObject2).LNC;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqW = ((dtj)localObject2).extraInfo;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqX = ((dtj)localObject2).musicOperationUrl;
                    ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).oOZ = ((dtj)localObject2).oOZ;
                    ((k.b)localObject1).a((com.tencent.mm.message.f)localObject3);
                  }
                }
                ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fav.a.ad.class)).a((k.b)localObject1, (WXMediaMessage)localObject6, str);
                break;
              case 5: 
                if (localObject3 == null)
                {
                  Log.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                }
                else
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
                  localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAj;
                  Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZBt;
                  localObject6 = new k.b();
                  if (localObject7 != null)
                  {
                    ((k.b)localObject6).title = ((ask)localObject7).title;
                    localObject2 = ((ask)localObject7).thumbUrl;
                    localObject1 = localObject2;
                    if (Util.isNullOrNil((String)localObject2)) {
                      localObject1 = Util.nullAs(((arf)localObject5).hDd, "");
                    }
                    ((k.b)localObject6).thumburl = ((String)localObject1);
                  }
                  if (Util.isNullOrNil(((k.b)localObject6).title)) {
                    ((k.b)localObject6).title = ((arf)localObject5).title;
                  }
                  if (localObject7 != null) {
                    ((k.b)localObject6).description = ((ask)localObject7).desc;
                  }
                  if (Util.isNullOrNil(((k.b)localObject6).description)) {
                    ((k.b)localObject6).description = ((arf)localObject5).desc;
                  }
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAj != null) {
                    ((k.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAj.ZBV;
                  }
                  if ((localObject8 != null) && (Util.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((asb)localObject8).link;
                  }
                  if ((((com.tencent.mm.plugin.fav.a.g)localObject3).Acq) && (Util.isNullOrNil(((k.b)localObject6).url))) {
                    ((k.b)localObject6).url = ((arf)localObject5).ZyM;
                  }
                  if (!Util.isNullOrNil(((arf)localObject5).canvasPageXml)) {
                    ((k.b)localObject6).canvasPageXml = ((arf)localObject5).canvasPageXml;
                  }
                  ((k.b)localObject6).action = "view";
                  ((k.b)localObject6).type = 5;
                  ((k.b)localObject6).iaa = ((asb)localObject8).hzi;
                  if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.WKx != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.WKx;
                    localObject2 = new e();
                    ((e)localObject2).nQm = ((arn)localObject1).nQm;
                    ((e)localObject2).nQp = ((arn)localObject1).nQp;
                    if (Util.isNullOrNil(((k.b)localObject6).iaa)) {
                      ((k.b)localObject6).iaa = ((arn)localObject1).hEE;
                    }
                    if (((arn)localObject1).nQm == 5)
                    {
                      ((e)localObject2).vid = ((arn)localObject1).vid;
                      ((e)localObject2).nQn = ((arn)localObject1).nQn;
                      ((e)localObject2).duration = ((arn)localObject1).duration;
                      ((e)localObject2).videoWidth = ((arn)localObject1).videoWidth;
                      ((e)localObject2).videoHeight = ((arn)localObject1).videoHeight;
                    }
                    ((k.b)localObject6).a((com.tencent.mm.message.f)localObject2);
                  }
                  if ((localObject7 != null) && (!Util.isNullOrNil(((ask)localObject7).ZCa)))
                  {
                    localObject1 = XmlParser.parseXml(((ask)localObject7).ZCa, "websearch", null);
                    localObject2 = new ak();
                    ((ak)localObject2).WoZ = ((String)((Map)localObject1).get(".websearch.relevant_vid"));
                    ((ak)localObject2).Wpa = ((String)((Map)localObject1).get(".websearch.relevant_expand"));
                    ((ak)localObject2).Wpb = ((String)((Map)localObject1).get(".websearch.relevant_pre_searchid"));
                    ((ak)localObject2).Wpc = ((String)((Map)localObject1).get(".websearch.relevant_shared_openid"));
                    ((ak)localObject2).Wpd = Util.getInt((String)((Map)localObject1).get(".websearch.rec_category"), -1);
                    ((ak)localObject2).ytZ = ((String)((Map)localObject1).get(".websearch.shareUrl"));
                    ((ak)localObject2).svG = ((String)((Map)localObject1).get(".websearch.shareTitle"));
                    ((ak)localObject2).ICb = ((String)((Map)localObject1).get(".websearch.shareDesc"));
                    ((ak)localObject2).Wpe = ((String)((Map)localObject1).get(".websearch.shareImgUrl"));
                    ((ak)localObject2).Wpf = ((String)((Map)localObject1).get(".websearch.shareString"));
                    ((ak)localObject2).Wpg = ((String)((Map)localObject1).get(".websearch.shareStringUrl"));
                    ((ak)localObject2).source = ((String)((Map)localObject1).get(".websearch.source"));
                    ((ak)localObject2).ibx = ((String)((Map)localObject1).get(".websearch.sourceUrl"));
                    ((ak)localObject2).Wph = ((String)((Map)localObject1).get(".websearch.strPlayCount"));
                    ((ak)localObject2).Wpi = ((String)((Map)localObject1).get(".websearch.titleUrl"));
                    ((ak)localObject2).Wpj = ((String)((Map)localObject1).get(".websearch.extReqParams"));
                    ((ak)localObject2).Wpk = ((String)((Map)localObject1).get(".websearch.tagList"));
                    ((ak)localObject2).Wpl = Util.getLong((String)((Map)localObject1).get(".websearch.channelId"), -1L);
                    ((ak)localObject2).thumbUrl = ((String)((Map)localObject1).get(".websearch.thumbUrl"));
                    ((ak)localObject2).Wpm = ((String)((Map)localObject1).get(".websearch.shareTag"));
                    ((k.b)localObject6).a((com.tencent.mm.message.f)localObject2);
                  }
                  ((k.b)localObject6).iah = ((arf)localObject5).iah;
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.a((arf)localObject5));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    if (localObject7 != null) {
                      break label2255;
                    }
                  }
                  for (localObject1 = null;; localObject1 = ((ask)localObject7).thumbUrl)
                  {
                    localObject2 = localObject1;
                    if (Util.isNullOrNil((String)localObject1)) {
                      localObject2 = Util.nullAs(((arf)localObject5).hDd, "");
                    }
                    localObject1 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
                    localObject2 = "fav_" + z.bAM() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                    localObject7 = com.tencent.mm.model.ad.Jo((String)localObject2);
                    localObject8 = com.tencent.mm.model.ad.bCb().M((String)localObject7, true);
                    ((ad.b)localObject8).q("prePublishId", localObject2);
                    ((ad.b)localObject8).q("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                    ((ad.b)localObject8).q("sendAppMsgScene", Integer.valueOf(1));
                    ((ad.b)localObject8).q("adExtStr", ((arf)localObject5).iah);
                    com.tencent.mm.plugin.messenger.a.g.gaI().a(str, (byte[])localObject1, k.b.a((k.b)localObject6, null, null), (String)localObject7);
                    break;
                  }
                }
                break;
              case 10: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAl;
                localObject3 = new sk();
                ((sk)localObject3).hVz.opType = 0;
                ((sk)localObject3).hVz.hVB = ((aru)localObject2).hZn;
                ((sk)localObject3).hVz.context = ((Context)localObject1);
                ((sk)localObject3).publish();
                if (((sk)localObject3).hVA.hCQ)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((aru)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((sk)localObject3).hVA.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.gaI().a(str, (byte[])localObject1, ((sk)localObject3).hVA.hVC, null);
                }
                break;
              case 15: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAn;
                localObject3 = new aam();
                ((aam)localObject3).idU.opType = 0;
                ((aam)localObject3).idU.idW = ((ase)localObject2).hZn;
                ((aam)localObject3).idU.context = ((Context)localObject1);
                ((aam)localObject3).publish();
                Log.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((aam)localObject3).idV.hCQ), ((ase)localObject2).thumbUrl });
                if (((aam)localObject3).idV.hCQ)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((ase)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((aam)localObject3).idV.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.gaI().a(str, (byte[])localObject1, ((aam)localObject3).idV.hVC, null);
                }
                break;
              case 11: 
                localObject1 = paramContext;
                localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAl;
                localObject3 = new sk();
                ((sk)localObject3).hVz.opType = 1;
                ((sk)localObject3).hVz.hVB = ((aru)localObject2).hZn;
                ((sk)localObject3).hVz.context = ((Context)localObject1);
                ((sk)localObject3).publish();
                if (((sk)localObject3).hVA.hCQ)
                {
                  localObject2 = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(((aru)localObject2).thumbUrl, "").getBytes()));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = Util.readFromFile(((sk)localObject3).hVA.thumbPath);
                  }
                  com.tencent.mm.plugin.messenger.a.g.gaI().a(str, (byte[])localObject1, ((sk)localObject3).hVA.hVC, null);
                }
                break;
              case 20: 
                localObject1 = f.Ahd;
                f.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3);
                break;
              case 19: 
                if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type != 19)
                {
                  Log.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type) });
                }
                else if (b.a(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAw))
                {
                  Log.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.ZAw;
                  localObject1 = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(((ard)localObject2).username);
                  if (localObject1 != null)
                  {
                    localObject1 = ((WxaAttributes)localObject1).field_nickname;
                    localObject5 = new k.b();
                    ((k.b)localObject5).title = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).description = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.title;
                    ((k.b)localObject5).nTD = ((ard)localObject2).username;
                    ((k.b)localObject5).nTC = ((ard)localObject2).hzy;
                    ((k.b)localObject5).nTE = ((ard)localObject2).appId;
                    ((k.b)localObject5).nTW = ((ard)localObject2).hJK;
                    ((k.b)localObject5).nTX = ((ard)localObject2).version;
                    ((k.b)localObject5).nTF = 2;
                    ((k.b)localObject5).nTM = ((ard)localObject2).rxs;
                    ((k.b)localObject5).url = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).UC(((ard)localObject2).appId);
                    ((k.b)localObject5).nTY = ((ard)localObject2).iconUrl;
                    ((k.b)localObject5).iag = ("wxapp_" + ((ard)localObject2).appId + ((ard)localObject2).hzy);
                    ((k.b)localObject5).iaa = ((ard)localObject2).username;
                    ((k.b)localObject5).iab = ((String)localObject1);
                    localObject1 = new a();
                    ((a)localObject1).nOW = ((ard)localObject2).rbZ;
                    ((a)localObject1).nOZ = ((ard)localObject2).idf;
                    ((a)localObject1).nPa = ((ard)localObject2).subType;
                    ((k.b)localObject5).a((com.tencent.mm.message.f)localObject1);
                    ((k.b)localObject5).type = 33;
                    localObject1 = new byte[0];
                    localObject6 = FavoriteImageServer.a(com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3), (com.tencent.mm.plugin.fav.a.g)localObject3);
                    if ((localObject6 == null) || (((Bitmap)localObject6).isRecycled())) {
                      break label3243;
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
                    w.a.bwq().a((k.b)localObject5, ((ard)localObject2).appId, "", str, "", (byte[])localObject1);
                    break;
                    localObject1 = MMApplicationContext.getContext().getString(q.i.appbrand_app_name);
                    break label2858;
                    Log.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                  }
                }
                break;
              case 14: 
              case 18: 
                Log.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
                localObject1 = l.a.a(paramContext, (com.tencent.mm.plugin.fav.a.g)localObject3);
                localObject2 = new arv();
                try
                {
                  Log.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                  ((arv)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
                  localObject3 = ((arv)localObject2).vEn;
                  localObject5 = ((LinkedList)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (arf)((Iterator)localObject5).next();
                    if (((arf)localObject6).Zzy != null)
                    {
                      if ((((arf)localObject6).Zzy.ZAw != null) && (b.a(((arf)localObject6).Zzy.ZAw)))
                      {
                        ((arf)localObject6).axy(1);
                        ((arf)localObject6).bsp(paramContext.getString(q.i.app_not_show));
                        ((LinkedList)localObject3).set(i, localObject6);
                        ((arv)localObject2).cs((LinkedList)localObject3);
                      }
                      if ((((arf)localObject6).Zzy.ZAj != null) && (com.tencent.mm.plugin.fav.a.m.a(((arf)localObject6).Zzy.ZAj)))
                      {
                        ((arf)localObject6).axy(1);
                        ((arf)localObject6).bsp(paramContext.getString(q.i.app_not_show));
                        ((LinkedList)localObject3).set(i, localObject6);
                        ((arv)localObject2).cs((LinkedList)localObject3);
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
                  localObject4 = new tr();
                  ((tr)localObject4).hXt.type = 2;
                  ((tr)localObject4).hXt.toUser = str;
                  ((tr)localObject4).hXt.hXw = ((arv)localObject2);
                  ((tr)localObject4).hXt.title = ((l.a)localObject1).title;
                  ((tr)localObject4).hXt.desc = ((l.a)localObject1).desc;
                  ((tr)localObject4).hXt.thumbPath = ((l.a)localObject1).thumbPath;
                  ((tr)localObject4).hXt.hXz = ((l.a)localObject1).AiA;
                  ((tr)localObject4).publish();
                }
                break;
              case 17: 
                localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
                localObject2 = cc.a.bys((String)localObject1);
                localObject4 = com.tencent.mm.plugin.messenger.a.g.gaI();
                if (au.bwO(((cc.a)localObject2).hgk)) {}
                for (i = 66;; i = 42)
                {
                  ((d)localObject4).ap(str, (String)localObject1, i);
                  break;
                }
              }
            }
          }
          if (!Util.isNullOrNil(paramString2)) {
            com.tencent.mm.plugin.messenger.a.g.gaI().ap(str, paramString2, ab.IX(str));
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
  
  public static boolean j(arf paramarf)
  {
    AppMethodBeat.i(106902);
    if ((paramarf != null) && (!Util.isNullOrNil(paramarf.ZyU)) && ((Util.isEqual(paramarf.ZyU, ".htm")) || (Util.isEqual(paramarf.ZyU, "htm"))))
    {
      AppMethodBeat.o(106902);
      return true;
    }
    AppMethodBeat.o(106902);
    return false;
  }
  
  public static String k(arf paramarf)
  {
    AppMethodBeat.i(106905);
    u localu = new u(com.tencent.mm.plugin.fav.a.b.a(paramarf));
    if (localu.jKS()) {}
    for (paramarf = ah.v(localu.jKT());; paramarf = com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(paramarf.hDd, "").getBytes()))
    {
      AppMethodBeat.o(106905);
      return paramarf;
    }
  }
  
  public static final class a
  {
    public String AiA;
    public String desc;
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
        localIterator = paramg.field_favProto.vEn.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (arf)localIterator.next();
          if ((paramg.field_type != 18) || (!l.j((arf)localObject1)))
          {
            int k = localSparseIntArray.get(((arf)localObject1).dataType);
            localSparseIntArray.put(((arf)localObject1).dataType, k + 1);
            switch (((arf)localObject1).dataType)
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
                localObject1 = ((arf)localObject1).desc;
                if (!Util.isNullOrNil((String)localObject1))
                {
                  localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                  localLinkedList.add((String)localObject1 + "\n");
                }
              }
              break;
            case 3: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(q.i.app_voice) + m.Q(paramContext, (int)com.tencent.mm.plugin.fav.a.b.mA(((arf)localObject1).duration)) + "\n");
              }
              break;
            case 2: 
              if (j == 0)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.a((arf)localObject1);
                if (auy((String)localObject2))
                {
                  locala.thumbPath = ((String)localObject2);
                  j = 1;
                }
                else
                {
                  locala.thumbPath = com.tencent.mm.plugin.fav.a.b.d((arf)localObject1);
                  j = 1;
                }
              }
              break;
            case 6: 
              if (localLinkedList.size() < 4)
              {
                localObject1 = ((arf)localObject1).Zzy.ZAh;
                localObject2 = new StringBuilder().append(paramContext.getString(q.i.app_location));
                if ((!Util.isNullOrNil(b((arm)localObject1))) && (!b((arm)localObject1).equals(paramContext.getString(q.i.location_sub_title_location_with_bracket)))) {
                  break label536;
                }
              }
              for (localObject1 = a((arm)localObject1);; localObject1 = b((arm)localObject1))
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
                localLinkedList.add(paramContext.getString(q.i.app_file) + ((arf)localObject1).title + "\n");
              }
              if (i == 0) {
                i = 1;
              }
              break;
            case 4: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(q.i.app_video) + "\n");
              }
              break;
            case 17: 
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(q.i.app_record) + "\n");
              }
              break;
            case 19: 
              label536:
              if (localLinkedList.size() < 4) {
                localLinkedList.add(paramContext.getString(q.i.app_app_brand) + ((arf)localObject1).title + "\n");
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
      Iterator localIterator = paramg.field_favProto.vEn.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (arf)localIterator.next();
        j = localSparseIntArray.get(((arf)localObject2).dataType);
        localSparseIntArray.put(((arf)localObject2).dataType, j + 1);
        switch (((arf)localObject2).dataType)
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
            localLinkedList.add(((arf)localObject2).ZzA + ":" + ((arf)localObject2).desc + "\n");
          }
          break;
        case 3: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_voice) + m.Q(paramContext, (int)com.tencent.mm.plugin.fav.a.b.mA(((arf)localObject2).duration)) + "\n");
          }
          break;
        case 2: 
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_pic) + "\n");
          }
          if (i == 0)
          {
            paramg = com.tencent.mm.plugin.fav.a.b.a((arf)localObject2);
            if (!auy(paramg)) {
              break label2777;
            }
            locala.thumbPath = paramg;
            i = 1;
          }
          break;
        }
      }
      label1469:
      label2777:
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4)
        {
          if ((((arf)localObject2).Zzy.ZAj == null) || (!com.tencent.mm.plugin.fav.a.m.a(((arf)localObject2).Zzy.ZAj))) {
            break label1469;
          }
          localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_not_show) + "\n");
        }
        while (i == 0)
        {
          paramg = com.tencent.mm.plugin.fav.a.b.a((arf)localObject2);
          if (!auy(paramg)) {
            break label1526;
          }
          locala.thumbPath = paramg;
          i = 1;
          break;
          localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_url) + ((arf)localObject2).title + "\n");
        }
        label1526:
        paramg = ((arf)localObject2).Zzy.ZAj;
        if (paramg == null) {}
        for (paramg = "";; paramg = paramg.thumbUrl)
        {
          localObject1 = paramg;
          if (Util.isNullOrNil(paramg)) {
            localObject1 = Util.nullAs(((arf)localObject2).hDd, "");
          }
          a(locala, (String)localObject1);
          break;
        }
        if ((com.tencent.mm.plugin.fav.a.b.dQh()) || (localLinkedList.size() >= 4)) {
          break;
        }
        localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_url) + ((arf)localObject2).title + "\n");
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_shortvideo) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.a((arf)localObject2);
        if (auy(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_video) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = com.tencent.mm.plugin.fav.a.b.a((arf)localObject2);
          if (auy(paramg))
          {
            locala.thumbPath = paramg;
            i = 1;
          }
          for (;;)
          {
            break;
            if (localLinkedList.size() < 4)
            {
              paramg = ((arf)localObject2).Zzy.ZAh;
              localObject1 = new StringBuilder().append(((arf)localObject2).ZzA).append(":").append(paramContext.getString(q.i.app_location));
              if ((!Util.isNullOrNil(b(paramg))) && (!b(paramg).equals(paramContext.getString(q.i.location_sub_title_location_with_bracket)))) {
                break label1941;
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
              localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_music) + ((arf)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            a(locala, ((arf)localObject2).hDd);
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_file) + ((arf)localObject2).title + "\n");
            }
            if (i != 0) {
              break;
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_product) + ((arf)localObject2).Zzy.ZAl.title + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((arf)localObject2).Zzy.ZAl;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_app) + "\n");
            }
            if (i != 0) {
              break;
            }
            paramg = ((arf)localObject2).Zzy.ZAn;
            if (paramg != null) {
              a(locala, paramg.thumbUrl);
            }
            i = 1;
            break;
            if (localLinkedList.size() < 4) {
              localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_friend_card) + "\n");
            }
            if (i != 0) {
              break;
            }
            locala.AiA = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(((arf)localObject2).desc).hgk;
            i = 1;
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_record) + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            if ((((arf)localObject2).Zzy.ZAw != null) && (((arf)localObject2).Zzy.ZAw.type == 3))
            {
              localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_not_show) + "\n");
              break;
            }
            localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_app_brand) + ((arf)localObject2).title + "\n");
            break;
            if (localLinkedList.size() >= 4) {
              break;
            }
            localLinkedList.add(((arf)localObject2).ZzA + ":" + paramContext.getString(q.i.app_friend_card_kefu) + "\n");
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
    
    private static String a(arm paramarm)
    {
      AppMethodBeat.i(106896);
      if (paramarm == null)
      {
        Log.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
        AppMethodBeat.o(106896);
        return "";
      }
      paramarm = paramarm.label;
      AppMethodBeat.o(106896);
      return paramarm;
    }
    
    private static void a(a parama, String paramString)
    {
      AppMethodBeat.i(106899);
      paramString = com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(paramString, "").getBytes());
      if (auy(paramString)) {
        parama.thumbPath = paramString;
      }
      AppMethodBeat.o(106899);
    }
    
    private static boolean auy(String paramString)
    {
      AppMethodBeat.i(106895);
      boolean bool = new u(paramString).jKS();
      AppMethodBeat.o(106895);
      return bool;
    }
    
    private static String b(arm paramarm)
    {
      AppMethodBeat.i(106897);
      if (paramarm == null)
      {
        Log.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
        AppMethodBeat.o(106897);
        return "";
      }
      paramarm = paramarm.hVI;
      AppMethodBeat.o(106897);
      return paramarm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */