package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static int[] rNC = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.GBf != null) && (!bu.isNullOrNil(paramg.field_favProto.GBf.canvasPageXml)))
    {
      paramg = paramg.field_favProto.GBf.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.oeJ;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((ajx)paramg.get(0)).canvasPageXml;
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
    if ((paramg.field_favProto.GBf != null) && (!bu.isNullOrNil(paramg.field_favProto.GBf.thumbUrl)))
    {
      paramg = paramg.field_favProto.GBf.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.oeJ;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((ajx)paramg.get(0)).hCS;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akp paramakp, Intent paramIntent)
  {
    AppMethodBeat.i(24588);
    paramIntent.putExtra(e.b.JoV, paramakp.scene);
    paramIntent.putExtra(e.b.JoW, paramakp.otZ);
    paramIntent.putExtra("biz_video_session_id", y.getSessionId());
    paramakp = paramg.field_favProto.Ekw;
    paramg = new x();
    paramg.dpP = paramakp.dpP;
    paramg.hFW = paramakp.hFW;
    paramg.hFY.url = paramIntent.getStringExtra("rawUrl");
    paramg.hFY.title = bu.nullAsNil(paramIntent.getStringExtra("share_report_pre_msg_title"));
    paramg.hFY.hGg = paramIntent.getStringExtra("share_report_pre_msg_desc");
    paramg.hFY.hGe = paramakp.hGe;
    paramg.hFY.type = paramakp.hBV;
    paramg.hFY.hBY = paramakp.hBY;
    paramg.hFY.time = paramakp.hBW;
    paramg.hFY.hGi = paramakp.duration;
    paramg.hFY.videoWidth = paramakp.videoWidth;
    paramg.hFY.videoHeight = paramakp.videoHeight;
    paramg.hFY.hCa = paramakp.hCa;
    paramg.t(paramIntent);
    ae.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramakp.GBW != null) {
      paramIntent.putExtra("img_gallery_width", paramakp.GBW.width).putExtra("img_gallery_height", paramakp.GBW.height).putExtra("img_gallery_left", paramakp.GBW.left).putExtra("img_gallery_top", paramakp.GBW.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramakp = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d(paramg.hFY.url, 24, 10000, i);
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, paramakp, paramg.hFY.type, 24, 10000, paramIntent)) {
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    }
    AppMethodBeat.o(24588);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akp paramakp)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramakp, localIntent);
    com.tencent.mm.plugin.fav.a.i.gn("FavRecordDetailUI", paramakp.sessionId);
    com.tencent.mm.br.d.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, akp paramakp, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramakp, paramIntent);
    paramIntent.putExtra("key_detail_info_id", paramg.field_localId);
    AppMethodBeat.o(24594);
  }
  
  public static void a(o.a parama, final Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(24596);
    if ((paramg == null) || (paramContext == null))
    {
      ae.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24596);
      return;
    }
    ajx localajx1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      ae.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      label53:
      localObject1 = null;
      label55:
      if (!(localObject1 instanceof String)) {
        break label1367;
      }
    }
    Object localObject2;
    for (Object localObject1 = (String)localObject1;; localObject1 = null)
    {
      localObject2 = paramg.field_favProto.GBf;
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
          if (!bu.isNullOrNil(((alc)localObject2).title)) {
            paramg = ((alc)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (bu.isNullOrNil(paramg)) {
          localObject1 = localajx1.title;
        }
        parama.aOo(paramContext.getResources().getString(2131755278) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        ajx localajx2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new k(com.tencent.mm.plugin.fav.a.b.a(localajx2));
          if (((k)localObject1).exists())
          {
            localObject1 = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
            break label55;
          }
          localObject1 = paramg.field_favProto.GBf;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((alc)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bu.isNullOrNil((String)localObject1)) {
              localObject2 = localajx2.dox;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.ahe((String)localObject2);
            localObject1 = localObject2;
            if (!bu.isNullOrNil((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(2131689584);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.GBh;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.ahe(((akm)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bu.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689577);
            break label55;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.GBj;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.ahe(((akw)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bu.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689577);
            break label55;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new k(com.tencent.mm.plugin.fav.a.b.a(localajx2));
          if (((k)localObject1).exists())
          {
            localObject1 = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.ahe(localajx2.dox);
          localObject2 = localObject1;
          if (bu.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localajx2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localajx2);
          }
          localObject1 = localObject2;
          if (!bu.isNullOrNil((String)localObject2)) {
            break label55;
          }
        }
        switch (paramg.field_type)
        {
        default: 
          localObject1 = Integer.valueOf(2131689581);
          break;
        case 2: 
          localObject1 = Integer.valueOf(2131230944);
          break;
        case 7: 
          localObject1 = Integer.valueOf(2131689564);
          break;
          if ((3 == paramg.field_type) || (6 == paramg.field_type)) {
            break label53;
          }
          if (8 == paramg.field_type)
          {
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.aME(localajx2.GzP));
            break;
          }
          if (17 == paramg.field_type)
          {
            bc.aCg();
            localObject1 = com.tencent.mm.model.c.azI().arp(localajx2.desc);
            if ((((bv.a)localObject1).cUA != null) && (((bv.a)localObject1).cUA.length() != 0))
            {
              localObject1 = new SpannableString(((bv.a)localObject1).cUA);
              break;
            }
            localObject1 = Integer.valueOf(2131231875);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.oeJ == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.oeJ.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localajx2 = (ajx)((Iterator)localObject1).next();
            } while (localajx2.dataType == 1);
            if (localajx2.dataType == 3)
            {
              localObject1 = Integer.valueOf(2131689583);
              break label55;
            }
            if (localajx2.dataType == 6)
            {
              localObject1 = Integer.valueOf(2131689562);
              break label55;
            }
            if (localajx2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.aME(localajx2.GzP));
              break label55;
            }
            if ((localajx2.dataType == 2) || (localajx2.dataType == 7) || (localajx2.dataType == 15) || (localajx2.dataType == 4))
            {
              localObject1 = new k(com.tencent.mm.plugin.fav.a.b.a(localajx2));
              if (((k)localObject1).exists())
              {
                localObject1 = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.ahe(localajx2.dox);
              if (bu.isNullOrNil((String)localObject1)) {
                switch (localajx2.dataType)
                {
                default: 
                  localObject1 = Integer.valueOf(2131689581);
                  break;
                case 2: 
                  localObject1 = Integer.valueOf(2131230944);
                  break;
                case 7: 
                  localObject1 = Integer.valueOf(2131689564);
                  break;
                }
              }
              break label55;
            }
            if (localajx2.dataType == 5)
            {
              localObject1 = new k(com.tencent.mm.plugin.fav.a.b.a(localajx2));
              if (((k)localObject1).exists())
              {
                localObject1 = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
                break label55;
              }
              localObject1 = localajx2.GAu.GBf;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((alc)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (bu.isNullOrNil((String)localObject1)) {
                  localObject2 = localajx2.dox;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.ahe((String)localObject2);
                localObject1 = localObject2;
                if (!bu.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(2131689584);
                break;
              }
            }
            if (localajx2.dataType == 22)
            {
              localObject1 = Integer.valueOf(2131690572);
              break label55;
            }
            if ((localajx2.dataType == 10) || (localajx2.dataType == 11))
            {
              localObject2 = localajx2.GAu.GBh;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.ahe(((akm)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bu.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
            if ((localajx2.dataType == 12) || (localajx2.dataType == 14))
            {
              localObject2 = localajx2.GAu.GBj;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.ahe(((akw)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bu.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
          } while (localajx2.dataType != 16);
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azI().arp(localajx2.desc);
          if ((((bv.a)localObject1).cUA != null) && (((bv.a)localObject1).cUA.length() != 0))
          {
            localObject1 = new SpannableString(((bv.a)localObject1).cUA);
            break;
          }
          localObject1 = Integer.valueOf(2131231875);
          break;
          label1367:
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
    if (bu.isNullOrNil((String)localObject1)) {
      paramg = localajx1.title;
    }
    parama.aOo(paramContext.getResources().getString(2131755773) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.aOo(paramg.field_favProto.desc);
    parama.fgo();
    parama.a(new d.a.b()
    {
      public final void cza()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", this.rAs.field_favProto.desc);
        com.tencent.mm.br.d.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.kk(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.GBd;
    paramg = paramContext.getString(2131755806);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((ake)localObject1).label;
    }
    parama.aOo(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!bu.isNullOrNil(((alc)localObject2).title)))
    {
      paramg = ((alc)localObject2).title;
      localObject1 = ((alc)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (bu.isNullOrNil(paramg)) {
        localObject2 = localajx1.title;
      }
      bu.isNullOrNil((String)localObject1);
      parama.aOo(paramContext.getResources().getString(2131755920) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.aOo(paramContext.getResources().getString(2131755872) + paramg);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.h.aRC((String)localObject1), 3);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.h.aRC((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.h.aRC((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      localObject1 = paramContext.getResources().getString(2131755834);
      paramContext = l.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.aOo((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.GBx;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(2131755775) + paramg.desc;; paramContext = paramContext.getString(2131755775))
      {
        parama.aOo(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!bu.isNullOrNil(((alc)localObject2).title)) {
          paramg = ((alc)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (bu.isNullOrNil(paramg)) {
        localObject1 = localajx1.title;
      }
      parama.aOo(paramContext.getResources().getString(2131755820) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.GBs != null) {}
      for (paramContext = paramContext.getString(2131755375) + paramg.field_favProto.title;; paramContext = paramContext.getString(2131755375))
      {
        parama.aOo(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(akp paramakp, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramakp.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramakp.otZ);
    paramIntent.putExtra("key_detail_fav_index", paramakp.index);
    paramIntent.putExtra("key_detail_fav_query", paramakp.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramakp.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramakp.rAT);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, ajx paramajx, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    aka localaka = paramajx.GAA;
    if ((localaka == null) || (bu.isNullOrNil(localaka.hET)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    m.a(m.a.rBi, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramajx);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localaka.hET);
    localIntent.putExtra("StreamWording", localaka.hEW);
    localIntent.putExtra("StremWebUrl", localaka.hEX);
    localIntent.putExtra("KThumUrl", localaka.hEY);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localaka.hEZ);
    localIntent.putExtra("KSta_StremVideoPublishId", localaka.hFa);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", m.b.rBs.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramajx.dIA);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localaka.GBN);
    localIntent.putExtra("KMediaTitle", localaka.hEV);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxf, 0) > 0)
    {
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ae.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(24591);
      return true;
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  private static boolean a(Context paramContext, ajx paramajx, boolean paramBoolean)
  {
    AppMethodBeat.i(186476);
    if ((paramajx == null) || (paramajx.GAu == null) || (paramajx.GAu.GBv == null))
    {
      ae.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(186476);
      return false;
    }
    paramBoolean = r.a(paramContext, paramajx.GAu.GBv, paramajx, paramBoolean);
    AppMethodBeat.o(186476);
    return paramBoolean;
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akp paramakp)
  {
    AppMethodBeat.i(24581);
    if (paramContext == null)
    {
      ae.w("MicroMsg.FavItemLogic", "Context is null");
      AppMethodBeat.o(24581);
      return;
    }
    if (paramg == null)
    {
      ae.w("MicroMsg.FavItemLogic", "Fav item is null");
      AppMethodBeat.o(24581);
      return;
    }
    ae.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
    switch (paramg.field_type)
    {
    case -1: 
    case 0: 
    case 9: 
    case 13: 
    default: 
      ae.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
    case 1: 
    case 2: 
    case 3: 
    case 16: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
    case 15: 
    case 11: 
    case 14: 
    case 17: 
      do
      {
        AppMethodBeat.o(24581);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_detail_text", paramg.field_favProto.desc);
        ((Intent)localObject1).putExtra("key_detail_info_id", paramg.field_localId);
        ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.cwr());
        ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
        if (paramg.field_sourceCreateTime <= 0L) {}
        for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
        {
          ((Intent)localObject1).putExtra("key_detail_create_time", l);
          a(paramakp, (Intent)localObject1);
          com.tencent.mm.plugin.fav.a.i.gn("FavoriteTextDetailUI", paramakp.sessionId);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
          AppMethodBeat.o(24581);
          return;
        }
        e(paramContext, paramg, paramakp);
        AppMethodBeat.o(24581);
        return;
        localObject1 = new Intent();
        a(paramg, paramakp, (Intent)localObject1);
        ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.GCe.createTime);
        com.tencent.mm.plugin.fav.a.i.gn("FavoriteVoiceDetailUI", paramakp.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if ((localObject1 != null) && (((ajx)localObject1).GAA != null) && ((!bu.isNullOrNil(((ajx)localObject1).GAA.hET)) || (!bu.isNullOrNil(((ajx)localObject1).GAA.hEX))))
        {
          ae.i("MicroMsg.FavItemLogic", "it is ad sight.");
          c(paramContext, paramg, paramakp);
          AppMethodBeat.o(24581);
          return;
        }
        d(paramContext, paramg, paramakp);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, paramakp);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, true, paramakp);
        AppMethodBeat.o(24581);
        return;
        Object localObject2 = paramg.field_favProto.GBd;
        String str = paramg.field_favProto.iWF;
        localObject1 = paramg.field_favProto.GCe;
        if ((localObject1 != null) && (!bu.isNullOrNil(((akt)localObject1).GBE))) {}
        for (localObject1 = com.tencent.mm.model.w.zP(((akt)localObject1).GBE);; localObject1 = com.tencent.mm.model.w.zP(paramg.field_fromUser))
        {
          ArrayList localArrayList = new ArrayList();
          if (paramg.field_tagProto.GCs != null) {
            localArrayList.addAll(paramg.field_tagProto.GCs);
          }
          com.tencent.mm.plugin.fav.a.i.gn("RedirectUI", paramakp.sessionId);
          com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (ake)localObject2, (String)localObject1, str, localArrayList, paramContext);
          AppMethodBeat.o(24581);
          return;
        }
        localObject2 = paramg.field_favProto.GCe;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramakp = new k(com.tencent.mm.plugin.fav.a.b.a((ajx)localObject1));
        if (!paramakp.exists()) {
          if (((ajx)localObject1).dox == null)
          {
            paramakp = "";
            paramakp = com.tencent.mm.ay.g.a(6, null, ((ajx)localObject1).title, ((ajx)localObject1).desc, ((ajx)localObject1).GzH, ((ajx)localObject1).GzL, ((ajx)localObject1).GzJ, ((ajx)localObject1).dua, com.tencent.mm.plugin.fav.a.b.cwi(), paramakp, "", ((akt)localObject2).appId);
            paramakp.ikq = ((ajx)localObject1).songAlbumUrl;
            paramakp.iki = ((ajx)localObject1).songLyric;
            paramakp.ikA = ((ajx)localObject1).dua;
            if (com.tencent.mm.plugin.fav.a.b.f((ajx)localObject1)) {
              break label912;
            }
            ae.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.ay.a.c(paramakp);
          }
        }
        for (;;)
        {
          paramakp.ikx = String.valueOf(paramg.field_localId);
          paramg = new Intent();
          paramg.putExtra("key_scene", 2);
          com.tencent.mm.br.d.b(paramContext, "music", ".ui.MusicMainUI", paramg);
          AppMethodBeat.o(24581);
          return;
          paramakp = new k(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(((ajx)localObject1).dox.getBytes()));
          if (paramakp.exists()) {}
          for (paramakp = com.tencent.mm.vfs.w.B(paramakp.fTh());; paramakp = "") {
            break;
          }
          paramakp = com.tencent.mm.vfs.w.B(paramakp.fTh());
          break;
          ae.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
        }
        c(paramContext, paramg, true, paramakp);
        AppMethodBeat.o(24581);
        return;
        ae.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.GBh.info;
        paramakp = new Intent();
        paramakp.putExtra("key_is_favorite_item", true);
        paramakp.putExtra("key_favorite_local_id", l);
        paramakp.putExtra("key_Product_xml", paramg);
        paramakp.putExtra("key_can_delete_favorite_item", true);
        paramakp.putExtra("key_ProductUI_getProductInfoScene", 3);
        com.tencent.mm.br.d.b(paramContext, "scanner", ".ui.ProductUI", paramakp);
        AppMethodBeat.o(24581);
        return;
        ae.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.GBj.info;
        paramakp = new Intent();
        paramakp.putExtra("key_TV_getProductInfoScene", 3);
        paramakp.putExtra("key_is_favorite_item", true);
        paramakp.putExtra("key_favorite_local_id", l);
        paramakp.putExtra("key_TV_xml", paramg);
        paramakp.putExtra("key_can_delete_favorite_item", true);
        com.tencent.mm.br.d.b(paramContext, "shake", ".ui.TVInfoUI", paramakp);
        AppMethodBeat.o(24581);
        return;
        ae.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        paramakp = new Intent();
        paramakp.putExtra("key_product_scene", 4);
        paramakp.putExtra("key_product_info", paramg.field_favProto.GBh.info);
        com.tencent.mm.br.d.b(paramContext, "product", ".ui.MallProductUI", paramakp);
        AppMethodBeat.o(24581);
        return;
        a(paramContext, paramg, true, paramakp);
        AppMethodBeat.o(24581);
        return;
        paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
        bc.aCg();
        paramg = com.tencent.mm.model.c.azI().arp(paramg);
      } while (paramg == null);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Contact_User", paramg.cUA);
      ((Intent)localObject1).putExtra("Contact_Alias", paramg.fhy);
      ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
      ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.jhO);
      ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.jhN);
      ((Intent)localObject1).putExtra("Contact_Uin", paramg.xik);
      ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.JgT);
      ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.JgU);
      ((Intent)localObject1).putExtra("Contact_QQNick", paramg.fwt());
      ((Intent)localObject1).putExtra("User_From_Fmessage", false);
      ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
      ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
      ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.jhS);
      ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.Ecg);
      ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.eRk);
      ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.xfV);
      ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
      ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
      ((Intent)localObject1).putExtra("Contact_Sex", paramg.eQV);
      ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
      ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
      ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
      com.tencent.mm.plugin.fav.a.i.gn("ContactInfoUI", paramakp.sessionId);
      com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      com.tencent.mm.bs.a.aae(paramg.scene);
      AppMethodBeat.o(24581);
      return;
    case 18: 
      label912:
      b(paramContext, paramg, true, paramakp);
      AppMethodBeat.o(24581);
      return;
    }
    Toast.makeText(paramContext, 2131759027, 0).show();
    AppMethodBeat.o(24581);
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akp paramakp)
  {
    AppMethodBeat.i(24583);
    ae.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    nk localnk = new nk();
    localnk.dCo.field_localId = paramg.field_localId;
    Object localObject;
    if ((!bu.isNullOrNil(paramg.rAB)) && (paramg.field_favProto != null) && (paramg.field_favProto.oeJ != null) && (paramg.field_favProto.oeJ.size() > 0))
    {
      localObject = paramg.field_favProto.oeJ.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label399;
      }
      if (!bu.lX(((ajx)((Iterator)localObject).next()).dua, paramg.rAB)) {
        break label350;
      }
    }
    label384:
    label399:
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localnk.dCo.dCr) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localnk.dCo;
          ((nk.a)localObject).dCr -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label384;
        }
        localnk.dCo.dCx = 4;
      }
      for (;;)
      {
        localnk.dCo.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.FId;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((akh)localObject).GBX);
          paramContext.putString("noteeditor", ((akh)localObject).GBY);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localnk.dCo.dCv = paramContext;
        localnk.dCo.field_favProto = paramg.field_favProto;
        localnk.dCo.type = 2;
        localnk.dCo.dCy = paramBoolean;
        localnk.dCo.dCz = paramakp;
        com.tencent.mm.sdk.b.a.IvT.l(localnk);
        com.tencent.mm.plugin.fav.a.i.gn("NoteEditorUI", paramakp.sessionId);
        AppMethodBeat.o(24583);
        return;
        label350:
        nk.a locala = localnk.dCo;
        locala.dCr += 1;
        break;
        localnk.dCo.dCr = 0;
        break label190;
        localnk.dCo.dCq = paramg.field_xml;
      }
    }
  }
  
  public static void b(o.a parama, final Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24597);
    if ((paramg == null) || (paramContext == null))
    {
      ae.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24597);
      return;
    }
    final ajx localajx = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24574);
          d.f(this.val$context, paramg, new akp());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", this.rAs.field_favProto.desc);
          com.tencent.mm.br.d.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.kk(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24576);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          if (this.rND != null)
          {
            localIntent.putExtra("kwebmap_slat", this.rND.lat);
            localIntent.putExtra("kwebmap_lng", this.rND.lng);
            localIntent.putExtra("Kwebmap_locaion", this.rND.label);
          }
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(24576);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24577);
          d.g(this.val$context, paramg, new akp());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24578);
          d.h(this.val$context, paramg, new akp());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.rAs.field_localId);
          localIntent.putExtra("key_detail_data_id", localajx.dua);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24580);
          ajx localajx = com.tencent.mm.plugin.fav.a.b.c(this.rAs);
          if (localajx == null)
          {
            ae.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.b(paramContext, localajx))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localajx.GAA != null) && ((!bu.isNullOrNil(localajx.GAA.hET)) || (!bu.isNullOrNil(localajx.GAA.hEX))))
          {
            ae.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", this.rAs.field_localId);
            localIntent.putExtra("key_detail_data_id", localajx.dua);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.rAs.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localajx));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localajx));
          localIntent.putExtra("key_detail_fav_video_duration", localajx.duration);
          localIntent.putExtra("key_detail_statExtStr", localajx.dIA);
          localIntent.putExtra("key_detail_msg_uuid", localajx.ixk);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(24572);
          d.i(this.val$context, paramg, new akp());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(163190);
          ary localary = this.rAs.field_favProto.GBx;
          if (localary != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.rEP;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localary);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akp paramakp)
  {
    AppMethodBeat.i(24590);
    m.a(m.a.rBg, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramakp, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akp paramakp)
  {
    AppMethodBeat.i(24584);
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramakp != null) && (paramakp.dKW == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!bu.isNullOrNil(paramg.rAB))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.rAB);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramakp, (Intent)localObject);
        com.tencent.mm.plugin.fav.a.i.gn("FavoriteFileDetailUI", paramakp.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramakp != null) && (paramakp.dKW == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d((ajx)localObject), ((ajx)localObject).GzP, 2);
      AppMethodBeat.o(24584);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.g((ajx)localObject))
    {
      if (com.tencent.mm.plugin.fav.a.b.h((ajx)localObject))
      {
        e(paramContext, paramg, paramakp);
        AppMethodBeat.o(24584);
        return;
      }
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.b((ajx)localObject, paramg));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.i(com.tencent.mm.plugin.fav.a.b.d((ajx)localObject), ((ajx)localObject).GzP, ((ajx)localObject).title, 2))
      {
        AppMethodBeat.o(24584);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("key_detail_data_id", ((ajx)localObject).dua);
    localIntent.putExtra("show_share", paramBoolean);
    a(paramakp, localIntent);
    com.tencent.mm.plugin.fav.a.i.gn("FavoriteFileDetailUI", paramakp.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
    AppMethodBeat.o(24584);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akp paramakp)
  {
    AppMethodBeat.i(24592);
    ajx localajx = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localajx, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (a(paramContext, localajx, false))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((bu.isNullOrNil(localajx.GzR)) || (localajx.GzV <= 0L))
    {
      ae.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localajx.GzR, Long.valueOf(localajx.GzV) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).GzH;
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).GzL;
      }
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramakp);
        AppMethodBeat.o(24592);
        return;
      }
      paramakp = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localajx.dIA);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramakp.putExtra("jsapiargs", (Bundle)localObject2);
      paramakp.putExtra("rawUrl", (String)localObject1);
      paramakp.putExtra("is_favorite_item", true);
      paramakp.putExtra("fav_local_id", paramg.field_localId);
      paramakp.putExtra("geta8key_scene", 14);
      ae.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramakp.putExtra("geta8key_scene", 14);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramakp);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramakp, (Intent)localObject1);
    com.tencent.mm.plugin.fav.a.i.gn("FavoriteSightDetailUI", paramakp.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akp paramakp)
  {
    AppMethodBeat.i(24587);
    Object localObject1 = J(paramg);
    if (!bu.isNullOrNil((String)localObject1))
    {
      paramakp = new Intent();
      paramakp.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramakp.putExtra("sns_landig_pages_from_source", 7);
      paramakp.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramakp.putExtra("sns_landing_favid", com.tencent.mm.model.v.aAC() + "_" + paramg.field_id);
      paramakp.addFlags(268435456);
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramakp);
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject2 = paramg.field_favProto.GBf;
    if ((localObject2 != null) && (((alc)localObject2).GCN) && (!bu.isNullOrNil(((alc)localObject2).GCL)))
    {
      paramg = bx.M(((alc)localObject2).GCL, "websearch");
      paramakp = new egh();
      paramakp.DTD = ((String)paramg.get(".websearch.relevant_vid"));
      paramakp.DTE = ((String)paramg.get(".websearch.relevant_expand"));
      paramakp.DTF = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramakp.DTG = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramakp.DTH = bu.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramakp.qlv = ((String)paramg.get(".websearch.shareUrl"));
      paramakp.qlw = ((String)paramg.get(".websearch.shareTitle"));
      paramakp.uly = ((String)paramg.get(".websearch.shareDesc"));
      paramakp.DTI = ((String)paramg.get(".websearch.shareImgUrl"));
      paramakp.DTJ = ((String)paramg.get(".websearch.shareString"));
      paramakp.DTK = ((String)paramg.get(".websearch.shareStringUrl"));
      paramakp.source = ((String)paramg.get(".websearch.source"));
      paramakp.dJL = ((String)paramg.get(".websearch.sourceUrl"));
      paramakp.DTL = ((String)paramg.get(".websearch.strPlayCount"));
      paramakp.DTM = ((String)paramg.get(".websearch.titleUrl"));
      paramakp.DTN = ((String)paramg.get(".websearch.extReqParams"));
      paramakp.DTO = ((String)paramg.get(".websearch.tagList"));
      paramakp.DTP = bu.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramakp.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramakp.DTQ = ((String)paramg.get(".websearch.shareTag"));
      ad.a(paramContext, com.tencent.mm.plugin.topstory.a.h.a(paramakp, 326, paramContext.getString(2131764521)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      localObject2 = paramg.field_favProto.GBf;
      localObject3 = ((alc)localObject2).GCG;
      localObject1 = ((alc)localObject2).title;
    }
    for (localObject2 = ((alc)localObject2).desc;; localObject2 = "")
    {
      akt localakt = paramg.field_favProto.GCe;
      Object localObject4 = localObject3;
      if (localakt != null)
      {
        localObject4 = localObject3;
        if (bu.isNullOrNil((String)localObject3)) {
          localObject4 = localakt.link;
        }
      }
      if (bu.isNullOrNil((String)localObject4))
      {
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).useOffline((String)localObject4, paramg.field_localId))
      {
        ae.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject4 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).getFavOfflineService().ahz((String)localObject4);
      ajx localajx = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      Object localObject5 = localObject1;
      if (localajx != null)
      {
        localObject3 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject3 = localajx.title;
        }
        localObject6 = localObject2;
        localObject5 = localObject3;
        if (bu.isNullOrNil((String)localObject2))
        {
          localObject6 = localajx.desc;
          localObject5 = localObject3;
        }
      }
      ae.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.cwt());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      if ((localakt != null) && (!bu.isNullOrNil(localakt.dkZ))) {
        ((Intent)localObject1).putExtra("srcDisplayname", com.tencent.mm.model.w.zP(localakt.dkZ));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).dIA);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + com.tencent.mm.model.v.aAC() + "_" + paramg.field_id;
      ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
      ((Intent)localObject1).putExtra("pre_username", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
      ((Intent)localObject1).putExtra("preChatTYPE", 14);
      ((Intent)localObject1).putExtra("share_report_pre_msg_url", (String)localObject4);
      ((Intent)localObject1).putExtra("share_report_pre_msg_title", localObject5);
      ((Intent)localObject1).putExtra("share_report_pre_msg_desc", (String)localObject6);
      ((Intent)localObject1).putExtra("share_report_pre_msg_icon_url", K(paramg));
      ((Intent)localObject1).putExtra("share_report_pre_msg_appid", "");
      ((Intent)localObject1).putExtra("share_report_from_scene", 4);
      localObject2 = com.tencent.mm.modelstat.a.c.Hi(com.tencent.mm.pluginsdk.model.f.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramakp.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramakp.otZ);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramakp.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramakp.query);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramakp.sessionId);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramakp.rAT);
      com.tencent.mm.plugin.fav.a.i.gn("WebViewUI", paramakp.sessionId);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      if ((paramg.field_favProto.Ekw != null) && (paramg.field_favProto.Ekw.hBX == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zk(paramg.field_favProto.Ekw.hBV)))
      {
        a(paramContext, paramg, paramakp, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
      }
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akp paramakp)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramakp, localIntent);
    com.tencent.mm.plugin.fav.a.i.gn("FavoriteImgDetailUI", paramakp.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */