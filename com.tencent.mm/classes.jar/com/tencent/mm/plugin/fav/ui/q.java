package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends c<gw>
{
  public q()
  {
    AppMethodBeat.i(160917);
    this.__eventId = gw.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(gw paramgw)
  {
    AppMethodBeat.i(107062);
    switch (paramgw.dsV.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.GjJ != null))
      {
        paramgw.dsW.bzf = new ArrayList();
        paramgw.dsW.bzf.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.GjJ);
        continue;
        if (paramgw.dsV.dsX != null)
        {
          localObject1 = new e(b.d(paramgw.dsV.dsX));
          if (((e)localObject1).exists()) {
            paramgw.dsW.path = com.tencent.mm.vfs.q.B(((e)localObject1).fOK());
          }
          localObject1 = new e(b.a(paramgw.dsV.dsX));
          if (((e)localObject1).exists())
          {
            paramgw.dsW.thumbPath = com.tencent.mm.vfs.q.B(((e)localObject1).fOK());
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(paramgw.dsV.dsZ);
            paramgw.dsW.ret = 0;
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(paramgw.dsV.dsZ);
            paramgw.dsW.ret = 0;
            continue;
            paramgw.dsW.dti = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvk();
            paramgw.dsW.ret = 0;
            continue;
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
            if (localObject1 == null) {}
            for (paramgw.dsW.dth = null;; paramgw.dsW.dth = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramgw.dsW.ret = 0;
              break;
            }
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramgw.dsV.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgw.dsV.dtg);
            paramgw.dsW.ret = 0;
            continue;
            localObject1 = b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC), paramgw.dsV.handler);
            paramgw.dsW.thumbPath = localObject1[0];
            paramgw.dsW.thumbUrl = localObject1[1];
            paramgw.dsW.ret = 0;
            continue;
            b.b(paramgw.dsV.dnC, paramgw.dsV.dta);
            continue;
            Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramgw.dsV.dnI != null) {
                localObject1 = b.a(paramgw.dsV.dnI);
              }
            }
            l.a(paramgw.dsV.context, paramgw.dsV.toUser, paramgw.dsV.dtb, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgw.dsV.dta);
            continue;
            if (b.g(paramgw.dsV.dsX))
            {
              paramgw.dsW.ret = 1;
            }
            else
            {
              paramgw.dsW.ret = 0;
              continue;
              b.l(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC));
              continue;
              b.m(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC));
              continue;
              paramgw.dsW.ret = b.agi(paramgw.dsV.dsX.Ghg);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.Gjv;
                if (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7)
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((ajn)localObject5);
                  localObject4 = com.tencent.mm.az.g.a(6, null, ((ajn)localObject5).title, ((ajn)localObject5).desc, ((ajn)localObject5).GgY, ((ajn)localObject5).Ghc, ((ajn)localObject5).Gha, ((ajn)localObject5).dsU, b.cuH(), (String)localObject6, "", ((akj)localObject4).appId);
                  ((com.tencent.mm.az.f)localObject4).ihx = ((ajn)localObject5).songAlbumUrl;
                  ((com.tencent.mm.az.f)localObject4).ihp = ((ajn)localObject5).songLyric;
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.nZa != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.nZa.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (ajn)((Iterator)localObject5).next();
                    if (((ajn)localObject6).dataType == 7)
                    {
                      Object localObject7 = m((ajn)localObject6);
                      localObject7 = com.tencent.mm.az.g.a(6, null, ((ajn)localObject6).title, ((ajn)localObject6).desc, ((ajn)localObject6).GgY, ((ajn)localObject6).Ghc, ((ajn)localObject6).Gha, ((ajn)localObject6).dsU, b.cuH(), (String)localObject7, "", ((akj)localObject4).appId);
                      ((com.tencent.mm.az.f)localObject7).ihx = ((ajn)localObject6).songAlbumUrl;
                      ((com.tencent.mm.az.f)localObject7).ihp = ((ajn)localObject6).songLyric;
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramgw.dsW.dtj = ((List)localObject1);
              continue;
              if (paramgw.dsV.dnC == -1L)
              {
                k.a(paramgw.dsV.title, paramgw.dsV.dnI.nZa, -1L);
              }
              else if (paramgw.dsV.dtc == -1)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.size() > 1))
                {
                  localObject1 = (ajn)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.get(0);
                  paramgw.dsW.dtm = bt.isNullOrNil(((ajn)localObject1).GgR);
                }
              }
              else if ((paramgw.dsV.dtc == -3) && (paramgw.dsV.dnC > 0L))
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramgw.dsV.dsY.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramgw.dsV.dsY.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).agl(paramgw.dsV.dsY.getStringExtra("fav_note_xml"));
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramgw.dsV.dtc == -2) && (paramgw.dsV.dnC > 0L))
                {
                  localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!bt.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).agl(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.size() > 1))
                    {
                      localObject2 = (ajn)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.get(0);
                      if ((!bt.isNullOrNil(((ajn)localObject2).GgR)) && (!bt.isNullOrNil(((ajn)localObject2).GgT)))
                      {
                        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramgw.dsV.dnC > 0L) && (!bt.isNullOrNil(paramgw.dsV.desc)) && (paramgw.dsV.dtc > 0))
                {
                  localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramgw.dsV.dnI.nZa, paramgw.dsV.dnC);
                if (!bt.isNullOrNil(paramgw.dsV.desc))
                {
                  if (paramgw.dsV.dtc > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramgw.dsV.dsY = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramgw.dsV.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramgw.dsV.title, paramgw.dsV.dnI.nZa, paramgw.dsV.dnC);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ap.cvH().cvI();
                  localObject1 = ap.cvH();
                  localObject2 = paramgw.dsV.title;
                  int i = paramgw.dsV.dtc;
                  int j = paramgw.dsV.dtd;
                  ((ap)localObject1).path = bt.bI((String)localObject2, "");
                  ((ap)localObject1).dtc = i;
                  ((ap)localObject1).duration = j;
                  continue;
                  paramgw.dsW.path = m.G(paramgw.dsV.context, paramgw.dsV.dtd).toString();
                  continue;
                  ap.cvH();
                  ap.cvJ().destroy();
                  continue;
                  ap.cvH();
                  ap.cvJ().cve();
                  continue;
                  localObject1 = paramgw.dsW;
                  ap.cvH();
                  ((gw.b)localObject1).dtk = ap.cvJ().aa(paramgw.dsV.path, paramgw.dsV.dtc, paramgw.dsV.dtd);
                  continue;
                  ap.cvH();
                  ap.cvJ().stopPlay();
                  continue;
                  localObject1 = paramgw.dsW;
                  ap.cvH();
                  ((gw.b)localObject1).path = ap.cvJ().path;
                  localObject1 = paramgw.dsW;
                  ap.cvH();
                  ((gw.b)localObject1).dtk = ap.cvJ().cfC();
                  localObject1 = paramgw.dsW;
                  ap.cvH();
                  ((gw.b)localObject1).dtl = ap.cvJ().cvd();
                  localObject1 = paramgw.dsW;
                  ap.cvH();
                  localObject2 = ap.cvJ();
                  boolean bool;
                  if (((n)localObject2).pyq == null)
                  {
                    ad.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2539:
                    ((gw.b)localObject1).dtm = bool;
                    paramgw = paramgw.dsW;
                    ap.cvH();
                    localObject1 = ap.cvJ();
                    if (((n)localObject1).pyq != null) {
                      break label2602;
                    }
                    ad.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2602:
                  for (double d = 0.0D;; d = ((n)localObject1).pyq.PF())
                  {
                    paramgw.dtn = d;
                    break;
                    bool = ((n)localObject2).pyq.OI();
                    break label2539;
                  }
                  if (paramgw.dsV.dsX != null)
                  {
                    localObject1 = new e(b.d(paramgw.dsV.dsX));
                    paramgw.dsW.path = com.tencent.mm.vfs.q.B(((e)localObject1).fOK());
                    localObject1 = new e(b.a(paramgw.dsV.dsX));
                    paramgw.dsW.thumbPath = com.tencent.mm.vfs.q.B(((e)localObject1).fOK());
                    continue;
                    localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                    if (localObject1 == null)
                    {
                      b.b(paramgw.dsV.dsX, paramgw.dsV.dtc, paramgw.dsV.dnC);
                      b.a(paramgw.dsV.dsX, paramgw.dsV.dtc, paramgw.dsV.dnC);
                    }
                    else if (bt.isNullOrNil(paramgw.dsV.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgw.dsV.dsX, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgw.dsV.dsX);
                      continue;
                      b.c(paramgw);
                      continue;
                      localObject1 = (am)paramgw.dsV.dor;
                      paramgw.dsW.path = ((am)localObject1).rtO;
                      if ((((am)localObject1).getReqResp() != null) && (((am)localObject1).getReqResp().getRespObj() != null) && (((am)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramgw = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(((am)localObject1).rtK);
                        if ((paramgw != null) && (paramgw.field_favProto != null) && (paramgw.field_favProto.nZa != null))
                        {
                          paramgw.field_favProto.ZQ(paramgw.field_favProto.version + 2);
                          paramgw.field_itemStatus = 1;
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgw, new String[] { "localId" });
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramgw.dsV.dnI != null) {
                              localObject1 = b.a(paramgw.dsV.dnI);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramgw.dsW;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((gw.b)localObject4).ret = i;
                            paramgw.dsW.dtm = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramgw.dsW.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramgw.dsW.dtm = true;
                            paramgw.dsW.path = null;
                            break;
                          }
                          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.bl(paramgw.dsV.dnI.nZa);
                            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramgw.dsV.dnI = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.eJ(paramgw.dsV.context);
                              continue;
                              paramgw = paramgw.dsW;
                              if (b.cuL()) {}
                              for (i = 1;; i = 0)
                              {
                                paramgw.ret = i;
                                break;
                              }
                              b.c(paramgw.dsV.context, paramgw.dsV.desc, paramgw.dsV.title, paramgw.dsV.path);
                              continue;
                              ad.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramgw.dsV.dte });
                              if (!bt.isNullOrNil(paramgw.dsV.dte))
                              {
                                paramgw = paramgw.dsV.dte.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramgw));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramgw = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(i);
                                        localObject4 = new ajt();
                                        ((ajt)localObject4).FuW = i;
                                        if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((ajt)localObject4).Fvc = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramgw.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem(paramgw);
                                  ad.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramgw.dsV.dte, paramgw.dsV.dtf });
                                    i = bt.getInt(paramgw.dsV.dte, -1);
                                    paramgw = bt.U(paramgw.dsV.dtf.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramgw);
                                    paramgw = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(i);
                                    if (paramgw != null) {
                                      break label3771;
                                    }
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    com.tencent.mm.plugin.fav.a.h.DV(8);
                                  }
                                  catch (Exception paramgw)
                                  {
                                    ad.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramgw, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3771:
                                  localObject1 = new akg();
                                  ((akg)localObject1).FuW = i;
                                  localObject4 = paramgw.field_favProto.nZa.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (ajn)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((ajn)localObject5).dsU + "#0"))
                                    {
                                      if (bt.isNullOrNil(((ajn)localObject5).GgT))
                                      {
                                        com.tencent.mm.ao.f.aGJ();
                                        ((ajn)localObject5).aOk(a.aGz());
                                        com.tencent.mm.plugin.fav.a.h.DV(2);
                                      }
                                      if (!i.fv(b.d((ajn)localObject5))) {
                                        break label4017;
                                      }
                                      ((ajn)localObject5).ZL(1);
                                      b.a((ajn)localObject5, paramgw, 0, false);
                                      com.tencent.mm.plugin.fav.a.h.DV(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((ajn)localObject5).dsU + "#1")) {
                                        break;
                                      }
                                      if (bt.isNullOrNil(((ajn)localObject5).GgT))
                                      {
                                        com.tencent.mm.ao.f.aGJ();
                                        ((ajn)localObject5).aOk(a.aGz());
                                        com.tencent.mm.plugin.fav.a.h.DV(2);
                                      }
                                      if (!i.fv(b.a((ajn)localObject5))) {
                                        break label4069;
                                      }
                                      ((ajn)localObject5).ZL(-1);
                                      b.a((ajn)localObject5, paramgw, 0);
                                      com.tencent.mm.plugin.fav.a.h.DV(3);
                                      i = 1;
                                      break;
                                      label4017:
                                      com.tencent.mm.plugin.fav.a.h.DV(5);
                                      localObject6 = new ald();
                                      ((ald)localObject6).FVK = ((ajn)localObject5).dsU;
                                      ((ald)localObject6).FVQ = 0;
                                      ((ald)localObject6).nDG = 4;
                                      ((akg)localObject1).Gjz.add(localObject6);
                                    }
                                    label4069:
                                    com.tencent.mm.plugin.fav.a.h.DV(5);
                                    localObject6 = new ald();
                                    ((ald)localObject6).FVK = ((ajn)localObject5).dsU;
                                    ((ald)localObject6).FVQ = 1;
                                    ((ald)localObject6).nDG = 4;
                                    ((akg)localObject1).Gjz.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    com.tencent.mm.plugin.fav.a.h.DW(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new ald();
                                        ((ald)localObject5).FVK = localObject4[0];
                                        ((ald)localObject5).FVQ = Integer.valueOf(localObject4[1]).intValue();
                                        ((ald)localObject5).nDG = 3;
                                        ((akg)localObject1).Gjz.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((akg)localObject1).Gjz.size() > 0) {
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem((akg)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramgw.field_type == 18) {
                                      paramgw.field_favProto.ZQ(paramgw.field_favProto.version + 1);
                                    }
                                    paramgw.field_itemStatus = 15;
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgw, new String[] { "localId" });
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
                                    com.tencent.mm.plugin.fav.a.h.DV(6);
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.h.DV(7);
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramgw.dsW.dto = b.b(paramgw.dsV.dnI);
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
  
  private static String m(ajn paramajn)
  {
    AppMethodBeat.i(107063);
    e locale = new e(b.a(paramajn));
    if (!locale.exists()) {
      if (paramajn.dnv == null) {
        paramajn = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramajn;
      paramajn = new e(b.cuB() + com.tencent.mm.b.g.getMessageDigest(paramajn.dnv.getBytes()));
      if (paramajn.exists())
      {
        paramajn = com.tencent.mm.vfs.q.B(paramajn.fOK());
      }
      else
      {
        paramajn = "";
        continue;
        paramajn = com.tencent.mm.vfs.q.B(locale.fOK());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.q
 * JD-Core Version:    0.7.0.1
 */