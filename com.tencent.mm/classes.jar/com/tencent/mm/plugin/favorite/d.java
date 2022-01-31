package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.av.e;
import com.tencent.mm.av.f;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.ui.i.a;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.widget.a.c.a.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static int[] kka = { R.h.chatting_note_thumb_iv_0, R.h.chatting_note_thumb_iv_1, R.h.chatting_note_thumb_iv_2, R.h.chatting_note_thumb_iv_3, R.h.chatting_note_thumb_iv_4 };
  
  private static String G(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramg.field_favProto == null) {}
    do
    {
      return null;
      if ((paramg.field_favProto.sWh != null) && (!bk.bl(paramg.field_favProto.sWh.canvasPageXml))) {
        return paramg.field_favProto.sWh.thumbUrl;
      }
      paramg = paramg.field_favProto.sXc;
    } while ((paramg == null) || (paramg.size() != 1));
    return ((xv)paramg.get(0)).dQL;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, yl paramyl)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    localIntent.putExtra("show_share", paramBoolean);
    a(paramyl, localIntent);
    i.da("FavRecordDetailUI", paramyl.bIB);
    com.tencent.mm.br.d.b(paramContext, "record", ".ui.FavRecordDetailUI", localIntent);
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, yl paramyl, Intent paramIntent)
  {
    a(paramyl, paramIntent);
    paramIntent.putExtra("key_detail_info_id", paramg.field_localId);
  }
  
  public static void a(g.a parama, Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    if ((paramg == null) || (paramContext == null))
    {
      y.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      return;
    }
    xv localxv1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (paramg == null)
    {
      y.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      label39:
      localObject1 = null;
      label41:
      if (!(localObject1 instanceof String)) {
        break label1319;
      }
    }
    Object localObject2;
    for (Object localObject1 = (String)localObject1;; localObject1 = null)
    {
      localObject2 = paramg.field_favProto.sWh;
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
          if (!bk.bl(((yy)localObject2).title)) {
            paramg = ((yy)localObject2).title;
          }
        }
        localObject1 = paramg;
        if (bk.bl(paramg)) {
          localObject1 = localxv1.title;
        }
        parama.WF(paramContext.getResources().getString(R.l.app_app) + (String)localObject1);
        return;
        xv localxv2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if (5 == paramg.field_type)
        {
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localxv2));
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            localObject1 = j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
            break label41;
          }
          localObject1 = paramg.field_favProto.sWh;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((yy)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bk.bl((String)localObject1)) {
              localObject2 = localxv2.bIm;
            }
            localObject2 = com.tencent.mm.plugin.fav.a.b.Cz((String)localObject2);
            localObject1 = localObject2;
            if (!bk.bl((String)localObject2)) {
              break;
            }
            localObject1 = Integer.valueOf(R.k.app_attach_file_icon_webpage);
            break;
          }
        }
        if ((11 == paramg.field_type) || (10 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.sWj;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.Cz(((yi)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bk.bl((String)localObject2)) {
              break label41;
            }
            localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
            break label41;
          }
        }
        if ((15 == paramg.field_type) || (12 == paramg.field_type))
        {
          localObject1 = paramg.field_favProto.sWl;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.fav.a.b.Cz(((ys)localObject1).thumbUrl);
            localObject1 = localObject2;
            if (!bk.bl((String)localObject2)) {
              break label41;
            }
            localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
            break label41;
          }
        }
        if ((2 == paramg.field_type) || (7 == paramg.field_type) || (16 == paramg.field_type) || (4 == paramg.field_type))
        {
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localxv2));
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            localObject1 = j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
            break label41;
          }
          localObject1 = com.tencent.mm.plugin.fav.a.b.Cz(localxv2.bIm);
          localObject2 = localObject1;
          if (bk.bl((String)localObject1))
          {
            com.tencent.mm.plugin.fav.a.b.a(paramg, localxv2);
            localObject2 = com.tencent.mm.plugin.fav.a.b.c(localxv2);
          }
          localObject1 = localObject2;
          if (!bk.bl((String)localObject2)) {
            break label41;
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
          if ((3 == paramg.field_type) || (6 == paramg.field_type)) {
            break label39;
          }
          if (8 == paramg.field_type)
          {
            localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.c.Vy(localxv2.sUV));
            break;
          }
          if (17 == paramg.field_type)
          {
            au.Hx();
            localObject1 = com.tencent.mm.model.c.Fy().HN(localxv2.desc);
            if ((((bi.a)localObject1).pyp != null) && (((bi.a)localObject1).pyp.length() != 0))
            {
              localObject1 = new SpannableString(((bi.a)localObject1).pyp);
              break;
            }
            localObject1 = Integer.valueOf(R.g.default_avatar);
            break;
          }
          if ((14 != paramg.field_type) || (paramg.field_favProto.sXc == null)) {
            break label39;
          }
          localObject1 = paramg.field_favProto.sXc.iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localxv2 = (xv)((Iterator)localObject1).next();
            } while (localxv2.aYU == 1);
            if (localxv2.aYU == 3)
            {
              localObject1 = Integer.valueOf(R.k.app_attach_file_icon_voice);
              break label41;
            }
            if (localxv2.aYU == 6)
            {
              localObject1 = Integer.valueOf(R.k.app_attach_file_icon_location);
              break label41;
            }
            if (localxv2.aYU == 8)
            {
              localObject1 = Integer.valueOf(com.tencent.mm.pluginsdk.c.Vy(localxv2.sUV));
              break label41;
            }
            if ((localxv2.aYU == 2) || (localxv2.aYU == 7) || (localxv2.aYU == 15) || (localxv2.aYU == 4))
            {
              localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localxv2));
              if (((com.tencent.mm.vfs.b)localObject1).exists())
              {
                localObject1 = j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
                break label41;
              }
              localObject1 = com.tencent.mm.plugin.fav.a.b.Cz(localxv2.bIm);
              if (bk.bl((String)localObject1)) {
                switch (localxv2.aYU)
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
                }
              }
              break label41;
            }
            if (localxv2.aYU == 5)
            {
              localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localxv2));
              if (((com.tencent.mm.vfs.b)localObject1).exists())
              {
                localObject1 = j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
                break label41;
              }
              localObject1 = localxv2.sVA.sWh;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((yy)localObject1).thumbUrl)
              {
                localObject2 = localObject1;
                if (bk.bl((String)localObject1)) {
                  localObject2 = localxv2.bIm;
                }
                localObject2 = com.tencent.mm.plugin.fav.a.b.Cz((String)localObject2);
                localObject1 = localObject2;
                if (!bk.bl((String)localObject2)) {
                  break;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_webpage);
                break;
              }
            }
            if ((localxv2.aYU == 10) || (localxv2.aYU == 11))
            {
              localObject2 = localxv2.sVA.sWj;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.Cz(((yi)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bk.bl((String)localObject2)) {
                  break label41;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                break label41;
              }
            }
            if ((localxv2.aYU == 12) || (localxv2.aYU == 14))
            {
              localObject2 = localxv2.sVA.sWl;
              if (localObject2 != null)
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.Cz(((ys)localObject2).thumbUrl);
                localObject1 = localObject2;
                if (!bk.bl((String)localObject2)) {
                  break label41;
                }
                localObject1 = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                break label41;
              }
            }
          } while (localxv2.aYU != 16);
          au.Hx();
          localObject1 = com.tencent.mm.model.c.Fy().HN(localxv2.desc);
          if ((((bi.a)localObject1).pyp != null) && (((bi.a)localObject1).pyp.length() != 0))
          {
            localObject1 = new SpannableString(((bi.a)localObject1).pyp);
            break;
          }
          localObject1 = Integer.valueOf(R.g.default_avatar);
          break;
          label1319:
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
    if (bk.bl((String)localObject1)) {
      paramg = localxv1.title;
    }
    parama.WF(paramContext.getResources().getString(R.l.app_file) + paramg);
    return;
    parama.WF(paramg.field_favProto.desc);
    parama.cmI();
    parama.a(new d.2(paramg, paramContext));
    return;
    paramg = paramg.field_favProto.sWf;
    parama.WF(paramContext.getString(R.l.app_location) + paramg.label);
    return;
    if ((localObject2 != null) && (!bk.bl(((yy)localObject2).title)))
    {
      paramg = ((yy)localObject2).title;
      localObject1 = ((yy)localObject2).desc;
    }
    for (;;)
    {
      localObject2 = paramg;
      if (bk.bl(paramg)) {
        localObject2 = localxv1.title;
      }
      if (bk.bl((String)localObject1)) {
        paramg = localxv1.desc;
      }
      parama.WF(paramContext.getResources().getString(R.l.app_url) + (String)localObject2);
      return;
      paramg = i.a.a(paramContext, paramg).title;
      parama.WF(paramContext.getResources().getString(R.l.app_record) + paramg);
      return;
      parama.d(com.tencent.mm.sdk.platformtools.c.YW((String)localObject1), 3);
      return;
      parama.d(com.tencent.mm.sdk.platformtools.c.YW((String)localObject1), 2);
      return;
      parama.d(com.tencent.mm.sdk.platformtools.c.YW((String)localObject1), 2);
      return;
      localObject1 = paramContext.getResources().getString(R.l.app_note);
      paramContext = i.a.a(paramContext, paramg).desc.replaceAll("\n", " ");
      parama.WF((String)localObject1 + paramContext);
      return;
      paramg = localObject4;
      if (localObject2 != null)
      {
        paramg = localObject4;
        if (!bk.bl(((yy)localObject2).title)) {
          paramg = ((yy)localObject2).title;
        }
      }
      localObject1 = paramg;
      if (bk.bl(paramg)) {
        localObject1 = localxv1.title;
      }
      parama.WF(paramContext.getResources().getString(R.l.app_music) + (String)localObject1);
      return;
      localObject1 = null;
      paramg = null;
    }
  }
  
  private static void a(yl paramyl, Intent paramIntent)
  {
    paramIntent.putExtra("key_detail_fav_scene", paramyl.scene);
    paramIntent.putExtra("key_detail_fav_sub_scene", paramyl.jYS);
    paramIntent.putExtra("key_detail_fav_index", paramyl.index);
    paramIntent.putExtra("key_detail_fav_query", paramyl.bVk);
    paramIntent.putExtra("key_detail_fav_sessionid", paramyl.bIB);
    paramIntent.putExtra("key_detail_fav_tags", paramyl.jYU);
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, yl paramyl)
  {
    if (paramContext == null) {
      y.w("MicroMsg.FavItemLogic", "Context is null");
    }
    label828:
    do
    {
      return;
      if (paramg == null)
      {
        y.w("MicroMsg.FavItemLogic", "Fav item is null");
        return;
      }
      y.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type) });
      long l;
      Object localObject2;
      Object localObject3;
      switch (paramg.field_type)
      {
      case -1: 
      case 0: 
      case 9: 
      case 13: 
      default: 
        y.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[] { Integer.valueOf(paramg.field_type) });
        return;
      case 1: 
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_detail_text", paramg.field_favProto.desc);
        ((Intent)localObject1).putExtra("key_detail_info_id", paramg.field_localId);
        ((Intent)localObject1).putExtra("key_detail_can_share_to_friend", paramg.aPX());
        ((Intent)localObject1).putExtra("key_detail_time", paramg.field_updateTime);
        if (paramg.field_sourceCreateTime <= 0L) {}
        for (l = paramg.field_updateTime;; l = paramg.field_sourceCreateTime)
        {
          ((Intent)localObject1).putExtra("key_detail_create_time", l);
          a(paramyl, (Intent)localObject1);
          i.da("FavoriteTextDetailUI", paramyl.bIB);
          com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteTextDetailUI", (Intent)localObject1);
          return;
        }
      case 2: 
        e(paramContext, paramg, paramyl);
        return;
      case 3: 
        localObject1 = new Intent();
        a(paramg, paramyl, (Intent)localObject1);
        ((Intent)localObject1).putExtra("key_detail_create_time", paramg.field_favProto.sXa.createTime);
        i.da("FavoriteVoiceDetailUI", paramyl.bIB);
        com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVoiceDetailUI", (Intent)localObject1);
        return;
      case 16: 
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        if ((localObject1 != null) && (((xv)localObject1).sVG != null) && ((!bk.bl(((xv)localObject1).sVG.dSP)) || (!bk.bl(((xv)localObject1).sVG.dST))))
        {
          y.i("MicroMsg.FavItemLogic", "it is ad sight.");
          c(paramContext, paramg, paramyl);
          return;
        }
        d(paramContext, paramg, paramyl);
        return;
      case 4: 
        d(paramContext, paramg, paramyl);
        return;
      case 5: 
        d(paramContext, paramg, true, paramyl);
        return;
      case 6: 
        localObject2 = paramg.field_favProto.sWf;
        localObject3 = paramg.field_favProto.fGK;
        localObject1 = paramg.field_favProto.sXa;
        if ((localObject1 != null) && (!bk.bl(((yp)localObject1).sWB))) {}
        for (localObject1 = r.gV(((yp)localObject1).sWB);; localObject1 = r.gV(paramg.field_fromUser))
        {
          ArrayList localArrayList = new ArrayList();
          if (paramg.field_tagProto.sXq != null) {
            localArrayList.addAll(paramg.field_tagProto.sXq);
          }
          i.da("RedirectUI", paramyl.bIB);
          com.tencent.mm.plugin.fav.a.b.a(paramg.field_localId, (yc)localObject2, (String)localObject1, (String)localObject3, localArrayList, paramContext);
          return;
        }
      case 7: 
        localObject3 = paramg.field_favProto.sXa;
        localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
        localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c((xv)localObject2));
        if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
          if (((xv)localObject2).bIm == null)
          {
            localObject1 = "";
            localObject1 = f.a(6, null, ((xv)localObject2).title, ((xv)localObject2).desc, ((xv)localObject2).sUN, ((xv)localObject2).sUR, ((xv)localObject2).sUP, ((xv)localObject2).kgC, com.tencent.mm.plugin.fav.a.b.aPP(), (String)localObject1, "", ((yp)localObject3).appId);
            if (com.tencent.mm.plugin.fav.a.b.e((xv)localObject2)) {
              break label828;
            }
            y.i("MicroMsg.FavItemLogic", " start play music");
            com.tencent.mm.av.a.b((e)localObject1);
          }
        }
        for (;;)
        {
          ((e)localObject1).euV = String.valueOf(paramg.field_localId);
          paramg = new Intent();
          paramg.putExtra("key_scene", 2);
          i.da("MusicMainUI", paramyl.bIB);
          com.tencent.mm.br.d.b(paramContext, "music", ".ui.MusicMainUI", paramg);
          return;
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(((xv)localObject2).bIm.getBytes()));
          if (((com.tencent.mm.vfs.b)localObject1).exists()) {}
          for (localObject1 = j.n(((com.tencent.mm.vfs.b)localObject1).cLr());; localObject1 = "") {
            break;
          }
          localObject1 = j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
          break;
          y.i("MicroMsg.FavItemLogic", "The music is playing, don't start play again");
        }
      case 8: 
        c(paramContext, paramg, true, paramyl);
        return;
      case 10: 
        y.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.sWj.info;
        paramyl = new Intent();
        paramyl.putExtra("key_is_favorite_item", true);
        paramyl.putExtra("key_favorite_local_id", l);
        paramyl.putExtra("key_Product_xml", paramg);
        paramyl.putExtra("key_can_delete_favorite_item", true);
        paramyl.putExtra("key_ProductUI_getProductInfoScene", 3);
        com.tencent.mm.br.d.b(paramContext, "scanner", ".ui.ProductUI", paramyl);
        return;
      case 12: 
      case 15: 
        y.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        l = paramg.field_localId;
        paramg = paramg.field_favProto.sWl.info;
        paramyl = new Intent();
        paramyl.putExtra("key_TV_getProductInfoScene", 3);
        paramyl.putExtra("key_is_favorite_item", true);
        paramyl.putExtra("key_favorite_local_id", l);
        paramyl.putExtra("key_TV_xml", paramg);
        paramyl.putExtra("key_can_delete_favorite_item", true);
        com.tencent.mm.br.d.b(paramContext, "shake", ".ui.TVInfoUI", paramyl);
        return;
      case 11: 
        y.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
        paramyl = new Intent();
        paramyl.putExtra("key_product_scene", 4);
        paramyl.putExtra("key_product_info", paramg.field_favProto.sWj.info);
        com.tencent.mm.br.d.b(paramContext, "product", ".ui.MallProductUI", paramyl);
        return;
      case 14: 
        a(paramContext, paramg, true, paramyl);
        return;
      case 17: 
        paramg = com.tencent.mm.plugin.fav.a.b.c(paramg).desc;
        au.Hx();
        paramg = com.tencent.mm.model.c.Fy().HN(paramg);
      }
    } while (paramg == null);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("Contact_User", paramg.pyp);
    ((Intent)localObject1).putExtra("Contact_Alias", paramg.cMT);
    ((Intent)localObject1).putExtra("Contact_Nick", paramg.nickname);
    ((Intent)localObject1).putExtra("Contact_QuanPin", paramg.fha);
    ((Intent)localObject1).putExtra("Contact_PyInitial", paramg.fgZ);
    ((Intent)localObject1).putExtra("Contact_Uin", paramg.mXV);
    ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramg.uBW);
    ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramg.uBX);
    ((Intent)localObject1).putExtra("Contact_QQNick", paramg.cvM());
    ((Intent)localObject1).putExtra("User_From_Fmessage", false);
    ((Intent)localObject1).putExtra("Contact_Scene", paramg.scene);
    ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
    ((Intent)localObject1).putExtra("Contact_RemarkName", paramg.fhe);
    ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramg.qZn);
    ((Intent)localObject1).putExtra("Contact_VUser_Info", paramg.cCF);
    ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramg.mVN);
    ((Intent)localObject1).putExtra("Contact_Province", paramg.getProvince());
    ((Intent)localObject1).putExtra("Contact_City", paramg.getCity());
    ((Intent)localObject1).putExtra("Contact_Sex", paramg.sex);
    ((Intent)localObject1).putExtra("Contact_Signature", paramg.signature);
    ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
    ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
    i.da("ContactInfoUI", paramyl.bIB);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
    com.tencent.mm.bs.a.EA(paramg.scene);
    return;
    b(paramContext, paramg, true, paramyl);
    return;
    Toast.makeText(paramContext, R.l.favorite_unknown_type, 0).show();
  }
  
  private static void b(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, yl paramyl)
  {
    y.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
    ku localku = new ku();
    localku.bTL.field_localId = paramg.field_localId;
    if (paramg.field_localId == -1L) {
      localku.bTL.bTR = 4;
    }
    for (;;)
    {
      localku.bTL.context = paramContext;
      paramContext = new Bundle();
      yd localyd = paramg.field_favProto.sro;
      if (localyd != null)
      {
        paramContext.putString("noteauthor", localyd.sWT);
        paramContext.putString("noteeditor", localyd.sWU);
      }
      paramContext.putLong("edittime", paramg.field_updateTime);
      localku.bTL.bTQ = paramContext;
      localku.bTL.field_favProto = paramg.field_favProto;
      localku.bTL.type = 2;
      localku.bTL.bTT = paramBoolean;
      localku.bTL.bTU = paramyl;
      com.tencent.mm.sdk.b.a.udP.m(localku);
      i.da("NoteEditorUI", paramyl.bIB);
      return;
      localku.bTL.bTN = paramg.field_xml;
    }
  }
  
  public static void b(g.a parama, final Context paramContext, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg == null) || (paramContext == null))
    {
      y.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
      return;
    }
    final xv localxv = com.tencent.mm.plugin.fav.a.b.c(paramg);
    switch (paramg.field_type)
    {
    case 3: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 17: 
    default: 
      return;
    case 1: 
      parama.a(new d.4(paramg, paramContext));
      return;
    case 8: 
      parama.a(new d.3(paramContext, paramg));
      return;
    case 6: 
      parama.a(new c.a.b()
      {
        public final void aSe()
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.kkb.lat);
          localIntent.putExtra("kwebmap_lng", this.kkb.lng);
          localIntent.putExtra("Kwebmap_locaion", this.kkb.label);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
        }
      });
      return;
    case 5: 
      parama.a(new c.a.b()
      {
        public final void aSe()
        {
          d.g(this.val$context, paramg, new yl());
        }
      });
      return;
    case 14: 
      parama.a(new c.a.b()
      {
        public final void aSe()
        {
          d.h(this.val$context, paramg, new yl());
        }
      });
      return;
    case 2: 
      parama.a(new c.a.b()
      {
        public final void aSe()
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_detail_info_id", this.jYv.field_localId);
          localIntent.putExtra("key_detail_data_id", localxv.kgC);
          localIntent.putExtra("show_share", false);
          com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.FavImgGalleryUI", localIntent);
        }
      });
      return;
    case 4: 
    case 16: 
      parama.a(new d.9(paramg, paramContext));
      return;
    }
    parama.a(new d.1(paramContext, paramg));
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, yl paramyl)
  {
    m.a(m.a.jZg, paramg);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", paramg.field_localId);
    a(paramyl, localIntent);
    com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteSightDetailUI", localIntent);
  }
  
  private static void c(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, yl paramyl)
  {
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
    if (com.tencent.mm.plugin.fav.a.b.f((xv)localObject))
    {
      if (com.tencent.mm.plugin.fav.a.b.g((xv)localObject)) {
        e(paramContext, paramg, paramyl);
      }
      while (!com.tencent.mm.pluginsdk.ui.tools.a.a((Activity)paramContext, com.tencent.mm.plugin.fav.a.b.b((xv)localObject), ((xv)localObject).sUV, 2)) {
        return;
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", paramg.field_localId);
    ((Intent)localObject).putExtra("show_share", paramBoolean);
    a(paramyl, (Intent)localObject);
    i.da("FavoriteFileDetailUI", paramyl.bIB);
    com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, yl paramyl)
  {
    xv localxv = com.tencent.mm.plugin.fav.a.b.c(paramg);
    Object localObject1 = localxv.sVG;
    if ((localObject1 == null) || (bk.bl(((xy)localObject1).dSP))) {}
    Object localObject2;
    for (int i = 0; i != 0; i = 1)
    {
      return;
      m.a(m.a.jZi, paramg);
      localObject2 = com.tencent.mm.plugin.fav.a.b.c(localxv);
      Intent localIntent = new Intent();
      localIntent.putExtra("IsAd", false);
      localIntent.putExtra("KStremVideoUrl", ((xy)localObject1).dSP);
      localIntent.putExtra("StreamWording", ((xy)localObject1).dSS);
      localIntent.putExtra("StremWebUrl", ((xy)localObject1).dST);
      localIntent.putExtra("KThumUrl", ((xy)localObject1).dSU);
      localIntent.putExtra("KSta_StremVideoAduxInfo", ((xy)localObject1).dSV);
      localIntent.putExtra("KSta_StremVideoPublishId", ((xy)localObject1).dSW);
      localIntent.putExtra("KSta_SourceType", 2);
      localIntent.putExtra("KSta_Scene", m.b.jZs.value);
      localIntent.putExtra("KSta_FromUserName", paramg.field_fromUser);
      localIntent.putExtra("KSta_FavID", paramg.field_id);
      localIntent.putExtra("KSta_SnsStatExtStr", localxv.bYN);
      localIntent.putExtra("KBlockFav", true);
      localIntent.putExtra("KMediaId", "fakeid_" + paramg.field_id);
      localIntent.putExtra("KThumbPath", (String)localObject2);
      localIntent.putExtra("KMediaVideoTime", ((xy)localObject1).sWK);
      localIntent.putExtra("KMediaTitle", ((xy)localObject1).dSR);
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
    if ((bk.bl(localxv.sUX)) || (localxv.sVb <= 0L))
    {
      y.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[] { localxv.sUX, Long.valueOf(localxv.sVb) });
      localObject2 = com.tencent.mm.plugin.fav.a.b.c(paramg).sUN;
      localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = com.tencent.mm.plugin.fav.a.b.c(paramg).sUR;
      }
      if (bk.bl((String)localObject1))
      {
        y.w("MicroMsg.FavItemLogic", "onClick video url null, return");
        c(paramContext, paramg, paramyl);
        return;
      }
      paramyl = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", localxv.bYN);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      paramyl.putExtra("jsapiargs", (Bundle)localObject2);
      paramyl.putExtra("rawUrl", (String)localObject1);
      paramyl.putExtra("is_favorite_item", true);
      paramyl.putExtra("fav_local_id", paramg.field_localId);
      paramyl.putExtra("geta8key_scene", 14);
      y.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
      paramyl.putExtra("geta8key_scene", 14);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramyl);
      return;
    }
    localObject1 = new Intent();
    a(paramg, paramyl, (Intent)localObject1);
    i.da("FavoriteSightDetailUI", paramyl.bIB);
    com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteSightDetailUI", (Intent)localObject1);
  }
  
  private static void d(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, yl paramyl)
  {
    if (paramg.field_favProto != null) {
      if ((paramg.field_favProto.sWh != null) && (!bk.bl(paramg.field_favProto.sWh.canvasPageXml)))
      {
        localObject1 = paramg.field_favProto.sWh.canvasPageXml;
        if (bk.bl((String)localObject1)) {
          break label200;
        }
        paramyl = new Intent();
        paramyl.putExtra("sns_landing_pages_xml", (String)localObject1);
        paramyl.putExtra("sns_landig_pages_from_source", 7);
        paramyl.putExtra("sns_landing_pages_share_thumb_url", G(paramg));
        paramyl.putExtra("sns_landing_favid", q.Gj() + "_" + paramg.field_id);
        paramyl.addFlags(268435456);
        com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramyl);
      }
    }
    label200:
    yp localyp;
    Object localObject3;
    Object localObject4;
    do
    {
      return;
      localObject1 = paramg.field_favProto.sXc;
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        localObject1 = ((xv)((List)localObject1).get(0)).canvasPageXml;
        break;
      }
      localObject1 = null;
      break;
      localyp = paramg.field_favProto.sXa;
      localObject3 = "";
      localObject1 = "";
      localObject2 = "";
      if (paramg.field_favProto.sWh != null)
      {
        localObject2 = paramg.field_favProto.sWh;
        localObject3 = ((yy)localObject2).sXG;
        localObject1 = ((yy)localObject2).title;
        localObject2 = ((yy)localObject2).desc;
      }
      localObject4 = localObject3;
      if (localyp != null)
      {
        localObject4 = localObject3;
        if (bk.bl((String)localObject3)) {
          localObject4 = localyp.eAl;
        }
      }
    } while (bk.bl((String)localObject4));
    xv localxv = com.tencent.mm.plugin.fav.a.b.c(paramg);
    Object localObject5 = localObject1;
    Object localObject6 = localObject2;
    if (localxv != null)
    {
      localObject3 = localObject1;
      if (bk.bl((String)localObject1)) {
        localObject3 = localxv.title;
      }
      localObject5 = localObject3;
      localObject6 = localObject2;
      if (bk.bl((String)localObject2))
      {
        localObject6 = localxv.desc;
        localObject5 = localObject3;
      }
    }
    y.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId) });
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
    ((Intent)localObject1).putExtra("showShare", paramBoolean);
    ((Intent)localObject1).putExtra("is_favorite_item", true);
    ((Intent)localObject1).putExtra("fav_local_id", paramg.field_localId);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_chat", paramg.aPX());
    ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_sns", paramg.aPY());
    if ((paramg.field_favProto.sWq & 0x4) != 0)
    {
      paramBoolean = true;
      ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_weibo", paramBoolean);
      if ((paramg.field_favProto.sWq & 0x8) == 0) {
        break label1053;
      }
      paramBoolean = true;
      label521:
      ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_cplink", paramBoolean);
      if ((paramg.field_favProto.sWq & 0x10) == 0) {
        break label1058;
      }
      paramBoolean = true;
      label545:
      ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_browser", paramBoolean);
      if ((paramg.field_favProto.sWq & 0x20) == 0) {
        break label1063;
      }
      paramBoolean = true;
      label569:
      ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_weiyun", paramBoolean);
      if ((paramg.field_favProto.sWq & 0x40) == 0) {
        break label1068;
      }
    }
    label1053:
    label1058:
    label1063:
    label1068:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((Bundle)localObject2).putBoolean("key_ctrl_flag_open_facebook", paramBoolean);
      y.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[] { ((Bundle)localObject2).toString() });
      ((Intent)localObject1).putExtra("favorite_control_argument", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("sentUsername", paramg.field_fromUser);
      if ((localyp != null) && (!bk.bl(localyp.bFn))) {
        ((Intent)localObject1).putExtra("srcDisplayname", r.gV(localyp.bFn));
      }
      ((Intent)localObject1).putExtra("mode", 1);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_snsad_statextstr", com.tencent.mm.plugin.fav.a.b.c(paramg).bYN);
      ((Bundle)localObject2).putLong("favlocalid", paramg.field_localId);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("from_scence", 4);
      localObject2 = "fav_" + q.Gj() + "_" + paramg.field_id;
      ((Intent)localObject1).putExtra("KPublisherId", (String)localObject2);
      ((Intent)localObject1).putExtra("pre_username", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("prePublishId", (String)localObject2);
      ((Intent)localObject1).putExtra("preUsername", paramg.field_fromUser);
      ((Intent)localObject1).putExtra("share_report_pre_msg_url", (String)localObject4);
      ((Intent)localObject1).putExtra("share_report_pre_msg_title", localObject5);
      ((Intent)localObject1).putExtra("share_report_pre_msg_desc", (String)localObject6);
      ((Intent)localObject1).putExtra("share_report_pre_msg_icon_url", G(paramg));
      ((Intent)localObject1).putExtra("share_report_pre_msg_appid", "");
      ((Intent)localObject1).putExtra("share_report_from_scene", 4);
      localObject2 = com.tencent.mm.modelstat.a.b.nv(com.tencent.mm.pluginsdk.model.d.class.getName());
      ((Bundle)localObject2).putInt("mm_rpt_fav_id", paramg.field_id);
      ((Bundle)localObject2).putInt("key_detail_fav_scene", paramyl.scene);
      ((Bundle)localObject2).putInt("key_detail_fav_sub_scene", paramyl.jYS);
      ((Bundle)localObject2).putInt("key_detail_fav_index", paramyl.index);
      ((Bundle)localObject2).putString("key_detail_fav_query", paramyl.bVk);
      ((Bundle)localObject2).putString("key_detail_fav_sessionid", paramyl.bIB);
      ((Bundle)localObject2).putString("key_detail_fav_tags", paramyl.jYU);
      i.da("WebViewUI", paramyl.bIB);
      ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_scene", 14);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label521;
      paramBoolean = false;
      break label545;
      paramBoolean = false;
      break label569;
    }
  }
  
  private static void e(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, yl paramyl)
  {
    Intent localIntent = new Intent();
    a(paramg, paramyl, localIntent);
    i.da("FavoriteImgDetailUI", paramyl.bIB);
    com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteImgDetailUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d
 * JD-Core Version:    0.7.0.1
 */