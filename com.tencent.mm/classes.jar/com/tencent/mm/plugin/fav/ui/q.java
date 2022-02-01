package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.a;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends IListener<hi>
{
  public q()
  {
    AppMethodBeat.i(160917);
    this.__eventId = hi.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(hi paramhi)
  {
    AppMethodBeat.i(107062);
    switch (paramhi.fEb.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.SAP != null))
      {
        paramhi.fEc.biI = new ArrayList();
        paramhi.fEc.biI.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.SAP);
        continue;
        if (paramhi.fEb.fEd != null)
        {
          localObject1 = new com.tencent.mm.vfs.q(b.d(paramhi.fEb.fEd));
          if (((com.tencent.mm.vfs.q)localObject1).ifE()) {
            paramhi.fEc.path = ((com.tencent.mm.vfs.q)localObject1).bOF();
          }
          localObject1 = new com.tencent.mm.vfs.q(b.a(paramhi.fEb.fEd));
          if (((com.tencent.mm.vfs.q)localObject1).ifE())
          {
            paramhi.fEc.thumbPath = ((com.tencent.mm.vfs.q)localObject1).bOF();
            continue;
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().add(paramhi.fEb.fEf);
            paramhi.fEc.ret = 0;
            continue;
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().remove(paramhi.fEb.fEf);
            paramhi.fEc.ret = 0;
            continue;
            paramhi.fEc.fEo = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().djV();
            paramhi.fEc.ret = 0;
            continue;
            localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
            if (localObject1 == null) {}
            for (paramhi.fEc.fEn = null;; paramhi.fEc.fEn = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramhi.fEc.ret = 0;
              break;
            }
            localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
            ((z)com.tencent.mm.kernel.h.ae(z.class)).a(paramhi.fEb.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramhi.fEb.fEm);
            paramhi.fEc.ret = 0;
            continue;
            localObject1 = b.a(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE), paramhi.fEb.handler);
            paramhi.fEc.thumbPath = localObject1[0];
            paramhi.fEc.thumbUrl = localObject1[1];
            paramhi.fEc.ret = 0;
            continue;
            b.b(paramhi.fEb.fyE, paramhi.fEb.fEg);
            continue;
            Object localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramhi.fEb.fyK != null) {
                localObject1 = b.a(paramhi.fEb.fyK);
              }
            }
            l.a(paramhi.fEb.context, paramhi.fEb.toUser, paramhi.fEb.fEh, (com.tencent.mm.plugin.fav.a.g)localObject1, paramhi.fEb.fEg);
            continue;
            if (b.g(paramhi.fEb.fEd))
            {
              paramhi.fEc.ret = 1;
            }
            else
            {
              paramhi.fEc.ret = 0;
              continue;
              b.l(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE));
              continue;
              b.m(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE));
              continue;
              paramhi.fEc.ret = b.azO(paramhi.fEb.fEd.Syc);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.SAB;
                if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7) || (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 21))
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((anm)localObject5);
                  localObject4 = com.tencent.mm.bb.g.a(6, null, ((anm)localObject5).title, ((anm)localObject5).desc, ((anm)localObject5).SxU, ((anm)localObject5).SxY, ((anm)localObject5).SxW, ((anm)localObject5).fEa, b.djr(), (String)localObject6, "", ((aoi)localObject4).appId);
                  ((com.tencent.mm.bb.f)localObject4).lVK = ((anm)localObject5).songAlbumUrl;
                  ((com.tencent.mm.bb.f)localObject4).lVC = ((anm)localObject5).songLyric;
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.syG != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.syG.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (anm)((Iterator)localObject5).next();
                    if ((((anm)localObject6).dataType == 7) || (((anm)localObject6).dataType == 29))
                    {
                      Object localObject7 = m((anm)localObject6);
                      localObject7 = com.tencent.mm.bb.g.a(6, null, ((anm)localObject6).title, ((anm)localObject6).desc, ((anm)localObject6).SxU, ((anm)localObject6).SxY, ((anm)localObject6).SxW, ((anm)localObject6).fEa, b.djr(), (String)localObject7, "", ((aoi)localObject4).appId);
                      ((com.tencent.mm.bb.f)localObject7).lVK = ((anm)localObject6).songAlbumUrl;
                      ((com.tencent.mm.bb.f)localObject7).lVC = ((anm)localObject6).songLyric;
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramhi.fEc.fEp = ((List)localObject1);
              continue;
              if (paramhi.fEb.fyE == -1L)
              {
                k.a(paramhi.fEb.title, paramhi.fEb.fyK.syG, -1L);
              }
              else if (paramhi.fEb.fEi == -1)
              {
                localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.syG.size() > 1))
                {
                  localObject1 = (anm)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.syG.get(0);
                  paramhi.fEc.fEs = Util.isNullOrNil(((anm)localObject1).Rwb);
                }
              }
              else if ((paramhi.fEb.fEi == -3) && (paramhi.fEb.fyE > 0L))
              {
                localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramhi.fEb.fEe.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramhi.fEb.fEe.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).azR(paramhi.fEb.fEe.getStringExtra("fav_note_xml"));
                  ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramhi.fEb.fEi == -2) && (paramhi.fEb.fyE > 0L))
                {
                  localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).azR(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.syG.size() > 1))
                    {
                      localObject2 = (anm)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.syG.get(0);
                      if ((!Util.isNullOrNil(((anm)localObject2).Rwb)) && (!Util.isNullOrNil(((anm)localObject2).SxP)))
                      {
                        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramhi.fEb.fyE > 0L) && (!Util.isNullOrNil(paramhi.fEb.desc)) && (paramhi.fEb.fEi > 0))
                {
                  localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramhi.fEb.fyK.syG, paramhi.fEb.fyE);
                if (!Util.isNullOrNil(paramhi.fEb.desc))
                {
                  if (paramhi.fEb.fEi > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramhi.fEb.fEe = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ary(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramhi.fEb.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ary(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramhi.fEb.title, paramhi.fEb.fyK.syG, paramhi.fEb.fyE);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ary(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ary(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ary(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  aq.dks().dkt();
                  localObject1 = aq.dks();
                  localObject2 = paramhi.fEb.title;
                  int i = paramhi.fEb.fEi;
                  int j = paramhi.fEb.fEj;
                  ((aq)localObject1).path = Util.nullAs((String)localObject2, "");
                  ((aq)localObject1).fEi = i;
                  ((aq)localObject1).duration = j;
                  continue;
                  paramhi.fEc.path = m.N(paramhi.fEb.context, paramhi.fEb.fEj).toString();
                  continue;
                  aq.dks();
                  aq.dku().destroy();
                  continue;
                  aq.dks();
                  aq.dku().djP();
                  continue;
                  localObject1 = paramhi.fEc;
                  aq.dks();
                  ((hi.b)localObject1).fEq = aq.dku().ad(paramhi.fEb.path, paramhi.fEb.fEi, paramhi.fEb.fEj);
                  continue;
                  aq.dks();
                  aq.dku().stopPlay();
                  continue;
                  localObject1 = paramhi.fEc;
                  aq.dks();
                  ((hi.b)localObject1).path = aq.dku().path;
                  localObject1 = paramhi.fEc;
                  aq.dks();
                  ((hi.b)localObject1).fEq = aq.dku().cTl();
                  localObject1 = paramhi.fEc;
                  aq.dks();
                  ((hi.b)localObject1).fEr = aq.dku().djO();
                  localObject1 = paramhi.fEc;
                  aq.dks();
                  localObject2 = aq.dku();
                  boolean bool;
                  if (((o)localObject2).uwr == null)
                  {
                    Log.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2553:
                    ((hi.b)localObject1).fEs = bool;
                    paramhi = paramhi.fEc;
                    aq.dks();
                    localObject1 = aq.dku();
                    if (((o)localObject1).uwr != null) {
                      break label2616;
                    }
                    Log.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2616:
                  for (double d = 0.0D;; d = ((o)localObject1).uwr.aeI())
                  {
                    paramhi.fEt = d;
                    break;
                    bool = ((o)localObject2).uwr.adH();
                    break label2553;
                  }
                  if (paramhi.fEb.fEd != null)
                  {
                    localObject1 = new com.tencent.mm.vfs.q(b.d(paramhi.fEb.fEd));
                    paramhi.fEc.path = ((com.tencent.mm.vfs.q)localObject1).bOF();
                    localObject1 = new com.tencent.mm.vfs.q(b.a(paramhi.fEb.fEd));
                    paramhi.fEc.thumbPath = ((com.tencent.mm.vfs.q)localObject1).bOF();
                    continue;
                    localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                    if (localObject1 == null)
                    {
                      b.b(paramhi.fEb.fEd, paramhi.fEb.fEi, paramhi.fEb.fyE);
                      b.a(paramhi.fEb.fEd, paramhi.fEb.fEi, paramhi.fEb.fyE);
                    }
                    else if (Util.isNullOrNil(paramhi.fEb.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramhi.fEb.fEd, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramhi.fEb.fEd);
                      continue;
                      b.c(paramhi);
                      continue;
                      localObject1 = (an)paramhi.fEb.fzz;
                      paramhi.fEc.path = ((an)localObject1).wHK;
                      if ((((an)localObject1).getReqResp() != null) && (((an)localObject1).getReqResp().getRespObj() != null) && (((an)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramhi = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(((an)localObject1).wHG);
                        if ((paramhi != null) && (paramhi.field_favProto != null) && (paramhi.field_favProto.syG != null))
                        {
                          paramhi.field_favProto.ary(paramhi.field_favProto.version + 2);
                          paramhi.field_itemStatus = 1;
                          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramhi, new String[] { "localId" });
                          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramhi.fEb.fyK != null) {
                              localObject1 = b.a(paramhi.fEb.fyK);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramhi.fEc;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((hi.b)localObject4).ret = i;
                            paramhi.fEc.fEs = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramhi.fEc.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramhi.fEc.fEs = true;
                            paramhi.fEc.path = null;
                            break;
                          }
                          localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.cg(paramhi.fEb.fyK.syG);
                            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramhi.fEb.fyK = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.fm(paramhi.fEb.context);
                              continue;
                              paramhi = paramhi.fEc;
                              if (b.djv()) {}
                              for (i = 1;; i = 0)
                              {
                                paramhi.ret = i;
                                break;
                              }
                              b.d(paramhi.fEb.context, paramhi.fEb.desc, paramhi.fEb.title, paramhi.fEb.path);
                              continue;
                              Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramhi.fEb.fEk });
                              if (!Util.isNullOrNil(paramhi.fEb.fEk))
                              {
                                paramhi = paramhi.fEb.fEk.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramhi));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramhi = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(i);
                                        localObject4 = new ans();
                                        ((ans)localObject4).RIr = i;
                                        if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((ans)localObject4).RIx = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramhi.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((ag)com.tencent.mm.kernel.h.ag(ag.class)).checkFavItem(paramhi);
                                  Log.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramhi.fEb.fEk, paramhi.fEb.fEl });
                                    i = Util.getInt(paramhi.fEb.fEk, -1);
                                    paramhi = Util.stringsToList(paramhi.fEb.fEl.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramhi);
                                    paramhi = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(i);
                                    if (paramhi != null) {
                                      break label3779;
                                    }
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    com.tencent.mm.plugin.fav.a.h.LD(8);
                                  }
                                  catch (Exception paramhi)
                                  {
                                    Log.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramhi, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3779:
                                  localObject1 = new aof();
                                  ((aof)localObject1).RIr = i;
                                  localObject4 = paramhi.field_favProto.syG.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (anm)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((anm)localObject5).fEa + "#0"))
                                    {
                                      if (Util.isNullOrNil(((anm)localObject5).SxP))
                                      {
                                        com.tencent.mm.aq.f.bkh();
                                        ((anm)localObject5).bsC(a.bjV());
                                        com.tencent.mm.plugin.fav.a.h.LD(2);
                                      }
                                      if (!u.agG(b.d((anm)localObject5))) {
                                        break label4025;
                                      }
                                      ((anm)localObject5).art(1);
                                      b.a((anm)localObject5, paramhi, 0, false);
                                      com.tencent.mm.plugin.fav.a.h.LD(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((anm)localObject5).fEa + "#1")) {
                                        break;
                                      }
                                      if (Util.isNullOrNil(((anm)localObject5).SxP))
                                      {
                                        com.tencent.mm.aq.f.bkh();
                                        ((anm)localObject5).bsC(a.bjV());
                                        com.tencent.mm.plugin.fav.a.h.LD(2);
                                      }
                                      if (!u.agG(b.a((anm)localObject5))) {
                                        break label4077;
                                      }
                                      ((anm)localObject5).art(-1);
                                      b.a((anm)localObject5, paramhi, 0);
                                      com.tencent.mm.plugin.fav.a.h.LD(3);
                                      i = 1;
                                      break;
                                      label4025:
                                      com.tencent.mm.plugin.fav.a.h.LD(5);
                                      localObject6 = new apd();
                                      ((apd)localObject6).Skl = ((anm)localObject5).fEa;
                                      ((apd)localObject6).Skr = 0;
                                      ((apd)localObject6).rVU = 4;
                                      ((aof)localObject1).SAF.add(localObject6);
                                    }
                                    label4077:
                                    com.tencent.mm.plugin.fav.a.h.LD(5);
                                    localObject6 = new apd();
                                    ((apd)localObject6).Skl = ((anm)localObject5).fEa;
                                    ((apd)localObject6).Skr = 1;
                                    ((apd)localObject6).rVU = 4;
                                    ((aof)localObject1).SAF.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    com.tencent.mm.plugin.fav.a.h.LE(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new apd();
                                        ((apd)localObject5).Skl = localObject4[0];
                                        ((apd)localObject5).Skr = Integer.valueOf(localObject4[1]).intValue();
                                        ((apd)localObject5).rVU = 3;
                                        ((aof)localObject1).SAF.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((aof)localObject1).SAF.size() > 0) {
                                    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).checkFavItem((aof)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramhi.field_type == 18) {
                                      paramhi.field_favProto.ary(paramhi.field_favProto.version + 1);
                                    }
                                    paramhi.field_itemStatus = 15;
                                    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramhi, new String[] { "localId" });
                                    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
                                    com.tencent.mm.plugin.fav.a.h.LD(6);
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.h.LD(7);
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramhi.fEc.fEu = b.b(paramhi.fEb.fyK);
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
  
  private static String m(anm paramanm)
  {
    AppMethodBeat.i(107063);
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(b.a(paramanm));
    if (!localq.ifE()) {
      if (paramanm.fyu == null) {
        paramanm = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramanm;
      paramanm = new com.tencent.mm.vfs.q(b.djl() + com.tencent.mm.b.g.getMessageDigest(paramanm.fyu.getBytes()));
      if (paramanm.ifE())
      {
        paramanm = paramanm.bOF();
      }
      else
      {
        paramanm = "";
        continue;
        paramanm = localq.bOF();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.q
 * JD-Core Version:    0.7.0.1
 */