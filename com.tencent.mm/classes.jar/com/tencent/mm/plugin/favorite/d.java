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
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.autogen.a.ql.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.a.n.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.fav.ui.l.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.widget.a.e.a.b;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static int[] Aqo = { R.h.fzE, R.h.fzF, R.h.fzG, R.h.fzH, R.h.fzI };
  
  private static String J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24585);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(24585);
      return null;
    }
    if ((paramg.field_favProto.ZAj != null) && (!Util.isNullOrNil(paramg.field_favProto.ZAj.canvasPageXml)))
    {
      paramg = paramg.field_favProto.ZAj.canvasPageXml;
      AppMethodBeat.o(24585);
      return paramg;
    }
    paramg = paramg.field_favProto.vEn;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((arf)paramg.get(0)).canvasPageXml;
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
    if ((paramg.field_favProto.ZAj != null) && (!Util.isNullOrNil(paramg.field_favProto.ZAj.thumbUrl)))
    {
      paramg = paramg.field_favProto.ZAj.thumbUrl;
      AppMethodBeat.o(24586);
      return paramg;
    }
    paramg = paramg.field_favProto.vEn;
    if ((paramg != null) && (paramg.size() == 1))
    {
      paramg = ((arf)paramg.get(0)).nRr;
      AppMethodBeat.o(24586);
      return paramg;
    }
    AppMethodBeat.o(24586);
    return null;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, Intent paramIntent)
  {
    AppMethodBeat.i(261534);
    paramg = paramg.field_favProto.WKx;
    String str = paramIntent.getStringExtra("rawUrl");
    Log.i("MicroMsg.FavItemLogic", "jump to native video");
    if (paramg.ZBl != null) {
      paramIntent.putExtra("img_gallery_width", paramg.ZBl.width).putExtra("img_gallery_height", paramg.ZBl.height).putExtra("img_gallery_left", paramg.ZBl.left).putExtra("img_gallery_top", paramg.ZBl.top);
    }
    paramIntent.addFlags(268435456);
    int i = (int)(System.currentTimeMillis() / 1000L);
    str = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e(str, 24, 10000, i);
    if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(24)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramContext, str, paramg.nQm, 24, 10000, paramIntent))) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      }
      AppMethodBeat.o(261534);
      return;
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, arx paramarx)
  {
    AppMethodBeat.i(24582);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    localIntent.putExtra("prePublishId", "msgrecord_detail");
    localIntent.putExtra("preChatTYPE", 15);
    a(paramarx, localIntent);
    com.tencent.mm.plugin.fav.a.i.hC("FavRecordDetailUI", paramarx.sessionId);
    com.tencent.mm.br.c.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
    AppMethodBeat.o(24582);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, arx paramarx, Intent paramIntent)
  {
    AppMethodBeat.i(24594);
    a(paramarx, paramIntent);
    paramIntent.putExtra("key_detail_info_id", paramg.field_localId);
    paramIntent.putExtra("key_detail_data_id", paramg.Acs);
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
    arf localarf1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
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
      localObject2 = paramg.field_favProto.ZAj;
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
          if (!Util.isNullOrNil(((ask)localObject2).title)) {
            paramg = ((ask)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (Util.isNullOrNil(paramg)) {
          localObject1 = localarf1.title;
        }
        parama.bra(paramContext.getResources().getString(R.l.app_app) + (String)localObject1);
        AppMethodBeat.o(24596);
        return;
        arf localarf2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new u(com.tencent.mm.plugin.fav.a.b.a(localarf2));
          if (((u)localObject1).jKS())
          {
            localObject1 = ah.v(((u)localObject1).jKT());
            break label55;
          }
          localObject1 = paramg.field_favProto.ZAj;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((ask)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              localObject2 = localarf2.hDd;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.atT((String)localObject2);
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
          localObject1 = paramg.field_favProto.ZAl;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.atT(((aru)localObject1).thumbUrl);
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
          localObject1 = paramg.field_favProto.ZAn;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.atT(((ase)localObject1).thumbUrl);
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
          localObject1 = new u(com.tencent.mm.plugin.fav.a.b.a(localarf2));
          if (((u)localObject1).jKS())
          {
            localObject1 = ah.v(((u)localObject1).jKT());
            break label55;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.atT(localarf2.hDd);
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localarf2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.a(localarf2);
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
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.boR(localarf2.ZyU));
            break;
          }
          if (17 == paramg.field_type)
          {
            bh.bCz();
            localObject1 = com.tencent.mm.model.c.bzD().aLU(localarf2.desc);
            if ((((cc.a)localObject1).hgk != null) && (((cc.a)localObject1).hgk.length() != 0))
            {
              localObject1 = new SpannableString(((cc.a)localObject1).hgk);
              break;
            }
            localObject1 = Integer.valueOf(R.g.default_avatar);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.vEn == null)) {
            break label53;
          }
          localObject1 = paramg.field_favProto.vEn.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localarf2 = (arf)((Iterator)localObject1).next();
            } while (localarf2.dataType == 1);
            if (localarf2.dataType == 3)
            {
              localObject1 = Integer.valueOf(R.k.app_attach_file_icon_voice);
              break label55;
            }
            if (localarf2.dataType == 6)
            {
              localObject1 = Integer.valueOf(R.k.app_attach_file_icon_location);
              break label55;
            }
            if (localarf2.dataType == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.f.boR(localarf2.ZyU));
              break label55;
            }
            if ((localarf2.dataType == 2) || (localarf2.dataType == 7) || (localarf2.dataType == 29) || (localarf2.dataType == 15) || (localarf2.dataType == 4))
            {
              localObject1 = new u(com.tencent.mm.plugin.fav.a.b.a(localarf2));
              if (((u)localObject1).jKS())
              {
                localObject1 = ah.v(((u)localObject1).jKT());
                break label55;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.atT(localarf2.hDd);
              if (Util.isNullOrNil((String)localObject1)) {
                switch (localarf2.dataType)
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
            if (localarf2.dataType == 5)
            {
              localObject1 = new u(com.tencent.mm.plugin.fav.a.b.a(localarf2));
              if (((u)localObject1).jKS())
              {
                localObject1 = ah.v(((u)localObject1).jKT());
                break label55;
              }
              localObject1 = localarf2.Zzy.ZAj;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((ask)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (Util.isNullOrNil((String)localObject1)) {
                  localObject2 = localarf2.hDd;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.atT((String)localObject2);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_webpage);
                break;
              }
            }
            if (localarf2.dataType == 22)
            {
              localObject1 = Integer.valueOf(R.k.icons_outlined_finder_icon);
              break label55;
            }
            if ((localarf2.dataType == 10) || (localarf2.dataType == 11))
            {
              localObject2 = localarf2.Zzy.ZAl;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.atT(((aru)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                break label55;
              }
            }
            if ((localarf2.dataType == 12) || (localarf2.dataType == 14))
            {
              localObject2 = localarf2.Zzy.ZAn;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.atT(((ase)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label55;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                break label55;
              }
            }
          } while (localarf2.dataType != 16);
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aLU(localarf2.desc);
          if ((((cc.a)localObject1).hgk != null) && (((cc.a)localObject1).hgk.length() != 0))
          {
            localObject1 = new SpannableString(((cc.a)localObject1).hgk);
            break;
          }
          localObject1 = Integer.valueOf(R.g.default_avatar);
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
      paramg = localarf1.title;
    }
    parama.bra(paramContext.getResources().getString(R.l.app_file) + paramg);
    AppMethodBeat.o(24596);
    return;
    parama.bra(paramg.field_favProto.desc);
    parama.iLm();
    parama.a(new e.a.b()
    {
      public final void dTb()
      {
        AppMethodBeat.i(24573);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", d.this.field_favProto.desc);
        com.tencent.mm.br.c.g(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
        com.tencent.mm.ui.base.b.ne(paramContext);
        AppMethodBeat.o(24573);
      }
    });
    AppMethodBeat.o(24596);
    return;
    localObject1 = paramg.field_favProto.ZAh;
    paramg = paramContext.getString(R.l.app_location);
    paramContext = paramg;
    if (localObject1 != null) {
      paramContext = paramg + ((arm)localObject1).label;
    }
    parama.bra(paramContext);
    AppMethodBeat.o(24596);
    return;
    if ((localObject2 != null) && (!Util.isNullOrNil(((ask)localObject2).title)))
    {
      paramg = ((ask)localObject2).title;
      localObject1 = ((ask)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (Util.isNullOrNil(paramg)) {
        localObject2 = localarf1.title;
      }
      Util.isNullOrNil((String)localObject1);
      parama.bra(paramContext.getResources().getString(R.l.app_url) + (String)localObject2);
      AppMethodBeat.o(24596);
      return;
      paramg = l.a.a(paramContext, paramg).title;
      parama.bra(paramContext.getResources().getString(R.l.app_record) + paramg);
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
      parama.bra((String)localObject1 + paramContext);
      AppMethodBeat.o(24596);
      return;
      paramg = paramg.field_favProto.ZAB;
      if (paramg != null) {}
      for (paramContext = paramContext.getString(R.l.app_finder) + paramg.desc;; paramContext = paramContext.getString(R.l.app_finder))
      {
        parama.bra(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!Util.isNullOrNil(((ask)localObject2).title)) {
          paramg = ((ask)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (Util.isNullOrNil(paramg)) {
        localObject1 = localarf1.title;
      }
      parama.bra(paramContext.getResources().getString(R.l.app_music) + (String)localObject1);
      AppMethodBeat.o(24596);
      return;
      if (paramg.field_favProto.ZAw != null) {}
      for (paramContext = paramContext.getString(R.l.app_brand_default_name_with_brackets) + paramg.field_favProto.title;; paramContext = paramContext.getString(R.l.app_brand_default_name_with_brackets))
      {
        parama.bra(paramContext);
        AppMethodBeat.o(24596);
        return;
      }
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(arx paramarx, Intent paramIntent)
  {
    AppMethodBeat.i(24595);
    paramIntent.putExtra("key_detail_fav_scene", paramarx.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramarx.AcJ);
    paramIntent.putExtra("key_detail_fav_index", paramarx.index);
    paramIntent.putExtra("key_detail_fav_query", paramarx.query);
    paramIntent.putExtra("key_detail_fav_sessionid", paramarx.sessionId);
    paramIntent.putExtra("key_detail_fav_tags", paramarx.AcL);
    AppMethodBeat.o(24595);
  }
  
  private static boolean a(Context paramContext, arf paramarf, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24591);
    ari localari = paramarf.ZzE;
    if ((localari == null) || (Util.isNullOrNil(localari.nTu)))
    {
      AppMethodBeat.o(24591);
      return false;
    }
    n.a(n.a.Adb, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.a(paramarf);
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", localari.nTu);
    localIntent.putExtra("StreamWording", localari.nTx);
    localIntent.putExtra("StremWebUrl", localari.nTy);
    localIntent.putExtra("KThumUrl", localari.nTz);
    localIntent.putExtra("KSta_StremVideoAduxInfo", localari.nTA);
    localIntent.putExtra("KSta_StremVideoPublishId", localari.nTB);
    localIntent.putExtra("KSta_SourceType", 2);
    localIntent.putExtra("KSta_Scene", n.b.Adl.value);
    localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
    localIntent.putExtra("KSta_FavID", paramg.field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", paramarf.iah);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaVideoTime", localari.ZBc);
    localIntent.putExtra("KMediaTitle", localari.nTw);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHP, 0) > 0)
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
  
  private static boolean a(Context paramContext, arf paramarf, boolean paramBoolean)
  {
    AppMethodBeat.i(261548);
    if ((paramarf == null) || (paramarf.Zzy == null) || (paramarf.Zzy.ZAz == null))
    {
      Log.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
      AppMethodBeat.o(261548);
      return false;
    }
    paramBoolean = s.a(paramContext, paramarf.Zzy.ZAz, paramarf, paramBoolean);
    AppMethodBeat.o(261548);
    return paramBoolean;
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, arx paramarx)
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
    ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fav.a.ab.class)).c(Long.valueOf(paramg.field_localId));
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
      ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.dQl());
      ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
      if (paramg.field_sourceCreateTime <= 0L) {}
      for (long l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
      {
        ((Intent)localObject1).putExtra("key_detail_create_time", l);
        a(paramarx, (Intent)localObject1);
        com.tencent.mm.plugin.fav.a.i.hC("FavoriteTextDetailUI", paramarx.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
        AppMethodBeat.o(24581);
        return;
      }
    case 2: 
      e(paramContext, paramg, paramarx);
      AppMethodBeat.o(24581);
      return;
    case 3: 
      localObject1 = new Intent();
      a(paramg, paramarx, (Intent)localObject1);
      ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.ZBt.createTime);
      com.tencent.mm.plugin.fav.a.i.hC("FavoriteVoiceDetailUI", paramarx.sessionId);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
      AppMethodBeat.o(24581);
      return;
    case 16: 
      localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      if ((localObject1 != null) && (((arf)localObject1).ZzE != null) && ((!Util.isNullOrNil(((arf)localObject1).ZzE.nTu)) || (!Util.isNullOrNil(((arf)localObject1).ZzE.nTy))))
      {
        Log.i("MicroMsg.FavItemLogic", "it is ad sight.");
        c(paramContext, paramg, paramarx);
        AppMethodBeat.o(24581);
        return;
      }
      d(paramContext, paramg, paramarx);
      AppMethodBeat.o(24581);
      return;
    case 4: 
      d(paramContext, paramg, paramarx);
      AppMethodBeat.o(24581);
      return;
    case 5: 
      d(paramContext, paramg, true, paramarx);
      AppMethodBeat.o(24581);
      return;
    case 6: 
      if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      localObject2 = paramg.field_favProto.ZAh;
      localObject3 = paramg.field_favProto.remark;
      localObject1 = paramg.field_favProto.ZBt;
      if ((localObject1 != null) && (!Util.isNullOrNil(((asb)localObject1).ZAT))) {}
      for (localObject1 = aa.getDisplayName(((asb)localObject1).ZAT);; localObject1 = aa.getDisplayName(paramg.field_fromUser))
      {
        localObject4 = new ArrayList();
        if (paramg.field_tagProto.ZBH != null) {
          ((ArrayList)localObject4).addAll(paramg.field_tagProto.ZBH);
        }
        com.tencent.mm.plugin.fav.a.i.hC("RedirectUI", paramarx.sessionId);
        com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (arm)localObject2, (String)localObject1, (String)localObject3, (ArrayList)localObject4, paramContext);
        AppMethodBeat.o(24581);
        return;
      }
    case 7: 
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      localObject2 = paramg.field_favProto.ZBt;
      localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramarx = new u(com.tencent.mm.plugin.fav.a.b.a((arf)localObject1));
      if (!paramarx.jKS()) {
        if (((arf)localObject1).hDd == null)
        {
          paramarx = "";
          paramarx = com.tencent.mm.aw.i.a(6, null, ((arf)localObject1).title, ((arf)localObject1).desc, ((arf)localObject1).ZyM, ((arf)localObject1).ZyQ, ((arf)localObject1).ZyO, ((arf)localObject1).hIQ, com.tencent.mm.plugin.fav.a.b.dQc(), paramarx, "", ((asb)localObject2).appId);
          paramarx.oOM = ((arf)localObject1).songAlbumUrl;
          paramarx.oOE = ((arf)localObject1).songLyric;
          paramarx.oOW = ((arf)localObject1).hIQ;
          if (com.tencent.mm.plugin.fav.a.b.f((arf)localObject1)) {
            break label984;
          }
          Log.i("MicroMsg.FavItemLogic", " start play music");
          com.tencent.mm.aw.a.c(paramarx);
        }
      }
      for (;;)
      {
        paramarx.oOT = String.valueOf(paramg.field_localId);
        paramg = new Intent();
        paramg.putExtra("key_scene", 2);
        paramg.setFlags(268435456);
        com.tencent.mm.br.c.b(paramContext, "music", ".ui.MusicMainUI", paramg);
        AppMethodBeat.o(24581);
        return;
        paramarx = new u(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(((arf)localObject1).hDd.getBytes()));
        if (paramarx.jKS()) {}
        for (paramarx = ah.v(paramarx.jKT());; paramarx = "") {
          break;
        }
        paramarx = ah.v(paramarx.jKT());
        break;
        Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
      }
    case 21: 
      label984:
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramContext))
      {
        AppMethodBeat.o(24581);
        return;
      }
      if (((cn)com.tencent.mm.kernel.h.az(cn.class)).canEnterMvAndShowToast())
      {
        localObject3 = paramg.field_favProto.ZBt;
        localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        paramarx = new u(com.tencent.mm.plugin.fav.a.b.a((arf)localObject2));
        if (paramarx.jKS()) {
          break label1642;
        }
        if (((arf)localObject2).hDd != null) {
          break label1579;
        }
        paramarx = "";
        if ((localObject2 == null) || (((arf)localObject2).Zzy == null)) {
          break label2319;
        }
      }
      break;
    }
    label2319:
    for (Object localObject1 = ((arf)localObject2).Zzy.ZAJ;; localObject1 = null)
    {
      for (;;)
      {
        localObject4 = new dtj();
        if (localObject1 != null) {}
        try
        {
          ((dtj)localObject4).parseFrom(((dtj)localObject1).toByteArray());
          paramarx = com.tencent.mm.aw.i.a(6, null, ((arf)localObject2).title, ((arf)localObject2).desc, ((arf)localObject2).ZyM, ((arf)localObject2).ZyQ, ((arf)localObject2).ZyO, ((arf)localObject2).hIQ, com.tencent.mm.plugin.fav.a.b.dQc(), paramarx, "", ((asb)localObject3).appId, com.tencent.mm.aw.h.a(((arf)localObject2).hIQ, (dtj)localObject4));
          paramarx.oOM = ((arf)localObject2).songAlbumUrl;
          paramarx.oOE = ((arf)localObject2).songLyric;
          paramarx.oOW = ((arf)localObject2).hIQ;
          if (localObject1 != null) {
            paramarx.oOZ = ((dtj)localObject1).oOZ;
          }
          if (!com.tencent.mm.plugin.fav.a.b.f((arf)localObject2))
          {
            Log.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.aw.a.c(paramarx);
            paramarx.oOT = String.valueOf(paramg.field_localId);
            paramg = new Intent();
            paramg.putExtra("key_scene", 2);
            paramg.setFlags(268435456);
            if (localObject1 != null)
            {
              paramg.putExtra("key_mv_feed_id", ((dtj)localObject1).YqN);
              paramg.putExtra("key_mv_nonce_id", ((dtj)localObject1).YqO);
              paramg.putExtra("key_mv_cover_url", ((dtj)localObject1).YqP);
              paramg.putExtra("key_mv_poster", ((dtj)localObject1).YqQ);
              paramg.putExtra("key_mv_song_name", ((arf)localObject2).title);
              paramg.putExtra("key_mv_song_lyric", ((arf)localObject2).songLyric);
              paramg.putExtra("key_mv_album_cover_url", ((arf)localObject2).songAlbumUrl);
              paramg.putExtra("key_mv_singer_name", ((dtj)localObject1).singerName);
              paramg.putExtra("key_mv_album_name", ((dtj)localObject1).albumName);
              paramg.putExtra("key_mv_music_genre", ((dtj)localObject1).musicGenre);
              paramg.putExtra("key_mv_issue_date", String.valueOf(((dtj)localObject1).issueDate));
              paramg.putExtra("key_mv_identification", ((dtj)localObject1).identification);
              paramg.putExtra("key_mv_extra_info", ((dtj)localObject1).extraInfo);
              paramg.putExtra("key_mv_music_duration", ((dtj)localObject1).LNC);
              paramg.putExtra("key_mv_thumb_path", ((dtj)localObject1).oPc);
              paramg.putExtra("key_mv_music_operation_url", ((dtj)localObject1).musicOperationUrl);
              paramg.putExtra("key_mv_song_mid", ((dtj)localObject1).oOZ);
            }
            paramarx = com.tencent.mm.plugin.secdata.ui.a.PlI;
            paramarx = (dtk)a.a.a(paramContext, "MusicMvMainUI", 7, dtk.class);
            paramarx.scene = 9;
            localObject1 = com.tencent.mm.plugin.comm.a.xeG;
            paramarx.zIO = com.tencent.mm.plugin.comm.a.dsT();
            paramarx.aaYP = 84;
            paramarx.aaYQ = ((arf)localObject2).hIQ;
            com.tencent.mm.br.c.b(paramContext, "mv", ".ui.MusicMvMainUI", paramg);
            AppMethodBeat.o(24581);
            return;
            label1579:
            paramarx = new u(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(((arf)localObject2).hDd.getBytes()));
            if (paramarx.jKS()) {}
            for (paramarx = ah.v(paramarx.jKT());; paramarx = "") {
              break;
            }
            label1642:
            paramarx = ah.v(paramarx.jKT());
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
      c(paramContext, paramg, true, paramarx);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      b.a(paramContext, paramg.field_localId, paramg.field_favProto.ZAl.hZn);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      b.b(paramContext, paramg.field_localId, paramg.field_favProto.ZAn.hZn);
      AppMethodBeat.o(24581);
      return;
      Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramarx = new Intent();
      paramarx.putExtra("key_product_scene", 4);
      paramarx.putExtra("key_product_info", paramg.field_favProto.ZAl.hZn);
      com.tencent.mm.br.c.b(paramContext, "product", ".ui.MallProductUI", paramarx);
      AppMethodBeat.o(24581);
      return;
      a(paramContext, paramg, true, paramarx);
      AppMethodBeat.o(24581);
      return;
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
      bh.bCz();
      paramg = com.tencent.mm.model.c.bzD().aLU(paramg);
      if (paramg == null) {
        break;
      }
      if ((!com.tencent.mm.model.ab.IS(paramg.hgk)) || (WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext)))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramg.hgk);
        ((Intent)localObject1).putExtra("Contact_Alias", paramg.kDc);
        ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
        ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.pTY);
        ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.pTX);
        ((Intent)localObject1).putExtra("Contact_Uin", paramg.MXS);
        ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.adkz);
        ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.adkA);
        ((Intent)localObject1).putExtra("Contact_QQNick", paramg.jcv());
        ((Intent)localObject1).putExtra("User_From_Fmessage", false);
        ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
        ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.pUc);
        ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.WAW);
        ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.verifyInfo);
        ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.MVy);
        ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
        ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
        ((Intent)localObject1).putExtra("Contact_Sex", paramg.sex);
        ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
        ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
        ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
        com.tencent.mm.plugin.fav.a.i.hC("ContactInfoUI", paramarx.sessionId);
        com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
        com.tencent.mm.bs.a.axl(paramg.scene);
      }
      AppMethodBeat.o(24581);
      return;
      b(paramContext, paramg, true, paramarx);
      AppMethodBeat.o(24581);
      return;
      Toast.makeText(paramContext, R.l.favorite_unknown_type, 0).show();
      AppMethodBeat.o(24581);
      return;
    }
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, arx paramarx)
  {
    AppMethodBeat.i(24583);
    Log.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    ql localql = new ql();
    localql.hTy.field_localId = paramg.field_localId;
    Object localObject;
    if ((!Util.isNullOrNil(paramg.Acs)) && (paramg.field_favProto != null) && (paramg.field_favProto.vEn != null) && (paramg.field_favProto.vEn.size() > 0))
    {
      localObject = paramg.field_favProto.vEn.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label396;
      }
      if (!Util.isEqual(((arf)((Iterator)localObject).next()).hIQ, paramg.Acs)) {
        break label347;
      }
    }
    label396:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localql.hTy.hTB) });
      if (bool)
      {
        if (paramg.field_type == 18)
        {
          localObject = localql.hTy;
          ((ql.a)localObject).hTB -= 1;
        }
        label190:
        if (paramg.field_localId != -1L) {
          break label381;
        }
        localql.hTy.hTG = 4;
      }
      for (;;)
      {
        localql.hTy.context = paramContext;
        paramContext = new Bundle();
        localObject = paramg.field_favProto.YzK;
        if (localObject != null)
        {
          paramContext.putString("noteauthor", ((arp)localObject).ZBm);
          paramContext.putString("noteeditor", ((arp)localObject).ZBn);
        }
        paramContext.putLong("edittime", paramg.field_updateTime);
        localql.hTy.hTF = paramContext;
        localql.hTy.field_favProto = paramg.field_favProto;
        localql.hTy.type = 2;
        localql.hTy.hTH = paramBoolean;
        localql.hTy.hTI = paramarx;
        localql.publish();
        com.tencent.mm.plugin.fav.a.i.hC("NoteEditorUI", paramarx.sessionId);
        AppMethodBeat.o(24583);
        return;
        label347:
        ql.a locala = localql.hTy;
        locala.hTB += 1;
        break;
        localql.hTy.hTB = 0;
        break label190;
        label381:
        localql.hTy.hTA = paramg.field_xml;
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
    final arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24574);
          d.f(d.this, paramg, new arx());
          AppMethodBeat.o(24574);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24575);
          Intent localIntent = new Intent();
          localIntent.putExtra("Retr_Msg_content", d.this.field_favProto.desc);
          com.tencent.mm.br.c.g(paramContext, ".ui.transmit.RetransmitPreviewUI", localIntent);
          com.tencent.mm.ui.base.b.ne(paramContext);
          AppMethodBeat.o(24575);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24576);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          if (d.this != null)
          {
            localIntent.putExtra("kwebmap_slat", d.this.lat);
            localIntent.putExtra("kwebmap_lng", d.this.lng);
            localIntent.putExtra("Kwebmap_locaion", d.this.label);
          }
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(24576);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24577);
          d.g(d.this, paramg, new arx());
          AppMethodBeat.o(24577);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24578);
          d.h(d.this, paramg, new arx());
          AppMethodBeat.o(24578);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24579);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", d.this.field_localId);
          localIntent.putExtra("key_detail_data_id", localarf.hIQ);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavImgGalleryUI", localIntent);
          AppMethodBeat.o(24579);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24580);
          arf localarf = com.tencent.mm.plugin.fav.a.b.c(d.this);
          if (localarf == null)
          {
            Log.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(24580);
            return;
          }
          if (d.b(paramContext, localarf))
          {
            AppMethodBeat.o(24580);
            return;
          }
          if ((localarf.ZzE != null) && ((!Util.isNullOrNil(localarf.ZzE.nTu)) || (!Util.isNullOrNil(localarf.ZzE.nTy))))
          {
            Log.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            localIntent = new Intent();
            localIntent.putExtra("key_detail_info_id", d.this.field_localId);
            localIntent.putExtra("key_detail_data_id", localarf.hIQ);
            localIntent.putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent);
            AppMethodBeat.o(24580);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", d.this.field_localId);
          localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(localarf));
          localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(localarf));
          localIntent.putExtra("key_detail_fav_video_duration", localarf.duration);
          localIntent.putExtra("key_detail_statExtStr", localarf.iah);
          localIntent.putExtra("key_detail_msg_uuid", localarf.pbn);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteVideoPlayUI", localIntent);
          AppMethodBeat.o(24580);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(24572);
          d.i(d.this, paramg, new arx());
          AppMethodBeat.o(24572);
        }
      });
      AppMethodBeat.o(24597);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(163190);
          bvl localbvl = d.this.field_favProto.ZAB;
          if (localbvl != null)
          {
            com.tencent.mm.plugin.fav.ui.f localf = com.tencent.mm.plugin.fav.ui.f.Ahd;
            com.tencent.mm.plugin.fav.ui.f.a(paramContext, localbvl);
          }
          AppMethodBeat.o(163190);
        }
      });
    }
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, arx paramarx)
  {
    AppMethodBeat.i(24590);
    n.a(n.a.AcZ, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramarx, localIntent);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
    AppMethodBeat.o(24590);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, arx paramarx)
  {
    AppMethodBeat.i(24584);
    arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if ((paramarx != null) && (paramarx.icP == 1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      if (!Util.isNullOrNil(paramg.Acs))
      {
        ((Intent)localObject).putExtra("key_detail_data_id", paramg.Acs);
        ((Intent)localObject).putExtra("key_detail_open_way", 2);
      }
      for (;;)
      {
        a(paramarx, (Intent)localObject);
        com.tencent.mm.plugin.fav.a.i.hC("FavoriteFileDetailUI", paramarx.sessionId);
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
        AppMethodBeat.o(24584);
        return;
        ((Intent)localObject).putExtra("key_detail_open_way", 1);
      }
    }
    if ((paramarx != null) && (paramarx.icP == 2))
    {
      if (!com.tencent.mm.pluginsdk.ui.tools.a.c((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.d(localarf), localarf.ZyU, 2)) {
        AppMethodBeat.o(24584);
      }
    }
    else if (com.tencent.mm.plugin.fav.a.b.g(localarf))
    {
      if (com.tencent.mm.plugin.fav.a.b.h(localarf))
      {
        e(paramContext, paramg, paramarx);
        AppMethodBeat.o(24584);
        return;
      }
      if (paramg == null) {
        break label345;
      }
    }
    label345:
    for (Object localObject = String.valueOf(paramg.field_id);; localObject = null)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.fromFavItem(localarf, (String)localObject, null, com.tencent.mm.plugin.fav.a.b.d(localarf)));
      if (!com.tencent.mm.pluginsdk.ui.tools.a.bA(com.tencent.mm.plugin.fav.a.b.d(localarf), localarf.ZyU, localarf.title))
      {
        AppMethodBeat.o(24584);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
      ((Intent)localObject).putExtra("key_detail_data_id", localarf.hIQ);
      ((Intent)localObject).putExtra("show_share", paramBoolean);
      a(paramarx, (Intent)localObject);
      com.tencent.mm.plugin.fav.a.i.hC("FavoriteFileDetailUI", paramarx.sessionId);
      com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
      AppMethodBeat.o(24584);
      return;
    }
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, arx paramarx)
  {
    AppMethodBeat.i(24592);
    arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (a(paramContext, localarf, paramg))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if (a(paramContext, localarf, false))
    {
      AppMethodBeat.o(24592);
      return;
    }
    if ((Util.isNullOrNil(localarf.ZyW)) || (localarf.Zza <= 0L))
    {
      Log.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localarf.ZyW, Long.valueOf(localarf.Zza) });
      Object localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).ZyM;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).ZyQ;
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramarx);
        AppMethodBeat.o(24592);
        return;
      }
      paramarx = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localarf.iah);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramarx.putExtra("jsapiargs", (Bundle)localObject2);
      paramarx.putExtra("rawUrl", (String)localObject1);
      paramarx.putExtra("is_favorite_item", true);
      paramarx.putExtra("fav_local_id", paramg.field_localId);
      paramarx.putExtra("geta8key_scene", 14);
      paramarx.putExtra("key_enable_teen_mode_check", true);
      Log.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramarx.putExtra("geta8key_scene", 14);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramarx);
      AppMethodBeat.o(24592);
      return;
    }
    Object localObject1 = new Intent();
    a(paramg, paramarx, (Intent)localObject1);
    com.tencent.mm.plugin.fav.a.i.hC("FavoriteSightDetailUI", paramarx.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
    AppMethodBeat.o(24592);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, arx paramarx)
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
      paramarx = new Intent();
      paramarx.putExtra("sns_landing_pages_xml", (String)localObject1);
      paramarx.putExtra("sns_landig_pages_from_source", 7);
      paramarx.putExtra("sns_landing_pages_share_thumb_url", K(paramg));
      paramarx.putExtra("sns_landing_favid", z.bAM() + "_" + paramg.field_id);
      paramarx.addFlags(268435456);
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramarx);
      AppMethodBeat.o(24587);
      return;
    }
    ask localask = paramg.field_favProto.ZAj;
    if ((localask != null) && (localask.ZCb) && (!Util.isNullOrNil(localask.ZCa)))
    {
      paramg = XmlParser.parseXml(localask.ZCa, "websearch", null);
      if (paramg == null)
      {
        Log.e("MicroMsg.FavItemLogic", "XmlParser.parseXml fail, values is null");
        AppMethodBeat.o(24587);
        return;
      }
      paramarx = new gib();
      paramarx.WoZ = ((String)paramg.get(".websearch.relevant_vid"));
      paramarx.Wpa = ((String)paramg.get(".websearch.relevant_expand"));
      paramarx.Wpb = ((String)paramg.get(".websearch.relevant_pre_searchid"));
      paramarx.Wpc = ((String)paramg.get(".websearch.relevant_shared_openid"));
      paramarx.Wpd = Util.getInt((String)paramg.get(".websearch.rec_category"), -1);
      paramarx.ytZ = ((String)paramg.get(".websearch.shareUrl"));
      paramarx.svG = ((String)paramg.get(".websearch.shareTitle"));
      paramarx.ICb = ((String)paramg.get(".websearch.shareDesc"));
      paramarx.Wpe = ((String)paramg.get(".websearch.shareImgUrl"));
      paramarx.Wpf = ((String)paramg.get(".websearch.shareString"));
      paramarx.Wpg = ((String)paramg.get(".websearch.shareStringUrl"));
      paramarx.source = ((String)paramg.get(".websearch.source"));
      paramarx.ibx = ((String)paramg.get(".websearch.sourceUrl"));
      paramarx.Wph = ((String)paramg.get(".websearch.strPlayCount"));
      paramarx.Wpi = ((String)paramg.get(".websearch.titleUrl"));
      paramarx.Wpj = ((String)paramg.get(".websearch.extReqParams"));
      paramarx.Wpk = ((String)paramg.get(".websearch.tagList"));
      paramarx.Wpl = Util.getLong((String)paramg.get(".websearch.channelId"), -1L);
      paramarx.thumbUrl = ((String)paramg.get(".websearch.thumbUrl"));
      paramarx.Wpm = ((String)paramg.get(".websearch.shareTag"));
      aj.a(paramContext, com.tencent.mm.plugin.topstory.a.g.a(paramarx, 326, paramContext.getString(R.l.topstory)));
      AppMethodBeat.o(24587);
      return;
    }
    Object localObject3 = "";
    localObject1 = "";
    if (localask != null)
    {
      localObject3 = localask.ZBV;
      localObject1 = localask.title;
    }
    for (Object localObject2 = localask.desc;; localObject2 = "")
    {
      asb localasb = paramg.field_favProto.ZBt;
      Object localObject4 = localObject3;
      if (localasb != null)
      {
        localObject4 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject4 = localasb.link;
        }
      }
      Object localObject5 = localObject4;
      if (Util.isNullOrNil((String)localObject4)) {
        if (paramg.field_favProto.vEn.size() <= 0) {
          break label754;
        }
      }
      label754:
      for (localObject3 = ((arf)paramg.field_favProto.vEn.get(0)).ZyM;; localObject3 = null)
      {
        localObject5 = localObject3;
        if (!Util.isNullOrNil(localObject5)) {
          break;
        }
        Log.w("MicroMsg.FavItemLogic", "go to web page error, url null, dataid[%s]", new Object[] { paramg.Acs });
        AppMethodBeat.o(24587);
        return;
      }
      if (((PluginFavOffline)com.tencent.mm.kernel.h.az(PluginFavOffline.class)).useOffline(localObject5, paramg.field_localId))
      {
        Log.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", new Object[] { localObject5 });
        AppMethodBeat.o(24587);
        return;
      }
      ((PluginFavOffline)com.tencent.mm.kernel.h.az(PluginFavOffline.class)).getFavOfflineService().aup(localObject5);
      arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
      Object localObject6 = localObject2;
      localObject4 = localObject1;
      if (localarf != null)
      {
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = localarf.title;
        }
        localObject6 = localObject2;
        localObject4 = localObject3;
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject6 = localarf.desc;
          localObject4 = localObject3;
        }
      }
      Log.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", localObject5);
      ((Intent)localObject1).putExtra("showShare", paramBoolean);
      ((Intent)localObject1).putExtra("is_favorite_item", true);
      ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
      ((Intent)localObject1).putExtra("favorite_control_argument", paramg.dQn());
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("webpageTitle", (String)localObject4);
      if ((localasb != null) && (!Util.isNullOrNil(localasb.hzi))) {
        ((Intent)localObject1).putExtra("srcDisplayname", aa.getDisplayName(localasb.hzi));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      ((Intent)localObject1).putExtra("thumbPath", localarf.Zzf);
      if ((localask != null) && (!Util.isNullOrNil(localask.thumbUrl))) {
        ((Intent)localObject1).putExtra("thumbUrl", localask.thumbUrl);
      }
      for (;;)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).iah);
        ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
        ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
        ((Intent)localObject1).putExtra("from_scence", 4);
        localObject2 = "fav_" + z.bAM() + "_" + paramg.field_id;
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
        localObject2 = com.tencent.mm.modelstat.a.c.Pu(k.class.getName());
        ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
        ((Bundle)localObject2).putInt("key_detail_fav_scene", paramarx.scene);
        ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramarx.AcJ);
        ((Bundle)localObject2).putInt("key_detail_fav_index", paramarx.index);
        ((Bundle)localObject2).putString("key_detail_fav_query", paramarx.query);
        ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramarx.sessionId);
        ((Bundle)localObject2).putString("key_detail_fav_tags", paramarx.AcL);
        com.tencent.mm.plugin.fav.a.i.hC("WebViewUI", paramarx.sessionId);
        ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
        ((Intent)localObject1).putExtra("geta8key_scene", 14);
        ((Intent)localObject1).putExtra("key_enable_teen_mode_check", true);
        if ((paramg.field_favProto.WKx != null) && (paramg.field_favProto.WKx.nQm == 16))
        {
          ((Intent)localObject1).putExtra("immersiveVideoStyle", 1);
          ((Intent)localObject1).putExtra("immersivePageBgIsDark", 1);
          ((Intent)localObject1).putExtra("webview_bg_color_rsID", 17170444);
        }
        if ((paramg.field_favProto.WKx == null) || (paramg.field_favProto.WKx.nQo != 1) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GU(paramg.field_favProto.WKx.nQm))) {
          break;
        }
        a(paramContext, paramg, (Intent)localObject1);
        AppMethodBeat.o(24587);
        return;
        if ((localarf != null) && (!Util.isNullOrNil(localarf.hDd)) && (localarf.hDd.startsWith("http"))) {
          ((Intent)localObject1).putExtra("thumbUrl", localarf.hDd);
        }
      }
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(24587);
      return;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, arx paramarx)
  {
    AppMethodBeat.i(24593);
    Intent localIntent = new Intent();
    a(paramg, paramarx, localIntent);
    com.tencent.mm.plugin.fav.a.i.hC("FavoriteImgDetailUI", paramarx.sessionId);
    com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
    AppMethodBeat.o(24593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */