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
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo.a;
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
  private static int[] qVd = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.EAK != null) && (!bs.isNullOrNil(paramg.field_favProto.EAK.canvasPageXml)))
    {
      paramg = paramg.field_favProto.EAK.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.nxC;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((agx)paramg.get(0)).canvasPageXml;
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
    if ((paramg.field_favProto.EAK != null) && (!bs.isNullOrNil(paramg.field_favProto.EAK.thumbUrl)))
    {
      paramg = paramg.field_favProto.EAK.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.nxC;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((agx)paramg.get(0)).hhV;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, ahp paramahp, Intent paramIntent)
  {
    AppMethodBeat.i(24588);
    paramIntent.putExtra(e.b.HgX, paramahp.scene);
    paramIntent.putExtra(e.b.HgY, paramahp.nLC);
    paramIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.v.getSessionId());
    paramahp = paramg.field_favProto.CoY;
    paramg = new x();
    paramg.ddo = paramahp.ddo;
    paramg.hkV = paramahp.hkV;
    paramg.hkX.url = paramIntent.getStringExtra("rawUrl");
    paramg.hkX.title = bs.nullAsNil(paramIntent.getStringExtra("share_report_pre_msg_title"));
    paramg.hkX.hlf = paramIntent.getStringExtra("share_report_pre_msg_desc");
    paramg.hkX.hld = paramahp.hld;
    paramg.hkX.type = paramahp.hgY;
    paramg.hkX.hhb = paramahp.hhb;
    paramg.hkX.time = paramahp.hgZ;
    paramg.hkX.hlh = paramahp.duration;
    paramg.hkX.videoWidth = paramahp.videoWidth;
    paramg.hkX.videoHeight = paramahp.videoHeight;
    paramg.hkX.hhd = paramahp.hhd;
    paramg.t(paramIntent);
    ac.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramahp.EBB != null) {
      paramIntent.putExtra("img_gallery_width", paramahp.EBB.width).putExtra("img_gallery_height", paramahp.EBB.height).putExtra("img_gallery_left", paramahp.EBB.left).putExtra("img_gallery_top", paramahp.EBB.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramahp = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d(paramg.hkX.url, 24, 10000, i);
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, paramahp, paramg.hkX.type, 24, 10000, paramIntent)) {
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    }
    AppMethodBeat.o(24588);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, ahp paramahp)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramahp, localIntent);
    i.fZ("FavRecordDetailUI", paramahp.sessionId);
    com.tencent.mm.br.d.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, ahp paramahp, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramahp, paramIntent);
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
      ac.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24596);
      return;
    }
    agx localagx1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      ac.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
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
      localObject2 = paramg.field_favProto.EAK;
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
          if (!bs.isNullOrNil(((aic)localObject2).title)) {
            paramg = ((aic)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (bs.isNullOrNil(paramg)) {
          localObject1 = localagx1.title;
        }
        parama.aHp(paramContext.getResources().getString(2131755278) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        agx localagx2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localagx2));
          if (((com.tencent.mm.vfs.e)localObject1).exists())
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
            break label55;
          }
          localObject1 = paramg.field_favProto.EAK;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((aic)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bs.isNullOrNil((String)localObject1)) {
              localObject2 = localagx2.dbZ;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.acs((String)localObject2);
            localObject1 = localObject2;
            if (!bs.isNullOrNil((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(2131689584);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.EAM;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.acs(((ahm)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bs.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689577);
            break label55;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.EAO;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.acs(((ahw)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bs.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131689577);
            break label55;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localagx2));
          if (((com.tencent.mm.vfs.e)localObject1).exists())
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.acs(localagx2.dbZ);
          localObject2 = localObject1;
          if (bs.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localagx2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localagx2);
          }
          localObject1 = localObject2;
          if (!bs.isNullOrNil((String)localObject2)) {
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
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.e.aFI(localagx2.Ezu));
            break;
          }
          if (17 == paramg.field_type)
          {
            az.ayM();
            localObject1 = com.tencent.mm.model.c.awD().alw(localagx2.desc);
            if ((((bo.a)localObject1).zTO != null) && (((bo.a)localObject1).zTO.length() != 0))
            {
              localObject1 = new SpannableString(((bo.a)localObject1).zTO);
              break;
            }
            localObject1 = Integer.valueOf(2131231875);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.nxC == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.nxC.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localagx2 = (agx)((Iterator)localObject1).next();
            } while (localagx2.dataType == 1);
            if (localagx2.dataType == 3)
            {
              localObject1 = Integer.valueOf(2131689583);
              break label55;
            }
            if (localagx2.dataType == 6)
            {
              localObject1 = Integer.valueOf(2131689562);
              break label55;
            }
            if (localagx2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.e.aFI(localagx2.Ezu));
              break label55;
            }
            if ((localagx2.dataType == 2) || (localagx2.dataType == 7) || (localagx2.dataType == 15) || (localagx2.dataType == 4))
            {
              localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localagx2));
              if (((com.tencent.mm.vfs.e)localObject1).exists())
              {
                localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.acs(localagx2.dbZ);
              if (bs.isNullOrNil((String)localObject1)) {
                switch (localagx2.dataType)
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
            if (localagx2.dataType == 5)
            {
              localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localagx2));
              if (((com.tencent.mm.vfs.e)localObject1).exists())
              {
                localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
                break label55;
              }
              localObject1 = localagx2.EzZ.EAK;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((aic)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (bs.isNullOrNil((String)localObject1)) {
                  localObject2 = localagx2.dbZ;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.acs((String)localObject2);
                localObject1 = localObject2;
                if (!bs.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(2131689584);
                break;
              }
            }
            if (localagx2.dataType == 22)
            {
              localObject1 = Integer.valueOf(2131690572);
              break label55;
            }
            if ((localagx2.dataType == 10) || (localagx2.dataType == 11))
            {
              localObject2 = localagx2.EzZ.EAM;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.acs(((ahm)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bs.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
            if ((localagx2.dataType == 12) || (localagx2.dataType == 14))
            {
              localObject2 = localagx2.EzZ.EAO;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.acs(((ahw)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bs.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131689577);
                break label55;
              }
            }
          } while (localagx2.dataType != 16);
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().alw(localagx2.desc);
          if ((((bo.a)localObject1).zTO != null) && (((bo.a)localObject1).zTO.length() != 0))
          {
            localObject1 = new SpannableString(((bo.a)localObject1).zTO);
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
    if (bs.isNullOrNil((String)localObject1)) {
      paramg = localagx1.title;
    }
    parama.aHp(paramContext.getResources().getString(2131755773) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.aHp(paramg.field_favProto.desc);
    parama.eNB();
    parama.a(new d.a.b()
    {
      public final void crN()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", this.qIe.field_favProto.desc);
        com.tencent.mm.br.d.e(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.jS(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.EAI;
    paramg = paramContext.getString(2131755806);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((ahe)localObject1).label;
    }
    parama.aHp(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!bs.isNullOrNil(((aic)localObject2).title)))
    {
      paramg = ((aic)localObject2).title;
      localObject1 = ((aic)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (bs.isNullOrNil(paramg)) {
        localObject2 = localagx1.title;
      }
      bs.isNullOrNil((String)localObject1);
      parama.aHp(paramContext.getResources().getString(2131755920) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.aHp(paramContext.getResources().getString(2131755872) + paramg);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.f.aKz((String)localObject1), 3);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.f.aKz((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      parama.i(com.tencent.mm.sdk.platformtools.f.aKz((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      localObject1 = paramContext.getResources().getString(2131755834);
      paramContext = l.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.aHp((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.EBc;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(2131755775) + paramg.desc;; paramContext = paramContext.getString(2131755775))
      {
        parama.aHp(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!bs.isNullOrNil(((aic)localObject2).title)) {
          paramg = ((aic)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (bs.isNullOrNil(paramg)) {
        localObject1 = localagx1.title;
      }
      parama.aHp(paramContext.getResources().getString(2131755820) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.EAX != null) {}
      for (paramContext = paramContext.getString(2131755375) + paramg.field_favProto.title;; paramContext = paramContext.getString(2131755375))
      {
        parama.aHp(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(ahp paramahp, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramahp.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramahp.nLC);
    paramIntent.putExtra("key_detail_fav_index", paramahp.index);
    paramIntent.putExtra("key_detail_fav_query", paramahp.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramahp.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramahp.qIF);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, agx paramagx, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    aha localaha = paramagx.EAf;
    if ((localaha == null) || (bs.isNullOrNil(localaha.hjV)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    m.a(m.a.qIU, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramagx);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localaha.hjV);
    localIntent.putExtra("StreamWording", localaha.hjY);
    localIntent.putExtra("StremWebUrl", localaha.hjZ);
    localIntent.putExtra("KThumUrl", localaha.hka);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localaha.hkb);
    localIntent.putExtra("KSta_StremVideoPublishId", localaha.hkc);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", m.b.qJe.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramagx.dvs);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localaha.EBs);
    localIntent.putExtra("KMediaTitle", localaha.hjX);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMG, 0) > 0)
    {
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ac.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(24591);
      return true;
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, ahp paramahp)
  {
    AppMethodBeat.i(24581);
    if (paramContext == null)
    {
      ac.w("MicroMsg.FavItemLogic", "Context is null");
      AppMethodBeat.o(24581);
      return;
    }
    if (paramg == null)
    {
      ac.w("MicroMsg.FavItemLogic", "Fav item is null");
      AppMethodBeat.o(24581);
      return;
    }
    ac.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
    switch (paramg.field_type)
    {
    case -1: 
    case 0: 
    case 9: 
    case 13: 
    default: 
      ac.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
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
        ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.cpl());
        ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
        if (paramg.field_sourceCreateTime <= 0L) {}
        for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
        {
          ((Intent)localObject1).putExtra("key_detail_create_time", l);
          a(paramahp, (Intent)localObject1);
          i.fZ("FavoriteTextDetailUI", paramahp.sessionId);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
          AppMethodBeat.o(24581);
          return;
        }
        e(paramContext, paramg, paramahp);
        AppMethodBeat.o(24581);
        return;
        localObject1 = new Intent();
        a(paramg, paramahp, (Intent)localObject1);
        ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.EBJ.createTime);
        i.fZ("FavoriteVoiceDetailUI", paramahp.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if ((localObject1 != null) && (((agx)localObject1).EAf != null) && ((!bs.isNullOrNil(((agx)localObject1).EAf.hjV)) || (!bs.isNullOrNil(((agx)localObject1).EAf.hjZ))))
        {
          ac.i("MicroMsg.FavItemLogic", "it is ad sight.");
          c(paramContext, paramg, paramahp);
          AppMethodBeat.o(24581);
          return;
        }
        d(paramContext, paramg, paramahp);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, paramahp);
        AppMethodBeat.o(24581);
        return;
        d(paramContext, paramg, true, paramahp);
        AppMethodBeat.o(24581);
        return;
        Object localObject2 = paramg.field_favProto.EAI;
        String str = paramg.field_favProto.iAC;
        localObject1 = paramg.field_favProto.EBJ;
        if ((localObject1 != null) && (!bs.isNullOrNil(((aht)localObject1).EBj))) {}
        for (localObject1 = com.tencent.mm.model.v.wk(((aht)localObject1).EBj);; localObject1 = com.tencent.mm.model.v.wk(paramg.field_fromUser))
        {
          ArrayList localArrayList = new ArrayList();
          if (paramg.field_tagProto.EBX != null) {
            localArrayList.addAll(paramg.field_tagProto.EBX);
          }
          i.fZ("RedirectUI", paramahp.sessionId);
          com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (ahe)localObject2, (String)localObject1, str, localArrayList, paramContext);
          AppMethodBeat.o(24581);
          return;
        }
        localObject2 = paramg.field_favProto.EBJ;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramahp = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a((agx)localObject1));
        if (!paramahp.exists()) {
          if (((agx)localObject1).dbZ == null)
          {
            paramahp = "";
            paramahp = com.tencent.mm.ay.g.a(6, null, ((agx)localObject1).title, ((agx)localObject1).desc, ((agx)localObject1).Ezm, ((agx)localObject1).Ezq, ((agx)localObject1).Ezo, ((agx)localObject1).dhw, com.tencent.mm.plugin.fav.a.b.cpc(), paramahp, "", ((aht)localObject2).appId);
            paramahp.hOj = ((agx)localObject1).songAlbumUrl;
            paramahp.hOb = ((agx)localObject1).songLyric;
            paramahp.hOt = ((agx)localObject1).dhw;
            if (com.tencent.mm.plugin.fav.a.b.f((agx)localObject1)) {
              break label912;
            }
            ac.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.ay.a.c(paramahp);
          }
        }
        for (;;)
        {
          paramahp.hOq = String.valueOf(paramg.field_localId);
          paramg = new Intent();
          paramg.putExtra("key_scene", 2);
          com.tencent.mm.br.d.b(paramContext, "music", ".ui.MusicMainUI", paramg);
          AppMethodBeat.o(24581);
          return;
          paramahp = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.coW() + com.tencent.mm.b.g.getMessageDigest(((agx)localObject1).dbZ.getBytes()));
          if (paramahp.exists()) {}
          for (paramahp = q.B(paramahp.fxV());; paramahp = "") {
            break;
          }
          paramahp = q.B(paramahp.fxV());
          break;
          ac.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
        }
        c(paramContext, paramg, true, paramahp);
        AppMethodBeat.o(24581);
        return;
        ac.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.EAM.info;
        paramahp = new Intent();
        paramahp.putExtra("key_is_favorite_item", true);
        paramahp.putExtra("key_favorite_local_id", l);
        paramahp.putExtra("key_Product_xml", paramg);
        paramahp.putExtra("key_can_delete_favorite_item", true);
        paramahp.putExtra("key_ProductUI_getProductInfoScene", 3);
        com.tencent.mm.br.d.b(paramContext, "scanner", ".ui.ProductUI", paramahp);
        AppMethodBeat.o(24581);
        return;
        ac.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.EAO.info;
        paramahp = new Intent();
        paramahp.putExtra("key_TV_getProductInfoScene", 3);
        paramahp.putExtra("key_is_favorite_item", true);
        paramahp.putExtra("key_favorite_local_id", l);
        paramahp.putExtra("key_TV_xml", paramg);
        paramahp.putExtra("key_can_delete_favorite_item", true);
        com.tencent.mm.br.d.b(paramContext, "shake", ".ui.TVInfoUI", paramahp);
        AppMethodBeat.o(24581);
        return;
        ac.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        paramahp = new Intent();
        paramahp.putExtra("key_product_scene", 4);
        paramahp.putExtra("key_product_info", paramg.field_favProto.EAM.info);
        com.tencent.mm.br.d.b(paramContext, "product", ".ui.MallProductUI", paramahp);
        AppMethodBeat.o(24581);
        return;
        a(paramContext, paramg, true, paramahp);
        AppMethodBeat.o(24581);
        return;
        paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
        az.ayM();
        paramg = com.tencent.mm.model.c.awD().alw(paramg);
      } while (paramg == null);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Contact_User", paramg.zTO);
      ((Intent)localObject1).putExtra("Contact_Alias", paramg.eNf);
      ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
      ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.iLM);
      ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.iLL);
      ((Intent)localObject1).putExtra("Contact_Uin", paramg.vLk);
      ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.GYX);
      ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.GYY);
      ((Intent)localObject1).putExtra("Contact_QQNick", paramg.fcl());
      ((Intent)localObject1).putExtra("User_From_Fmessage", false);
      ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
      ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
      ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.iLQ);
      ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.Chb);
      ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.eya);
      ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.vIX);
      ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
      ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
      ((Intent)localObject1).putExtra("Contact_Sex", paramg.exL);
      ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
      ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
      ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
      i.fZ("ContactInfoUI", paramahp.sessionId);
      com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      com.tencent.mm.bs.a.XC(paramg.scene);
      AppMethodBeat.o(24581);
      return;
    case 18: 
      label912:
      b(paramContext, paramg, true, paramahp);
      AppMethodBeat.o(24581);
      return;
    }
    Toast.makeText(paramContext, 2131759027, 0).show();
    AppMethodBeat.o(24581);
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, ahp paramahp)
  {
    AppMethodBeat.i(24583);
    ac.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    nb localnb = new nb();
    localnb.dpw.field_localId = paramg.field_localId;
    Object localObject;
    if ((!bs.isNullOrNil(paramg.qIn)) && (paramg.field_favProto != null) && (paramg.field_favProto.nxC != null) && (paramg.field_favProto.nxC.size() > 0))
    {
      localObject = paramg.field_favProto.nxC.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label399;
      }
      if (!bs.lr(((agx)((Iterator)localObject).next()).dhw, paramg.qIn)) {
        break label350;
      }
    }
    label384:
    label399:
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localnb.dpw.dpz) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localnb.dpw;
          ((nb.a)localObject).dpz -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label384;
        }
        localnb.dpw.dpF = 4;
      }
      for (;;)
      {
        localnb.dpw.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.DKz;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((ahh)localObject).EBC);
          paramContext.putString("noteeditor", ((ahh)localObject).EBD);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localnb.dpw.dpD = paramContext;
        localnb.dpw.field_favProto = paramg.field_favProto;
        localnb.dpw.type = 2;
        localnb.dpw.dpG = paramBoolean;
        localnb.dpw.dpH = paramahp;
        com.tencent.mm.sdk.b.a.GpY.l(localnb);
        i.fZ("NoteEditorUI", paramahp.sessionId);
        AppMethodBeat.o(24583);
        return;
        label350:
        nb.a locala = localnb.dpw;
        locala.dpz += 1;
        break;
        localnb.dpw.dpz = 0;
        break label190;
        localnb.dpw.dpy = paramg.field_xml;
      }
    }
  }
  
  public static void b(o.a parama, final Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24597);
    if ((paramg == null) || (paramContext == null))
    {
      ac.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(24597);
      return;
    }
    final agx localagx = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24574);
          d.f(this.val$context, paramg, new ahp());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", this.qIe.field_favProto.desc);
          com.tencent.mm.br.d.e(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.jS(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.6(paramg.field_favProto.EAI, paramContext));
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24577);
          d.g(this.val$context, paramg, new ahp());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24578);
          d.h(this.val$context, paramg, new ahp());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.qIe.field_localId);
          localIntent.putExtra("key_detail_data_id", localagx.dhw);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24580);
          agx localagx = com.tencent.mm.plugin.fav.a.b.c(this.qIe);
          if (localagx == null)
          {
            ac.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.c(paramContext, localagx))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localagx.EAf != null) && ((!bs.isNullOrNil(localagx.EAf.hjV)) || (!bs.isNullOrNil(localagx.EAf.hjZ))))
          {
            ac.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", this.qIe.field_localId);
            localIntent.putExtra("key_detail_data_id", localagx.dhw);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.qIe.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localagx));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localagx));
          localIntent.putExtra("key_detail_fav_video_duration", localagx.duration);
          localIntent.putExtra("key_detail_statExtStr", localagx.dvs);
          localIntent.putExtra("key_detail_msg_uuid", localagx.iaU);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(24572);
          d.i(this.val$context, paramg, new ahp());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(163190);
          anx localanx = this.qIe.field_favProto.EBc;
          if (localanx != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.qMB;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localanx);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static boolean b(Context paramContext, agx paramagx)
  {
    AppMethodBeat.i(24589);
    if ((paramagx == null) || (paramagx.EzZ == null) || (paramagx.EzZ.EBa == null))
    {
      ac.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(24589);
      return false;
    }
    boolean bool = r.a(paramContext, paramagx.EzZ.EBa, paramagx);
    AppMethodBeat.o(24589);
    return bool;
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, ahp paramahp)
  {
    AppMethodBeat.i(24590);
    m.a(m.a.qIS, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramahp, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, ahp paramahp)
  {
    AppMethodBeat.i(24584);
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramahp != null) && (paramahp.dxw == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!bs.isNullOrNil(paramg.qIn))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.qIn);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramahp, (Intent)localObject);
        i.fZ("FavoriteFileDetailUI", paramahp.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramahp != null) && (paramahp.dxw == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d((agx)localObject), ((agx)localObject).Ezu, 2);
      AppMethodBeat.o(24584);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.g((agx)localObject))
    {
      if (com.tencent.mm.plugin.fav.a.b.h((agx)localObject))
      {
        e(paramContext, paramg, paramahp);
        AppMethodBeat.o(24584);
        return;
      }
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(HandOffFile.b((agx)localObject, paramg));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.i(com.tencent.mm.plugin.fav.a.b.d((agx)localObject), ((agx)localObject).Ezu, ((agx)localObject).title, 2))
      {
        AppMethodBeat.o(24584);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("key_detail_data_id", ((agx)localObject).dhw);
    localIntent.putExtra("show_share", paramBoolean);
    a(paramahp, localIntent);
    i.fZ("FavoriteFileDetailUI", paramahp.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
    AppMethodBeat.o(24584);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, ahp paramahp)
  {
    AppMethodBeat.i(24592);
    agx localagx = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localagx, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (b(paramContext, localagx))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((bs.isNullOrNil(localagx.Ezw)) || (localagx.EzA <= 0L))
    {
      ac.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localagx.Ezw, Long.valueOf(localagx.EzA) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).Ezm;
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).Ezq;
      }
      if (bs.isNullOrNil((String)localObject1))
      {
        ac.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramahp);
        AppMethodBeat.o(24592);
        return;
      }
      paramahp = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localagx.dvs);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramahp.putExtra("jsapiargs", (Bundle)localObject2);
      paramahp.putExtra("rawUrl", (String)localObject1);
      paramahp.putExtra("is_favorite_item", true);
      paramahp.putExtra("fav_local_id", paramg.field_localId);
      paramahp.putExtra("geta8key_scene", 14);
      ac.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramahp.putExtra("geta8key_scene", 14);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramahp);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramahp, (Intent)localObject1);
    i.fZ("FavoriteSightDetailUI", paramahp.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, ahp paramahp)
  {
    AppMethodBeat.i(24587);
    Object localObject1 = J(paramg);
    if (!bs.isNullOrNil((String)localObject1))
    {
      paramahp = new Intent();
      paramahp.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramahp.putExtra("sns_landig_pages_from_source", 7);
      paramahp.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramahp.putExtra("sns_landing_favid", u.axw() + "_" + paramg.field_id);
      paramahp.addFlags(268435456);
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramahp);
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject2 = paramg.field_favProto.EAK;
    if ((localObject2 != null) && (((aic)localObject2).ECr) && (!bs.isNullOrNil(((aic)localObject2).ECq)))
    {
      paramg = bv.L(((aic)localObject2).ECq, "websearch");
      paramahp = new dyo();
      paramahp.BYK = ((String)paramg.get(".websearch.relevant_vid"));
      paramahp.BYL = ((String)paramg.get(".websearch.relevant_expand"));
      paramahp.BYM = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramahp.BYN = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramahp.BYO = bs.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramahp.pBl = ((String)paramg.get(".websearch.shareUrl"));
      paramahp.pBm = ((String)paramg.get(".websearch.shareTitle"));
      paramahp.tcG = ((String)paramg.get(".websearch.shareDesc"));
      paramahp.BYP = ((String)paramg.get(".websearch.shareImgUrl"));
      paramahp.BYQ = ((String)paramg.get(".websearch.shareString"));
      paramahp.BYR = ((String)paramg.get(".websearch.shareStringUrl"));
      paramahp.source = ((String)paramg.get(".websearch.source"));
      paramahp.kRU = ((String)paramg.get(".websearch.sourceUrl"));
      paramahp.BYS = ((String)paramg.get(".websearch.strPlayCount"));
      paramahp.BYT = ((String)paramg.get(".websearch.titleUrl"));
      paramahp.BYU = ((String)paramg.get(".websearch.extReqParams"));
      paramahp.BYV = ((String)paramg.get(".websearch.tagList"));
      paramahp.BYW = bs.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramahp.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramahp.BYX = ((String)paramg.get(".websearch.shareTag"));
      z.a(paramContext, com.tencent.mm.plugin.topstory.a.h.a(paramahp, 326, paramContext.getString(2131764521)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      localObject2 = paramg.field_favProto.EAK;
      localObject3 = ((aic)localObject2).ECl;
      localObject1 = ((aic)localObject2).title;
    }
    for (localObject2 = ((aic)localObject2).desc;; localObject2 = "")
    {
      aht localaht = paramg.field_favProto.EBJ;
      Object localObject4 = localObject3;
      if (localaht != null)
      {
        localObject4 = localObject3;
        if (bs.isNullOrNil((String)localObject3)) {
          localObject4 = localaht.link;
        }
      }
      if (bs.isNullOrNil((String)localObject4))
      {
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).useOffline((String)localObject4, paramg.field_localId))
      {
        ac.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject4 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).getFavOfflineService().acN((String)localObject4);
      agx localagx = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      Object localObject5 = localObject1;
      if (localagx != null)
      {
        localObject3 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject3 = localagx.title;
        }
        localObject6 = localObject2;
        localObject5 = localObject3;
        if (bs.isNullOrNil((String)localObject2))
        {
          localObject6 = localagx.desc;
          localObject5 = localObject3;
        }
      }
      ac.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.cpn());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      if ((localaht != null) && (!bs.isNullOrNil(localaht.cYF))) {
        ((Intent)localObject1).putExtra("srcDisplayname", com.tencent.mm.model.v.wk(localaht.cYF));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).dvs);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + u.axw() + "_" + paramg.field_id;
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
      localObject2 = com.tencent.mm.modelstat.a.c.DB(com.tencent.mm.pluginsdk.model.f.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramahp.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramahp.nLC);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramahp.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramahp.query);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramahp.sessionId);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramahp.qIF);
      i.fZ("WebViewUI", paramahp.sessionId);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      if ((paramg.field_favProto.CoY != null) && (paramg.field_favProto.CoY.hha == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yr(paramg.field_favProto.CoY.hgY)))
      {
        a(paramContext, paramg, paramahp, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
      }
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, ahp paramahp)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramahp, localIntent);
    i.fZ("FavoriteImgDetailUI", paramahp.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */