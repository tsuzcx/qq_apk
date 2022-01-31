package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends c<gi>
{
  public m()
  {
    AppMethodBeat.i(74284);
    this.__eventId = gi.class.getName().hashCode();
    AppMethodBeat.o(74284);
  }
  
  private static boolean d(gi paramgi)
  {
    AppMethodBeat.i(74285);
    switch (paramgi.cuX.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74285);
      return false;
      Object localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.wVq != null))
      {
        paramgi.cuY.aSH = new ArrayList();
        paramgi.cuY.aSH.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.wVq);
        continue;
        if (paramgi.cuX.cuZ != null)
        {
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(paramgi.cuX.cuZ));
          if (((com.tencent.mm.vfs.b)localObject1).exists()) {
            paramgi.cuY.path = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
          }
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramgi.cuX.cuZ));
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            paramgi.cuY.thumbPath = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
            continue;
            ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().add(paramgi.cuX.cvb);
            paramgi.cuY.ret = 0;
            continue;
            ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().remove(paramgi.cuX.cvb);
            paramgi.cuY.ret = 0;
            continue;
            paramgi.cuY.cvk = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwI();
            paramgi.cuY.ret = 0;
            continue;
            localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
            paramgi.cuY.cvj = com.tencent.mm.plugin.fav.a.b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto);
            paramgi.cuY.ret = 0;
            continue;
            localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
            ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramgi.cuX.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgi.cuX.cvi);
            paramgi.cuY.ret = 0;
            continue;
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM), paramgi.cuX.handler);
            paramgi.cuY.thumbPath = localObject1[0];
            paramgi.cuY.thumbUrl = localObject1[1];
            paramgi.cuY.ret = 0;
            continue;
            com.tencent.mm.plugin.fav.a.b.a(paramgi.cuX.cpM, paramgi.cuX.cvc);
            continue;
            Object localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
            com.tencent.mm.plugin.fav.a.b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramgi.cuX.cpT != null) {
                localObject1 = com.tencent.mm.plugin.fav.a.b.a(paramgi.cuX.cpT);
              }
            }
            i.a(paramgi.cuX.context, paramgi.cuX.toUser, paramgi.cuX.cvd, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgi.cuX.cvc);
            continue;
            if (com.tencent.mm.plugin.fav.a.b.f(paramgi.cuX.cuZ))
            {
              paramgi.cuY.ret = 1;
            }
            else
            {
              paramgi.cuY.ret = 0;
              continue;
              com.tencent.mm.plugin.fav.a.b.l(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM));
              continue;
              com.tencent.mm.plugin.fav.a.b.m(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM));
              continue;
              paramgi.cuY.ret = com.tencent.mm.plugin.fav.a.b.NC(paramgi.cuX.cuZ.wSR);
              continue;
              localObject1 = new ArrayList();
              ((List)localObject1).add(Integer.valueOf(7));
              localObject2 = com.tencent.mm.plugin.fav.a.b.a(null, null, (List)localObject1, null, null, null);
              localObject1 = new ArrayList();
              localObject2 = ((List)localObject2).iterator();
              Object localObject5;
              Object localObject4;
              Object localObject6;
              while (((Iterator)localObject2).hasNext())
              {
                localObject5 = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next();
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.wVa;
                if (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7)
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = k((aca)localObject5);
                  ((List)localObject1).add(com.tencent.mm.aw.f.a(6, null, ((aca)localObject5).title, ((aca)localObject5).desc, ((aca)localObject5).wSJ, ((aca)localObject5).wSN, ((aca)localObject5).wSL, ((aca)localObject5).mBq, com.tencent.mm.plugin.fav.a.b.bwd(), (String)localObject6, "", ((acw)localObject4).appId));
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.wVc != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.wVc.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (aca)((Iterator)localObject5).next();
                    if (((aca)localObject6).dataType == 7)
                    {
                      String str = k((aca)localObject6);
                      ((List)localObject1).add(com.tencent.mm.aw.f.a(6, null, ((aca)localObject6).title, ((aca)localObject6).desc, ((aca)localObject6).wSJ, ((aca)localObject6).wSN, ((aca)localObject6).wSL, ((aca)localObject6).mBq, com.tencent.mm.plugin.fav.a.b.bwd(), str, "", ((acw)localObject4).appId));
                    }
                  }
                }
              }
              paramgi.cuY.cvl = ((List)localObject1);
              continue;
              if (paramgi.cuX.cpM == -1L)
              {
                h.a(paramgi.cuX.title, paramgi.cuX.cpT.wVc, -1L);
              }
              else if (paramgi.cuX.cve == -1)
              {
                localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.size() > 1))
                {
                  localObject1 = (aca)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.get(0);
                  paramgi.cuY.cvo = bo.isNullOrNil(((aca)localObject1).wSC);
                }
              }
              else if ((paramgi.cuX.cve == -3) && (paramgi.cuX.cpM > 0L))
              {
                localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramgi.cuX.cva.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramgi.cuX.cva.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).NF(paramgi.cuX.cva.getStringExtra("fav_note_xml"));
                  ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramgi.cuX.cve == -2) && (paramgi.cuX.cpM > 0L))
                {
                  localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!bo.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).NF(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.size() > 1))
                    {
                      localObject2 = (aca)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.get(0);
                      if ((!bo.isNullOrNil(((aca)localObject2).wSC)) && (!bo.isNullOrNil(((aca)localObject2).wSE)))
                      {
                        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramgi.cuX.cpM > 0L) && (!bo.isNullOrNil(paramgi.cuX.desc)) && (paramgi.cuX.cve > 0))
                {
                  localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.s((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = h.a(paramgi.cuX.cpT.wVc, paramgi.cuX.cpM);
                if (!bo.isNullOrNil(paramgi.cuX.desc))
                {
                  if (paramgi.cuX.cve > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramgi.cuX.cva = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  com.tencent.mm.plugin.fav.a.b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramgi.cuX.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      h.a(paramgi.cuX.title, paramgi.cuX.cpT.wVc, paramgi.cuX.cpM);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    com.tencent.mm.plugin.fav.a.b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ao.bxf().bxg();
                  localObject1 = ao.bxf();
                  localObject2 = paramgi.cuX.title;
                  int i = paramgi.cuX.cve;
                  int j = paramgi.cuX.cvf;
                  ((ao)localObject1).path = bo.bf((String)localObject2, "");
                  ((ao)localObject1).cve = i;
                  ((ao)localObject1).duration = j;
                  continue;
                  paramgi.cuY.path = j.C(paramgi.cuX.context, paramgi.cuX.cvf).toString();
                  continue;
                  ao.bxf();
                  ao.bxh().destroy();
                  continue;
                  ao.bxf();
                  ao.bxh().bwB();
                  continue;
                  localObject1 = paramgi.cuY;
                  ao.bxf();
                  ((gi.b)localObject1).cvm = ao.bxh().ad(paramgi.cuX.path, paramgi.cuX.cve, paramgi.cuX.cvf);
                  continue;
                  ao.bxf();
                  ao.bxh().stopPlay();
                  continue;
                  localObject1 = paramgi.cuY;
                  ao.bxf();
                  ((gi.b)localObject1).path = ao.bxh().path;
                  localObject1 = paramgi.cuY;
                  ao.bxf();
                  ((gi.b)localObject1).cvm = ao.bxh().bwz();
                  localObject1 = paramgi.cuY;
                  ao.bxf();
                  ((gi.b)localObject1).cvn = ao.bxh().bwA();
                  localObject1 = paramgi.cuY;
                  ao.bxf();
                  localObject2 = ao.bxh();
                  boolean bool;
                  if (((n)localObject2).mtU == null)
                  {
                    ab.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2471:
                    ((gi.b)localObject1).cvo = bool;
                    paramgi = paramgi.cuY;
                    ao.bxf();
                    localObject1 = ao.bxh();
                    if (((n)localObject1).mtU != null) {
                      break label2534;
                    }
                    ab.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2534:
                  for (double d = 0.0D;; d = ((n)localObject1).mtU.Er())
                  {
                    paramgi.cvp = d;
                    break;
                    bool = ((n)localObject2).mtU.Ds();
                    break label2471;
                  }
                  if (paramgi.cuX.cuZ != null)
                  {
                    localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(paramgi.cuX.cuZ));
                    paramgi.cuY.path = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
                    localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramgi.cuX.cuZ));
                    paramgi.cuY.thumbPath = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
                    continue;
                    localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                    if (localObject1 == null)
                    {
                      com.tencent.mm.plugin.fav.a.b.b(paramgi.cuX.cuZ, paramgi.cuX.cve, paramgi.cuX.cpM);
                      com.tencent.mm.plugin.fav.a.b.a(paramgi.cuX.cuZ, paramgi.cuX.cve, paramgi.cuX.cpM);
                    }
                    else if (bo.isNullOrNil(paramgi.cuX.path))
                    {
                      com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgi.cuX.cuZ, true);
                    }
                    else
                    {
                      com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgi.cuX.cuZ);
                      continue;
                      com.tencent.mm.plugin.fav.a.b.c(paramgi);
                      continue;
                      localObject1 = (al)paramgi.cuX.cqE;
                      paramgi.cuY.path = ((al)localObject1).muy;
                      if ((((al)localObject1).getReqResp() != null) && (((al)localObject1).getReqResp().getRespObj() != null) && (((al)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramgi = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(((al)localObject1).muu);
                        if ((paramgi != null) && (paramgi.field_favProto != null) && (paramgi.field_favProto.wVc != null))
                        {
                          paramgi.field_favProto.MQ(paramgi.field_favProto.version + 2);
                          paramgi.field_itemStatus = 1;
                          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramgi, new String[] { "localId" });
                          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramgi.cuX.cpT != null) {
                              localObject1 = com.tencent.mm.plugin.fav.a.b.a(paramgi.cuX.cpT);
                            }
                          }
                          localObject2 = new k();
                          localObject4 = paramgi.cuY;
                          if ((!((k)localObject2).t((com.tencent.mm.plugin.fav.a.g)localObject1)) || (com.tencent.mm.plugin.fav.a.b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((gi.b)localObject4).ret = i;
                            paramgi.cuY.cvo = k.u((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramgi.cuY.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramgi.cuY.cvo = true;
                            paramgi.cuY.path = null;
                            break;
                          }
                          localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.aJ(paramgi.cuX.cpT.wVc);
                            ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramgi.cuX.cpT = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              com.tencent.mm.plugin.fav.a.b.bvY();
                              continue;
                              paramgi = paramgi.cuY;
                              if (com.tencent.mm.plugin.fav.a.b.bwh()) {}
                              for (i = 1;; i = 0)
                              {
                                paramgi.ret = i;
                                break;
                              }
                              com.tencent.mm.plugin.fav.a.b.e(paramgi.cuX.context, paramgi.cuX.desc, paramgi.cuX.title, paramgi.cuX.path);
                              continue;
                              ab.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramgi.cuX.cvg });
                              if (!bo.isNullOrNil(paramgi.cuX.cvg))
                              {
                                paramgi = paramgi.cuX.cvg.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramgi));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramgi = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(i);
                                        localObject4 = new acg();
                                        ((acg)localObject4).woD = i;
                                        if ((localObject2 != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((acg)localObject4).woJ = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramgi.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((ae)com.tencent.mm.kernel.g.G(ae.class)).checkFavItem(paramgi);
                                  ab.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    ab.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramgi.cuX.cvg, paramgi.cuX.cvh });
                                    i = bo.getInt(paramgi.cuX.cvg, -1);
                                    paramgi = bo.P(paramgi.cuX.cvh.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramgi);
                                    paramgi = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(i);
                                    if (paramgi != null) {
                                      break label3696;
                                    }
                                    ab.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    com.tencent.mm.plugin.fav.a.h.vQ(8);
                                  }
                                  catch (Exception paramgi)
                                  {
                                    ab.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramgi, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3696:
                                  localObject1 = new act();
                                  ((act)localObject1).woD = i;
                                  localObject4 = paramgi.field_favProto.wVc.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (aca)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((aca)localObject5).mBq + "#0"))
                                    {
                                      if (bo.isNullOrNil(((aca)localObject5).wSE))
                                      {
                                        com.tencent.mm.al.f.afP();
                                        ((aca)localObject5).anv(a.afG());
                                        com.tencent.mm.plugin.fav.a.h.vQ(2);
                                      }
                                      if (!e.cN(com.tencent.mm.plugin.fav.a.b.b((aca)localObject5))) {
                                        break label3942;
                                      }
                                      ((aca)localObject5).ML(1);
                                      com.tencent.mm.plugin.fav.a.b.a((aca)localObject5, paramgi, 0, false);
                                      com.tencent.mm.plugin.fav.a.h.vQ(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((aca)localObject5).mBq + "#1")) {
                                        break;
                                      }
                                      if (bo.isNullOrNil(((aca)localObject5).wSE))
                                      {
                                        com.tencent.mm.al.f.afP();
                                        ((aca)localObject5).anv(a.afG());
                                        com.tencent.mm.plugin.fav.a.h.vQ(2);
                                      }
                                      if (!e.cN(com.tencent.mm.plugin.fav.a.b.c((aca)localObject5))) {
                                        break label3994;
                                      }
                                      ((aca)localObject5).ML(-1);
                                      com.tencent.mm.plugin.fav.a.b.a((aca)localObject5, paramgi, 0);
                                      com.tencent.mm.plugin.fav.a.h.vQ(3);
                                      i = 1;
                                      break;
                                      label3942:
                                      com.tencent.mm.plugin.fav.a.h.vQ(5);
                                      localObject6 = new ado();
                                      ((ado)localObject6).wJF = ((aca)localObject5).mBq;
                                      ((ado)localObject6).wJL = 0;
                                      ((ado)localObject6).jJS = 4;
                                      ((act)localObject1).wVf.add(localObject6);
                                    }
                                    label3994:
                                    com.tencent.mm.plugin.fav.a.h.vQ(5);
                                    localObject6 = new ado();
                                    ((ado)localObject6).wJF = ((aca)localObject5).mBq;
                                    ((ado)localObject6).wJL = 1;
                                    ((ado)localObject6).jJS = 4;
                                    ((act)localObject1).wVf.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    ab.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    com.tencent.mm.plugin.fav.a.h.vR(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new ado();
                                        ((ado)localObject5).wJF = localObject4[0];
                                        ((ado)localObject5).wJL = Integer.valueOf(localObject4[1]).intValue();
                                        ((ado)localObject5).jJS = 3;
                                        ((act)localObject1).wVf.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((act)localObject1).wVf.size() > 0) {
                                    ((ae)com.tencent.mm.kernel.g.G(ae.class)).checkFavItem((act)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramgi.field_type == 18) {
                                      paramgi.field_favProto.MQ(paramgi.field_favProto.version + 1);
                                    }
                                    paramgi.field_itemStatus = 15;
                                    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramgi, new String[] { "localId" });
                                    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
                                    com.tencent.mm.plugin.fav.a.h.vQ(6);
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.h.vQ(7);
                                    ab.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
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
  
  private static String k(aca paramaca)
  {
    AppMethodBeat.i(74286);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramaca));
    if (!localb.exists()) {
      if (paramaca.cpH == null) {
        paramaca = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74286);
      return paramaca;
      paramaca = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(paramaca.cpH.getBytes()));
      if (paramaca.exists())
      {
        paramaca = com.tencent.mm.vfs.j.p(paramaca.dQJ());
      }
      else
      {
        paramaca = "";
        continue;
        paramaca = com.tencent.mm.vfs.j.p(localb.dQJ());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.m
 * JD-Core Version:    0.7.0.1
 */