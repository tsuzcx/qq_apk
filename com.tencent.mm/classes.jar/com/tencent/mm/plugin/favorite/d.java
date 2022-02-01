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
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.ms.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static int[] qmB = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.DhE != null) && (!bt.isNullOrNil(paramg.field_favProto.DhE.canvasPageXml)))
    {
      paramg = paramg.field_favProto.DhE.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.mVb;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((afy)paramg.get(0)).canvasPageXml;
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
    if ((paramg.field_favProto.DhE != null) && (!bt.isNullOrNil(paramg.field_favProto.DhE.thumbUrl)))
    {
      paramg = paramg.field_favProto.DhE.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.mVb;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((afy)paramg.get(0)).gHu;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, agq paramagq, Intent paramIntent)
  {
    AppMethodBeat.i(24588);
    paramIntent.putExtra(e.b.FHP, paramagq.scene);
    paramIntent.putExtra(e.b.FHQ, paramagq.niJ);
    paramIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.u.getSessionId());
    paramagq = paramg.field_favProto.AWL;
    paramg = new x();
    paramg.dfT = paramagq.dfT;
    paramg.gKv = paramagq.gKv;
    paramg.gKx.url = paramIntent.getStringExtra("rawUrl");
    paramg.gKx.title = bt.nullAsNil(paramIntent.getStringExtra("share_report_pre_msg_title"));
    paramg.gKx.gKF = paramIntent.getStringExtra("share_report_pre_msg_desc");
    paramg.gKx.gKD = paramagq.gKD;
    paramg.gKx.type = paramagq.gGx;
    paramg.gKx.gGA = paramagq.gGA;
    paramg.gKx.time = paramagq.gGy;
    paramg.gKx.gKH = paramagq.duration;
    paramg.gKx.videoWidth = paramagq.videoWidth;
    paramg.gKx.videoHeight = paramagq.videoHeight;
    paramg.gKx.gGC = paramagq.gGC;
    paramg.t(paramIntent);
    ad.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramagq.Div != null) {
      paramIntent.putExtra("img_gallery_width", paramagq.Div.width).putExtra("img_gallery_height", paramagq.Div.height).putExtra("img_gallery_left", paramagq.Div.left).putExtra("img_gallery_top", paramagq.Div.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramagq = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d(paramg.gKx.url, 24, 10000, i);
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, paramagq, paramg.gKx.type, 24, 10000, paramIntent)) {
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    }
    AppMethodBeat.o(24588);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, agq paramagq)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramagq, localIntent);
    i.fM("FavRecordDetailUI", paramagq.sessionId);
    com.tencent.mm.bs.d.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, agq paramagq, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramagq, paramIntent);
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
      ad.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24596);
      return;
    }
    afy localafy1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      ad.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
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
      localObject2 = paramg.field_favProto.DhE;
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
          if (!bt.isNullOrNil(((ahd)localObject2).title)) {
            paramg = ((ahd)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (bt.isNullOrNil(paramg)) {
          localObject1 = localafy1.title;
        }
        parama.aBX(paramContext.getResources().getString(2131755278) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        afy localafy2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localafy2));
          if (((com.tencent.mm.vfs.e)localObject1).exists())
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
            break label55;
          }
          localObject1 = paramg.field_favProto.DhE;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((ahd)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bt.isNullOrNil((String)localObject1)) {
              localObject2 = localafy2.deE;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.XW((String)localObject2);
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
          localObject1 = paramg.field_favProto.DhG;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.XW(((agn)localObject1).thumbUrl);
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
          localObject1 = paramg.field_favProto.DhI;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.XW(((agx)localObject1).thumbUrl);
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
          localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localafy2));
          if (((com.tencent.mm.vfs.e)localObject1).exists())
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.XW(localafy2.deE);
          localObject2 = localObject1;
          if (bt.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localafy2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localafy2);
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
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.e.aAq(localafy2.Dgo));
            break;
          }
          if (17 == paramg.field_type)
          {
            az.arV();
            localObject1 = com.tencent.mm.model.c.apO().agC(localafy2.desc);
            if ((((bl.a)localObject1).yGA != null) && (((bl.a)localObject1).yGA.length() != 0))
            {
              localObject1 = new SpannableString(((bl.a)localObject1).yGA);
              break;
            }
            localObject1 = Integer.valueOf(2131231875);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.mVb == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.mVb.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localafy2 = (afy)((Iterator)localObject1).next();
            } while (localafy2.dataType == 1);
            if (localafy2.dataType == 3)
            {
              localObject1 = Integer.valueOf(2131689583);
              break label55;
            }
            if (localafy2.dataType == 6)
            {
              localObject1 = Integer.valueOf(2131689562);
              break label55;
            }
            if (localafy2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.e.aAq(localafy2.Dgo));
              break label55;
            }
            if ((localafy2.dataType == 2) || (localafy2.dataType == 7) || (localafy2.dataType == 15) || (localafy2.dataType == 4))
            {
              localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localafy2));
              if (((com.tencent.mm.vfs.e)localObject1).exists())
              {
                localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.XW(localafy2.deE);
              if (bt.isNullOrNil((String)localObject1)) {
                switch (localafy2.dataType)
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
            if (localafy2.dataType == 5)
            {
              localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localafy2));
              if (((com.tencent.mm.vfs.e)localObject1).exists())
              {
                localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
                break label55;
              }
              localObject1 = localafy2.DgT.DhE;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((ahd)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (bt.isNullOrNil((String)localObject1)) {
                  localObject2 = localafy2.deE;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.XW((String)localObject2);
                localObject1 = localObject2;
                if (!bt.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(2131689584);
                break;
              }
            }
            if (localafy2.dataType == 22)
            {
              localObject1 = Integer.valueOf(2131690572);
              break label55;
            }
            if ((localafy2.dataType == 10) || (localafy2.dataType == 11))
            {
              localObject2 = localafy2.DgT.DhG;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.XW(((agn)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bt.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
            if ((localafy2.dataType == 12) || (localafy2.dataType == 14))
            {
              localObject2 = localafy2.DgT.DhI;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.XW(((agx)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bt.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
          } while (localafy2.dataType != 16);
          az.arV();
          localObject1 = com.tencent.mm.model.c.apO().agC(localafy2.desc);
          if ((((bl.a)localObject1).yGA != null) && (((bl.a)localObject1).yGA.length() != 0))
          {
            localObject1 = new SpannableString(((bl.a)localObject1).yGA);
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
      paramg = localafy1.title;
    }
    parama.aBX(paramContext.getResources().getString(2131755773) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.aBX(paramg.field_favProto.desc);
    parama.eyh();
    parama.a(new d.a.b()
    {
      public final void ckg()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", this.pZx.field_favProto.desc);
        com.tencent.mm.bs.d.e(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.jH(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.DhC;
    paramg = paramContext.getString(2131755806);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((agf)localObject1).label;
    }
    parama.aBX(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!bt.isNullOrNil(((ahd)localObject2).title)))
    {
      paramg = ((ahd)localObject2).title;
      localObject1 = ((ahd)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (bt.isNullOrNil(paramg)) {
        localObject2 = localafy1.title;
      }
      bt.isNullOrNil((String)localObject1);
      parama.aBX(paramContext.getResources().getString(2131755920) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.aBX(paramContext.getResources().getString(2131755872) + paramg);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.f.aFi((String)localObject1), 3);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.f.aFi((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.f.aFi((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      localObject1 = paramContext.getResources().getString(2131755834);
      paramContext = l.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.aBX((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.DhW;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(2131755775) + paramg.desc;; paramContext = paramContext.getString(2131755775))
      {
        parama.aBX(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!bt.isNullOrNil(((ahd)localObject2).title)) {
          paramg = ((ahd)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (bt.isNullOrNil(paramg)) {
        localObject1 = localafy1.title;
      }
      parama.aBX(paramContext.getResources().getString(2131755820) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.DhR != null) {}
      for (paramContext = paramContext.getString(2131755375) + paramg.field_favProto.title;; paramContext = paramContext.getString(2131755375))
      {
        parama.aBX(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(agq paramagq, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramagq.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramagq.niJ);
    paramIntent.putExtra("key_detail_fav_index", paramagq.index);
    paramIntent.putExtra("key_detail_fav_query", paramagq.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramagq.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramagq.pZZ);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, afy paramafy, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    agb localagb = paramafy.DgZ;
    if ((localagb == null) || (bt.isNullOrNil(localagb.gJv)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    m.a(m.a.qao, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramafy);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localagb.gJv);
    localIntent.putExtra("StreamWording", localagb.gJy);
    localIntent.putExtra("StremWebUrl", localagb.gJz);
    localIntent.putExtra("KThumUrl", localagb.gJA);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localagb.gJB);
    localIntent.putExtra("KSta_StremVideoPublishId", localagb.gJC);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", m.b.qay.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramafy.dxG);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localagb.Dim);
    localIntent.putExtra("KMediaTitle", localagb.gJx);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjp, 0) > 0)
    {
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ad.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(24591);
      return true;
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, agq paramagq)
  {
    AppMethodBeat.i(24581);
    if (paramContext == null)
    {
      ad.w("MicroMsg.FavItemLogic", "Context is null");
      AppMethodBeat.o(24581);
      return;
    }
    if (paramg == null)
    {
      ad.w("MicroMsg.FavItemLogic", "Fav item is null");
      AppMethodBeat.o(24581);
      return;
    }
    ad.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
    switch (paramg.field_type)
    {
    case -1: 
    case 0: 
    case 9: 
    case 13: 
    default: 
      ad.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
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
        ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.chE());
        ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
        if (paramg.field_sourceCreateTime <= 0L) {}
        for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
        {
          ((Intent)localObject1).putExtra("key_detail_create_time", l);
          a(paramagq, (Intent)localObject1);
          i.fM("FavoriteTextDetailUI", paramagq.sessionId);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
          AppMethodBeat.o(24581);
          return;
        }
        e(paramContext, paramg, paramagq);
        AppMethodBeat.o(24581);
        return;
        localObject1 = new Intent();
        a(paramg, paramagq, (Intent)localObject1);
        ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.DiD.createTime);
        i.fM("FavoriteVoiceDetailUI", paramagq.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if ((localObject1 != null) && (((afy)localObject1).DgZ != null) && ((!bt.isNullOrNil(((afy)localObject1).DgZ.gJv)) || (!bt.isNullOrNil(((afy)localObject1).DgZ.gJz))))
        {
          ad.i("MicroMsg.FavItemLogic", "it is ad sight.");
          c(paramContext, paramg, paramagq);
          AppMethodBeat.o(24581);
          return;
        }
        d(paramContext, paramg, paramagq);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, paramagq);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, true, paramagq);
        AppMethodBeat.o(24581);
        return;
        Object localObject2 = paramg.field_favProto.DhC;
        String str = paramg.field_favProto.iaz;
        localObject1 = paramg.field_favProto.DiD;
        if ((localObject1 != null) && (!bt.isNullOrNil(((agu)localObject1).Did))) {}
        for (localObject1 = com.tencent.mm.model.v.sh(((agu)localObject1).Did);; localObject1 = com.tencent.mm.model.v.sh(paramg.field_fromUser))
        {
          ArrayList localArrayList = new ArrayList();
          if (paramg.field_tagProto.DiR != null) {
            localArrayList.addAll(paramg.field_tagProto.DiR);
          }
          i.fM("RedirectUI", paramagq.sessionId);
          com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (agf)localObject2, (String)localObject1, str, localArrayList, paramContext);
          AppMethodBeat.o(24581);
          return;
        }
        localObject2 = paramg.field_favProto.DiD;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramagq = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a((afy)localObject1));
        if (!paramagq.exists()) {
          if (((afy)localObject1).deE == null)
          {
            paramagq = "";
            paramagq = com.tencent.mm.az.g.a(6, null, ((afy)localObject1).title, ((afy)localObject1).desc, ((afy)localObject1).Dgg, ((afy)localObject1).Dgk, ((afy)localObject1).Dgi, ((afy)localObject1).dkb, com.tencent.mm.plugin.fav.a.b.chv(), paramagq, "", ((agu)localObject2).appId);
            paramagq.hnG = ((afy)localObject1).songAlbumUrl;
            paramagq.hny = ((afy)localObject1).songLyric;
            paramagq.hnQ = ((afy)localObject1).dkb;
            if (com.tencent.mm.plugin.fav.a.b.f((afy)localObject1)) {
              break label912;
            }
            ad.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.az.a.c(paramagq);
          }
        }
        for (;;)
        {
          paramagq.hnN = String.valueOf(paramg.field_localId);
          paramg = new Intent();
          paramg.putExtra("key_scene", 2);
          com.tencent.mm.bs.d.b(paramContext, "music", ".ui.MusicMainUI", paramg);
          AppMethodBeat.o(24581);
          return;
          paramagq = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(((afy)localObject1).deE.getBytes()));
          if (paramagq.exists()) {}
          for (paramagq = q.B(paramagq.fhU());; paramagq = "") {
            break;
          }
          paramagq = q.B(paramagq.fhU());
          break;
          ad.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
        }
        c(paramContext, paramg, true, paramagq);
        AppMethodBeat.o(24581);
        return;
        ad.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.DhG.info;
        paramagq = new Intent();
        paramagq.putExtra("key_is_favorite_item", true);
        paramagq.putExtra("key_favorite_local_id", l);
        paramagq.putExtra("key_Product_xml", paramg);
        paramagq.putExtra("key_can_delete_favorite_item", true);
        paramagq.putExtra("key_ProductUI_getProductInfoScene", 3);
        com.tencent.mm.bs.d.b(paramContext, "scanner", ".ui.ProductUI", paramagq);
        AppMethodBeat.o(24581);
        return;
        ad.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.DhI.info;
        paramagq = new Intent();
        paramagq.putExtra("key_TV_getProductInfoScene", 3);
        paramagq.putExtra("key_is_favorite_item", true);
        paramagq.putExtra("key_favorite_local_id", l);
        paramagq.putExtra("key_TV_xml", paramg);
        paramagq.putExtra("key_can_delete_favorite_item", true);
        com.tencent.mm.bs.d.b(paramContext, "shake", ".ui.TVInfoUI", paramagq);
        AppMethodBeat.o(24581);
        return;
        ad.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        paramagq = new Intent();
        paramagq.putExtra("key_product_scene", 4);
        paramagq.putExtra("key_product_info", paramg.field_favProto.DhG.info);
        com.tencent.mm.bs.d.b(paramContext, "product", ".ui.MallProductUI", paramagq);
        AppMethodBeat.o(24581);
        return;
        a(paramContext, paramg, true, paramagq);
        AppMethodBeat.o(24581);
        return;
        paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
        az.arV();
        paramg = com.tencent.mm.model.c.apO().agC(paramg);
      } while (paramg == null);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Contact_User", paramg.yGA);
      ((Intent)localObject1).putExtra("Contact_Alias", paramg.eKn);
      ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
      ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.ilF);
      ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.ilE);
      ((Intent)localObject1).putExtra("Contact_Uin", paramg.uCr);
      ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.FzV);
      ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.FzW);
      ((Intent)localObject1).putExtra("Contact_QQNick", paramg.eMG());
      ((Intent)localObject1).putExtra("User_From_Fmessage", false);
      ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
      ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
      ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.ilJ);
      ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.AOL);
      ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.evE);
      ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.uAe);
      ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
      ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
      ((Intent)localObject1).putExtra("Contact_Sex", paramg.evp);
      ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
      ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
      ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
      i.fM("ContactInfoUI", paramagq.sessionId);
      com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      com.tencent.mm.bt.a.Vt(paramg.scene);
      AppMethodBeat.o(24581);
      return;
    case 18: 
      label912:
      b(paramContext, paramg, true, paramagq);
      AppMethodBeat.o(24581);
      return;
    }
    Toast.makeText(paramContext, 2131759027, 0).show();
    AppMethodBeat.o(24581);
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, agq paramagq)
  {
    AppMethodBeat.i(24583);
    ad.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    ms localms = new ms();
    localms.drL.field_localId = paramg.field_localId;
    Object localObject;
    if ((!bt.isNullOrNil(paramg.pZG)) && (paramg.field_favProto != null) && (paramg.field_favProto.mVb != null) && (paramg.field_favProto.mVb.size() > 0))
    {
      localObject = paramg.field_favProto.mVb.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label399;
      }
      if (!bt.kU(((afy)((Iterator)localObject).next()).dkb, paramg.pZG)) {
        break label350;
      }
    }
    label384:
    label399:
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localms.drL.drO) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localms.drL;
          ((ms.a)localObject).drO -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label384;
        }
        localms.drL.drU = 4;
      }
      for (;;)
      {
        localms.drL.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.Csh;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((agi)localObject).Diw);
          paramContext.putString("noteeditor", ((agi)localObject).Dix);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localms.drL.drS = paramContext;
        localms.drL.field_favProto = paramg.field_favProto;
        localms.drL.type = 2;
        localms.drL.drV = paramBoolean;
        localms.drL.drW = paramagq;
        com.tencent.mm.sdk.b.a.ESL.l(localms);
        i.fM("NoteEditorUI", paramagq.sessionId);
        AppMethodBeat.o(24583);
        return;
        label350:
        ms.a locala = localms.drL;
        locala.drO += 1;
        break;
        localms.drL.drO = 0;
        break label190;
        localms.drL.drN = paramg.field_xml;
      }
    }
  }
  
  public static void b(o.a parama, final Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24597);
    if ((paramg == null) || (paramContext == null))
    {
      ad.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24597);
      return;
    }
    final afy localafy = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24574);
          d.f(this.val$context, paramg, new agq());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", this.pZx.field_favProto.desc);
          com.tencent.mm.bs.d.e(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.jH(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24576);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          if (this.qmC != null)
          {
            localIntent.putExtra("kwebmap_slat", this.qmC.lat);
            localIntent.putExtra("kwebmap_lng", this.qmC.lng);
            localIntent.putExtra("Kwebmap_locaion", this.qmC.label);
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
        public final void ckg()
        {
          AppMethodBeat.i(24577);
          d.g(this.val$context, paramg, new agq());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24578);
          d.h(this.val$context, paramg, new agq());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.pZx.field_localId);
          localIntent.putExtra("key_detail_data_id", localafy.dkb);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24580);
          afy localafy = com.tencent.mm.plugin.fav.a.b.c(this.pZx);
          if (localafy == null)
          {
            ad.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.c(paramContext, localafy))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localafy.DgZ != null) && ((!bt.isNullOrNil(localafy.DgZ.gJv)) || (!bt.isNullOrNil(localafy.DgZ.gJz))))
          {
            ad.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", this.pZx.field_localId);
            localIntent.putExtra("key_detail_data_id", localafy.dkb);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.pZx.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localafy));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localafy));
          localIntent.putExtra("key_detail_fav_video_duration", localafy.duration);
          localIntent.putExtra("key_detail_statExtStr", localafy.dxG);
          localIntent.putExtra("key_detail_msg_uuid", localafy.hAt);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(24572);
          d.i(this.val$context, paramg, new agq());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(163190);
          ald localald = this.pZx.field_favProto.DhW;
          if (localald != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.qdY;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localald);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static boolean b(Context paramContext, afy paramafy)
  {
    AppMethodBeat.i(24589);
    if ((paramafy == null) || (paramafy.DgT == null) || (paramafy.DgT.DhU == null))
    {
      ad.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(24589);
      return false;
    }
    boolean bool = r.a(paramContext, paramafy.DgT.DhU, paramafy);
    AppMethodBeat.o(24589);
    return bool;
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, agq paramagq)
  {
    AppMethodBeat.i(24590);
    m.a(m.a.qam, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramagq, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, agq paramagq)
  {
    AppMethodBeat.i(24584);
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramagq != null) && (paramagq.dzK == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!bt.isNullOrNil(paramg.pZG))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.pZG);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramagq, (Intent)localObject);
        i.fM("FavoriteFileDetailUI", paramagq.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramagq != null) && (paramagq.dzK == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d((afy)localObject), ((afy)localObject).Dgo, 2);
      AppMethodBeat.o(24584);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.g((afy)localObject))
    {
      if (com.tencent.mm.plugin.fav.a.b.h((afy)localObject))
      {
        e(paramContext, paramg, paramagq);
        AppMethodBeat.o(24584);
        return;
      }
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(HandOffFile.b((afy)localObject, paramg));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.i(com.tencent.mm.plugin.fav.a.b.d((afy)localObject), ((afy)localObject).Dgo, ((afy)localObject).title, 2))
      {
        AppMethodBeat.o(24584);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("key_detail_data_id", ((afy)localObject).dkb);
    localIntent.putExtra("show_share", paramBoolean);
    a(paramagq, localIntent);
    i.fM("FavoriteFileDetailUI", paramagq.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
    AppMethodBeat.o(24584);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, agq paramagq)
  {
    AppMethodBeat.i(24592);
    afy localafy = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localafy, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (b(paramContext, localafy))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((bt.isNullOrNil(localafy.Dgq)) || (localafy.Dgu <= 0L))
    {
      ad.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localafy.Dgq, Long.valueOf(localafy.Dgu) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).Dgg;
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).Dgk;
      }
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramagq);
        AppMethodBeat.o(24592);
        return;
      }
      paramagq = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localafy.dxG);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramagq.putExtra("jsapiargs", (Bundle)localObject2);
      paramagq.putExtra("rawUrl", (String)localObject1);
      paramagq.putExtra("is_favorite_item", true);
      paramagq.putExtra("fav_local_id", paramg.field_localId);
      paramagq.putExtra("geta8key_scene", 14);
      ad.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramagq.putExtra("geta8key_scene", 14);
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramagq);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramagq, (Intent)localObject1);
    i.fM("FavoriteSightDetailUI", paramagq.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, agq paramagq)
  {
    AppMethodBeat.i(24587);
    Object localObject1 = J(paramg);
    if (!bt.isNullOrNil((String)localObject1))
    {
      paramagq = new Intent();
      paramagq.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramagq.putExtra("sns_landig_pages_from_source", 7);
      paramagq.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramagq.putExtra("sns_landing_favid", com.tencent.mm.model.u.aqG() + "_" + paramg.field_id);
      paramagq.addFlags(268435456);
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramagq);
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject2 = paramg.field_favProto.DhE;
    if ((localObject2 != null) && (((ahd)localObject2).Djl) && (!bt.isNullOrNil(((ahd)localObject2).Djk)))
    {
      paramg = bw.K(((ahd)localObject2).Djk, "websearch");
      paramagq = new dsx();
      paramagq.AGs = ((String)paramg.get(".websearch.relevant_vid"));
      paramagq.AGt = ((String)paramg.get(".websearch.relevant_expand"));
      paramagq.AGu = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramagq.AGv = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramagq.AGw = bt.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramagq.oYa = ((String)paramg.get(".websearch.shareUrl"));
      paramagq.oYb = ((String)paramg.get(".websearch.shareTitle"));
      paramagq.rUO = ((String)paramg.get(".websearch.shareDesc"));
      paramagq.AGx = ((String)paramg.get(".websearch.shareImgUrl"));
      paramagq.AGy = ((String)paramg.get(".websearch.shareString"));
      paramagq.AGz = ((String)paramg.get(".websearch.shareStringUrl"));
      paramagq.source = ((String)paramg.get(".websearch.source"));
      paramagq.kqB = ((String)paramg.get(".websearch.sourceUrl"));
      paramagq.AGA = ((String)paramg.get(".websearch.strPlayCount"));
      paramagq.AGB = ((String)paramg.get(".websearch.titleUrl"));
      paramagq.AGC = ((String)paramg.get(".websearch.extReqParams"));
      paramagq.AGD = ((String)paramg.get(".websearch.tagList"));
      paramagq.AGE = bt.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramagq.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramagq.AGF = ((String)paramg.get(".websearch.shareTag"));
      aa.a(paramContext, com.tencent.mm.plugin.topstory.a.h.a(paramagq, 326, paramContext.getString(2131764521)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      localObject2 = paramg.field_favProto.DhE;
      localObject3 = ((ahd)localObject2).Djf;
      localObject1 = ((ahd)localObject2).title;
    }
    for (localObject2 = ((ahd)localObject2).desc;; localObject2 = "")
    {
      agu localagu = paramg.field_favProto.DiD;
      Object localObject4 = localObject3;
      if (localagu != null)
      {
        localObject4 = localObject3;
        if (bt.isNullOrNil((String)localObject3)) {
          localObject4 = localagu.link;
        }
      }
      if (bt.isNullOrNil((String)localObject4))
      {
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).useOffline((String)localObject4, paramg.field_localId))
      {
        ad.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject4 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).getFavOfflineService().Yr((String)localObject4);
      afy localafy = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      Object localObject5 = localObject1;
      if (localafy != null)
      {
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject3 = localafy.title;
        }
        localObject6 = localObject2;
        localObject5 = localObject3;
        if (bt.isNullOrNil((String)localObject2))
        {
          localObject6 = localafy.desc;
          localObject5 = localObject3;
        }
      }
      ad.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.chG());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      if ((localagu != null) && (!bt.isNullOrNil(localagu.dbj))) {
        ((Intent)localObject1).putExtra("srcDisplayname", com.tencent.mm.model.v.sh(localagu.dbj));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).dxG);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + com.tencent.mm.model.u.aqG() + "_" + paramg.field_id;
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
      localObject2 = com.tencent.mm.modelstat.a.c.zw(com.tencent.mm.pluginsdk.model.f.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramagq.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramagq.niJ);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramagq.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramagq.query);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramagq.sessionId);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramagq.pZZ);
      i.fM("WebViewUI", paramagq.sessionId);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      if ((paramg.field_favProto.AWL != null) && (paramg.field_favProto.AWL.gGz == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xz(paramg.field_favProto.AWL.gGx)))
      {
        a(paramContext, paramg, paramagq, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
      }
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, agq paramagq)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramagq, localIntent);
    i.fM("FavoriteImgDetailUI", paramagq.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */