package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends c<gx>
{
  public q()
  {
    AppMethodBeat.i(160917);
    this.__eventId = gx.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(gx paramgx)
  {
    AppMethodBeat.i(107062);
    switch (paramgx.dub.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.GCs != null))
      {
        paramgx.duc.bzf = new ArrayList();
        paramgx.duc.bzf.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.GCs);
        continue;
        if (paramgx.dub.dud != null)
        {
          localObject1 = new com.tencent.mm.vfs.k(b.d(paramgx.dub.dud));
          if (((com.tencent.mm.vfs.k)localObject1).exists()) {
            paramgx.duc.path = w.B(((com.tencent.mm.vfs.k)localObject1).fTh());
          }
          localObject1 = new com.tencent.mm.vfs.k(b.a(paramgx.dub.dud));
          if (((com.tencent.mm.vfs.k)localObject1).exists())
          {
            paramgx.duc.thumbPath = w.B(((com.tencent.mm.vfs.k)localObject1).fTh());
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(paramgx.dub.duf);
            paramgx.duc.ret = 0;
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(paramgx.dub.duf);
            paramgx.duc.ret = 0;
            continue;
            paramgx.duc.duo = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwL();
            paramgx.duc.ret = 0;
            continue;
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
            if (localObject1 == null) {}
            for (paramgx.duc.dun = null;; paramgx.duc.dun = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramgx.duc.ret = 0;
              break;
            }
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramgx.dub.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgx.dub.dum);
            paramgx.duc.ret = 0;
            continue;
            localObject1 = b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH), paramgx.dub.handler);
            paramgx.duc.thumbPath = localObject1[0];
            paramgx.duc.thumbUrl = localObject1[1];
            paramgx.duc.ret = 0;
            continue;
            b.b(paramgx.dub.doH, paramgx.dub.dug);
            continue;
            Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramgx.dub.doN != null) {
                localObject1 = b.a(paramgx.dub.doN);
              }
            }
            l.a(paramgx.dub.context, paramgx.dub.toUser, paramgx.dub.duh, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgx.dub.dug);
            continue;
            if (b.g(paramgx.dub.dud))
            {
              paramgx.duc.ret = 1;
            }
            else
            {
              paramgx.duc.ret = 0;
              continue;
              b.l(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH));
              continue;
              b.m(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH));
              continue;
              paramgx.duc.ret = b.ahf(paramgx.dub.dud.GzP);
              continue;
              localObject1 = new ArrayList();
              ((List)localObject1).add(Integer.valueOf(7));
              localObject2 = b.a(null, null, (List)localObject1, null, null, null);
              localObject1 = new ArrayList();
              localObject2 = ((List)localObject2).iterator();
              Object localObject5;
              Object localObject4;
              Object localObject6;
              while (((Iterator)localObject2).hasNext())
              {
                localObject5 = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next();
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.GCe;
                if (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7)
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((ajx)localObject5);
                  localObject4 = com.tencent.mm.ay.g.a(6, null, ((ajx)localObject5).title, ((ajx)localObject5).desc, ((ajx)localObject5).GzH, ((ajx)localObject5).GzL, ((ajx)localObject5).GzJ, ((ajx)localObject5).dua, b.cwi(), (String)localObject6, "", ((akt)localObject4).appId);
                  ((com.tencent.mm.ay.f)localObject4).ikq = ((ajx)localObject5).songAlbumUrl;
                  ((com.tencent.mm.ay.f)localObject4).iki = ((ajx)localObject5).songLyric;
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.oeJ != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.oeJ.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (ajx)((Iterator)localObject5).next();
                    if (((ajx)localObject6).dataType == 7)
                    {
                      Object localObject7 = m((ajx)localObject6);
                      localObject7 = com.tencent.mm.ay.g.a(6, null, ((ajx)localObject6).title, ((ajx)localObject6).desc, ((ajx)localObject6).GzH, ((ajx)localObject6).GzL, ((ajx)localObject6).GzJ, ((ajx)localObject6).dua, b.cwi(), (String)localObject7, "", ((akt)localObject4).appId);
                      ((com.tencent.mm.ay.f)localObject7).ikq = ((ajx)localObject6).songAlbumUrl;
                      ((com.tencent.mm.ay.f)localObject7).iki = ((ajx)localObject6).songLyric;
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramgx.duc.dup = ((List)localObject1);
              continue;
              if (paramgx.dub.doH == -1L)
              {
                k.a(paramgx.dub.title, paramgx.dub.doN.oeJ, -1L);
              }
              else if (paramgx.dub.dui == -1)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.size() > 1))
                {
                  localObject1 = (ajx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.get(0);
                  paramgx.duc.dus = bu.isNullOrNil(((ajx)localObject1).GzA);
                }
              }
              else if ((paramgx.dub.dui == -3) && (paramgx.dub.doH > 0L))
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramgx.dub.due.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramgx.dub.due.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).ahi(paramgx.dub.due.getStringExtra("fav_note_xml"));
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramgx.dub.dui == -2) && (paramgx.dub.doH > 0L))
                {
                  localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!bu.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).ahi(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.size() > 1))
                    {
                      localObject2 = (ajx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.get(0);
                      if ((!bu.isNullOrNil(((ajx)localObject2).GzA)) && (!bu.isNullOrNil(((ajx)localObject2).GzC)))
                      {
                        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramgx.dub.doH > 0L) && (!bu.isNullOrNil(paramgx.dub.desc)) && (paramgx.dub.dui > 0))
                {
                  localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramgx.dub.doN.oeJ, paramgx.dub.doH);
                if (!bu.isNullOrNil(paramgx.dub.desc))
                {
                  if (paramgx.dub.dui > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramgx.dub.due = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aaw(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramgx.dub.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aaw(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramgx.dub.title, paramgx.dub.doN.oeJ, paramgx.dub.doH);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aaw(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aaw(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aaw(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ap.cxi().cxj();
                  localObject1 = ap.cxi();
                  localObject2 = paramgx.dub.title;
                  int i = paramgx.dub.dui;
                  int j = paramgx.dub.duj;
                  ((ap)localObject1).path = bu.bI((String)localObject2, "");
                  ((ap)localObject1).dui = i;
                  ((ap)localObject1).duration = j;
                  continue;
                  paramgx.duc.path = m.G(paramgx.dub.context, paramgx.dub.duj).toString();
                  continue;
                  ap.cxi();
                  ap.cxk().destroy();
                  continue;
                  ap.cxi();
                  ap.cxk().cwF();
                  continue;
                  localObject1 = paramgx.duc;
                  ap.cxi();
                  ((gx.b)localObject1).duq = ap.cxk().aa(paramgx.dub.path, paramgx.dub.dui, paramgx.dub.duj);
                  continue;
                  ap.cxi();
                  ap.cxk().stopPlay();
                  continue;
                  localObject1 = paramgx.duc;
                  ap.cxi();
                  ((gx.b)localObject1).path = ap.cxk().path;
                  localObject1 = paramgx.duc;
                  ap.cxi();
                  ((gx.b)localObject1).duq = ap.cxk().cgS();
                  localObject1 = paramgx.duc;
                  ap.cxi();
                  ((gx.b)localObject1).dur = ap.cxk().cwE();
                  localObject1 = paramgx.duc;
                  ap.cxi();
                  localObject2 = ap.cxk();
                  boolean bool;
                  if (((n)localObject2).pEU == null)
                  {
                    ae.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2539:
                    ((gx.b)localObject1).dus = bool;
                    paramgx = paramgx.duc;
                    ap.cxi();
                    localObject1 = ap.cxk();
                    if (((n)localObject1).pEU != null) {
                      break label2602;
                    }
                    ae.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2602:
                  for (double d = 0.0D;; d = ((n)localObject1).pEU.PE())
                  {
                    paramgx.dut = d;
                    break;
                    bool = ((n)localObject2).pEU.OG();
                    break label2539;
                  }
                  if (paramgx.dub.dud != null)
                  {
                    localObject1 = new com.tencent.mm.vfs.k(b.d(paramgx.dub.dud));
                    paramgx.duc.path = w.B(((com.tencent.mm.vfs.k)localObject1).fTh());
                    localObject1 = new com.tencent.mm.vfs.k(b.a(paramgx.dub.dud));
                    paramgx.duc.thumbPath = w.B(((com.tencent.mm.vfs.k)localObject1).fTh());
                    continue;
                    localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                    if (localObject1 == null)
                    {
                      b.b(paramgx.dub.dud, paramgx.dub.dui, paramgx.dub.doH);
                      b.a(paramgx.dub.dud, paramgx.dub.dui, paramgx.dub.doH);
                    }
                    else if (bu.isNullOrNil(paramgx.dub.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgx.dub.dud, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgx.dub.dud);
                      continue;
                      b.c(paramgx);
                      continue;
                      localObject1 = (am)paramgx.dub.dpw;
                      paramgx.duc.path = ((am)localObject1).rCa;
                      if ((((am)localObject1).getReqResp() != null) && (((am)localObject1).getReqResp().getRespObj() != null) && (((am)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramgx = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(((am)localObject1).rBW);
                        if ((paramgx != null) && (paramgx.field_favProto != null) && (paramgx.field_favProto.oeJ != null))
                        {
                          paramgx.field_favProto.aaw(paramgx.field_favProto.version + 2);
                          paramgx.field_itemStatus = 1;
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgx, new String[] { "localId" });
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramgx.dub.doN != null) {
                              localObject1 = b.a(paramgx.dub.doN);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramgx.duc;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((gx.b)localObject4).ret = i;
                            paramgx.duc.dus = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramgx.duc.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramgx.duc.dus = true;
                            paramgx.duc.path = null;
                            break;
                          }
                          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.bm(paramgx.dub.doN.oeJ);
                            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramgx.dub.doN = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.eN(paramgx.dub.context);
                              continue;
                              paramgx = paramgx.duc;
                              if (b.cwm()) {}
                              for (i = 1;; i = 0)
                              {
                                paramgx.ret = i;
                                break;
                              }
                              b.c(paramgx.dub.context, paramgx.dub.desc, paramgx.dub.title, paramgx.dub.path);
                              continue;
                              ae.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramgx.dub.duk });
                              if (!bu.isNullOrNil(paramgx.dub.duk))
                              {
                                paramgx = paramgx.dub.duk.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramgx));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramgx = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(i);
                                        localObject4 = new akd();
                                        ((akd)localObject4).FNu = i;
                                        if ((localObject2 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((akd)localObject4).FNA = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramgx.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem(paramgx);
                                  ae.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    ae.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramgx.dub.duk, paramgx.dub.dul });
                                    i = bu.getInt(paramgx.dub.duk, -1);
                                    paramgx = bu.U(paramgx.dub.dul.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramgx);
                                    paramgx = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(i);
                                    if (paramgx != null) {
                                      break label3771;
                                    }
                                    ae.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    com.tencent.mm.plugin.fav.a.h.Ei(8);
                                  }
                                  catch (Exception paramgx)
                                  {
                                    ae.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramgx, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3771:
                                  localObject1 = new akq();
                                  ((akq)localObject1).FNu = i;
                                  localObject4 = paramgx.field_favProto.oeJ.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (ajx)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((ajx)localObject5).dua + "#0"))
                                    {
                                      if (bu.isNullOrNil(((ajx)localObject5).GzC))
                                      {
                                        com.tencent.mm.an.f.aHa();
                                        ((ajx)localObject5).aPH(a.aGP());
                                        com.tencent.mm.plugin.fav.a.h.Ei(2);
                                      }
                                      if (!com.tencent.mm.vfs.o.fB(b.d((ajx)localObject5))) {
                                        break label4017;
                                      }
                                      ((ajx)localObject5).aar(1);
                                      b.a((ajx)localObject5, paramgx, 0, false);
                                      com.tencent.mm.plugin.fav.a.h.Ei(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((ajx)localObject5).dua + "#1")) {
                                        break;
                                      }
                                      if (bu.isNullOrNil(((ajx)localObject5).GzC))
                                      {
                                        com.tencent.mm.an.f.aHa();
                                        ((ajx)localObject5).aPH(a.aGP());
                                        com.tencent.mm.plugin.fav.a.h.Ei(2);
                                      }
                                      if (!com.tencent.mm.vfs.o.fB(b.a((ajx)localObject5))) {
                                        break label4069;
                                      }
                                      ((ajx)localObject5).aar(-1);
                                      b.a((ajx)localObject5, paramgx, 0);
                                      com.tencent.mm.plugin.fav.a.h.Ei(3);
                                      i = 1;
                                      break;
                                      label4017:
                                      com.tencent.mm.plugin.fav.a.h.Ei(5);
                                      localObject6 = new aln();
                                      ((aln)localObject6).Goj = ((ajx)localObject5).dua;
                                      ((aln)localObject6).Gop = 0;
                                      ((aln)localObject6).nJb = 4;
                                      ((akq)localObject1).GCi.add(localObject6);
                                    }
                                    label4069:
                                    com.tencent.mm.plugin.fav.a.h.Ei(5);
                                    localObject6 = new aln();
                                    ((aln)localObject6).Goj = ((ajx)localObject5).dua;
                                    ((aln)localObject6).Gop = 1;
                                    ((aln)localObject6).nJb = 4;
                                    ((akq)localObject1).GCi.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    ae.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    com.tencent.mm.plugin.fav.a.h.Ej(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new aln();
                                        ((aln)localObject5).Goj = localObject4[0];
                                        ((aln)localObject5).Gop = Integer.valueOf(localObject4[1]).intValue();
                                        ((aln)localObject5).nJb = 3;
                                        ((akq)localObject1).GCi.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((akq)localObject1).GCi.size() > 0) {
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem((akq)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramgx.field_type == 18) {
                                      paramgx.field_favProto.aaw(paramgx.field_favProto.version + 1);
                                    }
                                    paramgx.field_itemStatus = 15;
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgx, new String[] { "localId" });
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
                                    com.tencent.mm.plugin.fav.a.h.Ei(6);
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.h.Ei(7);
                                    ae.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramgx.duc.duu = b.b(paramgx.dub.doN);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static String m(ajx paramajx)
  {
    AppMethodBeat.i(107063);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(b.a(paramajx));
    if (!localk.exists()) {
      if (paramajx.dox == null) {
        paramajx = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramajx;
      paramajx = new com.tencent.mm.vfs.k(b.cwc() + com.tencent.mm.b.g.getMessageDigest(paramajx.dox.getBytes()));
      if (paramajx.exists())
      {
        paramajx = w.B(paramajx.fTh());
      }
      else
      {
        paramajx = "";
        continue;
        paramajx = w.B(localk.fTh());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.q
 * JD-Core Version:    0.7.0.1
 */