package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.a;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.ar;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.dtj;
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

public class FavoriteOperationListener
  extends IListener<ht>
{
  public FavoriteOperationListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(160917);
    this.__eventId = ht.class.getName().hashCode();
    AppMethodBeat.o(160917);
  }
  
  private static boolean d(ht paramht)
  {
    AppMethodBeat.i(107062);
    switch (paramht.hIR.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107062);
      return false;
      Object localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.ZBH != null))
      {
        paramht.hIS.dcC = new ArrayList();
        paramht.hIS.dcC.addAll(((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto.ZBH);
        continue;
        if (paramht.hIR.hIT != null)
        {
          localObject1 = new u(b.d(paramht.hIR.hIT));
          if (((u)localObject1).jKS()) {
            paramht.hIS.path = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
          }
          localObject1 = new u(b.a(paramht.hIR.hIT));
          if (((u)localObject1).jKS())
          {
            paramht.hIS.thumbPath = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
            continue;
            ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().add(paramht.hIR.hIV);
            paramht.hIS.ret = 0;
            continue;
            ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().remove(paramht.hIR.hIV);
            paramht.hIS.ret = 0;
            continue;
            paramht.hIS.hJe = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().dQF();
            paramht.hIS.ret = 0;
            continue;
            localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
            if (localObject1 == null) {}
            for (paramht.hIS.hJd = null;; paramht.hIS.hJd = b.a(((com.tencent.mm.plugin.fav.a.g)localObject1).field_type, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_tagProto))
            {
              paramht.hIS.ret = 0;
              break;
            }
            localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
            ((z)com.tencent.mm.kernel.h.ax(z.class)).a(paramht.hIR.context, (com.tencent.mm.plugin.fav.a.g)localObject1, paramht.hIR.hJc);
            paramht.hIS.ret = 0;
            continue;
            localObject1 = b.a(((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn), paramht.hIR.handler);
            paramht.hIS.thumbPath = localObject1[0];
            paramht.hIS.thumbUrl = localObject1[1];
            paramht.hIS.ret = 0;
            continue;
            b.b(paramht.hIR.hDn, paramht.hIR.hIW);
            continue;
            Object localObject2 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
            b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (paramht.hIR.hDt != null) {
                localObject1 = b.a(paramht.hIR.hDt);
              }
            }
            l.a(paramht.hIR.context, paramht.hIR.toUser, paramht.hIR.hIX, (com.tencent.mm.plugin.fav.a.g)localObject1, paramht.hIR.hIW);
            continue;
            if (b.g(paramht.hIR.hIT))
            {
              paramht.hIS.ret = 1;
            }
            else
            {
              paramht.hIS.ret = 0;
              continue;
              b.l(((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn));
              continue;
              b.m(((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn));
              continue;
              paramht.hIS.ret = b.atU(paramht.hIR.hIT.ZyU);
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
                localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.ZBt;
                if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 7) || (((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 21))
                {
                  localObject5 = b.c((com.tencent.mm.plugin.fav.a.g)localObject5);
                  localObject6 = m((arf)localObject5);
                  localObject4 = com.tencent.mm.aw.g.a(6, null, ((arf)localObject5).title, ((arf)localObject5).desc, ((arf)localObject5).ZyM, ((arf)localObject5).ZyQ, ((arf)localObject5).ZyO, ((arf)localObject5).hIQ, b.dQc(), (String)localObject6, "", ((asb)localObject4).appId);
                  ((com.tencent.mm.aw.f)localObject4).oOM = ((arf)localObject5).songAlbumUrl;
                  ((com.tencent.mm.aw.f)localObject4).oOE = ((arf)localObject5).songLyric;
                  if ((((arf)localObject5).Zzy != null) && (((arf)localObject5).Zzy.ZAJ != null) && (!Util.isNullOrNil(((arf)localObject5).Zzy.ZAJ.oOZ))) {
                    ((com.tencent.mm.aw.f)localObject4).oOZ = ((arf)localObject5).Zzy.ZAJ.oOZ;
                  }
                  ((List)localObject1).add(localObject4);
                }
                else if ((((com.tencent.mm.plugin.fav.a.g)localObject5).field_type == 14) && (((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.vEn != null))
                {
                  localObject5 = ((com.tencent.mm.plugin.fav.a.g)localObject5).field_favProto.vEn.iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (arf)((Iterator)localObject5).next();
                    if ((((arf)localObject6).dataType == 7) || (((arf)localObject6).dataType == 29))
                    {
                      Object localObject7 = m((arf)localObject6);
                      localObject7 = com.tencent.mm.aw.g.a(6, null, ((arf)localObject6).title, ((arf)localObject6).desc, ((arf)localObject6).ZyM, ((arf)localObject6).ZyQ, ((arf)localObject6).ZyO, ((arf)localObject6).hIQ, b.dQc(), (String)localObject7, "", ((asb)localObject4).appId);
                      ((com.tencent.mm.aw.f)localObject7).oOM = ((arf)localObject6).songAlbumUrl;
                      ((com.tencent.mm.aw.f)localObject7).oOE = ((arf)localObject6).songLyric;
                      if ((((arf)localObject6).Zzy != null) && (((arf)localObject6).Zzy.ZAJ != null) && (!Util.isNullOrNil(((arf)localObject6).Zzy.ZAJ.oOZ))) {
                        ((com.tencent.mm.aw.f)localObject7).oOZ = ((arf)localObject6).Zzy.ZAJ.oOZ;
                      }
                      ((List)localObject1).add(localObject7);
                    }
                  }
                }
              }
              paramht.hIS.hJf = ((List)localObject1);
              continue;
              if (paramht.hIR.hDn == -1L)
              {
                k.a(paramht.hIR.title, paramht.hIR.hDt.vEn, -1L);
              }
              else if (paramht.hIR.hIY == -1)
              {
                localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.vEn.size() > 1))
                {
                  localObject1 = (arf)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.vEn.get(0);
                  paramht.hIS.hJi = Util.isNullOrNil(((arf)localObject1).Ysw);
                }
              }
              else if ((paramht.hIR.hIY == -3) && (paramht.hIR.hDn > 0L))
              {
                localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus = paramht.hIR.hIU.getIntExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime = paramht.hIR.hIU.getLongExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
                  ((com.tencent.mm.plugin.fav.a.g)localObject1).atX(paramht.hIR.hIU.getStringExtra("fav_note_xml"));
                  ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                }
              }
              else
              {
                if ((paramht.hIR.hIY == -2) && (paramht.hIR.hDn > 0L))
                {
                  localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_itemStatus == 10) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml)))
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject1).atX(((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml);
                    if ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.vEn.size() > 1))
                    {
                      localObject2 = (arf)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.vEn.get(0);
                      if ((!Util.isNullOrNil(((arf)localObject2).Ysw)) && (!Util.isNullOrNil(((arf)localObject2).ZyH)))
                      {
                        ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                        continue;
                      }
                    }
                  }
                }
                localObject1 = new Intent();
                if ((paramht.hIR.hDn > 0L) && (!Util.isNullOrNil(paramht.hIR.desc)) && (paramht.hIR.hIY > 0))
                {
                  localObject2 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                  if (localObject2 != null)
                  {
                    ((Intent)localObject1).putExtra("fav_note_xml", com.tencent.mm.plugin.fav.a.g.t((com.tencent.mm.plugin.fav.a.g)localObject2));
                    ((Intent)localObject1).putExtra("fav_note_item_updatetime", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime);
                  }
                }
                localObject2 = k.a(paramht.hIR.hDt.vEn, paramht.hIR.hDn);
                if (!Util.isNullOrNil(paramht.hIR.desc))
                {
                  if (paramht.hIR.hIY > 0)
                  {
                    ((Intent)localObject1).putExtra("fav_note_item_status", ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus);
                    paramht.hIR.hIU = ((Intent)localObject1);
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.axG(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                  b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                  ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                  if (paramht.hIR.desc.equals("fav_add_new_note"))
                  {
                    if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.axG(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                    }
                    for (;;)
                    {
                      ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                      k.a(paramht.hIR.title, paramht.hIR.hDt.vEn, paramht.hIR.hDn);
                      break;
                      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.axG(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                    }
                  }
                }
                else
                {
                  if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version != 0) {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.axG(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 1);
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_itemStatus = 1;
                    b.q((com.tencent.mm.plugin.fav.a.g)localObject2);
                    ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
                    ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getCheckCdnService().run();
                    break;
                    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.axG(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.version + 2);
                  }
                  ar.dRe().dRf();
                  localObject1 = ar.dRe();
                  localObject2 = paramht.hIR.title;
                  int i = paramht.hIR.hIY;
                  int j = paramht.hIR.hIZ;
                  ((ar)localObject1).path = Util.nullAs((String)localObject2, "");
                  ((ar)localObject1).hIY = i;
                  ((ar)localObject1).duration = j;
                  continue;
                  paramht.hIS.path = m.Q(paramht.hIR.context, paramht.hIR.hIZ).toString();
                  continue;
                  ar.dRe();
                  ar.dRg().destroy();
                  continue;
                  ar.dRe();
                  ar.dRg().pausePlay();
                  continue;
                  localObject1 = paramht.hIS;
                  ar.dRe();
                  ((ht.b)localObject1).hJg = ar.dRg().ah(paramht.hIR.path, paramht.hIR.hIY, paramht.hIR.hIZ);
                  continue;
                  ar.dRe();
                  ar.dRg().stopPlay();
                  continue;
                  localObject1 = paramht.hIS;
                  ar.dRe();
                  ((ht.b)localObject1).path = ar.dRg().path;
                  localObject1 = paramht.hIS;
                  ar.dRe();
                  ((ht.b)localObject1).hJg = ar.dRg().dxE();
                  localObject1 = paramht.hIS;
                  ar.dRe();
                  ((ht.b)localObject1).hJh = ar.dRg().resumePlay();
                  localObject1 = paramht.hIS;
                  ar.dRe();
                  localObject2 = ar.dRg();
                  boolean bool;
                  if (((o)localObject2).xCQ == null)
                  {
                    Log.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    bool = false;
                    label2663:
                    ((ht.b)localObject1).hJi = bool;
                    paramht = paramht.hIS;
                    ar.dRe();
                    localObject1 = ar.dRg();
                    if (((o)localObject1).xCQ != null) {
                      break label2726;
                    }
                    Log.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                  }
                  label2726:
                  for (double d = 0.0D;; d = ((o)localObject1).xCQ.aGG())
                  {
                    paramht.hJj = d;
                    break;
                    bool = ((o)localObject2).xCQ.aFF();
                    break label2663;
                  }
                  if (paramht.hIR.hIT != null)
                  {
                    localObject1 = new u(b.d(paramht.hIR.hIT));
                    paramht.hIS.path = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
                    localObject1 = new u(b.a(paramht.hIR.hIT));
                    paramht.hIS.thumbPath = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
                    continue;
                    localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                    if (localObject1 == null)
                    {
                      b.b(paramht.hIR.hIT, paramht.hIR.hIY, paramht.hIR.hDn);
                      b.a(paramht.hIR.hIT, paramht.hIR.hIY, paramht.hIR.hDn);
                    }
                    else if (Util.isNullOrNil(paramht.hIR.path))
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramht.hIR.hIT, true);
                    }
                    else
                    {
                      b.a((com.tencent.mm.plugin.fav.a.g)localObject1, paramht.hIR.hIT);
                      continue;
                      b.c(paramht);
                      continue;
                      localObject1 = (ao)paramht.hIR.hEi;
                      paramht.hIS.path = ((ao)localObject1).AdY;
                      if ((((ao)localObject1).getReqResp() != null) && (((ao)localObject1).getReqResp().getRespObj() != null) && (((ao)localObject1).getReqResp().getRespObj().getRetCode() == -435))
                      {
                        paramht = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mL(((ao)localObject1).AdU);
                        if ((paramht != null) && (paramht.field_favProto != null) && (paramht.field_favProto.vEn != null))
                        {
                          paramht.field_favProto.axG(paramht.field_favProto.version + 2);
                          paramht.field_itemStatus = 1;
                          ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a(paramht, new String[] { "localId" });
                          ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getCheckCdnService().run();
                          continue;
                          localObject2 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                          localObject1 = localObject2;
                          if (localObject2 == null)
                          {
                            localObject1 = localObject2;
                            if (paramht.hIR.hDt != null) {
                              localObject1 = b.a(paramht.hIR.hDt);
                            }
                          }
                          localObject2 = new com.tencent.mm.plugin.fav.a.k();
                          localObject4 = paramht.hIS;
                          if ((!((com.tencent.mm.plugin.fav.a.k)localObject2).u((com.tencent.mm.plugin.fav.a.g)localObject1)) || (b.g((com.tencent.mm.plugin.fav.a.g)localObject1))) {}
                          for (i = 0;; i = 1)
                          {
                            ((ht.b)localObject4).ret = i;
                            paramht.hIS.hJi = com.tencent.mm.plugin.fav.a.k.v((com.tencent.mm.plugin.fav.a.g)localObject1);
                            paramht.hIS.path = "";
                            if (localObject1 != null) {
                              break;
                            }
                            paramht.hIS.hJi = true;
                            paramht.hIS.path = null;
                            break;
                          }
                          localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.cs(paramht.hIR.hDt.vEn);
                            ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().b((com.tencent.mm.plugin.fav.a.g)localObject1, new String[] { "localId" });
                            continue;
                            localObject1 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
                            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type == 18))
                            {
                              paramht.hIR.hDt = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
                              continue;
                              b.gk(paramht.hIR.context);
                              continue;
                              paramht = paramht.hIS;
                              if (b.dQg()) {}
                              for (i = 1;; i = 0)
                              {
                                paramht.ret = i;
                                break;
                              }
                              b.e(paramht.hIR.context, paramht.hIR.desc, paramht.hIR.title, paramht.hIR.path);
                              continue;
                              Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[] { paramht.hIR.hJa });
                              if (!Util.isNullOrNil(paramht.hIR.hJa))
                              {
                                paramht = paramht.hIR.hJa.split(";");
                                localObject1 = new LinkedList();
                                ((List)localObject1).addAll(Arrays.asList(paramht));
                                if (((List)localObject1).size() > 0)
                                {
                                  paramht = new ArrayList();
                                  localObject1 = ((List)localObject1).iterator();
                                  while (((Iterator)localObject1).hasNext())
                                  {
                                    localObject2 = (String)((Iterator)localObject1).next();
                                    try
                                    {
                                      i = Integer.valueOf((String)localObject2).intValue();
                                      if (i > 0)
                                      {
                                        localObject2 = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mL(i);
                                        localObject4 = new arl();
                                        ((arl)localObject4).YFt = i;
                                        if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml))) {
                                          ((arl)localObject4).YFz = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_xml;
                                        }
                                        paramht.add(localObject4);
                                      }
                                    }
                                    catch (Exception localException1) {}
                                  }
                                  ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).checkFavItem(paramht);
                                  Log.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                                  continue;
                                  Object localObject3;
                                  try
                                  {
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[] { paramht.hIR.hJa, paramht.hIR.hJb });
                                    i = Util.getInt(paramht.hIR.hJa, -1);
                                    paramht = Util.stringsToList(paramht.hIR.hJb.split(";"));
                                    localObject3 = new HashSet();
                                    ((HashSet)localObject3).addAll(paramht);
                                    paramht = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mL(i);
                                    if (paramht != null) {
                                      break label3895;
                                    }
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[] { Integer.valueOf(i) });
                                    com.tencent.mm.plugin.fav.a.h.MA(8);
                                  }
                                  catch (Exception paramht)
                                  {
                                    Log.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", paramht, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                                  }
                                  continue;
                                  label3895:
                                  localObject1 = new ary();
                                  ((ary)localObject1).YFt = i;
                                  localObject4 = paramht.field_favProto.vEn.iterator();
                                  i = 0;
                                  while (((Iterator)localObject4).hasNext())
                                  {
                                    localObject5 = (arf)((Iterator)localObject4).next();
                                    j = i;
                                    if (((HashSet)localObject3).remove(((arf)localObject5).hIQ + "#0"))
                                    {
                                      if (Util.isNullOrNil(((arf)localObject5).ZyH))
                                      {
                                        com.tencent.mm.modelcdntran.k.bHX();
                                        ((arf)localObject5).bst(d.bHI());
                                        com.tencent.mm.plugin.fav.a.h.MA(2);
                                      }
                                      if (!com.tencent.mm.vfs.y.ZC(b.d((arf)localObject5))) {
                                        break label4141;
                                      }
                                      ((arf)localObject5).axB(1);
                                      b.a((arf)localObject5, paramht, 0, false);
                                      com.tencent.mm.plugin.fav.a.h.MA(3);
                                    }
                                    for (j = 1;; j = i)
                                    {
                                      i = j;
                                      if (!((HashSet)localObject3).remove(((arf)localObject5).hIQ + "#1")) {
                                        break;
                                      }
                                      if (Util.isNullOrNil(((arf)localObject5).ZyH))
                                      {
                                        com.tencent.mm.modelcdntran.k.bHX();
                                        ((arf)localObject5).bst(d.bHI());
                                        com.tencent.mm.plugin.fav.a.h.MA(2);
                                      }
                                      if (!com.tencent.mm.vfs.y.ZC(b.a((arf)localObject5))) {
                                        break label4193;
                                      }
                                      ((arf)localObject5).axB(-1);
                                      b.a((arf)localObject5, paramht, 0);
                                      com.tencent.mm.plugin.fav.a.h.MA(3);
                                      i = 1;
                                      break;
                                      label4141:
                                      com.tencent.mm.plugin.fav.a.h.MA(5);
                                      localObject6 = new asw();
                                      ((asw)localObject6).Ziv = ((arf)localObject5).hIQ;
                                      ((asw)localObject6).ZiB = 0;
                                      ((asw)localObject6).vhk = 4;
                                      ((ary)localObject1).ZBx.add(localObject6);
                                    }
                                    label4193:
                                    com.tencent.mm.plugin.fav.a.h.MA(5);
                                    localObject6 = new asw();
                                    ((asw)localObject6).Ziv = ((arf)localObject5).hIQ;
                                    ((asw)localObject6).ZiB = 1;
                                    ((asw)localObject6).vhk = 4;
                                    ((ary)localObject1).ZBx.add(localObject6);
                                    i = j;
                                  }
                                  if (((HashSet)localObject3).size() > 0)
                                  {
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[] { ((HashSet)localObject3).toString() });
                                    com.tencent.mm.plugin.fav.a.h.MB(((HashSet)localObject3).size());
                                    localObject3 = ((HashSet)localObject3).iterator();
                                    while (((Iterator)localObject3).hasNext())
                                    {
                                      localObject4 = (String)((Iterator)localObject3).next();
                                      try
                                      {
                                        localObject4 = ((String)localObject4).split("#");
                                        localObject5 = new asw();
                                        ((asw)localObject5).Ziv = localObject4[0];
                                        ((asw)localObject5).ZiB = Integer.valueOf(localObject4[1]).intValue();
                                        ((asw)localObject5).vhk = 3;
                                        ((ary)localObject1).ZBx.add(localObject5);
                                      }
                                      catch (Exception localException2) {}
                                    }
                                  }
                                  if (((ary)localObject1).ZBx.size() > 0) {
                                    ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).checkFavItem((ary)localObject1);
                                  }
                                  if (i != 0)
                                  {
                                    if (paramht.field_type == 18) {
                                      paramht.field_favProto.axG(paramht.field_favProto.version + 1);
                                    }
                                    paramht.field_itemStatus = 15;
                                    ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().a(paramht, new String[] { "localId" });
                                    ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavCdnService().run();
                                    com.tencent.mm.plugin.fav.a.h.MA(6);
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.h.MA(7);
                                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                                    continue;
                                    paramht.hIS.hJk = b.b(paramht.hIR.hDt);
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
  
  private static String m(arf paramarf)
  {
    AppMethodBeat.i(107063);
    u localu = new u(b.a(paramarf));
    if (!localu.jKS()) {
      if (paramarf.hDd == null) {
        paramarf = "";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107063);
      return paramarf;
      paramarf = new u(b.dPW() + com.tencent.mm.b.g.getMessageDigest(paramarf.hDd.getBytes()));
      if (paramarf.jKS())
      {
        paramarf = com.tencent.mm.vfs.ah.v(paramarf.jKT());
      }
      else
      {
        paramarf = "";
        continue;
        paramarf = com.tencent.mm.vfs.ah.v(localu.jKT());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteOperationListener
 * JD-Core Version:    0.7.0.1
 */