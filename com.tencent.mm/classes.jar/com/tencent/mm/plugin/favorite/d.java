package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static int[] tnn = { 2131298531, 2131298532, 2131298533, 2131298534, 2131298535 };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.LwS != null) && (!Util.isNullOrNil(paramg.field_favProto.LwS.canvasPageXml)))
    {
      paramg = paramg.field_favProto.LwS.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.ppH;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((aml)paramg.get(0)).canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    AppMethodBeat.o(24585);
    return null;
  }
  
  private static String K(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24586);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24586);
      return null;
    }
    if ((paramg.field_favProto.LwS != null) && (!Util.isNullOrNil(paramg.field_favProto.LwS.thumbUrl)))
    {
      paramg = paramg.field_favProto.LwS.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.ppH;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((aml)paramg.get(0)).iwX;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, and paramand, Intent paramIntent)
  {
    AppMethodBeat.i(24588);
    paramIntent.putExtra(e.b.OyQ, paramand.scene);
    paramIntent.putExtra(e.b.OyR, paramand.pHw);
    paramIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.ab.getSessionId());
    paramand = paramg.field_favProto.IXu;
    paramg = new x();
    paramg.dHc = paramand.dHc;
    paramg.iAg = paramand.iAg;
    paramg.iAi.url = paramIntent.getStringExtra("rawUrl");
    paramg.iAi.title = Util.nullAsNil(paramIntent.getStringExtra("share_report_pre_msg_title"));
    paramg.iAi.iAq = paramIntent.getStringExtra("share_report_pre_msg_desc");
    paramg.iAi.iAo = paramand.iAo;
    paramg.iAi.type = paramand.iwc;
    paramg.iAi.iwf = paramand.iwf;
    paramg.iAi.time = paramand.iwd;
    paramg.iAi.iAs = paramand.duration;
    paramg.iAi.videoWidth = paramand.videoWidth;
    paramg.iAi.videoHeight = paramand.videoHeight;
    paramg.iAi.vid = paramand.vid;
    paramg.t(paramIntent);
    Log.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramand.LxS != null) {
      paramIntent.putExtra("img_gallery_width", paramand.LxS.width).putExtra("img_gallery_height", paramand.LxS.height).putExtra("img_gallery_left", paramand.LxS.left).putExtra("img_gallery_top", paramand.LxS.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramand = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(paramg.iAi.url, 24, 10000, i);
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, paramand, paramg.iAi.type, 24, 10000, paramIntent)) {
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    }
    AppMethodBeat.o(24588);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, and paramand)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramand, localIntent);
    com.tencent.mm.plugin.fav.a.i.gF("FavRecordDetailUI", paramand.sessionId);
    com.tencent.mm.br.c.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, and paramand, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramand, paramIntent);
    paramIntent.putExtra("key_detail_info_id", paramg.field_localId);
    paramIntent.putExtra("key_detail_data_id", paramg.taf);
    AppMethodBeat.o(24594);
  }
  
  public static void a(o.a parama, final Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(24596);
    if ((paramg == null) || (paramContext == null))
    {
      Log.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24596);
      return;
    }
    aml localaml1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      Log.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      label53:
      localObject1 = null;
      label55:
      if (!(localObject1 instanceof String)) {
        break label1419;
      }
    }
    Object localObject2;
    for (Object localObject1 = (String)localObject1;; localObject1 = null)
    {
      localObject2 = paramg.field_favProto.LwS;
      switch (paramg.field_type)
      {
      case 3: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 15: 
      case 17: 
      default: 
        paramg = localObject3;
        if (localObject2 != null)
        {
          paramg = localObject3;
          if (!Util.isNullOrNil(((anq)localObject2).title)) {
            paramg = ((anq)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (Util.isNullOrNil(paramg)) {
          localObject1 = localaml1.title;
        }
        parama.beQ(paramContext.getResources().getString(2131755313) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        aml localaml2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new o(com.tencent.mm.plugin.fav.a.b.a(localaml2));
          if (((o)localObject1).exists())
          {
            localObject1 = com.tencent.mm.vfs.aa.z(((o)localObject1).her());
            break label55;
          }
          localObject1 = paramg.field_favProto.LwS;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((anq)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              localObject2 = localaml2.dFN;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.arM((String)localObject2);
            localObject1 = localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(2131689587);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.LwU;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.arM(((ana)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689580);
            break label55;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.LwW;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.arM(((ank)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689580);
            break label55;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (21 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new o(com.tencent.mm.plugin.fav.a.b.a(localaml2));
          if (((o)localObject1).exists())
          {
            localObject1 = com.tencent.mm.vfs.aa.z(((o)localObject1).her());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.arM(localaml2.dFN);
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localaml2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localaml2);
          }
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2)) {
            break label55;
          }
        }
        switch (paramg.field_type)
        {
        default: 
          localObject1 = Integer.valueOf(2131689584);
          break;
        case 2: 
          localObject1 = Integer.valueOf(2131230967);
          break;
        case 7: 
          localObject1 = Integer.valueOf(2131689567);
          break;
        case 21: 
          localObject1 = Integer.valueOf(2131689567);
          break;
          if ((3 == paramg.field_type) || (6 == paramg.field_type)) {
            break label53;
          }
          if (8 == paramg.field_type)
          {
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.bcX(localaml2.LvC));
            break;
          }
          if (17 == paramg.field_type)
          {
            bg.aVF();
            localObject1 = com.tencent.mm.model.c.aSQ().aEK(localaml2.desc);
            if ((((ca.a)localObject1).dkU != null) && (((ca.a)localObject1).dkU.length() != 0))
            {
              localObject1 = new SpannableString(((ca.a)localObject1).dkU);
              break;
            }
            localObject1 = Integer.valueOf(2131231957);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.ppH == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.ppH.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localaml2 = (aml)((Iterator)localObject1).next();
            } while (localaml2.dataType == 1);
            if (localaml2.dataType == 3)
            {
              localObject1 = Integer.valueOf(2131689586);
              break label55;
            }
            if (localaml2.dataType == 6)
            {
              localObject1 = Integer.valueOf(2131689565);
              break label55;
            }
            if (localaml2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.bcX(localaml2.LvC));
              break label55;
            }
            if ((localaml2.dataType == 2) || (localaml2.dataType == 7) || (localaml2.dataType == 29) || (localaml2.dataType == 15) || (localaml2.dataType == 4))
            {
              localObject1 = new o(com.tencent.mm.plugin.fav.a.b.a(localaml2));
              if (((o)localObject1).exists())
              {
                localObject1 = com.tencent.mm.vfs.aa.z(((o)localObject1).her());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.arM(localaml2.dFN);
              if (Util.isNullOrNil((String)localObject1)) {
                switch (localaml2.dataType)
                {
                default: 
                  localObject1 = Integer.valueOf(2131689584);
                  break;
                case 2: 
                  localObject1 = Integer.valueOf(2131230967);
                  break;
                case 7: 
                case 29: 
                  localObject1 = Integer.valueOf(2131689567);
                  break;
                }
              }
              break label55;
            }
            if (localaml2.dataType == 5)
            {
              localObject1 = new o(com.tencent.mm.plugin.fav.a.b.a(localaml2));
              if (((o)localObject1).exists())
              {
                localObject1 = com.tencent.mm.vfs.aa.z(((o)localObject1).her());
                break label55;
              }
              localObject1 = localaml2.Lwh.LwS;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((anq)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (Util.isNullOrNil((String)localObject1)) {
                  localObject2 = localaml2.dFN;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.arM((String)localObject2);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(2131689587);
                break;
              }
            }
            if (localaml2.dataType == 22)
            {
              localObject1 = Integer.valueOf(2131690801);
              break label55;
            }
            if ((localaml2.dataType == 10) || (localaml2.dataType == 11))
            {
              localObject2 = localaml2.Lwh.LwU;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.arM(((ana)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689580);
                break label55;
              }
            }
            if ((localaml2.dataType == 12) || (localaml2.dataType == 14))
            {
              localObject2 = localaml2.Lwh.LwW;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.arM(((ank)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689580);
                break label55;
              }
            }
          } while (localaml2.dataType != 16);
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSQ().aEK(localaml2.desc);
          if ((((ca.a)localObject1).dkU != null) && (((ca.a)localObject1).dkU.length() != 0))
          {
            localObject1 = new SpannableString(((ca.a)localObject1).dkU);
            break;
          }
          localObject1 = Integer.valueOf(2131231957);
          break;
          label1419:
          if ((localObject1 instanceof Integer)) {
            ((Integer)localObject1).intValue();
          }
          break;
        }
        break;
      }
    }
    localObject1 = paramg.field_favProto.title;
    paramg = (com.tencent.mm.plugin.fav.a.g)localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      paramg = localaml1.title;
    }
    parama.beQ(paramContext.getResources().getString(2131755851) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.beQ(paramg.field_favProto.desc);
    parama.gpx();
    parama.a(new d.a.b()
    {
      public final void cXd()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", this.sZW.field_favProto.desc);
        com.tencent.mm.br.c.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.kc(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.LwQ;
    paramg = paramContext.getString(2131755888);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((ams)localObject1).label;
    }
    parama.beQ(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!Util.isNullOrNil(((anq)localObject2).title)))
    {
      paramg = ((anq)localObject2).title;
      localObject1 = ((anq)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (Util.isNullOrNil(paramg)) {
        localObject2 = localaml1.title;
      }
      Util.isNullOrNil((String)localObject1);
      parama.beQ(paramContext.getResources().getString(2131756012) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.beQ(paramContext.getResources().getString(2131755961) + paramg);
      AppMethodBeat.o(24596);
      return;
      parama.l(BitmapUtil.getBitmapNative((String)localObject1), 3);
      AppMethodBeat.o(24596);
      return;
      parama.l(BitmapUtil.getBitmapNative((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      parama.l(BitmapUtil.getBitmapNative((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      localObject1 = paramContext.getResources().getString(2131755920);
      paramContext = l.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.beQ((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.Lxk;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(2131755853) + paramg.desc;; paramContext = paramContext.getString(2131755853))
      {
        parama.beQ(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!Util.isNullOrNil(((anq)localObject2).title)) {
          paramg = ((anq)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (Util.isNullOrNil(paramg)) {
        localObject1 = localaml1.title;
      }
      parama.beQ(paramContext.getResources().getString(2131755905) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.Lxf != null) {}
      for (paramContext = paramContext.getString(2131755413) + paramg.field_favProto.title;; paramContext = paramContext.getString(2131755413))
      {
        parama.beQ(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(and paramand, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramand.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramand.pHw);
    paramIntent.putExtra("key_detail_fav_index", paramand.index);
    paramIntent.putExtra("key_detail_fav_query", paramand.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramand.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramand.tay);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, aml paramaml, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    amo localamo = paramaml.Lwn;
    if ((localamo == null) || (Util.isNullOrNil(localamo.iyZ)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    m.a(m.a.taN, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramaml);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localamo.iyZ);
    localIntent.putExtra("StreamWording", localamo.izc);
    localIntent.putExtra("StremWebUrl", localamo.izd);
    localIntent.putExtra("KThumUrl", localamo.ize);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localamo.izf);
    localIntent.putExtra("KSta_StremVideoPublishId", localamo.izg);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", m.b.taX.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramaml.ean);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localamo.LxJ);
    localIntent.putExtra("KMediaTitle", localamo.izb);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOS, 0) > 0)
    {
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(24591);
      return true;
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  private static boolean a(Context paramContext, aml paramaml, boolean paramBoolean)
  {
    AppMethodBeat.i(231715);
    if ((paramaml == null) || (paramaml.Lwh == null) || (paramaml.Lwh.Lxi == null))
    {
      Log.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(231715);
      return false;
    }
    paramBoolean = s.a(paramContext, paramaml.Lwh.Lxi, paramaml, paramBoolean);
    AppMethodBeat.o(231715);
    return paramBoolean;
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, and paramand)
  {
    AppMethodBeat.i(24581);
    if (paramContext == null)
    {
      Log.w("MicroMsg.FavItemLogic", "Context is null");
      AppMethodBeat.o(24581);
      return;
    }
    if (paramg == null)
    {
      Log.w("MicroMsg.FavItemLogic", "Fav item is null");
      AppMethodBeat.o(24581);
      return;
    }
    Log.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
    long l;
    Object localObject2;
    Object localObject3;
    switch (paramg.field_type)
    {
    case -1: 
    case 0: 
    case 9: 
    case 13: 
    case 19: 
    case 20: 
    default: 
      Log.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(24581);
      return;
    case 1: 
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_detail_text", paramg.field_favProto.desc);
      ((Intent)localObject1).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.cUu());
      ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
      if (paramg.field_sourceCreateTime <= 0L) {}
      for (l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
      {
        ((Intent)localObject1).putExtra("key_detail_create_time", l);
        a(paramand, (Intent)localObject1);
        com.tencent.mm.plugin.fav.a.i.gF("FavoriteTextDetailUI", paramand.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
      }
    case 2: 
      e(paramContext, paramg, paramand);
      AppMethodBeat.o(24581);
      return;
    case 3: 
      localObject1 = new Intent();
      a(paramg, paramand, (Intent)localObject1);
      ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.Lya.createTime);
      com.tencent.mm.plugin.fav.a.i.gF("FavoriteVoiceDetailUI", paramand.sessionId);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
      AppMethodBeat.o(24581);
      return;
    case 16: 
      localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      if ((localObject1 != null) && (((aml)localObject1).Lwn != null) && ((!Util.isNullOrNil(((aml)localObject1).Lwn.iyZ)) || (!Util.isNullOrNil(((aml)localObject1).Lwn.izd))))
      {
        Log.i("MicroMsg.FavItemLogic", "it is ad sight.");
        c(paramContext, paramg, paramand);
        AppMethodBeat.o(24581);
        return;
      }
      d(paramContext, paramg, paramand);
      AppMethodBeat.o(24581);
      return;
    case 4: 
      d(paramContext, paramg, paramand);
      AppMethodBeat.o(24581);
      return;
    case 5: 
      d(paramContext, paramg, true, paramand);
      AppMethodBeat.o(24581);
      return;
    case 6: 
      if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      localObject2 = paramg.field_favProto.LwQ;
      localObject3 = paramg.field_favProto.remark;
      localObject1 = paramg.field_favProto.Lya;
      if ((localObject1 != null) && (!Util.isNullOrNil(((anh)localObject1).LxA))) {}
      for (localObject1 = com.tencent.mm.model.aa.getDisplayName(((anh)localObject1).LxA);; localObject1 = com.tencent.mm.model.aa.getDisplayName(paramg.field_fromUser))
      {
        ArrayList localArrayList = new ArrayList();
        if (paramg.field_tagProto.Lyo != null) {
          localArrayList.addAll(paramg.field_tagProto.Lyo);
        }
        com.tencent.mm.plugin.fav.a.i.gF("RedirectUI", paramand.sessionId);
        com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (ams)localObject2, (String)localObject1, (String)localObject3, localArrayList, paramContext);
        AppMethodBeat.o(24581);
        return;
      }
    case 7: 
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      localObject2 = paramg.field_favProto.Lya;
      localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramand = new o(com.tencent.mm.plugin.fav.a.b.a((aml)localObject1));
      if (!paramand.exists()) {
        if (((aml)localObject1).dFN == null)
        {
          paramand = "";
          paramand = com.tencent.mm.ay.i.a(6, null, ((aml)localObject1).title, ((aml)localObject1).desc, ((aml)localObject1).Lvu, ((aml)localObject1).Lvy, ((aml)localObject1).Lvw, ((aml)localObject1).dLl, com.tencent.mm.plugin.fav.a.b.cUl(), paramand, "", ((anh)localObject2).appId);
          paramand.jfm = ((aml)localObject1).songAlbumUrl;
          paramand.jfe = ((aml)localObject1).songLyric;
          paramand.jfw = ((aml)localObject1).dLl;
          if (com.tencent.mm.plugin.fav.a.b.f((aml)localObject1)) {
            break label965;
          }
          Log.i("MicroMsg.FavItemLogic", " start play music");
          com.tencent.mm.ay.a.c(paramand);
        }
      }
      for (;;)
      {
        paramand.jft = String.valueOf(paramg.field_localId);
        paramg = new Intent();
        paramg.putExtra("key_scene", 2);
        paramg.setFlags(268435456);
        com.tencent.mm.br.c.b(paramContext, "music", ".ui.MusicMainUI", paramg);
        AppMethodBeat.o(24581);
        return;
        paramand = new o(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(((aml)localObject1).dFN.getBytes()));
        if (paramand.exists()) {}
        for (paramand = com.tencent.mm.vfs.aa.z(paramand.her());; paramand = "") {
          break;
        }
        paramand = com.tencent.mm.vfs.aa.z(paramand.her());
        break;
        Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
      }
    case 21: 
      label965:
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      if (((aj)com.tencent.mm.kernel.g.ah(aj.class)).canEnterMvAndShowToast())
      {
        localObject3 = paramg.field_favProto.Lya;
        localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramand = new o(com.tencent.mm.plugin.fav.a.b.a((aml)localObject2));
        if (paramand.exists()) {
          break label1558;
        }
        if (((aml)localObject2).dFN != null) {
          break label1495;
        }
        paramand = "";
        if ((localObject2 == null) || (((aml)localObject2).Lwh == null)) {
          break label2328;
        }
      }
      break;
    }
    label1558:
    label2328:
    for (Object localObject1 = ((aml)localObject2).Lwh.Lxs;; localObject1 = null)
    {
      paramand = com.tencent.mm.ay.i.a(6, null, ((aml)localObject2).title, ((aml)localObject2).desc, ((aml)localObject2).Lvu, ((aml)localObject2).Lvy, ((aml)localObject2).Lvw, ((aml)localObject2).dLl, com.tencent.mm.plugin.fav.a.b.cUl(), paramand, "", ((anh)localObject3).appId, com.tencent.mm.ay.h.a(((aml)localObject2).dLl, (css)localObject1));
      paramand.jfm = ((aml)localObject2).songAlbumUrl;
      paramand.jfe = ((aml)localObject2).songLyric;
      paramand.jfw = ((aml)localObject2).dLl;
      if (!com.tencent.mm.plugin.fav.a.b.f((aml)localObject2))
      {
        Log.i("MicroMsg.FavItemLogic", " start play music");
        com.tencent.mm.ay.a.c(paramand);
      }
      for (;;)
      {
        paramand.jft = String.valueOf(paramg.field_localId);
        paramg = new Intent();
        paramg.putExtra("key_scene", 2);
        paramg.setFlags(268435456);
        if (localObject1 != null)
        {
          paramg.putExtra("key_mv_feed_id", ((css)localObject1).Ktn);
          paramg.putExtra("key_mv_nonce_id", ((css)localObject1).Kto);
          paramg.putExtra("key_mv_cover_url", ((css)localObject1).Ktp);
          paramg.putExtra("key_mv_poster", ((css)localObject1).Ktq);
          paramg.putExtra("key_mv_song_name", ((aml)localObject2).title);
          paramg.putExtra("key_mv_song_lyric", ((aml)localObject2).songLyric);
          paramg.putExtra("key_mv_album_cover_url", ((aml)localObject2).songAlbumUrl);
          paramg.putExtra("key_mv_singer_name", ((css)localObject1).singerName);
          paramg.putExtra("key_mv_album_name", ((css)localObject1).albumName);
          paramg.putExtra("key_mv_music_genre", ((css)localObject1).musicGenre);
          paramg.putExtra("key_mv_issue_date", String.valueOf(((css)localObject1).issueDate));
          paramg.putExtra("key_mv_identification", ((css)localObject1).identification);
          paramg.putExtra("key_mv_extra_info", ((css)localObject1).extraInfo);
          paramg.putExtra("key_mv_music_duration", ((css)localObject1).Alz);
          paramg.putExtra("key_mv_thumb_path", ((css)localObject1).jfz);
        }
        paramand = SecDataUIC.CWq;
        paramand = (cst)SecDataUIC.a.a(paramContext, "MusicMvMainUI", 7, cst.class);
        paramand.scene = 9;
        localObject1 = com.tencent.mm.plugin.comm.a.qCo;
        paramand.sGQ = com.tencent.mm.plugin.comm.a.cAK();
        paramand.MxI = 84;
        paramand.MxJ = ((aml)localObject2).dLl;
        com.tencent.mm.br.c.b(paramContext, "mv", ".ui.MusicMvMainUI", paramg);
        AppMethodBeat.o(24581);
        return;
        label1495:
        paramand = new o(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(((aml)localObject2).dFN.getBytes()));
        if (paramand.exists()) {}
        for (paramand = com.tencent.mm.vfs.aa.z(paramand.her());; paramand = "") {
          break;
        }
        paramand = com.tencent.mm.vfs.aa.z(paramand.her());
        break;
        Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
      }
      c(paramContext, paramg, true, paramand);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      l = paramg.field_localId;
      paramg = paramg.field_favProto.LwU.info;
      paramand = new Intent();
      paramand.putExtra("key_is_favorite_item", true);
      paramand.putExtra("key_favorite_local_id", l);
      paramand.putExtra("key_Product_xml", paramg);
      paramand.putExtra("key_can_delete_favorite_item", true);
      paramand.putExtra("key_ProductUI_getProductInfoScene", 3);
      com.tencent.mm.br.c.b(paramContext, "scanner", ".ui.ProductUI", paramand);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      l = paramg.field_localId;
      paramg = paramg.field_favProto.LwW.info;
      paramand = new Intent();
      paramand.putExtra("key_TV_getProductInfoScene", 3);
      paramand.putExtra("key_is_favorite_item", true);
      paramand.putExtra("key_favorite_local_id", l);
      paramand.putExtra("key_TV_xml", paramg);
      paramand.putExtra("key_can_delete_favorite_item", true);
      com.tencent.mm.br.c.b(paramContext, "shake", ".ui.TVInfoUI", paramand);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramand = new Intent();
      paramand.putExtra("key_product_scene", 4);
      paramand.putExtra("key_product_info", paramg.field_favProto.LwU.info);
      com.tencent.mm.br.c.b(paramContext, "product", ".ui.MallProductUI", paramand);
      AppMethodBeat.o(24581);
      return;
      a(paramContext, paramg, true, paramand);
      AppMethodBeat.o(24581);
      return;
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
      bg.aVF();
      paramg = com.tencent.mm.model.c.aSQ().aEK(paramg);
      if (paramg == null) {
        break;
      }
      if ((!com.tencent.mm.model.ab.IT(paramg.dkU)) || (WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext)))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramg.dkU);
        ((Intent)localObject1).putExtra("Contact_Alias", paramg.fMb);
        ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
        ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.kfR);
        ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.kfQ);
        ((Intent)localObject1).putExtra("Contact_Uin", paramg.Bge);
        ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.OqK);
        ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.OqL);
        ((Intent)localObject1).putExtra("Contact_QQNick", paramg.gDZ());
        ((Intent)localObject1).putExtra("User_From_Fmessage", false);
        ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
        ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.kfV);
        ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.IOs);
        ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.fuN);
        ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.BdC);
        ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
        ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
        ((Intent)localObject1).putExtra("Contact_Sex", paramg.fuA);
        ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
        ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
        ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
        com.tencent.mm.plugin.fav.a.i.gF("ContactInfoUI", paramand.sessionId);
        com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
        com.tencent.mm.bs.a.aiT(paramg.scene);
      }
      AppMethodBeat.o(24581);
      return;
      b(paramContext, paramg, true, paramand);
      AppMethodBeat.o(24581);
      return;
      Toast.makeText(paramContext, 2131759353, 0).show();
      AppMethodBeat.o(24581);
      return;
    }
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, and paramand)
  {
    AppMethodBeat.i(24583);
    Log.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    oc localoc = new oc();
    localoc.dUe.field_localId = paramg.field_localId;
    Object localObject;
    if ((!Util.isNullOrNil(paramg.taf)) && (paramg.field_favProto != null) && (paramg.field_favProto.ppH != null) && (paramg.field_favProto.ppH.size() > 0))
    {
      localObject = paramg.field_favProto.ppH.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label399;
      }
      if (!Util.isEqual(((aml)((Iterator)localObject).next()).dLl, paramg.taf)) {
        break label350;
      }
    }
    label384:
    label399:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localoc.dUe.dUh) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localoc.dUe;
          ((oc.a)localObject).dUh -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label384;
        }
        localoc.dUe.dUn = 4;
      }
      for (;;)
      {
        localoc.dUe.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.KBr;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((amv)localObject).LxT);
          paramContext.putString("noteeditor", ((amv)localObject).LxU);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localoc.dUe.dUl = paramContext;
        localoc.dUe.field_favProto = paramg.field_favProto;
        localoc.dUe.type = 2;
        localoc.dUe.dUo = paramBoolean;
        localoc.dUe.dUp = paramand;
        EventCenter.instance.publish(localoc);
        com.tencent.mm.plugin.fav.a.i.gF("NoteEditorUI", paramand.sessionId);
        AppMethodBeat.o(24583);
        return;
        label350:
        oc.a locala = localoc.dUe;
        locala.dUh += 1;
        break;
        localoc.dUe.dUh = 0;
        break label190;
        localoc.dUe.dUg = paramg.field_xml;
      }
    }
  }
  
  public static void b(o.a parama, final Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24597);
    if ((paramg == null) || (paramContext == null))
    {
      Log.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24597);
      return;
    }
    final aml localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24574);
          d.f(this.val$context, paramg, new and());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", this.sZW.field_favProto.desc);
          com.tencent.mm.br.c.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.kc(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24576);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          if (this.tno != null)
          {
            localIntent.putExtra("kwebmap_slat", this.tno.lat);
            localIntent.putExtra("kwebmap_lng", this.tno.lng);
            localIntent.putExtra("Kwebmap_locaion", this.tno.label);
          }
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(24576);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24577);
          d.g(this.val$context, paramg, new and());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24578);
          d.h(this.val$context, paramg, new and());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.sZW.field_localId);
          localIntent.putExtra("key_detail_data_id", localaml.dLl);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24580);
          aml localaml = com.tencent.mm.plugin.fav.a.b.c(this.sZW);
          if (localaml == null)
          {
            Log.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.b(paramContext, localaml))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localaml.Lwn != null) && ((!Util.isNullOrNil(localaml.Lwn.iyZ)) || (!Util.isNullOrNil(localaml.Lwn.izd))))
          {
            Log.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", this.sZW.field_localId);
            localIntent.putExtra("key_detail_data_id", localaml.dLl);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.sZW.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localaml));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localaml));
          localIntent.putExtra("key_detail_fav_video_duration", localaml.duration);
          localIntent.putExtra("key_detail_statExtStr", localaml.ean);
          localIntent.putExtra("key_detail_msg_uuid", localaml.jsz);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(24572);
          d.i(this.val$context, paramg, new and());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(163190);
          bcj localbcj = this.sZW.field_favProto.Lxk;
          if (localbcj != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.teu;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localbcj);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, and paramand)
  {
    AppMethodBeat.i(24590);
    m.a(m.a.taL, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramand, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, and paramand)
  {
    AppMethodBeat.i(24584);
    aml localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramand != null) && (paramand.ecL == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!Util.isNullOrNil(paramg.taf))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.taf);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramand, (Intent)localObject);
        com.tencent.mm.plugin.fav.a.i.gF("FavoriteFileDetailUI", paramand.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramand != null) && (paramand.ecL == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d(localaml), localaml.LvC, 2);
      AppMethodBeat.o(24584);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.g(localaml))
    {
      if (com.tencent.mm.plugin.fav.a.b.h(localaml))
      {
        e(paramContext, paramg, paramand);
        AppMethodBeat.o(24584);
        return;
      }
      if (paramg == null) {
        break label347;
      }
    }
    label347:
    for (Object localObject = String.valueOf(paramg.field_id);; localObject = null)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.fromFavItem(localaml, (String)localObject, null, com.tencent.mm.plugin.fav.a.b.d(localaml)));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.bl(com.tencent.mm.plugin.fav.a.b.d(localaml), localaml.LvC, localaml.title))
      {
        AppMethodBeat.o(24584);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("key_detail_data_id", localaml.dLl);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      a(paramand, (Intent)localObject);
      com.tencent.mm.plugin.fav.a.i.gF("FavoriteFileDetailUI", paramand.sessionId);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
      AppMethodBeat.o(24584);
      return;
    }
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, and paramand)
  {
    AppMethodBeat.i(24592);
    aml localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localaml, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (a(paramContext, localaml, false))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((Util.isNullOrNil(localaml.LvE)) || (localaml.LvI <= 0L))
    {
      Log.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localaml.LvE, Long.valueOf(localaml.LvI) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).Lvu;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).Lvy;
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramand);
        AppMethodBeat.o(24592);
        return;
      }
      paramand = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localaml.ean);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramand.putExtra("jsapiargs", (Bundle)localObject2);
      paramand.putExtra("rawUrl", (String)localObject1);
      paramand.putExtra("is_favorite_item", true);
      paramand.putExtra("fav_local_id", paramg.field_localId);
      paramand.putExtra("geta8key_scene", 14);
      Log.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramand.putExtra("geta8key_scene", 14);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramand);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramand, (Intent)localObject1);
    com.tencent.mm.plugin.fav.a.i.gF("FavoriteSightDetailUI", paramand.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, and paramand)
  {
    AppMethodBeat.i(24587);
    if ((paramg == null) || (paramg.field_favProto == null))
    {
      if (paramg == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.e("MicroMsg.FavItemLogic", "handleWebPageItem, null == favItemInfo(%b) || null == favItemInfo.field_favProto", new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(24587);
        return;
      }
    }
    Object localObject1 = J(paramg);
    if (!Util.isNullOrNil((String)localObject1))
    {
      paramand = new Intent();
      paramand.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramand.putExtra("sns_landig_pages_from_source", 7);
      paramand.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramand.putExtra("sns_landing_favid", z.aTY() + "_" + paramg.field_id);
      paramand.addFlags(268435456);
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramand);
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject2 = paramg.field_favProto.LwS;
    if ((localObject2 != null) && (((anq)localObject2).LyI) && (!Util.isNullOrNil(((anq)localObject2).LyH)))
    {
      paramg = XmlParser.parseXml(((anq)localObject2).LyH, "websearch", null);
      if (paramg == null)
      {
        Log.e("MicroMsg.FavItemLogic", "XmlParser.parseXml fail, values is null");
        AppMethodBeat.o(24587);
        return;
      }
      paramand = new fat();
      paramand.IEy = ((String)paramg.get(".websearch.relevant_vid"));
      paramand.IEz = ((String)paramg.get(".websearch.relevant_expand"));
      paramand.IEA = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramand.IEB = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramand.IEC = Util.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramand.rCq = ((String)paramg.get(".websearch.shareUrl"));
      paramand.msN = ((String)paramg.get(".websearch.shareTitle"));
      paramand.xDQ = ((String)paramg.get(".websearch.shareDesc"));
      paramand.IED = ((String)paramg.get(".websearch.shareImgUrl"));
      paramand.IEE = ((String)paramg.get(".websearch.shareString"));
      paramand.IEF = ((String)paramg.get(".websearch.shareStringUrl"));
      paramand.source = ((String)paramg.get(".websearch.source"));
      paramand.eby = ((String)paramg.get(".websearch.sourceUrl"));
      paramand.IEG = ((String)paramg.get(".websearch.strPlayCount"));
      paramand.IEH = ((String)paramg.get(".websearch.titleUrl"));
      paramand.IEI = ((String)paramg.get(".websearch.extReqParams"));
      paramand.IEJ = ((String)paramg.get(".websearch.tagList"));
      paramand.IEK = Util.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramand.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramand.IEL = ((String)paramg.get(".websearch.shareTag"));
      ai.a(paramContext, com.tencent.mm.plugin.topstory.a.h.a(paramand, 326, paramContext.getString(2131766865)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      localObject3 = ((anq)localObject2).LyC;
      localObject1 = ((anq)localObject2).title;
    }
    for (localObject2 = ((anq)localObject2).desc;; localObject2 = "")
    {
      anh localanh = paramg.field_favProto.Lya;
      Object localObject4 = localObject3;
      if (localanh != null)
      {
        localObject4 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject4 = localanh.link;
        }
      }
      Object localObject5 = localObject4;
      if (Util.isNullOrNil((String)localObject4)) {
        if (paramg.field_favProto.ppH.size() <= 0) {
          break label754;
        }
      }
      label754:
      for (localObject3 = ((aml)paramg.field_favProto.ppH.get(0)).Lvu;; localObject3 = null)
      {
        localObject5 = localObject3;
        if (!Util.isNullOrNil(localObject5)) {
          break;
        }
        Log.w("MicroMsg.FavItemLogic", "go to web page error, url null, dataid[%s]", new Object[] { paramg.taf });
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.g.ah(PluginFavOffline.class)).useOffline(localObject5, paramg.field_localId))
      {
        Log.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject5 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.g.ah(PluginFavOffline.class)).getFavOfflineService().ash(localObject5);
      aml localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      localObject4 = localObject1;
      if (localaml != null)
      {
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = localaml.title;
        }
        localObject6 = localObject2;
        localObject4 = localObject3;
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject6 = localaml.desc;
          localObject4 = localObject3;
        }
      }
      Log.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", localObject5);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.cUw());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("webpageTitle", (String)localObject4);
      if ((localanh != null) && (!Util.isNullOrNil(localanh.dCl))) {
        ((Intent)localObject1).putExtra("srcDisplayname", com.tencent.mm.model.aa.getDisplayName(localanh.dCl));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).ean);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + z.aTY() + "_" + paramg.field_id;
      ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
      ((Intent)localObject1).putExtra("pre_username", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
      ((Intent)localObject1).putExtra("preChatTYPE", 14);
      ((Intent)localObject1).putExtra("share_report_pre_msg_url", localObject5);
      ((Intent)localObject1).putExtra("share_report_pre_msg_title", (String)localObject4);
      ((Intent)localObject1).putExtra("share_report_pre_msg_desc", (String)localObject6);
      ((Intent)localObject1).putExtra("share_report_pre_msg_icon_url", K(paramg));
      ((Intent)localObject1).putExtra("share_report_pre_msg_appid", "");
      ((Intent)localObject1).putExtra("share_report_from_scene", 4);
      localObject2 = com.tencent.mm.modelstat.a.c.PV(com.tencent.mm.pluginsdk.model.g.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramand.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramand.pHw);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramand.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramand.query);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramand.sessionId);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramand.tay);
      com.tencent.mm.plugin.fav.a.i.gF("WebViewUI", paramand.sessionId);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      ((Intent)localObject1).putExtra("key_enable_teen_mode_check", true);
      if ((paramg.field_favProto.IXu != null) && (paramg.field_favProto.IXu.iwe == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(paramg.field_favProto.IXu.iwc)))
      {
        a(paramContext, paramg, paramand, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
      }
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, and paramand)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramand, localIntent);
    com.tencent.mm.plugin.fav.a.i.gF("FavoriteImgDetailUI", paramand.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */