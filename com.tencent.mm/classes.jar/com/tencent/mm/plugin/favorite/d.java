package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.a.n.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.e.s;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static int[] wTL = { R.h.dyT, R.h.dyU, R.h.dyV, R.h.dyW, R.h.dyX };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.Szr != null) && (!Util.isNullOrNil(paramg.field_favProto.Szr.canvasPageXml)))
    {
      paramg = paramg.field_favProto.Szr.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.syG;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((anm)paramg.get(0)).canvasPageXml;
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
    if ((paramg.field_favProto.Szr != null) && (!Util.isNullOrNil(paramg.field_favProto.Szr.thumbUrl)))
    {
      paramg = paramg.field_favProto.Szr.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.syG;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((anm)paramg.get(0)).lmm;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, Intent paramIntent)
  {
    AppMethodBeat.i(276281);
    paramg = paramg.field_favProto.PTL;
    String str = paramIntent.getStringExtra("rawUrl");
    Log.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramg.SAt != null) {
      paramIntent.putExtra("img_gallery_width", paramg.SAt.width).putExtra("img_gallery_height", paramg.SAt.height).putExtra("img_gallery_left", paramg.SAt.left).putExtra("img_gallery_top", paramg.SAt.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    str = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e(str, 24, 10000, i);
    if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(24)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramContext, str, paramg.llp, 24, 10000, paramIntent))) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      }
      AppMethodBeat.o(276281);
      return;
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, aoe paramaoe)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramaoe, localIntent);
    com.tencent.mm.plugin.fav.a.i.gT("FavRecordDetailUI", paramaoe.sessionId);
    com.tencent.mm.by.c.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, aoe paramaoe, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramaoe, paramIntent);
    paramIntent.putExtra("key_detail_info_id", paramg.field_localId);
    paramIntent.putExtra("key_detail_data_id", paramg.wGj);
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
    anm localanm1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      Log.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      label53:
      localObject1 = null;
      label55:
      if (!(localObject1 instanceof String)) {
        break label1404;
      }
    }
    Object localObject2;
    for (Object localObject1 = (String)localObject1;; localObject1 = null)
    {
      localObject2 = paramg.field_favProto.Szr;
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
          if (!Util.isNullOrNil(((aor)localObject2).title)) {
            paramg = ((aor)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (Util.isNullOrNil(paramg)) {
          localObject1 = localanm1.title;
        }
        parama.brm(paramContext.getResources().getString(R.l.app_app) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        anm localanm2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new q(com.tencent.mm.plugin.fav.a.b.a(localanm2));
          if (((q)localObject1).ifE())
          {
            localObject1 = ((q)localObject1).bOF();
            break label55;
          }
          localObject1 = paramg.field_favProto.Szr;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((aor)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              localObject2 = localanm2.fyu;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.azN((String)localObject2);
            localObject1 = localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(R.k.app_attach_file_icon_webpage);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.Szt;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.azN(((aob)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
            break label55;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.Szv;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.azN(((aol)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              break label55;
            }
            localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
            break label55;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (21 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new q(com.tencent.mm.plugin.fav.a.b.a(localanm2));
          if (((q)localObject1).ifE())
          {
            localObject1 = ((q)localObject1).bOF();
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.azN(localanm2.fyu);
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localanm2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localanm2);
          }
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2)) {
            break label55;
          }
        }
        switch (paramg.field_type)
        {
        default: 
          localObject1 = Integer.valueOf(R.k.app_attach_file_icon_video);
          break;
        case 2: 
          localObject1 = Integer.valueOf(R.g.app_attach_file_icon_pic);
          break;
        case 7: 
          localObject1 = Integer.valueOf(R.k.app_attach_file_icon_music);
          break;
        case 21: 
          localObject1 = Integer.valueOf(R.k.app_attach_file_icon_music);
          break;
          if ((3 == paramg.field_type) || (6 == paramg.field_type)) {
            break label53;
          }
          if (8 == paramg.field_type)
          {
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.boX(localanm2.Syc));
            break;
          }
          if (17 == paramg.field_type)
          {
            bh.beI();
            localObject1 = com.tencent.mm.model.c.bbO().aOU(localanm2.desc);
            if ((((ca.a)localObject1).fcC != null) && (((ca.a)localObject1).fcC.length() != 0))
            {
              localObject1 = new SpannableString(((ca.a)localObject1).fcC);
              break;
            }
            localObject1 = Integer.valueOf(R.g.default_avatar);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.syG == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.syG.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localanm2 = (anm)((Iterator)localObject1).next();
            } while (localanm2.dataType == 1);
            if (localanm2.dataType == 3)
            {
              localObject1 = Integer.valueOf(R.k.app_attach_file_icon_voice);
              break label55;
            }
            if (localanm2.dataType == 6)
            {
              localObject1 = Integer.valueOf(R.k.app_attach_file_icon_location);
              break label55;
            }
            if (localanm2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.boX(localanm2.Syc));
              break label55;
            }
            if ((localanm2.dataType == 2) || (localanm2.dataType == 7) || (localanm2.dataType == 29) || (localanm2.dataType == 15) || (localanm2.dataType == 4))
            {
              localObject1 = new q(com.tencent.mm.plugin.fav.a.b.a(localanm2));
              if (((q)localObject1).ifE())
              {
                localObject1 = ((q)localObject1).bOF();
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.azN(localanm2.fyu);
              if (Util.isNullOrNil((String)localObject1)) {
                switch (localanm2.dataType)
                {
                default: 
                  localObject1 = Integer.valueOf(R.k.app_attach_file_icon_video);
                  break;
                case 2: 
                  localObject1 = Integer.valueOf(R.g.app_attach_file_icon_pic);
                  break;
                case 7: 
                case 29: 
                  localObject1 = Integer.valueOf(R.k.app_attach_file_icon_music);
                  break;
                }
              }
              break label55;
            }
            if (localanm2.dataType == 5)
            {
              localObject1 = new q(com.tencent.mm.plugin.fav.a.b.a(localanm2));
              if (((q)localObject1).ifE())
              {
                localObject1 = ((q)localObject1).bOF();
                break label55;
              }
              localObject1 = localanm2.SyG.Szr;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((aor)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (Util.isNullOrNil((String)localObject1)) {
                  localObject2 = localanm2.fyu;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.azN((String)localObject2);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_webpage);
                break;
              }
            }
            if (localanm2.dataType == 22)
            {
              localObject1 = Integer.valueOf(R.k.icons_outlined_finder_icon);
              break label55;
            }
            if ((localanm2.dataType == 10) || (localanm2.dataType == 11))
            {
              localObject2 = localanm2.SyG.Szt;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.azN(((aob)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                break label55;
              }
            }
            if ((localanm2.dataType == 12) || (localanm2.dataType == 14))
            {
              localObject2 = localanm2.SyG.Szv;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.azN(((aol)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                break label55;
              }
            }
          } while (localanm2.dataType != 16);
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbO().aOU(localanm2.desc);
          if ((((ca.a)localObject1).fcC != null) && (((ca.a)localObject1).fcC.length() != 0))
          {
            localObject1 = new SpannableString(((ca.a)localObject1).fcC);
            break;
          }
          localObject1 = Integer.valueOf(R.g.default_avatar);
          break;
          label1404:
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
      paramg = localanm1.title;
    }
    parama.brm(paramContext.getResources().getString(R.l.app_file) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.brm(paramg.field_favProto.desc);
    parama.hkv();
    parama.a(new d.a.b()
    {
      public final void dml()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", this.wGa.field_favProto.desc);
        com.tencent.mm.by.c.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.la(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.Szp;
    paramg = paramContext.getString(R.l.app_location);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((ant)localObject1).label;
    }
    parama.brm(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!Util.isNullOrNil(((aor)localObject2).title)))
    {
      paramg = ((aor)localObject2).title;
      localObject1 = ((aor)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (Util.isNullOrNil(paramg)) {
        localObject2 = localanm1.title;
      }
      Util.isNullOrNil((String)localObject1);
      parama.brm(paramContext.getResources().getString(R.l.app_url) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.brm(paramContext.getResources().getString(R.l.app_record) + paramg);
      AppMethodBeat.o(24596);
      return;
      parama.m(BitmapUtil.getBitmapNative((String)localObject1), 3);
      AppMethodBeat.o(24596);
      return;
      parama.m(BitmapUtil.getBitmapNative((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      parama.m(BitmapUtil.getBitmapNative((String)localObject1), 2);
      AppMethodBeat.o(24596);
      return;
      localObject1 = paramContext.getResources().getString(R.l.app_note);
      paramContext = l.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.brm((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.SzJ;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(R.l.app_finder) + paramg.desc;; paramContext = paramContext.getString(R.l.app_finder))
      {
        parama.brm(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!Util.isNullOrNil(((aor)localObject2).title)) {
          paramg = ((aor)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (Util.isNullOrNil(paramg)) {
        localObject1 = localanm1.title;
      }
      parama.brm(paramContext.getResources().getString(R.l.app_music) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.SzE != null) {}
      for (paramContext = paramContext.getString(R.l.app_brand_default_name_with_brackets) + paramg.field_favProto.title;; paramContext = paramContext.getString(R.l.app_brand_default_name_with_brackets))
      {
        parama.brm(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(aoe paramaoe, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramaoe.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramaoe.wGA);
    paramIntent.putExtra("key_detail_fav_index", paramaoe.index);
    paramIntent.putExtra("key_detail_fav_query", paramaoe.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramaoe.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramaoe.wGC);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, anm paramanm, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    anp localanp = paramanm.SyM;
    if ((localanp == null) || (Util.isNullOrNil(localanp.lor)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    n.a(n.a.wGS, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramanm);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localanp.lor);
    localIntent.putExtra("StreamWording", localanp.lou);
    localIntent.putExtra("StremWebUrl", localanp.lov);
    localIntent.putExtra("KThumUrl", localanp.low);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localanp.lox);
    localIntent.putExtra("KSta_StremVideoPublishId", localanp.loy);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", n.b.wHc.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramanm.fUk);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localanp.SAk);
    localIntent.putExtra("KMediaTitle", localanp.lot);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuU, 0) > 0)
    {
      com.tencent.mm.by.c.b(paramContext, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.FavItemLogic", "use new stream video play UI");
    }
    for (;;)
    {
      AppMethodBeat.o(24591);
      return true;
      com.tencent.mm.by.c.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  private static boolean a(Context paramContext, anm paramanm, boolean paramBoolean)
  {
    AppMethodBeat.i(276284);
    if ((paramanm == null) || (paramanm.SyG == null) || (paramanm.SyG.SzH == null))
    {
      Log.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(276284);
      return false;
    }
    paramBoolean = s.a(paramContext, paramanm.SyG.SzH, paramanm, paramBoolean);
    AppMethodBeat.o(276284);
    return paramBoolean;
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, aoe paramaoe)
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
    Object localObject2;
    Object localObject3;
    Object localObject4;
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
      ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.djA());
      ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
      if (paramg.field_sourceCreateTime <= 0L) {}
      for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
      {
        ((Intent)localObject1).putExtra("key_detail_create_time", l);
        a(paramaoe, (Intent)localObject1);
        com.tencent.mm.plugin.fav.a.i.gT("FavoriteTextDetailUI", paramaoe.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
      }
    case 2: 
      e(paramContext, paramg, paramaoe);
      AppMethodBeat.o(24581);
      return;
    case 3: 
      localObject1 = new Intent();
      a(paramg, paramaoe, (Intent)localObject1);
      ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.SAB.createTime);
      com.tencent.mm.plugin.fav.a.i.gT("FavoriteVoiceDetailUI", paramaoe.sessionId);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
      AppMethodBeat.o(24581);
      return;
    case 16: 
      localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      if ((localObject1 != null) && (((anm)localObject1).SyM != null) && ((!Util.isNullOrNil(((anm)localObject1).SyM.lor)) || (!Util.isNullOrNil(((anm)localObject1).SyM.lov))))
      {
        Log.i("MicroMsg.FavItemLogic", "it is ad sight.");
        c(paramContext, paramg, paramaoe);
        AppMethodBeat.o(24581);
        return;
      }
      d(paramContext, paramg, paramaoe);
      AppMethodBeat.o(24581);
      return;
    case 4: 
      d(paramContext, paramg, paramaoe);
      AppMethodBeat.o(24581);
      return;
    case 5: 
      d(paramContext, paramg, true, paramaoe);
      AppMethodBeat.o(24581);
      return;
    case 6: 
      if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      localObject2 = paramg.field_favProto.Szp;
      localObject3 = paramg.field_favProto.remark;
      localObject1 = paramg.field_favProto.SAB;
      if ((localObject1 != null) && (!Util.isNullOrNil(((aoi)localObject1).SAb))) {}
      for (localObject1 = aa.PJ(((aoi)localObject1).SAb);; localObject1 = aa.PJ(paramg.field_fromUser))
      {
        localObject4 = new ArrayList();
        if (paramg.field_tagProto.SAP != null) {
          ((ArrayList)localObject4).addAll(paramg.field_tagProto.SAP);
        }
        com.tencent.mm.plugin.fav.a.i.gT("RedirectUI", paramaoe.sessionId);
        com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (ant)localObject2, (String)localObject1, (String)localObject3, (ArrayList)localObject4, paramContext);
        AppMethodBeat.o(24581);
        return;
      }
    case 7: 
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      localObject2 = paramg.field_favProto.SAB;
      localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramaoe = new q(com.tencent.mm.plugin.fav.a.b.a((anm)localObject1));
      if (!paramaoe.ifE()) {
        if (((anm)localObject1).fyu == null)
        {
          paramaoe = "";
          paramaoe = com.tencent.mm.bb.i.a(6, null, ((anm)localObject1).title, ((anm)localObject1).desc, ((anm)localObject1).SxU, ((anm)localObject1).SxY, ((anm)localObject1).SxW, ((anm)localObject1).fEa, com.tencent.mm.plugin.fav.a.b.djr(), paramaoe, "", ((aoi)localObject2).appId);
          paramaoe.lVK = ((anm)localObject1).songAlbumUrl;
          paramaoe.lVC = ((anm)localObject1).songLyric;
          paramaoe.lVU = ((anm)localObject1).fEa;
          if (com.tencent.mm.plugin.fav.a.b.f((anm)localObject1)) {
            break label958;
          }
          Log.i("MicroMsg.FavItemLogic", " start play music");
          com.tencent.mm.bb.a.c(paramaoe);
        }
      }
      for (;;)
      {
        paramaoe.lVR = String.valueOf(paramg.field_localId);
        paramg = new Intent();
        paramg.putExtra("key_scene", 2);
        paramg.setFlags(268435456);
        com.tencent.mm.by.c.b(paramContext, "music", ".ui.MusicMainUI", paramg);
        AppMethodBeat.o(24581);
        return;
        paramaoe = new q(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(((anm)localObject1).fyu.getBytes()));
        if (paramaoe.ifE()) {}
        for (paramaoe = paramaoe.bOF();; paramaoe = "") {
          break;
        }
        paramaoe = paramaoe.bOF();
        break;
        Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
      }
    case 21: 
      label958:
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      if (((ak)com.tencent.mm.kernel.h.ag(ak.class)).canEnterMvAndShowToast())
      {
        localObject3 = paramg.field_favProto.SAB;
        localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramaoe = new q(com.tencent.mm.plugin.fav.a.b.a((anm)localObject2));
        if (paramaoe.ifE()) {
          break label1573;
        }
        if (((anm)localObject2).fyu != null) {
          break label1513;
        }
        paramaoe = "";
        if ((localObject2 == null) || (((anm)localObject2).SyG == null)) {
          break label2247;
        }
      }
      break;
    }
    label1573:
    label2247:
    for (Object localObject1 = ((anm)localObject2).SyG.SzR;; localObject1 = null)
    {
      for (;;)
      {
        localObject4 = new dbr();
        if (localObject1 != null) {}
        try
        {
          ((dbr)localObject4).parseFrom(((dbr)localObject1).toByteArray());
          paramaoe = com.tencent.mm.bb.i.a(6, null, ((anm)localObject2).title, ((anm)localObject2).desc, ((anm)localObject2).SxU, ((anm)localObject2).SxY, ((anm)localObject2).SxW, ((anm)localObject2).fEa, com.tencent.mm.plugin.fav.a.b.djr(), paramaoe, "", ((aoi)localObject3).appId, com.tencent.mm.bb.h.a(((anm)localObject2).fEa, (dbr)localObject4));
          paramaoe.lVK = ((anm)localObject2).songAlbumUrl;
          paramaoe.lVC = ((anm)localObject2).songLyric;
          paramaoe.lVU = ((anm)localObject2).fEa;
          if (!com.tencent.mm.plugin.fav.a.b.f((anm)localObject2))
          {
            Log.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.bb.a.c(paramaoe);
            paramaoe.lVR = String.valueOf(paramg.field_localId);
            paramg = new Intent();
            paramg.putExtra("key_scene", 2);
            paramg.setFlags(268435456);
            if (localObject1 != null)
            {
              paramg.putExtra("key_mv_feed_id", ((dbr)localObject1).Ruu);
              paramg.putExtra("key_mv_nonce_id", ((dbr)localObject1).Ruv);
              paramg.putExtra("key_mv_cover_url", ((dbr)localObject1).Ruw);
              paramg.putExtra("key_mv_poster", ((dbr)localObject1).Rux);
              paramg.putExtra("key_mv_song_name", ((anm)localObject2).title);
              paramg.putExtra("key_mv_song_lyric", ((anm)localObject2).songLyric);
              paramg.putExtra("key_mv_album_cover_url", ((anm)localObject2).songAlbumUrl);
              paramg.putExtra("key_mv_singer_name", ((dbr)localObject1).singerName);
              paramg.putExtra("key_mv_album_name", ((dbr)localObject1).albumName);
              paramg.putExtra("key_mv_music_genre", ((dbr)localObject1).musicGenre);
              paramg.putExtra("key_mv_issue_date", String.valueOf(((dbr)localObject1).issueDate));
              paramg.putExtra("key_mv_identification", ((dbr)localObject1).identification);
              paramg.putExtra("key_mv_extra_info", ((dbr)localObject1).extraInfo);
              paramg.putExtra("key_mv_music_duration", ((dbr)localObject1).FSG);
              paramg.putExtra("key_mv_thumb_path", ((dbr)localObject1).lVZ);
            }
            paramaoe = com.tencent.mm.plugin.secdata.ui.a.JbV;
            paramaoe = (dbs)a.a.a(paramContext, "MusicMvMainUI", 7, dbs.class);
            paramaoe.scene = 9;
            localObject1 = com.tencent.mm.plugin.comm.a.ubo;
            paramaoe.wmL = com.tencent.mm.plugin.comm.a.cPn();
            paramaoe.TIZ = 84;
            paramaoe.TJa = ((anm)localObject2).fEa;
            com.tencent.mm.by.c.b(paramContext, "mv", ".ui.MusicMvMainUI", paramg);
            AppMethodBeat.o(24581);
            return;
            label1513:
            paramaoe = new q(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(((anm)localObject2).fyu.getBytes()));
            if (paramaoe.ifE()) {}
            for (paramaoe = paramaoe.bOF();; paramaoe = "") {
              break;
            }
            paramaoe = paramaoe.bOF();
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("MicroMsg.FavItemLogic", "message:" + localIOException.getMessage());
            continue;
            Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
          }
        }
      }
      c(paramContext, paramg, true, paramaoe);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      b.a(paramContext, paramg.field_localId, paramg.field_favProto.Szt.fTp);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      b.b(paramContext, paramg.field_localId, paramg.field_favProto.Szv.fTp);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramaoe = new Intent();
      paramaoe.putExtra("key_product_scene", 4);
      paramaoe.putExtra("key_product_info", paramg.field_favProto.Szt.fTp);
      com.tencent.mm.by.c.b(paramContext, "product", ".ui.MallProductUI", paramaoe);
      AppMethodBeat.o(24581);
      return;
      a(paramContext, paramg, true, paramaoe);
      AppMethodBeat.o(24581);
      return;
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
      bh.beI();
      paramg = com.tencent.mm.model.c.bbO().aOU(paramg);
      if (paramg == null) {
        break;
      }
      if ((!ab.Qm(paramg.fcC)) || (WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext)))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramg.fcC);
        ((Intent)localObject1).putExtra("Contact_Alias", paramg.idS);
        ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
        ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.mXq);
        ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.mXp);
        ((Intent)localObject1).putExtra("Contact_Uin", paramg.GZN);
        ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.VGG);
        ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.VGH);
        ((Intent)localObject1).putExtra("Contact_QQNick", paramg.hAp());
        ((Intent)localObject1).putExtra("User_From_Fmessage", false);
        ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
        ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.mXu);
        ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.PKJ);
        ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.verifyInfo);
        ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.GXB);
        ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
        ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
        ((Intent)localObject1).putExtra("Contact_Sex", paramg.sex);
        ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
        ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
        ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
        com.tencent.mm.plugin.fav.a.i.gT("ContactInfoUI", paramaoe.sessionId);
        com.tencent.mm.by.c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
        com.tencent.mm.bz.a.are(paramg.scene);
      }
      AppMethodBeat.o(24581);
      return;
      b(paramContext, paramg, true, paramaoe);
      AppMethodBeat.o(24581);
      return;
      Toast.makeText(paramContext, R.l.favorite_unknown_type, 0).show();
      AppMethodBeat.o(24581);
      return;
    }
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, aoe paramaoe)
  {
    AppMethodBeat.i(24583);
    Log.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    oz localoz = new oz();
    localoz.fNG.field_localId = paramg.field_localId;
    Object localObject;
    if ((!Util.isNullOrNil(paramg.wGj)) && (paramg.field_favProto != null) && (paramg.field_favProto.syG != null) && (paramg.field_favProto.syG.size() > 0))
    {
      localObject = paramg.field_favProto.syG.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label399;
      }
      if (!Util.isEqual(((anm)((Iterator)localObject).next()).fEa, paramg.wGj)) {
        break label350;
      }
    }
    label384:
    label399:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localoz.fNG.fNJ) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localoz.fNG;
          ((oz.a)localObject).fNJ -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label384;
        }
        localoz.fNG.fNP = 4;
      }
      for (;;)
      {
        localoz.fNG.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.RDh;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((anw)localObject).SAu);
          paramContext.putString("noteeditor", ((anw)localObject).SAv);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localoz.fNG.fNN = paramContext;
        localoz.fNG.field_favProto = paramg.field_favProto;
        localoz.fNG.type = 2;
        localoz.fNG.fNQ = paramBoolean;
        localoz.fNG.fNR = paramaoe;
        EventCenter.instance.publish(localoz);
        com.tencent.mm.plugin.fav.a.i.gT("NoteEditorUI", paramaoe.sessionId);
        AppMethodBeat.o(24583);
        return;
        label350:
        oz.a locala = localoz.fNG;
        locala.fNJ += 1;
        break;
        localoz.fNG.fNJ = 0;
        break label190;
        localoz.fNG.fNI = paramg.field_xml;
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
    final anm localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24574);
          d.f(this.val$context, paramg, new aoe());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", this.wGa.field_favProto.desc);
          com.tencent.mm.by.c.f(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.la(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24576);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          if (this.wTM != null)
          {
            localIntent.putExtra("kwebmap_slat", this.wTM.lat);
            localIntent.putExtra("kwebmap_lng", this.wTM.lng);
            localIntent.putExtra("Kwebmap_locaion", this.wTM.label);
          }
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.by.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(24576);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24577);
          d.g(this.val$context, paramg, new aoe());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24578);
          d.h(this.val$context, paramg, new aoe());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.wGa.field_localId);
          localIntent.putExtra("key_detail_data_id", localanm.fEa);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24580);
          anm localanm = com.tencent.mm.plugin.fav.a.b.c(this.wGa);
          if (localanm == null)
          {
            Log.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.b(paramContext, localanm))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localanm.SyM != null) && ((!Util.isNullOrNil(localanm.SyM.lor)) || (!Util.isNullOrNil(localanm.SyM.lov))))
          {
            Log.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", this.wGa.field_localId);
            localIntent.putExtra("key_detail_data_id", localanm.fEa);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.wGa.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localanm));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localanm));
          localIntent.putExtra("key_detail_fav_video_duration", localanm.duration);
          localIntent.putExtra("key_detail_statExtStr", localanm.fUk);
          localIntent.putExtra("key_detail_msg_uuid", localanm.mic);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(24572);
          d.i(this.val$context, paramg, new aoe());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(163190);
          bje localbje = this.wGa.field_favProto.SzJ;
          if (localbje != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.wKG;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localbje);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, aoe paramaoe)
  {
    AppMethodBeat.i(24590);
    n.a(n.a.wGQ, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramaoe, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, aoe paramaoe)
  {
    AppMethodBeat.i(24584);
    anm localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramaoe != null) && (paramaoe.fWQ == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!Util.isNullOrNil(paramg.wGj))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.wGj);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramaoe, (Intent)localObject);
        com.tencent.mm.plugin.fav.a.i.gT("FavoriteFileDetailUI", paramaoe.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramaoe != null) && (paramaoe.fWQ == 2))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d(localanm), localanm.Syc, 2);
      AppMethodBeat.o(24584);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.g(localanm))
    {
      if (com.tencent.mm.plugin.fav.a.b.h(localanm))
      {
        e(paramContext, paramg, paramaoe);
        AppMethodBeat.o(24584);
        return;
      }
      if (paramg == null) {
        break label343;
      }
    }
    label343:
    for (Object localObject = String.valueOf(paramg.field_id);; localObject = null)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.fromFavItem(localanm, (String)localObject, null, com.tencent.mm.plugin.fav.a.b.d(localanm)));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.bg(com.tencent.mm.plugin.fav.a.b.d(localanm), localanm.Syc, localanm.title))
      {
        AppMethodBeat.o(24584);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("key_detail_data_id", localanm.fEa);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      a(paramaoe, (Intent)localObject);
      com.tencent.mm.plugin.fav.a.i.gT("FavoriteFileDetailUI", paramaoe.sessionId);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
      AppMethodBeat.o(24584);
      return;
    }
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, aoe paramaoe)
  {
    AppMethodBeat.i(24592);
    anm localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localanm, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (a(paramContext, localanm, false))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((Util.isNullOrNil(localanm.Sye)) || (localanm.Syi <= 0L))
    {
      Log.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localanm.Sye, Long.valueOf(localanm.Syi) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).SxU;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).SxY;
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramaoe);
        AppMethodBeat.o(24592);
        return;
      }
      paramaoe = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localanm.fUk);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramaoe.putExtra("jsapiargs", (Bundle)localObject2);
      paramaoe.putExtra("rawUrl", (String)localObject1);
      paramaoe.putExtra("is_favorite_item", true);
      paramaoe.putExtra("fav_local_id", paramg.field_localId);
      paramaoe.putExtra("geta8key_scene", 14);
      Log.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramaoe.putExtra("geta8key_scene", 14);
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramaoe);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramaoe, (Intent)localObject1);
    com.tencent.mm.plugin.fav.a.i.gT("FavoriteSightDetailUI", paramaoe.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, aoe paramaoe)
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
      paramaoe = new Intent();
      paramaoe.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramaoe.putExtra("sns_landig_pages_from_source", 7);
      paramaoe.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramaoe.putExtra("sns_landing_favid", z.bcZ() + "_" + paramg.field_id);
      paramaoe.addFlags(268435456);
      com.tencent.mm.by.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramaoe);
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject2 = paramg.field_favProto.Szr;
    if ((localObject2 != null) && (((aor)localObject2).SBi) && (!Util.isNullOrNil(((aor)localObject2).SBh)))
    {
      paramg = XmlParser.parseXml(((aor)localObject2).SBh, "websearch", null);
      if (paramg == null)
      {
        Log.e("MicroMsg.FavItemLogic", "XmlParser.parseXml fail, values is null");
        AppMethodBeat.o(24587);
        return;
      }
      paramaoe = new flm();
      paramaoe.PyQ = ((String)paramg.get(".websearch.relevant_vid"));
      paramaoe.PyR = ((String)paramg.get(".websearch.relevant_expand"));
      paramaoe.PyS = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramaoe.PyT = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramaoe.PyU = Util.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramaoe.vhY = ((String)paramg.get(".websearch.shareUrl"));
      paramaoe.pqW = ((String)paramg.get(".websearch.shareTitle"));
      paramaoe.CHR = ((String)paramg.get(".websearch.shareDesc"));
      paramaoe.PyV = ((String)paramg.get(".websearch.shareImgUrl"));
      paramaoe.PyW = ((String)paramg.get(".websearch.shareString"));
      paramaoe.PyX = ((String)paramg.get(".websearch.shareStringUrl"));
      paramaoe.source = ((String)paramg.get(".websearch.source"));
      paramaoe.fVx = ((String)paramg.get(".websearch.sourceUrl"));
      paramaoe.PyY = ((String)paramg.get(".websearch.strPlayCount"));
      paramaoe.PyZ = ((String)paramg.get(".websearch.titleUrl"));
      paramaoe.Pza = ((String)paramg.get(".websearch.extReqParams"));
      paramaoe.Pzb = ((String)paramg.get(".websearch.tagList"));
      paramaoe.Pzc = Util.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramaoe.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramaoe.Pzd = ((String)paramg.get(".websearch.shareTag"));
      ai.a(paramContext, com.tencent.mm.plugin.topstory.a.h.a(paramaoe, 326, paramContext.getString(R.l.topstory)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localObject2 != null)
    {
      localObject3 = ((aor)localObject2).SBc;
      localObject1 = ((aor)localObject2).title;
    }
    for (localObject2 = ((aor)localObject2).desc;; localObject2 = "")
    {
      aoi localaoi = paramg.field_favProto.SAB;
      Object localObject4 = localObject3;
      if (localaoi != null)
      {
        localObject4 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject4 = localaoi.link;
        }
      }
      Object localObject5 = localObject4;
      if (Util.isNullOrNil((String)localObject4)) {
        if (paramg.field_favProto.syG.size() <= 0) {
          break label754;
        }
      }
      label754:
      for (localObject3 = ((anm)paramg.field_favProto.syG.get(0)).SxU;; localObject3 = null)
      {
        localObject5 = localObject3;
        if (!Util.isNullOrNil(localObject5)) {
          break;
        }
        Log.w("MicroMsg.FavItemLogic", "go to web page error, url null, dataid[%s]", new Object[] { paramg.wGj });
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.h.ag(PluginFavOffline.class)).useOffline(localObject5, paramg.field_localId))
      {
        Log.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject5 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.h.ag(PluginFavOffline.class)).getFavOfflineService().aAi(localObject5);
      anm localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      localObject4 = localObject1;
      if (localanm != null)
      {
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = localanm.title;
        }
        localObject6 = localObject2;
        localObject4 = localObject3;
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject6 = localanm.desc;
          localObject4 = localObject3;
        }
      }
      Log.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", localObject5);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.djC());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("webpageTitle", (String)localObject4);
      if ((localaoi != null) && (!Util.isNullOrNil(localaoi.fuO))) {
        ((Intent)localObject1).putExtra("srcDisplayname", aa.PJ(localaoi.fuO));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).fUk);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + z.bcZ() + "_" + paramg.field_id;
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
      localObject2 = com.tencent.mm.modelstat.a.c.Xs(com.tencent.mm.pluginsdk.model.i.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramaoe.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramaoe.wGA);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramaoe.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramaoe.query);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramaoe.sessionId);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramaoe.wGC);
      com.tencent.mm.plugin.fav.a.i.gT("WebViewUI", paramaoe.sessionId);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      ((Intent)localObject1).putExtra("key_enable_teen_mode_check", true);
      if ((paramg.field_favProto.PTL != null) && (paramg.field_favProto.PTL.llr == 1) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gv(paramg.field_favProto.PTL.llp)))
      {
        a(paramContext, paramg, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
      }
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, aoe paramaoe)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramaoe, localIntent);
    com.tencent.mm.plugin.fav.a.i.gT("FavoriteImgDetailUI", paramaoe.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */