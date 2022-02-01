package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.nj.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static int[] rFr = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.Giw != null) && (!bt.isNullOrNil(paramg.field_favProto.Giw.canvasPageXml)))
    {
      paramg = paramg.field_favProto.Giw.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.nZa;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((ajn)paramg.get(0)).canvasPageXml;
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
    if ((paramg.field_favProto.Giw != null) && (!bt.isNullOrNil(paramg.field_favProto.Giw.thumbUrl)))
    {
      paramg = paramg.field_favProto.Giw.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.nZa;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((ajn)paramg.get(0)).hAe;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akf paramakf, Intent paramIntent)
  {
    AppMethodBeat.i(24588);
    paramIntent.putExtra(e.b.IUn, paramakf.scene);
    paramIntent.putExtra(e.b.IUo, paramakf.ooi);
    paramIntent.putExtra("biz_video_session_id", y.getSessionId());
    paramakf = paramg.field_favProto.DSw;
    paramg = new x();
    paramg.doK = paramakf.doK;
    paramg.hDe = paramakf.hDe;
    paramg.hDg.url = paramIntent.getStringExtra("rawUrl");
    paramg.hDg.title = bt.nullAsNil(paramIntent.getStringExtra("share_report_pre_msg_title"));
    paramg.hDg.hDo = paramIntent.getStringExtra("share_report_pre_msg_desc");
    paramg.hDg.hDm = paramakf.hDm;
    paramg.hDg.type = paramakf.hzh;
    paramg.hDg.hzk = paramakf.hzk;
    paramg.hDg.time = paramakf.hzi;
    paramg.hDg.hDq = paramakf.duration;
    paramg.hDg.videoWidth = paramakf.videoWidth;
    paramg.hDg.videoHeight = paramakf.videoHeight;
    paramg.hDg.hzm = paramakf.hzm;
    paramg.t(paramIntent);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramakf.Gjn != null) {
      paramIntent.putExtra("img_gallery_width", paramakf.Gjn.width).putExtra("img_gallery_height", paramakf.Gjn.height).putExtra("img_gallery_left", paramakf.Gjn.left).putExtra("img_gallery_top", paramakf.Gjn.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramakf = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d(paramg.hDg.url, 24, 10000, i);
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, paramakf, paramg.hDg.type, 24, 10000, paramIntent)) {
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    }
    AppMethodBeat.o(24588);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akf paramakf)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramakf, localIntent);
    com.tencent.mm.plugin.fav.a.i.gi("FavRecordDetailUI", paramakf.sessionId);
    com.tencent.mm.bs.d.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, akf paramakf, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramakf, paramIntent);
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
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24596);
      return;
    }
    ajn localajn1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
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
      localObject2 = paramg.field_favProto.Giw;
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
          if (!bt.isNullOrNil(((aks)localObject2).title)) {
            paramg = ((aks)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (bt.isNullOrNil(paramg)) {
          localObject1 = localajn1.title;
        }
        parama.aMS(paramContext.getResources().getString(2131755278) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        ajn localajn2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new e(com.tencent.mm.plugin.fav.a.b.a(localajn2));
          if (((e)localObject1).exists())
          {
            localObject1 = q.B(((e)localObject1).fOK());
            break label55;
          }
          localObject1 = paramg.field_favProto.Giw;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((aks)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bt.isNullOrNil((String)localObject1)) {
              localObject2 = localajn2.dnv;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.agh((String)localObject2);
            localObject1 = localObject2;
            if (!bt.isNullOrNil((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(2131689584);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.Giy;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.agh(((akc)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bt.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689577);
            break label55;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.GiA;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.agh(((akm)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bt.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689577);
            break label55;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new e(com.tencent.mm.plugin.fav.a.b.a(localajn2));
          if (((e)localObject1).exists())
          {
            localObject1 = q.B(((e)localObject1).fOK());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.agh(localajn2.dnv);
          localObject2 = localObject1;
          if (bt.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localajn2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localajn2);
          }
          localObject1 = localObject2;
          if (!bt.isNullOrNil((String)localObject2)) {
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
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.aLi(localajn2.Ghg));
            break;
          }
          if (17 == paramg.field_type)
          {
            ba.aBQ();
            localObject1 = com.tencent.mm.model.c.azs().aqk(localajn2.desc);
            if ((((bu.a)localObject1).dHm != null) && (((bu.a)localObject1).dHm.length() != 0))
            {
              localObject1 = new SpannableString(((bu.a)localObject1).dHm);
              break;
            }
            localObject1 = Integer.valueOf(2131231875);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.nZa == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.nZa.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localajn2 = (ajn)((Iterator)localObject1).next();
            } while (localajn2.dataType == 1);
            if (localajn2.dataType == 3)
            {
              localObject1 = Integer.valueOf(2131689583);
              break label55;
            }
            if (localajn2.dataType == 6)
            {
              localObject1 = Integer.valueOf(2131689562);
              break label55;
            }
            if (localajn2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.aLi(localajn2.Ghg));
              break label55;
            }
            if ((localajn2.dataType == 2) || (localajn2.dataType == 7) || (localajn2.dataType == 15) || (localajn2.dataType == 4))
            {
              localObject1 = new e(com.tencent.mm.plugin.fav.a.b.a(localajn2));
              if (((e)localObject1).exists())
              {
                localObject1 = q.B(((e)localObject1).fOK());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.agh(localajn2.dnv);
              if (bt.isNullOrNil((String)localObject1)) {
                switch (localajn2.dataType)
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
            if (localajn2.dataType == 5)
            {
              localObject1 = new e(com.tencent.mm.plugin.fav.a.b.a(localajn2));
              if (((e)localObject1).exists())
              {
                localObject1 = q.B(((e)localObject1).fOK());
                break label55;
              }
              localObject1 = localajn2.GhL.Giw;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((aks)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (bt.isNullOrNil((String)localObject1)) {
                  localObject2 = localajn2.dnv;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.agh((String)localObject2);
                localObject1 = localObject2;
                if (!bt.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(2131689584);
                break;
              }
            }
            if (localajn2.dataType == 22)
            {
              localObject1 = Integer.valueOf(2131690572);
              break label55;
            }
            if ((localajn2.dataType == 10) || (localajn2.dataType == 11))
            {
              localObject2 = localajn2.GhL.Giy;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.agh(((akc)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bt.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
            if ((localajn2.dataType == 12) || (localajn2.dataType == 14))
            {
              localObject2 = localajn2.GhL.GiA;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.agh(((akm)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bt.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
          } while (localajn2.dataType != 16);
          ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azs().aqk(localajn2.desc);
          if ((((bu.a)localObject1).dHm != null) && (((bu.a)localObject1).dHm.length() != 0))
          {
            localObject1 = new SpannableString(((bu.a)localObject1).dHm);
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
    if (bt.isNullOrNil((String)localObject1)) {
      paramg = localajn1.title;
    }
    parama.aMS(paramContext.getResources().getString(2131755773) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.aMS(paramg.field_favProto.desc);
    parama.fcA();
    parama.a(new d.a.b()
    {
      public final void cxz()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", this.rsf.field_favProto.desc);
        com.tencent.mm.bs.d.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.kd(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.Giu;
    paramg = paramContext.getString(2131755806);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((aju)localObject1).label;
    }
    parama.aMS(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!bt.isNullOrNil(((aks)localObject2).title)))
    {
      paramg = ((aks)localObject2).title;
      localObject1 = ((aks)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (bt.isNullOrNil(paramg)) {
        localObject2 = localajn1.title;
      }
      bt.isNullOrNil((String)localObject1);
      parama.aMS(paramContext.getResources().getString(2131755920) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.aMS(paramContext.getResources().getString(2131755872) + paramg);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.g.aQf((String)localObject1), 3);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.g.aQf((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.g.aQf((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      localObject1 = paramContext.getResources().getString(2131755834);
      paramContext = l.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.aMS((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.GiO;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(2131755775) + paramg.desc;; paramContext = paramContext.getString(2131755775))
      {
        parama.aMS(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!bt.isNullOrNil(((aks)localObject2).title)) {
          paramg = ((aks)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (bt.isNullOrNil(paramg)) {
        localObject1 = localajn1.title;
      }
      parama.aMS(paramContext.getResources().getString(2131755820) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.GiJ != null) {}
      for (paramContext = paramContext.getString(2131755375) + paramg.field_favProto.title;; paramContext = paramContext.getString(2131755375))
      {
        parama.aMS(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(akf paramakf, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramakf.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramakf.ooi);
    paramIntent.putExtra("key_detail_fav_index", paramakf.index);
    paramIntent.putExtra("key_detail_fav_query", paramakf.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramakf.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramakf.rsG);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, ajn paramajn, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    ajq localajq = paramajn.GhR;
    if ((localajq == null) || (bt.isNullOrNil(localajq.hCe)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    m.a(m.a.rsV, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramajn);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localajq.hCe);
    localIntent.putExtra("StreamWording", localajq.hCh);
    localIntent.putExtra("StremWebUrl", localajq.hCi);
    localIntent.putExtra("KThumUrl", localajq.hCj);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localajq.hCk);
    localIntent.putExtra("KSta_StremVideoPublishId", localajq.hCl);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", m.b.rtf.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramajn.dHv);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localajq.Gje);
    localIntent.putExtra("KMediaTitle", localajq.hCg);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqx, 0) > 0)
    {
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(24591);
      return true;
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  private static boolean a(Context paramContext, ajn paramajn, boolean paramBoolean)
  {
    AppMethodBeat.i(193216);
    if ((paramajn == null) || (paramajn.GhL == null) || (paramajn.GhL.GiM == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(193216);
      return false;
    }
    paramBoolean = r.a(paramContext, paramajn.GhL.GiM, paramajn, paramBoolean);
    AppMethodBeat.o(193216);
    return paramBoolean;
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akf paramakf)
  {
    AppMethodBeat.i(24581);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "Context is null");
      AppMethodBeat.o(24581);
      return;
    }
    if (paramg == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "Fav item is null");
      AppMethodBeat.o(24581);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
    switch (paramg.field_type)
    {
    case -1: 
    case 0: 
    case 9: 
    case 13: 
    default: 
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
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
        ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.cuQ());
        ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
        if (paramg.field_sourceCreateTime <= 0L) {}
        for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
        {
          ((Intent)localObject1).putExtra("key_detail_create_time", l);
          a(paramakf, (Intent)localObject1);
          com.tencent.mm.plugin.fav.a.i.gi("FavoriteTextDetailUI", paramakf.sessionId);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
          AppMethodBeat.o(24581);
          return;
        }
        e(paramContext, paramg, paramakf);
        AppMethodBeat.o(24581);
        return;
        localObject1 = new Intent();
        a(paramg, paramakf, (Intent)localObject1);
        ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.Gjv.createTime);
        com.tencent.mm.plugin.fav.a.i.gi("FavoriteVoiceDetailUI", paramakf.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if ((localObject1 != null) && (((ajn)localObject1).GhR != null) && ((!bt.isNullOrNil(((ajn)localObject1).GhR.hCe)) || (!bt.isNullOrNil(((ajn)localObject1).GhR.hCi))))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "it is ad sight.");
          c(paramContext, paramg, paramakf);
          AppMethodBeat.o(24581);
          return;
        }
        d(paramContext, paramg, paramakf);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, paramakf);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, true, paramakf);
        AppMethodBeat.o(24581);
        return;
        Object localObject2 = paramg.field_favProto.Giu;
        String str = paramg.field_favProto.iTM;
        localObject1 = paramg.field_favProto.Gjv;
        if ((localObject1 != null) && (!bt.isNullOrNil(((akj)localObject1).GiV))) {}
        for (localObject1 = com.tencent.mm.model.v.zf(((akj)localObject1).GiV);; localObject1 = com.tencent.mm.model.v.zf(paramg.field_fromUser))
        {
          ArrayList localArrayList = new ArrayList();
          if (paramg.field_tagProto.GjJ != null) {
            localArrayList.addAll(paramg.field_tagProto.GjJ);
          }
          com.tencent.mm.plugin.fav.a.i.gi("RedirectUI", paramakf.sessionId);
          com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (aju)localObject2, (String)localObject1, str, localArrayList, paramContext);
          AppMethodBeat.o(24581);
          return;
        }
        localObject2 = paramg.field_favProto.Gjv;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramakf = new e(com.tencent.mm.plugin.fav.a.b.a((ajn)localObject1));
        if (!paramakf.exists()) {
          if (((ajn)localObject1).dnv == null)
          {
            paramakf = "";
            paramakf = com.tencent.mm.az.g.a(6, null, ((ajn)localObject1).title, ((ajn)localObject1).desc, ((ajn)localObject1).GgY, ((ajn)localObject1).Ghc, ((ajn)localObject1).Gha, ((ajn)localObject1).dsU, com.tencent.mm.plugin.fav.a.b.cuH(), paramakf, "", ((akj)localObject2).appId);
            paramakf.ihx = ((ajn)localObject1).songAlbumUrl;
            paramakf.ihp = ((ajn)localObject1).songLyric;
            paramakf.ihH = ((ajn)localObject1).dsU;
            if (com.tencent.mm.plugin.fav.a.b.f((ajn)localObject1)) {
              break label912;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.az.a.c(paramakf);
          }
        }
        for (;;)
        {
          paramakf.ihE = String.valueOf(paramg.field_localId);
          paramg = new Intent();
          paramg.putExtra("key_scene", 2);
          com.tencent.mm.bs.d.b(paramContext, "music", ".ui.MusicMainUI", paramg);
          AppMethodBeat.o(24581);
          return;
          paramakf = new e(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(((ajn)localObject1).dnv.getBytes()));
          if (paramakf.exists()) {}
          for (paramakf = q.B(paramakf.fOK());; paramakf = "") {
            break;
          }
          paramakf = q.B(paramakf.fOK());
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
        }
        c(paramContext, paramg, true, paramakf);
        AppMethodBeat.o(24581);
        return;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.Giy.info;
        paramakf = new Intent();
        paramakf.putExtra("key_is_favorite_item", true);
        paramakf.putExtra("key_favorite_local_id", l);
        paramakf.putExtra("key_Product_xml", paramg);
        paramakf.putExtra("key_can_delete_favorite_item", true);
        paramakf.putExtra("key_ProductUI_getProductInfoScene", 3);
        com.tencent.mm.bs.d.b(paramContext, "scanner", ".ui.ProductUI", paramakf);
        AppMethodBeat.o(24581);
        return;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.GiA.info;
        paramakf = new Intent();
        paramakf.putExtra("key_TV_getProductInfoScene", 3);
        paramakf.putExtra("key_is_favorite_item", true);
        paramakf.putExtra("key_favorite_local_id", l);
        paramakf.putExtra("key_TV_xml", paramg);
        paramakf.putExtra("key_can_delete_favorite_item", true);
        com.tencent.mm.bs.d.b(paramContext, "shake", ".ui.TVInfoUI", paramakf);
        AppMethodBeat.o(24581);
        return;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        paramakf = new Intent();
        paramakf.putExtra("key_product_scene", 4);
        paramakf.putExtra("key_product_info", paramg.field_favProto.Giy.info);
        com.tencent.mm.bs.d.b(paramContext, "product", ".ui.MallProductUI", paramakf);
        AppMethodBeat.o(24581);
        return;
        a(paramContext, paramg, true, paramakf);
        AppMethodBeat.o(24581);
        return;
        paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
        ba.aBQ();
        paramg = com.tencent.mm.model.c.azs().aqk(paramg);
      } while (paramg == null);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Contact_User", paramg.dHm);
      ((Intent)localObject1).putExtra("Contact_Alias", paramg.ffB);
      ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
      ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.jeV);
      ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.jeU);
      ((Intent)localObject1).putExtra("Contact_Uin", paramg.wSt);
      ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.IMm);
      ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.IMn);
      ((Intent)localObject1).putExtra("Contact_QQNick", paramg.fss());
      ((Intent)localObject1).putExtra("User_From_Fmessage", false);
      ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
      ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
      ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.jeZ);
      ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.DKi);
      ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.ePz);
      ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.wQe);
      ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
      ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
      ((Intent)localObject1).putExtra("Contact_Sex", paramg.ePk);
      ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
      ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
      ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
      com.tencent.mm.plugin.fav.a.i.gi("ContactInfoUI", paramakf.sessionId);
      com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      com.tencent.mm.bt.a.Zy(paramg.scene);
      AppMethodBeat.o(24581);
      return;
    case 18: 
      label912:
      b(paramContext, paramg, true, paramakf);
      AppMethodBeat.o(24581);
      return;
    }
    Toast.makeText(paramContext, 2131759027, 0).show();
    AppMethodBeat.o(24581);
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akf paramakf)
  {
    AppMethodBeat.i(24583);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    nj localnj = new nj();
    localnj.dBj.field_localId = paramg.field_localId;
    Object localObject;
    if ((!bt.isNullOrNil(paramg.rso)) && (paramg.field_favProto != null) && (paramg.field_favProto.nZa != null) && (paramg.field_favProto.nZa.size() > 0))
    {
      localObject = paramg.field_favProto.nZa.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label399;
      }
      if (!bt.lQ(((ajn)((Iterator)localObject).next()).dsU, paramg.rso)) {
        break label350;
      }
    }
    label384:
    label399:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localnj.dBj.dBm) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localnj.dBj;
          ((nj.a)localObject).dBm -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label384;
        }
        localnj.dBj.dBs = 4;
      }
      for (;;)
      {
        localnj.dBj.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.FpF;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((ajx)localObject).Gjo);
          paramContext.putString("noteeditor", ((ajx)localObject).Gjp);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localnj.dBj.dBq = paramContext;
        localnj.dBj.field_favProto = paramg.field_favProto;
        localnj.dBj.type = 2;
        localnj.dBj.dBt = paramBoolean;
        localnj.dBj.dBu = paramakf;
        com.tencent.mm.sdk.b.a.IbL.l(localnj);
        com.tencent.mm.plugin.fav.a.i.gi("NoteEditorUI", paramakf.sessionId);
        AppMethodBeat.o(24583);
        return;
        label350:
        nj.a locala = localnj.dBj;
        locala.dBm += 1;
        break;
        localnj.dBj.dBm = 0;
        break label190;
        localnj.dBj.dBl = paramg.field_xml;
      }
    }
  }
  
  public static void b(o.a parama, final Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24597);
    if ((paramg == null) || (paramContext == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24597);
      return;
    }
    final ajn localajn = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24574);
          d.f(this.val$context, paramg, new akf());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", this.rsf.field_favProto.desc);
          com.tencent.mm.bs.d.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.kd(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24576);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          if (this.rFs != null)
          {
            localIntent.putExtra("kwebmap_slat", this.rFs.lat);
            localIntent.putExtra("kwebmap_lng", this.rFs.lng);
            localIntent.putExtra("Kwebmap_locaion", this.rFs.label);
          }
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.bs.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(24576);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24577);
          d.g(this.val$context, paramg, new akf());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24578);
          d.h(this.val$context, paramg, new akf());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.rsf.field_localId);
          localIntent.putExtra("key_detail_data_id", localajn.dsU);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24580);
          ajn localajn = com.tencent.mm.plugin.fav.a.b.c(this.rsf);
          if (localajn == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.b(paramContext, localajn))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localajn.GhR != null) && ((!bt.isNullOrNil(localajn.GhR.hCe)) || (!bt.isNullOrNil(localajn.GhR.hCi))))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", this.rsf.field_localId);
            localIntent.putExtra("key_detail_data_id", localajn.dsU);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.rsf.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localajn));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localajn));
          localIntent.putExtra("key_detail_fav_video_duration", localajn.duration);
          localIntent.putExtra("key_detail_statExtStr", localajn.dHv);
          localIntent.putExtra("key_detail_msg_uuid", localajn.iuq);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(24572);
          d.i(this.val$context, paramg, new akf());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(163190);
          arj localarj = this.rsf.field_favProto.GiO;
          if (localarj != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.rwD;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localarj);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akf paramakf)
  {
    AppMethodBeat.i(24590);
    m.a(m.a.rsT, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramakf, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akf paramakf)
  {
    AppMethodBeat.i(24584);
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramakf != null) && (paramakf.dJI == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!bt.isNullOrNil(paramg.rso))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.rso);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramakf, (Intent)localObject);
        com.tencent.mm.plugin.fav.a.i.gi("FavoriteFileDetailUI", paramakf.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramakf != null) && (paramakf.dJI == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d((ajn)localObject), ((ajn)localObject).Ghg, 2);
      AppMethodBeat.o(24584);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.g((ajn)localObject))
    {
      if (com.tencent.mm.plugin.fav.a.b.h((ajn)localObject))
      {
        e(paramContext, paramg, paramakf);
        AppMethodBeat.o(24584);
        return;
      }
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(HandOffFile.b((ajn)localObject, paramg));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.i(com.tencent.mm.plugin.fav.a.b.d((ajn)localObject), ((ajn)localObject).Ghg, ((ajn)localObject).title, 2))
      {
        AppMethodBeat.o(24584);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("key_detail_data_id", ((ajn)localObject).dsU);
    localIntent.putExtra("show_share", paramBoolean);
    a(paramakf, localIntent);
    com.tencent.mm.plugin.fav.a.i.gi("FavoriteFileDetailUI", paramakf.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
    AppMethodBeat.o(24584);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akf paramakf)
  {
    AppMethodBeat.i(24592);
    ajn localajn = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localajn, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (a(paramContext, localajn, false))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((bt.isNullOrNil(localajn.Ghi)) || (localajn.Ghm <= 0L))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localajn.Ghi, Long.valueOf(localajn.Ghm) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).GgY;
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).Ghc;
      }
      if (bt.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramakf);
        AppMethodBeat.o(24592);
        return;
      }
      paramakf = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localajn.dHv);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramakf.putExtra("jsapiargs", (Bundle)localObject2);
      paramakf.putExtra("rawUrl", (String)localObject1);
      paramakf.putExtra("is_favorite_item", true);
      paramakf.putExtra("fav_local_id", paramg.field_localId);
      paramakf.putExtra("geta8key_scene", 14);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramakf.putExtra("geta8key_scene", 14);
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramakf);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramakf, (Intent)localObject1);
    com.tencent.mm.plugin.fav.a.i.gi("FavoriteSightDetailUI", paramakf.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, akf paramakf)
  {
    AppMethodBeat.i(24587);
    Object localObject1 = J(paramg);
    if (!bt.isNullOrNil((String)localObject1))
    {
      paramakf = new Intent();
      paramakf.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramakf.putExtra("sns_landig_pages_from_source", 7);
      paramakf.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramakf.putExtra("sns_landing_favid", u.aAm() + "_" + paramg.field_id);
      paramakf.addFlags(268435456);
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramakf);
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject2 = paramg.field_favProto.Giw;
    if ((localObject2 != null) && (((aks)localObject2).Gkd) && (!bt.isNullOrNil(((aks)localObject2).Gkc)))
    {
      paramg = bw.M(((aks)localObject2).Gkc, "websearch");
      paramakf = new eeq();
      paramakf.DBG = ((String)paramg.get(".websearch.relevant_vid"));
      paramakf.DBH = ((String)paramg.get(".websearch.relevant_expand"));
      paramakf.DBI = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramakf.DBJ = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramakf.DBK = bt.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramakf.qeQ = ((String)paramg.get(".websearch.shareUrl"));
      paramakf.qeR = ((String)paramg.get(".websearch.shareTitle"));
      paramakf.uaw = ((String)paramg.get(".websearch.shareDesc"));
      paramakf.DBL = ((String)paramg.get(".websearch.shareImgUrl"));
      paramakf.DBM = ((String)paramg.get(".websearch.shareString"));
      paramakf.DBN = ((String)paramg.get(".websearch.shareStringUrl"));
      paramakf.source = ((String)paramg.get(".websearch.source"));
      paramakf.lox = ((String)paramg.get(".websearch.sourceUrl"));
      paramakf.DBO = ((String)paramg.get(".websearch.strPlayCount"));
      paramakf.DBP = ((String)paramg.get(".websearch.titleUrl"));
      paramakf.DBQ = ((String)paramg.get(".websearch.extReqParams"));
      paramakf.DBR = ((String)paramg.get(".websearch.tagList"));
      paramakf.DBS = bt.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramakf.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramakf.DBT = ((String)paramg.get(".websearch.shareTag"));
      com.tencent.mm.plugin.websearch.api.ad.a(paramContext, h.a(paramakf, 326, paramContext.getString(2131764521)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      localObject2 = paramg.field_favProto.Giw;
      localObject3 = ((aks)localObject2).GjX;
      localObject1 = ((aks)localObject2).title;
    }
    for (localObject2 = ((aks)localObject2).desc;; localObject2 = "")
    {
      akj localakj = paramg.field_favProto.Gjv;
      Object localObject4 = localObject3;
      if (localakj != null)
      {
        localObject4 = localObject3;
        if (bt.isNullOrNil((String)localObject3)) {
          localObject4 = localakj.link;
        }
      }
      if (bt.isNullOrNil((String)localObject4))
      {
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).useOffline((String)localObject4, paramg.field_localId))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject4 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).getFavOfflineService().agC((String)localObject4);
      ajn localajn = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      Object localObject5 = localObject1;
      if (localajn != null)
      {
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject3 = localajn.title;
        }
        localObject6 = localObject2;
        localObject5 = localObject3;
        if (bt.isNullOrNil((String)localObject2))
        {
          localObject6 = localajn.desc;
          localObject5 = localObject3;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.cuS());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      if ((localakj != null) && (!bt.isNullOrNil(localakj.djX))) {
        ((Intent)localObject1).putExtra("srcDisplayname", com.tencent.mm.model.v.zf(localakj.djX));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).dHv);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + u.aAm() + "_" + paramg.field_id;
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
      localObject2 = com.tencent.mm.modelstat.a.c.GG(com.tencent.mm.pluginsdk.model.f.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramakf.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramakf.ooi);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramakf.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramakf.query);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramakf.sessionId);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramakf.rsG);
      com.tencent.mm.plugin.fav.a.i.gi("WebViewUI", paramakf.sessionId);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      if ((paramg.field_favProto.DSw != null) && (paramg.field_favProto.DSw.hzj == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zb(paramg.field_favProto.DSw.hzh)))
      {
        a(paramContext, paramg, paramakf, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
      }
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, akf paramakf)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramakf, localIntent);
    com.tencent.mm.plugin.fav.a.i.gi("FavoriteImgDetailUI", paramakf.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */