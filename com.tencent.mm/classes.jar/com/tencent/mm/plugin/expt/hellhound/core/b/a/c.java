package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  d.a qRq;
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d qRu;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.qRu = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
    {
      public final void a(com.tencent.mm.plugin.expt.hellhound.core.a.a.a paramAnonymousa)
      {
        AppMethodBeat.i(121937);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(121937);
          return;
        }
        switch (paramAnonymousa.msgType)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(121937);
          return;
          if (paramAnonymousa.qQS != null)
          {
            Object localObject1 = (dic)paramAnonymousa.qQS;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((dic)localObject1).GIy.activityName, ((dic)localObject1).GIz.activityName, ((dic)localObject1).Grw });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((dic)localObject1).GIy == null) || (TextUtils.isEmpty(((dic)localObject1).GIy.activityName))) {
                break label1104;
              }
              paramAnonymousa = ((dic)localObject1).GIy.activityName;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod();
              bool = ((dic)localObject1).Grz;
              localObject4 = ((dic)localObject1).Grw;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).qRB.b(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa, ((dic)localObject1).Grw, 100);
              localObject3 = ((dic)localObject1).GIz.activityName;
              ad.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject3, null, 101);
              localObject4 = ((dic)localObject1).Gry;
              localObject5 = ((dic)localObject1).GIB;
              localObject6 = ((dic)localObject1).GIA;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1137;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((dic)localObject1).flags, paramAnonymousa, ((dic)localObject1).Grw, (String)localObject3, 0, ((dic)localObject1).timestamp);
              a.adT((String)localObject3);
              a.adV(paramAnonymousa);
              a.CS(0);
              if ((localObject3 != null) && (((c)localObject2).qRq != null)) {
                ((c)localObject2).qRq.adf((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1104:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bj)localObject3).Fti.activityName;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().adZ(paramAnonymousa);
              break;
              label1137:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("KPublisherId", "");
            }
            if (paramAnonymousa.qQS != null)
            {
              paramAnonymousa = (dno)paramAnonymousa.qQS;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.activityName });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((dno)localObject2).activityName });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(((dno)localObject2).activityName, null, 102);
                  localObject5 = ((dno)localObject2).activityName;
                  l = ((dno)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR().qRl.qRm;
                  if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                    break label1422;
                  }
                  i = 0;
                }
              }
              label1422:
              label1459:
              int j;
              for (;;)
              {
                if (i == 0)
                {
                  ad.w("HABBYGE-MALI.AsyncActivityMonitor", "_finish, popSuccess FALSE");
                  paramAnonymousa = new bj();
                  paramAnonymousa.Fti = new dno();
                  paramAnonymousa.Fti.activityName = ((dno)localObject2).activityName;
                  paramAnonymousa.Fti.aHQ = ((dno)localObject2).aHQ;
                  paramAnonymousa.Fti.timestamp = ((dno)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
                  com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aeg(((dno)localObject2).activityName);
                  com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().a(3, ((dno)localObject2).activityName, null);
                }
                c.aT(((dno)localObject2).activityName, true);
                if (((c)localObject1).qRq != null) {
                  ((c)localObject1).qRq.e(((dno)localObject2).activityName, ((dno)localObject2).aHQ, ((dno)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cnP();
                if (((bk)localObject4).Fto.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bk)localObject4).Fto.size() - 1;
                    if (i >= 0)
                    {
                      localObject6 = (dmi)((bk)localObject4).Fto.get(i);
                      j = ((dmi)localObject6).HAD.size() - 1;
                      label1488:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bj)((dmi)localObject6).HAD.get(j);
                        if (paramAnonymousa.Fti.activityName.equals(localObject5))
                        {
                          ((dmi)localObject6).HAD.remove(j);
                          if (((dmi)localObject6).HAD.isEmpty()) {
                            ((bk)localObject4).Fto.remove(i);
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    if (paramAnonymousa != null) {
                      break label1579;
                    }
                    i = 0;
                    break;
                    j -= 1;
                    break label1488;
                    i -= 1;
                    break label1459;
                    paramAnonymousa = null;
                  }
                  label1579:
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bk)localObject4);
                  if (((g)localObject3).qRp != null)
                  {
                    paramAnonymousa.Fti.timestamp = l;
                    ((g)localObject3).qRp.b(paramAnonymousa, (bj)g.cnX().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.qQS != null)
              {
                localObject1 = (cbm)paramAnonymousa.qQS;
                if (localObject1 != null)
                {
                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((cbm)localObject1).Grv.activityName });
                  paramAnonymousa = c.this;
                  localObject2 = ((cbm)localObject1).Grv;
                  bool = ((cbm)localObject1).GID;
                  localObject1 = c.a((dno)localObject2);
                  if (localObject1 != null)
                  {
                    ad.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((dno)localObject1).activityName });
                    if (!TextUtils.isEmpty(((dno)localObject1).activityName))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(((dno)localObject1).activityName, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR().qRl.qRm;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cnP();
                      localObject4 = new bj();
                      ((bj)localObject4).Fti = new dno();
                      ((bj)localObject4).Fti.activityName = ((dno)localObject1).activityName;
                      ((bj)localObject4).Fti.aHQ = ((dno)localObject1).aHQ;
                      ((bj)localObject4).Fti.timestamp = ((dno)localObject1).timestamp;
                      localObject5 = g.a((bk)localObject3, (bj)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (dmi)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (com.tencent.mm.plugin.expt.hellhound.core.stack.h.a(((bj)((dmi)localObject6).HAD.getFirst()).Fti, ((bj)localObject4).Fti))) && (i == ((bk)localObject3).Fto.size() - 1))
                        {
                          ((bk)localObject3).Fto.remove(i);
                          ((bk)localObject3).Fto.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bk)localObject3);
                          if (((g)localObject2).qRp != null) {
                            ((g)localObject2).qRp.d((bj)localObject4, g.e((bk)localObject3));
                          }
                        }
                      }
                      c.aT(((dno)localObject1).activityName, false);
                      if (paramAnonymousa.qRq != null) {
                        paramAnonymousa.qRq.f(((dno)localObject1).activityName, ((dno)localObject1).aHQ, ((dno)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.qQS != null)
                {
                  paramAnonymousa = (cdx)paramAnonymousa.qQS;
                  if (paramAnonymousa != null)
                  {
                    ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.Grv.activityName });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.Grv;
                    c.a(paramAnonymousa.flags, (dno)localObject2);
                    if (((c)localObject1).qRq != null) {
                      ((c)localObject1).qRq.adg(((dno)localObject2).activityName);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.qQS != null)
                  {
                    localObject1 = (cdx)paramAnonymousa.qQS;
                    if (localObject1 != null)
                    {
                      ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((cdx)localObject1).Grv.activityName });
                      paramAnonymousa = c.this;
                      i = ((cdx)localObject1).flags;
                      localObject1 = ((cdx)localObject1).Grv;
                      c.a(i, (dno)localObject1);
                      if (paramAnonymousa.qRq != null) {
                        paramAnonymousa.qRq.adh(((dno)localObject1).activityName);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.qQS != null)
                    {
                      paramAnonymousa = (dno)paramAnonymousa.qQS;
                      if (paramAnonymousa != null)
                      {
                        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.activityName });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.cX(com.tencent.mm.plugin.expt.hellhound.core.a.cnB().cnA());
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.adR(paramAnonymousa.activityName);
                        c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRe);
                        if (((c)localObject1).qRq != null) {
                          ((c)localObject1).qRq.g(paramAnonymousa.activityName, paramAnonymousa.aHQ, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.qQS != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.qQS;
                        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeJ(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.qQS != null)
                        {
                          paramAnonymousa = (cdy)paramAnonymousa.qQS;
                          if (paramAnonymousa != null)
                          {
                            ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.Grv.activityName });
                            if (c.this.qRq != null) {
                              c.this.qRq.adi(paramAnonymousa.Grv.activityName);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.qQS != null)
                          {
                            paramAnonymousa = (dno)paramAnonymousa.qQS;
                            if (paramAnonymousa != null)
                            {
                              ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.activityName });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 106);
                              c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRf);
                              if (((c)localObject1).qRq != null) {
                                ((c)localObject1).qRq.h(paramAnonymousa.activityName, paramAnonymousa.aHQ, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.qQS != null)
                            {
                              paramAnonymousa = (cdy)paramAnonymousa.qQS;
                              if (paramAnonymousa != null)
                              {
                                ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.Grv.activityName });
                                if (c.this.qRq != null) {
                                  c.this.qRq.adj(paramAnonymousa.Grv.activityName);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.qQS != null)
                              {
                                paramAnonymousa = (dno)paramAnonymousa.qQS;
                                if (paramAnonymousa != null)
                                {
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.activityName });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.adz(paramAnonymousa.activityName))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 107);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRg);
                                    if (((c)localObject1).qRq != null) {
                                      ((c)localObject1).qRq.i(paramAnonymousa.activityName, paramAnonymousa.aHQ, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.qQS != null)
                                {
                                  paramAnonymousa = (dno)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.activityName });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 108);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRh);
                                    if (((c)localObject1).qRq != null) {
                                      ((c)localObject1).qRq.cZ(paramAnonymousa.activityName, paramAnonymousa.aHQ);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (atl)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cnB().qQF.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (atk)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cnB().qQF.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cnB();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).qQF.R(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cnB();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).qQF.S(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.qQS).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.e.a.Do(i);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                  }
                                  catch (Exception paramAnonymousa)
                                  {
                                    ad.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramAnonymousa, "CATCH_ACTIVITY_ONRESUME: %s", new Object[] { paramAnonymousa.getMessage() });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 400)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.Dn(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.Dn(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.Do(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.a.c.c.cpn();
                                  ad.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed");
                                  int k;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.cnC())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.c.a.Di(8);
                                      a.CS(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      i = ((Integer)paramAnonymousa.get(1)).intValue();
                                      j = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      k = ((Integer)paramAnonymousa.get(4)).intValue();
                                      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).qYo != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).qYo.a((String)localObject1, i, j, l, k);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cpm();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new atr();
                                  }
                                  if (paramAnonymousa.GrH <= 0)
                                  {
                                    ad.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.GrH != i)
                                    {
                                      ad.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.GrH), Integer.valueOf(i) });
                                      if (paramAnonymousa.GrF == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.a.c.c.cpn();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cpm();
                                        if ((localObject1 != null) && (((atr)localObject1).GrJ)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3451;
                                          }
                                          ad.i("HABBYGE-MALI.FrontBackDao", "getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.a.c.a.la(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3451:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = ax.aQz("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.inh = i;
                                          localObject1 = paramAnonymousa.GrI;
                                          i = paramAnonymousa.aHQ;
                                          j = paramAnonymousa.GrH;
                                          l = paramAnonymousa.GrG;
                                          k = paramAnonymousa.inh;
                                          paramAnonymousa = new com.tencent.mm.vending.j.f();
                                          paramAnonymousa.LiZ = new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) };
                                          paramAnonymousa = (com.tencent.mm.vending.j.f)paramAnonymousa;
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      ad.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.GrH), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (bod)paramAnonymousa.qQS;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bod)localObject1).kJY;
                                    localObject1 = ((bod)localObject1).value;
                                    ad.i("HABBYGE-MALI.SyncBizCollector", "_collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnT().get(0));
                                    if (localObject2 != null)
                                    {
                                      ad.i("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.d.d.cpt();
                                      if (localObject3 != null) {
                                        break label3741;
                                      }
                                      ad.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label3986:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.cpJ();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      ad.e("HABBYGE-MALI.SyncBizCollector", "collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3741:
                                      if (((aua)localObject3).Gsb.isEmpty())
                                      {
                                        ad.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
                                        if (localObject4 == null)
                                        {
                                          ad.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new bod();
                                          ((bod)localObject5).kJY = paramAnonymousa;
                                          ((bod)localObject5).value = ((String)localObject1);
                                          i = ((aua)localObject3).Gsb.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (dbg)((aua)localObject3).Gsb.get(i);
                                            if ((localObject6 != null) && (((dbg)localObject6).dyV != null) && (((dbg)localObject6).dyV.equals(((chk)localObject4).sessionId)))
                                            {
                                              localObject6 = ((dbg)localObject6).Gsa.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                auc localauc = (auc)((Iterator)localObject6).next();
                                                if (!localauc.Gsi.isEmpty())
                                                {
                                                  j = localauc.Gsi.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label3986;
                                                    }
                                                    aub localaub = (aub)localauc.Gsi.get(j);
                                                    if (localaub != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localaub.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localaub.Gse.addLast(localObject5);
                                                        break;
                                                      }
                                                    }
                                                    j -= 1;
                                                  }
                                                }
                                              }
                                            }
                                            i -= 1;
                                          }
                                          com.tencent.mm.plugin.expt.hellhound.a.d.d.a((aua)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (boc)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new bod();
                                    ((bod)localObject3).kJY = paramAnonymousa;
                                    ((bod)localObject3).value = ((String)localObject1);
                                    ((boc)localObject2).Gse.add(localObject3);
                                    ((boc)localObject2).GIJ.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((boc)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.qQS;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.cpJ();
                                    if (localObject2 != null) {
                                      break label4151;
                                    }
                                    ad.e("HABBYGE-MALI.AsyncBizCollector", "getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((bod)localObject2).kJY)
                                  {
                                    ad.i("HABBYGE-MALI.AsyncBizCollector", "AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fT((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4151:
                                    paramAnonymousa = (boc)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fy(paramAnonymousa.Gse.size() + 1, paramAnonymousa.GIJ.size() + 1);
                                    localObject2 = new bod();
                                    ((bod)localObject2).kJY = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.v(paramAnonymousa.startTime, j);
                                    paramAnonymousa.Gse.add(localObject2);
                                    paramAnonymousa.GIJ.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, i);
                                    ad.i("HABBYGE-MALI.AsyncBizCollector", "getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((bod)localObject2).kJY });
                                  }
                                  localObject1 = (bod)paramAnonymousa.qQS;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bod)localObject1).dEZ;
                                    localObject2 = ((bod)localObject1).value;
                                    localObject3 = ((bod)localObject1).kJY;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.a.W(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      ad.i("HABBYGE-MALI.AsyncBizCollector", "_collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cpY();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aeY(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ("-1".equals(paramAnonymousa))
                                        {
                                          ad.e("HABBYGE-MALI.AsyncBizDao", " AsyncBizDao putBiz NOT LOGIN");
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if (paramAnonymousa.split("@").length <= 1)
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aeY(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty())) {
                                          paramAnonymousa = null;
                                        }
                                        while (paramAnonymousa == null)
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aeY(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                          paramAnonymousa = paramAnonymousa.split("@");
                                          if (paramAnonymousa.length <= 0) {
                                            paramAnonymousa = null;
                                          } else if (paramAnonymousa.length == 1) {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.N(paramAnonymousa[0], null);
                                          } else {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.N(paramAnonymousa[0], paramAnonymousa[1]);
                                          }
                                        }
                                        if ((TextUtils.isEmpty((CharSequence)paramAnonymousa.get(1))) && (!TextUtils.isEmpty((CharSequence)paramAnonymousa.get(0))))
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aeY((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aeY((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        catch (JSONException paramAnonymousa)
                                        {
                                          ad.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", paramAnonymousa, "AsyncBizDao.putBiz crash: %s", new Object[] { paramAnonymousa.getMessage() });
                                        }
                                      }
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().cpH();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fV(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.d.cpL();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fU(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  ad.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.ve(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).qYO;
                                  ad.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
                                  if ((paramAnonymousa != null) && (!TextUtils.isEmpty(paramAnonymousa.sessionId))) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(paramAnonymousa, l);
                                  }
                                  ad.i("HABBYGE-MALI.VoipFloatSession", "_beignVoipSession");
                                  bool = false;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
                                  if (paramAnonymousa == null)
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, "LauncherUI", "VideoActivity", 0, l);
                                    if (paramAnonymousa == null)
                                    {
                                      ad.e("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, 不是合法session ~~~");
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    bool = true;
                                    ad.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    if ((((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).qZv == null) || (!((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).qZv.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))) {
                                      break label5182;
                                    }
                                  }
                                  label5182:
                                  for (i = ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).qZw;; i = 0)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "VideoActivity", i, l);
                                    if (!bool) {
                                      break label5187;
                                    }
                                    paramAnonymousa.hQn = 0;
                                    localObject2 = m.cpH();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.ssn = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    ad.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                    break;
                                  }
                                  label5187:
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  ad.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.ve(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqE();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.GqU = -1;
                                    paramAnonymousa.GqV = -1;
                                    paramAnonymousa.GqX = 7;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                  }
                                  ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqC()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.cnE();
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.am((String)paramAnonymousa.first, l);
                                    }
                                  }
                                  for (;;)
                                  {
                                    ad.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5502;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, "LauncherUI", "FloatingBall", 0, l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    ad.e("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    ad.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "FloatBall", 0, l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.hQn = 0;
                                    localObject2 = m.cpH();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.ssn = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5502:
                                    ad.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqD();
                                  if (paramAnonymousa != null)
                                  {
                                    i = ((Integer)paramAnonymousa.second).intValue();
                                    if ((i != 1) && (i != 0)) {
                                      break label5685;
                                    }
                                  }
                                  label5685:
                                  for (bool = true;; bool = false)
                                  {
                                    ad.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatMenuHide, FloatSession, End: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                                    if (bool)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqE();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new asx();
                                    }
                                    paramAnonymousa.GqX = 8;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                    ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqC()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  l = ((Long)paramAnonymousa.qQS).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqD();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.Dp(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fz(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fz(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fz(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.lc(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fz(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.qQS).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.Dp(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK();
                                  localObject1 = paramAnonymousa.qZI;
                                  localObject2 = paramAnonymousa.qUj;
                                  localObject3 = paramAnonymousa.qZK;
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qUj = ((com.tencent.mm.plugin.expt.hellhound.a.a.e)localObject2);
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qSa, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZF);
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZD = ((com.tencent.mm.plugin.expt.hellhound.a.g.a)localObject3);
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qUi, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZG);
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qPk, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZG);
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZE, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZF);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.qUB.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK();
                                  paramAnonymousa.qUB.a(1, null);
                                  paramAnonymousa = paramAnonymousa.qZI;
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.qSa, paramAnonymousa.qZF);
                                  paramAnonymousa.qUj = null;
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qUi, paramAnonymousa.qZG);
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qPk, paramAnonymousa.qZG);
                                  paramAnonymousa.qZD = null;
                                  com.tencent.mm.hellhoundlib.a.aho();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qZE, paramAnonymousa.qZF);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().qUB.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.qZJ = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().qUB.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aQ(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aQ(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aQ(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qQS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aQ(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.vd(((Long)paramAnonymousa.qQS).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.cqA();
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.core.b.c.e.b((dwc)paramAnonymousa.qQS);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.b.a.a((bch)paramAnonymousa.qQS);
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
    };
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.qRu;
    localc.qQW.qQY = locald;
    AppMethodBeat.o(121938);
  }
  
  private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> Y(Activity paramActivity)
  {
    AppMethodBeat.i(121940);
    com.tencent.mm.vending.j.c localc = Z(paramActivity);
    if (!((Boolean)localc.get(1)).booleanValue())
    {
      paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.FALSE);
      AppMethodBeat.o(121940);
      return paramActivity;
    }
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> Z(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.ab(paramActivity);
    if (localObject != null) {
      str = localObject.getClass().getCanonicalName();
    }
    boolean bool = true;
    localObject = str;
    if (str == null)
    {
      localObject = paramActivity.getClass().getCanonicalName();
      bool = false;
    }
    paramActivity = com.tencent.mm.vending.j.a.N(localObject, Boolean.valueOf(bool));
    AppMethodBeat.o(121942);
    return paramActivity;
  }
  
  static dno a(dno paramdno)
  {
    AppMethodBeat.i(184315);
    dno localdno;
    if (paramdno != null)
    {
      localdno = paramdno;
      if (!TextUtils.isEmpty(paramdno.activityName)) {
        break label88;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnS();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localdno = paramdno;
      if (paramdno == null)
      {
        localdno = new dno();
        localdno.timestamp = System.currentTimeMillis();
      }
      localdno.activityName = ((String)localc.get(0));
      localdno.aHQ = ((Integer)localc.get(1)).intValue();
      label88:
      AppMethodBeat.o(184315);
      return localdno;
    }
    catch (Exception paramdno)
    {
      ad.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramdno, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, dno paramdno)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramdno.activityName, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CU(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!paramdno.activityName.equals(localObject))
      {
        ad.w("HABBYGE-MALI.AsyncActivityMonitor", "_onCreateEvent: %s, %s", new Object[] { localObject, paramdno.activityName });
        b(paramInt, null, null, paramdno.activityName, paramdno.aHQ, paramdno.timestamp);
      }
      a(paramdno.activityName, paramdno.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRd);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(210337);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(210337);
  }
  
  static void aT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.CS(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString)))
    {
      ad.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
    String str = null;
    if (localbj != null) {
      str = localbj.Fti.activityName;
    }
    a.adW(paramString);
    a.adU(str);
    ad.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static void b(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(210338);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR().a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramLong);
    AppMethodBeat.o(210338);
  }
  
  static cdy c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    cdy localcdy = new cdy();
    localcdy.Grv = new dno();
    localcdy.Grv.activityName = paramActivity.getClass().getCanonicalName();
    localcdy.Grv.aHQ = paramActivity.hashCode();
    localcdy.Grv.timestamp = paramLong;
    paramActivity = Y(paramActivity);
    localcdy.Grw = ((String)paramActivity.get(0));
    localcdy.Grz = ((Boolean)paramActivity.get(1)).booleanValue();
    localcdy.GIC = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localcdy;
  }
  
  static cdx g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    cdx localcdx = new cdx();
    if (paramIntent != null) {
      localcdx.flags = paramIntent.getFlags();
    }
    localcdx.Grv = new dno();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localcdx;
    }
    localcdx.Grv.activityName = paramActivity.getClass().getCanonicalName();
    localcdx.Grv.aHQ = paramActivity.hashCode();
    localcdx.Grv.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localcdx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */