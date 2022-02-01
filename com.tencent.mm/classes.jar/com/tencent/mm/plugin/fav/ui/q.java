package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends c<gs>
{
  public q()
  {
    AppMethodBeat.i(160917);
    this.__eventId = gs.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(gs paramgs)
  {
    AppMethodBeat.i(107062);
    switch (paramgs.dkc.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.DiR != null))
      {
        paramgs.dkd.bqk = new ArrayList();
        paramgs.dkd.bqk.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.DiR);
        continue;
        if (paramgs.dkc.dke != null)
        {
          localObject1 = new e(b.d(paramgs.dkc.dke));
          if (((e)localObject1).exists()) {
            paramgs.dkd.path = com.tencent.mm.vfs.q.B(((e)localObject1).fhU());
          }
          localObject1 = new e(b.a(paramgs.dkc.dke));
          if (((e)localObject1).exists())
          {
            paramgs.dkd.thumbPath = com.tencent.mm.vfs.q.B(((e)localObject1).fhU());
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(paramgs.dkc.dkg);
            paramgs.dkd.ret = 0;
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(paramgs.dkc.dkg);
            paramgs.dkd.ret = 0;
            continue;
            paramgs.dkd.dkp = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().chY();
            paramgs.dkd.ret = 0;
            continue;
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
            if (localObject1 == null) {}
            for (paramgs.dkd.dko = null;; paramgs.dkd.dko = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramgs.dkd.ret = 0;
              break;
            }
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramgs.dkc.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgs.dkc.dkn);
            paramgs.dkd.ret = 0;
            continue;
            localObject1 = b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL), paramgs.dkc.handler);
            paramgs.dkd.thumbPath = localObject1[0];
            paramgs.dkd.thumbUrl = localObject1[1];
            paramgs.dkd.ret = 0;
            continue;
            b.a(paramgs.dkc.deL, paramgs.dkc.dkh);
            continue;
            Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramgs.dkc.deS != null) {
                localObject1 = b.a(paramgs.dkc.deS);
              }
            }
            l.a(paramgs.dkc.context, paramgs.dkc.toUser, paramgs.dkc.dki, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgs.dkc.dkh);
            continue;
            if (b.g(paramgs.dkc.dke))
            {
              paramgs.dkd.ret = 1;
            }
            else
            {
              paramgs.dkd.ret = 0;
              continue;
              b.l(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL));
              continue;
              b.m(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL));
              continue;
              paramgs.dkd.ret = b.XX(paramgs.dkc.dke.Dgo);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.DiD;
                if (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7)
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((afy)localObject5);
                  localObject4 = com.tencent.mm.az.g.a(6, null, ((afy)localObject5).title, ((afy)localObject5).desc, ((afy)localObject5).Dgg, ((afy)localObject5).Dgk, ((afy)localObject5).Dgi, ((afy)localObject5).dkb, b.chv(), (String)localObject6, "", ((agu)localObject4).appId);
                  ((com.tencent.mm.az.f)localObject4).hnG = ((afy)localObject5).songAlbumUrl;
                  ((com.tencent.mm.az.f)localObject4).hny = ((afy)localObject5).songLyric;
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.mVb != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.mVb.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (afy)((Iterator)localObject5).next();
                    if (((afy)localObject6).dataType == 7)
                    {
                      Object localObject7 = m((afy)localObject6);
                      localObject7 = com.tencent.mm.az.g.a(6, null, ((afy)localObject6).title, ((afy)localObject6).desc, ((afy)localObject6).Dgg, ((afy)localObject6).Dgk, ((afy)localObject6).Dgi, ((afy)localObject6).dkb, b.chv(), (String)localObject7, "", ((agu)localObject4).appId);
                      ((com.tencent.mm.az.f)localObject7).hnG = ((afy)localObject6).songAlbumUrl;
                      ((com.tencent.mm.az.f)localObject7).hny = ((afy)localObject6).songLyric;
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramgs.dkd.dkq = ((List)localObject1);
              continue;
              if (paramgs.dkc.deL == -1L)
              {
                k.a(paramgs.dkc.title, paramgs.dkc.deS.mVb, -1L);
              }
              else if (paramgs.dkc.dkj == -1)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.mVb.size() > 1))
                {
                  localObject1 = (afy)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.mVb.get(0);
                  paramgs.dkd.dkt = bt.isNullOrNil(((afy)localObject1).DfZ);
                }
              }
              else if ((paramgs.dkc.dkj == -3) && (paramgs.dkc.deL > 0L))
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramgs.dkc.dkf.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramgs.dkc.dkf.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).Ya(paramgs.dkc.dkf.getStringExtra("fav_note_xml"));
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramgs.dkc.dkj == -2) && (paramgs.dkc.deL > 0L))
                {
                  localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!bt.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).Ya(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.mVb.size() > 1))
                    {
                      localObject2 = (afy)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.mVb.get(0);
                      if ((!bt.isNullOrNil(((afy)localObject2).DfZ)) && (!bt.isNullOrNil(((afy)localObject2).Dgb)))
                      {
                        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramgs.dkc.deL > 0L) && (!bt.isNullOrNil(paramgs.dkc.desc)) && (paramgs.dkc.dkj > 0))
                {
                  localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramgs.dkc.deS.mVb, paramgs.dkc.deL);
                if (!bt.isNullOrNil(paramgs.dkc.desc))
                {
                  if (paramgs.dkc.dkj > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramgs.dkc.dkf = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VL(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramgs.dkc.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VL(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramgs.dkc.title, paramgs.dkc.deS.mVb, paramgs.dkc.deL);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VL(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VL(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VL(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ap.civ().ciw();
                  localObject1 = ap.civ();
                  localObject2 = paramgs.dkc.title;
                  int i = paramgs.dkc.dkj;
                  int j = paramgs.dkc.dkk;
                  ((ap)localObject1).path = bt.by((String)localObject2, "");
                  ((ap)localObject1).dkj = i;
                  ((ap)localObject1).duration = j;
                  continue;
                  paramgs.dkd.path = m.C(paramgs.dkc.context, paramgs.dkc.dkk).toString();
                  continue;
                  ap.civ();
                  ap.cix().destroy();
                  continue;
                  ap.civ();
                  ap.cix().chS();
                  continue;
                  localObject1 = paramgs.dkd;
                  ap.civ();
                  ((gs.b)localObject1).dkr = ap.cix().Z(paramgs.dkc.path, paramgs.dkc.dkj, paramgs.dkc.dkk);
                  continue;
                  ap.civ();
                  ap.cix().stopPlay();
                  continue;
                  localObject1 = paramgs.dkd;
                  ap.civ();
                  ((gs.b)localObject1).path = ap.cix().path;
                  localObject1 = paramgs.dkd;
                  ap.civ();
                  ((gs.b)localObject1).dkr = ap.cix().bTK();
                  localObject1 = paramgs.dkd;
                  ap.civ();
                  ((gs.b)localObject1).dks = ap.cix().chR();
                  localObject1 = paramgs.dkd;
                  ap.civ();
                  localObject2 = ap.cix();
                  boolean bool;
                  if (((n)localObject2).org == null)
                  {
                    ad.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2539:
                    ((gs.b)localObject1).dkt = bool;
                    paramgs = paramgs.dkd;
                    ap.civ();
                    localObject1 = ap.cix();
                    if (((n)localObject1).org != null) {
                      break label2602;
                    }
                    ad.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2602:
                  for (double d = 0.0D;; d = ((n)localObject1).org.Oa())
                  {
                    paramgs.dku = d;
                    break;
                    bool = ((n)localObject2).org.Nb();
                    break label2539;
                  }
                  if (paramgs.dkc.dke != null)
                  {
                    localObject1 = new e(b.d(paramgs.dkc.dke));
                    paramgs.dkd.path = com.tencent.mm.vfs.q.B(((e)localObject1).fhU());
                    localObject1 = new e(b.a(paramgs.dkc.dke));
                    paramgs.dkd.thumbPath = com.tencent.mm.vfs.q.B(((e)localObject1).fhU());
                    continue;
                    localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                    if (localObject1 == null)
                    {
                      b.b(paramgs.dkc.dke, paramgs.dkc.dkj, paramgs.dkc.deL);
                      b.a(paramgs.dkc.dke, paramgs.dkc.dkj, paramgs.dkc.deL);
                    }
                    else if (bt.isNullOrNil(paramgs.dkc.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgs.dkc.dke, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgs.dkc.dke);
                      continue;
                      b.c(paramgs);
                      continue;
                      localObject1 = (am)paramgs.dkc.dfA;
                      paramgs.dkd.path = ((am)localObject1).qbg;
                      if ((((am)localObject1).getReqResp() != null) && (((am)localObject1).getReqResp().getRespObj() != null) && (((am)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramgs = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(((am)localObject1).qbc);
                        if ((paramgs != null) && (paramgs.field_favProto != null) && (paramgs.field_favProto.mVb != null))
                        {
                          paramgs.field_favProto.VL(paramgs.field_favProto.version + 2);
                          paramgs.field_itemStatus = 1;
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgs, new String[] { "localId" });
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramgs.dkc.deS != null) {
                              localObject1 = b.a(paramgs.dkc.deS);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramgs.dkd;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((gs.b)localObject4).ret = i;
                            paramgs.dkd.dkt = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramgs.dkd.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramgs.dkd.dkt = true;
                            paramgs.dkd.path = null;
                            break;
                          }
                          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.bd(paramgs.dkc.deS.mVb);
                            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramgs.dkc.deS = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.eB(paramgs.dkc.context);
                              continue;
                              paramgs = paramgs.dkd;
                              if (b.chz()) {}
                              for (i = 1;; i = 0)
                              {
                                paramgs.ret = i;
                                break;
                              }
                              b.c(paramgs.dkc.context, paramgs.dkc.desc, paramgs.dkc.title, paramgs.dkc.path);
                              continue;
                              ad.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramgs.dkc.dkl });
                              if (!bt.isNullOrNil(paramgs.dkc.dkl))
                              {
                                paramgs = paramgs.dkc.dkl.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramgs));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramgs = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(i);
                                        localObject4 = new age();
                                        ((age)localObject4).Cxl = i;
                                        if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((age)localObject4).Cxr = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramgs.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem(paramgs);
                                  ad.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramgs.dkc.dkl, paramgs.dkc.dkm });
                                    i = bt.getInt(paramgs.dkc.dkl, -1);
                                    paramgs = bt.S(paramgs.dkc.dkm.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramgs);
                                    paramgs = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(i);
                                    if (paramgs != null) {
                                      break label3771;
                                    }
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    h.Ci(8);
                                  }
                                  catch (Exception paramgs)
                                  {
                                    ad.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramgs, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3771:
                                  localObject1 = new agr();
                                  ((agr)localObject1).Cxl = i;
                                  localObject4 = paramgs.field_favProto.mVb.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (afy)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((afy)localObject5).dkb + "#0"))
                                    {
                                      if (bt.isNullOrNil(((afy)localObject5).Dgb))
                                      {
                                        com.tencent.mm.ao.f.awM();
                                        ((afy)localObject5).aDq(a.awE());
                                        h.Ci(2);
                                      }
                                      if (!com.tencent.mm.vfs.i.eK(b.d((afy)localObject5))) {
                                        break label4017;
                                      }
                                      ((afy)localObject5).VG(1);
                                      b.a((afy)localObject5, paramgs, 0, false);
                                      h.Ci(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((afy)localObject5).dkb + "#1")) {
                                        break;
                                      }
                                      if (bt.isNullOrNil(((afy)localObject5).Dgb))
                                      {
                                        com.tencent.mm.ao.f.awM();
                                        ((afy)localObject5).aDq(a.awE());
                                        h.Ci(2);
                                      }
                                      if (!com.tencent.mm.vfs.i.eK(b.a((afy)localObject5))) {
                                        break label4069;
                                      }
                                      ((afy)localObject5).VG(-1);
                                      b.a((afy)localObject5, paramgs, 0);
                                      h.Ci(3);
                                      i = 1;
                                      break;
                                      label4017:
                                      h.Ci(5);
                                      localObject6 = new aho();
                                      ((aho)localObject6).CVO = ((afy)localObject5).dkb;
                                      ((aho)localObject6).CVU = 0;
                                      ((aho)localObject6).mBi = 4;
                                      ((agr)localObject1).DiH.add(localObject6);
                                    }
                                    label4069:
                                    h.Ci(5);
                                    localObject6 = new aho();
                                    ((aho)localObject6).CVO = ((afy)localObject5).dkb;
                                    ((aho)localObject6).CVU = 1;
                                    ((aho)localObject6).mBi = 4;
                                    ((agr)localObject1).DiH.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    h.Cj(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new aho();
                                        ((aho)localObject5).CVO = localObject4[0];
                                        ((aho)localObject5).CVU = Integer.valueOf(localObject4[1]).intValue();
                                        ((aho)localObject5).mBi = 3;
                                        ((agr)localObject1).DiH.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((agr)localObject1).DiH.size() > 0) {
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem((agr)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramgs.field_type == 18) {
                                      paramgs.field_favProto.VL(paramgs.field_favProto.version + 1);
                                    }
                                    paramgs.field_itemStatus = 15;
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgs, new String[] { "localId" });
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
                                    h.Ci(6);
                                  }
                                  else
                                  {
                                    h.Ci(7);
                                    ad.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramgs.dkd.dkv = b.b(paramgs.dkc.deS);
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
  
  private static String m(afy paramafy)
  {
    AppMethodBeat.i(107063);
    e locale = new e(b.a(paramafy));
    if (!locale.exists()) {
      if (paramafy.deE == null) {
        paramafy = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramafy;
      paramafy = new e(b.chp() + com.tencent.mm.b.g.getMessageDigest(paramafy.deE.getBytes()));
      if (paramafy.exists())
      {
        paramafy = com.tencent.mm.vfs.q.B(paramafy.fhU());
      }
      else
      {
        paramafy = "";
        continue;
        paramafy = com.tencent.mm.vfs.q.B(locale.fhU());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.q
 * JD-Core Version:    0.7.0.1
 */