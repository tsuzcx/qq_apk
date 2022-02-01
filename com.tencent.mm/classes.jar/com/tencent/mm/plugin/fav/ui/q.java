package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends IListener<hb>
{
  public q()
  {
    AppMethodBeat.i(160917);
    this.__eventId = hb.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(hb paramhb)
  {
    AppMethodBeat.i(107062);
    switch (paramhb.dLm.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.Lyo != null))
      {
        paramhb.dLn.bzh = new ArrayList();
        paramhb.dLn.bzh.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.Lyo);
        continue;
        if (paramhb.dLm.dLo != null)
        {
          localObject1 = new com.tencent.mm.vfs.o(b.d(paramhb.dLm.dLo));
          if (((com.tencent.mm.vfs.o)localObject1).exists()) {
            paramhb.dLn.path = aa.z(((com.tencent.mm.vfs.o)localObject1).her());
          }
          localObject1 = new com.tencent.mm.vfs.o(b.a(paramhb.dLm.dLo));
          if (((com.tencent.mm.vfs.o)localObject1).exists())
          {
            paramhb.dLn.thumbPath = aa.z(((com.tencent.mm.vfs.o)localObject1).her());
            continue;
            ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(paramhb.dLm.dLq);
            paramhb.dLn.ret = 0;
            continue;
            ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(paramhb.dLm.dLq);
            paramhb.dLn.ret = 0;
            continue;
            paramhb.dLn.dLz = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUP();
            paramhb.dLn.ret = 0;
            continue;
            localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
            if (localObject1 == null) {}
            for (paramhb.dLn.dLy = null;; paramhb.dLn.dLy = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramhb.dLn.ret = 0;
              break;
            }
            localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
            ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramhb.dLm.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramhb.dLm.dLx);
            paramhb.dLn.ret = 0;
            continue;
            localObject1 = b.a(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW), paramhb.dLm.handler);
            paramhb.dLn.thumbPath = localObject1[0];
            paramhb.dLn.thumbUrl = localObject1[1];
            paramhb.dLn.ret = 0;
            continue;
            b.b(paramhb.dLm.dFW, paramhb.dLm.dLr);
            continue;
            Object localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramhb.dLm.dGb != null) {
                localObject1 = b.a(paramhb.dLm.dGb);
              }
            }
            l.a(paramhb.dLm.context, paramhb.dLm.toUser, paramhb.dLm.dLs, (com.tencent.mm.plugin.fav.a.g)localObject1, paramhb.dLm.dLr);
            continue;
            if (b.g(paramhb.dLm.dLo))
            {
              paramhb.dLn.ret = 1;
            }
            else
            {
              paramhb.dLn.ret = 0;
              continue;
              b.l(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW));
              continue;
              b.m(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW));
              continue;
              paramhb.dLn.ret = b.arN(paramhb.dLm.dLo.LvC);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.Lya;
                if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7) || (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 21))
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((aml)localObject5);
                  localObject4 = com.tencent.mm.ay.g.a(6, null, ((aml)localObject5).title, ((aml)localObject5).desc, ((aml)localObject5).Lvu, ((aml)localObject5).Lvy, ((aml)localObject5).Lvw, ((aml)localObject5).dLl, b.cUl(), (String)localObject6, "", ((anh)localObject4).appId);
                  ((com.tencent.mm.ay.f)localObject4).jfm = ((aml)localObject5).songAlbumUrl;
                  ((com.tencent.mm.ay.f)localObject4).jfe = ((aml)localObject5).songLyric;
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.ppH != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.ppH.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (aml)((Iterator)localObject5).next();
                    if ((((aml)localObject6).dataType == 7) || (((aml)localObject6).dataType == 29))
                    {
                      Object localObject7 = m((aml)localObject6);
                      localObject7 = com.tencent.mm.ay.g.a(6, null, ((aml)localObject6).title, ((aml)localObject6).desc, ((aml)localObject6).Lvu, ((aml)localObject6).Lvy, ((aml)localObject6).Lvw, ((aml)localObject6).dLl, b.cUl(), (String)localObject7, "", ((anh)localObject4).appId);
                      ((com.tencent.mm.ay.f)localObject7).jfm = ((aml)localObject6).songAlbumUrl;
                      ((com.tencent.mm.ay.f)localObject7).jfe = ((aml)localObject6).songLyric;
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramhb.dLn.dLA = ((List)localObject1);
              continue;
              if (paramhb.dLm.dFW == -1L)
              {
                k.a(paramhb.dLm.title, paramhb.dLm.dGb.ppH, -1L);
              }
              else if (paramhb.dLm.dLt == -1)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.size() > 1))
                {
                  localObject1 = (aml)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.get(0);
                  paramhb.dLn.dLD = Util.isNullOrNil(((aml)localObject1).KuR);
                }
              }
              else if ((paramhb.dLm.dLt == -3) && (paramhb.dLm.dFW > 0L))
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramhb.dLm.dLp.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramhb.dLm.dLp.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).arQ(paramhb.dLm.dLp.getStringExtra("fav_note_xml"));
                  ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramhb.dLm.dLt == -2) && (paramhb.dLm.dFW > 0L))
                {
                  localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).arQ(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.size() > 1))
                    {
                      localObject2 = (aml)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.get(0);
                      if ((!Util.isNullOrNil(((aml)localObject2).KuR)) && (!Util.isNullOrNil(((aml)localObject2).Lvp)))
                      {
                        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramhb.dLm.dFW > 0L) && (!Util.isNullOrNil(paramhb.dLm.desc)) && (paramhb.dLm.dLt > 0))
                {
                  localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramhb.dLm.dGb.ppH, paramhb.dLm.dFW);
                if (!Util.isNullOrNil(paramhb.dLm.desc))
                {
                  if (paramhb.dLm.dLt > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramhb.dLm.dLp = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajl(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramhb.dLm.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajl(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramhb.dLm.title, paramhb.dLm.dGb.ppH, paramhb.dLm.dFW);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajl(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajl(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((af)com.tencent.mm.kernel.g.ah(af.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajl(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ap.cVm().cVn();
                  localObject1 = ap.cVm();
                  localObject2 = paramhb.dLm.title;
                  int i = paramhb.dLm.dLt;
                  int j = paramhb.dLm.dLu;
                  ((ap)localObject1).path = Util.nullAs((String)localObject2, "");
                  ((ap)localObject1).dLt = i;
                  ((ap)localObject1).duration = j;
                  continue;
                  paramhb.dLn.path = m.J(paramhb.dLm.context, paramhb.dLm.dLu).toString();
                  continue;
                  ap.cVm();
                  ap.cVo().destroy();
                  continue;
                  ap.cVm();
                  ap.cVo().cUJ();
                  continue;
                  localObject1 = paramhb.dLn;
                  ap.cVm();
                  ((hb.b)localObject1).dLB = ap.cVo().ab(paramhb.dLm.path, paramhb.dLm.dLt, paramhb.dLm.dLu);
                  continue;
                  ap.cVm();
                  ap.cVo().stopPlay();
                  continue;
                  localObject1 = paramhb.dLn;
                  ap.cVm();
                  ((hb.b)localObject1).path = ap.cVo().path;
                  localObject1 = paramhb.dLn;
                  ap.cVm();
                  ((hb.b)localObject1).dLB = ap.cVo().cEF();
                  localObject1 = paramhb.dLn;
                  ap.cVm();
                  ((hb.b)localObject1).dLC = ap.cVo().cUI();
                  localObject1 = paramhb.dLn;
                  ap.cVm();
                  localObject2 = ap.cVo();
                  boolean bool;
                  if (((n)localObject2).qUl == null)
                  {
                    Log.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2559:
                    ((hb.b)localObject1).dLD = bool;
                    paramhb = paramhb.dLn;
                    ap.cVm();
                    localObject1 = ap.cVo();
                    if (((n)localObject1).qUl != null) {
                      break label2622;
                    }
                    Log.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2622:
                  for (double d = 0.0D;; d = ((n)localObject1).qUl.ZY())
                  {
                    paramhb.dLE = d;
                    break;
                    bool = ((n)localObject2).qUl.YY();
                    break label2559;
                  }
                  if (paramhb.dLm.dLo != null)
                  {
                    localObject1 = new com.tencent.mm.vfs.o(b.d(paramhb.dLm.dLo));
                    paramhb.dLn.path = aa.z(((com.tencent.mm.vfs.o)localObject1).her());
                    localObject1 = new com.tencent.mm.vfs.o(b.a(paramhb.dLm.dLo));
                    paramhb.dLn.thumbPath = aa.z(((com.tencent.mm.vfs.o)localObject1).her());
                    continue;
                    localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                    if (localObject1 == null)
                    {
                      b.b(paramhb.dLm.dLo, paramhb.dLm.dLt, paramhb.dLm.dFW);
                      b.a(paramhb.dLm.dLo, paramhb.dLm.dLt, paramhb.dLm.dFW);
                    }
                    else if (Util.isNullOrNil(paramhb.dLm.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramhb.dLm.dLo, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramhb.dLm.dLo);
                      continue;
                      b.c(paramhb);
                      continue;
                      localObject1 = (am)paramhb.dLm.dGJ;
                      paramhb.dLn.path = ((am)localObject1).tbF;
                      if ((((am)localObject1).getReqResp() != null) && (((am)localObject1).getReqResp().getRespObj() != null) && (((am)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramhb = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(((am)localObject1).tbB);
                        if ((paramhb != null) && (paramhb.field_favProto != null) && (paramhb.field_favProto.ppH != null))
                        {
                          paramhb.field_favProto.ajl(paramhb.field_favProto.version + 2);
                          paramhb.field_itemStatus = 1;
                          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramhb, new String[] { "localId" });
                          ((af)com.tencent.mm.kernel.g.ah(af.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramhb.dLm.dGb != null) {
                              localObject1 = b.a(paramhb.dLm.dGb);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramhb.dLn;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((hb.b)localObject4).ret = i;
                            paramhb.dLn.dLD = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramhb.dLn.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramhb.dLn.dLD = true;
                            paramhb.dLn.path = null;
                            break;
                          }
                          localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.bH(paramhb.dLm.dGb.ppH);
                            ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramhb.dLm.dGb = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.fh(paramhb.dLm.context);
                              continue;
                              paramhb = paramhb.dLn;
                              if (b.cUp()) {}
                              for (i = 1;; i = 0)
                              {
                                paramhb.ret = i;
                                break;
                              }
                              b.e(paramhb.dLm.context, paramhb.dLm.desc, paramhb.dLm.title, paramhb.dLm.path);
                              continue;
                              Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramhb.dLm.dLv });
                              if (!Util.isNullOrNil(paramhb.dLm.dLv))
                              {
                                paramhb = paramhb.dLm.dLv.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramhb));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramhb = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(i);
                                        localObject4 = new amr();
                                        ((amr)localObject4).KGZ = i;
                                        if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((amr)localObject4).KHf = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramhb.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((af)com.tencent.mm.kernel.g.ah(af.class)).checkFavItem(paramhb);
                                  Log.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramhb.dLm.dLv, paramhb.dLm.dLw });
                                    i = Util.getInt(paramhb.dLm.dLv, -1);
                                    paramhb = Util.stringsToList(paramhb.dLm.dLw.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramhb);
                                    paramhb = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(i);
                                    if (paramhb != null) {
                                      break label3791;
                                    }
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    h.HT(8);
                                  }
                                  catch (Exception paramhb)
                                  {
                                    Log.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramhb, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3791:
                                  localObject1 = new ane();
                                  ((ane)localObject1).KGZ = i;
                                  localObject4 = paramhb.field_favProto.ppH.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (aml)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((aml)localObject5).dLl + "#0"))
                                    {
                                      if (Util.isNullOrNil(((aml)localObject5).Lvp))
                                      {
                                        com.tencent.mm.an.f.baR();
                                        ((aml)localObject5).bgk(a.baG());
                                        h.HT(2);
                                      }
                                      if (!com.tencent.mm.vfs.s.YS(b.d((aml)localObject5))) {
                                        break label4037;
                                      }
                                      ((aml)localObject5).ajg(1);
                                      b.a((aml)localObject5, paramhb, 0, false);
                                      h.HT(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((aml)localObject5).dLl + "#1")) {
                                        break;
                                      }
                                      if (Util.isNullOrNil(((aml)localObject5).Lvp))
                                      {
                                        com.tencent.mm.an.f.baR();
                                        ((aml)localObject5).bgk(a.baG());
                                        h.HT(2);
                                      }
                                      if (!com.tencent.mm.vfs.s.YS(b.a((aml)localObject5))) {
                                        break label4089;
                                      }
                                      ((aml)localObject5).ajg(-1);
                                      b.a((aml)localObject5, paramhb, 0);
                                      h.HT(3);
                                      i = 1;
                                      break;
                                      label4037:
                                      h.HT(5);
                                      localObject6 = new aoc();
                                      ((aoc)localObject6).LiU = ((aml)localObject5).dLl;
                                      ((aoc)localObject6).Lja = 0;
                                      ((aoc)localObject6).oTW = 4;
                                      ((ane)localObject1).Lye.add(localObject6);
                                    }
                                    label4089:
                                    h.HT(5);
                                    localObject6 = new aoc();
                                    ((aoc)localObject6).LiU = ((aml)localObject5).dLl;
                                    ((aoc)localObject6).Lja = 1;
                                    ((aoc)localObject6).oTW = 4;
                                    ((ane)localObject1).Lye.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    h.HU(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new aoc();
                                        ((aoc)localObject5).LiU = localObject4[0];
                                        ((aoc)localObject5).Lja = Integer.valueOf(localObject4[1]).intValue();
                                        ((aoc)localObject5).oTW = 3;
                                        ((ane)localObject1).Lye.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((ane)localObject1).Lye.size() > 0) {
                                    ((af)com.tencent.mm.kernel.g.ah(af.class)).checkFavItem((ane)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramhb.field_type == 18) {
                                      paramhb.field_favProto.ajl(paramhb.field_favProto.version + 1);
                                    }
                                    paramhb.field_itemStatus = 15;
                                    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramhb, new String[] { "localId" });
                                    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                                    h.HT(6);
                                  }
                                  else
                                  {
                                    h.HT(7);
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramhb.dLn.dLF = b.b(paramhb.dLm.dGb);
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
  
  private static String m(aml paramaml)
  {
    AppMethodBeat.i(107063);
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(b.a(paramaml));
    if (!localo.exists()) {
      if (paramaml.dFN == null) {
        paramaml = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramaml;
      paramaml = new com.tencent.mm.vfs.o(b.cUf() + com.tencent.mm.b.g.getMessageDigest(paramaml.dFN.getBytes()));
      if (paramaml.exists())
      {
        paramaml = aa.z(paramaml.her());
      }
      else
      {
        paramaml = "";
        continue;
        paramaml = aa.z(localo.her());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.q
 * JD-Core Version:    0.7.0.1
 */