package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.mm.ak.a;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.a;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.zd;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends c<gf>
{
  public m()
  {
    this.udX = gf.class.getName().hashCode();
  }
  
  private static boolean d(gf paramgf)
  {
    switch (paramgf.bNF.type)
    {
    }
    for (;;)
    {
      return false;
      Object localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.sXq != null))
      {
        paramgf.bNG.aLn = new ArrayList();
        paramgf.bNG.aLn.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.sXq);
        continue;
        if (paramgf.bNF.bNH != null)
        {
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(paramgf.bNF.bNH));
          if (((com.tencent.mm.vfs.b)localObject1).exists()) {
            paramgf.bNG.path = com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
          }
          localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramgf.bNF.bNH));
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            paramgf.bNG.thumbPath = com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
            continue;
            ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().c(paramgf.bNF.bNJ);
            paramgf.bNG.ret = 0;
            continue;
            ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().d(paramgf.bNF.bNJ);
            paramgf.bNG.ret = 0;
            continue;
            paramgf.bNG.bNS = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQt();
            paramgf.bNG.ret = 0;
            continue;
            localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
            paramgf.bNG.bNR = com.tencent.mm.plugin.fav.a.b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto);
            paramgf.bNG.ret = 0;
            continue;
            localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
            ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.fav.a.y.class)).a(paramgf.bNF.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgf.bNF.bNQ);
            paramgf.bNG.ret = 0;
            continue;
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr), paramgf.bNF.handler);
            paramgf.bNG.thumbPath = localObject1[0];
            paramgf.bNG.thumbUrl = localObject1[1];
            paramgf.bNG.ret = 0;
            continue;
            com.tencent.mm.plugin.fav.a.b.a(paramgf.bNF.bIr, paramgf.bNF.bNK);
            continue;
            Object localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
            com.tencent.mm.plugin.fav.a.b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramgf.bNF.bIy != null) {
                localObject1 = com.tencent.mm.plugin.fav.a.b.a(paramgf.bNF.bIy);
              }
            }
            i.a(paramgf.bNF.context, paramgf.bNF.toUser, paramgf.bNF.bNL, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgf.bNF.bNK);
            continue;
            if (com.tencent.mm.plugin.fav.a.b.f(paramgf.bNF.bNH))
            {
              paramgf.bNG.ret = 1;
            }
            else
            {
              paramgf.bNG.ret = 0;
              continue;
              com.tencent.mm.plugin.fav.a.b.l(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr));
              continue;
              com.tencent.mm.plugin.fav.a.b.m(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr));
              continue;
              paramgf.bNG.ret = com.tencent.mm.plugin.fav.a.b.CA(paramgf.bNF.bNH.sUV);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.sXa;
                if (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7)
                {
                  localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = k((xv)localObject5);
                  ((List)localObject1).add(com.tencent.mm.av.f.a(6, null, ((xv)localObject5).title, ((xv)localObject5).desc, ((xv)localObject5).sUN, ((xv)localObject5).sUR, ((xv)localObject5).sUP, ((xv)localObject5).kgC, com.tencent.mm.plugin.fav.a.b.aPP(), (String)localObject6, "", ((yp)localObject4).appId));
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.sXc != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.sXc.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (xv)((Iterator)localObject5).next();
                    if (((xv)localObject6).aYU == 7)
                    {
                      String str = k((xv)localObject6);
                      ((List)localObject1).add(com.tencent.mm.av.f.a(6, null, ((xv)localObject6).title, ((xv)localObject6).desc, ((xv)localObject6).sUN, ((xv)localObject6).sUR, ((xv)localObject6).sUP, ((xv)localObject6).kgC, com.tencent.mm.plugin.fav.a.b.aPP(), str, "", ((yp)localObject4).appId));
                    }
                  }
                }
              }
              paramgf.bNG.bNT = ((List)localObject1);
              continue;
              if (paramgf.bNF.bIr == -1L)
              {
                h.a(paramgf.bNF.title, paramgf.bNF.bIy.sXc, -1L);
              }
              else if (paramgf.bNF.bNM == -1)
              {
                localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sXc.size() > 1))
                {
                  localObject1 = (xv)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sXc.get(0);
                  paramgf.bNG.bNW = bk.bl(((xv)localObject1).sUG);
                }
              }
              else if ((paramgf.bNF.bNM == -3) && (paramgf.bNF.bIr > 0L))
              {
                localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramgf.bNF.bNI.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramgf.bNF.bNI.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).CD(paramgf.bNF.bNI.getStringExtra("fav_note_xml"));
                  ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramgf.bNF.bNM == -2) && (paramgf.bNF.bIr > 0L))
                {
                  localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!bk.bl(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).CD(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sXc.size() > 1))
                    {
                      localObject2 = (xv)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sXc.get(0);
                      if ((!bk.bl(((xv)localObject2).sUG)) && (!bk.bl(((xv)localObject2).sUI)))
                      {
                        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramgf.bNF.bIr > 0L) && (!bk.bl(paramgf.bNF.desc)) && (paramgf.bNF.bNM > 0))
                {
                  localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.s((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = h.a(paramgf.bNF.bIy.sXc, paramgf.bNF.bIr);
                if (!bk.bl(paramgf.bNF.desc))
                {
                  if (paramgf.bNF.bNM > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramgf.bNF.bNI = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EP(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  com.tencent.mm.plugin.fav.a.b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramgf.bNF.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EP(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      h.a(paramgf.bNF.title, paramgf.bNF.bIy.sXc, paramgf.bNF.bIr);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EP(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EP(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    com.tencent.mm.plugin.fav.a.b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EP(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ao.aQQ().aQR();
                  localObject1 = ao.aQQ();
                  localObject2 = paramgf.bNF.title;
                  int i = paramgf.bNF.bNM;
                  int j = paramgf.bNF.bNN;
                  ((ao)localObject1).path = bk.aM((String)localObject2, "");
                  ((ao)localObject1).bNM = i;
                  ((ao)localObject1).duration = j;
                  continue;
                  paramgf.bNG.path = j.x(paramgf.bNF.context, paramgf.bNF.bNN).toString();
                  continue;
                  ao.aQQ();
                  ao.aQS().destroy();
                  continue;
                  ao.aQQ();
                  ao.aQS().aQm();
                  continue;
                  localObject1 = paramgf.bNG;
                  ao.aQQ();
                  ((gf.b)localObject1).bNU = ao.aQS().P(paramgf.bNF.path, paramgf.bNF.bNM, paramgf.bNF.bNN);
                  continue;
                  ao.aQQ();
                  ao.aQS().stopPlay();
                  continue;
                  localObject1 = paramgf.bNG;
                  ao.aQQ();
                  ((gf.b)localObject1).path = ao.aQS().path;
                  localObject1 = paramgf.bNG;
                  ao.aQQ();
                  ((gf.b)localObject1).bNU = ao.aQS().aQk();
                  localObject1 = paramgf.bNG;
                  ao.aQQ();
                  ((gf.b)localObject1).bNV = ao.aQS().aQl();
                  localObject1 = paramgf.bNG;
                  ao.aQQ();
                  localObject2 = ao.aQS();
                  boolean bool;
                  if (((n)localObject2).jZC == null)
                  {
                    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2458:
                    ((gf.b)localObject1).bNW = bool;
                    paramgf = paramgf.bNG;
                    ao.aQQ();
                    localObject1 = ao.aQS();
                    if (((n)localObject1).jZC != null) {
                      break label2521;
                    }
                    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2521:
                  for (double d = 0.0D;; d = ((n)localObject1).jZC.ue())
                  {
                    paramgf.bNX = d;
                    break;
                    bool = ((n)localObject2).jZC.uf();
                    break label2458;
                  }
                  if (paramgf.bNF.bNH != null)
                  {
                    localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(paramgf.bNF.bNH));
                    paramgf.bNG.path = com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
                    localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramgf.bNF.bNH));
                    paramgf.bNG.thumbPath = com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
                    continue;
                    localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                    if (localObject1 == null)
                    {
                      com.tencent.mm.plugin.fav.a.b.b(paramgf.bNF.bNH, paramgf.bNF.bNM, paramgf.bNF.bIr);
                      com.tencent.mm.plugin.fav.a.b.a(paramgf.bNF.bNH, paramgf.bNF.bNM, paramgf.bNF.bIr);
                    }
                    else if (bk.bl(paramgf.bNF.path))
                    {
                      com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgf.bNF.bNH, true);
                    }
                    else
                    {
                      com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgf.bNF.bNH);
                      continue;
                      com.tencent.mm.plugin.fav.a.b.c(paramgf);
                      continue;
                      localObject1 = (al)paramgf.bNF.bJk;
                      paramgf.bNG.path = ((al)localObject1).kac;
                      if ((((com.tencent.mm.ah.m)localObject1).edi != null) && (((com.tencent.mm.ah.m)localObject1).edi.HF() != null) && (((com.tencent.mm.ah.m)localObject1).edi.HF().spN == -435))
                      {
                        paramgf = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(((al)localObject1).jZY);
                        if ((paramgf != null) && (paramgf.field_favProto != null) && (paramgf.field_favProto.sXc != null))
                        {
                          paramgf.field_favProto.EP(paramgf.field_favProto.version + 2);
                          paramgf.field_itemStatus = 1;
                          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramgf, new String[] { "localId" });
                          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramgf.bNF.bIy != null) {
                              localObject1 = com.tencent.mm.plugin.fav.a.b.a(paramgf.bNF.bIy);
                            }
                          }
                          localObject2 = new k();
                          localObject4 = paramgf.bNG;
                          if ((!((k)localObject2).t((com.tencent.mm.plugin.fav.a.g)localObject1)) || (com.tencent.mm.plugin.fav.a.b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((gf.b)localObject4).ret = i;
                            paramgf.bNG.bNW = k.u((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramgf.bNG.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramgf.bNG.bNW = true;
                            paramgf.bNG.path = null;
                            break;
                          }
                          localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.az(paramgf.bNF.bIy.sXc);
                            ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramgf.bNF.bIy = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              com.tencent.mm.plugin.fav.a.b.aPK();
                              continue;
                              paramgf = paramgf.bNG;
                              if (com.tencent.mm.plugin.fav.a.b.aPT()) {}
                              for (i = 1;; i = 0)
                              {
                                paramgf.ret = i;
                                break;
                              }
                              com.tencent.mm.plugin.fav.a.b.f(paramgf.bNF.context, paramgf.bNF.desc, paramgf.bNF.title, paramgf.bNF.path);
                              continue;
                              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramgf.bNF.bNO });
                              if (!bk.bl(paramgf.bNF.bNO))
                              {
                                paramgf = paramgf.bNF.bNO.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramgf));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramgf = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(i);
                                        localObject4 = new yb();
                                        ((yb)localObject4).svw = i;
                                        if ((localObject2 != null) && (!bk.bl(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((yb)localObject4).svC = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramgf.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((ae)com.tencent.mm.kernel.g.t(ae.class)).checkFavItem(paramgf);
                                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramgf.bNF.bNO, paramgf.bNF.bNP });
                                    i = bk.getInt(paramgf.bNF.bNO, -1);
                                    paramgf = bk.G(paramgf.bNF.bNP.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramgf);
                                    paramgf = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(i);
                                    if (paramgf != null) {
                                      break label3683;
                                    }
                                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    com.tencent.mm.plugin.fav.a.h.qV(8);
                                  }
                                  catch (Exception paramgf)
                                  {
                                    com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramgf, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3683:
                                  localObject1 = new ym();
                                  ((ym)localObject1).svw = i;
                                  localObject4 = paramgf.field_favProto.sXc.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (xv)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((xv)localObject5).kgC + "#0"))
                                    {
                                      if (bk.bl(((xv)localObject5).sUI))
                                      {
                                        com.tencent.mm.ak.f.Ne();
                                        ((xv)localObject5).Xz(a.MW());
                                        com.tencent.mm.plugin.fav.a.h.qV(2);
                                      }
                                      if (!e.bK(com.tencent.mm.plugin.fav.a.b.b((xv)localObject5))) {
                                        break label3929;
                                      }
                                      ((xv)localObject5).EK(1);
                                      com.tencent.mm.plugin.fav.a.b.a((xv)localObject5, paramgf, 0, false);
                                      com.tencent.mm.plugin.fav.a.h.qV(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((xv)localObject5).kgC + "#1")) {
                                        break;
                                      }
                                      if (bk.bl(((xv)localObject5).sUI))
                                      {
                                        com.tencent.mm.ak.f.Ne();
                                        ((xv)localObject5).Xz(a.MW());
                                        com.tencent.mm.plugin.fav.a.h.qV(2);
                                      }
                                      if (!e.bK(com.tencent.mm.plugin.fav.a.b.c((xv)localObject5))) {
                                        break label3981;
                                      }
                                      ((xv)localObject5).EK(-1);
                                      com.tencent.mm.plugin.fav.a.b.a((xv)localObject5, paramgf, 0);
                                      com.tencent.mm.plugin.fav.a.h.qV(3);
                                      i = 1;
                                      break;
                                      label3929:
                                      com.tencent.mm.plugin.fav.a.h.qV(5);
                                      localObject6 = new zd();
                                      ((zd)localObject6).sLS = ((xv)localObject5).kgC;
                                      ((zd)localObject6).sLY = 0;
                                      ((zd)localObject6).hQq = 4;
                                      ((ym)localObject1).sXf.add(localObject6);
                                    }
                                    label3981:
                                    com.tencent.mm.plugin.fav.a.h.qV(5);
                                    localObject6 = new zd();
                                    ((zd)localObject6).sLS = ((xv)localObject5).kgC;
                                    ((zd)localObject6).sLY = 1;
                                    ((zd)localObject6).hQq = 4;
                                    ((ym)localObject1).sXf.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    com.tencent.mm.plugin.fav.a.h.qW(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new zd();
                                        ((zd)localObject5).sLS = localObject4[0];
                                        ((zd)localObject5).sLY = Integer.valueOf(localObject4[1]).intValue();
                                        ((zd)localObject5).hQq = 3;
                                        ((ym)localObject1).sXf.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((ym)localObject1).sXf.size() > 0) {
                                    ((ae)com.tencent.mm.kernel.g.t(ae.class)).checkFavItem((ym)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramgf.field_type == 18) {
                                      paramgf.field_favProto.EP(paramgf.field_favProto.version + 1);
                                    }
                                    paramgf.field_itemStatus = 15;
                                    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramgf, new String[] { "localId" });
                                    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
                                    com.tencent.mm.plugin.fav.a.h.qV(6);
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.h.qV(7);
                                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
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
  
  private static String k(xv paramxv)
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramxv));
    if (!localb.exists())
    {
      if (paramxv.bIm == null) {
        return "";
      }
      paramxv = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(paramxv.bIm.getBytes()));
      if (paramxv.exists()) {
        return com.tencent.mm.vfs.j.n(paramxv.cLr());
      }
      return "";
    }
    return com.tencent.mm.vfs.j.n(localb.cLr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.m
 * JD-Core Version:    0.7.0.1
 */