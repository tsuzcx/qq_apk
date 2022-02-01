package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.g.a.gt.b;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends c<gt>
{
  public q()
  {
    AppMethodBeat.i(160917);
    this.__eventId = gt.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(gt paramgt)
  {
    AppMethodBeat.i(107062);
    switch (paramgt.dhx.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.EBX != null))
      {
        paramgt.dhy.boK = new ArrayList();
        paramgt.dhy.boK.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.EBX);
        continue;
        if (paramgt.dhx.dhz != null)
        {
          localObject1 = new e(b.d(paramgt.dhx.dhz));
          if (((e)localObject1).exists()) {
            paramgt.dhy.path = com.tencent.mm.vfs.q.B(((e)localObject1).fxV());
          }
          localObject1 = new e(b.a(paramgt.dhx.dhz));
          if (((e)localObject1).exists())
          {
            paramgt.dhy.thumbPath = com.tencent.mm.vfs.q.B(((e)localObject1).fxV());
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(paramgt.dhx.dhB);
            paramgt.dhy.ret = 0;
            continue;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(paramgt.dhx.dhB);
            paramgt.dhy.ret = 0;
            continue;
            paramgt.dhy.dhK = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpF();
            paramgt.dhy.ret = 0;
            continue;
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
            if (localObject1 == null) {}
            for (paramgt.dhy.dhJ = null;; paramgt.dhy.dhJ = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramgt.dhy.ret = 0;
              break;
            }
            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramgt.dhx.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgt.dhx.dhI);
            paramgt.dhy.ret = 0;
            continue;
            localObject1 = b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg), paramgt.dhx.handler);
            paramgt.dhy.thumbPath = localObject1[0];
            paramgt.dhy.thumbUrl = localObject1[1];
            paramgt.dhy.ret = 0;
            continue;
            b.b(paramgt.dhx.dcg, paramgt.dhx.dhC);
            continue;
            Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramgt.dhx.dcm != null) {
                localObject1 = b.a(paramgt.dhx.dcm);
              }
            }
            l.a(paramgt.dhx.context, paramgt.dhx.toUser, paramgt.dhx.dhD, (com.tencent.mm.plugin.fav.a.g)localObject1, paramgt.dhx.dhC);
            continue;
            if (b.g(paramgt.dhx.dhz))
            {
              paramgt.dhy.ret = 1;
            }
            else
            {
              paramgt.dhy.ret = 0;
              continue;
              b.l(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg));
              continue;
              b.m(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg));
              continue;
              paramgt.dhy.ret = b.act(paramgt.dhx.dhz.Ezu);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.EBJ;
                if (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7)
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((agx)localObject5);
                  localObject4 = com.tencent.mm.ay.g.a(6, null, ((agx)localObject5).title, ((agx)localObject5).desc, ((agx)localObject5).Ezm, ((agx)localObject5).Ezq, ((agx)localObject5).Ezo, ((agx)localObject5).dhw, b.cpc(), (String)localObject6, "", ((aht)localObject4).appId);
                  ((com.tencent.mm.ay.f)localObject4).hOj = ((agx)localObject5).songAlbumUrl;
                  ((com.tencent.mm.ay.f)localObject4).hOb = ((agx)localObject5).songLyric;
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.nxC != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.nxC.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (agx)((Iterator)localObject5).next();
                    if (((agx)localObject6).dataType == 7)
                    {
                      Object localObject7 = m((agx)localObject6);
                      localObject7 = com.tencent.mm.ay.g.a(6, null, ((agx)localObject6).title, ((agx)localObject6).desc, ((agx)localObject6).Ezm, ((agx)localObject6).Ezq, ((agx)localObject6).Ezo, ((agx)localObject6).dhw, b.cpc(), (String)localObject7, "", ((aht)localObject4).appId);
                      ((com.tencent.mm.ay.f)localObject7).hOj = ((agx)localObject6).songAlbumUrl;
                      ((com.tencent.mm.ay.f)localObject7).hOb = ((agx)localObject6).songLyric;
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramgt.dhy.dhL = ((List)localObject1);
              continue;
              if (paramgt.dhx.dcg == -1L)
              {
                k.a(paramgt.dhx.title, paramgt.dhx.dcm.nxC, -1L);
              }
              else if (paramgt.dhx.dhE == -1)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.size() > 1))
                {
                  localObject1 = (agx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.get(0);
                  paramgt.dhy.dhO = bs.isNullOrNil(((agx)localObject1).Ezf);
                }
              }
              else if ((paramgt.dhx.dhE == -3) && (paramgt.dhx.dcg > 0L))
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramgt.dhx.dhA.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramgt.dhx.dhA.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).acw(paramgt.dhx.dhA.getStringExtra("fav_note_xml"));
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramgt.dhx.dhE == -2) && (paramgt.dhx.dcg > 0L))
                {
                  localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!bs.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).acw(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.size() > 1))
                    {
                      localObject2 = (agx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.get(0);
                      if ((!bs.isNullOrNil(((agx)localObject2).Ezf)) && (!bs.isNullOrNil(((agx)localObject2).Ezh)))
                      {
                        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramgt.dhx.dcg > 0L) && (!bs.isNullOrNil(paramgt.dhx.desc)) && (paramgt.dhx.dhE > 0))
                {
                  localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramgt.dhx.dcm.nxC, paramgt.dhx.dcg);
                if (!bs.isNullOrNil(paramgt.dhx.desc))
                {
                  if (paramgt.dhx.dhE > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramgt.dhx.dhA = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XU(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramgt.dhx.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XU(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramgt.dhx.title, paramgt.dhx.dcm.nxC, paramgt.dhx.dcg);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XU(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XU(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XU(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ap.cqc().cqd();
                  localObject1 = ap.cqc();
                  localObject2 = paramgt.dhx.title;
                  int i = paramgt.dhx.dhE;
                  int j = paramgt.dhx.dhF;
                  ((ap)localObject1).path = bs.bG((String)localObject2, "");
                  ((ap)localObject1).dhE = i;
                  ((ap)localObject1).duration = j;
                  continue;
                  paramgt.dhy.path = m.F(paramgt.dhx.context, paramgt.dhx.dhF).toString();
                  continue;
                  ap.cqc();
                  ap.cqe().destroy();
                  continue;
                  ap.cqc();
                  ap.cqe().cpz();
                  continue;
                  localObject1 = paramgt.dhy;
                  ap.cqc();
                  ((gt.b)localObject1).dhM = ap.cqe().Y(paramgt.dhx.path, paramgt.dhx.dhE, paramgt.dhx.dhF);
                  continue;
                  ap.cqc();
                  ap.cqe().stopPlay();
                  continue;
                  localObject1 = paramgt.dhy;
                  ap.cqc();
                  ((gt.b)localObject1).path = ap.cqe().path;
                  localObject1 = paramgt.dhy;
                  ap.cqc();
                  ((gt.b)localObject1).dhM = ap.cqe().caY();
                  localObject1 = paramgt.dhy;
                  ap.cqc();
                  ((gt.b)localObject1).dhN = ap.cqe().cpy();
                  localObject1 = paramgt.dhy;
                  ap.cqc();
                  localObject2 = ap.cqe();
                  boolean bool;
                  if (((n)localObject2).oUG == null)
                  {
                    ac.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2539:
                    ((gt.b)localObject1).dhO = bool;
                    paramgt = paramgt.dhy;
                    ap.cqc();
                    localObject1 = ap.cqe();
                    if (((n)localObject1).oUG != null) {
                      break label2602;
                    }
                    ac.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2602:
                  for (double d = 0.0D;; d = ((n)localObject1).oUG.NW())
                  {
                    paramgt.dhP = d;
                    break;
                    bool = ((n)localObject2).oUG.MZ();
                    break label2539;
                  }
                  if (paramgt.dhx.dhz != null)
                  {
                    localObject1 = new e(b.d(paramgt.dhx.dhz));
                    paramgt.dhy.path = com.tencent.mm.vfs.q.B(((e)localObject1).fxV());
                    localObject1 = new e(b.a(paramgt.dhx.dhz));
                    paramgt.dhy.thumbPath = com.tencent.mm.vfs.q.B(((e)localObject1).fxV());
                    continue;
                    localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                    if (localObject1 == null)
                    {
                      b.b(paramgt.dhx.dhz, paramgt.dhx.dhE, paramgt.dhx.dcg);
                      b.a(paramgt.dhx.dhz, paramgt.dhx.dhE, paramgt.dhx.dcg);
                    }
                    else if (bs.isNullOrNil(paramgt.dhx.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgt.dhx.dhz, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramgt.dhx.dhz);
                      continue;
                      b.c(paramgt);
                      continue;
                      localObject1 = (am)paramgt.dhx.dcV;
                      paramgt.dhy.path = ((am)localObject1).qJM;
                      if ((((am)localObject1).getReqResp() != null) && (((am)localObject1).getReqResp().getRespObj() != null) && (((am)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramgt = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(((am)localObject1).qJI);
                        if ((paramgt != null) && (paramgt.field_favProto != null) && (paramgt.field_favProto.nxC != null))
                        {
                          paramgt.field_favProto.XU(paramgt.field_favProto.version + 2);
                          paramgt.field_itemStatus = 1;
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgt, new String[] { "localId" });
                          ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramgt.dhx.dcm != null) {
                              localObject1 = b.a(paramgt.dhx.dcm);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramgt.dhy;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((gt.b)localObject4).ret = i;
                            paramgt.dhy.dhO = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramgt.dhy.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramgt.dhy.dhO = true;
                            paramgt.dhy.path = null;
                            break;
                          }
                          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.bk(paramgt.dhx.dcm.nxC);
                            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramgt.dhx.dcm = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.eJ(paramgt.dhx.context);
                              continue;
                              paramgt = paramgt.dhy;
                              if (b.cpg()) {}
                              for (i = 1;; i = 0)
                              {
                                paramgt.ret = i;
                                break;
                              }
                              b.c(paramgt.dhx.context, paramgt.dhx.desc, paramgt.dhx.title, paramgt.dhx.path);
                              continue;
                              ac.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramgt.dhx.dhG });
                              if (!bs.isNullOrNil(paramgt.dhx.dhG))
                              {
                                paramgt = paramgt.dhx.dhG.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramgt));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramgt = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(i);
                                        localObject4 = new ahd();
                                        ((ahd)localObject4).DPH = i;
                                        if ((localObject2 != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((ahd)localObject4).DPN = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramgt.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem(paramgt);
                                  ac.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    ac.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramgt.dhx.dhG, paramgt.dhx.dhH });
                                    i = bs.getInt(paramgt.dhx.dhG, -1);
                                    paramgt = bs.S(paramgt.dhx.dhH.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramgt);
                                    paramgt = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(i);
                                    if (paramgt != null) {
                                      break label3771;
                                    }
                                    ac.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    h.Dd(8);
                                  }
                                  catch (Exception paramgt)
                                  {
                                    ac.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramgt, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3771:
                                  localObject1 = new ahq();
                                  ((ahq)localObject1).DPH = i;
                                  localObject4 = paramgt.field_favProto.nxC.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (agx)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((agx)localObject5).dhw + "#0"))
                                    {
                                      if (bs.isNullOrNil(((agx)localObject5).Ezh))
                                      {
                                        com.tencent.mm.an.f.aDE();
                                        ((agx)localObject5).aIH(a.aDw());
                                        h.Dd(2);
                                      }
                                      if (!com.tencent.mm.vfs.i.eA(b.d((agx)localObject5))) {
                                        break label4017;
                                      }
                                      ((agx)localObject5).XP(1);
                                      b.a((agx)localObject5, paramgt, 0, false);
                                      h.Dd(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((agx)localObject5).dhw + "#1")) {
                                        break;
                                      }
                                      if (bs.isNullOrNil(((agx)localObject5).Ezh))
                                      {
                                        com.tencent.mm.an.f.aDE();
                                        ((agx)localObject5).aIH(a.aDw());
                                        h.Dd(2);
                                      }
                                      if (!com.tencent.mm.vfs.i.eA(b.a((agx)localObject5))) {
                                        break label4069;
                                      }
                                      ((agx)localObject5).XP(-1);
                                      b.a((agx)localObject5, paramgt, 0);
                                      h.Dd(3);
                                      i = 1;
                                      break;
                                      label4017:
                                      h.Dd(5);
                                      localObject6 = new ain();
                                      ((ain)localObject6).Eoy = ((agx)localObject5).dhw;
                                      ((ain)localObject6).EoE = 0;
                                      ((ain)localObject6).ndj = 4;
                                      ((ahq)localObject1).EBN.add(localObject6);
                                    }
                                    label4069:
                                    h.Dd(5);
                                    localObject6 = new ain();
                                    ((ain)localObject6).Eoy = ((agx)localObject5).dhw;
                                    ((ain)localObject6).EoE = 1;
                                    ((ain)localObject6).ndj = 4;
                                    ((ahq)localObject1).EBN.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    ac.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    h.De(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new ain();
                                        ((ain)localObject5).Eoy = localObject4[0];
                                        ((ain)localObject5).EoE = Integer.valueOf(localObject4[1]).intValue();
                                        ((ain)localObject5).ndj = 3;
                                        ((ahq)localObject1).EBN.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((ahq)localObject1).EBN.size() > 0) {
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).checkFavItem((ahq)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramgt.field_type == 18) {
                                      paramgt.field_favProto.XU(paramgt.field_favProto.version + 1);
                                    }
                                    paramgt.field_itemStatus = 15;
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramgt, new String[] { "localId" });
                                    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
                                    h.Dd(6);
                                  }
                                  else
                                  {
                                    h.Dd(7);
                                    ac.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramgt.dhy.dhQ = b.b(paramgt.dhx.dcm);
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
  
  private static String m(agx paramagx)
  {
    AppMethodBeat.i(107063);
    e locale = new e(b.a(paramagx));
    if (!locale.exists()) {
      if (paramagx.dbZ == null) {
        paramagx = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramagx;
      paramagx = new e(b.coW() + com.tencent.mm.b.g.getMessageDigest(paramagx.dbZ.getBytes()));
      if (paramagx.exists())
      {
        paramagx = com.tencent.mm.vfs.q.B(paramagx.fxV());
      }
      else
      {
        paramagx = "";
        continue;
        paramagx = com.tencent.mm.vfs.q.B(locale.fxV());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.q
 * JD-Core Version:    0.7.0.1
 */