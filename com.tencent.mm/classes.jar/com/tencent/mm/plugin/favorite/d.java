package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.f;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.ui.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.widget.b.c.a.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static int[] mEF = { 2131822717, 2131822718, 2131822719, 2131822720, 2131822721 };
  
  private static String H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(20512);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(20512);
      return null;
    }
    if ((paramg.field_favProto.wUf != null) && (!bo.isNullOrNil(paramg.field_favProto.wUf.canvasPageXml)))
    {
      paramg = paramg.field_favProto.wUf.canvasPageXml;
      AppMethodBeat.o(20512);
      return paramg;
    }
    paramg = paramg.field_favProto.wVc;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((aca)paramg.get(0)).canvasPageXml;
      AppMethodBeat.o(20512);
      return paramg;
    }
    AppMethodBeat.o(20512);
    return null;
  }
  
  private static String I(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(20513);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(20513);
      return null;
    }
    if ((paramg.field_favProto.wUf != null) && (!bo.isNullOrNil(paramg.field_favProto.wUf.thumbUrl)))
    {
      paramg = paramg.field_favProto.wUf.thumbUrl;
      AppMethodBeat.o(20513);
      return paramg;
    }
    paramg = paramg.field_favProto.wVc;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((aca)paramg.get(0)).fgM;
      AppMethodBeat.o(20513);
      return paramg;
    }
    AppMethodBeat.o(20513);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, acs paramacs, Intent paramIntent)
  {
    AppMethodBeat.i(153529);
    paramIntent.putExtra("biz_video_scene", paramacs.scene);
    paramIntent.putExtra("biz_video_subscene", paramacs.kbN);
    paramIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
    paramg = paramg.field_favProto.uVl;
    com.tencent.mm.af.s locals = new com.tencent.mm.af.s();
    locals.cqX = paramg.cqX;
    locals.fjB = paramg.fjB;
    locals.fjD.url = paramIntent.getStringExtra("rawUrl");
    locals.fjD.title = bo.nullAsNil(paramIntent.getStringExtra("share_report_pre_msg_title"));
    locals.fjD.fjL = paramIntent.getStringExtra("share_report_pre_msg_desc");
    locals.fjD.fjJ = paramg.fjJ;
    locals.fjD.type = paramg.fgh;
    locals.fjD.time = paramg.fgi;
    locals.fjD.fjN = paramg.duration;
    locals.fjD.videoWidth = paramg.videoWidth;
    locals.fjD.videoHeight = paramg.videoHeight;
    locals.fjD.fgl = paramg.fgl;
    locals.t(paramIntent);
    ab.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramg.wUS != null) {
      paramIntent.putExtra("img_gallery_width", paramg.wUS.width).putExtra("img_gallery_height", paramg.wUS.height).putExtra("img_gallery_left", paramg.wUS.left).putExtra("img_gallery_top", paramg.wUS.top);
    }
    paramIntent.addFlags(268435456);
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, locals.fjD.url, locals.fjD.type, true, paramacs.scene, paramacs.kbN, paramIntent)) {
      com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    }
    AppMethodBeat.o(153529);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, acs paramacs)
  {
    AppMethodBeat.i(20509);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramacs, localIntent);
    i.ep("FavRecordDetailUI", paramacs.cpW);
    com.tencent.mm.bq.d.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(20509);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, acs paramacs, Intent paramIntent)
  {
    AppMethodBeat.i(20519);
    a(paramacs, paramIntent);
    paramIntent.putExtra("key_detail_info_id", paramg.field_localId);
    AppMethodBeat.o(20519);
  }
  
  public static void a(g.a parama, Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(20521);
    if ((paramg == null) || (paramContext == null))
    {
      ab.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(20521);
      return;
    }
    aca localaca1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      ab.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      label53:
      localObject1 = null;
      label55:
      if (!(localObject1 instanceof String)) {
        break label1339;
      }
    }
    Object localObject2;
    for (Object localObject1 = (String)localObject1;; localObject1 = null)
    {
      localObject2 = paramg.field_favProto.wUf;
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
          if (!bo.isNullOrNil(((adf)localObject2).title)) {
            paramg = ((adf)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (bo.isNullOrNil(paramg)) {
          localObject1 = localaca1.title;
        }
        parama.amm(paramContext.getResources().getString(2131296543) + (String)localObject1);
        AppMethodBeat.o(20521);
        return;
        aca localaca2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localaca2));
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            localObject1 = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
            break label55;
          }
          localObject1 = paramg.field_favProto.wUf;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((adf)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bo.isNullOrNil((String)localObject1)) {
              localObject2 = localaca2.cpH;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.NB((String)localObject2);
            localObject1 = localObject2;
            if (!bo.isNullOrNil((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(2131230829);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.wUh;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.NB(((acp)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bo.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131230822);
            break label55;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.wUj;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.NB(((acz)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bo.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(2131230822);
            break label55;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localaca2));
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            localObject1 = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.NB(localaca2.cpH);
          localObject2 = localObject1;
          if (bo.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localaca2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.c(localaca2);
          }
          localObject1 = localObject2;
          if (!bo.isNullOrNil((String)localObject2)) {
            break label55;
          }
        }
        switch (paramg.field_type)
        {
        default: 
          localObject1 = Integer.valueOf(2131230826);
          break;
        case 2: 
          localObject1 = Integer.valueOf(2130837708);
          break;
        case 7: 
          localObject1 = Integer.valueOf(2131230809);
          break;
          if ((3 == paramg.field_type) || (6 == paramg.field_type)) {
            break label53;
          }
          if (8 == paramg.field_type)
          {
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.d.akU(localaca2.wSR));
            break;
          }
          if (17 == paramg.field_type)
          {
            aw.aaz();
            localObject1 = com.tencent.mm.model.c.YC().Ty(localaca2.desc);
            if ((((bi.a)localObject1).tac != null) && (((bi.a)localObject1).tac.length() != 0))
            {
              localObject1 = new SpannableString(((bi.a)localObject1).tac);
              break;
            }
            localObject1 = Integer.valueOf(2130838493);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.wVc == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.wVc.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localaca2 = (aca)((Iterator)localObject1).next();
            } while (localaca2.dataType == 1);
            if (localaca2.dataType == 3)
            {
              localObject1 = Integer.valueOf(2131230828);
              break label55;
            }
            if (localaca2.dataType == 6)
            {
              localObject1 = Integer.valueOf(2131230807);
              break label55;
            }
            if (localaca2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.d.akU(localaca2.wSR));
              break label55;
            }
            if ((localaca2.dataType == 2) || (localaca2.dataType == 7) || (localaca2.dataType == 15) || (localaca2.dataType == 4))
            {
              localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localaca2));
              if (((com.tencent.mm.vfs.b)localObject1).exists())
              {
                localObject1 = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.NB(localaca2.cpH);
              if (bo.isNullOrNil((String)localObject1)) {
                switch (localaca2.dataType)
                {
                default: 
                  localObject1 = Integer.valueOf(2131230826);
                  break;
                case 2: 
                  localObject1 = Integer.valueOf(2130837708);
                  break;
                case 7: 
                  localObject1 = Integer.valueOf(2131230809);
                  break;
                }
              }
              break label55;
            }
            if (localaca2.dataType == 5)
            {
              localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localaca2));
              if (((com.tencent.mm.vfs.b)localObject1).exists())
              {
                localObject1 = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
                break label55;
              }
              localObject1 = localaca2.wTw.wUf;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((adf)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (bo.isNullOrNil((String)localObject1)) {
                  localObject2 = localaca2.cpH;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.NB((String)localObject2);
                localObject1 = localObject2;
                if (!bo.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(2131230829);
                break;
              }
            }
            if ((localaca2.dataType == 10) || (localaca2.dataType == 11))
            {
              localObject2 = localaca2.wTw.wUh;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.NB(((acp)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bo.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131230822);
                break label55;
              }
            }
            if ((localaca2.dataType == 12) || (localaca2.dataType == 14))
            {
              localObject2 = localaca2.wTw.wUj;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.NB(((acz)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bo.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(2131230822);
                break label55;
              }
            }
          } while (localaca2.dataType != 16);
          aw.aaz();
          localObject1 = com.tencent.mm.model.c.YC().Ty(localaca2.desc);
          if ((((bi.a)localObject1).tac != null) && (((bi.a)localObject1).tac.length() != 0))
          {
            localObject1 = new SpannableString(((bi.a)localObject1).tac);
            break;
          }
          localObject1 = Integer.valueOf(2130838493);
          break;
          label1339:
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
    if (bo.isNullOrNil((String)localObject1)) {
      paramg = localaca1.title;
    }
    parama.amm(paramContext.getResources().getString(2131296962) + paramg);
    AppMethodBeat.o(20521);
    return;
    parama.amm(paramg.field_favProto.desc);
    parama.dny();
    parama.a(new d.2(paramg, paramContext));
    AppMethodBeat.o(20521);
    return;
    paramg = paramg.field_favProto.wUd;
    parama.amm(paramContext.getString(2131296989) + paramg.label);
    AppMethodBeat.o(20521);
    return;
    if ((localObject2 != null) && (!bo.isNullOrNil(((adf)localObject2).title)))
    {
      paramg = ((adf)localObject2).title;
      localObject1 = ((adf)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (bo.isNullOrNil(paramg)) {
        localObject2 = localaca1.title;
      }
      bo.isNullOrNil((String)localObject1);
      parama.amm(paramContext.getResources().getString(2131297097) + (String)localObject2);
      AppMethodBeat.o(20521);
      return;
      paramg = i.a.a(paramContext, paramg).title;
      parama.amm(paramContext.getResources().getString(2131297055) + paramg);
      AppMethodBeat.o(20521);
      return;
      parama.d(com.tencent.mm.sdk.platformtools.d.aoV((String)localObject1), 3);
      AppMethodBeat.o(20521);
      return;
      parama.d(com.tencent.mm.sdk.platformtools.d.aoV((String)localObject1), 2);
      AppMethodBeat.o(20521);
      return;
      parama.d(com.tencent.mm.sdk.platformtools.d.aoV((String)localObject1), 2);
      AppMethodBeat.o(20521);
      return;
      localObject1 = paramContext.getResources().getString(2131297017);
      paramContext = i.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.amm((String)localObject1 + paramContext);
      AppMethodBeat.o(20521);
      return;
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!bo.isNullOrNil(((adf)localObject2).title)) {
          paramg = ((adf)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (bo.isNullOrNil(paramg)) {
        localObject1 = localaca1.title;
      }
      parama.amm(paramContext.getResources().getString(2131297003) + (String)localObject1);
      AppMethodBeat.o(20521);
      return;
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(acs paramacs, Intent paramIntent)
  {
    AppMethodBeat.i(20520);
    paramIntent.putExtra("key_detail_fav_scene", paramacs.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramacs.kbN);
    paramIntent.putExtra("key_detail_fav_index", paramacs.index);
    paramIntent.putExtra("key_detail_fav_query", paramacs.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramacs.cpW);
    paramIntent.putExtra("key_detail_fav_tags", paramacs.mtm);
    AppMethodBeat.o(20520);
  }
  
  private static boolean a(Context paramContext, aca paramaca, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(20516);
    acd localacd = paramaca.wTC;
    if ((localacd == null) || (bo.isNullOrNil(localacd.fiO)))
    {
      AppMethodBeat.o(20516);
      return false;
    }
    m.a(m.a.mtA, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.c(paramaca);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localacd.fiO);
    localIntent.putExtra("StreamWording", localacd.fiR);
    localIntent.putExtra("StremWebUrl", localacd.fiS);
    localIntent.putExtra("KThumUrl", localacd.fiT);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localacd.fiU);
    localIntent.putExtra("KSta_StremVideoPublishId", localacd.fiV);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", m.b.mtK.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramaca.cGU);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localacd.wUJ);
    localIntent.putExtra("KMediaTitle", localacd.fiQ);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRW, 0) > 0)
    {
      com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ab.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(20516);
      return true;
      com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, acs paramacs)
  {
    AppMethodBeat.i(20508);
    if (paramContext == null)
    {
      ab.w("MicroMsg.FavItemLogic", "Context is null");
      AppMethodBeat.o(20508);
      return;
    }
    if (paramg == null)
    {
      ab.w("MicroMsg.FavItemLogic", "Fav item is null");
      AppMethodBeat.o(20508);
      return;
    }
    ab.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
    switch (paramg.field_type)
    {
    case -1: 
    case 0: 
    case 9: 
    case 13: 
    default: 
      ab.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
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
        AppMethodBeat.o(20508);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_detail_text", paramg.field_favProto.desc);
        ((Intent)localObject1).putExtra("key_detail_info_id", paramg.field_localId);
        ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.bwl());
        ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
        if (paramg.field_sourceCreateTime <= 0L) {}
        for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
        {
          ((Intent)localObject1).putExtra("key_detail_create_time", l);
          a(paramacs, (Intent)localObject1);
          i.ep("FavoriteTextDetailUI", paramacs.cpW);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
          AppMethodBeat.o(20508);
          return;
        }
        e(paramContext, paramg, paramacs);
        AppMethodBeat.o(20508);
        return;
        localObject1 = new Intent();
        a(paramg, paramacs, (Intent)localObject1);
        ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.wVa.createTime);
        i.ep("FavoriteVoiceDetailUI", paramacs.cpW);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
        AppMethodBeat.o(20508);
        return;
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if ((localObject1 != null) && (((aca)localObject1).wTC != null) && ((!bo.isNullOrNil(((aca)localObject1).wTC.fiO)) || (!bo.isNullOrNil(((aca)localObject1).wTC.fiS))))
        {
          ab.i("MicroMsg.FavItemLogic", "it is ad sight.");
          c(paramContext, paramg, paramacs);
          AppMethodBeat.o(20508);
          return;
        }
        d(paramContext, paramg, paramacs);
        AppMethodBeat.o(20508);
        return;
        d(paramContext, paramg, paramacs);
        AppMethodBeat.o(20508);
        return;
        d(paramContext, paramg, true, paramacs);
        AppMethodBeat.o(20508);
        return;
        Object localObject2 = paramg.field_favProto.wUd;
        Object localObject3 = paramg.field_favProto.hKa;
        localObject1 = paramg.field_favProto.wVa;
        if ((localObject1 != null) && (!bo.isNullOrNil(((acw)localObject1).wUA))) {}
        for (localObject1 = com.tencent.mm.model.s.nE(((acw)localObject1).wUA);; localObject1 = com.tencent.mm.model.s.nE(paramg.field_fromUser))
        {
          ArrayList localArrayList = new ArrayList();
          if (paramg.field_tagProto.wVq != null) {
            localArrayList.addAll(paramg.field_tagProto.wVq);
          }
          i.ep("RedirectUI", paramacs.cpW);
          com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (ach)localObject2, (String)localObject1, (String)localObject3, localArrayList, paramContext);
          AppMethodBeat.o(20508);
          return;
        }
        localObject3 = paramg.field_favProto.wVa;
        localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c((aca)localObject2));
        if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
          if (((aca)localObject2).cpH == null)
          {
            localObject1 = "";
            localObject1 = f.a(6, null, ((aca)localObject2).title, ((aca)localObject2).desc, ((aca)localObject2).wSJ, ((aca)localObject2).wSN, ((aca)localObject2).wSL, ((aca)localObject2).mBq, com.tencent.mm.plugin.fav.a.b.bwd(), (String)localObject1, "", ((acw)localObject3).appId);
            if (com.tencent.mm.plugin.fav.a.b.e((aca)localObject2)) {
              break label909;
            }
            ab.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.aw.a.b((e)localObject1);
          }
        }
        for (;;)
        {
          ((e)localObject1).fKH = String.valueOf(paramg.field_localId);
          paramg = new Intent();
          paramg.putExtra("key_scene", 2);
          i.ep("MusicMainUI", paramacs.cpW);
          com.tencent.mm.bq.d.b(paramContext, "music", ".ui.MusicMainUI", paramg);
          AppMethodBeat.o(20508);
          return;
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(((aca)localObject2).cpH.getBytes()));
          if (((com.tencent.mm.vfs.b)localObject1).exists()) {}
          for (localObject1 = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());; localObject1 = "") {
            break;
          }
          localObject1 = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
          break;
          ab.i("MicroMsg.FavItemLogic", "The music is playing, don't start play again");
        }
        c(paramContext, paramg, true, paramacs);
        AppMethodBeat.o(20508);
        return;
        ab.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.wUh.info;
        paramacs = new Intent();
        paramacs.putExtra("key_is_favorite_item", true);
        paramacs.putExtra("key_favorite_local_id", l);
        paramacs.putExtra("key_Product_xml", paramg);
        paramacs.putExtra("key_can_delete_favorite_item", true);
        paramacs.putExtra("key_ProductUI_getProductInfoScene", 3);
        com.tencent.mm.bq.d.b(paramContext, "scanner", ".ui.ProductUI", paramacs);
        AppMethodBeat.o(20508);
        return;
        ab.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.wUj.info;
        paramacs = new Intent();
        paramacs.putExtra("key_TV_getProductInfoScene", 3);
        paramacs.putExtra("key_is_favorite_item", true);
        paramacs.putExtra("key_favorite_local_id", l);
        paramacs.putExtra("key_TV_xml", paramg);
        paramacs.putExtra("key_can_delete_favorite_item", true);
        com.tencent.mm.bq.d.b(paramContext, "shake", ".ui.TVInfoUI", paramacs);
        AppMethodBeat.o(20508);
        return;
        ab.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        paramacs = new Intent();
        paramacs.putExtra("key_product_scene", 4);
        paramacs.putExtra("key_product_info", paramg.field_favProto.wUh.info);
        com.tencent.mm.bq.d.b(paramContext, "product", ".ui.MallProductUI", paramacs);
        AppMethodBeat.o(20508);
        return;
        a(paramContext, paramg, true, paramacs);
        AppMethodBeat.o(20508);
        return;
        paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
        aw.aaz();
        paramg = com.tencent.mm.model.c.YC().Ty(paramg);
      } while (paramg == null);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Contact_User", paramg.tac);
      ((Intent)localObject1).putExtra("Contact_Alias", paramg.dCJ);
      ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
      ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.gyI);
      ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.gyH);
      ((Intent)localObject1).putExtra("Contact_Uin", paramg.pAI);
      ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.yOi);
      ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.yOj);
      ((Intent)localObject1).putExtra("Contact_QQNick", paramg.dyu());
      ((Intent)localObject1).putExtra("User_From_Fmessage", false);
      ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
      ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
      ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.gyM);
      ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.uOT);
      ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.dqP);
      ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.pyu);
      ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
      ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
      ((Intent)localObject1).putExtra("Contact_Sex", paramg.dqC);
      ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
      ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
      ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
      i.ep("ContactInfoUI", paramacs.cpW);
      com.tencent.mm.bq.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      com.tencent.mm.br.a.My(paramg.scene);
      AppMethodBeat.o(20508);
      return;
    case 18: 
      label909:
      b(paramContext, paramg, true, paramacs);
      AppMethodBeat.o(20508);
      return;
    }
    Toast.makeText(paramContext, 2131299850, 0).show();
    AppMethodBeat.o(20508);
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, acs paramacs)
  {
    AppMethodBeat.i(20510);
    ab.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    li localli = new li();
    localli.cBr.field_localId = paramg.field_localId;
    if (paramg.field_localId == -1L) {
      localli.cBr.cBx = 4;
    }
    for (;;)
    {
      localli.cBr.context = paramContext;
      paramContext = new Bundle();
      ack localack = paramg.field_favProto.wjV;
      if (localack != null)
      {
        paramContext.putString("noteauthor", localack.wUT);
        paramContext.putString("noteeditor", localack.wUU);
      }
      paramContext.putLong("edittime", paramg.field_updateTime);
      localli.cBr.cBw = paramContext;
      localli.cBr.field_favProto = paramg.field_favProto;
      localli.cBr.type = 2;
      localli.cBr.cBz = paramBoolean;
      localli.cBr.cBA = paramacs;
      com.tencent.mm.sdk.b.a.ymk.l(localli);
      i.ep("NoteEditorUI", paramacs.cpW);
      AppMethodBeat.o(20510);
      return;
      localli.cBr.cBt = paramg.field_xml;
    }
  }
  
  public static void b(g.a parama, Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(20522);
    if ((paramg == null) || (paramContext == null))
    {
      ab.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      AppMethodBeat.o(20522);
      return;
    }
    aca localaca = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.3(paramContext, paramg));
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.4(paramg, paramContext));
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.5(paramg.field_favProto.wUd, paramContext));
      AppMethodBeat.o(20522);
      return;
      parama.a(new c.a.b()
      {
        public final void byw()
        {
          AppMethodBeat.i(20504);
          d.g(this.val$context, paramg, new acs());
          AppMethodBeat.o(20504);
        }
      });
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.7(paramContext, paramg));
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.8(paramg, localaca, paramContext));
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.9(paramg, paramContext));
      AppMethodBeat.o(20522);
      return;
      parama.a(new d.1(paramContext, paramg));
    }
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, acs paramacs)
  {
    AppMethodBeat.i(20515);
    m.a(m.a.mty, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramacs, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(20515);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, acs paramacs)
  {
    AppMethodBeat.i(20511);
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramacs != null) && (paramacs.cIT == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("key_detail_open_way", true);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      a(paramacs, (Intent)localObject);
      i.ep("FavoriteFileDetailUI", paramacs.cpW);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
      AppMethodBeat.o(20511);
      return;
    }
    if ((paramacs != null) && (paramacs.cIT == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.b((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.b((aca)localObject), ((aca)localObject).wSR, 2);
      AppMethodBeat.o(20511);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.f((aca)localObject))
    {
      if (com.tencent.mm.plugin.fav.a.b.g((aca)localObject))
      {
        e(paramContext, paramg, paramacs);
        AppMethodBeat.o(20511);
        return;
      }
      if (!com.tencent.mm.pluginsdk.ui.tools.a.R(com.tencent.mm.plugin.fav.a.b.b((aca)localObject), ((aca)localObject).wSR, 2))
      {
        AppMethodBeat.o(20511);
        return;
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
    ((Intent)localObject).putExtra("show_share", paramBoolean);
    a(paramacs, (Intent)localObject);
    i.ep("FavoriteFileDetailUI", paramacs.cpW);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
    AppMethodBeat.o(20511);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, acs paramacs)
  {
    AppMethodBeat.i(20517);
    aca localaca = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localaca, paramg))
    {
      AppMethodBeat.o(20517);
      return;
    }
    if ((bo.isNullOrNil(localaca.wST)) || (localaca.wSX <= 0L))
    {
      ab.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localaca.wST, Long.valueOf(localaca.wSX) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).wSJ;
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).wSN;
      }
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramacs);
        AppMethodBeat.o(20517);
        return;
      }
      paramacs = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localaca.cGU);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramacs.putExtra("jsapiargs", (Bundle)localObject2);
      paramacs.putExtra("rawUrl", (String)localObject1);
      paramacs.putExtra("is_favorite_item", true);
      paramacs.putExtra("fav_local_id", paramg.field_localId);
      paramacs.putExtra("geta8key_scene", 14);
      ab.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramacs.putExtra("geta8key_scene", 14);
      com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramacs);
      AppMethodBeat.o(20517);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramacs, (Intent)localObject1);
    i.ep("FavoriteSightDetailUI", paramacs.cpW);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(20517);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, acs paramacs)
  {
    AppMethodBeat.i(20514);
    Object localObject1 = H(paramg);
    if (!bo.isNullOrNil((String)localObject1))
    {
      paramacs = new Intent();
      paramacs.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramacs.putExtra("sns_landig_pages_from_source", 7);
      paramacs.putExtra("sns_landing_pages_share_thumb_url", I(paramg));
      paramacs.putExtra("sns_landing_favid", r.Zn() + "_" + paramg.field_id);
      paramacs.addFlags(268435456);
      com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramacs);
      AppMethodBeat.o(20514);
      return;
    }
    acw localacw = paramg.field_favProto.wVa;
    Object localObject3 = "";
    localObject1 = "";
    Object localObject2 = "";
    if (paramg.field_favProto.wUf != null)
    {
      localObject2 = paramg.field_favProto.wUf;
      localObject3 = ((adf)localObject2).wVF;
      localObject1 = ((adf)localObject2).title;
      localObject2 = ((adf)localObject2).desc;
    }
    Object localObject4 = localObject3;
    if (localacw != null)
    {
      localObject4 = localObject3;
      if (bo.isNullOrNil((String)localObject3)) {
        localObject4 = localacw.link;
      }
    }
    if (bo.isNullOrNil((String)localObject4))
    {
      AppMethodBeat.o(20514);
      return;
    }
    aca localaca = com.tencent.mm.plugin.fav.a.b.c(paramg);
    Object localObject5 = localObject1;
    Object localObject6 = localObject2;
    if (localaca != null)
    {
      localObject3 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject3 = localaca.title;
      }
      localObject5 = localObject3;
      localObject6 = localObject2;
      if (bo.isNullOrNil((String)localObject2))
      {
        localObject6 = localaca.desc;
        localObject5 = localObject3;
      }
    }
    ab.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
    ((Intent)localObject1).putExtra("showShare", paramBoolean);
    ((Intent)localObject1).putExtra("is_favorite_item", true);
    ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
    ((Intent)localObject1).putExtra("favorite_control_argument", paramg.bwn());
    ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
    if ((localacw != null) && (!bo.isNullOrNil(localacw.cmx))) {
      ((Intent)localObject1).putExtra("srcDisplayname", com.tencent.mm.model.s.nE(localacw.cmx));
    }
    ((Intent)localObject1).putExtra("mode", 1);
    ((Intent)localObject1).putExtra("geta8key_scene", 14);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).cGU);
    ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
    ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
    ((Intent)localObject1).putExtra("from_scence", 4);
    localObject2 = "fav_" + r.Zn() + "_" + paramg.field_id;
    ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
    ((Intent)localObject1).putExtra("pre_username", paramg.field_fromUser);
    ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
    ((Intent)localObject1).putExtra("preChatTYPE", 14);
    ((Intent)localObject1).putExtra("share_report_pre_msg_url", (String)localObject4);
    ((Intent)localObject1).putExtra("share_report_pre_msg_title", localObject5);
    ((Intent)localObject1).putExtra("share_report_pre_msg_desc", (String)localObject6);
    ((Intent)localObject1).putExtra("share_report_pre_msg_icon_url", I(paramg));
    ((Intent)localObject1).putExtra("share_report_pre_msg_appid", "");
    ((Intent)localObject1).putExtra("share_report_from_scene", 4);
    localObject2 = com.tencent.mm.modelstat.a.c.uJ(com.tencent.mm.pluginsdk.model.d.class.getName());
    ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
    ((Bundle)localObject2).putInt("key_detail_fav_scene", paramacs.scene);
    ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramacs.kbN);
    ((Bundle)localObject2).putInt("key_detail_fav_index", paramacs.index);
    ((Bundle)localObject2).putString("key_detail_fav_query", paramacs.query);
    ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramacs.cpW);
    ((Bundle)localObject2).putString("key_detail_fav_tags", paramacs.mtm);
    i.ep("WebViewUI", paramacs.cpW);
    ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
    ((Intent)localObject1).putExtra("geta8key_scene", 14);
    if ((paramg.field_favProto.uVl != null) && (paramg.field_favProto.uVl.fgj == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rT(paramg.field_favProto.uVl.fgh)))
    {
      a(paramContext, paramg, paramacs, (Intent)localObject1);
      AppMethodBeat.o(20514);
      return;
    }
    com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    AppMethodBeat.o(20514);
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, acs paramacs)
  {
    AppMethodBeat.i(20518);
    Intent localIntent = new Intent();
    a(paramg, paramacs, localIntent);
    i.ep("FavoriteImgDetailUI", paramacs.cpW);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(20518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */